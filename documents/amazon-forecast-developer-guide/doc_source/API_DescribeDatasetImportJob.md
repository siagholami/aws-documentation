# DescribeDatasetImportJob<a name="API_DescribeDatasetImportJob"></a>

Describes a dataset import job created using the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) operation\.

In addition to listing the parameters provided in the `CreateDatasetImportJob` request, this operation includes the following properties:
+  `CreationTime` 
+  `LastModificationTime` 
+  `DataSize` 
+  `FieldStatistics` 
+  `Status` 
+  `Message` \- If an error occurred, information about the error\.

## Request Syntax<a name="API_DescribeDatasetImportJob_RequestSyntax"></a>

```
{
   "DatasetImportJobArn": "string"
}
```

## Request Parameters<a name="API_DescribeDatasetImportJob_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetImportJobArn](#API_DescribeDatasetImportJob_RequestSyntax) **   <a name="forecast-DescribeDatasetImportJob-request-DatasetImportJobArn"></a>
The Amazon Resource Name \(ARN\) of the dataset import job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Syntax<a name="API_DescribeDatasetImportJob_ResponseSyntax"></a>

```
{
   "CreationTime": number,
   "DatasetArn": "string",
   "DatasetImportJobArn": "string",
   "DatasetImportJobName": "string",
   "DataSize": number,
   "DataSource": { 
      "S3Config": { 
         "KMSKeyArn": "string",
         "Path": "string",
         "RoleArn": "string"
      }
   },
   "FieldStatistics": { 
      "string" : { 
         "Avg": number,
         "Count": number,
         "CountDistinct": number,
         "CountNan": number,
         "CountNull": number,
         "Max": "string",
         "Min": "string",
         "Stddev": number
      }
   },
   "LastModificationTime": number,
   "Message": "string",
   "Status": "string",
   "TimestampFormat": "string"
}
```

## Response Elements<a name="API_DescribeDatasetImportJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [CreationTime](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-CreationTime"></a>
When the dataset import job was created\.  
Type: Timestamp

 ** [DatasetArn](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset that the training data was imported to\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [DatasetImportJobArn](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-DatasetImportJobArn"></a>
The ARN of the dataset import job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [DatasetImportJobName](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-DatasetImportJobName"></a>
The name of the dataset import job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*` 

 ** [DataSize](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-DataSize"></a>
The size of the dataset in gigabytes \(GB\) after the import job has finished\.  
Type: Double

 ** [DataSource](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-DataSource"></a>
The location of the training data to import and an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the data\.  
If encryption is used, `DataSource` includes an AWS Key Management Service \(KMS\) key\.  
Type: [DataSource](API_DataSource.md) object

 ** [FieldStatistics](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-FieldStatistics"></a>
Statistical information about each field in the input data\.  
Type: String to [Statistics](API_Statistics.md) object map  
Key Length Constraints: Maximum length of 256\.  
Key Pattern: `^[a-zA-Z0-9\_]+$` 

 ** [LastModificationTime](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-LastModificationTime"></a>
The last time that the dataset was modified\. The time depends on the status of the job, as follows:  
+  `CREATE_PENDING` \- The same time as `CreationTime`\.
+  `CREATE_IN_PROGRESS` \- The current timestamp\.
+  `ACTIVE` or `CREATE_FAILED` \- When the job finished or failed\.
Type: Timestamp

 ** [Message](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String

 ** [Status](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-Status"></a>
The status of the dataset import job\. The status is reflected in the status of the dataset\. For example, when the import job status is `CREATE_IN_PROGRESS`, the status of the dataset is `UPDATE_IN_PROGRESS`\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
Type: String  
Length Constraints: Maximum length of 256\.

 ** [TimestampFormat](#API_DescribeDatasetImportJob_ResponseSyntax) **   <a name="forecast-DescribeDatasetImportJob-response-TimestampFormat"></a>
The format of timestamps in the dataset\. The format that you specify depends on the `DataFrequency` specified when the dataset was created\. The following formats are supported  
+ "yyyy\-MM\-dd"

  For the following data frequencies: Y, M, W, and D
+ "yyyy\-MM\-dd HH:mm:ss"

  For the following data frequencies: H, 30min, 15min, and 1min; and optionally, for: Y, M, W, and D
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\:\.\,\'\s]+$` 

## Errors<a name="API_DescribeDatasetImportJob_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeDatasetImportJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DescribeDatasetImportJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DescribeDatasetImportJob) 