# What Is Amazon Pinpoint?<a name="welcome"></a>

Amazon Pinpoint is an AWS service that you can use to engage with your customers across multiple messaging channels\. You can use Amazon Pinpoint to send push notifications, emails, SMS text messages, and voice messages\.

The information in this user guide is intended for all Amazon Pinpoint users, including marketers, business users, and developers\. This guide contains information that's especially helpful for users who mainly interact with Amazon Pinpoint by using the AWS Management Console\. If you're new to Amazon Pinpoint, start by reading [Getting Started with Amazon Pinpoint](gettingstarted.md)\.

If you're an application developer, also refer to the [Amazon Pinpoint Developer Guide](https://docs.aws.amazon.com/pinpoint/latest/developerguide/) and the [Amazon Pinpoint API Reference](https://docs.aws.amazon.com/pinpoint/latest/apireference/)\. These documents provide information about using the features of Amazon Pinpoint programmatically\. They also contain information about integrating Amazon Pinpoint features into your applications\.

## Amazon Pinpoint Features<a name="welcome-features"></a>

This section describes the major features of Amazon Pinpoint and the tasks that you can perform by using them\.

### Define Audience Segments<a name="welcome-segments"></a>

Reach the right audience for your messages by [defining audience segments](segments.md)\. A segment designates which users receive the messages that are sent from a campaign or journey\. You can define dynamic segments based on data that's reported by your application, such as operating system or mobile device type\. You can also import static segments that you define outside of Amazon Pinpoint\.

### Engage Your Audience with Messaging Campaigns<a name="welcome-campaigns"></a>

Engage your audience by [creating a messaging campaign](campaigns.md)\. A campaign sends tailored messages on a schedule that you define\. You can create campaigns that send push notifications, email, SMS text messages, and voice messages\.

To experiment with alternative campaign strategies, set up your campaign as an A/B test, and analyze the results with Amazon Pinpoint analytics\.

### Create User Journeys<a name="welcome-journeys"></a>

Create custom, multi\-step experiences for your customers by [designing and building journeys](journeys.md)\. With journeys, you can send messages to your customers based on their attributes, behaviors, and activities\. When you build a journey, you design an automated workflow of activities that perform a variety of different actions—for example, sending an email message to participants, waiting for a certain period of time, or splitting participants based on actions that they take, such as clicking a link in a message\.

### Provide Consistent Messaging with Templates<a name="welcome-templates"></a>

Design consistent messages and reuse content more effectively by [creating and using message templates](messages-templates.md)\. A message template contains content and settings that you want to reuse in messages that you send for any of your Amazon Pinpoint projects\. You can use message templates in email messages, push notifications, SMS messages, and voice messages\.

### Deliver Personalized Content<a name="welcome-ml-models-rm"></a>

Send content that's customized for each recipient of a message\. Using message variables and attributes, you can deliver dynamic, personalized content in messages that you send from campaigns and journeys\.

To streamline development, you can also use message variables and attributes to [add personalized content to message templates](message-templates-personalizing.md)\. With message templates, this content can come from attributes that you create directly in Amazon Pinpoint or a machine learning model that you create in Amazon Personalize\. By connecting message templates to models in Amazon Personalize, you can [use machine learning](ml-models.md) to send relevant promotions or recommendations to each recipient of a message\.

### Analyze User Behavior<a name="welcome-analyze"></a>

Gain insight into your audience and the effectiveness of your campaigns and messaging activities by [using the analytics](analytics.md) that Amazon Pinpoint provides\. You can view trends in your users' level of engagement, purchase activity, demographics, and more\. You can also monitor your message traffic by viewing metrics such as the total number of messages that you sent for a campaign or project\. Through the Amazon Pinpoint API, your application can also report custom data, which Amazon Pinpoint makes available for analysis\.

To analyze or store analytics data outside Amazon Pinpoint, configure Amazon Pinpoint to [stream the data](analytics-streaming.md) to Amazon Kinesis\.

### Send Test Messages<a name="welcome-transactional"></a>

Test the design and deliverability of your messages by [sending test messages](messages.md) before you send messages to your customers\.

## Regional Availability<a name="welcome-regions"></a>

Amazon Pinpoint is available in several AWS Regions in North America, Europe, Asia, and Oceania\. In each Region, AWS maintains multiple Availability Zones\. These Availability Zones are physically isolated from each other, but are united by private, low\-latency, high\-throughput, and highly redundant network connections\. These Availability Zones enable us to provide very high levels of availability and redundancy, while also minimizing latency\.

To learn more about AWS Regions, see [Managing AWS Regions](https://docs.aws.amazon.com/general/latest/gr/rande-manage.html) in the *Amazon Web Services General Reference*\. For a list of all the Regions where Amazon Pinpoint is currently available and the endpoint for each Region, see [AWS Service Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#pinpoint_region) in the *Amazon Web Services General Reference*\. To learn more about the number of Availability Zones that are available in each Region, see [AWS Global Infrastructure](https://aws.amazon.com/about-aws/global-infrastructure/)\.

## Get Started<a name="welcome-getstarted"></a>

Get started with Amazon Pinpoint by [creating a new project](gettingstarted.md) or [completing a tutorial](tutorials.md)\. 