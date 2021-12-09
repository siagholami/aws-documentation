--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Getting Started with an AWS Snowball Edge Device<a name="getting-started"></a>

With AWS Snowball using an AWS Snowball Edge device, you can access the storage and compute power of the AWS Cloud locally and cost effectively in places where connecting to the internet might not be an option\. You can also transfer hundreds of terabytes or petabytes of data between your on\-premises data centers and Amazon Simple Storage Service \(Amazon S3\)\. 

Following, you can find general instructions for creating and completing your first AWS Snowball Edge device job in the AWS Snowball Management Console\. The console presents the most common workflows, separated into job types\. You can find more information on specific components of the AWS Snowball Edge device later in this documentation\. For an overview of the service as a whole, see [How AWS Snowball Works with the Snowball Edge](how-it-works.md)\. The getting started exercises cover the following job types:

Each of the getting started exercises assume that you use the AWS Snowball Management Console to create your job, the Snowball client to unlock the AWS Snowball Edge device, and the Amazon S3 Adapter for Snowball to read and write data\. If you'd rather create your job programmatically with more options for the jobs you're creating, you can use the job management API\. For more information, see [AWS Snowball API Reference](https://docs.aws.amazon.com/snowball/latest/api-reference/api-reference.html)\.

Before you can get started, you need to create an AWS account and an administrator user in AWS Identity and Access Management \(IAM\)\. If you already have these, then you can skip these first two steps\.

**Note**  
This getting started exercise focuses on creating jobs for transferring data\. For more information about jobs using compute instances, see [Using Amazon EC2 Compute Instances](using-ec2.md)\.

## Sign Up for AWS<a name="signing-up"></a>

If you already have an AWS account, go ahead and skip to the next section: [Create an Administrator IAM User](#create-admin-user)\. Otherwise, see [Sign Up for AWS](setting-up.md#setting-up-signup)\.

## Create an Administrator IAM User<a name="create-admin-user"></a>

If you already have an administrator AWS Identity and Access Management \(IAM\) user account, go ahead and skip to one of the sections listed following\. If you don't have an administrator IAM user, we recommend that you create one and not use the root credentials of your AWS account to make requests\. To do so, see [Create an IAM User](setting-up.md#setting-up-iam)\.

For information about how to use AWS Identity and Access Management policies to control access, see [AWS\-Managed \(Predefined\) Policies for AWS Snowball Edge](access-control-managing-permissions.md#access-policy-examples-aws-managed)\.

**Note**  
 After you unlock your device, you will also want to create local users\. You will do this in a later step\.

**Important**  
There is no free tier for AWS Snowball\. To avoid unwanted charges and delays, read through the relevant import or export section following before you start creating your jobs\.

**Next:**
+ [Getting Started with AWS Snowball Edge: Your First Job](common-get-start.md)