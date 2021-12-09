--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Getting Started with AWS Snowball<a name="getting-started"></a>

With AWS Snowball \(Snowball\), you can transfer hundreds of terabytes or petabytes of data between your on\-premises data centers and Amazon Simple Storage Service \(Amazon S3\)\. Following, you can find general instructions for creating and completing your first data transfer job\. You can find more information on specific components of Snowball later in this documentation\. For an overview of the service as a whole, see [How AWS Snowball Works with the Standard Snowball device](how-it-works.md)\.

Both sets of instructions assume that you'll use the AWS Snowball Management Console to create your job and the Snowball client to locally transfer your data\. If you'd rather work programmatically, to create jobs you can use the job management API for Snowball\. For more information, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\. To transfer your data programmatically, you can use the Amazon S3 Adapter for Snowball\. For more information, see [Transferring Data with the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md)\.

## Sign Up for AWS<a name="snowball-signing-up"></a>

If you already have an AWS account, go ahead and skip to the next section: [Create an Administrator IAM User](#create-admin-user)\. Otherwise, see [Sign Up for AWS](setting-up.md#setting-up-signup)\.

## Create an Administrator IAM User<a name="create-admin-user"></a>

If you already have an administrator AWS Identity and Access Management \(IAM\) user account, go ahead and skip to one of the sections listed following\. If you don't have an administrator IAM user, we recommend that you create one and not use the root credentials of your AWS account to make requests\. To do so, see [Create an IAM User](setting-up.md#setting-up-iam)\.

**Important**  
There is no free tier for Snowball\. To avoid unwanted charges and delays, read through the relevant import or export section following before you start creating your jobs\.

**Next:**
+  [Importing Data into Amazon S3 with AWS Snowball](create-import-job-steps.md)
+ [Exporting Data from Amazon S3 with Snowball](create-export-job-steps.md)