# Required Permissions for Database Credentials<a name="required-permissions"></a>

To connect to a database, you must provide a user name and password\. The user account identified by these credentials must have `SELECT` permissions on some system tables in order to allow Amazon QuickSight to do things like discover table schemas and estimate table size\. 

The following table identifies the tables that the user account must have `SELECT` permissions on, depending on the type of database you are connecting to\. These requirements apply for all database instances you connect to, regardless of their environment—that is, whether they are on\-premises, in Amazon RDS, in Amazon EC2, or elsewhere\.


****  

| Instance Type | Tables | 
| --- | --- | 
|  **Amazon Aurora**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 
|  **Amazon Redshift**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 
|  **MariaDB**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 
|  **Microsoft SQL Server**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 
|  **MySQL**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 
|  **PostgreSQL**   |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/quicksight/latest/user/required-permissions.html)  | 

**Note**  
 If you are using MySQL or PostgreSQL, verify that you are connecting from an allowed host or IP address\. For more detail, see [Database Configuration Requirements for Self\-Administered Instances](configure-access.md#database-configuration-requirements)\. 