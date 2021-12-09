# How Application Auto Scaling Works with IAM<a name="security_iam_service-with-iam"></a>

**Note**  
In December 2017, there was an update for Application Auto Scaling, enabling several service\-linked roles for Application Auto Scaling integrated services\. Specific IAM permissions *and* an Application Auto Scaling service\-linked role \(or a service role for Amazon EMR auto scaling\) are required so that users can configure scaling\. 

Before you use IAM to manage access to Application Auto Scaling, you should understand what IAM features are available to use with Application Auto Scaling\. To get a high\-level view of how Application Auto Scaling and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [Application Auto Scaling Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [Application Auto Scaling Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Access Control Lists \(ACLs\)](#security_iam_service-with-iam-acls)
+ [Authorization Based on Application Auto Scaling Tags](#security_iam_service-with-iam-tags)
+ [Application Auto Scaling IAM Roles](#security_iam_service-with-iam-roles)

## Application Auto Scaling Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources, and the conditions under which actions are allowed or denied\. Application Auto Scaling supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in Application Auto Scaling use the following prefix before the action: `application-autoscaling:`\. Policy statements must include either an `Action` or `NotAction` element\. Application Auto Scaling defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as shown in the following example\.

```
"Action": [
      "application-autoscaling:DescribeScalingPolicies",
      "application-autoscaling:DescribeScalingActivities"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "application-autoscaling:Describe*"
```

To see a list of Application Auto Scaling actions, see [Actions](https://docs.aws.amazon.com/autoscaling/application/APIReference/API_Operations.html) in the *Application Auto Scaling API Reference*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\.

Application Auto Scaling has no service\-defined resources that can be used as the `Resource` element of an IAM policy statement\. Therefore, there are no Amazon Resource Names \(ARNs\) for Application Auto Scaling for you to use in an IAM policy\. To control access to Application Auto Scaling actions, always use an \* \(asterisk\) as the resource when writing an IAM policy\. 

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. For example, you might want a policy to be applied only after a specific date\. To express conditions, use predefined condition keys\.

Application Auto Scaling does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\. 

The `Condition` element is optional\. 

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>

To view examples of Application Auto Scaling identity\-based policies, see [Example Policies for Working with the AWS CLI or an AWS SDK](security_iam_id-based-policy-examples.md)\.

## Application Auto Scaling Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

Application Auto Scaling does not support resource\-based policies\.

## Access Control Lists \(ACLs\)<a name="security_iam_service-with-iam-acls"></a>

Application Auto Scaling does not support Access Control Lists \(ACLs\)\.

## Authorization Based on Application Auto Scaling Tags<a name="security_iam_service-with-iam-tags"></a>

Application Auto Scaling has no service\-defined resources that can be tagged\. Therefore, it does not support controlling access based on tags\.

## Application Auto Scaling IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with Application Auto Scaling<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

Application Auto Scaling supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

[Service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role) give permissions to Application Auto Scaling so that it can make specific calls to other AWS services on your behalf\. Service\-linked roles appear in your IAM account and are owned by the service\. An IAM administrator can view but not edit the permissions for service\-linked roles\.

Application Auto Scaling supports service\-linked roles\. For more information, see [Service\-Linked Roles for Application Auto Scaling](application-auto-scaling-service-linked-roles.md)\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

If your Amazon EMR cluster uses automatic scaling, this feature allows Application Auto Scaling to assume a [service role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-role) on your behalf\. Similar to a service\-linked role, a service role allows the service to access resources in other services to complete an action on your behalf\. Service roles appear in your IAM account and are owned by the account\. This means that an IAM administrator can change the permissions for this role\. However, doing so might break the functionality of the service\.

Application Auto Scaling supports service roles only for Amazon EMR\. For documentation for the EMR service role, see [Using Automatic Scaling in Amazon EMR](https://docs.aws.amazon.com/emr/latest/ManagementGuide/emr-automatic-scaling.html) in the *Amazon EMR Management Guide*\.

**Note**  
With the introduction of service\-linked roles, several legacy service roles are no longer required\. If you specify a legacy service role for any other service \(for example, Amazon ECS or Spot Fleet\), Application Auto Scaling ignores it\. Instead, it uses a service\-linked role\. If this role doesn't exist, you must have permissions to create it or a permission error occurs\.