# Creating a Data Set from a Database<a name="create-a-database-data-set"></a>

The following procedures walk you through connecting to database data sources and creating data sets\. Use [Creating a Data Set from an Autodiscovered Amazon Redshift Cluster or Amazon RDS Instance](#create-a-data-set-autodiscovered) to create data sets from AWS data sources that your Amazon QuickSight account autodiscovered, or use [Creating a Data Set Using a Database That's Not Autodiscovered](#create-a-data-set-database) to create data sets from any other database data sources\.

## Creating a Data Set from an Autodiscovered Amazon Redshift Cluster or Amazon RDS Instance<a name="create-a-data-set-autodiscovered"></a>

Use the following procedure to create a connection to an autodiscovered AWS data source\.

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target table or query doesn't exceed data source limits\.

1. Confirm that the database credentials you plan to use have appropriate permissions as described in [Required Permissions for Database Credentials](required-permissions.md)\. 

1. Make sure that you have configured the cluster or instance for Amazon QuickSight access by following the instructions in [Network and Database Configuration Requirements](configure-access.md)\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose either the **RDS** or the **Redshift Auto\-discovered** icon, depending on the AWS service you want to connect to\.

1. Enter the connection information for the data source, as follows:
   + For **Data source name**, type a name for the data source\.
   + For **Instance ID**, choose the name of the instance or cluster you want to connect to\.
   + **Database name** shows the default database for the **Instance ID** cluster or instance\. If you want to use a different database on that cluster or instance, type its name\.
   + For **UserName**, type the user name of an account that has permissions to access the target database and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
   + For **Password**, type the password associated with the user account you entered\.

1. Choose **Validate connection** to verify your connection information is correct\.

1. If the connection validates, choose **Create data source**\. If not, correct the connection information and try validating again\.
**Note**  
Amazon QuickSight automatically secures connections to Amazon RDS instances and Amazon Redshift clusters by using Secure Sockets Layer \(SSL\)\. You don't need to do anything to enable this\.

1. Choose one of the following:
   + **Custom SQL**

     On the next screen, you can choose to write a query with the **Use custom SQL** option\. Doing this opens a screen named **Enter custom SQL query**, where you can type a name for your query, and then enter the SQL\. For best results, compose the query in a SQL editor, and then paste it into this window\. After you name and enter the query, you can choose **Edit/Preview data** or **Confirm query**\. Choose **Edit/Preview data** to immediately go to data preparation\. Choose **Confirm query** to validate the SQL and make sure that there are no errors\.
   + **Choose tables**

     If you prefer to connect to specific tables, for **Schema: contain sets of tables**, choose **Select** and then choose a schema\. In some cases where there is only a single schema in the database, that schema is automatically chosen, and the schema selection option isn't displayed\.

     To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation\. Use this option if you want to join to more tables\.

     Otherwise, after choosing a table, choose **Select**\.

1. Choose one of the following options:
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation for the selected table\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + To create a data set and analysis using the table data as\-is, and to import the data set data into SPICE for improved performance \(recommended\), check the table size and the SPICE indicator to see if you have enough capacity\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-meter.png)

     If you have enough SPICE capacity, choose **Import to SPICE for quicker analytics**, and then create an analysis by choosing **Visualize**\.
**Note**  
If you want to use SPICE and you don't have enough space, choose **Edit/Preview data**\. In data preparation, you can remove fields from the data set to decrease its size, apply a filter, or write a SQL query that reduces the number of rows or columns returned\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query2.png)
   + To create a data set and an analysis using the table data as\-is, and to have the data queried directly from the database, choose the **Directly query your data** option, and then create an analysis by choosing **Visualize**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query3.png)

## Creating a Data Set Using a Database That's Not Autodiscovered<a name="create-a-data-set-database"></a>

Use the following procedure to create a connection to any database other than an autodiscovered Amazon Redshift cluster or Amazon RDS instance\. Such databases include Amazon Redshift clusters and Amazon RDS instances that are in a different AWS Region or are associated with a different AWS account\. They also include MariaDB, Microsoft SQL Server, MySQL, and PostgreSQL instances that are on\-premises, in Amazon EC2, or in some other accessible environment\.

1. Check [Data Source Limits](data-source-limits.md) to make sure that your target table or query doesn't exceed data source limits\.

1. Confirm that the database credentials that you plan to use have appropriate permissions as described in [Required Permissions for Database Credentials](required-permissions.md)\. 

1. Make sure that you have configured the cluster or instance for Amazon QuickSight access by following the instructions in [Network and Database Configuration Requirements](configure-access.md)\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the **Redshift Manual connect** icon if you want to connect to an Amazon Redshift cluster in another AWS Region or associated with a different AWS account\. Or, choose the appropriate database management system icon to connect to an instance of Amazon Aurora, MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL\.

1. Enter the connection information for the data source, as follows:
   + For **Data source name**, type a name for the data source\.
   + For **Database server**, type or paste one of the following values:
     + For an Amazon Redshift cluster or Amazon RDS instance, type the endpoint of the cluster or instance without the port number\. For example, if the endpoint value is **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com:1234**, then type **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com**\. You can get the endpoint value from the **Endpoint** field on the cluster or instance detail page in the AWS console\.
     + For an Amazon EC2 instance of MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL, type the public DNS\. You can get the public DNS value from the **Public DNS** field on the instance detail pane in the Amazon EC2 console\.
     + For a non\-Amazon EC2 instance of MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL, type the hostname or public IP address of the database server\. If you are using Secure Sockets Layer \(SSL\) for a secured connection \(recommended\), you likely need to provide the hostname to match the information required by the SSL certificate\. For a list of accepted certificates see [Amazon QuickSight SSL and CA Certificates](configure-access.md#ca-certificates)\.
   + For **Port**, type the port that the cluster or instance uses for connections\.
   + For **Database name**, type the name of the database that you want to use\.
   + For **UserName**, type the user name of an account that has permissions to access the target database and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
   + For **Password**, type the password associated with the user account you entered\.

1. \(Optional\) If you are connecting to anything other than an Amazon Redshift cluster and you *don't* want a secured connection, make sure that **Enable SSL** is clear\. *We strongly recommend leaving this checked*, as an unsecured connection can be open to tampering\. 

   For more information on how the target instance uses SSL to secure connections, see the documentation for the target database management system\. Amazon QuickSight doesn't accept self\-signed SSL certificates as valid\. For a list of accepted certificates, see [Amazon QuickSight SSL and CA Certificates](configure-access.md#ca-certificates)\.

   Amazon QuickSight automatically secures connections to Amazon Redshift clusters by using SSL\. You don't need to do anything to enable this\.

   Some databases, such as Presto and Apache Spark, must meet additional requirements before Amazon QuickSight can connect\. For more information, see [Creating a Data Source Using Presto](create-a-data-source-presto.md), or [Creating a Data Source Using Apache Spark](create-a-data-source-spark.md)\.

1. \(Optional\) Choose **Validate connection** to verify your connection information is correct\.

1. If the connection validates, choose **Create data source**\. If not, correct the connection information and try validating again\.

1. Choose one of the following:
   + **Custom SQL**

     On the next screen, you can choose to write a query with the **Use custom SQL** option\. Doing this opens a screen named **Enter custom SQL query**, where you can type a name for your query, and then enter the SQL\. For best results, compose the query in a SQL editor, and then paste it into this window\. After you name and enter the query, you can choose **Edit/Preview data** or **Confirm query**\. Choose **Edit/Preview data** to immediately go to data preparation\. Choose **Confirm query** to validate the SQL and make sure that there are no errors\.
   + **Choose tables**

     If you prefer to connect to specific tables, for **Schema: contain sets of tables**, choose **Select** and then choose a schema\. In some cases where there is only a single schema in the database, that schema is automatically chosen, and the schema selection option isn't displayed\.

     To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation\. Use this option if you want to join to more tables\.

     Otherwise, after choosing a table, choose **Select**\.

1. Choose one of the following options:
   + To prepare the data before creating an analysis, choose **Edit/Preview data** to open data preparation for the selected table\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.
   + To create a data set and an analysis using the table data as\-is, and to import the data set data into SPICE for improved performance \(recommended\), check the table size and the SPICE indicator to see if you have enough space\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-meter.png)

     If you have enough SPICE capacity, choose **Import to SPICE for quicker analytics**, and then create an analysis by choosing **Visualize**\.
**Note**  
If you want to use SPICE and you don't have enough space, choose **Edit/Preview data**\. In data preparation, you can remove fields from the data set to decrease its size, apply a filter, or write a SQL query that reduces the number of rows or columns returned\. For more information about data preparation, see [Preparing Data Sets](preparing-data-sets.md)\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query2.png)
   + To create a data set and an analysis using the table data as\-is, and to have the data queried directly from the database, choose the **Directly query your data** option, and then create an analysis by choosing **Visualize**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query3.png)