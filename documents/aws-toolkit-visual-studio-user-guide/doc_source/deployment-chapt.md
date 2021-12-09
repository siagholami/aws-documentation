# Deployment Using the AWS Toolkit<a name="deployment-chapt"></a>

The Toolkit for Visual Studio supports application deployment to AWS Elastic Beanstalk containers or AWS CloudFormation stacks\.
+  [Deploying to Elastic Beanstalk](deployment-beanstalk.md#tkv-deploy-beanstalk) describes how to use the Visual Studio IDE to deploy applications to Elastic Beanstalk\.
+  [Deploying to Amazon EC2 Container Service](deployment-ecs.md#tkv-deploy-ecs) describes how to use the Visual Studio IDE to deploy applications to Amazon ECS\.
+  [Standalone Deployment Tool](deployment-tool.md#tkv-deployment-tool) describes how to use the standalone deployment tool to deploy to either Elastic Beanstalk containers or AWS CloudFormation stacks from a command window\.

**Note**  
If you are using Visual Studio Express Edition:  
You can use the [standalone deployment tool](deployment-tool.md#tkv-deployment-tool) to deploy applications to Elastic Beanstalk containers\.
You can use the [Docker CLI](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/docker-basics.use-ecr.html) to deploy applications to Amazon ECS containers\.
You can use the [AWS Management Console](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/using-features.deployment.newapp.html) to deploy applications to Elastic Beanstalk containers\.
For Elastic Beanstalk deployments, you must first create a web deployment package\. For more information, see [How to: Create a Web Deployment Package in Visual Studio](http://msdn.microsoft.com/en-us/library/dd465323.aspx)\. For Amazon ECS deployment, you must have a Docker image\. For more information, see [Visual Studio Tools for Docker](http://docs.microsoft.com/en-us/aspnet/core/publishing/visual-studio-tools-for-docker)\.

**Topics**
+ [Deploying to Elastic Beanstalk](deployment-beanstalk.md)
+ [Deploying to Amazon EC2 Container Service](deployment-ecs.md)
+ [Standalone Deployment Tool](deployment-tool.md)