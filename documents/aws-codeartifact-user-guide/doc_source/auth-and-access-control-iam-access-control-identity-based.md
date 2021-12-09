# Overview of managing access permissions to your AWS CodeArtifact resources<a name="auth-and-access-control-iam-access-control-identity-based"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by permissions policies\. An account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\)\. 

**Note**  
An account administrator \(or administrator user\) is a user with administrator privileges\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When you grant permissions, you decide who is getting the permissions, the resources they can access, and the actions that can be performed on those resources\.

**Topics**
+ [AWS CodeArtifact resources and operations](#arn-formats)
+ [Understanding resource ownership](#understanding-resource-ownership)
+ [Managing access to resources](#managing-access-resources)
+ [Specifying policy elements: Actions, effects, and principals](#actions-effects-principals)
+ [AWS Global Condition Context Keys](#global-condition-keys)

## AWS CodeArtifact resources and operations<a name="arn-formats"></a>

In AWS CodeArtifact, the primary resource is a domain\. In a policy, you use an Amazon Resource Name \(ARN\) to identify the resource the policy applies to\. Repositories are also resources and have ARNs associated with them\. For more information, see [Amazon Resource Names \(ARNs\)](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) in the *Amazon Web Services General Reference*\.


| Resource type | ARN format | 
| --- | --- | 
| Domain |  `arn:aws:codeartifact:region-ID:account-ID:domain/domain-name`  | 
| Repository |  `arn:aws:codeartifact:region-ID:account-ID:domain/domain-name/repository-name`  | 
| Package with a namespace |  arn:aws:codeartifact:region\-ID:account\-ID:package/domain\-name/repository\-name/package\-format/namespace/package\-name  | 
| Package without a namespace |  arn:aws:codeartifact:region\-ID:account\-ID:package/domain\-name/repository\-name/package\-format//package\-name  | 
|  All CodeArtifact resources  |  `arn:aws:codeartifact:*`  | 
|  All CodeArtifact resources owned by the specified account in the specified AWS Region  |  `arn:aws:codeartifact:region-ID:account-ID:*`  | 

**Note**  
Most AWS services treat a colon \(:\) or a forward slash \(/\) as the same character in ARNs\. However, CodeArtifact uses an exact match in resource patterns and rules\. Be sure to use the correct characters when you create event patterns so that they match the ARN syntax in the resource\.

For example, you can indicate a specific domain \(*myDomain*\) in your statement using its ARN as follows\.

```
"Resource": "arn:aws:codeartifact:us-east-2:123456789012:domain/myDomain"
```

To specify all resources, or if an API action does not support ARNs, use the wildcard character \(\*\) in the `Resource` element as follows\.

```
"Resource": "*"
```

To specify multiple resources in a single statement, separate their ARNs with commas, as follows\.

```
"Resource": [
  "arn:aws:codeartifact:us-east-2:123456789012:domain/myDomain",
  "arn:aws:codeartifact:us-east-2:123456789012:domain/myOtherDomain"
]
```

CodeArtifact provides a set of operations to work with the CodeArtifact resources\. For a list, see [AWS CodeArtifact permissions reference](auth-and-access-control-permissions-reference.md)\.

## Understanding resource ownership<a name="understanding-resource-ownership"></a>

The AWS account owns the resources that are created in the account, regardless of who created the resources\. Specifically, the resource owner is the AWS account of the [principal entity](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html) \(that is, the root account, an IAM user, or an IAM role\) that authenticates the resource creation request\. The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create a rule, your AWS account is the owner of the CodeArtifact resource\.
+ If you create an IAM user in your AWS account and grant permissions to create CodeArtifact resources to that user, the user can create CodeArtifact resources\. However, your AWS account, to which the user belongs, owns the CodeArtifact resources\.
+ If you create an IAM role in your AWS account with permissions to create CodeArtifact resources, anyone who can assume the role can create CodeArtifact resources\. Your AWS account, to which the role belongs, owns the CodeArtifact resources\.

## Managing access to resources<a name="managing-access-resources"></a>

A permissions policy describes who has access to which resources\. 

**Note**  
This section discusses the use of IAM in AWS CodeArtifact\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see [What Is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in the *IAM User Guide*\. For information about IAM policy syntax and descriptions, see [IAM JSON Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as* identity\-based policies* \(IAM policies\)\. Policies attached to a resource are referred to as *resource\-based policies*\. CodeArtifact supports identity\-based \(IAM policies\) only\.

### Identity\-based policies<a name="identity-based-policies"></a>

You can attach policies to IAM identities\. 
+ **Attach a permissions policy to a user or a group in your account** – To grant a user permissions to view domains and other AWS CodeArtifact resources in the AWS CodeArtifact console, you can attach a permissions policy to a user or group that the user belongs to\.
+ **Attach a permissions policy to a role \(grant cross\-account permissions\)** – You can attach an identity\-based permissions policy to an IAM role to grant cross\-account permissions\. For example, the administrator in Account A can create a role to grant cross\-account permissions to another AWS account \(for example, Account B\) or an AWS service as follows:

  1. Account A administrator creates an IAM role and attaches a permissions policy to the role that grants permissions on resources in Account A\.

  1. Account A administrator attaches a trust policy to the role identifying Account B as the principal who can assume the role\.

  1. Account B administrator can then delegate permissions to assume the role to any users in Account B\. Doing this allows users in Account B to create or access resources in Account A\. The principal in the trust policy must also be an AWS service principal if you want to grant an AWS service permissions to assume the role\.

  For more information about using IAM to delegate permissions, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\.

In CodeArtifact, identity\-based policies are used to manage permissions to the resources related to artifact management\. For example, you can control access to domain\.

You can create IAM policies to restrict the calls and resources that users in your account have access to, and then attach those policies to IAM users\. For more information about how to create IAM roles and to explore example IAM policy statements for CodeArtifact, see [Overview of managing access permissions to your AWS CodeArtifact resources](#auth-and-access-control-iam-access-control-identity-based)\. 

## Specifying policy elements: Actions, effects, and principals<a name="actions-effects-principals"></a>

For each AWS CodeArtifact resource, the service defines a set of API operations\. To grant permissions for these API operations, CodeArtifact defines a set of actions that you can specify in a policy\. Some API operations can require permissions for more than one action in order to perform the API operation\. For more information, see [AWS CodeArtifact resources and operations](#arn-formats) and [AWS CodeArtifact permissions reference](auth-and-access-control-permissions-reference.md)\.

The following are the basic policy elements:
+ **Resource** – You use an Amazon Resource Name \(ARN\) to identify the resource that the policy applies to\.
+ **Action** – You use action keywords to identify resource operations you want to allow or deny\. For example, the `codeartifact:DeleteDomain;` permission gives the user permissions to perform the `[DeleteDomain](https://docs.aws.amazon.com/codeartifact/latest/APIReference/API_DeleteDomain.html)` operation\.
+ **Effect** – You specify the effect, either allow or deny, when the user requests the action\. If you don't explicitly grant access to \(allow\) a resource, access is implicitly denied\. You can also explicitly deny access to a resource\. You might do this to make sure that a user cannot access a resource, even if a different policy grants access\.
+ **Principal** – In identity\-based policies \(IAM policies\), the user the policy is attached to is the implicit principal\. For resource\-based policies, you specify the user, account, service, or other entity that you want to receive permissions\.

To learn more about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

For a table showing all of the CodeArtifact API actions and the resources they apply to, see the [AWS CodeArtifact permissions reference](auth-and-access-control-permissions-reference.md)\.

## AWS Global Condition Context Keys<a name="global-condition-keys"></a>

AWS CodeArtifact does not support the following AWS Global Condition Context Keys:
+  [Referer](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-referer) 
+ [UserAgent](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#condition-keys-useragent)

 For more information on condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html)\. 