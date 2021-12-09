# DescribeDataset<a name="API_DescribeDataset"></a>

Describes an Amazon Forecast dataset created using the [CreateDataset](API_CreateDataset.md) operation\.

In addition to listing the parameters specified in the `CreateDataset` request, this operation includes the following dataset properties:
+  `CreationTime` 
+  `LastModificationTime` 
+  `Status` 

## Request Syntax<a name="API_DescribeDataset_RequestSyntax"></a>

```
{
   "DatasetArn": "string"
}
```

## Request Parameters<a name="API_DescribeDataset_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetArn](#API_DescribeDataset_RequestSyntax) **   <a name="forecast-DescribeDataset-request-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Syntax<a name="API_DescribeDataset_ResponseSyntax"></a>

```
{
   "CreationTime": number,
   "DataFrequency": "string",
   "DatasetArn": "string",
   "DatasetName": "string",
   "DatasetType": "string",
   "Domain": "string",
   "EncryptionConfig": { 
      "KMSKeyArn": "string",
      "RoleArn": "string"
   },
   "LastModificationTime": number,
   "Schema": { 
      "Attributes": [ 
         { 
            "AttributeName": "string",
            "AttributeType": "string"
         }
      ]
   },
   "Status": "string"
}
```

## Response Elements<a name="API_DescribeDataset_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [CreationTime](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-CreationTime"></a>
When the dataset was created\.  
Type: Timestamp

 ** [DataFrequency](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-DataFrequency"></a>
The frequency of data collection\.  
Valid intervals are Y \(Year\), M \(Month\), W \(Week\), D \(Day\), H \(Hour\), 30min \(30 minutes\), 15min \(15 minutes\), 10min \(10 minutes\), 5min \(5 minutes\), and 1min \(1 minute\)\. For example, "M" indicates every month and "30min" indicates every 30 minutes\.  
Type: String  
Pattern: `^Y|M|W|D|H|30min|15min|10min|5min|1min$` 

 ** [DatasetArn](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [DatasetName](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-DatasetName"></a>
The name of the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*` 

 ** [DatasetType](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-DatasetType"></a>
The dataset type\.  
Type: String  
Valid Values:` TARGET_TIME_SERIES | RELATED_TIME_SERIES | ITEM_METADATA` 

 ** [Domain](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-Domain"></a>
The domain associated with the dataset\.  
Type: String  
Valid Values:` RETAIL | CUSTOM | INVENTORY_PLANNING | EC2_CAPACITY | WORK_FORCE | WEB_TRAFFIC | METRICS` 

 ** [EncryptionConfig](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-EncryptionConfig"></a>
The AWS Key Management Service \(KMS\) key and the AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the key\.  
Type: [EncryptionConfig](API_EncryptionConfig.md) object

 ** [LastModificationTime](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-LastModificationTime"></a>
When you create a dataset, `LastModificationTime` is the same as `CreationTime`\. While data is being imported to the dataset, `LastModificationTime` is the current time of the `DescribeDataset` call\. After a [CreateDatasetImportJob](API_CreateDatasetImportJob.md) operation has finished, `LastModificationTime` is when the import job completed or failed\.  
Type: Timestamp

 ** [Schema](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-Schema"></a>
An array of `SchemaAttribute` objects that specify the dataset fields\. Each `SchemaAttribute` specifies the name and data type of a field\.  
Type: [Schema](API_Schema.md) object

 ** [Status](#API_DescribeDataset_ResponseSyntax) **   <a name="forecast-DescribeDataset-response-Status"></a>
The status of the dataset\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
+  `UPDATE_PENDING`, `UPDATE_IN_PROGRESS`, `UPDATE_FAILED` 
The `UPDATE` states apply while data is imported to the dataset from a call to the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) operation and reflect the status of the dataset import job\. For example, when the import job status is `CREATE_IN_PROGRESS`, the status of the dataset is `UPDATE_IN_PROGRESS`\.  
The `Status` of the dataset must be `ACTIVE` before you can import training data\.
Type: String  
Length Constraints: Maximum length of 256\.

## Errors<a name="API_DescribeDataset_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeDataset_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DescribeDataset) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DescribeDataset) 