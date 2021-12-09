# How AWS Health works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to AWS Health, you should understand what IAM features are available to use with AWS Health\. To get a high\-level view of how AWS Health and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [AWS Health identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [AWS Health resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization based on AWS Health tags](#security_iam_service-with-iam-tags)
+ [AWS Health IAM roles](#security_iam_service-with-iam-roles)

## AWS Health identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. AWS Health supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in AWS Health use the following prefix before the action: `health:`\. For example, to grant someone permission to view detailed information about specified events with the [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) API operation, you include the `heath:DescribeEventDetails` action in the policy\. 

Policy statements must include an `Action` or `NotAction` element\. AWS Health defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
      "health:action1",
      "health:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "health:Describe*"
```



To see a list of AWS Health actions, see [Actions Defined by AWS Health](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



An AWS Health event has the following Amazon Resource Name \(ARN\) format\.

```
arn:${Partition}:health:*::event/service/event-type-code/event-ID
```

For example, to specify the `EC2_INSTANCE_RETIREMENT_SCHEDULED_ABC123-DEF456` event in your statement, use the following ARN\.

```
"Resource": "arn:aws:health:*::event/EC2/EC2_INSTANCE_RETIREMENT_SCHEDULED/EC2_INSTANCE_RETIREMENT_SCHEDULED_ABC123-DEF456"
```

To specify all AWS Health events for Amazon EC2 that belong to a specific account, use the wildcard \(\*\)\.

```
"Resource": "arn:aws:health:*::event/EC2/*/*"
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

Some AWS Health actions can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

AWS Health API operations can involve multiple resources\. For example, the [DescribeEvents](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEvents.html) operation returns information about events that meet a specified filter criteria\. This means that an IAM user must have permissions to view this event\. 

To specify multiple resources in a single statement, separate the ARNs with commas\. 

```
"Resource": [
      "resource1",
      "resource2"
```

AWS Health supports only resource\-level permissions for health events and only for the [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) API operations\. For more information, see [Resource\- and action\-based conditions](security_iam_id-based-policy-examples.md#resource-action-based-conditions)\.

To see a list of AWS Health resource types and their ARNs, see [Resources Defined by AWS Health](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS Health](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-actions-as-permissions)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can create conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

AWS Health defines its own set of condition keys and also supports using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.



The [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) API operations support the `health:eventTypeCode` and `health:service` condition keys\.

To see a list of AWS Health condition keys, see [Condition Keys for AWS Health](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-policy-keys) in the *IAM User Guide*\. To learn with which actions and resources you can use a condition key, see [Actions Defined by AWS Health](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awshealthapisandnotifications.html#awshealthapisandnotifications-actions-as-permissions)\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of AWS Health identity\-based policies, see [AWS Health identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## AWS Health resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Resource\-based policies are JSON policy documents that specify what actions a specified principal can perform on the AWS Health resource and under what conditions\. AWS Health supports resource\-based permissions policies for health events\. Resource\-based policies let you grant usage permission to other accounts on a per\-resource basis\. You can also use a resource\-based policy to allow an AWS service to access your AWS Health events\.

To enable cross\-account access, you can specify an entire account or IAM entities in another account as the [principal in a resource\-based policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html)\. Adding a cross\-account principal to a resource\-based policy is only half of establishing the trust relationship\. When the principal and the resource are in different AWS accounts, you must also grant the principal entity permission to access the resource\. Grant permission by attaching an identity\-based policy to the entity\. However, if a resource\-based policy grants access to a principal in the same account, no additional identity\-based policy is required\. For more information, see [How IAM Roles Differ from Resource\-based Policies ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_compare-resource-policies.html)in the *IAM User Guide*\.

AWS Health supports only resource\-based policies for the [DescribeAffectedEntities](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeAffectedEntities.html) and [DescribeEventDetails](https://docs.aws.amazon.com/health/latest/APIReference/API_DescribeEventDetails.html) API operations\. You can specify these actions in a policy to define which principal entities \(accounts, users, roles, and federated users\) can perform actions on the AWS Health event\.

### Examples<a name="security_iam_service-with-iam-resource-based-policies-examples"></a>



To view examples of AWS Health resource\-based policies, see [Resource\- and action\-based conditions](security_iam_id-based-policy-examples.md#resource-action-based-conditions)\.

## Authorization based on AWS Health tags<a name="security_iam_service-with-iam-tags"></a>

AWS Health doesn't support tagging resources or controlling access based on tags\.

## AWS Health IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with AWS Health<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS Health supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

AWS Health supports service\-linked roles to integrate with AWS Organizations\. The role is named [Health\_OrganizationsServiceRolePolicy](https://console.aws.amazon.com/iam/home?#/policies/arn:aws:iam::aws:policy/aws-service-role/Health_OrganizationsServiceRolePolicy), which allows AWS Health to access health events from other AWS accounts in the organization\.

You can use the [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) operation to create the service\-linked role in the account\. However, if you want to disable this feature, you must first call the [DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) operation\. You can then delete the role through the IAM console, IAM API, or AWS Command Line Interface \(AWS CLI\)\. For more information, see [Using service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.

For more information, see [Aggregating AWS Health events across accounts with organizational view](aggregate-events.md)\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS Health doesn't support service roles\. 