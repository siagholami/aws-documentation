# Integrating Member Accounts and Amazon S3 with Amazon Macie<a name="macie-integration"></a>

You can integrate member accounts with Macie and integrate Amazon S3 with Macie\. For more information about the master and member accounts, see [Concepts and Terminology](macie-concepts.md)\.

**Topics**
+ [Integrating Member Accounts with Macie](#macie-integration-member)
+ [Specifying Data for Macie to Monitor](#macie-integration-services)
+ [Encrypted Objects](#macie-encrypted-objects)

## Integrating Member Accounts with Macie<a name="macie-integration-member"></a>

When you integrate member accounts with Macie, you're enabling Macie to monitor resources and activity in these member accounts\.

**Prerequisites**
+ Create a role that grants the member account the permissions required to create the **AWSServiceRoleForAmazonMacie** service\-linked role\. For more information, see [Creating a Handshake Role](macie-access-control.md#create-handshake-role)\.

**To integrate member accounts with Macie**

1. Log in to AWS with the credentials of the AWS account that is serving as your Macie master account\.

1. Open the Macie console and choose **Integrations** from the navigation pane\.

1. Choose **Accounts** and choose the plus icon \(**\+**\) next to **Member AWS accounts**\.

1. When prompted, enter one or more account IDs, separated by commas\. Choose **Add accounts**\.

1. \(Optional\) Verify that Macie created the **AWSServiceRoleForAmazonMacie** role in each member account that you integrated\. For more information, see [Creating a Service\-Linked Role for Macie](using-service-linked-roles.md#create-slr)\.

## Specifying Data for Macie to Monitor<a name="macie-integration-services"></a>

You can specify the S3 buckets and prefixes that contain the data for Macie to monitor\.

**Prerequisites**
+ The IAM identity \(user, role, group\) that you use to integrate must have the required permissions\. To grant the required permissions, attach the **AmazonMacieFullAccess** managed policy to this identity\. For more information, see [Predefined AWS Managed Policies for Macie](macie-access-control.md#managed-policies)\.

**To update your integration with Amazon S3**

1. Log in to AWS with the credentials of the account that is serving as your Macie master account\.

1. Open the Macie console and choose **Integrations** from the navigation pane\.

1. Choose **S3 Resources** and choose **Select** next to the account \(master or member\)\.

1. On the **Integrate S3 resources with Macie** page, choose **Edit** to edit the buckets/prefixes that are already integrated or **Add** to integrate new buckets/prefixes\.

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

## Encrypted Objects<a name="macie-encrypted-objects"></a>

If objects stored in your Amazon S3 buckets are encrypted, Macie might not be able to read and classify those objects for the following reasons: 
+ If your Amazon S3 objects are encrypted using [Amazon S3–managed encryption keys \(SSE\-S3\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingServerSideEncryption.html), Macie can read and classify the objects using the roles created during the setup process\.
+ If your Amazon S3 objects are encrypted using [AWS KMS–managed keys \(SSE\-KMS\)](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingKMSEncryption.html), Macie can read and classify the objects only if you add the `AWSMacieServiceCustomerServiceRole` IAM role or the `AWSServiceRoleForAmazonMacie` service\-linked role as a [key user](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-users) for the KMS customer master key \(CMK\)\. If you don't add either of these roles as a key user for the KMS CMK, Macie can't read and classify the objects\. However, Macie still stores metadata on the object, including which KMS CMK was used to protect the object\.
+ If your Amazon S3 objects are encrypted using client\-side encryption, Macie can't read and classify the objects, but still stores metadata on the object\.