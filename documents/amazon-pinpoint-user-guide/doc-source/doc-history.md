# Document History for Amazon Pinpoint<a name="doc-history"></a>

The following table describes important changes in each release of the *Amazon Pinpoint User Guide* after December 2018\. For notification about updates to this documentation, you can subscribe to an RSS feed\.
+ **Latest documentation update:** April 30, 2020

| Change | Description | Date | 
| --- |--- |--- |
| [Regional availability](#doc-history) | Amazon Pinpoint is now available in the AWS GovCloud \(US\) Region\. | April 30, 2020 | 
| [Custom channels](#doc-history) | Your campaigns can now [send messages using custom channels](https://docs.aws.amazon.com/pinpoint/latest/userguide/channels-custom)\. | April 23, 2020 | 
| [Machine learning](#doc-history) | You can now use [machine learning models](https://docs.aws.amazon.com/pinpoint/latest/userguide/ml-models.html) with message templates to add dynamic, personalized recommendations to messages that you send from campaigns and journeys\. | March 4, 2020 | 
| [Templates](#doc-history) | You can now create, view, and manage versions of [message templates](https://docs.aws.amazon.com/pinpoint/latest/userguide/messages-templates.html)\. | December 20, 2019 | 
| [Templates](#doc-history) | You can now create, view, and manage [message templates](https://docs.aws.amazon.com/pinpoint/latest/userguide/messages-templates.html) for voice messages\. You can also specify default values for message variables that you use in any type of message template\. | November 18, 2019 | 
| [Journeys](#doc-history) | Your Amazon Pinpoint projects can now include [journeys](https://docs.aws.amazon.com/pinpoint/latest/userguide/journeys.html)—multi\-step campaign messaging workflows\. | October 31, 2019 | 
| [Templates](#doc-history) | You can now create, view, and manage all the [message templates](https://docs.aws.amazon.com/pinpoint/latest/userguide/messages-templates.html) for your Amazon Pinpoint account from a single location\. You can use these templates in messages that you send for any of your Amazon Pinpoint projects\. | October 7, 2019 | 
| [Analytics](#doc-history) | For campaigns that send email, push notifications, or SMS messages, we replaced the endpoints messaged metric with metrics and charts that show the number of unique endpoints that a campaign was sent to in a 24\-hour period\. For campaigns that send push notifications, we replaced the event count metrics for sessions per unique endpoint and purchases per unique endpoint with metrics and charts that show the number of times an app was opened and the number of units that were purchased in a 24\-hour period after a campaign was sent\. All the new metrics and charts are available for both standard and A/B test campaigns\. | July 25, 2019 | 
| [Deliverability dashboard](#doc-history) | The Deliverability dashboard now includes deliverability for individual campaigns\. It also lets you easily create alarms that notify you when your bounce, complaint, inbox placement, or IP blacklist rates reach specific values\. | June 13, 2019 | 
| [Regional availability](#doc-history) | Amazon Pinpoint is now available in the AWS Asia Pacific \(Mumbai\) and Asia Pacific \(Sydney\) Regions\. | April 25, 2019 | 
| [General settings](#doc-history) | Added information about using the Amazon Pinpoint console to [delete a project](https://docs.aws.amazon.com/pinpoint/latest/userguide/settings-general.html#settings-general-delete-project)\. | January 10, 2019 | 

## Earlier Updates<a name="doc-releases-archive"></a>

The following table describes important changes in each release of the *Amazon Pinpoint User Guide* through December 2018\.


| Change | Description | Date | 
| --- | --- | --- | 
| Regional availability | Amazon Pinpoint is now available in the AWS US West \(Oregon\) and Europe \(Frankfurt\) Regions\. | December 21, 2018 | 
| Deliverability dashboard | Amazon Pinpoint now includes a [deliverability dashboard](channels-email-deliverability-dashboard.md), which you can use to identify issues that could impact the delivery of emails that you send by using Amazon Pinpoint\. | December 3, 2018 | 
| Event triggers | You can now configure campaigns to be sent when specific events occur\. For example, if a customer adds an item to their cart but doesn't purchase it, you can send them an email\. To learn more about configuring campaigns to be sent when specific events occur, see [Step 4: Choose When to Send the Campaign](campaigns-schedule.md)\. | November 19, 2018 | 
| Voice channel | You can use the new Amazon Pinpoint voice channel to create voice messages and deliver them to your customers over the phone\. Currently, you can only send voice messages by using the Amazon Pinpoint SMS and Voice API\. For more information, see [Amazon Pinpoint Voice Channel](channels-voice.md)\. | November 15, 2018 | 
| Transactional email | You can now use Amazon Pinpoint to send email directly to individual recipients, without having to create segments or campaigns first\. For more information about sending transactional email, see [Sending Email in Amazon Pinpoint](channels-mobile-send.md)\. For more information about setting up the email channel, see [Email Settings](settings-email.md)\. | November 5, 2018 | 
| Europe \(Ireland\) availability | Amazon Pinpoint is now available in the AWS Europe \(Ireland\) Region\. | October 25, 2018 | 
| New console design | The Amazon Pinpoint console has been completely redesigned to make it easier to use\. We've also streamlined the project creation process so that you can create projects directly on the Amazon Pinpoint console, rather than having to create them in AWS Mobile Hub\. | October 4, 2018 | 
| Advanced segmentation | Added the ability to [create dynamic segments](segments-building.md) that include advanced logic and comparisons\. | October 4, 2018 | 
| Monitoring with CloudWatch | You can now use Amazon CloudWatch to monitor and analyze metrics related to your Amazon Pinpoint account\. | October 4, 2018 | 
| Email tutorial | Added a [tutorial](tutorials-send-an-email.md) that includes complete procedures for setting up a campaign and sending an email\. | June 19, 2018 | 
| Analytics chart references | The Analytics section now includes several new and updated reports\. We've added [documentation](analytics-charts.md) that gives you additional information about each metric\. | June 12, 2018 | 
| Testing campaigns | You can now [test your messages](campaigns-message.md#campaigns-message-test) by sending them to a segment or to a list of individual recipients\. | May 7, 2018 | 
| Define segments by importing user IDs | Define a segment by [importing a file that contains a list of user IDs](segments-importing.md)\. When you send a message to the segment, the potential destinations include each endpoint that's associated with each user ID in the file\. | May 7, 2018 | 
| Self\-managed opt\-outs and dashboard exports | You can configure your SMS account settings so that you can [manage SMS opt\-outs outside of Amazon Pinpoint](settings-sms.md#settings-account-sms-self-managed-opt-out)\. You can also [export Amazon Pinpoint dashboards](analytics-charts.md#analytics-exporting) for further analysis\. | March 28, 2018 | 
| Email project creation and identity verification | Added information about [creating email projects](channels-email-setup-create.md) and [verifying identities used to send email](channels-email-manage-verify.md)\. | March 21, 2018 | 
| SMS best practices | Added [a best practices guide](channels-sms-best-practices.md) that contains tips and information related to SMS campaigns\. | February 23, 2018 | 
| Requesting support for SMS use cases | Contact AWS Support to [request support for your SMS use case](channels-sms-awssupport.md) if you want to increase your spending quota, reserve an origination number, or reserve a sender ID\. | February 21, 2018 | 
| Segment import documentation | Amazon Pinpoint can now create an IAM role for you automatically\. | February 6, 2018 | 
| Two\-way SMS support by country | Updated the [table of Supported Countries and Regions for the SMS channel](channels-sms-countries.md) to list the countries and regions that support 2\-way SMS\. | February 5, 2018 | 
| Time to Live value for mobile push | On the Amazon Pinpoint console, you can specify a Time to Live \(TTL\) value when you [write a mobile push message](campaigns-message.md#campaigns-message-mobile) for a campaign\. | December 22, 2017 | 
| Removal of Amazon S3 export documentation | The ability to export Amazon Pinpoint event data directly to Amazon S3 has been deprecated\. Instead, you can use Amazon Kinesis Data Firehose to send event data to Amazon S3, Amazon Redshift, and other AWS services\. For more information, see [Streaming Events with Amazon Pinpoint](analytics-streaming.md)\. | December 18, 2017 | 
| Segment import documentation | [Importing Segments](segments-importing.md) includes updated information about how to create endpoint files, the attributes you can use within these files, and how to create an IAM role for importing\. | October 26, 2017 | 
| APNs token authentication and APNs sandbox support | The [APNs channel settings](channels-mobile-manage.md#channels-mobile-manage-apns) accept a \.p8 signing key so that Amazon Pinpoint can construct authentication tokens for your push notifications\.Use the APNs channel to send notifications to production and sandbox environments\. | September 27, 2017 | 
| ADM and Baidu mobile push | [Enable mobile push channels](channels-mobile-manage.md) for Amazon Device Message and Baidu Cloud Push in your projects\. | September 27, 2017 | 
| User analytics with Amazon Cognito user pools | To enable [analytics about users and authentication](analytics-usage.md), use Amazon Cognito user pools to manage user sign\-in\. | September 26, 2017 | 
| Account settings | Use the [SMS settings](settings-sms.md) page on the console to manage account\-level SMS settings that take effect for all of your projects\. | September 11, 2017 | 
| Users analytics | [Users charts](analytics-usage.md) on the Amazon Pinpoint console provide metrics about app usage and user authentication\. | August 31, 2017 | 
| Direct email messages | You can [send email messages directly](messages-email.md), to a limited audience, without creating a campaign or engaging a segment\. | July 05, 2017 | 
| New channels: email and SMS | In addition to the [mobile push](channels-mobile.md) channel, you can enable [email](channels-email.md) and [SMS](channels-sms.md) channels as part of your Amazon Pinpoint projects\. With these channels enabled, you can send emails or text messages with your campaigns\. | June 08, 2017 | 
| Direct messaging | You can [send push notifications and text messages directly](messages.md), to a limited audience, without creating a campaign or engaging a segment\. | June 08, 2017 | 
| Revenue charts | You can view [revenue charts](analytics-revenue.md) on the Amazon Pinpoint console to see the revenue that's generated by your app and the number of items purchased by users\. | March 31, 2017 | 
| Event streams | You can configure Amazon Pinpoint to [send your app and campaign events to a Kinesis stream](analytics-streaming.md)\. | March 24, 2017 | 
| Amazon Pinpoint general availability | This release introduces Amazon Pinpoint\. | December 1, 2016 | 