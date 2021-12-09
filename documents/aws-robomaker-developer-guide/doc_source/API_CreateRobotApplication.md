# CreateRobotApplication<a name="API_CreateRobotApplication"></a>

Creates a robot application\. 

## Request Syntax<a name="API_CreateRobotApplication_RequestSyntax"></a>

```
POST /createRobotApplication HTTP/1.1
Content-type: application/json

{
   "[name](#robomaker-CreateRobotApplication-request-name)": "string",
   "[robotSoftwareSuite](#robomaker-CreateRobotApplication-request-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-CreateRobotApplication-request-sources)": [ 
      { 
         "[architecture](API_SourceConfig.md#robomaker-Type-SourceConfig-architecture)": "string",
         "[s3Bucket](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Bucket)": "string",
         "[s3Key](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Key)": "string"
      }
   ],
   "[tags](#robomaker-CreateRobotApplication-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_CreateRobotApplication_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_CreateRobotApplication_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [name](#API_CreateRobotApplication_RequestSyntax) **   <a name="robomaker-CreateRobotApplication-request-name"></a>
The name of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: Yes

 ** [robotSoftwareSuite](#API_CreateRobotApplication_RequestSyntax) **   <a name="robomaker-CreateRobotApplication-request-robotSoftwareSuite"></a>
The robot software suite \(ROS distribuition\) used by the robot application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object  
Required: Yes

 ** [sources](#API_CreateRobotApplication_RequestSyntax) **   <a name="robomaker-CreateRobotApplication-request-sources"></a>
The sources of the robot application\.  
Type: Array of [SourceConfig](API_SourceConfig.md) objects  
Required: Yes

 ** [tags](#API_CreateRobotApplication_RequestSyntax) **   <a name="robomaker-CreateRobotApplication-request-tags"></a>
A map that contains tag keys and tag values that are attached to the robot application\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

## Response Syntax<a name="API_CreateRobotApplication_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-CreateRobotApplication-response-arn)": "string",
   "[lastUpdatedAt](#robomaker-CreateRobotApplication-response-lastUpdatedAt)": number,
   "[name](#robomaker-CreateRobotApplication-response-name)": "string",
   "[revisionId](#robomaker-CreateRobotApplication-response-revisionId)": "string",
   "[robotSoftwareSuite](#robomaker-CreateRobotApplication-response-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-CreateRobotApplication-response-sources)": [ 
      { 
         "[architecture](API_Source.md#robomaker-Type-Source-architecture)": "string",
         "[etag](API_Source.md#robomaker-Type-Source-etag)": "string",
         "[s3Bucket](API_Source.md#robomaker-Type-Source-s3Bucket)": "string",
         "[s3Key](API_Source.md#robomaker-Type-Source-s3Key)": "string"
      }
   ],
   "[tags](#robomaker-CreateRobotApplication-response-tags)": { 
      "string" : "string" 
   },
   "[version](#robomaker-CreateRobotApplication-response-version)": "string"
}
```

## Response Elements<a name="API_CreateRobotApplication_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-arn"></a>
The Amazon Resource Name \(ARN\) of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastUpdatedAt](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the robot application was last updated\.  
Type: Timestamp

 ** [name](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-name"></a>
The name of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [revisionId](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-revisionId"></a>
The revision id of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Pattern: `[a-zA-Z0-9_.\-]*` 

 ** [robotSoftwareSuite](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-robotSoftwareSuite"></a>
The robot software suite \(ROS distribution\) used by the robot application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object

 ** [sources](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-sources"></a>
The sources of the robot application\.  
Type: Array of [Source](API_Source.md) objects

 ** [tags](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-tags"></a>
The list of all tags added to the robot application\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

 ** [version](#API_CreateRobotApplication_ResponseSyntax) **   <a name="robomaker-CreateRobotApplication-response-version"></a>
The version of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*` 

## Errors<a name="API_CreateRobotApplication_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **IdempotentParameterMismatchException**   
The request uses the same client token as a previous, but non\-identical request\. Do not reuse a client token with different requests, unless the requests are identical\.   
HTTP Status Code: 400

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

## See Also<a name="API_CreateRobotApplication_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/CreateRobotApplication) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/CreateRobotApplication) 