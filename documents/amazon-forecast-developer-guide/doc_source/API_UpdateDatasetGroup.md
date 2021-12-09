# UpdateDatasetGroup<a name="API_UpdateDatasetGroup"></a>

Replaces the datasets in a dataset group with the specified datasets\.

**Note**  
The `Status` of the dataset group must be `ACTIVE` before you can use the dataset group to create a predictor\. Use the [DescribeDatasetGroup](API_DescribeDatasetGroup.md) operation to get the status\.

## Request Syntax<a name="API_UpdateDatasetGroup_RequestSyntax"></a>

```
{
   "DatasetArns": [ "string" ],
   "DatasetGroupArn": "string"
}
```

## Request Parameters<a name="API_UpdateDatasetGroup_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [DatasetArns](#API_UpdateDatasetGroup_RequestSyntax) **   <a name="forecast-UpdateDatasetGroup-request-DatasetArns"></a>
An array of the Amazon Resource Names \(ARNs\) of the datasets to add to the dataset group\.  
Type: Array of strings  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

 ** [DatasetGroupArn](#API_UpdateDatasetGroup_RequestSyntax) **   <a name="forecast-UpdateDatasetGroup-request-DatasetGroupArn"></a>
The ARN of the dataset group\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Elements<a name="API_UpdateDatasetGroup_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_UpdateDatasetGroup_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_UpdateDatasetGroup_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/UpdateDatasetGroup) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/UpdateDatasetGroup) 