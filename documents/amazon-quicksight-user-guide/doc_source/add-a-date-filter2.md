# Adding a Date Filter<a name="add-a-date-filter2"></a>

You create filters on date fields by selecting the filter conditions and date values that you want to use\. There are two filter types for dates:
+ **Range** – A series of dates based on a time range and comparison type\. You can filter records based on whether the date field value is before or after a specified date, or within a date range\. You enter date values in the format MM/DD/YYYY\. You can use the following comparison types:
  + **Between** – Between a start date and an end date
  + **After** – After a specified date
  + **Before** – Before a specified date
  + **Equals** – On a specified date
+ **Relative** – A series of date/time elements based on the current date\. You can filter records based on the current date and your selected unit of measure \(UOM\)\. Date filter units include years, quarters, months, weeks, days, hours, and minutes\. You can use the following comparison types:
  + **Previous** – The previous UOM—for example, the previous year\.
  + **This** – This UOM, which includes all dates and times that fall within the select UOM, even if they occur in the future\.
  + **To date *or* up to now** – UOM to date, or UOM up to now\. The displayed phrase adapts to the UOM you choose\. However, in all cases this option filters out data that is not between the beginning of the current UOM and the current moment\.
  + **Last *n*** – The last specified number of the given UOM, which includes all of this UOM and all of the last *n * −1 UOM\. For example, let's say today is May 10, 2017\. You choose to use *years* as your UOM, and set Last *n *years to 3\. The filtered data includes data for all of 2017, plus all of 2016, and all of 2015\. If you have any data for the future dates of the current year \(2017 in this example\), these records are included in your data set\.
+ **Top and bottom** – A number of date entries ranked by another field\. You can show the top or bottom n for the type of date or time UOM you choose, based on values in another field\. For example, you can choose to show the top 5 sales days based on revenue\.

Comparisons are applied inclusive to the date specified\. For example, if you apply the filter `<date> Before 1/1/16`, the records returned include all rows with date values through 1/1/16 23:59:59\.

You can also choose to include or exclude nulls, or exclusively show rows that contain nulls in this field\.

**Note**  
If a column or attribute has no time zone information, then the client query engine sets the default interpretation of that datetime data\. For example, suppose that a column contains a timestamp, rather than a timestamptz, and you are in a different time zone than the data's origin\. In this case, the engine can render the timestamp differently than you expect\. Amazon QuickSight and [SPICE](welcome.md#spice) both use Universal Coordinated Time \(UTC\) times\. 

## Creating a Date Filter<a name="create-a-date-filter2"></a>

Use the following procedure to create a filter for a date field\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose **Create one**, and then choose a date field to filter on\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-new.png)

1. Choose the new filter to expand it\.

1. Choose a filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-filter-type.png)

1. Choose one of the following:
   + If you are creating a time range filter, choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-time-range-comparison-type.png)
   + If you are creating a relative date filter, choose a unit of measure \(UOM\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-relative-dates-unit.png)
   + If you are creating a top and bottom filter, choose Top or Bottom\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-top-and-bottom.png)

1. Choose one of the following:
   + **Time Range**: If you are filtering on a time range, enter date values\.

     To use **Between** as a comparison, enter a start and end date, or choose the **Start date** or **End date** field to bring up the date picker control and choose dates\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date.png)

     You can choose if you want to include either or both the start and end dates in the range\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date1.png)

     To use **Before**, **After**, or **Equals** comparisons, enter a date or choose the date field to bring up the date picker control and choose a date instead\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date2.png)
   + **Relative Dates**: If you are filtering on relative dates, choose a unit of measure \(UOM\)\. If you choose **Last** *n* *UOM*, specify a number for your range—for example, last 3 years, or last 2 hours\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-relative-dates-options.png)
   + **Top and bottom**: If you are filtering for top or bottom:

     For **Show top** \(or **Show bottom**\), enter the number of top or bottom items you want to show, and choose a unit of time\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-top-bottom.png)

     For **By**, choose a field to base the ranking on\. 

     Optionally, you can add another field as a tie breaker, if the field for **By** has duplicates\. Choose **\+Tie breaker**, and choose another field\. To remove a tie breaker, use the delete icon\.

1. \(Optional\) If you are filtering by using an existing parameter, instead of specific dates, enable **Use parameters**, then choose your parameter or parameters from the list\. To use **Before**, **After**, or **Equals** comparisons, choose one date parameter\. You have the option to include this date in the range\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-time-range-parameter.png)

   To use **Between**, enter both the start date and end date parameters separately\. You can include the start date, the end date, or both in the range\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-time-range-parameters.png)

   To use a parameter for **Top and bottom**, choose an integer parameter for the number of top or bottom items to show\. 

   You must create your parameters first, before you can use them in a filter\. Usually, you create a parameter, add a control for it, and then add a filter for it\. For more information, see [Parameters in Amazon QuickSight](parameters-in-quicksight.md)\.

1. \(Optional\) If you are not using parameters, at the bottom of the filter view, choose how to handle null values in the filtered field\. You can choose to include or exclude the values you listed\. Alternatively, you can choose to show nulls only\. The options for how to handle nulls don't appear for top and bottom filters\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-nulls.png)

1. Choose **Apply**\.