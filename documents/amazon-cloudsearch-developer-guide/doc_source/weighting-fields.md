# Using Relative Field Weighting to Customize Relevance Ranking in Amazon CloudSearch<a name="weighting-fields"></a>

You can assign weights to selected fields so you can boost the relevance `_score` of documents with matches in key fields such as a `title` field, and minimize the impact of matches in less important fields\. By default all fields have a weight of 1\.

Field weights are set with the `q.options` `fields` option\. You specify fields as an array of strings\. To set the weight for a field, you append a caret \(`^`\) and a positive numeric value to the field name\. You cannot set a field weight to zero or use mathematical functions or expressions to define a field weight\. 

For example, if you want matches within the `title` field to score higher than matches within the `plot` field, you could set the weight of the `title` field to 2 and the weight of the `plot` field to 0\.5:

```
q.options={fields:['title^2','plot^0.5']}
```

In addition to controlling field weights, the `fields` option defines the set of fields that are searched by default if you use the simple query parser or don't specify a field in part of a compound expression when using the structured query parser\. For more information, see [Search Request Parameters](search-api.md#search-request-parameters) in the Search API Reference\.

To reference the weighted relevance score in the definition of an expression, you use `_score`\. You can use the weighted `_score` value in conjunction with numeric fields, other expressions, and the standard numeric operators and functions\. For more information, see [Configuring Expressions](configuring-expressions.md)\.