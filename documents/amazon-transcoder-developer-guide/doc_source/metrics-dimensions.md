# Elastic Transcoder Metrics and Dimensions<a name="metrics-dimensions"></a>

When you create a job, Elastic Transcoder sends the following metrics and dimensions to CloudWatch every minute\. You can use the following procedures to view the metrics for Elastic Transcoder\.

**To view metrics using the CloudWatch console**

Metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\.

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. If necessary, change the region\. From the navigation bar, select the region where your AWS resources reside\. For more information, see [Regions and Endpoints](http://docs.aws.amazon.com/general/latest/gr/rande.html)\.

1. In the navigation pane, choose **Metrics**\.

1. In the **CloudWatch Metrics by Category** pane, under the metrics category for Elastic Transcoder, select a metrics category, and then in the upper pane, scroll down to view the full list of metrics\.

**To view metrics using the AWS CLI**
+ At a command prompt, use the following command:

  ```
  1. aws cloudwatch list-metrics --namespace "AWS/ElasticTranscoder"
  ```

CloudWatch displays the following metrics for Elastic Transcoder:

## Elastic Transcoder Dimensions and Metrics<a name="YourService-metrics-dimensions"></a>

The metrics and dimensions that Elastic Transcoder sends to Amazon CloudWatch are listed below\.

### Elastic Transcoder Metrics<a name="ET-metrics"></a>

The `AWS/ElasticTranscoder` namespace includes the following metrics\.


| Metric | Description | 
| --- | --- | 
|  `Billed HD Output` |  The number of billable seconds of HD output for a pipeline\. Valid Dimensions: PipelineId Unit: Seconds  | 
|  `Billed SD Output` |  The number of billable seconds of SD output for a pipeline\. Valid Dimensions: PipelineId Unit: Seconds  | 
|  `Billed Audio Output` |  The number of billable seconds of audio output for a pipeline\. Valid Dimensions: PipelineId Unit: Seconds  | 
|  `Jobs Completed` |  The number of jobs completed by this pipeline\. Valid Dimensions: PipelineId Unit: Count  | 
|  `Jobs Errored` |  The number of jobs that failed because of invalid inputs, such as a request to transcode a file that is not in the given input bucket\. Valid Dimensions: PipelineId Unit: Count  | 
|  `Outputs per Job` |  The number of outputs Elastic Transcoder created for a job\. Valid Dimensions: PipelineId Unit: Count  | 
|  `Standby Time` |  The number of seconds before Elastic Transcoder started transcoding a job\. Valid Dimensions: PipelineId Unit: Seconds  | 
|  `Errors` |  The number of errors caused by invalid operation parameters, such as a request for a job status that does not include the job ID\. Valid Dimensions: Operation Unit: Count  | 
|  `Throttles` |  The number of times that Elastic Transcoder automatically throttled an operation\. Valid Dimensions: Operation Unit: Count  | 

### Dimensions for Elastic Transcoder Metrics<a name="ET-metricdimensions"></a>

Elastic Transcoder metrics use the Elastic Transcoder namespace and provide metrics for the following dimension\(s\):


| Dimension | Description | 
| --- | --- | 
|  `PipelineId`  |  The ID of a pipeline\. This dimension filters the data you request for an Elastic Transcoder pipeline\.  | 
|  `Operation`  |  This dimension filters the data you request for the APIs that Elastic Transcoder provides\.  | 