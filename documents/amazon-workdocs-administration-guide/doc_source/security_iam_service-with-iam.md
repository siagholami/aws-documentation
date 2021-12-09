# How Amazon WorkDocs works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon WorkDocs, you should understand what IAM features are available to use with Amazon WorkDocs\. To get a high\-level view of how Amazon WorkDocs and other AWS services work with IAM, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Amazon WorkDocs identity\-based policies](#security_iam_service-with-iam-id-based-policies)
+ [Amazon WorkDocs resource\-based policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization based on Amazon WorkDocs tags](#security_iam_service-with-iam-tags)
+ [Amazon WorkDocs IAM roles](#security_iam_service-with-iam-roles)

## Amazon WorkDocs identity\-based policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions\. Amazon WorkDocs supports specific actions\. To learn about the elements that you use in a JSON policy, see [IAM JSON policy elements reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon WorkDocs use the following prefix before the action: `workdocs:`\. For example, to grant someone permission to run the Amazon WorkDocs `DescribeUsers` API operation, you include the `workdocs:DescribeUsers` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Amazon WorkDocs defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "workdocs:DescribeUsers",
      "workdocs:CreateUser"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "workdocs:Describe*"
```



To see a list of Amazon WorkDocs actions, see [Actions defined by Amazon WorkDocs](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazonworkdocs.html#amazonworkdocs-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

Amazon WorkDocs does not support specifying resource ARNs in a policy\.

### Condition keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Amazon WorkDocs does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS global condition context keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Amazon WorkDocs identity\-based policies, see [Amazon WorkDocs identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## Amazon WorkDocs resource\-based policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Amazon WorkDocs does not support resource\-based policies\.

## Authorization based on Amazon WorkDocs tags<a name="security_iam_service-with-iam-tags"></a>

Amazon WorkDocs does not support tagging resources or controlling access based on tags\.

## Amazon WorkDocs IAM roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using temporary credentials with Amazon WorkDocs<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon WorkDocs supports using temporary credentials\. 

### Service\-linked roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Amazon WorkDocs does not support service\-linked roles\.

### Service roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Amazon WorkDocs does not support service roles\. 