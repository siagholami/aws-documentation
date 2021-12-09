# Bounce and Complaint Rates<a name="channels-email-deliverability-dashboard-bounce-complaint"></a>

On the **Bounce and complaint rates** page, you can find important metrics related to the bounce and complaint rates for your combined Amazon Pinpoint and Amazon Simple Email Service \(Amazon SES\) account\.

A *bounce* occurs when an email that you send can't be delivered because of a permanent issue\. For example, a bounce might occur if the recipient's address doesn't exist, or the recipient's email provider is blocking email from your domain or IP address\. Email providers consider a high bounce rate to be a negative sign\. This is because it indicates that you're sending email to people who haven't explicitly opted to receive messages from you\. A high bounce rate could have a negative impact on the delivery of your emails\.

A *complaint* occurs when a customer receives an email from you and reports it to their email provider as an unwanted email \(for example, by using the *Report Spam* feature in their email client\)\. Email providers consider complaints to be a serious sign that your domain is sending unsolicited email\. For this reason, a high complaint rate can have a very negative impact on the delivery of your email\.

High bounce and complaint rates often indicate that a sender is sending unsolicited email to their recipients\. For this reason, email providers carefully consider your bounce and complaint rates when they determine whether to send your email to the inbox or to the junk mail folder\.

You can use the **Bounce and complaint rates** page to keep track of these account\-wide metrics\. On this page, you can also create alarms that notify you when your bounce or complaint rates reach certain thresholds\.

## Overview<a name="channels-email-deliverability-dashboard-bounce-complaint-overview"></a>

The **Overview** tab contains information about the bounce and complaint rates for account\.

**Note**  
This page shows bounce and complaint metrics for your entire AWS account in the current AWS Region\. If you use both Amazon Pinpoint and Amazon SES to send email, this page shows the combined bounce and complaint metrics for both services\.

### Summary<a name="channels-email-deliverability-dashboard-bounce-complaint-overview-summary"></a>

This section shows the status of your account\. The following is a list of possible values:
+ **Healthy** – There are no issues currently impacting your account\.
+ **Under review** – Your account is under review\. If the issues that caused us to place your account under review aren't resolved by the end of the review period, we might pause your account's ability to send email\.
+ **Pending end of review decision** – Your account is under review\. Because of the nature of the issues that caused us to place your account under review, we need to perform a manual review of your account before we take any further action\.
+ **Sending paused** – We've paused your account's ability to send email\. While your account's ability to send email is paused, you aren't able to send email using Amazon Pinpoint or Amazon SES\. You can request that we review this decision\.
+ **Pending sending pause** – Your account is under review\. The issues that caused us to place your account under review haven't been resolved\. In this situation, we typically pause your account's ability to send email\. However, because of the nature of your account, we need to review your account before any further action is taken\.

The number that's shown under **Emails sent** is the number of emails that we considered in making this determination\. The number under **Sent over period** is the period of time during which you sent those emails\.

To learn more about each status value and how we work with you to address issues that impact your account, see the [sending review process FAQs](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/faqs-enforcement.html) in the *Amazon Simple Email Service Developer Guide*\.

### Bounce Rate<a name="channels-email-deliverability-dashboard-bounce-complaint-overview-bouncerate"></a>

This section shows the current bounce rate for your account\. The bounce rate for your account should remain below 5%\. If the bounce rate for your account exceeds 10%, we might temporarily pause your account's ability to send email\.

This section contains the following information:
+ **Eligible emails sent** – The number of emails that were considered in calculating the bounce rate\.
+ **Sent over period** – The time period that we considered to calculate the bounce rate\.
+ **Bounce rate** – The percentage of emails you sent during the analysis period that bounced\.
+ **Overall status** – Indicates the health of the metric\. The status could be one of the following:
  + **Healthy** – The bounce rate for your account is within normal levels\.
  + **Almost healed** – Your account was placed under review because the bounce rate was too high\. Since the review period began, the bounce rate has stayed below the maximum rate\. If the bounce rate remains below the maximum rate, the status of this metric changes to **Healthy** at the end of the review period\. 
  + **Under review** – Your account was placed under review because the bounce rate was too high\. Since your account was placed under review, the bounce rate hasn't improved\. If the issue that caused the bounce rate to exceed 5% isn't resolved by the end of the review period, we might pause your account's ability to send email\.
  + **Sending pause** – Your account's ability to send email was paused because the bounce rate was too high\. While your account's ability to send email is paused, you can't send email\. You can request that we review this decision\.
  + **Pending sending pause** – The metric caused us to place your account under review\. The issues that caused this review period haven't been resolved\. These issues might cause us to pause your account's ability to send email\. A member of our team has to review your account before we take any further action\.

  To learn more about each status value and how we work with you to address issues that impact your account, see the [sending review process FAQs](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/faqs-enforcement.html) in the *Amazon Simple Email Service Developer Guide*\.

### Complaint Rate<a name="channels-email-deliverability-dashboard-bounce-complaint-overview-complaintrate"></a>

This section shows the current complaint rate for your account\. The complaint rate for your account should remain below 0\.1%\. If the complaint rate for your account exceeds 0\.1%, we might temporarily pause your account's ability to send email\.

This section contains the following information:
+ **Eligible emails sent** – The number of emails that were considered in calculating the complaint rate\.
+ **Sent over period** – The time period that we considered to calculate the complaint rate\.
+ **Bounce rate** – The percentage of emails you sent during the analysis period that resulted in complaints\.
+ **Overall status** – Indicates the health of the metric\. The status could be one of the following:
  + **Healthy** – The complaint rate for your account is within normal levels\.
  + **Almost healed** – Your account was placed under review because the complaint rate was too high\. Since the review period began, the complaint rate has stayed below the maximum rate\. If the complaint rate remains below the maximum rate, the status of this metric changes to **Healthy** at the end of the review period\. 
  + **Under review** – Your account was placed under review because the complaint rate was too high\. Since your account was placed under review, the complaint rate hasn't improved\. If the issue that caused the complaint rate to exceed 0\.1% isn't resolved by the end of the review period, we might pause your account's ability to send email\.
  + **Sending pause** – Your account's ability to send email was paused because the complaint rate was too high\. While your account's ability to send email is paused, you can't send email\. You can request that we review this decision\.
  + **Pending sending pause** – Your account was placed under review because the complaint rate was too high\. The issues that caused this review period haven't been resolved\. These issues might cause us to pause your account's ability to send email\. A member of our team has to review your account before we take any further action\.

  To learn more about each status value and how we work with you to address issues that impact your account, see the [sending review process FAQs](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/faqs-enforcement.html) in the *Amazon Simple Email Service Developer Guide*\.

## Alarms<a name="channels-email-deliverability-dashboard-bounce-complaint-alarms"></a>

On the **Alarms** tab, you can create alarms that send you notifications when the bounce or complaint rates for your account exceed certain levels\.

**To create an alarm**

1. On the **Alarms** tab, choose **Create alarm**\.

1. On the **Create alarm** page, do the following:

   1. For **Alarm name**, enter a name that helps you easily identify the alarm\.

   1. For **Send a notification when the**, choose one of the following options:
      + **Bounce rate**
      + **Complaint rate**

   1. Configure the values that cause the alarm to be triggered\. For example, if you want to be notified when the bounce rate for your account is 5% or greater, choose **>=**\. Then enter a value of **5**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/deliverability_dashboard_bounce_alarms_threshold.png)

   1. Specify the amount of time that has to elapse before the alarm is triggered\. For example, you can configure the alarm so that it only sends a notification when the bounce rate exceeds a certain rate and stays at that rate for more than 2 hours\. In this example, next to **for at least**, enter a value of **2**\. Then, next to **consecutive period\(s\) of**, choose **1 hour**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/deliverability_dashboard_blacklist_ip_alarms_period.png)

   1. Under **Notification method**, choose one of the following options:
      + **Use an existing SNS topic** – Choose this option if you've already created an Amazon SNS topic and subscribed endpoints to it\.
      + **Create a new topic** – Choose this option if you haven't yet created an Amazon SNS topic, or you want to create a new topic\.
**Note**  
When you create a new topic, you have to subscribe one or more endpoints to it\. For more information, see [Subscribing an Endpoint to a Topic](https://docs.aws.amazon.com/sns/latest/dg/sns-tutorial-create-subscribe-endpoint-to-topic.html) in the *Amazon Simple Notification Service Developer Guide*\.

   1. \(Optional\) You can choose or create more than one Amazon SNS topic\. To add a topic, choose **Notify an additional SNS topic**\.

   1. When you finish, choose **Create**\.