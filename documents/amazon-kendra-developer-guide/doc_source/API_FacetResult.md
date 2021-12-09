--------

--------

# FacetResult<a name="API_FacetResult"></a>

The facet values for the documents in the response\.

## Contents<a name="API_FacetResult_Contents"></a>

 **DocumentAttributeKey**   <a name="Kendra-Type-FacetResult-DocumentAttributeKey"></a>
The key for the facet values\. This is the same as the `DocumentAttributeKey` provided in the query\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `[a-zA-Z0-9_][a-zA-Z0-9_-]*`   
Required: No

 **DocumentAttributeValueCountPairs**   <a name="Kendra-Type-FacetResult-DocumentAttributeValueCountPairs"></a>
An array of key/value pairs, where the key is the value of the attribute and the count is the number of documents that share the key value\.  
Type: Array of [DocumentAttributeValueCountPair](API_DocumentAttributeValueCountPair.md) objects  
Required: No

## See Also<a name="API_FacetResult_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/FacetResult) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/FacetResult) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/FacetResult) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/FacetResult) 