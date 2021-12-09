# Migrating to the Amazon CloudSearch 2013\-01\-01 API<a name="migrating"></a>

The Amazon CloudSearch 2013\-01\-01 API offers several new features, including support for multiple languages, highlighting search terms in the results, and getting suggestions\. To use these features, you create and configure a new 2013\-01\-01 search domain, modify your data pipeline to populate the new domain using the 2013\-01\-01 data format, and update your query pipeline to submit requests in the 2013\-01\-01 request format\. This migration guide summarizes the API changes and highlights the ones that are most likely to affect your application\. 

## Creating 2013\-01\-01 Amazon CloudSearch Domains<a name="creating-2013-domains"></a>

 If you created Amazon CloudSearch domains prior to the launch of the 2013\-01\-01 API, you can choose which API version to use when you create a new domain\. To create a 2013\-01\-01 domain through the console, select the 2013\-01\-01 version in the Create Domain Wizard\. To create a 2013\-01\-01 domain from the command line, download and install the AWS CLI and run the `aws cloudsearch create-domain` command\. 

**Note**  
To create and interact with 2013\-01\-01 domains, you must use the AWS CLI tools\. To create and interact with 2011\-02\-01 domains, you must use the v1 tools\.

**Topics**

## Configuring 2013\-01\-01 Amazon CloudSearch Domains<a name="configuring-2013-domains"></a>

 You can configure 2013\-01\-01 domains through the console, command line tools, or AWS SDKs\. 2013\-01\-01 domains support several new configuration options:
+ **Analysis Schemes**—you configure analysis schemes to specify language\-specific text processing options for `text` and `text-array` fields\. Amazon CloudSearch now supports 33 languages, as well as an option for multi\-language fields\. For more information, see [Configuring Analysis Schemes](configuring-analysis-schemes.md)\. For the complete list of supported languages, see [Supported Languages](supported-languages.md)\.
+ **Availability Options**—you can enable the Multi\-AZ option to expand a domain into a second availability zone to ensure availability in the event of a service disruption\. For more information, see [Configuring Availability Options](configuring-availability-options.md)\.
+ **Scaling Options**—you can set the desired instance type and desired replication count to increase upload or search capacity, speed up search requests, and improve fault tolerance\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.
+ **Suggesters**—you can configure suggesters to implement autocomplete functionality\. For more information, see [Configuring Suggesters for Amazon CloudSearch](getting-suggestions.md#configuring-suggesters)\.

Access to the Amazon CloudSearch configuration service is managed through IAM and now enables you to control access to specific configuration actions\. Note that the Amazon CloudSearch ARN has also changed\. Access to your domain's document and search endpoints is managed through the Amazon CloudSearch configuration service\. For more information, see [Configuring Access for Amazon CloudSearch](configuring-access.md)\.

2013\-01\-01 domains also support an expanded set of indexing options:
+ **Analysis Scheme**—you configure language\-specific text\-processing on a per field basis by specifying an analysis scheme for each `text` and `text-array` field\. For more information, see [Configuring Analysis Schemes](configuring-analysis-schemes.md)\.
+ **Field Types**—Amazon CloudSearch now supports 11 field types: 
  + date—contains a timestamp\. Dates and times are specified in UTC \(Coordinated Universal Time\) according to IETF RFC3339: yyyy\-mm\-ddT00:00:00Z\. In UTC, for example, 5:00 PM August 23, 1970 is: 1970\-08\-23T17:00:00Z\.
  + date\-array—a date field that can contain multiple values\.
  + double—contains a double\-precision 64\-bit floating point value\.
  + double\-array—a double field that can contain multiple values\.
  + int—contains a 64\-bit signed integer value\.
  + int\-array—an integer field that can contain multiple values\.
  + latlon—contains a location stored as a latitude and longitude value pair\.
  + literal—contains an identifier or other data that you want to be able to match exactly\.
  + literal\-array—a literal field that can contain multiple values\.
  + text—contains arbitrary alphanumeric data\.
  + text\-array—a text field that can contain multiple values\.
+ **Highlight**—when you enable the highlight option for a field, you can retrieve excerpts that show where the search terms occur within that field\. For more information, see [Highlighting Search Hits in Amazon CloudSearch](highlighting.md)\.
+ **Source**—you can specify a source for a field to copy data from one field to another, enabling you to use the same source data in different ways by configuring different options for the fields\. 

When configuring your 2013\-01\-01 domain, there are several things to keep in mind: 
+ By default, when you add a field, all options valid for that field type are enabled\. While this is useful for development and testing, disabling options you don't need can reduce the size of your index and improve performance\. 
+ You must use the separate array type fields for multi\-valued fields\.
+ Only single\-value fields can be sort enabled\.
+ Only `text` and `text-array` fields can be highlight enabled\.
+ All fields *except* `text` and `text-array` fields can be facet enabled\.
+ Literal fields are now case\-sensitive\.
+ You no longer have to store floating point values as integers—use a `double` field\.
+ You can store locations using the new `latlon` field type\. For more information, see [Searching and Ranking Results by Geographic Location in Amazon CloudSearch](searching-locations.md)\. 
+ An `int` field is a 64\-bit signed integer\.
+ Instead of configuring a default search field, you can specify which fields to search with the `q.options` parameter in your search requests\. The `q.options` parameter also enables you to specify weights for each of the fields\.
+ When sorting and configuring expressions, you reference the default relevance score with the name `_score`\. Due to changes in the relevance algorithm, the calculated scores will be different than they were under the 2011\-02\-01 API\. For more information, see [Configuring Expressions](configuring-expressions.md)\. 
+ Expressions now support the `logn`, `atan2`, and `haversin` functions as well as the `_score` \(text relevance score\) and `_time` \(epoch time\) variables\. If you store locations in `latlon` fields, you can reference the latitude and longitude values as `FIELD.latitude` and `FIELD.longitude`\. You can also reference both `int` and `double` fields in expressions\. The following functions are no longer supported: `cs.text_relevance`, `erf`, `lgamma`, `rand`, and `time`\. For more information, see [Configuring Expressions](configuring-expressions.md)\.

For more information about configuring indexing options for a 2013\-01\-01 domain, see [Configuring Index Fields](configuring-index-fields.md)\. For more information about configuring availability options, scaling options, text processing options, suggesters, and expressions see [Creating and Managing Search Domains](creating-managing-domains.md)\.

### New Amazon CloudSearch Configuration Service Actions and Options<a name="new-configuration-api"></a>

The following actions have been added to the 2013\-01\-01 Configuration Service API:
+ DefineAnalysisScheme
+ DefineExpression
+ DefineSuggester
+ DeleteAnalysisScheme
+ DeleteExpression
+ DeleteSuggester
+ DexcribeAnalysisSchemes
+ DescribeAvailabilityOptions
+ DescribeExpressions
+ DescribeScalingParameters
+ DescribeSuggesters
+ ListDomainNames
+ UpdateAvailabilityOptions
+ UpdateScalingParameters

The `deployed` option has been added to the describe actions for index fields, access policies, and suggesters\. Set the `deployed` option to true to show the active configuration and exclude pending changes\. 

### Obsolete Amazon CloudSearch Configuration Service Actions and Options<a name="obsolete-configuration-api"></a>

The following actions are not supported in the 2013\-01\-01 Configuration Service API:
+ DefineRankExpression
+ DescribeRankExpression
+ DeleteRankExpression
+ DescribeDefaultSearchField
+ DescribeStemmingOptions
+ DescribeStopwordOptions
+ DescribeSynonymOptions
+ UpdateDefaultSearchField
+ UpdateStemmingOptions
+ UpdateStopwordOptions
+ UpdateSynonymOptions

## Uploading Data to 2013\-01\-01 Amazon CloudSearch Domains<a name="uploading-data-2013"></a>

 With the 2013\-01\-01 API, you no longer have to specify document versions—updates are applied in the order they are received\. You also no longer specify the `lang` attribute for each document—you control language\-specific text processing by configuring an analysis scheme for each `text` and `text-array` field\.

 To upload your data to a 2013\-01\-01 domain, you need to:
+ Omit the `version` and `lang` attributes from your document batches\.
+ Make sure all of the document fields correspond to index fields configured for your domain\. Unrecognized fields are no longer ignored, they will generate an error\.
+ Post the document batches to your 2013\-01\-01 domain's doc endpoint\. Note that you must specify the 2013\-01\-01 API version\. For example, the following request posts the batch contained in `data1.json` to the `doc-movies-123456789012.us-east-1.cloudsearch.amazonaws.com` endpoint\.

  ```
  curl -X POST --upload-file data1.json doc-movies-123456789012.us-east-1.
  cloudsearch.amazonaws.com/2013-01-01/documents/batch --header "Content-Type:
  application/json"
  ```

The 2013\-01\-01 API supports prescaling your domain to increase upload capacity\. If you have a large amount of data to upload, configure your domain's scaling options and select a larger desired instance type\. Moving to a larger instance type enables you to upload batches in parallel and reduces the time it takes for the data to be indexed\. For more information, see [Configuring Scaling Options in Amazon CloudSearch](configuring-scaling-options.md)\.

For more information about formatting your data, see [Preparing Your Data](preparing-data.md)\.

## Searching 2013\-01\-01 Amazon CloudSearch Domains<a name="searching-2013-domains"></a>

Much of the effort required to migrate an existing Amazon CloudSearch search domain to the 2013\-01\-01 API is updating your query pipeline to submit 2013\-01\-01 compatible search requests\. 
+ Use the 2013\-01\-01 API version in all requests\.
+ Use the `q` parameter to specify search criteria for all requests\. The `bq` parameter is no longer supported\. To use the structured \(Boolean\) search syntax, specify `q.parser=structured` in the request\.
+ Parameters cannot be repeated in a search request\.
+ The wildcard character \(\*\) is only supported when using the simple query parser\. Use the `prefix` operator to perform prefix matching with the structured query parser\. For example, `q=(prefix 'oce')&q.parser=structured`\.
+ Use the field name `_id` to reference the document ID field in a search request\. The `docid` field name is no longer supported\.
+ Use the `range` operator search a field for a value within the specified range\. The `filter` operator is no longer supported\.
+ Use the new range syntax to search for ranges of values, including dates and locations stored in `latlon` fields\. The double dot \(\.\.\) notation is no longer supported\. Separate the upper and lower bounds with a comma \(,\), and enclose the range in brackets or braces\. A square bracket \(\[,\]\) indicates that the bound is included, a curly brace \(\{,\}\) excludes the bound\. For example, `year:2008..2011` is now expressed as `year:[2008,2011]`\. An open ended range such as `year:..2011` is now expressed as `year:{,2011]`\.
+ Use the `term` operator to search a field for a particular value\. The `field` operator is no longer supported\. 
+ Use the `q.options` parameter to specify field weights\. The `cs.text_relevance` function is no longer supported\. For example, `q.options={fields:['title^2','plot^0.5']}`\.
+ Use the `fq` parameter to filter results without affecting how the matching documents are scored and sorted\.
+ Use a dot \(\.\) as a separator rather than a hyphen \(\-\) in the prefix parameters: `expr.NAME`, `facet.FIELD`, `highlight.FIELD`\.
+ Use the `facet.FIELD` parameter to specify all facet options\. The `facet-FIELD-top-N`, `facet-FIELD-sort`, and `facet-FIELD-constraints` parameters are no longer supported\. 
+ Use the `sort` parameter to specify the fields or expressions you want to use for sorting\. You must explicitly specify the sort direction in the sort parameter\. For example, `sort=rank asc, date desc`\. The `rank` parameter is no longer supported\.
+ Use `expr.NAME` to define an expression in a search request\. The `rank-RANKNAME` parameter is no longer supported\.
+ Use `format=xml` to get results as XML\. The `result-type` parameter is no longer supported\.

The 2013\-01\-01 search API also supports several new features:
+ Term boosting—use the `boost` option in a structured query to increase the importance of one part of the query relative to the other parts\. For more information, see [Constructing Compound Queries](searching-compound-queries.md)\.
+ Sloppy phrase search—use the `near` operator in a structured query to search a `text` or `text-array` field for multiple terms and find documents that contain the terms within the specified distance of one another\. You can also perform a sloppy phrase search with the simple query parser by appending the `~` operator and a value to the phrase\. For more information, see [Searching for Phrases](searching-text.md#searching-text-phrases)\.
+ Fuzzy search—use the `~` operator to perform fuzzy searches with the simple query parser\. Append the `~` operator and a value to a term to indicate how much terms can differ and still be considered a match\. For more information, see [Searching for Individual Terms](searching-text.md#searching-text-terms)\. 
+ Highlighting—use the `highlight.FIELD` parameter to highlight matches in a particular field\. For more information, see [Highlighting Search Hits in Amazon CloudSearch](highlighting.md)\.
+ Autocomplete—configure a suggester and submit requests to the `suggester` resource to get a list of query completions and the documents in which they were found\. For more information, see [Getting Autocomplete Suggestions in Amazon CloudSearch](getting-suggestions.md)\.
+ Partial search results—use the `partial=true` parameter to retrieve partial results when one or more index partitions are unavailable\. By default Amazon CloudSearch only returns results if every partition can be queried\.
+ Deep paging—use the `cursor` parameter to paginate results when you have a large result set\. For more information, see [Paginating Results](paginating-results.md)\. 
+ Match all documents—use the `matchall` structured query operator to retrieve all of the documents in the index\.
+ New query parsers—use the `q.parser` parameter to select the Lucene or DisMax parsers instead of the simple or structured parser, `q.parser=lucene` or `q.parser=dismax`\.

You'll also notice some changes in behavior when searching: 
+ Strings are no longer tokenized on case boundaries and periods that aren't followed by a space are considered part of the term\. For more information, see [Text Processing in Amazon CloudSearch](text-processing.md)\.
+ Literal fields are now case\-sensitive\.
+ Search responses no longer include the rank, match expression, or CPU time\. The only status information returned is the resource ID \(rid\) and processing time \(time\-ms\)\.
+ When you get facet information for an `int` field, `min` and `max` values are no longer returned\.

For more information about searching your data, see [Searching Your Data with Amazon CloudSearch](searching.md) and the [Search API Reference](search-api.md)\.

### New Parameters and Options in the Amazon CloudSearch 2013\-01\-01 Search API<a name="new-search-api"></a>

The following parameters have been added to the 2013\-01\-01 Search API:
+ `cursor.FIELD`
+ `expr.NAME`
+ `facet.FIELD`
+ `format`
+ `fq`
+ `highlight.FIELD`
+ `partial`
+ `pretty`
+ `q.options`
+ `q.parser`
+ `return`
+ `sort`

The `~` operator has been added to the simple query language to support fuzzy searches and sloppy phrase searches\.

The following operators have been added to the structured query language:
+ `boost`
+ `matchall`
+ `near`
+ `phrase`
+ `prefix`
+ `range`
+ `term`

### Obsolete Amazon CloudSearch Search Parameters and Options<a name="obsolete-search-api"></a>

The following parameters are no longer supported in the 2013\-01\-01 search API:
+ bq
+ facet\-FIELD\-top\-N
+ facet\-FIELD\-sort
+ facet\-FIELD\-constraints
+ rank
+ rank\-RANKNAME
+ return\-fields
+ result\-type
+ t\-FIELD

The following operators and shortcuts are no longer supported in structured queries:
+ field
+ filter
+ \-
+ \|
+ \+
+ \*

## Updated Limits in Amazon CloudSearch 2013\-01\-01<a name="migrating-changes-limits"></a>

This table summarizes the changes and additions to the Amazon CloudSearch limits\. For the complete list of Amazon CloudSearch limits, see [Limits](limits.md)\.


| Change | Summary | 
| --- | --- | 
| Reserved names | score is the only reserved name\. | 
| No limit on return data | Data returned from a text field is no longer truncated at 2 KB\. However, keep in mind that the maximum document size is 1 MB\. | 
| No limit on stemming, stopword, or synonym dictionaries\. | Stemming, stopword, and synonym dictionaries are configured in an analysis scheme and there is no limit on the size of an analysis scheme definition\. | 
| Maximum number of field values | An array type field can contain up to 1000 values\. | 
| Field size | The maximum size of literal fields is 4096 Unicode code points\.  | 
| Int field range | An int field can contain values in the range \-9,223,372,036,854,775,808 \- 9,223,372,036,854,775,807 \(inclusive\)\. | 
| Maximum number of highlights | The maximum number of occurrences of the search term\(s\) that can be highlighted is 5\. | 
| Maximum number of suggesters | The maximum number of suggesters you can configure for a domain is 10\. | 
| Maximum number of hits you can retrieve at once | The maximum number of hits you can retrieve at once is 10,000\. The size parameter can contain values in the range 0 \- 10000\. | 