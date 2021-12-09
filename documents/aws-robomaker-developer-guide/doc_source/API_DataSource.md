# DataSource<a name="API_DataSource"></a>

Information about a data source\.

## Contents<a name="API_DataSource_Contents"></a>

 **name**   <a name="robomaker-Type-DataSource-name"></a>
The name of the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 255\.  
Pattern: `[a-zA-Z0-9_\-]*`   
Required: No

 **s3Bucket**   <a name="robomaker-Type-DataSource-s3Bucket"></a>
The S3 bucket where the data files are located\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][a-z0-9.\-]*[a-z0-9]`   
Required: No

 **s3Keys**   <a name="robomaker-Type-DataSource-s3Keys"></a>
The list of S3 keys identifying the data source files\.  
Type: Array of [S3KeyOutput](API_S3KeyOutput.md) objects  
Required: No

## See Also<a name="API_DataSource_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/robomaker-2018-06-29/DataSource) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/robomaker-2018-06-29/DataSource) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/robomaker-2018-06-29/DataSource) 
+  [AWS SDK for Ruby V2](https://docs.aws.amazon.com/goto/SdkForRubyV2/robomaker-2018-06-29/DataSource) 