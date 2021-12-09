# How AWS Elemental MediaPackage Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to MediaPackage, you should understand what IAM features are available to use with MediaPackage\. To get a high\-level view of how MediaPackage and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [MediaPackage Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [MediaPackage Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization Based on MediaPackage Tags](#security_iam_service-with-iam-tags)
+ [MediaPackage IAM Roles](#security_iam_service-with-iam-roles)

## MediaPackage Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. MediaPackage supports specific actions, resources, and condition keys\. To learn about all the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in MediaPackage use the following prefix before the action: `mediapackage:`\. For example, to grant someone permission to delete a MediaPackage endpoint with the MediaPackage `DeleteOriginEndpoint` API operation, you include the `mediapackage:DeleteOriginEndpoint` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. MediaPackage defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "mediapackage:action1",
      "mediapackage:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "mediapackage:Describe*"
```

For a list of MediaPackage actions, see [Actions Defined by AWS Elemental MediaPackage](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediapackage.html#awselementalmediapackage-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.

MediaPackage has the following resource ARNs:

```
arn:${Partition}:mediapackage:${Region}:${Account}:channels/${channelID}
arn:${Partition}:mediapackage:${Region}:${Account}:origin_endpoints/${endpointID}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the `9a6b3953e242400eb805f324d95788e3` channel in your statement, use the following ARN:

```
"Resource": "arn:aws:mediapackage:us-east-1:111122223333:channels/9a6b3953e242400eb805f324d95788e3"
```

To specify all instances that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:mediapackage:us-east-1:111122223333:channels/*"
```

Some MediaPackage actions, such as those for creating resources, can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To see a list of MediaPackage resource types and their ARNs, see [Resources Defined by AWS Elemental MediaPackage](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediapackage.html#awselementalmediapackage-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS Elemental MediaPackage](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awselementalmediapackage.html#awselementalmediapackage-actions-as-permissions)\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

MediaPackage doesn't provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>

For examples of MediaPackage identity\-based policies, see [AWS Elemental MediaPackage Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## MediaPackage Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

MediaPackage doesn't support resource\-based policies\.

## Authorization Based on MediaPackage Tags<a name="security_iam_service-with-iam-tags"></a>

You can attach tags to MediaPackage resources or pass tags in a request to MediaPackage\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `mediapackage:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. For more information about tagging MediaPackage resources, see [Tagging AWS Elemental MediaPackage Resources](tagging.md)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing MediaPackage Channels Based on Tags](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-view-channel-tags)\.

## MediaPackage IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with MediaPackage<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

MediaPackage supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

MediaPackage does not support service\-linked roles\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

MediaPackage supports service roles\. 

### Choosing an IAM Role in MediaPackage<a name="security_iam_service-with-iam-roles-choose"></a>

When you create an asset resource in MediaPackage, you must choose a role to allow MediaPackage to access Amazon S3 on your behalf\. If you previously created a service role or service\-linked role, MediaPackage provides you with a list of roles to choose from\. It's important to choose a role that allows access to read from the S3 bucket and retrieve content\. For more information, see [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.