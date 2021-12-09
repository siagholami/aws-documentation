--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Job Statuses<a name="jobstatuses"></a>

Each job has a *status*, which changes to denote the current state of the job\. This job status information doesn't reflect the health, the current processing state, or the storage used for the associated devices\.


| Console Identifier | API Identifier | Status Description | 
| --- | --- | --- | 
| Job created | New | Your job has just been created\. This status is the only one during which you can cancel a job or its job parts, if the job is an export job\. | 
| Preparing device | PreparingAppliance | AWS is preparing a device for your job\. | 
| Exporting | InProgress | AWS is exporting your data from Amazon S3 onto a device\. | 
| Preparing shipment | PreparingShipment | AWS is preparing to ship a device to you\. | 
| In transit to you | InTransitToCustomer | The device has been shipped to the address you provided during job creation\. | 
| Delivered to you | WithCustomer | The device has arrived at the address you provided during job creation\. | 
| In transit to AWS | InTransitToAWS | You have shipped the device back to AWS\. | 
| At sorting facility | WithAWSSortingFacility | The device for this job is at our internal sorting facility\. Any additional processing for import jobs into Amazon S3 will begin soon, typically within 2 days\. | 
| At AWS | WithAWS | Your shipment has arrived at AWS\. If you're importing data, your import typically begins within a day of its arrival\. | 
| Importing | InProgress | AWS is importing your data into Amazon Simple Storage Service \(Amazon S3\)\. | 
| Completed | Complete | Your job or a part of your job has completed successfully\. | 
| Canceled | Cancelled | Your job has been canceled\. | 

## Cluster Statuses<a name="clusterstatuses"></a>

Each cluster has a *status*, which changes to denote the current general progress state of the cluster\. Each individual node of the cluster has its own job status\.

This cluster status information doesn't reflect the health, the current processing state, or the storage used for the cluster or its nodes\.


| Console Identifier | API Identifier | Status Description | 
| --- | --- | --- | 
| Awaiting Quorum | AwaitingQuorum | The cluster hasn't created yet, because there aren't enough nodes to begin processing the cluster request\. For a cluster to be created, it needs to have at least five nodes\. | 
| Pending | Pending | Your cluster has been created, and we're getting its nodes ready to ship out\. You can track the status of each node with that node's job status\. | 
| Delivered to you | InUse | At least one node of the cluster is at the address you provided during job creation\. | 
| Completed | Complete | All the nodes of the cluster have been returned to AWS\. | 
| Canceled | Cancelled | The request to make a cluster was canceled\. Cluster requests can only be canceled before they enter the Pending state\. | 