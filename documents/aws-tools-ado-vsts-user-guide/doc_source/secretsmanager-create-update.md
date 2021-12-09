# AWS Secrets Manager Create/Update Secret task<a name="secretsmanager-create-update"></a>

## Synopsis<a name="synopsis"></a>

Updates a secret, optionally creating a secret if it does not exist\.

## Description<a name="description"></a>

Use this task to create a new secret in Secrets Manager or to update the value for an existing secret\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Secrets Manager Create/Update Secret

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

### Secret Name<a name="secret-name"></a>

Specifies the friendly name of the new secret\. The secret name must be ASCII letters, digits, or the following characters: /\_\+=\.@\- \(spaces are not permitted\)\.

Length Constraints: Minimum length of 1\. Maximum length of 512\.

If updating an existing secret you can specify either the Amazon Resource Name \(ARN\) or the friendly name of the secret\.

### Description<a name="id1"></a>

Optional description of the secret\.

### Secret Value Location<a name="secret-value-location"></a>

Specifies the source of the value to be stored in the secret\. You can enter text values for secrets inline in the task configuration or in a file loaded when the task runs\. Binary secret values must be loaded from a file\.

### Secret Value<a name="secret-value"></a>

Specifies the text value that you want to store in this secret\. For storing multiple values we recommend that you use a JSON text string argument and specify key/value pairs\.

Required if *Secret Value Location* is set to *Inline*\.

### Secret Value Type<a name="secret-value-type"></a>

Specifies whether the file contents being stored in the secret text or binary data\.

 **Note:** to satisfy the service's API requirements the task will automatically base\-64 encode secrets specified as binary type; you do not need to perform the base\-64 encoding prior to specifying the secret value in the task\.

### Path to File Containing Secret Value<a name="path-to-file-containing-secret-value"></a>

Specifies the file containing the value \(text or binary\) that you want to store in this secret\.

Required if *Secret Value Location* is set to *From File*\.

### KMS Key ID<a name="kms-key-id"></a>

Speciﬁes the ARN or alias of the AWS KMS customer master key \(CMK\) to be used to encrypt the secret\.

If you don't specify this value, then Secrets Manager defaults to using the AWS account's default CMK \(the one named aws/secretsmanager\)\. If a KMS CMK with that name doesn't yet exist, then Secrets Manager creates it for you automatically the ﬁrst time it needs to encrypt a secret\.

 **Important:** You can use the account's default CMK to encrypt and decrypt only if you call this operation using credentials from the same account that owns the secret\. If the secret is in a diﬀerent account, then you must create a custom CMK and specify the ARN in this ﬁeld\.

### Create secret if it does not exist<a name="create-secret-if-it-does-not-exist"></a>

If the specified secret does not exist, attempt to create a new secret\. Secrets Manager automatically attaches the staging label \_AWSCURRENT\_ to the new version\. If this option is not selected, the task will return an error if the secret cannot be found\.

### Tags for New Secret<a name="tags-for-new-secret"></a>

Optional list of tags \(key\-value pairs\) that can be assigned to the new secret\. Enter as Key=Value, one per line\. Up to 50 tags can be applied to a secret\.

### Output variable name to contain the secret's ARN<a name="output-variable-name-to-contain-the-secret-s-arn"></a>

Optional name of a variable to store the ARN of the new or updated secret on task completion\.

### Output variable name to contain the secret's version ID<a name="output-variable-name-to-contain-the-secret-s-version-id"></a>

Optional name of a variable to store the version ID of the new or updated secret on task completion\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ secretsmanager:CreateSecret
+ secretsmanager:PutSecretValue
+ secretsmanager:UpdateSecret