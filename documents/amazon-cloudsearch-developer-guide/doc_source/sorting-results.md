# Sorting Results in Amazon CloudSearch<a name="sorting-results"></a>

By default, search results are sorted according to their relevance to the search request\. A document's relevance score \(`_score`\) is based on how often the search terms appear in the document compared to how common the term is across all documents in the domain\. Relevance scores are positive values that can vary widely depending on your data and queries\. The scores for each clause in your query are additive, so queries with more clauses will naturally have higher scores than queries with just one or two\. If you know what your typical queries will look like, you can do some test queries to get an idea of the range of scores you’re likely to see\. 

To change how search results are sorted, you can:
+ Use a `text` or `literal` field to sort results alphabetically\. Note that Amazon CloudSearch sorts by Unicode codepoint, so numbers come before letters and uppercase letters come before lowercase letters\. Numbers are sorted as strings, not by value; for example, 10 will come before 2\. 
+ Use an `int` or `double` field to sort results numerically\. 
+ Use a `date` field to sort results by date\. 
+ Use a custom expression to sort results\.

To use a field to sort the search results, you must configure the field to be `SortEnabled`\. Only single\-value fields can be `SortEnabled`—you cannot use the array\-type fields for sorting\. For more information about configuring fields, see [Configuring Index Fields](configuring-index-fields.md)\.

To use an expression for sorting, you construct a numeric expression using `int` fields, other expressions, a document's relevance score, and numeric operators and functions\. You can define expressions in your domain configuration, or within a search request\. For more information about configuring expressions, see [Configuring Expressions](configuring-expressions.md)\.

**Tip**  
To sort results randomly, you can use a simple `_rand` expression:  

```
/2013-01-01/search?expr.r=_rand&q=test&return=r%2Cplot%2Ctitle&sort=r+desc
```
This expression is stable, which lets you page back and forth without losing the initial, randomized sort\. If you want to use a different randomized sort, you can add `a-z` and `0-9` characters after the `_rand` value, such as:  

```
/2013-01-01/search?expr.r=_rand1a2b3c&q=test&return=r%2Cplot%2Ctitle&sort=r+desc
```

You use the `sort` parameter to specify the field or expression you want to use to sort the results\. You must explicitly specify the sort direction along with the name of the field or expression\. For example, `sort=year asc` or `sort=year desc`\.

When you use a field for sorting, documents without a value in that field are listed last\. If you specify a comma separated list of fields or expressions, the first field or expression is used as the primary sort criteria, the second is used as the secondary sort criteria, and so on\. 

 If you do not specify the `sort` parameter, the search results are ranked using the documents' default relevance scores with the highest\-scoring documents listed first\. This is equivalent to specifying `sort=_score desc`\. 

You can use the `q.options` parameter to specify field weights to apply when calculating a document's relevance `_score`\. For more information, see [Using Relative Field Weighting to Customize Text Relevance](weighting-fields.md)\.