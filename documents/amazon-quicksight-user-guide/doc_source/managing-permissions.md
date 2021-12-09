# Managing Amazon QuickSight Permissions to AWS Resources<a name="managing-permissions"></a>

As part of signing up for Amazon QuickSight, you set Amazon QuickSight permissions to your AWS resources\. You can edit those permissions to change the level of access that Amazon QuickSight has to these resources\. To edit these permissions, you must be signed in using the IAM account or AWS root account used to create your Amazon QuickSight account\. Alternatively, you can be signed in as an IAM user with administrative privileges and the permissions described in the **Set Amazon QuickSight permissions to AWS resources** row of the table shown in [Setting Your IAM Policy](set-iam-policy.md)\. 

**Important**  
You should only edit Amazon QuickSight permissions to your AWS resources from within Amazon QuickSight\. If you edit these permissions directly using the IAM Management Console, you can't edit them from Amazon QuickSight\. 

**To edit Amazon QuickSight permissions to your AWS resources**

1. Choose your user name on the application bar, and then choose **Manage QuickSight**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/admin-menu.png)

1. Choose **Account settings**\.

1. Under **Account permissions**, choose **Edit AWS Permissions**\.

1. \(For Amazon QuickSight Enterprise edition accounts only\) On the AWS sign\-in page, enter your AWS or IAM credentials\.

1. On the **Edit QuickSight read\-only access to AWS resources** page, select **Enable autodiscovery of your data and users in your AWS Redshift, RDS, and IAM services**\. Doing this allows Amazon QuickSight to autodiscover any of these types of resources associated with your AWS account\. Alternatively, expand this section and choose the individual options for the resources that you want to use with Amazon QuickSight\.

1. If you have one or more Amazon S3 buckets, select the **Amazon S3 \(all buckets\)** check box to edit Amazon QuickSight access to them\. For **Choose Amazon S3 buckets**, choose the buckets you want to make available to Amazon QuickSight, and then choose **Select buckets**\.

1. If you have Amazon Athena databases, choose **Athena** to allow Amazon QuickSight to access them\.

1. Choose **Apply**\.

**Note**  
The `QuickSightAthena` managed policy contains the necessary permissions for Amazon QuickSight to interact with Athena\. However, it doesn't have permissions for input buckets\. Managed policies can't be changed\. So, even if you are using this policy you still need to enable access to the S3 buckets\.

If you have difficulties accessing Athena, see [Troubleshooting Issues When Using Athena with Amazon QuickSight](troubleshoot-athena.md)\.