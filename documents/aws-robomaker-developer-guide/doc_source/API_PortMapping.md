# PortMapping<a name="API_PortMapping"></a>

An object representing a port mapping\.

## Contents<a name="API_PortMapping_Contents"></a>

 **applicationPort**   <a name="robomaker-Type-PortMapping-applicationPort"></a>
The port number on the application\.  
Type: Integer  
Valid Range: Minimum value of 1024\. Maximum value of 65535\.  
Required: Yes

 **enableOnPublicIp**   <a name="robomaker-Type-PortMapping-enableOnPublicIp"></a>
A Boolean indicating whether to enable this port mapping on public IP\.  
Type: Boolean  
Required: No

 **jobPort**   <a name="robomaker-Type-PortMapping-jobPort"></a>
The port number on the simulation job instance to use as a remote connection point\.   
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 65535\.  
Required: Yes

## See Also<a name="API_PortMapping_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/PortMapping) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/PortMapping) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/PortMapping) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/PortMapping) 