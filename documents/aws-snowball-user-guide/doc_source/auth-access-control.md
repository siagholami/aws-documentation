--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Authorization and Access Control in AWS Snowball<a name="auth-access-control"></a>

You must have valid credentials to create Snowball jobs\. You use these credentials to authenticate your access\. A requester with valid credentials must also have permissions from the resource owner to access resources from the resource owner\. For example, you can use the AWS Identity and Access Management \(IAM\) service to create users in your account\. IAM users have valid credentials to make requests, but by default they don't have permissions to access any resources\. Following, you can find information on how to authenticate requests and manage permissions to access Snowball resources\.

**Note**  
The following contains information specific to the AWS Snowball Management Console and Snowball client\. If you're planning on programmatically creating jobs and transferring data, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

## Authentication<a name="snowball-authentication"></a>

Every Snowball job must be authenticated\. You do this by creating and managing the IAM users in your account\. Using IAM, you can create and manage users and permissions in AWS\.

Snowball users must have certain IAM\-related permissions to access the AWS Snowball Management Console to create jobs\. An IAM user that creates an import or export job must also have access to the right Amazon Simple Storage Service \(Amazon S3\) resources, such as the Amazon S3 buckets to be used for the job\.

To use AWS Snowball Management Console, the IAM user must meet the following conditions:
+ The IAM account must be able to do the following: 
  + List all of your Amazon S3 buckets and create new ones as needed\.
  + Create Amazon Simple Notification Service \(Amazon SNS\) topics\.
  + Choose AWS Key Management Service \(AWS KMS\) keys\.
  + Create IAM role Amazon Resource Names \(ARNs\)\.

  For more information on granting a user access to an Amazon S3 bucket, see [Creating an IAM User for Snowball](#create-iam-user)\.
+ An IAM role must be created with write permissions for your Amazon S3 buckets\. The role must also have a trust relationship with Snowball, so AWS can write the data in the Snowball to your designated Amazon S3 buckets\. The job creation wizard for each job does this step automatically; you can also do it manually\. For more information, see [Creating an IAM Role for Snowball](#create-iam-role)\.

### Creating an IAM User for Snowball<a name="create-iam-user"></a>

If the account doing the work in the Snowball console is not the root account or administrator, you must use the IAM Management Console to grant the user the permissions necessary to create and manage jobs\. The following procedure shows how to create a new IAM user for this purpose and give that user the necessary permissions through an inline policy\.

If you are updating an existing IAM user, start with step 6\.

**To create a new IAM user for Snowball**

1. Sign in to the AWS Management Console and open the IAM Management Console at [https://console\.aws\.amazon\.com/iam](https://console.aws.amazon.com/iam)\.

1. From the navigation pane, choose **Users**\.

1. Choose **Create New Users**\.

1. Type a name for the user, and choose **Create**\.

1. On the screen that appears, you can download security credentials for the IAM user that you just created\. Creating an IAM user generates an access key consisting of an access key ID and a secret access key, which are used to sign programmatic requests that you make to AWS\. If you want to download these security credentials, choose **Download**\. Otherwise, choose **close** to return to your list of users\.
**Note**  
After this access step, your secret key is no longer available through the AWS Management Console; you have the only copy\. To protect your account, keep this information confidential and never email it\. Do not share it outside your organization, even if an inquiry appears to come from AWS or Amazon\.com\. No one who legitimately represents Amazon will ever ask you for your secret key\.

1. To view the user details page, choose your user from the table\.

1. Choose the **Permissions** tab, and then expand **Inline Policy\.**

1. Choose the **click here** link to create a new inline policy\.

1. Choose **Custom Policy**, and then choose **Select** to provide your own policy document\.

1. Create a name you'll remember for your custom policy, like *JobCreation*\.

1. Paste the following text into your custom **Policy Document**\. 
**Note**  
If you're updating an existing user, review the following text carefully before you change their permissions, as you might inadvertently grant or disable permissions that you didn't intend to change\.

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Action": [
                           "s3:ListBucket",
                           "s3:GetBucketPolicy",
                           "s3:GetBucketLocation",
                           "s3:ListBucketMultipartUploads",
                           "s3:ListAllMyBuckets",
                           "s3:CreateBucket"
               ],
               "Resource": [
                   "*"
               ]
           },
           {
               "Effect": "Allow",
               "Action": [
                           "kms:DescribeKey",
                           "kms:ListAliases",
                           "kms:ListKeys",
                           "kms:CreateGrant"
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
                           "sns:CreateTopic",
                           "sns:GetTopicAttributes",
                           "sns:ListSubscriptionsByTopic",
                           "sns:ListTopics",
                           "sns:Subscribe",
                           "sns:SetTopicAttributes"
               ],
               "Resource": [
                   "*"
               ]
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

1. Choose **Apply Policy** to finalize your new inline policy and return to the IAM **Users** page in the console\.

The preceding procedure creates a user that can create and manage jobs in the Snowball console\.

### Creating an IAM Role for Snowball<a name="create-iam-role"></a>

An IAM role must be created with read and write permissions for your Amazon S3 buckets\. The role must also have a trust relationship with Snowball, so AWS can write the data in the Snowball and in your Amazon S3 buckets, depending on whether you're importing or exporting data\.

When creating a job in the AWS Snowball Management Console, creating the necessary IAM role occurs in step 4 in the **Permission** section\. This process is automatic, and the IAM role that you allow Snowball to assume is only used to write your data to your bucket when the Snowball with your transferred data arrives at AWS\. The following procedure outlines that process\.

**To create the IAM role for your import job**

1. Sign in to the AWS Management Console and open the AWS Snowball console at [https://console\.aws\.amazon\.com/importexport/](https://console.aws.amazon.com/importexport/)\. 

1. Choose **Create job**\.

1. In the first step, fill out the details for your import job into Amazon S3, and then choose **Next**\.

1. In the second step, under **Permission**, choose **Create/Select IAM Role**\.

   The IAM Management Console opens, showing the IAM role that AWS uses to copy objects into your specified Amazon S3 buckets\.

1. Review the details on this page, and then choose **Allow**\.

   You return to the AWS Snowball Management Console, where **Selected IAM role ARN** contains the Amazon Resource Name \(ARN\) for the IAM role that you just created\.

1. Choose **Next** to finish creating your IAM role\.

The preceding procedure creates an IAM role that has write permissions for the Amazon S3 buckets that you plan to import your data into\. The IAM role that is created has one of the following structures, depending on whether it's for an import or export job\.

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

**IAM Role for an Export Job**

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

## Access Control<a name="access-control"></a>

As IAM resource owner, you have responsibility for access control and security for the Snowball console, Snowball, and other assets associated with using Snowball\. These assets include such things as Amazon S3 buckets, the workstation that the data transfer goes through, and your on\-premises data itself\. 

In some cases, we can help you grant and manage access control to the resources used in transferring your data with Snowball\. In other cases, we suggest that you follow industry\-wide best practices for access control\.


| Resource | Description | How to Control Access | 
| --- | --- | --- | 
| AWS Snowball Management Console | The AWS Snowball Management Console is where you create and manage your data transfers between your on\-premises data centers and Amazon S3 using discrete units of work called jobs\. To access the console, see [AWS Snowball Management Console](https://console.aws.amazon.com/importexport/home?region=us-west-2)\. | You can control access to this resource by creating or managing your IAM users\. For more information, see [Creating an IAM User for Snowball](#create-iam-user)\. | 
| Amazon S3 buckets | All data in Amazon S3 is stored in units called objects\. Objects are stored in containers called buckets\. Any data that goes into Amazon S3 must be stored in a bucket\. | To import data into an Amazon S3 bucket, the IAM user that created the import job must have read and write access to your Amazon S3 buckets\. For more information on granting a user access to an Amazon S3 bucket, see [How Amazon S3 Authorizes a Request for a Bucket Operation](https://docs.aws.amazon.com/AmazonS3/latest/dev/access-control-auth-workflow-bucket-operation.html) and [Example 1: Bucket Owner Granting Its Users Bucket Permissions](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-walkthroughs-managing-access-example1.html) in the Amazon Simple Storage Service Developer Guide\. | 
| Snowball | A Snowball is a storage device that is physically rugged, protected by AWS Key Management Service \(AWS KMS\), and owned by Amazon\. In the AWS Snowball service, all data transfers between Amazon S3 and your on\-premises data center is done through a Snowball\. You can only access a Snowball through the Snowball client, the data transfer tool\. For you to access a Snowball, it must be connected to a physical workstation that has the Snowball client installed on it in your on\-premises data center\. With the Snowball client, you can access the Snowball by providing the job manifest and unlock code in the command that the Snowball client uses to start communication with the Snowball\. | You can control access to the Snowball by careful distribution of a job's manifest and unlock code\. | 
| Manifest | The manifest is an encrypted file that you can download from the AWS Snowball Management Console after your job enters the Processing status\. The manifest is decrypted by the unlock code, when you pass both values to the Snowball through the Snowball client when the client is started for the first time\. | As a best practice, we recommend that you don't save a copy of the unlock code in the same location as the manifest for that job\. Saving these separately helps prevent unauthorized parties from gaining access to the Snowball associated with that job\. For example, you might save a copy of the manifest to the workstation, and email the code to the IAM user to perform the data transfer from the workstation\. This approach limits those who can access the Snowball to individuals who have access to files saved on the workstation and also that IAM user's email address\. | 
| Unlock code | The unlock code is a 29\-character code with 25 alphanumeric characters and 4 hyphens\. This code decrypts the manifest when it is passed along with the manifest to the Snowball through the Snowball client when the client is started for the first time\. You can see the unlock code in the AWS Snowball Management Console after your job enters the Preparing Snowball status\. The code also appears in the dialog box when you download the manifest for a job\. The unlock code appears on\-screen only and is not downloaded\. | Again, as a best practice we recommend that you don't save a copy of the unlock code in the same location as the manifest for that job\. Saving these separately helps prevent unauthorized parties from gaining access to the Snowball associated with that job\. For example, you might save a copy of the manifest to the workstation, and email the code to the IAM user to perform the data transfer from the workstation\. This approach limits those who can access the Snowball to individuals who have access to files saved on the workstation and also that IAM user's email address\. | 