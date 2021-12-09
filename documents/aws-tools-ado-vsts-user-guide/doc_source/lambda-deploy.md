# AWS Lambda Deploy Function task<a name="lambda-deploy"></a>

## Synopsis<a name="synopsis"></a>

Supports deployment of AWS Lambda functions for all supported Lambda language runtimes\. Note that this task can be used to deploy \.NET Core\-based functions but it does not build the deployment package first\. To perform a build and deployment for \.NET Core\-based functions, or to deploy \.NET Core\-based serverless applications, please refer to the AWS Lambda \.NET Core Deployment task\.

## Description<a name="description"></a>

Applications that are based on Lambda \(also referred to as serverless applications\) are composed of functions triggered by events\. A typical serverless application consists of one or more functions triggered by events such as object uploads to Amazon S3, Amazon SNS notifications, and API actions\. Those functions can stand alone or use other resources such as Amazon DynamoDB tables or Amazon S3 buckets\. The most basic serverless application is simply a function\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Deploy Lambda Function

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

### Deployment Mode\*<a name="deployment-mode"></a>

Selects the type of deployment\. You can deploy new function code to an existing function or you can specify settings for both code and configuration\. For the 'code and configuration' mode if the function does not exist it will be created\.

### Function Name\*<a name="function-name"></a>

The name of the Lambda function to create or update\. You can also specify the Amazon Resource Name \(ARN\) for an existing function\.

### Description<a name="id1"></a>

A short, user\-defined function description\. Lambda does not use this value\.

### Function Handler\*<a name="function-handler"></a>

"The function within your code that Lambda calls to begin execution\. For Node\.js, it is the module\-name\.export value in your function\. For Java, it can be package\.class\-name::handler or package\.class\-name\. For more information and other examples see [Programming Model](https://docs.aws.amazon.com/lambda/latest/dg/programming-model-v2.html)\.

### Runtime\*<a name="runtime"></a>

The runtime environment for the Lambda function you are uploading\. The list of runtimes available in the pick list are those known at the time this version of the tools was released\. To use a runtime not shown in the list simply enter the runtime identifier in the field\.

### Code Location\*<a name="code-location"></a>

Specifies the source location of the deployment package to be uploaded\. You can choose from a file in the local file system or a file previously uploaded to Amazon S3\. If the source location is Amazon S3 you can also optionally supply a specific version of the file\.

### Zip File Path<a name="zip-file-path"></a>

Path to the zip file containing the function code to deploy\. Required if *Code Location* is set to *Zip file in the work area*\.

### S3 Bucket<a name="s3-bucket"></a>

The name of the Amazon S3 bucket containing the previously uploaded zip file of the function's code\. Required if *Code Location* is set to *Zip file in Amazon S3*\.

### S3 Object Key<a name="s3-object-key"></a>

The key \(name\) of the object in the bucket containing the function's code\. Required if *Code Location* is set to *Zip file in Amazon S3*\.

### S3 Object Version<a name="s3-object-version"></a>

Version of the S3 object containing the function code\. If not specified the latest version of the object is used\.

### Role ARN or Name\*<a name="role-arn-or-name"></a>

The Amazon Resource Name \(ARN\), or name, of the IAM role that Lambda assumes when it executes your function to access any other Amazon Web Services \(AWS\) resources\. If a role name is supplied the task will attempt to retrieve the ARN automatically\.

### Memory Size<a name="memory-size"></a>

The amount of memory, in MB, your Lambda function is given\. Lambda uses this memory size to infer the amount of CPU and memory allocated to your function\. Your function use\-case determines your CPU and memory requirements\. For example, a database operation might need less memory compared to an image processing function\. The default value is 128 MB\. The value must be a multiple of 64 MB\.

### Timeout<a name="timeout"></a>

The function execution time at which Lambda should terminate the function\. Because the execution time has cost implications, we recommend you set this value based on your expected execution time\. The default is 3 seconds\.

### Publish<a name="publish"></a>

If set requests AWS Lambda to create or update the Lambda function and publish a version as an atomic operation\.

### Advanced<a name="advanced"></a>

Advanced settings are only displayed when creating a new function, or updating code and configuration for an existing function\.

#### Dead Letter ARN<a name="dead-letter-arn"></a>

The Amazon Resource Name \(ARN\) of an Amazon SQS queue or Amazon SNS topic to be used as your Dead Letter Queue \(DLQ\)\.

#### KMS Key ARN<a name="kms-key-arn"></a>

The Amazon Resource Name \(ARN\) of the KMS key used to encrypt your function's environment variables\. If not provided, AWS Lambda will use a default service key\.

#### Environment Variables<a name="environment-variables"></a>

Key\-value pairs that represent your environment's configuration settings\. Enter as Name=Value, one per line\.

#### Tags<a name="tags"></a>

List of tags \(key\-value pairs\) assigned to the new function\. Enter as *key\*=\*value*, one per line\. Tags can only be specified when creating a new function and are ignored when updating functions\.

#### Security Group IDs<a name="security-group-ids"></a>

List of security group IDs, one per line\. If your Lambda function accesses resources in a VPC at least one security group and one subnet ID belonging to the same VPC must be specified\.

#### Subnet IDs<a name="subnet-ids"></a>

List of subnet IDs, one per line\. If your Lambda function accesses resources in a VPC at least one security group and one subnet ID belonging to the same VPC must be specified\.

#### Tracing configuration<a name="tracing-configuration"></a>

Your function's trace settings\. Can be either X\-Ray, PassThrough or Active\. If PassThrough, Lambda will only trace the request from an upstream service if it contains a tracing header with "sampled=1"\. If Active, Lambda will respect any tracing header it receives from an upstream service\. The default setting of X\-Ray means that if no tracing header is received, Lambda will call X\-Ray for a tracing decision\.

#### Output Variable<a name="output-variable"></a>

The name of the variable that will contain the Amazon Resource Name \(ARN\) of the created or updated function on task completion\. The variable can be used as $\(variableName\) to refer to the function result in subsequent tasks\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ lambda:CreateFunction
+ lambda:GetFunction
+ lambda:UpdateFunctionCode
+ lambda:UpdateFunctionConfiguration