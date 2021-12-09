# Transactional Messaging Charts<a name="analytics-transactional-email"></a>

The **Transactional Messaging** page contains charts that show you how many transactional emails you've sent\. It also includes charts that help you measure your recipients' responses to your transactional emails—that is, the number of messages that were delivered, opened, clicked, or that bounced or were reported as spam\.

## Viewing the Transactional Email Charts<a name="analytics-transactional-email-view"></a>

You can view the **Transactional Messaging** charts in the Amazon Pinpoint console\. You can filter the charts on this page by date\.

**To view and filter the Transactional Messaging charts**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **Pinpoint Projects** page, choose the project that you want to view transactional email metrics for\.

1. In the navigation pane, under **Analytics**, choose **Transactional Messaging**\.

1. \(Optional\) To filter the charts by a specific date or range of dates, choose **Last 30 days**, and then specify a date range\.

## Chart Descriptions<a name="analytics-transactional-email-description"></a>

The Transactional Messaging page contains several charts that provide information about how your recipients have responded to the transactional emails that you've sent in the time period you selected\. These charts are discussed in greater detail below\.

**Note**  
These charts only include information about transactional emails\. They don't include information about emails that you sent by using campaigns\. For metrics related to emails sent from campaigns, see the [Campaigns charts](analytics-campaigns.md)\.

### Sends and Responses<a name="analytics-transactional-email-responses"></a>

**Sends**  
The total number of transactional email messages you sent in the time period you selected\.

**Deliveries**  
The number of transactional email messages that were delivered to their recipients in the time period\. There are several factors that could cause this value to differ from the number of emails that were sent\. For example, if an email bounces, it is counted as sent, but not delivered\.

**Opens**  
The number of transactional messages that were received by their recipients and opened\. Amazon Pinpoint adds a very small, transparent image to the end of each transactional message you send\. When a recipient opens an email that contains one of these images, their email client downloads the image from our servers, and we count the message as opened\. If a recipient opens the same message more than once, we count each of those opens separately\.

**Clicks**  
The number of transactional messages that contained links that were clicked by their recipients\. When you send a transactional email that contains links, Amazon Pinpoint replaces those links with links that refer to our servers\. When a recipient clicks one of these links, we redirect the recipient to their intended location, and count the message as clicked\. If a recipient clicks a link in the same message more than once, or clicks multiple links in the same message, we count each of those clicks separately\.

**Complaints**  
The number of transactional messages that were reported by their recipients as spam\. When a recipient uses the **Mark as Spam** or similar function in their email client, the recipient's email provider notifies us that the message was reported\.

### Rates<a name="analytics-transactional-email-rates"></a>

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/analytics-transactional-messaging-rates.png)

This section provides rates for deliveries, bounces, and complaints\. For each rate, we divide the number of events that occurred for that metric in the time period by the number of messages that you sent in the same period\. For example, if you sent 10 emails in a given time period and 8 were delivered, this section shows a **Delivery rate** of 80%\.

Each part of this section also shows an **Average** rate\. To calculate this value, we calculate the rate for each day in the selected time period, and then calculate the average of those values\. For example, assume you were analyzing a period of three days, and your delivery rates for each of those three days were 78%, 79%, and 83%\. In this example, the daily average rate is 80%\.

Each part of this section also shows the percentage change in the daily rate from the first day of the time period to the last \(**Change over period**\)\. We calculate this value by subtracting the daily rate on the first day from the rate on the last day, and then dividing the difference by the value on the first day\. If the value on the first day was 0%, we show a dash \(—\) in this section, because it isn't possible to calculate a percentage change when the first value is 0\.

### Unique User Events and Bounce and Complaint Events<a name="analytics-transactional-email-unique-bounce-complaint"></a>

This section contains the following charts, which help compare certain response metrics in a single chart:

**Unique recipient metrics**  
This chart shows the numbers of opens and clicks for the time period you selected\. Unlike the Opens and Clicks charts described in [the Sends and Responses section](#analytics-transactional-email-responses), these charts show the numbers of recipients who opened or clicked messages, as opposed to the number of open and click events that occurred\. In other words, if a single user opens a message five times, we only count one open in this chart\.

**Bounce and complaint metrics**  
This chart shows the numbers of soft bounces, hard bounces, and complaints that occurred on each day of the selected time period\. Soft bounces are usually temporary in nature—for example, if the recipient's inbox is full or their mail server is temporarily offline when we attempt to deliver the message, we count it as a soft bounce\. Hard bounces are permanent\. For example, if a recipient's email address doesn't exist or their mail server doesn't accept mail from your domain, we count it as a hard bounce\.