# Editing a Data Source<a name="edit-a-data-source"></a>

You can edit an existing database data source to update the connection information, such as the server name or the user credentials\. You can also edit an existing Amazon Athena data source to update the data source name\. You can't edit Amazon S3 or Salesforce data sources\.

## Editing a Database Data Source<a name="edit-a-database-data-source"></a>

Use the following procedure to edit a database data source\.

1. In the **FROM EXISTING DATA SOURCES** section of the **Create a Data Set** page, choose a database data source\.

1. Choose **Edit Data Source**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/edit-data-source.png)

1. Modify the data source information\.
   + If you are editing an autodiscovered database data source, you can modify any of the following settings:
     + For **Data source name**, type a name for the data source\.
     + For **Instance ID**, choose the name of the instance or cluster you want to connect to from the list provided\.
     + **Database name** shows the default database for the **Instance ID** cluster or instance\. If you want to use a different database on that cluster or instance, type its name\.
     + For **UserName**, type the user name of an account that has permissions to access the target database and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
     + For **Password**, type the password associated with the user account you entered\.
   + If you are editing an external database data source, you can modify any of the following settings:
     + For **Data source name**, type a name for the data source\.
     + For **Database server**, type or paste one of the following values:
       + For an Amazon Redshift cluster, type the endpoint of the cluster without the port number\. For example, if the endpoint value is **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com:1234**, then type **clustername\.1234abcd\.us\-west\-2\.redshift\.amazonaws\.com**\. You can get the endpoint value from the **Endpoint** field on the cluster detail page in the Amazon Redshift console\.
       + For an Amazon EC2 instance of PostgreSQL, MySQL, or SQL Server, type the public DNS\. You can get the public DNS value from the **Public DNS** field on the instance detail pane in the EC2 console\.
       + For a non\-Amazon EC2 instance of PostgreSQL, MySQL, or SQL Server, type the hostname or public IP address of the database server\.
     + For **Port**, type the port that the cluster or instance uses for connections\.
     + For **Database name**, type the name of the database that you want to use\.
     + For **UserName**, type the user name of an account that has permissions to access the target database and also to read \(perform a `SELECT` statement on\) any tables in that database that you want to use\.
     + For **Password**, type the password associated with the user account you entered\.

1. Choose **Validate connection**\.

1. If the connection validates, choose **Update data source**\. If not, correct the connection information and try validating again\.

1. If you want to create a new data set using the updated data source, proceed with the instructions at [Creating a Data Set from a Database](create-a-database-data-set.md)\. Otherwise, close the **Choose your table** dialog\.

## Editing an Athena Data Source<a name="edit-an-athena-data-source"></a>

Use the following procedure to edit an Athena data source\.

1. In the **FROM EXISTING DATA SOURCES** section of the **Create a Data Set** page, choose an Athena data source\.

1. Choose **Edit Data Source**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/edit-data-source-athena.png)

1. For **Data source name**, type a new name\.

1. Choose **Update data source**\.

1. If you want to create a new data set using the updated data source, proceed with the instructions at [Creating a Data Set Using Amazon Athena Data](create-a-data-set-athena.md)\. Otherwise, close the **Choose your table** dialog\.