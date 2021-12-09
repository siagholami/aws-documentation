# Service\-Linked Roles for AWS Auto Scaling<a name="aws-auto-scaling-service-linked-roles"></a>

AWS Auto Scaling uses service\-linked roles for the permissions that it requires to call other AWS services on your behalf\. A service\-linked role is a unique type of AWS Identity and Access Management \(IAM\) role that is linked directly to an AWS service\. 

Service\-linked roles provide a secure way to delegate permissions to AWS services because only the linked service can assume a service\-linked role\. For more information, see [Using Service\-Linked Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.

The following sections describe how to create and manage the AWS Auto Scaling service\-linked role\. Start by configuring permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\.

## Permissions Granted by the Service\-Linked Role<a name="service-linked-role-permissions"></a>

AWS Auto Scaling uses the **AWSServiceRoleForAutoScalingPlans\_EC2AutoScaling** service\-linked role to manage predictive scaling of Amazon EC2 Auto Scaling groups on your behalf\. This role is predefined with permissions to make the following calls on your behalf: 
+ `cloudwatch:GetMetricData`
+ `autoscaling:DescribeAutoScalingGroups`
+ `autoscaling:DescribeScheduledActions`
+ `autoscaling:BatchPutScheduledUpdateGroupAction`
+ `autoscaling:BatchDeleteScheduledAction`

This role trusts the `autoscaling-plans.amazonaws.com` service to assume it\. 

## Create Service\-Linked Roles \(Automatic\)<a name="create-service-linked-role-automatic"></a>

AWS Auto Scaling creates the **AWSServiceRoleForAutoScalingPlans\_EC2AutoScaling** role for you the first time that you create a scaling plan with predictive scaling enabled\.

**Important**  
Make sure that you have enabled the IAM permissions that allow an IAM entity \(such as a user, group, or role\) to create the service\-linked role\. Otherwise, the automatic creation fails\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide* or the information about [Permissions Required to Create a Service\-Linked Role](security_iam_id-based-policy-examples.md#aws-auto-scaling-slr-permissions) in this guide\.

## Create Service\-Linked Roles \(Manual\)<a name="create-service-linked-role-manual"></a>

To create the service\-linked role manually, you can use the IAM console, AWS CLI, or IAM API\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\.

**To create a service\-linked role \(AWS CLI\)**  
Use the following [create\-service\-linked\-role](https://docs.aws.amazon.com/cli/latest/reference/iam/create-service-linked-role.html) CLI command to create the AWS Auto Scaling service\-linked role\.

```
aws iam create-service-linked-role --aws-service-name autoscaling-plans.amazonaws.com
```

## Edit the Service\-Linked Roles<a name="edit-service-linked-role"></a>

With the **AWSServiceRoleForAutoScalingPlans\_EC2AutoScaling** role created by AWS Auto Scaling, you can edit only its description and not its permissions\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Delete the Service\-Linked Roles<a name="delete-service-linked-role"></a>

If you no longer use scaling plans, we recommend that you delete the service\-linked role\. You can delete a service\-linked role only after first deleting the related AWS resources\. If a service\-linked role is used with multiple scaling plans, you must delete all scaling plans with predictive scaling enabled before you can delete the role\. This protects your scaling plans by preventing you from inadvertently removing the permissions that you need to manage them\. For more information, see [Step 5: Clean Up](gs-delete-scaling-plan.md)\.

You can use IAM to delete the service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

After you delete the **AWSServiceRoleForAutoScalingPlans\_EC2AutoScaling** service\-linked role, AWS Auto Scaling creates the role again when you create a scaling plan with predictive scaling enabled\. 

## Supported Regions for AWS Auto Scaling Service\-Linked Roles<a name="slr-regions"></a>

AWS Auto Scaling supports using service\-linked roles in all of the AWS Regions where the service is available\.