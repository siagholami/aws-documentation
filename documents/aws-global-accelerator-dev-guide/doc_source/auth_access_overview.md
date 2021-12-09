# Overview of access and authentication<a name="auth_access_overview"></a>

If you're new to IAM, read the following topics to get started with authorization and access in AWS\. 

**Topics**
+ [What is authentication?](#auth_access_what-is-authentication)
+ [What is access control?](#auth_access_what-is-access-control)
+ [What are policies?](#auth_access_what-are-policies)
+ [Getting started with IAM](#auth_access_getting-started)

## What is authentication?<a name="auth_access_what-is-authentication"></a>

Authentication is how you sign in to AWS using your credentials\.

**Note**  
To get started quickly, you can ignore this section\. First, review the introductory information on [Identity and access management for AWS Global Accelerator](auth-and-access-control.md), and then see [Getting started with IAM](#auth_access_getting-started)\.

As a principal, you must be *authenticated* \(signed in to AWS\) using an entity \(root user, IAM user, or IAM role\) to send a request to AWS\. An IAM user can have long\-term credentials such as a user name and password or a set of access keys\. When you assume an IAM role, you are given temporary security credentials\. 

To get authenticated from the AWS Management Console as a user, you must sign in with your user name and password\. To get authenticated from the AWS CLI or AWS API, you must provide your access key and secret key or temporary credentials\. AWS provides SDK and CLI tools to cryptographically sign your request using your credentials\. If you don’t use AWS tools, you must sign the request yourself\. Regardless of the authentication method that you use, you might also be required to provide additional security information\. For example, AWS recommends that you use multi\-factor authentication \(MFA\) to increase the security of your account\.

As a principal, you can sign in to AWS using the following entities \(users or roles\):

**AWS account root user**  
  When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. 

**IAM user**  
An [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html) is an entity within your AWS account that has specific permissions\. Global Accelerator supports *Signature Version 4*, a protocol for authenticating inbound API requests\. For more information about authenticating requests, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *AWS General Reference*\.

**IAM role**  
  An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an IAM identity that you can create in your account that has specific permissions\. An IAM role is similar to an IAM user in that it is an AWS identity with permissions policies that determine what the identity can and cannot do in AWS\. However, instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it\. Also, a role does not have standard long\-term credentials such as a password or access keys associated with it\. Instead, when you assume a role, it provides you with temporary security credentials for your role session\. IAM roles with temporary credentials are useful in the following situations:    
**Federated user access**  
  Instead of creating an IAM user, you can use existing identities from AWS Directory Service, your enterprise user directory, or a web identity provider\. These are known as *federated users*\. AWS assigns a role to a federated user when access is requested through an [identity provider](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html)\. For more information about federated users, see [Federated Users and Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html#intro-access-roles) in the *IAM User Guide*\.   
**Temporary user permissions**  
An IAM user can assume a role temporarily to take on different permissions for a specific task\.   
**Cross\-account access**  
You can use an IAM role to allow a trusted principal in a different account to access resources in your account\. Roles are the primary way to grant cross\-account access\. However, with some AWS services, you can attach a policy directly to a resource \(instead of using a role as a proxy\)\. Global Accelerator does not support these resource\-based policies\. For more information about choosing whether to use a role or a resource\-based policy to allow cross\-account access, see [Controlling access to pPrincipals in a different account](#auth_access_controlling-principal-accounts)\.  
**AWS service access**  
  A service role is an IAM role that a service assumes to perform actions in your account on your behalf\. When you set up some AWS service environments, you must define a role for the service to assume\. This service role must include all the permissions that are required for the service to access the AWS resources that it needs\. Service roles vary from service to service, but many allow you to choose your permissions as long as you meet the documented requirements for that service\. Service roles provide access only within your account and cannot be used to grant access to services in other accounts\. You can create, modify, and delete a service role from within IAM\. For example, you can create a role that allows Amazon Redshift to access an Amazon S3 bucket on your behalf and then load data from that bucket into an Amazon Redshift cluster\. For more information, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html) in the *IAM User Guide*\.   
**Applications running on Amazon EC2**  
  You can use an IAM role to manage temporary credentials for applications that are running on an EC2 instance and making AWS CLI or AWS API requests\. This is preferable to storing access keys within the EC2 instance\. To assign an AWS role to an EC2 instance and make it available to all of its applications, you create an instance profile that is attached to the instance\. An instance profile contains the role and enables programs that are running on the EC2 instance to get temporary credentials\. For more information, see [Using an IAM Role to Grant Permissions to Applications Running on Amazon EC2 Instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html) in the *IAM User Guide*\. 

## What is access control?<a name="auth_access_what-is-access-control"></a>

After you sign in \(are authenticated\) to AWS, your access to AWS resources and operations is governed by policies\. Access control is also known as authorization\.

**Note**  
To get started quickly, you can ignore this page\. First, review the introductory information on [Identity and access management for AWS Global Accelerator](auth-and-access-control.md), and then see [Getting started with IAM](#auth_access_getting-started)\.

During authorization, AWS uses values from the [ request context](https://docs.aws.amazon.com/IAM/latest/UserGuide/intro-structure-request.html) to check for policies that apply\. It then uses the policies to determine whether to allow or deny the request\. Most policies are stored in AWS as JSON documents and specify the permissions that are allowed or denied for principals\. For more information about the structure and contents of JSON policy documents, see [What are policies?](#auth_access_what-are-policies)\.

Policies let an administrator specify who has access to AWS resources and what actions they can perform on those resources\. Every IAM entity \(user or role\) starts with no permissions\. In other words, by default, users can do nothing, not even view their own access keys\. To give a user permission to do something, an administrator must attach a permissions policy to a user\. Or they can add the user to a group that has the intended permissions\. When an administrator then gives permissions to a group, all users in that group get those permissions\.

You might have valid credentials to authenticate your requests, but unless an administrator grants you permissions you cannot create or access AWS Global Accelerator resources\. For example, you must have explicit permissions to create an AWS Global Accelerator accelerator\.

As an administrator, you can write a policy to control access to the following:
+ **[ Principals](#auth_access_controlling-principals)** – Control what the person or application making the request \(the *principal*\) is allowed to do\. 
+ **[IAM identities](#auth_access_controlling-identities)** – Control which IAM identities \(groups, users, and roles\) can be accessed and how\.
+ **[IAM policies](#auth_access_controlling-policies)** – Control who can create, edit, and delete customer managed policies, and who can attach and detach all managed policies\.
+ **[AWS resources](#auth_access_controlling-resources)** – Control who has access to resources using an identity\-based policy or a resource\-based policy\.
+ **[AWS accounts](#auth_access_controlling-principal-accounts)** – Control whether a request is allowed only for members of a specific account\.

### Controlling access for principals<a name="auth_access_controlling-principals"></a>

Permissions policies control what you, as a principal, are allowed to do\. An administrator must attach an identity\-based permissions policy to the identity \(user, group, or role\) that provides your permissions\. Permissions policies allow or deny access to AWS\. Administrators can also set a permissions boundary for an IAM entity \(user or role\) to define the maximum permissions that the entity can have\. Permissions boundaries are an advanced IAM feature\. For more information about permissions boundaries, see [Permissions boundaries for IAM identities](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_boundaries.html) in the *IAM User Guide*\.

For more information and an example of how to control AWS access for principals, see [Controlling access for principals](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html#access_controlling-principals) in the *IAM User Guide*\.

### Controlling access to identities<a name="auth_access_controlling-identities"></a>

Administrators control what you can do to an IAM identity \(user, group, or role\) by creating a policy that limits what can be done to an identity or who can access it\. Then they attach that policy to the identity that provides your permissions\. 

For example, an administrator might allow you to reset the password for three specific users\. To do this, they attach a policy to your IAM user that allows you to reset the password for only yourself and users with the ARN of the three specified users\. This allows you to reset the password of your team members but not other IAM users\.

For more information and an example of using a policy to control AWS access to identities, see [Controlling access to identities](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html#access_controlling-identities) in the *IAM User Guide*\.

### Controlling access to policies<a name="auth_access_controlling-policies"></a>

Administrators can control who can create, edit, and delete customer managed policies, and who can attach and detach all managed policies\. When you review a policy, you can view the policy summary that includes a summary of the access level for each service within that policy\. AWS categorizes each service action into one of four *access levels* based on what each action does: `List`, `Read`, `Write`, or `Permissions management`\. You can use these access levels to determine which actions to include in your policies\. For more information, see [Understanding access level summaries within policy summaries](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_understand-policy-summary-access-level-summaries.html) in the *IAM User Guide*\.

**Warning**  
You should limit `Permissions Management` access\-level permissions in your account\. Otherwise, your account members can create policies for themselves with more permissions than they should have\. Or they can create separate users with full access to AWS\. 

For more information and an example for how to control AWS access to policies, see [Controlling access to policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html#access_controlling-policies) in the *IAM User Guide*\.

### Controlling access to resources<a name="auth_access_controlling-resources"></a>

Administrators can control access to resources using an identity\-based policy or a resource\-based policy\. In an identity\-based policy, you attach the policy to an identity and specify what resources that identity can access\. In a resource\-based policy, you attach a policy to the resource that you want to control\. In the policy, you specify which principals can access that resource\. 

For more information, see [Controlling Access to Resources](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html#access_controlling-resources) in the *IAM User Guide*\.

#### Resource creators do not automatically have permissions<a name="NoDefaultPermissions"></a>

All resources in an account are owned by the account, regardless of who created those resources\. The AWS account root user is the account owner, and therefore has permission to perform any action on any resource in the account\.

**Important**  
We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, follow the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. To view the tasks that require you to sign in as the root user, see [AWS Tasks That Require Root User](https://docs.aws.amazon.com/general/latest/gr/aws_tasks-that-require-root.html)\.

Entities \(users or roles\) in the AWS account must be granted access to create a resource\. But just because they create a resource doesn't mean they automatically have full access to that resource\. Administrators must explicitly grant permissions for each action\. Additionally, administrators can revoke those permissions at any time, as long as they have access to manage user and role permissions\.

### Controlling access to pPrincipals in a different account<a name="auth_access_controlling-principal-accounts"></a>

Administrators can use AWS resource\-based policies, IAM cross\-account roles, or the AWS Organizations service to allow principals in another account to access resources in your account\.

For some AWS services, administrators can grant cross\-account access to your resources\. To do this, an administrator attaches a policy directly to the resource that they want to share, instead of using a role as a proxy\. If the service supports this policy type, then the resource that the administrator shares must also support resource\-based policies\. Unlike a user\-based policy, a resource\-based policy specifies who \(in the form of a list of AWS account ID numbers\) can access that resource\. Global Accelerator does not support resource\-based policies\.

Cross\-account access with a resource\-based policy has some advantages over a role\. With a resource that is accessed through a resource\-based policy, the principal \(person or application\) still works in the trusted account and does not have to give up their user permissions in place of the role permissions\. In other words, the principal has access to resources in the trusted account *and* in the trusting account at the same time\. This is useful for tasks such as copying information from one account to another\. For more information about using cross\-account roles, see [Providing Access to an IAM User in Another AWS Account That You Own](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_aws-accounts.html) in the *IAM User Guide*\.

AWS Organizations offers policy\-based management for multiple AWS accounts that you own\. With Organizations, you can create groups of accounts, automate account creation, and apply and manage policies for those groups\. Organizations enables you to centrally manage policies across multiple accounts, without requiring custom scripts and manual processes\. Using AWS Organizations, you can create Service Control Policies \(SCPs\) that centrally control AWS service use across AWS accounts\. For more information, see [What Is AWS Organizations?](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_introduction.html) in the *AWS Organizations User Guide*\.

## What are policies?<a name="auth_access_what-are-policies"></a>

You control access in AWS by creating policies and attaching them to IAM identities or AWS resources\.

**Note**  
To get started quickly, you can ignore this page\. First, review the introductory information on [Identity and access management for AWS Global Accelerator](auth-and-access-control.md), and then see [Getting started with IAM](#auth_access_getting-started)\.

A policy is an object in AWS that, when associated with an entity or resource, defines their permissions\. AWS evaluates these policies when a principal, such as a user, makes a request\. Permissions in the policies determine whether the request is allowed or denied\. Most policies are stored in AWS as JSON documents\.

IAM policies define permissions for an action regardless of the method that you use to perform the operation\. For example, if a policy allows the [GetUser](https://docs.aws.amazon.com/IAM/latest/APIReference/API_GetUser.html) action, then a user with that policy can get user information from the AWS Management Console, the AWS CLI, or the AWS API\. When you create an IAM user, you can set up the user to allow console or programmatic access\. The IAM user can sign in to the console using a user name and password\. Or they can use access keys to work with the CLI or API\.

The following policy types, listed in order of frequency, can affect whether a request is authorized\. For more details, see [Policy Types](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#access_policy-types) in the *IAM User Guide*\.

**Identity\-based policies**  
You can attach managed and inline policies to IAM identities \(users, groups to which users belong, and roles\)\.

**Resource\-based policies**  
You can attach inline policies to resources in some AWS services\. The most common examples of resource\-based policies are Amazon S3 bucket policies and IAM role trust policies\. Global Accelerator does not support resource\-based policies\. 

**Organizations SCPs**  
You can use an AWS Organizations service control policy \(SCP\) to apply a permissions boundary to an AWS Organizations organization or organizational unit \(OU\)\. Those permissions are applied to all entities within the member accounts\.

**Access control lists \(ACLs\)**  
You can use ACLs to control what principals can access a resource\. ACLs are similar to resource\-based policies, although they are the only policy type that does not use the JSON policy document structure\. Global Accelerator supports OR does not support ACLs\. 

These policies types can be categorized as *permissions policies* or *permissions boundaries*\.

**Permissions policies**  
You can attach permissions policies to a resource in AWS to define the permissions for that object\. Within a single account, AWS evaluates all permissions policies together\. Permissions policies are the most common policies\. You can use the following policy types as permissions policies:    
**Identity\-based policies**  
When you attach a managed or inline policy to an IAM user, group, or role, the policy defines the permissions for that entity\.  
**Resource\-based policies**  
When you attach a JSON policy document to a resource, you define the permissions for that resource\. The service must support resource\-based policies\.  
**Access control lists \(ACLs\)**  
When you attach an ACL to a resource, you define a list of principals with permission to access that resource\. The resource must support ACLs\.

**Permissions boundaries**  
You can use policies to define the permissions boundary for an entity \(user or role\)\. A permissions boundary controls the maximum permissions that an entity can have\. Permissions boundaries are an advanced AWS feature\. When more than one permissions boundary applies to a request, AWS evaluates each permissions boundary separately\. You can apply a permissions boundary in the following situations:    
**Organizations**  
You can use an AWS Organizations service control policy \(SCP\) to apply a permissions boundary to an AWS Organizations organization or organizational unit \(OU\)\.  
**IAM users or roles**  
You can use a managed policy for a user's or role's permissions boundary\. For more information, see [Permissions Boundaries for IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_boundaries.html) in the *IAM User Guide*\.

**Topics**
+ [Identity\-based policies](#auth_access_manage-access-intro-identity-policies)
+ [Resource\-based policies](#auth_access_manage-access-intro-resource-policies)
+ [Policy access level classifications](#auth_access_policies-access-level)

### Identity\-based policies<a name="auth_access_manage-access-intro-identity-policies"></a>

You can attach policies to IAM identities\. For example, you can do the following:

**Attach a permissions policy to a user or a group in your account**  
To grant a user permissions to create an AWS Global Accelerator resource, such as an accelerator, you can attach a permissions policy to a user or a group to which the user belongs\.

**Attach a permissions policy to a role \(grant cross\-account permissions\)**  
You can attach an identity\-based permissions policy to an IAM role to grant cross\-account permissions\. For example, the administrator in account A can create a role to grant cross\-account permissions to another AWS account \(for example, account B\) or an AWS service as follows:  

1. Account A administrator creates an IAM role and attaches a permissions policy to the role that grants permissions on resources in account A\.

1. Account A administrator attaches a trust policy to the role identifying account B as the principal who can assume the role\. 

1. Account B administrator can then delegate permissions to assume the role to any users in account B\. Doing this allows users in account B to create or access resources in account A\. The principal in the trust policy can also be an AWS service principal if you want to grant an AWS service permissions to assume the role\.
For more information about using IAM to delegate permissions, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) in the *IAM User Guide*\.

For more information about users, groups, roles, and permissions, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the *IAM User Guide*\. 

The following are two examples of policies that you could use with Global Accelerator The first example policy grants a user programmatic access to all List and Describe actions for accelerators in your AWS account:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "globalaccelerator:List*",
                "globalaccelerator:Describe*"
            ],
            "Resource": "*"
        }
    ]
}
```

The following example grants programmatic access to the `ListAccelerators` operation:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "globalaccelerator:ListAccelerators",
            ],
            "Resource": "*"
        }
    ]
}
```

### Resource\-based policies<a name="auth_access_manage-access-intro-resource-policies"></a>

Resource\-based policies are JSON policy documents that you attach to a resource\. These policies allow you to specify what actions a specified principal can perform on that resource and under what conditions\. The most common resource\-based policy is for an Amazon S3 bucket\. Resource\-based policies are inline policies that exist only on the resource\. There are no managed resource\-based policies\.

Granting permissions to members of other AWS accounts using a resource\-based policy has some advantages over an IAM role\. For more information, see [How IAM Roles Differ from Resource\-based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_compare-resource-policies.html) in the *IAM User Guide*\.

### Policy access level classifications<a name="auth_access_policies-access-level"></a>

In the IAM console, actions are grouped using the following access\-level classifications:

**List**  
Provides permission to list resources within the service to determine whether an object exists\. Actions with this level of access can list objects but cannot see the contents of a resource\. Most actions with the **List** access level cannot be performed on a specific resource\. When you create a policy statement with these actions, you must specify **All resources** \(`"*"`\)\. 

**Read**  
Provides permission to read but not edit the contents and attributes of resources in the service\. For example, the Amazon S3 operations `GetObject` and `GetBucketLocation` have the **Read** access level\.

**Write**  
Provides permission to create, delete, or modify resources in the service\. For example, the Amazon S3 operations `CreateBucket`, `DeleteBucket`, and `PutObject` have the **Write** access level\.

**Permissions management**  
Provides permission to grant or modify resource permissions in the service\. For example, most IAM and AWS Organizations policy actions have the **Permissions management** access level\.  
**Tip**  
To improve the security of your AWS account, restrict or regularly monitor policies that include the **Permissions management** access\-level classification\.

**Tagging**  
Provides permission to create, delete, or modify tags that are attached to a resource in the service\. For example, the Amazon EC2 `CreateTags` and `DeleteTags` operations have the **Tagging** access level\.

## Getting started with IAM<a name="auth_access_getting-started"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that allows you manage access to services and resources securely\. IAM is a feature of your AWS account offered at no additional charge\.

**Note**  
Before you start with IAM, review the introductory information on [Identity and access management for AWS Global Accelerator](auth-and-access-control.md)\.

  When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create your first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\. 

### Create your IAM admin user<a name="auth_access_setup-iam-admin"></a>

**To create an administrator user for yourself and add the user to an administrators group \(console\)**

1. Sign in to the [IAM console](https://console.aws.amazon.com/iam/) as the account owner by choosing **Root user** and entering your AWS account email address\. On the next page, enter your password\.
**Note**  
We strongly recommend that you adhere to the best practice of using the **Administrator** IAM user below and securely lock away the root user credentials\. Sign in as the root user only to perform a few [account and service management tasks](https://docs.aws.amazon.com/general/latest/gr/aws_tasks-that-require-root.html)\.

1. In the navigation pane, choose **Users** and then choose **Add user**\.

1. For **User name**, enter **Administrator**\.

1. Select the check box next to **AWS Management Console access**\. Then select **Custom password**, and then enter your new password in the text box\.

1. \(Optional\) By default, AWS requires the new user to create a new password when first signing in\. You can clear the check box next to **User must create a new password at next sign\-in** to allow the new user to reset their password after they sign in\.

1. Choose **Next: Permissions**\.

1. Under **Set permissions**, choose **Add user to group**\.

1. Choose **Create group**\.

1. In the **Create group** dialog box, for **Group name** enter **Administrators**\.

1. Choose **Filter policies**, and then select **AWS managed \-job function** to filter the table contents\.

1. In the policy list, select the check box for **AdministratorAccess**\. Then choose **Create group**\.
**Note**  
You must activate IAM user and role access to Billing before you can use the `AdministratorAccess` permissions to access the AWS Billing and Cost Management console\. To do this, follow the instructions in [step 1 of the tutorial about delegating access to the billing console](https://docs.aws.amazon.com/IAM/latest/UserGuide/tutorial_billing.html)\.

1. Back in the list of groups, select the check box for your new group\. Choose **Refresh** if necessary to see the group in the list\.

1. Choose **Next: Tags**\.

1. \(Optional\) Add metadata to the user by attaching tags as key\-value pairs\. For more information about using tags in IAM, see [Tagging IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_tags.html) in the *IAM User Guide*\.

1. Choose **Next: Review** to see the list of group memberships to be added to the new user\. When you are ready to proceed, choose **Create user**\.

You can use this same process to create more groups and users and to give your users access to your AWS account resources\. To learn about using policies that restrict user permissions to specific AWS resources, see [Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/access.html) and [Example Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_examples.html)\.

### Create delegated users for Global Accelerator<a name="auth_access_setup-iam-delegated"></a>

To support multiple users in your AWS account, you must delegate permission to allow other people to perform only the actions that you want to allow\. To do this, create an IAM group with the permissions those people need and then add IAM users to the necessary groups as you create them\. You can use this process to set up the groups, users, and permissions for your entire AWS account\. This solution is best used by small and medium organizations where an AWS administrator can manually manage the users and groups\. For large organizations, you can use [custom IAM roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_enable-console-custom-url.html), [federation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html), or [single sign\-on](https://docs.aws.amazon.com/singlesignon/latest/userguide/what-is.html)\.

In the following procedure, you create three users named **arnav**, **carlos**, and **martha** and attach a policy that grants permission to create an accelerator named **my\-example\-accelerator**, but only within the next 30 days\. You can use the steps provided here to add users with different permissions\.

**To create a delegated user for someone else \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users**, and then choose **Add user**\.

1. For **User name**, enter **arnav**\.

1. Choose **Add another user** and enter **carlos** for the second user\. Then choose **Add another user** and enter **martha** for the third user\.

1. Select the check box next to **AWS Management Console access**, and then select **Autogenerated password**\.

1. Clear the check box next to **User must create a new password at next sign\-in** to allow the new user to reset their password after they sign in\.

1. Choose **Next: Permissions**\.

1. Choose **Attach existing policies directly**\. You will create a new managed policy for the users\.

1. Choose **Create policy**\.

   The **Create policy** wizard opens in a new tab or browser window\.

1. On the **Visual editor** tab, choose **Choose a service**\. Then choose Global Accelerator\. You can use the search box at the top to limit the results in the list of services\.

   The **Service** section closes, and the **Actions** section opens automatically\.

1. Choose the Global Accelerator actions that you want to allow\. For example, to grants permission to create an accelerator, enter **`globalaccelerator:CreateAccelerator`** in the **Filter actions** text box\. When the list of Global Accelerator actions is filtered, select the check box next to **`globalaccelerator:CreateAccelerator`**\.

   The Global Accelerator actions are grouped by access\-level classification to make it easy for you to quickly determine the level of access that each action provides\. For more information, see [Policy access level classifications](#auth_access_policies-access-level)\.

1. If the actions that you selected in the preceding steps do not support choosing specific resources, then **All resources** is selected for you\. In that case, you cannot edit this section\.

   If you chose one or more actions that support resource\-level permissions, then the visual editor lists those resource types in the **Resources** section\. Choose **You chose actions that require the **accelerator** resource type** to choose whether you want to enter a specific accelerator for your policy\. 

1. If you want to allow the `globalaccelerator:CreateAccelerator` action for all resources, choose **All resources**\.

   If you want to specify a resource, choose **Add ARN**\. Specify the region and account ID \(or account ID\) \(or choose **Any**\), and then enter **my\-example\-accelerator** for the resource\. Then choose **Add**\.

1. Choose **Specify request conditions \(optional\)**\.

1. Choose **Add condition** to grants permission to create an accelerator within the next 7 days\. Assume that today's date is January 1, 2019\. 

1. For **Condition Key**, choose **aws:CurrentTime**\. This condition key checks the date and time that the user makes the request\. It returns true \(and therefore allows the **`globalaccelerator:CreateAccelerator`** action only if the date and time are within the specified range\.

1. For **Qualifier**, keep the default value\.

1. To specify the start of the allowed date and time range, for **Operator**, choose **DateGreaterThan**\. Then for **Value**, enter **2019\-01\-01T00:00:00Z**\.

1. Choose **Add** to save your condition\.

1. Choose **Add another condition** to specify the end date\.

1. Follow similar steps to specify the end of the allowed date and time range\. For **Condition Key**, choose **aws:CurrentTime**\. For **Operator**, choose **DateLessThan**\. For **Value**, enter **2019\-01\-06T23:59:59Z**, seven days after the first date\. Then choose **Add** to save your condition\.

1. \(Optional\) To see the JSON policy document for the policy that you are creating, choose the **JSON** tab\. You can switch between the **Visual editor** and **JSON** tabs any time\. However, if you make changes or choose **Review policy** in the **Visual editor** tab, IAM might restructure your policy to optimize it for the visual editor\. For more information, see [Policy Restructuring](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_policies.html#troubleshoot_viseditor-restructure) in the *IAM User Guide*\.

1. When you are finished, choose **Review policy**\.

1. On the **Review policy** page, for **Name**, enter **`globalaccelerator:CreateAccelerator`Policy**\. For **Description**, enter **Policy to grants permission to create an accelerator**\. Review the policy summary to make sure that you have granted the intended permissions, and then choose **Create policy** to save your new policy\.

1. Return to the original tab or window, and refresh your list of policies\. 

1. In the search box, enter **`globalaccelerator:CreateAccelerator`Policy**\. Select the check box next to your new policy\. Then choose **Next Step**\.

1. Choose **Next: Review** to preview your new users\. When you are ready to proceed, choose **Create users**\.

1. Download or copy the passwords for your new users and deliver them to the users securely\. Separately, provide your users with a [link to your IAM user console page](https://docs.aws.amazon.com/IAM/latest/UserGuide/console.html#user-sign-in-page) and the user names that you just created\.

### Allow users to self\-manage their credentials<a name="auth_access_manage-password-mfa"></a>

You must have physical access to the hardware that will host the user's virtual MFA device in order to configure MFA\. For example, you might configure MFA for a user who will use a virtual MFA device running on a smartphone\. In that case, you must have the smartphone available in order to finish the wizard\. Because of this, you might want to let users configure and manage their own virtual MFA devices\. In that case, you must grant users the permissions to perform the necessary IAM actions\.

**To create a policy to allow credential self\-management \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**, and then choose **Create policy**\.

1. Choose the **JSON** tab and copy the text from the following JSON policy document\. Paste this text into the **JSON** text box\.
**Important**  
This example policy does not allow users to reset their password while signing in\. New users and users with an expired password might try to do so\. You can allow this by adding `iam:ChangePassword` and `iam:CreateLoginProfile` to the statement `BlockMostAccessUnlessSignedInWithMFA`\. However, IAM does not recommend this\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Sid": "AllowAllUsersToListAccounts",
               "Effect": "Allow",
               "Action": [
                   "iam:ListAccountAliases",
                   "iam:ListUsers",
                   "iam:ListVirtualMFADevices",
                   "iam:GetAccountPasswordPolicy",
                   "iam:GetAccountSummary"
               ],
               "Resource": "*"
           },
           {
               "Sid": "AllowIndividualUserToSeeAndManageOnlyTheirOwnAccountInformation",
               "Effect": "Allow",
               "Action": [
                   "iam:ChangePassword",
                   "iam:CreateAccessKey",
                   "iam:CreateLoginProfile",
                   "iam:DeleteAccessKey",
                   "iam:DeleteLoginProfile",
                   "iam:GetLoginProfile",
                   "iam:ListAccessKeys",
                   "iam:UpdateAccessKey",
                   "iam:UpdateLoginProfile",
                   "iam:ListSigningCertificates",
                   "iam:DeleteSigningCertificate",
                   "iam:UpdateSigningCertificate",
                   "iam:UploadSigningCertificate",
                   "iam:ListSSHPublicKeys",
                   "iam:GetSSHPublicKey",
                   "iam:DeleteSSHPublicKey",
                   "iam:UpdateSSHPublicKey",
                   "iam:UploadSSHPublicKey"
               ],
               "Resource": "arn:aws:iam::*:user/${aws:username}"
           },
           {
               "Sid": "AllowIndividualUserToViewAndManageTheirOwnMFA",
               "Effect": "Allow",
               "Action": [
                   "iam:CreateVirtualMFADevice",
                   "iam:DeleteVirtualMFADevice",
                   "iam:EnableMFADevice",
                   "iam:ListMFADevices",
                   "iam:ResyncMFADevice"
               ],
               "Resource": [
                   "arn:aws:iam::*:mfa/${aws:username}",
                   "arn:aws:iam::*:user/${aws:username}"
               ]
           },
           {
               "Sid": "AllowIndividualUserToDeactivateOnlyTheirOwnMFAOnlyWhenUsingMFA",
               "Effect": "Allow",
               "Action": [
                   "iam:DeactivateMFADevice"
               ],
               "Resource": [
                   "arn:aws:iam::*:mfa/${aws:username}",
                   "arn:aws:iam::*:user/${aws:username}"
               ],
               "Condition": {
                   "Bool": {
                       "aws:MultiFactorAuthPresent": "true"
                   }
               }
           },
           {
               "Sid": "BlockMostAccessUnlessSignedInWithMFA",
               "Effect": "Deny",
               "NotAction": [
                   "iam:CreateVirtualMFADevice",
                   "iam:DeleteVirtualMFADevice",
                   "iam:ListVirtualMFADevices",
                   "iam:EnableMFADevice",
                   "iam:ResyncMFADevice",
                   "iam:ListAccountAliases",
                   "iam:ListUsers",
                   "iam:ListSSHPublicKeys",
                   "iam:ListAccessKeys",
                   "iam:ListServiceSpecificCredentials",
                   "iam:ListMFADevices",
                   "iam:GetAccountSummary",
                   "sts:GetSessionToken"
               ],
               "Resource": "*",
               "Condition": {
                   "BoolIfExists": {
                       "aws:MultiFactorAuthPresent": "false"
                   }
               }
           }
       ]
   }
   ```

   What does this policy do? 
   + The `AllowAllUsersToListAccounts` statement enables the user to see basic information about the account and its users in the IAM console\. These permissions must be in their own statement because they do not support or do not need to specify a specific resource ARN, and instead specify `"Resource" : "*"`\.
   + The `AllowIndividualUserToSeeAndManageOnlyTheirOwnAccountInformation` statement enables the user to manage his or her own user, password, access keys, signing certificates, SSH public keys, and MFA information in the IAM console\. It also allows users to sign in for the first time in an administrator requires them to set a first\-time password\. The resource ARN limits the use of these permissions to only the user's own IAM user entity\.
   + The `AllowIndividualUserToViewAndManageTheirOwnMFA` statement enables the user to view or manage his or her own MFA device\. Notice that the resource ARNs in this statement allow access to only an MFA device or user that has the same name as the currently signed\-in user\. Users can't create or alter any MFA device other than their own\.
   + The `AllowIndividualUserToDeactivateOnlyTheirOwnMFAOnlyWhenUsingMFA` statement allows the user to deactivate only his or her own MFA device, and only if the user signed in using MFA\. This prevents others with only the access keys \(and not the MFA device\) from deactivating the MFA device and accessing the account\.
   + The `BlockMostAccessUnlessSignedInWithMFA` statement uses a combination of `"Deny"` and `"NotAction"` to deny access to all but a few actions in IAM and other AWS services ***if*** the user is not signed\-in with MFA\. For more information about the logic for this statement, see [NotAction with Deny](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_notaction.html) in the *IAM User Guide*\. If the user is signed\-in with MFA, then the `"Condition"` test fails and the final "deny" statement has no effect and other policies or statements for the user determine the user's permissions\. This statement ensures that when the user is not signed\-in with MFA, they can perform only the listed actions and only if another statement or policy allows access to those actions\.

     The `...IfExists` version of the `Bool` operator ensures that if the `aws:MultiFactorAuthPresent` key is missing, the condition returns true\. This means that a user accessing an API with long\-term credentials, such as an access key, is denied access to the non\-IAM API operations\.

1. When you are finished, choose **Review policy**\.

1. On the **Review** page, enter **Force\_MFA** for the policy name\. For the policy description, enter **This policy allows users to manage their own passwords and MFA devices but nothing else unless they authenticate with MFA\.** Review the policy **Summary** to see the permissions granted by your policy, and then choose **Create policy** to save your work\.

   The new policy appears in the list of managed policies and is ready to attach\.

**To attach the policy to a user \(console\)**

1. In the navigation pane, choose **Users**\.

1. Choose the name \(not the check box\) of the user you want to edit\. 

1. On the **Permissions** tab, choose **Add permissions**\.

1. Choose **Attach existing policies directly**\.

1. In the search box, enter **Force**, and then select the check box next to **Force\_MFA** in the list\. Then choose **Next: Review**\.

1. Review your changes and choose **Add permissions**\.

### Enable MFA for your IAM user<a name="auth_access_enable-mfa"></a>

For increased security, we recommend that all IAM users configure multi\-factor authentication \(MFA\) to help protect your Global Accelerator resources\. MFA adds extra security because it requires users to provide unique authentication from an AWS\-supported MFA device in addition to their regular sign\-in credentials\. The most secure AWS MFA device is the U2F security key\. If your company already has U2F devices, then we recommend that you enable those devices for AWS\. Otherwise, you must purchase a device for each of your users and wait for the hardware to arrive\. For more information, see [Enabling a U2F Security Key](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa_enable_u2f.html) in the *IAM User Guide*\. 

If you don't already have a U2F device, you can get started quickly and at a low cost by enabling a virtual MFA device\. This requires that you install a software app on an existing phone or other mobile device\. The device generates a six\-digit numeric code based upon a time\-synchronized one\-time password algorithm\. When the user signs in to AWS, they are prompted to enter a code from the device\. Each virtual MFA device assigned to a user must be unique\. A user cannot enter a code from another user's virtual MFA device to authenticate\. For a list of a few supported apps that you can use as virtual MFA devices, see [Multi\-Factor Authentication](http://aws.amazon.com/iam/details/mfa/)\.

**Note**  
You must have physical access to the mobile device that will host the user's virtual MFA device in order to configure MFA for an IAM user\.

**To enable a virtual MFA device for an IAM user \(console\)**

1. Sign in to the AWS Management Console and open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users**\.

1. In the **User Name** list, choose the name of the intended MFA user\.

1. Choose the **Security credentials** tab\. Next to **Assigned MFA device**, choose **Manage**\.

1. In the **Manage MFA Device** wizard, choose **Virtual MFA device**, and then choose **Continue**\.

   IAM generates and displays configuration information for the virtual MFA device, including a QR code graphic\. The graphic is a representation of the "secret configuration key" that is available for manual entry on devices that do not support QR codes\.

1. Open your virtual MFA app\.

   For a list of apps that you can use for hosting virtual MFA devices, see [Multi\-Factor Authentication](http://aws.amazon.com/iam/details/mfa/)\. If the virtual MFA app supports multiple accounts \(multiple virtual MFA devices\), choose the option to create a new account \(a new virtual MFA device\)\.

1. Determine whether the MFA app supports QR codes, and then do one of the following:
   + From the wizard, choose **Show QR code**, and then use the app to scan the QR code\. For example, you might choose the camera icon or choose an option similar to **Scan code**, and then use the device's camera to scan the code\.
   + In the **Manage MFA Device** wizard, choose **Show secret key**, and then enter the secret key into your MFA app\.

   When you are finished, the virtual MFA device starts generating one\-time passwords\. 

1. In the **Manage MFA Device** wizard, in the **MFA code 1** box, enter the one\-time password that currently appears in the virtual MFA device\. Wait up to 30 seconds for the device to generate a new one\-time password\. Then enter the second one\-time password into the **MFA code 2** box\. Choose **Assign MFA**\. 
**Important**  
Submit your request immediately after generating the codes\. If you generate the codes and then wait too long to submit the request, the MFA device successfully associates with the user but the MFA device is out of sync\. This happens because time\-based one\-time passwords \(TOTP\) expire after a short period of time\. If this happens, you can resync the device\. For more information, see [Resynchronizing Virtual and Hardware MFA Devices](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa_sync.html) in the *IAM User Guide*\.

   The virtual MFA device is now ready for use with AWS\.