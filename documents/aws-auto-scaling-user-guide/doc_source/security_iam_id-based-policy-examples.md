# AWS Auto Scaling Identity\-Based Policy Examples<a name="security_iam_id-based-policy-examples"></a>

By default, a brand new IAM user has no permissions to do anything\. An IAM administrator must create IAM policies that grant users and roles permission to perform AWS Auto Scaling actions, such as configuring scaling policies\. The administrator must then attach those policies to the IAM users or roles that require those permissions\.

To learn how to create an IAM policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

If you are new to creating policies, we recommend that you first create an IAM user in your account and attach policies to the user\. You can use the console to verify the effects of each policy as you attach the policy to the user\. 

**Topics**
+ [Policy Best Practices](#security_iam_service-with-iam-policy-best-practices)
+ [Allow Users to Create Scaling Plans](#example-policies-scaling-plans)
+ [Allow Users to Enable Predictive Scaling](#example-policies-predictive-scaling)
+ [Additional Required Permissions](#aws-auto-scaling-additional-permissions)
+ [Permissions Required to Create a Service\-Linked Role](#aws-auto-scaling-slr-permissions)

## Policy Best Practices<a name="security_iam_service-with-iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS Auto Scaling resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get Started Using AWS Managed Policies** – To start using AWS Auto Scaling quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and updated by AWS\. For more information, see [Get Started Using Permissions With AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant Least Privilege** – When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant Least Privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for Sensitive Operations** – For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using Multi\-Factor Authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use Policy Conditions for Extra Security** – To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write conditions to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON Policy Elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Allow Users to Create Scaling Plans<a name="example-policies-scaling-plans"></a>

 The following shows an example of a permissions policy that allows users to create scaling plans\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
              "autoscaling-plans:*",
              "cloudwatch:PutMetricAlarm",
              "cloudwatch:DeleteAlarms",
              "cloudwatch:DescribeAlarms",
              "cloudformation:ListStackResources"
            ],
            "Resource": "*"
        }
    ]
}
```

For a user to work with a scaling plan, that user must have additional permissions that allow them to work with specific resources in their AWS account\. These permissions are listed in [Additional Required Permissions](#aws-auto-scaling-additional-permissions)\.

Each console user also needs permissions that allow them to discover the scalable resources in their AWS account and to view graphs of CloudWatch metric data from the AWS Auto Scaling console\. The additional set of permissions required to work with the AWS Auto Scaling console is listed below: 
+ `cloudformation:ListStacks`: To list stacks\.
+ `tag:GetTagKeys`: To find scalable resources that contain certain tag keys\.
+ `tag:GetTagValues`: To find resources that contain certain tag values\.
+ `autoscaling:DescribeTags`: To find Auto Scaling groups that contain certain tags\.
+ `cloudwatch:GetMetricData`: To view data in metric graphs for AWS resources\. 

## Allow Users to Enable Predictive Scaling<a name="example-policies-predictive-scaling"></a>

The following shows an example of a permissions policy that allows users to enable predictive scaling\. These permissions extend the features of scaling plans that are set up to scale Auto Scaling groups\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
              "cloudwatch:GetMetricData",
              "autoscaling:DescribeAutoScalingGroups",
              "autoscaling:DescribeScheduledActions",
              "autoscaling:BatchPutScheduledUpdateGroupAction",
              "autoscaling:BatchDeleteScheduledAction"
            ],
            "Resource": "*"
        }
    ]
}
```

## Additional Required Permissions<a name="aws-auto-scaling-additional-permissions"></a>

When granting permissions for AWS Auto Scaling, you must decide which resources users get permissions for\. Depending on which scenarios you want to support, you can specify the following actions in the `Action` element of an IAM policy statement\. 

**Auto Scaling groups**

To add Auto Scaling groups to a scaling plan, users must have the following permissions from Amazon EC2 Auto Scaling: 
+ `autoscaling:UpdateAutoScalingGroup`
+ `autoscaling:DescribeAutoScalingGroups`
+ `autoscaling:PutScalingPolicy`
+ `autoscaling:DescribePolicies`
+ `autoscaling:DeletePolicy`

**ECS services**

To add ECS services to a scaling plan, users must have the following permissions from Amazon ECS and Application Auto Scaling: 
+ `ecs:DescribeServices`
+ `ecs:UpdateService`
+ `application-autoscaling:RegisterScalableTarget`
+ `application-autoscaling:DescribeScalableTargets`
+ `application-autoscaling:DeregisterScalableTarget`
+ `application-autoscaling:PutScalingPolicy`
+ `application-autoscaling:DescribeScalingPolicies`
+ `application-autoscaling:DeleteScalingPolicy`

**Spot Fleet**

To add Spot Fleets to a scaling plan, users must have the following permissions from Amazon EC2 and Application Auto Scaling: 
+ `ec2:DescribeSpotFleetRequests`
+ `ec2:ModifySpotFleetRequest`
+ `application-autoscaling:RegisterScalableTarget`
+ `application-autoscaling:DescribeScalableTargets`
+ `application-autoscaling:DeregisterScalableTarget`
+ `application-autoscaling:PutScalingPolicy`
+ `application-autoscaling:DescribeScalingPolicies`
+ `application-autoscaling:DeleteScalingPolicy`

**DynamoDB tables or global indexes**

To add DynamoDB tables or global indexes to a scaling plan, users must have the following permissions from DynamoDB and Application Auto Scaling: 
+ `dynamodb:DescribeTable`
+ `dynamodb:UpdateTable`
+ `application-autoscaling:RegisterScalableTarget`
+ `application-autoscaling:DescribeScalableTargets`
+ `application-autoscaling:DeregisterScalableTarget`
+ `application-autoscaling:PutScalingPolicy`
+ `application-autoscaling:DescribeScalingPolicies`
+ `application-autoscaling:DeleteScalingPolicy`

**Aurora DB clusters**

To add Aurora DB clusters to a scaling plan, users must have the following permissions from Amazon Aurora and Application Auto Scaling: 
+ `rds:AddTagsToResource`
+ `rds:CreateDBInstance`
+ `rds:DeleteDBInstance`
+ `rds:DescribeDBClusters`
+ `rds:DescribeDBInstances`
+ `application-autoscaling:RegisterScalableTarget`
+ `application-autoscaling:DescribeScalableTargets`
+ `application-autoscaling:DeregisterScalableTarget`
+ `application-autoscaling:PutScalingPolicy`
+ `application-autoscaling:DescribeScalingPolicies`
+ `application-autoscaling:DeleteScalingPolicy`

## Permissions Required to Create a Service\-Linked Role<a name="aws-auto-scaling-slr-permissions"></a>

AWS Auto Scaling requires permissions to create a service\-linked role the first time any user in your AWS account creates a scaling plan with predictive scaling enabled\. If the service\-linked role does not exist already, AWS Auto Scaling creates it in your account\. The service\-linked role grants permissions to AWS Auto Scaling so that it can call other services on your behalf\. 

For automatic role creation to succeed, users must have permissions for the `iam:CreateServiceLinkedRole` action\.

```
"Action": "iam:CreateServiceLinkedRole"
```

The following shows an example of a permissions policy that allows a user to create an AWS Auto Scaling service\-linked role\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "arn:aws:iam::*:role/aws-service-role/autoscaling-plans.amazonaws.com/AWSServiceRoleForAutoScalingPlans_EC2AutoScaling",
            "Condition": {
                "StringLike": {
                    "iam:AWSServiceName":"autoscaling-plans.amazonaws.com"
                }
            }
        }
    ]
}
```

For more information, see [Service\-Linked Roles for AWS Auto Scaling](aws-auto-scaling-service-linked-roles.md)\.