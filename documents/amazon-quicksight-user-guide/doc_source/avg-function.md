# avg<a name="avg-function"></a>

The `avg` function averages the set of numbers in the specified measure, grouped by the chosen dimension or dimensions\. For example, `avg(salesAmount)` returns the average for that measure grouped by the \(optional\) chosen dimension\.

### Syntax<a name="avg-function-syntax"></a>

```
avg(decimal)
```

### Arguments<a name="avg-function-arguments"></a>

 *decimal*   
The argument must be a measure\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.