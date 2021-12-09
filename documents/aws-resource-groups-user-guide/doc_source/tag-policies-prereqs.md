# Prerequisites and permissions<a name="tag-policies-prereqs"></a>

Before you can evaluate compliance with tag policies in AWS Resource Groups, you need to meet the requirements and set the necessary permissions\. 

## Prerequisites for evaluating compliance with tag policies<a name="tag-policies-prereqs-overview"></a>

Evaluating compliance with tag policies requires the following:
+ You must first enable the feature in AWS Organizations and create and attach tag policies\. For more information, see the following pages in the *AWS Organizations User Guide*:
  + [Prerequisites and permissions for managing tag policies](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_tag-policies-prereqs.html)
  + [Enabling tag policies](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_enable-disable.html)
  + [Getting started with tag policies](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_policies_tag-policies-getting-started.html)
+ To [**find noncompliant tags on an account's resources**](tag-policies-arg-finding-noncompliant-tags.md), you need sign\-in credentials for that account and the permissions listed in [Permissions for evaluating compliance for an account](#tag-policies-permissions-account)\.
+ To [**evaluate organization\-wide compliance**](tag-policies-arg-evaluating-org-wide-compliance.md), you need sign\-in credentials for the organization's master account and the permissions listed in [Permissions for evaluating organization\-wide compliance ](#tag-policies-permissions-org)\.

## Permissions for evaluating compliance for an account<a name="tag-policies-permissions-account"></a>

Finding noncompliant tags on an account's resources requires these permissions:
+ `organizations:DescribeEffectivePolicy` – To get the contents of the effective tag policy for the account\.
+ `tag:GetResources` – To get a list of resources that do not comply with the attached tag policy\.
+ `tag:TagResources` – To add or update tags\. You also need service\-specific permissions to create tags\. For example, to tag resources in Amazon EC2, you need permissions for `ec2:CreateTags`\.
+ `tag:UnTagResources` – To remove a tag\. You also need service\-specific permissions to remove tags\. For example, to untag resources in Amazon EC2, you need permissions for `ec2:DeleteTags`\.

The following example IAM policy provides permissions for evaluating tag compliance for an account\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "EvaluateAccountCompliance",
            "Effect": "Allow",
            "Action": [
                "organizations:DescribeEffectivePolicy",
                "tag:GetResources",
                "tag:TagResources",
                "tag:UnTagResources"
            ],
            "Resource": "*"
        }
    ]
}
```

For more information on IAM policies and permissions, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## Permissions for evaluating organization\-wide compliance<a name="tag-policies-permissions-org"></a>

Evaluating organization\-wide compliance with tag policies requires the following permissions:
+ `organizations:DescribeEffectivePolicy` – To get the contents of the tag policy that's attached to the organization, OU, or account\.
+ `tag:GetComplianceSummary` – To get a summary of noncompliant resources in all accounts in the organization\.
+ `tag:StartReportCreation` – To export the results of the most recent compliance evaluation to a file\. Organization\-wide compliance is evaluated every 48 hours\. 
+ `tag:DescribeReportCreation` – To check the status of report creation\.

The following example IAM policy provides permissions for evaluating organization\-wide compliance\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "EvaluateOrgCompliance",
            "Effect": "Allow",
            "Action": [
                "organizations:DescribeEffectivePolicy",
                "tag:GetComplianceSummary",
                "tag:StartReportCreation",
                "tag:DescribeReportCreation"
            ],
            "Resource": "*"
        }
    ]
}
```

For more information on IAM policies and permissions, see the [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)\.

## Amazon S3 bucket policy for storing report<a name="bucket-policy"></a>

To create an organization\-wide compliance report, you must grant access for the tag policies service principal to an Amazon S3 bucket in the US East \(N\. Virginia\) Region for report storage\. Attach the following bucket policy to the bucket:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "TagPolicyACL",
            "Effect": "Allow",
            "Principal": {
                "Service": [
                    "tagpolicies.tag.amazonaws.com"
                ]
            },
            "Action": "s3:GetBucketAcl",
            "Resource": "arn:aws:s3:::your-bucket-name"
        },
        {
            "Sid": "TagPolicyBucketDelivery",
            "Effect": "Allow",
            "Principal": {
                "Service": [
                    "tagpolicies.tag.amazonaws.com"
                ]
            },
            "Action": [
                "s3:PutObject"
            ],
            "Resource": "arn:aws:s3:::your-bucket-name/AwsTagPolicies/your-org-id/*"
        }
    ]
}
```