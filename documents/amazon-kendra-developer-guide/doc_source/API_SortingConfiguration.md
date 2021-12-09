--------

--------

# SortingConfiguration<a name="API_SortingConfiguration"></a>

Specifies the document attribute to use to sort the response to a Amazon Kendra query\. You can specify a single attribute for sorting\. The attribute must have the `Sortable` flag set to `true`, otherwise Amazon Kendra returns an exception\.

You can sort attributes of the following types\.
+ Date value
+ Long value
+ String value

You can't sort attributes of the following type\.
+ String list value

## Contents<a name="API_SortingConfiguration_Contents"></a>

 **DocumentAttributeKey**   <a name="Kendra-Type-SortingConfiguration-DocumentAttributeKey"></a>
The name of the document attribute used to sort the response\. You can use any field that has the `Sortable` flag set to true\.  
You can also sort by any of the following built\-in attributes:  
+ \_category
+ \_created\_at
+ \_last\_updated\_at
+ \_version
+ \_view\_count
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 200\.  
Pattern: `[a-zA-Z0-9_][a-zA-Z0-9_-]*`   
Required: Yes

 **SortOrder**   <a name="Kendra-Type-SortingConfiguration-SortOrder"></a>
The order that the results should be returned in\. In case of ties, the relevance assigned to the result by Amazon Kendra is used as the tie\-breaker\.  
Type: String  
Valid Values:` DESC | ASC`   
Required: Yes

## See Also<a name="API_SortingConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SortingConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SortingConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SortingConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SortingConfiguration) 