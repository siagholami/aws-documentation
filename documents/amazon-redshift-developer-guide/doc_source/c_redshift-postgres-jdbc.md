# Amazon Redshift and PostgreSQL JDBC and ODBC<a name="c_redshift-postgres-jdbc"></a>

 Because Amazon Redshift is based on PostgreSQL, we previously recommended using JDBC4 Postgresql driver version 8\.4\.703 and psqlODBC version 9\.x drivers; if you are currently using those drivers, we recommend moving to the new Amazon Redshift–specific drivers going forward\. For more information about drivers and configuring connections, see [JDBC and ODBC Drivers for Amazon Redshift](https://docs.aws.amazon.com/redshift/latest/mgmt/configuring-connections.html#connecting-drivers) in the *Amazon Redshift Cluster Management Guide*\.

To avoid client\-side out\-of\-memory errors when retrieving large data sets using JDBC, you can enable your client to fetch data in batches by setting the JDBC fetch size parameter\. For more information, see [Setting the JDBC fetch size parameter](queries-troubleshooting.md#set-the-JDBC-fetch-size-parameter)\.

Amazon Redshift does not recognize the JDBC maxRows parameter\. Instead, specify a [LIMIT](r_ORDER_BY_clause.md#order-by-clause-limit) clause to restrict the result set\. You can also use an [OFFSET](r_ORDER_BY_clause.md#order-by-clause-offset) clause to skip to a specific starting point in the result set\.