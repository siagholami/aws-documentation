--------

--------

# Monitoring AWS IoT Things Graph with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor AWS IoT Things Graph using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective on how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

CloudWatch collects data only for cloud deployments of flow configurations\. CloudWatch isn't available for AWS IoT Greengrass deployments\.

**To enable data collection using the console**

1. Sign in to the AWS IoT Things Graph console\.

1. On the **Configure target** page, select **Enable metrics**\. This page appears after you enter a name for a flow\.

![\[\]](http://docs.aws.amazon.com/thingsgraph/latest/ug/images/TGEnableMetrics.png)

**To enable data collection using the CLI**
+ Create a [MetricsConfiguration](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_MetricsConfiguration.html) object and pass it to the [CreateSystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateSystemInstance.html) command\.

The `MetricsConfiguration` object contains the following values\.
+ `cloudMetricEnabled`: A Boolean that specifies whether cloud metrics are collected\.
+ `metricRuleRoleArn`: The ARN of an IAM role used to collect cloud metrics\. This value is not required\.

**Example**  
The following AWS CLI example enables data collection for a new flow configuration\.  

```
    aws iotthingsgraph create-system-instance \
    --definition language=GRAPHQL,text="MySystemInstanceDefinition" \
    --target CLOUD \
    --flow-actions-role-arn myRoleARN \
    --metrics-configuration cloudMetricEnabled=true
```

The following tables list the metrics and dimensions for AWS IoT Things Graph\.

## AWS IoT Things Graph Metrics<a name="things-graph-metrics"></a>

AWS IoT Things Graph sends the following metrics to CloudWatch every minute\.


| Metric | Description | 
| --- | --- | 
|  `FlowExecutionTime`  |  The amount of time a flow execution takes to complete\.  | 
|  `FlowExecutionsAborted`  |  The number of flow executions that are aborted\.  | 
|  `FlowExecutionsFailed`  |  The number of flow executions that failed\.  | 
|  `FlowExecutionsStarted`  |  The number of flow executions that started\.  | 
|  `FlowExecutionsSucceeded`  |  The number of flow executions that succeeded\.  | 
|  `FlowStepExecutionTime`  |  The amount of time a flow execution step takes to complete\.  | 
|  `FlowStepExecutionsFailed`  |  The number of flow execution steps that failed\.  | 
|  `FlowStepExecutionsStarted`  |  The number of flow execution steps that started\.  | 
|  `FlowStepExecutionsSucceeded`  |  The number of flow execution steps that succeeded\.  | 
|  `FlowStepLambdaExecutionsFailed`  |  The number of flow execution Lambda function steps that failed\.  | 
|  `FlowStepLambdaExecutionsStarted`  |  The number of flow execution Lambda function steps that started\.  | 
|  `FlowStepLambdaExecutionsSucceeded`  |  The number of flow execution Lambda function steps that succeeded\.  | 

## Dimensions for AWS IoT Things Graph Metrics<a name="things-graph-metricdimensions"></a>

AWS IoT Things Graph metrics use the AWS IoT Things Graph namespace and provide metrics for the following dimensions\.


| Dimension | Description | 
| --- | --- | 
|  `FlowTemplateId`  |  The ID of the flow template that the flow execution belongs to\.  | 
|  `LambdaArn`  |  The ARN of the Lambda function flow execution step\.  | 
|  `StepName`  |  The name of the flow execution step\.  | 
|  `SystemTemplateId`  |  The ID of the system template that the flow execution belongs to\.  | 