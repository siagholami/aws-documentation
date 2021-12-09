# AWS Shell Script task<a name="awsshell"></a>

## Synopsis<a name="synopsis"></a>

Run a shell script using Bash with AWS credentials\.

## Description<a name="description"></a>

Runs a shell script in Bash, setting AWS credentials and Region information into the shell environment using the standard environment keys *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY*, *AWS\_SESSION\_TOKEN* and *AWS\_REGION*\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: AWS Shell Script

### AWS Credentials<a name="aws-credentials"></a>

Specifies the AWS credentials to be used by the task in the build agent environment\.

You can specify credentials using a service endpoint \(of type AWS\) in the task configuration or you can leave unspecified\. If unspecified the task will attempt to obtain credentials from the following sources in order:
+ From task variables named *AWS\.AccessKeyID*, *AWS\.SecretAccessKey* and optionally *AWS\.SessionToken*\.
+ From credentials set in environment variables in the build agent process\. When using environment variables in the build agent process you may use the standard AWS environment variables: *AWS\_ACCESS\_KEY\_ID*, *AWS\_SECRET\_ACCESS\_KEY* and optionally *AWS\_SESSION\_TOKEN*\.
+ If the build agent is running on an Amazon EC2 instance, from the instance metadata associated with the EC2 instance\. For credentials to be available from EC2 instance metadata the instance must have been started with an instance profile referencing a role granting permissions to the task to make calls to AWS on your behalf\. For more information, see [Using an IAM role to grant permissions to applications running on Amazon EC2 instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html)\.

### AWS Region<a name="aws-region"></a>

The AWS Region code \(us\-east\-1, us\-west\-2 etc\.\) of the Region containing the AWS resources the task will use or create\. For more information, see [Regions and endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html) in the *Amazon Web Services General Reference*\.

If a Region is not specified in the task configuration, the task will attempt to obtain the Region to be used using the standard AWS environment variable *AWS\_REGION* in the build agent process's environment\. Tasks running in build agents hosted on Amazon EC2 instances \(Windows or Linux\) will also attempt to obtain the Region using the instance metadata associated with the EC2 instance if no Region is configured on the task or set in the environment variable\.

 **Note:** The Regions listed in the picker are those known at the time this software was released\. New Regions that are not listed can still be used by entering the *Region code* of the Region \(for example, *us\_west\_2*\)\.

### Arguments<a name="arguments"></a>

The arguments to be passed to the shell script\.

### Script Source<a name="script-source"></a>

The source of the script to run in the shell\. Choose *Script file* to enter the file path to the script to be run or *Inline script* to specify the source code for the script in the task configuration\.

### Script Path<a name="script-path"></a>

When *Script Source* is set to *Script file*, specifies the file path to the script to execute\. This must be a fully qualified path or a path relative to the $\(System\.DefaultWorkingDirectory\) location\. The script file must exist\.

### Inline Script<a name="inline-script"></a>

The source code of the script to run when *Script Source* is set to *Inline script*\. A maximum of 5000 characters is allowed\.

### Specify Working Directory<a name="specify-working-directory"></a>

If selected a custom working directory, which must exist, can be specified for the script\. The default behavior when unchecked is to set the working directory for the shell to be the script file location\.

### Working Directory<a name="working-directory"></a>

If *Specify Working Directory* is checked, contains the custom working directory for the script\.

#### Fail on Standard Error<a name="fail-on-standard-error"></a>

If this option is selected, the task will fail if any errors are written to the standard error stream\.

## Task Permissions<a name="task-permissions"></a>

Permissions for this task to call AWS service APIs depend on the activities in the supplied script\.