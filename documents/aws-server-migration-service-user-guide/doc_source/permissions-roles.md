# Configure AWS SMS Permissions and Roles<a name="permissions-roles"></a>

The following permission and role prerequisites apply to either platform supported by AWS SMS\.

## Configure User Permissions for AWS SMS<a name="user-permissions"></a>

If your IAM user account, group, or role is assigned administrator permissions, then you already have access to AWS SMS\. To call the AWS SMS API with the credentials of an IAM user that does not have administrative access to your AWS account: 
+ Create a custom inline policy defined by the following JSON code\.
+ Apply it to the IAM user\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Action":[
            "sms:*"
         ],
         "Effect":"Allow",
         "Resource":"*"
      },
      {
         "Action":[
            "cloudformation:ListStacks",
            "cloudformation:DescribeStacks",
            "cloudformation:DescribeStackResources"
         ],
         "Effect":"Allow",
         "Resource":"*"
      },
      {
         "Action":[
            "s3:ListAllMyBuckets",
            "s3:GetObject"
         ],
         "Effect":"Allow",
         "Resource":"*"
      },
      {
         "Action":[
            "ec2:DescribeKeyPairs",
            "ec2:DescribeVpcs",
            "ec2:DescribeSubnets",
            "ec2:DescribeSecurityGroups"
         ],
         "Effect":"Allow",
         "Resource":"*"
      },
      {
         "Action":"iam:PassRole",
         "Resource":"*",
         "Effect":"Allow",
         "Condition":{
            "StringLike":{
               "iam:AssociatedResourceArn":"arn:aws:cloudformation:*:*:stack/sms-app-*/*"
            }
         }
      }
   ]
}
```

**Note**  
If you are using multiple connectors, we recommend that you create a unique IAM role for each connector to avoid having a single point of failure\.

## Configure an IAM User for Server Migration Connector<a name="connector-permissions"></a>

**To create an IAM user for Server Migration Connector in your AWS account**

1. Create a new IAM user for your connector to communicate with AWS\. Save the generated access key and secret key for use during the initial connector setup\. For information about managing IAM users and permissions, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\.

1. Attach the managed IAM policy `ServerMigrationConnector` to the IAM user\. For more information, see [Managed Policies and Inline Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html)\.

## Configure a Service Role for AWS SMS<a name="service-role"></a>

Use one of the following procedures to create an IAM role that grants permissions to AWS SMS to place migrated resources into your Amazon EC2 account\. In AWS Regions that make an IAM role template available, Option 1 works\. If you find that no template for **AWS Server Migration Service** exists in your AWS Region, proceed to Option 2\.

**Option 1: Create an AWS SMS IAM role with a template**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**, **Create role**\.

1. Under **Choose the service that will use this role**, choose **SMS**, **Next: Permissions**\. 

1. Under **Attached permissions policies**, confirm that the policy **ServerMigrationServiceRole** is visible and choose **Next: Review**\.

1. Under **Review**, for **Role name**, enter **sms**\. 
**Note**  
Alternatively, you can apply a different name\. However, you must then specify the role name explicitly each time that you create a replication job or an application\.

1. Choose **Create role**\. You should now see the **sms** role in the list of available roles\.

Use the following option in AWS Regions that do not make an IAM role template available\. This option also works as a manual alternative to Option 1 in all Regions\.

**Option 2: Create an AWS SMS IAM role manually**

1. Create a local file named `trust-policy.json` with the following content:

   ```
   {
           "Version": "2012-10-17",
           "Statement": [
               {
                   "Sid": "",
                   "Effect": "Allow",
                   "Principal": {
                       "Service": "sms.amazonaws.com"
                   },
                   "Action": "sts:AssumeRole",
                   "Condition": {
                       "StringEquals": {
                           "sts:ExternalId": "sms"
                       }
                   }
               }
           ]
       }
   ```

1. Create a local file named `role-policy.json` with the following content:

   ```
   {
      "Version":"2012-10-17",
      "Statement":[
         {
            "Action":[
               "cloudformation:CreateChangeSet",
               "cloudformation:CreateStack",
               "cloudformation:DeleteStack",
               "cloudformation:ExecuteChangeSet"
            ],
            "Resource":"arn:aws:cloudformation:*:*:stack/sms-app-*/*",
            "Effect":"Allow",
            "Condition":{
               "ForAllValues:StringLikeIfExists":{
                  "cloudformation:ResourceTypes":[
                     "AWS::EC2::*"
                  ]
               }
            }
         },
         {
            "Action":[
               "cloudformation:DeleteChangeSet",
               "cloudformation:DescribeChangeSet",
               "cloudformation:DescribeStackEvents",
               "cloudformation:DescribeStackResources",
               "cloudformation:GetTemplate"
            ],
            "Resource":"arn:aws:cloudformation:*:*:stack/sms-app-*/*",
            "Effect":"Allow"
         },
         {
            "Action":[
               "cloudformation:DescribeStacks",
               "cloudformation:ValidateTemplate",
               "cloudformation:DescribeStackResource",
               "s3:ListAllMyBuckets"
            ],
            "Resource":"*",
            "Effect":"Allow"
         },
         {
            "Action":[
               "s3:CreateBucket",
               "s3:DeleteBucket",
               "s3:DeleteObject",
               "s3:GetBucketAcl",
               "s3:GetBucketLocation",
               "s3:GetObject",
               "s3:ListBucket",
               "s3:PutObject",
               "s3:PutObjectAcl",
               "s3:PutLifecycleConfiguration",
               "s3:ListAllMyBuckets"
            ],
            "Resource":"arn:aws:s3:::sms-app-*",
            "Effect":"Allow"
         },
         {
            "Action":[
               "sms:CreateReplicationJob",
               "sms:DeleteReplicationJob",
               "sms:GetReplicationJobs",
               "sms:GetReplicationRuns",
               "sms:GetServers",
               "sms:ImportServerCatalog",
               "sms:StartOnDemandReplicationRun",
               "sms:UpdateReplicationJob"
            ],
            "Resource":"*",
            "Effect":"Allow"
         },
         {
            "Action":[
               "ec2:ModifySnapshotAttribute",
               "ec2:CopySnapshot",
               "ec2:CopyImage",
               "ec2:Describe*",
               "ec2:DeleteSnapshot",
               "ec2:DeregisterImage",
               "ec2:CreateTags",
               "ec2:DeleteTags"
            ],
            "Resource":"*",
            "Effect":"Allow"
         },
         {
            "Action":"iam:GetRole",
            "Resource":"*",
            "Effect":"Allow"
         },
         {
            "Action":"iam:PassRole",
            "Resource":"*",
            "Effect":"Allow",
            "Condition":{
               "StringLike":{
                  "iam:AssociatedResourceArn":"arn:aws:cloudformation:*:*:stack/sms-app-*/*"
               }
            }
         }
      ]
   }
   ```

1. At a command prompt, go to the directory where you stored the two JSON policy files, and run the following commands to create the AWS SMS service role:

   ```
   aws iam create-role --role-name sms --assume-role-policy-document file://trust-policy.json
   aws iam put-role-policy --role-name sms --policy-name sms --policy-document file://role-policy.json
   ```

**Note**  
Your AWS CLI user must have permissions on IAM\. You can grant these by attaching the `IAMFullAccess` managed policy to your AWS CLI user\. For information about managing IAM users and permissions, see [Creating an IAM User in Your AWS Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_create.html)\. 

## Configure a Launch Role for AWS SMS<a name="sms-launch-role"></a>

If you plan to launch applications, you need an AWS SMS launch role\. You assign this role using the `PutAppLaunchConfiguration` API\. When the `LaunchApp` API is called, the role is used by AWS CloudFormation\. 

Use one of the following procedures to configure this role\. Use Option 2 in AWS Regions that do not make an AWS SMS launch role template available, or as a manual alternative to Option 1 in all Regions\.

**Option 1: Create an AWS SMS launch role with a template**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**, **Create role**\.

1. Under **Choose the service that will use this role**, choose **CloudFormation**, **Next: Permissions**\. 

1. Under **Attached permissions policies**, confirm that the policy **ServerMigrationServiceLaunchRole** is visible and choose **Next: Review**\.

1. Under **Review**, for **Role name**, enter **sms\-launch**\. 
**Note**  
Alternatively, you can apply a different name\. However, you must then specify the role name explicitly each time that you create a launch configuration for an application\.

1. Choose **Create role**\. You should now see the **sms\-launch** role in the list of available roles\.

**Option 2: Create an AWS SMS launch role manually**

1. Create a local file named `trust-policy.json` with the following content:

   ```
   {
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Principal":{
               "Service":"cloudformation.amazonaws.com"
            },
            "Action":"sts:AssumeRole"
         }
      ]
   }
   ```

1. Create a local file named `role-policy.json` with the following content:

   ```
   {
      "Version":"2012-10-17",
      "Statement":[
         {
            "Effect":"Allow",
            "Action":[
               "ec2:ModifyInstanceAttribute",
               "ec2:StopInstances",
               "ec2:StartInstances",
               "ec2:TerminateInstances"
            ],
            "Resource":"*",
            "Condition":{
               "ForAllValues:StringLike":{
                  "ec2:ResourceTag/aws:cloudformation:stack-id":"arn:aws:cloudformation:*:*:stack/sms-app-*/*"
               }
            }
         },
         {
            "Effect":"Allow",
            "Action":"ec2:CreateTags",
            "Resource":"arn:aws:ec2:*:*:instance/*"
         },
         {
            "Effect":"Allow",
            "Action":[
               "ec2:RunInstances",
               "ec2:Describe*"
            ],
            "Resource":"*"
         }
      ]
   }
   ```

1. At a command prompt, go to the directory where you stored the two JSON policy files, and run the following commands to create the AWS SMS service role:

   ```
   aws iam create-role --role-name sms-launch --assume-role-policy-document file://trust-policy.json
   aws iam put-role-policy --role-name sms-launch --policy-name sms --policy-document file://role-policy.json
   ```