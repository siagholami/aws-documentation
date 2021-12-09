# Search API Reference for Amazon CloudSearch<a name="search-api"></a>

**Topics**
+ [Submitting Search Requests in Amazon CloudSearch](#submitting-search-requests-api)
+ [Search](#search-request)
+ [Submitting Suggest Requests in Amazon CloudSearch](#submitting-suggest-requests)
+ [Suggest](#suggest)
+ [Search Service Errors](#search-service-errors)

You use the Search API to submit search or suggestion requests to your Amazon CloudSearch domain\. For more information about searching, see [Searching Your Data with Amazon CloudSearch](searching.md)\. For more information about suggestions, see [Getting Autocomplete Suggestions in Amazon CloudSearch](getting-suggestions.md)\.

The other APIs you use to interact with Amazon CloudSearch are: 
+ [Configuration API](configuration-api.md)—Set up and manage your search domain\.
+ [Document Service API](document-service-api.md)—Submit the data you want to search\.

## Submitting Search Requests in Amazon CloudSearch<a name="submitting-search-requests-api"></a>

We recommend using one of the AWS SDKs or the AWS CLI to submit search requests\. The SDKs and AWS CLI handle request signing for you and provide an easy way to perform all Amazon CloudSearch actions\. You can also use the Search Tester in the Amazon CloudSearch console to search your data, browse the results, and view the generated request URLs and JSON and XML responses\. For more information, see [Searching with the Search Tester](getting-started-search.md#searching-console)\.

**Important**  
Search endpoints don't change: A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request is likely to result in your requests being throttled\.
IP addresses **do** change: Your domain's IP address *can* change over time, so it's important to cache the endpoint as shown in the console and returned by the `aws cloudsearch describe-domains` command rather than the IP address\. You should also re\-resolve the endpoint DNS to an IP address regularly\. For more information, see [Setting the JVM TTL for DNS Name Lookups](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/java-dg-jvm-ttl.html)\.

For example, the following request submits a simple text search for `wolverine` using the AWS CLI and returns just the IDs of the matching documents\.

```
aws cloudsearchdomain --endpoint-url http://search-movies-y6gelr4lv3jeu4rvoelunxsl2e.us-east-1.cloudsearch.amazonaws.com search --search-query wolverine  --return _no_fields
{
    "status": {
        "rid": "/rnE+e4oCAqfEEs=", 
        "time-ms": 6
    }, 
    "hits": {
        "found": 3, 
        "hit": [
            {
                "id": "tt1430132"
            }, 
            {
                "id": "tt0458525"
            }, 
            {
                "id": "tt1877832"
            }
        ], 
        "start": 0
    }
}
```

By default, Amazon CloudSearch returns the response in JSON\. You can get the results formatted in XML by specifying the `format` parameter\. Setting the response format only affects responses to successful requests\. The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\.

**Note**  
The AWS SDKs return fields as arrays\. Single\-value fields are returned as arrays with one element, such as:  

```
"fields": {
  "plot": ["Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol."]
}
```

For development and testing purposes, you can allow anonymous access to your domain's search service and submit unsigned HTTP GET or POST requests directly to your domain's search endpoint\. In a production environment, restrict access to your domain to specific IAM users, groups, or roles and submit signed requests using the AWS SDKs or AWS CLI\. For information about controlling access for Amazon CloudSearch, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\. For more information about request signing, see [Signing AWS API Requests](https://docs.aws.amazon.com/general/latest/gr/signing_aws_api_requests.html)\. 

You can use any method you want to send HTTP requests directly to your domain's search endpoint—you can enter the request URL directly in a Web browser, use cURL to submit the request, or generate an HTTP call using your favorite HTTP library\. To specify your search criteria, you specify a query string that specifies the constraints for your search and what you want to get back in the response\. The query string must be URL\-encoded\. The maximum size of a search request submitted via GET is 8190 bytes, including the HTTP method, URI, and protocol version\. You can submit larger requests using HTTP POST; however, keep in mind that large, complex requests take longer to process and are more likely to time out\. For more information, see [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)\.

For example, the following request submits a structured query to the `search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.amazonaws.com` domain and gets the contents of the `title` field\.

```
http://search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.
amazonaws.com/2013-01-01/search?q=(and+(term+field%3Dtitle+'star')
(term+field%3Dyear+1977))&q.parser=structured&return=title
```

**Important**  
Special characters in the query string must be URL\-encoded\. For example, you must encode the `=` operator in a structured query as `%3D`: `(term+field%3Dtitle+'star')`\. If you don't encode the special characters when you submit the search request, you'll get an `InvalidQueryString` error\.

## Search<a name="search-request"></a>

This section describes the HTTP request and response messages for the search resource\.

### Search Syntax<a name="search-syntax"></a>

```
GET /2013-01-01/search
```

### Search Request Headers<a name="search-request-headers"></a>

HOST  
The search request endpoint for the domain you're querying\. You can use [DescribeDomains](API_DescribeDomains.md) to retrieve your domain's search request endpoint\.   
Required: Yes

### Search Request Parameters<a name="search-request-parameters"></a>

cursor  
Retrieves a cursor value you can use to page through large result sets\. Use the `size` parameter to control the number of hits you want to include in each response\. You can specify either the `cursor` or `start` parameter in a request, they are mutually exclusive\. For more information, see [Paginating Results](paginating-results.md)\.  
To get the first cursor, specify `cursor=initial` in your initial request\. In subsequent requests, specify the cursor value returned in the hits section of the response\.   
For example, the following request sets the cursor value to `initial` and the `size` parameter to 100 to get the first set of hits\. The cursor for the next set of hits is included in the response\.  

```
search?q=john&cursor=initial&size=100&return=_no_fields
{
   "status": {
      "rid": "+/Xu5s0oHwojC6o=",
      "time-ms": 15
   },
   "hits": {
      "found": 503,
      "start": 0,
      "cursor": "VegKzpYYQW9JSVFFRU1UeWwwZERBd09EUTNPRGM9ZA",
      "hit": [
         {"id": "tt0120601"},
         {"id": "tt1801552"},
         ...
      ]
   }
}
```
To get the next set of hits, you specify the cursor value and the number of hits to retrieve\.  

```
search?q=john&cursor=VegKzpYYQW9JSVFFRU1UeWwwZERBd09EUTNPRGM9ZA&size=100
```
Type: String  
Required: No

expr\.NAME  
Defines an expression that can be used to sort results\. You can also specify an expression as a return field\. For more information about defining and using expressions, see [Configuring Expressions](configuring-expressions.md)\.  
You can define and use multiple expressions in a search request\. For example, the following request creates two expressions that are used to sort the results and includes them in the search results:  

```
search?q=(and (term field=genres 'Sci-Fi')(term field=genres 'Comedy'))&q.parser=structured
&expr.expression1=_score*rating
&expr.expression2=(1/rank)*year
&sort=expression1 desc,expression2 desc
&return=title,rating,rank,year,_score,expression1,expression2
```
Type: String  
Required: No

facet\.FIELD   
Specifies a field that you want to get facet information for—`FIELD` is the name of the field\. The specified field must be facet enabled in the domain configuration\. Facet options are specified as a JSON object\. If the JSON object is empty, `facet.FIELD={}`, facet counts are computed for all field values, the facets are sorted by facet count, and the top 10 facets are returned in the results\.   
You can specify three options in the JSON object:  
+ `sort` specifies how you want to sort the facets in the results: `bucket` or `count`\. Specify `bucket` to sort alphabetically or numerically by facet value \(in ascending order\)\. Specify `count` to sort by the facet counts computed for each facet value \(in descending order\)\. To retrieve facet counts for particular values or ranges of values, use the `buckets` option instead of `sort`\. 
+ `buckets` specifies an array of the facet values or ranges you want to count\. Buckets are returned in the order they are specified in the request\. To specify a range of values, use a comma \(,\) to separate the upper and lower bounds and enclose the range using brackets or braces\. A square bracket, \[ or \], indicates that the bound is included in the range, a curly brace, \{ or \}, excludes the bound\. You can omit the upper or lower bound to specify an open\-ended range\. When omitting a bound, you must use a curly brace\. The `sort` and `size` options are not valid if you specify `buckets`\.
+ `size` specifies the maximum number of facets to include in the results\. By default, Amazon CloudSearch returns counts for the top 10\. The `size` parameter is only valid when you specify the `sort` option; it cannot be used in conjunction with `buckets`\.
For example, the following request gets facet counts for the `year` field, sorts the facet counts by value and returns counts for the top three:  

```
facet.year={sort:"bucket", size:3}
```
To specify which values or range of values you want to calculate facet counts for, use the `buckets` option\. For example, the following request calculates and returns the facet counts by decade:  

```
facet.year={buckets:["[1970,1979]","[1980,1989]",
             "[1990,1999]","[2000,2009]",
             "[2010,}"]}
```
 You can also specify individual values as buckets:  

```
facet.genres={buckets:["Action","Adventure","Sci-Fi"]}
```
Note that the facet values are case\-sensitive—with the sample IMDb movie data, if you specify `["action","adventure","sci-fi"]` instead of `["Action","Adventure","Sci-Fi"]`, all facet counts are zero\.   
Type: String  
Required: No

format  
Specifies the content type of the response\.   
Type: String  
Valid Values: json\|xml  
Default: json  
Required: No

fq  
Specifies a structured query that filters the results of a search without affecting how the results are scored and sorted\. You use `fq` in conjunction with the `q` parameter to filter the documents that match the constraints specified in the `q` parameter\. Specifying a filter just controls which matching documents are included in the results, it has no effect on how they are scored and sorted\. The `fq` parameter supports the full structured query syntax\. For more information about using filters, see [Filtering Matching Documents](filtering-results.md)\. For more information about structured queries, see [Structured Search Syntax](#structured-search-syntax)\.   
Type: String  
Required: No

highlight\.FIELD  
Retrieves highlights for matches in the specified `text` or `text-array` field\. Highlight options are specified as a JSON object\. If the JSON object is empty, the returned field text is treated as HTML and the first match is highlighted with emphasis tags: `<em>search-term</em>`\.   
You can specify four options in the JSON object:  
+ `format`—specifies the format of the data in the text field: `text` or `html`\. When data is returned as HTML, all non\-alphanumeric characters are encoded\. The default is `html`\. 
+ `max_phrases`—specifies the maximum number of occurrences of the search term\(s\) you want to highlight\. By default, the first occurrence is highlighted\. 
+ `pre_tag`—specifies the string to prepend to an occurrence of a search term\. The default for HTML highlights is `<em>`\. The default for text highlights is `*`\. 
+ `post_tag`—specifies the string to append to an occurrence of a search term\. The default for HTML highlights is `</em>`\. The default for text highlights is `*`\. 
Examples: `highlight.plot={}`, `highlight.plot={format:'text',max_phrases:2,pre_tag:'<b>',post_tag:'</b>'}`  
Type: String  
Required: No

partial  
Controls whether partial results are returned if one or more index partitions are unavailable\. When your search index is partitioned across multiple search instances, by default Amazon CloudSearch only returns results if every partition can be queried\. This means that the failure of a single search instance can result in 5xx \(internal server\) errors\. When you specify `partial=true`\. Amazon CloudSearch returns whatever results are available and includes the percentage of documents searched in the search results \(`percent-searched`\)\. This enables you to more gracefully degrade your users' search experience\. For example, rather than displaying no results, you could display the partial results and a message indicating that the results might be incomplete due to a temporary system outage\.  
Type: Boolean  
Default: False  
Required: No

pretty  
Formats JSON output so it's easier to read\.   
Type: Boolean  
Default: False  
Required: No

q   
The search criteria for the request\. How you specify the search criteria depends on the query parser used for the request and the parser options specified in the `q.options` parameter\. By default, the `simple` query parser is used to process requests\. To use the `structured`, `lucene`, or `dismax` query parser, you must also specify the `q.parser` parameter\. For more information about specifying search criteria, see [Searching Your Data with Amazon CloudSearch](searching.md)\.  
Type: String  
Required: Yes

q\.options   
Configure options for the query parser specified in the `q.parser` parameter\. The options are specified as a JSON object, for example: `q.options={defaultOperator: 'or', fields: ['title^5','description']}`\.   
The options you can configure vary according to which parser you use:  
+ `defaultOperator`—The default operator used to combine individual terms in the search string\. For example: `defaultOperator: 'or'`\. For the `dismax` parser, you specify a percentage that represents the percentage of terms in the search string \(rounded down\) that must match, rather than a default operator\. A value of `0%` is the equivalent to OR, and a value of `100%` is equivalent to AND\. The percentage must be specified as a value in the range 0\-100 followed by the percent \(%\) symbol\. For example, `defaultOperator: 50%`\. Valid values: `and`, `or`, a percentage in the range 0%\-100% \(`dismax`\)\. Default: `and` \(`simple`, `structured`, `lucene`\) or `100` \(`dismax`\)\. Valid for: `simple`, `structured`, `lucene`, and `dismax`\. 
+ `fields`—An array of the fields to search when no fields are specified in a search\. If no fields are specified in a search and this option is not specified, all statically configured `text` and `text-array` fields are searched\. You can specify a weight for each field to control the relative importance of each field when Amazon CloudSearch calculates relevance scores\. To specify a field weight, append a caret \(`^`\) symbol and the weight to the field name\. For example, to boost the importance of the `title` field over the `description` field you could specify: `fields: ['title^5','description']`\. Valid values: The name of any configured field and an optional numeric value greater than zero\. Default: All statically configured `text` and `text-array` fields\. Dynamic fields and `literal` fields are not searched by default\. Valid for: `simple`, `structured`, `lucene`, and `dismax`\. 
+ `operators`—An array of the operators or special characters you want to disable for the simple query parser\. If you disable the `and`, `or`, or `not` operators, the corresponding operators \(`+`, `|`, `-`\) have no special meaning and are dropped from the search string\. Similarly, disabling `prefix` disables the wildcard operator \(`*`\) and disabling `phrase` disables the ability to search for phrases by enclosing phrases in double quotes\. Disabling precedence disables the ability to control order of precedence using parentheses\. Disabling `near` disables the ability to use the \~ operator to perform a sloppy phrase search\. Disabling the `fuzzy` operator disables the ability to use the \~ operator to perform a fuzzy search\. `escape` disables the ability to use a backslash \(`\`\) to escape special characters within the search string\. Disabling whitespace is an advanced option that prevents the parser from tokenizing on whitespace, which can be useful for Vietnamese\. \(It prevents Vietnamese words from being split incorrectly\.\) For example, you could disable all operators other than the phrase operator to support just simple term and phrase queries: `operators:['and', 'not', 'or', 'prefix']`\. Valid values: `and`, `escape`, `fuzzy`, `near`, `not`, `or`, `phrase`, `precedence`, `prefix`, `whitespace`\. Default: All operators and special characters are enabled\. Valid for: `simple`\. 
+ `phraseFields`—An array of the `text` or `text-array` fields you want to use for phrase searches\. When the terms in the search string appear in close proximity within a field, the field scores higher\. You can specify a weight for each field to boost that score\. The `phraseSlop` option controls how much the matches can deviate from the search string and still be boosted\. To specify a field weight, append a caret \(`^`\) symbol and the weight to the field name\. For example, to boost phrase matches in the `title` field over the `abstract` field, you could specify: `phraseFields:['title^3', 'abstract']` Valid values: The name of any `text` or `text-array` field and an optional numeric value greater than zero\. Default: No fields\. If you don't specify any fields with `phraseFields`, proximity scoring is disabled even if `phraseSlop` is specified\. Valid for: `dismax`\.
+ `phraseSlop`—An integer value that specifies how much matches can deviate from the search phrase and still be boosted according to the weights specified in the `phraseFields` option\. For example, `phraseSlop: 2`\. You must also specify `phraseFields` to enable proximity scoring\. Valid values: positive integers\. Default: 0\. Valid for: `dismax`\.
+ `explicitPhraseSlop`—An integer value that specifies how much a match can deviate from the search phrase when the phrase is enclosed in double quotes in the search string\. \(Phrases that exceed this proximity distance are not considered a match\.\) `explicitPhraseSlop: 5`\. Valid values: positive integers\. Default: 0\. Valid for: `dismax`\.
+ `tieBreaker`—When a term in the search string is found in a document's field, a score is calculated for that field based on how common the word is in that field compared to other documents\. If the term occurs in multiple fields within a document, by default only the highest scoring field contributes to the document's overall score\. You can specify a `tieBreaker` value to enable the matches in lower\-scoring fields to contribute to the document's score\. That way, if two documents have the same max field score for a particular term, the score for the document that has matches in more fields will be higher\. The formula for calculating the score with a tieBreaker is:

  ```
  (max field score) + (tieBreaker) * (sum of the scores for the rest of the matching fields)
  ```

  For example, the following query searches for the term *dog* in the `title`, `description`, and `review` fields and sets `tieBreaker` to 0\.1:

  ```
  q=dog&q.parser=dismax&q.options={fields:['title', 'description', 'review'], tieBreaker: 0.1}
  ```

  If *dog* occurs in all three fields of a document and the scores for each field are title=1, description=3, and review=1, the overall score for the term dog is:

  ```
  3 +  0.1 * (1+1) = 3.2
  ```

   Set `tieBreaker` to 0 to disregard all but the highest scoring field \(pure max\)\. Set to 1 to sum the scores from all fields \(pure sum\)\. Valid values: 0\.0 to 1\.0\. Default: 0\.0\. Valid for: `dismax`\.
Type: JSON object  
Default: See individual option descriptions\.  
Required: No

q\.parser   
Specifies which query parser to use to process the request: `simple`, `structured`, `lucene`, and `dismax`\. If `q.parser` is not specified, Amazon CloudSearch uses the `simple` query parser\.   
+ `simple`—perform simple searches of `text` and `text-array` fields\. By default, the `simple` query parser searches all statically configured `text` and `text-array` fields\. You can specify which fields to search by with the `q.options` parameter\. If you prefix a search term with a plus sign \(\+\) documents must contain the term to be considered a match\. \(This is the default, unless you configure the default operator with the `q.options` parameter\.\) You can use the `-` \(NOT\), `|` \(OR\), and `*` \(wildcard\) operators to exclude particular terms, find results that match any of the specified terms, or search for a prefix\. To search for a phrase rather than individual terms, enclose the phrase in double quotes\. For more information, see [Searching Your Data with Amazon CloudSearch](searching.md)\. 
+ `structured`—perform advanced searches by combining multiple expressions to define the search criteria\. You can also search within particular fields, search for values and ranges of values, and use advanced options such as term boosting, `matchall`, and `near`\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.
+ `lucene`—search using the Apache Lucene query parser syntax\. For more information, see [Apache Lucene Query Parser Syntax](https://cwiki.apache.org/confluence/display/solr/The+Standard+Query+Parser)\.
+ `dismax`—search using the simplified subset of the Apache Lucene query parser syntax defined by the DisMax query parser\. For more information, see [DisMax Query Parser Syntax](https://cwiki.apache.org/confluence/display/solr/The+DisMax+Query+Parser)\.
Type: String  
Default: `simple`  
Required: No

return   
The field and expression values to include in the response, specified as a comma\-separated list\. By default, a search response includes all return enabled fields \(`return=_all_fields`\)\. To return only the document IDs for the matching documents, specify `return=_no_fields`\. To retrieve the relevance score calculated for each document, specify `return=_score`\. You specify multiple return fields as a comma separated list\. For example, `return=title,_score` returns just the title and relevance score of each matching document\.  
Type: String  
Required: No

size   
The maximum number of search hits to return\.   
Type: Positive integer  
Default: 10  
Required: No

sort  
A comma\-separated list of fields or custom expressions to use to sort the search results\. You must specify the sort direction \(`asc` or `desc`\) for each field\. For example, `sort=year desc,title asc`\. You can specify a maximum of 10 fields and expressions\. To use a field to sort results, it must be sort enabled in the domain configuration\. Array type fields cannot be used for sorting\. If no `sort` parameter is specified, results are sorted by their default relevance scores in descending order: `sort=_score desc`\. You can also sort by document ID \(`sort=_id`\) and version \(`sort=_version`\)\.  
Type: String  
Required: No

start   
The offset of the first search hit you want to return\. You can specify either the `start` or `cursor` parameter in a request, they are mutually exclusive\. For more information, see [Paginating Results](paginating-results.md)\.  
Type: Positive integer  
Default: 0 \(the first hit\)  
Required: No

#### Structured Search Syntax<a name="structured-search-syntax"></a>

You use the Amazon CloudSearch structured search syntax to define search criteria when using the `structured` query parser, and to specify filter criteria with the `fq` parameter\. 

When using the structured query operators, you specify the name of the operator, options for the operator, and then the terms being operated on, `(OPERATOR OPTIONS STRING|EXPRESSION)`\. Any options must be specified before the string or expression\. For example, `(and (not field=genres 'Sci-Fi')(or (term field=title boost=2 'star')(term field=plot 'star')))`\. 

**Important**  
You must URL\-encode special characters in the query string\. For example, you must encode the `=` operator in a structured query as `%3D`: `(term+field%3Dtitle+'star'`\)\. Amazon CloudSearch returns an `InvalidQueryString` error if special characters are not URL\-encoded\. For a complete reference of URL\-encodings, see the W3C [HTML URL Encoding Reference](http://www.w3schools.com/tags/ref_urlencode.asp)\.

If you do not specify the field you want to search when using the structured query parser, all statically configured `text` and `text-array` fields are searched\. Dynamic fields and `literal` fields are *not* searched by default\. You can specify which fields you want to search by default with the `q.options` parameter\. 

Parentheses control the order of evaluation of the expressions in a compound query\. When an expression is enclosed in parentheses, that expression is evaluated first, and then the resulting value is used in the evaluation of the remainder of the query\. The expressions can contain any of the structured query operators\. 

You can also use the structured query parser to search for a simple text string—just enclose the string you want to search for in single quotes: `q='black swan'&q.parser="structured"`\.

For more information about constructing compound queries with the structured query operators, see [Constructing Compound Queries](searching-compound-queries.md)\.

FIELD  
Syntax: `FIELD: 'STRING'|value`  
Searches the specified field for a string, numeric value, date, or range of numeric values or dates\.   
Strings must be enclosed in single quotes\. Any single quotation marks or backslashes in the string must be escaped with a backslash\. To specify a range of values, use a comma \(,\) to separate the upper and lower bounds and enclose the range using brackets or braces\. A square bracket, \[ or \], indicates that the bound is included in the range, a curly brace, \{ or \}, excludes the bound\. You can omit the upper or lower bound to specify an open\-ended range\. When omitting a bound, you must use a curly brace\.   
 Dates and times are specified in UTC \(Coordinated Universal Time\) according to [IETF RFC3339](http://tools.ietf.org/html/rfc3339): `yyyy-mm-ddTHH:mm:ss.SSSZ`\. In UTC, for example, 5:00 PM August 23, 1970 is: `1970-08-23T17:00:00Z`\. Note that you can also specify fractional seconds when specifying times in UTC\. For example, `1967-01-31T23:20:50.650Z.`   
Examples:   

```
title:'star'
year:2000
year:[1998,2000]
year:{,2011]
release_date:['2013-01-01T00:00:00Z',}
```

and  
Syntax: `(and boost=N EXPRESSION EXPRESSION ... EXPRESSIONn)`  
Includes a document only if it matches all of the specified expressions\.\(Boolean `AND` operator\.\) The expressions can contain any of the structured query operators, or a simple search string\. Search strings must be enclosed in single quotes\. Note that to match documents that contain the specified terms in any of the fields being searched, you specify each term as a separate expression: `(and 'star' 'wars')`\. If you specify `(and 'star wars')`, *star* and *wars* must occur within the same field to be considered a match\.   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Example:   

```
(and title:'star' actors:'Harrison Ford' year:{,2000])
```

matchall  
Syntax: `matchall`   
Matches every document in the domain\. By default, returns the first 10\. Use the `size` and `start` parameters to page through the results\.

near  
Syntax: `(near field=FIELD distance=N boost=N 'STRING') `  
Searches a `text` or `text-array` field for the specified multi\-term string and matches documents that contain the terms within the specified distance of one another\. \(This is sometimes called a *sloppy* phrase search\.\) If you omit the `field` option, Amazon CloudSearch searches all statically configured `text` and `text-array` fields by default\. Dynamic fields and `literal` fields are not searched by default\. You can specify which fields you want to search by default by specifying the `q.options` `fields` option\.   
The distance value must be a positive integer\. For example, to find all documents where *teenage* occurs within 10 words of *vampire* in the `plot` field, you specify a distance value of 10: `(near field=plot distance=10 'teenage vampire')`\.   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Example:   

```
(near field=plot distance=10 'teenage vampire')
```

not   
Syntax: `(not boost=N EXPRESSION)`  
Excludes a document if it matches the specified expression\. \(Boolean `NOT` operator\.\) The expression can contain any of the structured query operators, or a simple search string\. Search strings must be enclosed in single quotes\.  
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Example:   

```
(not (or actors:'Harrison Ford' year:{,2010]))
```

or   
Syntax: `(or boost=N EXPRESSION1 EXPRESSION2 ... EXPRESSIONn)`  
Includes a document if it matches any of the specified expressions\. \(Boolean `OR` operator\.\) The expressions can contain any of the structured query operators, or a simple search string\. Search strings must be enclosed in single quotes\.  
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Example:   

```
(or actors:'Alec Guinness' actors:'Harrison Ford' actors:'James Earl Jones')
```

phrase   
Syntax: `(phrase field=FIELD boost=N 'STRING')`  
Searches a `text` or `text-array` field for the specified phrase\. If you omit the `field` option, Amazon CloudSearch searches all statically configured `text` and `text-array` fields by default\. Dynamic fields and `literal` fields are not searched by default\. You can specify which fields you want to search by default by specifying the `q.options` `fields` option\.   
Use the `phrase` operator to combine a phrase search with other search criteria in a structured query\. For example `q=(and (term field=title 'star') (range field=year {,2000]))` matches all documents that contain *star* in the title field and have a year value less than or equal to 2000\.   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Example:   

```
(phrase field=plot 'teenage girl')
```

prefix   
Syntax: `(prefix field=FIELD boost=N 'STRING')`  
Searches a `text`, `text-array`, `literal`, or `literal-array` field for the specified prefix followed by zero or more characters\. If you omit the `field` option, Amazon CloudSearch searches all statically configured `text` and `text-array` fields by default\. Dynamic fields and `literal` fields are not searched by default\. You can specify which fields you want to search by default by specifying the `q.options` `fields` option\.   
Use the `prefix` operator to combine a prefix search with other search criteria in a structured query\. For example, `q=(and (prefix field=title 'sta') (range field=year {,2000]))` matches all documents that contain the prefix *sta* in the title field and have a year value of less than or equal to 2000\.   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
To implement search suggestions, you should configure and query a suggester, rather than performing prefix searches\. For more information see [Suggestion Requests](#suggest-request)\.
Example:   

```
(prefix field=title 'star')
```

range  
Syntax: `(range field=FIELD boost=N RANGE)`  
Searches a numeric field \(double, double\-array, int, int\-array\) or date field \(date, date\-array\) for values in the specified range\. Matches documents that have at least one value in the field within the specified range\. The `field` option must be specified\.  
Use the `range` operator to combine a range search with other search criteria in a structured query\. For example `q=(and (term field=title 'star') (range field=year {,2000]))` matches all documents that contain *star* in the title field and have a year value of less than or equal to 2000\.   
 To specify a range of values, use a comma \(,\) to separate the upper and lower bounds and enclose the range using brackets or braces\. A square bracket, \[ or \], indicates that the bound is included in the range, a curly brace, \{ or \}, excludes the bound\. You can omit the upper or lower bound to specify an open\-ended range\. When omitting a bound, you must use a curly brace\.   
 Dates and times are specified in UTC \(Coordinated Universal Time\) according to [IETF RFC3339](http://tools.ietf.org/html/rfc3339): `yyyy-mm-ddTHH:mm:ss.SSSZ`\. In UTC, for example, 5:00 PM August 23, 1970 is: `1970-08-23T17:00:00Z`\. Note that you can also specify fractional seconds when specifying times in UTC\. For example, `1967-01-31T23:20:50.650Z.`   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Examples:   

```
(range field=year [1990,2000])
(range field=year {,2000])
(range field=year [1990,})
```

term  
Syntax: `(term field=FIELD boost=N 'STRING'|VALUE) `  
Searches the specified field for a string, numeric value, or date\. The `field` option must be specified when searching for a value\. If you omit the `field` option, Amazon CloudSearch searches all statically configured `text` and `text-array` fields by default\. Dynamic fields and `literal` fields are not searched by default\. You can specify which fields you want to search by default by specifying the `q.options` `fields` option\.   
Use the `term` operator to combine a term search with other search criteria in a structured query\. For example, `q=(and (term field=title 'star') (range field=year {,2000]))` matches all documents that contain *star* in the title field and have a year value of less than or equal to 2000\.   
Strings and dates must be enclosed in single quotes\. Any single quotation marks or backslashes in a string must be escaped with a backslash\.   
 Dates and times are specified in UTC \(Coordinated Universal Time\) according to [IETF RFC3339](http://tools.ietf.org/html/rfc3339): `yyyy-mm-ddTHH:mm:ss.SSSZ`\. In UTC, for example, 5:00 PM August 23, 1970 is: `1970-08-23T17:00:00Z`\. Note that you can also specify fractional seconds when specifying times in UTC\. For example, `1967-01-31T23:20:50.650Z.`   
 The boost value is a positive numeric value that increases the importance of this part of the search query relative to the other parts\.   
Examples:   

```
(term field=title 'star')
(term field=year 2000)
```

#### Simple Search Syntax<a name="simple-search-syntax"></a>

You use the Amazon CloudSearch simple search syntax to define search criteria when using the `simple` query parser\. The simple query parser is used by default if you do not specify the `q.parser` parameter\. 

You use the simple query parser to search for individual terms or phrases\. By default, all statically configured `text` and `text-array` fields are searched\. Dynamic fields and `literal` fields are *not* searched by default\. You can use the `q.options` parameter to specify which fields you want to search, change the default operator used to combine individual terms in the search string, or disable any of the simple parser operators \(`and`, `escape`, `fuzzy`, `near`, `not`, `or`, `phrase`, `precedence`, `prefix`, `whitespace`\)\.

For more information about using the simple query parser, see [Searching for Text in Amazon CloudSearch](searching-text.md)\.

\+ \(and\)  
Syntax: `+TERM`  
Requires the specified term\. To match, documents must contain the specified term\.  
Example: \+star

\\ \(escape\)  
Syntax: `\CHAR`  
Escapes special characters that you want to search for\. You must escape the following characters if you want them to be part of the query: \+ \- & \| \! \( \) \{ \} \[ \] ^ " \~ \* ? : \\ /\.  
Example: `M\*A\*S\*H`

\~ \(fuzzy\)  
Syntax: `TERM~N`  
Performs a fuzzy search\. Append the \~ operator and a value to a term to indicate how much terms can differ and still be considered a match\.   
Example: `stor~1`

\~ \(near\)  
Syntax: `"PHRASE"~N`  
Performs a sloppy phrase search\. Append the \~ operator and a value to a phrase to indicate how far apart the terms can be and still be considered a match for the phrase\.   
Example: `"star wars"~4`

\- \(not\)  
Syntax: `-TERM`  
Prohibits the specified term\. To match, documents must not contain the term\.   
Example: star \-wars

\| \(or\)  
Syntax: `|TERM`  
Makes the specified term optional\.   
Example: star \|wars

"\.\.\." \(phrase\)  
Syntax: `"PHRASE"`  
Performs a search for the entire phrase\. Can be combined with the `~` operator to perform a sloppy phrase search\.   
Example: "star wars"

\(\.\.\.\) \(precedence\)  
Syntax: `(...)`  
Controls the order in which the query constraints are evaluated\. The contents of the inner\-most parentheses are evaluated first\.   
Example: `+(war|trek)+star`

\* \(prefix\)  
Syntax: `CHARS*`  
Matches documents that contain terms that have the specified prefix\.   
Example: `sta*`

### Search Response<a name="search-response"></a>

When a request completes successfully, the response body contains the search results\. By default, search results are returned in JSON\. If the `format` parameter is set to `xml`, search results are returned in XML\. 

Unless you explicitly specify the `return` parameter, the document ID and all returnable fields are included for each matching document \(hit\)\. The response also shows the total number of hits found \(`found`\) and the index of the first document listed \(`start`\)\. By default, the response contains the first 10 hits\. You specify the `size` parameter in your request to control how many hits are included in each response\. To page through the hits, you can use the `start` or `cursor` parameter\. For more information, see [Paginating Results](paginating-results.md)\.

The following example shows a typical JSON response\.

```
{
    "status": {
        "rid": "rtKz7rkoeAojlvk=",
        "time-ms": 10
    },
    "hits": {
        "found": 3,
        "start": 0,
        "hit": [
            {
                "id": "tt1142977",
                "fields": {
                    "rating": "6.9",
                    "genres": [
                        "Animation",
                        "Comedy",
                        "Family",
                        "Horror",
                        "Sci-Fi"
                    ],
                    "plot": "Young Victor conducts a science experiment to  
                             bring his beloved dog Sparky back to life, only
                              to face unintended, sometimes monstrous, 
                              consequences.",
                    "release_date": "2012-09-20T00:00:00Z",
                    "title": "Frankenweenie",
                    "rank": "1462",
                    "running_time_secs": "5220",
                    "directors": [
                        "Tim Burton"
                    ],
                    "image_url": "http://ia.media-imdb.com/images/M/MV5BMjIx
                                  ODY3MjEwNV5BMl5BanBnXkFtZTcwOTMzNjc4Nw@@._
                                  V1_SX400_.jpg",
                    "year": "2012",
                    "actors": [
                        "Winona Ryder",
                        "Catherine O'Hara",
                        "Martin Short"
                    ]
                }
            },
			.
			.
			.
        ]			
    }
}
```

The following example shows the equivalent XML response\.

```
<results>
    <status rid="itzL7rkoeQojlvk=" time-ms="34"/>
    <hits found="3" start="0">
        <hit id="tt1142977">
            <field name="rating">6.9</field>
            <field name="genres">Animation</field>
            <field name="genres">Comedy</field>
            <field name="genres">Family</field>
            <field name="genres">Horror</field>
            <field name="genres">Sci-Fi</field>
            <field name="plot">Young Victor conducts a science experiment to
                               bring his beloved dog Sparky back to life, only
                               to face unintended, sometimes monstrous, 
                               consequences.
            </field>
            <field name="release_date">2012-09-20T00:00:00Z</field>
            <field name="title">Frankenweenie</field>
            <field name="rank">1462</field>
            <field name="running_time_secs">5220</field>
            <field name="directors">Tim Burton</field>
            <field name="image_url">http://ia.media-imdb.com/images/M/MV5BMjI
                                    xODY3MjEwNV5BMl5BanBnXkFtZTcwOTMzNjc4Nw@@.
                                    _V1_SX400_.jpg
            </field>
            <field name="year">2012</field>
            <field name="actors">Winona Ryder</field>
            <field name="actors">Catherine O'Hara</field>
            <field name="actors">Martin Short</field>
        </hit>
        .
        .
        .
    </hits>
</results>
```

 Setting the response format only affects responses to successful requests\. The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\. When a request returns an error code, the body of the response contains information about the error that occurred\. If an error occurs while the request body is parsed and validated, the error code is set to 400 and the response body includes a list of the errors and where they occurred\. 

#### Search Response Headers<a name="search-response-headers"></a>

Content\-Type  
A standard MIME type describing the format of the object data\. For more information, see [W3C RFC 2616 Section 14](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17)\.  
Valid values: application/json or application/xml   
Default: application/json 

Content\-Length  
The length in bytes of the body in the response\.

#### Search Response Properties \(JSON\)<a name="search-response-elements-json"></a>

status  
Contains the resource id \(rid\) and the time it took to process the request \(time\-ms\)\.    
rid  
The encrypted Resource ID\.  
time\-ms  
How long it took to process the search request in milliseconds\.

hits  
Contains the number of matching documents \(`found`\), the index of the first document included in the response \(`start`\), and an array \(`hit`\) that lists the document IDs and data for each hit\.     
found  
The total number of hits that match the search request after Amazon CloudSearch finished processing the request\.   
start  
The index of the first hit returned in this response\.   
hit  
An array that lists the document IDs and data for each hit\.     
id  
The unique identifier for a document\.   
fields  
A list of returned fields\.   
facets  
Contains facet information and facet counts\.   
FACETFIELD  
A field for which facets were calculated\.   
buckets  
An array of the calculated facet values and counts\.  
value  
The facet value being counted\.  
count  
The number of hits that contain the facet value in `FACETFIELD`\. 

#### Search Response Elements \(XML\)<a name="search-response-elements-xml"></a>

results  
Contains the search results\. Any errors that occurred while processing the request are returned as messages in the info element\.    
status  
Contains the resource id \(`rid`\) and the time it took to process the request \(`time-ms`\)\.  
hits  
Contains hit statistics and a collection of hit elements\. The found attribute is the total number of hits that match the search request after Amazon CloudSearch finished processing the results\. The contained hit elements are ordered according to their relevance scores or the `sort` option specified in the search request\.     
hit  
A document that matched the search request\. The id attribute is the document's unique id\. Contains a `d` \(data\) element for each returned field\.    
field  
A field returned from a hit\. Hit elements contain a `d` \(data\) element for each returned field\.   
facets  
Contains a facet element for each facet requested in the search request\.    
facet  
Contains a bucket element for each value of a field for which a facet count was calculated\. The `facet.FIELD` size option can be used to specify how many constraints to return\. By default, facet counts are returned for the top 10 constraints\. The `facet.FIELD` buckets option can be used to explicitly specify which values to count\.     
bucket  
A facet field value and the number of occurrences \(count\) of that value within the search hits\.

## Submitting Suggest Requests in Amazon CloudSearch<a name="submitting-suggest-requests"></a>

You submit suggest requests via HTTP GET to your domain's search endpoint at `2013-01-01/suggest`\. For information about controlling access to the suggest service, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\.

You must specify the API version in all suggest requests and that version must match the API version specified when the domain was created\.

For example, the following request gets suggestions from the `search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.amazonaws.com` domain for the query string `oce` using the suggester called `title`\. 

```
http://search-imdb-hd6ebyouhw2lczkueyuqksnuzu.us-west-2.cloudsearch.amazonaws.com/2013-01-01/suggest -d"q=oce&suggester=suggest_title"
```

You can use any method you want to send GET requests to your domain's search endpoint—you can enter the request URL directly in a Web browser, use cURL to submit the request, or generate an HTTP call using your favorite HTTP library\. You can also use the Search Tester in the Amazon CloudSearch console to get suggestions\. For more information, see [Searching with the Search Tester](getting-started-search.md#searching-console)\.

**Important**  
A domain's document and search endpoints remain the same for the life of the domain\. You should cache the endpoints rather than retrieving them before every upload or search request\. Querying the Amazon CloudSearch configuration service by calling `aws cloudsearch describe-domains` or `DescribeDomains` before every request is likely to result in your requests being throttled\. 

By default, Amazon CloudSearch returns the response in JSON\. You can get the results formatted in XML by specifying the `format` parameter, `format=xml`\. Setting the response format only affects responses to successful requests\. The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\.

## Suggest<a name="suggest"></a>

### Suggestion Requests<a name="suggest-request"></a>

#### Suggest Syntax in Amazon CloudSearch<a name="suggest-syntax"></a>

```
GET /2013-01-01/suggest
```

#### Suggest Request Headers in Amazon CloudSearch<a name="suggest-request-headers"></a>

HOST  
The search request endpoint for the domain you're querying\. You can use [DescribeDomains](API_DescribeDomains.md) to retrieve your domain's search request endpoint\.   
Required: Yes

#### Suggest Request Parameters in Amazon CloudSearch<a name="suggest-request-parameters"></a>

q  
The string to get suggestions for\.  
Type: String  
Required: Yes

suggester  
The name of the suggester to use to find suggested matches\.  
Type: String  
Required: Yes

size   
The maximum number of suggestions to return\.   
Type: Positive integer  
Default: 10  
Required: No

format  
Specifies the content type of the response\.   
Type: String  
Valid Values: json\|xml  
Default: json  
Required: No

### Suggest Response<a name="suggest-response"></a>

When a request completes successfully, the response body contains the suggestions\. By default, suggestions are returned in JSON\. Set the `format` parameter to `xml` to get the results in XML\.

 Setting the response format only affects responses to successful requests\. The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\. When a request returns an error code, the body of the response contains information about the error that occurred\. If an error occurs while the request body is parsed and validated, the error code is set to 400 and the response body includes a list of the errors and where they occurred\. 

The following example shows a JSON response to a request for suggestions:

```
{
   "status": {
      "rid": "qOSM5s0oCwr8pVk=",
      "time-ms": 2
   },
   "suggest": {
      "query": "oce",
      "found": 3,
      "suggestions": [
         {
          "suggestion": "Ocean's Eleven",
           "score": 0,
           "id": "tt0054135"
         },
         {
          "suggestion": "Ocean's Thirteen",
          "score": 0,
          "id": "tt0496806"
         },
         {
          "suggestion": "Ocean's Twelve",
          "score": 0,
          "id": "tt0349903"
         }
      ]
   }
}
```

The following example shows the equivalent XML response:

```
<results>
   <status rid="/pSz580oDQr8pVk=" time-ms="2"/>
   <suggest query="oce" found="3">
      <suggestions>
         <item suggestion="Ocean's Eleven" score="0" id="tt0054135"/>
         <item suggestion="Ocean's Thirteen" score="0" id="tt0496806"/>
         <item suggestion="Ocean's Twelve" score="0" id="tt0349903"/>
      </suggestions>
   </suggest>
</results>
```

## Search Service Errors<a name="search-service-errors"></a>

A search or suggestion request can return three types of status codes:
+ 5xx status codes indicate that there was an internal server error\. You should catch and retry all 5xx error codes as they typically represent transient error conditions\. For more information, see [Handling Errors](error-handling.md)\. 
+ 4xx status codes indicate that the request was malformed\. Correct the error\(s\) before resubmitting your request\.
+ 2xx status codes indicate that the request was processed successfully\.

The format of an error response depends on the origin of the error\. Errors returned by the search service are always returned in JSON\. 5xx errors due to server timeouts and other request routing problems are returned in XML\. 

Errors returned by the search service contain the following information:

error  
Contains an error message returned by the search service\. The `code` and `msg` properties are included for each error\.

code  
The error code\.

msg  
A description of the error that was returned by the search service\.