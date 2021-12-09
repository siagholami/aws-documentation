# AWS SSM Run Command Task<a name="systemsmanager-runcommand"></a>

\(AWS Systems Manager Run Command Task\)

## Synopsis<a name="synopsis"></a>

Runs a Systems Manager or user\-provided Command on a fleet of EC2 instances\. Commands can also target on\-premise machines if the required Systems Manager agent is installed\.

## Description<a name="description"></a>

This task runs a Systems Manager Command, or a user\-provided Command, on a fleet of EC2 instances\. On\-premise machines can also be targets if the required Systems Manager agent is installed\. The command to run is identified by name\. The targets on which the command will be run are identified using either instance IDs or tags\. Parameters specific to the selected Command can also be specified\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Systems Manager Get Parameter

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

### Document Name\*<a name="document-name"></a>

The name of the Systems Manager document to execute\. This can be a public document or a custom document private to your account and to which the credentials supplied to the task have access\.

### Parameters<a name="id1"></a>

The required and optional parameters for the document to be executed, specified as JSON\. Refer to the specific command to be run for details\.

Example format: `{ "parameter1" : [ "value" ], "parameter2" : [ "value","value2" ] }` 

### Comment<a name="comment"></a>

User\-specified information about the command, such as a brief description of what the command should do\. Maximum length 100 characters\.

### Service Role ARN<a name="service-role-arn"></a>

The Amazon Resource Name \(ARN\) or name of the IAM role Systems Manager uses to send notifications\. If the name of a role is supplied the task will automatically determine the ARN\.

### Select Targets by\*<a name="select-targets-by"></a>

Sets how the list of instances to be targeted are specified\. You can supply a list of instance IDs, or tags \(as key=value pairs\) for search criteria or you can supply the instance IDs using the name of a build variable\. The value of the build variable should be a comma delimited list of IDs\.

### Instance IDs<a name="instance-ids"></a>

The instance IDs where the command should execute\.

You can specify a maximum of 50 IDs, one per line\. For more information about how to use Targets, see [Sending Commands to a Fleet](https://docs.aws.amazon.com/systems-manager/latest/userguide/send-commands-multiple.html)\.

This parameter is required if *Select Targets by* is set to *Manually select instances*\.

### Tags<a name="tags"></a>

A list of tags that targets instances using a Key=Value combination that you specify, one per line\. For more information about how to use Targets, see [Sending Commands to a Fleet](https://docs.aws.amazon.com/systems-manager/latest/userguide/send-commands-multiple.html)\.

This parameter is required if *Select Targets by* is set to *From tags*\.

### Variable Name<a name="variable-name"></a>

The name of the build variable containing the list of instance IDs to target, as a comma delimited list\.

 **Note:** you should specify just the variable name, do not enclose it in $\(\) syntax\.

This parameter is required if *Select Targets by* is set to *Build variable name*\.

### Execution Concurrency<a name="execution-concurrency"></a>

The maximum number of instances that are allowed to execute the command at the same time\. You can specify a number such as 10 or a percentage such as 10%\. The default value is 50\.

For more information about how to use MaxConcurrency, see [Using Concurrency Controls](https://docs.aws.amazon.com/systems-manager/latest/userguide/send-commands-multiple.html#send-commands-velocity)\.

### Max Errors Before Stop<a name="max-errors-before-stop"></a>

The maximum number of errors allowed without the command failing\. When the command fails one more time beyond the value of MaxErrors, the systems stops sending the command to additional targets\. You can specify a number like 10 or a percentage like 10%\. The default value is 50\.

For more information about how to use MaxErrors, see [Using Error Controls](https://docs.aws.amazon.com/systems-manager/latest/userguide/send-commands-multiple.html#send-commands-maxerrors)\.

### Timeout \(seconds\)<a name="timeout-seconds"></a>

If this time is reached and the command has not already started executing, it will not execute\.

Minimum value of 30, maximum value of 2592000\. Default value: 600\.

### Notification ARN<a name="notification-arn"></a>

An Amazon Resource Name \(ARN\) for a Amazon SNS \(SNS\) topic\. Run Command pushes notifications about command status changes to this topic\.

### Notification Events<a name="notification-events"></a>

The different events for which you can receive notifications\. For more information see [Setting Up Events and Notifications](https://docs.aws.amazon.com/systems-manager/latest/userguide/monitor-commands.html)\.

### Notification Type<a name="notification-type"></a>
+  *Command*: Receive notification when the status of a command changes\.
+  *Invocation*: For commands sent to multiple instances, receive notification on a per\-instance basis when the status of a command changes\.

### S3 Bucket Name<a name="s3-bucket-name"></a>

The name of the Amazon S3 bucket where command execution responses should be stored\.

### S3 Key Prefix<a name="s3-key-prefix"></a>

The key prefix \(folder structure\) within the S3 bucket where the S3 objects containing the responses should be stored\.

### Command ID Output Variable<a name="command-id-output-variable"></a>

The name of a variable that will contain the unique ID assigned to the command\. The command ID can be used future references to the request\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ ssm:SendCommand