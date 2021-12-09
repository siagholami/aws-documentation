# Getting Started with Application Auto Scaling<a name="getting-started"></a>

Application Auto Scaling integrates with other AWS services so that you can add scaling capabilities to meet your application's demand\. Automatic scaling is an optional feature of the service that is disabled by default in almost all cases\. 

With Application Auto Scaling, there are two ways to enable automatic scaling: using the service console of the resources that you want to scale, and accessing the Application Auto Scaling API programmatically or through the AWS Command Line Interface \(AWS CLI\)\. You can use either method, or both\. In most cases, you can achieve the same result using either method\.

If you are just getting started with Application Auto Scaling or are exploring the AWS Management Console, we recommend that you refer to the following documentation for sample configurations and to learn more about how the service integrates with Application Auto Scaling\. If a service doesn't include documentation for configuring scaling in the console, you can use the AWS CLI or API to configure scaling\.
+ [Service Auto Scaling](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/service-auto-scaling.html) in the *Amazon Elastic Container Service Developer Guide*
+ [Automatic Scaling for Spot Fleet](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-automatic-scaling.html) in the *Amazon EC2 User Guide*
+ [Using Automatic Scaling in Amazon EMR](https://docs.aws.amazon.com/emr/latest/ManagementGuide/emr-automatic-scaling.html) in the *Amazon EMR Management Guide*
+ [Fleet Auto Scaling for AppStream 2\.0](https://docs.aws.amazon.com/appstream2/latest/developerguide/autoscaling.html) in the *Amazon AppStream 2\.0 Administration Guide*
+ [Managing Throughput Capacity with DynamoDB Auto Scaling](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/AutoScaling.html) in the *Amazon DynamoDB Developer Guide*
+ [Using Amazon Aurora Auto Scaling with Aurora Replicas](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/Aurora.Integrating.AutoScaling.html) in the *Amazon RDS User Guide*
+ [Automatically Scaling Amazon SageMaker Models](https://docs.aws.amazon.com/sagemaker/latest/dg/endpoint-auto-scaling.html) in the *Amazon SageMaker Developer Guide*
+ [Autoscaling with Endpoints](https://docs.aws.amazon.com/comprehend/latest/dg/comprehend-autoscaling.html) in the *Amazon Comprehend Developer Guide*
+ [Managing Concurrency for a Lambda Function](https://docs.aws.amazon.com/lambda/latest/dg/configuration-concurrency.html) in the *AWS Lambda Developer Guide*

This user guide shows how to work with the Application Auto Scaling API using the AWS CLI\. To get started, complete the exercises in [Getting Started Using the AWS CLI](get-started-exercise.md)\. In this tutorial, we show you how to use the AWS CLI to access Application Auto Scaling as a first\-time user\. You learn the basic steps to configure scaling so your DynamoDB table scales at scheduled times\. We chose to use a DynamoDB table as the basis for the tutorial because DynamoDB is available in most Regions, but you can use any supported service that you are comfortable with\.