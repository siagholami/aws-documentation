# FailedCreateSimulationJobRequest<a name="API_FailedCreateSimulationJobRequest"></a>

Information about a failed create simulation job request\.

## Contents<a name="API_FailedCreateSimulationJobRequest_Contents"></a>

 **failedAt**   <a name="robomaker-Type-FailedCreateSimulationJobRequest-failedAt"></a>
The time, in milliseconds since the epoch, when the simulation job batch failed\.  
Type: Timestamp  
Required: No

 **failureCode**   <a name="robomaker-Type-FailedCreateSimulationJobRequest-failureCode"></a>
The failure code\.  
Type: String  
Valid Values:` InternalServiceError | RobotApplicationCrash | SimulationApplicationCrash | BadPermissionsRobotApplication | BadPermissionsSimulationApplication | BadPermissionsS3Object | BadPermissionsS3Output | BadPermissionsCloudwatchLogs | SubnetIpLimitExceeded | ENILimitExceeded | BadPermissionsUserCredentials | InvalidBundleRobotApplication | InvalidBundleSimulationApplication | InvalidS3Resource | LimitExceeded | MismatchedEtag | RobotApplicationVersionMismatchedEtag | SimulationApplicationVersionMismatchedEtag | ResourceNotFound | RequestThrottled | BatchTimedOut | BatchCanceled | InvalidInput | WrongRegionS3Bucket | WrongRegionS3Output | WrongRegionRobotApplication | WrongRegionSimulationApplication`   
Required: No

 **failureReason**   <a name="robomaker-Type-FailedCreateSimulationJobRequest-failureReason"></a>
The failure reason of the simulation job request\.  
Type: String  
Required: No

 **request**   <a name="robomaker-Type-FailedCreateSimulationJobRequest-request"></a>
The simulation job request\.  
Type: [SimulationJobRequest](API_SimulationJobRequest.md) object  
Required: No

## See Also<a name="API_FailedCreateSimulationJobRequest_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/FailedCreateSimulationJobRequest) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/FailedCreateSimulationJobRequest) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/FailedCreateSimulationJobRequest) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/FailedCreateSimulationJobRequest) 