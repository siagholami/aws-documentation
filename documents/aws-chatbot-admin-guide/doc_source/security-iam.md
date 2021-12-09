# Identity and Access Management for AWS Chatbot<a name="security-iam"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps an administrator securely control access to AWS resources\. IAM administrators control who can be *authenticated* \(signed in\) and *authorized* \(have permissions\) to use AWS Chatbot resources\. IAM is an AWS service that you can use with no additional charge\.

## Audience<a name="security_iam_audience"></a>

How you use AWS Identity and Access Management \(IAM\) differs, depending on the work you do in AWS Chatbot\.

**Service user** – If you use the AWS Chatbot service to do your job, then your administrator provides you with the credentials and permissions that you need\. As you use more AWS Chatbot features to do your work, you might need additional permissions\. Understanding how access is managed can help you request the right permissions from your administrator\. If you cannot access a feature in AWS Chatbot, see [Troubleshooting AWS Chatbot identity and access](security_iam_troubleshoot.md)\.

**Service administrator** – If you're in charge of AWS Chatbot resources at your company, you probably have full access to AWS Chatbot\. It's your job to determine which AWS Chatbot features and resources your employees should access\. You must then submit requests to your IAM administrator to change the permissions of your service users\. Review the information on this page to understand the basic concepts of IAM\. To learn more about how your company can use IAM with AWS Chatbot, see [How AWS Chatbot works with IAM](#security_iam_service-with-iam)\.

**IAM administrator** – If you're an IAM administrator, you might want to learn details about how you can write policies to manage access to AWS Chatbot\. To view example AWS Chatbot identity\-based policies that you can use in IAM, see [Identity\-based policies for AWS Chatbot](security_iam_service-with-iam-id-based-policies.md#security_iam_id-based-policy-examples)\.

## How AWS Chatbot works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to AWS Chatbot, you should understand which IAM features are available to use with AWS Chatbot\. The following subsections introduce each IAM capability supported by AWS Chatbot, point you to further information about how to use them, and describe the IAM capabilities that AWS Chatbot doesn't support\. To get a high\-level view of how AWS Chatbot and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

For an overview of IAM and its features, see [Understanding How IAM Works](https://docs.aws.amazon.com/IAM/latest/UserGuide/intro-structure.html) in the *IAM User Guide*\.

**Topics**
+ [Identity\-based policies and AWS Chatbot](#identity-based-policies-use-in-chatbot)
+ [Resource\-level permissions and AWS Chatbot](#resource-based-policies-use-in-chatbot)
+ [Condition keys and AWS Chatbot](#security_iam_service-with-iam-id-based-policies-conditionkeys)
+ [Authorization based on AWS Chatbot tags](#security_iam_service-with-iam-tags)
+ [Using temporary credentials with AWS Chatbot](#security_iam_service-with-iam-roles-tempcreds)
+ [Service\-linked roles](#security_iam_service-with-iam-roles-service-linked)
+ [Service roles](#security_iam_service-with-iam-roles-service)
+ [Other policy types](#security-iam-other-policies)
+ [Troubleshooting AWS Chatbot identity and access](security_iam_troubleshoot.md)

### Identity\-based policies and AWS Chatbot<a name="identity-based-policies-use-in-chatbot"></a>

AWS Chatbot supports the use of IAM identity\-based policies for service usage and management\.

An AWS Identity and Access Management \(IAM\) *policy* is a document that defines the permissions that apply to an IAM user, group, or role\. The permissions determine what users can do in AWS\. A policy typically allows access to specific actions, and can optionally grant that the actions are allowed for specific resources, like Amazon Simple Notification Service \(Amazon SNS\) notifications\. Policies can also explicitly deny access\. 

*Identity\-based policies* are attached to an IAM user, group, or role \(identity\)\. These policies let you specify what that AWS identity can do \(its permissions\)\. For example, you can attach an identity policy to the IAM user named adesai, to allow that user to perform the AWS Chatbot `DescribeSlackChannels` action\. 

For information about, and examples of, using identity\-based policies with AWS Chatbot, see [AWS Chatbot Identity\-Based Policies](security_iam_service-with-iam-id-based-policies.md)\.

For more general information about how IAM identity\-based policies work, see [Identity vs\. Resource](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html) in the *IAM User Guide*\.

### Resource\-level permissions and AWS Chatbot<a name="resource-based-policies-use-in-chatbot"></a>

*Resource\-level permissions* are JSON policy statements that specify the AWS resources on which associated IAM entities can perform actions\. ** You define a resource\-level permission in an IAM policy, then attach the policy to a user's AWS account or to any other IAM entity\. The users then have permission to access that resource\. Resource\-level permissions differ from IAM* resource\-based policies* because you attach complete resource\-based policies directly to an AWS resource\.

When you customize IAM policies for users to work with the AWS Chatbot service, one of your primary options for policy editing is to configure resource\-based permissions for your policies\. 

AWS Chatbot supports resource\-level permissions, but not resource\-based policies\. 

For more information about how IAM resource\-level permissions work with AWS Chatbot, see [IAM Resource\-Level Permissions for AWS Chatbot](security_iam_service-with-iam-resource-based-policies.md)\.

### Condition keys and AWS Chatbot<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

AWS Chatbot doesn't define any service\-specific condition keys\. It supports global condition keys\. To see all actions and resources for which AWS Chatbot can use global condition keys, see [Actions, Resources, and Condition Keys for AWS Chatbot](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awschatbot.html#awschatbot-policy-keys) in the *IAM User Guide*\. For more information about AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Authorization based on AWS Chatbot tags<a name="security_iam_service-with-iam-tags"></a>

AWS Chatbot doesn't support tagging resources or controlling access based on tags\.

### Using temporary credentials with AWS Chatbot<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or assume a cross\-account role\. You obtain temporary security credentials by calling AWS Security Token Service \(AWS STS\) API operations, such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS Chatbot supports using temporary credentials\. For more information about defining and using temporary IAM credentials, see [Temporary Security Credentials](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp.html) in the *IAM User Guide*\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view, but can't edit the permissions for service\-linked roles\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

AWS Chatbot supports service roles\. 

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might prevent the service from functioning as expected\.

### Other policy types<a name="security-iam-other-policies"></a>

AWS supports additional, less common policy types\. These policy types can set the maximum permissions granted to you by the more common policy types\. 
+ **AWS Organizations service control policies \(SCPs\)** \- SCPs are JSON policies that specify the maximum permissions for an organization or organizational unit \(OU\) in AWS Organizations\. AWS Organizations is a service for grouping and centrally managing multiple AWS accounts that your business owns\. If you enable all features in an organization, then you can apply service control policies \(SCPs\) to any or all of your accounts\. The SCP limits permissions for entities in member accounts, including each AWS account root user\. For more information about Organizations and SCPs, see [How SCPs Work](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_about-scps.html) in the *AWS Organizations User Guide*\.
+ **IAM account settings** \- With IAM, you can use AWS Security Token Service \(AWS STS\) to create and provide trusted users with temporary security credentials that can control access to your AWS resources\. When you activate STS endpoints for a Region, AWS STS can issue temporary credentials to users and roles in your account that make an AWS STS request\. Those credentials can then be used in any Region that is enabled by default or is manually enabled\. You must activate the Region in the account where the temporary credentials are generated\. It does not matter whether a user is signed into the same account or a different account when they make the request\. For more information, see [Activating and deactivating AWS STS in an AWS Region](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_enable-regions.html#sts-regions-activate-deactivate) in the *IAM User Guide*\.

**Note**  
AWS Chatbot is a global service that requires access to all AWS Regions\. If there is a policy in place that prevents access to services in certain Regions, you must change the policy to allow global AWS Chatbot access\.