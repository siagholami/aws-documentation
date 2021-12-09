# Events Charts<a name="analytics-events"></a>

The charts and metrics on the **Events** page help you see trends by displaying data for one or more types of events and event attributes\. You can filter the data on the page to show any event that your application reports to Amazon Pinpoint\.

## Viewing the Events Charts<a name="analytics-events-view"></a>

Complete the following steps to view the **Events** charts and metrics on the Amazon Pinpoint console\. You can filter the data by date, event, and endpoint attributes\.

**To view and filter the Events charts and metrics**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to view event data for\.

1. In the navigation pane, under **Analytics**, choose **Events**\.

1. \(Optional\) To apply a filter that displays the data for a specific date or range of dates, use the date selector at the top of the page to choose the dates for the time period that you want\. After you choose new dates, the page updates to show the data for the selected time period\.

1. \(Optional\) To apply additional filters, expand the **Filters** section\.
**Note**  
To provide you with the best possible experience, we hide these filters if you haven't used them in the past 90 days\.  
If the **Filters** section shows a message stating that the filters are unavailable, choose **More information**, and then choose **Enable filters**\. When you do, we restore the filters for your account in the current AWS Region\. Depending on the amount of data that's associated with your account, this process can take up to 72 hours to complete\.

   If the additional filters are available, do any of the following:
   + To apply a filter that displays the data for only a specific type of event, choose the event type from the **Event** list\. After you choose an event type, choose event attributes or metrics and a value from the **Event Attributes and Metrics** and **Event Attribute Values** lists\.

     The **Event** list displays the types of events that your app reported during the past 14 days\. If your app didn't report any events during that time period, only the **All event types** option is available and you can't filter the data by a specific type of event\.
   + To apply a filter that displays data for only those endpoints that have a specific attribute, choose the attribute from the **Endpoint Attributes** list\. After you choose an attribute, choose an attribute value from the **Endpoint Attribute Values** list\.

   To further filter the data, repeat this step for each additional event or attribute that you want to filter the data by\.

## Chart Descriptions<a name="analytics-events-description"></a>

The **Events** page includes the following sections:

**Event count**  
This chart displays the number of events that were reported by your app for each day in the selected time period\. This chart also provides the average number of events per day, the total number of events in the time period, and the percentage change in the number of events from the beginning to the end of the time period\.

**Endpoint count**  
This chart displays the number of endpoints that reported the selected event for each day in the selected time period\. This chart also provides the average number of endpoints that reported the event each day, the total number of endpoints that reported the event each day, and the percentage change in the number of endpoints that reported the event from the beginning to the end of the time period\.

**Events per session**  
This chart displays the average number of events that occurred in each app session for each day in the selected time period\. Amazon Pinpoint calculates this metric by dividing the number of times the selected event occurred each day by the number of sessions that occurred that day\.  
This chart also provides the average number of events per session for the entire time period, and the percentage change in the number of events per session from the beginning to the end of the time period\.