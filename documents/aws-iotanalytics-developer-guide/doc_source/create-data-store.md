# Creating a data store<a name="create-data-store"></a>

A data store receives and stores your messages\. It is not a database but a scalable and queryable repository of your messages\. You can create multiple data stores to store messages that comes from different devices or locations, or your can use a single data store to receive all of your AWS IoT messages\.

```
aws iotanalytics create-datastore --datastore-name mydatastore
```

To list the data stores you have already created\.

```
aws iotanalytics list-datastores
```

To get more information about a data store\.

```
aws iotanalytics describe-datastore --datastore-name mydatastore
```

Processed data store messages are stored in an Amazon S3 bucket managed by AWS IoT Analytics or in one managed by you\. Use the `datastoreStorage` parameter to specify which\. The default is a service\-managed Amazon S3 bucket\. If you choose to have data store messages stored in an Amazon S3 bucket that you manage, you must grant AWS IoT Analytics permission to perform these actions on your Amazon S3 bucket on your behalf: `s3:GetBucketLocation` \(verify bucket location\) `s3:PutObject`, `s3:DeleteObject`\. If you use the data store as a source for an SQL query data set, you must set up an Amazon S3 bucket policy that grants AWS IoT Analytics permission to execute Amazon Athena queries on the contents of your bucket\. The following is an example bucket policy that grants the required permissions\.

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

See [Cross\-account access](https://docs.aws.amazon.com/athena/latest/ug/cross-account-permissions.html) in the *Amazon Athena User Guide* for more information\. Also, if you make changes in the options or permissions of your customer\-managed data store storage, you may need to reprocess channel data to ensure that previously ingested data is included in data set contents\. See [Reprocessing channel data](https://docs.aws.amazon.com/iotanalytics/latest/userguide/reprocessing.html#aws-iot-analytics-reprocessing)\.