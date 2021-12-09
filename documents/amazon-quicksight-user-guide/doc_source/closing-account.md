# Canceling Your Amazon QuickSight Subscription and Closing the Account<a name="closing-account"></a>

If you want to close your Amazon QuickSight account, you can unsubscribe from the service\. To unsubscribe, you must be signed in using the IAM account or AWS root account that was used to create your Amazon QuickSight account\.

Use the following procedure to unsubscribe from Amazon QuickSight\. 

1. Choose your user name on the application bar and then choose **Manage QuickSight**\.

1. Choose **Account settings**\.

1. Choose **Unsubscribe**\.

1. \(For Amazon QuickSight Enterprise edition accounts only\) On the AWS sign\-in page, enter your AWS or IAM credentials\.

1. 
**Note**  
This step applies only to early adopters of Amazon QuickSight\. Amazon QuickSight accounts created after the preview period don't see these options\.

   \(Optional\) If you prefer to use the AWS Management Console to manually delete the Simple AD directory or VPC that Amazon QuickSight used for user management, deselect to uncheck **Delete Simple AD directory** or **Delete VPC**\. 

   However, we strongly recommend leaving these selected \(checked\) so that these resources are automatically removed\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/unsubscribe3.png)

1. Choose **Unsubscribe**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/quicksight/latest/user/images/unsubscribe2.png)

**Note**  
If you need to delete your Amazon QuickSight account, even when you can't access Amazon QuickSight to unsubscribe, sign in to AWS and use the following link to open [the unsubscribe screen](https://us-east-1.quicksight.aws.amazon.com/sn/console/unsubscribe): `https://us-east-1.quicksight.aws.amazon.com/sn/console/unsubscribe`\. This approach works no matter what AWS Regions you use\. It deletes all data, analyses, Amazon QuickSight users, and Amazon QuickSight administrators\. If you have difficulties, contact AWS Support\.   
Unsubscribing deletes all users, data, and assets \(for example, data sets, data sources, queries, dashboards, analyses, settings, and so on\)\. You can't undo this action\. However, after your account is unsubscribed, you can create a new Amazon QuickSight account using any edition and user authorization method\.  
Closing your Amazon QuickSight account, also called unsubscribing, doesn't close your AWS account\. If you also want to close the associated AWS account, see [Closing an AWS Account](https://docs.aws.amazon.com//awsaccountbilling/latest/aboutv2/close-account.html)\.