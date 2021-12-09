# Use Peer Node Metrics<a name="managed-blockchain-peer-node-metrics"></a>

You can use peer node metrics to track the activity and health of peer nodes that belong to your Amazon Managed Blockchain member\. You can use the Managed Blockchain console to view the metrics for a peer node\. Managed Blockchain also reports metrics to Amazon CloudWatch\. You can use CloudWatch to set up dashboards, receive alarms, and view log files for peer node metrics\. For more information, see [Using Amazon CloudWatch Metrics](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/working_with_metrics.html) in the *Amazon CloudWatch User Guide*\.

In addition to using peer node metrics, you optionally can enable CloudWatch Logs for peer nodes and for instances of chaincode running on a peer node\. These logs are useful for troubleshooting and analysis of chaincode activity\. For more information, see [Monitoring Blockchain Activity Using CloudWatch Logs](monitoring-cloudwatch-logs.md)\.

Managed Blockchain collects the following metrics for each peer node in the `aws/managedblockchain` namespace\.


| Metric | Description | 
| --- | --- | 
| Channel metrics | 
|  Transactions  |  The number of transactions that a peer node receives per minute\. Units: Count  | 
| Utilization metrics | 
|  CPUUtilization\(%\)  |  The percentage of total CPU capacity used on the peer node's Managed Blockchain instance at any given instant\. Units: Percent  | 
|  MemoryUtilization\(%\)  |  The percentage of total available memory used on the peer node's Managed Blockchain instance at any given instant\. Units: Percent  | 

## Viewing Peer Node Metrics<a name="managed-blockchain-view-metrics"></a>

You can use the Amazon Managed Blockchain console to view graphs for peer node metrics\. Metrics are available on the peer node details page\.

**To view metrics using the Managed Blockchain console**

1. Open the Managed Blockchain console at [https://console\.aws\.amazon\.com/managedblockchain/](https://console.aws.amazon.com/managedblockchain/)\.

1. Under **Network**, choose the **Name** of the network\.

1. Choose **Members**\. Under **Members owned by you**, choose the **Name** of the member to which the node belongs\.

1. Under **Peer Nodes**, choose the **Node ID** you want to view\.

   Under **Metrics**, tabs for **Channel Metrics** and **Utilization Metrics** are available\.

1. For **Channel Metrics**, choose the channels you want to view or compare from the list\.

1. Choose a chart and then use **Statistics**, **Time Range**, and **Period** to customize the chart\.  
![\[Customizing a metrics chart in Managed Blockchain.\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/metrics_chart.png)