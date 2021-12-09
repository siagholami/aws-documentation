# Overview of Managing Access Permissions to Your Cloud Directory Resources<a name="iam_auth_access_accesscontrol_overview"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access the resources are governed by permissions policies\. An account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\), and some services \(such as AWS Lambda\) also support attaching permissions policies to resources\.

**Note**  
An *account administrator* \(or administrator user\) is a user with administrator privileges\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When granting permissions, you decide who is getting the permissions, the resources they get permissions for, and the specific actions that you want to allow on those resources\. 

**Topics**
+ [Cloud Directory Resources and Operations](#iam_auth_access_creatingiampolicies)
+ [Understanding Resource Ownership](#iam_auth_access_accesscontrol_resourceowner)
+ [Managing Access to Resources](#iam_auth_access_accesscontrol_managingaccess)
+ [Specifying Policy Elements: Actions, Effects, Resources, and Principals](#iam_auth_access_specifyingiampolicyactions)
+ [Specifying Conditions in a Policy](#iam_auth_access_specifyingiampolicyconditions)

## Cloud Directory Resources and Operations<a name="iam_auth_access_creatingiampolicies"></a>

In Cloud Directory, the primary resources are directories and schemas\. These resources have unique Amazon Resource Names \(ARNs\) associated with them as shown in the following table\.


****  

| **Resource Type**  |  **ARN Format**  | 
| --- | --- | 
| Directory | `arn:aws:clouddirectory:region:account-id:directory/directory-id` | 
| Schema | arn:aws:clouddirectory:region:account\-id:schema/schema\-state/schema\-name | 

For more information about schema states and ARNs, see [ARN Examples](https://docs.aws.amazon.com/clouddirectory/latest/APIReference/arns.html) in the *Amazon Cloud Directory API Reference*\.

Cloud Directory provides a set of operations to work with the appropriate resources\. For a list of available operations, see either [Amazon Cloud Directory Actions](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_Operations.html) or [Directory Service Actions](https://docs.aws.amazon.com/directoryservice/latest/devguide/API_Operations.html)\.

## Understanding Resource Ownership<a name="iam_auth_access_accesscontrol_resourceowner"></a>

A *resource owner* is the AWS account that created a resource\. That is, the resource owner is the AWS account of the *principal entity* \(the root account, an IAM user, or an IAM role\) that authenticates the request that creates the resource\. The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create a Cloud Directory resource, such as a directory, your AWS account is the owner of that resource\.
+ If you create an IAM user in your AWS account and grant permissions to create Cloud Directory resources to that user, the user can also create Cloud Directory resources\. However, your AWS account, to which the user belongs, owns the resources\.
+ If you create an IAM role in your AWS account with permissions to create Cloud Directory resources, anyone who can assume the role can create Cloud Directory resources\. Your AWS account, to which the role belongs, owns the Cloud Directory resources\. 

## Managing Access to Resources<a name="iam_auth_access_accesscontrol_managingaccess"></a>

A *permissions policy* describes who has access to what\. The following section explains the available options for creating permissions policies\.

**Note**  
This section discusses using IAM in the context of Cloud Directory\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see [What Is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in the *IAM User Guide*\. For information about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as *identity\-based* policies \(IAM polices\) and policies attached to a resource are referred to as *resource\-based* policies\. Cloud Directory supports only identity\-based policies \(IAM policies\)\.

**Topics**
+ [Identity\-Based Policies \(IAM Policies\)](#iam_auth_access_accesscontrol_managingaccess_identitybased)
+ [Resource\-Based Policies](#iam_auth_access_accesscontrol_managingaccess_resourcebased)

### Identity\-Based Policies \(IAM Policies\)<a name="iam_auth_access_accesscontrol_managingaccess_identitybased"></a>

You can attach policies to IAM identities\. For example, you can do the following: 
+ **Attach a permissions policy to a user or a group in your account** – An account administrator can use a permissions policy that is associated with a particular user to grant permissions for that user to create an Cloud Directory resource, such as a new directory\. 
+ **Attach a permissions policy to a role \(grant cross\-account permissions\)** – You can attach an identity\-based permissions policy to an IAM role to grant cross\-account permissions\. For example, the administrator in Account A can create a role to grant cross\-account permissions to another AWS account \(for example, Account B\) or an AWS service as follows: 

  1. Account A administrator creates an IAM role and attaches a permissions policy to the role that grants permissions on resources in Account A\.

  1. Account A administrator attaches a trust policy to the role identifying Account B as the principal who can assume the role\. 

  1. Account B administrator can then delegate permissions to assume the role to any users in Account B\. Doing this allows users in Account B to create or access resources in Account A\. The principal in the trust policy can also be an AWS service principal if you want to grant an AWS service permissions to assume the role\.

   For more information about using IAM to delegate permissions, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\. 

The following permissions policy grants permissions to a user to run all of the actions that begin with `Create`\. These actions show information about an Cloud Directory resource, such as a directory or schema\. Note that the wildcard character \(\*\) in the `Resource` element indicates that the actions are allowed for all Cloud Directory resources owned by the account\. 

```
 1. {
 2.    "Version":"2017-01-11",
 3.    "Statement":[
 4.       {
 5.          "Effect":"Allow",
 6.          "Action":"clouddirectory:Create*",
 7.          "Resource":"*"
 8.       }
 9.    ]
10. }
```

For more information about using identity\-based policies with Cloud Directory, see [Using Identity\-Based Policies \(IAM Policies\) for Cloud Directory](iam_auth_access_accesscontrol_identitybased.md)\. For more information about users, groups, roles, and permissions, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the *IAM User Guide*\. 

### Resource\-Based Policies<a name="iam_auth_access_accesscontrol_managingaccess_resourcebased"></a>

Other services, such as Amazon S3, also support resource\-based permissions policies\. For example, you can attach a policy to an S3 bucket to manage access permissions to that bucket\. Cloud Directory doesn't support resource\-based policies\. 

## Specifying Policy Elements: Actions, Effects, Resources, and Principals<a name="iam_auth_access_specifyingiampolicyactions"></a>

For each Cloud Directory resource \(see [Cloud Directory Resources and Operations](#iam_auth_access_creatingiampolicies)\), the service defines a set of API operations\. For a list of available API operations, see either [Amazon Cloud Directory Actions](http://docs.aws.amazon.com/clouddirectory/latest/APIReference/API_Operations.html) or [Directory Service Actions](https://docs.aws.amazon.com/directoryservice/latest/devguide/API_Operations.html)\. To grant permissions for these API operations, Cloud Directory defines a set of actions that you can specify in a policy\. Note that, performing an API operation can require permissions for more than one action\. 

The following are the basic policy elements:
+ **Resource** – In a policy, you use an Amazon Resource Name \(ARN\) to identify the resource to which the policy applies\. For Cloud Directory resources, you always use the wildcard character \(\*\) in IAM policies\. For more information, see [Cloud Directory Resources and Operations](#iam_auth_access_creatingiampolicies)\. 
+ **Action** – You use action keywords to identify resource operations that you want to allow or deny\. For example, the `clouddirectory:GetDirectory` permission allows the user permissions to perform the Cloud Directory `GetDirectory` operation\. 
+ **Effect** – You specify the effect when the user requests the specific action—this can be either allow or deny\. If you don't explicitly grant access to \(allow\) a resource, access is implicitly denied\. You can also explicitly deny access to a resource, which you might do to make sure that a user cannot access it, even if a different policy grants access\.
+ **Principal** – In identity\-based policies \(IAM policies\), the user that the policy is attached to is the implicit principal\. For resource\-based policies, you specify the user, account, service, or other entity that you want to receive permissions \(applies to resource\-based policies only\)\. Cloud Directory doesn't support resource\-based policies\.

To learn more about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

For a table showing all of the Amazon Cloud Directory API actions and the resources that they apply to, see [Amazon Cloud Directory API Permissions: Actions, Resources, and Conditions Reference](iam_auth_access_usingwith_iam_resourcepermissions.md)\. 

## Specifying Conditions in a Policy<a name="iam_auth_access_specifyingiampolicyconditions"></a>

When you grant permissions, you can use the access policy language to specify the conditions when a policy should take effect\. For example, you might want a policy to be applied only after a specific date\. For more information about specifying conditions in a policy language, see [Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

To express conditions, you use predefined condition keys\. There are no condition keys specific to Cloud Directory\. However, there are AWS\-wide condition keys that you can use as appropriate\. For a complete list of AWS\-wide keys, see [Available Global Condition Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html#AvailableKeys) in the *IAM User Guide*\.  