# `round`<a name="round-function"></a>

`round` rounds a decimal value to the closest integer if no scale is specified, or to the closest decimal place if scale is specified\.

`round` is supported for use with analyses based on [SPICE](welcome.md#spice) data sets\.

### Syntax<a name="round-function-syntax"></a>

```
round(decimal, scale)
```

### Arguments<a name="round-function-arguments"></a>

 *decimal*   
A field that uses the decimal data type, a literal value like **17\.62**, or a call to another function that outputs a decimal\.

 *scale*   
The number of decimal places to use for the return values\.

### Return Type<a name="round-function-return-type"></a>

Decimal

### Example<a name="round-function-example"></a>

The following example rounds a decimal field to the closest second decimal place\.

```
round(salesAmount, 2)
```

The following are the given field values\.

```
20.1307
892.0388
57.5447
```

For these field values, the following values are returned\.

```
20.13
892.04
58.54
```