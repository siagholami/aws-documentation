# DescribeRobot<a name="API_DescribeRobot"></a>

Describes a robot\.

## Request Syntax<a name="API_DescribeRobot_RequestSyntax"></a>

```
POST /describeRobot HTTP/1.1
Content-type: application/json

{
   "[robot](#robomaker-DescribeRobot-request-robot)": "string"
}
```

## URI Request Parameters<a name="API_DescribeRobot_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DescribeRobot_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [robot](#API_DescribeRobot_RequestSyntax) **   <a name="robomaker-DescribeRobot-request-robot"></a>
The Amazon Resource Name \(ARN\) of the robot to be described\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_DescribeRobot_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[architecture](#robomaker-DescribeRobot-response-architecture)": "string",
   "[arn](#robomaker-DescribeRobot-response-arn)": "string",
   "[createdAt](#robomaker-DescribeRobot-response-createdAt)": number,
   "[fleetArn](#robomaker-DescribeRobot-response-fleetArn)": "string",
   "[greengrassGroupId](#robomaker-DescribeRobot-response-greengrassGroupId)": "string",
   "[lastDeploymentJob](#robomaker-DescribeRobot-response-lastDeploymentJob)": "string",
   "[lastDeploymentTime](#robomaker-DescribeRobot-response-lastDeploymentTime)": number,
   "[name](#robomaker-DescribeRobot-response-name)": "string",
   "[status](#robomaker-DescribeRobot-response-status)": "string",
   "[tags](#robomaker-DescribeRobot-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_DescribeRobot_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [architecture](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-architecture"></a>
The target architecture of the robot application\.  
Type: String  
Valid Values:` X86_64 | ARM64 | ARMHF` 

 ** [arn](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-arn"></a>
The Amazon Resource Name \(ARN\) of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-createdAt"></a>
The time, in milliseconds since the epoch, when the robot was created\.  
Type: Timestamp

 ** [fleetArn](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-fleetArn"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [greengrassGroupId](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-greengrassGroupId"></a>
The Greengrass group id\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `.*` 

 ** [lastDeploymentJob](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-lastDeploymentJob"></a>
The Amazon Resource Name \(ARN\) of the last deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastDeploymentTime](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-lastDeploymentTime"></a>
The time of the last deployment job\.  
Type: Timestamp

 ** [name](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-name"></a>
The name of the robot\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [status](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-status"></a>
The status of the fleet\.  
Type: String  
Valid Values:` Available | Registered | PendingNewDeployment | Deploying | Failed | InSync | NoResponse` 

 ** [tags](#API_DescribeRobot_ResponseSyntax) **   <a name="robomaker-DescribeRobot-response-tags"></a>
The list of all tags added to the specified robot\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_DescribeRobot_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **InternalServerException**   
AWS RoboMaker experienced a service issue\. Try your call again\.  
HTTP Status Code: 500

 **InvalidParameterException**   
A parameter specified in a request is not valid, is unsupported, or cannot be used\. The returned message provides an explanation of the error value\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
The specified resource does not exist\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeRobot_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DescribeRobot) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DescribeRobot) 