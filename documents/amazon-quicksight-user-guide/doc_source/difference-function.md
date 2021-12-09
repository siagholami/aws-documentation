# `difference`<a name="difference-function"></a>

`difference` calculates the difference between a measure based on one set of partitions and sorts, and a measure based on another\. 

`difference` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="difference-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
difference
(
     measure 
     ,[ sortorder_field ASC_or_DESC, ... ]
     ,lookup_index,
     ,[ partition field, ... ] 
)
```

### Arguments<a name="difference-function-arguments"></a>

 *measure*   
An aggregated measure that you want to see the difference for\. 

 *sort order field*   
One or more measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *lookup index*   
The lookup index can be 1 or \-1, indicating the next row in the sort \(1\) or the previous row in the sort \(\-1\)\. 

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="difference-function-example"></a>

The following example calculates the difference between of `sum({Billed Amount})`, sorted by `Customer Region` ascending, compared to the next row, and partitioned by `Service Line`\.

```
difference(
     sum( {Billed Amount} ), 
     [{Customer Region} ASC],
     1,
     [{Service Line}]
)
```

The following example calculates the difference between `Billed Amount` compared to the next line, partitioned by \(`[{Customer Region}]`\)\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
difference(
     sum( {Billed Amount} ), 
     [{Customer Region} ASC],
     1
)
```

The red highlights show how each amount is added \( a \+ b = c \) to show the difference between amounts a and c\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/differenceCalc.png)