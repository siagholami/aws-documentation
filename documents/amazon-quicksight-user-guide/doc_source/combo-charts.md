# Using Combo Charts<a name="combo-charts"></a>

Amazon QuickSight supports the following types of combo charts:
+ Clustered bar combo chart
+ Stacked bar combo chart

These are also known as line and column charts\.

Use the combo chart visual types to create a single visualization that shows two different types of data\. These two types are individually best suited to a line chart and a bar chart\. The difference between these two types can work well for comparing two sets of data, for example trends and categorical data\.

On the clustered bar combo chart, bars display for each child dimension, grouped by the parent dimension\. On the stacked bar combo chart, one bar displays per parent dimension\. Inside each bar, colors show the relative values of each item in the child dimension\. Both types of combo chart require only one dimension on the **X axis**, but are usually more effective when also displaying at least one measure under **Lines**\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/combo-chart-example1.png)

The combo chart is like using two different types of visualization at the same time\. You should make sure the data in the bars \(or columns\) directly relates to the data in the line or lines\. This relationship is not technically enforced by the tool, so it's essential that you determine this relationship yourself\. Without some relation between the lines and bars, the visual loses meaning\.

You can use the combo chart visual type to create a single\-measure or single\-line chart\. A single\-measure combo chart shows one measure for one dimension\. 

To create a multi\-measure chart, you can choose to add multiple lines, or multiple bars\. A multi\-measure bar chart shows two or more measures for one dimension\. You can group the bars in clusters, or stack them\. 

For the bars, use a dimension for the axis and a measure for the value\. The dimension is typically a text field that is related to the measure in some way and can be used to segment it to see more detailed information\. Each bar in the chart represents a measure value for an item in the dimension you chose\. 

Bars and lines show up to 2500 data points on the axis for visuals that don't use group/color\. For visuals that do use group/color, bars show up to 50 data points on the axis and up to 50 data points for group/color, while lines show 200 data points on the axis and up to 25 data points for group/color\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

A clustered bar chart shows values for a dimension grouped by a parent dimension\. A stacked bar combo chart shows values for a dimension stacked by parent dimension\. Combo charts use a scale based on the maximum value for the selected measure\. 

The icons for combo charts are as follows\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/clustered-bar-combo-chart.png)

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/stacked-bar-combo-chart.png)

## Combo Chart Features<a name="combo-chart-features"></a>

Use the following table to understand the features supported by combo charts\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes, with exceptions | Multi\-measure combo charts display a legend, and single\-measure combo charts don't\. | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Yes | You can set the range for the axis\. | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | Yes |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude any bar on the chart, except when you are using a date field as the dimension for the axis\. In that case, you can only focus on a bar, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes | You can sort on the fields you choose for the axis and the values\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the field or fields you choose for the value\. You can't apply aggregation to the fields you choose for the axis or group/color\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the axis and Group/Color field wells\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Creating a Combo Chart<a name="create-combo-chart"></a>

Use the following procedure to create a combo chart\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose one of the combo chart icons\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\. You can create combo charts as follows:
   + Choose a dimension for the **X axis**\.
   + To create a single\-measure combo chart, choose one measure for either **Bars** or **Lines**\.
   + To create a multi\-measure combo chart, choose two or more measures for the **Bars** or **Lines** field well\. 
   + Optionally, add a dimension to the **Group/Color** field well\. If you have a field in **Group/Color**, you can't have more than one field under **Bars**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/combo-chart-example2-clustered.png)

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **X axis** or **Group/Color** field wells\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/combo-chart-example3-stacked.png)