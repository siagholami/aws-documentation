# Removing Nodes from a Cluster<a name="Clusters.DeleteNode"></a>

You can delete a node from a cluster using the AWS Management Console, the AWS CLI, or the ElastiCache API\.

**Topics**
+ [Using the AWS Management Console](#Clusters.DeleteNode.CON)
+ [Using the AWS CLI](#Clusters.DeleteNode.CLI)
+ [Using the ElastiCache API](#Clusters.DeleteNode.API)

## Using the AWS Management Console<a name="Clusters.DeleteNode.CON"></a>

**To remove nodes from a cluster \(console\)**

1. Sign in to the AWS Management Console and open the ElastiCache console at [ https://console\.aws\.amazon\.com/elasticache/](https://console.aws.amazon.com/elasticache/)\.

1. From the list in the upper\-right corner, choose the AWS Region of the cluster that you want to remove nodes from\.

1. In the navigation pane, choose the engine running on the cluster that you want to remove a node\.

   A list of clusters running the chosen engine appears\.

1. From the list of clusters, choose the cluster name from which you want to remove a node\.

   A list of the cluster's nodes appears\.

1. Choose the box to the left of the node ID for the node that you want to remove\. Using the ElastiCache console, you can only delete one node at a time, so choosing multiple nodes means that you can't use the **Delete node** button\.

   The *Delete Node* page appears\.

1. To delete the node, complete the **Delete Node** page and choose **Delete Node**\. To keep the node, choose **Cancel**\.
**Important**  
If deleting the node results in the cluster no longer being Multi\-AZ compliant, make sure to first clear the **Multi\-AZ** check box and then delete the node\. If you clear the **Multi\-AZ** check box, you can choose to enable **Auto failover**\.


**Impact of New Add and Remove Requests on Pending Requests**  

| Scenarios | Pending Operation | New Request | Results | 
| --- | --- | --- | --- | 
|  Scenario 1 |  Delete | Delete |  The new delete request, pending or immediate, replaces the pending delete request\. For example, if nodes 0001, 0003, and 0007 are pending deletion and a new request to delete nodes 0002 and 0004 is issued, only nodes 0002 and 0004 will be deleted\. Nodes 0001, 0003, and 0007 will not be deleted\. | 
|  Scenario 2 |  Delete |  Create |  The new create request, pending or immediate, replaces the pending delete request\. For example, if nodes 0001, 0003, and 0007 are pending deletion and a new request to create a node is issued, a new node will be created and nodes 0001, 0003, and 0007 will not be deleted\. | 
|  Scenario 3 |  Create |  Delete |  The new delete request, pending or immediate, replaces the pending create request\. For example, if there is a pending request to create two nodes and a new request is issued to delete node 0003, no new nodes will be created and node 0003 will be deleted\. | 
|  Scenario 4 |  Create |  Create |  The new create request is added to the pending create request\. For example, if there is a pending request to create two nodes and a new request is issued to create three nodes, the new requests is added to the pending request and five nodes will be created\. If the new create request is set to **Apply Immediately \- Yes**, all create requests are performed immediately\. If the new create request is set to **Apply Immediately \- No**, all create requests are pending\. | 

To determine what operations are pending, choose the **Description** tab and check to see how many pending creations or deletions are shown\. You cannot have both pending creations and pending deletions\. 

![\[Image: Cluster description tab\]](http://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/images/ModifyCacheCluster-DescriptionTab-PendActions.png)

## Using the AWS CLI<a name="Clusters.DeleteNode.CLI"></a>

1. Identify the IDs of the nodes that you want to remove\. For more information, see [Viewing a Cluster's Details](Clusters.ViewDetails.md)\.

1. Use the `modify-cache-cluster` CLI operation with a list of the nodes to remove, as in the following example\.

   To remove nodes from a cluster using the command\-line interface, use the command `modify-cache-cluster` with the following parameters:
   + `--cache-cluster-id` The ID of the cache cluster that you want to remove nodes from\.
   + `--num-cache-nodes` The `--num-cache-nodes` parameter specifies the number of nodes that you want in this cluster after the modification is applied\.
   + `--cache-node-ids-to-remove` A list of node IDs that you want removed from this cluster\.
   + `--apply-immediately` or `--no-apply-immediately` Specifies whether to remove these nodes immediately or at the next maintenance window\.
   + `--region` Specifies the AWS Region of the cluster that you want to remove nodes from\.

   The following example immediately removes node 0001 from the cluster my\-cluster\.

   For Linux, macOS, or Unix:

   ```
   aws elasticache modify-cache-cluster \
       --cache-cluster-id my-cluster \
       --num-cache-nodes 2 \
       --cache-node-ids-to-remove 0001 \
       --region us-east-2 \
       --apply-immediately
   ```

   For Windows:

   ```
   aws elasticache modify-cache-cluster ^
       --cache-cluster-id my-cluster ^
       --num-cache-nodes 2 ^
       --cache-node-ids-to-remove 0001 ^
       --region us-east-2 ^
       --apply-immediately
   ```

   This operation produces output similar to the following \(JSON format\):

   ```
   {
       "CacheClusters": [
           {
               "SecurityGroups": [
                   {
                       "Status": "active",
                       "SecurityGroupId": "sg-dbe93fa2"
                   }
               ],
               "ClientDownloadLandingPage": "https://console.aws.amazon.com/elasticache/home#client-download:",
               "AuthTokenEnabled": false,
               "CacheSubnetGroupName": "default",
               "SnapshotWindow": "12:30-13:30",
               "AutoMinorVersionUpgrade": true,
               "CacheClusterCreateTime": "2018-02-26T21:13:24.250Z",
               "CacheClusterStatus": "available",
               "AtRestEncryptionEnabled": false,
               "PreferredAvailabilityZone": "us-west-2a",
               "TransitEncryptionEnabled": false,
               "ReplicationGroupId": "my-cluster2",
               "Engine": "redis",
               "PreferredMaintenanceWindow": "sun:08:30-sun:09:30",
               "CacheClusterId": "my-cluster2-001",
               "PendingModifiedValues": {},
               "CacheNodeType": "cache.r4.large",
               "CacheParameterGroup": {
                   "CacheNodeIdsToReboot": [],
                   "ParameterApplyStatus": "in-sync",
                   "CacheParameterGroupName": "default.redis3.2"
               },
               "SnapshotRetentionLimit": 0,
               "EngineVersion": "3.2.10",
               "CacheSecurityGroups": [],
               "NumCacheNodes": 1
           },
           {
               "SecurityGroups": [
                   {
                       "Status": "active",
                       "SecurityGroupId": "sg-dbe93fa2"
                   }
               ],
               "ClientDownloadLandingPage": "https://console.aws.amazon.com/elasticache/home#client-download:",
               "AuthTokenEnabled": false,
               "CacheSubnetGroupName": "default",
               "SnapshotWindow": "12:30-13:30",
               "AutoMinorVersionUpgrade": true,
               "CacheClusterCreateTime": "2018-02-26T21:13:24.250Z",
               "CacheClusterStatus": "available",
               "AtRestEncryptionEnabled": false,
               "PreferredAvailabilityZone": "us-west-2b",
               "TransitEncryptionEnabled": false,
               "ReplicationGroupId": "my-cluster2",
               "Engine": "redis",
               "PreferredMaintenanceWindow": "sun:08:30-sun:09:30",
               "CacheClusterId": "my-cluster2-002",
               "PendingModifiedValues": {},
               "CacheNodeType": "cache.r4.large",
               "CacheParameterGroup": {
                   "CacheNodeIdsToReboot": [],
                   "ParameterApplyStatus": "in-sync",
                   "CacheParameterGroupName": "default.redis3.2"
               },
               "SnapshotRetentionLimit": 0,
               "EngineVersion": "3.2.10",
               "CacheSecurityGroups": [],
               "NumCacheNodes": 1
           },
           {
               "SecurityGroups": [
                   {
                       "Status": "active",
                       "SecurityGroupId": "sg-dbe93fa2"
                   }
               ],
               "ClientDownloadLandingPage": "https://console.aws.amazon.com/elasticache/home#client-download:",
               "AuthTokenEnabled": false,
               "CacheSubnetGroupName": "default",
               "SnapshotWindow": "12:30-13:30",
               "AutoMinorVersionUpgrade": true,
               "CacheClusterCreateTime": "2018-02-26T21:13:24.250Z",
               "CacheClusterStatus": "available",
               "AtRestEncryptionEnabled": false,
               "PreferredAvailabilityZone": "us-west-2c",
               "TransitEncryptionEnabled": false,
               "ReplicationGroupId": "my-cluster2",
               "Engine": "redis",
               "PreferredMaintenanceWindow": "sun:08:30-sun:09:30",
               "CacheClusterId": "my-cluster2-003",
               "PendingModifiedValues": {},
               "CacheNodeType": "cache.r4.large",
               "CacheParameterGroup": {
                   "CacheNodeIdsToReboot": [],
                   "ParameterApplyStatus": "in-sync",
                   "CacheParameterGroupName": "default.redis3.2"
               },
               "SnapshotRetentionLimit": 0,
               "EngineVersion": "3.2.10",
               "CacheSecurityGroups": [],
               "NumCacheNodes": 1
           },
           {
               "CacheClusterStatus": "available",
               "SecurityGroups": [
                   {
                       "Status": "active",
                       "SecurityGroupId": "sg-dbe93fa2"
                   }
               ],
               "ClientDownloadLandingPage": "https://console.aws.amazon.com/elasticache/home#client-download:",
               "Engine": "redis",
               "PreferredMaintenanceWindow": "wed:12:00-wed:13:00",
               "CacheSubnetGroupName": "default",
               "SnapshotWindow": "08:30-09:30",
               "TransitEncryptionEnabled": false,
               "AtRestEncryptionEnabled": false,
               "CacheClusterId": "my-cluster1",
               "CacheClusterCreateTime": "2018-02-26T21:06:43.420Z",
               "PreferredAvailabilityZone": "us-west-2c",
               "AuthTokenEnabled": false,
               "PendingModifiedValues": {},
               "CacheNodeType": "cache.r4.large",
               "CacheParameterGroup": {
                   "CacheNodeIdsToReboot": [],
                   "ParameterApplyStatus": "in-sync",
                   "CacheParameterGroupName": "default.redis3.2"
               },
               "SnapshotRetentionLimit": 0,
               "AutoMinorVersionUpgrade": true,
               "EngineVersion": "3.2.10",
               "CacheSecurityGroups": [],
               "NumCacheNodes": 1
           }
       ]
   }
   ```

For more information, see the AWS CLI topics [https://docs.aws.amazon.com/cli/latest/reference/elasticache/describe-cache-cluster.html](https://docs.aws.amazon.com/cli/latest/reference/elasticache/describe-cache-cluster.html) and [https://docs.aws.amazon.com/cli/latest/reference/elasticache/modify-cache-cluster.html](https://docs.aws.amazon.com/cli/latest/reference/elasticache/modify-cache-cluster.html)\.

## Using the ElastiCache API<a name="Clusters.DeleteNode.API"></a>

To remove nodes using the ElastiCache API, call the `ModifyCacheCluster` API operation with the cache cluster ID and a list of nodes to remove, as shown:
+ `CacheClusterId` The ID of the cache cluster that you want to remove nodes from\.
+ `NumCacheNodes` The `NumCacheNodes` parameter specifies the number of nodes that you want in this cluster after the modification is applied\.
+ `CacheNodeIdsToRemove.member.n` The list of node IDs to remove from the cluster\.
  + `CacheNodeIdsToRemove.member.1=0004`
  + `CacheNodeIdsToRemove.member.1=0005`
+ `ApplyImmediately` Specifies whether to remove these nodes immediately or at the next maintenance window\.
+ `Region` Specifies the AWS Region of the cluster that you want to remove a node from\.

The following example immediately removes nodes 0004 and 0005 from the cluster my\-cluster\.

```
https://elasticache.us-west-2.amazonaws.com/
    ?Action=ModifyCacheCluster
    &CacheClusterId=my-cluster
    &ApplyImmediately=true
    &CacheNodeIdsToRemove.member.1=0004
    &CacheNodeIdsToRemove.member.2=0005
    &NumCacheNodes=3   
    &Region us-east-2
    &Version=2014-12-01
    &SignatureVersion=4
    &SignatureMethod=HmacSHA256
    &Timestamp=20141201T220302Z
    &X-Amz-Algorithm=AWS4-HMAC-SHA256
    &X-Amz-Date=20141201T220302Z
    &X-Amz-SignedHeaders=Host
    &X-Amz-Expires=20141201T220302Z
    &X-Amz-Credential=<credential>
    &X-Amz-Signature=<signature>
```

For more information, see ElastiCache API topic [https://docs.aws.amazon.com/AmazonElastiCache/latest/APIReference/API_ModifyCacheCluster.html](https://docs.aws.amazon.com/AmazonElastiCache/latest/APIReference/API_ModifyCacheCluster.html)\.