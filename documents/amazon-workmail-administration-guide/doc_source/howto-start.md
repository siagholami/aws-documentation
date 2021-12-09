# Getting started with Amazon WorkMail<a name="howto-start"></a>

Whether you are a new Amazon WorkMail user or an existing user of Amazon WorkDocs or Amazon WorkSpaces, get started with Amazon WorkMail by completing the following steps\.

**Note**  
Complete the [Prerequisites](prereqs.md) before getting started\.

**Topics**
+ [Step 1: Sign in to the Amazon WorkMail console](#workmail_signin)
+ [Step 2: Set up your Amazon WorkMail site](#setup-site)
+ [Step 3: Set up Amazon WorkMail user access](#setup-user)
+ [More resources](#more-getting-started)

## Step 1: Sign in to the Amazon WorkMail console<a name="workmail_signin"></a>

You must sign in to the Amazon WorkMail console before you can add users and manage accounts and mailboxes\.

**To sign in to the Amazon WorkMail console**

1. Sign in to the AWS Management Console and open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. If necessary, go to the navigation bar and select the AWS Region that meets your needs\. For more information, see [Regions and endpoints](http://docs.aws.amazon.com/general/latest/gr/index.html?rande.html) in the *Amazon Web Services General Reference*\.

## Step 2: Set up your Amazon WorkMail site<a name="setup-site"></a>

1. After you sign in to the Amazon WorkMail console, set up your organization\. Choose from the following organization setup options:
   + [Quick setup: Creating a new directory](add_new_organization.md#quick_setup) \- Sets up a new directory for you
   + [Standard setup: Integrating with an existing directory](add_new_organization.md#premises_directory) \- Integrates with your existing directory

1. Next, add a domain\. We recommend registering a dedicated domain for your Amazon WorkMail organization\. For more information about adding a domain, see [Adding a domain](add_domain.md)\.
**Note**  
You can start using your Amazon WorkMail organization with the provided test domain created during setup\. The test domain format is *example*\.awsapps\.com\. You can use the test mail domain as long as you maintain enabled users in your Amazon WorkMail organization\. However, the test domain cannot be used outside of Amazon WorkMail\. Also, the test domain might become available for registration and use by other customers if your Amazon WorkMail organization does not maintain at least one enabled user\. 

1. Create new users or enable your existing directory users for Amazon WorkMail\. For more information, see [Creating users](manage-users.md#add_new_user)\.

1. \(Optional\) If you have existing Microsoft Exchange mailboxes, migrate them to Amazon WorkMail\. For more information, see [Migrating to Amazon WorkMail](migration_overview.md)\.

After you've finished setting up your Amazon WorkMail site, you can access Amazon WorkMail using the web application URL\.

**To locate your Amazon WorkMail web application URL**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation panel, choose **Organization settings**\.

The web application URL is on the **General settings** tab and looks like this: https://*alias*\.awsapps\.com/mail\.

## Step 3: Set up Amazon WorkMail user access<a name="setup-user"></a>

Choose from the following options to set up Amazon WorkMail user access\.
+ Set up user access from an existing desktop client using the Microsoft Outlook client\. For more information, see [Connect Microsoft Outlook to your Amazon WorkMail account](https://docs.aws.amazon.com/workmail/latest/userguide/connect_mail_client.html)\.
+ Set up user access from a mobile device, such as a Kindle, Android, iPad, iPhone, or Windows Phone\. For more information, see [Getting started with a mobile device](https://docs.aws.amazon.com/workmail/latest/userguide/mobile-start.html)\.
+ Set up user access with any IMAP\-compatible client software\. For more information, see [Connect IMAP clients to Your Amazon WorkMail account](https://docs.aws.amazon.com/workmail/latest/userguide/using_IMAP_client.html)\.

## More resources<a name="more-getting-started"></a>
+ [Migrating to Amazon WorkMail](migration_overview.md)
+ [Interoperability between Amazon WorkMail and Microsoft Exchange](interoperability.md)
+ [Amazon WorkMail quotas](workmail_limits.md)