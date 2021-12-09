# distinct\_count<a name="distinct_count-function"></a>

The `distinct_count` function calculates the number of distinct values in a dimension or measure, grouped by the chosen dimension or dimensions\. For example, `distinct_count(product type)` returns the total number of unique product types grouped by the \(optional\) chosen dimension, without any duplicates\. The `distinct_count(ship date)` function returns the total number of dates when products were shipped grouped by the \(optional\) chosen dimension, for example region\.

### Syntax<a name="distinct_count-function-syntax"></a>

```
distinct_count(dimension or measure)
```

### Arguments<a name="distinct_count-function-arguments"></a>

 *dimension or measure*   
The argument must be a measure or a dimension\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.