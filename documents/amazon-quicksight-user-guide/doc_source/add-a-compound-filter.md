# Adding a Compound Filter with And/Or Operators<a name="add-a-compound-filter"></a>

When you add multiple filters to a visual, Amazon QuickSight uses the AND operator to combine them\.

To add multiple filters using the OR operator, you must create a filter group\. This lets you combine multiple conditions in a single filter with the OR operator\. You can think of this as grouping filters in parentheses\. Filter grouping is available for all types of filters\. 

When you filter on multiple measures \(green fields marked with \#\), you can apply the filter conditions to an aggregate of that field\. Filters in a group can contain either aggregated or non\-aggregated fields, but not both\. 

To create a filter group, follow these steps\.

1.  Edit or create a filter\. 

1.  Scroll to the bottom of the filter, where there is a dividing line labeled **OR**\. Choose **Add filter condition**\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-group-add-filter-condition.png)

1.  A new blank filter appears below the first one\. Choose the next field and the conditions to filter on\. 

1.  \(Optional\) You can add additional filter conditions to the filter group\. 

1.  \(Optional\) To remove a filter from the filter group, choose trashcan icon near the field name\. 

1.  When you are finished, choose **Apply**\. 