# Using Identity\-Based Policies \(IAM Policies\) for Cloud Directory<a name="iam_auth_access_accesscontrol_identitybased"></a>

This topic provides examples of identity\-based policies in which an account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\)\. 

**Important**  
We recommend that you first review the introductory topics that explain the basic concepts and options available for you to manage access to your Cloud Directory resources\. For more information, see [Overview of Managing Access Permissions to Your Cloud Directory Resources](iam_auth_access_accesscontrol_overview.md)\.

The sections in this topic cover the following:
+ [Permissions Required to Use the AWS Directory Service Console](#iam_auth_access_usingwith_iam_requiredpermissions_console)
+ [AWS Managed \(Predefined\) Policies for Amazon Cloud Directory](#iam_auth_access_accesscontrol_managedpolicies)

## Permissions Required to Use the AWS Directory Service Console<a name="iam_auth_access_usingwith_iam_requiredpermissions_console"></a>

For a user to work with the AWS Directory Service console, that user must have permissions listed in the policy above or the permissions granted by the Directory Service Full Access Role or Directory Service Read Only role, described in [AWS Managed \(Predefined\) Policies for Amazon Cloud Directory](#iam_auth_access_accesscontrol_managedpolicies)\.

If you create an IAM policy that is more restrictive than the minimum required permissions, the console won't function as intended for users with that IAM policy\. 

## AWS Managed \(Predefined\) Policies for Amazon Cloud Directory<a name="iam_auth_access_accesscontrol_managedpolicies"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. Managed policies grant necessary permissions for common use cases so you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\.

The following AWS managed policies, which you can attach to users in your account, are specific to Amazon Cloud Directory:
+ **AmazonCloudDirectoryReadOnlyAccess** – Grants a user or group read\-only access to all Amazon Cloud Directory resources\. For more information, see the [Policies](https://console.aws.amazon.com/iam/home#policies/arn:aws:iam::aws:policy/AmazonCloudDirectoryReadOnlyAccess) page in the AWS Management Console\.
+ **AmazonCloudDirectoryFullAccess** – Grants a user or group full access to Amazon Cloud Directory\. For more information, see the [Policies](https://console.aws.amazon.com/iam/home#policies/arn:aws:iam::aws:policy/AmazonCloudDirectoryFullAccess) page in the AWS Management Console\.

In addition, there are other AWS\-managed policies that are suitable for use with other IAM roles\. These policies are assigned to the roles associated with users in your Amazon Cloud Directory and are required in order for those users to have access to other AWS resources, such as Amazon EC2\.

You can also create custom IAM policies that allow users to access the required API actions and resources\. You can attach these custom policies to the IAM users or groups that require those permissions\.