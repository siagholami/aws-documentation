# Amazon S3 Download task<a name="s3-download"></a>

## Synopsis<a name="synopsis"></a>

Downloads file and folder content from an Amazon Simple Storage Service \(S3\) bucket\.

## Description<a name="description"></a>

Downloads file and folder content from an Amazon Simple Storage Service \(S3\) bucket to a folder location\. The source location in the bucket, or key prefix, can also be specified\. If a source location is not supplied, the bucket root is used\. You specify the files to download using a set of one or more globbing patterns\. The default pattern is `**`, causing all files in all folders at and beneath the source location to be downloaded, preserving the relative folder paths\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: S3 Download

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

### Bucket Name\*<a name="bucket-name"></a>

The name of the Amazon S3 bucket containing the content to download\.

### Source Folder<a name="source-folder"></a>

The source folder \(or S3 key prefix\) in the bucket that the filename selection patterns will be run against to select objects to download\. If not set the root of the bucket is assumed\.

### Filename Patterns<a name="filename-patterns"></a>

Glob patterns to select the file and folder content to download\. Supports multiple lines of minimatch patterns\. The default is `**`\.

### Target Folder\*<a name="target-folder"></a>

The target folder on the build host to contain the downloaded content\. You can browse for it or you can use [variables](https://www.visualstudio.com/en-us/docs/build/define/variables)\.

### Server\-Side Encryption<a name="server-side-encryption"></a>

#### Encryption Key Management<a name="encryption-key-management"></a>

When you retrieve an object from Amazon S3 that was encrypted by using server\-side encryption with customer\-provided encryption keys \(SSE\-C\), set *Use customer\-provided encryption key* and provide the customer key data to enable the objects to be decrypted\. If the objects were encrypted using an Amazon S3\-provided key leave this option set to the default value, *Not using server\-side encryption, or encrypted using an Amazon S3 managed key*\.

#### Customer Key<a name="customer-key"></a>

Available, and required, when *Encryption Key Management* is set to *Use customer\-provided encryption key*\. Hex\-encoded string representing the encryption key for Amazon S3 to use in decrypting data\. This value is used to decrypt the object and then is discarded; Amazon does not store the encryption key\. This value must be appropriate for use with the AES256 encryption algorithm used for encryption when customer managed keys are selected\.

### Advanced<a name="advanced"></a>

#### Overwrite<a name="overwrite"></a>

Changing this checkbox has no effect\. If a file \(an Amazon S3 object\) with the same name already exists in the Amazon S3 bucket, it will always be overwritten\.

#### Force path style addressing<a name="force-path-style-addressing"></a>

If selected path style URLs will be used when working with the bucket\. The default is off meaning the task will automatically switch between virtual host style addressing and path style addressing depending on whether the bucket name is DNS compatible\.

For more information see [Virtual Hosting of Buckets](https://docs.aws.amazon.com/AmazonS3/latest/dev/VirtualHosting.html)\.

#### Flatten folders<a name="flatten-folders"></a>

If selected, the task will remove the key prefix from the downloaded objects causing them to be written to the selected download folder without subpaths\.

If this option is unchecked, the key prefix of each object is preserved and objects are downloaded to a subfolder hierarchy matching the key prefix of the object\.

**Note**  
If folder flattening is selected and multiple objects with the same name but different key prefixes exist in the download set, earlier objects will be overwritten with later objects\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ s3:GetObject
+ s3:HeadBucket
+ s3:ListObjects