--------

--------

# BatchDeleteDocumentResponseFailedDocument<a name="API_BatchDeleteDocumentResponseFailedDocument"></a>

Provides information about documents that could not be removed from an index by the [BatchDeleteDocument](API_BatchDeleteDocument.md) operation\.

## Contents<a name="API_BatchDeleteDocumentResponseFailedDocument_Contents"></a>

 **ErrorCode**   <a name="Kendra-Type-BatchDeleteDocumentResponseFailedDocument-ErrorCode"></a>
The error code for why the document couldn't be removed from the index\.  
Type: String  
Valid Values:` InternalError | InvalidRequest`   
Required: No

 **ErrorMessage**   <a name="Kendra-Type-BatchDeleteDocumentResponseFailedDocument-ErrorMessage"></a>
An explanation for why the document couldn't be removed from the index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^\P{C}*$`   
Required: No

 **Id**   <a name="Kendra-Type-BatchDeleteDocumentResponseFailedDocument-Id"></a>
The identifier of the document that couldn't be removed from the index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Required: No

## See Also<a name="API_BatchDeleteDocumentResponseFailedDocument_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/BatchDeleteDocumentResponseFailedDocument) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/BatchDeleteDocumentResponseFailedDocument) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/BatchDeleteDocumentResponseFailedDocument) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/BatchDeleteDocumentResponseFailedDocument) 