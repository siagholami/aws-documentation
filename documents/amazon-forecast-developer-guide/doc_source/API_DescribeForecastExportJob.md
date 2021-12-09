# DescribeForecastExportJob<a name="API_DescribeForecastExportJob"></a>

Describes a forecast export job created using the [CreateForecastExportJob](API_CreateForecastExportJob.md) operation\.

In addition to listing the properties provided by the user in the `CreateForecastExportJob` request, this operation lists the following properties:
+  `CreationTime` 
+  `LastModificationTime` 
+  `Status` 
+  `Message` \- If an error occurred, information about the error\.

## Request Syntax<a name="API_DescribeForecastExportJob_RequestSyntax"></a>

```
{
   "ForecastExportJobArn": "string"
}
```

## Request Parameters<a name="API_DescribeForecastExportJob_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [ForecastExportJobArn](#API_DescribeForecastExportJob_RequestSyntax) **   <a name="forecast-DescribeForecastExportJob-request-ForecastExportJobArn"></a>
The Amazon Resource Name \(ARN\) of the forecast export job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## Response Syntax<a name="API_DescribeForecastExportJob_ResponseSyntax"></a>

```
{
   "CreationTime": number,
   "Destination": { 
      "S3Config": { 
         "KMSKeyArn": "string",
         "Path": "string",
         "RoleArn": "string"
      }
   },
   "ForecastArn": "string",
   "ForecastExportJobArn": "string",
   "ForecastExportJobName": "string",
   "LastModificationTime": number,
   "Message": "string",
   "Status": "string"
}
```

## Response Elements<a name="API_DescribeForecastExportJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [CreationTime](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-CreationTime"></a>
When the forecast export job was created\.  
Type: Timestamp

 ** [Destination](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-Destination"></a>
The path to the Amazon Simple Storage Service \(Amazon S3\) bucket where the forecast is exported\.  
Type: [DataDestination](API_DataDestination.md) object

 ** [ForecastArn](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-ForecastArn"></a>
The Amazon Resource Name \(ARN\) of the exported forecast\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [ForecastExportJobArn](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-ForecastExportJobArn"></a>
The ARN of the forecast export job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

 ** [ForecastExportJobName](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-ForecastExportJobName"></a>
The name of the forecast export job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*` 

 ** [LastModificationTime](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-LastModificationTime"></a>
When the last successful export job finished\.  
Type: Timestamp

 ** [Message](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-Message"></a>
If an error occurred, an informational message about the error\.  
Type: String

 ** [Status](#API_DescribeForecastExportJob_ResponseSyntax) **   <a name="forecast-DescribeForecastExportJob-response-Status"></a>
The status of the forecast export job\. States include:  
+  `ACTIVE` 
+  `CREATE_PENDING`, `CREATE_IN_PROGRESS`, `CREATE_FAILED` 
+  `DELETE_PENDING`, `DELETE_IN_PROGRESS`, `DELETE_FAILED` 
The `Status` of the forecast export job must be `ACTIVE` before you can access the forecast in your S3 bucket\.
Type: String  
Length Constraints: Maximum length of 256\.

## Errors<a name="API_DescribeForecastExportJob_Errors"></a>

 **InvalidInputException**   
We can't process the request because it includes an invalid value or a value that exceeds the valid range\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
We can't find a resource with that Amazon Resource Name \(ARN\)\. Check the ARN and try again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeForecastExportJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/DescribeForecastExportJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DescribeForecastExportJob) 