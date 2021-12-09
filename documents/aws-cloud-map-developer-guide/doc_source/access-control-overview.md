# Overview of Managing Access Permissions to Your AWS Cloud Map Resources<a name="access-control-overview"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by permissions policies\.

**Note**  
An *account administrator* \(or administrator user\) is a user that has administrator privileges\. For more information about administrators, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When you grant permissions, you decide who gets the permissions, the resources they get permissions for, and the actions that they get permissions to perform\.

**Topics**
+ [ARNs for AWS Cloud Map Resources](#access-control-resources)
+ [Understanding Resource Ownership](#access-control-owner)
+ [Managing Access to Resources](#access-control-manage-access-intro)
+ [Specifying Policy Elements: Resources, Actions, Effects, and Principals](#access-control-specify-cloud-map-actions)
+ [Specifying Conditions in an IAM Policy](#specifying-conditions)

## ARNs for AWS Cloud Map Resources<a name="access-control-resources"></a>

You can grant or deny resource\-level permissions for namespaces and services for selected operations\. For more information, see [AWS Cloud Map API Permissions: Actions, Resources, and Conditions Reference](cloud-map-api-permissions-ref.md)\.

## Understanding Resource Ownership<a name="access-control-owner"></a>

An AWS account owns the resources that are created in the account, regardless of who created the resources\. Specifically, the resource owner is the AWS account of the principal entity \(that is, the root account, an IAM user, or an IAM role\) that authenticates the resource creation request\. 

The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create an HTTP namespace, your AWS account is the owner of the resource\.
+ If you create an IAM user in your AWS account and grant permissions to create an HTTP namespace to that user, the user can create an HTTP namespace\. However, your AWS account, to which the user belongs, owns the HTTP namespace resource\.
+ If you create an IAM role in your AWS account with permissions to create an HTTP namespace, anyone who can assume the role can create an HTTP namespace\. Your AWS account, to which the role belongs, owns the HTTP namespace resource\.

## Managing Access to Resources<a name="access-control-manage-access-intro"></a>

A *permissions policy* specifies who has access to what\. This section explains the options for creating permissions policies for AWS Cloud Map\. For general information about IAM policy syntax and descriptions, see the [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as *identity\-based* policies \(IAM policies\), and policies attached to a resource are referred to as *resource\-based* policies\. AWS Cloud Map supports only identity\-based policies \(IAM policies\)\.

**Topics**
+ [Identity\-Based Policies \(IAM Policies\)](#access-control-manage-access-intro-iam-policies)
+ [Resource\-Based Policies](#access-control-manage-access-intro-resource-policies)

### Identity\-Based Policies \(IAM Policies\)<a name="access-control-manage-access-intro-iam-policies"></a>

You can attach policies to IAM identities\. For example, you can do the following:
+ **Attach a permissions policy to a user or a group in your account** – An account administrator can use a permissions policy that is associated with a particular user to grant permissions for that user to create AWS Cloud Map resources\.
+ **Attach a permissions policy to a role \(grant cross\-account permissions\)** – You can grant permission to perform AWS Cloud Map actions to a user that was created by another AWS account\. To do so, you attach a permissions policy to an IAM role, and then you allow the user in the other account to assume the role\. The following example explains how this works for two AWS accounts, account A and account B:

  1. Account A administrator creates an IAM role and attaches to the role a permissions policy that grants permissions to create or access resources that are owned by account A\.

  1. Account A administrator attaches a trust policy to the role\. The trust policy identifies account B as the principal that can assume the role\.

  1. Account B administrator can then delegate permissions to assume the role to users or groups in Account B\. This allows users in account B to create or access resources in account A\.

  For more information about how to delegate permissions to users in another AWS account, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\.

The following example policy allows a user to perform the `CreatePublicDnsNamespace` action to create a public DNS namespace for any AWS account\. The Amazon Route 53 permissions are required because when you create a public DNS namespace, AWS Cloud Map also creates a Route 53 hosted zone:

```
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "servicediscovery:CreatePublicDnsNamespace",
            "route53:CreateHostedZone",
            "route53:GetHostedZone",
            "route53:ListHostedZonesByName"
         ],
         "Resource":"*"
      }
   ]
}
```

If you want the policy to instead apply to private DNS namespaces, you need to grant permissions to use the AWS Cloud Map `CreatePrivateDnsNamespace` action\. In addition, you grant permission to use the same Route 53 actions as in the previous example because AWS Cloud Map creates a Route 53 private hosted zone\. You also grant permission to use two Amazon EC2 actions, `DescribeVpcs` and `DescribeRegion`:

```
{
   "Version": "2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "servicediscovery:CreatePrivateDnsNamespace",
            "route53:CreateHostedZone",
            "route53:GetHostedZone",
            "route53:ListHostedZonesByName"
         ],
         "Resource":"*"
      },
      {
         "Effect": "Allow",
         "Action": [
            "ec2:DescribeVpcs",
            "ec2:DescribeRegion"
         ],
         "Resource":"*"
      },
   ]
}
```

For more information about attaching policies to identities for AWS Cloud Map, see [Using Identity\-Based Policies \(IAM Policies\) for AWS Cloud Map](access-control-managing-permissions.md)\. For more information about users, groups, roles, and permissions, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the *IAM User Guide*\.

### Resource\-Based Policies<a name="access-control-manage-access-intro-resource-policies"></a>

Other services, such as Amazon S3, also support attaching permissions policies to resources\. For example, you can attach a policy to an S3 bucket to manage access permissions to that bucket\. AWS Cloud Map doesn't support attaching policies to resources\. 

## Specifying Policy Elements: Resources, Actions, Effects, and Principals<a name="access-control-specify-cloud-map-actions"></a>

AWS Cloud Map includes API actions \(see the [AWS Cloud Map API Reference](https://docs.aws.amazon.com/cloud-map/latest/api/)\) that you can use on each AWS Cloud Map resource \(see [ARNs for AWS Cloud Map Resources](#access-control-resources)\)\. You can grant a user or a federated user permissions to perform any or all of these actions\. Note that some API actions, such as creating a public DNS namespace, require permissions to perform more than one action\.

The following are the basic policy elements:
+ **Resource** – You use an Amazon Resource Name \(ARN\) to identify the resource that the policy applies to\. For more information, see [ARNs for AWS Cloud Map Resources](#access-control-resources)\.
+ **Action** – You use action keywords to identify resource actions that you want to allow or deny\. For example, depending on the specified `Effect`, the `servicediscovery:CreateHttpNamespace` permission allows or denies a user the ability to perform the AWS Cloud Map `CreateHttpNamespace` action\.
+ **Effect** – You specify the effect, either allow or deny, when a user tries to perform the action on the specified resource\. If you don't explicitly grant access to an action, access is implicitly denied\. You can also explicitly deny access to a resource, which you might do to make sure that a user cannot access it, even if a different policy grants access\.
+ **Principal** – In identity\-based policies \(IAM policies\), the user that the policy is attached to is the implicit principal\. For resource\-based policies, you specify the user, account, service, or other entity that you want to receive permissions \(applies to resource\-based policies only\)\. AWS Cloud Map doesn't support resource\-based policies\.

For more information about IAM policy syntax and descriptions, see the [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

For a list of the AWS Cloud Map API actions and the resources that they apply to, see [AWS Cloud Map API Permissions: Actions, Resources, and Conditions Reference](cloud-map-api-permissions-ref.md)\.

## Specifying Conditions in an IAM Policy<a name="specifying-conditions"></a>

When you grant permissions, you can use the IAM policy language to specify when a policy should take effect\. For example, you might want a policy to be applied only after a specified date, or you might want a policy to apply only to a specified namespace\.

To express conditions, you use predefined condition keys\. AWS Cloud Map defines its own set of condition keys and also supports using some global condition keys\. For more information, see the following topics:
+ For information about AWS Cloud Map condition keys, see [AWS Cloud Map API Permissions: Actions, Resources, and Conditions Reference](cloud-map-api-permissions-ref.md)\.
+ For information about AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.
+ For information about specifying conditions in a policy language, [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.