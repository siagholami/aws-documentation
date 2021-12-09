# CreateDataset<a name="API_CreateDataset"></a>

Creates an empty dataset and adds it to the specified dataset group\. Use [CreateDatasetImportJob](API_CreateDatasetImportJob.md) to import your training data to a dataset\.

There are three types of datasets:
+ Interactions
+ Items
+ Users

Each dataset type has an associated schema with required field types\. Only the `Interactions` dataset is required in order to train a model \(also referred to as creating a solution\)\.

A dataset can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS

To get the status of the dataset, call [DescribeDataset](API_DescribeDataset.md)\.

**Related APIs**
+  [CreateDatasetGroup](API_CreateDatasetGroup.md) 
+  [ListDatasets](API_ListDatasets.md) 
+  [DescribeDataset](API_DescribeDataset.md) 
+  [DeleteDataset](API_DeleteDataset.md) 

## Request Syntax<a name="API_CreateDataset_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "datasetType": "string",
   "name": "string",
   "schemaArn": "string"
}
```

## Request Parameters<a name="API_CreateDataset_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_CreateDataset_RequestSyntax) **   <a name="personalize-CreateDataset-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group to add the dataset to\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

 ** [datasetType](#API_CreateDataset_RequestSyntax) **   <a name="personalize-CreateDataset-request-datasetType"></a>
The type of dataset\.  
One of the following \(case insensitive\) values:  
+ Interactions
+ Items
+ Users
Type: String  
Length Constraints: Maximum length of 256\.  
Required: Yes

 ** [name](#API_CreateDataset_RequestSyntax) **   <a name="personalize-CreateDataset-request-name"></a>
The name for the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [schemaArn](#API_CreateDataset_RequestSyntax) **   <a name="personalize-CreateDataset-request-schemaArn"></a>
The ARN of the schema to associate with the dataset\. The schema defines the dataset fields\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_CreateDataset_ResponseSyntax"></a>

```
{
   "datasetArn": "string"
}
```

## Response Elements<a name="API_CreateDataset_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasetArn](#API_CreateDataset_ResponseSyntax) **   <a name="personalize-CreateDataset-response-datasetArn"></a>
The ARN of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateDataset_Errors"></a>

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

## See Also<a name="API_CreateDataset_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateDataset) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateDataset) 