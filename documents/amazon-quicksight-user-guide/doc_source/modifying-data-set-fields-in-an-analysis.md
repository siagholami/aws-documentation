# Modifying Data Set Fields in an Analysis<a name="modifying-data-set-fields-in-an-analysis"></a>

You can modify the dimension or measure setting of a field by using the **Field list** pane\. You can also change numeric field data types, and numeric or date field formats, by using the **Field list** pane, visual field wells, or on\-visual editors\. When you change a field data type or format, it applies to all visuals in the analysis that use that data set\.

**Topics**
+ [Setting a Field as a Dimension or Measure](setting-dimension-or-measure.md)
+ [Changing a Field Data Type](changing-an-analysis-field-data-type.md)
+ [Customizing a Field Format](#customizing-field-format)

## Customizing a Field Format<a name="customizing-field-format"></a>

Use the following procedure to customizing the appearance of fields in an analysis\. 

1. In an analysis, choose a field to format, either by choosing it either in the field well or in the **Fields list** of the **Visualize **pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/customizing-field-format.png)

1. Choose **Show as** to change how the field shows in the analysis, and choose from the options on the context menu\. The list of available options varies based on the field's data type\. If you choose a non\-numeric field from the fields list, you can change the *count format*, which is the formatting used when the field is counted\.

1. Choose **Format** to change the format of the field, and choose from the options on the context menu\. If you don't see an option that you want to use, choose **More formatting options** from the context menu\.

   The **Format Data** pane opens, presenting options for the type of numeric or date field you chose\. The following screenshots show the **Format Data** pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/more-field-formatting-options.png)

   The options for **Show as** from the context menu now appear in the dropdown list at the top of the **Format Data** pane\. The rest of the options are specific to the data type and how you choose to show the field\. 

For date and time data, the default format pattern is YYYY\-MM\-DD**`T`**HH:mm:ssZZ, for example 2016\-09\-22T17:00:00\-07:00\.

For numbers, you can choose from the following units to display after the number:
+ No unit suffix\. This is the default\.
+ Thousands \(K\)
+ Millions \(M\)
+ Billions \(B\)
+ Trillions \(T\)
+ A custom unit prefix or suffix

For currency, you can choose from the following symbols:
+ Dollars \($\)
+ Euros \(€\)
+ Pounds \(£\)
+ Yen \(¥\)