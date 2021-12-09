# Getting Started with AWS Auto Scaling<a name="auto-scaling-getting-started"></a>

This section describes the steps to begin using AWS Auto Scaling\. You use the AWS Management Console to create your first scaling plan\. Then you learn the basics of creating scaling plans with predictive scaling and dynamic scaling enabled\. 

Before you create a scaling plan for use with your application, review your application thoroughly as it runs in the AWS Cloud\. Take note of the following: 
+ How long it takes to launch and configure a server\.
+ Whether you have existing scaling policies created from other consoles\.
+ What metrics have the most relevance to your application's performance\. 
+ The target utilization that makes sense for each scalable resource in your application based on the resource as a whole\. For example, the target utilization for the full Amazon EC2 Auto Scaling group instead of individual instances\. 
+ Whether the metric history is sufficiently long to use with predictive scaling \(if using newly created Amazon EC2 Auto Scaling groups\)\. In general, having a full 14 days of historical data translates into more accurate forecasts\. The minimum is 24 hours\.

The better you understand your application, the more effective you can make your scaling plan\. 

**Topics**
+ [Step 1: Find Your Scalable Resources](gs-select-application.md)
+ [Step 2: Specify the Scaling Strategy](gs-configure-scaling-plan.md)
+ [Step 3: Configure Advanced Settings \(Optional\)](gs-specify-custom-settings.md)
+ [Step 4: Create Your Scaling Plan](gs-create-scaling-plan.md)
+ [Step 5: Clean Up](gs-delete-scaling-plan.md)
+ [Step 6: Next Steps](gs-next-steps.md)