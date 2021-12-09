# Searching Your Data with Amazon CloudSearch<a name="searching"></a>

You specify the terms or values you want to search for with the `q` parameter\. How you specify the search criteria depends on which query parser you use\. Amazon CloudSearch supports four query parsers:
+ `simple`—search all `text` and `text-array` fields for the specified string\. The simple query parser enables you to search for phrases, individual terms, and prefixes\. You can designate terms as required or optional, or exclude matches that contain particular terms\. To search particular fields, you can specify the fields you want to search with the `q.options` parameter\. The `simple` query parser is used by default if the `q.parser` parameter is not specified\. 
+ `structured`—search specific fields, construct compound queries using Boolean operators, and use advanced features such as term boosting and proximity searching\. 
+ `lucene`—specify search criteria using the Apache Lucene query parser syntax\. If you currently use the Lucene syntax, using the `lucene` query parser enables you to migrate your search services to an Amazon CloudSearch domain without having to completely rewrite your search queries in the Amazon CloudSearch structured search syntax\. 
+ `dismax`—specify search criteria using the simplified subset of the Apache Lucene query parser syntax defined by the DisMax query parser\. If you are currently using the DisMax syntax, using the `dismax` query parser enables you to migrate your search services to an Amazon CloudSearch domain without having to completely rewrite your search queries in the Amazon CloudSearch structured search syntax\. 

You can use additional search parameters to [control how search results are returned](controlling-search-results.md) and [include additional information](querying-for-more-info.md) such as facets, highlights, and suggestions with your search results\. 

For information about all of the Amazon CloudSearch search parameters, see the [Search API Reference](search-api.md)\.

**Topics**
+ [Submitting Search Requests to an Amazon CloudSearch Domain](submitting-search-requests.md)
+ [Constructing Compound Queries in Amazon CloudSearch](searching-compound-queries.md)
+ [text](searching-text.md)
+ [Searching for Numbers in Amazon CloudSearch](searching-numbers.md)
+ [Searching for Dates and Times in Amazon CloudSearch](searching-dates.md)
+ [Searching for a Range of Values in Amazon CloudSearch](searching-ranges.md)
+ [location-based searching and sorting](searching-locations.md)
+ [Searching DynamoDB Data with Amazon CloudSearch](searching-dynamodb-data.md)
+ [Filtering Matching Documents in Amazon CloudSearch](filtering-results.md)
+ [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)