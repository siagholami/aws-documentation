--------

--------

# Deleting data sources<a name="delete-data-source"></a>

You delete a data source when you want to remove the information contained in the data source from your Amazon Kendra index\. For example, delete a data source when:
+ A data source is incorrectly configured\. Delete the data source, wait for the data source to finish deleting, and then recreate it\.
+ You migrated documents from one data source to another\. Delete the original data source and recreate it in the new location\.
+ You have reached the limit of data sources for an index\. Delete one of the existing data sources and add a new one\. For more information about the number of data sources that you can create, see [Quotas](quotas.md#quota-details)\.

To delete a data source, use the console, the AWS Command Line Interface \(AWS CLI\), or the `DeleteDataSource` operation\. Deleting a data source removes all of the information about the data source from the index\. If you only want to stop synching the data source, change the synchronization schedule for the data source to "run on demand"\.

**To delete a data source \(console\)**

1. Sign in to the AWS Management Console and open the Amazon Kendra console at [https://console\.aws\.amazon\.com/kendra/](https://console.aws.amazon.com/kendra/)\.

1. From the left menu, choose **Indexes**, and then choose the index that contains the data source to delete\.

1. From the left menu, choose **Data sources**\.

1. Choose the data source to remove\.

1. Choose **Delete** to delete the data source\.

**To delete a data source \(CLI\)**
+ In the AWS Command Line Interface, use the following command\. The command is formatted for Linux and macOS\. If you are using Windows, replace the Unix line continuation character \(\\\) with a caret \(^\)\.

  ```
  aws kendra delete-data-source \
     --id data-source-id \
     --index-id index-id
  ```

When you delete a data source, Amazon Kendra removes all of the stored information about the data source\. Amazon Kendra removes all of the document data stored in the index, and all run histories and metrics associated with the data source\. Deleting a data source does not remove the original documents from your storage\.

Deleting a data source is an asynchronous operation\. When you start deleting a data source, the data source status changes to `DELETING`\. It remains in the `DELETING` state until the information related to the data source is removed\. After the data source is deleted, it no longer appears in the results of a call to the [ListDataSources](API_ListDataSources.md) operation\. If you call the [DescribeDataSource](API_DescribeDataSource.md) operation with the deleted data source's identifier, you receive a `ResourceNotFound` exception\.

Amazon Kendra releases the resources for a data source as soon as you call the `DeleteDataSource` operation or choose to delete the data source in the console\. If you are deleting the data source to reduce the number of data sources below your limit, you can create a new data source right away\.

If you are deleting a data source and then creating another data source to the document data, wait for the first data source to be deleted before you sync the new data source\.

You can delete a data source that is in the process of syncing with Amazon Kendra\. The sync is stopped and the data source is removed\. If you attempt to start a sync when the data source is being deleted, you get a `ConflictException` exception\.

You can't delete a data source if the associated index is in the `DELETING` state\. Deleting an index deletes all of the data sources for the index\. You can start deleting an index while a data source for that index is in the `DELETING` state\.

If you have two data sources pointing to the same documents, such as two data sources pointing to the same S3 bucket, data in the index might be  inconsistentwhen one of the data sources is deleted\. When two data sources reference the same documents, only one copy of the document data is stored in the index\. Removing one data source removes the index data for the documents\. The other data source is not aware that the documents have been removed, so it won't correctly re\-index the documents the next time it syncs\. When you have two data sources pointing to the same document location, you should delete both data sources and then recreate one\.