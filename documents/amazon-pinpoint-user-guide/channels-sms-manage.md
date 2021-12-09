# Managing the Amazon Pinpoint SMS Channel<a name="channels-sms-manage"></a>

Use the Amazon Pinpoint console to enable the SMS channel and manage SMS settings, such as your default message type \(transactional or promotional\) and your monthly spending quota\.

To update your SMS settings, use the **SMS and voice settings** page\. For more information, see [SMS and Voice Settings](settings-sms.md)\.

Before you can use Amazon Pinpoint to send SMS messages, you must enable the SMS channel for one or more projects\. To create a new project with SMS support, see [Setting Up the Amazon Pinpoint SMS Channel](channels-sms-setup.md)\. To enable the SMS channel in an existing project, complete the following steps:

**To enable the SMS channel for a project**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project for which you want to enable the SMS channel\.

1. In the navigation pane, under **Settings**, choose **SMS**\.

1. Next to **General**, choose **Edit**\.

1. Choose **Enable the SMS channel for this project**\.

1. Choose **Save changes**\.

## SMS Opt Out<a name="channels-sms-manage-optout"></a>

Where required by local laws and regulations \(such as in the US and Canada\), SMS recipients can use their devices to opt out by replying to the message with any of the following: 
+ ARRET \(French\)
+ CANCEL
+ END
+ OPT\-OUT
+ OPTOUT
+ QUIT
+ REMOVE
+ STOP
+ TD
+ UNSUBSCRIBE

To opt out, the recipient must reply to the same long code or short code that Amazon Pinpoint used to deliver the message\. After opting out, the recipient no longer receives SMS messages from your AWS account\.