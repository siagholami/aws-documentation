--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Identity and Access Management in Snowball<a name="snowball-edge-iam"></a>

Every Snowball job must be authenticated\. You do this by creating and managing the IAM users in your account\. Using IAM, you can create and manage users and permissions in AWS\. 

Snowball users must have certain IAM\-related permissions to access the AWS Snowball AWS Management Console to create jobs\. An IAM user that creates an import or export job must also have access to the right Amazon Simple Storage Service \(Amazon S3\) resources, such as the Amazon S3 buckets to be used for the job\.

**Important**  
For information about using IAM locally on your device, see [Using IAM Locally](using-local-iam.md)\.

**Topics**
+ [Access Control for Snow Family Console and Creating Jobs](authentication-and-access-control.md)