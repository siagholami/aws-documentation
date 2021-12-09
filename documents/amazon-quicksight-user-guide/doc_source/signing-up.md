# Signing Up for Amazon QuickSight<a name="signing-up"></a>

If you are new to AWS, see [Setting Up Amazon QuickSight](setup-new-quicksight-account.md) to create an Amazon QuickSight account\.

If you have an existing AWS account, see [Subscribe to Amazon QuickSight](#how-to-add-quicksight-to-your-aws-account) to create an Amazon QuickSight account\.

If your organization has an existing Amazon QuickSight account and you want to request access to it, follow the procedure in [Request Access to an Existing Amazon QuickSight Account](#request-access)\.

**Note**  
To avoid confusion with *AWS users* and *AWS administrators*, we refer to all Amazon QuickSight users as *Amazon QuickSight users* or *Amazon QuickSight administrators\.*

For information on supported browsers, see [Supported Browsers](supported-browsers.md)\.

**Topics**
+ [Subscribe to Amazon QuickSight](#how-to-add-quicksight-to-your-aws-account)
+ [Request Access to an Existing Amazon QuickSight Account](#request-access)

## Subscribe to Amazon QuickSight<a name="how-to-add-quicksight-to-your-aws-account"></a>

Use this topic to subscribe to Amazon QuickSight using an existing AWS account\. If you don't have an AWS account, see [Setting Up Amazon QuickSight](setup-new-quicksight-account.md) for streamlined sign\-up\.

You can have only one Amazon QuickSight account per AWS account\. The Amazon QuickSight account contains all the users who use Amazon QuickSight\. Users can sign in directly, through an IAM user or role, or through Single Sign\-On\. For details on using IAM, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. For details on using Single Sign\-On, see [Enabling Single Sign\-On Access to Amazon QuickSight Using SAML 2\.0](external-identity-providers.md)\.

Before you begin, you must be able connect to an existing AWS account\. If your company already has an AWS account, contact your AWS account administrator for assistance\. 

**To subscribe to Amazon QuickSight**

1. Sign in to your AWS account and open Amazon QuickSight from the AWS Management Console\. It is located under Analytics, and you can find it by searching for "QuickSight"\.

1. Your AWS account number is displayed for verification purposes\. Choose **Sign up for QuickSight**\.

1. Choose **Standard** or **Enterprise**\. To confirm, choose **Continue**\. A screen titled **Create your QuickSight account** appears\. 

1. If you choose Standard, skip this step and proceed to the next one\.

   If you choose Enterprise, you first choose the method you want to connect with\. Choose one of the following\. 
   + **Use Role Based Federation \(SSO\)**
   + **Use Active Directory**

1. For both Standard and Enterprise editions, make choices for the following items:
   + Type in a unique account name for Amazon QuickSight\. Your account name can only contain characters \(A–Z and a–z\), digits \(0–9\), and hyphens \(\-\)\. If you use AD, and it has a default alias, this alias is used for the account name\.
   + Type in a notification email address for the Amazon QuickSight account owner or group\. This email receives service and usage notifications\.
   + \(Optional\) Choose the AWS region you want to utilize for your default [SPICE](welcome.md#spice) capacity\. This is where your account’s free SPICE capacity is allocated after signing up\. Note that you aren't able to change the default capacity region later, but you can always purchase additional SPICE capacity in different regions as needed\. See [AWS Regions and IP Address Ranges](regions.md) for information on regions\.
   + \(Optional\) Choose whether to allow autodiscovery of your AWS resources\. You can change these options later in **Manage Account**\. For more information, see [Allowing Autodiscovery of AWS Resources](autodiscover-aws-data-sources.md)\.

1. Review the choices you made, then choose **Finish**\. 

1. \(Optional\) To open Amazon QuickSight, choose **Go to Amazon QuickSight**\. 

   If you are using Enterprise edition, you can manage user groups, by choosing **Manage access to QuickSight**\. Otherwise, close the browser and notify your users how to connect\.

For Enterprise edition, there are a few more steps to complete: configuring users and groups to access Amazon QuickSight\.

After you sign up for Amazon QuickSight, users can start to sign in, connect to data, and create analyses\. 

To set up data sources for your users, see [Working with Data Sources in Amazon QuickSight](working-with-data-sources.md)\.

To enable self\-provisioning for Amazon QuickSight by setting an IAM policy on a role with permissions for `CreateUser` or `CreateAdmin`, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\.

To start creating analyses, see [Getting Started with Data Analysis in Amazon QuickSight](getting-started.md)\. 

For more information about managing users in Amazon QuickSight Standard edition, see [Managing User Accounts in Amazon QuickSight Standard Edition](managing-users.md)\. 

For more information about managing users in Amazon QuickSight Enterprise edition, see [Managing User Accounts in Amazon QuickSight Enterprise Edition](managing-users-enterprise.md)\.

**Topics**

## Request Access to an Existing Amazon QuickSight Account<a name="request-access"></a>

If your organization has already signed up for Amazon QuickSight, you can ask your Amazon QuickSight administrator to add you as a user\. 

For Standard edition accounts, your Amazon QuickSight administrator can give you access through your IAM credentials, through Single Sign\-On \(SSO\), or through your email address\. For more information for Standard edition users, see [Getting Access as a New Amazon QuickSight Standard Edition User](#request-access-standard)\.

For more information for Enterprise edition users, see [Getting Access as a New Amazon QuickSight Enterprise Edition User](#request-access-enterprise)\. 

After you sign in for the first time, you can connect to data and creating analyses\. For more information about creating your first analysis, see [Getting Started with Data Analysis in Amazon QuickSight](getting-started.md)\.

**Topics**
+ [Getting Access as a New Amazon QuickSight Standard Edition User](#request-access-standard)
+ [Getting Access as a New Amazon QuickSight Enterprise Edition User](#request-access-enterprise)

### Getting Access as a New Amazon QuickSight Standard Edition User<a name="request-access-standard"></a>

Your Amazon QuickSight administrator uses either your IAM credentials, your Single Sign\-On \(SSO\) service, or your email address to create your Amazon QuickSight user account\. Then Amazon QuickSight sends you an email inviting you to activate it\. The invitation email you receive indicates what type of credentials you should use\.

**Note**  
If your company uses a Single Sign\-On \(SSO\) service with Amazon QuickSight, your administrator must provide instructions on how to sign in\. For more information on how this is set up, see [Enabling Single Sign\-On Access to Amazon QuickSight Using SAML 2\.0](external-identity-providers.md)\. 

#### Signing In as a New User Using Credentials Based on Your Email Address<a name="request-access-qs"></a>

Use the following procedure to sign in as a new user who has an Amazon QuickSight–only account based on an email address\.

**To sign in as a new user who has an account based on an email address**

1. In your invitation email, choose the link in the body of the email to open the Amazon QuickSight sign\-up page\.

1. Complete your user account by typing a password\.

   Passwords are case\-sensitive, must be between 8 and 64 characters in length, and must contain at least one character from three of the following four categories:
   + Lowercase letters \(a–z\)
   + Uppercase letters \(A–Z\)
   + Numbers \(0–9\)
   + Nonalphanumeric characters \(\~\!@\#$%^&\*\_\-\+=`\|\\\(\)\{\}\[\]:;"'<>,\.?/\)

1. Choose **Create account and sign in**\.

1. Choose **Continue**\. Doing this takes you to the Amazon QuickSight start page\.

#### Signing In as a New User Using Your IAM Credentials<a name="request-access-iam"></a>

Use the following procedure to sign in to Amazon QuickSight as a new user who has IAM credentials\.

**To sign in as a new user with IAM credentials**

1. When you receive the invitation email, go to the Amazon QuickSight sign in page, [https://quicksight\.aws\.amazon\.com/](https://quicksight.aws.amazon.com/)\.

1. For **Account name**, type the account name in your invitation email, and then choose **Continue**\.

1. Type your IAM user name in **Email address or username**\.

1. Type your IAM password in **Password**\.

1. Choose **Sign in**\.

#### Self\-Provisioning an Amazon QuickSight user<a name="self-service-access"></a>

Use the following procedure to sign in to Amazon QuickSight as a new user who has access to Amazon QuickSight, but has not yet created a login\. For this process to work, the AWS administrator must have granted permissions, using an AWS user or group policy in IAM\. For more information, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 

**To sign in as a new user with access but no login**

1. When you are invited to do so, go to the Amazon QuickSight sign in page, [https://quicksight\.aws\.amazon\.com/](https://quicksight.aws.amazon.com/)\.

1. For **Account name**, type the Amazon QuickSight account name \(not the AWS account number\)\. Your administrator or manager might provide this name\. Then choose **Continue**\.

1. Type your new Amazon QuickSight user name in **Email address or username**\.

1. Type your new Amazon QuickSight password in **Password**\.

1. Choose **Sign in**\.

#### Self\-Provisioning an Amazon QuickSight administrator<a name="assigning-the-admin"></a>

Use the following procedure to set or create the administrator for Amazon QuickSight\. This procedure does not require using an alias for your account or your directory\.

**To make a user the Amazon QuickSight administrator**

1. Create the AWS user
   + Use IAM to create the user you want to be the administrator of Amazon QuickSight\. Or, identify an existing user in IAM for the administrator role\. If you prefer, you can put the user inside a new group, for manageability\. 
   + Grant the user \(or group\) sufficient permissions, as described in [Setting Your IAM Policy](set-iam-policy.md)\. 
   + For more information on working with IAM, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\. 

1. Log in to your AWS console with the target user's credentials\.

1. Go to [http://quicksight.aws.amazon.com/sn/console/get-user-email](http://quicksight.aws.amazon.com/sn/console/get-user-email)\.

1. Type in your email, and choose **Continue**

1. On success, the target IAM user is now an Amazon QuickSight administrator\.

### Getting Access as a New Amazon QuickSight Enterprise Edition User<a name="request-access-enterprise"></a>

Before you begin, your Amazon QuickSight administrator must add your network user account to an active directory group associated with Amazon QuickSight\. Then, the administrator must provide you with the information that you need to activate your Amazon QuickSight user account, including the Amazon QuickSight account name\.

Use the following procedure to sign in to Amazon QuickSight as a new Enterprise edition user\.

**To sign in as a new Enterprise edition user**

1. Choose **Standard** or **Enterprise**\. To confirm, choose **Continue**\. A screen titled **Create your QuickSight account** appears\. 

1. \(Optional\) If you choose **Standard**, skip this step and proceed to the next one\.

   If you choose **Enterprise**, you can choose the method you want to use to connect\. You can choose one of the following\. 
   + **Use Role Based Federation \(SSO\)**
   + **Use Active Directory**
**Note**  
If you want to use IAM to manage your users, choose **Use Role Based Federation \(SSO\)**\. 

   If you choose **Active Directory**, you will have the chance to add groups and users at this point\. However, you can do this later\. 

1. For all editions, make choices for the following items\.
   + Type in a unique account name for QuickSight\. Your account name can only contain characters \(A–Z and a–z\), digits \(0–9\), and hyphens \(\-\)\. If you use AD and it has a default alias, the alias becomes the account name\.
   + Type in a notification email address for the QuickSight account owner or group\. This email receives service and usage notifications
   + \(Optional\) Choose a capacity region for [SPICE](welcome.md#spice)\. New Enterprise accounts must start in US East \(N\. Virginia\)\. Users can change their region any time\. See [AWS Regions and IP Address Ranges](regions.md) for information on regions\.
   + \(Optional\) Choose whether to allow autodiscovery of your AWS resources\. You can change these options later in **Manage Account**\. For more information, see [Allowing Autodiscovery of AWS Resources](autodiscover-aws-data-sources.md)\.

1. Before you choose **Finish**, make sure you chose the correct edition \(Standard or Enterprise\)\. Currently, to change editions you must either to unsubscribe and create a new Amazon QuickSight account or contact the product team for migration assistance\. 

   Verify the choices you made, then choose **Finish**\. 

1. \(Optional\) If you are using Standard edition, skip this step\. For Enterprise edition, to open Amazon QuickSight choose **Go to Amazon QuickSight**\. To manage Microsoft Active Directory user groups, choose **Manage access to QuickSight**\.

   Otherwise, close the browser and notify your users how to connect\.

After you sign up for Amazon QuickSight, users can log in, connect to data, and create analyses\. You can send them a link to [Amazon QuickSight Quick Start Guide](quickstart.md) to provide them with information to get started\.

To enable self\-provisioning for Amazon QuickSight by setting an IAM policy on a role with permissions for `CreateUser` or `CreateAdmin`, see [Working with AWS Identity and Access Management \(IAM\) Users, Roles, and Policies](working-with-iam.md)\.

To set up data sources for your users, see [Working with Data Sources in Amazon QuickSight](working-with-data-sources.md)\.

For more information about managing users for Amazon QuickSight administrators, see [Managing User Access Inside Amazon QuickSight](managing-quicksight-users.md)\. 