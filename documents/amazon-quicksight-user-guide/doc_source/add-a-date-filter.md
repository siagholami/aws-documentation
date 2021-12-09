# Adding a Date Filter<a name="add-a-date-filter"></a>

You create filters on date fields by selecting the filter conditions and date values that you want to use\. There are two filter types for dates:
+ **Range** – A series of dates based on a time range and comparison type\. You can filter records based on whether the date field value is before or after a specified date, or within a date range\. You enter date values in the format MM/DD/YYYY\. You can use the following comparison types:
  + **Between** – Between a start date and an end date
  + **After** – After a specified date
  + **Before** – Before a specified date
+ **Relative** – A series of date/time elements based on the current date\. You can filter records based on the current date and your selected unit of measure \(UOM\)\. Date filter UOMs include years, quarters, months, weeks, days, hours, and minutes\. You can use the following comparison types:
  + **Previous** – The previous UOM—for example, the previous year\.
  + **This** – This UOM, which includes all dates and times that fall within the select UOM, even if they occur in the future\.
  + **to date *or* up to now** – UOM to date, or UOM up to now\. The displayed phrase adapts to the UOM you choose\. However, in all cases this option filters out data that is not between the beginning of the current UOM and the current moment\.
  + **Last *n*** – The last specified number of the given UOM, which includes all of this UOM and all of the last *n * −1 UOM\. For example, let's say today is May 10, 2017\. You choose to use *years* as your UOM, and set Last *n *years to 3\. The filtered data includes data for all of 2017, plus all of 2016, and all of 2015\. If you have any data for the future dates of the current year \(2017 in this example\), these records are included in your data set\.

Comparisons are applied inclusive to the date specified\. For example, if you apply the filter `<date> Before 1/1/16`, the records returned include all rows with date values through 1/1/16 23:59:59\.

**Note**  
If a column or attribute has no time zone information, then the client query engine sets the default interpretation of that datetime data\. For example, suppose that a column contains a timestamp, rather than a timestamptz, and you are in a different time zone than the data's origin\. In this case, the engine can render the timestamp differently than you expect\. Amazon QuickSight and [SPICE](welcome.md#spice) both use Universal Coordinated Time \(UTC\) times\. 

## Creating a Date Filter<a name="create-a-date-filter"></a>

Use the following procedure to create a filter for a date field\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose **Create one**, and then choose a date field to filter on\.

   Doing this creates a new filter with no criteria\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-new.png)

1. If the filter does not expand to show options, choose the new filter to expand it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-choose.png)

1. Choose a filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-filter-type.png)

1. Do the following to create a date filter on a time range:

   1. To create a date filter on a time range, choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-time-range-comparison-type.png)

   1. Type date values\.

      If you choose a **Between** comparison, type a start and end date, or select the **Start date** or **End date** field to bring up the date picker control and select dates\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date.png)

      If you choose a **Before** or **After** comparison, type a date, or choose the date field to bring up the date picker control and select a date instead\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date2.png)

1. Do the following to create a date filter on relative dates:

   1. Choose a unit of measure \(UOM\)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-relative-dates-unit.png)

   1. Choose one option\. If you choose **Last** *n* *UOM*, specify a number for your range—for example, last 3 years, or last 2 hours\.

      For more information about date filter options, see [Adding a Date Filter](#add-a-date-filter)\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-date-relative-dates-options.png)

1. Choose **Apply**\.