# Monitoring Blockchain Activity Using CloudWatch Logs<a name="monitoring-cloudwatch-logs"></a>

Amazon Managed Blockchain supports publishing peer node, chaincode, and Certificate Authority \(CA\) logs to Amazon CloudWatch Logs\. You can use these logs to troubleshoot during chaincode development and to monitor network activity and errors\.

You can enable and view logs in the Managed Blockchain management console, in the CloudWatch Logs console, and using AWS CLI commands for CloudWatch Logs\. In addition, you can set up *metric filters* in CloudWatch Logs to turn log data into numerical CloudWatch metrics that you can graph and set an alarm on\. For each member that has logging enabled, Managed Blockchain creates a log group in CloudWatch Logs\. For more information about CloudWatch Logs, see the [Amazon CloudWatch Logs User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/)\. For more information about creating metric filters, see [Searching and Filtering Log Data](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/MonitoringLogData.html) in the *Amazon CloudWatch Logs User Guide*\.
+ **Peer node logs** help you debug timeout errors associated with proposals and identify rejected proposals that do not meet the endorsement policies\. Peer node logs contain messages generated when your client submits transaction proposals to peer nodes, requests to join channels, enrolls an admin peer, and lists the chaincode instances on a peer node\. Peer node logs also contain the results of chaincode installation\. You can enable and disable logs on individual peer nodes\.
+ **Chaincode logs** help you analyze and debug the business logic and execution of chaincode on a peer node\. They contain the results of instantiating, invoking, and querying the chaincode\. A peer can run multiple instances of chaincode\. When you enable chaincode logging, individual log streams are created for each and every chaincode on the peer\.
+ **CA logs** help you determine when a member in your account joins the network, or when new peers register with a member CA\. You can use CA logs to debug problems related to certificates and enrollment\. CA logging can be enabled and disabled for each member\. A single log stream for the CA exists for each member\.

**Note**  
Managed Blockchain gathers CloudWatch metrics for peer nodes automatically and separately from CloudWatch Logs for CAs, peer nodes, and chaincode\. For more information, see [Use Peer Node Metrics](managed-blockchain-peer-node-metrics.md)\. 

## Considerations and Limitations<a name="monitoring-considerations"></a>

Consider the following before you enable and view CloudWatch Logs for Managed Blockchain\.
+ Log entries are updated every five seconds\.
+ Logging requires the service\-linked role for Managed Blockchain\. The role is created automatically when an IAM principal \(user or role\) in your account with permissions to create the service\-linked role creates a network, member, or peer\. For more information, see [Using Service\-Linked Roles for Managed Blockchain](using-service-linked-roles.md)\.
+ Logging currently does not support CloudWatch Logs encryption\.
+ Logging currently does not support CloudWatch Logs Insights\.
+ To log chaincode events, you must first configure Go chaincode for logging\. For more information, see [Logging Control for Go Chaincodes](https://hyperledger-fabric.readthedocs.io/en/release-1.2/logging-control.html#go-chaincodes) in the Hyperledger Fabric documentation\.

## Enabling and Disabling Logs<a name="monitoring-enable"></a>

You can enable logs using the Managed Blockchain management console when you create a member or node, or at any time after a member or node is created\. You can disable CA logging, peer node logging, and chaincode logging at any time\. When a log is disabled, log entries are not published to CloudWatch Logs\. Previous log entries are still viewable and available in CloudWatch Logs\.

### Enabling and Disabling Peer Node and Chaincode Logs<a name="enable-peer-chaincode-logs"></a>

You can enable peer node logs, chaincode logs, or both when you create a peer node or when viewing information about a peer node\. You can also disable logs while viewing information about a peer node\.

**To enable peer node or chaincode logs when you create a node**

1. On the **Members** tab of the Managed Blockchain network that you are working with, under **Members owned by you**, choose the name of the member from the list, and then choose **Create peer node**\.

1. Under **Logging configuration**, choose **Enable peer node logs**, **Enable chaincode logs**, or both, and then choose **Create peer node**\.

**To enable or disable peer node and chaincode logs for an existing member**

1. On the **Members** tab of the Managed Blockchain network that you are working with, under **Members owned by you**, choose the name of the member from the list\.

1. Under **Peer nodes**, choose the **Node ID** of the peer\.

1. Under monitoring, choose **Peer node logs** or **Chaincode logs**\.

1. Choose **Enable logging**, or choose **Actions** and then **Disable Logging**\.

## Working with Logged Events in the Managed Blockchain Console<a name="work-with-logged-events"></a>

Managed Blockchain publishes logged events to CloudWatch Logs every five seconds\. By default, logged events are updated every five seconds in the Managed Blockchain console under **Logged events** on member and node information pages\. When viewing logged events in Managed Blockchain, you can choose **Actions** and then view **View in CloudWatch** to open the CloudWatch Logs management console focused on the log stream that you are viewing\. Choose the gear icon to configure the logging interval and other details\.

### Searching \(Filtering\) Logged Events<a name="filter-logs"></a>

While viewing events for any log in Managed Blockchain, you can enter a keyword or phrase in the **Search events** box to show only those events that contain the search term\. For example, you can enter a date, a date and time, or a log level such as `CRITICAL`, `DEBUG`, or `WARNING`\. When you download a log after searching, only the events filtered by your search term are downloaded\.

![\[Screenshot of the log filtering UI for CA logs\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/filter_CA_logs.png)

### Downloading Logged Events<a name="download-logs"></a>

Choose **Actions** and then **Download** while viewing any log in Managed Blockchain to save the events that are loaded to the default download directory on your local machine with a `.log` extension\. Logged events are listed along with a header that contains log information as shown in the following example\.

```
Event Count: 100
Filtered: Yes
Filtered Event Count: 44
Filter: "DEBUG"

2020-02-03T01:04:34.548Z 2020/02/03 01:04:34 [DEBUG] Cleaning up expired nonces for CA 'm-J46DNSFRTVCCLONS9DT5TTLS2A'
2020-02-03T01:00:56.382Z 2020/02/03 01:00:56 [DEBUG] Received request for /cainfo
2020-02-03T00:55:56.308Z 2020/02/03 00:55:56 [DEBUG] Received request for /cainfo
2020-02-03T00:50:56.208Z 2020/02/03 00:50:56 [DEBUG] Received request for /cainfo
2020-02-03T00:49:34.544Z 2020/02/03 00:49:34 [DEBUG] Cleaning up expired nonces for CA 'm-J46DNSFRTVCCLONS9DT5TTLS2A'
2020-02-03T00:45:56.282Z 2020/02/03 00:45:56 [DEBUG] Received request for /cainfo
2020-02-03T00:40:56.111Z 2020/02/03 00:40:56 [DEBUG] Received request for /cainfo
2020-02-03T00:35:56.026Z 2020/02/03 00:35:56 [DEBUG] Received request for /cainfo
2020-02-03T00:34:34.539Z 2020/02/03 00:34:34 [DEBUG] Cleaning up expired nonces for CA 'm-J46DNSFRTVCCLONS9DT5TTLS2A'
2020-02-03T00:30:56.081Z 2020/02/03 00:30:56 [DEBUG] Received request for /cainfo
2020-02-03T00:25:56.123Z 2020/02/03 00:25:56 [DEBUG] Received request for /cainfo
2020-02-03T00:20:56.197Z 2020/02/03 00:20:56 [DEBUG] Received request for /cainfo
```

### Viewing Different Chaincode Logs<a name="view-chaincode-logs"></a>

When viewing chaincode logs for a peer node with multiple chaincodes, you can choose the chaincode to view by choosing the chaincode name from the list next to **Logged events**\. When you download a log, only the logged events for the chaincode that you are viewing are downloaded\.

![\[Screenshot of the log filtering UI for chaincode events\]](http://docs.aws.amazon.com/managed-blockchain/latest/managementguide/images/choose_chaincode_log.png)

## Identifying Logs in CloudWatch Logs<a name="monitoring-identify-in-cloudwatch"></a>

Each set of log events in Managed Blockchain corresponds to a *log stream* in CloudWatch Logs\. The easiest way to access a log stream in the CloudWatch Logs management console is to choose **Actions** and then **View in CloudWatch** while viewing a log in the Managed Blockchain management console\.

All log streams associated with a member and peer nodes that a member owns are in a log group with the naming pattern shown below—for example, **aws/managedblockchain/n\-MWY63ZJZU5HGNCMBQER7IN6OIU/m\-J46DNSFRTVCCLONS9DT5TTLS2A**\.

```
aws/managedblockchain/NetworkID/MemberID
```

Log streams in the log group are named according to the patterns in the table below\.


| Type of log | Stream name | 
| --- | --- | 
|  Peer node logs  |  ***PeerNodeID***, for example, **nd\-6EAJ5VA43JGGNPXOUZP7Y47E4Y**\.  | 
|  Chaincode logs  |  ***MemberID*\-*PeerNodeID*\-*ChaincodeName*\-*ChaincodeVersion***, for example, **m\-J46DNSFRTVCCLONS9DT5TTLS2A\-nd\-6EAJ5VA43JGGNPXOUZP7Y47E4Y\-MyChaincode\-v0**\.  | 
|  CA logs  |  **ca**  | 