# Creating a Data Source Using Apache Spark<a name="create-a-data-source-spark"></a>

You can connect directly to Apache Spark using Amazon QuickSight, or you can connect to Spark through Spark SQL\. Using the results of queries, or direct links to tables or views, you create data sources in Amazon QuickSight\. You can either directly query your data through Spark, or you can import the results of your query into [SPICE](welcome.md#spice)\.

Before you use Amazon QuickSight with Spark products, you must configure Spark for Amazon QuickSight\. 

Amazon QuickSight requires your Spark server to be secured and authenticated using LDAP, which is available to Spark version 2\.0 or later\. If Spark is configured to allow unauthenticated access, Amazon QuickSight refuses the connection to the server\. To use Amazon QuickSight as a Spark client, you must configure LDAP authentication to work with Spark\. 

The Spark documentation contains information on how to set this up\. To start, you need to configure it to enable front\-end LDAP authentication over HTTPS\. For general information on Spark, see [the Apache Spark website](http://spark.apache.org/)\. For information specifically on Spark and security, see [Spark security documentation](http://spark.apache.org/docs/latest/security.html)\. 

To make sure that you have configured your server for Amazon QuickSight access, follow the instructions in [Network and Database Configuration Requirements](configure-access.md)\.