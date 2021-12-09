# Monitoring SMS Activity with Amazon Pinpoint<a name="channels-sms-monitor"></a>

Amazon Pinpoint provides the following options for monitoring your SMS activity\.

## Streaming SMS Event Data<a name="channels-sms-monitor-streaming"></a>

To monitor your SMS activity, such as the number of successful and failed message deliveries, you can configure Amazon Pinpoint to stream SMS event data to Amazon Kinesis Data Streams or Amazon Kinesis Data Firehose\. Then, you can use the Kinesis platform to analyze your SMS data\. For more information, see [Streaming Amazon Pinpoint Events to Kinesis](analytics-streaming.md#analytics-streaming-kinesis)\.

For examples of the event data that Amazon Pinpoint streams to Kinesis, see [SMS Events](http://docs.aws.amazon.com/pinpoint/latest/developerguide/event-streams-data-sms.html) in the *Amazon Pinpoint Developer Guide*\.

## Amazon Pinpoint Analytics<a name="channels-sms-monitor-analytics"></a>

You can also use the **Analytics** pages on the Amazon Pinpoint console to view charts and data for metrics related to the SMS channel for a project\. For example, you can see the number of SMS messages that you've sent and the number of active endpoints that you can send SMS messages to\. For more information, see [Amazon Pinpoint Analytics](analytics.md)\.