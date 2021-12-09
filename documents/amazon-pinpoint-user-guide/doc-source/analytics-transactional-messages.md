# Transactional Messaging Charts<a name="analytics-transactional-messages"></a>

The **Transactional messaging** page provides charts and metrics that show how many transactional messages you've sent, and helps you measure recipients' responses to those messages\. For example, this page shows the number of transactional email messages that were delivered, opened, clicked, bounced, or reported as spam\.

**Note**  
The data on this page only includes information about transactional messages\. It doesn't include information about messages that you sent by using campaigns\. To see the data for messages that were sent by campaigns, use the [Campaigns charts](analytics-campaigns.md)\. In addition, it can take up to two hours for new data to appear on this page\.

## Viewing the Transactional Messaging Charts<a name="analytics-transactional-messages-view"></a>

Complete the following steps to view the **Transactional messaging** charts and metrics on the Amazon Pinpoint console\. You can filter the data by channel and by date\.

**To view and filter the Transactional messaging charts and metrics**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to view transactional messaging data for\.

1. In the navigation pane, under **Analytics**, choose **Transactional messaging**\.

1. Use the menu at the top of the page to choose whether to display data for transactional **Email** or **SMS** messages, as shown in the following image:  
![\[\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/analytics-transactional-messaging-channel-selector.png)

1. \(Optional\) To apply a filter that displays the data for a specific date or range of dates, use the date selector at the top of the page to choose the dates for the time period that you want\. After you choose new dates, the page updates to show the data for the selected time period\.

## Chart Descriptions<a name="analytics-transactional-messages-description"></a>

The **Transactional messaging** page contains several charts and metrics that provide information about how recipients have responded to the transactional email and SMS messages that you sent during the selected time period\. 

### Transactional SMS Charts<a name="analytics-transactional-messages-sms"></a>

When you use the channel selector to display the data for transactional SMS messages, you see the following charts and metrics:

**Sends**  
Shows the number of messages that you sent:  
+ Average – The average number of messages that were sent each day of the selected time period\.
+ Total – The total number of messages that were sent during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were sent on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were sent on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were sent on each day of the selected time period\.

**Deliveries**  
Shows the number of messages that were delivered to recipients:  
+ Average – The average number of messages that were delivered each day of the selected time period\.
+ Total – The total number of messages that were delivered during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were delivered on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were delivered on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were delivered on each day of the selected time period\.  
There are several factors that could cause these values to differ from the average and total number of messages that were sent\. For example, if you send an SMS message to a phone number that doesn't exist, it is counted as sent, but not delivered\.

**Delivery rate**  
Shows the average percentage of messages that were sent and delivered to recipients during the selected time period\. Amazon Pinpoint calculates the average delivery rate by first calculating the daily delivery rate for each day of the time period\. \(The daily delivery rate is the number of messages that were delivered on a certain day divided by the number of messages that were sent on that day\.\) Amazon Pinpoint then calculates the sum of the daily delivery rates, and divides the sum by the number of days in the time period\.  
This section also shows the percentage of change between the daily delivery rates for the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were delivered on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero percent \(`0%`\) for the first day of the time period\.  
The chart shows the delivery rate for each day of the selected time period\.

**Messages by country or region**  
Lists all the countries that you sent messages to during the selected time period\. For each country, this table shows the number of messages that you sent to recipients in that country \(**Messages sent**\), the number of messages that were delivered to recipients in that country \(**Messages delivered**\), and the average price that you paid for each message that you sent to a recipient in that country \(**Average price**\)\.

**Message delivery errors**  
Shows the number of errors that occurred as a result of the messages that you sent during the selected time period\. To view a list of all the types of errors that occurred, expand the **Show all SMS errors** section\. For each error, this section shows the number of times that the error occurred during the selected time period \(**Total over period**\), the average number of times that the error occurred for each day \(**Average over period**\), and the percentage of change between the number of errors that occurred on the first and last days of the time period \(**Change over period**\)\.

### Transactional Email Charts<a name="analytics-transactional-messages-email"></a>

When you use the channel selector to view the data for transactional email messages, you see the following charts and metrics:

**Sends**  
Shows the number of messages that were sent:  
+ Average – The average number of messages that were sent each day of the selected time period\.
+ Total – The total number of messages that were sent during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were sent on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were sent on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were sent on each day of the selected time period\.

**Deliveries**  
Shows the number of messages that were delivered to recipients:   
+ Average – The average number of messages that were delivered each day of the selected time period\.
+ Total – The total number of messages that were delivered during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were delivered on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were delivered on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were delivered on each day of the selected time period\.  
There are several factors that could cause these values to differ from the average and total number of messages that were sent\. For example, if a message bounces, it is counted as sent, but not delivered\.

**Opens**  
Shows the number of messages that were opened by recipients:   
+ Average – The average number of messages that were opened each day of the selected time period\.
+ Total – The total number of messages that were opened during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were opened on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were opened on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were opened on each day of the selected time period\.  
Amazon Pinpoint adds a very small, transparent image to the end of each transactional message that you send\. When a recipient opens a message that contains one of these images, their email client downloads the image from our servers\. We count the message as opened\. If a recipient opens the same message more than once, we count each of those opens separately\.

**Clicks**  
Shows the number of times that recipients clicked links in the messages:   
+ Average – The average number of clicks that occurred each day of the selected time period\.
+ Total – The total number of clicks that occurred during the selected time period\.
+ Change over period – The percentage of change between the number of clicks that occurred on the first and last days of the selected time period\. If this value is an em dash \(—\), no clicks occurred on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of clicks that occurred on each day of the selected time period\.  
When you send a message that contains links, Amazon Pinpoint replaces those links with links that refer to our servers\. When a recipient clicks one of these links, we redirect the recipient to the intended location, and count the click\. If a single recipient clicks multiple links in a message, or clicks the same link more than once, each click is counted as a separate event\.

**Complaints**  
Shows the number of messages that were reported as spam by recipients:   
+ Average – The average number of messages that were reported as spam on each day of the selected time period\.
+ Total – The total number of messages that were reported as spam during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were reported as spam on the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were reported as spam on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of messages that were reported as spam on each day of the selected time period\.  
When a recipient applies **Mark as Spam** or a similar function to a message by using their email client, the recipient's email provider notifies us that the message was reported as spam\.

**Delivery rate**  
Shows the average percentage of messages that were sent and delivered to recipients during the selected time period\. Amazon Pinpoint calculates the average delivery rate by first calculating the daily delivery rate for each day of the time period\. \(The daily delivery rate is the number of messages that were delivered on a certain day divided by the number of messages that were sent on that day\.\) Amazon Pinpoint then calculates the sum of the daily delivery rates and divides the sum by the number of days in the time period\.  
This section also shows the percentage of change between the daily delivery rates for the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were delivered on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero percent \(`0%`\) for the first day of the time period\.

**Bounce rate**  
Shows the average percentage of messages that bounced during the selected time period\. Amazon Pinpoint calculates the average bounce rate by first calculating the daily bounce rate for each day in the time period that you selected\. \(The daily bounce rate is the number of messages that bounced on a certain day divided by the number of messages that were sent on that day\.\) Amazon Pinpoint then calculates the sum of the daily bounce rates and divides the sum by the number of days in the time period\.  
This section also shows the percentage of change between the daily bounce rates for the first and last days of the selected time period\. If this value is an em dash \(—\), no messages bounced on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero percent \(`0%`\) for the first day of the time period\.

**Complaint rate**  
Shows the average percentage of messages that were reported as spam by recipients during the selected time period\. Amazon Pinpoint calculates the average complaint rate by first calculating the daily complaint rate for each day in the time period that you selected\. \(The daily complaint rate is the number of messages that were reported as spam on a certain day divided by the number of messages that were sent on that day\.\) Amazon Pinpoint then calculates the sum of the daily complaint rates and divides the sum by the number of days in the time period\.  
This section also shows the percentage of change between the daily complaint rates for the first and last days of the selected time period\. If this value is an em dash \(—\), no messages were reported as spam on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero percent \(`0%`\) for the first day of the time period\.

**Unique user events**  
Shows the number of unique recipients who opened messages \(**Unique message opens**\) and clicked links in messages \(**Unique message clicks**\):  
+ Average – The average number of open or click events that occurred on each day of the selected time period\.
+ Total – The total number of open or click events that occurred during the selected time period\.
+ Change over period – The percentage of change between the number of open or click events that occurred on the first and last days of the selected time period\. If this value is an em dash \(—\), no open or click events occurred on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
The chart shows the total number of unique recipients that opened messages and clicked links in messages on each day of the selected time period\.  
Unlike the **Opens** and **Clicks** metrics, these metrics show the number of unique recipients who opened messages or clicked links in messages, as opposed to the total number of messages that were opened and click events that occurred\. In other words, if a single user opens a message five times, the **Opens** chart would show five open events, but this chart would show only one open event\.

**Bounce and complaint events**  
Shows the number of soft bounces, hard bounces, and complaints that occurred on each day of the selected time period\. Soft bounces are usually temporary in nature\. For example, if the recipient's inbox is full or their mail server is temporarily offline when we attempt to deliver a message, we count it as a soft bounce\. Hard bounces are permanent\. For example, if a recipient's email address doesn't exist or their mail server doesn't accept messages from your domain, we count it as a hard bounce\.