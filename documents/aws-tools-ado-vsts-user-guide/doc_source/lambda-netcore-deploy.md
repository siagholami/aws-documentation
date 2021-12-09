# AWS Lambda \.NET Core task<a name="lambda-netcore-deploy"></a>

## Synopsis<a name="synopsis"></a>

Builds, packages, and deploys a \.NET Core AWS Lambda function or serverless application\. Optionally the task can create the deployment package for subsequent deployment in another build or release pipeline\.

 **Note:** this task is specific to Lambda functions written in C\# or F\#\. For other languages supported by Lambda please refer to the AWS Lambda Deploy Function task\.

## Description<a name="description"></a>

Applications based on Lambda \(also referred to as serverless applications\) are composed of functions triggered by events\. A typical serverless application consists of one or more functions triggered by events such as object uploads to Amazon S3, Amazon SNS notifications, and API actions\. Those functions can stand alone or use other resources such as Amazon DynamoDB tables or Amazon S3 buckets\. The most basic serverless application is simply a function\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Deploy \.NET Core to Lambda

### AWS Credentials<a name="aws-credentials"></a>

Specifies the AWS credentials to be used by the task in the build agent environment\.

You can specify credentials using a service endpoint \(of type AWS\) in the task configuration or you can leave unspecified\. If unspecified the task will attempt to obtain credentials from the following sources in order:
+ From task variables named *AWS\.AccessKeyID*, *AWS\.SecretAccessKey* and optionally *AWS\.SessionToken*\.
+ From credentials set in environment variables in the build agent process\. When using environment variables in the build agent process you may use the standard AWS environment variables: *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY* and optionally *AWS\_SESSION\_TOKEN*\.
+ If the build agent is running on an Amazon EC2 instance, from the instance metadata associated with the EC2 instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

### AWS Region<a name="aws-region"></a>

The AWS Region code \(for example, us\-east\-1, us\-west\-2\) of the Region containing the AWS resources the task will use or create\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

If a Region is not specified in the task configuration the task will attempt to obtain the Region to be used using the standard AWS environment variable *AWS\_REGION* in the build agent process's environment\. Tasks running in build agents hosted on Amazon EC2 instances \(Windows or Linux\) will also attempt to obtain the Region using the instance metadata associated with the EC2 instance if no Region is configured on the task or set in the environment variable\.

 **Note:** The Regions listed in the picker are those known at the time this software was released\. New Regions that are not listed may still be used by entering the *region code* of the Region \(for example, *us\_west\_2*\)\.

### Deployment Type\*<a name="deployment-type"></a>

The type of deployment to perform, or package to build or deploy\.
+  *Function* deploys a single function to Lambda, or creates a package zip file for subsequent deployment\.
+  *Serverless Application* performs a deployment using AWS CloudFormation \(allowing multiple functions to be deployed at the same time\) or builds the application and uploads it to Amazon S3, outputting the serverless template file for subsequent deployment of the updated code using AWS CloudFormation\.

 **Note:** both options will perform the relevant NuGet package restore and build operations to create the resulting deployment package\.

### Create deployment package only<a name="create-deployment-package-only"></a>

If selected the task creates the outputs for the selected deployment type but does not perform the deployment to AWS Lambda or AWS CloudFormation\.

### Package\-only output file<a name="package-only-output-file"></a>

Available when *Create deployment package only* is selected\.

When *Deployment Type* is set to *Function* specifies the output folder and filename of the packaged `.zip` file\. This `.zip` file can then be used with the *AWS Lambda Deploy Function* task to perform the deployment at a later stage\.

When *Deployment Type* is set to *Serverless Application* specifies the output folder and file name where the serverless template file, updated to contain the Amazon S3 location of the built project code and artifacts, will be placed\. This updated template can then be used with the *AWS CloudFormation Create/Update Stack* task, or AWS CloudFormation change set tasks, to perform the deployment at a later stage\.

### Path to Lambda Project\*<a name="path-to-lam-project"></a>

The relative path to the location of the Lambda function or serverless application project to package and/or deploy\.

### Function Deployment: Lambda Function Properties<a name="function-deployment-lam-function-properties"></a>

#### Function Name<a name="function-name"></a>

The name of the Lambda function to invoke\. You can also specify the Amazon Resource Name \(ARN\) of the function when deploying to an existing function\.

#### Function Role<a name="function-role"></a>

The name of the IAM role providing access to AWS services for the deployed Lambda function\.

#### Function Handler<a name="function-handler"></a>

The function within your code that Lambda calls to begin execution\. The format is `<assembly-name>::<namespace.type-name>::<function-name>`\.

#### Function Memory \(MB\)<a name="function-memory-mb"></a>

The memory allocated to the Lambda function\. The value must be in multiples of 64\.

#### Function Timeout \(Seconds\)<a name="function-timeout-seconds"></a>

The function execution time at which Lambda should terminate the function\.

### Serverless Application Deployment: Serverless Application Properties<a name="serverless-application-deployment-serverless-application-properties"></a>

#### Stack Name<a name="stack-name"></a>

The name of the AWS CloudFormation stack to deploy to\.

 **Note:** This field is required when performing a deployment of a serverless application using this task\. When performing a package\-only build this field is ignored as the stack name is only relevant during deployment\.

#### S3 Bucket<a name="s3-bucket"></a>

The name of the Amazon S3 bucket used to store the built project code\. This field is required when performing a either a deployment or package\-only build of a serverless application\.

#### S3 Prefix<a name="s3-prefix"></a>

The object key prefix to be used for the packaged objects that will be uploaded to Amazon S3 for subsequent deployment\.

### Advanced<a name="advanced"></a>

#### Additional Command Line Arguments for Lambda Tools<a name="additional-command-line-arguments-for-lam-tools"></a>

Additional arguments that can be passed to the `dotnet lambda` CLI extension command that is used to build, package and deploy your function or serverless application using this task\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ lambda:CreateFunction
+ lambda:UpdateFunctionCode
+ lambda:GetFunctionConfiguration
+ cloudformation:CreateChangeSet
+ cloudformation:ExecuteChangeSet
+ cloudformation:DescribeStackEvents
+ cloudformation:DeleteStack
+ cloudformation:DescribeChangeSet
+ cloudformation:DescribeStacks
+ s3:CreateBucket
+ s3:GetBucketLocation

The task also requires permissions to upload your Lambda function or serverless application content to the specified Amazon S3 bucket\. Depending on the size of the application bundle, either PutObject or the S3 multi\-part upload APIs may be used\.