# Identity and access management for AWS Global Accelerator<a name="auth-and-access-control"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps an administrator securely control access to AWS resources, including AWS Global Accelerator resources\. Administrators use IAM to control who is *authenticated* \(signed in\) and *authorized* \(has permissions\) to use Global Accelerator resources\. IAM is a feature included with your AWS account at no additional charge\.

**Important**  
If you're not familiar with IAM, review the introductory information on this page, and then see [Getting started with IAM](auth_access_overview.md#auth_access_getting-started)\. Optionally, you can learn more about authentication and access control by viewing [What is authentication?](auth_access_overview.md#auth_access_what-is-authentication), [What is access control?](auth_access_overview.md#auth_access_what-is-access-control), and [What are policies?](auth_access_overview.md#auth_access_what-are-policies)\.

**Topics**
+ [Concepts and terms](#auth_access_introduction)
+ [Permissions required for console access, authentication management, and access control](#auth_access_required-permissions)
+ [Understanding how Global Accelerator works with IAM](#auth_access_service-with-iam)
+ [Troubleshooting authentication and access control](#auth_access_troubleshoot)

## Concepts and terms<a name="auth_access_introduction"></a>

**Authentication** – To sign in to AWS, you must use one of the following: root user credentials \(not recommended\), IAM user credentials, or temporary credentials using IAM roles\. To learn more about these entities, see [What is authentication?](auth_access_overview.md#auth_access_what-is-authentication)\.

**Access control** – AWS administrators use policies to control access to AWS resources, such as accelerators in Global Accelerator\. To learn more, see [What is access control?](auth_access_overview.md#auth_access_what-is-access-control) and [What are policies?](auth_access_overview.md#auth_access_what-are-policies)\.

**Important**  
All resources in an account are owned by the account, regardless of who created those resources\. You must be granted access to create a resource\. However, just because you created a resource doesn't mean that you automatically have full access to that resource\. An administrator must explicitly grant permissions for each action that you want to perform\. That administrator can also revoke your permissions at any time\.

To help you understand the basics of how IAM works, review the following terms:

**Resources**  
AWS services, such as Global Accelerator and IAM, typically include objects called resources\. In most cases, you can create, manage, and delete these resources from the service\. IAM resources include users, groups, roles, and policies:    
**Users**  
An IAM user represents the person or application who uses its credentials to interact with AWS\. A user consists of a name, a password to sign in to the AWS Management Console, and up to two access keys that can be used with the AWS CLI or AWS API\.  
**Groups**  
An IAM group is a collection of IAM users\. Administrators can use groups to specify permissions for member users\. This makes it easier for an administrator to manage permissions for multiple users\.  
**Roles**  
An IAM role does not have any long\-term credentials \(password or access keys\) associated with it\. A role can be assumed by anyone who needs it and has permissions\. An IAM user can assume a role to temporarily take on different permissions for a specific task\. Federated users can assume a role by using an external identity provider that is mapped to the role\. Some AWS services can assume a *service role* to access AWS resources on your behalf\.  
**Policies**  
Policies are JSON documents that define the permissions for the object to which they are attached\. AWS supports *identity\-based policies* that you attach to identities \(users, groups, or roles\)\. Some AWS services allow you to attach *resource\-based policies* to resources to control what a principal \(person or application\) can do to that resource\. Global Accelerator does not support resource\-based policies\.

**Identities**  
Identities are IAM resources for which you can define permissions\. These include users, groups, and roles\.

**Entities**  
Entities are IAM resources that you use for authentication\. These include users and roles\. 

**Principals**  
In AWS, a principal is a person or application that uses an entity to sign in and make requests to AWS\. As a principal, you can use the AWS Management Console, the AWS CLI, or the AWS API to perform an operation \(such as deleting an accelerator\)\. This creates a *request* for that operation\. Your request specifies the *action*, *resource*, *principal*, *principal account*, and any additional information about your request\. All of this information provides AWS with *context* for your request\. AWS checks all the policies that apply to the context of your request\. AWS authorizes the request only if each part of your request is allowed by the policies\. 

To view a diagram of the authentication and access control process, see [Understanding How IAM Works](https://docs.aws.amazon.com/IAM/latest/UserGuide/intro-structure.html) in the *IAM User Guide*\. For details about how AWS determines whether a request is allowed, see [Policy Evaluation Logic](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_evaluation-logic.html) in the *IAM User Guide*\.

## Permissions required for console access, authentication management, and access control<a name="auth_access_required-permissions"></a>

To use Global Accelerator or to manage authorization and access control for yourself or others, you must have the correct permissions\. 

### Permissions required to create a Global Accelerator accelerator<a name="auth_access_required-permissions-create-accelerator"></a>

To create a AWS Global Accelerator accelerator, users must have permission to create service\-linked roles that are associated with Global Accelerator\. 

To ensure that users have the correct permissions to create accelerators in Global Accelerator, attach a policy to the user such as the following\.

**Note**  
If you create an identity\-based permissions policy that is more restrictive, users with that policy won't be able to create an accelerator\.

```
{
      "Effect": "Allow",
      "Action": "iam:CreateServiceLinkedRole",
      "Resource": "*",
      "Condition": {
        "StringEquals": {
          "iam:AWSServiceName": "globalaccelerator.amazonaws.com"
        }
      }
    },
    {
      "Effect": "Allow",
      "Action": [
        "iam:DeleteServiceLinkedRole",
        "iam:GetServiceLinkedRoleDeletionStatus"
      ],
      "Resource": "arn:aws:iam::*:role/aws-service-role/globalaccelerator.amazonaws.com/AWSServiceRoleForGlobalAccelerator*"
    }
```

### Permissions required to use the Global Accelerator console<a name="auth_access_required-permissions-console"></a>

To access the AWS Global Accelerator console, you must have a minimum set of permissions that allows you to list and view details about the Global Accelerator resources in your AWS account\. If you create an identity\-based permissions policy that is more restrictive than the minimum required permissions, the console won't function as intended for entities with that policy\.

To ensure that those entities can still use the Global Accelerator console or API actions, also attach one of the following AWS managed policies to the user, as described in [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor):

```
        GlobalAcceleratorReadOnlyAccess
        GlobalAcceleratorFullAccess
```

Attach the first policy, `GlobalAcceleratorReadOnlyAccess`, if users only need to view information in the console or make calls to the AWS CLI or the API that use `List*` or `Describe*` operations\.

Attach the second policy, `GlobalAcceleratorFullAccess`, to users who need to create or make updates to accelerators\. The full access policy includes *full* permissions for Global Accelerator as well as *describe* permissions for Amazon EC2 and Elastic Load Balancing\.

**Note**  
If you create an identity\-based permissions policy that does not include the required permissions for Amazon EC2 and Elastic Load Balancing, users with that policy will not be able to add Amazon EC2 and Elastic Load Balancing resources to accelerators\.

The following is the full access policy:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "globalaccelerator:*"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "ec2:CreateNetworkInterface",
                "ec2:DescribeNetworkInterfaces",
                "ec2:DescribeInstances",
                "ec2:DescribeInternetGateways",
                "ec2:DescribeSubnets",
                "ec2:ModifyNetworkInterfaceAttribute",
                "ec2:DeleteNetworkInterface"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "ec2:DeleteSecurityGroup",
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "ec2:ResourceTag/AWSServiceName": "GlobalAccelerator"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "ec2:CreateSecurityGroup",
                "ec2:DescribeSecurityGroups"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "elasticloadbalancing:DescribeLoadBalancers",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "ec2:CreateTags",
            "Resource": [
                "arn:aws:ec2:*:*:security-group/*",
                "arn:aws:ec2:*:*:network-interface/*"
            ]
        }
    ]
}
```

### Permissions required for authentication management<a name="auth_access_required-permissions-iam-auth"></a>

To manage your own credentials, such as your password, access keys, and multi\-factor authentication \(MFA\) devices, your administrator must grant you the required permissions\. To view the policy that includes these permissions, see [Allow users to self\-manage their credentials](auth_access_overview.md#auth_access_manage-password-mfa)\.

As an AWS administrator, you need full access to IAM so that you can create and manage users, groups, roles, and policies in IAM\. You should use the [AdministratorAccess](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/AdministratorAccess) AWS managed policy that includes full access to all of AWS\. This policy doesn't provide access to the AWS Billing and Cost Management console or allow tasks that require AWS account root user credentials\. For more information, see [AWS Tasks That Require AWS Account Root User Credentials](https://docs.aws.amazon.com/general/latest/gr/aws_tasks-that-require-root.html) in the *AWS General Reference*\.

**Warning**  
Only an administrator user should have full access to AWS\. Anyone with this policy has permission to fully manage authentication and access control, in addition to modifying every resource in AWS\. To learn how to create this user, see [Create your IAM admin user](auth_access_overview.md#auth_access_setup-iam-admin)\.

### Permissions required for access control<a name="auth_access_required-permissions-iam-authz"></a>

If your administrator provided you with IAM user credentials, they attached policies to your IAM user to control what resources you can access\. To view the policies that are attached to your user identity in the AWS Management Console, you must have the following permissions:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ViewOwnUserInfo",
            "Effect": "Allow",
            "Action": [
                "iam:GetUserPolicy",
                "iam:ListGroupsForUser",
                "iam:ListAttachedUserPolicies",
                "iam:ListUserPolicies",
                "iam:GetUser"
            ],
            "Resource": [
                "arn:aws:iam::*:user/${aws:username}"
            ]
        },
        {
            "Sid": "ListUsersViewGroupsAndPolicies",
            "Effect": "Allow",
            "Action": [
                "iam:GetGroupPolicy",
                "iam:GetPolicyVersion",
                "iam:GetPolicy",
                "iam:ListAttachedGroupPolicies",
                "iam:ListGroupPolicies",
                "iam:ListPolicyVersions",
                "iam:ListPolicies",
                "iam:ListUsers"
            ],
            "Resource": "*"
        }
    ]
}
```

If you need additional permissions, ask your administrator to update your policies to allow you to access the actions that you require\.

## Understanding how Global Accelerator works with IAM<a name="auth_access_service-with-iam"></a>

Services can work with IAM in several ways:

**Actions**  
Global Accelerator supports using actions in a policy\. This allows an administrator to control whether an entity can complete an operation in Global Accelerator\. For example, to allow an entity to call the `GetPolicy` AWS API operation to view a policy, an administrator must attach a policy that allows the `iam:GetPolicy` action\.   
The following example policy allows a user to perform the `CreateAccelerator` operation to programmatically create an accelerator for your AWS account:  

```
{
   "Version": "2018-08-08",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "globalaccelerator:CreateAccelerator"
         ],
         "Resource":"*"
      }
   ]
}
```

**Resource\-level permissions**  
Global Accelerator supports resource\-level permissions\.  Resource\-level permissions allow you to use [ARNs](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) to specify individual resources in the policy\.  

**Resource\-based policies**  
Global Accelerator does not support resource\-based policies\. With resource\-based policies, you can attach a policy to a resource within the service\. Resource\-based policies include a `Principal` element to specify which IAM identities can access that resource\. 

**Authorization based on tags**  
Global Accelerator supports authorization\-based tags\. This feature allows you to use [resource tags](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/tag-editor.html) in the condition of a policy\. 

**Temporary credentials**  
Global Accelerator supports temporary credentials\. With temporary credentials, you can sign in with federation, assume an IAM role, or assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

**Service\-linked roles**  
Global Accelerator supports service\-linked roles\. This feature allows a service to assume a [service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account, and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

**Service roles**  
Global Accelerator does not support service roles\. This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, this might break the functionality of the service\.

## Troubleshooting authentication and access control<a name="auth_access_troubleshoot"></a>

Use the following information to help you diagnose and fix common issues that you might encounter when working with IAM\.

**Topics**
+ [I am not authorized to perform an action in Global Accelerator](#auth_access_troubleshoot-no-permissions)
+ [I'm an administrator and want to allow others to access Global Accelerator](#auth_access_troubleshoot-admin-allow-access)
+ [I want to understand IAM without becoming an expert](#auth_access_troubleshoot-iam-expert)

### I am not authorized to perform an action in Global Accelerator<a name="auth_access_troubleshoot-no-permissions"></a>

If the AWS Management Console tells you that you're not authorized to perform an action, you must contact the administrator who provided you with your user name and password\. 

The following example occurs when an IAM user named `my-user-name` tries to use the console to perform the `globalaccelerator:CreateAccelerator` action but does not have permissions:

```
User: arn:aws:iam::123456789012:user/my-user-name is not authorized to perform: aws-globalaccelerator:CreateAccelerator on resource: my-example-accelerator
```

In this case, ask your administrator to update your policies to allow you to access the `my-example-accelerator` resource using the `aws-globalaccelerator:CreateAccelerator` action\.

### I'm an administrator and want to allow others to access Global Accelerator<a name="auth_access_troubleshoot-admin-allow-access"></a>

To allow others to access Global Accelerator, you must create an IAM entity \(user or role\) for the person or application that needs access\. They will use the credentials for that entity to access AWS\. You must then attach a policy to the entity that grants them the correct permissions in Global Accelerator\. 

To get started right away, see [Getting started with IAM](auth_access_overview.md#auth_access_getting-started)\.

### I want to understand IAM without becoming an expert<a name="auth_access_troubleshoot-iam-expert"></a>

To learn more about IAM terms, concepts, and procedures, see the following topics:
+ [What is authentication?](auth_access_overview.md#auth_access_what-is-authentication)
+ [What is access control?](auth_access_overview.md#auth_access_what-is-access-control)
+ [What are policies?](auth_access_overview.md#auth_access_what-are-policies)

## Tag\-based policies<a name="access-control-manage-access-tag-policies"></a>

When you design IAM policies, you might set granular permissions by granting access to specific resources\. As the number of resources that you manage grows, this task becomes more difficult\. Tagging accelerators and using tags in policy statement conditions can make this task easier\. You grant access in bulk to any accelerator with a certain tag\. Then you repeatedly apply this tag to relevant accelerators, when you create the accelerator or by updating the accelerator later\.

**Note**  
Using tags in conditions is one way to control access to resources and requests\. For information about tagging in Global Accelerator, see [Tagging in AWS Global Accelerator](tagging-in-global-accelerator.md)\.

Tags can be attached to a resource or passed in the request to services that support tagging\. In Global Accelerator, only accelerators can include tags\. When you create an IAM policy, you can use tag condition keys to control:
+ Which users can perform actions on an accelerator, based on tags that it already has\.
+ What tags can be passed in an action's request\.
+ Whether specific tag keys can be used in a request\.

For the complete syntax and semantics of tag condition keys, see [ Control access using IAM tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_iam-tags.html) in the *IAM User Guide*\.

For example, the Global Accelerator `GlobalAcceleratorFullAccess` managed user policy gives users unlimited permission to perform any Global Accelerator action on any resource\. The following policy limits this power and denies unauthorized users permission to perform any Global Accelerator action on any *production* accelerators\. A customer's administrator must attach this IAM policy to unauthorized IAM users, in addition to the managed user policy\.

```
{ 
   "Version":"2012-10-17",
   "Statement":[ 
      { 
         "Effect":"Deny",
         "Action":"*",
         "Resource":"*",
         "Condition":{ 
            "ForAnyValue:StringEquals":{ 
               "aws:RequestTag/stage":"prod"
            }
         }
      },
      { 
         "Effect":"Deny",
         "Action":"*",
         "Resource":"*",
         "Condition":{ 
            "ForAnyValue:StringEquals":{ 
               "aws:ResourceTag/stage":"prod"
            }
         }
      }
   ]
}
```