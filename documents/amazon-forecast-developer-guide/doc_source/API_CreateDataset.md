# CreateDataset<a name="API_CreateDataset"></a>

Creates an Amazon Forecast dataset\. The information about the dataset that you provide helps Forecast understand how to consume the data for model training\. This includes the following:
+  * `DataFrequency` * \- How frequently your historical time\-series data is collected\.
+  * `Domain` * and * `DatasetType` * \- Each dataset has an associated dataset domain and a type within the domain\. Amazon Forecast provides a list of predefined domains and types within each domain\. For each unique dataset domain and type within the domain, Amazon Forecast requires your data to include a minimum set of predefined fields\.
+  * `Schema` * \- A schema specifies the fields in the dataset, including the field name and data type\.

After creating a dataset, you import your training data into it and add the dataset to a dataset group\. You use the dataset group to create a predictor\. For more information, see [Datasets and Dataset Groups](howitworks-datasets-groups.md)\.

To get a list of all your datasets, use the [ListDatasets](API_ListDatasets.md) operation\.

For example Forecast datasets, see the [Amazon Forecast Sample GitHub repository](https://github.com/aws-samples/amazon-forecast-samples)\.

**Note**  
The `Status` of a dataset must be `ACTIVE` before you can import training data\. Use the [DescribeDataset](API_DescribeDataset.md) operation to get the status\.

## Request Syntax<a name="API_CreateDataset_RequestSyntax"></a>

```
{
   "DataFrequency": "string",
   "DatasetName": "string",
   "DatasetType": "string",
   "Domain": "string",
   "EncryptionConfig": { 
      "KMSKeyArn": "string",
      "RoleArn": "string"
   },
   "Schema": { 
      "Attributes": [ 
         { 
            "AttributeName": "string",
            "AttributeType": "string"
         }
      ]
   },
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_CreateDataset_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DataFrequency](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-DataFrequency"></a>
The frequency of data collection\. This parameter is required for RELATED\_TIME\_SERIES datasets\.  
Valid intervals are Y \(Year\), M \(Month\), W \(Week\), D \(Day\), H \(Hour\), 30min \(30 minutes\), 15min \(15 minutes\), 10min \(10 minutes\), 5min \(5 minutes\), and 1min \(1 minute\)\. For example, "D" indicates every day and "15min" indicates every 15 minutes\.  
Type: String  
Pattern: `^Y|M|W|D|H|30min|15min|10min|5min|1min$`   
Required: No

 ** [DatasetName](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-DatasetName"></a>
A name for the dataset\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 ** [DatasetType](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-DatasetType"></a>
The dataset type\. Valid values depend on the chosen `Domain`\.  
Type: String  
Valid Values:` TARGET_TIME_SERIES | RELATED_TIME_SERIES | ITEM_METADATA`   
Required: Yes

 ** [Domain](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-Domain"></a>
The domain associated with the dataset\. When you add a dataset to a dataset group, this value and the value specified for the `Domain` parameter of the [CreateDatasetGroup](API_CreateDatasetGroup.md) operation must match\.  
The `Domain` and `DatasetType` that you choose determine the fields that must be present in the training data that you import to the dataset\. For example, if you choose the `RETAIL` domain and `TARGET_TIME_SERIES` as the `DatasetType`, Amazon Forecast requires `item_id`, `timestamp`, and `demand` fields to be present in your data\. For more information, see [Datasets and Dataset Groups](howitworks-datasets-groups.md)\.  
Type: String  
Valid Values:` RETAIL | CUSTOM | INVENTORY_PLANNING | EC2_CAPACITY | WORK_FORCE | WEB_TRAFFIC | METRICS`   
Required: Yes

 ** [EncryptionConfig](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-EncryptionConfig"></a>
An AWS Key Management Service \(KMS\) key and the AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the key\.  
Type: [EncryptionConfig](API_EncryptionConfig.md) object  
Required: No

 ** [Schema](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-Schema"></a>
The schema for the dataset\. The schema attributes and their order must match the fields in your data\. The dataset `Domain` and `DatasetType` that you choose determine the minimum required fields in your training data\. For information about the required fields for a specific dataset domain and type, see [Predefined Dataset Domains and Dataset Types](howitworks-domains-ds-types.md)\.  
Type: [Schema](API_Schema.md) object  
Required: Yes

 ** [Tags](#API_CreateDataset_RequestSyntax) **   <a name="forecast-CreateDataset-request-Tags"></a>
The optional metadata that you apply to the dataset to help you categorize and organize them\. Each tag consists of a key and an optional value, both of which you define\.  
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

## Response Syntax<a name="API_CreateDataset_ResponseSyntax"></a>

```
{
   "DatasetArn": "string"
}
```

## Response Elements<a name="API_CreateDataset_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [DatasetArn](#API_CreateDataset_ResponseSyntax) **   <a name="forecast-CreateDataset-response-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

## Errors<a name="API_CreateDataset_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of resources per account has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
There is already a resource with this name\. Try again with a different name\.  
HTTP Status Code: 400

## See Also<a name="API_CreateDataset_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/CreateDataset) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/CreateDataset) 