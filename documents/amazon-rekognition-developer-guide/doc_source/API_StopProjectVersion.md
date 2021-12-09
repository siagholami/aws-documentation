# StopProjectVersion<a name="API_StopProjectVersion"></a>

Stops a running model\. The operation might take a while to complete\. To check the current status, call [DescribeProjectVersions](API_DescribeProjectVersions.md)\. 

## Request Syntax<a name="API_StopProjectVersion_RequestSyntax"></a>

```
{
   "[ProjectVersionArn](#rekognition-StopProjectVersion-request-ProjectVersionArn)": "string"
}
```

## Request Parameters<a name="API_StopProjectVersion_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ProjectVersionArn](#API_StopProjectVersion_RequestSyntax) **   <a name="rekognition-StopProjectVersion-request-ProjectVersionArn"></a>
The Amazon Resource Name \(ARN\) of the model version that you want to delete\.  
This operation requires permissions to perform the `rekognition:StopProjectVersion` action\.  
Type: String  
Length Constraints: Minimum length of 20\. Maximum length of 2048\.  
Pattern: `(^arn:[a-z\d-]+:rekognition:[a-z\d-]+:\d{12}:project\/[a-zA-Z0-9_.\-]{1,255}\/version\/[a-zA-Z0-9_.\-]{1,255}\/[0-9]+$)`   
Required: Yes

## Response Syntax<a name="API_StopProjectVersion_ResponseSyntax"></a>

```
{
   "[Status](#rekognition-StopProjectVersion-response-Status)": "string"
}
```

## Response Elements<a name="API_StopProjectVersion_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [Status](#API_StopProjectVersion_ResponseSyntax) **   <a name="rekognition-StopProjectVersion-response-Status"></a>
The current status of the stop operation\.   
Type: String  
Valid Values:` TRAINING_IN_PROGRESS | TRAINING_COMPLETED | TRAINING_FAILED | STARTING | RUNNING | FAILED | STOPPING | STOPPED | DELETING` 

## Errors<a name="API_StopProjectVersion_Errors"></a>

 **AccessDeniedException**   
You are not authorized to perform the action\.  
HTTP Status Code: 400

 **InternalServerError**   
Amazon Rekognition experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
Input parameter violated a constraint\. Validate your parameter before calling the API operation again\.  
HTTP Status Code: 400

 **ProvisionedThroughputExceededException**   
The number of requests exceeded your throughput limit\. If you want to increase this limit, contact Amazon Rekognition\.  
HTTP Status Code: 400

 **ResourceInUseException**   
  
HTTP Status Code: 400

 **ResourceNotFoundException**   
The collection specified in the request cannot be found\.  
HTTP Status Code: 400

 **ThrottlingException**   
Amazon Rekognition is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 500

## See Also<a name="API_StopProjectVersion_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/rekognition-2016-06-27/StopProjectVersion) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/rekognition-2016-06-27/StopProjectVersion) 