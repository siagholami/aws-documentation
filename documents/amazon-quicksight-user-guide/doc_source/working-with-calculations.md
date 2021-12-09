# Working with Table Calculations<a name="working-with-calculations"></a>

You can use table calculations to apply statistical functions to pivot table cells that contain measures \(numeric values\)\. Use the following sections to understand which functions you can use in calculations, and how to apply or remove them\.

If the data type doesn't work properly for the calculation you create, then the data type of the cell values is changed\. For example, let's say you apply the **Rank** function to a currency data type\. The values display as integers rather than currency, because rank isn't measured as currency\. Similarly, if you apply the **Percent difference** function instead, the cell values display as percentages\. 

Table calculations can be added only to non\-aggregated fields\. For example, if you create a calculated field that is a sum of a measure, you can't add a table calculation to it\.

## Adding and Removing Table Calculations<a name="adding-a-calculation"></a>

Use the following procedures to add, modify, and remove table calculation on a pivot table\.

### Adding a Table Calculation<a name="add-a-calculation"></a>

Use the following procedure to add a table calculation to a pivot table\.

1. Expand the **Field wells** pane by choosing the expand icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/expand-field-wells.png)

1. Choose the field in the **Values** well that you want to apply a table calculation to, choose **Add table calculation**, and then choose the function to apply\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/table-calculation.png)

### Changing How a Calculation Is Applied<a name="change-how-a-calculation-is-applied"></a>

Use the following procedure to change the way a table calculation is applied to a pivot table\.

1. Expand the **Field wells** pane by choosing the expand icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/expand-field-wells.png)

1. Choose the field in the **Values** well that has the table calculation that you want to change, choose **Calculate as**, and then choose the way that you want the calculation applied\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/calculate-as.png)

### Removing a Calculation<a name="remove-a-calculation"></a>

Use the following procedure to remove a table calculation from a pivot table\.

1. Expand the **Field wells** pane by choosing the expand icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/expand-field-wells.png)

1. Choose the field in the **Values** well that you want to remove the table calculation from, and then choose **Remove calculation**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/remove-calculation.png)

## Functions for Table Calculations<a name="supported-functions"></a>

You can use the following functions in pivot table calculations\.

**Topics**
+ [Running Total](#running-total)
+ [Difference](#difference)
+ [Percent Difference](#percent-difference)
+ [Percent of Total](#percent-of-total)
+ [Rank](#rank)
+ [Percentile](#percentile)

### Running Total<a name="running-total"></a>

The running total function calculates the sum of a given cell value and the values of all cells prior to it\. This is calculated as `Cell1=Cell1, Cell2=Cell1+Cell2, Cell3=Cell1+Cell2+Cell3`, and so on\. For example, suppose that you have the following data\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total1.png)

Applying the running total function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total2.png)

### Difference<a name="difference"></a>

The difference function calculates the difference between a cell value and value of the cell prior to it\. This is calculated as `Cell1=Cell1-null, Cell2=Cell2-Cell1, Cell3=Cell3-Cell2,` and so on\. Because `Cell1-null = null`, the Cell1 value is always empty\. For example, suppose that you have the following data\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total1.png)

Applying the difference function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/difference.png)

### Percent Difference<a name="percent-difference"></a>

The percent difference function calculates the difference between a cell value and the value of the cell prior to it, divided by the value of the cell prior to it\. This is calculated as `Cell1=(Cell1-null)/null, Cell2=(Cell2-Cell1)/Cell1, Cell3=(Cell3/Cell2)/Cell2,` and so on\. Because `(Cell1-null)/null = null`, the Cell1 value is always empty\. For example, take the following rows\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total1.png)

Applying the percent difference function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percent-difference.png)

### Percent of Total<a name="percent-of-total"></a>

The percent of total function calculates the percentage the given cell represents of the sum of all of the cells included in the calculation\. This is calculated as `Cell1=Cell1/(sum of all cells), Cell2=Cell2/(sum of all cells),` and so on\. For example, suppose that you have the following data\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total1.png)

Applying the percent of total function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percent-total.png)

### Rank<a name="rank"></a>

The rank function calculates the rank of the cell value compared to the values of the other cells included in the calculation\. Rank always shows the highest value equal to 1 and lowest value equal to the count of cells included in the calculation\. If there are two or more cells with equal values, they receive the same rank but are considered to take up their own spots in the ranking\. Thus, the next highest value is pushed down in rank by the number of cells at the rank above it, minus one\. For example, if you rank the values 5,3,3,4,3,2, their ranks would be 1,3,3,2,3,6\. 

Given the following data:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank2.png)

Applying the rank function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank.png)

If you applied rank using table across down instead, so that the initial ranks are determined across the rows and then those ranks are in turn ranked down the columns, you get the following results\. The last column has two equal values sharing the top rank of 1, so the remaining value has a rank of 3\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank3.png)

### Percentile<a name="percentile"></a>

The percentile function calculates the percent of the values of the cells included in the calculation that are at or below the value for the given cell\. This is calculated as the count of cell values that is less than `(current cell value + (.05 * count of cell values equal to the current cell value)) / count of all cells`\. For example, suppose that you have the following data\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total1.png)

Applying the percentile function across the table rows gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percentile.png)

## Ways to Apply Table Calculations<a name="supported-applications"></a>

You can apply table calculations in the ways described following\. Table calculations are applied to only one field at a time, so if you have a pivot table with multiple values, calculations are only applied to the cells representing the field you applied the calculation to\.

**Topics**
+ [Table Across](#table-across)
+ [Table Down](#table-down)
+ [Table Across Down](#table-across-down)
+ [Table Down Across](#table-down-across)
+ [Group Across](#group-across)
+ [Group Down](#group-down)
+ [Group Across Down](#group-across-down)
+ [Group Down Across](#group-down-across)

### Table Across<a name="table-across"></a>

Using table across applies the calculation across the rows of the pivot table, regardless of any grouping\. This is the default\. For example, take the following pivot table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using table across gives you the following results, with row totals in the last column\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/table-across.png)

### Table Down<a name="table-down"></a>

Using table down applies the calculation down the columns of the pivot table, regardless of any grouping\. For example, take the following pivot table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using table down gives you the following results, with column totals in the last row\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/table-down.png)

### Table Across Down<a name="table-across-down"></a>

Using table across down applies the calculation across the rows of the pivot table, and then takes the results and reapplies the calculation down the columns of the pivot table\.

For the running total and difference functions, you get the same results whether you apply the function using table across down or table down across, because of the way those functions are calculated\. For all other functions, the results are different depending on whether you apply the function using table across down or table down across\.

For example, take the following pivot table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using table across down *or* table down across gives you the following results, where totals are summed both down and across, with the grand total in the bottom right cell\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total-down-across.png)

Applying the rank function using table across down, so that the initial ranks are determined across the table rows and then those ranks are in turn ranked down the columns, gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-table-across-down.png)

While applying the rank function using table down across, so that the initial ranks are determined down the table columns and then those ranks are in turn ranked across the rows, gives you the following results instead\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-table-down-across.png)

### Table Down Across<a name="table-down-across"></a>

Using table down across applies the calculation down the columns of the pivot table, then takes the results and re\-applies the calculation across the rows of the pivot table\.

For the running total and difference functions, you get the same results whether you apply the function using table down across or table across down, because of the way those functions are calculated\. For all other functions, the results are different depending on whether you apply the function using table down across or table across down\.

For example, take the following pivot table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using table down across *or* table across down gives you the following results, where totals are summed both down and across, with the grand total in the bottom right cell\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total-down-across.png)

Applying the rank function using table down across, so that the initial ranks are determined down the table columns and then those ranks are in turn ranked across the rows, gives you the following results\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-table-down-across.png)

While applying the rank function using table across down, so that the initial ranks are determined across the table rows and then those ranks are in turn ranked down the columns, gives you the following results instead\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-table-across-down.png)

### Group Across<a name="group-across"></a>

Using group across applies the calculation across the rows of the pivot table within group boundaries, as determined by the second level of grouping applied to the columns\. For example, if you group by state and then by city, grouping is applied at the state level\. If you group by region, state, and city, grouping is again applied at the state level\. When there is no grouping, group across returns the same results as table across\. 

For example, take the following pivot table where columns are grouped by service category and then by consumption channel\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using group across gives you the following results, where the function is applied across the rows, bounded by the columns for each service category group\. The **Mobile** columns display the total for both consumption channels for the given service category, for the customer region and year represented by the given row\. For example, the highlighted cell represents the total for the **AP** region for **2012**, for all consumption channels in the **Billing** service category\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/group-across.png)

### Group Down<a name="group-down"></a>

Using group down applies the calculation down the columns of the pivot table within group boundaries, as determined by the second level of grouping applied to the rows\. For example, if you group by state and then by city, grouping is applied at the state level\. If you group by region, state, and city, grouping is again applied at the state level\. When there is no grouping, group down returns the same results as table down\.

For example, take the following pivot table where rows are grouped by region and then by year\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using group down gives you the following results, where the function is applied down the columns, bounded by the rows for each region group\. The **2014** rows display the total for all years for the given region, for the service category and consumption channel represented by the given column\. For example, the highlighted cell represents the total for the **Billing** service category for the **Mobile** consumption channel, for all years in the **AP** region\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/group-down.png)

### Group Across Down<a name="group-across-down"></a>

Using group across down applies the calculation across the rows within group boundaries, as determined by the second level of grouping applied to the columns\. Then the function takes the results and re\-applies the calculation down the columns of the pivot table, within group boundaries as determined by the second level of grouping applied to the rows\. For example, if you group a row or column by state and then by city, grouping is applied at the state level\. If you group by region, state, and city, grouping is again applied at the state level\. When there is no grouping, group across down returns the same results as table across down\.

For the running total and difference functions, you get the same results whether you apply the function using group across down or group down across, because of the way those functions are calculated\. For all other functions, the results are different depending on whether you apply the function using group across down or group down across\.

For example, take the following pivot table where columns are grouped by service category and then by consumption channel, and rows are grouped by region and then by year\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using group across down *or* group down across gives you the following results, where totals are summed both down and across within the group boundaries\. In this case, these are service category for the columns and customer region for the rows\. The grand total appears in the bottom right cell for the group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total-group-across-down.png)

Applying the rank function using group across down gives you the following results, where the function is first applied across the rows bounded by each service category group\. The function is then applied again to the results of that first calculation, this time applied down the columns bounded by each region group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-group-across-down.png)

Applying the rank function using group down across gives you the following results instead, where the function is first applied down the columns bounded by each region group\. The function is then applied again to the results of that first calculation, this time applied across the rows bounded by each service category group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-group-down-across.png)

### Group Down Across<a name="group-down-across"></a>

Using group down across applies the calculation down the columns within group boundaries, as determined by the second level of grouping applied to the rows\. Then Amazon QuickSight takes the results and reapplies the calculation across the rows of the pivot table\. Again, it reapplies the calculation within group boundaries as determined by the second level of grouping applied to the columns\. For example, if you group a row or column by state and then by city, grouping is applied at the state level\. If you group by region, state, and city, grouping is again applied at the state level\. When there is no grouping, group down across returns the same results as table down across\.

For the running total and difference functions, you get the same results whether you apply the function using group down across or group across down, because of the way those functions are calculated\. For all other functions, the results are different depending on whether you apply the function using group down across or group across down\.

For example, take the following pivot table where columns are grouped by service category and then by consumption channel, and rows are grouped by region and then by year\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/sample-pivot.png)

Applying the running total function using group down across *or* group across down gives you the following results\. Here, totals are summed both down and across within the group boundaries, in this case service category for the columns and customer region for the rows\. The grand total is in the bottom right cell for the group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/running-total-group-across-down.png)

Applying the rank function using group down across gives you the following results, where the function is first applied down the columns bounded by each region group\. The function is then applied again to the results of that first calculation, this time applied across the rows bounded by each service category group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-group-down-across.png)

Applying the rank function using group across down gives you the following results instead, where the function is first applied across the rows bounded by each service category group\. The function is then applied again to the results of that first calculation, this time applied down the columns bounded by each region group\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/rank-group-across-down.png)