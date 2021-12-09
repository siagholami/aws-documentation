# Filtering Matching Documents in Amazon CloudSearch<a name="filtering-results"></a>

You use the `fq` parameter to filter the documents that match the search criteria specified with the `q` parameter without affecting the relevance scores of the documents included in the search results\. Specifying a filter just controls which matching documents are included in the results, it has no effect on how they are scored and sorted\. 

The `fq` parameter supports the structured query syntax described in [Search API Reference](search-api.md)\.

For example, you could add an `available` field to your documents to indicate whether or not an item is in stock, and filter on that field to limit the results to in\-stock items: 

```
search?q=star+wars&fq=available:'true'&return=title
```