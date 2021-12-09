# Using Pie Charts<a name="pie-chart"></a>

Use pie charts to compare values for items in a dimension\.

Each wedge in a pie chart represents one item in the dimension\. Wedge size represents the proportion of the value for the selected measure that the item represents compared to the whole for the dimension\. Pie charts are best when precision isn't important and there are few items in the dimension\.

Pie charts show up to 20 data points for group/color\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icon for a pie chart is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/pie-chart.png)

## Pie Chart Features<a name="pie-chart-features"></a>

Use the following table to understand the features supported by pie charts\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes |  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Not applicable |  | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | Yes |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude a wedge in a pie chart, except when you are using a date field as a dimension\. In that case, you can only focus on a wedge, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes | You can sort on the field you choose for the value or the group/color\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the field you choose for the value, and can't apply aggregation to the field you choose for group/color\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the Group/Color field well\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Create a Pie Chart<a name="create-pie-chart"></a>

Use the following procedure to create a pie chart\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the pie chart icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.

   To create a pie chart, drag a measure to the **Value** field well and a dimension to the **Group/Color** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **Group/Color** field well\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 