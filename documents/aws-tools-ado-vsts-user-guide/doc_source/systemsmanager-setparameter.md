# AWS SSM Set Parameter Task<a name="systemsmanager-setparameter"></a>

\(AWS Systems Manager Set Parameter Task\)

## Synopsis<a name="synopsis"></a>

Creates or updates a parameter in Systems Manager Parameter Store\.

## Description<a name="description"></a>

Use this task to creates or updates a parameter in Systems Manager Parameter Store\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Systems Manager Set Parameter

### AWS Credentials<a name="aws-credentials"></a>

Specifies the AWS credentials to be used by the task in the build agent environment\.

You can specify credentials using a service endpoint \(of type AWS\) in the task configuration or you can leave unspecified\. If unspecified the task will attempt to obtain credentials from the following sources in order:
+ From task variables named *AWS\.AccessKeyID*, *AWS\.SecretAccessKey* and optionally *AWS\.SessionToken*\.
+ From credentials set in environment variables in the build agent process\. When using environment variables in the build agent process you may use the standard AWS environment variables: *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY* and optionally *AWS\_SESSION\_TOKEN*\.
+ If the build agent is running on an Amazon EC2 instance, from the instance metadata associated with the EC2 instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

### AWS Region<a name="aws-region"></a>

The AWS region code \(for example, us\-east\-1, us\-west\-2\) of the Region containing the AWS resources the task will use or create\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

If a Region is not specified in the task configuration the task will attempt to obtain the Region to be used using the standard AWS environment variable *AWS\_REGION* in the build agent process's environment\. Tasks running in build agents hosted on Amazon EC2 instances \(Windows or Linux\) will also attempt to obtain the Region using the instance metadata associated with the EC2 instance if no Region is configured on the task or set in the environment variable\.

 **Note:** The Regions listed in the picker are those known at the time this software was released\. New Regions that are not listed may still be used by entering the *region code* of the Region \(for example, *us\_west\_2*\)\.

### Parameter Name<a name="parameter-name"></a>

The name identifying a single parameter to be created or updated in the store\.

### Parameter Type<a name="paraneter-type"></a>

The type of parameter to be written Choose from \-
+ String: the parameter is assigned a single string value
+ String list: the parameter value is a comma\-separated list of strings
+ Secure string: the parameter value is encrypted at rest using either a service\- or customer\-provided KMS key

 **Note:** If the parameter exists and is a secure string, this field is ignored and the secure string status of the parameter is retained\.

### Parameter Value<a name="parameter-value"></a>

The value for the parameter\.

### KMS Key ID<a name="kms-key-id"></a>

If the parameter type is set to *Secure string*, identifies the customer\-provided KMS key used to encrypt the parameter value at rest\. If a secure string type is specified but no key provided a service\-provided KMS key is used to encrypt the parameter value\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ ssm:GetParameter
+ ssm:PutParameter