# count<a name="count-function"></a>

The `count` function calculates the number of values in a dimension or measure, grouped by the chosen dimension or dimensions\. For example, `count(product type)` returns the total number of product types grouped by the \(optional\) chosen dimension, including any duplicates\. The `count(sales)` function returns the total number of sales completed grouped by the \(optional\) chosen dimension, for example salesperson\.

### Syntax<a name="count-function-syntax"></a>

```
count(dimension or measure)
```

### Arguments<a name="count-function-arguments"></a>

 *dimension or measure*   
The argument must be a measure or a dimension\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.