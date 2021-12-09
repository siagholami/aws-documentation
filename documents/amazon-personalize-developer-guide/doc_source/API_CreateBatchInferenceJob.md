# CreateBatchInferenceJob<a name="API_CreateBatchInferenceJob"></a>

Creates a batch inference job\. The operation can handle up to 50 million records and the input file must be in JSON format\. For more information, see [Getting Batch Recommendations](recommendations-batch.md)\.

## Request Syntax<a name="API_CreateBatchInferenceJob_RequestSyntax"></a>

```
{
   "batchInferenceJobConfig": { 
      "itemExplorationConfig": { 
         "string" : "string" 
      }
   },
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
   "numResults": number,
   "roleArn": "string",
   "solutionVersionArn": "string"
}
```

## Request Parameters<a name="API_CreateBatchInferenceJob_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [batchInferenceJobConfig](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-batchInferenceJobConfig"></a>
The configuration details of a batch inference job\.  
Type: [BatchInferenceJobConfig](API_BatchInferenceJobConfig.md) object  
Required: No

 ** [filterArn](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-filterArn"></a>
The ARN of the filter to apply to the batch inference job\. For more information on using filters, see Using Filters with Amazon Personalize\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [jobInput](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-jobInput"></a>
The Amazon S3 path that leads to the input file to base your recommendations on\. The input material must be in JSON format\.  
Type: [BatchInferenceJobInput](API_BatchInferenceJobInput.md) object  
Required: Yes

 ** [jobName](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-jobName"></a>
The name of the batch inference job to create\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [jobOutput](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-jobOutput"></a>
The path to the Amazon S3 bucket where the job's output will be stored\.  
Type: [BatchInferenceJobOutput](API_BatchInferenceJobOutput.md) object  
Required: Yes

 ** [numResults](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-numResults"></a>
The number of recommendations to retreive\.  
Type: Integer  
Required: No

 ** [roleArn](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-roleArn"></a>
The ARN of the Amazon Identity and Access Management role that has permissions to read and write to your input and out Amazon S3 buckets respectively\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):iam::\d{12}:role/?[a-zA-Z_0-9+=,.@\-_/]+`   
Required: Yes

 ** [solutionVersionArn](#API_CreateBatchInferenceJob_RequestSyntax) **   <a name="personalize-CreateBatchInferenceJob-request-solutionVersionArn"></a>
The Amazon Resource Name \(ARN\) of the solution version that will be used to generate the batch inference recommendations\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_CreateBatchInferenceJob_ResponseSyntax"></a>

```
{
   "batchInferenceJobArn": "string"
}
```

## Response Elements<a name="API_CreateBatchInferenceJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [batchInferenceJobArn](#API_CreateBatchInferenceJob_ResponseSyntax) **   <a name="personalize-CreateBatchInferenceJob-response-batchInferenceJobArn"></a>
The ARN of the batch inference job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateBatchInferenceJob_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_CreateBatchInferenceJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateBatchInferenceJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateBatchInferenceJob) 