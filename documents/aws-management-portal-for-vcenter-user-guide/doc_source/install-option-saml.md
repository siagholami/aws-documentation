# Option 2: SAML\-Based Authentication<a name="install-option-saml"></a>

You can set up the management portal to authenticate users using your identity provider \(IdP\)\.

Your users don't have direct access to AWS resources\. Instead, the vSphere client gets the user's information from your identity store and uses a SAML assertion to grant the user access to AWS Management Portal for vCenter\. The following diagram illustrates this process\.

![\[The SAML authentication process\]](http://docs.aws.amazon.com/amp/latest/userguide/images/saml_architecture.png)

**SAML\-based authentication**

1. The user signs in to vCenter, clicks **Home**, and then clicks **AWS Management Portal**\. The vSphere client sends an authentication request to the IdP\.

1. The IdP authenticates the user\.

1. The IdP generates a SAML authentication response that includes assertions that identify the user and provide information about the user\.

1. The vSphere client posts the SAML assertion to an AWS single sign\-on \(SSO\) endpoint\. The endpoint requests temporary security credentials from AWS Security Token Service \(AWS STS\) and creates a console sign\-in URL\.

1. AWS sends the console a sign\-in URL to the vSphere client with a redirect\.

1. The management portal grants users access to AWS resources based on the permissions assigned to them by an administrator\.

**Prerequisites**

Before you get started setting up the management portal, set up and configure an IdP for use with AWS SAML federation\. Your IdP must support SAML 2\.0, and you must enable the `RelayState` parameter\.

If you are using Windows Active Directory \(AD\) for your directory service, you can use Active Directory Federation Services \(ADFS\) as your IdP\. For more information, see [Setting Up ADFS for AWS Management Portal for vCenter](setting-up-adfs-for-amp.md)\. For information about other identity providers, see [Integrating SAML Solution Providers with AWS](http://docs.aws.amazon.com/IAM/latest/UserGuide/IdP-solution-providers.html) in *IAM User Guide*\.

**Tasks**

To set up the management portal, complete the following tasks:

1. [Create the required accounts and users](#connector-accounts)

1. [Set up the trust relationship](#set-up-trust)

1. [Deploy the connector virtual appliance](#deploy-connector-appliance)

1. [Configure the connector](#configure-connector)

## Creating the Required Accounts and Users<a name="connector-accounts"></a>

First, create the accounts and users that are required by the management portal\.

**To create the required accounts and users**

1. If your organization doesn't have an AWS account already, use the following steps to create one:

   1. Open [https://aws\.amazon\.com/](https://aws.amazon.com/), and then choose **Create an AWS Account**\.
**Note**  
This might be unavailable in your browser if you previously signed into the AWS Management Console\. In that case, choose **Sign in to a different account**, and then choose **Create a new AWS account**\.

   1. Follow the online instructions\.

      Part of the sign\-up procedure involves receiving a phone call and entering a PIN using the phone keypad\.

   You can complete the setup process using the credentials of either your AWS account or an IAM user\. For more information about AWS Identity and Access Management \(IAM\), see *[IAM User Guide](http://docs.aws.amazon.com/IAM/latest/UserGuide/)*\. To allow an IAM user to set up the management portal, you must grant that user permission to use the actions specified in the following policy:

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                   "iam:*",
                   "amp:*"
               ],
               "Resource": "*"
           },
           {
               "Effect": "Allow",
               "Action": [
                   "s3:CreateBucket",
                   "s3:PutBucketAcl",
                   "s3:GetBucketLocation",
                   "s3:GetBucketAcl"
               ],
               "Resource": "arn:aws:s3:::export-to-s3-*"
           },
           {
               "Effect": "Allow",
               "Action": [
                   "s3:ListAllMyBuckets"
               ],
               "Resource": [
                   "arn:aws:s3:::*"
               ]
           }
       ]
   }
   ```

1. <a name="create-aws-service-account"></a>Create the *AWS service account*, which is an IAM user that the connector uses to migrate VMs from vCenter to AWS\.

   1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

   1. In the navigation pane, click **Users**\.

   1. Click **Add user**\.

   1. On the **Add user** page, type a user name, select **Programmatic access**, and then click **Next: Permissions**\.

   1. Select **Attach existing policies directly**\.

   1. In the search field, type **AWSConnector**\. Select the check box next for the **AWSConnector** policy and then click **Next: Review**\.

   1. Click **Create user**\.

   1. Save the credentials for this account in a safe location and then click **Close**\.
**Important**  
You'll need these credentials to complete the connector setup process\.

1. Create the *vCenter service account*, which is a local or domain user that the connector uses to communicate with vCenter\. Specify a unique, random password for the account\. Do not manually assign vCenter privileges to this user at this point; we assign the vApp Export privilege to this user during the connector setup process\. Note that you can restrict this privilege to specific parts of your vCenter inventory after you complete the connector setup process\.
**Important**  
Save the credentials for this account in a safe location\. You'll need them to complete the connector setup process\.

   You can create this user using your IdP, vCenter, or Windows; whichever is easiest for you\. For more information about creating local or domain users, see the following documentation, or contact an administrator for your vCenter or your IdP:
   + Active Directory: [Create a New User Account](http://technet.microsoft.com/en-us/library/cc732336.aspx)
   + Windows: [Create a local user account](http://technet.microsoft.com/en-us/library/cc770642.aspx)
   + vCenter 5\.5: [Add vCenter Single Sign\-On Users](https://pubs.vmware.com/vsphere-55/index.jsp?topic=%2Fcom.vmware.vsphere.security.doc%2FGUID-72BFF98C-C530-4C50-BF31-B5779D2A4BBB.html) \(the default domain is `vsphere.local`\)
   + vCenter 5\.1: [Add a vCenter Single Sign On User](http://pubs.vmware.com/vsphere-51/index.jsp?topic=%2Fcom.vmware.vsphere.security.doc%2FGUID-72BFF98C-C530-4C50-BF31-B5779D2A4BBB.html) \(the default domain is `System-Domain`\)
   + vCenter Server Appliance: [Creating and managing local user accounts](http://virtual-drive.in/2011/12/18/creating-local-user-accounts-on-vcenter-server-appliance/)

## Setting Up the Trust Relationship<a name="set-up-trust"></a>

Complete the following procedure to set up a trust relationship between the management portal and your IdP\.

**To set up the trust relationship**

1. Open the AWS Management Portal for vCenter [setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.
**Tip**  
If you've already completed the setup process but would like to change authentication providers, go to the summary page, expand **Reset Trust Relationship**, click **I acknowledge that I want to reset my trust relationships configuration**, and then click **Reset Trust Relationship**\.

1. Click **Get started now**\.

1. On the **AWS Management Portal for vCenter Configuration** page, select **SAML\-based authentication provider**\.

1. <a name="configure-trust-saml"></a>On the **Configure the Trust Relationship** page, do one of the following:
   + **Option 1: Set up trust**

     1. In **SAML provider**, select **CREATE NEW** to create a SAML provider\. Enter a name for the provider, select the SAML metadata document for your IdP, and then click **Save**\.

        If your IdP is ADFS, you can download the SAML metadata document using the following URL, where *my\-adfs\-server* is the host name of your ADFS server:

        ```
        https://my-adfs-server/FederationMetadata/2007-06/FederationMetadata.xml
        ```

     1. In **Identity Provider URN**, enter the unique identifier for your IdP\. This is the value of the `entityID` attribute in the SAML metadata document for your IdP\.

     1. In **SAML role**, select **CREATE NEW**\. This role has no AWS privileges\. The management portal trusts users who can assume this role using an assertion from your IdP\.

     1. In **AMP service role**, select **CREATE NEW**\. The management portal assumes this role to manage your AWS resources\.

     1. In **Import service role**, select **CREATE NEW**\. The VM Import/Export service assumes this role to manage your conversion tasks when you migrate a VM using connector\.

     1. Click **I agree that AWS Management Portal for vCenter may create the above roles on my behalf**\.

     1. Click **Save and Continue**\.
   + **Option 2: Change authentication providers**

     If you previously selected **AWS Connector** as the authentication provider, click **Reset Trust Relationship**\. After the reset, you can start the setup process again, select **SAML\-based authentication provider**, and then set up trust\.

1. <a name="configure-sso"></a>On the **Configure Single Sign\-On URL** page, enter the single sign\-on \(SSO\) URL, and then click **Save and Continue**\.

   This URL must use the following parameters: relying party identifier \(`urn:amazon:webservices`\) and SAML `RelayState` \(`https://amp.aws.amazon.com/auth`\)\.

   If your IdP is ADFS, the SSO URL is the IdP URL followed by:

   ```
   ?RelayState=RPID%3Durn%253Aamazon%253Awebservices%26RelayState%3Dhttps%253A%252F%252Famp.aws.amazon.com%252Fauth
   ```

   For example, suppose that the IdP URL is: `https://adfs.mydomain.com/adfs/ls/IdpInitiatedSignOn.aspx`\. The corresponding SSO URL is:

   ```
   https://adfs.mydomain.com/adfs/ls/IdpInitiatedSignOn.aspx?RelayState=RPID%3Durn%253Aamazon%253Awebservices%26RelayState%3Dhttps%253A%252F%252Famp.aws.amazon.com%252Fauth
   ```

   You can create the SSO URL manually or use a generator tool\. For example, if your IdP is ADFS, see [ADFS 2\.0 RelayState Generator](http://social.technet.microsoft.com/wiki/contents/articles/13172.ad-fs-2-0-relaystate-generator.aspx)\.

1. <a name="add-admins-saml"></a>On the **Add Administrators** page, add one to five users from your organization as administrators of the management portal, and then click **Save and Continue**\. Note that you can specify both local and domain users\.
**Important**  
Domain and user names are case\-sensitive\.

   Use the form *domain*\\*user*, where *domain\\* is optional for local users\. For domain users, *domain*\\*user* must not exceed 32 characters\. For local users, *user* must not exceed 32 characters\. The *domain* and *user* names must each begin with a letter and contain only the following characters: a\-z, A\-Z, 0\-9, periods \(\.\), underscores \(\_\), and dashes \(\-\)\.

   Note that you must add at least one administrator now, but you can add additional users as administrators later on\. For more information, see [Managing Administrators](administer-resources.md#manage-admins)\.

1. <a name="create-key-saml"></a>On the **Create an AMP Connector Key** page, enter the name for the AMP connector key, and then click **Create**\.

1. On the **Review Your Configuration** page, click **Download Configuration**, which downloads a file that contains your trust relationship configuration\. Save this file to a safe location\. You'll need it to complete the connector deployment process\. Click **Finish**\.

   Note that you can create a new AMP trust role or AMP connector key if you believe they were compromised\. 

1. Within your IdP, configure AWS as a trusted relying party\. If your IdP is ADFS, see [Configuring SSO to ADFS and AWS Management Portal for vCenter](configure-trust-with-aws.md) for more information\.

1. Test your SSO URL using your browser\. At this point, you should see a page that says the following:

   ```
   AWS Management Portal for vCenter
   Your AWS Management Portal setup is incomplete
   ```

   If you see the AWS Management Console instead, then your IdP is not configured to support the `RelayState` parameter\. For more information, see [Enabling RelayState](setting-up-adfs-for-amp.md#enable-relaystate)\.

## Deploying the Connector Virtual Appliance<a name="deploy-connector-appliance"></a>

The management portal requires that you deploy and configure the connector, which manages the administrators and permissions\.

The connector is packaged as a virtual appliance\. To deploy the connector, complete the following procedure\.

**To deploy the Connector virtual appliance**

1. Sign in to vCenter as a VMware administrator\.

1. From the **File** menu, click **Deploy OVF Template**\. Enter the following URL into the **Deploy from a file or URL** field and then click **Next**:

   ```
   https://s3.amazonaws.com/aws-connector/AWS-Connector.ova
   ```

   \(Optional\) To verify the download, use the following MD5 and SHA256 checksums:

   ```
   https://s3.amazonaws.com/aws-connector/AWS-Connector.ova.md5sum
   https://s3.amazonaws.com/aws-connector/AWS-Connector.ova.sha256sum
   ```

1. Complete the wizard\. On the **Disk Format** page, select one of the thick provision disk types\. We recommend that you select **Thick Provision Eager Zeroed**, as it has the best performance and reliability; however, it requires several hours to zero the disk\. Do not select **Thin Provision**; this option makes deployment faster but significantly reduces disk performance\. For more information, see [Types of supported virtual disks](http://kb.vmware.com/selfservice/microsites/search.do?language=en_US&cmd=displayKC&externalId=1022242) in the VMware documentation\.

1. Locate the newly deployed template in the vSphere client inventory tree, right\-click it, and select **Power > Power On**\. Right\-click the template again and select **Open Console**\. The console displays the IP address of the connector management console\. Save the IP address in a secure location; you'll need it to complete the connector setup process\.
**Note**  
If you don't have a DHCP server, you must configure a static IP address\. For more information, see [\(Optional\) Configuring Network Settings](setting-up.md#network-settings)\.

## Configuring the Connector<a name="configure-connector"></a>

To complete the setup process, open a web browser and complete the following procedure\.

**Important**  
The directions in this procedure are written for version 2\.1\.0 and later of the connector\. If the version information in the upper\-right corner of the screen is **Version: 2\.0\.0**, download the PDF file [Configuring the Connector](http://awsdocs.s3.amazonaws.com/AMP/2.0/configuring-connector-2-0.pdf) for directions written for version 2\.0\.0 of the connector\.

**To configure the connector using the connector management console**

1. From your web browser, go to https://*ip\_address*/, where *ip\_address* is the IP address of the connector management console that you saved earlier\.
**Tip**  
If your browser can't verify the certificate for the site, it notifies you that the site is untrusted\. You can verify the certificate \(see [Validating an Untrusted SSL Certificate](manage-connector.md#ssl-certificate)\) or replace it with one of your own certificates \(see [Installing a Trusted SSL Certificate](manage-connector.md#upload-certificate)\)\.

1. In the **Log in to Connector** dialog box, enter the IP address or hostname of the vCenter Server and the credentials for a vCenter administrator, and then click **Log in**\. The vCenter hostname can't be longer than 32 characters\. Therefore, specify a shorter hostname or the IP address\.

   When prompted, create a password\. You'll use this password the next time that you log in to the connector management console\.
**Note**  
If you enter an incorrect password 20 times, you are locked out and must reset your password\. For more information, see [Resetting the Connector Password](manage-connector.md#reset-connector-pwd)\.

1. If this is the first time that you've logged in to the connector, the registration wizard starts automatically\. Otherwise, click **Register the Connector**\.

1. On the **Upload Key Pair** page, copy the key that you created when setting up the trust relationship, and then click **Next**\.

1. On the **vCenter Admin Credentials** page, enter the credentials of a vCenter account that has permissions to register a new vCenter extension, and then click **Next**\. Note that we discard these credentials after you complete the connector setup process\.

1. On the **vCenter Service Account Credentials** page, enter the credentials of the vCenter service account that you created in [Creating the Required Accounts and Users](#connector-accounts), and then click **Next**\. For domain users, use the form *domain*\\*username* or *username*@*domain*\.

   Note that we store these credentials in encrypted form, and you do not need to store them after you complete the setup process\.

1. On the **AWS Credentials** page, enter the credentials of the AWS service account that you created in [Creating the Required Accounts and Users](#connector-accounts), and then click **Next**\. Note that we store these credentials in encrypted form\.
**Note**  
If you receive an error that the AWSConnector policy for your IAM user is out of date, you must update the policy\. For more information, see [Updating the AWSConnector Policy](manage-connector.md#updating-the-AWSConnector-policy)\.

1. On the **Register Plugin** page, click **Register**\.

1. Exit the vSphere client and reopen it\. Click **Home** and then click **AWS Management Portal**\.

   If you are prompted to select an IAM role, select the role with `AWS-Management-Portal-for-vCenter` in its name\.
**Important**  
If you see the AWS console instead of the management portal, it is probably because the `RelayState` parameter is not enabled\. For more information, see [Enabling RelayState](setting-up-adfs-for-amp.md#enable-relaystate)\.

You've completed the setup process and are ready to start using the management portal\. However, you might want to complete the following steps before you begin: [Configure Time Synchronization](setting-up.md#time-synchronization) and [Configure Network Settings](setting-up.md#network-settings)\.