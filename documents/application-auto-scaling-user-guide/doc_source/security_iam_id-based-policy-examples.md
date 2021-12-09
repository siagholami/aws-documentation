# Example Policies for Working with the AWS CLI or an AWS SDK<a name="security_iam_id-based-policy-examples"></a>

By default, a brand new IAM user has no permissions to do anything\. An IAM administrator must create IAM policies that grant users and roles permission to perform Application Auto Scaling actions, such as configuring scaling policies\. The administrator must then attach those policies to the IAM users or roles that require those permissions\.

To learn how to create an IAM policy using these example JSON policy documents, see [Creating Policies on the JSON Tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*\.

The following policies grant the permissions for common use cases\. You can attach these policies to your IAM users, based on the access that they need\. Each policy grants access to all or some of the API actions for Application Auto Scaling\. 

The following shows an example of a permissions policy that allows a user to perform all API actions for Application Auto Scaling\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
              "application-autoscaling:*"
            ],
            "Resource": "*"
        }
    ]
}
```

The following shows an example of a permissions policy that allows a user to configure scaling policies\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
              "application-autoscaling:RegisterScalableTarget",
              "application-autoscaling:DescribeScalableTargets",
              "application-autoscaling:DeregisterScalableTarget",
              "application-autoscaling:PutScalingPolicy",
              "application-autoscaling:DescribeScalingPolicies",
              "application-autoscaling:DescribeScalingActivities",
              "application-autoscaling:DeleteScalingPolicy"
            ],
            "Resource": "*"
        }
    ]
}
```

The following shows an example of a permissions policy that allows a user to configure scheduled scaling\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
              "application-autoscaling:RegisterScalableTarget",
              "application-autoscaling:DescribeScalableTargets",
              "application-autoscaling:DeregisterScalableTarget",
              "application-autoscaling:PutScheduledAction",
              "application-autoscaling:DescribeScheduledActions",
              "application-autoscaling:DescribeScalingActivities",
              "application-autoscaling:DeleteScheduledAction"
            ],
            "Resource": "*"
        }
    ]
}
```

## Additional Required IAM Permissions<a name="application-auto-scaling-additional-permissions"></a>

Users must have additional permissions for each type of resource for which they will configure scaling policies\. You specify the following actions in the `Action` element of an IAM policy statement\. 

**AppStream 2\.0 fleets**
+ `appstream:DescribeFleets`
+ `appstream:UpdateFleet`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Amazon Comprehend document classification endpoints**
+ `comprehend:UpdateEndpoint`
+ `comprehend:DescribeEndpoint`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**DynamoDB tables and global secondary indexes**
+ `dynamodb:DescribeTable`
+ `dynamodb:UpdateTable`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Amazon EC2 Spot Fleet requests**
+ `ec2:DescribeSpotFleetRequests`
+ `ec2:ModifySpotFleetRequest`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Amazon ECS services**
+ `ecs:DescribeServices`
+ `ecs:UpdateServices`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Amazon EMR clusters**
+ `elasticmapreduce:ModifyInstanceGroups`
+ `elasticmapreduce:ListInstanceGroups`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Aurora DB clusters**
+ `rds:AddTagsToResource`
+ `rds:CreateDBInstance`
+ `rds:DeleteDBInstance`
+ `rds:DescribeDBClusters`
+ `rds:DescribeDBInstances`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Amazon SageMaker endpoints**
+ `sagemaker:DescribeEndpoint`
+ `sagemaker:DescribeEndpointConfig`
+ `sagemaker:UpdateEndpointWeightsAndCapacities`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**AWS Lambda functions**
+ `lambda:PutProvisionedConcurrencyConfig`
+ `lambda:GetProvisionedConcurrencyConfig`
+ `lambda:DeleteProvisionedConcurrencyConfig`
+ `cloudwatch:DeleteAlarms`
+ `cloudwatch:DescribeAlarms`
+ `cloudwatch:PutMetricAlarm`

**Custom Resources**
+ `execute-api:Invoke`
+ `cloudwatch:DeleteAlarms `
+ `cloudwatch:DescribeAlarms `
+ `cloudwatch:PutMetricAlarm `

## Permissions Required to Create a Service\-Linked Role<a name="application-auto-scaling-slr-permissions"></a>

Application Auto Scaling requires permissions to create a service\-linked role the first time any user in your AWS account calls `RegisterScalableTarget` for a given service\. Application Auto Scaling creates a service\-specific service\-linked role in your account, if the role does not exist already\. The service\-linked role grants permissions to Application Auto Scaling so that it can call other services on your behalf\. 

For automatic role creation to succeed, users must have permissions for the `iam:CreateServiceLinkedRole` action\.

```
"Action": "iam:CreateServiceLinkedRole"
```

The following shows an example of a permissions policy that allows a user to create an Application Auto Scaling service\-linked role for Spot Fleet\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "arn:aws:iam::*:role/aws-service-role/ec2.application-autoscaling.amazonaws.com/AWSServiceRoleForApplicationAutoScaling_EC2SpotFleetRequest",
            "Condition": {
                "StringLike": {
                    "iam:AWSServiceName":"ec2.application-autoscaling.amazonaws.com"
                }
            }
        }
    ]
}
```

For more information, see [Service\-Linked Roles for Application Auto Scaling](application-auto-scaling-service-linked-roles.md)\.