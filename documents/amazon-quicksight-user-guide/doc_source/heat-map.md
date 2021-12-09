# Using Heat Maps<a name="heat-map"></a>

Use heat maps to show a measure for the intersection of two dimensions, with color\-coding to easily differentiate where values fall in the range\. Heat maps can also be used to show the count of values for the intersection of the two dimensions\.

Each rectangle on a heat map represents the value for the specified measure for the intersection of the selected dimensions\. Rectangle color represents where the value falls in the range for the measure, with darker colors indicating higher values and lighter colors indicating lower ones\.

Heat maps and pivot tables display data in a similar tabular fashion\. Use a heat map if you want to identify trends and outliers, as the use of color makes these easier to spot\. Use a pivot table if you want to further analyze data on the visual, for example by changing column sort order or applying aggregate functions across rows or columns\.

To create a heat map, choose at least two fields of any data type\. Amazon QuickSight populates the rectangle values with the count of the X axis value for the intersecting Y axis value\. Typically, you would choose a measure and two dimensions\.

For example, the following heat map shows which products are most used by the customers in these countries, measured by a simple count\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/heat-map-sample.png)

Heat maps show up to 50 data points for rows and up to 50 data points for columns\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

The icon for a heat map is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/heat-map.png)

## Heat Map Features<a name="heat-map-features"></a>

Use the following table to understand the features supported by heat maps\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | Yes |  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | Yes |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Not applicable |  | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | No |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude a rectangle in a heat map, except when you are using a date field as the rows dimension\. In that case, you can only focus on a rectangle, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes | You can sort by the fields you choose for the columns and the values\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the fields you choose for the value, and can't apply aggregation to the fields you choose for the rows or columns\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | Yes | You can add drill\-down levels to the Rows and Columns field wells\. | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Create a Heat Map<a name="create-heat-map"></a>

Use the following procedure to create a heat map\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the heat map icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.

   To create a heat map, drag a dimension to the **Rows** field well, a dimension to the **Columns** field well, and a measure to the **Values** field well\.

1. \(Optional\) Add drill\-down layers by dragging one or more additional fields to the **Rows** or **Columns** field wells\. For more information about adding drill\-downs, see [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md)\. 