# Joining Tables<a name="joining-tables"></a>

If you want to use fields from multiple tables in your data set, you can use Amazon QuickSight's join interface to join two or more tables from the same data source\. On the join interface, you can specify the join type and the fields to use to join the tables\. The fields used in the join must be from the data source and not calculated fields\. The join interface doesn't let you use any additional SQL statements to refine the data set\. If you want to do this, use a custom SQL query instead\. For more information about using a SQL query to create a data set, see [Using a SQL Query](adding-a-SQL-query.md)\.

To successfully join tables, make sure that these requirements are in place: 
+ The target of the join is a [SPICE](welcome.md#spice) data set\.
+ Both data sets are based on the same SQL database data source\.

 To join tables from different data sources, create the join before importing to Amazon QuickSight\. 

**Important**  
If you chose a table and made changes to the fields \(for example, changing a field name or adding a calculated field\), these changes are discarded when you add tables using the join interface\.

## Creating a Join<a name="create-a-join"></a>

Use the following procedure to join several tables to use in a data set\.

1. On the data preparation page, expand the **Tables** pane and then choose a table\. This table is on the left when you are choosing a join type and join columns\. The table appears in the join interface\.
**Note**  
 You can only join tables if they are members of the same SQL database data source\. Others don't appear in the list\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join1.png)

1. In the **Tables** pane, choose another table\. This table is on the right when you are choosing a join type and join columns\. The table appears in the join interface and a join appears between the two tables\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join2.png)

1. Choose the join to open the **Configure join** pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join3.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join4.png)

1. Enter the join column information:
   + In the **Data sources** section of the **Configure join** pane, choose the join column for the left table\. This should be a column that has a matching column in the table to the right\. For example, a Customers table usually has a customer ID column to uniquely identify the customer\. An Orders table usually has a customer ID column to identify what customer that order belongs to\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join6.png)
   + Choose the join column for the table to the right\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join7.png)
   + \(Optional\) If the tables you selected join on multiple columns, choose **Add a new join clause** and specify the next set of join columns\. Repeat this process until you have identified all of the join columns for the tables\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join8.png)  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join9.png)

1. In the **Configure join** pane, choose a join type\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join5.png)

   You can choose from the following join types:
   + **Inner** — An inner join records only where both tables have matching values in the join columns\. This join type is the most commonly used one\. For example, suppose that you perform an inner join on the following Safety Ratings and Widgets tables\.

     ```
     rating_id	safety_rating
     1		    A+
     2		    A
     3		    A-
     4		    B+
     5		    B
     ```

     ```
     widget_id	  widget	safety_rating_id
     1		    WidgetA		3
     2		    WidgetB		1
     3		    WidgetC		1
     4		    WidgetD		2
     5		    WidgetE		
     6		    WidgetF		5
     7		    WidgetG
     ```

     In the result set, widgets without safety ratings aren't shown, and safety ratings that aren't associated with any widget aren't shown\.

     ```
     rating_id    safety_rating    widget_id   widget    
     safety_rating_id
     3	        A-                1        WidgetA        3
     1	        A+                2        WidgetB        1
     1	        A+                3        WidgetC        1
     2	        A                 4        WidgetD        2
     5	        B                 6        WidgetF        5
     ```
   + **Left** — A left outer join returns all records from the left table, and only records that have a value in the join column for the table to the right\. For example, suppose that you perform a left outer join on the Safety Ratings \(left table\) and Widgets \(right table\) tables\. In this case, all safety ratings records are returned, and only matching widget records are returned\.

     ```
     rating_id    safety_rating    widget_id   widget    
     safety_rating_id
     1	        A+                2        WidgetB   	1
     1	        A+                3        WidgetC   	1
     2	        A                 4        WidgetD   	2
     3	        A-                1        WidgetA   	3
     4	        B+        	
     5	        B                 6        WidgetF   	5
     ```
   + **Right** — A right outer join returns all records from the table to the right, and only records that have a value in the join column for the left table\. For example, suppose that you perform a right outer join on the Safety Ratings \(left table\) and Widgets \(right table\) tables\. In this case, all widget records are returned, and only matching safety ratings records are returned\.

     ```
     rating_id    safety_rating    widget_id   widget    
     safety_rating_id
     3	        A-                1	WidgetA   	 3
     1	        A+                2	WidgetB   	 1
     1	        A+                3	WidgetC   	 1
     2	        A                 4	WidgetD   	 2    
                                       5     WidgetE   	
     5	        B                 6	WidgetF   	 5
                                       7     WidgetG
     ```
   + **Outer** — A full outer join returns all records from both tables, regardless of the values in the join columns\. This type of join can return very large result sets because it includes all rows from both tables\. For example, if you perform a full outer join on the Safety Ratings and Widgets tables, all records are returned\.

     ```
     rating_id    safety_rating    widget_id   widget    
     safety_rating_id
     1	        A+                2	WidgetB   	1
     1	        A+                3	WidgetC   	1
     2	        A                 4	WidgetD   	2
     3	        A-                1	WidgetA   	3
     4	        B+
     5	        B                 6	WidgetF   	5
                                       5	WidgetE   	
                                       7	WidgetG
     ```

1. Choose **Apply**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join10.png)

   The join icon updates to indicate that the join type and columns have been selected\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join12.png)

   The fields from the table to the right appear at the bottom of the **Fields** pane\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/join13.png)

1. \(Optional\) Repeat steps 2–6 to add more tables\. The table you selected in Step 1 is the left table and the new table is the right table for each join you add\.

## Modifying Existing Joins<a name="modifying-existing-joins"></a>

To modify an existing join, choose the join icon to open it in the **Configure join** pane\.

To remove a table from the data set, either deselect it in the **Tables** pane, or hover over it in the relationship pane and then choose the delete icon\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/delete-table.png)