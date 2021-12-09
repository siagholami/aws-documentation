# How Amazon Inspector works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon Inspector, you should understand what IAM features are available to use with Amazon Inspector\. To get a high\-level view of how Amazon Inspector and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Amazon Inspector identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [Amazon Inspector resource\-based policies \(not supported\)](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization based on Amazon Inspector tags \(not supported\)](#security_iam_service-with-iam-tags)
+ [Amazon Inspector IAM roles](#security_iam_service-with-iam-roles)

## Amazon Inspector identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Amazon Inspector supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon Inspector use the following prefix before the action: `inspector:`\. For example, the `inspector:ListFindings` permission allows the user permissions to perform the Amazon Inspector `ListFindings` operation\. Policy statements must include either an `Action` or `NotAction` element\. Amazon Inspector defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "inspector:action1",
      "inspector:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "inspector:Describe*"
```



To see a list of Amazon Inspector actions, see [Actions Defined by Amazon Inspector](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazoninspector.html#amazoninspector-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



Amazon Inspector does not support specifying a resource ARN in the `Resource` element of an IAM policy statement\. To allow access to Amazon Inspector, specify `"Resource": "*"` in your policy\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Amazon Inspector does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS global condition context keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Managed policies for Amazon Inspector<a name="security_iam_service-with-iam-id-based-policies-managed"></a>

Amazon Inspector provides the following AWS managed policies, which you can attach to IAM users in your account\.
+ `AmazonInspectorFullAccess` – Provides full access to Amazon Inspector\.
+ `AmazonInspectorReadOnlyAccess` – Provides read\-only access to Amazon Inspector\. 

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Amazon Inspector identity\-based policies, see [Amazon Inspector identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## Amazon Inspector resource\-based policies \(not supported\)<a name="security_iam_service-with-iam-resource-based-policies"></a>

Amazon Inspector does not support resource\-based policies\.

## Authorization based on Amazon Inspector tags \(not supported\)<a name="security_iam_service-with-iam-tags"></a>

Amazon Inspector does not support tagging resources or controlling access based on tags

## Amazon Inspector IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with Amazon Inspector<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, to assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon Inspector supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Amazon Inspector supports service\-linked roles\. For details about creating or managing Amazon Inspector service\-linked roles, see [Using service\-linked roles for Amazon Inspector](inspector_slr.md)\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Amazon Inspector supports service roles\. 