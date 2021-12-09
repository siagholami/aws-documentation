--------

--------

# DataSourceSyncJobMetrics<a name="API_DataSourceSyncJobMetrics"></a>

Maps a batch delete document request to a specific data source sync job\. This is optional and should only be supplied when documents are deleted by a connector\.

## Contents<a name="API_DataSourceSyncJobMetrics_Contents"></a>

 **DocumentsAdded**   <a name="Kendra-Type-DataSourceSyncJobMetrics-DocumentsAdded"></a>
The number of documents added from the data source up to now in the data source sync\.  
Type: String  
Pattern: `(([1-9][0-9]*)|0)`   
Required: No

 **DocumentsDeleted**   <a name="Kendra-Type-DataSourceSyncJobMetrics-DocumentsDeleted"></a>
The number of documents deleted from the data source up to now in the data source sync run\.  
Type: String  
Pattern: `(([1-9][0-9]*)|0)`   
Required: No

 **DocumentsFailed**   <a name="Kendra-Type-DataSourceSyncJobMetrics-DocumentsFailed"></a>
The number of documents that failed to sync from the data source up to now in the data source sync run\.  
Type: String  
Pattern: `(([1-9][0-9]*)|0)`   
Required: No

 **DocumentsModified**   <a name="Kendra-Type-DataSourceSyncJobMetrics-DocumentsModified"></a>
The number of documents modified in the data source up to now in the data source sync run\.  
Type: String  
Pattern: `(([1-9][0-9]*)|0)`   
Required: No

 **DocumentsScanned**   <a name="Kendra-Type-DataSourceSyncJobMetrics-DocumentsScanned"></a>
The current number of documents crawled by the current sync job in the data source\.  
Type: String  
Pattern: `(([1-9][0-9]*)|0)`   
Required: No

## See Also<a name="API_DataSourceSyncJobMetrics_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DataSourceSyncJobMetrics) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DataSourceSyncJobMetrics) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DataSourceSyncJobMetrics) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DataSourceSyncJobMetrics) 