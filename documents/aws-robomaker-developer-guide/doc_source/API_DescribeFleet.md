# DescribeFleet<a name="API_DescribeFleet"></a>

Describes a fleet\.

## Request Syntax<a name="API_DescribeFleet_RequestSyntax"></a>

```
POST /describeFleet HTTP/1.1
Content-type: application/json

{
   "[fleet](#robomaker-DescribeFleet-request-fleet)": "string"
}
```

## URI Request Parameters<a name="API_DescribeFleet_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DescribeFleet_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [fleet](#API_DescribeFleet_RequestSyntax) **   <a name="robomaker-DescribeFleet-request-fleet"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_DescribeFleet_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-DescribeFleet-response-arn)": "string",
   "[createdAt](#robomaker-DescribeFleet-response-createdAt)": number,
   "[lastDeploymentJob](#robomaker-DescribeFleet-response-lastDeploymentJob)": "string",
   "[lastDeploymentStatus](#robomaker-DescribeFleet-response-lastDeploymentStatus)": "string",
   "[lastDeploymentTime](#robomaker-DescribeFleet-response-lastDeploymentTime)": number,
   "[name](#robomaker-DescribeFleet-response-name)": "string",
   "[robots](#robomaker-DescribeFleet-response-robots)": [ 
      { 
         "[architecture](API_Robot.md#robomaker-Type-Robot-architecture)": "string",
         "[arn](API_Robot.md#robomaker-Type-Robot-arn)": "string",
         "[createdAt](API_Robot.md#robomaker-Type-Robot-createdAt)": number,
         "[fleetArn](API_Robot.md#robomaker-Type-Robot-fleetArn)": "string",
         "[greenGrassGroupId](API_Robot.md#robomaker-Type-Robot-greenGrassGroupId)": "string",
         "[lastDeploymentJob](API_Robot.md#robomaker-Type-Robot-lastDeploymentJob)": "string",
         "[lastDeploymentTime](API_Robot.md#robomaker-Type-Robot-lastDeploymentTime)": number,
         "[name](API_Robot.md#robomaker-Type-Robot-name)": "string",
         "[status](API_Robot.md#robomaker-Type-Robot-status)": "string"
      }
   ],
   "[tags](#robomaker-DescribeFleet-response-tags)": { 
      "string" : "string" 
   }
}
```

## Response Elements<a name="API_DescribeFleet_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-arn"></a>
The Amazon Resource Name \(ARN\) of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [createdAt](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-createdAt"></a>
The time, in milliseconds since the epoch, when the fleet was created\.  
Type: Timestamp

 ** [lastDeploymentJob](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-lastDeploymentJob"></a>
The Amazon Resource Name \(ARN\) of the last deployment job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastDeploymentStatus](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-lastDeploymentStatus"></a>
The status of the last deployment\.  
Type: String  
Valid Values:` Pending | Preparing | InProgress | Failed | Succeeded | Canceled` 

 ** [lastDeploymentTime](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-lastDeploymentTime"></a>
The time of the last deployment\.  
Type: Timestamp

 ** [name](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-name"></a>
The name of the fleet\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [robots](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-robots"></a>
A list of robots\.  
Type: Array of [Robot](API_Robot.md) objects  
Array Members: Minimum number of 0 items\. Maximum number of 1000 items\.

 ** [tags](#API_DescribeFleet_ResponseSyntax) **   <a name="robomaker-DescribeFleet-response-tags"></a>
The list of all tags added to the specified fleet\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

## Errors<a name="API_DescribeFleet_Errors"></a>

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

## See Also<a name="API_DescribeFleet_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DescribeFleet) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DescribeFleet) 