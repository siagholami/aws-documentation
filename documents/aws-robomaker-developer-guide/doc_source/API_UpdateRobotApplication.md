# UpdateRobotApplication<a name="API_UpdateRobotApplication"></a>

Updates a robot application\.

## Request Syntax<a name="API_UpdateRobotApplication_RequestSyntax"></a>

```
POST /updateRobotApplication HTTP/1.1
Content-type: application/json

{
   "[application](#robomaker-UpdateRobotApplication-request-application)": "string",
   "[currentRevisionId](#robomaker-UpdateRobotApplication-request-currentRevisionId)": "string",
   "[robotSoftwareSuite](#robomaker-UpdateRobotApplication-request-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-UpdateRobotApplication-request-sources)": [ 
      { 
         "[architecture](API_SourceConfig.md#robomaker-Type-SourceConfig-architecture)": "string",
         "[s3Bucket](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Bucket)": "string",
         "[s3Key](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Key)": "string"
      }
   ]
}
```

## URI Request Parameters<a name="API_UpdateRobotApplication_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_UpdateRobotApplication_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [application](#API_UpdateRobotApplication_RequestSyntax) **   <a name="robomaker-UpdateRobotApplication-request-application"></a>
The application information for the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

 ** [currentRevisionId](#API_UpdateRobotApplication_RequestSyntax) **   <a name="robomaker-UpdateRobotApplication-request-currentRevisionId"></a>
The revision id for the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Pattern: `[a-zA-Z0-9_.\-]*`   
Required: No

 ** [robotSoftwareSuite](#API_UpdateRobotApplication_RequestSyntax) **   <a name="robomaker-UpdateRobotApplication-request-robotSoftwareSuite"></a>
The robot software suite \(ROS distribution\) used by the robot application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object  
Required: Yes

 ** [sources](#API_UpdateRobotApplication_RequestSyntax) **   <a name="robomaker-UpdateRobotApplication-request-sources"></a>
The sources of the robot application\.  
Type: Array of [SourceConfig](API_SourceConfig.md) objects  
Required: Yes

## Response Syntax<a name="API_UpdateRobotApplication_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-UpdateRobotApplication-response-arn)": "string",
   "[lastUpdatedAt](#robomaker-UpdateRobotApplication-response-lastUpdatedAt)": number,
   "[name](#robomaker-UpdateRobotApplication-response-name)": "string",
   "[revisionId](#robomaker-UpdateRobotApplication-response-revisionId)": "string",
   "[robotSoftwareSuite](#robomaker-UpdateRobotApplication-response-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-UpdateRobotApplication-response-sources)": [ 
      { 
         "[architecture](API_Source.md#robomaker-Type-Source-architecture)": "string",
         "[etag](API_Source.md#robomaker-Type-Source-etag)": "string",
         "[s3Bucket](API_Source.md#robomaker-Type-Source-s3Bucket)": "string",
         "[s3Key](API_Source.md#robomaker-Type-Source-s3Key)": "string"
      }
   ],
   "[version](#robomaker-UpdateRobotApplication-response-version)": "string"
}
```

## Response Elements<a name="API_UpdateRobotApplication_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-arn"></a>
The Amazon Resource Name \(ARN\) of the updated robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastUpdatedAt](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the robot application was last updated\.  
Type: Timestamp

 ** [name](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-name"></a>
The name of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [revisionId](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-revisionId"></a>
The revision id of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Pattern: `[a-zA-Z0-9_.\-]*` 

 ** [robotSoftwareSuite](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-robotSoftwareSuite"></a>
The robot software suite \(ROS distribution\) used by the robot application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object

 ** [sources](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-sources"></a>
The sources of the robot application\.  
Type: Array of [Source](API_Source.md) objects

 ** [version](#API_UpdateRobotApplication_ResponseSyntax) **   <a name="robomaker-UpdateRobotApplication-response-version"></a>
The version of the robot application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*` 

## Errors<a name="API_UpdateRobotApplication_Errors"></a>

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

 **ResourceNotFoundException**   
The specified resource does not exist\.  
HTTP Status Code: 400

 **ThrottlingException**   
AWS RoboMaker is temporarily unable to process the request\. Try your call again\.  
HTTP Status Code: 400

## See Also<a name="API_UpdateRobotApplication_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/UpdateRobotApplication) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/UpdateRobotApplication) 