# `lead`<a name="lead-function"></a>

`lead` calculates the lead \(following\) value for a measure based on specified partitions and sorts\.

`lead` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="lead-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
lead
(
     measure
     ,[ sortorder_field ASC_or_DESC, ... ]  
     ,lookup_index,
     ,[ partition_field, ... ]
)
```

### Arguments<a name="lead-function-arguments"></a>

*measure*   
The measure that you want to get the lead for\. This can include an aggregate, for example `sum({Sales Amt})`\.

*sort order field*   
One or more measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

*lookup index*   
The lookup index must be 1\. 

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="lead-function-example"></a>

The following example calculates the next `sum(sales)`, partitioned by the state of origin, in the ascending sort order on `cancellation_code`\.

```
lead
(
     sum(sales), 
     [cancellation_code ASC], 
     1, 
     [origin_state_nm]
)
```

The following example uses a calculated field with lead to display the amount for the next row beside the amount for the current row, sorted by `Customer Segment`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
lead(
     sum({Billed Amount}),
     [{Customer Segment} ASC],
     1
)
```

The following screenshot shows the results of the example\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/leadCalc.png)