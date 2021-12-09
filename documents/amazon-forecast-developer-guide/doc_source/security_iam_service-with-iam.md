# How Amazon Forecast Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to Amazon Forecast, you should understand what IAM features are available to use with Forecast\. To get a high\-level view of how Forecast and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Forecast Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [Forecast IAM Roles](#security_iam_service-with-iam-roles)

## Forecast Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources as well as the conditions under which actions are allowed or denied\. Forecast supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Forecast use the following prefix before the action: `forecast:`\. For example, to grant someone permission to run an FOR dataset group creation job with the `CreateDatasetGroup` API operation, you include the `forecast:CreateDatasetGroup` action in their policy\. Policy statements must include either an `Action` or `NotAction` element\. Forecast defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as follows\.

```
"Action": [
      "forecast:action1",
      "forecast:action2"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "forecast:Describe*"
```



To see a list of Forecast actions, see [Actions Defined by Amazon Forecast](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awskeymanagementservice.html#amazonforecast-actions-as-permissions) in the *IAM User Guide*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\. Statements must include either a `Resource` or a `NotResource` element\. You specify a resource using an ARN or using the wildcard \(\*\) to indicate that the statement applies to all resources\.



An Amazon Forecast dataset resource has the following ARN\.

```
arn:${Partition}:forecast:${Region}:${Account}:dataset/${DatasetName}
```

For more information about the format of ARNs, see [Amazon Resource Names \(ARNs\) and AWS Service Namespaces](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html)\.

For example, to specify the dataset called `MyDataset` in your statement, use the following ARN\.

```
"Resource": "arn:aws:forecast:us-east-1:123456789012:dataset/MyDataset"
```

To specify all datasets that belong to a specific account, use the wildcard \(\*\)\.

```
"Resource": "arn:aws:forecast:us-east-1:123456789012:dataset/*"
```

Some Forecast actions, such as those for creating resources, cannot be performed on a specific resource\. In those cases, you must use the wildcard \(\*\)\.

```
"Resource": "*"
```

To see a list of Forecast resource types and their ARNs, see [Resources Defined by Amazon Forecast](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awskeymanagementservice.html#amazonforecast-resources-for-iam-policies) in the *IAM User Guide*\. To learn with which actions you can specify the ARN of each resource, see [Actions Defined by Amazon Forecast](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awskeymanagementservice.html#amazonforecast-actions-as-permissions)\.

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

Forecast does not provide any service\-specific condition keys\.

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>



To view examples of Forecast identity\-based policies, see [Amazon Forecast Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## Forecast IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with Forecast<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Forecast supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) allow AWS services to access resources in other services to complete an action on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Forecast does not support service\-linked roles\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

This feature allows a service to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. This role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Forecast supports service roles\. 