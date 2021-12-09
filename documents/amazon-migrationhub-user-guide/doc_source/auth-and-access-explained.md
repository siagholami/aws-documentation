# AWS Migration Hub Authentication and Access Control Explained<a name="auth-and-access-explained"></a>

## Overview of Managing Access Permissions to Your AWS Migration Hub Resources<a name="access-control-overview"></a>

Every AWS resource is owned by an AWS account, and permissions to create or access a resource are governed by permissions policies\. An account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\), as well as attaching permissions policies to resources\.

**Note**  
An *account administrator* \(or administrator user\) is a user with administrator privileges\. For more information, see [IAM Best Practices](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html) in the *IAM User Guide*\.

When granting permissions, you decide who is getting the permissions, the resources they get permissions for, and the specific actions that you want to allow on those resources\.

**Topics**
+ [AWS Migration Hub Resources and Operations](#access-control-resources)
+ [Understanding Resource Ownership](#access-control-resource-ownership)
+ [Managing Access to Resources](#access-control-manage-access-intro)
+ [Specifying Policy Elements: Actions, Effects, and Principals](#specify-policy-elements)
+ [Specifying Conditions in a Policy](#specifying-conditions)

### AWS Migration Hub Resources and Operations<a name="access-control-resources"></a>

 In AWS Migration Hub, the primary resource is a Migration Hub *ProgressUpdateStream*\.  This resource has an unique Amazon Resource Name \(ARN\) associated with it as shown in the following table\. 


****  

| Resource Type | ARN Format  | 
| --- | --- | 
| ProgressUpdateStream |  arn:aws:mgh:*region*:*account\-id*:ProgressUpdateStreamName:*resource\-name*  | 

AWS Migration Hub provides a set of operations to work with the Migration Hub resources\. For a list of available operations, see [Actions](API_Operations.md)\.

### Understanding Resource Ownership<a name="access-control-resource-ownership"></a>

A *resource owner* is the AWS account that created the resource\. That is, the resource owner is the AWS account of the *principal entity* \(the root account, an IAM user, or an IAM role\) that authenticates the request that creates the resource\. The following examples illustrate how this works:
+ If you use the root account credentials of your AWS account to create a Migration Hub ProgressUpdateStream, your AWS account is the owner of the resource \(in Migration Hub, the resource is a ProgressUpdateStream\)\.
+ If you create an IAM user in your AWS account and grant permissions to create a Migration Hub ProgressUpdateStream to that user, the user can create a ProgressUpdateStream\. However, your AWS account, to which the user belongs, owns the ProgressUpdateStream resource\.
+ If you create an IAM role in your AWS account with permissions to create a Migration Hub ProgressUpdateStream, anyone who can assume the role can create a ProgressUpdateStream\. Your AWS account, to which the role belongs, owns the ProgressUpdateStream resource\. 

### Managing Access to Resources<a name="access-control-manage-access-intro"></a>

A *permissions policy* describes who has access to what\. The following section explains the available options for creating permissions policies\.

**Note**  
This section discusses using IAM in the context of AWS Migration Hub\. It doesn't provide detailed information about the IAM service\. For complete IAM documentation, see [What Is IAM?](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html) in the *IAM User Guide*\. For information about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

Policies attached to an IAM identity are referred to as *identity\-based* policies \(IAM polices\) and policies attached to a resource are referred to as *resource\-based* policies\. AWS Migration Hub *does not support resource\-based policies*, see [Resource\-Based Policies](#access-control-manage-access-resource-based)\. 

**Topics**
+ [Identity\-Based Policies \(IAM Policies\)](#access-control-manage-access-identity-based)
+ [Resource\-Based Policies](#access-control-manage-access-resource-based)

#### Identity\-Based Policies \(IAM Policies\)<a name="access-control-manage-access-identity-based"></a>

You can attach policies to IAM identities\. For example, you can do the following: 
+ **Attach a permissions policy to a user or a group in your account** – An account administrator can use a permissions policy that is associated with a particular user to grant permissions for that user to create a Migration Hub resource\. 
+ **Attach a permissions policy to a role \(grant cross\-account permissions\)** – You can attach an identity\-based permissions policy to an IAM role to grant cross\-account permissions\. For example, the administrator in Account A can create a role to grant cross\-account permissions to another AWS account \(for example, Account B\) or an AWS service as follows:

  1. Account A administrator creates an IAM role and attaches a permissions policy to the role that grants permissions on resources in Account A\.

  1. Account A administrator attaches a trust policy to the role identifying Account B as the principal who can assume the role\. 

  1. Account B administrator can then delegate permissions to assume the role to any users in Account B\. Doing this allows users in Account B to create or access resources in Account A\. The principal in the trust policy can also be an AWS service principal if you want to grant an AWS service permissions to assume the role\.

   For more information about using IAM to delegate permissions, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\. 

The following is an example policy that grants permissions for the Migration Hub action `mgh:NotifyMigrationTaskState` on all resources\. 

```
{
  "Version": "2017-03-31",
  "Statement": {
    "Effect": "Allow",
    "Action":[
      "mgh:NotifyMigrationTaskState"
    ],
    "Resource": "*"
      
  }
}
```

For more information about using identity\-based policies with Migration Hub, see [Using Identity\-Based Policies \(IAM Policies\) for AWS Migration Hub](#access-control-identity-based)\. For more information about users, groups, roles, and permissions, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the *IAM User Guide*\. 

#### Resource\-Based Policies<a name="access-control-manage-access-resource-based"></a>

Other services, such as Amazon S3, also support resource\-based permissions policies\. For example, you can attach a policy to an S3 bucket to manage access permissions to that bucket\. Migration Hub does not support resource\-based policies\. However, keep in mind that you will still see references made to resources\. This is because there is a difference between *resource\-based* permissions and *resource\-level* permissions\. 

Resource\-based permissions are permissions that attach directly to a resource, whereas a resource\-level permission simply specifies, within an identity\-based permission, on which resource a user or a role can perform actions on\. Therefore, when references to resources are made discussing Migration Hub permissions, it is within this context of *resource\-level* permissions\.

### Specifying Policy Elements: Actions, Effects, and Principals<a name="specify-policy-elements"></a>

For each Migration Hub resource, the service defines a set of API operations\. To grant permissions for these API operations, Migration Hub defines a set of actions that you can specify in a policy\. Some API operations can require permissions for more than one action in order to perform the API operation\. For more information about resources and API operations, see [AWS Migration Hub Resources and Operations](#access-control-resources) and Migration Hub [Actions](API_Operations.md)\.

The following are the most basic policy elements:
+ **Resource** – You use an Amazon Resource Name \(ARN\) to identify the resource that the policy applies to\. For more information, see [AWS Migration Hub Resources and Operations](#access-control-resources)\.
+ **Action** – You use action keywords to identify resource operations that you want to allow or deny\. For example, you can use `mgh:AssociateDiscoveredResource` to allow the user permission to perform the Migration Hub `AssociateDiscoveredResource` operation\.
+ **Effect** – You specify the effect, either allow or deny, when the user requests the specific action\. If you don't explicitly grant access to \(allow\) a resource, access is implicitly denied\. You can also explicitly deny access to a resource, which you might do to make sure that a user cannot access it, even if a different policy grants access\.
+ **Principal** – In identity\-based policies \(IAM policies\), the user that the policy is attached to is the implicit principal\. For resource\-based policies, you specify the user, account, service, or other entity that you want to receive permissions \(applies to resource\-based policies only\)\. Migration Hub doesn't support resource\-based policies\.

To learn more about IAM policy syntax and descriptions, see [AWS IAM Policy Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies.html) in the *IAM User Guide*\.

For a table showing all of the AWS Migration Hub API actions and the resources that they apply to, see [AWS Migration Hub API Permissions: Actions and Resources Reference](migrationhub-api-permissions-ref.md)\.

### Specifying Conditions in a Policy<a name="specifying-conditions"></a>

When you grant permissions, you can use the IAM policy language to specify the conditions when a policy should take effect\. For example, you might want a policy to be applied only after a specific date\. For more information about specifying conditions in a policy language, see [Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#Condition) in the *IAM User Guide*\.

To express conditions, you use predefined condition keys\. There are no condition keys specific to Migration Hub\. However, there are AWS\-wide condition keys that you can use as appropriate\. For a complete list of AWS\-wide keys, see [Available Keys for Conditions](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\.

## Using Identity\-Based Policies \(IAM Policies\) for AWS Migration Hub<a name="access-control-identity-based"></a>

This topic provides explanations of identity\-based policies in which an account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\)\. 

**Important**  
 We recommend that you first review the introductory topics that explain the basic concepts and options available for you to manage access to your AWS Migration Hub resources\. For more information, see [Overview of Managing Access Permissions to Your AWS Migration Hub Resources](#access-control-overview)\.

The sections in this topic cover the following:
+ [Permissions Required to Use the AWS Migration Hub Console and API](#console-required-permissions) 
+ [AWS Managed \(Predefined\) Policies for AWS Migration Hub](#access-policy-examples-aws-managed) 
+ [AWS Migration Hub Trust Policies ](#access-policy-examples-aws-trust) 

The following shows an example of a permissions policy:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "mgh:AssociateCreatedArtifact",
                "mgh:NotifyApplicationState",
                "mgh:ListDiscoveredResources"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:mgh:us-west-2:account_num:ProgressUpdateStreamName/DMS/*"
        }
    ]
}
```

Next, you must define a trust policy that authorizes the migration tool, in this example, AWS Database Migration Service \(DMS\), to assume the role:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "dms.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```

This policy is implemented in two parts, the permission policy and the trust policy: 
+ The permission policy grants permissions for the Migration Hub actions \(`mgh:AssociateCreatedArtifact`, `mgh:NotifyApplicationState`, and `mgh:ListDiscoveredResources`\) on any resources identified by the Amazon Resource Name \(ARN\) for the AWS DMS migration tool\. The wildcard character \(\*\) specified at the end of the resource name means that the migration tool can act on any migration tasks the tool creates under the particular ProgressUpdateStream name\.
+ The trust policy authorizes the AWS DMS migration tool to assume the role's permission policy\. Migration Hub policies always require a trust policy to be associated with them\.

For a table showing all of the AWS Migration Hub API actions and the resources and conditions that they apply to, see [AWS Migration Hub API Permissions: Actions and Resources Reference](migrationhub-api-permissions-ref.md)\.

### Permissions Required to Use the AWS Migration Hub Console and API<a name="console-required-permissions"></a>

The AWS Migration Hub console provides an integrated environment for users and APIs to create Migration Hub resources and to manage migrations\. The console provides many features and workflows that require specific permissions in order to access\. The best way to implement these permissions is through managed policies\. See [Console & API Managed Access](new-customer-setup.md#api-console-access-managed)\.

In addition, there are API\-specific permissions documented in [AWS Migration Hub API Permissions: Actions and Resources Reference](migrationhub-api-permissions-ref.md)\.

#### AWS Managed \(Predefined\) Policies for AWS Migration Hub<a name="access-policy-examples-aws-managed"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. These AWS managed policies grant necessary permissions for common use cases so that you can avoid having to investigate what permissions are needed\. 

The following AWS managed policies, which you can attach to users in your account, are specific to Migration Hub and are grouped by use case scenario:
+ **AWSMigrationHubDiscoveryAccess** – Grants permission to allow the Migration Hub service to call Application Discovery Service\.
+ **AWSMigrationHubFullAccess** – Grants access to the Migration Hub console and API/CLI for a user who's not an administrator\.
+ **AWSMigrationHubSMSAccess** – Grants permission for Migration Hub to receive notifications from the AWS Server Migration Service migration tool\.
+ **AWSMigrationHubDMSAccess** – Grants permission for Migration Hub to receive notifications from the AWS Database Migration Service migration tool\.

**Note**  
You can review these permissions policies by signing in to the IAM console and searching for these specific policies there\.

You can also create your own custom IAM policies to allow permissions for Migration Hub actions and resources\. You can attach these custom policies to the IAM users or groups that require those permissions\. 

### AWS Migration Hub Trust Policies<a name="access-policy-examples-aws-trust"></a>

A trust policy simply authorizes the principal to assume, or use, the role's permission policy\. A principal can be an AWS account \(the "root" user\), an IAM user, or a role\. In Migration Hub, the trust policy must be manually added to the permission policy\.

Therefore, each IAM role requires two separate policies that must be created for it:
+ A permissions policy, which defines what actions and resources the principal is allowed to use\.
+ A trust policy, which specifies who is allowed to assume the role \(the trusted entity, or principal\)\.