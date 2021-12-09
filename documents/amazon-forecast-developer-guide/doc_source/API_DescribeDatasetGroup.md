# DescribeDatasetGroup<a name="API_DescribeDatasetGroup"></a>

Describes a dataset group created using the [CreateDatasetGroup](API_CreateDatasetGroup.md) operation\.

In addition to listing the parameters provided in the `CreateDatasetGroup` request, this operation includes the following properties:
+  `DatasetArns` \- The datasets belonging to the group\.
+  `CreationTime` 
+  `LastModificationTime` 
+  `Status` 

## Request Syntax<a name="API_DescribeDatasetGroup_RequestSyntax"></a>

```
{
   "DatasetGroupArn": "string"
}
```

## Request Parameters<a name="API_DescribeDatasetGroup_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetGroupArn](#API_DescribeDatasetGroup_RequestSyntax) **   <a name="forecast-DescribeDatasetGroup-request-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Syntax<a name="API_DescribeDatasetGroup_ResponseSyntax"></a>

```
{
   "CreationTime": number,
   "DatasetArns": [ "string" ],
   "DatasetGroupArn": "string",
   "DatasetGroupName": "string",
   "Domain": "string",
   "LastModificationTime": number,
   "Status": "string"
}
```

## Response Elements<a name="API_DescribeDatasetGroup_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [CreationTime](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-CreationTime"></a>
When the dataset group was created\.  
Type: Timestamp

 ** [DatasetArns](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-DatasetArns"></a>
An array of Amazon Resource Names \(ARNs\) of the datasets contained in the dataset group\.  
Type: Array of strings  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [DatasetGroupArn](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-DatasetGroupArn"></a>
The ARN of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [DatasetGroupName](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-DatasetGroupName"></a>
The name of the dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*` 

 ** [Domain](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-Domain"></a>
The domain associated with the dataset group\.  
Type: String  
Valid Values:` RETAIL | CUSTOM | INVENTORY_PLANNING | EC2_CAPACITY | WORK_FORCE | WEB_TRAFFIC | METRICS` 

 ** [LastModificationTime](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-LastModificationTime"></a>
When the dataset group was created or last updated from a call to the [UpdateDatasetGroup](API_UpdateDatasetGroup.md) operation\. While the dataset group is being updated, `LastModificationTime` is the current time of the `DescribeDatasetGroup` call\.  
Type: Timestamp

 ** [Status](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="forecast-DescribeDatasetGroup-response-Status"></a>
The status of the dataset group\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
+  `UPDATE_PENDING`, `UPDATE_IN_PROGRESS`, `UPDATE_FAILED` 
The `UPDATE` states apply when you call the [UpdateDatasetGroup](API_UpdateDatasetGroup.md) operation\.  
The `Status` of the dataset group must be `ACTIVE` before you can use the dataset group to create a predictor\.
Type: String  
Length Constraints: Maximum length of 256\.

## Errors<a name="API_DescribeDatasetGroup_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeDatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DescribeDatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DescribeDatasetGroup) 