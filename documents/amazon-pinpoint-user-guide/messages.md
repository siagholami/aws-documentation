# Send Test Messages with Amazon Pinpoint<a name="messages"></a>

With Amazon Pinpoint, you can send *test messages*, which are one\-time messages that you send directly to a specific set of recipients\. Sending a test message is useful if you want to test the deliverability of a message, or see how a message appears to recipients\. You can send a test message by using any channel that Amazon Pinpoint supports\.

We charge you for each test message that you send\. However, we don't bill you based on your monthly targeted audience \(MTA\) when you send test messages\. For more information, see [Amazon Pinpoint Pricing](https://aws.amazon.com/pinpoint/pricing/)\.

When you use the Amazon Pinpoint console to send a test message, you can send the message to as many as 15 recipients, depending on the type of message\. You can't send a test message to a segment—you have to send it to individual users\. In addition, Amazon Pinpoint delivers a test message immediately\. You can't schedule the delivery of a test message\. Finally, a test message doesn't generate messaging metrics, such as open, click, or bounce rates\. If you want to send a message to a segment, schedule the delivery of a message, or obtain metrics data for a message, you should [create a campaign](campaigns.md) instead of sending a test message\.

To send a test message from the Amazon Pinpoint console, use the **Test messaging** page on the console\.

**To open the Test messaging page**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to send a test message for\.

1. In the navigation pane, choose **Test messaging**\.