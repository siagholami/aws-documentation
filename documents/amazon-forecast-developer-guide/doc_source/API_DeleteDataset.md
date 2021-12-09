# DeleteDataset<a name="API_DeleteDataset"></a>

Deletes an Amazon Forecast dataset that was created using the [CreateDataset](API_CreateDataset.md) operation\. You can only delete datasets that have a status of `ACTIVE` or `CREATE_FAILED`\. To get the status use the [DescribeDataset](API_DescribeDataset.md) operation\.

**Note**  
Forecast does not automatically update any dataset groups that contain the deleted dataset\. In order to update the dataset group, use the [UpdateDatasetGroup](API_UpdateDatasetGroup.md) operation, omitting the deleted dataset's ARN\.

## Request Syntax<a name="API_DeleteDataset_RequestSyntax"></a>

```
{
   "DatasetArn": "string"
}
```

## Request Parameters<a name="API_DeleteDataset_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetArn](#API_DeleteDataset_RequestSyntax) **   <a name="forecast-DeleteDataset-request-DatasetArn"></a>
The Amazon Resource Name \(ARN\) of the dataset to delete\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Elements<a name="API_DeleteDataset_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_DeleteDataset_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DeleteDataset_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DeleteDataset) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DeleteDataset) 