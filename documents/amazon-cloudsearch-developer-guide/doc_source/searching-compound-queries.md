# Constructing Compound Queries in Amazon CloudSearch<a name="searching-compound-queries"></a>

You can use the structured query parser to combine match expressions using Boolean `and`, `or`, and `not` operators\. To select the structured query parser, you include `q.parser=structured` in your query\. The structured query operators are specified as *prefix* operators\. The syntax is:
+ `(and boost=N EXPRESSION1 EXPRESSION2 ... EXPRESSIONn)`
+ `(or boost=N EXPRESSION1 EXPRESSION2 ... EXPRESSIONn)`
+ `(not boost=N EXPRESSION)`

For example, the following query matches all movies in the sample data set that contain *star* in the title, and either Harrison Ford or William Shatner appear in the `actors` field, but Zachary Quinto does not\.

```
(and title:'star' (or actors:'Harrison Ford' actors:'William Shatner')(not actors:'Zachary Quinto'))
```

When using the structured query operators, you specify the name of the operator, options for the operator, and then the match expression being operated on, `(OPERATOR OPTIONS EXPRESSION)`\. The match expression can be a simple text string, or a subclause of your compound query\. Any options must be specified before the terms\. For example, `(and (not field=genres 'Sci-Fi')(or (term field=title boost=2 'star')(term field=plot 'star')))`\.

Parentheses control the order of evaluation of the expressions\. When an expression is enclosed in parentheses, that expression is evaluated first, and then the resulting value is used in the evaluation of the remainder of the compound query\. 

**Important**  
You must URL\-encode special characters in the query string\. For example, you must encode the `=` operator in a structured query as `%3D`: `(term+field%3Dtitle+'star'`\)\. Amazon CloudSearch returns an `InvalidQueryString` error if special characters are not URL\-encoded\. For a complete reference of URL\-encodings, see the W3C [HTML URL Encoding Reference](http://www.w3schools.com/tags/ref_urlencode.asp)\.

For example, the following query searches the `title` field for the phrase `star wars` and excludes matches that have a value less than 2000 in the `year` field\. 

```
(and (phrase field='title' 'star wars') (not (range field=year {,2000})))
```

To submit this search request, you need to encode the query string and specify the `structured` query parser with the `q.parser` parameter\.

```
http://search-movies-rr2f34ofg56xneuemujamut52i.us-east-1.cloudsearch.
amazonaws.com/2013-01-01/search?q=(and+(phrase+field='title'+'star wars')+(not+(range+field%3Dyear+{,2000})))&q.parser=structured
```

The structured query syntax enables you to combine searches against multiple fields\. If you don't specify a field to search, all `text` and `text-array` fields are searched\. For example, the following query searches all `text` and `text-array` fields for the term *star*, and excludes documents that contain *Zachary Quinto* in the `actors` field\.

```
(and 'star' (not actors:'Zachary Quinto'))
```

You can specify a `boost` value to increase the importance of one expression in a compound query in relation to the others\. The boost value increases the scores of the matching documents\. For example, the following query boosts matches for the term *star* if they occur in the `title` field rather than the `description` field\.

```
(and (range field=year [2013,}) (or (term field=title boost=2 'star') (term field=plot 'star')) 
```

Boost values must be greater than zero\.

In addition to `and`, `or`, and `not`, the Amazon CloudSearch structured search syntax supports several specialized operators:
+ `matchall`—Matches every document in the domain\. Syntax: `matchall`\.
+ `near`—Supports sloppy phrase queries\. The `distance` value specifies the maximum number of words that can separate the words in the phrase; for example, `(near field='plot' distance=4 'naval mutiny demonstration')`\. Use the `near` operator to enable matching when the specified terms are in close proximity, but not adjacent\. For more information about sloppy phrase searches, see [Searching for Phrases](searching-text.md#searching-text-phrases)\. Syntax: `(near field=FIELD distance=N boost=N 'STRING')`\.
+ `phrase`—Searches for a phrase in `text` or `text-array` fields; for example, `(phrase field="title" 'teenage mutant ninja')`\. Supports boosting documents that match the expression\. For more information about phrase searches, see [Searching for Phrases](searching-text.md#searching-text-phrases)\. Syntax: `(phrase field=FIELD boost=N 'STRING')`\.
+ `prefix`—Searches a text, text\-array, literal, or literal\-array field for the specified prefix followed by zero or more characters; for example, `(prefix field='title' 'wait')`\. Supports boosting documents that match the expression\. For more information about prefix searches, see [Searching for Prefixes](searching-text.md#searching-text-prefixes)\.Syntax: `(prefix field=FIELD boost=N 'STRING')`\.
+ `range`—Searches for a range of values in a numeric field; for example: `(range field=year [2000,2013])`\. For more information about range searches, see [Searching for a Range of Values](searching-ranges.md)\. Syntax: `(range field=FIELD boost=N RANGE)`\.
+ `term`—Searches for an individual term or value in any field; for example: `(and (term field=title 'star')(term field=year 1977))`\. Syntax: `(term field=FIELD boost=N 'STRING'|VALUE)`\.

For more information about searching particular types of data, see the following sections\. For more information about the structured search syntax, see [Structured Search Syntax](search-api.md#structured-search-syntax)\. 