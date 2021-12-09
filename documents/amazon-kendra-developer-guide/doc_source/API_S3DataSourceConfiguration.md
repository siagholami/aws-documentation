--------

--------

# S3DataSourceConfiguration<a name="API_S3DataSourceConfiguration"></a>

Provides configuration information for a data source to index documents in an Amazon S3 bucket\.

## Contents<a name="API_S3DataSourceConfiguration_Contents"></a>

 **AccessControlListConfiguration**   <a name="Kendra-Type-S3DataSourceConfiguration-AccessControlListConfiguration"></a>
Provides the path to the S3 bucket that contains the user context filtering files for the data source\.  
Type: [AccessControlListConfiguration](API_AccessControlListConfiguration.md) object  
Required: No

 **BucketName**   <a name="Kendra-Type-S3DataSourceConfiguration-BucketName"></a>
The name of the bucket that contains the documents\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][\.\-a-z0-9]{1,61}[a-z0-9]`   
Required: Yes

 **DocumentsMetadataConfiguration**   <a name="Kendra-Type-S3DataSourceConfiguration-DocumentsMetadataConfiguration"></a>
Document metadata files that contain information such as the document access control information, source URI, document author, and custom attributes\. Each metadata file contains metadata about a single document\.  
Type: [DocumentsMetadataConfiguration](API_DocumentsMetadataConfiguration.md) object  
Required: No

 **ExclusionPatterns**   <a name="Kendra-Type-S3DataSourceConfiguration-ExclusionPatterns"></a>
A list of glob patterns for documents that should not be indexed\. If a document that matches an inclusion prefix also matches an exclusion pattern, the document is not indexed\.  
For more information about glob patterns, see [glob \(programming\)](https://en.wikipedia.org/wiki/Glob_(programming)) in *Wikipedia*\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **InclusionPrefixes**   <a name="Kendra-Type-S3DataSourceConfiguration-InclusionPrefixes"></a>
A list of S3 prefixes for the documents that should be included in the index\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

## See Also<a name="API_S3DataSourceConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/S3DataSourceConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/S3DataSourceConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/S3DataSourceConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/S3DataSourceConfiguration) 