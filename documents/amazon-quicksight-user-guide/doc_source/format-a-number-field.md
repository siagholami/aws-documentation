# Format a Number Field<a name="format-a-number-field"></a>

When you format a number field, you can either choose the decimal place and thousand separator format from a list of common options or you can open the **Format Data** pane and manually format the field\. Manually formatting the field allows you to choose what separators to use, the number of decimal places to show, what units to use, and how to display negative numbers\.

Changing a field format changes it for all visuals in the analysis, but does not change it in the underlying data set\.

### Format a Number Field Using List Options<a name="format-a-number-field-list"></a>

If you want to format a number field by choosing from a list of common options, you can access such a list from the **Field list** pane, an on\-visual editor, or a visual field well\.

Use the following procedure to change a number field's format by choosing a list option\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the number field you want to format\.
   + On any visual that contains an on\-visual editor associated with the number field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the number field you want to change\.

1. Choose **Format**, and then choose the format you want\. The following quick formatting options are offered for number fields:
   + Use commas to separate groups of thousands and use a decimal point to show the fractional part of the number, for example 1,234\.56\.
   + Use a decimal point to show the fractional part of the number, for example 1234\.56\.
   + Show the number as an integer and use commas to separate groups of thousands, for example 1,234\.
   + Show the number as an integer, for example 1234\.

### Format a Number Field Manually<a name="format-a-number-field-manual"></a>

Manually formatting the field allows you to choose what separators to use, the number of decimal places to show, what units to use, and how to display negative numbers\.

Use the following procedure to manually change a number field's format\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the number field you want to format\.
   + On any visual that contains an on\-visual editor associated with the number field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the number field you want to change\.

1. Choose **Format** and then choose **More Formatting Options\.\.\.**\.

   The **Format Data** pane opens\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-data-number.png)

1. Expand the **Separators** section and choose from the following options:
   + Under **Decimal**, choose a dot or a comma for the decimal separator\. A dot is the default\. If you choose a comma instead, you must use a dot or a space as the thousands separator\.
   + Under **Thousands**, select or deselect **Enabled** to indicate whether you want to use a thousands separator\. **Enabled** is selected by default\.
   + If you are using a thousands separator, choose whether to use a comma, dot, or space for the separator\. A comma is the default\. If you choose a dot instead, you must use a comma as the decimal separator\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/number-separator.png)

1. Expand the **Decimal Places** section and choose from the following options:
   + Choose **Auto** to have Amazon QuickSight automatically determine the appropriate number of decimal places, or choose **Custom** to specify a number of decimal places\. **Auto** is the default\.
   + If you chose **Custom**, enter the number of decimal places to use\. Field values are rounded to the decimal places specified\. For example, if you specify two decimal places, the value 6\.728 is rounded to 6\.73\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/number-decimals.png)

1. Expand the **Units** section and choose from the following options:
   + Choose the unit to use\. Choosing a unit adds the appropriate suffix to the number value\. For example, if you choose **Thousands**, a field value of 1234 displays as 1\.234K\.

     The unit options are as follows:
     + No unit suffix\. This is the default\.
     + Thousands \(K\)
     + Millions \(M\)
     + Billions \(B\)
     + Trillions \(T\)
   + If you want to use a custom prefix or suffix, specify it in the **Prefix** or **Suffix** box\. You can specify both, and you can also specify a custom prefix in addition to the suffix added by selecting a unit\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/number-units.png)

1. Expand the **Negatives** section and choose whether to display a negative value by using a minus sign or by enclosing it in parentheses\. Using a minus sign is the default\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/number-negatives.png)