# `floor`<a name="floor-function"></a>

`floor` decrements a decimal value to the next lowest integer\. For example, `floor(29.08)` returns `29`\.

`floor` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="floor-function-syntax"></a>

```
floor(decimal)
```

### Arguments<a name="floor-function-arguments"></a>

 *decimal*   
A field that uses the decimal data type, a literal value like **17\.62**, or a call to another function that outputs a decimal\.

### Return Type<a name="floor-function-return-type"></a>

Integer

### Example<a name="floor-function-example"></a>

The following example decrements a decimal field to the next lowest integer\.

```
floor(salesAmount)
```

The following are the given field values\.

```
20.13
892.03
57.54
```

For these field values, the following values are returned\.

```
20
892
57
```