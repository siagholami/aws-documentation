# `decimalToInt`<a name="decimalToInt-function"></a>

`decimalToInt` converts a decimal value to the integer data type by stripping off the decimal point and any numbers after it\. `decimalToInt` does not round up\. For example, `decimalToInt(29.99)` returns `29`\.

`decimalToInt` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="decimalToInt-function-syntax"></a>

```
decimalToInt(decimal)
```

### Arguments<a name="decimalToInt-function-arguments"></a>

 *decimal*   
A field that uses the decimal data type, a literal value like **17\.62**, or a call to another function that outputs a decimal\.

### Return Type<a name="decimalToInt-function-return-type"></a>

Integer

### Example<a name="decimalToInt-function-example"></a>

The following example converts a decimal field to an integer\.

```
decimalToInt(salesAmount)
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
 58
```