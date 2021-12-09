--------

--------

# How AWS IoT Things Graph Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to AWS IoT Things Graph, you should understand what IAM features are available to use with AWS IoT Things Graph\. To get a high\-level view of how AWS IoT Things Graph and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [AWS IoT Things Graph Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [AWS IoT Things Graph Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Access Control Lists](#security_iam_service-with-iam-acls)
+ [Authorization Based on AWS IoT Things Graph Tags](#security_iam_service-with-iam-tags)
+ [AWS IoT Things Graph IAM Roles](#security_iam_service-with-iam-roles)

## AWS IoT Things Graph Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. AWS IoT Things Graph supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

The AWS IoT Things Graph control plane uses IAM policies to define what a user can do\. You can create policies that assign permissions for all actions in the [AWS IoT Things Graph API Reference](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_Operations.html)\. 

For example, the following policy assigns permission for a user to use the [CreateSystemInstance](https://docs.aws.amazon.com/thingsgraph/latest/APIReference/API_CreateSystemInstance.html) API\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iotthingsgraph:CreateSystemInstance"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

The following policy gives permission to perform all actions\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "iotthingsgraph:*"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

Policy actions in AWS IoT Things Graph use the following prefix before the action: `iotthingsgraph:`\. For example, to grant someone permission to upload iotthingsgraph entities with the AWS IoT Things Graph `UploadEntityDefinitions` API operation, you include the `iotthingsgraph:UploadEntityDefinitions` action in the policy\. Policy statements must include an `Action` or `NotAction` element\. AWS IoT Things Graph defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
      "iotthingsgraph:action1",
      "iotthingsgraph:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Create`, include the following action\.

```
"Action": "iotthingsgraph:Create*"
```



To see a list of AWS IoT Things Graph actions, see [Actions Defined by AWS IoT Things Graph](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotthingsgraph#awsiotthingsgraph-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



The AWS IoT Things Graph workflow \(flow\) instance resource has the following ARN\.

```
arn:${Partition}:iotthingsgraph:${Region}:${Account}:workflow/${WorkflowName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\)](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) in the *AWS General Reference*\.

For example, to specify the `SecurityFlow` flow in your statement, use the following ARN\.

```
"Resource": "arn:aws:iotthingsgraph:us-east-1:123456789012:workflow/SecurityFlow"
```

To specify all flows that belong to a specific account, use the wildcard \(\*\)\.

```
"Resource": "arn:aws:iotthingsgraph:us-east-1:123456789012:workflow/*"
```

Some AWS IoT Things Graph actions, such as those for creating resources, can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To specify multiple resources in a single statement, separate the ARNs with commas\. 

```
"Resource": [
      "resource1",
      "resource2"
```

To see a list of AWS IoT Things Graph resource types and their ARNs, see [Resources Defined by AWS IoT Things Graph](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotthingsgraph.html#awsiotthingsgraph-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS IoT Things Graph](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotthingsgraph#awsiotthingsgraph-actions-as-permissions)\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

AWS IoT Things Graph defines its own set of condition keys and also supports using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.



To see a list of AWS IoT Things Graph condition keys, see [Condition Keys for AWS IoT Things Graph](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotthingsgraph#awsiotthingsgraph-policy-keys) in the *IAM User Guide*\. To learn with which actions and resources you can use a condition key, see [Actions Defined by AWS IoT Things Graph](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotthingsgraph#awsiotthingsgraph-actions-as-permissions)\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of AWS IoT Things Graph identity\-based policies, see [AWS IoT Things Graph Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## AWS IoT Things Graph Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Resource\-based policies are JSON policy documents that specify what actions a specified principal can perform on the AWS IoT Things Graph resource and under what conditions\. AWS IoT Things Graph doesn't support IAM resource\-based policies\.

## Access Control Lists<a name="security_iam_service-with-iam-acls"></a>

Access control lists \(ACLs\) are lists of grantees that you can attach to resources\. AWS IoT Things Graph doesn't support ACLs\.

## Authorization Based on AWS IoT Things Graph Tags<a name="security_iam_service-with-iam-tags"></a>

You can attach tags to AWS IoT Things Graph resources or pass tags in a request to AWS IoT Things Graph\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `iotthingsgraph:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. For more information about tagging AWS IoT Things Graph resources, see [Tagging Your AWS IoT Things Graph Resources](tagging-tg.html)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing AWS IoT Things Graph Flow Configurations Based on Tags](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-view-flow-configurations)\.

## AWS IoT Things Graph IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with AWS IoT Things Graph<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS IoT Things Graph supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. AWS IoT Things Graph doesn't support service\-linked roles\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS IoT Things Graph supports service roles\. 