# How Amazon Translate Works with IAM<a name="security_iam_service-with-iam"></a>

You can manage access to Amazon Translate operations and resources with AWS Identity and Access Management\. Before you use AWS Identity and Access Management \(IAM\) to manage access to Amazon Translate, you should understand which IAM features are available to use with Amazon Translate\. To get a high\-level view of how Amazon Translate and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Amazon Translate Identity\-Based Policies](#access-control-managing-permissions)
+ [Amazon Translate Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization Based on Amazon Translate Tags](#security_iam_service-with-iam-tags)
+ [Amazon Translate IAM Roles](#security_iam_service-with-iam-roles)

## Amazon Translate Identity\-Based Policies<a name="access-control-managing-permissions"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Amazon Translate supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Amazon Translate use the following prefix before the action: `translate:`\. For example, to grant someone permission to perform a translation with the Amazon Translate `TranslateText` API operation, log in as an admin and include the `translate:TranslateText` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Amazon Translate defines its own set of actions that describe tasks that you can perform with this service\. To see a list of Amazon Translate actions, see [Actions Defined by Amazon Translate](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_amazontranslate.html#amazontranslate-actions-as-permissions) in the *IAM User Guide*\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "translate:action1",
      "translate:action2"
```

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

Amazon Translate doesn't support specifying resource Amazon Resource Names \(ARNs\) in a policy\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Amazon Translate doesn't provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. The `Condition` element is optional\. You can build conditional expressions that use [condition operators](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html), such as equals or less than, to match the condition in the policy with values in the request\. 

If you specify multiple `Condition` elements in a statement, or multiple keys in a single `Condition` element, AWS evaluates them using a logical `AND` operation\. If you specify multiple values for a single condition key, AWS evaluates the condition using a logical `OR` operation\. All of the conditions must be met before the statement's permissions are granted\.

 You can also use placeholder variables when you specify conditions\. For example, you can grant an IAM user permission to access a resource only if it is tagged with their IAM user name\. For more information, see [IAM Policy Elements: Variables and Tags](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_variables.html) in the *IAM User Guide*\. 

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To see examples of Amazon Translate identity\-based policies, see [Amazon Translate Identity\-based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Amazon Translate Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Amazon Translate doesn't support resource\-based policies\.

## Authorization Based on Amazon Translate Tags<a name="security_iam_service-with-iam-tags"></a>

Amazon Translate doesn't support tagging resources or controlling access based on tags\.

## Amazon Translate IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with Amazon Translate<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS Security Token Service \(AWS STS\) API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Amazon Translate supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view, but not edit\. the permissions for service\-linked roles\.

Amazon Translate doesn't support service\-linked roles\.