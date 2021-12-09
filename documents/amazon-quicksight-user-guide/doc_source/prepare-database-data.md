# Preparing a Data Set Based on Database Data<a name="prepare-database-data"></a>

Use the following procedure to prepare a data set based on a query to a database\. The data for this data set can be from an AWS database data source like Amazon Athena, Amazon RDS, or Amazon Redshift, or from an external database instance\. You can choose whether to import a copy of your data into [SPICE](welcome.md#spice), or to query the data directly\.

1. Open a database data set for preparation by choosing one of the following options:
   + Create a new database data set and choose **Edit/Preview data**\. For more information about creating a new data set using a new database data source, see [Creating Data Sets from New Database Data Sources](creating-database-data-sets.md)\. For more information about creating a new data set using an existing database data source, see [Creating a Data Set Using an Existing Database Data Source](create-a-data-set-existing.md#create-a-data-set-existing-database)\.
   + Open an existing database data set for editing from either the analysis page or the **Your Data Sets** page\. For more information about opening an existing data set for data preparation, see [Editing a Data Set](edit-a-data-set.md)\.

1. \(Optional\) On the data preparation page, type a name into the data set name box on the application bar\.

   This name defaults to the table name if you selected one before data preparation\. Otherwise, it's **Untitled data source**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-set-name-db.png)

1. Decide how your data is selected by choosing one of the following:
   + To use a single table to provide data, choose a table or change the table selection\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/database-tables.png)

     If you have a long table list in the **Tables** pane, you can search for a specific table by typing a search term for **Search tables**\. 

     Any table whose name contains the search term is shown\. Search is case\-insensitive and wildcards are not supported\. Choose the cancel icon \(**X**\) to the right of the search box to return to viewing all tables\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/data-prep-tables.png)
   + To use two or more joined tables to provide data, choose two tables and join them using the join pane\. You must import data into [SPICE](welcome.md#spice) if you choose to use joined tables\. For more information about joining tables using the Amazon QuickSight interface, see [Joining Tables](joining-tables.md)\.
   + To use a custom SQL query to provide data in a new data set, choose **Switch to Custom SQL** tool on the **Tables** pane\. For more information, see [Using a SQL Query](adding-a-SQL-query.md)\.

     To change the SQL query in an existing data set, choose **Edit SQL** on the **Fields** pane to open the SQL pane and edit the query\.

1. Prepare the data by doing one or more of the following:
   + [Selecting Fields](selecting-fields.md)
   + [Changing a Field Name](changing-a-field-name.md)
   + [Changing a Field Data Type](changing-a-field-data-type.md)
   + [Adding a Calculated Field During Data Preparation](working-with-calculated-fields.md#adding-a-calculated-field)
   + [Adding a Filter](adding-a-filter.md)

1. If you aren't joining tables, choose whether to query the database directly or to import the data into SPICE by selecting either the **Query** or **SPICE** radio button\. We recommend using SPICE for enhanced performance\.   
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query.png)

   If you want to use SPICE, check the SPICE indicator to see if you have enough space to import the data set\. Importing occurs when you choose either **Save & visualize** or **Save**\.

   If you don't have enough space, you can remove fields from the data set or apply a filter to decrease its size\.
**Note**  
The SPICE indicator doesn't update to reflect the potential savings of removing fields or filtering the data\. It continues to reflect the size of the data set as retrieved from the data source\.

1. Choose **Save** to save your work, or **Cancel** to cancel it\. 

   You might also see an option to **Save & visualize**\. This option appears based on the screen you started from\. If this option isn't there, you can create a new visualization by starting from the data set screen\. 