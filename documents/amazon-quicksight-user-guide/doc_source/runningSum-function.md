# `runningSum`<a name="runningSum-function"></a>

`runningSum` calculates a running sum for a measure based on the specified dimensions and sort orders\. 

`runningSum` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="runningSum-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\. 

```
runningSum
(
     measure 
     ,[ sortorder_field ASC_or_DESC, ... ]  
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="runningSum-function-arguments"></a>

 *measure*   
An aggregated measure that you want to see the running sum for\. 

 *sort order field*   
One or more measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *partition field*  
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="runningSum-function-example"></a>

The following example calculates a running sum of `sum(Sales)`, sorted by `Sales`, partitioned by `City` and `State`\.

```
runningSum
(
     sum(Sales), 
     [Sales ASC], 
     [City, State]
)
```

The following example calculates a running sum of `Billed Amount`, sorted by month \(`[truncDate("MM",Date) ASC]`\)\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
runningSum
(
     sum({Billed Amount}),
     [truncDate("MM",Date) ASC]
)
```

The following screenshot shows the results of the example\. The red labels show how each amount is added \( `a + b = c` \) to the next amount, resulting in a new total\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/runningSum.png)