# How AWS IoT SiteWise works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to AWS IoT SiteWise, you should understand what IAM features are available to use with AWS IoT SiteWise\.


|  IAM feature  |  Supported by AWS IoT SiteWise?  | 
| --- | --- | 
|  [Identity\-based policies with resource\-level permissions](#security_iam_service-with-iam-id-based-policies)  | Yes | 
|  [Resource\-based policies](#security_iam_service-with-iam-resource-based-policies)  | No | 
|  [Access control lists \(ACLs\)](#security_iam_service-with-iam-acls)  | No | 
|  [Tags\-based authorization](#security_iam_service-with-iam-tags)  | Yes | 
|  [Temporary credentials](#security_iam_service-with-iam-roles-tempcreds)  | Yes | 
|  [Service\-linked roles](#security_iam_service-with-iam-roles-service-linked)  | Yes | 
|  [Service roles](#security_iam_service-with-iam-roles-service-linked)  | Yes | 

To get a high\-level view of how AWS IoT SiteWise and other AWS services work with IAM, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Contents**
+ [AWS IoT SiteWise identity\-based policies](#security_iam_service-with-iam-id-based-policies)
  + [Actions](#security_iam_service-with-iam-id-based-policies-actions)
    + [BatchPutAssetPropertyValue authorization](#security_iam_service-with-iam-id-based-policies-batchputassetpropertyvalue-action)
  + [Resources](#security_iam_service-with-iam-id-based-policies-resources)
  + [Condition keys](#security_iam_service-with-iam-id-based-policies-conditionkeys)
  + [Examples](#security_iam_service-with-iam-id-based-policies-examples)
+ [AWS IoT SiteWise resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Access control lists \(ACLs\)](#security_iam_service-with-iam-acls)
+ [Authorization based on AWS IoT SiteWise tags](#security_iam_service-with-iam-tags)
+ [AWS IoT SiteWise IAM roles](#security_iam_service-with-iam-roles)
  + [Using temporary credentials with AWS IoT SiteWise](#security_iam_service-with-iam-roles-tempcreds)
  + [Service\-linked roles](#security_iam_service-with-iam-roles-service-linked)
  + [Service roles](#security_iam_service-with-iam-roles-service)
  + [Choosing an IAM role in AWS IoT SiteWise](#security_iam_service-with-iam-roles-choose)

## AWS IoT SiteWise identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. AWS IoT SiteWise supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON policy elements reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in AWS IoT SiteWise use the following prefix before the action: `iotsitewise:`\. For example, to grant someone permission to upload asset property data to AWS IoT SiteWise with the `BatchPutAssetPropertyValue` API operation, you include the `iotsitewise:BatchPutAssetPropertyValue` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. AWS IoT SiteWise defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
  "iotsitewise:action1",
  "iotsitewise:action2"
]
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "iotsitewise:Describe*"
```



To see a list of AWS IoT SiteWise actions, see [Actions Defined by AWS IoT SiteWise](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotsitewise.html#awsiotsitewise-actions-as-permissions) in the *IAM User Guide*\.

#### BatchPutAssetPropertyValue authorization<a name="security_iam_service-with-iam-id-based-policies-batchputassetpropertyvalue-action"></a>

AWS IoT SiteWise authorizes access to the [BatchPutAssetPropertyValue](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_BatchPutAssetPropertyValue.html) action in an unusual way\. For most actions, when you allow or deny access to an action, that action returns an error if permissions aren't granted\. When you use `BatchPutAssetPropertyValue`, you can send multiple data entries to different assets and asset properties in a single API request, and AWS IoT SiteWise authorizes each data entry independently\. For any individual entry that fails authorization in the request, AWS IoT SiteWise includes an `AccessDeniedException` in the returned list of errors\. AWS IoT SiteWise receives the data for any entry that authorizes and succeeds, even if another entry in the same request fails\.

**Important**  
If one entry is denied permissions, all entries for the same asset are also denied\. For example, consider a scenario where you allow access to a property `Property1` for any asset using the `propertyId` condition key\. If you send a `BatchPutAssetPropertyValue` request that contains entries for `Asset1.Property1`, `Asset1.Property2`, `Asset2.Property1`, and `Asset3.Property3`, then the only entry that succeeds is `Asset2.Property1`\. If you send those entries in separate `BatchPutAssetPropertyValue` requests, then `Asset1.Property1` and `Asset2.Property1` succeed\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



Each IAM policy statement applies to the resources that you specify using their ARNs\. An ARN has the following general syntax\.

```
arn:${Partition}:${Service}:${Region}:${Account}:${ResourceType}/${ResourcePath}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS service namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the asset with ID `a1b2c3d4-5678-90ab-cdef-22222EXAMPLE` in your statement, use the following ARN\.;

```
"Resource": "arn:aws:iotsitewise:region:123456789012:asset/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE"
```

To specify all assets that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:iotsitewise:region:123456789012:asset/*"
```

Some AWS IoT SiteWise actions, such as those for creating resources, can't be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To specify multiple resources in a single statement, separate the ARNs with commas\. 

```
"Resource": [
  "resource1",
  "resource2"
]
```

To see a list of AWS IoT SiteWise resource types and their ARNs, see [Resources Defined by AWS IoT SiteWise](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotsitewise.html#awsiotsitewise-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by AWS IoT SiteWise](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotsitewise.html#awsiotsitewise-actions-as-permissions)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can create conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

**Important**  
Many condition keys are specific to a resource, and some API actions use multiple resources\. If you write a policy statement with a condition key, use the `Resource` element of the statement to specify the resource to which the condition key applies\. If you don't do so, the policy might prevent users from performing the action at all, because the condition check fails for the resources to which the condition key doesn't apply\. If you don't want to specify a resource, or if you've written the `Action` element of your policy to include multiple API actions, then you must use the `...IfExists` condition type to ensure that the condition key is ignored for resources that don't use it\. For more information, see [\.\.\.IfExists conditions](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#Conditions_IfExists) in the *IAM User Guide*\.

AWS IoT SiteWise defines its own set of condition keys and also supports using some global condition keys\. To see all AWS global condition keys, see [AWS global condition context keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.


**AWS IoT SiteWise condition keys**  

| Condition key | Description | Types | 
| --- | --- | --- | 
| iotsitewise:assetHierarchyPath |  The asset's hierarchy path, which is a string of asset IDs each separated by a forward slash\. Use this condition key to define permissions based on a subset of your hierarchy of all assets in your account\. Example value: `/a1b2c3d4-5678-90ab-cdef-22222EXAMPLE/a1b2c3d4-5678-90ab-cdef-66666EXAMPLE`  | String | 
| iotsitewise:propertyId |  The ID of an asset property\. Use this condition key to define permissions based on a specified property of an asset model\. This condition key applies to all assets of that model\. Example value: `a1b2c3d4-5678-90ab-cdef-33333EXAMPLE`  | String | 
| iotsitewise:childAssetId |  The ID of an asset being associated as a child to another asset\. Use this condition key to define permissions based on child assets\. To define permissions based on parent assets, use the resource section of a policy statement\. Example value: `a1b2c3d4-5678-90ab-cdef-66666EXAMPLE`  | String | 
| iotsitewise:group |  The ID of an AWS SSO group when listing access policies\. Use this condition key to define access policy permissions for an AWS SSO group\. Example value: `a1b2c3d4e5-a1b2c3d4-5678-90ab-cdef-bbbbbEXAMPLE`  | String, Null | 
| iotsitewise:user |  The ID of an AWS SSO user when listing access policies\. Use this condition key to define access policy permissions for an AWS SSO user\. Example value: `a1b2c3d4e5-a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE`  | String, Null | 
| iotsitewise:portal |  The ID of a portal in an access policy\. Use this condition key to define access policy permissions based on a portal\. Example value: `a1b2c3d4-5678-90ab-cdef-77777EXAMPLE`  | String, Null | 
| iotsitewise:project |  The ID of a project in an access policy, or the ID of a project for a dashboard\. Use this condition key to define dashboard or access policy permissions based on a project\. Example value: `a1b2c3d4-5678-90ab-cdef-88888EXAMPLE`  | String, Null | 



To learn with which actions and resources you can use a condition key, see [Actions Defined by AWS IoT SiteWise](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsiotsitewise.html#awsiotsitewise-actions-as-permissions)\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of AWS IoT SiteWise identity\-based policies, see [AWS IoT SiteWise identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## AWS IoT SiteWise resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

AWS IoT SiteWise doesn't support [resource\-based policies](security-iam.md#security_iam_access-manage-resource-based-policies)\.

## Access control lists \(ACLs\)<a name="security_iam_service-with-iam-acls"></a>

AWS IoT SiteWise doesn't support [ACLs](security-iam.md#security_iam_access-manage-acl)\.

## Authorization based on AWS IoT SiteWise tags<a name="security_iam_service-with-iam-tags"></a>

You can attach tags to AWS IoT SiteWise resources or pass tags in a request to AWS IoT SiteWise\. To control access based on tags, you provide tag information in the [condition element](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) of a policy using the `iotsitewise:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\. For more information about tagging AWS IoT SiteWise resources, see [Tagging your AWS IoT SiteWise resources](tag-resources.md)\.

To view an example identity\-based policy for limiting access to a resource based on the tags on that resource, see [Viewing AWS IoT SiteWise assets based on tags](security_iam_id-based-policy-examples.md#security_iam_id-based-policy-examples-view-asset-tags)\.

## AWS IoT SiteWise IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with AWS IoT SiteWise<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS IoT SiteWise supports using temporary credentials\.

SiteWise Monitor supports federated users to access portals\. When a user signs in to a portal, SiteWise Monitor generates a session policy that provides the following permissions:
+ Read\-only access to the assets and asset data in AWS IoT SiteWise in your account to which that portal's role provides access\.
+ Access to projects in that portal to which the user has administrator \(project owner\) or read\-only \(project viewer\) access\.

For more information about federated portal user permissions, see [Using service\-linked roles for AWS IoT SiteWise](using-service-linked-roles.md)\.

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

AWS IoT SiteWise supports service\-linked roles\. For details about creating or managing AWS IoT SiteWise service\-linked roles, see [Using service\-linked roles for AWS IoT SiteWise](using-service-linked-roles.md)\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

AWS IoT SiteWise uses a service role to allow SiteWise Monitor portal users to access some of your AWS IoT SiteWise resources on your behalf\. For more information, see [Using service roles for AWS IoT SiteWise Monitor](monitor-service-role.md)\.

### Choosing an IAM role in AWS IoT SiteWise<a name="security_iam_service-with-iam-roles-choose"></a>

When you create a `portal` resource in AWS IoT SiteWise, you must choose a role to allow the federated users of your SiteWise Monitor portal to access AWS IoT SiteWise on your behalf\. If you have previously created a service role, then AWS IoT SiteWise provides you with a list of roles to choose from\. Otherwise, you can create a role with the required permissions when you create a portal\. It's important to choose a role that allows access to your assets and asset data\. For more information, see [Using service roles for AWS IoT SiteWise Monitor](monitor-service-role.md)\.