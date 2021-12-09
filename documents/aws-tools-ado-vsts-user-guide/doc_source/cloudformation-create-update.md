# AWS CloudFormation Create/Update Stack task<a name="cloudformation-create-update"></a>

## Synopsis<a name="synopsis"></a>

Creates a new AWS CloudFormation stack or updates the stack if it exists\.

## Description<a name="description"></a>

Creates or updates a stack based on the specified parameters\. When you need to change a stack's settings or its resources, update the stack instead of deleting it and creating a new stack\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Create/Update Stack

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

### Stack Name\*<a name="stack-name"></a>

The name associated with the stack\. The name must be unique in the region in which you are creating the stack\.

A stack name can contain only alphanumeric characters \(case\-sensitive\) and hyphens\. It must start with an alphabetic character and cannot be longer than 128 characters\.

### Template Source\*<a name="template-source"></a>

Specifies the location of the template to use to create or update the stack\. You can specify the template using the path to a file in the local file system, a URL to the file, or an object in Amazon S3\. If you select an object in Amazon S3, you can specify the bucket and object name \(key\)\.

Note that CloudFormation limits the size of template files uploaded to the service to 51,200 bytes\. If your template is larger than the allowed size you should choose either the URL or Amazon S3 location options\. You can also specify a bucket name for the local file option\. If a bucket name is specified, the template is uploaded to the bucket by the task\. The object key will be the template filename, less any path\.

When the task uploads the template to a bucket or you specify an Amazon S3 bucket name and object key, the task generates a URL to the object and supplies the URL to CloudFormation\.

### Template File\*<a name="template-file"></a>

The path to the template file for the stack\. For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### S3 Bucket<a name="s3-bucket"></a>

The name of the bucket to which a local template file can be uploaded, or which contains the template to be used\. If *Template Source* is set to *Amazon S3 bucket and object key* this parameter is required\.

For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### S3 Object Key<a name="s3-object-key"></a>

The name of the template file in the S3 bucket\. The task will generate a URL to the file when specifying the location of the template file to CloudFormation\. If *Template Source* is set to *Amazon S3 bucket and object key* this parameter is required\.

For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### Template URL<a name="template-url"></a>

URL reference to the template file in Amazon S3\. This field is required if *Template Source* is set to *URL to the template file*\. When stored in Amazon S3 template files are subject to a maximum size of 460,800 bytes\.

For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### Template Parameters Source<a name="template-parameters-source"></a>

Specifies the source of parameter values to supply with the template\. If your template uses parameters you can supply their values in JSON or YAML content, from a file in the build area or inline in the task\.

If your template does not need parameter value to be supplied leave the 'Local file' option field empty\. Note that a value for parameters must be specified if if the field is set to *Inline*\.

### Template Parameters File<a name="template-parameters-file"></a>

Optional path to an existing file containing the template parameters in JSON or YAML format\. If your template does not require parameters leave the field empty\.

CloudFormation expects the file to contain an array of one or more parameter objects\. Each object specifies the name of the parameter as *ParameterKey* and the corresponding value in *ParameterValue*, for example \(in JSON format\):

**\[**    
**\{**  
"ParameterKey": "parameter1", "ParameterValue": "parameter1value"
\}, \{  
"ParameterKey": "parameter2", "ParameterValue": "parameter2value"  
\}

\]

For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### Template Parameters<a name="template-parameters"></a>

Parameter values for the template in JSON or YAML format when *Template Parameters\. A value must be provided if \*Template Parameters Source* is set to *Inline*\.

CloudFormation expects the file to contain an array of one or more parameter objects\. Each object specifies the name of the parameter as *ParameterKey* and the corresponding value in *ParameterValue*, for example \(in JSON format\):

**\[**    
**\{**  
"ParameterKey": "parameter1", "ParameterValue": "parameter1value"
\}, \{  
"ParameterKey": "parameter2", "ParameterValue": "parameter2value"  
\}

\]

For more information, see [Template Anatomy](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-anatomy.html) in the *AWS CloudFormation User Guide*\.

### Create or Update the Stack Using a Change Set<a name="create-or-update-the-stack-using-a-change-set"></a>

If selected a change set will be created that contains a list of changes that will be applied to a stack and then validated\. If the changes validate successfully the change set can then be executed to effect the changes\. You can elect to use a change set to both create a new stack or update an existing stack\.

 **Note:** when using this task to deploy a serverless application template you must select to use a change set\.

### Change Set Name<a name="change-set-name"></a>

The name of the change set\. The name must be unique among all change sets that are associated with the specified stack\.

A change set name can contain only alphanumeric, case sensitive characters and hyphens\. It must start with an alphabetic character and cannot exceed 128 characters\. This parameter is required if the option to use a change set is selected\.

### Description<a name="id11"></a>

A description to help you identify this change set\. Max length 1024 characters\.

### Automatically Execute the Change Set<a name="automatically-execute-the-change-set"></a>

If checked, the change set is automatically executed when validation succeeds\. If it isn't checked the change set is validated but not executed\. You can execute the change set later by using theAWS CloudFormation Execute Change Set task\.

### Capabilities<a name="capabilities"></a>

Capabilities that must be specified before AWS CloudFormation can update certain stacks\. Some stack templates might include resources that can affect permissions in your AWS account, for example, by creating new AWS Identity and Access Management \(IAM\) users\. For those stacks, you must explicitly acknowledge their capabilities by specifying this parameter\.

If your stack manipulates IAM resources, you can specify either capability otherwise an InsufficientCapabilities error will be returned\.

#### Create or Update IAM Resources \('CAPABILITY\_IAM'\)<a name="create-or-update-iam-resources-capability-iam"></a>

If your stack manipulates IAM resources, you can specify either capability\. Otherwise, an `InsufficientCapabilities` error is returned\.

#### Create or Update Named IAM Resources \('CAPABILITY\_NAMED\_IAM'\)<a name="create-or-update-named-iam-resources-capability-named-iam"></a>

If your stack manipulates IAM resources with custom names, you must add this capability otherwise an `InsufficientCapabilities` error is returned\.

### Advanced<a name="advanced"></a>

#### Role ARN<a name="role-arn"></a>

The Amazon Resource Name \(ARN\) of an IAM role that AWS CloudFormation assumes when executing the change set\. AWS CloudFormation uses the role's credentials to make calls on your behalf\. AWS CloudFormation uses this role for all future operations on the stack\. As long as users have permission to operate on the stack, AWS CloudFormation uses this role even if the users don't have permission to pass it\. Ensure that the role grants least privilege\.nnIf you don't specify a value, AWS CloudFormation uses the role that was previously associated with the stack\. If no role is available, AWS CloudFormation uses a temporary session that is generated from your user credentials\.

It is recommended as a general principle that the role grants least privilege\.

If you don't specify a value, AWS CloudFormation uses the role that was previously associated with the stack\. If no role is available, AWS CloudFormation uses a temporary session that is generated from your user credentials\.

#### Resource Types<a name="resource-types"></a>

The template resource types that you have permissions to work with if you execute this change set\. For example, `AWS::EC2::Instance`, `AWS::EC2::*`, or `Custom::MyCustomInstance`\.

If the list of resource types doesn't include a resource type that you're updating, the stack update fails\. By default, AWS CloudFormation grants permissions to all resource types\. IAM uses this parameter for condition keys in IAM policies for AWS CloudFormation\.

For more information, see [Controlling Access with AWS Identity and Access Management](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/using-iam-template.html) in the *AWS CloudFormation User Guide*\.

#### Notification ARNs<a name="notification-arns"></a>

One or more Amazon Resource Name \(ARN\) of Amazon SNS topics that AWS CloudFormation associates with the stack\. To remove all associated notification topics, specify an empty list\.

#### Tags<a name="tags"></a>

Collection of tags to apply to the resources created by your template\. Tags can be specified as *tagkey=tagvalue*, one per line\.

#### Rollback Triggers<a name="rollback-triggers"></a>

Rollback triggers enable you to have AWS CloudFormation monitor the state of your application during stack creation and updating, and to rollback that operation if the application breaches the threshold of any of the alarms you've specified\. [Learn more\.](http://docs.aws.amazon.com/AWSCloudFormation/latest/APIReference/API_RollbackConfiguration.html)

#### Trigger Monitoring Time<a name="trigger-monitoring-time"></a>

The amount of time, in minutes, during which AWS CloudFormation should monitor all the rollback triggers after the stack creation or update operation deploys all necessary resources\.

If you specify a monitoring period but do not specify any rollback triggers, AWS CloudFormation still waits the specified period of time before cleaning up old resources after update operations\. You can use this monitoring period to perform any manual stack validation desired, and manually cancel the stack creation or update \(using CancelUpdateStack, for example\) as necessary\.

If you specify 0 for this parameter, AWS CloudFormation still monitors the specified rollback triggers during stack creation and update operations\. Then, for update operations, it begins disposing of old resources immediately once the operation completes\.

#### Rollback Trigger ARNs<a name="rollback-trigger-arns"></a>

The Amazon Resource Names \(ARNs\) of the triggers to monitor during stack creation or update actions\.

By default AWS CloudFormation saves the rollback triggers specified for a stack and applies them to any subsequent update operations for the stack, unless you specify otherwise\. If you do specify rollback triggers for this parameter, those triggers replace any list of triggers previously specified for the stack\. This means:
+ To use the rollback triggers previously specified for this stack, if any, don't specify this parameter\.
+ To specify new or updated rollback triggers, you must specify all the triggers that you want used for this stack, even triggers you've specified before \(for example, when creating the stack or during a previous stack update\)\. Any triggers that you don't include in the updated list of triggers are no longer applied to the stack\.

If a specified trigger is missing, the entire stack operation fails and is rolled back\.

A maximum of five triggers can be supplied\.

### Options<a name="options"></a>

#### On Failure<a name="on-failure"></a>

Determines what action to take if stack creation fails\. The default is to roll back\.

#### Disable Rollback<a name="disable-rollback"></a>

If checked, disables rollback of the stack if stack creation failed\. You can specify `DisableRollback` or `OnFailure`, but not both\.

#### Log warning during stack update if AWS CloudFormation reports no work to be done<a name="log-warning"></a>

If selected and an update\-stack operation, with or without a change set, results in no changes being reported by the service, then a warning message is emitted into the task logs\. If not selected, the message from the service is ignored and no warning is emitted\.

#### Output Variable<a name="output-variable"></a>

The name of the variable that will contain the ID of the stack on task completion\. You can use `$(variableName)` to refer to the stack ID in subsequent tasks\.

#### Max Timeout<a name="max-timeout"></a>

Maximum time, specified in minutes, that the task should wait for the stack creation or update to complete\. By default a maximum of 60 minutes is used\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ cloudformation:CreateChangeSet
+ cloudformation:CreateStack
+ cloudformation:DeleteChangeSet
+ cloudformation:DescribeChangeSet
+ cloudformation:DescribeStacks
+ cloudformation:DescribeStackResources
+ cloudformation:ExecuteChangeSet
+ cloudformation:UpdateStack

The task may also require permissions to upload your application template to the specified Amazon S3 bucket\.