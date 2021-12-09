# max<a name="max-function"></a>

The `max` function returns the maximum value of the specified measure, grouped by the chosen dimension or dimensions\. For example, `max(sales goal)` returns the maximum sales goals grouped by the \(optional\) chosen dimension\.

### Syntax<a name="max-function-syntax"></a>

```
max(measure)
```

### Arguments<a name="max-function-arguments"></a>

 *measure*   
The argument must be a measure\. Null values are omitted from the results\. Literal values don't work\. The argument must be a field\.