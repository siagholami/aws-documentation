# `percentile`<a name="percentileRank-function"></a>

`percentileRank` calculates the percentile rank of a measure or a dimension in comparison to the specified partitions\. The percentile rank value\(*x*\) indicates that the current item is above *x*% of values in the specified partition\. The percentile rank value ranges from 0 \(inclusive\) to 100 \(exclusive\)\. 

`percentileRank` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="percentileRank-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
percentileRank
(
      [ sort_order_field ASC_or_DESC, ... ] 
     ,[ {partition_field}, ... ]
)
```

### Arguments<a name="percentileRank-function-arguments"></a>

 *sort order field*   
One or more aggregated measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="percentileRank-function-example"></a>

The following example does a percentile ranking of `max(Sales)` in descending order, by `State`\. 

```
percentileRank
(
     [max(Sales) DESC], 
     [State]
)
```

The following example does a percentile ranking of `Customer Region` by total `Billed Amount`\. This example uses the [revenue sample data file](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
percentileRank(
     [sum({Billed Amount}) DESC],
     [{Customer Region}]
)
```

The following screenshot shows the results of the example, along with the total `Billed Amount` so you can see how each region compares\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percentileRank.png)