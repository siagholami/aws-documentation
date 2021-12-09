# DeleteRobot<a name="API_DeleteRobot"></a>

Deletes a robot\.

## Request Syntax<a name="API_DeleteRobot_RequestSyntax"></a>

```
POST /deleteRobot HTTP/1.1
Content-type: application/json

{
   "[robot](#robomaker-DeleteRobot-request-robot)": "string"
}
```

## URI Request Parameters<a name="API_DeleteRobot_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DeleteRobot_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [robot](#API_DeleteRobot_RequestSyntax) **   <a name="robomaker-DeleteRobot-request-robot"></a>
The Amazon Resource Name \(ARN\) of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_DeleteRobot_ResponseSyntax"></a>

```
HTTP/1.1 200
```

## Response Elements<a name="API_DeleteRobot_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response with an empty HTTP body\.

## Errors<a name="API_DeleteRobot_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_DeleteRobot_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DeleteRobot) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DeleteRobot) 