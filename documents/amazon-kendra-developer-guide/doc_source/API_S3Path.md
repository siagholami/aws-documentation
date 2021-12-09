--------

--------

# S3Path<a name="API_S3Path"></a>

Information required to find a specific file in an Amazon S3 bucket\.

## Contents<a name="API_S3Path_Contents"></a>

 **Bucket**   <a name="Kendra-Type-S3Path-Bucket"></a>
The name of the S3 bucket that contains the file\.  
Type: String  
Length Constraints: Minimum length of 3\. Maximum length of 63\.  
Pattern: `[a-z0-9][\.\-a-z0-9]{1,61}[a-z0-9]`   
Required: Yes

 **Key**   <a name="Kendra-Type-S3Path-Key"></a>
The name of the file\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Required: Yes

## See Also<a name="API_S3Path_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/S3Path) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/S3Path) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/S3Path) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/S3Path) 