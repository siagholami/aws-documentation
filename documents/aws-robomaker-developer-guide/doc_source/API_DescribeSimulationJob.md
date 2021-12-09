# DescribeSimulationJob<a name="API_DescribeSimulationJob"></a>

Describes a simulation job\.

## Request Syntax<a name="API_DescribeSimulationJob_RequestSyntax"></a>

```
POST /describeSimulationJob HTTP/1.1
Content-type: application/json

{
   "[job](#robomaker-DescribeSimulationJob-request-job)": "string"
}
```

## URI Request Parameters<a name="API_DescribeSimulationJob_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_DescribeSimulationJob_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [job](#API_DescribeSimulationJob_RequestSyntax) **   <a name="robomaker-DescribeSimulationJob-request-job"></a>
The Amazon Resource Name \(ARN\) of the simulation job to be described\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_DescribeSimulationJob_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[arn](#robomaker-DescribeSimulationJob-response-arn)": "string",
   "[clientRequestToken](#robomaker-DescribeSimulationJob-response-clientRequestToken)": "string",
   "[dataSources](#robomaker-DescribeSimulationJob-response-dataSources)": [ 
      { 
         "[name](API_DataSource.md#robomaker-Type-DataSource-name)": "string",
         "[s3Bucket](API_DataSource.md#robomaker-Type-DataSource-s3Bucket)": "string",
         "[s3Keys](API_DataSource.md#robomaker-Type-DataSource-s3Keys)": [ 
            { 
               "[etag](API_S3KeyOutput.md#robomaker-Type-S3KeyOutput-etag)": "string",
               "[s3Key](API_S3KeyOutput.md#robomaker-Type-S3KeyOutput-s3Key)": "string"
            }
         ]
      }
   ],
   "[failureBehavior](#robomaker-DescribeSimulationJob-response-failureBehavior)": "string",
   "[failureCode](#robomaker-DescribeSimulationJob-response-failureCode)": "string",
   "[failureReason](#robomaker-DescribeSimulationJob-response-failureReason)": "string",
   "[iamRole](#robomaker-DescribeSimulationJob-response-iamRole)": "string",
   "[lastStartedAt](#robomaker-DescribeSimulationJob-response-lastStartedAt)": number,
   "[lastUpdatedAt](#robomaker-DescribeSimulationJob-response-lastUpdatedAt)": number,
   "[loggingConfig](#robomaker-DescribeSimulationJob-response-loggingConfig)": { 
      "[recordAllRosTopics](API_LoggingConfig.md#robomaker-Type-LoggingConfig-recordAllRosTopics)": boolean
   },
   "[maxJobDurationInSeconds](#robomaker-DescribeSimulationJob-response-maxJobDurationInSeconds)": number,
   "[name](#robomaker-DescribeSimulationJob-response-name)": "string",
   "[networkInterface](#robomaker-DescribeSimulationJob-response-networkInterface)": { 
      "[networkInterfaceId](API_NetworkInterface.md#robomaker-Type-NetworkInterface-networkInterfaceId)": "string",
      "[privateIpAddress](API_NetworkInterface.md#robomaker-Type-NetworkInterface-privateIpAddress)": "string",
      "[publicIpAddress](API_NetworkInterface.md#robomaker-Type-NetworkInterface-publicIpAddress)": "string"
   },
   "[outputLocation](#robomaker-DescribeSimulationJob-response-outputLocation)": { 
      "[s3Bucket](API_OutputLocation.md#robomaker-Type-OutputLocation-s3Bucket)": "string",
      "[s3Prefix](API_OutputLocation.md#robomaker-Type-OutputLocation-s3Prefix)": "string"
   },
   "[robotApplications](#robomaker-DescribeSimulationJob-response-robotApplications)": [ 
      { 
         "[application](API_RobotApplicationConfig.md#robomaker-Type-RobotApplicationConfig-application)": "string",
         "[applicationVersion](API_RobotApplicationConfig.md#robomaker-Type-RobotApplicationConfig-applicationVersion)": "string",
         "[launchConfig](API_RobotApplicationConfig.md#robomaker-Type-RobotApplicationConfig-launchConfig)": { 
            "[environmentVariables](API_LaunchConfig.md#robomaker-Type-LaunchConfig-environmentVariables)": { 
               "string" : "string" 
            },
            "[launchFile](API_LaunchConfig.md#robomaker-Type-LaunchConfig-launchFile)": "string",
            "[packageName](API_LaunchConfig.md#robomaker-Type-LaunchConfig-packageName)": "string",
            "[portForwardingConfig](API_LaunchConfig.md#robomaker-Type-LaunchConfig-portForwardingConfig)": { 
               "[portMappings](API_PortForwardingConfig.md#robomaker-Type-PortForwardingConfig-portMappings)": [ 
                  { 
                     "[applicationPort](API_PortMapping.md#robomaker-Type-PortMapping-applicationPort)": number,
                     "[enableOnPublicIp](API_PortMapping.md#robomaker-Type-PortMapping-enableOnPublicIp)": boolean,
                     "[jobPort](API_PortMapping.md#robomaker-Type-PortMapping-jobPort)": number
                  }
               ]
            }
         }
      }
   ],
   "[simulationApplications](#robomaker-DescribeSimulationJob-response-simulationApplications)": [ 
      { 
         "[application](API_SimulationApplicationConfig.md#robomaker-Type-SimulationApplicationConfig-application)": "string",
         "[applicationVersion](API_SimulationApplicationConfig.md#robomaker-Type-SimulationApplicationConfig-applicationVersion)": "string",
         "[launchConfig](API_SimulationApplicationConfig.md#robomaker-Type-SimulationApplicationConfig-launchConfig)": { 
            "[environmentVariables](API_LaunchConfig.md#robomaker-Type-LaunchConfig-environmentVariables)": { 
               "string" : "string" 
            },
            "[launchFile](API_LaunchConfig.md#robomaker-Type-LaunchConfig-launchFile)": "string",
            "[packageName](API_LaunchConfig.md#robomaker-Type-LaunchConfig-packageName)": "string",
            "[portForwardingConfig](API_LaunchConfig.md#robomaker-Type-LaunchConfig-portForwardingConfig)": { 
               "[portMappings](API_PortForwardingConfig.md#robomaker-Type-PortForwardingConfig-portMappings)": [ 
                  { 
                     "[applicationPort](API_PortMapping.md#robomaker-Type-PortMapping-applicationPort)": number,
                     "[enableOnPublicIp](API_PortMapping.md#robomaker-Type-PortMapping-enableOnPublicIp)": boolean,
                     "[jobPort](API_PortMapping.md#robomaker-Type-PortMapping-jobPort)": number
                  }
               ]
            }
         }
      }
   ],
   "[simulationTimeMillis](#robomaker-DescribeSimulationJob-response-simulationTimeMillis)": number,
   "[status](#robomaker-DescribeSimulationJob-response-status)": "string",
   "[tags](#robomaker-DescribeSimulationJob-response-tags)": { 
      "string" : "string" 
   },
   "[vpcConfig](#robomaker-DescribeSimulationJob-response-vpcConfig)": { 
      "[assignPublicIp](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-assignPublicIp)": boolean,
      "[securityGroups](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-securityGroups)": [ "string" ],
      "[subnets](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-subnets)": [ "string" ],
      "[vpcId](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-vpcId)": "string"
   }
}
```

## Response Elements<a name="API_DescribeSimulationJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [arn](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-arn"></a>
The Amazon Resource Name \(ARN\) of the simulation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

 ** [clientRequestToken](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-clientRequestToken"></a>
Unique, case\-sensitive identifier that you provide to ensure the idempotency of the request\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 64\.  
Pattern: `[a-zA-Z0-9_\-=]*` 

 ** [dataSources](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-dataSources"></a>
The data sources for the simulation job\.  
Type: Array of [DataSource](API_DataSource.md) objects

 ** [failureBehavior](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-failureBehavior"></a>
The failure behavior for the simulation job\.  
Type: String  
Valid Values:` Fail | Continue` 

 ** [failureCode](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-failureCode"></a>
The failure code of the simulation job if it failed:    
InternalServiceError  
Internal service error\.  
RobotApplicationCrash  
Robot application exited abnormally\.  
SimulationApplicationCrash  
 Simulation application exited abnormally\.  
BadPermissionsRobotApplication  
Robot application bundle could not be downloaded\.  
BadPermissionsSimulationApplication  
Simulation application bundle could not be downloaded\.  
BadPermissionsS3Output  
Unable to publish outputs to customer\-provided S3 bucket\.  
BadPermissionsCloudwatchLogs  
Unable to publish logs to customer\-provided CloudWatch Logs resource\.  
SubnetIpLimitExceeded  
Subnet IP limit exceeded\.  
ENILimitExceeded  
ENI limit exceeded\.  
BadPermissionsUserCredentials  
Unable to use the Role provided\.  
InvalidBundleRobotApplication  
Robot bundle cannot be extracted \(invalid format, bundling error, or other issue\)\.  
InvalidBundleSimulationApplication  
Simulation bundle cannot be extracted \(invalid format, bundling error, or other issue\)\.  
RobotApplicationVersionMismatchedEtag  
Etag for RobotApplication does not match value during version creation\.  
SimulationApplicationVersionMismatchedEtag  
Etag for SimulationApplication does not match value during version creation\.
Type: String  
Valid Values:` InternalServiceError | RobotApplicationCrash | SimulationApplicationCrash | BadPermissionsRobotApplication | BadPermissionsSimulationApplication | BadPermissionsS3Object | BadPermissionsS3Output | BadPermissionsCloudwatchLogs | SubnetIpLimitExceeded | ENILimitExceeded | BadPermissionsUserCredentials | InvalidBundleRobotApplication | InvalidBundleSimulationApplication | InvalidS3Resource | LimitExceeded | MismatchedEtag | RobotApplicationVersionMismatchedEtag | SimulationApplicationVersionMismatchedEtag | ResourceNotFound | RequestThrottled | BatchTimedOut | BatchCanceled | InvalidInput | WrongRegionS3Bucket | WrongRegionS3Output | WrongRegionRobotApplication | WrongRegionSimulationApplication` 

 ** [failureReason](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-failureReason"></a>
Details about why the simulation job failed\. For more information about troubleshooting, see [Troubleshooting](https://docs.aws.amazon.com/robomaker/latest/dg/troubleshooting.html)\.  
Type: String

 ** [iamRole](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-iamRole"></a>
The IAM role that allows the simulation instance to call the AWS APIs that are specified in its associated policies on your behalf\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `arn:aws:iam::\w+:role/.*` 

 ** [lastStartedAt](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-lastStartedAt"></a>
The time, in milliseconds since the epoch, when the simulation job was last started\.  
Type: Timestamp

 ** [lastUpdatedAt](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-lastUpdatedAt"></a>
The time, in milliseconds since the epoch, when the simulation job was last updated\.  
Type: Timestamp

 ** [loggingConfig](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-loggingConfig"></a>
The logging configuration\.  
Type: [LoggingConfig](API_LoggingConfig.md) object

 ** [maxJobDurationInSeconds](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-maxJobDurationInSeconds"></a>
The maximum job duration in seconds\. The value must be 8 days \(691,200 seconds\) or less\.  
Type: Long

 ** [name](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-name"></a>
The name of the simulation job\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*` 

 ** [networkInterface](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-networkInterface"></a>
The network interface information for the simulation job\.  
Type: [NetworkInterface](API_NetworkInterface.md) object

 ** [outputLocation](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-outputLocation"></a>
Location for output files generated by the simulation job\.  
Type: [OutputLocation](API_OutputLocation.md) object

 ** [robotApplications](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-robotApplications"></a>
A list of robot applications\.  
Type: Array of [RobotApplicationConfig](API_RobotApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.

 ** [simulationApplications](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-simulationApplications"></a>
A list of simulation applications\.  
Type: Array of [SimulationApplicationConfig](API_SimulationApplicationConfig.md) objects  
Array Members: Fixed number of 1 item\.

 ** [simulationTimeMillis](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-simulationTimeMillis"></a>
The simulation job execution duration in milliseconds\.  
Type: Long

 ** [status](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-status"></a>
The status of the simulation job\.  
Type: String  
Valid Values:` Pending | Preparing | Running | Restarting | Completed | Failed | RunningFailed | Terminating | Terminated | Canceled` 

 ** [tags](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-tags"></a>
The list of all tags added to the specified simulation job\.  
Type: String to string map  
Key Length Constraints: Minimum length of 1\. Maximum length of 128\.  
Key Pattern: `[a-zA-Z0-9 _.\-\/+=:]*`   
Value Length Constraints: Minimum length of 0\. Maximum length of 256\.  
Value Pattern: `[a-zA-Z0-9 _.\-\/+=:]*` 

 ** [vpcConfig](#API_DescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-DescribeSimulationJob-response-vpcConfig"></a>
The VPC configuration\.  
Type: [VPCConfigResponse](API_VPCConfigResponse.md) object

## Errors<a name="API_DescribeSimulationJob_Errors"></a>

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

## See Also<a name="API_DescribeSimulationJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/DescribeSimulationJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DescribeSimulationJob) 