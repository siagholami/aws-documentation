# How AWS Elemental MediaStore works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to MediaStore, you should understand what IAM features are available to use with MediaStore\. To get a high\-level view of how MediaStore and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

## MediaStore identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. MediaStore supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in MediaStore use the following prefix before the action: `mediastore:`\. For example, to grant someone permission to create a new container with the MediaStore `CreateContainer` API operation, you include the `mediastore:CreateContainer` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. MediaStore defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "mediastore:action1",
      "mediastore:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "mediastore:Describe*"
```

To see a list of MediaStore actions, see [Actions Defined by AWS Elemental MediaStore](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediastore.html#awselementalmediastore-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

The MediaStore container resource has the following ARN:

```
arn:${Partition}:mediastore:${Region}:${Account}:container/${containerName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `AwardsShow` container in your statement, use the following ARN:

```
"Resource": "arn:aws:mediastore:us-east-1:111122223333:container/AwardsShow"
```

To specify all instances that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:mediastore:us-east-1:111122223333:container/*"
```

Some MediaStore actions, such as those for creating resources, can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\):

```
"Resource": "*"
```

To see a list of MediaStore resource types and their ARNs, see [Resources Defined by AWS Elemental MediaStore](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediastore.html#awselementalmediastore-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS Elemental MediaStore](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediastore.html#awselementalmediastore-actions-as-permissions)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

MediaStore does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>

For examples of MediaStore identity\-based policies, see [AWS Elemental MediaStore Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## MediaStore Resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Resource\-based policies are JSON policy documents that specify what actions a specified principal can perform on the MediaStore resource and under what conditions\. MediaStore supports resource\-based permissions policies for MediaStore containers\. Resource\-based policies let you grant usage permission to other accounts on a per\-resource basis\. You can also use a resource\-based policy to allow an AWS service to access your MediaStore containers\.

To enable cross\-account access, you can specify an entire account or IAM entities in another account as the [principal in a resource\-based policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html)\. Adding a cross\-account principal to a resource\-based policy is only half of establishing the trust relationship\. When the principal and the resource are in different AWS accounts, you must also grant the principal entity permission to access the resource\. Grant permission by attaching an identity\-based policy to the entity\. However, if a resource\-based policy grants access to a principal in the same account, no additional identity\-based policy is required\. For more information, see [How IAM Roles Differ from Resource\-based Policies ](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_compare-resource-policies.html)in the *IAM User Guide*\.

The MediaStore service supports only one type of resource\-based policy called a container policy, which is attached to a container\. This policy defines which principal entities \(accounts, users, roles, and federated users\) can perform actions on the container\.

To learn how to attach a resource\-based policy to a container, see [Container policies in AWS Elemental MediaStore](policies.md)\.

### Examples<a name="security_iam_service-with-iam-resource-based-policies-examples"></a>

For examples of MediaStore resource\-based policies, see [Example container policies](policies-examples.md),

## Authorization based on MediaStore tags<a name="security_iam_service-with-iam-tags"></a>

MediaStore doesn't support tagging resources or controlling access based on tags\.

## MediaStore IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with MediaStore<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

MediaStore supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

MediaStore does not support service\-linked roles\. 

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

MediaStore supports service roles\. 