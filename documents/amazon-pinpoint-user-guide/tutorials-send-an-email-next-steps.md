# Conclusion and Next Steps<a name="tutorials-send-an-email-next-steps"></a>

By completing this tutorial, you've accomplished the following:
+ Created a new Amazon Pinpoint project\.
+ Verified an email address or domain that you can use to send email from Amazon Pinpoint\.
+ Created a spreadsheet that contains contact information for a list of contacts, and then uploaded that spreadsheet to Amazon S3\.
+ Created a new segment that uses the contact information in the spreadsheet that you uploaded to Amazon S3\.
+ Created a new email campaign and sent it to your segment\.
+ Reviewed the delivery and response metrics for your campaign\.

## What's Next?<a name="tutorials-send-an-email-next-steps-whats-next"></a>

Now that you know how to send an email in Amazon Pinpoint, you're ready for some more advanced steps\. The following sections provide information about other Amazon Pinpoint features that you can explore\.

### Get Out of the Sandbox<a name="tutorials-send-an-email-next-steps-whats-next-sandbox"></a>

New Amazon Pinpoint customers are placed in a "sandbox" environment\. When your account is in the sandbox, you can only send email to verified email addresses\. Additionally, you can send a maximum of 200 messages in a 24\-hour period, and a maximum of 1 message per second\.

We put new accounts in the sandbox in order to prevent unscrupulous users from creating multiple accounts and using them to send unsolicited or malicious email\. In order to have your account removed from the sandbox, you have to demonstrate that you follow industry best practices, and that your email sending practices abide by the policies in the [AWS Service Terms](https://aws.amazon.com/service-terms/) and [AWS Acceptable Use Policy](https://aws.amazon.com/agreement/) documents\.

For information about having your account removed from the sandbox, see [Managing Email Sending Quotas](channels-email-manage-limits.md)\.

### View Your Response Metrics<a name="tutorials-send-an-email-next-steps-whats-next-metrics"></a>

After you send a message, Amazon Pinpoint automatically monitors how your customers interact with that message\. For example, when you send email to a segment of customers, Amazon Pinpoint keeps track of how many emails were delivered\. It also tracks the number of customers that opened the email, and the number who unsubscribed after receiving the email\. You can view these metrics directly in the Amazon Pinpoint console\.

**To view the response metrics for your campaign**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. Choose the project that you want to view response metrics for\.

1. In the navigation pane, under **Analytics**, choose **Campaigns**\.

1. In the list of campaigns at the bottom of the page, choose a campaign\. The campaign details page appears\. This page tells you how many messages were sent, how many were delivered, how many bounced, and how many were opened\. It also tells you the date and time when each campaign run occurred\. If you sent the message once, you see information for only one campaign run\. If you sent a message on a recurring basis, you see information for each time Amazon Pinpoint sent the message\.

### Send Messages in Other Channels<a name="tutorials-send-an-email-next-steps-whats-next-other-channels"></a>

If your customers consent to being contacted by other channels, such as SMS or push notifications, you can use Amazon Pinpoint to send messages through those channels as well\. The process for sending through other channels is similar to the process that you used to send email in this tutorial\.

When you send messages by using other channels, you need to modify a few of the procedures in this tutorial:
+ When you create a new project, specify a different channel type\.
+ When you upload a list of segment members, include their mobile phone numbers \(for SMS messages\) or their app tokens \(for push notifications\)\.

For more information about other messaging channels in Amazon Pinpoint, see [Amazon Pinpoint Channels](channels.md)\.