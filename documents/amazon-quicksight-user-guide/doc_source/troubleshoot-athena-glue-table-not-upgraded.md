# Table Incompatible When Using AWS Glue with Athena in Amazon QuickSight<a name="troubleshoot-athena-glue-table-not-upgraded"></a>

If you are getting errors when using AWS Glue tables in Athena with Amazon QuickSight, it might be because you're missing some metadata\. Follow these steps to find out if your tables don't have the `TableType` attribute that Amazon QuickSight needs for the Athena connector to work\. Usually, the metadata for these tables wasn't migrated to the AWS Glue Data Catalog\. For more information, see [Upgrading to the AWS Glue Data Catalog Step\-by\-Step](https://docs.aws.amazon.com//athena/latest/ug/glue-upgrade.html) in the* AWS Glue Developer Guide\.*

If you don't want to migrate to the AWS Glue data catalog at this time, you have two options\. You can recreate each AWS Glue table through the AWS Glue Management Console\. Alternatively, you can use the AWS CLI scripts listed in the following procedure to identify and update tables with missing `TableType` attributes\.

If you prefer to use the CLI to do this, use the following procedure to help you design your scripts\.

1. Use the CLI to learn which AWS Glue tables have no `TableType` attributes\.

   ```
   aws glue get-tables --database-name <your_datebase_name>;
   ```

   For example, you can run the following command in the CLI\.

   ```
   aws glue get-table --database-name "test_database" --name "table_missing_table_type"
   ```

   Following is a sample of what the output looks like\. You can see that the table `"table_missing_table_type"` doesn't have the `TableType` attribute declared\.

   ```
   {
       "TableList": [
           {
               "Retention": 0,
               "UpdateTime": 1522368588.0,
               "PartitionKeys": [
                   {
                       "Name": "year",
                       "Type": "string"
                   },
                   {
                       "Name": "month",
                       "Type": "string"
                   },
                   {
                       "Name": "day",
                       "Type": "string"
                   }
               ],
               "LastAccessTime": 1513804142.0,
               "Owner": "owner",
               "Name": "table_missing_table_type",
               "Parameters": {
                   "delimiter": ",",
                   "compressionType": "none",
                   "skip.header.line.count": "1",
                   "sizeKey": "75",
                   "averageRecordSize": "7",
                   "classification": "csv",
                   "objectCount": "1",
                   "typeOfData": "file",
                   "CrawlerSchemaDeserializerVersion": "1.0",
                   "CrawlerSchemaSerializerVersion": "1.0",
                   "UPDATED_BY_CRAWLER": "crawl_date_table",
                   "recordCount": "9",
                   "columnsOrdered": "true"
               },
               "StorageDescriptor": {
                   "OutputFormat": "org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat",
                   "SortColumns": [],
                   "StoredAsSubDirectories": false,
                   "Columns": [
                       {
                           "Name": "col1",
                           "Type": "string"
                       },
                       {
                           "Name": "col2",
                           "Type": "bigint"
                       }
                   ],
                   "Location": "s3://myAthenatest/test_dataset/",
                   "NumberOfBuckets": -1,
                   "Parameters": {
                       "delimiter": ",",
                       "compressionType": "none",
                       "skip.header.line.count": "1",
                       "columnsOrdered": "true",
                       "sizeKey": "75",
                       "averageRecordSize": "7",
                       "classification": "csv",
                       "objectCount": "1",
                       "typeOfData": "file",
                       "CrawlerSchemaDeserializerVersion": "1.0",
                       "CrawlerSchemaSerializerVersion": "1.0",
                       "UPDATED_BY_CRAWLER": "crawl_date_table",
                       "recordCount": "9"
                   },
                   "Compressed": false,
                   "BucketColumns": [],
                   "InputFormat": "org.apache.hadoop.mapred.TextInputFormat",
                   "SerdeInfo": {
                       "Parameters": {
                          "field.delim": ","
                       },
                       "SerializationLibrary": "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe"
                   }
               }
           }
       ]
   }
   ```

1. Edit the table definition in your editor to add `"TableType": "EXTERNAL_TABLE"` to the table definition, as shown in the following example\.

   ```
   {
    "Table": {
        "Retention": 0,
        "TableType": "EXTERNAL_TABLE",
        "PartitionKeys": [
            {
                "Name": "year",
                "Type": "string"
            },
            {
                "Name": "month",
                "Type": "string"
            },
            {
                "Name": "day",
                "Type": "string"
            }
        ],
        "UpdateTime": 1522368588.0,
        "Name": "table_missing_table_type",
        "StorageDescriptor": {
            "BucketColumns": [],
            "SortColumns": [],
            "StoredAsSubDirectories": false,
            "OutputFormat": "org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat",
            "SerdeInfo": {
                "SerializationLibrary": "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe",
                "Parameters": {
                    "field.delim": ","
                }
            },
            "Parameters": {
                "classification": "csv",
                "CrawlerSchemaSerializerVersion": "1.0",
                "UPDATED_BY_CRAWLER": "crawl_date_table",
                "columnsOrdered": "true",
                "averageRecordSize": "7",
                "objectCount": "1",
                "sizeKey": "75",
                "delimiter": ",",
                "compressionType": "none",
                "recordCount": "9",
                "CrawlerSchemaDeserializerVersion": "1.0",
                "typeOfData": "file",
                "skip.header.line.count": "1"
            },
            "Columns": [
                {
                    "Name": "col1",
                    "Type": "string"
                },
                {
                    "Name": "col2",
                    "Type": "bigint"
                }
            ],
            "Compressed": false,
            "InputFormat": "org.apache.hadoop.mapred.TextInputFormat",
            "NumberOfBuckets": -1,
            "Location": "s3://myAthenatest/test_date_part/"
        },
        "Owner": "owner",
        "Parameters": {
            "classification": "csv",
            "CrawlerSchemaSerializerVersion": "1.0",
            "UPDATED_BY_CRAWLER": "crawl_date_table",
            "columnsOrdered": "true",
            "averageRecordSize": "7",
            "objectCount": "1",
            "sizeKey": "75",
            "delimiter": ",",
            "compressionType": "none",
            "recordCount": "9",
            "CrawlerSchemaDeserializerVersion": "1.0",
            "typeOfData": "file",
            "skip.header.line.count": "1"
        },
        "LastAccessTime": 1513804142.0
    }
   }
   ```

1. You can adapt the following script to update the table input, so that it includes the `TableType` attribute\.

   ```
   aws glue update-table --database-name <your_datebase_name> --table-input <updated_table_input>
   ```

   The following shows an example\. 

   ```
   aws glue update-table --database-name test_database --table-input '
   {
           "Retention": 0,
           "TableType": "EXTERNAL_TABLE",
           "PartitionKeys": [
               {
                   "Name": "year",
                   "Type": "string"
               },
               {
                   "Name": "month",
                   "Type": "string"
               },
               {
                   "Name": "day",
                   "Type": "string"
               }
           ],
           "Name": "table_missing_table_type",
           "StorageDescriptor": {
               "BucketColumns": [],
               "SortColumns": [],
               "StoredAsSubDirectories": false,
               "OutputFormat": "org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat",
               "SerdeInfo": {
                   "SerializationLibrary": "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe",
                   "Parameters": {
                       "field.delim": ","
                   }
               },
               "Parameters": {
                   "classification": "csv",
                   "CrawlerSchemaSerializerVersion": "1.0",
                   "UPDATED_BY_CRAWLER": "crawl_date_table",
                   "columnsOrdered": "true",
                   "averageRecordSize": "7",
                   "objectCount": "1",
                   "sizeKey": "75",
                   "delimiter": ",",
                   "compressionType": "none",
                   "recordCount": "9",
                   "CrawlerSchemaDeserializerVersion": "1.0",
                   "typeOfData": "file",
                   "skip.header.line.count": "1"
               },
               "Columns": [
                   {
                       "Name": "col1",
                       "Type": "string"
                   },
                   {
                       "Name": "col2",
                       "Type": "bigint"
                   }
               ],
               "Compressed": false,
               "InputFormat": "org.apache.hadoop.mapred.TextInputFormat",
               "NumberOfBuckets": -1,
               "Location": "s3://myAthenatest/test_date_part/"
           },
           "Owner": "owner",
           "Parameters": {
               "classification": "csv",
               "CrawlerSchemaSerializerVersion": "1.0",
               "UPDATED_BY_CRAWLER": "crawl_date_table",
               "columnsOrdered": "true",
               "averageRecordSize": "7",
               "objectCount": "1",
               "sizeKey": "75",
               "delimiter": ",",
               "compressionType": "none",
               "recordCount": "9",
               "CrawlerSchemaDeserializerVersion": "1.0",
               "typeOfData": "file",
               "skip.header.line.count": "1"
           },
           "LastAccessTime": 1513804142.0
       }'
   ```