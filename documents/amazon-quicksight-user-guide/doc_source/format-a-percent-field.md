# Format a Percent Field<a name="format-a-percent-field"></a>

When you format a percent field, you can either choose the number of decimal places from a list of common options, or open the **Format Data** pane and manually format the field\. Manually formatting the field allows you to choose what separators to use, the number of decimal places to show, and how to display negative numbers\.

Changing a field format changes it for all visuals in the analysis, but does not change it in the underlying data set\.

### Format a Percent Field Using List Options<a name="format-a-percent-field-list"></a>

If you want to choose the number of decimal places for a percent field from a list of common options, you can access such a list from the **Field list** pane, an on\-visual editor, or a visual field well\.

Use the following procedure to change a percent field's number of decimal places by choosing a list option\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the percent field you want to format\.
   + On any visual that contains an on\-visual editor associated with the percent field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the percent field you want to change\.

1. Choose **Decimals**, and then choose the number of decimal places you want\. The following quick formats are offered for percent fields:
   + Display the value with two decimal places\.
   + Display the value with one decimal place\.
   + Display the value with no decimal places\.

### Format a Percent Field Manually<a name="format-a-percent-field-manual"></a>

Manually formatting the field allows you to choose what separators to use, the number of decimal places to show, and how to display negative numbers\.

Use the following procedure to manually change a percent field's format\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the percent field you want to format\.
   + On any visual that contains an on\-visual editor associated with the percent field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the percent field you want to change\.

1. Choose **Format** and then choose **More Formatting options\.\.\.**\.

   The **Format Data** pane opens\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-percent.png)

1. Expand the **Separators** section and choose from the following options:
   + Under **Decimal**, choose a dot or a comma for the decimal separator\. A dot is the default\. If you choose a comma instead, you must use a dot or a space as the thousands separator\.
   + Under **Thousands**, select or deselect **Enabled** to indicate whether you want to use a thousands separator\. **Enabled** is selected by default\.
   + If you are using a thousands separator, choose whether to use a comma, dot, or space for the separator\. A comma is the default\. If you choose a dot instead, you must use a comma as the decimal separator\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percent-separators.png)

1. Expand the **Decimal Places** section and choose from the following options:
   + Choose **Auto** to have Amazon QuickSight automatically determine the appropriate number of decimal places, or choose **Custom** to specify a number of decimal places\. **Auto** is the default\.
   + If you chose **Custom**, enter the number of decimal places to use\. Field values are rounded to the decimal places specified\. For example, if you specify two decimal places, the value 6\.728 is rounded to 6\.73\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percent-decimals.png)

1. Expand the **Negatives** section and choose whether to display a negative value by using a minus sign or by enclosing it in parentheses\. Using a minus sign is the default\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/percent-negatives.png)