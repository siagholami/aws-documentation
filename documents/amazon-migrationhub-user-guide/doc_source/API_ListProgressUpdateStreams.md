# ListProgressUpdateStreams<a name="API_ListProgressUpdateStreams"></a>

Lists progress update streams associated with the user account making this call\.

## Request Syntax<a name="API_ListProgressUpdateStreams_RequestSyntax"></a>

```
{
   "MaxResults": number,
   "NextToken": "string"
}
```

## Request Parameters<a name="API_ListProgressUpdateStreams_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [MaxResults](#API_ListProgressUpdateStreams_RequestSyntax) **   <a name="migrationhub-ListProgressUpdateStreams-request-MaxResults"></a>
Filter to limit the maximum number of results to list per page\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [NextToken](#API_ListProgressUpdateStreams_RequestSyntax) **   <a name="migrationhub-ListProgressUpdateStreams-request-NextToken"></a>
If a `NextToken` was returned by a previous call, there are more results available\. To retrieve the next page of results, make the call again using the returned token in `NextToken`\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 2048\.  
Pattern: `^[a-zA-Z0-9\/\+\=]{0,2048}$`   
Required: No

## Response Syntax<a name="API_ListProgressUpdateStreams_ResponseSyntax"></a>

```
{
   "NextToken": "string",
   "ProgressUpdateStreamSummaryList": [ 
      { 
         "ProgressUpdateStreamName": "string"
      }
   ]
}
```

## Response Elements<a name="API_ListProgressUpdateStreams_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [NextToken](#API_ListProgressUpdateStreams_ResponseSyntax) **   <a name="migrationhub-ListProgressUpdateStreams-response-NextToken"></a>
If there are more streams created than the max result, return the next token to be passed to the next call as a bookmark of where to start from\.  
Type: String  
Length Constraints: Minimum length of 0\. Maximum length of 2048\.  
Pattern: `^[a-zA-Z0-9\/\+\=]{0,2048}$` 

 ** [ProgressUpdateStreamSummaryList](#API_ListProgressUpdateStreams_ResponseSyntax) **   <a name="migrationhub-ListProgressUpdateStreams-response-ProgressUpdateStreamSummaryList"></a>
List of progress update streams up to the max number of results passed in the input\.  
Type: Array of [ProgressUpdateStreamSummary](API_ProgressUpdateStreamSummary.md) objects

## Errors<a name="API_ListProgressUpdateStreams_Errors"></a>

 **AccessDeniedException**   
You do not have sufficient access to perform this action\.  
HTTP Status Code: 400

 **HomeRegionNotSetException**   
The home region is not set\. Set the home region to continue\.  
HTTP Status Code: 400

 **InternalServerError**   
Exception raised when an internal, configuration, or dependency error is encountered\.  
HTTP Status Code: 500

 **InvalidInputException**   
Exception raised when the provided input violates a policy constraint or is entered in the wrong format or data type\.  
HTTP Status Code: 400

 **ServiceUnavailableException**   
Exception raised when there is an internal, configuration, or dependency error encountered\.  
HTTP Status Code: 500

 **ThrottlingException**   
The request was denied due to request throttling\.  
HTTP Status Code: 400

## Example<a name="API_ListProgressUpdateStreams_Examples"></a>

### List progress update streams<a name="API_ListProgressUpdateStreams_Example_1"></a>

The following example lists the progress update streams associated with the account invoking the request and uses the value passed to the optional parameter `MaxResults`\.

#### Sample Request<a name="API_ListProgressUpdateStreams_Example_1_Request"></a>

```
{
    "MaxResults": 2
}
```

#### Sample Response<a name="API_ListProgressUpdateStreams_Example_1_Response"></a>

```
{
    "ProgressUpdateStreamSummaryList": [
        {
            "ProgressUpdateStreamName": "DMS"
        }, 
        {
            "ProgressUpdateStreamName": "SMS"
        }
    ], 
    "NextToken": "AYADeDJG11y1VuQBWp87zGdqAkkAXwABABVhd3MtY3J5cHRvLXB1YmxpYy1rZ
    XkAREFwM0s3MElDWDI4NVJ3RG4vQUVnWFZKa2xNQVI1a2RJZXNNQXZnN2Y4M0pMdjN6Ujhka2VE
    Z0lRZEFnQ2toUE1Rdz09AAEAB2F3cy1rbXMAS2Fybjphd3M6a21zOnVzLXdlc3QtMjo2MzEzOTQ
    0NDA2MDg6a2V5L2UzNmUxYTc5LTUyYTUtNDdhZi05YmZjLWUxZDY2MjMyM2E0MwCnAQEBAHieuD
    SjpG16QpfVPv6L98gI73HcNP7jNyhyIMduHA8a4wAAAH4wfAYJKoZIhvcNAQcGoG8wbQIBADBoB
    gkqhkiG9w0BBwEwHgYJYIZIAWUDBAEuMBEEDGKeYQzVoDEvBo0EDwIBEIA7KbgCu41sTOBeQaU9
    BOchDBz6NGrh3AztXyqwJGczR7PiOOJZUPipWyiZDOSwVh/Exbkwm5clUF3VJ0kCAAAAAAwAABA
    Ac1MGWKEY/ySGi8kJmVlSZlU6rN/okwmmQCyymv////8AAAABvAPw0ZhHxJ3B4nsQAAAAbahc0b
    uugm7vytB05AobE5AWiEJaEEz5kMiYQJtzDfwXM8h9GS8kX7ydocfw0yLCMM9/sLa5JaaqY3yVh
    K3m9SwqxBSlBBhNhsjPMOZFBVMB12UcG5CW/Qo2rrzpNA/dVrCIweobaBVrxu4X9TkvT7qm67ns
    IGQM8SHofcfRAGcwZQIwElspH+HhwSxyI59eG6a3juJvgbHBNKwIH72N9Si3TZaTyiskL6QUPH5
    Y9PLmtIX7AjEAiZaqz55O+EUmaxiizH76sVuWoCMReEgFJtSm5NM3trucfj20AiIZ6/MG3bsJ43
    fZ"
}
```

## See Also<a name="API_ListProgressUpdateStreams_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/AWSMigrationHub-2017-05-31/ListProgressUpdateStreams) 