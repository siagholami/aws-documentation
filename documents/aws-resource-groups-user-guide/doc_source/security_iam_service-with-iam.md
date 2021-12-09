# How Resource Groups Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Resource Groups, you should understand what IAM features are available to use with Resource Groups\. To get a high\-level view of how Resource Groups and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Resource Groups Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies-arg-te)
+ [Resource\-Based Policies](#security_iam_resource-based-policies)
+ [Authorization Based on Resource Groups Tags](#security_iam_tags)
+ [Resource Groups IAM Roles](#security_iam_roles)

## Resource Groups Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies-arg-te"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Resource Groups supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions-arg-te"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Resource Groups use the following prefix before the action: `resource-groups:`\. Tag Editor actions are performed entirely in the console, but have the prefix `resource-explorer` in log entries\.

For example, to grant someone permission to create a Resource Groups group with the Resource Groups `CreateGroup` API operation, you include the `resource-groups:CreateGroup` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Resource Groups defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple Resource Groups and Tag Editor actions in a single statement, separate them with commas as follows:

```
"Action": [
      "resource-groups:action1",
      "resource-groups:action2",
      "resource-explorer:action3"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `List`, include the following action:

```
"Action": "resource-groups:List*"
```

To see a list of Resource Groups actions, see [Actions, Resources, and Condition Keys for AWS Resource Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsresourcegroups.html) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources-arg-te"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



The only Resource Groups resource is a *group*\. The group resource has an ARN in the following format:

```
arn:${Partition}:resource-groups:${Region}:${Account}:group/${GroupName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `my-test-group` resource group in your statement, use the following ARN:

```
"Resource": "arn:aws:resource-groups:us-west-2:123456789012:group/my-test-group"
```

To specify all groups that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:resource-groups:us-west-2:123456789012:group/*"
```

Some Resource Groups actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

Some Resource Groups API actions can involve multiple resources\. For example, `DeleteGroup` deletes groups, so an IAM user must have permissions to delete a specific group or all groups\. To specify multiple resources in a single statement, separate the ARNs with commas\.

```
"Resource": [
      "resource1",
      "resource2"
```

To see a list of Resource Groups resource types and their ARNs, and learn with which actions you can specify the ARN of each resource, see [Actions, Resources, and Condition Keys for AWS Resource Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsresourcegroups.html) in the *IAM User Guide*\.

### Condition Keys<a name="security_iam_id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can create conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

Resource Groups defines its own set of condition keys and also supports using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

To see a list of Resource Groups condition keys, and learn with which actions and resources you can use a condition key, see [Actions, Resources, and Condition Keys for AWS Resource Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsresourcegroups.html) in the *IAM User Guide*\.

### Examples<a name="security_iam-id-based-policies-examples"></a>

To view examples of Resource Groups identity\-based policies, see [AWS Resource Groups Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Resource\-Based Policies<a name="security_iam_resource-based-policies"></a>

Resource Groups does not support resource\-based policies\.

## Authorization Based on Resource Groups Tags<a name="security_iam_tags"></a>

You can attach tags to groups in Resource Groups, or pass tags in a request to Resource Groups\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `aws:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. You can apply tags to a group when you are creating or updating the group\. For more information about tagging a group in Resource Groups, see [Build a query and create a group \(console\)](gettingstarted-query.md#gettingstarted-query-console) and [Update groups in AWS Resource Groups](updating-resource-groups.md) in this guide\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing Groups Based on Tags](security_iam_id-based-policy-examples.md#security_iam_policy-examples-view-tags)\.

## Resource Groups IAM Roles<a name="security_iam_roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\. Resource Groups does not have or use service roles\.

### Using Temporary Credentials with Resource Groups<a name="security_iam_roles-tempcreds"></a>

In Resource Groups, you can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\.

### Service\-Linked Roles<a name="security_iam_roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\.

Resource Groups does not have or use service\-linked roles\.

### Service Roles<a name="security_iam_roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\.

Resource Groups does not have or use service roles\.