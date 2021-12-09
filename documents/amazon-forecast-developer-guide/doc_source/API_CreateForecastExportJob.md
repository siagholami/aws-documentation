# CreateForecastExportJob<a name="API_CreateForecastExportJob"></a>

Exports a forecast created by the [CreateForecast](API_CreateForecast.md) operation to your Amazon Simple Storage Service \(Amazon S3\) bucket\. The forecast file name will match the following conventions:

<ForecastExportJobName>\_<ExportTimestamp>\_<PartNumber>

where the <ExportTimestamp> component is in Java SimpleDateFormat \(yyyy\-MM\-ddTHH\-mm\-ssZ\)\.

You must specify a [DataDestination](API_DataDestination.md) object that includes an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the Amazon S3 bucket\. For more information, see [Set Up Permissions for Amazon Forecast](aws-forecast-iam-roles.md)\.

For more information, see [Forecasts](howitworks-forecast.md)\.

To get a list of all your forecast export jobs, use the [ListForecastExportJobs](API_ListForecastExportJobs.md) operation\.

**Note**  
The `Status` of the forecast export job must be `ACTIVE` before you can access the forecast in your Amazon S3 bucket\. To get the status, use the [DescribeForecastExportJob](API_DescribeForecastExportJob.md) operation\.

## Request Syntax<a name="API_CreateForecastExportJob_RequestSyntax"></a>

```
{
   "Destination": { 
      "S3Config": { 
         "KMSKeyArn": "string",
         "Path": "string",
         "RoleArn": "string"
      }
   },
   "ForecastArn": "string",
   "ForecastExportJobName": "string",
   "Tags": [ 
      { 
         "Key": "string",
         "Value": "string"
      }
   ]
}
```

## Request Parameters<a name="API_CreateForecastExportJob_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [Destination](#API_CreateForecastExportJob_RequestSyntax) **   <a name="forecast-CreateForecastExportJob-request-Destination"></a>
The location where you want to save the forecast and an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the location\. The forecast must be exported to an Amazon S3 bucket\.  
If encryption is used, `Destination` must include an AWS Key Management Service \(KMS\) key\. The IAM role must allow Amazon Forecast permission to access the key\.  
Type: [DataDestination](API_DataDestination.md) object  
Required: Yes

 ** [ForecastArn](#API_CreateForecastExportJob_RequestSyntax) **   <a name="forecast-CreateForecastExportJob-request-ForecastArn"></a>
The Amazon Resource Name \(ARN\) of the forecast that you want to export\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

 ** [ForecastExportJobName](#API_CreateForecastExportJob_RequestSyntax) **   <a name="forecast-CreateForecastExportJob-request-ForecastExportJobName"></a>
The name for the forecast export job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: Yes

 ** [Tags](#API_CreateForecastExportJob_RequestSyntax) **   <a name="forecast-CreateForecastExportJob-request-Tags"></a>
The optional metadata that you apply to the forecast export job to help you categorize and organize them\. Each tag consists of a key and an optional value, both of which you define\.  
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

## Response Syntax<a name="API_CreateForecastExportJob_ResponseSyntax"></a>

```
{
   "ForecastExportJobArn": "string"
}
```

## Response Elements<a name="API_CreateForecastExportJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [ForecastExportJobArn](#API_CreateForecastExportJob_ResponseSyntax) **   <a name="forecast-CreateForecastExportJob-response-ForecastExportJobArn"></a>
The Amazon Resource Name \(ARN\) of the export job\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$` 

## Errors<a name="API_CreateForecastExportJob_Errors"></a>

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

## See Also<a name="API_CreateForecastExportJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/forecast-2018-06-26/CreateForecastExportJob) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/CreateForecastExportJob) 