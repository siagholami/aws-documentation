# Using a SQL Query<a name="adding-a-SQL-query"></a>

When creating a new data set based on a direct query to a database, you can choose an existing SQL query or create a new SQL query\. You can use either an existing or new query to refine the data retrieved from a database, or to combine data from multiple tables\. Using a SQL query, you can specify SQL statements in addition to any join criteria to refine the data set\. If you want to join tables only by specifying the join type and the fields to use to join the tables, you can use the join interface instead\. For more information about using the join interface, see [Joining Tables](joining-tables.md)\.

You can specify a SQL query only for data sets based on SQL database data sources\.

**Important**  
If you chose a table and made any changes to the fields \(for example, changing a field name or adding a calculated field\), these changes are discarded when you switch from the table selector to the Custom SQL tool\.

## Creating a Custom SQL Query<a name="add-a-SQL-query"></a>

Use the following procedure to create a custom SQL query for a data set\.

1. Create a new data set that points to a database source\. For more information about creating a data set from a database, see [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)\.

1. Choose one of the following:
   + **Custom SQL**

     On the next screen, you can choose to write a query with the **Use custom SQL** option\. Doing this opens a screen named **Enter custom SQL query**, where you can type a name for your query, and then enter the SQL\. For best results, compose the query in a SQL editor, and then paste it into this window\. After you name and enter the query, you can choose **Edit/Preview data** or **Confirm query**\. Choose **Edit/Preview data** to immediately go to data preparation\. Choose **Confirm query** to validate the SQL and make sure that there are no errors\.
   + **Choose tables**

     If you prefer to connect to specific tables, for **Schema: contain sets of tables**, choose **Select** and then choose a schema\. 

     To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation\. Use this option if you want to join to more tables\.

     Otherwise, after choosing a table, choose **Select**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-set-use-custom-sql.png)

     After you choose **Use SQL**, the **Tables** pane is renamed to **Custom SQL**\. You can choose this new pane to switch back to using tables\.
**Note**  
You can explore the fields in your tables by using the **Tables** pane\. After you select a table, its structure displays in the viewer\. This view can be useful if you are unfamiliar with the field names, and want to write SQL\.  
In some cases, Amazon QuickSight can't change a table data source into a query\. In this case, the screen doesn't display the option to switch to a custom SQL query\. To use a query instead, create a new data set that is based on the query you want to use\.   
If your newly created data set doesn't appear on **Your Data Sets** screen, refresh your page\. Likewise, if you choose your new data set and its dialog box has no options except **Create analysis**, close this dialog box and reopen it\. 

1. Enter information for a new SQL query:
   + In the **Custom SQL** pane, choose **Use SQL**\.
   + For **Custom SQL name**, type a query name\.
   + For **Custom SQL**, type or paste in a SQL query\. The query must conform to the SQL syntax of the target database engine in terms of capitalization, command termination, and other requirements\.
**Note**  
The **Custom SQL** box has no query editing functionality\. It's easier to create the query that you want in your SQL editor of choice and then paste it in\.
   + Choose **Finish**\. The query is processed and a sample of the query results displays in the data preview pane\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/enter-sql.png)

After you have selected or created a SQL query, the [SPICE](welcome.md#spice) indicator updates to reflect the size of the data set returned by the query\.

### Switching Back to Using a Table<a name="switch-to-table"></a>

To stop using a SQL query and use regular table data instead, choose **Switch to table selector** in the **Custom SQL** pane, and then choose a table\. You can only do this with new data sets\. Once you have saved the data set to use a SQL query, you can edit the query, but you can't switch to using a table\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/table-selector.png)

### Modifying Existing Queries<a name="modifying-existing-queries"></a>

To update an existing data set based on a SQL query, open the **Fields** pane, and choose **Edit SQL** to open the SQL pane and edit the query\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/edit-sql.png)