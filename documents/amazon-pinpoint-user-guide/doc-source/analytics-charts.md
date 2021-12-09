# Chart Reference for Amazon Pinpoint Analytics<a name="analytics-charts"></a>

The **Analytics** pages on the Amazon Pinpoint console provide overviews of key metrics\. They also provide dashboards that give details about campaigns, demographics, funnels, usage, revenue, and more\. You can filter these dashboards by date for further analysis\. You can also filter some dashboards by other attributes, such as event or channel attributes\.

**Topics**
+ [Endpoints and Users in Amazon Pinpoint Analytics](#analytics-endpoints-users)
+ [Exporting Dashboards](#analytics-exporting)
+ [Overview Charts](analytics-overview.md)
+ [Usage Charts](analytics-usage.md)
+ [Revenue Charts](analytics-revenue.md)
+ [Events Charts](analytics-events.md)
+ [Demographics Charts](analytics-demographics.md)
+ [Campaign Charts](analytics-campaigns.md)
+ [Transactional Messaging Charts](analytics-transactional-messages.md)

## Endpoints and Users in Amazon Pinpoint Analytics<a name="analytics-endpoints-users"></a>

Some of the charts and metrics in these dashboards provide data about *endpoints*\. Others provide data about *users*\.

An *endpoint* is a destination that you can send messages to—such as a user's mobile device, email address, or phone number\. Before you can see data about endpoints, your application must register endpoints with Amazon Pinpoint, or you must import your endpoint definitions into Amazon Pinpoint\.

A *user* is an individual who has a unique user ID\. This ID can be associated with one or more endpoints\. For example, if a person uses your app on more than one device, your app could assign that person's user ID to the endpoint for each device\. Before you can see data about users, your application must assign user IDs to endpoints, or you must import endpoint definitions that include user IDs\.

For information about registering endpoints and assigning user IDs within a mobile app, see [Registering Endpoints in Your Application](https://docs.aws.amazon.com/pinpoint/latest/developerguide/integrate-endpoints.html) in the *Amazon Pinpoint Developer Guide*\. For information about registering endpoints and assigning user IDs for other types of applications, see [Adding Endpoints to Amazon Pinpoint](https://docs.aws.amazon.com/pinpoint/latest/developerguide/audience-define-endpoints.html) in the *Amazon Pinpoint Developer Guide*\. For information about importing endpoint definitions, see [Importing Segments](segments-importing.md)\.

## Exporting Dashboards<a name="analytics-exporting"></a>

You can export data from the dashboards that appear on the **Analytics** pages of the Amazon Pinpoint console\. When you export data from a dashboard, Amazon Pinpoint creates a \.zip file that contains a comma\-separated values \(\.csv\) file with the data for each section of the dashboard\. You can open these \.csv files by using any modern spreadsheet or data analysis application\. 

To export data from a dashboard, choose a date range for the data \(and other attributes, if applicable\), and then choose **Download CSV**\. 