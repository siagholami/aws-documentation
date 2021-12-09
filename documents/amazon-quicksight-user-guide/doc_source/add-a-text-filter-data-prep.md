# Adding a Text Filter<a name="add-a-text-filter-data-prep"></a>

You have two options for creating text field filters\. You can specify multiple field values to include or exclude using the **Custom filter list** filter type, or specify a single value that the field value must equal or not equal using the **Custom filter** filter type\.

## Adding a Text Filter by Specifying Multiple Field Values<a name="add-text-custom-filter-list-data-prep"></a>

With the **Custom filter list** filter type, you specify one or more field values to filter on, and whether you want to include or exclude records that contain those values\. The specified value and actual field value must match exactly for the filter to be applied to a given record\.

Use the following procedure to create a text field filter by specifying multiple field values\.

1. On the data preparation page, expand the **Filters** pane\.

1. Choose **New filter**, and then choose a text field to filter on\. 

   Doing this creates a new filter with no criteria\.

1. Choose the new filter to expand it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/choose-text-filter.png)

1. Change the filter type to **Custom filter list**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-list-dp.png)

1. Type a field value in **Enter a value to add**, and then choose the add icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-field-value.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/add-icon.png)

   To remove a field value from the criteria, choose its delete icon\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/delete-icon.png)

1. \(Optional\) Repeat Step 5 until you have added all of the field values that you want to filter on\.

1. Choose whether to include or exclude records that contain the field values you selected\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-list-include.png)

1. Choose **Apply**\.

## Adding a Text Filter by Specifying a Single Field Value<a name="add-text-filter-custom-list-data-prep"></a>

With the **Custom filter** filter type, you specify a single value that the field value must equal or not equal\. If you choose an equal comparison, the specified value and actual field value must match exactly in order for the filter to be applied to a given record\.

Use the following procedure to create a text field filter by specifying one field value\.

1. On the data preparation page, expand the **Filters** pane\.

1. Choose **New filter**, and then choose a text field to filter on\. 

   Doing this creates a new filter with no criteria\.

1. Choose the new filter to expand it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/choose-text-filter.png)

1. Change the filter type to **Custom filter**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-dp.png)

1. Choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-equals.png)

1. Type a field value in the **value** box\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-value.png)

1. Choose **Apply**\.