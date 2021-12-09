# Working with Visual Types in Amazon QuickSight<a name="working-with-visual-types"></a>

Amazon QuickSight offers a range of visual types that you can use to display your data\. Use the topics in this section to learn more about the capabilities of each visual type\.

**Topics**
+ [Measures and Dimensions in Visuals](#measures-and-dimensions-in-visuals)
+ [Display Limits in Visuals](#display-limits)
+ [Using AutoGraph](autograph.md)
+ [Using Bar Charts](bar-charts.md)
+ [Using Combo Charts](combo-charts.md)
+ [Using Geospatial Charts \(Maps\)](geospatial-charts.md)
+ [Using Heat Maps](heat-map.md)
+ [Using KPIs](kpi.md)
+ [Using Line Charts](line-charts.md)
+ [Using Pie Charts](pie-chart.md)
+ [Using Pivot Table](pivot-table.md)
+ [Using Scatter Plots](scatter-plot.md)
+ [Using Tabular Reports](tabular.md)
+ [Using Tree Maps](tree-map.md)

## Measures and Dimensions in Visuals<a name="measures-and-dimensions-in-visuals"></a>

When we describe how to use the different visual types, we use the term *measure* to refer to numeric values that you use for measurement, comparison, and aggregation in visuals\. A measure can be either a numeric field, like product cost, or a numeric aggregate on a field of any data type, like count of transaction IDs\.

We use the term *dimension* to refer to text or date fields that can be items, like products, or attributes that are related to measures and can be used to partition them\. Examples are sales date for sales figures or product manufacturer for customer satisfaction numbers\. Amazon QuickSight automatically identifies a field as a measure or a dimension based on its data type\. 

Numeric fields can act as dimensions, for example ZIP codes and most ID numbers\. It's helpful to give such fields a string data type during data preparation\. This way, Amazon QuickSight understands that they are to be treated as dimensions and are not useful for performing mathematical calculations\. 

You can change whether a field is displayed as a dimension or measure on an analysis\-by\-analysis basis instead\. For more information, see [Fields as Dimensions and Measures](creating-a-visual.md#dimensions-and-measures)\.

## Display Limits in Visuals<a name="display-limits"></a>

All visual types limit the number of data points they display, so that the visual elements \(like lines, bars, or bubbles\) are still easy to view and analyze\. The visual selects the first *n* number of rows for display up to the limit for that visual type\. The selection is either according to sort order, if one has been applied, or in default order otherwise\. 

The number of data points supported varies by visual type\. To learn more about display limits for a particular visual type, see the topic for that type\. 

The visual title identifies the number of data points displayed if you have reached the display limit for that visual type\. If you have a large data set and want to avoid running into the visual display limit, use one or more filters to reduce the amount of data displayed\. For more information about using filters with visuals, see [Filtering Visual Data in Amazon QuickSight](filtering-visual-data.md)\.

Amazon QuickSight supports up to 20 data sets in a single analysis, and up to 20 visuals in a single analysis\.

An **other** category also shows on some visuals\. It contains the aggregated data for all the data beyond the cutoff limit for the visual type you are using\. You can use the on\-visual menu to choose whether or not to display the **other** category\. The **other** category doesn't show on scatter plots, heat maps, maps, tables \(tabular reports\), or KPIs\. It also doesn't show on line charts when the X axis is a date\. Drilling down into the **other** category is not supported\. 

The following image shows the **other** category on a bar chart\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/other-category-barchart.png)

The following image shows the **other** category on a pivot table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/other-category-pivot.png)

### Hiding or Displaying the other Category<a name="other-category"></a>

Use the following procedure to hide or display the **other** category\.

1. On the analysis page, select the visual that you want to modify\.

1. Choose the on\-visual menu at the upper\-right corner of the visual, and then choose **Hide "other" category** or **Show "other" category**, as appropriate\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/hide-other.png)

**Topics**
+ [Measures and Dimensions in Visuals](#measures-and-dimensions-in-visuals)
+ [Display Limits in Visuals](#display-limits)
+ [Using AutoGraph](autograph.md)
+ [Using Bar Charts](bar-charts.md)
+ [Using Combo Charts](combo-charts.md)
+ [Using Geospatial Charts \(Maps\)](geospatial-charts.md)
+ [Using Heat Maps](heat-map.md)
+ [Using KPIs](kpi.md)
+ [Using Line Charts](line-charts.md)
+ [Using Pie Charts](pie-chart.md)
+ [Using Pivot Table](pivot-table.md)
+ [Using Scatter Plots](scatter-plot.md)
+ [Using Tabular Reports](tabular.md)
+ [Using Tree Maps](tree-map.md)