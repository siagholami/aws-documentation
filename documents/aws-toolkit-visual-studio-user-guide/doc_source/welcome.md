# AWS Toolkit for Visual Studio<a name="welcome"></a>

This is the user guide for the **AWS Toolkit for Visual Studio**\. If you are looking for the **AWS Toolkit for VS Code**, see the *[User Guide for the AWS Toolkit for Visual Studio Code](https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/)\.*

## What is the Toolkit for Visual Studio<a name="welcome-about-tkv"></a>

The AWS Toolkit for Visual Studio is a plugin for the Visual Studio IDE that makes it easier for you to develop, debug, and deploy \.NET applications that use Amazon Web Services\. The Toolkit for Visual Studio is supported for Visual Studio versions 2013 and later\. For details about how to download and install the kit, see [Install the Toolkit for Visual Studio](setup.md#install)\.

**Note**  
The Toolkit for Visual Studio is also available for Visual Studio 2008, 2010, and 2012 versions\. However, those versions are not supported\. For more information, see [Install the Toolkit for Visual Studio](setup.md#install)\.

The Toolkit for Visual Studio contains the following features to enhance your development experience\.

### AWS Explorer<a name="explorer"></a>

The AWS Explorer tool window, available from the IDE's **View** menu, enables you to interact with many of the AWS services from inside the Visual Studio IDE\. Supported data services include Amazon Simple Storage Service \(Amazon S3\), Amazon SimpleDB, Amazon Simple Notification Service \(Amazon SNS\), Amazon Simple Queue Service \(Amazon SQS\), and Amazon CloudFront\. AWS Explorer also provides access to Amazon Elastic Compute Cloud \(Amazon EC2\) management, AWS Identity and Access Management \(IAM\) user and policy management, deployment of serverless applications and functions to AWS Lambda and deployment of web applications to AWS Elastic Beanstalk and AWS CloudFormation\.

### Credential and Region Management<a name="credential-and-region-management"></a>

AWS Explorer supports multiple AWS accounts \(including IAM user accounts\) and regions, and enables you to easily change the displayed view from one account to another or view and manage resources and services in different regions\.

### Amazon EC2<a name="ec2"></a>

From AWS Explorer, you can view available Amazon Machine Images \(AMIs\), create Amazon EC2 instances from those AMIs, and then connect to those instances by using Windows Remote Desktop\. AWS Explorer also enables supporting functionality, such as the capability to create and manage key pairs and security groups\.

### AWS Lambda<a name="lamlong"></a>

You can use Lambda to host your serverless \.NET Core C\# functions and serverless applications\. Use blueprints to quickly create new serverless projects and get a head start in developing your serverless application\.

### AWS CodeCommit<a name="acclong"></a>

CodeCommit is integrated with Visual Studio Team Explorer\. This makes it easy to clone and create repositories held in CodeCommit, and to work with source code changes from within the IDE\.

### Amazon DynamoDB<a name="ddblong"></a>

DynamoDB is a fast, highly scalable, highly available, cost\-effective, nonrelational database service\. The Toolkit for Visual Studio provides functionality for working with Amazon DynamoDB in a development context\. With the Toolkit for Visual Studio, you can create and edit attributes in DynamoDB tables and run scan operations on tables\.

### Amazon S3<a name="s3"></a>

You can quickly and easily upload content to Amazon S3 buckets by dragging and dropping, or download content from Amazon S3\. You can also set permissions, metadata, and tags conveniently on objects in buckets\.

### Amazon RDS<a name="rds"></a>

AWS Explorer can help you create and manage Amazon RDS assets in Visual Studio\. Amazon RDS instances that use Microsoft SQL Server can also be added to Visual Studio's **Server Explorer**\.

### AWS Elastic Beanstalk<a name="eblong"></a>

You can use Elastic Beanstalk to deploy your \.NET web application projects to AWS\. You can deploy your application to a single instance environment or to a fully load balanced, automatically scaled environment from within the IDE\. You can also deploy new versions of your application quickly and conveniently without leaving Visual Studio\. If your application uses SQL Server in Amazon RDS, the deployment wizard can also set up the connectivity between your application environment in Elastic Beanstalk and the database instance in Amazon RDS\. The Toolkit for Visual Studio also includes the standalone command\-line deployment tool\. Use the deployment tool to make deployment an automatic part of your build process, or to include deployment in other scripting scenarios outside of Visual Studio\.

### AWS CloudFormation<a name="cfn"></a>

You can use the Toolkit for Visual Studio to edit AWS CloudFormation JSON\-format templates with support for editor IntelliSense and syntax highlighting\. With a AWS CloudFormation template you describe the resources you want to instantiate to host your application\. From within the IDE you then deploy the template to AWS CloudFormation\. The resources described in the template are provisioned for you, freeing you to focus on developing the application's functionality\.

### AWS Identity and Access Management \(IAM\)<a name="iamlong-iam"></a>

From AWS Explorer, you can create IAM users, roles, and policies, and attach policies to users\.

## Related Information<a name="related-info"></a>

To open an issues or view currently open issues, visit [https://github\.com/aws/aws\-toolkit\-visual\-studio/issues]( https://github.com/aws/aws-toolkit-visual-studio/issues)\.

To learn more about Visual Studio, visit [https://visualstudio\.microsoft\.com/vs/](https://visualstudio.microsoft.com/vs/)\.