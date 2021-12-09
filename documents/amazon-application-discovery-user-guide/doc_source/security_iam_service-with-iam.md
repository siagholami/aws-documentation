# How AWS Application Discovery Service Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Application Discovery Service, you should understand what IAM features are available to use with Application Discovery Service\. To get a high\-level view of how Application Discovery Service and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Application Discovery Service Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [Application Discovery Service Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Authorization Based on Application Discovery Service Tags](#security_iam_service-with-iam-tags)
+ [Application Discovery Service IAM Roles](#security_iam_service-with-iam-roles)

## Application Discovery Service Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Application Discovery Service supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Application Discovery Service use the following prefix before the action: `discovery:`\. Policy statements must include either an `Action` or `NotAction` element\. Application Discovery Service defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": [
      "discovery:action1",
      "discovery:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action:

```
"Action": "discovery:Describe*"
```



To see a list of Application Discovery Service actions, see [Actions Defined by AWS Application Discovery Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_applicationdiscovery.html#awskeymanagementservice-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

Application Discovery Service does not support specifying resource ARNs in a policy\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Application Discovery Service does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Application Discovery Service identity\-based policies, see [AWS Application Discovery Service Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Application Discovery Service Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Application Discovery Service does not support resource\-based policies\. 

## Authorization Based on Application Discovery Service Tags<a name="security_iam_service-with-iam-tags"></a>

Application Discovery Service does not support tagging resources or controlling access based on tags\.

## Application Discovery Service IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with Application Discovery Service<a name="security_iam_service-with-iam-roles-tempcreds"></a>

Application Discovery Service does not support using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Application Discovery Service supports service\-linked roles\. For details about creating or managing Application Discovery Service service\-linked roles, see [Using Service\-Linked Roles for Application Discovery Service](using-service-linked-roles.md)\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Application Discovery Service supports service roles\. 