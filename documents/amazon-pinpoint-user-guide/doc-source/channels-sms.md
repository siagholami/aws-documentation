# Amazon Pinpoint SMS Channel<a name="channels-sms"></a>

You can use the SMS channel in Amazon Pinpoint to send SMS messages \(text messages\) to your customers' mobile devices\. Amazon Pinpoint can send SMS messages to recipients in [over 200 countries and regions](channels-sms-countries.md)\. In some countries and regions, you can also receive messages from your customers by using the two\-way SMS feature\.

To send text messages using Amazon Pinpoint, you have to [enable the SMS channel in your project](channels-sms-setup.md)\. Depending on how you use Amazon Pinpoint to send SMS messages, you might also need to [initiate a request with AWS Support](channels-sms-awssupport.md) to request that certain SMS options are enabled or modified for your account\. For example, you can request an increase to your SMS spending quota, or request a short code to use when sending and receiving messages\.

To receive text messages using Amazon Pinpoint, you should first obtain a dedicated [short code](channels-sms-awssupport-short-code.md) or [long code](channels-sms-awssupport-long-code.md)\. When you have a dedicated number, you can [enable two\-way SMS for it](channels-sms-two-way.md)\. Finally, you can [specify the messages that Amazon Pinpoint sends to customers when it receives incoming messages](settings-sms.md)\. 

In the [SMS and voice settings section](settings-sms.md) of the Amazon Pinpoint console, you can manage SMS channel settings for your use case and budget\. For example, you can set your monthly SMS spending quota, or change your default message type\.

**Note**  
When you configure SMS channel settings in Amazon Pinpoint, your changes apply to other AWS services that send SMS messages, such as Amazon SNS\.

**Topics**
+ [SMS Limits and Restrictions in Amazon Pinpoint](channels-sms-limitations.md)
+ [Setting Up the Amazon Pinpoint SMS Channel](channels-sms-setup.md)
+ [Requesting Support for SMS Messaging with Amazon Pinpoint](channels-sms-awssupport.md)
+ [Monitoring SMS Activity with Amazon Pinpoint](channels-sms-monitor.md)
+ [Managing the Amazon Pinpoint SMS Channel](channels-sms-manage.md)
+ [Originating Identities for SMS Messages](channels-sms-originating-identities.md)
+ [Using Two\-Way SMS Messaging in Amazon Pinpoint](channels-sms-two-way.md)
+ [Supported Countries and Regions \(SMS Channel\)](channels-sms-countries.md)
+ [SMS Best Practices](channels-sms-best-practices.md)