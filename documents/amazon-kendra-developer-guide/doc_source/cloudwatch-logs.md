--------

--------

# Monitoring Amazon Kendra with Amazon CloudWatch Logs<a name="cloudwatch-logs"></a>

Amazon Kendra uses Amazon CloudWatch Logs to give you insight into the operation of your data sources\. Amazon Kendra logs process details for the documents that as they are indexed\. It logs errors from your data source that occur while your documents are being indexed\. You use CloudWatch Logs to monitor, store and access the log files\.

CloudWatch Logs stores log events in a log stream that is part of a log group\. Amazon Kendra uses these features as follows:
+ Log groups – Amazon Kendra stores all of your log streams in a single log group for each index\. Amazon Kendra creates the log group when the index is created\. The log group identifier always begins with "aws/kendra/"\.
+ Log stream – creates a new data source log stream in the log group for each index synchronization job that you run\. It also creates a new document log stream when a stream reaches approximately 500 entries\. 
+ Log entries – Amazon Kendra creates a log entry in the log stream as it indexes documents\. Each entry provides information about processing the document or any errors that are encountered\.

For more information about using CloudWatch Logs, see [ What Is Amazon Cloud Watch Logs](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/WhatIsCloudWatchLogs.html) in the *Amazon Cloud Watch Logs User Guide*\. 

Amazon Kendra creates two types of log streams:
+ [data source log streams](#data-source-log-stream)
+ [Document log streams](#document-log-stream)

## data source log streams<a name="data-source-log-stream"></a>

Data source log streams publish entries about your index synchronization jobs\. Each synchronization job creates a new log stream that it uses to publish entries\. The log stream name is:

```
data source id/YYYY-MM-DD-HH/data source sync job ID
```

A new log stream is created for each synchronization job run\.

There are three types of log messages published to a data source log stream:
+ A log message for a document that failed to be sent for indexing\. The following is an example of this message for a document in an S3 data source:

  ```
  {
      "DocumentId": "document ID",
      "S3Path": "s3://bucket/prefix/object",
      "Message": "Failed to ingest document via BatchPutDocument.",
      "ErrorCode": "InvalidRequest",
      "ErrorMessage": "No document metadata configuration found for document attribute key  city."
  }
  ```
+ A log message for a document that failed to be sent for deletion\. The following is an example of this message:

  ```
  {
      "DocumentId": "document ID",
      "Message": "Failed to delete document via BatchDeleteDocument.",
      "ErrorCode": "InvalidRequest",
      "ErrorMessage": "Document can't be deleted because it doesn't exist." 
  }
  ```
+ A log message when an invalid metadata file for a document in an Amazon S3 bucket is found\. The following is an example of this message\.

  ```
  {
      "Message": "Found invalid metadata file bucket/prefix/filename.extension.metadata.json."
  }
  ```
+ For SharePoint and database connectors, Amazon Kendra only writes messages to the log stream if a document can't be indexed\. The following is an example of the error message that Amazon Kendra logs\.

  ```
  { 
      "DocumentID": "document ID", 
      "IndexID": "index ID", 
      "SourceURI": "", 
      "CrawlStatus": "FAILED", 
      "ErrorCode": "403", 
      "ErrorMessage": "Access Denied", 
      "DataSourceErrorCode": "403"
  }
  ```

## Document log streams<a name="document-log-stream"></a>

Amazon Kendra logs information about processing documents while the are being indexed\. It logs a set of messages for documents stored in an Amazon S3 data source\. It logs errors only for documents stored in a Microsoft SharePoint or a database data source\.

If the documents were added to the index using the [BatchPutDocument](API_BatchPutDocument.md) operation, the log stream is named as follows:

```
YYYY-MM-DD-HH/UUID
```

If the documents were added to the index using a datasource, the log stream is named as follows:

```
dataSourceId/YYYY-MM-DD-HH/UUID
```

Each log stream contains up to 500 messages\.

If indexing a document fails, this message is output to the log stream:

```
{
    "DocumentId": "document ID",
    "IndexName": "index name",
    "IndexId": "index ID"
    "SourceURI": "source URI"
    "IndexingStatus": "DocumentFailedToIndex",
    "ErrorCode": "400 | 500",
    "ErrorMessage": "message"
}
```