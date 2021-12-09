--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Clustering Overview<a name="old-clusters"></a>

**Note**  
In January 2018, there was a feature update to for clusters, making them leaderless\. The cluster update is backwards compatible with older clusters\. This is the original cluster documentation for the Snowball Edge\. If you're looking for the updated content, see [Using an AWS Snowball Edge Cluster](UsingCluster.md)\.

For the AWS Snowball service, a cluster is a collective of AWS Snowball Edge devices, used as a single logical unit, for local storage and compute purposes\.

A cluster offers two primary benefits over a standalone Snowball Edge for local storage and compute purposes:
+ **Increased Durability** – The data stored in a cluster of Snowball Edges enjoys increased data durability over a single device\. In addition, the data on the cluster remains as safe and viable as it was previously, despite possible Snowball Edge outages in the cluster\. Clusters can withstand the loss of two nodes before the data is in danger\. You can also add or replace nodes\.
+ **Increased Storage** – The total available storage is 45 terabytes of data per node in the cluster\. Thus, in a five\-node cluster there's 225 terabytes of available storage space\. In contrast, there's about 82 terabytes of available storage space in a standalone Snowball Edge\. Clusters that have more than five nodes have even more storage space\.

A cluster of Snowball Edge devices is made of nodes\. There are two types of nodes: primary nodes and secondary nodes\. When writing data to a cluster, data is written from your server, across your internal network, and to the primary node of the cluster\. The primary node then writes the data to the secondary nodes\.

The primary node is the leader of the cluster and performs most of the behind\-the\-scenes management of the cluster\. You designate the primary node from among all the nodes of the cluster when you unlock the cluster for the first time\. You can change the primary node if the current one becomes unavailable\.

## Snowball Edge Cluster Quorums<a name="old-clusterquorums"></a>

A quorum represents the minimum number of Snowball Edge devices in a cluster that must be communicating with each other to maintain some level of operation\. There are two levels of quorum for Snowball Edge clusters—a read/write quorum and a read quorum\.

Let's say you've uploaded your data to a cluster of Snowball Edge devices\. With all devices healthy, you have a read/write quorum for your cluster\.

If one of those nodes goes offline, you have reduced the operational capacity of the cluster\. However, you can still read and write to the cluster\. In that sense, with the cluster operating all but one node, the cluster still has a read/write quorum\.

In this same example, if the external power failure took out two of the nodes in your cluster, any additional or ongoing write operations fail\. But any data that was successfully written to the cluster can be accessed and read\. This situation is called a read quorum\.

Finally, in this example, suppose that a third node loses power\. Then the cluster is offline, and the data in the cluster is unavailable\. You might be able fix this, or the data might be permanently lost, depending on the severity of the event\. If it is a temporary external power event, and you can power the three Snowball Edges back on and unlock all the nodes in the cluster, then your data will be available again\.

**Important**  
If a minimum quorum of healthy nodes doesn't exist, contact AWS Support\.

You can check the quorum state of your cluster by running the `snowballEdge status` command\. Ensuring that the devices in your cluster are healthy and connected is an administrative responsibility that you take on when you create the cluster job\.

## Considerations for Cluster Jobs for AWS Snowball Edge<a name="old-clusterconsiderations"></a>

Keep the following considerations in mind when planning to use a cluster of Snowball Edges:
+ We recommend that you have a redundant power supply to reduce potential performance and stability issues for your cluster\.
+ As with standalone local storage and compute jobs, the data stored in a cluster can't be imported into Amazon S3 without ordering additional devices as a part of separate import jobs\. If you order these devices, you can transfer the data from the cluster to the devices and import the data when you return the devices for the import jobs\.
+ To get data onto a cluster from Amazon S3, you have to create a separate export job and copy the data from the devices of the export job onto the cluster\.
+ You can create a cluster job from the console, the AWS CLI, or one of the AWS SDKs\. For a guided walkthrough of creating a job, see [Getting Started with an AWS Snowball Edge Device](getting-started.md)\.
+ Cluster nodes have node IDs\. A *node ID* is the same as the job ID for a device that you can get from the console, the AWS CLI, the AWS SDKs, and the Snowball client\. You can use node IDs to remove old nodes from clusters\. You can get a list of node IDs by using the `snowballEdge status` command\.
+ The lifespan of a cluster is limited by the security certificate granted to the cluster devices when the cluster is provisioned\. By default, Snowball Edge devices can be used for up to 365 days before they need to be returned\. At the end of that time, the devices stop responding to read/write requests\. If you need to keep one or more devices for longer than 365 days, contact AWS Support\.
+ When AWS receives a returned device that was part of a cluster, we perform a complete erasure of the device\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\.

## Related Topics<a name="old-relatedcluster"></a>

Beyond the content presented in this topic, you can find other topics in this guide that are relevant to clusters:
+ [Getting Started with an AWS Snowball Edge Device](getting-started.md) – This section outlines how to get started creating your first job\. The techniques in this section work for all job types, including cluster jobs\.
+ [Commands for the Snowball Client](old-using-client.md#old-using-client-commands) – This section contains a list of commands for the Snowball client tool\. These commands include the Snowball Edge administrative commands to unlock a cluster, get the status information for the nodes and the cluster as a whole, remove unavailable nodes, and add new nodes\.
+ [Administrating a Cluster](old-administercluster.md) – This section contains information about the administrative tasks you perform with a cluster like adding and removing nodes, and includes helpful procedures\.