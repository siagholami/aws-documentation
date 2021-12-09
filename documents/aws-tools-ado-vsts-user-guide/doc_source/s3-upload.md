# Amazon S3 Upload task<a name="s3-upload"></a>

## Synopsis<a name="synopsis"></a>

Uploads file and folder content to an Amazon Simple Storage Service \(S3\) bucket\.

## Description<a name="description"></a>

This task accepts a source location from which to upload files to an Amazon S3 bucket\. The target location in the bucket, or key prefix, can also be specified\. If you don't supply a target location, the files are uploaded to the bucket root\. You specify the files to upload by using a set of one or more globbing patterns\. The default pattern is `**`, which causes all files in all folders at and beneath the source location to be uploaded, preserving the relative folder paths\.

The task can optionally create the bucket to which the content is to be uploaded\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: S3 Upload

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

The name of the Amazon S3 bucket to which the content will be uploaded\. If the bucket does not exist it can be created if the *Create S3 bucket if it does not exist* option is selected\.

 **Note:** bucket names must be globally unique\.

### Source Folder<a name="source-folder"></a>

The source folder that the filename selection patterns will be run against\. If not set the root of the work area is assumed\. You can also use [variables](https://go.microsoft.com/fwlink/?LinkID=550988) to specify the folder\.

Example: code:*$\(Build\.ArtifactStagingDirectory\)* 

### Filename Patterns<a name="filename-patterns"></a>

Glob patterns to select the file and folder content to be uploaded\. Supports multiple lines of minimatch patterns\.

### Target Folder\*<a name="target-folder"></a>

The target folder \(referred to as a key prefix in Amazon S3\) in the bucket to contain the uploaded content\. If not set the root of the bucket is assumed\. You can also use [variables](https://go.microsoft.com/fwlink/?LinkID=550988) to specify the folder/key prefix value\.

### Access Control \(ACL\)<a name="access-control-acl"></a>

The canned access control list \(ACL\) to apply to the uploaded content\. See [Canned ACL](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl) for an explanation of the possible values\. By default all uploaded content is marked *Private*\.

### Create S3 Bucket if it does not exist<a name="create-s3-bucket-if-it-does-not-exist"></a>

If checked and the specified bucket does not exist, the task attempts to automatically create it\.

 **Note:** bucket names must be globally unique\.

### Server\-Side Encryption<a name="server-side-encryption"></a>

#### Encryption Key Management<a name="encryption-key-management"></a>

You can optionally request Amazon S3 to encrypt data at rest using server\-side encryption\. Server\-side encryption is about data encryption at rest, that is, Amazon S3 encrypts your data as it writes it to disks in its data centers and decrypts it for you when you access it\.

Select *Use AWS\-managed encryption keys* if you want Amazon S3 to manage keys used to encrypt data\. To manage and provide your own keys select *Use customer\-provided encryption keys*\. Selecting *Not using server\-side encryption* disables server\-side encryption for the uploaded objects\.

#### Encryption Algorithm<a name="encryption-algorithm"></a>

Specifies a server\-side encryption algorithm to use when Amazon S3 creates an object\.

#### KMS Master Encryption Key ID<a name="kms-master-encryption-key-id"></a>

The ID of the AWS Key Management Service \(KMS\) master encryption key to be used when encrypting the object\.

This field is required if *Encryption Algorithm* is set to *aws:kms*\.

#### Customer Key<a name="customer-key"></a>

Hex\-encoded string representing the encryption key for Amazon S3 to use in encrypting data\. This value is used to store the object and then is discarded; Amazon S3 does not store the encryption key\. This value must be appropriate for use with the AES256 encryption algorithm used for encryption when customer managed keys are selected\.

This field is required when *Encryption Key Management* is set to *Use customer\-provided encryption key*\.

### Advanced<a name="advanced"></a>

#### Overwrite<a name="overwrite"></a>

Changing this checkbox has no effect\. If a file \(an Amazon S3 object\) with the same name already exists in the Amazon S3 bucket, it will always be overwritten\.

#### Flatten Folders<a name="flatten-folders"></a>

If selected the relative subfolders of the files being uploaded are removed and all files are placed directly into the target location\. The default behavior is to preserve the relative folder hierarchy\.

#### Content Type<a name="content-type"></a>

Sets a custom content type for the uploaded files\. If a custom content type is not specified the task will apply built\-in defaults for common file types \(html, css, js, image files etc\.\)\. This parameter can be used to override the built\-in defaults\.

 **Note:** any value specified is applied to **all** files processed by the task\.

#### Storage Class<a name="storage-class"></a>

Choose a storage class depending on your use case scenario and performance access requirements\.
+  *STANDARD* – This storage class \(the default\) is ideal for performance\-sensitive use cases and frequently accessed data\.
+  *STANDARD\_IA* – This storage class \(IA, for infrequent access\) is optimized for long\-lived and less frequently accessed data, for example backups and older data where frequency of access has diminished, but the use case still demands high performance\. **Note** There is a retrieval fee associated with STANDARD\_IA objects which makes it most suitable for infrequently accessed data\.
+  *REDUCED\_REDUNDANCY* – The Reduced Redundancy Storage \(RRS\) storage class is designed for noncritical, reproducible data stored at lower levels of redundancy than the STANDARD storage class, which reduces storage costs\.

For more information see [Storage Classes](https://docs.aws.amazon.com/AmazonS3/latest/dev/storage-class-intro.html) in the Amazon S3 documentation for more information\.

#### Force path style addressing<a name="force-path-style-addressing"></a>

If selected path style URLs will be used for S3 objects\. The default is off meaning the task will automatically switch between virtual host style addressing and path style addressing depending on whether the bucket name is DNS compatible\.

For more information see [Virtual Hosting of Buckets](https://docs.aws.amazon.com/AmazonS3/latest/dev/VirtualHosting.html)\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ s3:CreateBucket
+ s3:HeadBucket

Content uploads are performed using S3's PutObject API and/or the multi\-part upload APIs\. The specific APIs used depend on the size of the individual files being uploaded\.