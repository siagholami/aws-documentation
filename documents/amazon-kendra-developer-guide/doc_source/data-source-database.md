--------

--------

# Using a database data source<a name="data-source-database"></a>

You can index documents stored in a database using a database data source\. After you provided connection information for the database, Amazon Kendra connects and indexes documents\. Amazon Kendra supports the following databases:
+ Amazon Aurora MySQL
+ Amazon Aurora PostgreSQL
+ Amazon RDS for MySQL
+ Amazon RDS for PostgreSQL

Before you create a database data source, you need to create an index and create custom fields in the index for the data from the database\. For more information, see [Creating an index](create-index.md) and [Mapping data source fields](field-mapping.md)\.

To use a database data source, you need to identify the following:
+  Connection information such as credentials for the database stored in AWS Secrets Manager, the host name, port, and name of the data table that contains the document data\. For PostgreSQL the data table must be a public table\.
+ Column information such as the names of the columns in the data table that contain the document data and document ID, one to five columns to detect if a document has changed, and optional data table columns that map to custom index fields\. You can map any of the Amazon Kendra reserved field names to a table column\. 
+ Optionally, VPC information to connect to the database server\. For more information about using a VPC, see [Configuring Amazon Kendra to use a VPC](vpc-configuration.md)\. If you are using a database data source with a VPC, the subnets provided in the VPC configuration must be in one of the following Availability Zone IDs:
  + US West \(Oregon\) – usw2\-az1, usw2\-az2, usw2\-az3
  + US East \(N\. Virginia\) – use1\-az1, use1\-az2, use1\-az4
  + EU \(Ireland\) – euw1\-az1, uew1\-az2, euw1\-az3

Database configuration provides the information required to connect to your database server\. The host and port tell Amazon Kendra where to find the database server on the internet\. The database name and table name tell Amazon Kendra where to find the document data on the database server\.

To enable Amazon Kendra to access your documents, you must specify a user that has read access to the table that contains the documents\. Amazon Kendra requires credentials for the user to access the database\. You provide these credentials using AWS Secrets Manager\. Once you have created the secret, you provide the Amazon Resource Name \(ARN\) of the secret to Amazon Kendra\. The secret must contain the user name and password that Amazon Kendra uses to access the database in a JSON structure\. The secret may contain additional information, but Amazon Kendra uses only the user name and password\. The following is the minimum JSON structure that must be in the secret:

```
{
    "username": "user name",
    "password": "password"
}
```

The secret can contain more information\. However, Amazon Kendra ignores other fields\. For more information, see [ What Is AWS Secrets Manager ](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager User Guide*\.

The following example shows a database configuration\.

```
"DatabaseConfiguration": {
    "ConnectionConfiguration": {
        "DatabaseHost": "host.subdomain.domain.tld",
        "DatabaseName": "DocumentDatabase",
        "DatabasePort": 3306,
        "SecretArn": "arn:aws:secretmanager:region:account ID:secret/secret name",
        "TableName": "DocumentTable"
    }
}
```

**Note**  
The `DatabaseHost` field should be the Amazon Relational Database Service \(Amazon RDS\) instance endpoint for the database\. Don't use the cluster endpoint\.

By default, Amazon Kendra uses SQL identifiers—such as database name, table name, and column names—exactly as set in the database data source configuration\. Amazon Kendra doesn't enclose identifiers in quotation marks or change the case\.

A PostgreSQL database always changes unquoted table and column names to lowercase\. For example, if Amazon Kendra is configured to use the table name **SAMPLE\_TABLE**, PostgreSQL converts it internally to **sample\_table**\. If a table or column name contains uppercase letters, the SQL query won’t match the correct columns or table because PostgreSQL internally changes them to lowercase\.

To configure Amazon Kendra to enclose the SQL identifiers for table and column names in quotation marks \("\), set the `QueryIdentifiersEnclosingOption` field to `DOUBLE_QUOTES` inside the[SqlConfiguration](API_SqlConfiguration.md) parameter of the [CreateDataSource](API_CreateDataSource.md) operation\. When you set this parameter, the SQL identifiers sent to databases are enclosed in quotation marks so that PostgreSQL doesn't change SQL identifiers to lowercase\. If you enclose identifiers in quotation marks when you are using MySQL, you must set the `ansi_quotes` option in the MySQL database\.

You add document table information to an index by mapping table columns to index fields\. There are two types of information that you add\. The first is one to five columns that Amazon Kendra uses to determine if a document has changed since the last time that an index update was run\. For example, if you have columns in your table named `LastUpdateDate` and `LastUpdateTime`, you can tell Amazon Kendra to use them to determine if a document was updated\.

The second type of information about columns is to map some or all of the columns in your table to index fields\. For example, you can map a column that contains the document abstract to an index field\. If you mark the field searchable, Amazon Kendra uses the contents of the field when determining if a document matches the query\. For more information about the attributes that you can assign a custom field, see [Mapping data source fields](field-mapping.md)\. 

After you map the columns, you can also use the index fields as custom attributes to filter the results of a query\. For more information, see [Filtering queries](filtering.md)\.

You must specify the `DocumentDataColumnName` and `DocumentIdColumnName` fields\. The column mapped to the `DocumentIdColumnName` field must be an integer column\.

The following example shows a simple column configuration for a database data source\.

```
"ColumnConfiguration": {
    "ChangeDetectingColumns": [
        "LastUpdateDate",
        "LastUpdateTime"
    ],
    "DocumentDataColumnName": "TextColumn",
    "DocumentIdColumnName": "IdentifierColumn",
    "DocoumentTitleColumnName": "TitleColumn",
    "FieldMappings": [
        {
            "DataSourceFieldName": "AbstractColumn",
            "IndexFieldName": "Abstract"
        }
    ]
}
```