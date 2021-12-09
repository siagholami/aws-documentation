# Reprocessing Channel Data<a name="reprocessing"></a>

AWS IoT Analytics allows you to reprocess channel data or, to put it another way, to replay existing raw data through a pipeline\. This can be useful if:
+ You want to replay existing ingested data rather than starting over\.
+ You make an update to a pipeline and want to bring existing data up\-to\-date with the changes\.
+ You make changes to your customer\-based storage options or permissions for channels or data stores and you want to include data which was ingested before these changes in data set contents going forward\.

To trigger the reprocessing of existing raw data, use the [StartPipelineReprocessing](api.md#cli-iotanalytics-startpipelinereprocessing) command\. Note the following:
+ The "startTime" and "endTime" parameters specify when the raw data was ingested, but these are rough estimates\. You can round to the nearest hour\. The "startTime" is inclusive, but the "endTime" is exclusive\.
+ The command launches the reprocessing asynchronously and returns immediately\.
+ There is no guarantee that reprocessed messages are processed in the order they were originally received\. It is roughly the same, but not exact\.
+ Reprocessing your raw data will incur additional costs\.

To cancel the reprocessing of existing raw data, use the [CancelPipelineReprocessing](api.md#cli-iotanalytics-cancelpipelinereprocessing) command\.

Use the [DescribePipeline](api.md#cli-iotanalytics-describepipeline) command to check the status of the reprocessing\. See the "reprocessingSummaries" field in the response\.