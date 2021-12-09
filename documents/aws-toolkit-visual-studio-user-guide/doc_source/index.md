# AWS Toolkit for Visual Studio User Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [AWS Toolkit for Visual Studio](welcome.md)
+ [Setting Up the AWS Toolkit for Visual Studio](getting-set-up.md)
   + [Setting Up the AWS Toolkit for Visual Studio](setup.md)
   + [Providing AWS Credentials](credentials.md)
   + [Using the Toolkit for Visual Studio](basic-use.md)
+ [Working with AWS Services](working-with-services.md)
   + [Managing Amazon EC2 Instances](tkv-ec2-ami.md)
   + [Managing Amazon ECS Instances](tkv-ecs.md)
   + [Managing Security Groups from AWS Explorer](tkv-sg-create.md)
   + [Create an AMI from an Amazon EC2 Instance](tkv-create-ami-from-instance.md)
   + [Setting Launch Permissions on an Amazon Machine Image](tkv-set-ami-launch-perms.md)
   + [Amazon Virtual Private Cloud (VPC)](vpc-tkv.md)
   + [Deployment Using the AWS Toolkit](deployment-chapt.md)
      + [Deploying to Elastic Beanstalk](deployment-beanstalk.md)
         + [Deploy a Traditional ASP.NET Application to Elastic Beanstalk](deployment-beanstalk-traditional.md)
         + [Deploying an ASP.NET Core Application to Elastic Beanstalk](deployment-beanstalk-netcore.md)
         + [How to Specify the AWS Security Credentials for Your Application](deployment-beanstalk-specify-credentials.md)
         + [How to Republish Your Application to an Elastic Beanstalk Environment](deployment-beanstalk-republish.md)
         + [Custom Elastic Beanstalk Application Deployments](deployment-beanstalk-custom.md)
         + [Custom ASP.NET Core Elastic Beanstalk Deployments](deployment-beanstalk-custom-netcore.md)
         + [Multiple Application Support for .NET and Elastic Beanstalk](deployment-beanstalk-multiple-application.md)
         + [Deploying to Elastic Beanstalk (Legacy)](deployment-beanstalk-legacy.md)
         + [Deploying to AWS CloudFormation (Legacy)](deployment-cloudform.md)
      + [Deploying to Amazon EC2 Container Service](deployment-ecs.md)
         + [Specify AWS Credentials for Your ASP.NET Core 2 Application](deployment-ecs-specify-credentials.md)
         + [Deploying an ASP.NET Core 2.0 App to Amazon ECS (Fargate)](deployment-ecs-aspnetcore-fargate.md)
         + [Deploying an ASP.NET Core 2.0 App to Amazon ECS (EC2)](deployment-ecs-aspnetcore-ec2.md)
      + [Standalone Deployment Tool](deployment-tool.md)
         + [Customizing the AWS CloudFormation Template Used for Deployment](custom-template-tkv.md)
   + [Using the AWS CloudFormation Template Editor for Visual Studio](tkv-cfn-editor.md)
      + [Creating an AWS CloudFormation Template Project in Visual Studio](tkv-cfn-editor-new-project.md)
      + [Deploying a AWS CloudFormation Template in Visual Studio](tkv-cfn-editor-deploy-template.md)
      + [Estimating the Cost of Your AWS CloudFormation Template Project in Visual Studio](tkv-cfn-editor-estimate-cost.md)
      + [Formatting a AWS CloudFormation Template in Visual Studio](tkv-cfn-editor-format.md)
   + [Using Amazon S3 from AWS Explorer](tkv-s3.md)
   + [Using DynamoDB from AWS Explorer](dynamodb-tkv.md)
   + [Using AWS CodeCommit with Visual Studio Team Explorer](using-aws-codecommit-with-team-explorer.md)
   + [Amazon RDS from AWS Explorer](rds-tkv.md)
      + [Launch an Amazon RDS Database Instance](rds-launch-instance.md)
      + [Create a Microsoft SQL Server Database in an RDS Instance](rds-launch-instance-sql.md)
      + [Amazon RDS Security Groups](rds-security-groups.md)
   + [Using Amazon SimpleDB from AWS Explorer](tkv-simpleDB.md)
   + [Using Amazon SQS from AWS Explorer](tkv-sqs.md)
   + [Identity and Access Management](tkv-iam.md)
   + [Using the AWS Lambda Templates in the AWS Toolkit for Visual Studio](lambda-index.md)
      + [Tutorial: Using the AWS Lambda Project in the AWS Toolkit for Visual Studio](lambda-creating-project-in-visual-studio.md)
      + [Tutorial: Build and Test a Serverless Application with AWS Lambda](lambda-build-test-severless-app.md)
      + [Tutorial: Creating an Amazon Rekognition Lambda Application](lambda-rekognition-example.md)
      + [Tutorial: Using Amazon Logging Frameworks with AWS Lambda to Create Application Logs](cw-log-frameworks.md)
   + [Deploying an AWS Lambda Project with the .NET Core CLI](lambda-cli-publish.md)
+ [Security for this AWS Product or Service](security.md)
   + [Data Protection in this AWS Product or Service](data-protection.md)
   + [Identity and Access Management for this AWS Product or Service](security-iam.md)
   + [Compliance Validation for this AWS Product or Service](compliance-validation.md)
   + [Resilience for this AWS Product or Service](disaster-recovery-resiliency.md)
   + [Infrastructure Security for this AWS Product or Service](infrastructure-security.md)
   + [Configuration and Vulnerability Analysis in this AWS Product or Service](configuration-and-vulnerability-analysis.md)
+ [Document History of the AWS Toolkit for Visual Studio User Guide](tkv-document-history.md)