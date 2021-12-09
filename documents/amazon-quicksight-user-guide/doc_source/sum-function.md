# sum<a name="sum-function"></a>

The `sum` function adds the set of numbers in the specified measure, grouped by the chosen dimension or dimensions\. For example, `sum(profit amount)` returns the total profit amount grouped by the \(optional\) chosen dimension\.

### Syntax<a name="sum-function-syntax"></a>

```
sum(measure)
```

### Arguments<a name="sum-function-arguments"></a>

 *measure*   
The argument must be a measure\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.