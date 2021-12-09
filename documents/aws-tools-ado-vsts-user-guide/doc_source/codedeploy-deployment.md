# AWS CodeDeploy Application Deployment task<a name="codedeploy-deployment"></a>

## Synopsis<a name="synopsis"></a>

Deploys an application to Amazon EC2 instances by using AWS CodeDeploy\.

## Description<a name="description"></a>

This can be a variety of application content, such as code, web and configuration files, executable files, packages, scripts, and multimedia files\.

## Parameters<a name="parameters"></a>

You can set the following parameters for the task\. Required parameters are noted by an asterisk \(\*\)\. Other parameters are optional\.

### Display name\*<a name="display-name"></a>

The default name of the task instance, which can be modified: Deploy with CodeDeploy

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

### Application Name\*<a name="application-name"></a>

The name of the AWS CodeDeploy application\.

### Deployment Group Name\*<a name="deployment-group-name"></a>

The name of the deployment group the revision is to be deployed to\.

### Deployment Revision Source\*<a name="deployment-revision-source"></a>

Specifies the source of the revision to be deployed\. You can select from:
+  *Folder or archive file in the workspace*: the task will create or use an existing zip archive in the location specified to *Revision Bundle*, upload the archive to Amazon S3 and supply the key of the S3 object to CodeDeploy as the revision source\.
+  *Archive file in Amazon S3*: select to specify the key of an archive previously uploaded to Amazon S3 as the deployment revision source\.

### Revision Bundle\*<a name="revision-bundle"></a>

The location of the application revision artifacts to deploy\. You can supply a filename or folder\. If a folder is supplied the task will recursively zip the folder contents into an archive file before uploading the archive to Amazon S3\. If a filename is supplied the task uploads it unmodified to Amazon S3\. CodeDeploy requires the appspec\.yml file describing the application to exist at the root of the specified folder or archive file\.

Required if *Deployment Revision Source* is set to *Folder or archive file in the workspace*\.

### S3 Bucket Name\*<a name="s3-bucket-name"></a>

The name of the Amazon S3 bucket to which the revision bundle is uploaded or can be found, if *Archive file in Amazon S3* was selected for *Deployment Revision Source*\.

### Target Folder<a name="target-folder"></a>

Optional folder \(key prefix\) for the uploaded revision bundle in the bucket\. If not specified the, bundle is uploaded to the root of the bucket\.

Available when *Folder or archive file in the workspace* is selected for *Deployment Revision Source*\.

### Revision Bundle Key<a name="revision-bundle-key"></a>

The Amazon S3 object key of the previously uploaded archive file containing the deployment revision artifacts\.

Required if *Deployment Revision Source* is set to *Archive file in Amazon S3*\.

### Description<a name="id1"></a>

Optional description for the deployment\.

### Existing File Behavior<a name="existing-file-behavior"></a>

How AWS CodeDeploy should handle files that already exist in a deployment target location but weren't part of the previous successful deployment\.

### Advanced<a name="advanced"></a>

#### Update Outdated Instances Only<a name="update-outdated-instances-only"></a>

If checked, deploys to only those instances that are not running the latest application revision\.

#### Ignore Application Stop Failures<a name="ignore-application-stop-failures"></a>

When checked, if the deployment causes the ApplicationStop deployment lifecycle event to an instance to fail, the deployment to that instance is not considered failed at that point\. It continues on to the BeforeInstall deployment lifecycle event\.

#### Max Timeout<a name="max-timeout"></a>

Maximum time, specified in minutes, that the task should wait for the stack creation or update to complete\. By default a maximum of 60 minutes is used\.

### Output<a name="output"></a>

#### Output Variable<a name="output-variable"></a>

The name of the variable that will contain the deployment ID on task completion\. You can use the variable $\(variableName\) to refer to the function result in subsequent tasks\.

## Task Permissions<a name="task-permissions"></a>

This task requires permissions to call the following AWS service APIs \(depending on selected task options, not all APIs may be used\):
+ codedeploy:GetApplication
+ codedeploy:GetDeploymentGroup
+ codedeploy:CreateDeployment
+ codedeploy:GetDeployment

Depending on selected parameters the task may also require permissions to verify your deployment bundle exists in S3 or upload your application bundle to the specified Amazon S3 bucket\. Depending on the size of the application bundle, either PutObject or the S3 multi\-part upload APIs may be used\.