# Insufficient Permissions When Using Athena with Amazon QuickSight<a name="troubleshoot-athena-insufficient-permissions"></a>

If you receive an "insufficient permissions" error, try these steps to resolve your problem:

1. Make sure that you granted Amazon QuickSight read\-only access to the S3 buckets used by Athena\. 

   1. To do this, choose **Manage QuickSight** from your profile icon in the top right of the screen\.

   1. Next, choose **Account Settings** and then **Edit AWS permissions**\. 

   1. On the **Edit QuickSight read\-only\-access to AWS resources** screen, choose **Choose S3 buckets**\. Verify that the appropriate S3 buckets are listed and that their check boxes are selected\. 

   1. If your bucket isn't listed under **S3 buckets linked to QuickSight account**, choose the **S3 buckets you can access across AWS** tab\. To add your bucket, type in your bucket's name and choose **Add S3 bucket**\.

1. If your data file is encrypted with an AWS KMS key, grant permissions to the Amazon QuickSight IAM role to decrypt the key\. The easiest way to do this is to use the AWS CLI\. If you don’t have the AWS CLI set up and configured, see [Configuring the AWS CLI](docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html) in the *AWS Command Line Interface User Guide\.*

   You can run the [create\-grant](https://docs.aws.amazon.com//cli/latest/reference/kms/create-grant.html) command in AWS CLI to do this\. 

   ```
   aws kms create-grant --key-id <KMS key ARN> --grantee-principal <Your Amazon QuickSight Role ARN> --operations Decrypt
   ```

   The Amazon Resource Name \(ARN\) for the Amazon QuickSight role has the format `arn:aws:iam::<account id>:role/service-role/aws-quicksight-servicerole-v<version no.>` and can be accessed from the IAM console\. To find your KMS key ARN, use the S3 console\. Go to the bucket that contains your data file and choose the **Overview** tab\. The key is located near **KMS key ID**\.