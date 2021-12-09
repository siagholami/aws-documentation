# Monitoring Email Activity with Amazon Pinpoint<a name="channels-email-monitor"></a>

For email that you send for a project, Amazon Pinpoint provides options for monitoring your email activity\.

## Amazon Pinpoint Analytics<a name="channels-email-monitor-analytics"></a>

The **Analytics** pages on the Amazon Pinpoint console provide many email\-related metrics for the campaigns and transactional messages that you send for a project\. For example, you can view the number of email endpoints that you can send messages to, and the number of endpoints that you've already sent messages to\. Also, you can view the open, click, and opt\-out rates for messages that you've already sent\. For campaign messages, you can view these metrics across all of your campaigns or for individual campaigns\. To learn more about these metrics and how to view them, see [Amazon Pinpoint Analytics](analytics.md)\.

Amazon Pinpoint provides similar metrics for email that you send for a journey\. For example, you can view the number of messages that were opened by participants in each activity of a journey\. After you publish a journey, you can view the data for these metrics by using the **Journey metrics** pane in the journey workspace\. To learn more about these metrics, see [View Journey Metrics](journeys-metrics.md)\.

## Streaming Email Event Data<a name="channels-email-monitor-stream"></a>

To monitor data, such as successful and failed email deliveries, configure Amazon Pinpoint to stream email event data to Amazon Kinesis Data Streams or Amazon Kinesis Data Firehose\. Then, you can use the Kinesis platform to analyze this email data\. For more information, see [Streaming Amazon Pinpoint Events to Kinesis](analytics-streaming.md#analytics-streaming-kinesis)\.

For examples of the event data that Amazon Pinpoint streams to Kinesis, see [Email Events](http://docs.aws.amazon.com/pinpoint/latest/developerguide/event-streams-data-email.html) in the *Amazon Pinpoint Developer Guide*\.