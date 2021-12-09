# Target Tracking Scaling Policies for Application Auto Scaling<a name="application-auto-scaling-target-tracking"></a>

With target tracking scaling policies, you choose a scaling metric and set a target value\. Application Auto Scaling creates and manages the CloudWatch alarms that trigger the scaling policy and calculates the scaling adjustment based on the metric and the target value\. The scaling policy adds or removes capacity as required to keep the metric at, or close to, the specified target value\. In addition to keeping the metric close to the target value, a target tracking scaling policy also adjusts to changes in the metric due to a changing load pattern\.

You can have one or more target tracking scaling policies, one or more step scaling policies, or both\. Application Auto Scaling scales based on the policy that provides the largest capacity for both scale in and scale out\. This provides greater flexibility to cover multiple scenarios and ensures that there is always enough capacity to process your application workloads\.

**Limits**
+ Target tracking scaling policies are not supported for Amazon EMR\.
+ You cannot use Application Auto Scaling to create or update a scaling policy that's used with the AWS Auto Scaling service\. For information about the AWS Auto Scaling console, CLI, or API actions, see the [AWS Auto Scaling](https://docs.aws.amazon.com/autoscaling/index.html#lang/en_us) documentation\.
+ You can use Application Auto Scaling to apply a target tracking scaling policy based on a predefined or CloudWatch customized metric\. Not all services allow you to manage customized metrics through the console, however\. To see if a service supports customized metrics in the console, consult the documentation for that service\.

## Considerations<a name="target-tracking-considerations"></a>

Keep the following considerations in mind:
+ Not all metrics work for target tracking\. This can be important when you are specifying a customized metric\. The metric must be a valid utilization metric and describe how busy a scalable target is\. The metric value must increase or decrease proportionally to the capacity of the scalable target so that the metric data can be used to proportionally scale the scalable target\.
+ Wherever possible, you should scale on metrics with a 1\-minute frequency because that ensures a faster response to utilization changes\.
+ A target tracking scaling policy assumes that it should perform scale out when the specified metric is above the target value\. You cannot use a target tracking scaling policy to scale out when the specified metric is below the target value\.
+ A target tracking scaling policy does not perform scaling when the specified metric has insufficient data, for example, because of a network connectivity issue\. It does not perform scale in because it does not interpret insufficient data as low utilization\. 
+ You may see gaps between the target value and the actual metric data points\. This is because Application Auto Scaling always acts conservatively by rounding up or down when it determines how much capacity to add or remove\. This prevents it from adding insufficient capacity or removing too much capacity\. However, for a scalable target with a small capacity, the actual metric data points might seem far from the target value\. 
+ For a scalable target with a larger capacity, adding or removing capacity causes less of a gap between the target value and the actual metric data points\.
+ To ensure application availability, Application Auto Scaling scales out proportionally to the metric as fast as it can, but scales in more gradually\.
+ You can have multiple target tracking scaling policies for a scalable target, provided that each of them uses a different metric\. The intention of Application Auto Scaling is to always prioritize availability, so its behavior differs depending on whether the target tracking policies are ready for scale out or scale in\. It will scale out the scalable target if any of the target tracking policies are ready for scale out, but will scale in only if all of the target tracking policies \(with the scale\-in portion enabled\) are ready to scale in\.
+ You can disable the scale\-in portion of a target tracking scaling policy\. This feature provides the flexibility to use a different method for scale in than you use for scale out\. For example, you can use a different scaling policy type for scale in while using a target tracking scaling policy for scale out\. 
+ Do not edit or delete the CloudWatch alarms that are configured for the target tracking scaling policy\. CloudWatch alarms that are associated with your target tracking scaling policies are deleted automatically when you delete the scaling policies\.

## Cooldown Period<a name="target-tracking-cooldown"></a>

The *scale\-out cooldown period* is the amount of time, in seconds, after a scale\-out activity completes before another scale\-out activity can start\. While this cooldown period is in effect, the capacity added by the initiating scale\-out event is calculated as part of the desired capacity for the next scale\-out event\. The intention is to continuously \(but not excessively\) scale out\.

The *scale\-in cooldown period* is the amount of time, in seconds, after a scale\-in activity completes before another scale\-in activity can start\. This cooldown period is used to block subsequent scale\-in events until it has expired\. The intention is to scale in conservatively to protect your application's availability\. However, if another alarm triggers a scale\-out policy during the cooldown period after a scale\-in event, Application Auto Scaling scales out your scalable target immediately\.

## Register Scalable Target<a name="target-tracking-register-scalable-target"></a>

Before you can create a scaling policy, you must register the scalable target\. Use the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/register-scalable-target.html) command to register a new scalable target\. 

The following example registers a Spot Fleet request with Application Auto Scaling\. Application Auto Scaling can scale the number of instances in the Spot Fleet at a minimum of 2 instances and a maximum of 10\. 

```
aws application-autoscaling register-scalable-target --service-namespace ec2 \
  --scalable-dimension ec2:spot-fleet-request:TargetCapacity \
  --resource-id spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE \
  --min-capacity 2 --max-capacity 10
```

**Note**  
When you configure scaling policies in the console, this automatically registers the resource as a scalable target with Application Auto Scaling\. For more information, see the documentation in the [Getting Started with Application Auto Scaling](getting-started.md) section\. 

## Create a Target Tracking Scaling Policy<a name="create-target-tracking-policy"></a>

You can create target tracking scaling policies that tell Application Auto Scaling to scale out or scale in automatically when the load on the application changes\. 

The following is an example target tracking configuration that keeps the average CPU utilization at 40 percent\. Save this configuration in a file named `config.json`\.

```
{
  "TargetValue": 40.0,
  "PredefinedMetricSpecification": 
    {
      "PredefinedMetricType": "EC2SpotFleetRequestAverageCPUUtilization"
    }
}
```

Alternatively, you can customize the metric used for scaling by creating a customized metric specification and adding values for each parameter from CloudWatch\. The following is an example target tracking configuration that keeps the average utilization of the specified metric at 40 percent\.

```
{
   "TargetValue":40.0,
   "CustomizedMetricSpecification":{
      "MetricName":"MyUtilizationMetric",
      "Namespace":"MyNamespace",
      "Dimensions":[
         {
            "Name":"MyOptionalMetricDimensionName",
            "Value":"MyOptionalMetricDimensionValue"
         }
      ],
      "Statistic":"Average",
      "Unit":"Percent"
   }
}
```

Use the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scaling-policy.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/put-scaling-policy.html) command, along with the `config.json` file you created, to create a scaling policy named `cpu40-target-tracking-scaling-policy`\.

```
aws application-autoscaling put-scaling-policy --service-namespace ec2 \
  --scalable-dimension ec2:spot-fleet-request:TargetCapacity \
  --resource-id spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE \
  --policy-name cpu40-target-tracking-scaling-policy --policy-type TargetTrackingScaling \
  --target-tracking-scaling-policy-configuration file://config.json
```

The following is example output\. It contains the ARNs and names of the two CloudWatch alarms created on your behalf\.

```
{
    "PolicyARN": "arn:aws:autoscaling:region:account-id:scalingPolicy:policy-id:resource/ec2/spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE:policyName/cpu40-target-tracking-scaling-policy",
    "Alarms": [
        {
            "AlarmARN": "arn:aws:cloudwatch:region:account-id:alarm:TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmHigh-d4f0770c-b46e-434a-a60f-3b36d653feca",
            "AlarmName": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmHigh-d4f0770c-b46e-434a-a60f-3b36d653feca"
        },
        {
            "AlarmARN": "arn:aws:cloudwatch:region:account-id:alarm:TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmLow-1b437334-d19b-4a63-a812-6c67aaf2910d",
            "AlarmName": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmLow-1b437334-d19b-4a63-a812-6c67aaf2910d"
        }
    ]
}
```

## Describe Target Tracking Scaling Policies<a name="describe-target-tracking-policy"></a>

You can describe all scaling policies for the specified service namespace using the following [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-policies.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/describe-scaling-policies.html) command\.

```
aws application-autoscaling describe-scaling-policies --service-namespace ec2
```

You can filter the results to just the target tracking scaling policies using the `--query` parameter\. This syntax for `query` works on Linux or macOS\. On Windows, change the single quotes to double quotes\.

```
aws application-autoscaling describe-scaling-policies --service-namespace ec2 \
  --query 'ScalingPolicies[?PolicyType==`TargetTrackingScaling`]'
```

The following is example output\.

```
[
    {
        "PolicyARN": "PolicyARN",
        "TargetTrackingScalingPolicyConfiguration": {
            "PredefinedMetricSpecification": {
                "PredefinedMetricType": "EC2SpotFleetRequestAverageCPUUtilization"
            },
            "TargetValue": 40.0
        },
        "PolicyName": "cpu40-target-tracking-scaling-policy",
        "ScalableDimension": "ec2:spot-fleet-request:TargetCapacity",
        "ServiceNamespace": "ec2",
        "PolicyType": "TargetTrackingScaling",
        "ResourceId": "spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE",
        "Alarms": [
            {
                "AlarmName": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmHigh-d4f0770c-b46e-434a-a60f-3b36d653feca",
                "AlarmARN": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmHigh-d4f0770c-b46e-434a-a60f-3b36d653feca"
            },
            {
                "AlarmName": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmLow-1b437334-d19b-4a63-a812-6c67aaf2910d",
                "AlarmARN": "TargetTracking-spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE-AlarmLow-1b437334-d19b-4a63-a812-6c67aaf2910d"
            }
        ],
        "CreationTime": 1515021724.807
    }
]
```

## Delete a Target Tracking Scaling Policy<a name="delete-target-tracking-policy"></a>

When you are finished with a target tracking scaling policy, you can delete it using the [https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scaling-policy.html](https://docs.aws.amazon.com/cli/latest/reference/application-autoscaling/delete-scaling-policy.html) command\.

The following command deletes the specified target tracking scaling policy for the specified Spot Fleet request\. It also deletes the CloudWatch alarms that Application Auto Scaling created on your behalf\.

```
aws application-autoscaling delete-scaling-policy --service-namespace ec2 \
  --scalable-dimension ec2:spot-fleet-request:TargetCapacity \
  --resource-id spot-fleet-request/sfr-73fbd2ce-aa30-494c-8788-1cee4EXAMPLE \
  --policy-name cpu40-target-tracking-scaling-policy
```