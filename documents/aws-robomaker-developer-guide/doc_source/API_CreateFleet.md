# CreateFleet<a name="API_CreateFleet"></a>

Creates a fleet, a logical group of robots running the same robot application\.

## Request Syntax<a name="API_CreateFleet_RequestSyntax"></a>

```
POST /createFleet HTTP/1.1
Content-type: application/json

{
   "[name](#robomaker-CreateFleet-request-name)": "string",
   "[tags](#robomaker-CreateFleet-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_CreateFleet_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_CreateFleet_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [name](#API_CreateFleet_RequestSyntax) **   <a name="robomaker-CreateFleet-request-name"></a>
The name of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: Yes

 ** [tags](#API_CreateFleet_RequestSyntax) **   <a name="robomaker-CreateFleet-request-tags"></a>
A map that contains tag keys and tag values that are attached to the fleet\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

## Response Syntax<a name="API_CreateFleet_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-CreateFleet-response-arn)": "string",
   "[createdAt](#robomaker-CreateFleet-response-createdAt)": number,
   "[name](#robomaker-CreateFleet-response-name)": "string",
   "[tags](#robomaker-CreateFleet-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_CreateFleet_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_CreateFleet_ResponseSyntax) **   <a name="robomaker-CreateFleet-response-arn"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_CreateFleet_ResponseSyntax) **   <a name="robomaker-CreateFleet-response-createdAt"></a>
The time, in milliseconds since the epoch, when the fleet was created\.  
Type: Timestamp

 ** [name](#API_CreateFleet_ResponseSyntax) **   <a name="robomaker-CreateFleet-response-name"></a>
The name of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [tags](#API_CreateFleet_ResponseSyntax) **   <a name="robomaker-CreateFleet-response-tags"></a>
The list of all tags added to the fleet\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_CreateFleet_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **LimitExceededException**   
The requested resource exceeds the maximum number allowed, or the number of concurrent stream requests exceeds the maximum number allowed\.   
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_CreateFleet_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/CreateFleet) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/CreateFleet) 