# Searching with the Search Tester<a name="search-tester"></a>

The search tester in the Amazon CloudSearch console enables you to submit sample search requests using any of the supported query parsers: simple, structured, lucene, or dismax\. By default, requests are processed with the simple query parser\. You can specify options for the selected parser, filter and sort the results, and browse the configured facets\. The search hits are automatically highlighted in the search results\. For information about how this is done, see [Highlighting Search Hits in Amazon CloudSearch](highlighting.md)\. You can also select a suggester to get suggestions as you enter terms in the **Search** field\. \(You must configure a suggester before you can get suggestions\. For more information see [Getting Autocomplete Suggestions in Amazon CloudSearch](getting-suggestions.md)\.\)

By default, results are sorted according to an automatically\-generated relevance score, * \_score*\. For information about customizing how results are ranked, see [Sorting Results in Amazon CloudSearch](sorting-results.md)\.

**To search your domain**

1. Go to the Amazon CloudSearch console at [https://console\.aws\.amazon\.com/cloudsearch/home](https://console.aws.amazon.com/cloudsearch/home)\.

1. In the **Navigation** panel, click the name of your movies domain and then click the **Run a Test Search** link\.

1. To perform a simple text search, enter the text you want to search for and click **Go**\. By default, all `text` and `text-array` fields are searched\. 

1. To search particular fields, click the **More Parameters** link and enter a comma\-separated list of the fields you want to search in the **Search Fields** field\. You can append a weight to each field with a caret \(^\) to control the relative importance of each field in the search results\. For example, specifying `title^5, description` weights hits in the `title` field five times more than hits in the `description` field when calculating relevance scores for each matching document\.

1. To use the structured query syntax, select **Structured** from the **Query Parser** menu\. Once you've selected the structured query parser, enter your structured query in the **Search** field and click **Go**\. For example, to find all of the movies with *star* in the title that were released in the year 2000 or earlier, you could enter: `(and title:'star' year:{,2000])`\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\. To submit Lucene or DisMax queries, select the appropriate query parser\.

 You can specify additional options for the selected query parser to configure the default operator and control which operators can be used in a query\. For more information, see [Search Request Parameters](search-api.md#search-request-parameters)\.

To view the HTTP search request that was sent to your domain's search endpoint and the response returned by Amazon CloudSearch, click the **view raw** link for the response format you want to see\.

You can copy and paste the request URL to submit the request and view the response from a Web browser\. Requests can be sent via HTTP or HTTPS\.