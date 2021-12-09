# Filtering Batch Recommendations<a name="filter-batch"></a>

Filtering batch recommendations works nearly the same as filtering real\-time recommendations\. For both, you [create a filter](filter-real-time.md) and then apply it to a [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md) operation create a batch inference job using the console \(see [Getting Batch Recommendations \(Amazon Personalize Console\)](recommendations-batch.md#batch-console)\)\. Amazon Personalize removes filtered recommendations from the batch job’s output JSON file\.

You can use either the console or the AWS SDKs to filter batch recommendations\.

## Filtering Batch Recommendations \(Console\)<a name="filter-batch-recommendations-console"></a>

1.  Use the console or the SDK to [create a filter](filter-real-time.md)\. 

1. When you create the batch recommendation job, on the **Create batch inference job** page, for **Filter configuration \- optional**, **Filter name**, choose the filter\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/batch_filter.PNG)

## Filtering Batch Recommendations \(AWS SDK\)<a name="filter-batch-recommendations-sdk"></a>

1.  Use the console or the SDK to [create a filter](filter-real-time.md)\. 

1.  Include the `FilterArn` parameter in the [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md) request\. 

```
import boto3
     
personalize = boto3.client('personalize')
 
personalize_rec.create_batch_inference_job (
    solutionVersionArn = "Solution version ARN",
    jobName = "Batch job name",
    roleArn = "IAM role ARN",
    filterArn = "Filter ARN",
    jobInput = 
        {"s3DataSource": {"path": "S3 input path"}},
    jobOutput = 
        {"S3DataDestination": {"path": "S3 output path"}}
)
```