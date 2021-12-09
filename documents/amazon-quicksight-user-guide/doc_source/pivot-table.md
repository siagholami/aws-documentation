# Using Pivot Table<a name="pivot-table"></a>

Use pivot tables to show measure values for the intersection of two dimensions\.

After you populate a pivot table, you can change row sort order and also apply statistical functions for further analysis\. You can cluster pivot table columns and rows to show values for subcategories grouped by related dimension\. You can also specify multiple measures to populate the cell values of the table, so that you can see a range of data in a single table\. 

Heat maps and pivot tables display data in a similar tabular fashion\. Use a heat map if you want to identify trends and outliers, as the use of color makes these easier to spot\. Use a pivot table if you want to analyze data on the visual\.

To create a pivot table, choose at least two fields of any data type\. Amazon QuickSight creates the table and populates the cell values with the count of the column value for the intersecting row value\. Typically, you would choose a measure and two dimensions measurable by that measure\.

Pivot tables show up to 1000 data points for rows and up to 200 data points for columns\. For more information about how we handle data that falls outside display limits, see [Display Limits in Visuals](working-with-visual-types.md#display-limits)\.

To easily transpose the fields used by the rows and columns of the pivot table, choose the orientation icon:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/pivot-orientation.png)

The icon for a pivot table is as follows:

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/pivot-table.png)

## Pivot Table Features<a name="pivot-table-features"></a>

Pivot tables don't display a legend\.

You can't hide or display the title on a pivot table visual\.

Use the following table to understand the features supported by pivot tables\.


****  

| Feature | Supported? | Comments | For More Information | 
| --- | --- | --- | --- | 
| Changing the legend display | No |  | [Customizing the Visual Legend](formatting-a-visual.md#customizing-visual-legend) | 
| Changing the title display | No |  | [Customizing a Visual Title](formatting-a-visual.md#displaying-visual-title) | 
| Changing the axis range | Not applicable |  | [Changing the Visual Scale with the Axis Range](formatting-a-visual.md#changing-visual-scale-axis-range) | 
| Changing the visual colors | No |  | [Changing Visual Colors in Amazon QuickSight](changing-visual-colors.md) | 
| Focusing on or excluding elements | Yes, with exceptions | You can focus on or exclude any column or row, except when you are using a date field as one of the dimensions\. In that case, you can only focus on the column or row that uses the date dimension, not exclude it\. |  [Focusing on Visual Elements](focusing-on-visual-elements.md) [Excluding Visual Elements](excluding-visual-elements.md) | 
| Sorting | Yes | You can sort by the field you choose for the columns\. | [Sorting Visual Data in Amazon QuickSight](sorting-visual-data.md) | 
| Field aggregation | Yes | You must apply aggregation to the field or fields you choose for the value, and can't apply aggregation to the fields you choose for the rows or columns\. If you choose to create a multi\-measure pivot table, you can apply different types of aggregation to the different measures\. For example, you could show the sum of the sales amount and the maximum discount amount\. | [Changing Field Aggregation](changing-field-aggregation.md) | 
| Adding drill\-downs | No |  | [Adding Drill\-Downs to Visual Data in Amazon QuickSight](adding-drill-downs.md) | 

## Creating a Pivot Table<a name="create-pivot-table"></a>

Use the following procedure to create a pivot table\.

1. On the analysis page, choose **Visualize** on the tool bar\.

1. Choose **Add** on the application bar, and then choose **Add visual**\.

1. On the **Visual types** pane, choose the pivot table icon\.

1. From the **Fields list** pane, drag the fields that you want to use to the appropriate field wells\. Typically, you want to use dimension or measure fields as indicated by the target field well\. If you choose to use a dimension field as a measure, the **Count** aggregate function is automatically applied to it to create a numeric value\.
   + To create a single\-measure pivot table, drag a dimension to the **Rows** field well, a dimension to the **Columns** field well, and a measure to the **Values** field well\.
   + To create a multi\-measure pivot table, drag a dimension to the **Rows** field well, a dimension to the **Columns** field well, and two or more measures to the **Values** field well\.
   + To create a clustered pivot table, drag one or more dimensions to the **Rows** field well, one or more dimensions to the **Columns** field well, and a measure to the **Values** field well\.

   You can also select multiple fields for all of the pivot table field wells if you want to, to combine the multi\-measure and clustered pivot table approaches\.