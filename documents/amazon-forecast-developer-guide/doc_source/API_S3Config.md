# S3Config<a name="API_S3Config"></a>

The path to the file\(s\) in an Amazon Simple Storage Service \(Amazon S3\) bucket, and an AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the file\(s\)\. Optionally, includes an AWS Key Management Service \(KMS\) key\. This object is part of the [DataSource](API_DataSource.md) object that is submitted in the [CreateDatasetImportJob](API_CreateDatasetImportJob.md) request, and part of the [DataDestination](API_DataDestination.md) object that is submitted in the [CreateForecastExportJob](API_CreateForecastExportJob.md) request\.

## Contents<a name="API_S3Config_Contents"></a>

 **KMSKeyArn**   <a name="forecast-Type-S3Config-KMSKeyArn"></a>
The Amazon Resource Name \(ARN\) of an AWS Key Management Service \(KMS\) key\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:aws:kms:.*:key/.*`   
Required: No

 **Path**   <a name="forecast-Type-S3Config-Path"></a>
The path to an Amazon Simple Storage Service \(Amazon S3\) bucket or file\(s\) in an Amazon S3 bucket\.  
Type: String  
Pattern: `^s3://[a-z0-9].+$`   
Required: Yes

 **RoleArn**   <a name="forecast-Type-S3Config-RoleArn"></a>
The ARN of the AWS Identity and Access Management \(IAM\) role that Amazon Forecast can assume to access the Amazon S3 bucket or files\. If you provide a value for the `KMSKeyArn` key, the role must allow access to the key\.  
Passing a role across AWS accounts is not allowed\. If you pass a role that isn't in your account, you get an `InvalidInputException` error\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## See Also<a name="API_S3Config_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/S3Config) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/S3Config) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/S3Config) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/S3Config) 