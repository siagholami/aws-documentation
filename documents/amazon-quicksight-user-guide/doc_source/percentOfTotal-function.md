# `percentOfTotal`<a name="percentOfTotal-function"></a>

`percentOfTotal` calculates the percentage a measure contributes to the total, based on the dimensions specified\. 

`percentOfTotal` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="percentOfTotal-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
percentOfTotal
(
     measure 
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="percentOfTotal-function-arguments"></a>

 *measure*   
An aggregated measure that you want to see the percent of total for\. \(Currently, the `avg` aggregation is not supported for percentOfTotal\.\)

 *partition field*  
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="percentOfTotal-function-example"></a>

The following example creates a calculation for the percent of total `Sales` contributed by each `State`\.

```
percentOfTotal
(
     sum(Sales), 
     [State]
)
```

The following example calculates the percent that a specific `Billed Amount` is when compared to the total `Billed Amount`, partitioned by \(`[{Service Line} ASC]`\)\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
percentOfTotal(
     sum( {Billed Amount} ), 
     [{Service Line}]
)
```

The following screenshot shows the results of the example\. The red highlights show that the partition field with the value "`Billing`" has three entries, one for each region\. The total billed amount for this service line is divided into three percentages, which total 100 percent\. Percentages are rounded and might not always add up to exactly 100 percent\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percentOfTotal.png)