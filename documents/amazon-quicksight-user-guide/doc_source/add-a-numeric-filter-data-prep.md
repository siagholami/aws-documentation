# Adding a Numeric Filter<a name="add-a-numeric-filter-data-prep"></a>

Fields with decimal or int data types are considered numeric fields\. You create filters on numeric fields by specifying a comparison type, for example **Greater than** or **Between**, and a comparison value or values as appropriate to the comparison type\. Comparison values must be positive integers and should not contain commas\.

You can use the following comparison types in numeric filters:
+ Equals
+ Does not equal
+ Greater than
+ Greater than or equal to
+ Less than
+ Less than or equal to
+ Between

## Creating a Numeric Filter<a name="create-a-numeric-filter-data-prep"></a>

Use the following procedure to create a numeric field filter\.

1. On the data preparation page, expand the **Filters** pane\.

1. Choose **New filter**, and then choose a numeric field to filter on\. 

   Doing this creates a new filter with no criteria\.

1. Choose the new filter to expand it\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/choose-numeric-filter.png)

1. Choose a comparison type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/filter-numeric-comparison.png)

1. If you have chosen a comparison type other than **Between** or **Not between**, type a comparison value\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/enter-numeric-value.png)

   If you have chosen a comparison type of **Between** or **Not between**, type the beginning of the value range in **Minimum value** and the end of the value range in **Maximum value**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/enter-numeric-value2.png)

1. Choose **Apply**\.