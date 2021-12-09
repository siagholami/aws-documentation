# Creating a Data Set Using Amazon Athena Data<a name="create-a-data-set-athena"></a>

You can connect to Amazon Athena data sources and use Athena data to create Amazon QuickSight data sets\.

Before you try to read files from Amazon S3 buckets, make sure that you grant Amazon QuickSight access to them\. For more information, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.

**To create an Athena data set**

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target table or query doesn't exceed data source limits\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the **Athena** icon\.

1. For **Data source name**, type a name for the data source\.

1. Choose **Validate connection** to validate the connection\. If validation fails, make sure Amazon QuickSight has permission to access Athena resources\. Then, try validating again\. For more information on setting Amazon QuickSight permissions to AWS resources, see [Managing Amazon QuickSight Permissions to AWS Resources](managing-permissions.md)\.

1. Choose **Create data source**\. 
**Note**  
Amazon QuickSight automatically secures connections to Athena instances by using Secure Sockets Layer \(SSL\)\. You don't need to do anything to enable this\.

1. For **Database: contain sets of tables\.**, choose **Select**, and then choose your Athena database\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/athena-select-dbschema.png)
**Note**  
If you want to create a custom SQL query, choose **Edit/Preview data** to edit a query\. If you do this without selecting a table, an error appears in the data preview area\. You can safely ignore this\. The error is saying that there is no data to display until your query is created\. 

1. Choose one of the following options:
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to begin data preparation\. Choose to prepare data at this point if you are planning on writing a SQL query, rather than selecting data from a single table\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + Otherwise, choose a table, and then choose **Select** to confirm\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/athena-select-table.png)

1. If you did not choose to prepare the data in the previous step, you will see the following screen\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/athena-finish-data-set.png)

   To load your data into [SPICE](welcome.md#spice), choose **Import to SPICE**\. The green indicator shows whether or not you have space available\. 

   Alternatively, you can choose to query your data without using SPICE\. To do this, choose **Directly query your data**\.

1. After choosing how to query your data, choose one of the following options:
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to begin data preparation for the selected table\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + To create a data set and analyze the data using the table as\-is, choose **Visualize**\.