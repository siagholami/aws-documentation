# Format a Date Field<a name="format-a-date-field"></a>

When you format a date field, you can choose a list of common formatting options\. Alternatively, you can open the **Format Data** pane choose from a list of common formats, or specify custom formatting for the date and time values\.

Changing a field format changes it for all visuals in the analysis that use that data set, but does not change it in the data set itself\.

### Format a Date Field Using List Options<a name="format-a-date-field-list"></a>

If you want to format a date field by choosing from a list of common options, you can access such a list from the **Field list** pane, a visual on\-visual editor, or a visual field well\.

Use the following procedure to change a date field's format by choosing a list option\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the date field you want to format\.
   + On any visual that contains an on\-visual editor associated with the date field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the date field you want to change\.

1. Choose **Format**, and then choose the format you want\. The following quick formatting options are offered for date fields:
   + Show the month, day, year, and time\.
   + Show the month, day, and year\.
   + Show the month and year\.
   + Show the year\.

### Format a Date Field Manually<a name="format-a-date-field-manual"></a>

Manually formatting the field allows you to choose from a more extensive list of date and time formats to use, or alternatively to specify custom formats for the date and time values\.

Use the following procedure to manually change a date field's format\.

1. Choose one of the following options:
   + In the **Field list** pane, choose the selector icon to the right of the date field you want to format\.
   + On any visual that contains an on\-visual editor associated with the date field you want to format, choose that on\-visual editor\.
   + Expand the **Field wells** pane, then choose the field well associated with the date field you want to change\.

1. Choose **Format** and then choose **More Formatting Options\.\.\.**\.

   The **Format Data** pane opens\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/format-data-date.png)

1. Expand the **Date** section\. Choose an existing date format, or choose **Custom** and specify a format pattern in the **Custom** section lower down in the **Format Data** pane\. If you choose **Custom** for the **Date** section, you must also choose **Custom** for the following **Time** section, and the pattern you specify in the **Custom** section must include any date and time formatting that you want\.

   The default selection is **Custom**, with a default format pattern of YYYY\-MM\-DD**`T`**HH:mm:ssZZ, for example 2016\-09\-22T17:00:00\-07:00\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/date-format.png)

1. Expand the **Time** section\. Choose an existing time format, or choose **Custom** and specify a format pattern in the **Custom** section lower down in the **Format Data** pane\. If you choose **Custom** for the **Time** section, you must also choose **Custom** for the preceding **Date** section, and the pattern you specify in the **Custom** section must include any date and time formatting that you want\.

   The default selection is **Custom**, with a default format pattern of YYYY\-MM\-DD**`T`**HH:mm:ssZZ, for example 2016\-09\-22T17:00:00\-07:00\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/time-format.png)

1. If you chose **Custom** in the **Date** and **Time** sections, expand the **Custom** section and specify the format pattern that you want, using the format pattern syntax specified in [Class DateTimeFormat](http://www.joda.org/joda-time/apidocs/org/joda/time/format/DateTimeFormat.html) in the Joda project documentation\.

   If you chose something other than **Custom** in the **Date** and **Time** sections, **Custom** is populated with the format pattern that reflects your selections\. For example, if you chose Jun 21, 2016 in the **Date **section and 17:00:00pm in the **Time** section, the **Custom** section shows the format pattern MMM DD, YYYY HH:mm:ssa\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-format.png)

1. \(Optional\) Expand the **Custom** section and use **Preview** to verify your specified format\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/preview-format.png)