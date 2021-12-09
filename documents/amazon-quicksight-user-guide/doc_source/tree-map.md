# Using Tree Maps<a name="tree-map"></a>

Use tree maps to visualize one or two measures for a dimension\.

Each rectangle on the tree map represents one item in the dimension\. Rectangle size represents the proportion of the value for the selected measure that the item represents compared to the whole for the dimension\. You can optionally use rectangle color to represent another measure for the item\. Rectangle color represents where the value for the item falls in the range for the measure, with darker colors indicating higher values and lighter colors indicating lower ones\.

Tree maps show up to 100 data points for the group by field\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icon for a tree map is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/tree-map.png)

## Tree Map Features<a name="tree-map-features"></a>

Use the following table to understand the features supported by tree maps\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes |  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Not applicable |  | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | No |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude a rectangle from a tree map, except when you are using a date field as the dimension\. In that case, you can only focus on a rectangle, not exclude it\.  |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes | You can sort on the fields you choose for size, color, or to group by\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the fields you choose for size and color, and can't apply aggregation to the field you choose to group by\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the Group by field well\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Create a Tree Map<a name="create-tree-map"></a>

Use the following procedure to create a tree map\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the tree map icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.

   To create a tree map, drag a measure to the **Size** field well and a dimension to the **Group by** field well\. Optionally, drag another measure to the **Color** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **Group by** field well\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 