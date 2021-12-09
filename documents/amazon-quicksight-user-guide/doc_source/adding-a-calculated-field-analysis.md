# Adding a Calculated Field to an Analysis<a name="adding-a-calculated-field-analysis"></a>

You create calculated fields to use functions and operators to analyze or transform field data\. You can add calculated fields to a data set or to an analysis\. You can create a calculated field and add a formula \(expression\) with aggregate functions only in an analysis\.

When you add a calculated field to a data set during data preparation, it's available to all analyses that use that data set\. Data sets support only single\-row operations\. When you add a calculated field to an analysis, it's available only in that analysis\. Analyses support both single\-row operations and aggregate operations\. 

Single\-row operations are those that supply a \(potentially\) different result for every row\. Aggregate operations supply results that are always the same for entire sets of rows\. For example, if you use a simple string function with no conditions, it changes every row\. If you use an aggregate function, it applies to all the rows in a group\. If you ask for the total sales amount for the US, the same number applies to the entire set\. If you ask for data on a particular state, the total sales amount changes to reflect your new grouping\. It still provides one result for the entire set\.

By creating the aggregated calculated field within the analysis, you can then drill down into the data\. The value of that aggregated field is recalculated appropriately for each level\. This type of aggregation isn't possible during data set preparation\.

For example, let's say that you want to figure out the percentage of profit for each country, region, and state\. You can add a calculated field to your analysis, `(sum(salesAmount - cost)) / sum(salesAmount)`\. This field is then calculated for each country, region, and state, at the time your analyst drills down into the geography\.

To see which functions are available in [SPICE](welcome.md#spice), see \.[Functions by Category](calculated-field-reference.md#functions-by-category)

**Note**  
The date functions `extract` and `truncDate` don't support SS \(second\) in SPICE\. 

For information on calculated fields in data sets, see [Working with Calculated Fields](working-with-calculated-fields.md)\. 

**Topics**
+ [Using Aggregate Functions in Calculated Fields](#calculated-field-aggregations)
+ [Adding a Calculated Field](#add-a-calculated-field-analysis)
+ [Parameters in a Calculated Field in an Analysis](#parameters-in-a-calculated-field-analysis)
+ [Editing a Calculated Field](#edit-a-calculated-field-analysis)
+ [Deleting a Calculated Field](#delete-a-calculated-field-analysis)

## Using Aggregate Functions in Calculated Fields<a name="calculated-field-aggregations"></a>

You can use the following aggregate functions on calculated fields during analysis and visualization: 
+ Average – Averages the set of numbers in the specified measure, grouped by the chosen dimension or dimensions\.
+ Count – Calculates the number of values in a dimension or measure, grouped by the chosen dimension or dimensions\. 
+ Distinct Count– Calculates the number of distinct values in a dimension or measure, grouped by the chosen dimension or dimensions\. 
+ Max – Returns the maximum value of the specified measure, grouped by the chosen dimension or dimensions\.
+ Min – Returns the minimum value of the specified measure, grouped by the chosen dimension or dimensions\.
+ Sum – Adds the set of numbers in the specified measure, grouped by the chosen dimension or dimensions\.

When a calculated field formula contains an aggregation, it becomes a custom aggregation\. To make sure your data is accurately displayed, Amazon QuickSight applies the following rules:
+ Custom aggregations can't contain nested aggregate functions\. For example, this formula won't work: `sum(avg(x)/avg(y))`\. However, nesting nonaggregated functions inside or outside aggregate functions do work\. For example, `ceil(avg(x))` works\. So does `avg(ceil(x))`\.
+ Custom aggregations can't contain both aggregated and nonaggregated fields, in any combination\. For example, this formula won't work: `Sum(sales)+quantity`
+ Filter groups can't contain both aggregated and nonaggregated fields\.
+ Custom aggregations can't be converted to a dimension\. They also can't be dropped into the field well as a dimension\.
+ In a pivot table, custom aggregations can't be added to table calculations\.
+ Scatter plots with custom aggregations need at least one dimension under **Group/Color** in the field wells\.

For details about supported functions and operators, see [Calculated Field Function and Operator Reference for Amazon QuickSight Functions and Operators](calculated-field-reference.md)\.

**Topics**
+ [avg](avg-function.md)
+ [count](count-function.md)
+ [distinct\_count](distinct_count-function.md)
+ [max](max-function.md)
+ [min](min-function.md)
+ [sum](sum-function.md)

## Adding a Calculated Field<a name="add-a-calculated-field-analysis"></a>

Use the following procedure to add a calculated field\.

1. Choose **Add** on the application bar, and then choose **Add calculated field**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-calc-field.png)

1. For **Calculated field name**, where it says **Enter a field name**, type a name for the calculated field\. This name will be the field label displayed in the analysis, so it should match the existing style of field names\. 

1. Choose a function from **Function list**, and choose the fields that you want to use from the **Field list**\. Each field is entered into the formula where your cursor is\. You can add user\-defined parameters from **Parameter list** in the same way\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-calc-field2.png)

1. In **Formula**, type any formula parameters needed by the function\. Choose any additional fields or parameters to complete your formula\.

   If you use a field that has a space or a nonalphanumeric character other than an underscore in the name, you must enclose the field name in curly braces when referencing it, for example **\{ship charges amount\}**\. Curly braces are optional if the field name has no space and no nonalphanumeric character\. 

1. Choose **Create**\.

   If there are no errors in the formula or name, the new calculated field is created\. It appears in the **Fields list** pane\.

## Parameters in a Calculated Field in an Analysis<a name="parameters-in-a-calculated-field-analysis"></a>

You can reference parameters in calculated fields that are in an analysis\. When you create a calculation, you can choose existing parameters from the list of parameters under **Parameter list**\. Alternatively, you can type in the parameter name, preceded with a `$` and enclosed in curly braces `{}`, for example `${parameterName}`\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-calc-field3.png)

## Editing a Calculated Field<a name="edit-a-calculated-field-analysis"></a>

Use the following procedure to edit a calculated field\.

1. In the **Field list** pane, hover over the calculated field you want to change\.

1. Choose the selector icon to the right of the field name, and then choose **Edit calculated field**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-calc-field.png)

1. If the field is a custom aggregation, you can edit it in the field well\. 

   Hover over the field in the field well and choose the selector icon to the right of the field name\. Choose **Aggregate: custom**, and then choose **Custom**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-calc-field1.png)

   Then choose **Edit formula**\.

## Deleting a Calculated Field<a name="delete-a-calculated-field-analysis"></a>

Use the following procedure to delete a calculated field\.

1. In the **Field list** pane, hover over the calculated field you want to delete\.

1. Choose the selector icon to the right of the field name, and then choose **Remove calculated field**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/analysis-calc-field.png)