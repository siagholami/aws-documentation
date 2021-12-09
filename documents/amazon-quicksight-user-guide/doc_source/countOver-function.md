# `countOver`<a name="countOver-function"></a>

`countOver` calculates the count of a dimension or measure partitioned by a list of dimensions\. 

`countOver` is supported for use with analyses based on [SPICE](welcome.md#spice) and direct query data sets\.

### Syntax<a name="countOver-function-syntax"></a>

The brackets are required\. To see which arguments are optional, see the following descriptions\.

```
countOver(
     measure 
     ,[ partition_field, ... ]  
)
```

### Arguments<a name="countOver-function-arguments"></a>

 *measure*   
The aggregated measure that you want to get the sum for, for example `sum({Sales Amt})`\.

 *partition field*   
\(Optional\) One or more dimensions that you want to partition by, separated by commas\.   
Each field in the list is enclosed in \{\} \(curly braces\), if it is more than one word\. The entire list is enclosed in \[ \] \(square brackets\)\.

### Example<a name="countOver-function-example"></a>

The following example gets the count of `Sales` partitioned over `City` and `State`\. 

```
countOver
(
     Sales, 
     [City, State]
)
```

The following example gets the count of `{County}` partitioned over `City` and `State`\. 

```
countOver
(
     {County}, 
     [City, State]
)
```

The following example shows the count of `Billed Amount` over `Customer Region`\. This example uses the [revenue sample dataset](https://quicksightsampledata.s3.amazonaws.com/RevenueData_QuickSightSample.csv), located in an Amazon S3 bucket\. The fields in the table calculation are in the field wells of the visual\.

```
countOver(
     sum({Billed Amount}),
     [{Customer Region}]
)
```

The following screenshot shows the results of the example\. Because there are no other fields involved, the count is one for each region\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/countOver1.png)

If you add additional fields, the count changes\. In the following screenshot, we add `Customer Segment` and `Service Line`\. Each of those fields contains three unique values\. With 3 segments, 3 service lines, and 3 regions, the calculated field shows 9\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/countOver2.png)

If you add the two additional fields to the partitioning fields in the calculated field, `countOver( sum({Billed Amount}), [{Customer Region}, {Customer Segment}, {Service Line}]`, then the count is again 1 for each row\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/countOver.png)