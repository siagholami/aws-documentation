# DescribeDatasetGroup<a name="API_DescribeDatasetGroup"></a>

Describes the given dataset group\. For more information on dataset groups, see [CreateDatasetGroup](API_CreateDatasetGroup.md)\.

## Request Syntax<a name="API_DescribeDatasetGroup_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string"
}
```

## Request Parameters<a name="API_DescribeDatasetGroup_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_DescribeDatasetGroup_RequestSyntax) **   <a name="personalize-DescribeDatasetGroup-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeDatasetGroup_ResponseSyntax"></a>

```
{
   "datasetGroup": { 
      "creationDateTime": number,
      "datasetGroupArn": "string",
      "failureReason": "string",
      "kmsKeyArn": "string",
      "lastUpdatedDateTime": number,
      "name": "string",
      "roleArn": "string",
      "status": "string"
   }
}
```

## Response Elements<a name="API_DescribeDatasetGroup_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [datasetGroup](#API_DescribeDatasetGroup_ResponseSyntax) **   <a name="personalize-DescribeDatasetGroup-response-datasetGroup"></a>
A listing of the dataset group's properties\.  
Type: [DatasetGroup](API_DatasetGroup.md) object

## Errors<a name="API_DescribeDatasetGroup_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeDatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeDatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeDatasetGroup) 