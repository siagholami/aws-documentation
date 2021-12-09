# Amazon Kinesis Data Firehose Quota<a name="limits"></a>

Amazon Kinesis Data Firehose has the following quota\. 
+ By default, each account can have up to 50 Kinesis Data Firehose delivery streams per Region\. If you exceed this number, a call to [https://docs.aws.amazon.com/firehose/latest/APIReference/API_CreateDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_CreateDeliveryStream.html) results in a `LimitExceededException` exception\. To increase this quota, you can use [Service Quotas](https://console.aws.amazon.com/servicequotas/) if it's available in your Region\. For information about using Service Quotas, see [Requesting a Quota Increase](https://docs.aws.amazon.com/servicequotas/latest/userguide/request-increase.html)\. If Service Quotas isn't available in your region, you can use the [Amazon Kinesis Data Firehose Limits form](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-kinesis-firehose) to request an increase\.
+ When **Direct PUT** is configured as the data source, each Kinesis Data Firehose delivery stream provides the following combined quota for [PutRecord](https://docs.aws.amazon.com/firehose/latest/APIReference/API_PutRecord.html) and [PutRecordBatch](https://docs.aws.amazon.com/firehose/latest/APIReference/API_PutRecordBatch.html) requests:
  + For US East \(N\. Virginia\), US West \(Oregon\), and Europe \(Ireland\): 5,000 records/second, 2,000 requests/second, and 5 MiB/second\.
  + For US East \(Ohio\), US West \(N\. California\), AWS GovCloud \(US\-East\), AWS GovCloud \(US\-West\), Asia Pacific \(Hong Kong\), Asia Pacific \(Mumbai\), Asia Pacific \(Seoul\), Asia Pacific \(Singapore\), Asia Pacific \(Sydney\), Asia Pacific \(Tokyo\), Canada \(Central\), Europe \(Frankfurt\), Europe \(London\), Europe \(Paris\), Europe \(Stockholm\), Middle East \(Bahrain\), South America \(São Paulo\), Africa \(Cape Town\), and Europe \(Milan\): 1,000 records/second, 1,000 requests/second, and 1 MiB/second\. 

  To request an increase in quota, use the [Amazon Kinesis Data Firehose Limits form](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-kinesis-firehose)\. The three quota scale proportionally\. For example, if you increase the throughput quota in US East \(N\. Virginia\), US West \(Oregon\), or Europe \(Ireland\) to 10 MiB/second, the other two quota increase to 4,000 requests/second and 10,000 records/second\.
**Important**  
If the increased quota is much higher than the running traffic, it causes small delivery batches to destinations\. This is inefficient and can result in higher costs at the destination services\. Be sure to increase the quota only to match current running traffic, and increase the quota further if traffic increases\.
**Note**  
When Kinesis Data Streams is configured as the data source, this quota doesn't apply, and Kinesis Data Firehose scales up and down with no limit\. 
+ Each Kinesis Data Firehose delivery stream stores data records for up to 24 hours in case the delivery destination is unavailable\.
+ The maximum size of a record sent to Kinesis Data Firehose, before base64\-encoding, is 1,000 KiB\.
+ The [PutRecordBatch](https://docs.aws.amazon.com/firehose/latest/APIReference/API_PutRecordBatch.html) operation can take up to 500 records per call or 4 MiB per call, whichever is smaller\. This quota cannot be changed\.
+ The following operations can provide up to five invocations per second: [https://docs.aws.amazon.com/firehose/latest/APIReference/API_CreateDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_CreateDeliveryStream.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_DeleteDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_DeleteDeliveryStream.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_DescribeDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_DescribeDeliveryStream.html), `[ListDeliveryStreams](https://docs.aws.amazon.com/firehose/latest/APIReference/API_ListDeliveryStreams.html)`, [https://docs.aws.amazon.com/firehose/latest/APIReference/API_UpdateDestination.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_UpdateDestination.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_TagDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_TagDeliveryStream.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_UntagDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_UntagDeliveryStream.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_ListTagsForDeliveryStream.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_ListTagsForDeliveryStream.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_StartDeliveryStreamEncryption.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_StartDeliveryStreamEncryption.html), [https://docs.aws.amazon.com/firehose/latest/APIReference/API_StopDeliveryStreamEncryption.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_StopDeliveryStreamEncryption.html)\. 
+ The buffer sizes hints range from 1 MiB to 128 MiB for Amazon S3 delivery\. For Amazon Elasticsearch Service \(Amazon ES\) delivery, they range from 1 MiB to 100 MiB\. For AWS Lambda processing, you can set a buffering hint between 1 MiB and 3 MiB using the [https://docs.aws.amazon.com/firehose/latest/APIReference/API_ProcessorParameter.html](https://docs.aws.amazon.com/firehose/latest/APIReference/API_ProcessorParameter.html) processor parameter\. The size threshold is applied to the buffer before compression\. These options are treated as hints\. Kinesis Data Firehose might choose to use different values when it is optimal\. 
+ The buffer interval hints range from 60 seconds to 900 seconds\.
+ For delivery from Kinesis Data Firehose to Amazon Redshift, only publicly accessible Amazon Redshift clusters are supported\.
+ The retry duration range is from 0 seconds to 7,200 seconds for Amazon Redshift and Amazon ES delivery\.
+ Kinesis Data Firehose supports Elasticsearch versions 1\.5, 2\.3, 5\.1, 5\.3, 5\.5, 5\.6, as well as all 6\.\* and 7\.\* versions\.
+ When the destination is Amazon S3, Amazon Redshift, or Amazon ES, Kinesis Data Firehose allows up to 5 outstanding Lambda invocations per shard\. For Splunk, the quota is 10 outstanding Lambda invocations per shard\. 
+ You can use a CMK of type CUSTOMER\_MANAGED\_CMK to encrypt up to 500 delivery streams\.