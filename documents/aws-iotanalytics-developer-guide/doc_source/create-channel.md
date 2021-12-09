# Creating a channel<a name="create-channel"></a>

A channel collects and archives raw, unprocessed message data before publishing this data to a pipeline\. Incoming messages are sent to a channel, so the first step is to create a channel for your data\.

```
aws iotanalytics create-channel --channel-name mychannel
```

If you want AWS IoT messages to be ingested into AWS IoT Analytics, you can create an AWS IoT Rules Engine rule to send the messages to this channel\. This is shown later in [Ingesting data to AWS IoT Analytics](ingest-data.md)\. Another way to get the data in to a channel is to use the AWS IoT Analytics command `BatchPutMessage`\. 

To list the channels you have already created:

```
aws iotanalytics list-channels
```

To get more information about a channel\.

```
aws iotanalytics describe-channel --channel-name mychannel
```

Unprocessed channel messages are stored in an Amazon S3 bucket managed by AWS IoT Analytics, or in one managed by you\. Use the `channelStorage` parameter to specify which\. The default is a service\-managed Amazon S3 bucket\. If you choose to have channel messages stored in an Amazon S3 bucket that you manage, you must grant AWS IoT Analytics permission to perform these actions on your Amazon S3 bucket on your behalf: `s3:GetBucketLocation` \(verify bucket location\) `s3:PutObject` \(store\), `s3:GetObject` \(read\), `s3:ListBucket` \(reprocessing\)\. 

**Example**  

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
                "s3:PutObject"
            ],
            "Resource": [
                "arn:aws:s3:::my-iot-analytics-bucket",
                "arn:aws:s3:::my-iot-analytics-bucket/*"
            ]
        }
    ]
}
```

If you make changes in the options or permissions of your customer\-managed channel storage, you might need to reprocess channel data to ensure that previously ingested data is included in data set contents\. See [Reprocessing channel data](https://docs.aws.amazon.com/iotanalytics/latest/userguide/reprocessing.html#aws-iot-analytics-reprocessing)\.