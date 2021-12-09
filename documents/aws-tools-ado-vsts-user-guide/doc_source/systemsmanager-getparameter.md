# AWS SSM Get Parameter task<a name="systemsmanager-getparameter"></a>

\(AWS Systems Manager Get Parameter Task\)

## Synopsis<a name="synopsis"></a>

<a name="systemsmanager-getparameter-synopisis"></a>Reads one or more values from Systems Manager Parameter Store into build variables\.

## Description<a name="description"></a>

This task reads a parameter value, or hierarchy of values identified by common path, into build variables in the build or release definition\. These variables are then accessible from downstream tasks in the definition\. The names used for the build variables are customizable\.

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

### Read Mode\*<a name="read-mode"></a>

Whether the task gets the value of a single named parameter or values from a parameter hierarchy identified by common parameter path\.

### Parameter Name<a name="parameter-name"></a>

The name identifying a single parameter to be read from the store\. Required if *Read Mode* is set to *Get value for single parameter*\.

### Parameter Version<a name="parameter-version"></a>

If unspecified the value associated with the latest version of the parameter is read\. If specified the task requests the value associated with the supplied version\. Parameter versions start at 1 and increment each time a new value is stored for the parameter\.

This field is only available when Read Mode is set to get a single parameter value\.

### Parameter Path<a name="parameter-path"></a>

The path hierarchy for the parameters to be read\. Hierarchies start with, and are separated by, a forward slash \(/\) and may contain up to five levels\. The path hierarchy can identify a specific parameter in the hierarchy by appending the parameter name, or can identify a group of parameters sharing the hierarchy path\. If the supplied hierarchy contains multiple parameters, all parameter values in the hierarchy are downloaded\.

 **Note:** *SecureString* parameters found in a hierarchy will be automatically set as secret variables\.

Required if *Read Mode* is set to *Get values for parameter hierarchy*\.

### Recursive<a name="recursive"></a>

Available when reading a parameter hierarchy\. If selected then parameter values for the specified *Parameter Path* and all sub\-paths are read\. If not selected only the values for parameters matching the supplied path are read, values in sub\-paths are ignored\.

### Variable Name Transform<a name="variable-name-transform"></a>

Specifies how the build variable names to hold the parameter values are created\. You can choose from
+ Use parameter names \(including any paths\) as variable names\. The full parameter name is used to set the build variable name\.
+ Use leaf of parameter names as variable names\. The path is removed and the resulting leaf text is used as the build variable name\.
+ Replace text in the parameter name using a regular expression to form the build variable name\.
+ Use custom name\. Available for single parameter read mode only, enables entry of a custom name for the build variable\.

### Custom Variable Name<a name="custom-variable-name"></a>

The name of the build variable to hold the parameter value\. This value is required if *Variable Name Transform* is set to *Use custom name*\.

### Search Pattern<a name="search-pattern"></a>

A regular expression defining the text in the parameter name that is to be replaced to form the variable name\. This field is required if *Variable Name Transform* is set to *Replace text in the parameter name using a regular expression*\.

### Replacement Text<a name="replacement-text"></a>

The text to use to replace the matched pattern defined in the *Search Pattern* option\. If an empty string is supplied the text identified by the pattern is simply removed from the parameter name\.

### Global Match<a name="global-match"></a>

If selected then a global match is performed with the specified pattern\. If not selected the replacement stops after the first match\.

### Case\-insensitive Match<a name="case-insensitive-match"></a>

If selected a case\-insensitive match is performed with the specified pattern\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ ssm:GetParameter
+ ssm:GetParametersByPath