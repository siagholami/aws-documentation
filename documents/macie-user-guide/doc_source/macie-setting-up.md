# Setting Up Amazon Macie<a name="macie-setting-up"></a>

When you sign up for AWS, your AWS account is automatically signed up for all services in AWS, including Amazon Macie\. Before you can get started with Macie, you must enable Macie\.

**Tasks**
+ If you don't have an AWS account, open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup) and follow the directions\.
+ [Enable Macie](#macie-setting-up-enable)
+ [Integrate Amazon S3 with Macie](#macie-integrates3)

## Enable Macie<a name="macie-setting-up-enable"></a>

The AWS account that you use to enable Macie is automatically designated as your master account\. For more information, see [Concepts and Terminology](macie-concepts.md)\.

After you enable Macie, it immediately begins pulling and analyzing independent streams of data from AWS CloudTrail to generate alerts\. Because Macie consumes this data only to determine if there are potential security issues, Macie doesn't manage CloudTrail for you or make its events and logs available to you\. If you have enabled CloudTrail independent of Macie, you continue to have the option to configure its settings through the CloudTrail console or APIs\. For more information, see the [AWS CloudTrail User Guide](https://docs.aws.amazon.com/awscloudtrail/latest/userguide/)\.

**Prerequisites**
+ The IAM identity \(user, role, group\) that you use to enable Macie must have the required permissions\. To grant the required permissions, attach the **AmazonMacieFullAccess** managed policy to this identity\. For more information, see [Predefined AWS Managed Policies for Macie](macie-access-control.md#managed-policies)\.

**To enable Amazon Macie**

1. Open the Macie console using one of the following links:
   + US East \(N\. Virginia\): [https://us\-east\-1\.redirection\.macie\.aws\.amazon\.com/](https://us-east-1.redirection.macie.aws.amazon.com/)
   + US West \(Oregon\): [https://us\-west\-2\.redirection\.macie\.aws\.amazon\.com/](https://us-west-2.redirection.macie.aws.amazon.com/)

1. Choose **Get started**\.

1. \(Optional\) When you enable Macie, Macie creates a service\-linked role\. To view the IAM policy for this role, choose **View service role permissions**\. For more information, see [Service\-Linked Roles for Amazon Macie](using-service-linked-roles.md)\.

1. Choose **Enable Macie**\.

You can disable Macie at any time to stop it from processing and analyzing CloudTrail events\. For more information, see [Disabling Amazon Macie and Deleting Collected Metadata](macie-disable.md)\.

## Integrate Amazon S3 with Macie<a name="macie-integrates3"></a>

To classify and protect your data, Macie analyzes and processes information from CloudTrail and Amazon S3\. Enabling CloudTrail in your account is required to enable Macie\. Integrating S3 with Macie is not required\. However, we strongly recommend that you integrate with Amazon S3 as part of setting up Macie\. For more information about how Macie classifies your data, see [Classifying Data with Amazon Macie](macie-classify-data.md)\.

When you integrate with Amazon S3, Macie creates a trail and a bucket to store the logs about the Amazon S3 object\-level API activity \(data events\) that it will analyze, along with other CloudTrail logs that it processes\.

**Prerequisites**
+ The IAM identity \(user, role, group\) that you use to integrate must have the required permissions\. To grant the required permissions, attach the **AmazonMacieFullAccess** managed policy to this identity\. For more information, see [Predefined AWS Managed Policies for Macie](macie-access-control.md#managed-policies)\.

**To integrate with Amazon S3**

1. Log in to AWS with the credentials of the account that is serving as your Macie master account\.

1. Open the Macie console and choose **Integrations** from the navigation pane\.

1. Choose **S3 Resources** and choose **Select** next to the account \(master or member\)\.

1. On the **Integrate S3 resources with Macie** page, choose **Add**\. Select up to 250 Amazon S3 resources from the current AWS Region and then choose **Add**\.

1. For **Classification of existing objects**, keep the default setting, **Full**\. The one\-time classification method is applied only once to all of the existing objects in the selected S3 buckets\.

   Macie displays the following information for each selected bucket:
   + **Total objects** – Total number of objects\.
   + **Processed estimate** – Total size of the data that Macie will classify\.
   + **Cost estimate** – Cost estimate for classifying all of the objects\.

   Macie also displays the following totals across all selected buckets:
   + **Total size** – Total size of the data\.
   + **Total number of objects** – Total number of objects\.
   + **Processed estimate** – Total size of the data that Macie will classify\.
   + **Total cost estimate** – Cost estimate for classifying all of the objects\.

   The cost estimate for each bucket is based on its processed estimate value\. The total cost estimates are provided only for S3 buckets, not for prefixes\. For more information, see [Amazon Macie Pricing](http://aws.amazon.com/macie/pricing/)\.

   The one\-time classification cost estimates are only calculated per S3 bucket, not bucket prefixes\. If you select a bucket prefix, the cost estimate for the entire S3 bucket is included in the total cost estimate\. If you select multiple prefixes of the same S3 bucket, the cost estimate for the entire S3 bucket is included only once in the total cost estimate\.

1. When you have finished your selections, choose **Review**\.

1. When you have finished reviewing your selections, choose **Start classification**\.