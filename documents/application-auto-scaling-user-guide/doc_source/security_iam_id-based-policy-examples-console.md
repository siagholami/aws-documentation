# Example Policies for Working in the AWS Management Console<a name="security_iam_id-based-policy-examples-console"></a>

There is no standalone Application Auto Scaling console\. Most services that integrate with Application Auto Scaling have features that are dedicated to helping you configure scaling with their console\. 

In most cases, each service provides AWS managed \(predefined\) IAM policies that define access to their console, which includes permissions to the Application Auto Scaling API actions\. For more information, refer to the documentation for the service whose console you want to use\. 

You can also create your own custom IAM policies to give users fine\-grained permissions to view and work with specific Application Auto Scaling actions in the AWS Management Console\. You can use the example policies in the previous section; however, they are designed for requests that are made with the AWS CLI or an AWS SDK\. The console uses additional API actions for its features, so these policies may not work as expected\. For example, to configure step scaling, users might require additional permissions to create and manage CloudWatch alarms\. 

**Tip**  
To help you work out which API actions are required to perform tasks in the console, you can use a service such as AWS CloudTrail\. For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-user-guide.html)\. 

The following shows an example of a permissions policy that allows a user to configure scaling policies for Spot Fleet\. In addition to the [IAM permissions for Spot Fleet](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/spot-fleet-requests.html#spot-fleet-iam-users), the IAM user that accesses fleet scaling settings from the console must have the appropriate permissions for the services that support dynamic scaling\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "application-autoscaling:*",
                "ec2:DescribeSpotFleetRequests",
                "ec2:ModifySpotFleetRequest",
                "cloudwatch:DeleteAlarms",
                "cloudwatch:DescribeAlarmHistory",
                "cloudwatch:DescribeAlarms",
                "cloudwatch:DescribeAlarmsForMetric",
                "cloudwatch:GetMetricStatistics",
                "cloudwatch:ListMetrics",
                "cloudwatch:PutMetricAlarm",
                "cloudwatch:DisableAlarmActions",
                "cloudwatch:EnableAlarmActions",
                "sns:CreateTopic",
                "sns:Subscribe",
                "sns:Get*",
                "sns:List*"
            ],
            "Resource": "*"
        },
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

This policy allows users to view and modify scaling policies in the Amazon EC2 console, and to create and manage CloudWatch alarms in the CloudWatch console\. 

You can adjust the API actions to limit user access\. For example, replacing `application-autoscaling:*` with `application-autoscaling:Describe*` means that the user has read\-only access\. 

You can also adjust the CloudWatch permissions as required to limit user access to CloudWatch features\. For more information, see [Permissions Required to Use the CloudWatch Console](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/iam-identity-based-access-control-cw.html#console-permissions-cw) in the *Amazon CloudWatch User Guide*\.

Keep in mind that Application Auto Scaling requires permission to create a service\-linked role the first time that you configure scaling for a given service\. For example, after this role has been created for the first scaling configuration you add to a Spot Fleet, you do not need to add this permission to other users of the same AWS account who use Spot Fleet\.