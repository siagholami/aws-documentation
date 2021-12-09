# Requesting Dedicated Short Codes for SMS Messaging with Amazon Pinpoint<a name="channels-sms-awssupport-short-code"></a>

A short code is a number that you can use for high\-volume SMS message sending\. Short codes are often used for application\-to\-person \(A2P\) messaging, two\-factor authentication \(2FA\), and marketing\. A short code typically contains between three and seven digits, depending on the country or region that it's based in\.

You can only use short codes to send messages to recipients in the same country where the short code is based\. If your use case requires you to use short codes in more than one country, you have to request a separate short code for each country that your recipients are located in\.

For information about short code pricing, see [Amazon Pinpoint Pricing](https://aws.amazon.com/pinpoint/pricing/#Dedicated_Short_Codes)\.

**Important**  
If you're new to SMS messaging with Amazon Pinpoint, request a monthly SMS spending threshold that meets the expected demands of your SMS use case\. By default, your monthly spending threshold is $1\.00 \(USD\)\. You can request to increase your spending threshold in the same support case that includes your request for a short code\. Or, you can use a separate case\. For more information, see [Requesting Increases to Your Monthly SMS Spending Quota for Amazon Pinpoint](channels-sms-awssupport-spend-threshold.md)\.  
In addition, if you're requesting a dedicated short code to send messages that will or may contain Protected Health Information \(PHI\), you should identify this purpose in your **Case description** when you open a support case, as detailed below\.

## Step 1: Open a Support Case<a name="channels-sms-awssupport-short-code-open"></a>

Open a case with AWS Support by completing the following steps\.

**To request a dedicated short code**

1. Sign in to the AWS Management Console at [https://console\.aws\.amazon\.com/](https://console.aws.amazon.com/)\.

1. On the **Support** menu, choose **Support Center**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/console_region_selector.png)

1. On the **My support cases** tab, choose **Create case**\.

1. Choose **Service quota increase**\.

1. Under **Case classification**, complete the following sections:
   + For **Quota type**, choose **Pinpoint SMS**\.
   + For **Provide a link to the site or app which will be sending SMS messages**, provide information about the website, application, or service that will send SMS messages\.
   + For **What type of messages do you plan to send**, choose the type of messages that you plan to send using your short code\.
   + For **Which countries do you plan to send messages to**, enter the country or region that you want to purchase short codes in\.

1. Under **Requests**, complete the following sections:
   + For **Resource Type**, choose **Dedicated SMS Short Codes**\.
   + For **Quota**, choose the type of messages that you plan to send using this short code\.
   + For **New quota value**, enter the number of short codes that you want to purchase\.

1. Under **Case description**, for **Use case description**, provide the following information:

**Company information:**
   + Company name\.
   + Company mailing address\.
   + Name and phone number for the primary contact for your request\.
   + Email address and toll\-free number for support at your company\.
   + Company tax ID\.
   + Name of your product or service\.

**User sign\-up process:**
   + Company website, or the website that your customers will sign up on to receive messages from your short code\.
   + How users will sign up to receive messages from your short code\. Specify one or more of the following options:
     + **Text messages**\.
     + **Website**\.
     + **Mobile app**\.
     + **Other**\. If other, explain\.
   + The text for the option to sign up for messages on your website, app, or elsewhere\.
   + The sequence of messages that you plan to use for double opt\-in\. Provide all of the following:

     1. The SMS message that you plan to send when a user signs up\. This message asks for the user's consent for recurring messages\. For example: *ExampleCorp: Reply YES to receive account transaction alerts\. Msg&data rates may apply\.*

     1. The opt\-in response that you expect from the user\. This is typically a keyword, such as *YES*\.

     1. The confirmation message that you want to send when customers send this keyword to your short code\. For example: *You are now registered for account alerts from ExampleCorp\. Msg&data rates may apply\. Txt STOP to cancel or HELP for info\.*

**The purpose of your messages:**
   + The purpose of the messages that you plan to send with your short code\. Specify one of the following options:
     + **Promotions and marketing**\.
     + **Location\-based services**\.
     + **Notifications**\.
     + **Information on demand**\.
     + **Group chat**\.
     + **Two\-factor authentication \(2FA\)**\.
     + **Polling and surveys**\.
     + **Sweepstakes or contests**\.
     + **Other**\. If other, explain\.
   + Whether you plan to use your short code to send promotional or marketing messages for a business other than your own\.
   + Whether you plan to use your short code to send messages that will or may contain Protected Health Information \(PHI\), as defined by the Health Insurance Portability and Accountability Act \(HIPAA\) and associated legislation and regulations\.

**Message content:**
   + The message that you plan to send when customers opt in to your messages by sending you a specific keyword\. Be careful when you specify this keyword and message—it may take several weeks to change this message\. When we create your short code, we register the keyword and message with the mobile phone carriers in the country where you use the short code\. Your message might resemble the following example: *Welcome to *ProductName* alerts\! Msg&data rates apply\. *2* msgs per month\. Reply HELP for help, STOP to cancel\.*
   + The response that you want to send when customers reply to your messages with the keyword *HELP*\. This message has to include customer support contact information\. For example: **ProductName* Alerts: Help at *example\.com/help* or *\(800\) 555\-0199*\. Msg&data rates apply\. *2* msgs per month\. Reply STOP to cancel\.*
   + The response that you want to send when customers reply to your messages with the keyword *STOP*\. This message has to confirm that the user will no longer receive messages from you\. For example: *You are unsubscribed from *ProductName* Alerts\. No more messages will be sent\. Reply HELP for help or *\(800\) 555\-0199*\.*
   + The text that you plan to send as a periodic reminder that the user is subscribed to your messages\. For example: *Reminder: You're subscribed to account alerts from ExampleCorp\. Msg&data rates may apply\. Txt STOP to cancel or HELP for info\.*
   + An example of each type of message that you plan to send using your short code\. Provide at least three examples\. If you plan to send more than three types of messages, provide examples for all of them\.
**Important**  
Mobile carriers require us to provide all of the information listed above in order to provision short codes\. We can't process your request until you provide all of this information\.

1. Under **Contact options**, for **Preferred contact language**, choose whether you want to receive communications for this case in **English** or **Japanese**\.

1. When you finish, choose **Submit**\.

After we receive your request, we provide an initial response within 24 hours\. We might contact you to request additional information\. If we're able to provide you with a short code, we send you information about the costs associated with obtaining a short code in the country or region that you specified in your request\. We also provide an estimate of the amount of time that's required to provision a short code in your country or region\. It usually takes several weeks to provision a short code, although this delay can be much shorter or much longer depending on the country or region where the short code is based\.

**Note**  
The fees associated with using short codes begin immediately after we initiate your short code request with carriers\. You're responsible for paying these charges, even if the short code hasn't been completely provisioned yet\.

In order to prevent our systems from being used to send unsolicited or malicious content, we have to consider each request carefully\. We might not be able to grant your request if your use case doesn’t align with our policies\.

## Step 2: Update Your SMS Settings in the Amazon Pinpoint Console<a name="channels-sms-awssupport-short-code-settings"></a>

After we notify you that your short code has been provisioned, complete the following steps\.

**Note**  
You can't complete this steps until we've obtained the short code and associated it with your account\.

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose a project that the SMS channel is enabled in\.

1. In the navigation pane, under **Settings**, choose **SMS and voice**\. 

1. Under **Number settings**, choose the short code\.

1. Under **Default keywords**, verify that the responses for the *HELP* and *STOP* keywords match the values that you specified in your request\.

1. Under **Registered keyword**, verify that the opt\-in keyword and response match the values that you specified in your request\.

1. \(Optional\) If you want to specify additional keyword responses, or if you want to process inbound messages outside of Amazon Pinpoint, you can enable two\-way SMS\. For more information, see [Two\-Way SMS Settings](settings-sms.md#settings-account-sms-number-2way)\.

1. When you finish, choose **Save**\.

## Next Steps<a name="channels-sms-awssupport-short-code-next"></a>

You've registered a short code with wireless carriers and reviewed your settings in the Amazon Pinpoint console\. Now you can use Amazon Pinpoint to send SMS messages with your short code as the origination number\.

To engage an audience segment with an SMS campaign, see [Amazon Pinpoint Campaigns](campaigns.md)\.