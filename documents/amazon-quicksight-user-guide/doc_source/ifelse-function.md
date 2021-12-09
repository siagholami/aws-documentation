# `ifelse`<a name="ifelse-function"></a>

`ifelse` evaluates a set of *if*, *then* expression pairings, and returns the value of the *then* argument for the first *if* argument that evaluates to true\. The remaining arguments in the list are not evaluated\. If none of the *if* arguments evaluate to true, then the value of the *else* argument is returned\.

### Syntax<a name="ifelse-function-syntax"></a>

```
ifelse(if, then [, if, then ...], else)
```

### Arguments<a name="ifelse-function-arguments"></a>

`ifelse` takes one or more *if*, *then* expression pairings, plus one expression for the *else* argument\.

 *if*   
The expression to be evaluated as true or not\. It can be a field name like **address1**, a literal value like **'Unknown'**, or another function like `toString(salesAmount)`\.   
If you use multiple AND and OR operators in the `if` argument, enclose statements in parentheses to identify processing order\. For example, the following `if` argument returns records with a month of 1, 2, or 5 and a year of 2000\.  

```
ifelse((month = 5 OR month < 3) AND year = 2000, 'yes', 'no')
```
The next `if` argument uses the same operators, but returns records with a month of 5 and any year, or with a month of 1 or 2 and a year of 2000\.  

```
ifelse(month = 5 OR (month < 3 AND year = 2000), 'yes', 'no')
```

 *then*   
The expression to return if its *if* argument is evaluated as true\. It can be a field name like **address1**, a literal value like **'Unknown'**, or a call to another function\. The expression must have the same data type as the other `then` arguments and the `else` argument\. 

 *else*   
The expression to return if none of the *if* arguments evaluate as true\. It can be a field name like **address1**, a literal value like **'Unknown'**, or another function like `toString(salesAmount)`\. The expression must have the same data type as all of the `then` arguments\. 

### Return Type<a name="ifelse-function-return-type"></a>

`ifelse` returns a value of the same data type as the input arguments\.

### Example<a name="ifelse-function-example"></a>

The following example assigns a group to a sales record based on the sales total\.

```
ifelse(salesTotal > 0 AND salesTotal < 500, 'Group 1', salesTotal >= 500 AND salesTotal < 1000, 'Group 2', 'Group 3')
```