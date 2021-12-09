# Task reference<a name="task-reference"></a>

This reference describes the tasks that are included in the AWS Toolkit for Microsoft Azure DevOps\.<a name="task-prerequisites"></a>

 **Prerequisites** 

You must have an AWS account\. For information on setting up an account, see [Setting up the AWS Toolkit for Azure DevOps](setting-up.md)\.

Each task requires that AWS credentials for your account be available to the build agent running your task\. Each task also requires the Region in which the API calls to AWS services will be made\.

You can do one of the following:
+ Specify credentials explicitly for each task\. Do this by configuring a named service endpoint \(of endpoint type *AWS*\) and then referring to the endpoint name in the *AWS Credentials* field for each task\. For information about this method, see the topic on [Supply task credentials using a service connection](getting-started.md#service-connection)\.

  In this case, the AWS Region can be set in the **AWS Region** property of a task\.
+ Supply credentials and Region to tasks using environment variables in the process hosting the build agent\.
+ If your build agent is running on an Amazon EC2 instance you can also elect to have credentials \(and Region\) be obtained automatically from the instance metadata associated with the instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

 **Note:** If you choose to use an AWS service endpoint to supply credentials to tasks, we strongly recommend using an AWS Identity and Access Management user account, with appropriate permissions to scope the privileges of the user account to only those needed to execute the tasks you need\.

**Topics**
+ [AWS CLI](aws-cli.md)
+ [AWS Tools for Windows PowerShell Script](awspowershell-module-script.md)
+ [AWS Shell Script](awsshell.md)
+ [AWS CloudFormation Create/Update Stack](cloudformation-create-update.md)
+ [AWS CloudFormation Delete Stack](cloudformation-delete-stack.md)
+ [AWS CloudFormation Execute Change Set](cloudformation-execute-changeset.md)
+ [AWS CodeDeploy Application Deployment](codedeploy-deployment.md)
+ [Amazon ECR Push](ecr-pushimage.md)
+ [AWS Elastic Beanstalk Create Version](elastic-beanstalk-createversion.md)
+ [AWS Elastic Beanstalk Deploy Application](elastic-beanstalk-deploy.md)
+ [AWS Lambda Deploy Function](lambda-deploy.md)
+ [AWS Lambda Invoke Function](lambda-invoke.md)
+ [AWS Lambda \.NET Core](lambda-netcore-deploy.md)
+ [Amazon S3 Download](s3-download.md)
+ [Amazon S3 Upload](s3-upload.md)
+ [AWS Secrets Manager Create/Update Secret](secretsmanager-create-update.md)
+ [AWS Secrets Manager Get Secret](secretsmanager-getsecret.md)
+ [AWS Send SNS or SQS Message](send-message.md)
+ [AWS SSM Get Parameter](systemsmanager-getparameter.md)
+ [AWS SSM Set Parameter](systemsmanager-setparameter.md)
+ [AWS SSM Run Command](systemsmanager-runcommand.md)