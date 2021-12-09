# Viewing CloudWatch log groups and log streams by using the AWS Toolkit for JetBrains<a name="viewing-CloudWatch-logs"></a>

A *log stream* is a sequence of log events that share the same source\. Each separate source of logs into CloudWatch Logs makes up a separate log stream\.

 A *log group* is a group of log streams that share the same retention, monitoring, and access control settings\. You can define log groups and specify which streams to put into each group\. There is no limit on the number of log streams that can belong to one log group\. 

For more information, see [Working with Log Groups and Log Streams ](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Working-with-log-groups-and-streams.html) in the *Amazon CloudWatch User Guide*\.

**Topics**
+ [Viewing log groups and log streams with the **CloudWatch Logs** node](#viewing-log-groups)
+ [Viewing log streams with the **Lambda** node](#viewing-lamba-log-groups)
+ [Viewing log streams with the **Amazon ECS** node](#viewing-ecs-log-groups)

## Viewing log groups and log streams with the **CloudWatch Logs** node<a name="viewing-log-groups"></a>

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\.

1. Click the **CloudWatch Logs** node to expand the list of log groups\.

   The log groups for the [current AWS Region](setup-region.md#setup-region-current-region) are displayed under the **CloudWatch Logs** node\.

1. To view the log streams in a log group, do one of the following:
   + Double\-click the name of the log group\.
   + Right\-click the name of the log group, and then choose **View Log Streams**\.

   The log group's contents are displayed in the **Log Streams** pane\. For information about interacting with the log events in each stream, see [Working with CloudWatch log events](working-CloudWatch-log-events.md)\.  
![\[Viewing log streams in a CloudWatch log group in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

## Viewing log streams with the **Lambda** node<a name="viewing-lamba-log-groups"></a>

You can view CloudWatch Logs for AWS Lambda functions by using the **Lambda** node in AWS Explorer\. 

**Note**  
You can also view log streams for all AWS services, including Lambda functions, using the **CloudWatch Logs** node in AWS Explorer\. We recommend using the **Lambda** node, however, for an overview of log data specific to Lambda functions\.

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\.

1. Click the **Lambda** node to expand the list of Lambda functions\.

   The Lambda functions for the [current AWS Region](setup-region.md#setup-region-current-region) are displayed beneath the **Lambda** node\.

1. Right\-click a Lambda function, and then choose **View Log Streams**\.

   The log streams for the function are displayed in the **Log Streams** pane\. For information about interacting with the log events in each stream, see [Working with CloudWatch log events](working-CloudWatch-log-events.md)\.

## Viewing log streams with the **Amazon ECS** node<a name="viewing-ecs-log-groups"></a>

You can view CloudWatch Logs for clusters and containers that are run and maintained in Amazon Elastic Container Service by using the **Amazon ECS** node in AWS Explorer 

**Note**  
You can also view log groups for all AWS services, including Amazon ECS, using the **CloudWatch Logs** node in AWS Explorer\. We recommend using the **Amazon ECS** node, however, for an overview of log data specific to Amazon ECS clusters and containers\.

1. [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\.

1. Click the **Amazon ECS** node to expand the list of Amazon ECS clusters\.

   The Amazon ECS clusters for the [current AWS Region](setup-region.md#setup-region-current-region) are displayed beneath the **Amazon ECS** node\.

1. Right\-click a cluster, and then choose **View Log Streams**\.

   The log streams for the cluster are displayed in the **Log Streams** pane\.

1. To view log streams for a specific container, click a cluster to expand its list of registered containers\.

   The containers registered for the cluster are displayed beneath\.

1. Right\-click a container, and then choose **View Container Log Stream**\.

   The log streams for the container are displayed in the **Log Streams** pane\. For information about interacting with the log events for clusters and containers, see [Working with CloudWatch log events](working-CloudWatch-log-events.md)\. 