# Step 3: Search Your Amazon CloudSearch Domain<a name="getting-started-search"></a>

You can use the search tester in the Amazon CloudSearch console to submit sample search requests and view the results\. You can also submit sample search requests through a Web browser or using cURL\. In your application, you can use any HTTP library to send search traffic to your Amazon CloudSearch domain\.

## Searching with the Search Tester<a name="searching-console"></a>

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

## Submitting Search Requests from a Web Browser<a name="searching-browser"></a>

You can submit search requests directly to your search endpoint from any Web browser\. You can use any of the query parsers \(simple, structured, lucene, or dismax\) and specify a variety of options to constrain your search, request facet information, customize ranking, and control what information is returned in the results\. 

For example, to search your movies domain and get the titles of all of the available *Star Wars* movies, append the following search string to your search endpoint\. \(2013\-01\-01 is the API version and must be specified\.\)

**Example**  

```
/2013-01-01/search?q=star+wars&return=title
```

**Note**  
Your domain's search endpoint is shown on the domain dashboard\. You can also perform a search from the AWS Management Console, view the raw request and response, and copy the request URL from the Search Request field\. A domain's search and document service endpoints remain the same for the life of the domain\.

By default, Amazon CloudSearch returns the response in JSON\. You can also get the search results formatted in XML by specifying the `format` parameter, `format=xml`\. \(Note that errors can be returned in either JSON or XML, depending on where the error originated\.\) 

## Searching Numeric Fields<a name="getting-started-searching-numeric-fields"></a>

 You can use the structured query syntax, `q.parser=structured`, to find documents that have particular numeric attributes\. You can search for an exact value or a range of values within any numeric field \(`double`, `double-array`, `int`, `int-array`\)\. To search for a range, you specify the upper and lower bounds, separated by a comma, and enclose the range in brackets or braces\. Use square brackets \(\[,\]\) when you want to include the bounds, and curly braces \(\{,\}\) to exclude the bounds\. For example: 
+ `year:2000` matches documents whose year field contains the value 2000\.
+ `year:[2000,}` matches documents whose year field contains a value greater than or equal to 2000
+ `year:{,2000]` matches documents whose year field contains a value less than or equal to 2000
+ `year:[2000,2011]` matches documents whose year field contains a value between 2000 and 2011, inclusive\.
+ `year:{2000,2011}` matches documents whose year field contains a value between 2000 and 2011, exclusive\.

 You can also search date fields for a specific date or date range, but you must enclose each date string in single quotes: `release_date:['2000-01-01T00:00:00Z','2011-01-01T00:00:00Z']`\.

For example, the following structured query searches for "star" in the title field, finds all of the matching movies that were released before 2000, and returns the title, year, and relevance score for each one: 

**Example**  

```
q=(and title:'star' year:{,2000])&q.parser=structured&return=title,year,_score
```

The response shows the status of the request, the number of matching documents, and the requested fields for each hit\.

```
{
    "status": {
        "rid": "hLPckLsoEQoELQo=",
        "time-ms": 2
    },
    "hits": {
        "found": 15,
        "start": 0,
        "hit": [
            {
                "id": "tt0076759",
                "fields": {
                    "title": "Star Wars",
                    "year": "1977",
                    "_score": "5.7601414"
                }
            },
            .
            .
            .
            {
                "id": "tt0088170",
                "fields": {
                    "title": "Star Trek III: The Search for Spock",
                    "year": "1984",
                    "_score": "4.2371693"
                }
            }
        ]
    }
}
```

For more information about constructing search queries, see [Searching Your Data with Amazon CloudSearch](searching.md)\.

## Sorting the Search Results<a name="ranking-results"></a>

By default, Amazon CloudSearch sorts the search results according to an automatically generated relevance `_score`\. You can change how results are ranked by using the *sort* parameter in your search request to specify the field or expression you want to use for ranking\. \(An expression is a custom numeric expression that can be evaluated for each document in the set of matching documents\. For information about defining your own expressions, see [Configuring Expressions](configuring-expressions.md)\.\)

If you specify a text field with the `sort` parameter, the results are sorted alphabetically according to that field\. For example, to sort results from your movies domain alphabetically by title, add `&sort=title asc` to your query string:

**Example**  

```
2013-01-01/search?q=(and genres:'Sci-Fi' year:{,2000])&q.parser=structured&return=title,year&sort=title asc
```

Note that you must explicitly specify the sort direction, `asc` \(ascending\) or `desc` \(descending\)\. When you sort alphabetically, Amazon CloudSearch sorts by Unicode codepoint\. This means numbers come before letters and uppercase letters come before lowercase letters\. Numbers are sorted as strings; for example, 10 will come before 2\.

Similarly, you can specify an integer field with the `sort` parameter to sort the results numerically\. 

 If you specify a comma separated list of fields or expressions, the first field or expression is used as the primary sort criteria, the second is used as the secondary sort criteria, and so on\.

For more information about ranking results, see [Sorting Results in Amazon CloudSearch](sorting-results.md)

## Getting Facet Information<a name="w3aab7c21c12"></a>

A facet is an index field that represents a category that you want to use to refine and filter search results\. When you submit search requests to Amazon CloudSearch, you can request facet information to find out how many hits share the same value in a facet\. You can display this information along with the search results and use it to enable users to interactively refine their searches\. \(This is often referred to as faceted navigation or faceted search\.\)

A facet can be any date, literal, or numeric field that has faceting enabled in your domain configuration\. For each facet, Amazon CloudSearch calculates the number of hits that share the same value\. You can define buckets to calculate facet counts for particular subsets of the facet values\. Only buckets that have matches are included in the facet results\.

**To get facet counts with your search results**
+ Use the `facet.FIELD` option to specify a field for which you want to compute facets\. For the sample IMDb movies data faceting is enabled for the following fields: `genres`, `rank`, `rating`, `release_date`, `running_time_secs`, and `year`\. Facet options are specified as a JSON object\. If the JSON object is empty, `facet.FIELD={}`, facet counts are computed for all field values, the facets are sorted by facet count, and the top 10 facets are returned in the results:

  ```
  q=star&return=title&facet.genres={}
  ```

The facets appear below the hits in the results\. 

```
facets": {

    "genres": {
        "buckets": [
            {"value": "Comedy","count": 41},
            .
            .
            .
            {"value": "Sport", "count": 7}
        ]
    }
}
```

You can specify options to calculate facets for selected field values, specify the maximum number of facet values to include in the results, and control how the facets are sorted\. 

To define buckets to compute facet counts for selected field values, you specify the `buckets` option\. For example, the following request sorts the facet counts for the year field by decade:

```
q=star&facet.year={buckets:["[1970,1979]","[1980,1989]","[1990,1999]"]}
```

This constrains the facet counts to the three specified ranges: 

```
"facets": {
        "year": {
            "buckets": [
                {"value": "[1970,1979]", "count": 3},
                {"value": "[1980,1989]","count": 7},
                {"value": "[1990,1999]","count": 12}
            ]
        }
}
```

For more information about specifying facet options, see [Getting and Using Facet Information in Amazon CloudSearch](faceting.md)\.

## Getting Search Highlights<a name="getting-highlights"></a>

A search highlight is an excerpt of a text or text\-array field that shows where the search term occurs within the field\. 

**To get highlight information with your search results**
+ Use the `highlight.FIELD` option to specify the text or text\-array field you want to get highlights for\. The field must be highlight enabled in your domain's indexing options\. For the sample IMDb movies data highlighting is enabled for the following fields: `actors`, `directors`, `plot`, and `title`\. Highlight options are specified as a JSON object\. If the JSON object is empty, `highlight.FIELD={}`, Amazon CloudSearch highlights all occurrences of the search term\(s\) by enclosing them in HTML emphasis tags, `<em>term</em>`, and the excerpts are returned as HTML\.

  ```
  q=title:'star'&q.parser=structured&return=_no_fields&highlight.title={}
  ```

The highlight information is included with each search hit\. 

```
hits": {
    "found": 29,
    "start": 0,
    "hit": [
        {
            "id": "tt0796366",
            "highlights": {
                "title": "<em>Star</em> Trek"
            }
        },
        .
        .
        .
        {
            "id": "tt2488496",
            "highlights": {
                "title": "<em>Star</em> Wars: Episode VII"
            }
        }
    ]
}
```

For more information about specifying highlight options, see [Highlighting Search Hits in Amazon CloudSearch](highlighting.md)\.