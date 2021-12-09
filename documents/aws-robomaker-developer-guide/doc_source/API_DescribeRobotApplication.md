# DescribeRobotApplication<a name="API_DescribeRobotApplication"></a>

Describes a robot application\.

## Request Syntax<a name="API_DescribeRobotApplication_RequestSyntax"></a>

```
POST /describeRobotApplication HTTP/1.1
Content-type: application/json

{
   "[application](#robomaker-DescribeRobotApplication-request-application)": "string",
   "[applicationVersion](#robomaker-DescribeRobotApplication-request-applicationVersion)": "string"
}
```

## URI Request Parameters<a name="API_DescribeRobotApplication_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DescribeRobotApplication_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [application](#API_DescribeRobotApplication_RequestSyntax) **   <a name="robomaker-DescribeRobotApplication-request-application"></a>
The Amazon Resource Name \(ARN\) of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 ** [applicationVersion](#API_DescribeRobotApplication_RequestSyntax) **   <a name="robomaker-DescribeRobotApplication-request-applicationVersion"></a>
The version of the robot application to describe\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*`   
Required: No

## Response Syntax<a name="API_DescribeRobotApplication_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-DescribeRobotApplication-response-arn)": "string",
   "[lastUpdatedAt](#robomaker-DescribeRobotApplication-response-lastUpdatedAt)": number,
   "[name](#robomaker-DescribeRobotApplication-response-name)": "string",
   "[revisionId](#robomaker-DescribeRobotApplication-response-revisionId)": "string",
   "[robotSoftwareSuite](#robomaker-DescribeRobotApplication-response-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-DescribeRobotApplication-response-sources)": [ 
      { 
         "[architecture](API_Source.md#robomaker-Type-Source-architecture)": "string",
         "[etag](API_Source.md#robomaker-Type-Source-etag)": "string",
         "[s3Bucket](API_Source.md#robomaker-Type-Source-s3Bucket)": "string",
         "[s3Key](API_Source.md#robomaker-Type-Source-s3Key)": "string"
      }
   ],
   "[tags](#robomaker-DescribeRobotApplication-response-tags)": { 
      "string" : "string" 
   },
   "[version](#robomaker-DescribeRobotApplication-response-version)": "string"
}
```

## Response Elements<a name="API_DescribeRobotApplication_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-arn"></a>
The Amazon Resource Name \(ARN\) of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastUpdatedAt](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the robot application was last updated\.  
Type: Timestamp

 ** [name](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-name"></a>
The name of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [revisionId](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-revisionId"></a>
The revision id of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Pattern: `[a-zA-Z0-9_.\-]*` 

 ** [robotSoftwareSuite](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-robotSoftwareSuite"></a>
The robot software suite \(ROS distribution\) used by the robot application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object

 ** [sources](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-sources"></a>
The sources of the robot application\.  
Type: Array of [Source](API_Source.md) objects

 ** [tags](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-tags"></a>
The list of all tags added to the specified robot application\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

 ** [version](#API_DescribeRobotApplication_ResponseSyntax) **   <a name="robomaker-DescribeRobotApplication-response-version"></a>
The version of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*` 

## Errors<a name="API_DescribeRobotApplication_Errors"></a>

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

## See Also<a name="API_DescribeRobotApplication_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DescribeRobotApplication) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DescribeRobotApplication) 