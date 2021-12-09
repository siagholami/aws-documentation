# AWS Elemental MediaPackage Events<a name="cloudwatch-events-example"></a>

AWS Elemental MediaPackage integrates with Amazon CloudWatch Events to notify you of certain events that affect your channels and endpoints\. Each event is represented in [JSON \(JavaScript Object Notation\)](http://json.org) and contains the event name, the date and time when the event occurred, the channel or endpoint affected, and more\. You can use CloudWatch Events to collect these events and set up rules that route them to one or more *targets* such as AWS Lambda functions, Amazon SNS topics, Amazon SQS queues, streams in Amazon Kinesis Data Streams, or built\-in targets\.

For more information about using CloudWatch Events with other kinds of events, see the [Amazon CloudWatch Events User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/)\.

The following topics describe the CloudWatch Events that AWS Elemental MediaPackage creates\.

**Topics**
+ [Input Notification Events](#input-state-events)
+ [Key Provider Notification Events](#key-provider-state-events)
+ [Harvest Job Notification Events](#hj-status-events)

## Input Notification Events<a name="input-state-events"></a>

You get input notification events for live and video on demand \(VOD\) content\. These events notify you when something happens with MediaPackage ingest\. These are the input notification events you might receive:
+ Maximum input streams exceeded 
+ Input switch
+ VOD ingest status change
+ VOD playback readiness

The following sections describe each of these events\.

** Maximum Input Streams Exceeded Event **  
For live content, a channel in MediaPackage exceeds the quota for the number of input streams\. For information about quotas, see [Quotas in AWS Elemental MediaPackage](limits.md)\.  

**Example**  

```
{
   "id": "7bf73129-1428-4cd3-a780-95db273d1602",
   "detail-type": "MediaPackage Input Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2015-11-11T21:29:54Z",
   "region": "us-west-2",
   "resources":[
      "arn:aws:mediapackage:us-west-2:aws_account_id:channels/262ff182d46d4b399fcabea1364df682"
   ],
   "detail":{
      "event": "MaxIngestStreamsError",
      "message": "Parent Manifest [%s] has [23] streams, more than [20] allowed: (index_1.m3u8,index_2.m3u8,index_3.m3u8,index_4.m3u8,index_5.m3u8,index_6.m3u8,index_7.m3u8,index_8.m3u8,index_9.m3u8,index_10.m3u8,index_11.m3u8,index_12.m3u8,index_13.m3u8,index_14.m3u8,index_15.m3u8,index_16.m3u8,index_17.m3u8,index_18.m3u8,index_19.m3u8,index_20.m3u8,index_21.m3u8,index_22.m3u8,index_23.m3u8)"
   }
}
```

**Input Switch Event**  
For live content, MediaPackage switches inputs for one of your endpoints\.   
One event is sent in a five\-minute period\. If the input switches multiple times in five minutes \(for example, if MediaPackage switches to one input, then back to the other\), you receive only one event\.  
For information about input redundancy and what causes inputs to switch, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.  

**Example**  

```
{
   "id": "8f9b8e72-0b31-e883-f19c-aec84742f3ce",
   "detail-type": "MediaPackage Input Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2018-07-16T17:29:36Z",
   "region": "us-east-1",
   "resources":[
      "arn:aws:mediapackage:us-east-1:aws_account_id:origin_endpoints/82d6b9bc04cb4612b487963d6c8d0f1a"
   ],
   "detail":{
      "event": "InputSwitchEvent",
      "message": "Origin endpoint experienced an Input Switch Event"
   }
}
```

**VOD Ingest Status Event**  
For video on demand \(VOD\) content, an asset in MediaPackage changes ingest status\. You get notifications for the following events:  
+ `IngestStart`
+ `IngestError`
+ `IngestComplete`

**Example**  

```
{
   "id": "8f9b8e72-0b31-e883-f19c-aec84742f3ce",
   "detail-type": "MediaPackage Input Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2019-05-03T17:29:36Z",
   "region": "us-west-2",
   "resources":[
      "arn:aws:mediapackage-vod:us-west-2:aws_account_id:assets/asset_id"
   ],
   "detail":{
      "event": "IngestComplete",
      "message": "message text"
   }
}
```

**VOD Playback Event**  
For VOD content, an asset in MediaPackage is available for playback\. There is a period of time between when asset ingest is complete, and when the asset can be played back\. The event `VodAssetPlayable` means that MediaPackage can now fulfill playback requests for the asset\.  

**Example**  

```
{
   "id": "81e896e4-d9e5-ec79-f82a-b4cf3246c567",
   "detail-type": "MediaPackage Input Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2019-11-03T21:46:00Z",
   "region": "us-west-2",
   "resources":[
      "arn:aws:mediapackage-vod:us-west-2:aws_account_id:assets/asset_id",
      "arn:aws:mediapackage-vod:us-west-2:aws_account_id:packaging_configuration/packaging_configuration_id"
   ],
   "detail":{
      "event": "VodAssetPlayable",
      "message": "Asset 'asset_id' is now playable for PackagingConfiguration 'packaging_configuration_id'",
      "packaging_configuration_id": "packaging_configuration_id",
      "manifest_urls":[
         "https://accd64649dc.egress.mediapackage-vod.us-west-2.amazonaws.com/out/v1/b9cc115bf7f1a/b848dfb116920772aa69ba/a3c74b1cae6a451c/index.m3u8"
      ]
   }
}
```

## Key Provider Notification Events<a name="key-provider-state-events"></a>

You get key provider notification events when you're using content encryption on an endpoint and MediaPackage can't reach the key provider\. For information about DRM and encryption, see [https://docs.aws.amazon.com/speke/latest/documentation/](https://docs.aws.amazon.com/speke/latest/documentation/)\.

**Example**  

```
{
   "id": "7bf73129-1428-4cd3-a780-98ds273d1602",
   "detail-type": "MediaPackage Key Provider Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2015-11-11T21:29:54Z",
   "region": "us-west-2",
   "resources":[
      "arn:aws:mediapackage:us-west-2:aws_account_id:origin_endpoints/70b44e2e666c4bdc9e5f4488e1f1aa99"
   ],
   "detail":{
      "event": "KeyProviderError",
      "message": "message-text"
   }
}
```

## Harvest Job Notification Events<a name="hj-status-events"></a>

You get harvest job status events when you export a clip from a live stream to create a live\-to\-VOD asset\. MediaPackage creates notifications when the harvest job succeeds or fails\. For information about harvest jobs and live\-to\-VOD assets, see [Creating Live\-to\-VOD Assets with AWS Elemental MediaPackage](ltov.md)\.

**Example Successful Harvest Job Event**  

```
{
   "id": "8f9b8e72-0b31-e883-f19c-aec84742f3ce",
   "detail-type": "MediaPackage HarvestJob Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2019-07-16T17:29:36Z",
   "region": "us-east-1",
   "resources":[
      "arn:aws:mediapackage:us-east-1:aws_account_id:harvest_jobs/harvest_job_id"
   ],
   "detail":{
      "harvest_job": {
          "id": "harvest_job_id",
          "arn": "arn:aws:mediapackage-vod:us-east-1:aws_account_id:harvest_jobs/harvest_job_id",
          "status": "COMPLETED",
          "origin_endpoint_id": "endpoint_id",
          "start_time": "2019-06-26T20:30:00-08:00",
          "end_time": "2019-06-26T21:00:00-08:00",
          "s3_destination": {
              "bucket_name": "s3_bucket_name",
              "manifest_key": "path/and/manifest_name/index.m3u8",
              "role_arn": "arn:aws:iam::aws_account_id:role/S3Access_role",
          },
          "created_at": "2019-06-26T21:03:12-08:00"
      }
   }
}
```

**Example Failed Harvest Job Event**  

```
{
   "id": "8f9b8e72-0b31-e883-f19c-aec84742f3ce",
   "detail-type": "MediaPackage HarvestJob Notification",
   "source": "aws.mediapackage",
   "account": "aws_account_id",
   "time": "2019-07-16T17:29:36Z",
   "region": "us-east-1",
   "resources":[
      "arn:aws:mediapackage:us-east-1:aws_account_id:harvest_jobs/harvest_job_id"
   ],
   "detail":{
      "harvest_job": {
          "id": "harvest_job_id",
          "arn": "arn:aws:mediapackage-vod:us-east-1:aws_account_id:harvest_jobs/harvest_job_id",
          "status": "FAILED",
          "origin_endpoint_id": "endpoint_id",
          "start_time": "2019-06-26T20:30:00-08:00",
          "end_time": "2019-06-26T21:00:00-08:00",
          "s3_destination": {
              "bucket_name": "s3_bucket_name",
              "manifest_key": "path/and/manifest_name/index.m3u8",
              "role_arn": "arn:aws:iam::aws_account_id:role/S3Access_role",
          },
          "created_at": "2019-06-26T21:03:12-08:00"
      },
      "message": "Message text"
   }
}
```