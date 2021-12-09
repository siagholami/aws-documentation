# Adding a Text Filter<a name="add-a-text-filter"></a>

You can filter text fields by either choosing field values from a list or by specifying field values\.

Use the **Filter list** filter type to filter by choosing field values\. Using this filter type, Amazon QuickSight retrieves a list of the field values for the selected field\. You choose the values that you want to filter on, and whether you want to include or exclude records with those values\. You also have the option to **Select all** values, or search for specific values\. 

To narrow down the values displayed, type a search term into the box above the checklist and choose **Search**\. Search terms are case\-insensitive and wildcards aren't supported\. Any field value that contains the search term is returned\. For example, searching on **L** returns **al**, **AL**, **la**, and **LA**\.

To return to viewing the full set of field values rather than just those that match the search term, choose **Search** again\.

For filter lists, you can refresh the list of field values by choosing the refresh icon\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/refresh-filter.png)

To specify one or more field values to filter on, use the **Custom filter list** filter type\. You can also choose whether you want to include or exclude records that contain those values\. The specified value and actual field value must match exactly for the filter to be applied to a given record\. You can also choose whether to exclude or include nulls, or show only rows with nulls in this field\.

With the **Custom filter** filter type, you specify a single value that the field value must equal or not equal\. If you choose an equal comparison, the specified value and actual field value must match exactly in order for the filter to be applied to a given record\. Custom filters also allow you the option to attach a parameter\. To use a preexisting parameter, enable the **Use parameters** setting\. For more information about parameters, see [Parameterize a Filter](parameterize-a-filter.md)\.

Use a **Top and bottom filter** filter type to show the top or bottom *n* value for the field you choose, based on values in another field\. For example, you can choose to show the top 5 sales people based on revenue\. You can use an integer parameter as the *n* value to dynamically control the number of results to show\. 

You can find details on how to create each type of text field filter in the following sections\.

**Topics**
+ [Using a Filter List to Select Field Values](#add-a-text-filter-choose-values)
+ [Using a Custom Filter List to Specify Multiple Values](#add-text-custom-filter-list)
+ [Using a Custom Filter to Specify a Single Value or Parameter](#add-text-filter-custom-list)
+ [Using a Top and Bottom Text Filter](#add-text-filter-top-and-bottom)

## Using a Filter List to Select Field Values<a name="add-a-text-filter-choose-values"></a>

Use the following procedure to create a text field filter by selecting field values\.

**Important**  
You can only filter by choosing field values in cases where Amazon QuickSight can quickly retrieve the full set of values\. In cases where you are working with very large record sets and this is not possible, filter by specifying field values instead\. For more information about filtering with specified field values, see [Using a Custom Filter List to Specify Multiple Values](#add-text-custom-filter-list) and [Using a Custom Filter to Specify a Single Value or Parameter](#add-text-filter-custom-list)\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose the add filter icon \( **\+** \), and then choose a text field to filter on\. 

   Doing this creates a new filter with no criteria\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/choose-text-filter-field.png)

1. The filter is added to the list of filters\. Choose the new filter to expand it\.

1. Choose **Filter list** for the filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-list.png)

1. Choose the field values that you want to filter on\.

   Scroll through the list and select or clear values, or toggle the **ALL** check box to select or deselect all of the values at once\.

   To narrow down the values displayed, type a search term into the box above the checklist and choose **Search**\. Search terms are case\-insensitive and wildcards aren't supported\. Any field value that contains the search term is returned\. For example, searching on **L** returns **al**, **AL**, **la**, and **LA**\.

   Choose **X** in the search box to clear the search term\.
**Note**  
The filter list can display up to 10,000 values\. If you have more than 10,000 values in your list, use a custom filter\. For information about custom filters, see [Using a Custom Filter List to Specify Multiple Values](#add-text-custom-filter-list)\. 

## Using a Custom Filter List to Specify Multiple Values<a name="add-text-custom-filter-list"></a>

You can use the **Custom filter list** filter type to specify one or more field values to filter on, and choose whether you want to include or exclude records that contain those values\. The specified value and actual field value must match exactly for the filter to be applied to a given record\. 

Use the following procedure to create a text field filter by specifying exact field values\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose the new filter icon, and then choose a text field to filter on\. 

1. Choose the new filter to expand it\.

1. Choose **Custom filter list** for the filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-list.png)

1. Enter a field value in **Enter a value to add**, and then choose the add icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-field-value.png)

   To remove a field value from the criteria, choose its delete icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/delete-icon.png)

1. \(Optional\) Repeat Step 5 until you have all of the field values that you want to filter on\.

1. Choose whether to include or exclude records that contain the field values you selected\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-list-include.png)

1. Choose how to handle null values in the filtered field\. You can choose to include or exclude the values you listed\. Alternatively, you can choose to show nulls only\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-list-nulls.png)

1. Choose **Apply**\.

## Using a Custom Filter to Specify a Single Value or Parameter<a name="add-text-filter-custom-list"></a>

With the **Custom filter** filter type, you specify a single value that the field value must equal or not equal\. If you choose an equal comparison, the specified value and actual field value must match exactly for the filter to be applied to a given record\. You can also choose how to handle null values in the filtered field\. You can choose to include or exclude nulls, or show only rows containing nulls\. Alternatively, you can use a parameter with a custom filter\. 

Use the following procedure to create a text field filter by specifying one field value or parameter\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose the new filter icon, and then choose a text field to filter on\. 

1. Choose the new filter to expand it\.

1. Choose **Custom filter** for the filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter.png)

1. Choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-equals.png)

1. Choose one of the following\. 
   + To use a literal value, type a field value in the **value** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-value.png)

     Then choose how to handle null values in the filtered field\. You can choose to include or exclude the values you listed\. Alternatively, you can choose to show nulls only\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-nulls.png)
   + To use an existing parameter, enable **Use parameters**, then choose your parameter from the list\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-use-parameters.png)

     You must create your parameters first for them to appear in this list\. Usually, you create a parameter, add a control for it, and then add a filter for it\. For more information, see [Parameters in Amazon QuickSight](parameters-in-quicksight.md)\.

1. Choose **Apply**\.

## Using a Top and Bottom Text Filter<a name="add-text-filter-top-and-bottom"></a>

You can use a **Top and bottom filter** to show the top or bottom *n* value of one field ranked by the values in another field\. For example, you might show the top 5 sales people based on revenue\. You can also use a parameter to allow dashboard users to dynamically choose how many top or bottom ranking values to show\.

Use the following procedure to create a top and bottom text filter\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose the new filter icon, and then choose a text field to filter on\. 

1. Choose the new filter to expand it\.

1. Choose **Top and bottom** for the filter type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/top-and-bottom-filter.png)

1. Choose **Top** or **Bottom**\.

1. For **Show top** \(or **Show bottom**\), do one of the following:
   + Enter the number of top or bottom items to show\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/top-and-bottom-text-filter-options.png)
   + To use a parameter for the number of top or bottom items to show, enable **Use parameters**\. Then choose an existing integer parameter\. 

     For example, let's say you want to show the top 3 salespersons by default, but you want the dashboard viewer to be able to choose whether to show between 1 and 10 top salespersons\. In this case, take the following actions:
     + Create an integer parameter with a default value\. 
     + To link the number of displayed items to a parameter control, create a control for the integer parameter\. Then you make the control a slider with a step size of 1, a minimum value of 1, and a maximum value of 10\. 
     + To make the control work, link it to a filter by creating a top and bottom filter on `Salesperson` by `Weighted Revenue`, enable Use parameters, and choose your integer parameter\. 

1. For **By**, choose a field to base the ranking on\. If you want to show the top 5 sales people per revenue, choose the revenue field\. You can also set the aggregate that you want to perform on the field\.

1. \(Optional\) Add one or more aggregations as tie breakers, in case there are more than 5 results returned for the top 5 sales people per revenue\. This situation can happen if multiple salespeople have the same revenue amount\. 

   To create a tie breaker, choose **\+Tie breaker**, and then choose another field\. To remove a tie breaker, use the delete icon\.

1. Choose **Apply**\.