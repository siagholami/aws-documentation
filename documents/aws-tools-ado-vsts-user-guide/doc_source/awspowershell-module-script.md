# AWS Tools for Windows PowerShell Script task<a name="awspowershell-module-script"></a>

## Synopsis<a name="synopsis"></a>

Runs a PowerShell script that uses cmdlets from the AWS Tools for Windows PowerShell module\. The module is automatically installed if it isn't already available in the environment\.

## Description<a name="description"></a>

This task accepts a PowerShell command or script that uses cmdlets from the Tools for Windows PowerShell module to interact with AWS services\. You can specify the script to run via its file name, or you can enter it into the task configuration\. Before running the supplied script, the task tests to see if the required Tools for Windows PowerShell module is already installed\. If it isn't installed, the latest available version from the [PowerShell Gallery](https://www.powershellgallery.com/packages/AWSPowerShell) is downloaded and installed\.

**Note**  
If an installation is performed, the module is installed in the `current user` scope\. The location is compatible with automatic module load\. As a result, you don't need to import the module in your script\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: AWS Tools for Windows PowerShell Script

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

### Arguments<a name="arguments"></a>

Optional arguments to pass to the script\. You can use ordinal or named parameters\.

### Script Source\*<a name="script-source"></a>

The type of script to run\. Choose **Script File** to run a script that is contained in a file\. Choose **Inline Script** to enter the script to run in the task configuration\.

### Script Path\*<a name="script-path"></a>

Required if the `Script Source` parameter is set to **Script File**\. Specify the full path to the script you want to run\.

### Inline Script\*<a name="inline-script"></a>

Required if the `Script Source` parameter is set to **Inline Script**\. Enter the text of the script to run\.

### ErrorActionPreference<a name="erroractionpreference"></a>

Prepends the line *$ErrorActionPreference = 'VALUE'* at the top of your script\.

### Advanced<a name="advanced"></a>

#### Fail on Standard Error<a name="fail-on-standard-error"></a>

If this option is selected, the task will fail if any errors are written to the error pipeline, or if any data is written to the Standard Error stream\. Otherwise, the task relies on the exit code to determine failure\.

#### Ignore $LASTEXITCODE<a name="ignore-lastexitcode"></a>

If this option is not selected, the line *if \(\(Test\-Path \-LiteralPath variable:\\LASTEXITCODE\)\) \{ exit $LASTEXITCODE \}* is appended to the end of your script\. This causes the last exit code from an external command to propagate as the exit code of PowerShell\. Otherwise, the line is not appended to the end of your script\.

#### Working Directory<a name="working-directory"></a>

The working directory where the script runs\.

## Task Permissions<a name="task-permissions"></a>

Permissions for this task to call AWS service APIs depend on the activities in the supplied script\.