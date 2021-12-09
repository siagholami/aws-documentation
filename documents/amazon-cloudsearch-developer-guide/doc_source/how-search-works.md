# How Search Works<a name="how-search-works"></a>

The collection of data that you want to search \(sometimes referred to as your *corpus*\) can consist of unstructured full\-text documents, semi\-structured documents such as those formatted in mark\-up languages like XML, or structured data that conforms to a strict data model\. Each item that you want to be able to search \(such as a forum post or web page\) is represented as a document\. Every document has a unique ID and one or more fields that contain the data that you want to search and include in results\. 

To make your data searchable, you represent it as a batch of documents in either JSON or XML and upload the batch to your search domain\. Amazon CloudSearch then generates a search index from your document data according to your domain's configuration options\. You submit queries against this index to find the documents that meet specific search criteria\. 

As your data changes, you submit updates to add, change, or delete documents from your index\. Updates are applied continuously in the order they are received\.

For information about how to format your data, see [Preparing Your Data](preparing-data.md)\.

## Indexing in Amazon CloudSearch<a name="concepts-indexing"></a>

To build a search index from your data, Amazon CloudSearch needs the following information:
+ Which document fields do you want to search?
+ Which document field values do you want to retrieve with the search results?
+ Which document fields represent categories that you want to use to refine and filter search results?
+ How should the text within a particular field be processed?

You define this metadata in your domain configuration by configuring indexing options\. You use indexing options to specify the fields included in the search index and control how you can use those fields\. 

You must configure a corresponding index field for each document field that occurs in your data—there's a one\-to\-one mapping between document fields and the fields in your Amazon CloudSearch index\. In addition to the index field name, you specify the following:
+ The index field type
+ Whether the field is searchable \(`text` and `text-array` fields are always searchable\)
+ Whether the field can be used as a category \(facet\)
+ Whether the field value can be returned with the search results
+ Whether the field can be used to sort the results
+ Whether highlights can be returned for the field
+ A default value to use if no value is specified in the document data\.

For information about how to configure index fields for Amazon CloudSearch, see [Configuring Index Fields](configuring-index-fields.md)\.

## Facets in Amazon CloudSearch<a name="concepts-facets"></a>

A facet is an index field that represents a category that you want to use to refine and filter search results\. When you submit search requests to Amazon CloudSearch, you can request facet information to find out how many hits share the same value in a facet\. You can display this information along with the search results and use it to enable users to interactively refine their searches\. \(This is often referred to as faceted navigation or faceted search\.\)

A facet can be any date, literal, or numeric field that has faceting enabled in your domain configuration\. For each facet, Amazon CloudSearch calculates the number of hits that share the same value\. You can define buckets to calculate facet counts for particular subsets of the facet values\. Only buckets that have matches are included in the facet results\.

For information about configuring facets, see [Configuring Index Fields](configuring-index-fields.md)\. For information about using facet information to support faceted navigation, see [Getting and Using Facet Information in Amazon CloudSearch](faceting.md)\.

## Text Processing in Amazon CloudSearch<a name="concepts-text-processing"></a>

During indexing, Amazon CloudSearch processes the contents of `text` and `text-array` fields according to the language\-specific analysis scheme configured for the field\. An analysis scheme controls how the text is normalized, tokenized, and stemmed, and specifies any stopwords or synonyms to take into account during indexing\. Amazon CloudSearch provides default analysis schemes for each supported language\. For information about configuring custom analysis schemes, see [Configuring Analysis Schemes](configuring-analysis-schemes.md)\. For information about how Amazon CloudSearch normalizes and tokenizes text and applies configured text options when indexing text fields and processing search requests, see [Text Processing in Amazon CloudSearch](text-processing.md)\.

## Sorting Results in Amazon CloudSearch<a name="concepts-result-ranking"></a>

You can customize how search results are ranked by defining expressions that calculate custom values for every document that matches your search criteria\. For example, you might define an expression that takes into account the value in a document's `popularity` field as well as the default relevance score calculated by Amazon CloudSearch Expressions are simply numeric expressions that use standard numeric operators and functions\. Expressions can reference `int` and `double` fields, other expressions, a document's relevance score \(\_score\), as well as the epoch time \(\_time\)\. When you submit search requests, you specify the expression\(s\) you want to use to sort the search results\. You can also reference expressions within your search criteria\. 

A document's relevance `_score` indicates how relevant a particular search hit is to the search request\. To calculate the relevance score, Amazon CloudSearch takes into account how many times the search terms appear in a document relative to the other documents in the index\.

For information about how to configure expressions for your domain, see [Configuring Expressions](configuring-expressions.md)\.

## Search Requests in Amazon CloudSearch<a name="concepts-searches"></a>

You submit search requests to your domain's search endpoint as HTTP/HTTPS GET requests\. You can specify a variety of options to constrain your search, request facet information, control ranking, and specify what you want to be returned in the results\. You can get search results in either JSON or XML\. By default, Amazon CloudSearch returns results in JSON\.

When you submit a search request, Amazon CloudSearch performs text processing on the search string\. The search string is processed to:
+ Convert all characters to lowercase
+ Split the string into separate terms on whitespace and punctuation boundaries 
+ Remove terms that are on the stopword list for the field being searched\.
+ Map stems and synonyms according to the stemming and synonym options configure for the field being searched\.

After this preprocessing is complete, Amazon CloudSearch looks up the search terms in the index and identifies all of the documents that match the request\. To generate a response, Amazon CloudSearch processes this list of search hits to filter and sort the matching documents and compute facets\. Amazon CloudSearch then returns the response in JSON or XML\. 

By default, Amazon CloudSearch returns search results ranked according to the hits' relevance \_scores\. Alternatively, your request can specify the index field or expression that you want to use to sort the hits\. For example, you might want to sort hits by an index field that contains the price or an expression that calculates popularity\. 

For more information about searching, ranking, and paginating results, see [Searching Your Data with Amazon CloudSearch](searching.md)\. 