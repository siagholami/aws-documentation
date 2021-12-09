# min<a name="min-function"></a>

The `min` function returns the minimum value of the specified measure, grouped by the chosen dimension or dimensions\. For example, `min(return rate)` returns the minimum rate of returns grouped by the \(optional\) chosen dimension\.

### Syntax<a name="min-function-syntax"></a>

```
min(measure)
```

### Arguments<a name="min-function-arguments"></a>

 *measure*   
The argument must be a measure\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.