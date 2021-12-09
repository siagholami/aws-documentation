# How to Use AWS IoT Analytics<a name="getting-started"></a>

This section discusses the basic commands you use to collect, store, process and query your device data using AWS IoT Analytics\. The examples shown here use the AWS Command Line Interface \(AWS CLI\)\. For more information on the CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html)\. For more information about the CLI commands available for AWS IoT, see [iot](https://docs.aws.amazon.com/cli/latest/reference/iot/index.html) in the *AWS Command Line Interface Reference*\.

**Important**  
Use the **aws iotanalytics** *command* to interact with AWS IoT Analytics using the CLI\. Use the **aws iot** *command* to interact with other parts of the IoT system using the CLI\.

**Note**  
Be aware as you enter the names of AWS IoT Analytics entities \(channel, data set, data store, and pipeline\) in the examples that follow, that any upper\-case letters you use are automatically changed to lower\-case by the system\. The names of entities must start with a lower\-case letter and contain only lower\-case letters, underscores and digits\.

## AWS IoT Analytics Components and Concepts<a name="aws-iot-analytics-components-subset"></a>

In this section we cover these basic components and concepts:

**Channel \- collect the data**  
A channel collects and archives raw, unprocessed message data before publishing this data to a pipeline\.

**Pipeline \- process the data**  
A pipeline consumes messages from a channel and allows you to process and filter the messages before storing them in a data store\.

**Data store \- store the data**  
A data store is not a database, but it is a scalable and queryable repository of your messages\. You can have multiple data stores for messages that come from different devices or locations\.

**Data set \- retrieve the data for analysis**  
You retrieve data from a data store by creating a data set\. AWS IoT Analytics allows you to create a SQL data set or a container data set\. Here we look at a simple SQL data set which is similar to a materialized view from a SQL database\. In fact, you create a SQL data set by applying a SQL action\.

**Data set contents \- get the results**  
After you create data set contents, you can view them from the console\.

## Channel<a name="aws-iot-analytics-step-create-channel"></a>

Incoming messages are sent to a channel, so the first step is to create a channel for your data:

```
aws iotanalytics create-channel --channel-name mychannel
```

If you want AWS IoT messages to be ingested into AWS IoT Analytics, you can create an AWS IoT Rules Engine rule to send the messages to this channel\. This is shown later in [Create an AWS IoT Rule to send messages to AWS IoT Analytics](#aws-iot-analytics-step-create-rule)\. Another way to get the data in to a channel is to use the AWS IoT Analytics command "`BatchPutMessage`"\.

To list the channels you have already created:

```
aws iotanalytics list-channels
```

To get more information about a channel:

```
aws iotanalytics describe-channel --channel-name mychannel
```

Unprocessed channel messages are stored in an Amazon S3 bucket managed by AWS IoT Analytics, or in one managed by you\. Use the `channelStorage` parameter to specify which\. The default is a service\-managed Amazon S3 bucket\. If you choose to have channel messages stored in an Amazon S3 bucket that you manage, you must grant AWS IoT Analytics permission to perform these actions on your Amazon S3 bucket on your behalf: `s3:GetBucketLocation` \(verify bucket location\) `s3:PutObject` \(store\), `s3:GetObject` \(read\), `s3:ListBucket` \(reprocessing\)\. For example:

```
{
    "Version": "2012-10-17",
    "Id": "MyPolicyID",
    "Statement": [
        {
            "Sid": "MyStatementSid",
            "Effect": "Allow",
            "Principal": {
                "Service": "iotanalytics.amazonaws.com"
            },
            "Action": [
                "s3:GetObject",
                "s3:GetBucketLocation",
                "s3:ListBucket",
                "s3:PutObject",
            ],
            "Resource": [
                "arn:aws:s3:::my-iot-analytics-bucket",
                "arn:aws:s3:::my-iot-analytics-bucket/*"
            ]
        }
    ]
}
```

If you make changes in the options or permissions of your customer\-managed channel storage, you may need to reprocess channel data to ensure that previously ingested data is included in data set contents\. See [Reprocessing Channel Data](reprocessing.md#aws-iot-analytics-reprocessing)\.

## Data Store<a name="aws-iot-analytics-step-create-datastore"></a>

A data store receives and stores your messages\. You can create multiple data stores to store data according to your needs, or you can use a single data store to receive all of your AWS IoT messages:

```
aws iotanalytics create-datastore --datastore-name mydatastore
```

To list the data stores you have already created:

```
aws iotanalytics list-datastores
```

To get more information about a data store:

```
aws iotanalytics describe-datastore --datastore-name mydatastore
```

Processed data store messages are stored in an Amazon S3 bucket managed by AWS IoT Analytics or in one managed by you\. Use the `datastoreStorage` parameter to specify which\. The default is a service\-managed Amazon S3 bucket\. If you choose to have data store messages stored in an Amazon S3 bucket that you manage, you must grant AWS IoT Analytics permission to perform these actions on your Amazon S3 bucket on your behalf: `s3:GetBucketLocation` \(verify bucket location\) `s3:PutObject`, `s3:DeleteObject`\. If you use the data store as a source for an SQL query data set, you must set up an Amazon S3 bucket policy that grants AWS IoT Analytics permission to execute Amazon Athena queries on the contents of your bucket\. The following is an example bucket policy that grants the required permissions:

```
{
    "Version": "2012-10-17",
    "Id": "MyPolicyID",
    "Statement": [
        {
            "Sid": "MyStatementSid",
            "Effect": "Allow",
            "Principal": {
                "Service": "iotanalytics.amazonaws.com"
            },
            "Action": [
                "s3:GetBucketLocation",
                "s3:GetObject",
                "s3:ListBucket",
                "s3:ListBucketMultipartUploads",
                "s3:ListMultipartUploadParts",
                "s3:AbortMultipartUpload",
                "s3:PutObject",
                "s3:DeleteObject"
            ],
            "Resource": [
                "arn:aws:s3:::my-athena-data-bucket",
                "arn:aws:s3:::my-athena-data-bucket/*"
            ]
        }
    ]
}
```

See [Cross\-account Access](https://docs.aws.amazon.com/athena/latest/ug/cross-account-permissions.html) in the **Amazon Athena User Guide** for more information\. Also, if you make changes in the options or permissions of your customer\-managed data store storage, you may need to reprocess channel data to ensure that previously ingested data is included in data set contents\. See [Reprocessing Channel Data](reprocessing.md#aws-iot-analytics-reprocessing)\.

## Pipeline<a name="aws-iot-analytics-step-create-pipeline"></a>

To connect a channel to a data store, you create a pipeline\. The simplest possible pipeline contains no activities other than specifying the channel that collects the data and identifying the data store to which the messages are sent\. For information about more complicated pipelines, see [Pipeline Activities](pipeline-activities.md#aws-iot-analytics-pipeline-activities)\.

When starting out, we recommend that you create a pipeline that does nothing other than connect a channel to a data store\. Then, after you verify that raw data flows to the data store, you can introduce additional pipeline activities to process this data\.

Create a pipeline:

```
aws iotanalytics create-pipeline --cli-input-json file://mypipeline.json
```

where the file `mypipeline.json` contains:

```
{
    "pipelineName": "mypipeline",
    "pipelineActivities": [
        {
            "channel": {
                "name": "mychannelactivity",
                "channelName": "mychannel",
                "next": "mystoreactivity"
            }
        },
        {
            "datastore": {
                "name": "mystoreactivity",
                "datastoreName": "mydatastore"
            }
        }
    ]
}
```

To list your existing pipelines:

```
aws iotanalytics list-pipelines
```

To view the configuration of an individual pipeline:

```
aws iotanalytics describe-pipeline  --pipeline-name mypipeline
```

## Get Data Into AWS IoT Analytics<a name="aws-iot-analytics-step-get-data-in"></a>

If you have a channel that routes data to a pipeline that stores data in a data store where it can be queried, then you're ready to send message data into AWS IoT Analytics\. Here we show two methods of getting data into AWS IoT Analytics\. You can send a message using the AWS IoT message broker or use the AWS IoT Analytics "BatchPutMessage" command\.

To use the AWS IoT message broker, you create a rule using the AWS IoT Rules Engine\. The rule routes messages with a specific topic into AWS IoT Analytics\. But first, this rule requires you to create a role which grants the required permissions\. We'll show that next\. Later in this section we'll also show how to use the AWS IoT Analytics "BatchPutMessage" command to send messages directly to a channel\.

### Grant Permission with an IAM Role<a name="aws-iot-analytics-step-create-role"></a>

To have AWS IoT messages routed into an AWS IoT Analytics channel, you set up a rule\. But first, you must create an IAM role that grants that rule permission to send message data to an AWS IoT Analytics channel\.

Create the role:

```
aws iam create-role --role-name myAnalyticsRole --assume-role-policy-document file://arpd.json
```

where the contents of the file `arpd.json` should look like this:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "Service": "iot.amazonaws.com"
            },
            "Action": "sts:AssumeRole"
        }
    ]
}
```

Then, you attach a policy document to the role:

```
aws iam put-role-policy --role-name myAnalyticsRole --policy-name myAnalyticsPolicy --policy-document file://pd.json
```

where the contents of the file `pd.json` looks like this:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "iotanalytics:BatchPutMessage",
            "Resource": [
               "arn:aws:iotanalytics:us-west-2:<your-account-number>:channel/mychannel"
            ]
        }
    ]
}
```

### Create an AWS IoT Rule to send messages to AWS IoT Analytics<a name="aws-iot-analytics-step-create-rule"></a>

Create an AWS IoT rule that sends messages to your channel:

```
aws iot create-topic-rule --rule-name analyticsTestRule --topic-rule-payload file://rule.json
```

The contents of the `rule.json` file should look like this:

```
{
    "sql": "SELECT * FROM 'iot/test'",
    "ruleDisabled": false,
    "awsIotSqlVersion": "2016-03-23",
    "actions": [ {
        "iotAnalytics": {
            "channelName": "mychannel",
            "roleArn": "arn:aws:iam::<your-account-number>:role/myAnalyticsRole"
        }
    } ]
}
```

Replace `iot/test` with the MQTT topic of the messages that should be routed\. Replace the channel name and the role with the ones you created in the previous sections\.

### Use the AWS IoT Console to Send Message Data Into AWS IoT Analytics<a name="aws-iot-analytics-send-message-with-console"></a>

After you have joined a rule to a channel, a channel to a pipeline, and a pipeline to a data store, any data matching the rule now flows through AWS IoT Analytics to the data store ready to be queried\. To test this, you can use the AWS IoT console to send a message\.

**Note**  
The field names of message payloads \(data\) that you send to AWS IoT Analytics:  
Must contain only alphanumeric characters and underscores \(\_\); no other special characters are allowed\.
Must begin with an alphabetic character or single underscore \(\_\)\.
Cannot contain hyphens \(\-\)\.
In regular expression terms: `"^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$"`\.
Cannot be greater than 255 characters\.
Are case\-insensitive\. \(Fields named "foo" and "FOO" in the same payload are considered duplicates\.\)
For example, `{"temp_01": 29}` or `{"_temp_01": 29}` are valid, but `{"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\.

1. In the [AWS IoT console](https://console.aws.amazon.com/iot/home), in the left navigation pane, choose **Test**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/choose-test.png)

1. On the MQTT client page, in the **Publish** section, in **Specify a topic**, type `iot/test`\. In the message payload section, verify the following JSON contents are present, or type them if not:

   ```
   {
       "message": "Hello from AWS IoT console"
   }
   ```

1. Choose **Publish to topic**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/publish.png)

   This publishes a message that is routed to the data store you created earlier\.

### Use "BatchPutMessage" to Send a Message to the Channel<a name="aws-iot-analytics-use-batchputmessage"></a>

Another way to get message data into AWS IoT Analytics is to use the "BatchPutMessage" API command\. This method does not require that you set up an AWS IoT rule to route messages with a specific topic to your channel\. But it does require that the device which sends its data/messages to the channel is capable of running software created with the AWS SDK or is capable of using the AWS CLI to call "BatchPutMessage"\.

1. Create a file "messages\.json" which contains the messages to be sent \(in this example only one message is sent\):

   ```
   [
       { "messageId": "message01", "payload": "{ \"message\": \"Hello from the CLI\" }" }
   ]
   ```

1. Call `batch-put-message`:

   ```
   aws iotanalytics batch-put-message  --channel-name mychannel  --messages file://messages.json
   ```

1. If there are no errors, you see the following output:

   ```
   {
       "batchPutMessageErrorEntries": []
   }
   ```

## Checking the Progress of IoT Messages<a name="aws-iot-analytics-check-message"></a>

You can check that the messages you sent are being ingested into your channel by using the AWS IoT Analytics console\. Follow these steps:

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), in the left navigation pane, choose **Prepare** and \(if necessary\) choose **Channels**, then choose the name of the channel you created earlier:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/analytics-console-return.png)

1. On the channel detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of messages ingested into this channel during the specified time frame:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/channel-monitoring.png)

A similar monitoring capability exists for checking pipeline activity executions\. You can monitor activity execution errors on the pipeline's detail page\. \(If you haven't specified activities as part of your pipeline, then 0 execution errors should be displayed\.\)

1. In the [AWS IoT Analytics console](https://console.aws.amazon.com/iotanalytics/home), in the left navigation pane, choose **Prepare** and then choose **Pipelines**, then choose the name of a pipeline you created earlier:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/console-prepare-pipelines.png)

1. On the pipeline detail page, scroll down to the **Monitoring** section\. Adjust the displayed time frame as necessary by choosing one of the time frame indicators \(**1h 3h 12h 1d 3d 1w**\)\. You should see a graph line indicating the number of pipeline activity execution errors during the specified time frame:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/images/pipeline-monitoring.png)

## Data Set \- Query Your Data<a name="aws-iot-analytics-query-data"></a>

When you have data in a data store, you can query it to answer analytical questions\. Although a data store is not a database, you use SQL expressions to query the data and produce results that are stored in a data set\.

To query the data, you create a data set\. A data set contains the SQL that you use to query the data store along with an optional schedule that repeats the query at a day and time you choose\. You create the optional schedules using expressions similar to [Amazon CloudWatch schedule expressions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/ScheduledEvents.html)\.<a name="step-create-dataset"></a>

Create a data set:

```
aws iotanalytics create-dataset --cli-input-json file://mydataset.json
```

where the file `mydataset.json` contains:

```
{
    "datasetName": "mydataset",
    "actions": [
        {
            "actionName":"myaction",
            "queryAction": {
                "sqlQuery": "select * from mydatastore"
            }
        }
    ]
}
```

Create the data set content by executing the query:

```
aws iotanalytics create-dataset-content --dataset-name mydataset
```

Wait a few minutes for the data set content to be created before you continue\.

## Data Set Content \- Access the Query Results<a name="aws-iot-analytics-step-access-results"></a>

The result of the query is your data set content, stored as a file, in CSV format\. The file is made available to you through Amazon S3\. The following example shows how you can check that your results are ready and download the file\.

Call `get-dataset-content`:

```
aws iotanalytics get-dataset-content --dataset-name mydataset
```

If your data set contains any data, then the output from `get-dataset-content` has `"state": "SUCCEEDED"` in the `status` field, like this:

```
{
    "timestamp": 1508189965.746,
    "entries": [
        {
          "entryName": "someEntry",
          "dataURI": "https://aws-iot-analytics-datasets-f7253800-859a-472c-aa33-
          e23998b31261.s3.amazonaws.com/results/f881f855-c873-49ce-abd9-b50e9611b71f.csv?X-Amz-
          Security-Token=<TOKEN>&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20171016T214541Z&X-Amz-
          SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Credential=<CREDENTIAL>&X-Amz-
          Signature=<SIGNATURE>"
        }
    ],
    "status": {
      "state": "SUCCEEDED",
      "reason": "A useful comment."
    }
}
```

 `dataURI` is a signed URL to the output results\. It is valid for a short period of time \(a few hours\)\. Depending on your workflow, you might want to always call `get-dataset-content` before you access the content because calling this command generates a new signed URL\.

## Explore Your Data<a name="aws-iot-analytics-explore-data"></a>

You have several options for storing, analyzing and visualizing your data\.\.\.

### Amazon S3<a name="amazon-s3"></a>

You can send data set contents to an [Amazon Simple Storage Service \(S3\)](https://docs.aws.amazon.com/AmazonS3/latest/gsg/GetStartedWithS3.html) bucket, enabling integration with your existing data lakes or access from in\-house applications and visualization tools\. See the field `contentDeliveryRules::destination::s3DestinationConfiguration` in [CreateDataset](api.md#cli-iotanalytics-createdataset)\.

### AWS IoT Events<a name="aws-iot-events"></a>

You can send data set contents as an input to [AWS IoT Events](https://docs.aws.amazon.com/iotevents/latest/developerguide/what-is-iotevents.html), a service which enables you to monitor devices or processes for failures or changes in operation, and to trigger additional actions when such events occur\. See the field `contentDeliveryRules::destination::iotEventsDestinationConfiguration` in [CreateDataset](api.md#cli-iotanalytics-createdataset)\.

### Amazon QuickSight<a name="amazon-quicksight"></a>

AWS IoT Analytics provides direct integration with [Amazon QuickSight](https://quicksight.aws)\. Amazon QuickSight is a fast business analytics service you can use to build visualizations, perform ad\-hoc analysis, and quickly get business insights from your data\. Amazon QuickSight enables organizations to scale to hundreds of thousands of users, and delivers responsive performance by using a robust in\-memory engine \(SPICE\)\. Amazon QuickSight is available in [these regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#quicksight_region)\.

### Jupyter Notebooks<a name="jupyter-notebooks"></a>

AWS IoT Analytics data sets can also be directly consumed by Jupyter Notebooks in order to perform advanced analytics and data exploration\. Jupyter Notebooks is an open source solution\. You can install and download from [http://jupyter\.org/install\.html](http://jupyter.org/install.html)\. Additional integration with SageMaker, an Amazon hosted notebook solution, is also available\.

## Keeping Multiple Versions of AWS IoT Analytics Data Sets<a name="aws-iot-analytics-dataset-versions"></a>

You can choose how many versions of your data set contents to retain, and for how long, by specifying values for the data set `retentionPeriod` and `versioningConfiguration` fields when invoking the [CreateDataset](api.md#cli-iotanalytics-createdataset) and [UpdateDataset](api.md#cli-iotanalytics-updatedataset) APIs:

```
...
"retentionPeriod": {
  "unlimited": "boolean",
  "numberOfDays": "integer"
},
"versioningConfiguration": {
  "unlimited": "boolean",
  "maxVersions": "integer"
},
...
```

The settings of these two parameters work together to determine how many versions of data set contents are retained, and for how long, in the following ways:


****  

|  |  |  |  | 
| --- |--- |--- |--- |
|  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  |  Only the latest version plus the latest succeeded version \(if different\) are retained for 90 days\.  |  Only the latest version plus the latest succeeded version \(if different\) are retained for an unlimited time\.  |  Only the latest version plus the latest succeeded version \(if different\) are retained for X days\.  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  |  All versions from the last 90 days will be retained, regardless of how many\.  |  There is no limit to the number of versions retained\.  |  All versions from the last X days will be retained, regardless of how many\.  | 
|  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/getting-started.html)  |  No more than Y versions from the last 90 days will be retained\.  |  Up to Y versions will be retained, regardless of how old they are\.  |  No more than Y versions from the last X days will be retained\.  | 

## AWS IoT Analytics Message Payload Restrictions<a name="aws-iot-analytics-payload-restrict"></a>

The field names of message payloads \(data\) that you send to AWS IoT Analytics:
+ Must contain only alphanumeric characters and underscores \(\_\); no other special characters are allowed\.
+ Must begin with an alphabetic character or single underscore \(\_\)\.
+ Cannot contain hyphens \(\-\)\.
+ In regular expression terms: `"^[A-Za-z_]([A-Za-z0-9]*|[A-Za-z0-9][A-Za-z0-9_]*)$"`\.
+ Cannot be greater than 255 characters\.
+ Are case\-insensitive\. \(Fields named "foo" and "FOO" in the same payload are considered duplicates\.\)

For example, `{"temp_01": 29}` or `{"_temp_01": 29}` are valid, but `{"temp-01": 29}`, `{"01_temp": 29}` or `{"__temp_01": 29}` are invalid in message payloads\.

## AWS IoT Analytics Service Limits<a name="aws-iot-analytics-service-limits"></a>


****  

| API | Limit Description | Adjustable? | 
| --- | --- | --- | 
|   `SampleChannelData`   |  1 transaction per second per channel  |  yes  | 
|   `CreateDatasetContent`   |  1 transaction per second per data set  |  yes  | 
|   `RunPipelineActivity`   |  1 transaction per second  |  yes  | 
|  other management APIs  |  20 transactions per second  |  yes  | 
|   `BatchPutMessage`   |  100,000 messages or 500MB total message size per second per channel; 100 messages per batch; 128Kb per message  |  yes; yes; no  | 


****  

| Resource | Limit Description | Adjustable? | 
| --- | --- | --- | 
|  channel  |  50 per account  |  yes  | 
|  data store  |  25 per account  |  yes  | 
|  pipeline  |  100 per account  |  yes  | 
|  activities  |  25 per pipeline  |  no  | 
|  data set  |  100 per account  |  yes  | 
|  minimum SQL data set refresh interval  |  1 minute  |  no  | 
|  minimum container data set refresh interval  |  15 minutes  |  yes  | 
|  concurrent data set content generation  |  2 data sets simultaneously  |  no  | 
|  container data sets that can be triggered from a single SQL data set  |  10  |  no  | 
|  concurrent container data set runs  |  20  |  no  | 