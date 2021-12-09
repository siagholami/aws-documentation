# DataSource<a name="API_DataSource"></a>

The source of your training data, an AWS Identity and Access Management \(IAM\) role that allows Amazon Forecast to access the data and, optionally, an AWS Key Management Service \(KMS\) key\. This object is submitted in the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) request\.

## Contents<a name="API_DataSource_Contents"></a>

 **S3Config**   <a name="forecast-Type-DataSource-S3Config"></a>
The path to the training data stored in an Amazon Simple Storage Service \(Amazon S3\) bucket along with the credentials to access the data\.  
Type: [S3Config](API_S3Config.md) object  
Required: Yes

## See Also<a name="API_DataSource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/DataSource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/DataSource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/DataSource) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/DataSource) 