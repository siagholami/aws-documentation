# AWS Toolkit for Microsoft Azure DevOps<a name="welcome"></a>

AWS Toolkit for Microsoft Azure DevOps is an extension for Microsoft Azure DevOps \(formerly known as Visual Studio Team Services or VSTS\)\. It contains tasks you can use in build and release definitions in Azure DevOps and Microsoft Azure DevOps Server \(previously named Visual Studio Team Foundation Server\) to interact with AWS services\. AWS Toolkit for Azure DevOps is available through the Visual Studio Marketplace\. See the [Getting started](getting-started.md) topic for more information\.

You can use these tasks in an Azure DevOps project or in an on\-premises Azure DevOps Server environment\. The available AWS tasks include the following\.


**Deployment tasks**  

| Task | Description | 
| --- |--- |
| [AWS CodeDeploy Application Deployment](codedeploy-deployment.md) | Deploys an application to Amazon EC2 instances\. | 
| [AWS CloudFormation Create/Update Stack](cloudformation-create-update.md) | Creates a new AWS CloudFormation stack or updates the stack if it exists\. | 
| [AWS CloudFormation Delete Stack](cloudformation-delete-stack.md) | Deletes an AWS CloudFormation stack\. | 
| [AWS CloudFormation Execute Change Set](cloudformation-execute-changeset.md) | Executes an AWS CloudFormation change set to create or update a stack\. | 
| [AWS Elastic Beanstalk Create Version](elastic-beanstalk-createversion.md) | Creates a new version of an application\. | 
| [AWS Elastic Beanstalk Deploy Application](elastic-beanstalk-deploy.md) | Deploys a new version of an application to an Elastic Beanstalk environment\. | 
| [Amazon ECR Push](ecr-pushimage.md) | Pushes a Docker image to the Amazon Elastic Container Registry \(ECR\)\. | 
| [AWS Lambda Deploy Function](lambda-deploy.md) | Supports deployment of AWS Lambda functions for all supported Lambda language runtimes\. | 
| [AWS Lambda \.NET Core](lambda-netcore-deploy.md) | Builds, packages, and deploys a \.NET Core AWS Lambda function or serverless application\. | 
| [AWS Lambda Invoke Function](lambda-invoke.md) | Invokes an AWS Lambda function with a JSON payload\. | 


**General purpose tasks**  

| Task | Description | 
| --- |--- |
| [AWS CLI](aws-cli.md) | Runs a command using the AWS CLI\. | 
| [AWS Tools for Windows PowerShell Script](awspowershell-module-script.md) | Runs a PowerShell script that uses cmdlets from the AWS Tools for Windows PowerShell module\. | 
| [AWS Shell Script](awsshell.md) | Run a shell script using Bash with AWS credentials\. | 
| [Amazon S3 Download](s3-download.md) | Downloads file and folder content from an Amazon Simple Storage Service \(S3\) bucket\. | 
| [Amazon S3 Upload](s3-upload.md) | Uploads file and folder content to an Amazon Simple Storage Service \(S3\) bucket\. | 
| [AWS Send SNS or SQS Message](send-message.md) | Sends a message to an Amazon Simple Notification Service \(SNS\) topic or to an Amazon Simple Queue Service \(SQS\) queue\. | 
| [AWS Secrets Manager Create/Update Secret](secretsmanager-create-update.md) | Updates a secret, optionally creating a secret if it does not exist\. | 
| [AWS Secrets Manager Get Secret](secretsmanager-getsecret.md) | Stores the value of a secret in AWS Secrets Manager into a secret build variable\. | 
| [AWS SSM Get Parameter](systemsmanager-getparameter.md) | Reads one or more values from Systems Manager Parameter Store into build variables\. | 
| [AWS SSM Set Parameter](systemsmanager-setparameter.md) | Creates or updates a parameter in Systems Manager Parameter Store\. | 
| [AWS SSM Run Command](systemsmanager-runcommand.md) | Runs a Systems Manager or user\-provided Command on a fleet of EC2 instances\. | 

## What's in This Guide<a name="what-s-in-this-guide"></a>

The AWS Toolkit for Azure DevOps User Guide describes how to install and use the AWS Toolkit for Azure DevOps\.

 [Getting Started](getting-started.md) 

How to set up an AWS account and install the AWS Toolkit for Azure DevOps\. Also how to set up AWS credentials for use in the tasks, which can be accomplished using service endpoints, environment variables, or Amazon EC2 instance metadata \(for build agents running on Amazon EC2 instances\)\.

 [Using the AWS Toolkit for Azure DevOps](tutorials.md) 

Walk\-through topics demonstrating how to use tasks in the AWS Toolkit for Azure DevOps in your build and release definitions\.

 [Task Reference](task-reference.md) 

Describes the tasks included in the AWS Toolkit for Azure DevOps\.