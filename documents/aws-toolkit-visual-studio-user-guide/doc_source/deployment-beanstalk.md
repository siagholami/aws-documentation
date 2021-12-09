# Deploying to Elastic Beanstalk<a name="deployment-beanstalk"></a>

AWS Elastic Beanstalk is a service that simplifies the process of provisioning AWS resources for your application\. Elastic Beanstalk provides all of the AWS infrastructure required to deploy your application\. This infrastructure includes:
+ Amazon EC2 instances that host the executables and content for your application\.
+ An Auto Scaling group to maintain the appropriate number of Amazon EC2 instances to support your application\.
+ An Elastic Load Balancing load balancer that routes incoming traffic to the Amazon EC2 instance with the most bandwidth\.

The Toolkit for Visual Studio provides a wizard that simplifies publishing applications through Elastic Beanstalk\. This wizard is described in the following sections\.

For more information about Elastic Beanstalk, go to the [Elastic Beanstalk documentation](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/Welcome.html)\.

**Topics**
+ [Deploy an ASP\.NET App \(Traditional\)](deployment-beanstalk-traditional.md)
+ [Deploy an ASP\.NET App \(\.NET Core\)](deployment-beanstalk-netcore.md)
+ [Specify AWS Credentials](deployment-beanstalk-specify-credentials.md)
+ [Republish to Elastic Beanstalk](deployment-beanstalk-republish.md)
+ [Custom Deployments \(Traditional\)](deployment-beanstalk-custom.md)
+ [Custom Deployments \(\.NET Core\)](deployment-beanstalk-custom-netcore.md)
+ [Multiple Application Support](deployment-beanstalk-multiple-application.md)
+ [Deploying to Elastic Beanstalk \(Legacy\)](deployment-beanstalk-legacy.md)
+ [Deploying to AWS CloudFormation \(Legacy\)](deployment-cloudform.md)