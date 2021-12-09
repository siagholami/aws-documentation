# `sumOver`<a name="sumOver-function"></a>

`sumOver` calculates the sum of a measure partitioned by a list of dimensions\. 

`sumOver` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="sumOver-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
sumOver
(
     measure 
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="sumOver-function-arguments"></a>

*measure*   
The aggregated measure that you want to get the sum for, for example `sum({Sales Amt})`\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="sumOver-function-example"></a>

The following example calculates the sum of `sum(Sales)`, partitioned by `City` and `State`\.

```
sumOver
(
     sum(Sales), 
     [City, State]
)
```

The following example sums `Billed Amount` over `Customer Region`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
sumOver(
     sum({Billed Amount}),
     [{Customer Region}]
)
```

The following screenshot shows the results of the example\. With the addition of `Customer Segment`, the total amount billed for each is summed for the `Customer Region`, and displays in the calculated field\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sumOver.png)