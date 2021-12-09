# Creating Data Sets from New Database Data Sources<a name="creating-database-data-sets"></a>

You can use a variety of database data sources to provide data to Amazon QuickSight\. This includes Amazon RDS instances and Amazon Redshift clusters\. It also includes MariaDB, Microsoft SQL Server, MySQL, and PostgreSQL instances in your organization, Amazon EC2, or similar environments\.

When creating a new database data set, you can select one table, join several tables, or create a SQL query to retrieve the data that you want\. You can also change whether the data set uses a direct query or instead stores data in [SPICE](welcome.md#spice)\.

When you create a data set based on an AWS service like Amazon RDS, Amazon Redshift, or Amazon EC2, data transfer charges might apply when consuming data from that source\. Those charges might also vary depending on whether that AWS resource is in the home AWS Region that you chose for your Amazon QuickSight account\. For details on pricing, see the pricing page for the service in question\.

**Topics**
+ [Required Permissions for Database Credentials](required-permissions.md)
+ [Network and Database Configuration Requirements](configure-access.md)
+ [Creating a Data Set from a Database](create-a-database-data-set.md)