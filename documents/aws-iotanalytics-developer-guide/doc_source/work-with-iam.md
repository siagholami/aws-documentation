# How AWS IoT Analytics works with IAM<a name="work-with-iam"></a>

Before your use IAM to manage access to AWS IoT Analytics, you should understand what IAM features are available to use with AWS IoT Analytics\. To get a high\-level view of how AWS IoT Analytics and other AWS services work with IAM, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [AWS IoT Analytics identity\-based policies](#iam-id-based-policies)
+ [AWS IoT Analytics resource\-based policies](#iam-resource-based-policies)
+ [Authorization based on AWS IoT Analytics tags](#iam-tags)
+ [AWS IoT Analytics IAM roles](#iam-roles)

## AWS IoT Analytics identity\-based policies<a name="iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources and the conditions under which actions are allowed or denied\. AWS IoT Analytics supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON policy elements reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The actions is used in a policy to grant permissions to perform the associated operation\.

Policy action in AWS IoT Analytics use the following prefix before the action: `iotanalytics:` For example, to grant someone permission to create an AWS IoT Analytics channel with the AWS IoT Analytics `CreateChannel` API operation, you include the `iotanalytics:BatchPuMessage` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. AWS IoT Analytics defines its own set of actions that describe tasks that you can perform with this service\.

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

To see a list of AWS IoT Analytics actions, see [Actions defined by AWS IoT Analytics](https://docs.aws.amazon.com/iotanalytics/latest/userguide/list_awsiotanalytics.html#awsiotanalytics-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

The AWS IoT Analytics dataset resource has the following ARN\. 

```
arn:${Partition}:iotanalytics:${Region}:${Account}:dataset/${DatasetName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS service namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

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

Some AWS IoT Analytics API actions involve multiple resources\. For example, `CreatePipeline` references as a channel and a dataset, so an IAM user must have permissions to use the channel and the dataset\. To specify multiple resources in a single statement, separate the ARNs with commas\.

```
"Resource": [
    "resource1",
    "resource2"
```

To see a list of AWS IoT Analytics resource types and their ARNs, see [ Resources defined by AWS IoT Analytics](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotanalytics.html#awsiotanalytics-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions defined by AWS IoT Analytics](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotanalytics.html#awsiotanalytics-actions-as-permissions)\.

### Condition keys<a name="id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\.

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM policy elements: Variables and tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\.

AWS IoT Analytics does not provide any sevice\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS global condition context keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html)\. in the *IAM User Guide*\.

### Examples<a name="iam-id-based-policies-examples"></a>

To view examples of AWS IoT Analytics identity\-based policies, see [Examples](#iam-id-based-policies-examples)\.

## AWS IoT Analytics resource\-based policies<a name="iam-resource-based-policies"></a>

AWS IoT Analytics does not support resource\-based policies\. To view an example of a detailed resource\-based policy page, see [https://docs\.aws\.amazon\.com/lambda/latest/dg/access\-control\-resource\-based\.html](https://docs.aws.amazon.com/lambda/latest/dg/access-control-resource-based.html)\.

## Authorization based on AWS IoT Analytics tags<a name="iam-tags"></a>

You can attach tags to AWS IoT Analytics resources or pass tags in a request to AWS IoT Analytics\. To control access based on tags, your provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `iotanalytics:ResourceTag/{key-name}, aws:RequestTag/{key-name}` or `aws:TagKeys`condition keys\. For more information about tagging AWS IoT Analytics resources, see [Tagging your AWS IoT Analytics resources](https://docs.aws.amazon.com/iotanalytics/latest/userguide/tagging.html#aws-iot-analytics-tagging)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing AWS IoT Analytics channels based on tags](https://docs.aws.amazon.com/iotanalytics/latest/userguide/security.html#security-iam-id-based-policy-examples-view-input-tags)\.

## AWS IoT Analytics IAM roles<a name="iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credential with AWS IoT Analytics<a name="iam-assume-roles"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS Security Token Service \(AWS STS\) API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\.

AWS IoT Analytics does not support using temporary credentials\.

### Service\-linked roles<a name="iam-service-linked-roles"></a>

[Service\-lined roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS service to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

AWS IoT Analytics does not support service\-linked roles\.

### Service roles<a name="iam-service-roles"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS IoT Analytics supports service roles\.