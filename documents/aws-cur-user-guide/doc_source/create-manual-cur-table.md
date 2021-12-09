# Creating a Cost and Usage Reports Status Table<a name="create-manual-cur-table"></a>

AWS refreshes your AWS CUR multiple times a day\. There isn't a way for Athena to tell when AWS is in the process of refreshing your report, which can lead to query results with a combination of old and new data\. To mitigate this, create a table to track whether AWS is refreshing your Cost and Usage Reports and query that table to see if AWS is refreshing your data\. You only need to create this table once\. After that, AWS keeps the table up to date\.<a name="create-refresh-table"></a>

**To create your refresh table**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. In the **New query 1** query pane, paste the following SQL\. 

   ```
   CREATE EXTERNAL TABLE IF NOT EXISTS cost_and_usage_data_status(
     status STRING)
   ROW FORMAT SERDE
     'org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe'
   WITH SERDEPROPERTIES (
    'serialization.format' = '1'
   )
   LOCATION 's3://{S3_Bucket_Name}/{Report_Key}/cost_and_usage_data_status/'
   ```

1. Choose **Run query**\.

To check whether AWS is refreshing your data, use the Athena console to run the following SQL query\.

```
select status from cost_and_usage_data_status 
```