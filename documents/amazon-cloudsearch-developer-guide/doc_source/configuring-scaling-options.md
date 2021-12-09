# Configuring Scaling Options in Amazon CloudSearch<a name="configuring-scaling-options"></a>

A search domain has one or more search instances, each with a finite amount of RAM and CPU resources for indexing data and processing requests\. You can configure scaling options to control the instance type that is used, the number of instances your search index is distributed across \(partition count\), and the number of replicas of each index partition \(replication count\)\. All instances for a domain are always of the same type\.

You can configure the desired instance type, partition count, or replication count for an Amazon CloudSearch domain to:
+ **Increase upload capacity** By default, all search domains start out on a `search.m1.small` instance\. You can increase your domain's document upload capacity by changing the desired instance type\. If you have a large amount of data to upload—for example, when you are initially populating your search domain—you can choose a larger instance type to increase the number of updates that can be submitted in parallel and reduce how long it takes to index your data\. If you are already using the largest instance type, you can increase the desired partition count to further increase upload capacity\. For more information, see [Bulk Uploads](uploading-data.md#bulk-uploads)\. Note that increasing the desired replication count does *not* generally increase a domain's upload capacity\.
+ **Speed up search requests\.** Choosing a larger desired instance type can also speed up search requests\. If you've tuned your requests and still aren't meeting your performance targets, try choosing a larger instance type\. If you are already using the largest instance type, you can increase the desired partition count to further boost query performance\. For more information, see [Tuning Search Request Performance in Amazon CloudSearch](tuning-search.md)\.
+ **Increase search capacity\. **By default, Amazon CloudSearch uses one instance per index partition\. When Amazon CloudSearch scales the domain automatically, it adds replicas based on the resources needed to process the query traffic\. To increase a domain's search capacity, you set the desired replication count\. However, deploying additional instances takes some time\. If you know in advance that you will need additional capacity—for example, before a big launch or announcement—add replicas ahead of time to ensure that your search domain is ready to handle the load\. 
+ **Improve fault tolerance\.** Increasing the desired replication count also improves the domain's fault\-tolerance—if there's a problem with one of the replicas, the others will continue to handle requests while it is being recovered\. However, note that the replicas reside in the same Availability Zone\. If you need to ensure availability of your domain in the event of an Availability Zone service disruption, you should enable the MultiAZ option\. For more information, see [Configuring Availability Options](configuring-availability-options.md)\. 

When you set the desired instance type, desired number of replicas, or desired partition count, Amazon CloudSearch scales your domain as necessary, but will never scale the domain to an instance type that's smaller than the desired type, use fewer replicas than the desired number of replicas, or reduce the partition count below the desired partition count\.

**Note**  
Although initially counterintuitive, Amazon CloudSearch might scale a domain "up" from an `m3.medium` instance to an `m1.small`\. The automatic scaling progression is based on the instance type's available disk space\. From smallest to largest, Amazon CloudSearch uses the following progression: `m3.medium`, `m1.small`, `m3.large`, `m3.xlarge`, `m3.2xlarge`\.

You can change your scaling options at any time\. If your need for additional capacity is temporary, you can prescale your domain by setting the scaling options and then revert the changes after your volume of uploads or queries returns to your domain's steady state\. When you make changes, you need to re\-index your domain, which can take some time for the changes to take effect\. How long it takes to re\-index depends on the amount of data in your index\. You can monitor the domain status to determine when indexing is complete—the status changes from PROCESSING to ACTIVE\. 

**Topics**
+ [Choosing Scaling Options in Amazon CloudSearch](#choosing-scaling-options)
+ [Configuring Scaling Options through the Amazon CloudSearch Console](#configuring-scaling-options-console)
+ [Configuring Scaling Options through the AWS CLI](#configuring-scaling-options-cli)
+ [Configuring Scaling Options through the AWS SDK](#configuring-scaling-options-sdk)

## Choosing Scaling Options in Amazon CloudSearch<a name="choosing-scaling-options"></a>

When you set scaling options for a domain, you make a trade\-off between cost and performance—changing the desired instance type, replication count, and partition count can significantly impact the cost of running your domain\. 

 To determine which instance type to select to handle your upload traffic, monitor your upload performance as you increase the upload rate\. If you start seeing a large number of 504 or 507 errors before you reach your desired upload rate, select a larger instance type\. If you are already on the largest instance type, you can increase the number of partitions to further increase upload capacity\. 

 For datasets of less than 1 GB of data or fewer than one million 1 KB documents, a small search instance should be sufficient\. To upload data sets between 1 GB and 8 GB, we recommend setting the desired instance type to `search.m3.large` before you begin uploading\. For datasets between 8 GB and 16 GB, start with a `search.m3.xlarge`\. For datasets between 16 GB and 32 GB, start with a `search.m3.2xlarge`\. If you have more than 32 GB to upload, select the `search.m3.2xlarge` instance type and increase the desired partition count to accommodate your data set\. Each partition can contain up to 32 GB of data\. Submit a [Service Increase Limit Request](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudsearch-partitions-and-instances) if you need more upload capacity or have more than 500 GB to index\. 

To determine how many replicas you need to handle a given query volume, do some testing using a sample of your expected queries at the rate you need to support\. Keep in mind that query performance depends heavily on the type of queries being processed\. In general, searches that return a large volume of hits and complex structured queries are more resource intensive than simple text queries that match a small percentage of the documents in your search domain\. If you expect a high volume of complex queries, choose a larger desired instance type and increase the desired replication count\. 

## Configuring Scaling Options through the Amazon CloudSearch Console<a name="configuring-scaling-options-console"></a>

**To configure a search domain's scaling options**

1. Sign in to the AWS Management Console and open the Amazon CloudSearch console\. In the **Navigation** pane, click the name of the domain you want to configure, and then click the **Scaling Options** link\.

1. Select an instance type from the **Desired Instance Type** menu\. If you select the `search.m3.2xlarge` instance type, you also have the option of setting the **Desired Partition Count**\. You should increase the desired partition count if you have more data to upload than will fit on a single `search.m3.2xlarge` partition\. For more information, see [Bulk Uploads](uploading-data.md#bulk-uploads)\.

1. Select the number of replicas you want to use from the **Desired Replication Count** menu\.

1. Select the number of index partitions you want to use from the **Desired Partition Count** menu\.

1. Click **Submit** to save your changes and then click **OK** to confirm that you want to modify your domain's scaling options\. Note that changing the desired instance type and replication count can significantly increase the cost of running your domain\. To exit without saving your changes, click **Cancel** and then click **Revert**\.

1. After you finish making changes to your domain configuration, click `Run Indexing` to update and deploy your index to the new instances\.

## Configuring Scaling Options through the AWS CLI<a name="configuring-scaling-options-cli"></a>

You use the `aws cloudsearch update-scaling-parameters` command to configure scaling options for a search domain\. For information about installing and setting up the AWS CLI, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\. 

**To configure a search domain's scaling options**
+ Run the `aws cloudsearch update-scaling-parameters` command\. You can specify the desired instance type and desired replication count\. If you choose the largest instance type \(`search.m3.2xlarge`\), you can also set the desired partition count\. For example, the following command sets the desired instance type to `search.m3.xlarge` and the desired replication count to two\. You must specify both the `--domain-name` and `--scaling-parameters` options\. 

  ```
  aws cloudsearch update-scaling-parameters --domain-name movies --scaling-parameters DesiredInstanceType=search.m3.xlarge,DesiredReplicationCount=2
  {
      "ScalingParameters": {
          "Status": {
              "PendingDeletion": false, 
              "State": "RequiresIndexDocuments", 
              "CreationDate": "2014-06-25T21:41:21Z", 
              "UpdateVersion": 10, 
              "UpdateDate": "2014-06-25T21:41:21Z"
          }, 
          "Options": {
              "DesiredInstanceType": "search.m3.xlarge", 
              "DesiredReplicationCount": 2
          }
      }
  }
  ```
**Important**  
When you specify `--scaling-parameters`, Amazon CloudSearch treats unspecified options as "reset to default" rather than "leave as\-is\."  
For example, if you specify `--scaling-parameters DesiredInstanceType=search.m3.xlarge` in a command and then `--scaling-parameters DesiredReplicationCount=2` in a subsequent command, Amazon CloudSearch resets `DesiredInstanceType` to its default value during the second command\.  
If you want the change from the first command to persist, you must specify it again in all subsequent commands: `--scaling-parameters DesiredInstanceType=search.m3.xlarge,DesiredReplicationCount=2`\.

For the changes to take effect, you must initiate an index build\. You can rebuild the index by calling `aws cloudsearch index-documents`\.

## Configuring Scaling Options through the AWS SDK<a name="configuring-scaling-options-sdk"></a>

The AWS SDKs \(except the Android and iOS SDKs\) support all of the Amazon CloudSearch actions defined in the Amazon CloudSearch Configuration API, including `[UpdateScalingParameters](API_UpdateScalingParameters.md)`\. For more information about installing and using the AWS SDKs, see [AWS Software Development Kits](http://aws.amazon.com/code)\.