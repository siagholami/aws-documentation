# Setting up the Amazon Chime Meetings App for Slack<a name="config-slack"></a>

If you are a Slack workspace administrator, you can set up the Amazon Chime Meetings App for Slack for your workspace\. Your users can use Slack to start instant meetings and calls\.

**To set up the Amazon Chime Meetings App for Slack for your Slack workspace users**

1. Choose [https://signin.id.ue1.app.chime.aws/auth/slack?purpose=app_authz](https://signin.id.ue1.app.chime.aws/auth/slack?purpose=app_authz) to install the Amazon Chime Meetings App for Slack from the Slack App Directory\.

1. Configure your Slack workspace **Calls** setting to **Enable calling in Slack, using Amazon Chime**\.

Your Slack workspace users can now use the Amazon Chime Meetings App for Slack to start instant meetings and calls\. For more information about how users can use the Amazon Chime Meetings App for Slack, see [Using the Amazon Chime Meetings App for Slack](https://docs.aws.amazon.com/chime/latest/ug/using-slack.html) in the *Amazon Chime User Guide*\.

Associate your workspace with an Amazon Chime Team account to manage your users' permissions\. You can upgrade meeting hosts to Amazon Chime Pro so that they can start meetings with up to 250 attendees and 16 video tiles, and include phone numbers to dial in for audio\. Assign users Amazon Chime Basic permissions so they can start one\-on\-one meetings or join Amazon Chime meetings without being charged for active host days\. For more information, see [Amazon Chime Pricing](http://aws.amazon.com/chime/pricing/)\.

**Note**  
If you associate an Amazon Chime Team account with your Slack workspace, users can sign in to Amazon Chime from the Amazon Chime Meetings App for Slack\. You can change this setting at any time\. For more information, see [Managing meeting settings](mtg-settings.md)\.

Before you can associate your Slack workspace with an Amazon Chime Team account, you must create an AWS account\. For more information about how to create an AWS account, see [Prerequisites](prereqs.md)\.

**To associate your Slack workspace with an Amazon Chime Team account when installing the Amazon Chime Meetings App for Slack**

1. Immediately after installing the Amazon Chime Meetings App for Slack in your Slack workspace, choose **Upgrade now**\.

1. Follow the prompts to sign in to the Amazon Chime console using your AWS account credentials\.

1. Follow the prompts to create a new Team account in Amazon Chime or choose an existing one\.
   + **Create a new account** – Create a new Amazon Chime account to which to invite your Slack users\. Enter an account name, choose whether to invite your Slack users, then choose **Create**\.
   + **Choose an existing account** – Select an existing Amazon Chime account to invite your Slack users to\. Select the account, then choose **Invite**\.

When you invite your Slack users to join Amazon Chime, they receive an email invitation\. When they accept the invitation, they are automatically upgraded to Amazon Chime Pro\.

If you did not associate your Slack workspace with an Amazon Chime Team account when you installed the Amazon Chime Meetings App for Slack, you can do so after the fact by using the following steps\.

**To associate your Slack workspace with an Amazon Chime Team account after installing the Amazon Chime Meetings App for Slack**

1. Sign in to your AWS account\.

1. Sign in to your Slack workspace as an administrator\.

1. Go to [https://signin\.id\.ue1\.app\.chime\.aws/auth/slack?purpose=app\_authz](https://signin.id.ue1.app.chime.aws/auth/slack?purpose=app_authz)\.

1. Follow the prompts to create a new Team account in Amazon Chime or choose an existing one\.
   + **Create a new account** – Create a new Amazon Chime account to which to invite your Slack users\. Enter an account name, choose whether to invite your Slack users, then choose **Create**\.
   + **Choose an existing account** – Select an existing Amazon Chime account to invite your Slack users to\. Select the account, then choose **Invite**\.