# `minOver`<a name="minOver-function"></a>

`minOver` calculates the minimum of a measure or date partitioned by a list of dimensions\. 

`minOver` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="minOver-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
minOver
(
     measure 
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="minOver-function-arguments"></a>

*measure*   
The aggregated measure that you want to get the sum for, for example `sum({Sales Amt})`\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="minOver-function-example"></a>

The following example calculates the min `sum(Sales)`, partitioned by `City` and `State`\.

```
minOver
(     
     sum(Sales), 
     [City, State]
)
```

The following example shows the minimum `Billed Amount` over `Customer Region`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
minOver(
     sum({Billed Amount}),
     [{Customer Region}]
)
```

The followins screenshot shows the results of the example\. With the addition of `Service Line`, the total amount billed for each is displayed, and the minimum of these three values displays in the calculated field\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/minOver.png)