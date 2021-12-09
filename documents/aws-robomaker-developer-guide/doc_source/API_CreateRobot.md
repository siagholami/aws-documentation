# CreateRobot<a name="API_CreateRobot"></a>

Creates a robot\.

## Request Syntax<a name="API_CreateRobot_RequestSyntax"></a>

```
POST /createRobot HTTP/1.1
Content-type: application/json

{
   "[architecture](#robomaker-CreateRobot-request-architecture)": "string",
   "[greengrassGroupId](#robomaker-CreateRobot-request-greengrassGroupId)": "string",
   "[name](#robomaker-CreateRobot-request-name)": "string",
   "[tags](#robomaker-CreateRobot-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_CreateRobot_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_CreateRobot_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [architecture](#API_CreateRobot_RequestSyntax) **   <a name="robomaker-CreateRobot-request-architecture"></a>
The target architecture of the robot\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF`   
Required: Yes

 ** [greengrassGroupId](#API_CreateRobot_RequestSyntax) **   <a name="robomaker-CreateRobot-request-greengrassGroupId"></a>
The Greengrass group id\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `.*`   
Required: Yes

 ** [name](#API_CreateRobot_RequestSyntax) **   <a name="robomaker-CreateRobot-request-name"></a>
The name for the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: Yes

 ** [tags](#API_CreateRobot_RequestSyntax) **   <a name="robomaker-CreateRobot-request-tags"></a>
A map that contains tag keys and tag values that are attached to the robot\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

## Response Syntax<a name="API_CreateRobot_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[architecture](#robomaker-CreateRobot-response-architecture)": "string",
   "[arn](#robomaker-CreateRobot-response-arn)": "string",
   "[createdAt](#robomaker-CreateRobot-response-createdAt)": number,
   "[greengrassGroupId](#robomaker-CreateRobot-response-greengrassGroupId)": "string",
   "[name](#robomaker-CreateRobot-response-name)": "string",
   "[tags](#robomaker-CreateRobot-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_CreateRobot_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [architecture](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-architecture"></a>
The target architecture of the robot\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF` 

 ** [arn](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-arn"></a>
The Amazon Resource Name \(ARN\) of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-createdAt"></a>
The time, in milliseconds since the epoch, when the robot was created\.  
Type: Timestamp

 ** [greengrassGroupId](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-greengrassGroupId"></a>
The Amazon Resource Name \(ARN\) of the Greengrass group associated with the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `.*` 

 ** [name](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-name"></a>
The name of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [tags](#API_CreateRobot_ResponseSyntax) **   <a name="robomaker-CreateRobot-response-tags"></a>
The list of all tags added to the robot\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_CreateRobot_Errors"></a>

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

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_CreateRobot_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/CreateRobot) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/CreateRobot) 