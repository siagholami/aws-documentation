--------

--------

# DocumentMetadataConfiguration<a name="API_DocumentMetadataConfiguration"></a>

Specifies the properties of a custom index field\.

## Contents<a name="API_DocumentMetadataConfiguration_Contents"></a>

 **Name**   <a name="Kendra-Type-DocumentMetadataConfiguration-Name"></a>
The name of the index field\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 30\.  
Required: Yes

 **Relevance**   <a name="Kendra-Type-DocumentMetadataConfiguration-Relevance"></a>
Provides manual tuning parameters to determine how the field affects the search results\.  
Type: [Relevance](API_Relevance.md) object  
Required: No

 **Search**   <a name="Kendra-Type-DocumentMetadataConfiguration-Search"></a>
Provides information about how the field is used during a search\.  
Type: [Search](API_Search.md) object  
Required: No

 **Type**   <a name="Kendra-Type-DocumentMetadataConfiguration-Type"></a>
The data type of the index field\.   
Type: String  
Valid Values:` STRING_VALUE | STRING_LIST_VALUE | LONG_VALUE | DATE_VALUE`   
Required: Yes

## See Also<a name="API_DocumentMetadataConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DocumentMetadataConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DocumentMetadataConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DocumentMetadataConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DocumentMetadataConfiguration) 