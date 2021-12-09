# `parseJson`<a name="parseJson-function"></a>

Use `parseJson` to extract values from a JSON object\. 

In [SPICE](welcome.md#spice), you can use `parseJson` when you are preparing a data set, but not in calculated fields during analysis\.

For direct query, you can use `parseJson` both during data preparation and analysis\. The `parseJson` function applies to either strings or to JSON native data types, depending on the dialect, as shown in the following table\.


| Dialect | Type | 
| --- | --- | 
| PostgreSQL | JSON | 
| Amazon Redshift | String | 
| Microsoft SQL Server | String | 
| MySQL | JSON | 
| Teradata | JSON | 
| Presto | String | 
| Snowflake | Semistructured data type object and array | 
| Hive | String | 

### Syntax<a name="parseJson-function-syntax"></a>

```
parseJson(fieldName, path)
```

### Arguments<a name="parseJson-function-arguments"></a>

 *fieldName*   
The field containing the JSON object that you want to parse\.

 *path*   
The path to the data element you want to parse from the JSON object\. Valid path syntax includes:  
+ *$* – Root object
+ *\.* – Child operator
+ *\[ \]* – Subscript operator for array

### Return Type<a name="parseJson-function-return-type"></a>

String

### Example<a name="parseJson-function-example-query"></a>

The following example evaluates incoming JSON to retrieve a value for item quantity\. By using this during data preparation, you can create a table out of the JSON\.

```
parseJson({jsonField}, “$.items.qty”)
```

The following shows the JSON\.

```
{
    "customer": "John Doe",
    "items": {
        "product": "Beer",
        "qty": 6
    },
    "list1": [
        "val1",
        "val2"
    ],
    "list2": [
        {
            "list21key1": "list1value1"
        }
    ]
}
```

For this example, the following value is returned\.

```
6
```

### Example<a name="parseJson-function-example"></a>

The following example evaluates `JSONObject1` to extract the first key value pair \(KVP\), labelled `"State"`, and assign the value to the calculated field that you are creating\.

```
parseJson(JSONObject1, “$.state”)
```

The following are the given field values\.

```
JSONObject1
-----------
{"State":"New York","Product":"Produce","Date Sold":"1/16/2018","Sales Amount":"$3423.39"}
{"State":"North Carolina","Product":"Bakery Products","Date Sold":"2/1/2018","Sales Amount":"$3226.42"}
{"State":"Utah","Product":"Water","Date Sold":"4/24/2018","Sales Amount":"$7001.52"}
```

For these field values, the following rows are returned\.

```
New York
North Carolina
Utah
```