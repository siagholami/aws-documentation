# CreateDatasetGroup<a name="API_CreateDatasetGroup"></a>

Creates a dataset group, which holds a collection of related datasets\. You can add datasets to the dataset group when you create the dataset group, or later by using the [UpdateDatasetGroup](API_UpdateDatasetGroup.md) operation\.

After creating a dataset group and adding datasets, you use the dataset group when you create a predictor\. For more information, see [Datasets and Dataset Groups](howitworks-datasets-groups.md)\.

To get a list of all your datasets groups, use the [ListDatasetGroups](API_ListDatasetGroups.md) operation\.

**Note**  
The `Status` of a dataset group must be `ACTIVE` before you can use the dataset group to create a predictor\. To get the status, use the [DescribeDatasetGroup](API_DescribeDatasetGroup.md) operation\.

## Request Syntax<a name="API_CreateDatasetGroup_RequestSyntax"></a>

```
{
   "DatasetArns": [ "string" ],
   "DatasetGroupName": "string",
   "Domain": "string",
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_CreateDatasetGroup_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetArns](#API_CreateDatasetGroup_RequestSyntax) **   <a name="forecast-CreateDatasetGroup-request-DatasetArns"></a>
An array of Amazon Resource Names \(ARNs\) of the datasets that you want to include in the dataset group\.  
Type: Array of strings  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: No

 ** [DatasetGroupName](#API_CreateDatasetGroup_RequestSyntax) **   <a name="forecast-CreateDatasetGroup-request-DatasetGroupName"></a>
A name for the dataset group\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 ** [Domain](#API_CreateDatasetGroup_RequestSyntax) **   <a name="forecast-CreateDatasetGroup-request-Domain"></a>
The domain associated with the dataset group\. When you add a dataset to a dataset group, this value and the value specified for the `Domain` parameter of the [CreateDataset](API_CreateDataset.md) operation must match\.  
The `Domain` and `DatasetType` that you choose determine the fields that must be present in training data that you import to a dataset\. For example, if you choose the `RETAIL` domain and `TARGET_TIME_SERIES` as the `DatasetType`, Amazon Forecast requires that `item_id`, `timestamp`, and `demand` fields are present in your data\. For more information, see [Datasets and Dataset Groups](howitworks-datasets-groups.md)\.  
Type: String  
Valid Values:` RETAIL | CUSTOM | INVENTORY_PLANNING | EC2_CAPACITY | WORK_FORCE | WEB_TRAFFIC | METRICS`   
Required: Yes

 ** [Tags](#API_CreateDatasetGroup_RequestSyntax) **   <a name="forecast-CreateDatasetGroup-request-Tags"></a>
The optional metadata that you apply to the dataset group to help you categorize and organize them\. Each tag consists of a key and an optional value, both of which you define\.  
The following basic restrictions apply to tags:  
+ Maximum number of tags per resource \- 50\.
+ For each resource, each tag key must be unique, and each tag key can have only one value\.
+ Maximum key length \- 128 Unicode characters in UTF\-8\.
+ Maximum value length \- 256 Unicode characters in UTF\-8\.
+ If your tagging schema is used across multiple services and resources, remember that other services may have restrictions on allowed characters\. Generally allowed characters are: letters, numbers, and spaces representable in UTF\-8, and the following characters: \+ \- = \. \_ : / @\.
+ Tag keys and values are case sensitive\.
+ Do not use `aws:`, `AWS:`, or any upper or lowercase combination of such as a prefix for keys as it is reserved for AWS use\. You cannot edit or delete tag keys with this prefix\. Values can have this prefix\. If a tag value has `aws` as its prefix but the key does not, then Forecast considers it to be a user tag and will count against the limit of 50 tags\. Tags with only the key prefix of `aws` do not count against your tags per resource limit\.
Type: Array of [Tag](API_Tag.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 200 items\.  
Required: No

## Response Syntax<a name="API_CreateDatasetGroup_ResponseSyntax"></a>

```
{
   "DatasetGroupArn": "string"
}
```

## Response Elements<a name="API_CreateDatasetGroup_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [DatasetGroupArn](#API_CreateDatasetGroup_ResponseSyntax) **   <a name="forecast-CreateDatasetGroup-response-DatasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

## Errors<a name="API_CreateDatasetGroup_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of resources per account has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
There is already a resource with this name\. Try again with a different name\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_CreateDatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/CreateDatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/CreateDatasetGroup) 