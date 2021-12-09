# ProgressDetail<a name="API_ProgressDetail"></a>

Information about the progress of a deployment job\.

## Contents<a name="API_ProgressDetail_Contents"></a>

 **currentProgress**   <a name="robomaker-Type-ProgressDetail-currentProgress"></a>
The current progress status\.    
Validating  
Validating the deployment\.  
DownloadingExtracting  
Downloading and extracting the bundle on the robot\.  
ExecutingPreLaunch  
Executing pre\-launch script\(s\) if provided\.  
Launching  
Launching the robot application\.  
ExecutingPostLaunch  
Executing post\-launch script\(s\) if provided\.  
Finished  
Deployment is complete\.
Type: String  
Valid Values:` Validating | DownloadingExtracting | ExecutingDownloadCondition | ExecutingPreLaunch | Launching | ExecutingPostLaunch | Finished`   
Required: No

 **estimatedTimeRemainingSeconds**   <a name="robomaker-Type-ProgressDetail-estimatedTimeRemainingSeconds"></a>
Estimated amount of time in seconds remaining in the step\. This currently only applies to the `Downloading/Extracting` step of the deployment\. It is empty for other steps\.  
Type: Integer  
Required: No

 **percentDone**   <a name="robomaker-Type-ProgressDetail-percentDone"></a>
Precentage of the step that is done\. This currently only applies to the `Downloading/Extracting` step of the deployment\. It is empty for other steps\.  
Type: Float  
Valid Range: Minimum value of 0\.0\. Maximum value of 100\.0\.  
Required: No

 **targetResource**   <a name="robomaker-Type-ProgressDetail-targetResource"></a>
The Amazon Resource Name \(ARN\) of the deployment job\.  
Type: String  
Required: No

## See Also<a name="API_ProgressDetail_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/ProgressDetail) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/ProgressDetail) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/ProgressDetail) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/ProgressDetail) 