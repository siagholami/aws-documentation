# Overview Charts<a name="analytics-overview"></a>

The **Analytics overview** page contains several charts and metrics that provide an overview of endpoint, usage, and campaign responses for your project\. If you've sent transactional email messages for your project, this page also provides information about responses to those messages\.

## Viewing the Analytics Overview Charts<a name="analytics-overview-view"></a>

Complete the following steps to view the charts and metrics on the **Analytics overview** page of the Amazon Pinpoint console\. You can filter the data by date\.

**To view and filter the Analytics overview charts and metrics**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to view analytics data for\.

1. In the navigation pane, choose **Analytics**\.

1. \(Optional\) To apply a filter that displays the data for a specific date or range of dates, use the date selector at the top of the page to choose the dates for the time period that you want\. After you choose new dates, the page updates to show the data for the selected time period\.

## Chart Descriptions<a name="analytics-overview-description"></a>

The **Analytics overview** page contains three sections: [App analytics](#analytics-overview-description-app-analytics), [Campaign analytics](#analytics-overview-description-campaign-analytics), and [Transactional email](#analytics-overview-description-transactional-email-analytics)\.

### App analytics<a name="analytics-overview-description-app-analytics"></a>

The **App analytics** section contains some of the most commonly used metrics that are related to your app or project\.

**Daily active endpoints**  
Shows the number of endpoints that opened your app at least once in a 24\-hour period for each day in the selected time period\. This chart also provides the average number of daily active endpoints for the entire time period, and the percentage change in the number of daily active endpoints from the beginning to the end of the time period\.

**Monthly active endpoints**  
Shows the number of endpoints that opened your app at least once in the previous 30 days for each day in the selected time period\. This chart also provides the average number of monthly active endpoints for the entire time period, and the percentage change in the number of monthly active endpoints from the beginning to the end of the time period\.

**New endpoints**  
Shows the number of endpoints that were registered with Amazon Pinpoint for the first time, for each day in the selected time period\. This chart also provides the average number of new endpoints for the entire time period, and the percentage change in the number of new endpoints from the beginning to the end of the time period\.

**7\-day retention rate**  
Shows the percentage of users who opened your app 8 days ago, and then opened it again at some point during the following 7 days\. This chart also provides the average 7\-day retention rate for the entire time period, and the percentage change in the 7\-day retention rate from the beginning to the end of the time period\.

**Sessions**  
Shows the total number of times that your app was opened each day in the selected time period\. This chart also provides the average number of daily sessions for the entire time period, and the percentage change in the number of sessions from the beginning to the end of the time period\.

**Revenue**  
Shows the revenue, in USD, that was reported by your app for each day in the selected time period\. This chart also provides the total revenue for the entire time period, and the percentage change in the amount of revenue from the beginning to the end of the time period\.

### Campaign analytics<a name="analytics-overview-description-campaign-analytics"></a>

The **Campaign analytics** section contains several important metrics that can help you understand the success of your campaigns\. The metrics in this section provide aggregated metrics for all the campaigns in the current project\.

**Active targetable endpoints**  
Shows the number of endpoints that are opted in to receive messages from you through at least one channel, and the number of active targetable endpoints for each channel—for example, push notifications, email, and SMS\. For an app, this section also shows the number of endpoints that are opted in to receive messages from you and have opened your app during the past 30 days\.

**Campaigns**  
Shows information about the campaigns that were active during the selected time period\. This section includes the following information:    
**Active campaigns**  
The number of campaigns that are currently active\.  
**Messages delivered**  
The number of messages that were delivered to their intended recipients\. Amazon Pinpoint calculates this number by subtracting the number of messages that bounced from the number of messages that you sent\.  
**Delivery rate**  
The percentage of targeted endpoints that received messages from you\. Amazon Pinpoint calculates this rate by dividing the number of messages that were delivered to their intended recipients by the total number of messages that you sent\.  
**Opt\-out rate**  
The percentage of users who opted out after receiving messages from you\. Amazon Pinpoint calculates this rate by determining the number of messages that were received by their intended recipients and dividing that number by the number of recipients who received your message and opted out\. \(The recipients might have opted out by clicking an unsubscribe link in an email, or by replying to an SMS message with the keyword `STOP`\)\.   
**Email open rate**  
The percentage of recipients who opened messages from you\. Amazon Pinpoint calculates this rate by dividing the number of email messages that were sent and opened by their recipients by the number of messages that were received by their recipients\.  
**Push open rate**  
The percentage of push notifications that were opened by recipients\. Amazon Pinpoint calculates this rate by dividing the number of recipients who opened push notifications from you by the number of push notifications that were received by their recipients\.  
**Endpoint deliveries**  
The average number of unique endpoints that received messages from you on each day of the selected time period\. The chart shows the number of unique endpoints that received messages from you, for each day in the selected time period\.

### Transactional email<a name="analytics-overview-description-transactional-email-analytics"></a>

The **Transactional email** section contains a chart and metrics that provide information about responses to all the transactional email messages that you sent during the selected time period\. Note that this section doesn't include information about messages that you sent from campaigns or transactional messages that you sent through other types of channels\. In addition, it can take up to two hours for new data to appear in this section\.

**Sent**  
The number of transactional messages that were sent:  
+ Average – The average number of messages that were sent each day of the selected time period\.
+ Total – The total number of messages that were sent during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were sent on the first and last days of the selected time period\. If this value is an em dash \(—\), no transactional email messages were sent on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.

**Delivered**  
The number of transactional messages that were delivered to their intended recipients:  
+ Average – The average number of messages that were delivered each day of the selected time period\.
+ Total – The total number of messages that were delivered during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were delivered on the first and last days of the selected time period\. If this value is an em dash \(—\), no transactional email messages were delivered on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.

**Opened**  
The number of transactional messages that were opened by recipients:  
+ Average – The average number of messages that were opened each day of the selected time period\.
+ Total – The total number of messages that were opened during the selected time period\.
+ Change over period – The percentage of change between the number of messages that were opened on the first and last days of the selected time period\. If this value is an em dash \(—\), no transactional email messages were opened on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.

**Clicked**  
The number of times that recipients clicked links in transactional messages:  
+ Average – The average number of clicks that occurred each day of the selected time period\.
+ Total – The total number of clicks that occurred during the selected time period\.
+ Change over period – The percentage of change between the number of clicks that occurred on the first and last days of the selected time period\. If this value is an em dash \(—\), no clicks occurred on the first day of the time period\. Amazon Pinpoint can't calculate the percentage of change if the value is zero \(`0`\) for the first day of the time period\.
If a single recipient clicks multiple links in a message, or clicks the same link more than once, each click is counted as a separate click event\.