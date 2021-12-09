# DescribeBatchInferenceJob<a name="API_DescribeBatchInferenceJob"></a>

Gets the properties of a batch inference job including name, Amazon Resource Name \(ARN\), status, input and output configurations, and the ARN of the solution version used to generate the recommendations\.

## Request Syntax<a name="API_DescribeBatchInferenceJob_RequestSyntax"></a>

```
{
   "batchInferenceJobArn": "string"
}
```

## Request Parameters<a name="API_DescribeBatchInferenceJob_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [batchInferenceJobArn](#API_DescribeBatchInferenceJob_RequestSyntax) **   <a name="personalize-DescribeBatchInferenceJob-request-batchInferenceJobArn"></a>
The ARN of the batch inference job to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeBatchInferenceJob_ResponseSyntax"></a>

```
{
   "batchInferenceJob": { 
      "batchInferenceJobArn": "string",
      "batchInferenceJobConfig": { 
         "itemExplorationConfig": { 
            "string" : "string" 
         }
      },
      "creationDateTime": number,
      "failureReason": "string",
      "filterArn": "string",
      "jobInput": { 
         "s3DataSource": { 
            "kmsKeyArn": "string",
            "path": "string"
         }
      },
      "jobName": "string",
      "jobOutput": { 
         "s3DataDestination": { 
            "kmsKeyArn": "string",
            "path": "string"
         }
      },
      "lastUpdatedDateTime": number,
      "numResults": number,
      "roleArn": "string",
      "solutionVersionArn": "string",
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeBatchInferenceJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [batchInferenceJob](#API_DescribeBatchInferenceJob_ResponseSyntax) **   <a name="personalize-DescribeBatchInferenceJob-response-batchInferenceJob"></a>
Information on the specified batch inference job\.  
Type: [BatchInferenceJob](API_BatchInferenceJob.md) object

## Errors<a name="API_DescribeBatchInferenceJob_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeBatchInferenceJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeBatchInferenceJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeBatchInferenceJob) 