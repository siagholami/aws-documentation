# Using Unsupported or Custom Dates<a name="using-unsupported-dates"></a>

Amazon QuickSight natively supports a limited number of date formats\. However, you can’t always control the format of the data provided to you\. When your data contains a date in an unsupported format, you can tell Amazon QuickSight how to interpret it\.

You can do this by editing the data set, and changing the format of the column from text or numeric to date\. A screen appears after you make this change, so you can enter the format\. For example, if you are using a relational data source, you can specify MM\-dd\-yyyy for a text field containing '09\-19\-2017', so it is interpreted as 2017\-09\-19T00:00:00\.000Z\. If you are using a nonrelational data source, you can do the same thing starting with a numeric field or a text field\.

Amazon QuickSight only supports text to date for relational \(SQL\) sources\. 

For more information on supported date formats, see [Supported Date Formats](data-source-limits.md#supported-date-formats)\.

Use this procedure to help Amazon QuickSight understand dates in different formats\.

1. For a data set containing unsupported date formats, edit the data as follows\. For the column containing your datetime data, change the data type from text to date\. Do this by choosing the colorful data type icon beneath the column name in the data preview\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/dataset-change-datatype.png)
**Note**  
Integer dates that aren’t Unix epoch datetimes don't work as is\. For example, these formats are not supported as integers: `MMddyy`, `MMddyyyy`, `ddMMyy`, `ddMMyyyy`, and `yyMMdd`\. The workaround is to first change them to text format\. Make sure all your rows contain six digits \(not five\)\. Then change the text data type to datetime\.  
For more information on Unix epoch datetimes, see [`epochDate`](epochDate-function.md)\.

   When you change the data type to date, the **Edit date format** screen appears\.

1. Type your date format, indicating which parts are month, date, year, or time\. Formats are case\-sensitive\. 

1. Choose **Validate** to make sure Amazon QuickSight can now interpret your datetime data with the format you specified\. Rows that don't validate are skipped and omitted from the data set\.

1. When you are satisfied with the results, choose **Update**\. Otherwise, choose **Close**\.