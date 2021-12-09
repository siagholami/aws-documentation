# Step Scaling Policies for Application Auto Scaling<a name="application-auto-scaling-step-scaling-policies"></a>

With step scaling, you choose scaling metrics and threshold values for the CloudWatch alarms that trigger the scaling process as well as define how your scalable target should be scaled when a threshold is in breach for a specified number of evaluation periods\. 

If your scaling metric is a utilization metric that increases or decreases proportionally to the capacity of the scalable target, we recommend that you use a target tracking scaling policy\. For more information, see [Target Tracking Scaling Policies for Application Auto Scaling](application-auto-scaling-target-tracking.md)\. You still have the option to use target tracking scaling with step scaling for a more advanced scaling policy configuration\. For example, if you want, you can configure a more aggressive response when utilization reaches a certain level\. 

Step scaling policies increase or decrease the current capacity of a scalable target based on a set of scaling adjustments, known as *step adjustments*\. The adjustments vary based on the size of the alarm breach\. All alarms that are breached are evaluated by Application Auto Scaling as it receives the alarm messages\.

**Limits**
+ Step scaling policies are not supported for DynamoDB, Amazon Comprehend, or Lambda\.

## Step Adjustments<a name="as-scaling-steps"></a>

When you create a step scaling policy, you add one or more step adjustments that enable you to scale based on the size of the alarm breach\. Each step adjustment specifies the following:
+ A lower bound for the metric value
+ An upper bound for the metric value
+ The amount by which to scale, based on the scaling adjustment type

CloudWatch aggregates metric data points based on the statistic for the metric associated with your CloudWatch alarm\. When the alarm is breached, the appropriate scaling policy is triggered\. Application Auto Scaling applies your specified aggregation type to the most recent metric data points from CloudWatch \(as opposed to the raw metric data\)\. It compares this aggregated metric value against the upper and lower bounds defined by the step adjustments to determine which step adjustment to perform\. 

You specify the upper and lower bounds relative to the breach threshold\. For example, let's say that you have a scalable target that has both a current capacity and a desired capacity of 10\. You have a CloudWatch alarm with a breach threshold of 50 percent\. You have an adjustment type of `PercentChangeInCapacity` and scale\-out and scale\-in policies with the following step adjustments:


**Example: Step adjustments for scale\-out policy**  

| **Lower Bound** | **Upper Bound** | **Adjustment** | 
| --- | --- | --- | 
|  0  |  10  |  0  | 
|  10  |  20  |  10  | 
|  20  |  null  |  30  | 


**Example: Step adjustments for scale\-in policy**  

| **Lower Bound** | **Upper Bound** | **Adjustment** | 
| --- | --- | --- | 
|  \-10  |  0  |  0  | 
|  \-20  |  \-10  |  \-10  | 
|  null  |  \-20  |  \-30  | 

This creates the following scaling configuration\.

```
Metric value

-infinity          30%    40%          60%     70%             infinity
-----------------------------------------------------------------------
          -30%      | -10% | Unchanged  | +10%  |       +30%        
-----------------------------------------------------------------------
```

The following points summarize the behavior of the scaling configuration in relation to the desired and current capacity of the scalable target:
+ The current and desired capacity is maintained while the aggregated metric value is greater than 40 and less than 60\.
+ If the metric value gets to 60, Application Auto Scaling increases the desired capacity of the scalable target by 1, to 11\. That's based on the second step adjustment of the scale\-out policy \(add 10 percent of 10\)\. After the new capacity is added, Application Auto Scaling increases the current capacity to 11\. If the metric value rises to 70 even after this increase in capacity, Application Auto Scaling increases the target capacity by 3, to 14\. That's based on the third step adjustment of the scale\-out policy \(add 30 percent of 11, 3\.3, rounded down to 3\)\.
+ If the metric value gets to 40, Application Auto Scaling decreases the target capacity by 1, to 13, based on the second step adjustment of the scale\-in policy \(remove 10 percent of 14, 1\.4, rounded down to 1\)\. If the metric value falls to 30 even after this decrease in capacity, Application Auto Scaling decreases the target capacity by 3, to 10, based on the third step adjustment of the scale\-in policy \(remove 30 percent of 13, 3\.9, rounded down to 3\)\.

When you specify the step adjustments for your scaling policy, note the following:
+ The ranges of your step adjustments can't overlap or have a gap\.
+ Only one step adjustment can have a null lower bound \(negative infinity\)\. If one step adjustment has a negative lower bound, then there must be a step adjustment with a null lower bound\.
+ Only one step adjustment can have a null upper bound \(positive infinity\)\. If one step adjustment has a positive upper bound, then there must be a step adjustment with a null upper bound\.
+ The upper and lower bound can't be null in the same step adjustment\.
+ If the metric value is above the breach threshold, the lower bound is inclusive and the upper bound is exclusive\. If the metric value is below the breach threshold, the lower bound is exclusive and the upper bound is inclusive\.

## Scaling Adjustment Types<a name="as-scaling-adjustment"></a>

You can define a scaling policy that performs the optimal scaling action, based on the scaling adjustment type that you choose\. You can specify the adjustment type as a percentage of the current capacity of your scalable target or in absolute numbers\.

Application Auto Scaling supports the following adjustment types for step scaling policies:
+ **ChangeInCapacity**—Increase or decrease the current capacity of the scalable target by the specified value\. A positive value increases the capacity and a negative value decreases the capacity\. For example: If the current capacity is 3 and the adjustment is 5, then Application Auto Scaling adds 5 to the capacity for a total of 8\.
+ **ExactCapacity**—Change the current capacity of the scalable target to the specified value\. Specify a positive value with this adjustment type\. For example: If the current capacity is 3 and the adjustment is 5, then Application Auto Scaling changes the capacity to 5\.
+ **PercentChangeInCapacity**—Increase or decrease the current capacity of the scalable target by the specified percentage\. A positive value increases the capacity and a negative value decreases the capacity\. For example: If the current capacity is 10 and the adjustment is 10 percent, then Application Auto Scaling adds 1 to the capacity for a total of 11\. 
**Note**  
If the resulting value is not an integer, Application Auto Scaling rounds it as follows:  
Values greater than 1 are rounded down\. For example, `12.7` is rounded to `12`\.
Values between 0 and 1 are rounded to 1\. For example, `.67` is rounded to `1`\.
Values between 0 and \-1 are rounded to \-1\. For example, `-.58` is rounded to `-1`\.
Values less than \-1 are rounded up\. For example, `-6.67` is rounded to `-6`\.

  With **PercentChangeInCapacity**, you can also specify the minimum amount to scale using the `MinAdjustmentMagnitude` parameter\. For example, suppose that you create a policy that adds 25 percent and you specify a minimum amount of 2\. If the scalable target has a capacity of 4 and the scaling policy is performed, 25 percent of 4 is 1\. However, because you specified a minimum increment of 2, Application Auto Scaling adds 2\.

## Cooldown Period<a name="step-scaling-cooldown"></a>

The *cooldown period* is the amount of time, in seconds, after a scaling activity completes where previous trigger\-related scaling activities can influence future scaling events\.

While the cooldown period is in effect, capacity added by the initiating scale\-out event is calculated as part of the desired capacity for the next scale\-out event\. The intention is to continuously \(but not excessively\) scale out\. For example, when an alarm triggers a step scaling policy to increase the capacity by 2, the scaling activity completes successfully and a cooldown period starts\. If the alarm triggers again during the cooldown period but at a more aggressive step adjustment of 3, the previous increase of 2 is considered part of the current capacity\. Therefore, only 1 is added to the capacity\.

For scale\-in policies, the cooldown period is used to block subsequent scale\-in events until it has expired\. The intention is to scale in conservatively to protect your application's availability\. However, if another alarm triggers a scale\-out policy during the cooldown period after a scale\-in event, Application Auto Scaling scales out your scalable target immediately\.

## Register Scalable Target<a name="step-scaling-register-scalable-target"></a>

Before you can create a scaling policy, you must register the scalable target\. Use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command to register a new scalable target\. 

The following example registers an Amazon ECS service with Application Auto Scaling\. Application Auto Scaling can scale the number of tasks at a minimum of 2 tasks and a maximum of 10\. 

```
aws application-autoscaling register-scalable-target --service-namespace ecs \
--scalable-dimension ecs:service:DesiredCount \
--resource-id service/default/sample-app-service \
--min-capacity 2 --max-capacity 10
```

**Note**  
When you configure scaling policies in the console, this automatically registers the resource as a scalable target with Application Auto Scaling\. For more information, see the documentation in the [Getting Started with Application Auto Scaling](getting-started.md) section\.

## Configure Step Scaling Policies Using the AWS CLI<a name="create-step-scaling-policy"></a>

You can create step scaling policies that tell Application Auto Scaling what to do when the load on the application changes\.

The following is an example step configuration with an adjustment type of `ChangeInCapacity` that increases the capacity of the scalable target based on the following step adjustments \(assuming a CloudWatch alarm threshold of 70 percent\): 
+ Increase capacity by 1 when the value of the metric is greater than or equal to 70 percent but less than 85 percent 
+ Increase capacity by 2 when the value of the metric is greater than or equal to 85 percent but less than 95 percent 
+ Increase capacity by 3 when the value of the metric is greater than or equal to 95 percent 

Save this configuration in a file named `config.json`\.

```
{
  "AdjustmentType": "ChangeInCapacity",
  "MetricAggregationType": "Average",
  "Cooldown": 60,
  "StepAdjustments": [ 
    {
      "MetricIntervalLowerBound": 0,
      "MetricIntervalUpperBound": 15,
      "ScalingAdjustment": 1
    },
    {
      "MetricIntervalLowerBound": 15,
      "MetricIntervalUpperBound": 25,
      "ScalingAdjustment": 2
    },
    {
      "MetricIntervalLowerBound": 25,
      "ScalingAdjustment": 3
    }
  ]
}
```

Use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scaling-policy.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scaling-policy.html) command, along with the `config.json` file that you created, to create a scaling policy named `my-step-scaling-policy`:

```
aws application-autoscaling put-scaling-policy --service-namespace ecs \
  --scalable-dimension ecs:service:DesiredCount \
  --resource-id service/default/sample-app-service \
  --policy-name my-step-scaling-policy --policy-type StepScaling \
  --step-scaling-policy-configuration file://config.json
```

The output includes the ARN that serves as a unique name for the policy\. You need it to create CloudWatch alarms\.

```
{
    "PolicyARN": "arn:aws:autoscaling:region:123456789012:scalingPolicy:ac542982-cbeb-4294-891c-a5a941dfa787:resource/ecs/service/default/sample-app-service:policyName/my-step-scaling-policy"
}
```

Finally, use the following CloudWatch [https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/put-metric-alarm.html](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/put-metric-alarm.html) command to create an alarm to use with your step scaling policy\. In this example, you have an alarm based on average CPU utilization\. The alarm is configured to be in an ALARM state if it reaches a threshold of 70 percent for at least two consecutive evaluation periods of 60 seconds\. To specify a different CloudWatch metric or use your own custom metric, specify its name in `--metric-name` and its namespace in `--namespace`\. 

```
aws cloudwatch put-metric-alarm --alarm-name Step-Scaling-AlarmHigh-ECS:service/default/sample-app-service \
  --metric-name CPUUtilization --namespace AWS/ECS --statistic Average \
  --period 60 --evaluation-periods 2 --threshold 70 \
  --comparison-operator GreaterThanOrEqualToThreshold \
  --dimensions Name=ClusterName,Value=default Name=ServiceName,Value=sample-app-service \
  --alarm-actions PolicyARN
```

## Describe Step Scaling Policies<a name="describe-step-scaling-policy"></a>

You can describe all scaling policies for the specified service namespace using the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-policies.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-policies.html) command\.

```
aws application-autoscaling describe-scaling-policies --service-namespace ecs
```

You can filter the results to just the step scaling policies using the `--query` parameter\. This syntax for `query` works on Linux or macOS\. On Windows, change the single quotes to double quotes\.

```
aws application-autoscaling describe-scaling-policies --service-namespace ecs \
  --query 'ScalingPolicies[?PolicyType==`StepScaling`]'
```

The following is example output\.

```
[
    {
        "PolicyARN": "PolicyARN",
        "StepScalingPolicyConfiguration": {
            "MetricAggregationType": "Average",
            "Cooldown": 60,
            "StepAdjustments": [
                {
                    "MetricIntervalLowerBound": 0.0,
                    "MetricIntervalUpperBound": 15.0,
                    "ScalingAdjustment": 1
                },
                {
                    "MetricIntervalLowerBound": 15.0,
                    "MetricIntervalUpperBound": 25.0,
                    "ScalingAdjustment": 2
                },
                {
                    "MetricIntervalLowerBound": 25.0,
                    "ScalingAdjustment": 3
                }
            ],
            "AdjustmentType": "ChangeInCapacity"
        },
        "PolicyType": "StepScaling",
        "ResourceId": "service/default/sample-app-service",
        "ServiceNamespace": "ecs",
        "Alarms": [
            {
                "AlarmName": "Step-Scaling-AlarmHigh-ECS:service/default/sample-app-service",
                "AlarmARN": "arn:aws:cloudwatch:region:012345678910:alarm:Step-Scaling-AlarmHigh-ECS:service/default/sample-app-service"
            }
        ],
        "PolicyName": "my-step-scaling-policy",
        "ScalableDimension": "ecs:service:DesiredCount",
        "CreationTime": 1515024099.901
    }
]
```

## Delete a Step Scaling Policy<a name="delete-step-scaling-policy"></a>

When you no longer need a step scaling policy, you can delete it\. To delete both the scaling policy and the CloudWatch alarm, complete the following tasks\. 

**To delete your scaling policy**  
Use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scaling-policy.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scaling-policy.html) command\.

```
aws application-autoscaling delete-scaling-policy --service-namespace ecs \
  --scalable-dimension ecs:service:DesiredCount \
  --resource-id service/default/sample-app-service \
  --policy-name my-step-scaling-policy
```

**To delete the CloudWatch alarm**  
Use the [https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/delete-alarms.html](https://docs.aws.amazon.com/cli/latest/reference/cloudwatch/delete-alarms.html) command\. You can delete one or more alarms at a time\. For example, use the following command to delete the `Step-Scaling-AlarmHigh-ECS:service/default/sample-app-service` and `Step-Scaling-AlarmLow-ECS:service/default/sample-app-service` alarms\.

```
aws cloudwatch delete-alarms --alarm-name Step-Scaling-AlarmHigh-ECS:service/default/sample-app-service Step-Scaling-AlarmLow-ECS:service/default/sample-app-service
```