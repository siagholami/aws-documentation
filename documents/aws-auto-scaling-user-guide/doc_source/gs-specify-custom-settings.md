# Step 3: Configure Advanced Settings \(Optional\)<a name="gs-specify-custom-settings"></a>

Now that you have specified the scaling strategy to use for each resource type, you can choose to customize any of the default settings on a per resource basis using the **Configure advanced settings** step\. For each resource type, there are multiple groups of settings that you can customize\. In most cases, however, the default settings should be optimal, with the possible exception of the values for minimum capacity and maximum capacity, which should be carefully adjusted\.

Skip this procedure if you would like to keep the default settings\. You can change these settings anytime by editing the scaling plan\.

**Important**  
For the beginner tutorial, let's make a few changes to update the maximum capacity of your Auto Scaling group and enable predictive scaling in forecast only mode\. Although you do not need to customize all of the settings for the tutorial, let's also briefly examine the settings in each section\. 

## General Settings<a name="gs-customize-general-scaling"></a>

Use this procedure to view and customize the settings you specified in the previous step, on a per resource basis\. You can also customize the minimum capacity and maximum capacity for each resource\. 

**To view and customize the general settings**

1. On the **Configure advanced settings** page, choose the arrow to the left of any of the section headings to expand the section\. For the tutorial, expand the **Auto Scaling groups** section\.

1. From the table that's displayed, choose the Auto Scaling group that you are using in this tutorial\. 

1. Leave the **Include in scaling plan** option selected\. If this option is not selected, the resource is omitted from the scaling plan\. If you do not include at least one resource, the scaling plan cannot be created\. 

1. To expand the view and see the details of the **General Settings** section, choose the arrow to the left of the section heading\.

1. You can make choices for any of the following items\. For this tutorial, locate the **Maximum capacity** setting and enter a value of `3` in place of the current value\. 
   + **Scaling strategy**—Allows you to optimize for availability, cost, or a balance of both, or to specify a custom strategy\.
   + **Enable dynamic scaling**—If this setting is cleared, the selected resource cannot scale using a target tracking scaling configuration\.
   + **Enable predictive scaling**—\[Auto Scaling groups only\] If this setting is cleared, the selected group cannot scale using predictive scaling\.
   + **Scaling metric**—Specifies the scaling metric to use\. If you choose **Custom**, you can specify a customized scaling metric to use instead of the scaling metrics that are available in the console\. For more information, see the next topic in this section\.
   + **Target value**—Specifies the target utilization value to use\.
   + **Load metric**—\[Auto Scaling groups only\] Specifies the load metric to use\. If you choose **Custom**, you can specify a customized load metric to use instead of the load metrics that are available in the console\. For more information, see the next topic in this section\.
   + **Minimum capacity**—Specifies the minimum capacity for the resource\. AWS Auto Scaling ensures that your resource never goes below this size\.
   + **Maximum capacity**—Specifies the maximum capacity for the resource\. AWS Auto Scaling ensures that your resource never goes above this size\. 
**Note**  
When you use predictive scaling, you can optionally choose a different maximum capacity behavior to use based on the forecast capacity\. This setting is in the **Predictive scaling settings** section\.

### Customized Metrics Specification<a name="gs-customized-metric-specification"></a>

AWS Auto Scaling provides the most commonly used metrics for automatic scaling\. However, depending on your needs, you might prefer to get data from different metrics instead of the metrics in the console\. Amazon CloudWatch has many different metrics to choose from\. CloudWatch also lets you publish your own metrics\. 

You use JSON to specify a CloudWatch customized metric\. Before you follow these instructions, we recommend that you become familiar with the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

To specify a customized metric, you construct a JSON\-formatted payload using a set of required parameters from a template\. You add the values for each parameter from CloudWatch\. We provide the template as part of the custom options for **Scaling metric** and **Load metric** in the advanced settings of your scaling plan\. 

JSON represents data in two ways:
+ An *object*, which is an unordered collection of name\-value pairs\. An object is defined within left \(\{\) and right \(\}\) braces\. Each name\-value pair begins with the name, followed by a colon, followed by the value\. Name\-value pairs are comma\-separated\. 
+ An *array*, which is an ordered collection of values\. An array is defined within left \(\[\) and right \(\]\) brackets\. Items in the array are comma\-separated\. 

Here is an example of the JSON template with sample values for each parameter: 

```
 {
   "MetricName": "MyBackendCPU",
   "Namespace": "MyNamespace",
   "Dimensions": [
     {
       "Name": "MyOptionalMetricDimensionName",
       "Value": "MyOptionalMetricDimensionValue"
     }
   ],
   "Statistic": "Sum"
 }
```

For more information, see [Customized Scaling Metric Specification](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_CustomizedScalingMetricSpecification.html) and [Customized Load Metric Specification](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_CustomizedLoadMetricSpecification.html) in the *AWS Auto Scaling API Reference*\.

## Dynamic Scaling Settings<a name="gs-customize-dynamic-scaling"></a>

Use this procedure to view and customize the settings for the target tracking scaling policy that AWS Auto Scaling creates\. 

**To view and customize the settings for dynamic scaling**

1. To expand the view and see the details of the **Dynamic scaling settings** section, choose the arrow to the left of the section heading\. 

1. You can make choices for the following items\. However, the default settings are fine for this tutorial\. 
   + **Replace external scaling policies**—If this setting is cleared, it keeps existing scaling policies created from outside of this scaling plan, and does not create new ones\. 
   + **Disable scale\-in**—If this setting is cleared, automatic scale\-in to decrease the current capacity of the resource is allowed when the specified metric is below the target value\. 
   + **Cooldown**—Creates scale\-out and scale\-in cooldown periods\. Cooldown periods are the amount of time after a scale\-out or scale\-in activity completes before another activity can start\. The intention is to give newly provisioned resources time to start handling demand before triggering a new scaling action\. This setting is not available if the resource is an Auto Scaling group\. For more information, see [Cooldown Period](https://docs.aws.amazon.com/autoscaling/application/userguide/application-auto-scaling-target-tracking.html#target-tracking-cooldown) in the *Application Auto Scaling User Guide*\. 
   + **Instance warmup**—\[Auto Scaling groups only\] Controls the amount of time that elapses before a newly launched instance begins contributing to the CloudWatch metrics\. For more information, see [Instance Warmup](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-scaling-target-tracking.html#as-target-tracking-scaling-warmup) in the *Amazon EC2 Auto Scaling User Guide*\.

## Predictive Scaling Settings<a name="gs-customize-predictive-scaling"></a>

If your resource is an Auto Scaling group, use this procedure to view and customize the settings AWS Auto Scaling uses for predictive scaling\. 

**To view and customize the settings for predictive scaling**

1. To expand the view and see the details of the **Predictive scaling settings** section, choose the arrow to the left of the section heading\. 

1. You can make choices for the following items\. For this tutorial, change the **Predictive scaling mode** to **Forecast only**\.
   + **Predictive scaling mode**—Specifies the scaling mode\. The default is **Forecast and scale**\. If you change it to **Forecast only**, the scaling plan forecasts future capacity but doesn't apply the scaling actions\.
   + **Pre\-launch instances**—Adjusts the scaling actions to run earlier when scaling out\. For example, the forecast says to add capacity at 10:00 AM, and the buffer time is 5 minutes \(300 seconds\)\. The runtime of the corresponding scaling action is then 9:55 AM\. This is helpful for Auto Scaling groups, where it can take a few minutes from the time an instance launches until it comes in service\. The actual time can vary as it depends on several factors, such as the size of the instance and whether there are startup scripts to complete\. The default is 300 seconds\.
   + **Max capacity behavior**—Controls whether the selected resource can scale up above the maximum capacity when the forecast capacity is close to or exceeds the currently specified maximum capacity\. The default is **Enforce the maximum capacity setting**\. 
     + **Enforce the maximum capacity setting**—AWS Auto Scaling cannot scale resource capacity higher than the maximum capacity\. The maximum capacity is enforced as a hard limit\. 
     + **Set the maximum capacity to equal forecast capacity**—AWS Auto Scaling can scale resource capacity higher than the maximum capacity to equal but not exceed forecast capacity\.
     + **Increase maximum capacity above forecast capacity**—AWS Auto Scaling can scale resource capacity higher than the maximum capacity by a specified buffer value\. The intention is to give the target tracking scaling policy extra capacity if unexpected traffic occurs\. 
   + **Max capacity behavior buffer**—If you chose **Increase maximum capacity above forecast capacity**, choose the size of the capacity buffer to use when the forecast capacity is close to or exceeds the maximum capacity\. The value is specified as a percentage relative to the forecast capacity\. For example, with a 10 percent buffer, if the forecast capacity is 50, and the maximum capacity is 40, then the effective maximum capacity is 55\. 

1. When you are finished customizing settings, choose **Next**\.
**Note**  
To revert any of your changes, select the resources and choose **Revert to original**\. This resets the selected resources to their last known state within the scaling plan\. 