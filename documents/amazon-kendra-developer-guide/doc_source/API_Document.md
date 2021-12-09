--------

--------

# Document<a name="API_Document"></a>

A document in an index\.

## Contents<a name="API_Document_Contents"></a>

 **AccessControlList**   <a name="Kendra-Type-Document-AccessControlList"></a>
Information to use for user context filtering\.  
Type: Array of [Principal](API_Principal.md) objects  
Required: No

 **Attributes**   <a name="Kendra-Type-Document-Attributes"></a>
Custom attributes to apply to the document\. Use the custom attributes to provide additional information for searching, to provide facets for refining searches, and to provide additional information in the query response\.  
Type: Array of [DocumentAttribute](API_DocumentAttribute.md) objects  
Required: No

 **Blob**   <a name="Kendra-Type-Document-Blob"></a>
The contents of the document\.   
Documents passed to the `Blob` parameter must be base64 encoded\. Your code might not need to encode the document file bytes if you're using an AWS SDK to call Amazon Kendra operations\. If you are calling the Amazon Kendra endpoint directly using REST, you must base64 encode the contents before sending\.  
Type: Base64\-encoded binary data object  
Required: No

 **ContentType**   <a name="Kendra-Type-Document-ContentType"></a>
The file type of the document in the `Blob` field\.  
Type: String  
Valid Values:` PDF | HTML | MS_WORD | PLAIN_TEXT | PPT`   
Required: No

 **Id**   <a name="Kendra-Type-Document-Id"></a>
A unique identifier of the document in the index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Required: Yes

 **S3Path**   <a name="Kendra-Type-Document-S3Path"></a>
Information required to find a specific file in an Amazon S3 bucket\.  
Type: [S3Path](API_S3Path.md) object  
Required: No

 **Title**   <a name="Kendra-Type-Document-Title"></a>
The title of the document\.  
Type: String  
Required: No

## See Also<a name="API_Document_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/Document) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/Document) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/Document) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/Document) 