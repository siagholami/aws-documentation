# Security in AWS IoT Analytics<a name="security"></a>

Cloud security at AWS is the highest priority\. As an AWS customer, you benefit from a data center and network architecture that is built to meet the requirements of the most security\-sensitive organizations\.

Security is a shared responsibility between AWS and you\. The [shared responsibility model](https://aws.amazon.com/compliance/shared-responsibility-model/) describes this as security *of* the cloud and security *in* the cloud:
+  **Security of the cloud** \- AWS is responsible for protecting the infrastructure that runs AWS services in the AWS Cloud\. AWS also provides you with services that you can use securely\. The effectiveness of our security is regularly tested and verified by third\-party auditors as part of the [AWS compliance programs](https://aws.amazon.com/compliance/programs/)\. To learn about the compliance programs that apply to AWS IoT Analytics, see [AWS Services in Scope by Compliance Program](https://aws.amazon.com/compliance/services-in-scope/)\.
+  **Security in the cloud** \- Your responsibility is determined by the AWS service that you use\. You are also responsible for other factors including the sensitivity of your data, your organization’s requirements, and applicable laws and regulations\.

This documentation will help you understand how to apply the shared responsibility model when using AWS IoT Analytics\. The following topics show you how to configure AWS IoT Analytics to meet your security and compliance objectives\. You'll also learn how to use other AWS services that can help you to monitor and secure your AWS IoT Analytics resources\.<a name="security-iam"></a>

## Identity and Access Management for AWS IoT Analytics<a name="security-iam"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps an administrator securely control access to AWS resources\. IAM administrators control who can be *authenticated* \(signed in\) and *authorized* \(have permissions\) to use AWS IoT Analytics resources\. IAM is an AWS service that you can use with no additional charge\.

### Audience<a name="security-iam-audience"></a>

How you use AWS Identity and Access Management \(IAM\) differs, depending on the work you do in AWS IoT Analytics\.

 **Service user** \- If you use the AWS IoT Analytics service to do your job, then your administrator provides you with the credentials and permissions that you need\. As you use more AWS IoT Analytics features to do your work, you might need additional permissions\. Understanding how access is managed can help you request the right permissions from your administrator\. If you cannot access a feature in AWS IoT Analytics, see [Troubleshooting AWS IoT Analytics Identity and Access](#security-iam-troubleshoot)\.

 **Service administrator** \- If you're in charge of AWS IoT Analytics resources at your company, you probably have full access to AWS IoT Analytics\. It's your job to determine which AWS IoT Analytics features and resources your employees should access\. You must then submit requests to your IAM administrator to change the permissions of your service users\. Review the information on this page to understand the basic concepts of IAM\. To learn more about how your company can use IAM with AWS IoT Analytics, see [How AWS IoT Analytics Works with IAM](#security-iam-service-with-iam)\.

 **IAM administrator** \- If you're an IAM administrator, you might want to learn details about how you can write policies to manage access to AWS IoT Analytics\. To view example AWS IoT Analytics identity\-based policies that you can use in IAM, see [AWS IoT Analytics Identity\-Based Policy Examples](#security-iam-id-based-policy-examples)\.

### Authenticating with Identities<a name="security-iam-authentication"></a>

Authentication is how you sign in to AWS using your identity credentials\. For more information about signing in using the AWS Management Console, see [The IAM Console and Sign\-in Page](https://docs.aws.amazon.com/IAM/latest/UserGuide/console.html) in the *IAM User Guide*\.

You must be *authenticated* \(signed in to AWS\) as the AWS account root user, an IAM user, or by assuming an IAM role\. You can also use your company's single sign\-on authentication, or even sign in using Google or Facebook\. In these cases, your administrator previously set up identity federation using IAM roles\. When you access AWS using credentials from another company, you are assuming a role indirectly\.

To sign in directly to the [AWS Management Console](https://console.aws.amazon.com), use your password with your root user email or your IAM user name\. You can access AWS programmatically using your root user or IAM user access keys\. AWS provides SDK and command line tools to cryptographically sign your request using your credentials\. If you don’t use AWS tools, you must sign the request yourself\. Do this using *Signature Version 4*, a protocol for authenticating inbound API requests\. For more information about authenticating requests, see [Signature Version 4 Signing Process](https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html) in the *AWS General Reference*\.

Regardless of the authentication method that you use, you might also be required to provide additional security information\. For example, AWS recommends that you use multi\-factor authentication \(MFA\) to increase the security of your account\. To learn more, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.

#### AWS Account Root User<a name="security-iam-authentication-rootuser"></a>

When you first create an AWS account, you begin with a single sign\-in identity that has complete access to all AWS services and resources in the account\. This identity is called the AWS account *root user* and is accessed by signing in with the email address and password that you used to create the account\. We strongly recommend that you do not use the root user for your everyday tasks, even the administrative ones\. Instead, adhere to the [best practice of using the root user only to create you first IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users)\. Then securely lock away the root user credentials and use them to perform only a few account and service management tasks\.

#### IAM Users and Groups<a name="security-iam-authentication-iamuser"></a>

An [IAM user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users.html) is an identity within your AWS account that has specific permissions for a single person or application\. An IAM user can have long\-term credentials such as a user name and password or a set of access keys\. To learn how to generate access keys, see [Managing Access Keys for IAM Users](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html) in the *IAM User Guide*\. When you generate access keys for an IAM user, make sure you view and securely save the key pair\. You cannot recover a lost secret access key\. Instead, you must generate a new access key pair\.

An [IAM group](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_groups.html) is an identity that specifies a collection of IAM users\. You can't sign in as a group\. You can use groups to specify permissions for multiple users at a time\. Groups make permissions easier to manage for large sets of users\. For example, you could have a group named *IAMAdmins* and give that group permissions to administer IAM resources\.

Users are different from roles\. A user is uniquely associated with one person or application, but a role is intended to be assumable by anyone who needs it\. Users have permanent long\-term credentials, but roles provide temporary credentials\. To learn more, see [When to Create an IAM User \(Instead of a Role\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html#id_which-to-choose) in the *IAM User Guide*\.

#### IAM Roles<a name="security-iam-authentication-iamrole"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an identity within your AWS account that has specific permissions\. It is similar to an IAM user, but is not associated with a specific person\. You can temporarily assume an IAM role in the AWS Management Console by [switching roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-console.html)\. You can assume a role by calling an AWS CLI or AWS API operation or by using a custom URL\. For more information about methods for using roles, see [Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use.html) in the *IAM User Guide*\.

IAM roles with temporary credentials are useful in the following situations:
+  **Temporary IAM user permissions** \- An IAM user can assume an IAM role to temporarily take on different permissions for a specific task\.
+  **Federated user access** \- Instead of creating an IAM user, you can use existing identities from AWS Directory Service, your enterprise user directory, or a web identity provider\. These are known as *federated users*\. AWS assigns a role to a federated user when access is requested through an [identity provider](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers.html)\. For more information about federated users, see [Federated Users and Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction_access-management.html#intro-access-roles) in the *IAM User Guide*\.
+  **Cross\-account access** \- You can use an IAM role to allow someone \(a trusted principal\) in a different account to access resources in your account\. Roles are the primary way to grant cross\-account access\. However, with some AWS services, you can attach a policy directly to a resource \(instead of using a role as a proxy\)\. To learn the difference between roles and resource\-based policies for cross\-account access, see [How IAM Roles Differ from Resource\-based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_compare-resource-policies.html) in the *IAM User Guide*\.
+  **AWS service access** \- A service role is an IAM role that a service assumes to perform actions in your account on your behalf\. When you set up some AWS service environments, you must define a role for the service to assume\. This service role must include all the permissions that are required for the service to access the AWS resources that it needs\. Service roles vary from service to service, but many allow you to choose your permissions as long as you meet the documented requirements for that service\. Service roles provide access only within your account and cannot be used to grant access to services in other accounts\. You can create, modify, and delete a service role from within IAM\. For example, you can create a role that allows Amazon Redshift to access an Amazon S3 bucket on your behalf and then load data from that bucket into an Amazon Redshift cluster\. For more information, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html) in the *IAM User Guide*\.
+  **Applications running on Amazon EC2** \- You can use an IAM role to manage temporary credentials for applications that are running on an EC2 instance and making AWS CLI or AWS API requests\. This is preferable to storing access keys within the EC2 instance\. To assign an AWS role to an EC2 instance and make it available to all of its applications, you create an instance profile that is attached to the instance\. An instance profile contains the role and enables programs that are running on the EC2 instance to get temporary credentials\. For more information, see [Using an IAM Role to Grant Permissions to Applications Running on Amazon EC2 Instances](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-ec2.html) in the *IAM User Guide*\.

To learn whether to use IAM roles, see [When to Create an IAM Role \(Instead of a User\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html#id_which-to-choose_role) in the *IAM User Guide*\.

### Managing Access Using Policies<a name="security-iam-access-manage"></a>

You control access in AWS by creating policies and attaching them to IAM identities or AWS resources\. A policy is an object in AWS that, when associated with an identity or resource, defines their permissions\. AWS evaluates these policies when an entity \(root user, IAM user, or IAM role\) makes a request\. Permissions in the policies determine whether the request is allowed or denied\. Most policies are stored in AWS as JSON documents\. For more information about the structure and contents of JSON policy documents, see [Overview of JSON Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#access_policies-json) in the *IAM User Guide*\.

An IAM administrator can use policies to specify who has access to AWS resources, and what actions they can perform on those resources\. Every IAM entity \(user or role\) starts with no permissions\. In other words, by default, users can do nothing, not even change their own password\. To give a user permission to do something, an administrator must attach a permissions policy to a user\. Or the administrator can add the user to a group that has the intended permissions\. When an administrator gives permissions to a group, all users in that group are granted those permissions\.

IAM policies define permissions for an action regardless of the method that you use to perform the operation\. For example, suppose that you have a policy that allows the `iam:GetRole` action\. A user with that policy can get role information from the AWS Management Console, the AWS CLI, or the AWS API\.

#### Identity\-Based Policies<a name="identity-based-policies"></a>

Identity\-based policies are JSON permissions policy documents that you can attach to an identity, such as an IAM user, role, or group\. These policies control what actions that identity can perform, on which resources, and under what conditions\. To learn how to create an identity\-based policy, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html) in the *IAM User Guide*\.

Identity\-based policies can be further categorized as *inline policies* or *managed policies*\. Inline policies are embedded directly into a single user, group, or role\. Managed policies are standalone policies that you can attach to multiple users, groups, and roles in your AWS account\. Managed policies include AWS managed policies and customer managed policies\. To learn how to choose between a managed policy or an inline policy, see [Choosing Between Managed Policies and Inline Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#choosing-managed-or-inline) in the *IAM User Guide*\.

#### Other Policy Types<a name="security-iam-access-manage-other-policies"></a>

AWS supports additional, less common policy types\. These policy types can set the maximum permissions granted to you by the more common policy types\.
+  **Permissions boundaries** \- A permissions boundary is an advanced feature in which you set the maximum permissions that an identity\-based policy can grant to an IAM entity \(IAM user or role\)\. You can set a permissions boundary for an entity\. The resulting permissions are the intersection of entity's identity\-based policies and its permissions boundaries\. Resource\-based policies that specify the user or role in the `Principal` field are not limited by the permissions boundary\. An explicit deny in any of these policies overrides the allow\. For more information about permissions boundaries, see [Permissions Boundaries for IAM Entities](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_boundaries.html) in the *IAM User Guide*\.
+  **Service control policies \(SCPs\)** \- SCPs are JSON policies that specify the maximum permissions for an organization or organizational unit \(OU\) in AWS Organizations\. AWS Organizations is a service for grouping and centrally managing multiple AWS accounts that your business owns\. If you enable all features in an organization, then you can apply SCPs to any or all of your accounts\. The SCP limits permissions for entities in member accounts, including each AWS Account root user\. For more information about AWS Organizations and SCPs, see [How SCPs Work](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_about-scps.html) in the *AWS Organizations User Guide*\.
+  **Session policies** \- Session policies are advanced policies that you pass as a parameter when you programmatically create a temporary session for a role or federated user\. The resulting session's permissions are the intersection of the user or role's identity\-based policies and the session policies\. Permissions can also come from a resource\-based policy\. An explicit deny in any of these policies overrides the allow\. For more information, see [Session Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session) in the *IAM User Guide*\.

#### Multiple Policy Types<a name="security-iam-access-manage-multiple-policies"></a>

When multiple types of policies apply to a request, the resulting permissions are more complicated to understand\. To learn how AWS determines whether to allow a request when multiple policy types are involved, see [Policy Evaluation Logic](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_evaluation-logic.html) in the *IAM User Guide*\.

#### Learn More<a name="security-iam-learn-more"></a>

For more information about identity and access management for AWS IoT Analytics, continue to the following sections:
+  [How AWS IoT Analytics Works with IAM](#security-iam-service-with-iam) 
+  [Troubleshooting AWS IoT Analytics Identity and Access](#security-iam-troubleshoot) 

### How AWS IoT Analytics Works with IAM<a name="security-iam-service-with-iam"></a>

Before you use IAM to manage access to AWS IoT Analytics, you should understand what IAM features are available to use with AWS IoT Analytics\. To get a high\-level view of how AWS IoT Analytics and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

#### AWS IoT Analytics Identity\-Based Policies<a name="security-iam-service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources and the conditions under which actions are allowed or denied\. AWS IoT Analytics supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

##### Actions<a name="security-iam-service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\.

Policy actions in AWS IoT Analytics use the following prefix before the action: `iotanalytics:` For example, to grant someone permission to create an AWS IoT Analytics channel with the AWS IoT Analytics `CreateChannel` API operation, you include the `iotanalytics:CreateChannel` action in their policy\. To grant someone permission to send an message data to a channel with the AWS IoT Analytics `BatchPutMessage` API operation, you include the `iotanalytics:BatchPutMessage` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. AWS IoT Analytics defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
    "iotanalytics:action1",
    "iotanalytics:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "iotanalytics:Describe*"
```

To see a list of AWS IoT Analytics actions, see [Actions Defined by AWS IoT Analytics](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotanalytics.html#awsiotanalytics-actions-as-permissions) in the *IAM User Guide*\.

##### Resources<a name="security-iam-service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

The AWS IoT Analytics dataset resource has the following ARN\.

```
arn:${Partition}:iotanalytics:${Region}:${Account}:dataset/${DatasetName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `Foobar` dataset in your statement, use the following ARN\.

```
"Resource": "arn:aws:iotanalytics:us-east-1:123456789012:dataset/Foobar"
```

To specify all instances that belong to a specific account, use the wildcard \(\*\)\.

```
"Resource": "arn:aws:iotanalytics:us-east-1:123456789012:dataset/*"
```

Some AWS IoT Analytics actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

Some AWS IoT Analytics API actions involve multiple resources\. For example, `CreatePipeline` references a channel and a dataset, so an IAM user must have permissions to use the channel and the dataset\. To specify multiple resources in a single statement, separate the ARNs with commas\.

```
"Resource": [
    "resource1",
    "resource2"
```

To see a list of AWS IoT Analytics resource types and their ARNs, see [Resources Defined by AWS IoT Analytics](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotanalytics.html#awsiotanalytics-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS IoT Analytics](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotanalytics.html#awsiotanalytics-actions-as-permissions)\.

##### Condition Keys<a name="security-iam-service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block* lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\.

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\.

AWS IoT Analytics does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

##### Examples<a name="security-iam-service-with-iam-id-based-policies-examples"></a>

To view examples of AWS IoT Analytics identity\-based policies, see [AWS IoT Analytics Identity\-Based Policy Examples](#security-iam-id-based-policy-examples)\.

#### AWS IoT Analytics Resource\-Based Policies<a name="security-iam-service-with-iam-resource-based-policies"></a>

AWS IoT Analytics does not support resource\-based policies\. To view an example of a detailed resource\-based policy page, see [https://docs\.aws\.amazon\.com/lambda/latest/dg/access\-control\-resource\-based\.html](https://docs.aws.amazon.com/lambda/latest/dg/access-control-resource-based.html)\.

#### Authorization Based on AWS IoT Analytics Tags<a name="security-iam-service-with-iam-tags"></a>

You can attach tags to AWS IoT Analytics resources or pass tags in a request to AWS IoT Analytics\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `iotanalytics:ResourceTag/{key-name}`, `aws:RequestTag/{key-name}` or `aws:TagKeys` condition keys\. For more information about tagging AWS IoT Analytics resources, see [Tagging Your AWS IoT Analytics Resources](tagging.md#aws-iot-analytics-tagging)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing AWS IoT Analytics Channels Based on Tags](#security-iam-id-based-policy-examples-view-input-tags)\.

#### AWS IoT Analytics IAM Roles<a name="security-iam-service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

##### Using Temporary Credentials with AWS IoT Analytics<a name="security-iam-service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS Security Token Service \(AWS STS\) API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\.

AWS IoT Analytics does not support using temporary credentials\.

##### Service\-Linked Roles<a name="security-iam-service-with-iam-roles-service-linked"></a>

 [Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

AWS IoT Analytics does not support service\-linked roles\.

##### Service Roles<a name="security-iam-service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS IoT Analytics supports service roles\.

### AWS IoT Analytics Identity\-Based Policy Examples<a name="security-iam-id-based-policy-examples"></a>

By default, IAM users and roles don't have permission to create or modify AWS IoT Analytics resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

#### Policy Best Practices<a name="security-iam-service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS IoT Analytics resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+  **Get Started Using AWS Managed Policies** \- To start using AWS IoT Analytics quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+  **Grant Least Privilege** \- When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+  **Enable MFA for Sensitive Operations** \- For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+  **Use Policy Conditions for Extra Security** \- To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

#### Using the AWS IoT Analytics Console<a name="security-iam-id-based-policy-examples-console"></a>

To access the AWS IoT Analytics console, you must have a minimum set of permissions\. These permissions must allow you to list and view details about the AWS IoT Analytics resources in your AWS account\. If you create an identity\-based policy that is more restrictive than the minimum required permissions, the console won't function as intended for entities \(IAM users or roles\) with that policy\.

To ensure that those entities can still use the AWS IoT Analytics console, also attach the following AWS managed policy to the entities\. For more information, see [Adding Permissions to a User](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#users_change_permissions-add-console) in the *IAM User Guide*\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iotanalytics:BatchPutMessage",
                "iotanalytics:CancelPipelineReprocessing",
                "iotanalytics:CreateChannel",
                "iotanalytics:CreateDataset",
                "iotanalytics:CreateDatasetContent",
                "iotanalytics:CreateDatastore",
                "iotanalytics:CreatePipeline",
                "iotanalytics:DeleteChannel",
                "iotanalytics:DeleteDataset",
                "iotanalytics:DeleteDatasetContent",
                "iotanalytics:DeleteDatastore",
                "iotanalytics:DeletePipeline",
                "iotanalytics:DescribeChannel",
                "iotanalytics:DescribeDataset",
                "iotanalytics:DescribeDatastore",
                "iotanalytics:DescribeLoggingOptions",
                "iotanalytics:DescribePipeline",
                "iotanalytics:GetDatasetContent",
                "iotanalytics:ListChannels",
                "iotanalytics:ListDatasetContents",
                "iotanalytics:ListDatasets",
                "iotanalytics:ListDatastores",
                "iotanalytics:ListPipelines",
                "iotanalytics:ListTagsForResource",
                "iotanalytics:PutLoggingOptions",
                "iotanalytics:RunPipelineActivity",
                "iotanalytics:SampleChannelData",
                "iotanalytics:StartPipelineReprocessing",
                "iotanalytics:TagResource",
                "iotanalytics:UntagResource",
                "iotanalytics:UpdateChannel",
                "iotanalytics:UpdateDataset",
                "iotanalytics:UpdateDatastore",
                "iotanalytics:UpdatePipeline"
            ],
            "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:channel/${channelName}",
            "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:dataset/${datasetName}",
            "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:datastore/${datastoreName}",
            "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:pipeline/${pipelineName}"
        }
    ]
}
```

You don't need to allow minimum console permissions for users that are making calls only to the AWS CLI or the AWS API\. Instead, allow access to only the actions that match the API operation that you're trying to perform\.

#### Allow Users to View Their Own Permissions<a name="security-iam-id-based-policy-examples-view-own-permissions"></a>

This example shows how you might create a policy that allows IAM users to view the inline and managed policies that are attached to their user identity\. This policy includes permissions to complete this action on the console or programmatically using the AWS CLI or AWS API\.

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
            "Sid": "NavigateInConsole",
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

#### Accessing One AWS IoT Analytics Input<a name="security-iam-id-based-policy-examples-access-one-input"></a>

In this example, you want to grant an IAM user in your AWS account access to one of your AWS IoT Analytics channels, `exampleChannel` You also want to allow the user to add, update, and delete channels\.

The policy grants the `iotanalytics:ListChannels`, `iotanalytics:DescribeChannel`, `iotanalytics:CreateChannel`, `iotanalytics:DeleteChannel`, and `iotanalytics:UpdateChannel` permissions to the user\. For an example walkthrough for the Amazon S3 service that grants permissions to users and tests them using the console, see [An Example Walkthrough: Using user policies to control access to your bucket](https://docs.aws.amazon.com/AmazonS3/latest/dev/walkthrough1.html)\.

```
{
    "Version":"2012-10-17",
    "Statement":[
       {
          "Sid":"ListChannelsInConsole",
          "Effect":"Allow",
          "Action":[
             "iotanalytics:ListChannels"
          ],
          "Resource":"arn:aws:iotanalytics:::*"
       },
       {
          "Sid":"ViewSpecificChannelInfo",
          "Effect":"Allow",
          "Action":[
             "iotanalytics:DescribeChannel"
          ],
          "Resource":"arn:aws:iotanalytics:::exampleChannel"
       },
       {
          "Sid":"ManageChannels",
          "Effect":"Allow",
          "Action":[
             "iotanalytics:CreateChannel",
             "iotanalytics:DeleteChannel",
             "iotanalytics:DescribeChannel",
             "iotanalytics:ListChannels",
             "iotanalytics:UpdateChannel"
          ],
          "Resource":"arn:aws:iotanalytics:::exampleChannel/*"
       }
    ]
 }
```

#### Viewing AWS IoT Analytics Channels Based on Tags<a name="security-iam-id-based-policy-examples-view-input-tags"></a>

You can use conditions in your identity\-based policy to control access to AWS IoT Analytics resources based on tags\. This example shows how you might create a policy that allows viewing a `channel`\. However, permission is granted only if the `channel` tag `Owner` has the value of that user's user name\. This policy also grants the permissions needed to complete this action on the console\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ListChannelsInConsole",
            "Effect": "Allow",
            "Action": "iotanalytics:ListChannels",
            "Resource": "*"
        },
        {
            "Sid": "ViewChannelsIfOwner",
            "Effect": "Allow",
            "Action": "iotanalytics:ListChannels",
            "Resource": "arn:aws:iotanalytics:*:*:channel/*",
            "Condition": {
                "StringEquals": {"iotanalytics:ResourceTag/Owner": "${aws:username}"}
            }
        }
    ]
}
```

You can attach this policy to the IAM users in your account\. If a user named `richard-roe` attempts to view an AWS IoT Analytics `channel`, the `channel` must be tagged `Owner=richard-roe` or `owner=richard-roe`\. Otherwise, he is denied access\. The condition tag key `Owner` matches both `Owner` and `owner` because condition key names are not case sensitive\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

### Troubleshooting AWS IoT Analytics Identity and Access<a name="security-iam-troubleshoot"></a>

Use the following information to help you diagnose and fix common issues that you might encounter when working with AWS IoT Analytics and IAM\.<a name="security-iam-troubleshoot-no-permissions"></a>

If the AWS Management console tells you that you're not authorized to perform an action, then you must contact your administrator for assistance\. Your administrator is the person that provided you with your user name and password\.

The following example error occurs when the `mateojackson` IAM user tries to use the console to view details about a `channel` but does not have `iotanalytics:ListChannels` permissions\.

```
User: arn:aws:iam::123456789012:user/mateojackson is not authorized to perform: iotanalytics:``ListChannels`` on resource: ``my-example-channel``
```

In this case, Mateo asks his administrator to update his policies to allow him to access the `my-example-channel` resource using the `iotanalytics:ListChannel` action\.<a name="security-iam-troubleshoot-passrole"></a>

If you receive an error that you're not authorized to perform the `iam:PassRole` action, then you must contact your administrator for assistance\. Your administrator is the person that provided you with your user name and password\. Ask that person to update your policies to allow you to pass a role to AWS IoT Analytics\.

Some AWS services allow you to pass an existing role to that service, instead of creating a new service role or service\-linked role\. To do this, you must have permissions to pass the role to the service\.

The following example error occurs when an IAM user named `marymajor` tries to use the console to perform an action in AWS IoT Analytics\. However, the action requires the service to have permissions granted by a service role\. Mary does not have permissions to pass the role to the service\.

```
User: arn:aws:iam::123456789012:user/marymajor is not authorized to perform: iam:PassRole
```

In this case, Mary asks her administrator to update her policies to allow her to perform the `iam:PassRole` action\.<a name="security-iam-troubleshoot-access-keys"></a>

After you create your IAM user access keys, you can view your access key ID at any time\. However, you can't view your secret access key again\. If you lose your secret key, you must create a new access key pair\.

Access keys consist of two parts: an access key ID \(for example, `AKIAIOSFODNN7EXAMPLE`\) and a secret access key \(for example, `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY`\)\. Like a user name and password, you must use both the access key ID and secret access key together to authenticate your requests\. Manage your access keys as securely as you do your user name and password\.

**Important**  
Do not provide your access keys to a third party, even to help [find your canonical user ID](https://docs.aws.amazon.com/general/latest/gr/acct-identifiers.html#FindingCanonicalId)\. By doing this, you might give someone permanent access to your account\.

When you create an access key pair, you are prompted to save the access key ID and secret access key in a secure location\. The secret access key is available only at the time you create it\. If you lose your secret access key, you must add new access keys to your IAM user\. You can have a maximum of two access keys\. If you already have two, you must delete one key pair before creating a new one\. To view instructions, see [Managing Access Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey) in the *IAM User Guide*\.<a name="security-iam-troubleshoot-admin-delegate"></a>

To allow others to access AWS IoT Analytics, you must create an IAM entity \(user or role\) for the person or application that needs access\. They will use the credentials for that entity to access AWS\. You must then attach a policy to the entity that grants them the correct permissions in AWS IoT Analytics\.

To get started right away, see [Creating Your First IAM Delegated User and Group](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started_create-delegated-user.html) in the *IAM User Guide*\.

You can create a role that users in other accounts or people outside of your organization can use to access your resources\. You can specify who is trusted to assume the role\. For services that support resource\-based policies or access control lists \(ACLs\), you can use those policies to grant people access to your resources\.

To learn more, consult the following:
+ To learn whether AWS IoT Analytics supports these features, see [How AWS IoT Analytics Works with IAM](#security-iam-service-with-iam)\.
+ To learn how to provide access to your resources across AWS accounts that you own, see [Providing Access to an IAM User in Another AWS Account That You Own](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_aws-accounts.html) in the *IAM User Guide*\.
+ To learn how to provide access to your resources to third\-party AWS accounts, see [Providing Access to AWS Accounts Owned by Third Parties](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_third-party.html) in the *IAM User Guide*\.
+ To learn how to provide access through identity federation, see [Providing Access to Externally Authenticated Users \(Identity Federation\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_federated-users.html) in the *IAM User Guide*\.
+ To learn the difference between using roles and resource\-based policies for cross\-account access, see [How IAM Roles Differ from Resource\-based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_compare-resource-policies.html) in the *IAM User Guide*\.