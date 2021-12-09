# How Scaling Plans Work<a name="how-it-works"></a>

A scaling plan is the core component of AWS Auto Scaling\. It's where you configure a set of instructions for scaling your resources\. If you work with AWS CloudFormation or add tags to AWS resources, you can set up scaling plans for different sets of resources, per application\. AWS Auto Scaling provides recommendations for scaling strategies customized to each resource\. After you create your scaling plan, AWS Auto Scaling combines dynamic scaling and predictive scaling methods together to support your scaling strategy\.

**What is a scaling strategy?**  
The scaling strategy tells AWS Auto Scaling how to optimize the utilization of resources in your scaling plan\. You can optimize for availability, for cost, or a balance of both\. Alternatively, you can also create your own custom strategy, per the metrics and thresholds you define\. You can set separate strategies for each resource or resource type\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/autoscaling/plans/userguide/images/strategies.png)

**What is dynamic scaling?**  
Dynamic scaling creates target tracking scaling policies for the resources in your scaling plan\. These scaling policies adjust resource capacity in response to live changes in resource utilization\. The intention is to provide enough capacity to maintain utilization at the target value specified by the scaling strategy\. This is similar to the way that your thermostat maintains the temperature of your home\. You choose the temperature and the thermostat does the rest\. 

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/autoscaling/plans/userguide/images/dynamic-scaling.png)

For example, you can configure your scaling plan to keep the number of tasks that your ECS service runs at 75 percent of CPU\. When the CPU utilization of your service rises above 75 percent \(meaning that more than 75 percent of the CPU that is reserved for the service is being used\), this triggers your scaling policy to add another task to your service to help out with the increased load\.

**What is predictive scaling?**  
Predictive scaling uses machine learning to analyze each resource's historical workload and regularly forecasts the future load for the next two days\. This is similar to how weather forecasts work\. Using the forecast, predictive scaling generates scheduled scaling actions to make sure that the resource capacity is available before your application needs it\. Like dynamic scaling, predictive scaling works to maintain utilization at the target value specified by the scaling strategy\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/autoscaling/plans/userguide/images/predictive-scaling.png)

For example, you can enable predictive scaling and configure your scaling strategy to keep the average CPU utilization of your Auto Scaling group at 50 percent\. Your forecast calls for traffic spikes to occur every day at 8 o'clock in the morning\. Your scaling plan creates the future scheduled scaling actions to make sure that your Auto Scaling group is ready to handle that traffic ahead of time\. This helps keep the application performance constant, with the aim of always having the capacity required to maintain resource utilization as close to 50 percent as possible at all times\.