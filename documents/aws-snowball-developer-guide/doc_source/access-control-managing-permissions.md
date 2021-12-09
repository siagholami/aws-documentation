--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Using Identity\-Based Policies \(IAM Policies\) for AWS Snowball<a name="access-control-managing-permissions"></a>

This topic provides examples of identity\-based policies that demonstrate how an account administrator can attach permissions policies to IAM identities \(that is, users, groups, and roles\)\. These policies thereby grant permissions to perform operations on AWS Snowball resources in the AWS Cloud\.

**Important**  
We recommend that you first review the introductory topics that explain the basic concepts and options available for you to manage access to your AWS Snowball resources\. For more information, see [Overview of Managing Access Permissions to Your Resources in the AWS Cloud](authentication-and-access-control.md#access-control-overview)\. 

The sections in this topic cover the following:
+  [Permissions Required to Use the AWS Snowball Console](#additional-console-required-permissions) 
+ [AWS\-Managed \(Predefined\) Policies for AWS Snowball Edge](#access-policy-examples-aws-managed)
+ [Customer Managed Policy Examples](access-policy-examples-for-sdk-cli.md)

The following shows an example of a permissions policy\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetBucketLocation",
        "s3:GetObject",
        "s3:ListBucket"
      ],
      "Resource": "arn:aws:s3:::*"
    },
    {
       "Effect": "Allow",
       "Action": [
          "snowball:*",
          "importexport:*"
       ],
       "Resource": "*"
    }
  ]
}
```

The policy has two statements:
+ The first statement grants permissions for three Amazon S3 actions \(`s3:GetBucketLocation`, `s3:GetObject`, and `s3:ListBucket`\) on all Amazon S3 buckets using the *Amazon Resource Name \(ARN\)* of `arn:aws:s3:::*`\. The ARN specifies a wildcard character \(\*\) so the user can choose any or all Amazon S3 buckets to export data from\.
+ The second statement grants permissions for all AWS Snowball actions\. Because these actions don't support resource\-level permissions, the policy specifies the wildcard character \(\*\) and the `Resource` value also specifies a wild card character\.

The policy doesn't specify the `Principal` element because in an identity\-based policy you don't specify the principal who gets the permission\. When you attach a policy to a user, the user is the implicit principal\. When you attach a permissions policy to an IAM role, the principal identified in the role's trust policy gets the permissions\. 

For a table showing all of the AWS Snowball job management API actions and the resources that they apply to, see [AWS Snowball API Permissions: Actions, Resources, and Conditions Reference](access-policy-examples-for-sdk-cli.md#snowball-api-permissions-ref)\. 

## Permissions Required to Use the AWS Snowball Console<a name="additional-console-required-permissions"></a>

The permissions reference table lists the AWS Snowball job management API operations and shows the required permissions for each operation\. For more information about job management API operations, see [AWS Snowball API Permissions: Actions, Resources, and Conditions Reference](access-policy-examples-for-sdk-cli.md#snowball-api-permissions-ref)\. 

 To use the AWS Snowball Management Console, you need to grant permissions for additional actions as shown in the following permissions policy: 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketLocation",
                "s3:GetBucketPolicy",
                "s3:ListBucket",
                "s3:ListBucketMultipartUploads",
                "s3:ListAllMyBuckets"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:CreateBucket",
                "s3:PutObject",
                "s3:AbortMultipartUpload",
                "s3:ListMultipartUploadParts",
                "s3:PutObjectAcl"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "lambda:GetFunction",
                "lambda:GetFunctionConfiguration"
            ],
            "Resource": "arn:aws:lambda:::function:*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "lambda:ListFunctions"
            ],
            "Resource": "arn:aws:lambda:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "kms:CreateGrant",
                "kms:GenerateDataKey",
                "kms:Decrypt",
                "kms:Encrypt",
                "kms:RetireGrant",
                "kms:ListKeys",
                "kms:DescribeKey",
                "kms:ListAliases"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "iam:AttachRolePolicy",
                "iam:CreatePolicy",
                "iam:CreateRole",
                "iam:ListRoles",
                "iam:ListRolePolicies",
                "iam:PutRolePolicy",
                "iam:PassRole"
            ],
            "Resource": [
                "*"
            ]
        },
        {
           "Effect": "Allow",
           "Action": [
                "ec2:DescribeImages",
                "ec2:ModifyImageAttribute"
           ],
           "Resource": [
                "*"
           ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "sns:CreateTopic",
                "sns:ListTopics",
                "sns:GetTopicAttributes",
                "sns:SetTopicAttributes",
                "sns:ListSubscriptionsByTopic",
                "sns:Subscribe"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "greengrass:getServiceRoleForAccount"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "snowball:*"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

The AWS Snowball console needs these additional permissions for the following reasons:
+ `ec2:` – These allow the user to describe Amazon EC2 instances and modify their attributes for local compute purposes\. For more information, see [Using Amazon EC2 Compute Instances](using-ec2.md)\.
+ `lambda:` – These allow the user to select Lambda functions for local compute purposes\. For more information, see [Using AWS Lambda with an AWS Snowball Edge](using-lambda.md)\.
+ `kms:` – These allow the user to create or choose the KMS key that will encrypt your data\. For more information, see [AWS Key Management Service in AWS Snowball Edge](kms.md)\.
+ `iam:` – These allow the user to create or choose an IAM role ARN that AWS Snowball will assume to access the AWS resources associated with job creation and processing\.
+ `sns:` – These allow the user to create or choose the Amazon SNS notifications for the jobs they create\. For more information, see [Notifications for the AWS Snowball Edge](notifications.md)\.

## AWS\-Managed \(Predefined\) Policies for AWS Snowball Edge<a name="access-policy-examples-aws-managed"></a>

AWS addresses many common use cases by providing standalone IAM policies that are created and administered by AWS\. Managed policies grant necessary permissions for common use cases so you can avoid having to investigate what permissions are needed\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\. 

You can use the following AWS\-managed policies with AWS Snowball\.

### Creating an IAM Role Policy for Snowball Edge<a name="create-iam-role"></a>

An IAM role policy must be created with read and write permissions for your Amazon S3 buckets\. The IAM role must also have a trust relationship with Snowball\. Having a trust relationship means that AWS can write the data in the Snowball and in your Amazon S3 buckets, depending on whether you're importing or exporting data\.

When you create a job in the AWS Snowball Management Console, creating the necessary IAM role occurs in step 4 in the **Permission** section\. This process is automatic\. The IAM role that you allow Snowball to assume is only used to write your data to your bucket when the Snowball with your transferred data arrives at AWS\. The following procedure outlines that process\.

**To create the IAM role for your import job**

1. Sign in to the AWS Management Console and open the AWS Snowball console at [https://console\.aws\.amazon\.com/importexport/](https://console.aws.amazon.com/importexport/)\. 

1. Choose **Create job**\.

1. In the first step, fill out the details for your import job into Amazon S3, and then choose **Next**\.

1. In the second step, under **Permission**, choose **Create/Select IAM Role**\.

   The IAM Management Console opens, showing the IAM role that AWS uses to copy objects into your specified Amazon S3 buckets\.

1. Review the details on this page, and then choose **Allow**\.

   You return to the AWS Snowball Management Console, where **Selected IAM role ARN** contains the Amazon Resource Name \(ARN\) for the IAM role that you just created\.

1. Choose **Next** to finish creating your IAM role\.

The preceding procedure creates an IAM role that has write permissions for the Amazon S3 buckets that you plan to import your data into\. The IAM role that is created has one of the following structures, depending on whether it's for an import job or export job\.

**IAM Role for an Import Job**

```
          {
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetBucketLocation",
        "s3:ListBucketMultipartUploads"
      ],
      "Resource": "arn:aws:s3:::*"
    },
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetBucketPolicy",
        "s3:PutObject",
        "s3:AbortMultipartUpload",
        "s3:ListMultipartUploadParts",
        "s3:PutObjectAcl"
      ],
      "Resource": "arn:aws:s3:::*"
    }
  ]
}
```

If you use server\-side encryption with AWS KMS–managed keys \(SSE\-KMS\) to encrypt the Amazon S3 buckets associated with your import job, you also need to add the following statement to your IAM role\.

```
{
     "Effect": "Allow",
     "Action": [
       "kms:GenerateDataKey"
     ],
     "Resource": "arn:aws:kms:us-west-2:123456789012:key/abc123a1-abcd-1234-efgh-111111111111"
}
```

If the object sizes are larger, the Amazon S3 client that is used for the import process uses multipart upload\. If you initiate a multipart upload using SSE\-KMS, then all the uploaded parts are encrypted using the specified AWS KMS key\. Because the parts are encrypted, they must be decrypted before they can be assembled to complete the multipart upload\. So you must have permission to decrypt the AWS KMS key \(`kms:Decrypt`\) when you run a multipart upload to Amazon S3 with SSE\-KMS\.

The following is an example of an IAM role needed for an import job that needs `kms:Decrypt` permission\.

```
{
    "Effect": "Allow",
     "Action": [
       "kms:GenerateDataKey","kms:Decrypt"

     ],
     "Resource": "arn:aws:kms:us-west-2:123456789012:key/abc123a1-abcd-1234-efgh-111111111111"
}
```

 The following is an example of an IAM role needed for an export job\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetBucketLocation",
        "s3:GetBucketPolicy",
        "s3:GetObject",
        "s3:ListBucket"
      ],
      "Resource": "arn:aws:s3:::*"
    }
  ]
}
```

If you use server\-side encryption with AWS KMS–managed keys to encrypt the Amazon S3 buckets associated with your export job, you also need to add the following statement to your IAM role\.

```
{
     "Effect": "Allow",
     "Action": [
            “kms:Decrypt”
      ],
     "Resource": "arn:aws:kms:us-west-2:123456789012:key/abc123a1-abcd-1234-efgh-111111111111"
}
```

You can create your own custom IAM policies to allow permissions for API operations for AWS Snowball job management\. You can attach these custom policies to the IAM users or groups that require those permissions\. 