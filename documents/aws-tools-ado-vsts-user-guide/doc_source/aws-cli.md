# AWS CLI task<a name="aws-cli"></a>

## Synopsis<a name="synopsis"></a>

Runs a command using the AWS CLI\. Note that you must have the AWS CLI installed to use this task\. For more information, see [Installing the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/installing.html)\.

## Syntax<a name="aws-properties-aws-cli-syntax"></a>

To declare this entity in your Azure Pipelines template, use the following syntax:

### YAML<a name="aws-properties-aws-cli-syntax.yaml"></a>

```
- task: AWSCLI@1
  inputs:
    [awsCredentials](#aws-credentials): String
    [regionName](#aws-region): String 
    [awsCommand](#command): String
    [awsSubCommand](#subcommand): String
    [awsArguments](#options-and-parameters): String
    [failOnStandardError](#fail-on-standard-error): Boolean
```

## Description<a name="description"></a>

The AWS CLI uses a multipart structure on the command line\. It starts with the base call to AWS\. The next part specifies a top\-level command, which often represents an AWS service that the AWS CLI supports\. Each AWS service has additional subcommands that specify the operation to perform\. You can specify the general AWS CLI options, or the specific parameters for an operation, in any order on the command line\. If you specify an exclusive parameter multiple times, only the last value applies\.

```
<command> <subcommand> [options and parameters]
```

Parameters can take various types of input values such as numbers, strings, lists, maps, and JSON structures\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: AWS CLI

### AWS Credentials<a name="aws-credentials"></a>

Specifies the AWS credentials to be used by the task in the build agent environment\.

You can specify credentials using a service endpoint \(of type AWS\) in the task configuration or you can leave unspecified\. If unspecified the task will attempt to obtain credentials from the following sources in order:
+ From task variables named *AWS\.AccessKeyID*, *AWS\.SecretAccessKey* and optionally *AWS\.SessionToken*\.
+ From credentials set in environment variables in the build agent process\. When using environment variables in the build agent process you may use the standard AWS environment variables: *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY* and optionally *AWS\_SESSION\_TOKEN*\.
+ If the build agent is running on an Amazon EC2 instance, from the instance metadata associated with the EC2 instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.
*Required*: Yes  
*Type*: String  

### AWS Region<a name="aws-region"></a>

The AWS Region code \(for example, us\-east\-1, us\-west\-2\) of the Region containing the AWS resources the task will use or create\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

If a Region is not specified in the task configuration the task will attempt to obtain the Region to be used using the standard AWS environment variable *AWS\_REGION* in the build agent process's environment\. Tasks running in build agents hosted on Amazon EC2 instances \(Windows or Linux\) will also attempt to obtain the Region using the instance metadata associated with the EC2 instance if no Region is configured on the task or set in the environment variable\.

**Note**  
 The Regions listed in the picker are those known at the time this software was released\. New Regions that are not listed may still be used by entering the *region code* of the Region \(for example, *us\_west\_2*\)\.
*Required*: Yes  
*Type*: String  

### Command\*<a name="command"></a>

The AWS CLI command to run\. Run `aws help` in the AWS Command Line Interface to get a complete list of commands, or see [CommandStructure](https://docs.aws.amazon.com/cli/latest/userguide/command-structure.html) in the AWS Command Line Interface\.
*Required*: Yes  
*Type*: String  

### Subcommand<a name="subcommand"></a>

The AWS CLI subcommand to run\. Run `aws help` in the AWS Command Line Interface to get a complete list of commands, or see [CommandStructure](https://docs.aws.amazon.com/cli/latest/userguide/command-structure.html) in the AWS Command Line Interface\.
*Required*: Yes  
*Type*: String  

### Options and Parameters<a name="options-and-parameters"></a>

The arguments to pass to the AWS CLI command\. Run `aws <command> --help` in the AWS Command Line Interface to get the complete list of arguments supported by the command\.
*Required*: No  
*Type*: String  

### Advanced<a name="advanced"></a>

#### Fail on Standard Error<a name="fail-on-standard-error"></a>

If true, this task fails if any errors are written to the StandardError stream\.
*Required*: No  
*Type*: Boolean  

## Task Permissions<a name="task-permissions"></a>

Permissions for this task to call AWS service APIs depend on the configured command\.

## Examples<a name="aws-properties-aws-cli--examples"></a>

### Azure Pipelines get caller identity AWS cli task<a name="aws-properties-aws-cli--examples--Azure_Pipelines_get_caller_identity_AWS_cli_task"></a>

#### YAML<a name="aws-properties-aws-cli--examples--Azure_Pipelines_get_caller_identity_AWS_cli_task--yaml"></a>

```
- task: AWSCLI@1
  inputs:
    awsCredentials: 'service-connection-name'
    regionName: 'us-east-1'
    awsCommand: 'sts'
    awsSubCommand: 'get-caller-identity'
    failOnStandardError: true
```