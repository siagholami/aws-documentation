# CreateDatasetGroup<a name="API_CreateDatasetGroup"></a>

Creates an empty dataset group\. A dataset group contains related datasets that supply data for training a model\. A dataset group can contain at most three datasets, one for each type of dataset:
+ Interactions
+ Items
+ Users

To train a model \(create a solution\), a dataset group that contains an `Interactions` dataset is required\. Call [CreateDataset](API_CreateDataset.md) to add a dataset to the group\.

A dataset group can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING

To get the status of the dataset group, call [DescribeDatasetGroup](API_DescribeDatasetGroup.md)\. If the status shows as CREATE FAILED, the response includes a `failureReason` key, which describes why the creation failed\.

**Note**  
You must wait until the `status` of the dataset group is `ACTIVE` before adding a dataset to the group\.

You can specify an AWS Key Management Service \(KMS\) key to encrypt the datasets in the group\. If you specify a KMS key, you must also include an AWS Identity and Access Management \(IAM\) role that has permission to access the key\.

**APIs that require a dataset group ARN in the request**
+  [CreateDataset](API_CreateDataset.md) 
+  [CreateEventTracker](API_CreateEventTracker.md) 
+  [CreateSolution](API_CreateSolution.md) 

**Related APIs**
+  [ListDatasetGroups](API_ListDatasetGroups.md) 
+  [DescribeDatasetGroup](API_DescribeDatasetGroup.md) 
+  [DeleteDatasetGroup](API_DeleteDatasetGroup.md) 

## Request Syntax<a name="API_CreateDatasetGroup_RequestSyntax"></a>

```
{
   "kmsKeyArn": "string",
   "name": "string",
   "roleArn": "string"
}
```

## Request Parameters<a name="API_CreateDatasetGroup_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [kmsKeyArn](#API_CreateDatasetGroup_RequestSyntax) **   <a name="personalize-CreateDatasetGroup-request-kmsKeyArn"></a>
The Amazon Resource Name \(ARN\) of a KMS key used to encrypt the datasets\.  
Type: String  
Required: No

 ** [name](#API_CreateDatasetGroup_RequestSyntax) **   <a name="personalize-CreateDatasetGroup-request-name"></a>
The name for the new dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

 ** [roleArn](#API_CreateDatasetGroup_RequestSyntax) **   <a name="personalize-CreateDatasetGroup-request-roleArn"></a>
The ARN of the IAM role that has permissions to access the KMS key\. Supplying an IAM role is only valid when also specifying a KMS key\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):iam::\d{12}:role/?[a-zA-Z_0-9+=,.@\-_/]+`   
Required: No

## Response Syntax<a name="API_CreateDatasetGroup_ResponseSyntax"></a>

```
{
   "datasetGroupArn": "string"
}
```

## Response Elements<a name="API_CreateDatasetGroup_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasetGroupArn](#API_CreateDatasetGroup_ResponseSyntax) **   <a name="personalize-CreateDatasetGroup-response-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the new dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

## Errors<a name="API_CreateDatasetGroup_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

## See Also<a name="API_CreateDatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateDatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateDatasetGroup) 