# Deleting multiple objects per request<a name="DeletingMultipleObjects"></a>

**Topics**
+ [Deleting multiple objects using the AWS SDK for Java](DeletingMultipleObjectsUsingJava.md)
+ [Deleting multiple objects using the AWS SDK for \.NET](DeletingMultipleObjectsUsingNetSDK.md)
+ [Deleting multiple objects using the AWS SDK for PHP](DeletingMultipleObjectsUsingPHPSDK.md)
+ [Deleting multiple objects using the REST API](DeletingMultipleObjectsUsingREST.md)

Amazon S3 provides the Multi\-Object Delete API \(see [Delete \- Multi\-Object Delete](https://docs.aws.amazon.com/AmazonS3/latest/API/multiobjectdeleteapi.html)\), which enables you to delete multiple objects in a single request\. The API supports two modes for the response: verbose and quiet\. By default, the operation uses verbose mode\. In verbose mode, the response includes the result of the deletion of each key that is specified in your request\. In quiet mode, the response includes only keys for which the delete operation encountered an error\. If all keys are successfully deleted when you're using quiet mode, Amazon S3 returns an empty response\.

To learn more about object deletion, see [Deleting objects](DeletingObjects.md)\. 

You can use the REST API directly or use the AWS SDKs\. 