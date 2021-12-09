# Enforcing DMARC policies on incoming email<a name="inbound-dmarc"></a>

Email domains use DNS records for security\. They protect your users from common attacks such as spoofing or phishing\. DNS records for domains often include DMARC TXT records, which are set by the domain owner that is sending the email\. DMARC TXT records include policies that specify actions to take when an email fails a DMARC check\. You can choose whether to enforce the DMARC policy on emails being sent to your organization\.

New Amazon WorkMail organizations have DMARC enforcement turned on by default\.

**To turn on DMARC enforcement**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. In the navigation pane, choose **Organization settings**\.

1. Choose **Advanced**\.

1. For **Inbound DMARC Settings**, choose **Edit**\. 

1. For **DMARC enforcement**, select **On**\.

1. Select the acknowledgment check box\.

1. Choose **Save**\.

**To turn off DMARC enforcement**
+ Follow steps 1\-8 in the previous section, but for step 6, choose **Off** instead of **On**\.

## Using email event logging to track DMARC enforcement<a name="logging-dmarc"></a>

Turning on DMARC enforcement might result in inbound emails being dropped or marked as spam, depending on how the sender configured their domain\. If a sender misconfigures their email domain, your users might stop receiving legitimate emails\. To check for emails that aren't being delivered to your users, you can enable email event logging for your Amazon WorkMail organization\. Then, you can query your email event logs for inbound emails that are filtered out based on the sender's DMARC policies\. 

Before you use email event logging to track DMARC enforcement, enable email event logging in the Amazon WorkMail console\. To get the most out of your log data, allow some time to pass while email events are logged\. For more information and instructions, see [Turning on email event logging](tracking.md#enable-tracking)\.

**To use email event logging to track DMARC enforcement**

1. In the CloudWatch Insights console, under **Logs**, choose **Insights**\. 

1. For **Select log group\(s\)**, select your Amazon WorkMail organization's log group\. For example, /aws/workmail/events/organization\-alias\.

1. Select a time period to query\.

1. Run the following query: **stats count\(\) by event\.dmarcPolicy \| filter event\.dmarcVerdict == "FAIL"**

1. Choose **Run query**\.

You can also set up custom metrics for these events\. For more information, see [Creating metric filters](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/MonitoringPolicyExample.html)\.