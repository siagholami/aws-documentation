# Using Line Charts<a name="line-charts"></a>

Use line charts to compare changes in measure values over period of time, for the following scenarios: 
+ One measure over a period of time, for example gross sales by month\. 
+ Multiple measures over a period of time, for example gross sales and net sales by month\. 
+ One measure for a dimension over a period of time, for example number of flight delays per day by airline\. 

Line charts show the individual values of a set of measures or dimensions against the range displayed by the Y axis\. Area line charts differ from regular line charts in that each value is represented by a colored area of the chart instead of just a line, to make it easier to evaluate item values relative to each other\.

For example, discount amount by year by region looks like the following in a line chart\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/line-chart-example.png)

It looks like the following in an area line chart\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/area-line-chart-example.png)

Each line on the chart represents a measure value across a period of time\. When you have a chart with multiple lines, hover over any line to see a pop\-up legend that shows the values for each line for that point in time\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/line-on-hover-legend.png)

Use line charts to compare changes in values for one or more measures or dimensions over a period of time\. 

In regular line charts each value is represented by a line, and in area line charts each value is represented by a colored area of the chart\. 

Line charts show up to 2500 data points on the X axis when no color field is selected\. When color is populated, line charts show up to 200 data points on the X axis and up to 25 data points for color\. For more information about how data that falls outside the display limit for this visual type, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icons for line charts are as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/line-chart.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/area-line-chart.png)

## Line Chart Features<a name="line-chart-features"></a>

Use the following table to understand the features supported by line charts\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes |  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Yes | You can set the range for the Y axis\. | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | Yes |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude any line on the chart, except in the following cases: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/line-charts.html) In these cases, you can only focus on a line, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes, with exceptions | You can sort data for numeric measures in the X axis and Value field wells\. Other data is automatically sorted in ascending order\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the field you choose for the value, and can't apply aggregation to the fields you choose for the X axis and color\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the X axis and Color field wells\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Creating a Line Chart<a name="create-measure-line-chart"></a>

Use the following procedure to create a line chart\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose one of the line chart icons\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.
   + To create a single\-measure line chart, drag a dimension to the **X axis** field well and one measure to the **Value** field well\.
   + To create a multi\-measure line chart, drag a dimension to the **X axis** field well and two or more measures to the **Value** field well\. Leave the **Color** field well empty\.
   + To create a multi\-dimension line chart, drag a dimension to the **X axis** field well, one measure to the **Value** field well, and one dimension to the **Color** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **X axis** or **Color** field wells\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 