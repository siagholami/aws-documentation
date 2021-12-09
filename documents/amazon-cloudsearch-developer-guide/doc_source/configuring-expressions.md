# Configuring Expressions in Amazon CloudSearch<a name="configuring-expressions"></a>

You can define numeric expressions and use them to sort search results\. Expressions can also be returned in search results\. You can add expressions to the domain configuration or define expressions within search requests\. 

**Topics**
+ [Writing Expressions for Amazon CloudSearch](#writing-expressions)
+ [query time expressions](defining-expressions-in-requests.md)
+ [Configuring Reusable Expressions for a Search Domain in Amazon CloudSearch](configuring-reusable-expressions.md)
+ [Comparing Expressions in Amazon CloudSearch](comparing-expressions.md)

## Writing Expressions for Amazon CloudSearch<a name="writing-expressions"></a>

Amazon CloudSearch expressions can contain:
+ Single value, sort enabled numeric fields \(`int`, `double`, `date`\)\. \(You must specify a specific field, wildcards are not supported\.\)
+ Other expressions
+ The `_score` variable, which references a document's relevance score
+ The `_time` variable, which references the current epoch time
+ The `_rand` variable, which returns a randomly generated value
+ Integer, floating point, hex, and octal literals
+ Arithmetic operators: `+ - * / %`
+ Bitwise operators:` | & ^ ~ << >> >>>`
+ Boolean operators \(including the ternary operator\):` && || ! ?: `
+ Comparison operators:` < <= == >= > `
+ Mathematical functions: `abs ceil exp floor ln log10 logn max min pow sqrt `
+ Trigonometric functions: `acos acosh asin asinh atan atan2 atanh cos cosh sin sinh tanh tan`
+ The `haversin` distance function

[ JavaScript order of precedence rules](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_Precedence#Table) apply for operators\. You can override operator precedence by using parentheses\.

Shortcut evaluation is used when evaluating logical expressions—if the value of the expression can be determined after evaluating the first argument, the second argument is not evaluated\. For example, in the expression `a || b`, `b` is only evaluated if `a` is not true\.

Expressions always return an integer value from 0 to the maximum 64\-bit signed integer value \(2^63 \- 1\)\. Intermediate results are calculated as double\-precision floating point values and the return value is rounded to the nearest integer\. If the expression is invalid or evaluates to a negative value, it returns 0\. If the expression evaluates to a value greater than the maximum, it returns the maximum value\. 

Expression names must begin with a letter and be at least 3 and no more than 64 characters long\. The following characters are allowed: a\-z \(lower\-case letters\), 0\-9, and \_ \(underscore\)\. The name *score* is reserved and cannot be used as an expression name\.

For example, if you define an `int` field named *popularity* for your domain, you could use that field in conjunction with the default relevance `_score` to construct a custom expression\. 

```
(0.3*popularity)+(0.7*_score)
```

Note that this simple example assumes that the popularity ranking and the relevance \_score values are in about the same range\. To tune your expressions for ranking results, you need to do some testing to determine how to weight the components of your expressions to get the results you want\. 

### Using Date Fields in Amazon CloudSearch Expressions<a name="using-dates-in-expressions"></a>

The value from a `date` field is stored as an epoch time with millisecond resolution\. This means you can use the mathematical and comparison operators to construct expressions using dates stored in your documents and the current epoch time \(`_time`\)\. For example, using the following expression to sort search results from the movies domain pushes movies with recent release dates toward the top of the list\. 

```
_score/(_time - release_date)
```