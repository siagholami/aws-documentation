--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Administrating a Cluster<a name="administercluster"></a>

Following, you can find information about administrative tasks to operate a healthy cluster of Snowball Edge devices\. The primary administrative tasks are covered in the following topics\.

**Topics**
+ [Reading and Writing Data to a Cluster](#transfer-to-cluster)
+ [Reconnecting an Unavailable Cluster Node](#reconnectingclusternode)
+ [Removing an Unhealthy Node from a Cluster](#remove-node)
+ [Adding or Replacing a Node in a Cluster](#replacement)

Most administrative tasks require that you use the Snowball client and its commands that perform the following actions:
+ [Unlocking Snowball Edge Devices](using-client-commands.md#setting-up-client)
+ [Getting Device Status](using-client-commands.md#client-status) of a cluster
+ [Removing a Node from a Cluster](using-client-commands.md#client-cluster-remove)
+ [Adding a Node to a Cluster](using-client-commands.md#client-cluster-add)

## Reading and Writing Data to a Cluster<a name="transfer-to-cluster"></a>

After you've unlocked a cluster, you're ready to read and write data to it\. You can use the Amazon S3 Adapter for Snowball to read and write data to a cluster\. For more information, see [Transferring Files Using the Amazon S3 Adapter](using-adapter.md)\.

To write data to a cluster, you must have a read/write quorum with no more than one unavailable node\. To read data from a cluster, you must have a read quorum of no more than two unavailable nodes\. For more information on quorums, see [Snowball Edge Cluster Quorums](UsingCluster.md#clusterquorums)\.

## Reconnecting an Unavailable Cluster Node<a name="reconnectingclusternode"></a>

A node can become temporarily unavailable due to an issue \(like power or network loss\) without damaging the data on the node\. When this happens, it affects the status of your cluster\. A node's network reachability and lock status is reported in the Snowball client by using the `snowballEdge describe-cluster` command\.

We recommend that you physically position your cluster so you have access to the front, back, and top of all nodes\. This way, you can access the power and network cables on the back, the shipping label on the top to get your node ID, and the LCD screen on the front of the device for the IP address and other administrative information\.

When you detect that a node is unavailable, we recommend that you try one of the following procedures, depending on the scenario that caused the unavailability\.

**To reconnect an unavailable node**

1. Ensure that the node has power\.

1. Ensure that the node is connected to the same internal network that the rest of the cluster is on\.

1. Wait for the node to finish powering up, if it needed to be powered up\.

1. Run the `snowballEdge unlock-cluster` command, or the `snowballEdge associate-device` command\. For an example, see [Unlocking Snowball Edge Devices](using-client-commands.md#setting-up-client)\.

**To reconnect an unavailable node that lost network but didn't lose power**

1. Ensure that the node is connected to the same internal network that the rest of the cluster is on\.

1. Run the `snowballEdge describe-device` command to see when the previously unavailable node is added back to the cluster\. For an example, see [Getting Device Status](using-client-commands.md#client-status)\.

When you have performed the preceding procedures, your nodes should be working normally\. You should also have a read/write quorum\. If that's not the case, then one or more of your nodes might have a more serious issue and might need to be removed from the cluster\.

## Removing an Unhealthy Node from a Cluster<a name="remove-node"></a>

Rarely, a node in your cluster might become unhealthy\. If the node is unavailable, we recommend going through the procedures listed in [Reconnecting an Unavailable Cluster Node](#reconnectingclusternode) first\. 

If doing so doesn't resolve the issue, then the node might be unhealthy\. An unhealthy node can occur if the node has taken damage from an external source, if there was an unusual electrical event, or if some other unlikely event occurs\. If this happens, you need to remove the node from the cluster before you can add a new node as a replacement\.

When you detect that a node is unhealthy and needs to be removed, we recommend that you do so with the following procedure\.

**To remove an unhealthy node**

1. Ensure that the node is unhealthy and not just unavailable\. For more information, see [Reconnecting an Unavailable Cluster Node](#reconnectingclusternode)\.

1. Disconnect the unhealthy node from the network and power it off\.

1. Run the `snowballEdge dissassociate-device` Snowball client command\. For more information, see [Removing a Node from a Cluster](using-client-commands.md#client-cluster-remove)\.

1. Order a replacement node using the console, the AWS CLI, or one of the AWS SDKs\.

1. Return the unhealthy node to AWS\. When we have the node, we perform a complete erasure of the device\. This erasure follows the National Institute of Standards and Technology \(NIST\) 800\-88 standards\.

After you successfully remove a node, your data is still available on the cluster if you still have a read quorum\. To have read quorum, a cluster must have no more than two unavailable nodes\. Therefore, we recommend that you order replacement nodes as soon as you remove an unavailable node from the cluster\.

## Adding or Replacing a Node in a Cluster<a name="replacement"></a>

You can add a new node after you have removed an unhealthy node from a cluster\. You can also add a new node to increase local storage\. 

To add a new node, you first need to order a replacement\. You can order a replacement node from the console, the AWS CLI, or one of the AWS SDKs\. If you're ordering a replacement node from the console, you can order replacements for any job that hasn't been canceled or completed\.

**To order a replacement node from the console**

1. Sign in to the [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\.

1. Find and choose a job for a node that belongs to the cluster that you created from the Job dashboard\.

1. For **Actions**, choose **Replace node**\.

   Doing this opens the final step of the job creation wizard, with all settings identical to how the cluster was originally created\.

1. Choose **Create job**\.

Your replacement Snowball Edge is now on its way to you\. When it arrives, use the following procedure to add it to your cluster\.

**To add a replacement node**

1. Position the new node for the cluster such that you have access to the front, back, and top of all nodes\.

1. Ensure that the node has power\.

1. Ensure that the node is connected to the same internal network that the rest of the cluster is on\.

1. Wait for the node to finish powering up, if it needed to be powered on\.

1. Run the `snowballEdge associate-device` command\. For an example, see [Adding a Node to a Cluster](using-client-commands.md#client-cluster-add)\.