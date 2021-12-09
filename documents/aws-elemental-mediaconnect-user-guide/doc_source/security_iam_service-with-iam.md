# How AWS Elemental MediaConnect works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to MediaConnect, you should understand what IAM features are available to use with MediaConnect\. To get a high\-level view of how MediaConnect and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [MediaConnect identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [MediaConnect resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization based on MediaConnect tags](#security_iam_service-with-iam-tags)
+ [MediaConnect IAM roles](#security_iam_service-with-iam-roles)

## MediaConnect identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. MediaConnect supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in MediaConnect use the following prefix before the action: `mediaconnect:`\. For example, to grant someone permission to view a list of entitlements with the MediaConnect `ListEntitlements` API operation, you include the `mediaconnect:ListEntitlements` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. MediaConnect defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "mediaconnect:action1",
      "mediaconnect:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `List`, include the following action:

```
"Action": "mediaconnect:List*"
```

To see a list of MediaConnect actions, see [Actions Defined by AWS Elemental MediaConnect](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediaconnect.html#awselementalmediaconnect-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

MediaConnect has the following ARNs:

```
arn:${Partition}:mediaconnect:${Region}:${Account}:entitlement:${resourceID}:${resourceName}
arn:${Partition}:mediaconnect:${Region}:${Account}:flow:${resourceID}:${resourceName}
arn:${Partition}:mediaconnect:${Region}:${Account}:output:${resourceID}:${resourceName}
arn:${Partition}:mediaconnect:${Region}:${Account}:source:${resourceID}:${resourceName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `1-23aBC45dEF67hiJ8-12AbC34DE5fG` flow in your statement, use the following ARN:

```
"Resource": "arn:aws:mediaconnect:us-east-1:111122223333:flow:1-23aBC45dEF67hiJ8-12AbC34DE5fG:BasketballGame"
```

To specify all flows that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:mediaconnect:us-east-1:111122223333:flow:*"
```

Some MediaConnect actions, such as those for creating resources, can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

Many MediaConnect API actions involve multiple resources\. For example, `RemoveFlowOutput` removes an output from a particular flow, so an IAM user must have permissions for the flow and the output\. To specify multiple resources in a single statement, separate the ARNs with commas\. 

```
"Resource": [
      "resource1",
      "resource2"
```

To see a list of MediaConnect resource types and their ARNs, see [Resources Defined by AWS Elemental MediaConnect](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awskeymanagementservice.html#list_awselementalmediaconnect.html#awselementalmediaconnect-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS Elemental MediaConnect](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediaconnect.html#awselementalmediaconnect-actions-as-permissions)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

MediaConnect doesn't provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\. 

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of MediaConnect identity\-based policies, see [AWS Elemental MediaConnect identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## MediaConnect resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

AWS Elemental MediaConnect does not support resource\-based policies\.

## Authorization based on MediaConnect tags<a name="security_iam_service-with-iam-tags"></a>

AWS Elemental MediaConnect does not support tagging resources or controlling access based on tags\.

## MediaConnect IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with MediaConnect<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

MediaConnect supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

MediaConnect does not support service\-linked roles\. 

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

MediaConnect does not support service roles\. 