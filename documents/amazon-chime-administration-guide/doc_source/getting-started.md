# Getting started<a name="getting-started"></a>

The easiest way for your users to get started with Amazon Chime is to download and use the Amazon Chime Pro version for free for 30 days\. For more information, see [Download Amazon Chime](https://aws.amazon.com/chime/trial)\.

**Purchasing Amazon Chime**  
To continue using the Amazon Chime Pro version after the 30\-day free trial period, you must create an Amazon Chime administrator account and add your users to it\. To get started, you must first complete the [Prerequisites](prereqs.md), which include creating an AWS account\. Then, you can create and configure an Amazon Chime administrator account and add users to it by completing the following tasks\.

**Topics**
+ [Step 1: Creating an Amazon Chime administrator account](#create-account)
+ [Step 2 \(optional\): Configuring account settings](#acct-settings)
+ [Step 3: Adding users to your account](#add-users)
+ [\(Optional\) Setting up phone numbers for your Amazon Chime account](#add-phone-options)
+ [\(Optional\) Configuring your conference rooms to use Amazon Chime](#conference-room-options)

## Step 1: Creating an Amazon Chime administrator account<a name="create-account"></a>

After you complete the [Prerequisites](prereqs.md), you can create an Amazon Chime administrator account\.

**To create an Amazon Chime administrator account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, choose **New account**\.

1. For **Account Name**, enter a name for the account and choose **Create account**\.

1. \(Optional\) Choose whether to let Amazon Chime select the optimal AWS Region for your meetings from all available Regions, or to use only the Regions that you select\. For more information, see [Managing meeting settings](mtg-settings.md)\.

## Step 2 \(optional\): Configuring account settings<a name="acct-settings"></a>

By default, new accounts are created as Team accounts\. If you prefer to claim a domain and connect to your own identity provider, or Okta SSO, you can convert to an Enterprise account\. For more information about Team and Enterprise account types, see [Choosing between an Amazon Chime Team account or Enterprise account](choose-team-enterprise-account.md)\.

**To convert a Team account to an Enterprise account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Accounts**, choose the name of the account\.

1. For **Identity**, choose **Getting Started**\.

1. Follow the steps in the console to claim your domain\.

1. \(Optional\) Follow the steps in the console to set up your identity provider and configure your directory group\.

For more information about claiming domains, see [Claiming a domain](claim-domain.md)\. For more information about setting up identity providers, see [Connecting to your Active Directory](active_directory.md) and [Connecting to Okta SSO](okta_sso.md)\.

You can also allow or stop allowing account policies for options, such as remote control of shared screens and the Amazon Chime call me feature\.

**To configure account policies**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, choose the name of the account to configure\.

1. For **Settings**, choose **Meetings**\.

1. For **Policies**, select or clear the account policy options you want to allow or stop allowing\.

1. Choose **Change**\.

For more information, see [Managing meeting settings](mtg-settings.md)\.

## Step 3: Adding users to your account<a name="add-users"></a>

After your Amazon Chime Team account is created, invite yourself and your users to join it\. If you are upgrading your account to an Enterprise account, you do not need to invite your users\. Instead, upgrade to an Enterprise account and claim your domain\. For more information, see [Step 2 \(optional\): Configuring account settings](#acct-settings)\.

**To add users to your Amazon Chime account**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, choose the name of your account\.

1. On the **Users** page, choose **Invite users**\.

1. Enter the email addresses of the users to invite, including yourself, and choose **Invite users**\. 

The invited users receive email invitations to join the Amazon Chime Team account that you created\. When they register their Amazon Chime user accounts, they receive Pro permissions by default, and their 30\-day trial ends\. If they have already signed up for an Amazon Chime user account with their work email address, they can continue to use that account\. They can also download the Amazon Chime client app at any time by choosing **Download Amazon Chime** and signing in to their user account\.

You are only charged for a user with Pro permissions when they host a meeting\. There is no charge for users with Basic permissions\. Basic users cannot host meetings, but they can attend meetings and use chat\. For more information about pricing and the features that users with Pro and Basic permissions can access, see [Plans and pricing](https://aws.amazon.com/chime/pricing)\.

**To change user permissions**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. On the **Accounts** page, choose the name of your account\.

1. On the **Users** page, select the user or users to change permissions for\.

1. Choose **User actions**, **Assign user permission**\.

1. For **Permissions**, select **Pro** or **Basic**\.

1. Choose **Assign**\.

You can provide other users with administrator permissions, and also control their access to the Amazon Chime console for your account\. For more information, see [Identity and access management for Amazon Chime](security-iam.md)\.

## \(Optional\) Setting up phone numbers for your Amazon Chime account<a name="add-phone-options"></a>

The following phone options are available for Amazon Chime administrative accounts:

**Amazon Chime Business Calling**  
Lets your users send and receive phone calls and text messages directly from Amazon Chime\. Provision your phone numbers in the Amazon Chime console or port in existing phone numbers\. Assign the phone numbers to your Amazon Chime users and grant them permissions to send and receive phone calls and text messages using Amazon Chime\. For more information, see [Managing phone numbers in Amazon Chime](phone-numbers.md) and [Porting existing phone numbers](porting.md)\.

**Amazon Chime Voice Connector**  
Provides SIP trunking service for an existing phone system\. Port in existing phone numbers or provision new phone numbers in the Amazon Chime console\. For more information, see [Managing Amazon Chime Voice Connectors](voice-connectors.md)\.

## \(Optional\) Configuring your conference rooms to use Amazon Chime<a name="conference-room-options"></a>

Amazon Chime can integrate with your in\-room video conference systems\. For more information, see [Conference room configuration](configure-rooms.md) and [Setting up Amazon Chime on Dolby hardware](setup-dolby.md)\.