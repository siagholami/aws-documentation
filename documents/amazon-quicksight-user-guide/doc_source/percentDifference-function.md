# `percentDifference`<a name="percentDifference-function"></a>

`percentDifference` calculates the percentage difference between the current value and a comparison value, based on partitions, sorts, and lookup index\. 

`percentDifference` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="percentDifference-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
percentDifference
(
     measure 
     ,[ sortorder_field ASC_or_DESC, ... ]  
     ,lookup index
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="percentDifference-function-arguments"></a>

 *measure*   
An aggregated measure that you want to see the percent difference for\. 

 *sort order field*   
One or more measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *lookup index*   
The lookup index can be 1 or \-1, indicating the next row in the sort \(1\) or the previous row in the sort \(\-1\)\. 

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="percentDifference-function-example"></a>

The following example calculates the percentage of difference between the `sum(Sales)` for the current and the previous `State`, sorted by `Sales`\.

```
percentDifference
(
     sum(amount), 
     [sum(amount) ASC],
     -1, 
     [State]
)
```

The following example calculates the percent that a specific `Billed Amount` is of another `Billed Amount`, sorted by \(`[{Customer Region} ASC]`\)\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
percentDifference(
     sum( {Billed Amount} ), 
     [{Customer Region} ASC],
     1
)
```

The following screenshot shows the results of the example\. The red letters show that the total `Billed Amount` for the `Customer Region` **APAC** is 24 percent less than the amount for the **EMEA** region\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percentDifference.png)