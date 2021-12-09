# IP Reputation<a name="channels-email-deliverability-dashboard-ip-address"></a>

The **IP address reputation** page contains information about the blacklist activities for the dedicated IP addresses that you use to send email by using Amazon Pinpoint and Amazon Simple Email Service \(Amazon SES\)\. 

## Overview<a name="channels-email-deliverability-dashboard-ip-address-overview"></a>

The **Overview** tab lists every dedicated IP address that's associated with your Amazon Pinpoint and Amazon SES accounts, as shown in the following image\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/channels-email-deliverability-dashboard-ip-address.png)

If the value in the **Reputation** column is *High*, then there are no blacklist activities that impact the reputation of that IP address\. If the IP address does appear on a blacklist, the name of that blacklist is shown in the **Blacklist name** column\.

If one of your dedicated IP addresses appears in this section, you should contact the organization that manages the blacklist, and request that your IP address be removed\. The following table includes a list of blacklist operators that are considered in this section, and includes links to their procedures for delisting an IP address\.


| Blacklist Operator | Link to Delisting Procedures | 
| --- | --- | 
| Spamhaus | [Spamhaus website](https://www.spamhaus.org/lookup/)  | 
| Barracuda | [Barracuda website](http://www.barracudacentral.org/rbl/removal-request)  | 
| Invaluement | [Invaluement website](https://www.invaluement.com/removal/)  | 
| LashBack | [LashBack website](https://blacklist.lashback.com/)  | 
| Passive Spam Block List \(PSBL\) | [Passive Spam Block List website](https://psbl.org/remove)  | 
| SORBS | [SORBS website](http://www.sorbs.net/delisting/overview.shtml)  | 

## Alarms<a name="channels-email-deliverability-dashboard-ip-address-alarms"></a>

On the **Alarms** tab, you can create alarms that send you notifications when your dedicated IPs are added to major blacklists\.

**To create an alarm**

1. On the **Alarms** tab, choose **Create alarm**\.

1. On the **Create alarm** page, do the following:

   1. For **Alarm name**, enter a name that helps you easily identify the alarm\.

   1. Configure the values that cause the alarm to be triggered\. For example, if you want to be notified when the blacklisted IP rate for your account is 5% or greater, choose **>=**\. Then enter a value of **5**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/deliverability_dashboard_blacklist_ip_alarms_threshold.png)

   1. Specify the amount of time that has to elapse before the alarm is triggered\. For example, you can configure the alarm so that it only sends a notification when the blacklisted IP rate exceeds a certain rate and stays at that rate for more than 2 hours\. In this example, next to **for at least**, enter a value of **2**\. Then, next to **consecutive period\(s\) of**, choose **1 hour**, as shown in the following image\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/deliverability_dashboard_blacklist_ip_alarms_period.png)

   1. Under **Notification method**, choose one of the following options:
      + **Use an existing SNS topic** – Choose this option if you've already created an Amazon SNS topic and subscribed endpoints to it\.
      + **Create a new topic** – Choose this option if you haven't yet created an Amazon SNS topic, or if you want to create a new topic\.
**Note**  
When you create a new topic, you have to subscribe one or more endpoints to it\. For more information, see [Subscribing an Endpoint to a Topic](https://docs.aws.amazon.com/sns/latest/dg/sns-tutorial-create-subscribe-endpoint-to-topic.html) in the *Amazon Simple Notification Service Developer Guide*\.

   1. \(Optional\) You can choose or create more than one Amazon SNS topic\. To add a topic, choose **Notify an additional SNS topic**\.

   1. When you finish, choose **Create**\.