# ListDatasetImportJobs<a name="API_ListDatasetImportJobs"></a>

Returns a list of dataset import jobs that use the given dataset\. When a dataset is not specified, all the dataset import jobs associated with the account are listed\. The response provides the properties for each dataset import job, including the Amazon Resource Name \(ARN\)\. For more information on dataset import jobs, see [CreateDatasetImportJob](API_CreateDatasetImportJob.md)\. For more information on datasets, see [CreateDataset](API_CreateDataset.md)\.

## Request Syntax<a name="API_ListDatasetImportJobs_RequestSyntax"></a>

```
{
   "datasetArn": "string",
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListDatasetImportJobs_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetArn](#API_ListDatasetImportJobs_RequestSyntax) **   <a name="personalize-ListDatasetImportJobs-request-datasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset to list the dataset import jobs for\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [maxResults](#API_ListDatasetImportJobs_RequestSyntax) **   <a name="personalize-ListDatasetImportJobs-request-maxResults"></a>
The maximum number of dataset import jobs to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListDatasetImportJobs_RequestSyntax) **   <a name="personalize-ListDatasetImportJobs-request-nextToken"></a>
A token returned from the previous call to `ListDatasetImportJobs` for getting the next set of dataset import jobs \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListDatasetImportJobs_ResponseSyntax"></a>

```
{
   "datasetImportJobs": [ 
      { 
         "creationDateTime": number,
         "datasetImportJobArn": "string",
         "failureReason": "string",
         "jobName": "string",
         "lastUpdatedDateTime": number,
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListDatasetImportJobs_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasetImportJobs](#API_ListDatasetImportJobs_ResponseSyntax) **   <a name="personalize-ListDatasetImportJobs-response-datasetImportJobs"></a>
The list of dataset import jobs\.  
Type: Array of [DatasetImportJobSummary](API_DatasetImportJobSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListDatasetImportJobs_ResponseSyntax) **   <a name="personalize-ListDatasetImportJobs-response-nextToken"></a>
A token for getting the next set of dataset import jobs \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListDatasetImportJobs_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListDatasetImportJobs_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListDatasetImportJobs) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListDatasetImportJobs) 