# Amazon SES notifications sent by email<a name="monitor-sending-activity-using-notifications-email"></a>

Amazon SES can send you email when you receive bounces and complaints by using a process called *email feedback forwarding*\.

In order to send email using Amazon SES, you must configure it to send bounce and complaint notifications by using one of the following methods:
+ By enabling email feedback forwarding\. The procedure for setting up this type of notification is included in this section\.
+ By sending notifications to an Amazon SNS topic\. For more information, see [Amazon SES notifications sent through Amazon SNS](monitor-sending-activity-using-notifications-sns.md)\.
+ By publishing event notifications\. For more information, see [Monitor email sending using Amazon SES event publishing](monitor-using-event-publishing.md)\.

**Important**  
For several important points about notifications, see [Monitoring Amazon SES email sending using notifications](monitor-sending-activity-using-notifications.md)\.

**Topics**
+ [Enabling email feedback forwarding](#monitor-sending-activity-using-notifications-email-enabling)
+ [Disabling email feedback forwarding](#monitor-sending-activity-using-notifications-email-disabling)
+ [Email feedback forwarding destination](#monitor-sending-activity-using-notifications-email-destination)

## Enabling email feedback forwarding<a name="monitor-sending-activity-using-notifications-email-enabling"></a>

Email feedback forwarding is enabled by default\. If you previously disabled it, you can enable it by following the procedures in this section\.

**To enable bounce and complaint forwarding through email using the Amazon SES console**

1. Sign in to the AWS Management Console and open the Amazon SES console at [https://console\.aws\.amazon\.com/ses/](https://console.aws.amazon.com/ses/)\.

1. In the navigation pane, under **Identity Management**, choose **Email Addresses** if you want to configure bounce and complaint notifications for an email address, or choose **Domains** if you want to configure bounce and complaint notifications for a domain\.

1. In the list of verified email addresses or domains, choose the email address or domain that you want to configure bounce and complaint notifications for\.

1. In the details pane, expand the **Notifications** section\.

1. Choose **Edit Configuration**\.

1. Under **Email Feedback Forwarding**, choose **Enabled**\.
**Note**  
Changes you make on this page may take a few minutes to take effect\.

You can also enable bounce and complaint notifications through email by using the [ SetIdentityFeedbackForwardingEnabled](https://docs.aws.amazon.com/ses/latest/APIReference/API_SetIdentityFeedbackForwardingEnabled.html) API operation\.

## Disabling email feedback forwarding<a name="monitor-sending-activity-using-notifications-email-disabling"></a>

If you set up a different method of providing bounce and complaint notifications, you can disable email feedback forwarding so that you don't receive multiple notifications when a bounce or complaint event occurs\.

**To disable bounce and complaint forwarding through email using the Amazon SES console**

1. Sign in to the AWS Management Console and open the Amazon SES console at [https://console\.aws\.amazon\.com/ses/](https://console.aws.amazon.com/ses/)\.

1. In the navigation pane, under **Identity Management**, choose **Email Addresses** if you want to configure bounce and complaint notifications for an email address, or choose **Domains** if you want to configure bounce and complaint notifications for a domain\.

1. In the list of verified email addresses or domains, choose the email address or domain that you want to configure bounce and complaint notifications for\.

1. In the details pane, expand the **Notifications** section\.

1. Choose **Edit Configuration**\.

1. Under **Email Feedback Forwarding**, choose **Disabled**\.
**Note**  
You must configure one method of receiving bounce and complaint notifications in order to send email through Amazon SES\. If you disable email feedback forwarding, you must enable notifications sent by Amazon SNS, or publish bounce and complaint events to an Amazon SNS topic or a Kinesis Data Firehose stream by using [event publishing](monitor-using-event-publishing.md)\. If you use event publishing, you must also apply the configuration set that contains the event publishing rule to each email you send\. If you don't set up a method of receiving bounce and complaint notifications, Amazon SES automatically forwards feedback notifications by email to the address in the Return\-Path field \(or the Source field, if you didn't specify a Return\-Path address\) of the message that resulted in the bounce or complaint event\. In this situation, Amazon SES forwards bounce and complaint notifications even if you disabled email feedback notifications\.

1. Choose **Save Config** to save your notification configuration\.
**Note**  
Changes you make on this page might take a few minutes to take effect\.

You can also disable bounce and complaint notifications through email by using the [SetIdentityFeedbackForwardingEnabled](https://docs.aws.amazon.com/ses/latest/APIReference/API_SetIdentityFeedbackForwardingEnabled.html) API operation\. 

## Email feedback forwarding destination<a name="monitor-sending-activity-using-notifications-email-destination"></a>

When you receive notifications by email, Amazon SES rewrites the `From` header and sends the notification to you\. The address to which Amazon SES forwards the notification depends on how you sent the original message\.

If you used the SMTP interface to send the message, then notifications go to the address specified in the MAIL FROM command\.

If you used the `SendEmail` API operation to send the message, then the notifications are delivered according to the following rules:
+ If you specified the optional `ReturnPath` parameter in your call to the `SendEmail` API, then notifications go to that address\.
+ Otherwise, notifications go to the address specified in the required `Source` parameter of `SendEmail`\.

If you used the `SendRawEmail` API operation to send the message, then the notifications are delivered according to the following rules:
+ If you specified a `Source` parameter in your call to the `SendRawEmail` API, then notifications go to that address\. This is true even if you specified a `Return-Path` header in the body of the email\.
+ Otherwise, if you specified a `Return-Path` header in the raw message, then notifications go to that address\.
+ Otherwise, notifications go to the address in the `From` header of the raw message\.

**Note**  
When you specify a `Return-Path` address in an email, you receive notifications at that address\. However, the version of the message that the recipient receives contains a `Return-Path` header that includes an anonymized email address \(such as *a0b1c2d3e4f5a6b7\-c8d9e0f1\-a2b3\-c4d5\-e6f7\-a8b9c0d1e2f3\-000000@amazonses\.com*\)\. This anonymization happens regardless of how you sent the email\.