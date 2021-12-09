# Campaign Charts<a name="analytics-campaigns"></a>

The charts and metrics on the **Campaigns** page provide information about all the campaigns for a project\. You can also choose a specific campaign to view additional delivery and engagement metrics for that campaign\.

## Viewing the Campaign Charts<a name="analytics-campaigns-view"></a>

Complete the following steps to view the **Campaigns** charts and metrics on the Amazon Pinpoint console\. You can filter the data by date\.

**To view and filter the Campaigns charts and metrics**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to view campaign data for\.

1. In the navigation pane, under **Analytics**, choose **Campaigns**\.

1. \(Optional\) To apply a filter that displays the data for a specific date or range of dates, use the date selector at the top of the page to choose the dates for the time period that you want\. After you choose new dates, the page updates to show the data for the selected time period\.

## Chart Descriptions<a name="analytics-campaigns-description"></a>

The **Campaigns** page includes sections that provide aggregated charts and metrics for all the campaigns that were active during the selected time period\. It also includes a table that lists all of those campaigns\. When you choose a specific campaign from the table, you see a new set of charts and metrics with data that's specific to that campaign\.

### Aggregated Campaign Metrics<a name="analytics-campaigns-description-aggregated"></a>

The **Campaigns** page includes the following charts and metrics, which are aggregated across all the campaigns that were active during the selected time period\.

**Active targetable endpoints**  
Shows the total number of *targetable endpoints*\. A targetable endpoint is an endpoint that has opened your application at least once during the past 30 days and has opted in to receiving messages from you through at least one channel\. This section displays the total number of active targetable endpoints across all channels, and the number of active targetable endpoints for each channel—for example, push notifications, email, and SMS\.

**Campaigns**  
Shows the total number of campaigns that are currently active\. For the selected time period, this section also shows the number of endpoints that received messages from you, and the delivery, open, and opt\-out rates for those messages\. The **Endpoint deliveries** area shows the number of unique endpoints that received messages from the campaigns\.

### Metrics for Individual Campaigns<a name="analytics-campaigns-description-individual"></a>

When you select a campaign from the table of campaigns, you see charts and metrics that are specific to that campaign\. The charts and metrics that you see depend on the type of channel that the campaign used\.

**Note**  
If you select an A/B test campaign, you see the charts and metrics listed in the following sections for each treatment\. This report makes it easy to compare the effectiveness of various treatments for a campaign\.

#### Email Campaigns<a name="analytics-campaigns-description-individual-email"></a>

When you select a standard campaign that uses the email channel, you see the following charts and metrics\.

**Delivery count metrics**  
This section provides the following charts and metrics that relate to the number of messages that were sent and delivered for this campaign:    
**Messages sent**  
The number of messages that were sent\.  
**Messages delivered**  
The number of messages that were delivered to their intended recipients\. Amazon Pinpoint calculates this number by subtracting the number of messages that hard bounced from the number of messages that were sent\.  
**Links clicked**  
The number of times that recipients clicked links in the message\. If a single recipient clicks multiple links in a message, or clicks the same link more than once, each click is counted as a separate event\.  
**Endpoint deliveries**  
The average number of unique email endpoints that the message was delivered to on each day\. The chart shows the number of unique email endpoints that the message was delivered to, for each day in the selected time period\.

**Delivery rate metrics**  
This section provides the following metrics that relate to the delivery of messages from this campaign:    
**Delivery rate**  
The percentage of messages that were delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing the number of messages that were delivered by the number of messages that were sent\.  
**Email open rate**  
The percentage of messages that were opened by their intended recipients\. Amazon Pinpoint calculates this rate by dividing the number of messages that were opened by the number of messages that were delivered\.  
**Bounce rate**  
The percentage of messages that couldn't be delivered to their intended recipients\. This metric only measures *hard bounces*—that is, messages in which the recipient's email address had a permanent issue that prevented the message from being delivered\. Amazon Pinpoint calculates this rate by dividing the number of bounced messages by the number of messages sent\.

**Campaign runs**  
This section provides the following metrics that relate to the timing and delivery of your messages each time this campaign ran:    
**Run date**  
The date and time when the campaign run was sent\.  
**Endpoints targeted**  
The number of unique endpoints that you attempted to send the message to as part of the campaign run\.  
**Messages sent**  
The number of messages that were sent during the campaign run\. This number might differ from the number of endpoints targeted if the targeted segment included email addresses that were formatted incorrectly or were known to produce hard bounces\. This number also omits endpoints that opted out\.  
**Messages delivered**  
The number of messages that were sent from the campaign run and delivered to their intended recipients\.  
**Delivery rate**  
The percentage of messages that were sent from the campaign run and delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing **Messages delivered** by **Messages sent**\.  
**Total email opened**  
The number of messages that were sent from the campaign run and opened by their intended recipients\. Due to technical limitations, this value only includes recipients who opened the message by using an email client that supports images\.  
**Email open rate**  
The percentage of messages that were sent from the campaign run and opened by their intended recipients\. Amazon Pinpoint calculates this rate by dividing **Total email opened** by **Messages delivered**\.  
**Bounce rate**  
The percentage of messages that were sent from the campaign run and couldn't be delivered to their intended recipients\. This metric measures only hard bounces\. Amazon Pinpoint calculates this rate by dividing the number of messages that bounced during the campaign run by **Messages delivered**\.

#### Push Notification Campaigns<a name="analytics-campaigns-description-individual-push"></a>

When you select a standard campaign that sends push notifications, you see the following charts and metrics\.

**Campaign delivery counts**  
This section provides the following charts and metrics that relate to the number of push notifications that were sent and delivered for this campaign:    
**Messages sent**  
The number of push notifications that were sent\.  
**Messages delivered**  
The number of push notifications that were delivered to their intended recipients\. Amazon Pinpoint calculates this number by subtracting the number of notifications that couldn't be delivered from the total number of notifications that you sent\.  
**Endpoint deliveries**  
The average number of unique push\-notification endpoints that the message was delivered to on each day\. The chart shows the number of unique push\-notification endpoints that the message was delivered to, for each day in the selected time period\.

**Campaign engagement rates**  
This section provides the following charts and metrics that relate to delivery and engagement rates for the push notifications that were sent by this campaign:    
**Delivery rate**  
The percentage of push notifications that were delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing the number of push notifications that were delivered by the number of push notifications that were sent\.  
**Push open rate**  
The percentage of push notifications that were opened by their intended recipients\. Amazon Pinpoint calculates this rate by dividing the number of recipients who opened push notifications from you by the number of push notifications that were delivered to their intended recipients\.

**Campaign sessions**  
This section provides the following charts and metrics that relate to the number of times that your app was opened by unique endpoints within 24 hours of receiving a push notification from this campaign:    
**Total sessions**  
The number of times that your app was opened by endpoints during the selected time period\.  
**Sessions per endpoint**  
Shows the number of times that your app was opened by unique endpoints within 24 hours of receiving the push notification from the campaign, for each day in the selected time period\.  
**Campaign session heat map**  
Shows the days and times when users opened your app after receiving the push notification from the campaign\. Darker rectangles represent greater numbers of users\. Times are based on each user's local time zone\.

**Campaign units sold**  
This section provides the following charts and metrics that relate to the number of units that were purchased by unique endpoints within 24 hours of receiving a push notification from this campaign:    
**Total units sold**  
The number of units that were purchased by endpoints during the selected time period\.  
**Units sold per endpoint**  
Shows the number of purchases that were made by unique endpoints within 24 hours of receiving the push notification from the campaign, for each day in the analysis period\.

**Campaign runs**  
This section provides the following metrics that relate to the timing and delivery of your push notifications each time this campaign ran:    
**Run date**  
The date and time when the campaign run was sent\.  
**Endpoints targeted**  
The number of unique endpoints that you attempted to send the push notification to as part of the campaign run\.  
**Messages sent**  
The number of push notifications that were sent during the campaign run\. This number might differ from the number of endpoints targeted, if the targeted segment included invalid tokens or endpoints that opted out\.  
**Messages delivered**  
The number of push notifications that were sent from the campaign run and were delivered to their intended recipients\.  
**Delivery rate**  
The percentage of push notifications that were sent from the campaign run and delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing **Messages delivered** by **Messages sent**\.  
**Total push opened**  
The number of push notifications that were sent from the campaign run and opened by their intended recipients\.  
**Push open rate**  
The percentage of push notifications that were sent from the campaign run and opened by their intended recipients\. Amazon Pinpoint calculates this rate by dividing **Total push opened** by **Messages delivered**\.

#### SMS Campaigns<a name="analytics-campaigns-description-individual-sms"></a>

When you select a standard campaign that uses the SMS channel, you see the following charts and metrics\.

**Delivery metrics**  
This section provides the following metrics that relate to the delivery of messages from this campaign:    
**Messages sent**  
The number of messages that were sent\.  
**Messages delivered**  
The number of messages that were delivered to their intended recipients\. Amazon Pinpoint calculates this number by subtracting the number of messages that couldn't be delivered from the number of messages that were sent\.  
**Delivery rate**  
The percentage of messages that were delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing the number of messages that were delivered by the number of messages that were sent\.  
**Endpoint deliveries**  
The average number of unique SMS endpoints that the message was delivered to on each day\. The chart shows the number of unique SMS endpoints that the message was delivered to, for each day in the selected time period\.

**Total SMS spend**  
This section shows the total amount of money, in USD, that you spent sending SMS messages for the campaign during the selected time period\.

**Campaign runs**  
This section provides the following metrics that relate to the timing and delivery of your messages each time this campaign ran:    
**Run date**  
The date and time when the campaign run was sent\.  
**Endpoints targeted**  
The number of unique endpoints that you attempted to send the message to as part of the campaign run\.  
**Messages sent**  
The number of messages that were sent during the campaign run\. This number might differ from the number of endpoints targeted if the targeted segment included invalid phone numbers or endpoints that opted out\.  
**Messages delivered**  
The number of messages that were sent from the campaign run and were delivered to their intended recipients\.  
**Delivery rate**  
The percentage of messages that were sent from the campaign run and were delivered to their intended recipients\. Amazon Pinpoint calculates this rate by dividing **Messages delivered** by **Messages sent**\.