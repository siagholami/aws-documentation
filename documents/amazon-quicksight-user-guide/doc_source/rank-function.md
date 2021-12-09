# `rank`<a name="rank-function"></a>

`rank` calculates the rank of a measure or a dimension in comparison to the specified partitions\. It counts each item, even duplicates, once and assigns a rank "with holes" to make up for duplicate values\. 

`rank` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="rank-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
rank
(
     [ sort_order_field ASC_or_DESC, ... ]
     ,[ partition_field, ... ] 
)
```

### Arguments<a name="rank-function-arguments"></a>

 *sort order field*   
One or more aggregated measures and dimensions that you want to sort the data by, separated by commas\. You can specify either ascending \(**ASC**\) or descending \(**DESC**\) sort order\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="rank-function-example"></a>

The following example ranks `max(Sales)`, based on a descending sort order, by `State` and `City`, within the `State` of **WA**\. Any cities with the same `max(Sales)` are assigned the same rank, but the next rank includes the count of all previously existing ranks\. For example, if three cities share the same ranking, the fourth city is ranked as fourth\. 

```
rank
(
     [max(Sales) DESC], 
     [State, City]
)
```

The following example ranks `max(Sales)`, based on an ascending sort order, by `State`\. Any states with the same `max(Sales)` are assigned the same rank, but the next rank includes the count of all previously existing ranks\. For example, if three states share the same ranking, the fourth state is ranked as fourth\. 

```
rank
(
     [max(Sales) ASC], 
     [State]
)
```

The following example ranks `Customer Region` by total `Billed Amount`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
rank(
     [sum({Billed Amount}) DESC]
)
```

The following screenshot shows the results of the example, along with the total `Billed Amount` so you can see how each region ranks\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rankCalc.png)