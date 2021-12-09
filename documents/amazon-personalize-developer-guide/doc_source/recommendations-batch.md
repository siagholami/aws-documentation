# Getting Batch Recommendations<a name="recommendations-batch"></a>

Use an asynchronous batch workflow to get recommendations from large datasets that do not require real\-time updates\. For instance, you might create a batch inference job to get product recommendations for all users on an email list, or to get [item\-to\-item similarities \(SIMS\)](native-recipe-sims.md) across an inventory\. To get batch recommendations, you can create a batch inference job by calling [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md)\.

In order to get batch recommendations, the IAM user role that invokes the [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md) operation must have read and write permissions to your input and output Amazon S3 buckets respectively\. For more information on bucket permissions, see [User Policy Examples](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-policies-s3.html) in the *Amazon Simple Storage Service \(S3\) Developer Guide*\.

You can perform batch inference operations with any of the following tools:
+ [Amazon Personalize console](#batch-console)
+ [AWS CLI](#batch-cli)
+ [AWS SDK](#batch-sdk)

**How scoring works**

Item scores calculated by batch recommendation jobs are calculated the same ways as described in [Getting Real\-Time Recommendations](getting-real-time-recommendations.md), and can be viewed in the batch job's output JSON file\. Scores are only returned by models trained with the HRNN and Personalize\-Ranking recipes\.

## Input and Output JSON Examples<a name="batch-recommendations-json-examples"></a>

The [CreateBatchInferenceJob](API_CreateBatchInferenceJob.md) uses a chosen solution version to make recommendations based on data provided in an input JSON file\. The result is then returned as a JSON file to an Amazon S3 bucket\. The following tab list contains correctly formatted JSON input and output examples for each recipe type\.

**HRNN and USER\_PERSONALIZATION**

------
#### [ Input ]

```
{"userId": "4638"}
{"userId": "663"}
{"userId": "3384"}
...
```

------
#### [ Output ]

```
{"input":{"userId":"4638"}, "output": {"recommendedItems": ["296", "1", "260", "318"]}, {"scores": [0.0009785, 0.000976, 0.0008851]}}
{"input":{"userId":"663"}, "output": {"recommendedItems": ["1393", "3793", "2701", "3826"]}, {"scores": [0.00008149, 0.00007025, 0.000652]}}
{"input":{"userId":"3384"}, "output": {"recommendedItems": ["8368", "5989", "40815", "48780"]}, {"scores": [0.003015, 0.00154, 0.00142]}}
...
```

------

**Popularity\-Count**

------
#### [ Input ]

```
{}
{"itemId": "105"}
{"itemId": "41"}
...
```

------
#### [ Output ]

```
{"input": {}, "output": {"recommendedItems": ["105", "106", "441"]}}
{"input": {"itemId": "105"}, "output": {"recommendedItems": ["105", "106", "441"]}}
{"input": {"itemId": "41"}, "output": {"recommendedItems": ["105", "106", "441"]}}
...
```

------

**Personalize\-Ranking**

------
#### [ Input ]

```
{"userId": "891", "itemList": ["27", "886", "101"]}
{"userId": "445", "itemList": ["527", "55", "901"]}
{"userId": "71", "itemList": ["27", "351", "101"]}
...
```

------
#### [ Output ]

```
{"input": {"userId": "891", "itemList": ["27", "886", "101"]}, "output": {"recommendedItems": ["27", "101", "886"]}, {"scores": [0.48421, 0.28133, 0.23446]}}
{"input": {"userId": "445", "itemList": ["527", "55", "901"]}, "output": {"recommendedItems": ["901", "527", "55"]}, {"scores": [0.46972, 0.31011, 0.22017]}}
{"input": {"userId": "71", "itemList": ["29", "351", "199"]}, "output": {"recommendedItems": ["351", "29", "199"]}, {"scores": [0.68937, 0.24829, 0.06232]}}
...
```

------

**SIMS**

------
#### [ Input ]

```
{"itemId": "105"}
{"itemId": "106"}
{"itemId": "441"}
...
```

------
#### [ Output ]

```
{"input": {"itemId": "105"}, "output": {"recommendedItems": ["106", "107", "49"]}, }
{"input": {"itemId": "106"}, "output": {"recommendedItems": ["105", "107", "49"]}}
{"input": {"itemId": "441"}, "output": {"recommendedItems": ["2", "442", "435"]}}
...
```

------

## Getting Batch Recommendations \(Amazon Personalize Console\)<a name="batch-console"></a>

The following procedure outlines the batch inference workflow using the Amazon Personalize console\. This procedure assumes that you have already created a solution that is properly formatted to perform the desired batch job on your dataset\.

1. Open the Amazon Personalize console at [https://console\.aws\.amazon\.com/personalize/home](https://console.aws.amazon.com/personalize/home) and sign in to your account\.

1. Choose **Batch inference jobs** in the navigation pane, then choose **Create batch inference job**\.

1. In **Batch inference job details**, in **Batch inference job name**, specify a name for your batch inference job\.

1. For **IAM service role**, choose the Amazon Personalize IAM service role that has read and write access to your input and output Amazon S3 buckets respectively\.

1. For **Solution**, choose the solution that you want to use to generate the recommendations The solution recipe must match the input data's format\.

1. In **Input data configuration**, specify the Amazon S3 path to your input file\. In **Output data configuration**, specify the path to your output Amazon S3 bucket\.

1. Choose **Create batch inference job**\. Batch inference job creation starts and the **Batch inference jobs** page appears with the **Batch inference job detail** section displayed\.

   Your screen should look similar to the following:  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/personalize/latest/dg/images/batch-job-result.png)
**Note**  
Creating a batch inference job takes time\.

1. When the batch inference job's status changes to **Active**, you can retrieve the job's output from the designated output Amazon S3 bucket\. The output file's name will be of the format `input-name.out`\.

## Getting Batch Recommendations \(AWS CLI\)<a name="batch-cli"></a>

The following is an example of a batch inference workflow using the AWS CLI for a solution trained using the the `USER_PERSONALIZATION` recipe\. A JSON file called `batch.json` is passed as input, and the output file, `batch.json.out`, is returned to an Amazon S3 bucket\. 

For `batch-inference-job-config`, the example includes `USER_PERSONALIZE` recipe specific `itemExplorationConfig` hyperparameters: `explorationWeight` and `explorationItemAgeCutOff`\. Optionally include `explorationWeight` and `explorationItemAgeCutOff` values to configure exploration\. For more information, see [User\-Personalization Recipe](native-recipe-new-item-USER_PERSONALIZATION.md)\.

```
aws personalize create-batch-inference-job --job-name batchTest \
                --solution-version-arn arn:aws:personalize:us-west-2:012345678901:solution/batch-test-solution-version/1234abcd \
                --job-input s3DataSource={path=s3://personalize/batch/input/input.json} \
                --job-output s3DataDestination={path=s3://personalize/batch/output/} \
                --role-arn arn:aws:iam::012345678901:role/import-export-role \
                --batch-inference-job-config itemExplorationConfig={explorationWeight=0.3, explorationItemAgeCutOff=30} 
      
{
   "batchInferenceJobArn": "arn:aws:personalize:us-west-2:012345678901:batch-inference-job/batchTest"
}
```

Once a batch inference job is created, you can inspect it further with the [DescribeBatchInferenceJob](API_DescribeBatchInferenceJob.md) operation\.

```
aws personalize describe-batch-inference-job --batch-inference-job-arn arn:aws:personalize:us-west-2:012345678901:batch-inference-job/batchTest

{
  "jobName": "batchTest",
  "batchInferenceJobArn": "arn:aws:personalize:us-west-2:012345678901:batch-inference-job/batchTest",
  "solutionVersionArn": "arn:aws:personalize:us-west-2:012345678901:solution/batch-test-solution-version/1234abcd",
  "jobInput": { 
      "s3DataSource": {
          "path": "s3://personalize/batch/input/batch.json"
        }
  },
  "jobOutput": { 
      "s3DataDestination": {
          "path": "s3://personalize/batch/output/" 
        }
  },
  "roleArn": "arn:aws:iam::012345678901:role/import-export-role",
  "status": "ACTIVE",
  "creationDateTime": 1542392161.837,
  "lastUpdateDateTime: 1542393013.377
}
```

## Getting Batch Recommendations \(AWS Python SDK\)<a name="batch-sdk"></a>

Use the following code to get batch recommendations using the AWS Python SDK\. The example includes `itemExplorationConfig` hyperparameters for solution versions trained using the `USER_PERSONALIZATION` recommendation recipe\. Optionally include the `itemExplorationConfig` hyperparameters to configure exploration\. For more information see [User\-Personalization Recipe](native-recipe-new-item-USER_PERSONALIZATION.md)\.

The operation reads an input JSON file from an Amazon S3 bucket and places an output JSON file \(`input-file-name.out`\) in an Amazon S3 bucket\.

 The first item in the response file is considered by Amazon Personalize to be of most interest to the user\.

```
import boto3

personalize_rec = boto3.client(service_name='personalize')

personalize_rec.create_batch_inference_job (
    solutionVersionArn = "Solution version ARN",
    jobName = "Batch job name",
    roleArn = "IAM role ARN",
    batchInferenceJobConfig = {
        # optional USER_PERSONALIZATION recipe hyperparameters
        "itemExplorationConfig": {      
            "explorationWeight": "0.3",
            "explorationItemAgeCutOff": "30"
        }
    },
    jobInput = 
       {"s3DataSource": {"path": "S3 input path"}},
    jobOutput = 
       {"s3DataDestination": {"path": "S3 output path"}}
)
```

The command returns the ARN for the batch job \(the `batchRecommendationsJobArn`\)\.

Processing the batch job might take a while to complete\. You can check a job's status by calling [DescribeBatchInferenceJob](API_DescribeBatchInferenceJob.md) and passing a `batchRecommendationsJobArn` as the input parameter\. You can also list all Amazon Personalize batch inference jobs in your AWS environment by calling [ListBatchInferenceJobs](API_ListBatchInferenceJobs.md)\.