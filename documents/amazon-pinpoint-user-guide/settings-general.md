# General Settings<a name="settings-general"></a>

Use the **General settings** page to specify when Amazon Pinpoint can send messages for campaigns and journeys in the current project and how many messages Amazon Pinpoint can send for those campaigns and journeys\. This includes settings such as the time frame for sending messages and the maximum number of messages to send to each endpoint\. You can also use the **General settings** page to delete a project\.

**Topics**
+ [Configuring Default Settings for a Project](#settings-general-campaigns)
+ [Deleting a Project](#settings-general-delete-project)

## Configuring Default Settings for a Project<a name="settings-general-campaigns"></a>

On the **General settings** page, you can configure default settings and quotas that you want to apply to campaigns and journeys in a project\. When you change these settings, Amazon Pinpoint automatically applies them to all new campaigns and journeys that you create for the project\. The settings aren't applied to any campaigns or journeys that you previously created\. You can also configure these same settings for individual campaigns and journeys\. If you configure settings for an individual campaign or journey, those settings override the settings that you choose on the **General settings** page\.

**To configure default settings for a project**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to change the default settings for\.

1. In the navigation pane, under **Settings**, choose **General settings**\.

1. Choose **Edit**\.

1. On the **Edit general settings** page, change any of the following settings:  
**Quiet time hours**  
Use these settings to prevent Amazon Pinpoint from sending messages during specific hours\. When you configure these settings, you provide a **Start time** and an **End time**\. If a message would be sent between the start and end times in an endpoint's local time zone, Amazon Pinpoint doesn't attempt to send the message to that endpoint\.  
In order for this setting to observe local time zones, the endpoint definition for a recipient has to include a properly\-formatted `Demographic.Timezone` attribute\.
The times that you specify have to use 24\-hour notation and be in *HH:MM* format\. For example, for 9:30 PM, enter **21:30**\.  
**Maximum number of daily messages per endpoint**  
Use this setting to specify the maximum number of messages that can be sent to a single endpoint during a 24\-hour period by all the campaigns and journeys in the project\. The value that you specify can't be larger than 100\.  
**Maximum number of messages per endpoint**  
Use this setting to specify the maximum number of messages that can be sent to a single endpoint by each campaign or journey\. If a campaign recurs, this setting applies to all runs of the campaign\. The value that you specify can't be larger than 100\.  
This setting considers the number of messages that *target* an endpoint, as opposed to the number of messages that are actually *delivered* to an endpoint\. For example, if a campaign is configured to automatically send a message when a customer creates a new account, but the endpoint isn't able to receive the message \(for example, if the quiet time setting applies to the endpoint\), then the endpoint is still counted as having been targeted\. In this situation, the endpoint would be removed from subsequent runs of the campaign\.  
**Maximum number of messages per second**  
Use this setting to specify the maximum number of messages that can be sent each second by a campaign or journey\. The value that you specify has to be a number between 50 and 20,000\.  
**Maximum amount of time for a campaign run**  
Use this setting to specify the maximum amount of time, in seconds, that a campaign can attempt to deliver a message after the scheduled start time\. The minimum value for this setting is 60 seconds\.

1. When you finish, choose **Save**\.

## Deleting a Project<a name="settings-general-delete-project"></a>

If you want to remove a project from Amazon Pinpoint completely, you can delete the project by using the Amazon Pinpoint console\.

**Warning**  
If you delete a project, Amazon Pinpoint deletes all project\-specific settings, campaigns, journeys, and other information for the project\. The information can't be recovered\.

When you delete a project, Amazon Pinpoint deletes all project\-specific settings for the push notification and two\-way SMS messaging channels, and all segments, campaigns, journeys, and project\-specific analytics data that's stored in Amazon Pinpoint, such as the following:
+ Segments – All segment settings and data\. For dynamic segments, this includes segment groups and filters that you defined\. For imported segments, this includes endpoints, user IDs, and other data that you imported, and any filters that you applied\.
+ Campaigns – All messages, message treatments and variables, analytics data, schedules, and other settings\.
+ Journeys – All activities, analytics data, schedules, and other settings\.
+ Analytics – Data for all engagement metrics, such as the number of messages sent and delivered for campaigns and journeys, and all journey execution metrics\. For mobile and web apps, all event data that wasn’t streamed to another AWS service such as Amazon Kinesis, all funnels, and data for application usage, revenue, and demographic metrics\. Before you delete a project, we recommend that you export this data to another location\. For more information, see [Exporting Dashboards](analytics-charts.md#analytics-exporting)\.

Note that account\-level settings and data for your Amazon Pinpoint account and your AWS account aren't deleted\. This includes:
+ Message templates\.
+ Production access and sending quotas for channels\.
+ Dedicated phone numbers for sending SMS and voice messages, and for receiving SMS messages\.
+ Verified identities for sending email and SMS messages\.
+ SMS information such as short codes, long codes, keywords, and registered sender IDs for sending SMS messages\.
+ SMTP credentials and other settings for sending email by using the Amazon Pinpoint SMTP interface\.
+ Configuration settings for connecting to and using machine learning models\.

In addition, data that's stored in other AWS services isn't deleted\. This includes event data that you streamed to other AWS services such as Amazon Kinesis, files that you imported from an Amazon Simple Storage Service \(Amazon S3\) bucket to define a segment, and any Amazon Pinpoint metrics and spending alarms that you configured in Amazon CloudWatch\.

**To delete a project**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to delete\.

1. In the navigation pane, under **Settings**, choose **General settings**\.

1. Choose **Delete project**\.

1. Enter the name of the project that you want to delete, and then choose **Ok**\.