# Event Stream Settings<a name="settings-event-streams"></a>

Use the **Event stream** settings page to enable or disable streaming of usage and engagement data, known as *event* data, for the current project to supported AWS services\. If you enable streaming, you can also choose the type of stream and the AWS Identity and Access Management role that you want to use\. 

**To set up event streaming**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project that you want to set up data streaming for\.

1. In the navigation pane, under **Settings**, choose **Event stream**\.

1. In the **Services** section, choose **Edit**\.

1. Choose **Stream to Amazon Kinesis**\.

1. Under **Choose a stream type**, choose one of the following options:
   + **Send events to an Amazon Kinesis Data Stream** – Choose this option if you want to send Amazon Pinpoint event data to an external application for analysis\.
   + **Send events to an Amazon Kinesis Data Firehose stream** – Choose this option if you want to send event data to an AWS data store, such as Amazon Redshift\.

1. For **Amazon Kinesis stream**, choose the Amazon Kinesis stream that you want to use to export the data\.
**Note**  
If you haven't already created an Amazon Kinesis stream, go to the Amazon Kinesis console at [https://console\.aws\.amazon\.com/kinesis](https://console.aws.amazon.com/kinesis)\. For more information about creating streams, see the [Amazon Kinesis Data Streams Developer Guide](https://docs.aws.amazon.com/streams/latest/dev/) or the [Amazon Kinesis Data Firehose Developer Guide](https://docs.aws.amazon.com/firehose/latest/dev/)\.

1. Under **IAM role**, choose one of the following options:
   + **Use an existing role** – Choose this option to have Amazon Pinpoint assume an IAM role that already exists in your account\. The role that you select must allow the `firehose:PutRecordBatch` action\. For an example of a policy that allows this action, see [Permissions Policies](https://docs.aws.amazon.com/pinpoint/latest/developerguide/permissions-streams.html#permissions-streams-permissionspolicies) in the *Amazon Pinpoint Developer Guide*\.
   + **Automatically create a role** – Choose this option to automatically create an IAM role with the required permissions\. This role authorizes Amazon Pinpoint to send data to the stream that you chose in step 7\.

1. Choose **Save**\.

As Amazon Pinpoint receives events for your project, it sends this data to your Kinesis stream\. For information about the data that Amazon Pinpoint sends for an event, see [Streaming Amazon Pinpoint Events to Kinesis](https://docs.aws.amazon.com/pinpoint/latest/developerguide/event-streams.html) in the *Amazon Pinpoint Developer Guide*\.