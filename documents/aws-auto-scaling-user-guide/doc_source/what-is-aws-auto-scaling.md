# What Is AWS Auto Scaling?<a name="what-is-aws-auto-scaling"></a>

AWS Auto Scaling enables you to configure automatic scaling for the AWS resources that are part of your application in a matter of minutes\. The AWS Auto Scaling console provides a single user interface to use the automatic scaling features of multiple AWS services\. You can configure automatic scaling for individual resources or for whole applications\. 

With AWS Auto Scaling, you configure and manage scaling for your resources through a scaling plan\. The scaling plan uses dynamic scaling and predictive scaling to automatically scale your application’s resources\. This ensures that you add the required computing power to handle the load on your application and then remove it when it's no longer required\. The scaling plan lets you choose scaling strategies to define how to optimize your resource utilization\. You can optimize for availability, for cost, or a balance of both\. Alternatively, you can create custom scaling strategies\. 

AWS Auto Scaling is useful for applications that experience daily or weekly variations in traffic flow, including the following:
+ Cyclical traffic such as high use of resources during regular business hours and low use of resources overnight
+ On and off workload patterns, such as batch processing, testing, or periodic analysis
+ Variable traffic patterns, such as marketing campaigns with periods of spiky growth

## Features of AWS Auto Scaling<a name="scalable-resources"></a>

Use AWS Auto Scaling to automatically scale the following resources:
+ **Amazon EC2 Auto Scaling groups**: Launch or terminate EC2 instances in an Auto Scaling group\. 
+ **Amazon EC2 Spot Fleet requests**: Launch or terminate instances from a Spot Fleet request, or automatically replace instances that get interrupted for price or capacity reasons\. 
+ **Amazon ECS**: Adjust the ECS service desired count up or down in response to load variations\.
+ **Amazon DynamoDB**: Enable a DynamoDB table or a global secondary index to increase or decrease its provisioned read and write capacity to handle increases in traffic without throttling\. 
+ **Amazon Aurora**: Dynamically adjust the number of Aurora read replicas provisioned for an Aurora DB cluster to handle changes in active connections or workload\. 

The scaling features currently available are dynamic scaling and predictive scaling\. 

Dynamic scaling creates target tracking scaling policies for the scalable resources in your application\. This lets your scaling plan add and remove capacity for each resource as required to maintain resource utilization at the specified target value\. The default scaling metrics provided are based on the most commonly used metrics used for automatic scaling\. 

How predictive scaling works:
+ **Load forecasting**: AWS Auto Scaling analyzes up to 14 days of history for a specified load metric and forecasts the future demand for the next two days\. This data is available in one\-hour intervals and updated daily\. 
+ **Scheduled scaling actions**: AWS Auto Scaling schedules the scaling actions that proactively add and remove resource capacity to reflect the load forecast\. At the scheduled time, AWS Auto Scaling updates the resource's minimum capacity with the value specified by the scheduled scaling action\. The intention is to maintain resource utilization at the target value specified by the scaling strategy\. If your application requires more capacity than is forecast, dynamic scaling is available to add additional capacity\.
+ **Maximum capacity behavior**: Each resource has a minimum and a maximum capacity limit between which the value specified by the scheduled scaling action is expected to lie\. However, you can control whether your application can add resources beyond their maximum capacity when the forecast capacity is higher than the maximum capacity\. 

Currently, predictive scaling is only available for Amazon EC2 Auto Scaling groups\. 

## Pricing<a name="pricing"></a>

AWS Auto Scaling features are enabled by Amazon CloudWatch metrics and alarms\. The features are provided at no additional charge beyond the service fees for CloudWatch and the other AWS resources that you use\.

## How to Get Started<a name="how-to-get-started"></a>

For an introduction to AWS Auto Scaling, we recommend that you familiarize yourself with the following: 
+ [How Scaling Plans Work](how-it-works.md)—This introduces the concepts of scaling strategies, dynamic scaling, and predictive scaling to help you get familiar with AWS Auto Scaling\.
+ [AWS Auto Scaling FAQs](https://aws.amazon.com/autoscaling/faqs/)—The FAQ on the product page provides information about the benefits of this service\.
+ [AWS Auto Scaling Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/autoscaling_region.html) in the *AWS General Reference*—This page shows you the Regional availability of AWS Auto Scaling\. 
+ [Amazon EC2 Auto Scaling User Guide](https://docs.aws.amazon.com/autoscaling/ec2/userguide/)—This guide shows you how to create and manage the Auto Scaling groups to use when scaling your fleet of Amazon EC2 instances\.
+ [Application Auto Scaling User Guide](https://docs.aws.amazon.com/autoscaling/application/userguide/)—This guide provides you with topics and resources related to automatic scaling of resources beyond Amazon EC2\. Whenever you need more information specific to scaling an individual scalable resource or service other than Amazon EC2, you can access the technical documentation from this guide\.

To get started, complete the getting started tutorial for AWS Auto Scaling in [Getting Started with AWS Auto Scaling](auto-scaling-getting-started.md)\.

## Related Services<a name="related-services"></a>

[AWS CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/) allows you to use templates, which are formatted text files in JSON or YAML, to model and provision a collection of related AWS resources\. You can use AWS CloudFormation sample templates or create your own templates to create the AWS resources, and any associated dependencies or runtime parameters, required to run your application\. You can also create templates of scaling plans using AWS CloudFormation\.

[Amazon CloudWatch](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/) is a monitoring service for AWS Cloud resources and the applications you run on AWS\. CloudWatch lets you collect and track metrics, log files, and automatically react to changes in your applications using alarms\. You can also publish your own custom metrics to CloudWatch using the AWS CLI or an API\.