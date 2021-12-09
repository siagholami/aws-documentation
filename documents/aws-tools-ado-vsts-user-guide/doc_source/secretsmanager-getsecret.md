# AWS Secrets Manager Get Secret task<a name="secretsmanager-getsecret"></a>

## Synopsis<a name="synopsis"></a>

Stores the value of a secret in AWS Secrets Manager into a secret build variable\.

## Description<a name="description"></a>

Use this task to retrieve the value of a secret stored in AWS Secrets Manager and store it locally in an Azure DevOps build variable\. The build variable will be automatically set to 'secret' mode to automatically mask the value when logged or otherwise displayed\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Secrets Manager Get Secret

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

### Secret ID/Name<a name="secret-id-name"></a>

Specifies the secret containing the version that you want to retrieve\. You can specify either the Amazon Resource Name \(ARN\) or the friendly name of the secret\.

### Version ID<a name="version-id"></a>

Specifies the unique identifier of the version of the secret that you want to retrieve\. If you specify this parameter then don't specify *Version Stage*\. If you don't specify either a *Version Stage* or *Version ID* then the default is to perform the operation on the version with the version stage value of *AWSCURRENT*\.

### Version Stage<a name="version-stage"></a>

Specifies the version of the secret that you want to retrieve using the staging label attached to the version\.

Staging labels are used to keep track of different versions during the rotation process\. If you use this parameter then don't specify *Version ID*\. If you don't specify either a *Version Stage* or *Version ID*, then the default is to perform the operation on the version with the version stage value of *AWSCURRENT*\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ secretsmanager:GetSecretValue