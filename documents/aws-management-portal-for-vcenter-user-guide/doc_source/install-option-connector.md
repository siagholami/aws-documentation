# Option 1: Federation Authentication Proxy<a name="install-option-connector"></a>

You can set up the management portal to authenticate users using the AWS Connector for vCenter\.

Your users don't have direct access to AWS resources\. Instead, the vSphere client gets the user's information from your vCenter server and assumes an AWS Identity and Access Management \(IAM\) role to get temporary AWS security credentials for the user\. The following diagram illustrates this process\.

![\[The authentication process using the connector\]](http://docs.aws.amazon.com/amp/latest/userguide/images/connector_architecture.png)

**Federation authentication proxy**

1. The user signs in to vCenter, clicks **Home**, and then clicks **AWS Management Portal**\. The vSphere client sends an authentication request to the connector\.

1. The connector authenticates the user\.

1. The connector requests temporary security credentials from AWS Security Token Service \(AWS STS\)\.

1. AWS STS sends the connector temporary security credentials for the user\.

1. Users are granted access to AWS resources based on the permissions assigned to them by an administrator\.

**Tasks**

To set up the management portal, complete the following tasks:

1. [Create the required accounts and users](#connector-accounts-fp)

1. [Set up the trust relationship](#set-up-trust-fp)

1. [Deploy the connector virtual appliance](#deploy-connector-appliance-fp)

1. [Configure the connector](#configure-connector-fp)

## Creating the Required Accounts and Users<a name="connector-accounts-fp"></a>

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

1. <a name="create-aws-authenticator-provider-account"></a>Create the *AWS authenticator provider account*, which is an IAM user that the connector uses to assume a trust role and authenticate users\.

   1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

   1. In the navigation pane, click **Users**\.

   1. Click **Add user**\.

   1. On the **Add user** page, type a user name, select **Programmatic access**, and then click **Next: Permissions**\.

   1. Select **Attach existing policies directly**\.

   1. In the search field, type **AWSConnector**\. Select the checkbox for the **AWSConnector** policy and then click **Next: Review**\.

   1. Click **Create user**\.

   1. Save the credentials for this account in a safe location and then click **Close**\.
**Important**  
You'll need these credentials to complete the connector setup process\.

1. Create the *vCenter service account*, which is a local or domain user that the connector uses to communicate with vCenter\. Specify a unique, random password for the account\. Do not manually assign vCenter privileges to this user at this point\. We assign the vApp Export privilege to this user during the connector setup process\. Note that you can restrict this privilege to specific parts of your vCenter inventory after you complete the connector setup process\.
**Important**  
Save the credentials for this account in a safe location\. You'll need them to complete the connector setup process\.

   You can create this user using your IdP, vCenter, or Windows; whichever is easiest for you\. For more information about creating local or domain users, see the following documentation, or contact an administrator for your vCenter or your IdP:
   + Active Directory: [Create a New User Account](http://technet.microsoft.com/en-us/library/cc732336.aspx)
   + Windows: [Create a local user account](http://technet.microsoft.com/en-us/library/cc770642.aspx)
   + vCenter 5\.5: [Add vCenter Single Sign\-On Users](https://pubs.vmware.com/vsphere-55/index.jsp?topic=%2Fcom.vmware.vsphere.security.doc%2FGUID-72BFF98C-C530-4C50-BF31-B5779D2A4BBB.html) \(the default domain is `vsphere.local`\)
   + vCenter 5\.1: [Add a vCenter Single Sign On User](http://pubs.vmware.com/vsphere-51/index.jsp#com.vmware.vsphere.security.doc/GUID-72BFF98C-C530-4C50-BF31-B5779D2A4BBB.html) \(the default domain is `System-Domain`\)
   + vCenter Server Appliance: [Creating and managing local user accounts](http://virtual-drive.in/2011/12/18/creating-local-user-accounts-on-vcenter-server-appliance/)

## Setting Up the Trust Relationship<a name="set-up-trust-fp"></a>

Complete the following procedure to set up a trust relationship between the management portal and the connector\.

**To set up the trust relationship**

1. Open the AWS Management Portal for vCenter [setup console](https://amp.aws.amazon.com/VCPlugin.html#setup)\.
**Tip**  
If you've already completed the setup process but would like to change authentication providers, go to the summary page, expand **Reset Trust Relationship**, click **I acknowledge that I want to reset my trust relationships configuration**, and then click **Reset Trust Relationship**\.

1. Click **Get started now**\.

1. On the **AWS Management Portal for vCenter Configuration** page, select **AWS Connector** as the authentication provider\.

1. <a name="configure-trust-fp"></a>On the **Configure the Trust Relationship** page, do one of the following:

   **Option 1: Set up trust**

   1. Specify the name of the IAM user that you created as the AWS authenticator provider account\.

   1. \(Optional\) Review the policies for the AMP trust role, AMP service role, and import service role\.

   1. Select **I agree that AWS Management Portal for vCenter may create the above roles on my behalf**\.

   1. Click **Save and Continue**\.

   **Option 2: Change authentication providers**

   If you previously selected **SAML\-based authentication provider** as the authentication provider, click **Reset Trust Relationship**\. After the reset, you can start the setup process again, select **AWS Connector**, and then set up trust\.

1. <a name="add-admins-fp"></a>On the **Add Administrators** page, add one to five users from your organization as administrators of the management portal, and then click **Save and Continue**\. Note that you can specify both local and domain users\.
**Important**  
Domain and user names are case\-sensitive\.

   Use the form *domain*\\*user*, where *domain\\* is optional for local users\. For domain users, *domain*\\*user* must not exceed 32 characters\. For local users, *user* must not exceed 32 characters\. The *domain* and *user* names must each begin with a letter and contain only the following characters: a\-z, A\-Z, 0\-9, periods \(\.\), underscores \(\_\), and dashes \(\-\)\.

   Note that you must add at least one administrator now, but you can add additional users as administrators later on\. For more information, see [Managing Administrators](administer-resources.md#manage-admins)\.

1. <a name="create-key-fp"></a>On the **Create an AMP Connector Key** page, enter the name for the AMP connector key, and then click **Create**\.

1. On the **Review Your Configuration** page, click **Download Configuration**, which downloads a file that contains your trust relationship configuration\. Save this file to a safe location; you'll need it to complete the connector deployment process\. Click **Finish**\.

   Note that you can create a new AMP trust role or AMP connector key if you believe they were compromised\. 

1. On the **AWS Management Portal Setup** page, you can review and edit your current setup configuration\.

## Deploying the Connector Virtual Appliance<a name="deploy-connector-appliance-fp"></a>

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

## Configuring the Connector<a name="configure-connector-fp"></a>

To complete the setup process, open a web browser and complete the following procedure\.

**To configure the connector using the connector management console**

1. From your web browser, go to https://*ip\_address*/, where *ip\_address* is the IP address of the connector management console that you saved earlier\.
**Tip**  
If your browser can't verify the certificate for the site, it notifies you that the site is untrusted\. You can verify the certificate \(see [Validating an Untrusted SSL Certificate](manage-connector.md#ssl-certificate)\) or replace it with one of your own certificates \(see [Installing a Trusted SSL Certificate](manage-connector.md#upload-certificate)\)\.

1. In the **Log in to Connector** dialog box, enter the IP address or hostname of the vCenter Server and the credentials for a vCenter administrator, and then click **Log in**\. The vCenter hostname can't be longer than 32 characters\. Therefore, specify a shorter hostname or the IP address\.

   When prompted, create a password\. You'll use this password the next time that you log in to the connector management console\.
**Note**  
If you enter an incorrect password 20 times, you are locked out and must reset your password\. For more information, see [Resetting the Connector Password](manage-connector.md#reset-connector-pwd)\.

1. If this is the first time that you've logged in to the connector, the registration wizard starts automatically\. Otherwise, click **Register the Connector**\.

1. If you downloaded the configuration file, do the following:

   1. Click **Upload the configuration file**, select the configuration file, and then click **Next**\.

   1. On the **vCenter Service Account Credentials** page, enter the credentials of the vCenter service account that you created in [Creating the Required Accounts and Users](#connector-accounts-fp), and then click **Next**\. For domain users, use the form *domain*\\*username* or *username*@*domain*\.

   1. On the **AWS Credentials** page, enter the credentials of the AWS service account that you selected in [Setting Up the Trust Relationship](#set-up-trust-fp)\. \(You can use the same IAM user for VM Import, or use a different IAM user that also has the AWSConnector policy attached\.\) Click **Next**\.
**Note**  
If you receive an error that the AWSConnector policy for your IAM user is out of date, you must update the policy\. For more information, see [Updating the AWSConnector Policy](manage-connector.md#updating-the-AWSConnector-policy)\.

   1. On the **Register Plugin** page, click **I agree to install the vCenter SSL certificates on this connector**\. You will receive automatic upgrades for the connector unless you clear this option\. Click **Register** to install the vCenter Server certificate\. The authentication provider in the connector responds to vCenter Server only if it presents this certificate\.

   Otherwise, complete the setup as follows:

   1. Click **Enter the configuration manually**, select the same configuration type that you selected earlier, and then click **Next**\.

   1. Enter the AMP connector key that you saved earlier, and then click **Next**\.

   1. On the **vCenter Admin Credentials** page, enter the IP address or hostname of the vCenter server and the name and password of a vCenter admin\. The vCenter hostname can't be longer than 32 characters\. Therefore, specify a shorter hostname or the IP address\. Click **Next**\.

      Note that this page doesn't appear the first time you configure the connector\.

   1. On the **vCenter Service Account Credentials** page, enter the credentials of the vCenter service account that you created in [Creating the Required Accounts and Users](#connector-accounts-fp), and then click **Next**\. For domain users, use the form *domain*\\*username* or *username*@*domain*\.

   1. On the **AWS Credentials** page, enter the ARN of the AMP trust role and credentials of the AWS service account that you selected in [Setting Up the Trust Relationship](#set-up-trust-fp)\. \(You can use the same IAM user for VM Import, or use a different IAM user that also has the AWSConnector policy attached\.\) Click **Next**\.
**Note**  
If you receive an error that the AWSConnector policy for your IAM user is out of date, you must update the policy\. For more information, see [Updating the AWSConnector Policy](manage-connector.md#updating-the-AWSConnector-policy)\.

   1. On the **Register Plugin** page, click **Register** to install the vCenter Server certificate\. The authentication provider in the connector responds to vCenter Server only if it presents this certificate\.

1. Exit the vSphere client and reopen it\. Click **Home** and then click **AWS Management Portal**\.

You've complete the setup process and are ready to start using the management portal\. However, you might want to complete the following steps before you begin: [Configure Time Synchronization](setting-up.md#time-synchronization) and [Configure Network Settings](setting-up.md#network-settings)\.