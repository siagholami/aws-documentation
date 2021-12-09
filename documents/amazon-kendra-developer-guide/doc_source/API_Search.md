--------

--------

# Search<a name="API_Search"></a>

Provides information about how a custom index field is used during a search\.

## Contents<a name="API_Search_Contents"></a>

 **Displayable**   <a name="Kendra-Type-Search-Displayable"></a>
Determines whether the field is returned in the query response\. The default is `true`\.  
Type: Boolean  
Required: No

 **Facetable**   <a name="Kendra-Type-Search-Facetable"></a>
Indicates that the field can be used to create search facets, a count of results for each value in the field\. The default is `false` \.  
Type: Boolean  
Required: No

 **Searchable**   <a name="Kendra-Type-Search-Searchable"></a>
Determines whether the field is used in the search\. If the `Searchable` field is `true`, you can use relevance tuning to manually tune how Amazon Kendra weights the field in the search\. The default is `true` for string fields and `false` for number and date fields\.  
Type: Boolean  
Required: No

 **Sortable**   <a name="Kendra-Type-Search-Sortable"></a>
Determines whether the field can be used to sort the results of a query\. If you specify sorting on a field that does not have `Sortable` set to `true`, Amazon Kendra returns an exception\. The default is `false`\.  
Type: Boolean  
Required: No

## See Also<a name="API_Search_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/Search) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/Search) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/Search) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/Search) 