# Building Dashboards with CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor how your application uses resources by using Amazon CloudWatch, which generates metrics about your usage and performance\. CloudWatch collects raw data from your AWS resources and the applications that you run on AWS, and processes it into readable, near real time metrics\. The metrics are kept for 15 months so that you can access historical information to gain a better perspective on how your application is performing\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

CloudWatch dashboards are customizable home pages in the CloudWatch console that you can use to monitor your resources in a single view, even those resources that are spread across different Regions\. You can use CloudWatch dashboards to create customized views of selected metrics for your AWS resources\. You can select the color used for each metric on each graph, so you can more easily track the same metric across multiple graphs\. 

**To create a CloudWatch dashboard**

1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

1. In the navigation pane, choose **Dashboard**, and then choose **Create new dashboard**\. 

1. Enter a name for the dashboard, such as the name of the service for which you want to view CloudWatch data\. 

1. Choose **Create dashboard**\. 

1. Choose a type of widget to add to your dashboard, such as a line graph\. Then choose **Configure**, and choose the metric that you want to add to your dashboard\. For more information, see [Add or Remove a Graph from a CloudWatch Dashboard](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/add_remove_graph_dashboard.html) in the *Amazon CloudWatch User Guide*

By default, the metrics that you create in the CloudWatch dashboards are averages\.

## Metrics and Dimensions<a name="metrics-to-monitor"></a>

When you interact with the services that integrate with Application Auto Scaling, they send the metrics shown in the following table to CloudWatch\. In CloudWatch, metrics are grouped first by the service namespace, and then by the various dimension combinations within each namespace\. 

These metrics can help you discover your application's capacity requirements\. You can use this information to set your capacity statically, or to set up automatic scaling\. If your application’s workload is not constant, this indicates that you should consider using automatic scaling\. 


| Metric Name  | Namespace | Dimensions | Applies To | 
| --- | --- | --- | --- | 
| [CPUUtilization](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/cloudwatch-metrics.html) | AWS/ECS | ClusterName, ServiceName | ECS | 
| [MemoryUtilization](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/cloudwatch-metrics.html) | AWS/ECS | ClusterName, ServiceName | ECS | 
| [CPUUtilization](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-cloudwatch-metrics.html) | AWS/EC2Spot | FleetRequestId | Spot Fleet | 
| [NetworkIn](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-cloudwatch-metrics.html) | AWS/EC2Spot | FleetRequestId | Spot Fleet | 
| [NetworkOut](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-cloudwatch-metrics.html) | AWS/EC2Spot | FleetRequestId | Spot Fleet | 
| [RequestCountPerTarget](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/load-balancer-cloudwatch-metrics.html) | AWS/ApplicationELB | TargetGroup | ECS, Spot Fleet | 
| [YARNMemoryAvailablePercentage](https://docs.aws.amazon.com/emr/latest/ManagementGuide/UsingEMR_ViewingMetrics.html) | AWS/ElasticMapReduce  | ClusterId | EMR | 
| [AvailableCapacity](https://docs.aws.amazon.com/appstream2/latest/developerguide/monitoring.html) | AWS/AppStream | Fleet | AppStream | 
| [CapacityUtilization](https://docs.aws.amazon.com/appstream2/latest/developerguide/monitoring.html) | AWS/AppStream | Fleet | AppStream | 
| [ProvisionedReadCapacityUnits](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) | AWS/DynamoDB | TableName, GlobalSecondaryIndexName | DynamoDB | 
| [ProvisionedWriteCapacityUnits](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) | AWS/DynamoDB | TableName, GlobalSecondaryIndexName | DynamoDB | 
| [ConsumedReadCapacityUnits](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) | AWS/DynamoDB | TableName, GlobalSecondaryIndexName | DynamoDB | 
| [ConsumedWriteCapacityUnits](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/metrics-dimensions.html) | AWS/DynamoDB | TableName, GlobalSecondaryIndexName | DynamoDB | 
| [CPUUtilization](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.Monitoring.html) | AWS/RDS | DBClusterIdentifier, Role \(READER\) | Aurora | 
| [DatabaseConnections](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.Monitoring.html) | AWS/RDS | DBClusterIdentifier, Role \(READER\) | Aurora | 
| [InvocationsPerInstance](https://docs.aws.amazon.com/sagemaker/latest/dg/monitoring-cloudwatch.html) | AWS/SageMaker  | EndpointName, VariantName | SageMaker | 
| [InferenceUtilization](https://docs.aws.amazon.com/comprehend/latest/dg/custom-sync.html) | AWS/Comprehend | EndpointArn | Comprehend | 
| [ProvisionedConcurrencyUtilization](https://docs.aws.amazon.com/lambda/latest/dg/monitoring-functions-metrics.html) | AWS/Lambda | FunctionName, Resource | Lambda | 

While CloudWatch allows you to choose any statistic and period for each metric, not all combinations are useful\. For example, the Average, Minimum, and Maximum statistics for CPU utilization are useful, but the Sum statistic is not\. For more information, refer to the service's documentation by following the links provided in the preceding table\.

A commonly used measure of application performance is average CPU utilization\. If there is an increase in CPU utilization and you have insufficient capacity to handle it, the application might become unresponsive\. On the other hand, if you have too much capacity and resources are running when utilization is low, this increases the costs for using that service\.

Depending on the service, you also have metrics that track the amount of provisioned throughput that is available\. For example, for the number of invocations that are being processed on a function alias or version with provisioned concurrency, Lambda emits the ProvisionedConcurrencyUtilization metric\. If you are starting a large job and invoke the same function many times simultaneously, the job might experience latency when it exceeds the amount of provisioned concurrency available\. On the other hand, if you have more provisioned concurrency than you need, your costs might be higher than they should be\.

If you do not see these metrics in the CloudWatch console, make sure that you have completed the setup of the resource\. Metrics do not appear before the resource has been set up completely\. Also, if a metric hasn't published data in the past 14 days, you can't find it when searching for metrics to add to a graph on a CloudWatch dashboard\. For information about how to add any metric manually, see [Graph Metrics Manually on a CloudWatch Dashboard](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/add_old_metrics_to_graph.html) in the *Amazon CloudWatch User Guide*\.