# Connecting to Okta SSO<a name="okta_sso"></a>

If you have an Enterprise account, you can connect to Okta SSO to authenticate and assign user permissions\.

**Note**  
If you need to create an Enterprise account, which allows you to manage all users within a given set of email address domains, see [Claiming a domain](claim-domain.md)\.

Connecting Amazon Chime to Okta requires configuring two applications in the Okta Administration Console\. The first application is manually configured, and uses OpenID Connect to authenticate users to the Amazon Chime service\. The second application is available as **Amazon Chime SCIM Provisioning** in the Okta Integration Network \(OIN\)\. It is configured to push updates to Amazon Chime about changes to users and groups\.

**To connect to Okta SSO**

1. Create the Amazon Chime application \(OpenID Connect\) in the **Okta Administration Console**:

   1. Sign in to the **Okta Administration Dashboard**, then choose **Add Application**\. In the **Create New Application** dialog box, choose **Web**, **Next**\. 

   1. Configure the **Application Settings**:

      1. Name the application **Amazon Chime**\.

      1. For **Login Redirect URI**, enter the following value: **https://signin\.id\.ue1\.app\.chime\.aws/auth/okta/callback**

      1. In the **Allowed Grant Types** section, select all of the options to enable them\.

      1. On the **Login initiated by** drop\-down menu, choose **Either \(Okta or App\)**, and select all the related options\.

      1. For the **Initiate Login URI**, enter the following value: **https://signin\.id\.ue1\.app\.chime\.aws/auth/okta**

      1. Choose **Save**\.

      1. Keep this page open, because you'll need the **Client ID**, **Client secret**, and **Issuer URI** information for Step 2\. 

1. In the Amazon Chime console, follow these steps:

   1. On the **Okta single\-sign on configuration** page, at the top of the page, choose **Set up incoming keys**\.

   1. In the **Setup incoming Okta keys** dialog box:

      1. Paste the **Client ID** and **Client secret** information from the **Okta Application Settings** page\.

      1. Paste the appropriate **Issuer URI** from the **Okta API** page\. The **Issuer URI** must be an Okta domain, such as `https://example.okta.com`\.

1. Set up the **Amazon Chime SCIM Provisioning** application in the **Okta Administration Console** to exchange select identity and group membership information with Amazon Chime:

   1. In the **Okta Administration Console**, choose **Applications**, **Add Application**, search for **Amazon Chime SCIM Provisioning**, and add the application\.
**Important**  
During the initial setup, choose both **Do not display application to users** and **Do not display application icon in the Okta Mobile App**, then choose **Done**\.

   1. On the **Provisioning** tab, choose **Configure API Integration**, and select **Enable API Integration**\. Keep this page open, because you'll need to copy an API access key to it for the following step\.

   1. In the Amazon Chime console, choose **Create access key** to create an API access key\. Copy it to the **Okta API Token** field in the **Configure API Integration** dialog box, choose **Test the Integration**, then choose **Save**\.

   1. Configure the actions and attributes that Okta will use to update Amazon Chime\. On the **Provisioning** tab, under the **To App** section, choose **Edit**, choose from **Enable Users**, **Update User Attributes**, and **Deactivate Users**, and choose **Save**\.

   1. On the **Assignments** tab, grant users permissions to the new SCIM app\.
**Important**  
We recommend granting permissions through a group that contains all the users who should have access to Amazon Chime, regardless of license\. The group must be the same as the group used to assign the user\-facing OIDC application in step 1 previously\. Otherwise, end users will not be able to sign in\.

   1. On the **Push Groups** tab, configure which groups and memberships are synced to Amazon Chime\. These groups are used to differentiate between Basic and Pro users\.

1. Configure directory groups in Amazon Chime:

   1. In the Amazon Chime console, navigate to the **Okta single\-sign on configuration** page\.

   1. Under **Directory groups**, choose **Add new groups**\. 

   1. Type the name of a directory group to add to Amazon Chime\. The name must be an exact match of one of the **Push Groups** configured previously in step 3\-f\.

   1. Choose whether users in this group should receive **Basic** or **Pro** capabilities, and choose **Save**\. Repeat this process to configure additional groups\.
**Note**  
If you receive an error message stating that the group is not found, the two systems might not have completed the sync\. Wait for a few minutes, and choose **Add new groups** again\. 

Choosing **Basic** or **Pro** capabilities for the users in your directory group affects the license, capabilities, and cost of those users in your Amazon Chime Enterprise account\. For more information, see [Pricing](https://aws.amazon.com/chime/pricing/)\.