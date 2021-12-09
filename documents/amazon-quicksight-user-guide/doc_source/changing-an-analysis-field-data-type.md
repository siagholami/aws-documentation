# Changing a Field Data Type<a name="changing-an-analysis-field-data-type"></a>

You can use the **Field list** pane, visual field wells, or on\-visual editors to change numeric field data types within the context of an analysis\. Numeric fields default to displaying as numbers, but you can choose to have them display as currency or as a percentage instead\. You can't change the data types for string or date fields\.

Changing a field's data type in an analysis changes it for all visuals in the analysis that use that data set, but does not change it in the data set itself\.

**Note**  
If you are working in a pivot table visual, applying a table calculation changes the data type of the cell values if the data type doesn't make sense with the applied calculation\. For example, if you apply the **Rank** function to a numeric field that you modified to use a currency data type, the cell values display as numbers rather than currency\. Similarly, if you apply the **Percent difference** function instead, the cell values display as percentages rather than currency\. For more information about applying calculations to a pivot table, see [Working with Table Calculations](working-with-calculations.md)\.

## Change a Numeric Field's Data Type<a name="change-an-analysis-field-data-type-data-set"></a>

Use the following procedure to change a field's data type\.

1. Choose one of the following options:
   + In the **Field list** pane, hover over the numeric field you want to change and then choose the selector icon to the right of the field name\.
   + On any visual that contains an on\-visual editor associated with the numeric field you want to change, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the numeric field you want to change\.

1. Choose **Show as** and then choose **Number**, **Currency**, or **Percent**\.