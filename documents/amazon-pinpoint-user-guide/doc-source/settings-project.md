# Managing Project Settings in Amazon Pinpoint<a name="settings-project"></a>

You can use the Amazon Pinpoint console to specify default settings for your project, such as the maximum number of messages that each campaign can deliver to your users\.

**To manage the default project settings**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **Projects** page, choose the project for which you want to manage settings\.

1. In the navigation menu, choose **Settings**\.

On the **Settings** page, under the **Project** tab, you can set the following options:
+ **Maximum number of messages a user can receive per day** – The number of messages that each campaign for the app can send to each user daily\.
+ **Maximum number of messages a user can receive for a campaign** – The total number of messages that each campaign for the app can send\.
+ **Maximum number of messages a campaign can send per second** – The number of messages per second that each campaign can send\. The minimum value is 50, and the maximum value is 20,000\.
+ **Maximum number of seconds a campaign can be running** – The amount of time, in seconds, in which each campaign attempts to deliver a message after its scheduled delivery time\. The minimum value is 60\.
+ **Quiet time** – The default quiet time for the app\. Each campaign for this app sends no messages during this time unless the campaign overrides the default with a quiet time of its own\.
+ **Abbreviated numbers** – Simplifies large numbers in the Amazon Pinpoint console\. For example, 10,534,534 will be represented as 10\.53 M\.

Under the **Event streams** tab, you can configure Amazon Pinpoint to stream app and campaign events to Amazon Kinesis\. For more information, see [Streaming App and Campaign Events with Amazon Pinpoint](analytics-streaming.md)\.

Under the **Channels** tab, you can manage the settings for your mobile push and email channels, and you can enable the SMS channel for your project\. To manage SMS settings, use the **Account settings** page\. For more information, see:
+ [Managing Mobile Push Channels with Amazon Pinpoint](channels-mobile-manage.md)
+ [Updating Email Settings](channels-email-manage-update.md)
+ [Managing Account Settings in Amazon Pinpoint](settings-account.md)