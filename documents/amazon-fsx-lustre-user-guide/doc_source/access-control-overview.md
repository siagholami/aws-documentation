# Administration Access Control with IAM for Amazon FSx for Lustre Resources<a name="access-control-overview"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by permissions policies\. An account administrator can attach permissions policies to AWS Identity and Access Management \(IAM\) identities \(that is, users, groups, and roles\)\. Some services \(such as AWS Lambda\) also support attaching permissions policies to resources\. 

**Note**  
An *account administrator* \(or administrator user\) is a user with administrator privileges\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When granting permissions, you decide who is getting the permissions, the resources they get permissions for, and the specific actions that you want to allow on those resources\.

**Topics**
+ [Resources and Operations for Amazon FSx for Lustre](#access-control-resources)
+ [Using Service\-Linked Roles for Amazon FSx for Lustre](using-service-linked-roles.md)
+ [Understanding Resource Ownership](#access-control-owner)
+ [Managing Access to Resources](#access-control-manage-access-intro)
+ [Amazon FSx for Lustre API Permissions: Actions, Resources, and Conditions Reference](fsx-api-permissions-ref.md)

## Resources and Operations for Amazon FSx for Lustre<a name="access-control-resources"></a>

In Amazon FSx for Lustre, the primary resource is a *file system*\. Amazon FSx for Lustre also supports additional resource types, the data repository task\. However, for Amazon FSx, you can create data repository tasks only in the context of an existing file system\. Data repository tasks are referred to as subresources\. These resources and subresources have unique Amazon Resource Names \(ARNs\) associated with them as shown in the following table\.


****  

| Resource Type | ARN Format | 
| --- | --- | 
| File system | arn:aws:fsx:region:account\-id:file\-system/filesystem\-id | 
| Data repository task | arn:aws:fsx:region:account\-id:task/task\-id | 

Amazon FSx for Lustre provides a set of operations to work with Amazon FSx for Lustre resources\. For a list of available operations, see the [Amazon FSx for Lustre API Reference](https://docs.aws.amazon.com/fsx/latest/APIReference/Welcome.html)\.

## Understanding Resource Ownership<a name="access-control-owner"></a>

The AWS account owns the resources that are created in the account, regardless of who created the resources\. Specifically, the resource owner is the AWS account of the [principal entity](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html) \(that is, the root account, an IAM user, or an IAM role\) that authenticates the resource creation request\. The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create a file system, your AWS account is the owner of the resource\. In Amazon FSx for Lustre, the resource is the file system\.
+ If you create an IAM user in your AWS account and grant permissions to create a file system to that user, the user can create a file system\. However, your AWS account, to which the user belongs, owns the file system resource\.
+ If you create an IAM role in your AWS account with permissions to create a file system, anyone who can assume the role can create a file system\. Your AWS account, to which the role belongs, owns the file system resource\. 

## Managing Access to Resources<a name="access-control-manage-access-intro"></a>

A *permissions policy* describes who has access to what\. The following section explains the available options for creating permissions policies\.

**Note**  
This section discusses using IAM in the context of Amazon FSx for Lustre\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see [What Is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in the *IAM User Guide*\. For information about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as *identity\-based* policies \(IAM policies\) and policies attached to a resource are referred to as *resource\-based* policies\. Amazon FSx for Lustre supports only identity\-based policies \(IAM policies\)\. 