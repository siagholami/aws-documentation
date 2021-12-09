# SMS and Voice Settings<a name="settings-sms"></a>

Use the **SMS and voice** settings page to enable or disable the SMS and voice channels for the current project\. You can also use this page to manage the default SMS settings that apply to all SMS messages that you send from your AWS account, including messages that you send by using other AWS services\.

In addition, you can use this page to view a list of the phone numbers that you can use to send voice messages\. This page also provides options for requesting additional phone numbers and relinquishing phone numbers for the voice channel\. To learn more about using the voice channel to send voice messages, see [Amazon Pinpoint Voice Channel](channels-voice.md)\.

**Topics**
+ [Changing SMS Settings](#settings-account-sms-general)
+ [Managing Number Settings](#settings-account-sms-number)

## Changing SMS Settings<a name="settings-account-sms-general"></a>

The Amazon Pinpoint console provides several options to help you update and manage SMS channel settings to match your use case and budget\. For example, you can enable or disable the SMS channel for a specific project, set a monthly SMS spending quota for your AWS account, or change the default message type for your AWS account\.

**To change SMS settings**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, do one of the following:
   + To change SMS settings for a specific project, choose the project\.
   + To change SMS settings for your AWS account, choose any project\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\.

1. On the **SMS and voice** settings page, next to **General**, choose **Edit**\.

1. On the **Edit SMS** page, change any of the following settings:
   + **Enable the SMS channel for this project** – Select this option to enable the SMS channel for the current project\. To disable the SMS channel for the project, clear this option\.
   + **Account\-level settings** – Change these settings to modify the SMS settings for your AWS account\. These settings apply to your entire Amazon Pinpoint account and to all AWS services that you can use to send SMS messages, such as Amazon Simple Notification Service\. You can change the following settings:
     + **Default message type** – Choose the type of SMS messages that you plan to send\. If you plan to send time\-sensitive content, such as alerts and one\-time passwords, choose **Transactional**\. If you plan to send marketing\-related content, choose **Promotional**\.
     + **Account spending limit** – Specify the maximum amount of money, in US Dollars, that you want to spend sending SMS messages during each calendar month\.
     + **Default sender ID** – Optionally, specify the sender ID that you plan to use to send SMS messages\. A sender ID is an alphanumeric identifier that appears on recipients' devices when they receive messages from you\. Support for sender IDs varies by country or region\. For more information, see [Supported Countries and Regions \(SMS Channel\)](channels-sms-countries.md)\.

1. When you finish making changes, choose **Save changes**\.

## Managing Number Settings<a name="settings-account-sms-number"></a>

You can use the options in the **Number settings** section of the **SMS and voice** settings page to manage settings for the dedicated *short codes* and *long codes* that you requested from AWS Support and assigned to your account\. A short code is a five\-digit or six\-digit number that's meant for high\-volume SMS messaging\. To learn how to request a dedicated short code, see [Requesting Dedicated Short Codes for SMS Messaging with Amazon Pinpoint](channels-sms-awssupport-short-code.md)\. A long code is a standard 10\-digit phone number that's meant for low\-volume, person\-to\-person communication\. To learn how to request a dedicated long code, see [Requesting Dedicated Long Codes for SMS Messaging with Amazon Pinpoint](channels-sms-awssupport-long-code.md)\.

After you receive one or more dedicated short codes or long codes from AWS Support, those numbers appear in the **Number settings** section, where you can manage SMS keyword settings and two\-way SMS messaging settings for the numbers\.

### Keyword Settings<a name="settings-account-sms-number-keyword"></a>

A *keyword* is a specific word or phrase that a customer can send to your number to elicit a response, such as an informational message or a special offer\. When your number receives a message that begins with a keyword, Amazon Pinpoint responds with a customizable message\.

For short codes, the console shows the keywords and responses that you initially define when you request a short code from AWS Support\. AWS Support registers your keywords and responses with wireless carriers when it provisions your short code\.

For long codes, the console shows the default keywords and responses\.

**Important**  
Your keywords and response messages must comply with the guidelines that are set by wireless carriers and wireless industry groups\. Otherwise, following an audit, such groups might take action against your short code or long code\. This action can include blacklisting your number and blocking your messages\.

#### Default Keywords<a name="settings-account-sms-number-keyword-default"></a>

Wireless carriers in the US require short codes to support the following keywords\. In addition, AWS expects all long codes and short codes to support these keywords:

HELP  
Used to obtain customer support\. The response message must include customer\-support contact information, as in the following example:  
*"For assistance with your account, call 1 \(NNN\) 555\-0199\."*

STOP  
Used to opt out of receiving messages from your number\. In addition to *STOP*, your audience can use any supported opt\-out keyword, such as *CANCEL* or *OPTOUT*\. For a list of supported opt\-out keywords, see [SMS Opt Out](channels-sms-manage.md#channels-sms-manage-optout)\. After your number receives an SMS message that contains an opt\-out keyword, Amazon Pinpoint stops sending SMS messages from your account to the individual who opted out\.  
The response message must confirm that messages will stop being sent to the individual who opted out, as in the following example:  
*"You are now opted out and will no longer receive messages\."*

#### Registered Keyword<a name="settings-account-sms-number-keyword-registered"></a>

A *registered keyword* is a keyword that's specific to your SMS use case\. When you use short codes, you're required to register this keyword with wireless carriers\. Customers can send this keyword to your short code to get more information about the products and services that you offer\.

#### Changing Keyword Settings<a name="settings-account-sms-number-keyword-managing"></a>

Use the Amazon Pinpoint console to customize the keyword responses for your number\.

1. On the **SMS and voice** settings page, under **Number settings**, choose the short code or long code that you want to manage keyword responses for\.

   Under **Keywords**, the console provides options for:
   + The default *HELP* and *STOP* keywords\. You can edit the response messages, but you can't edit the keywords\.
   + Your registered keyword\. If you want to change your registered keyword, you need to first open a case with AWS Support and request to update the keyword with wireless carriers\. Then, you need to edit the keyword in the Amazon Pinpoint console to match\. You can also edit the response message, but the intent of the message must remain consistent with the message that you provide to AWS Support\.

1. In the table that contains the keyword that you want to edit, choose **Edit**, and then edit the keyword and response message\.

1. When you finish making changes, choose **Save**\.

### Two\-Way SMS Settings<a name="settings-account-sms-number-2way"></a>

You can define keywords for SMS messages that you want to receive and process by using a service other than Amazon Pinpoint\. When your number receives an SMS message that begins with one of these keywords, Amazon Pinpoint sends the message and related data to an Amazon Simple Notification Service \(Amazon SNS\) topic in your account\. You can then use Amazon SNS to publish the message to topic subscribers or to AWS services for further processing\.

**To set up two\-way SMS**

1. On the **All projects** page, choose the project that you want to manage two\-way SMS settings for\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\.

1. Under **Number settings**, choose the phone number that you want to configure two\-way SMS for\.
**Note**  
You can enable two\-way SMS for a phone number only if the value in the **SMS** column is *Enabled*\.

1. Under **Two\-way SMS**, choose **Enable 2\-way SMS**\.

1. Under **Incoming messages destination**, specify the Amazon SNS topic that receives your SMS messages by choosing one of the following options:
   + **Create a new Amazon SNS topic** – Amazon Pinpoint creates a topic in your account\.
   + **Choose an existing Amazon SNS topic** – Specify the ARN of a topic in your account\.
**Note**  
Amazon Pinpoint currently doesn't support the use of encrypted Amazon SNS topics for two\-way SMS messaging\. You have to choose a topic that isn't encrypted\.

1. Under **Two\-way SMS keywords**, you can add or edit keywords and response messages\. When your number receives an SMS message that contains one of these keywords, Amazon Pinpoint does the following:
   + Sends the message to your Amazon SNS topic\.
   + Responds with the keyword response message, if you specified one\.

   To add a keyword, choose **Add another keyword**\.

1. When you finish making changes, choose **Save**\.

### Self\-Managed Opt\-Outs<a name="settings-account-sms-self-managed-opt-out"></a>

By default, when a customer sends a message that begins with *HELP* or *STOP* to one of your dedicated numbers, Amazon Pinpoint automatically replies with a customizable message\. In the case of incoming STOP messages, Amazon Pinpoint also opts the customer out of receiving future SMS messages\. If you prefer to manage HELP and STOP responses by using a service other than Amazon Pinpoint, you can enable self\-managed opt\-outs\. 

**Note**  
To enable self\-managed opt\-outs for a number, you must first enable two\-way SMS messaging for that number\.

When you enable this feature, there are three changes to the way that Amazon Pinpoint handles incoming messages that your customers send to the specified long or short code\. First, it stops sending automatic responses to incoming HELP and STOP messages\. \(However, you can use [keyword settings](#settings-account-sms-number-keyword-managing) to manually configure responses to these messages\.\) Second, Amazon Pinpoint stops automatically opting your customers out of receiving future SMS messages when they send a STOP message\. And finally, it routes incoming HELP and STOP messages to the Amazon SNS topic that you use to receive two\-way SMS messages, rather than responding to the sender automatically\. 

If you enable this feature, you're responsible for responding to HELP and STOP requests\. You're also responsible for tracking and honoring opt\-out requests\.

**Important**  
Many countries, regions, and jurisdictions impose severe penalties for sending unwanted SMS messages\. If you enable this feature, make sure you have systems and processes in place for capturing and managing opt\-out requests\.

**To enable self\-managed opt\-outs**

1. Under **Number settings**, choose the short code or long code that you want to enable self\-managed opt\-outs for\.

1. On the **Number settings** page, choose **Two\-way SMS**\.

1. Enable and set up two\-way SMS messaging, if you haven't already done so\. For information about setting up two\-way SMS messaging, see [Using Two\-Way SMS Messaging in Amazon Pinpoint](channels-sms-two-way.md)\. 

1. Under **Opt\-outs**, choose **Enable self\-managed opt\-outs**\.