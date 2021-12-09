# Warming Up Dedicated IP Addresses<a name="channels-email-dedicated-ips-warming"></a>

When determining whether to accept or reject a message, email service providers consider the reputation of the IP address that sent it\. One of the factors that contributes to the reputation of an IP address is whether the address has a history of sending high\-quality email\. Email providers are less likely to accept mail from new IP addresses that have little or no history\. Email sent from IP addresses with little or no history might end up in recipients' junk mail folders, or might be blocked altogether\.

When you start sending email from a new IP address, you should gradually increase the amount of email you send from that address before using it to its full capacity\. This process is called *warming up* the IP address\.

The amount of time that's required to warm up an IP address varies between email providers\. For some email providers, you can establish a positive reputation in around two weeks, while for others it might take up to six weeks\. When warming up a new IP address, you should send emails to your most active users to ensure that your complaint rate remains low\. You should also carefully examine your bounce messages and send less email if you receive a high number of blocking or throttling notifications\. 

## Automatically Warm Up Dedicated IP Addresses<a name="channels-email-dedicated-ips-auto-warm-up"></a>

When you request dedicated IP addresses, Amazon Pinpoint automatically warms them up to improve the delivery of emails you send\. The automatic IP address warm\-up feature is enabled by default\. 

The steps that happen during the automatic warm\-up process depend on whether you already have dedicated IP addresses:
+ When you request dedicated IP addresses for the first time, Amazon Pinpoint distributes your email sending between your dedicated IP addresses and a set of addresses that are shared with other Amazon Pinpoint customers\. Amazon Pinpoint gradually increases the number of messages sent from your dedicated IP addresses over time\.
+ If you already have dedicated IP addresses, Amazon Pinpoint distributes your email sending between your existing dedicated IPs \(which are already warmed up\) and your new dedicated IPs \(which aren't warmed up\)\. Amazon Pinpoint gradually increases the number of messages that are sent from your new dedicated IP addresses over time\.

After you warm up a dedicated IP address, you should send around 1,000 emails every day to each email provider that you want to maintain a positive reputation with\. You should perform this task on each dedicated IP address that you use with Amazon Pinpoint\. 

You should avoid sending large volumes of email immediately after the warm\-up process is complete\. Instead, slowly increase the number of emails you send until you reach your target volume\. If an email provider sees a large, sudden increase in the number of emails being sent from an IP address, they might block or throttle the delivery of messages from that address\.