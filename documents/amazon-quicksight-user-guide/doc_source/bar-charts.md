# Using Bar Charts<a name="bar-charts"></a>

Amazon QuickSight supports the following types of bar charts, with either horizontal or vertical orientation:
+ Single\-measure
+ Multi\-measure
+ Clustered
+ Stacked
+ Stacked 100 percent

You use these as follows:
+ Use the horizontal or vertical bar chart visual types to create single\-measure, multi\-measure, or clustered bar charts\.
+ Use a single\-measure bar chart to show values for a single measure for a dimension\.
+ Use a multi\-measure bar chart to show values for a two or more measures for a dimension\.
+ Use a clustered bar chart to show values for a single measure for a dimension that is then grouped by another dimension, for example sales total by state, grouped by region\.
+ Use any of the stacked bar chart visual types to create stacked bar charts\. A *stacked bar chart *is similar to a clustered bar chart in that it displays a measure for two dimensions\. However, instead of clustering bars for each child dimension by the parent dimension, it displays one bar per parent dimension\. It uses color blocks within the bars to show the relative values of each item in the child dimension\.

Amazon QuickSight offers both regular stacked bar charts and stacked 100 percent bar charts\. A regular stacked bar chart differs from a stacked 100 percent bar chart in that the color blocks reflect the value of each item in the child dimension relative to the total for the measure\. In contrast, a stacked 100 percent bar chart shows them by their percentage\. 

For example, the following stacked bar chart shows that total sales in the southern region were $2735\.51, with $1474\.96 from Texas and $1260\.55 from Florida\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar1.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar2.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar3.png)

The following stacked 100 percent bar chart shows this same data by percentage, which is 100 percent for the southern region\. The color block for Florida represents the approximately 46 percent of revenue from that state\. The color block for Texas represents the remaining 54 percent\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar4.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar5.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar6.png)

You can use the bar chart visual type to create a single\-measure, multi\-measure, or clustered bar chart\. A single\-measure bar chart shows one measure for one dimension, for example average delay time by flight number\. A multi\-measure bar chart shows two or more measures for one dimension, for example sales total and profit total by automobile mode\. A clustered bar chart shows values for a dimension grouped by a related dimension, for example sales totals by automobile model, grouped by car maker\.

To create a bar chart, use a dimension for the X or Y axis and a measure for the value\. The dimension is typically a text field that is related to the measure in some way and can be used to segment it to see more detailed information\. You can also use a date field in this way, but in that case we recommend using a line chart because it's better suited to showing changes in a measure over time\. Each bar in the chart represents a measure value for an item in the dimension you chose\. 

Bar charts show up to 2500 data points on the axis for visuals that don't use group/color\. For visuals that do use group/color, they show up to 50 data points on the axis and up to 50 data points for group/color\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icons for bar charts are as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/horizontal-bar-chart.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vertical-bar-chart.png)

## Other Bar Charts<a name="bar-chart-variants"></a>

Use a *stacked bar chart* to show values for hierarchical data, for example sales total by car model, stacked by car maker\. A stacked bar chart uses a scale based on the maximum value for the selected measure\. 

The icon for stacked bar charts are as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/horizontal-stacked-bar-chart.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/vertical-stacked-bar-chart.png)

Use a *100 percent bar chart* to show values for hierarchical data, where you want to emphasize the percentage in relation to a total of 100\. A stacked 100 percent bar chart uses a scale of 100 percent\. 

## Bar Chart Features<a name="bar-chart-features"></a>

Use the following table to understand the features supported by bar charts\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes, with exceptions | Multi\-measure and clustered bar charts display a legend, while single\-measure horizontal bar charts don't\. | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Yes |  | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | Yes |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude any bar on the chart, except when you are using a date field as the dimension for the axis\. In that case, you can only focus on a bar, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md)  | 
| Sorting | Yes | You can sort on the fields you choose for the axis and the values\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the field or fields you choose for the value, and can't apply aggregation to the fields you choose for the axis or group/color\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the axis, and Group/Color field wells\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Creating a Bar Chart<a name="create-bar-chart"></a>

Use the following procedure to create a bar chart\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the bar chart icon for the type of bar chart you want to create\.

1. From the **Fields list** pane, choose the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.
   + To create a single\-measure bar chart, use one measure in the **Value** field well\.
   + To create a multi\-measure bar chart, use two or more measures in the **Value** field well\. Leave the **Group/Color** field well empty\.
   + To create a clustered bar chart, choose another dimension for the **Group/Color** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **X or Y axis** or **Group/Color** field wells\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 