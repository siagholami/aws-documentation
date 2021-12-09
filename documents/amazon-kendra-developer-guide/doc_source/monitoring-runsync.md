--------

--------

# Monitoring your index \(Console\)<a name="monitoring-runsync"></a>

Use the Amazon Kendra console to monitor the state of indexes and data sources\. You can use this information to track the size and storage requirements of your index and to monitor the progress and success of synchronization between your index and data sources\.

**To view index metrics \(Console\)**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index to view\.

1. Scroll the screen to see the index metrics\.

You can see the following metrics about your index\.
+ **Document count** – The total number of documents indexed\. This includes all documents from all data sources\. Use this metric to determine if you need to purchase more or fewer storage units for your index\.  
![\[The Amazon Kendra console showing the total document count for an index.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/IndexDocumentCount.png)
+ **Queries per second** – The number of index queries that are requested each second\. Use this metric to determine if you need to purchase more or fewer query units for your index\.  
![\[The Amazon Kendra console showing the average queries per second for an index.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/IndexQueriesPerSecond.png)

To monitor the progress and success of synchronization between your index and a data source, use the Amazon Kendra console\. Use this information to help determine the health of your data source\.

**To view synchronization metrics \(Console\)**

1. Sign into the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/home](https://console.aws.amazon.com/kendra/home)\.

1. From the list of indexes, choose the index to view synchronization metrics for\.

1. From the left menu, choose **Data sources**\.

1. From the list of data sources, choose the data source to view\.

1. Scroll the screen to see the sync run metrics\.

You can see the following information\.
+ **Sync run history** – Statistics about the synchronization run, including the start and end time, the number of documents added, deleted, and failed\. If the sync run fails, there is a link to CloudWatch Logs with more information\. Choose the settings icon in the upper left to change the columns that are displayed in the history\. Use this information to determine the general health of your data source\.  
![\[The Amazon Kendra console showing the sync run history for a data source.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/SyncRunHistory.png)
+ **Document count** – The total number of documents indexed from this data source\. This is the total of all documents added to the data source minus the total of all documents deleted from the data source\. Use this information to determine how many documents from this data source are included in the index\.  
![\[The Amazon Kendra console showing the total document count for a data source.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/DocumentCount.png)
+ **Document scans** – The total number of documents scanned during the sync run\. This includes all documents in the data source, including those added, updated, deleted, or unchanged\. Use this information to determine if Amazon Kendra is scanning all of the documents in the data source\. The number of documents scanned affects the amount charged for the service\.  
![\[The Amazon Kendra console showing the the number of documents scanned for a data source.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/DocumentScans.png)
+ **Average sync run time in minutes** – The average length of time that it takes for a sync run to complete\. The time that it takes to sync a data source affects the amount charged for the service\.  
![\[The Amazon Kendra console showing the the average run time for a data source sync.\]](http://docs.aws.amazon.com/kendra/latest/dg/images/AverageRunTime.png)