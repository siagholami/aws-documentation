# How AWS Auto Scaling Works with IAM<a name="security_iam_service-with-iam"></a>

Before you use IAM to manage access to AWS Auto Scaling, you should understand what IAM features are available to use with AWS Auto Scaling\. To get a high\-level view of how AWS Auto Scaling and other AWS services work with IAM, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) in the *IAM User Guide*\.

**Topics**
+ [AWS Auto Scaling Identity\-Based Policies](#security_iam_service-with-iam-id-based-policies)
+ [AWS Auto Scaling Resource\-Based Policies](#security_iam_service-with-iam-resource-based-policies)
+ [Access Control Lists \(ACLs\)](#security_iam_service-with-iam-acls)
+ [Authorization Based on AWS Auto Scaling Tags](#security_iam_service-with-iam-tags)
+ [AWS Auto Scaling IAM Roles](#security_iam_service-with-iam-roles)

## AWS Auto Scaling Identity\-Based Policies<a name="security_iam_service-with-iam-id-based-policies"></a>

With IAM identity\-based policies, you can specify allowed or denied actions and resources, and the conditions under which actions are allowed or denied\. AWS Auto Scaling supports specific actions, resources, and condition keys\. To learn about all of the elements that you use in a JSON policy, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html) in the *IAM User Guide*\.

### Actions<a name="security_iam_service-with-iam-id-based-policies-actions"></a>

The `Action` element of an IAM identity\-based policy describes the specific action or actions that will be allowed or denied by the policy\. Policy actions usually have the same name as the associated AWS API operation\. The action is used in a policy to grant permissions to perform the associated operation\. 

Policy actions in AWS Auto Scaling use the following prefix before the action: `autoscaling-plans:`\. Policy statements must include either an `Action` or `NotAction` element\. AWS Auto Scaling defines its own set of actions that describe tasks that you can perform with this service\.

To specify multiple actions in a single statement, separate them with commas as shown in the following example\.

```
"Action": [
      "autoscaling-plans:DescribeScalingPlans",
      "autoscaling-plans:DescribeScalingPlanResources"
```

You can specify multiple actions using wildcards \(\*\)\. For example, to specify all actions that begin with the word `Describe`, include the following action\.

```
"Action": "autoscaling-plans:Describe*"
```

To see a list of AWS Auto Scaling actions, see [Actions](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_Operations.html) in the *AWS Auto Scaling API Reference*\.

### Resources<a name="security_iam_service-with-iam-id-based-policies-resources"></a>

The `Resource` element specifies the object or objects to which the action applies\.

AWS Auto Scaling has no service\-defined resources that can be used as the `Resource` element of an IAM policy statement\. Therefore, there are no Amazon Resource Names \(ARNs\) for AWS Auto Scaling for you to use in an IAM policy\. To control access to AWS Auto Scaling actions, always use an \* \(asterisk\) as the resource when writing an IAM policy\. 

### Condition Keys<a name="security_iam_service-with-iam-id-based-policies-conditionkeys"></a>

The `Condition` element \(or `Condition` *block*\) lets you specify conditions in which a statement is in effect\. For example, you might want a policy to be applied only after a specific date\. To express conditions, use predefined condition keys\.

AWS Auto Scaling does not provide any service\-specific condition keys, but it does support using some global condition keys\. To see all AWS global condition keys, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\. 

The `Condition` element is optional\. 

### Examples<a name="security_iam_service-with-iam-id-based-policies-examples"></a>

To view examples of AWS Auto Scaling identity\-based policies, see [AWS Auto Scaling Identity\-Based Policy Examples](security_iam_id-based-policy-examples.md)\.

## AWS Auto Scaling Resource\-Based Policies<a name="security_iam_service-with-iam-resource-based-policies"></a>

AWS Auto Scaling does not support resource\-based policies\.

## Access Control Lists \(ACLs\)<a name="security_iam_service-with-iam-acls"></a>

AWS Auto Scaling does not support Access Control Lists \(ACLs\)\.

## Authorization Based on AWS Auto Scaling Tags<a name="security_iam_service-with-iam-tags"></a>

AWS Auto Scaling has no service\-defined resources that can be tagged\. Therefore, it does not support controlling access based on tags\.

## AWS Auto Scaling IAM Roles<a name="security_iam_service-with-iam-roles"></a>

An [IAM role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles.html) is an entity within your AWS account that has specific permissions\.

### Using Temporary Credentials with AWS Auto Scaling<a name="security_iam_service-with-iam-roles-tempcreds"></a>

You can use temporary credentials to sign in with federation, to assume an IAM role, or to assume a cross\-account role\. You obtain temporary security credentials by calling AWS STS API operations such as [AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) or [GetFederationToken](https://docs.aws.amazon.com/STS/latest/APIReference/API_GetFederationToken.html)\. 

AWS Auto Scaling supports using temporary credentials\. 

### Service\-Linked Roles<a name="security_iam_service-with-iam-roles-service-linked"></a>

AWS Auto Scaling supports service\-linked roles\. 

Depending on which resources you add to your scaling plan, AWS automatically creates a service\-linked role for Amazon EC2 Auto Scaling and one service\-linked role per resource type for Application Auto Scaling\. If you enable predictive scaling, AWS automatically creates the AWS Auto Scaling service\-linked role\. For more information, see [Service\-Linked Roles for Amazon EC2 Auto Scaling](https://docs.aws.amazon.com/autoscaling/ec2/userguide/autoscaling-service-linked-role.html) in the *Amazon EC2 Auto Scaling User Guide*, [Service\-Linked Roles for Application Auto Scaling](https://docs.aws.amazon.com/autoscaling/application/userguide/application-auto-scaling-service-linked-roles.html) in the *Application Auto Scaling User Guide*, and [Service\-Linked Roles for AWS Auto Scaling](aws-auto-scaling-service-linked-roles.md) in this guide\.

You can use the following procedure to determine if your account already has a service\-linked role\.<a name="procedure_check_instance_role"></a>

**To determine whether a service\-linked role already exists**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**\. 

1. Search the list for “AWSServiceRole” to find the service linked roles that exist in your account\. Look for the name of the service\-linked role that you want to check\.

### Service Roles<a name="security_iam_service-with-iam-roles-service"></a>

AWS Auto Scaling has no service roles\.