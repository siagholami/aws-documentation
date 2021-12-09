# `lag`<a name="lag-function"></a>

`lag` calculates the lag \(previous\) value for a measure based on specified partitions and sorts\.

`lag` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="lag-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
lag
(
     measure> 
     ,[ sortorder_field ASC_or_DESC, ... ]  
     ,lookup_index,
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="lag-function-arguments"></a>

*measure*   
The measure that you want to get the lag for\. This can include an aggregate, for example `sum({Sales Amt})`\.

*sort order field*   
One or more measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

*lookup index*   
The lookup index must be 1\. 

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="lag-function-example"></a>

The following example calculates the previous `sum(sales)`, partitioned by the state of origin, in the ascending sort order on `cancellation_code`\.

```
lag
(
     sum(Sales), 
     [cancellation_code ASC], 
     1, 
     [origin_state_nm]
)
```

The following example uses a calculated field with lag to display the amount for the previous row next to the amount for the current row, sorted by `Customer Segment`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
lag(
     sum({Billed Amount}),
     [{Customer Segment} ASC],
     1
)
```

The following screenshot shows the results of the example\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/lagCalc.png)