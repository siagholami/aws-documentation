# AWS Elemental MediaConnect resource\-based policy examples<a name="security_iam_resource-based-policy-examples"></a>

To access the AWS Elemental MediaConnect console, you must have a minimum set of permissions that allows you to list and view details about the MediaConnect resources in your AWS account\. The IAM policies in this section show examples of policies that allow specific actions on resources in AWS Elemental MediaConnect\.

## Allow read access to all resources in AWS Elemental MediaConnect<a name="iam-policy-examples-for-mediaconnect-actions-read-only-all-resources"></a>

To access the AWS Elemental MediaConnect console, you must have a policy that defines which actions you are allowed to take on MediaConnect resources in your AWS account\. The IAM policy below provides the following permissions:
+ The section for the `mediaconnect:List*` and `mediaconnect:Describe*` actions allow read\-only access to all resources that you create in AWS Elemental MediaConnect\.
+ The section for the `ec2:DescribeAvailabilityZones` action allows the service to obtain information about which Availability Zone the flow is in\. This portion of the policy is required\.
+ The section for the `cloudwatch:GetMetricData` action allows the service to obtain metrics from Amazon CloudWatch\. This portion of the policy is required\.
+ The section for the `iam:PassRole` action allows IAM to *pass* a role to AWS Elemental MediaConnect the service to communicate with IAM in order to assume a role on behalf of the service\. This allows the service to assume the role later and perform actions on your behalf\. This portion of the policy is required\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "mediaconnect:List*",
                "mediaconnect:Describe*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
        {
            "Action": [
                "ec2:DescribeAvailabilityZones"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
         {
            "Action": [
                "cloudwatch:GetMetricData"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
        {
            "Action": [
                "iam:PassRole"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

## Allow all actions on all AWS Elemental MediaConnect resources<a name="iam-policy-examples-for-mediaconnect-actions-all-actions-all-resources"></a>

Every user of AWS Elemental MediaConnect must have a policy that defines permissions on AWS Elemental MediaConnect resources\. The IAM policy below provides the following permissions:
+ The section for the `mediaconnect:*` action allows all actions on all resources that you create in AWS Elemental MediaConnect\.
+ The section for the `ec2:DescribeAvailabilityZones` action allows the service to obtain information about which Availability Zone the flow is in\. This portion of the policy is required\.
+ The section for the `cloudwatch:GetMetricData` action allows the service to obtain metrics from Amazon CloudWatch\. This portion of the policy is required\.
+ The section for the `iam:PassRole` action allows IAM to *pass* a role to AWS Elemental MediaConnect the service to communicate with IAM in order to assume a role on behalf of the service\. This allows the service to assume the role later and perform actions on your behalf\. This portion of the policy is required\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "mediaconnect:*"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
        {
            "Action": [
                "ec2:DescribeAvailabilityZones"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
         {
            "Action": [
                "cloudwatch:GetMetricData"
            ],
            "Effect": "Allow",
            "Resource": "*"
        },
        {
            "Action": [
                "iam:PassRole"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

## Allow AWS Elemental MediaConnect to create and manage network interfaces in your VPC<a name="iam-policy-examples-for-mediaconnect-vpc"></a>

This example IAM policy allows AWS Elemental MediaConnect to create and manage network interfaces in your VPC so that content can flow from your VPC to MediaConnect\. If you want to connect your VPC to your flow, you must set up this policy\.
+ The section for the `ec2:` actions allows MediaConnect to create, read, update, and delete network interfaces in your VPC\. This portion of the policy is required\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "ec2:describeNetworkInterfaces",
                "ec2:describeSecurityGroups",
                "ec2:describeSubnets",
                "ec2:createNetworkInterface",
                "ec2:createNetworkInterfacePermission",
                "ec2:deleteNetworkInterface",
                "ec2:deleteNetworkInterfacePermission"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```