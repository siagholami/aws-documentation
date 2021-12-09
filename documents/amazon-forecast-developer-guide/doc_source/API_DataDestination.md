# DataDestination<a name="API_DataDestination"></a>

The destination for an exported forecast, an AWS Identity and Access Management \(IAM\) role that allows Amazon Forecast to access the location and, optionally, an AWS Key Management Service \(KMS\) key\. This object is submitted in the [CreateForecastExportJob](API_CreateForecastExportJob.md) request\.

## Contents<a name="API_DataDestination_Contents"></a>

 **S3Config**   <a name="forecast-Type-DataDestination-S3Config"></a>
The path to an Amazon Simple Storage Service \(Amazon S3\) bucket along with the credentials to access the bucket\.  
Type: [S3Config](API_S3Config.md) object  
Required: Yes

## See Also<a name="API_DataDestination_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DataDestination) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DataDestination) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DataDestination) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DataDestination) 