# Using Service\-Linked Roles for Amazon FSx for Lustre<a name="using-service-linked-roles"></a>

Amazon FSx for Lustre uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Amazon FSx for Lustre\. Service\-linked roles are predefined by Amazon FSx for Lustre and include all the permissions that the service requires to call other AWS services on your behalf\. 

Amazon FSx for Lustre defines the permissions of its service\-linked roles, and unless defined otherwise, only Amazon FSx for Lustre can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your Amazon FSx for Lustre resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-Linked Role Permissions for Amazon FSx for Lustre<a name="slr-permissions"></a>

Amazon FSx for Lustre uses two service\-linked roles named `AWSServiceRoleForAmazonFSx` and `AWSServiceRoleForFSxS3Access_fs-01234567890` that perform certain actions in your account\. Examples of these actions are creating elastic network interfaces for your file systems in your VPC and accessing your data repository in an Amazon S3 bucket\. For `AWSServiceRoleForFSxS3Access_fs-01234567890`, this service\-linked role is created for each Amazon FSx for Lustre file system you create that is linked to an S3 bucket\.

For `AWSServiceRoleForAmazonFSx`, the role permissions policy allows Amazon FSx for Lustre to complete the following actions on the all applicable AWS resources:
+ `ec2:CreateNetworkInterface`

For `AWSServiceRoleForFSxS3Access_fs-01234567890`, the role permissions policy allows Amazon FSx for Lustre to complete the following actions on your Amazon S3 bucket hosting your data repository\.
+ `s3:AbortMultipartUpload`
+ `s3:DeleteObject`
+ `s3:PutObject`
+ `s3:Get*`
+ `s3:List*`

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a Service\-Linked Role for Amazon FSx for Lustre<a name="create-slr"></a>

You don't need to manually create a service\-linked role\. When you create a file system in the AWS Management Console, the IAM CLI, or the IAM API, Amazon FSx for Lustre creates the service\-linked roles for you\. 

**Important**  
The service\-linked roles can appear in your account if you completed an action in another service that uses the features supported by this role\. To learn more, see [A New Role Appeared in My IAM Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared)\.

If you delete these service\-linked roles, and then need to create them again, you can use the same process to recreate the role in your account\. When you create a file system, Amazon FSx for Lustre creates the service\-linked role for you again\. 

## Editing a Service\-Linked Role for Amazon FSx for Lustre<a name="edit-slr"></a>

Amazon FSx for Lustre does not allow you to edit these service\-linked roles\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a Service\-Linked Role for Amazon FSx for Lustre<a name="delete-slr"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must delete all of your file systems and backups before you can manually delete the service\-linked role\.

**Note**  
If the Amazon FSx for Lustre service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To manually delete a service\-linked role using IAM**

Use the IAM console, the AWS CLI, or the IAM API to delete the AWSServiceRoleForAmazonFSx service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Amazon FSx for Lustre Service\-Linked Roles<a name="slr-regions"></a>

Amazon FSx for Lustre supports using service\-linked roles in all of the regions where the service is available\. For more information, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\.