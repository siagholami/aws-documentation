# Using Scatter Plots<a name="scatter-plot"></a>

Use scatter plots to visualize two or three measures for a dimension\.

Each bubble on the scatter plot represents one item in the dimension\. The X and Y axes represent two different measures that apply to the dimension\. A bubble appears on the chart at the point where the values for the two measures for an item in the dimension intersect\. Optionally, you can also use bubble size to represent an additional measure\. 

Scatter plots show up to 50 data points for the intersection of the X and Y axis values for visuals that don't use group/color\. For visuals that do use group/color, scatter plots show up to 2500 data points\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icon for a scatter plot is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/scatter-plot.png)

## Scatter Plot Features<a name="scatter-plot-features"></a>

Use the following table to understand the features supported by scatter plots\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes, with exceptions | Scatter plots display a legend if you have the Group/Color field well populated\.  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Yes | You can set the range for both the X and Y axes\. | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | Yes |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude a bubble in a scatter plot, except when you are using a date field as a dimension\. In that case, you can only focus on a bubble, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | No |  | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the fields you choose for the X axis, Y axis, and size, and can't apply aggregation to the field you choose for the group/color\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the Group/Color field well\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Creating a Scatter Plot<a name="create-scatter-plot"></a>

Use the following procedure to create a scatter plot\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the scatter plot icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.

   To create a scatter plot, drag a measure to the **X axis** field well, a measure to the **Y axis** field well, and a dimension to the **Group/Color** field well\. To represent another measure with bubble size, drag that measure to the **Size** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **Group/Color** field well\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 