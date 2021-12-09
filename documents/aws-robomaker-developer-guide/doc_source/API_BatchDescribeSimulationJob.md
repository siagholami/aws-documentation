# BatchDescribeSimulationJob<a name="API_BatchDescribeSimulationJob"></a>

Describes one or more simulation jobs\.

## Request Syntax<a name="API_BatchDescribeSimulationJob_RequestSyntax"></a>

```
POST /batchDescribeSimulationJob HTTP/1.1
Content-type: application/json

{
   "[jobs](#robomaker-BatchDescribeSimulationJob-request-jobs)": [ "string" ]
}
```

## URI Request Parameters<a name="API_BatchDescribeSimulationJob_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_BatchDescribeSimulationJob_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [jobs](#API_BatchDescribeSimulationJob_RequestSyntax) **   <a name="robomaker-BatchDescribeSimulationJob-request-jobs"></a>
A list of Amazon Resource Names \(ARNs\) of simulation jobs to describe\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*`   
Required: Yes

## Response Syntax<a name="API_BatchDescribeSimulationJob_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[jobs](#robomaker-BatchDescribeSimulationJob-response-jobs)": [ 
      { 
         "[arn](API_SimulationJob.md#robomaker-Type-SimulationJob-arn)": "string",
         "[clientRequestToken](API_SimulationJob.md#robomaker-Type-SimulationJob-clientRequestToken)": "string",
         "[dataSources](API_SimulationJob.md#robomaker-Type-SimulationJob-dataSources)": [ 
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
         "[failureBehavior](API_SimulationJob.md#robomaker-Type-SimulationJob-failureBehavior)": "string",
         "[failureCode](API_SimulationJob.md#robomaker-Type-SimulationJob-failureCode)": "string",
         "[failureReason](API_SimulationJob.md#robomaker-Type-SimulationJob-failureReason)": "string",
         "[iamRole](API_SimulationJob.md#robomaker-Type-SimulationJob-iamRole)": "string",
         "[lastStartedAt](API_SimulationJob.md#robomaker-Type-SimulationJob-lastStartedAt)": number,
         "[lastUpdatedAt](API_SimulationJob.md#robomaker-Type-SimulationJob-lastUpdatedAt)": number,
         "[loggingConfig](API_SimulationJob.md#robomaker-Type-SimulationJob-loggingConfig)": { 
            "[recordAllRosTopics](API_LoggingConfig.md#robomaker-Type-LoggingConfig-recordAllRosTopics)": boolean
         },
         "[maxJobDurationInSeconds](API_SimulationJob.md#robomaker-Type-SimulationJob-maxJobDurationInSeconds)": number,
         "[name](API_SimulationJob.md#robomaker-Type-SimulationJob-name)": "string",
         "[networkInterface](API_SimulationJob.md#robomaker-Type-SimulationJob-networkInterface)": { 
            "[networkInterfaceId](API_NetworkInterface.md#robomaker-Type-NetworkInterface-networkInterfaceId)": "string",
            "[privateIpAddress](API_NetworkInterface.md#robomaker-Type-NetworkInterface-privateIpAddress)": "string",
            "[publicIpAddress](API_NetworkInterface.md#robomaker-Type-NetworkInterface-publicIpAddress)": "string"
         },
         "[outputLocation](API_SimulationJob.md#robomaker-Type-SimulationJob-outputLocation)": { 
            "[s3Bucket](API_OutputLocation.md#robomaker-Type-OutputLocation-s3Bucket)": "string",
            "[s3Prefix](API_OutputLocation.md#robomaker-Type-OutputLocation-s3Prefix)": "string"
         },
         "[robotApplications](API_SimulationJob.md#robomaker-Type-SimulationJob-robotApplications)": [ 
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
         "[simulationApplications](API_SimulationJob.md#robomaker-Type-SimulationJob-simulationApplications)": [ 
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
         "[simulationTimeMillis](API_SimulationJob.md#robomaker-Type-SimulationJob-simulationTimeMillis)": number,
         "[status](API_SimulationJob.md#robomaker-Type-SimulationJob-status)": "string",
         "[tags](API_SimulationJob.md#robomaker-Type-SimulationJob-tags)": { 
            "string" : "string" 
         },
         "[vpcConfig](API_SimulationJob.md#robomaker-Type-SimulationJob-vpcConfig)": { 
            "[assignPublicIp](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-assignPublicIp)": boolean,
            "[securityGroups](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-securityGroups)": [ "string" ],
            "[subnets](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-subnets)": [ "string" ],
            "[vpcId](API_VPCConfigResponse.md#robomaker-Type-VPCConfigResponse-vpcId)": "string"
         }
      }
   ],
   "[unprocessedJobs](#robomaker-BatchDescribeSimulationJob-response-unprocessedJobs)": [ "string" ]
}
```

## Response Elements<a name="API_BatchDescribeSimulationJob_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [jobs](#API_BatchDescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-BatchDescribeSimulationJob-response-jobs"></a>
A list of simulation jobs\.  
Type: Array of [SimulationJob](API_SimulationJob.md) objects

 ** [unprocessedJobs](#API_BatchDescribeSimulationJob_ResponseSyntax) **   <a name="robomaker-BatchDescribeSimulationJob-response-unprocessedJobs"></a>
A list of unprocessed simulation job Amazon Resource Names \(ARNs\)\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 1224\.  
Pattern: `arn:.*` 

## Errors<a name="API_BatchDescribeSimulationJob_Errors"></a>

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

## See Also<a name="API_BatchDescribeSimulationJob_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/robomaker-2018-06-29/BatchDescribeSimulationJob) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/BatchDescribeSimulationJob) 