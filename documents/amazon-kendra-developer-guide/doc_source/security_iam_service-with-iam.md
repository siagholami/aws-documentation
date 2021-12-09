--------

--------

# How Amazon Kendra works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon Kendra, you should understand what IAM features are available to use with Amazon Kendra\. To get a high\-level view of how Amazon Kendra and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Amazon Kendra identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [Amazon Kendra Resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Access control lists \(ACLs\)](#security_iam_service-with-iam-acls)
+ [Authorization based on Amazon Kendra tags](#security_iam_service-with-iam-tags)
+ [Amazon Kendra IAM Roles](#security_iam_service-with-iam-roles)

## Amazon Kendra identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Amazon Kendra supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon Kendra use the following prefix before the action: `kendra:`\. For example, to grant someone permission to list Amazon Kendra indexes with the [ListIndices](API_ListIndices.md) API operation, you include the `kendra:ListIndices` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Amazon Kendra defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "kendra:action1",
      "kendra:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "kendra:Describe*"
```

To see a list of Amazon Kendra actions, see [Actions Defined by Amazon Kendra](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_kendra.html#kendra-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



The Amazon Kendra index resource has the following ARN:

```
arn:${Partition}:kendra:${Region}:${Account}:index/${IndexId}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify an index in your statement, use the GUID of the index in the following ARN:

```
"Resource": "arn:aws:kendra:${Region}:${Account}:index/${GUID}"
```

To specify all indexes that belong to a specific account, use the wildcard \(\*\):

```
"Resource": "arn:aws:${Region}:${Account}:index/*"
```

Some Amazon Kendra actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To see a list of Amazon Kendra resource types and their ARNs, see [Resources Defined by Amazon Kendra](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_kendra.html#kendra-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by Amazon Kendra](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_kendra.html#kendra-actions-as-permissions)\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can create conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

Amazon Kendra does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Amazon Kendra identity\-based policies, see [Amazon Kendra Identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## Amazon Kendra Resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Amazon Kendra does not support resource\-based policies\.

## Access control lists \(ACLs\)<a name="security_iam_service-with-iam-acls"></a>

Amazon Kendra does not support access control lists \(ACLs\) for access to AWS services and resources\.

## Authorization based on Amazon Kendra tags<a name="security_iam_service-with-iam-tags"></a>

You can associate tags with certain types of Amazon Kendra resources to authorize access to those resources\. To control access based on tags, provide tag information in the condition element of a policy by using the `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys\.

The following table lists the actions, corresponding resource types, and condition keys for tag\-based access control\. Each action is authorized based on the tags associated with the corresponding resource type\.


| Action | Resource type | Condition keys | 
| --- | --- | --- | 
| [CreateDataSource](API_CreateDataSource.md) |   | aws:RequestTag, aws:TagKeys | 
| [CreateFaq](API_CreateFaq.md) |   | aws:RequestTag, aws:TagKeys | 
| [CreateIndex](API_CreateIndex.md) |   | aws:RequestTag, aws:TagKeys | 
| [ListTagsForResource](API_ListTagsForResource.md) | data source, FAQ, index |   | 
| [TagResource](API_TagResource.md) | data source, FAQ, index | aws:RequestTag, aws:TagKeys | 
| [UntagResource](API_UntagResource.md) | data source, FAQ, index | aws:TagKeys | 

For information about tagging Amazon Kendra resources, see [Tags](tagging.md)\. For an example identity\-based policy that limits access to a resource based on resource tags, see [Tag\-based policy examples](security_iam_id-based-policy-examples.md#examples-tagging)\. For more information about using tags to limit access to resources, see [Controlling access using tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_tags.html) in the *IAM User Guide*\. 

## Amazon Kendra IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with Amazon Kendra<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon Kendra supports using temporary credentials\. 

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Amazon Kendra supports service roles\. 

### Choosing an IAM role in Amazon Kendra<a name="security_iam_service-with-iam-roles-choose"></a>

When you create an index, call the `BatchPutDocument` operation, create a data source or create an FAQ, you must provide an access role Amazon Resource Name \(ARN\) that Amazon Kendra uses to access the required resources on your behalf\. If you have previously created a role, then the Amazon Kendra console provides you with a list of roles to choose from\. It's important to choose a role that allows access to the resources that you require\. For more information, see [IAM access roles for Amazon Kendra](iam-roles.md)\.