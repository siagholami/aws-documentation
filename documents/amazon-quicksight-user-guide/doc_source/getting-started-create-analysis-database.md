# Create an Analysis Using Your Own Database Data<a name="getting-started-create-analysis-database"></a>

To create your first analysis using your own database data, follow these steps:

**Topics**
+ [Connect to a Database Data Source](#step-1-connect-to-database-data-source)
+ [Step 2: Create a Database Data Set and an Analysis](#step-2-create-database-data-set-and-analysis)
+ [Step 3: Create a Visual](#step-3-create-database-visual)

## Connect to a Database Data Source<a name="step-1-connect-to-database-data-source"></a>

Choose the situation that applies to you and follow the steps in the procedure to connect to your data source\.

**Topics**
+ [Has Autodiscovered AWS Data Sources](#step-1-connect-to-data-source-autodiscover)
+ [Does Not Have Autodiscovered AWS Data Sources](#step-1-connect-to-data-source-no-autodiscover)

### Your Amazon QuickSight Account Has Autodiscovered AWS Data Sources<a name="step-1-connect-to-data-source-autodiscover"></a>

If your Amazon QuickSight account has any autodiscovered AWS data sources, icons for those data sources appear on your start page\. If you have credentials for one of these AWS data sources, use the following procedure\. Otherwise, use the procedure in [Your Amazon QuickSight Account Does Not Have Autodiscovered AWS Data Sources](#step-1-connect-to-data-source-no-autodiscover)\.

1. Check [Data Source Limits](data-source-limits.md) to make sure your target table or query doesn't exceed data source limits\.

1. Confirm that the database credentials you plan to use have appropriate permissions as described in [Required Permissions for Database Credentials](required-permissions.md)\. 

1. Make sure you have configured the cluster or instance for Amazon QuickSight access by following the instructions in [Network and Database Configuration Requirements](configure-access.md)\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose either the **RDS** or the **Redshift Auto\-discovered** icon, depending on the AWS service you want to connect to\.

1. Enter the connection information for the data source, as follows:
   + For **Data source name**, type a name for the data source\.
   + For **Instance ID**, choose the name of the instance or cluster you want to connect to\.
   + **Database name** shows the default database for the **Instance ID** cluster or instance\. If you want to use a different database on that cluster or instance, type its name\.
   + For **Username**, type the user name of an account that has permissions to access the target database, and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
   + For **Password**, type the password associated with the user account you entered\.

1. \(Optional\) Choose **Validate connection** to verify your connection information is correct\.

1. Choose **Create data source**\.
**Note**  
Amazon QuickSight automatically secures connections to Amazon RDS instances and Amazon Redshift clusters by using Secure Sockets Layer \(SSL\)\. You don't need to do anything to enable this\.

1. Go to [Step 2: Create a Database Data Set and an Analysis](#step-2-create-database-data-set-and-analysis)\.

### Your Amazon QuickSight Account Does Not Have Autodiscovered AWS Data Sources<a name="step-1-connect-to-data-source-no-autodiscover"></a>

If you don't have any autodiscovered AWS data sources, use the following procedure:

1. Check [Data Source Limits](data-source-limits.md) to make sure your target table or query doesn't exceed data source limits\.

1. Confirm that the database credentials you plan to use have appropriate permissions as described in [Required Permissions for Database Credentials](required-permissions.md)\. 

1. Make sure you have configured the cluster or instance for Amazon QuickSight access by following the instructions in [Network and Database Configuration Requirements](configure-access.md)\.

1. On the Amazon QuickSight start page, choose **Manage data**\.

1. On the **Your Data Sets** page, choose **New data set**\.

1. In the **FROM NEW DATA SOURCES** section of the **Create a Data Set** page, choose the **Redshift Manual connect** icon if you want to connect to an Amazon Redshift cluster in another region or associated with a different AWS account, or choose the appropriate database management system icon to connect to an instance of Amazon Aurora, MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL\.

1. Enter the connection information for the data source, as follows:
   + For **Data source name**, type a name for the data source\.
   + For **Database server**, type or paste one of the following values:
     + For an Amazon Redshift cluster or Amazon RDS instance, type the endpoint of the cluster or instance without the port number\. For example, if the endpoint value is **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com:1234**, then type **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com**\. You can get the endpoint value from the **Endpoint** field on the cluster or instance detail page in the AWS console\.
     + For an Amazon EC2 instance of MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL, type the public DNS\. You can get the public DNS value from the **Public DNS** field on the instance detail pane in the EC2 console\.
     + For a non–Amazon EC2 instance of MariaDB, Microsoft SQL Server, MySQL, or PostgreSQL, type the host name or public IP address of the database server\.
   + For **Port**, type the port that the cluster or instance uses for connections\.
   + For **Database name**, type the name of the database that you want to use\.
   + For **Username**, type the user name of an account that has permissions to access the target database and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
   + For **Password**, type the password associated with the user account you entered\.

1. \(Optional\) If you are connecting to anything other than an Amazon Redshift cluster and you ***don't*** want a secured connection, uncheck **Enable SSL**\. *We strongly recommend leaving this checked*, as an unsecured connection can be open to tampering\. For more information on how the target instance uses Secure Sockets Layer \(SSL\) to secure connections, refer to the documentation for that database management system\.

   Amazon QuickSight automatically secures connections to Amazon Redshift clusters by using SSL\. You don't need to do anything to enable this\.

1. \(Optional\) Choose **Validate connection** to verify your connection information is correct\.

1. Choose **Create data source**\.

1. Go to [Step 2: Create a Database Data Set and an Analysis](#step-2-create-database-data-set-and-analysis)\.

## Step 2: Create a Database Data Set and an Analysis<a name="step-2-create-database-data-set-and-analysis"></a>

Complete the following procedure to create a data set and an analysis:

1. For **Schema: contain sets of tables**, choose **Select** and then choose a schema\. Note that in some cases where there is only a single schema in the database, that schema will be automatically chosen and the schema selection option won't be displayed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/select-schema.png)

1. Choose a table and then choose **Select**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/select-table.png)

1. Choose the **Import to SPICE for quicker analytics** radio button and then create an analysis by choosing **Visualize**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/spice-or-query2.png)

## Step 3: Create a Visual<a name="step-3-create-database-visual"></a>

Next, create a visual\.

In the **Fields list** pane of the analysis page, choose the fields you want to use\.

Amazon QuickSight creates the visual, using AutoGraph to determine the most appropriate visual type for the fields you selected\. For more information about AutoGraph, see [Using AutoGraph](autograph.md)\. For more information about modifying the visual, see [Working with Amazon QuickSight Visuals](working-with-visuals.md)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/visual-fields1.png)