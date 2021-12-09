# Adding a Numeric Filter<a name="add-a-numeric-filter"></a>

Fields with decimal or int data types are considered numeric fields\. You create filters on numeric fields by specifying a comparison type, for example **Greater than** or **Between**, and a comparison value or values as appropriate to the comparison type\. Comparison values must be positive integers and should not contain commas\.

You can use the following comparison types in numeric filters:
+ Equals
+ Does not equal
+ Greater than
+ Less than
+ Greater than or equal to
+ Less than or equal to
+ Between

**Note**  
To use a top and bottom filter for numeric data, first change the field from a measure to a dimension\. Doing this converts the data to text\. Then you can use a text filter\. For more information, see [Adding a Text Filter](add-a-text-filter.md)\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/convert-to-dimension.png)

For data sets based on database queries, you can also optionally apply an aggregate function to the comparison value or values, for example **Sum** or **Average**\. 

You can use the following aggregate functions in numeric filters:
+ Average
+ Count
+ Max
+ Min
+ Sum

## Creating a Numeric Filter<a name="create-a-numeric-filter"></a>

Use the following procedure to create a numeric field filter\.

1. Choose **Filter** on the tool bar\.

1. On the **Applied filters** pane, choose the new filter icon, and then choose a numeric field to filter on\.

   This creates a new filter with no criteria\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/new-numeric-filter.png)

1. Choose the new filter to expand it\.

1. If you want to aggregate, choose the aggregation type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-numeric-agg.png)

1. Choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-numeric-comparison.png)

1. Choose one of the following:
   + To use literal values, enter the comparison value or values\. If you chose a comparison type other than **Between**, enter one comparison value\. If you chose a comparison type of **Between**, enter the beginning of the value range in **Minimum value** and the end of the value range in **Maximum value**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/enter-numeric-value.png)
   + To use an existing parameter, enable **Use parameters**, then choose your parameter from the list\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/custom-filter-use-parameters.png)

     You must create your parameters first before they can appear in this list\. Usually, you create a parameter, add a control for it, and then add a filter for it\. For more information, see [Parameters in Amazon QuickSight](parameters-in-quicksight.md)\.

1. Choose **Apply**\.