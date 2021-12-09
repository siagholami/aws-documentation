# Suspending and Resuming Scaling for Application Auto Scaling<a name="application-auto-scaling-suspend-resume-scaling"></a>

This topic explains how to suspend and then resume one or more of the scaling activities for the scalable targets in your application\. The suspend\-resume feature is used to temporarily pause scaling activities triggered by your scaling policies and scheduled actions\. This can be useful, for example, when you don't want automatic scaling to potentially interfere while you are making a change or investigating a configuration issue\. Your scaling policies and scheduled actions can be retained, and when you are ready, scaling activities can be resumed\.

## Scaling Activities<a name="process-types"></a>

Application Auto Scaling supports putting the following scaling activities in a suspended state:
+ All scale\-in activities that are triggered by a scaling policy\.
+ All scale\-out activities that are triggered by a scaling policy\.
+ All scaling activities that involve scheduled actions\. 

The following descriptions explain what happens when individual scaling activities are suspended\. Each one can be suspended and resumed independently\. Depending on the reason for suspending a scaling activity, you might need to suspend multiple scaling activities together\. 

`DynamicScalingInSuspended`
+ Application Auto Scaling does not remove capacity when a target tracking scaling policy or a step scaling policy is triggered\. This allows you to temporarily disable scale\-in activities associated with scaling policies without deleting the scaling policies or their associated CloudWatch alarms\. When you resume scale in, Application Auto Scaling evaluates policies with alarm thresholds that are currently in breach\.

`DynamicScalingOutSuspended`
+ Application Auto Scaling does not add capacity when a target tracking scaling policy or a step scaling policy is triggered\. This allows you to temporarily disable scale\-out activities associated with scaling policies without deleting the scaling policies or their associated CloudWatch alarms\. When you resume scale out, Application Auto Scaling evaluates policies with alarm thresholds that are currently in breach\.

`ScheduledScalingSuspended`
+ Application Auto Scaling does not initiate the scaling actions that are scheduled to run during the suspension period\. When you resume scheduled scaling, Application Auto Scaling only evaluates scheduled actions whose execution time has not yet passed\.

## Suspend and Resume Scaling Activities Using the AWS CLI<a name="aas-suspend-aws-cli"></a>

You can suspend and resume individual scaling activities or all scaling activities for your Application Auto Scaling scalable target\.

**Note**  
For brevity, these examples illustrate how to suspend and resume scaling for a DynamoDB table\. To specify a different scalable target, specify its namespace in `--service-namespace`, its scalable dimension in `--scalable-dimension`, and its resource ID in `--resource-id`\. 

**To suspend a scaling activity**  
Open a command\-line window and use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command with the `--suspendedstate` option as follows\. 

```
aws application-autoscaling register-scalable-target --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:ReadCapacityUnits --resource-id table/my-table \
  --suspended-state file://config.json
```

To only suspend scale\-in activities that are triggered by a scaling policy, specify the following in config\.json\.

```
{
    "DynamicScalingInSuspended":true
}
```

To only suspend scale\-out activities that are triggered by a scaling policy, specify the following in config\.json\.

```
{
    "DynamicScalingOutSuspended":true
}
```

To only suspend scaling activities that involve scheduled actions, specify the following in config\.json\.

```
{
    "ScheduledScalingSuspended":true
}
```

**To suspend all scaling activities**  
Use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command with the `--suspendedstate` option as follows\.

```
aws application-autoscaling register-scalable-target --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:ReadCapacityUnits --resource-id table/my-table \
  --suspended-state file://config.json
```

This example assumes that the file config\.json contains the following JSON\-formatted parameters\. 

```
{
    "DynamicScalingInSuspended":true,
    "DynamicScalingOutSuspended":true,
    "ScheduledScalingSuspended":true
}
```

### View Suspended Scaling Activities<a name="aas-check-suspend-state-aws-cli"></a>

Use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scalable-targets.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scalable-targets.html) command to determine which scaling activities are in a suspended state for a scalable target\.

```
aws application-autoscaling describe-scalable-targets --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:ReadCapacityUnits --resource-id table/my-table
```

The following is example output\.

```
{
    "ScalableTargets": [
        {
            "ServiceNamespace": "dynamodb",
            "ScalableDimension": "dynamodb:table:ReadCapacityUnits",
            "ResourceId": "table/my-table",
            "MinCapacity": 1,
            "MaxCapacity": 20,
            "SuspendedState": {
                "DynamicScalingOutSuspended": true,
                "DynamicScalingInSuspended": true,
                "ScheduledScalingSuspended": true
            },
            "CreationTime": 1558125758.957,
            "RoleARN": "arn:aws:iam::123456789012:role/aws-service-role/dynamodb.application-autoscaling.amazonaws.com/AWSServiceRoleForApplicationAutoScaling_DynamoDBTable"
        }
    ]
}
```

### Resume Scaling Activities<a name="aas-resume-aws-cli"></a>

When you are ready to resume the scaling activity, you can resume it using the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command\.

The following example command resumes all scaling activities for the specified scalable target\. 

```
aws application-autoscaling register-scalable-target --service-namespace dynamodb \
  --scalable-dimension dynamodb:table:ReadCapacityUnits --resource-id table/my-table \
  --suspended-state file://config.json
```

This example assumes that the file config\.json contains the following JSON\-formatted parameters\. 

```
{
    "DynamicScalingInSuspended":false,
    "DynamicScalingOutSuspended":false,
    "ScheduledScalingSuspended":false
}
```