# `coalesce`<a name="coalesce-function"></a>

`coalesce` returns the value of the first argument that is not null\. When a non\-null value is found, the remaining arguments in the list are not evaluated\. If all arguments are null, the result is null\. 0\-length strings are valid values and are not considered equivalent to null\.

### Syntax<a name="coalesce-function-syntax"></a>

```
coalesce(expression1, expression2 [, expression3, ...])
```

### Arguments<a name="coalesce-function-arguments"></a>

`coalesce` takes two or more expressions as arguments\. All of the expressions must have the same data type or be able to be implicitly cast to the same data type\.

 *expression*   
The expression can be numeric, datetime, or string\. It can be a field name, a literal value, or another function\. 

### Return Type<a name="coalesce-function-return-type"></a>

`coalesce` returns a value of the same data type as the input arguments\.

### Example<a name="coalesce-function-example"></a>

The following example retrieves a customer's billing address if it exists, her street address if there is no billing address, or returns "No address listed" if neither address is available\.

```
coalesce(billingAddress, streetAddress, 'No address listed')
```