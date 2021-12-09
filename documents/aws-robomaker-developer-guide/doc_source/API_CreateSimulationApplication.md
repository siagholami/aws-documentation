# CreateSimulationApplication<a name="API_CreateSimulationApplication"></a>

Creates a simulation application\.

## Request Syntax<a name="API_CreateSimulationApplication_RequestSyntax"></a>

```
POST /createSimulationApplication HTTP/1.1
Content-type: application/json

{
   "[name](#robomaker-CreateSimulationApplication-request-name)": "string",
   "[renderingEngine](#robomaker-CreateSimulationApplication-request-renderingEngine)": { 
      "[name](API_RenderingEngine.md#robomaker-Type-RenderingEngine-name)": "string",
      "[version](API_RenderingEngine.md#robomaker-Type-RenderingEngine-version)": "string"
   },
   "[robotSoftwareSuite](#robomaker-CreateSimulationApplication-request-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[simulationSoftwareSuite](#robomaker-CreateSimulationApplication-request-simulationSoftwareSuite)": { 
      "[name](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-name)": "string",
      "[version](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-CreateSimulationApplication-request-sources)": [ 
      { 
         "[architecture](API_SourceConfig.md#robomaker-Type-SourceConfig-architecture)": "string",
         "[s3Bucket](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Bucket)": "string",
         "[s3Key](API_SourceConfig.md#robomaker-Type-SourceConfig-s3Key)": "string"
      }
   ],
   "[tags](#robomaker-CreateSimulationApplication-request-tags)": { 
      "string" : "string" 
   }
}
```

## URI Request Parameters<a name="API_CreateSimulationApplication_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_CreateSimulationApplication_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [name](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-name"></a>
The name of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: Yes

 ** [renderingEngine](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-renderingEngine"></a>
The rendering engine for the simulation application\.  
Type: [RenderingEngine](API_RenderingEngine.md) object  
Required: No

 ** [robotSoftwareSuite](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-robotSoftwareSuite"></a>
The robot software suite \(ROS distribution\) used by the simulation application\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object  
Required: Yes

 ** [simulationSoftwareSuite](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-simulationSoftwareSuite"></a>
The simulation software suite used by the simulation application\.  
Type: [SimulationSoftwareSuite](API_SimulationSoftwareSuite.md) object  
Required: Yes

 ** [sources](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-sources"></a>
The sources of the simulation application\.  
Type: Array of [SourceConfig](API_SourceConfig.md) objects  
Required: Yes

 ** [tags](#API_CreateSimulationApplication_RequestSyntax) **   <a name="robomaker-CreateSimulationApplication-request-tags"></a>
A map that contains tag keys and tag values that are attached to the simulation application\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Required: No

## Response Syntax<a name="API_CreateSimulationApplication_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-CreateSimulationApplication-response-arn)": "string",
   "[lastUpdatedAt](#robomaker-CreateSimulationApplication-response-lastUpdatedAt)": number,
   "[name](#robomaker-CreateSimulationApplication-response-name)": "string",
   "[renderingEngine](#robomaker-CreateSimulationApplication-response-renderingEngine)": { 
      "[name](API_RenderingEngine.md#robomaker-Type-RenderingEngine-name)": "string",
      "[version](API_RenderingEngine.md#robomaker-Type-RenderingEngine-version)": "string"
   },
   "[revisionId](#robomaker-CreateSimulationApplication-response-revisionId)": "string",
   "[robotSoftwareSuite](#robomaker-CreateSimulationApplication-response-robotSoftwareSuite)": { 
      "[name](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-name)": "string",
      "[version](API_RobotSoftwareSuite.md#robomaker-Type-RobotSoftwareSuite-version)": "string"
   },
   "[simulationSoftwareSuite](#robomaker-CreateSimulationApplication-response-simulationSoftwareSuite)": { 
      "[name](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-name)": "string",
      "[version](API_SimulationSoftwareSuite.md#robomaker-Type-SimulationSoftwareSuite-version)": "string"
   },
   "[sources](#robomaker-CreateSimulationApplication-response-sources)": [ 
      { 
         "[architecture](API_Source.md#robomaker-Type-Source-architecture)": "string",
         "[etag](API_Source.md#robomaker-Type-Source-etag)": "string",
         "[s3Bucket](API_Source.md#robomaker-Type-Source-s3Bucket)": "string",
         "[s3Key](API_Source.md#robomaker-Type-Source-s3Key)": "string"
      }
   ],
   "[tags](#robomaker-CreateSimulationApplication-response-tags)": { 
      "string" : "string" 
   },
   "[version](#robomaker-CreateSimulationApplication-response-version)": "string"
}
```

## Response Elements<a name="API_CreateSimulationApplication_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-arn"></a>
The Amazon Resource Name \(ARN\) of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [lastUpdatedAt](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the simulation application was last updated\.  
Type: Timestamp

 ** [name](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-name"></a>
The name of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [renderingEngine](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-renderingEngine"></a>
The rendering engine for the simulation application\.  
Type: [RenderingEngine](API_RenderingEngine.md) object

 ** [revisionId](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-revisionId"></a>
The revision id of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Pattern: `[a-zA-Z0-9_.\-]*` 

 ** [robotSoftwareSuite](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-robotSoftwareSuite"></a>
Information about the robot software suite \(ROS distribution\)\.  
Type: [RobotSoftwareSuite](API_RobotSoftwareSuite.md) object

 ** [simulationSoftwareSuite](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-simulationSoftwareSuite"></a>
The simulation software suite used by the simulation application\.  
Type: [SimulationSoftwareSuite](API_SimulationSoftwareSuite.md) object

 ** [sources](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-sources"></a>
The sources of the simulation application\.  
Type: Array of [Source](API_Source.md) objects

 ** [tags](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-tags"></a>
The list of all tags added to the simulation application\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

 ** [version](#API_CreateSimulationApplication_ResponseSyntax) **   <a name="robomaker-CreateSimulationApplication-response-version"></a>
The version of the simulation application\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `(\$LATEST)|[0-9]*` 

## Errors<a name="API_CreateSimulationApplication_Errors"></a>

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

## See Also<a name="API_CreateSimulationApplication_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/CreateSimulationApplication) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/CreateSimulationApplication) 