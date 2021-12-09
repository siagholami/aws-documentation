# Overview of managing access permissions to your CodeGuru Profiler resources<a name="security_iam_service-with-iam"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by IAM permissions policies\. An account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\)\. 

**Note**  
An account administrator \(or administrator user\) is a user with administrator privileges\. For more information, see [IAM best practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When you grant permissions, you decide who is getting the permissions, the resources they can access, and the actions that can be performed on those resources\.

**Topics**
+ [CodeGuru Profiler resources and operations](#arn-formats)
+ [Understanding resource ownership](#understanding-resource-ownership)
+ [Managing access to resources](#managing-access-resources)
+ [Specifying policy elements: actions, effects, and principals](#actions-effects-principals)

## CodeGuru Profiler resources and operations<a name="arn-formats"></a>

In CodeGuru Profiler, the primary resource is a profiling group\. In a policy, you use an Amazon Resource Name \(ARN\) to identify the resource the policy applies to\. For more information, see [Amazon Resource Names \(ARNs\)](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) in the *Amazon Web Services General Reference*\.


| Resource type | ARN format | 
| --- | --- | 
| profiling group |  `arn:aws:codeguru-profiler:region-ID:account-ID:profilingGroup/profiling-group-name`  | 

For example, you can indicate a specific profiling group \(*my\-profiling\-group*\) in your statement using its ARN, as follows\.

```
"Resource": "arn:aws:codeguru-profiler:us-east-2:123456789012:profilingGroup/my-profiling-group"
```

To specify all resources, or if an API action does not support ARNs, use the wildcard character \(\*\) in the `Resource` element, as follows\.

```
"Resource": "*"
```

To specify multiple resources in a single statement, separate their ARNs with commas, as follows\.

```
"Resource": [
     "arn:aws:codeguru-profiler:us-east-2:123456789012:profilingGroup/my-profiling-group",
     "arn:aws:codeguru-profiler:us-east-2:123456789012:profilingGroup/my-other-profiling-group"
   ]
```

CodeGuru Profiler provides a set of operations to work with the CodeGuru Profiler resources\. For a list, see the [Amazon CodeGuru Profiler permissions reference](auth-and-access-control-permissions-reference.md)\.

## Understanding resource ownership<a name="understanding-resource-ownership"></a>

The AWS account owns the resources that are created in it, regardless of who created the resources\. Specifically, the resource owner is the AWS account of the [principal entity](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html) \(that is, the root account, an IAM user, or an IAM role\) that authenticates the resource creation request\. The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create a profiling group, your AWS account is the owner of the CodeGuru Profiler resource\.
+ If you create an IAM user in your AWS account and grant permissions to create CodeGuru Profiler resources to that user, the user can create CodeGuru Profiler resources\. However, your AWS account, to which the user belongs, owns the CodeGuru Profiler resources\.
+ If you create an IAM role in your AWS account with permissions to create CodeGuru Profiler resources, anyone who can assume the role can create CodeGuru Profiler resources\. Your AWS account, to which the role belongs, owns the CodeGuru Profiler resources\.

## Managing access to resources<a name="managing-access-resources"></a>

A permissions policy describes who has access to which resources\. 

**Note**  
This section discusses the use of IAM in Amazon CodeGuru Profiler\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see [What is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in the *IAM User Guide*\. For information about IAM policy syntax and descriptions, see the [IAM JSON Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as *identity\-based policies* \(IAM policies\)\. Policies attached to a resource are referred to as *resource\-based policies*\. CodeGuru Profiler supports identity\-based \(IAM policies\) only\.

### Identity\-based policies<a name="identity-based-policies"></a>

You can attach policies to IAM identities\. 
+ **Attach a permissions policy to a user or a group in your account** – To grant a user permissions to view profiling groups in the CodeGuru Profiler console, you can attach a permissions policy to a user or group that the user belongs to\.
+ **Attach a permissions policy to a role \(grant cross\-account permissions\)** – You can attach an identity\-based permissions policy to an IAM role to grant cross\-account permissions\. For example, the administrator in Account A can create a role to grant cross\-account permissions to another AWS account \(for example, Account B\) or an AWS service, as follows:

  1. Account A administrator creates an IAM role and attaches a permissions policy to the role that grants permissions on resources in Account A\.

  1. Account A administrator attaches a trust policy to the role identifying Account B as the principal who can assume the role\.

  1. Account B administrator can then delegate permissions to assume the role to any users in Account B\. Doing this allows users in Account B to create or access resources in Account A\. The principal in the trust policy must also be an AWS service principal if you want to grant an AWS service permissions to assume the role\.

  For more information about using IAM to delegate permissions, see [Access management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\.

In CodeGuru Profiler, identity\-based policies are used to manage permissions to the resources related to artifact management\. For example, you can control access to a profiling group\.

You can create IAM policies to restrict the calls and resources that users in your account have access to, and then attach those policies to IAM users\. For more information about how to create IAM roles and to explore example IAM policy statements for CodeGuru Profiler, see [Identity\-based policies](security_iam_access-manage.md#security_iam_access-manage-id-based-policies)\. 

## Specifying policy elements: actions, effects, and principals<a name="actions-effects-principals"></a>

For each CodeGuru Profiler resource, the service defines a set of API operations\. To grant permissions for these API operations, CodeGuru Profiler defines a set of actions that you can specify in a policy\. Some API operations can require permissions for more than one action to perform the API operation\. For more information, see [CodeGuru Profiler resources and operations](#arn-formats) and the [Amazon CodeGuru Profiler permissions reference](auth-and-access-control-permissions-reference.md)\.

The following are the basic policy elements:
+ **Resource** – You use an Amazon Resource Name \(ARN\) to identify the resource that the policy applies to\.
+ **Action** – You use action keywords to identify resource operations to allow or deny\. For example, the `codeguru-profiler:DeleteProfilingGroup;` permission gives the user permission to perform the `[DeleteProfilingGroup](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_DeleteProfilingGroup.html)` operation\.
+ **Effect** – You specify the effect, either allow or deny, when the user requests the action\. If you don't explicitly grant access to \(allow\) a resource, access is implicitly denied\. You can also explicitly deny access to a resource\. You might do this to make sure that a user cannot access a resource, even if a different policy grants access\.
+ **Principal** – In identity\-based policies \(IAM policies\), the user the policy is attached to is the implicit principal\. For resource\-based policies, you specify the user, account, service, or other entity that you want to receive permissions\.

To learn more about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

For a table showing all of the CodeGuru Profiler API actions and the resources they apply to, see the [Amazon CodeGuru Profiler permissions reference](auth-and-access-control-permissions-reference.md)\.