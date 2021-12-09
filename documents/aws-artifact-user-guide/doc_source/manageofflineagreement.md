# Managing an Existing Offline Agreement<a name="manageofflineagreement"></a>

Before you can view your accepted agreements for the first time, including the agreements that you accepted offline, follow the [Getting Started with AWS Artifact](getting-started.md) process\. After you go through all of the Getting Started steps, you can use the AWS Artifact console to view your offline agreements\.

If you have an existing offline agreement, AWS Artifact displays the agreements that you accepted offline\. For example, the console might display the **Offline Business Associate Addendum \(BAA\)** with an **Active** status\. The active status indicates that the agreement was accepted\. To terminate an offline agreement, see the termination guidelines and instructions that are included in your agreement\.

If your account is the master account in an AWS Organizations organization, you can use AWS Artifact to apply the terms of your offline agreement to all accounts in your organization\. To apply an agreement that you accepted offline to your organization and all accounts in your organization, you must have the following permissions:

```
organizations:DescribeOrganization 
organizations:EnableAWSServiceAccess 
organizations:ListAWSServiceAccessForOrganization
iam:ListRoles 
iam:CreateRole 
iam:AttachRolePolicy
```

If your account is a member account in an organization, you must have the following permissions to see your offline organization agreements:

```
organizations:DescribeOrganization 
```

For more information about creating policies, see [Create an IAM Policy](controlling-access.md#create-iam-policy)\.