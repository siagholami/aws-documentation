# I Can't Connect to Amazon Athena<a name="troubleshoot-connect-athena"></a>

You get an insufficient permissions error when you run a query and the permissions aren't configured\. To verify that you can connect Amazon QuickSight to Amazon Athena, check these settings: 
+ AWS resource permissions inside of Amazon QuickSight
+ IAM \(IAM\) policies
+ Amazon S3 location
+ Query results location
+ AWS KMS key policy \(for encrypted data sets only\)

Use the following procedure to make sure that you authorized Amazon QuickSight to use Athena\. Permissions to AWS resources apply to all Amazon QuickSight users\.

**To authorize Amazon QuickSight to access Athena**

1. In the AWS Region list at top right, choose the US East \(N\. Virginia\) Region\. You use this AWS Region temporarily while you edit your account permissions\. 

1. Open Amazon QuickSight, choose your profile name at top right, and then choose **Manage QuickSight**\. 

1. Choose **Account Settings**, on the left\. 

1. On the **Account Settings** page, choose **Edit AWS permissions**\. If **Athena** is not enabled \(selected\), select it now\. 

1. Verify that you enabled access to the Amazon S3 buckets for your Athena query:

   1. On the **Edit QuickSight read\-only access to AWS resources** page, find Amazon S3\. 

      If Amazon S3 is not enabled \(selected\), select it now\. 

   1. Choose **Choose S3 buckets** to choose individual buckets\.

   1. Choose the buckets that you want to access from your Athena query, and then choose **Select buckets** to confirm\.

1. On the **Edit QuickSight read\-only access to AWS resources** page, choose **Apply**\. 

1. If you changed your AWS Region during the first step of this process, change it back to the AWS Region that you want to use\.

Your AWS Identity and Access Management \(IAM\) policies must grant permissions to specific actions\. Your IAM user or role must be able to read and write both the input and the output of the S3 buckets that Athena uses for your query\.

**To verify that your IAM policies have permission to use S3 buckets for your query**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Locate the IAM user or role you are using\. Choose the user or role name to see the associated policies\.

1. Verify that the policy has the correct permissions\. Choose a policy you want to verify, then choose **Edit policy**\. Use the visual editor, which opens by default\. If you have the JSON editor open instead, choose the **Visual editor** tab\. 

1. Choose the S3 entry in the list to see its contents\. The policy needs to grant permissions to list, read, and write\. If S3 is not in the list, or it doesn't have the correct permissions, you can add them here\.

The IAM user needs access to read and write to the results location in S3\. By default, Athena stores query results in `aws-athena-query-results-<ACCOUNTID>-<REGION>`\. However, you might be using a different S3 bucket\. Also, if the data set is encrypted, the IAM user needs to be a key user in the specified KMS key's policy\.

**Important**  
Do not put the endpoint in the S3 URL\.   
This format is correct: `s3://bucket/path`  
This format generates an "Access Denied" error: **s3://us\-east\-1\.amazonaws\.com/bucket/path**

**To set permissions to your Athena query results location**

1. Open the Athena console at [https://console\.aws\.amazon\.com/athena/](https://console.aws.amazon.com/athena/home)\.

1. Choose **Settings** and get the value in **Query result location**\. If **Encrypt query results** is enabled \(selected\), check whether it uses SSE\-KMS or CSE\-KMS, and note the key\. 

1. Make sure that your IAM user has access to the correct bucket by opening the S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\. Alternatively, if you are managing access with an access control list \(ACL\), check the ACLs\. 

1. If your data set is encrypted \(**Encrypt query results** is enabled\), make sure that the IAM user or role is added as a key user in that AWS KMS key's policy\. You can access KMS settings in IAM\.

**To grant access to the S3 bucket used by Athena**

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. Choose the S3 bucket used by Athena in the **Query result location**\. 

1. On the **Permissions** tab, verify the permissions\.
