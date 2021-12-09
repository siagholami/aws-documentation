# Defining Amazon CloudSearch Expressions in Search Requests<a name="defining-expressions-in-requests"></a>

You can define and use expressions directly within a search request so that you can iterate quickly while you fine\-tune expressions that you use to sort results\. By defining an expression within a search request, you can also incorporate contextual information into the expression, such as the user's geographic location\. You can override an expression defined in the domain configuration by defining an expression with the same name within a search request\.

When you define an expression within a search request, it is not stored as part of your domain configuration\. If you want to use the expression in other requests, you must define the expression in each request or add the expression to your domain configuration\. Defining an expression in every request rather than adding it to the domain configuration increases the request overhead, which can result in slower response times and potentially increase the cost of running your domain\. For information about adding expressions to the domain configuration, see [Configuring Expressions](configuring-expressions.md)\. 

You can define and use multiple expressions in a search request\. The definition of an expression can reference other expressions defined within the request, as well as expressions configured as part of the domain configuration\. 

There are no restrictions on how you can use expressions that you define in a search request\. You can use the expression to sort the search results, define other expressions, or return computed information in the search results\. 

**To define an expression in a search request**

1. Use the `expr.NAME` parameter, where NAME is the name of the expression you are defining\. For example: 

   ```
   expr.rank1=log10(clicks)*_score
   ```

1. To use the expression to sort the results, specify the name of the expression with the `sort` parameter:

   ```
   search?q=terminator&expr.rank1=log10(clicks)*_score&sort=rank1 desc
   ```

1. To include the computed value in the search results, add the expression to the list of `return` fields: 

   ```
   search?q=terminator&expr.rank1=log10(clicks)*_score&sort=rank1 desc&return=rank1
   ```

 For example, the following request creates two expressions that are used to sort the results and returns one of them in the search results:

```
search?q=terminator&expr.rank1=sin( _score)&expression.rank2=cos( _score)&sort=rank1 desc,rank2 desc&return=title,_score,rank2
```