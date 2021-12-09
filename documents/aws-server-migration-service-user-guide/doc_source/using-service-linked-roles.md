# Service\-linked roles for AWS SMS<a name="using-service-linked-roles"></a>

AWS SMS uses a service\-linked role for the permissions that it requires to call other AWS services on your behalf\. For more information, see [Using Service\-Linked Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.

Before the introduction of a service\-linked role for AWS SMS, you were required to create two IAM roles to grant AWS SMS the permissions that it needs\. These roles are no longer required to use AWS SMS\. However, they are documented here for completeness\. For more information, see [Legacy IAM roles for AWS SMS](sms-legacy-iam-roles.md)\.

## Permissions granted by the service\-linked role<a name="service-linked-role-permissions"></a>

AWS SMS uses the service\-linked role named **AWSServiceRoleForSMS** to enable AWS SMS to manage your replication jobs\.

**AWSServiceRoleForSMS** trusts the `sms.amazonaws.com` service principal to assume the role\.

The role permissions policy allows AWS SMS to complete the following actions on the specified resources:
+ Use specific AWS SMS actions to create and manage replication jobs
+ Use specific AWS CloudFormation actions to create and manage arn:aws:cloudformation:\*:\*:stack/sms\-app\-\*/\*
+ Use specific Amazon EC2 actions to manage snapshots and images, launch instances, and manage instances that meet the following tag condition: ec2:ResourceTag/aws:cloudformation:stack\-id": "arn:aws:cloudformation:\*:\*:stack/sms\-app\-\*/\*
+ Use specific AWS Systems Manager actions to run scripts on your instances
+ Use `iam:GetRole` on all resources and `iam:PassRole` on arn:aws:cloudformation:\*:\*:stack/sms\-app\-\*/\*
+ Use specific Amazon S3 actions to create and manage arn:aws:s3:::sms\-app\-\*

## Create the service\-linked role<a name="create-service-linked-role"></a>

You don't need to manually create the **AWSServiceRoleForSMS** role\. AWS SMS creates this role for you when you select the **Allow automatic role creation** option when creating or updating a replication job, application, or launch configuration using the AWS Management Console\.

For AWS SMS to create a service\-linked role on your behalf, you must have the required permissions\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

If you do not use the console, you can create this service\-linked role manually\. For example, use the following AWS CLI [create\-service\-linked\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-service-linked-role.html) command to create **AWSServiceRoleForSMS**\.

```
aws iam create-service-linked-role --aws-service-name sms.amazonaws.com
```

## Edit the service\-linked role<a name="edit-service-linked-role"></a>

You can edit the description of **AWSServiceRoleForSMS** using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Delete the service\-linked role<a name="delete-service-linked-role"></a>

If you no longer need to use AWS SMS, we recommend that you delete the **AWSServiceRoleForSMS** role\. The service\-linked role can only be deleted in the following conditions:
+ The service\-linked role is not being used by an active replication job
+ The service\-linked role is not being used by an application that has an associated active replication job
+ The service\-linked role is not being used by an application that has an associated AWS CloudFormation stack

You can use the IAM console, the IAM CLI, or the IAM API to delete service\-linked roles\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

After you delete the **AWSServiceRoleForSMS** role, AWS SMS creates the role again if you start a replication job\.