# Step 3: Scheduling a migration<a name="schedule"></a>

After you complete steps 1 and 2, use the Amazon WorkDocs Migration Service to schedule the migration\. When you schedule the migration, your Amazon WorkDocs user account **Storage** setting is automatically changed to **Unlimited**\.

**Note**  
Migrating files that exceed your Amazon WorkDocs storage limit can result in additional costs\. For more information, see [Amazon WorkDocs Pricing](http://aws.amazon.com/workdocs/pricing/)\.

The Amazon WorkDocs Migration Service provides an AWS Identity and Access Management \(IAM\) policy for you to use for the migration\. With this policy, you create a new IAM role that grants the Amazon WorkDocs Migration Service access to the Amazon S3 bucket and Amazon WorkDocs site that you designate\. You also subscribe to Amazon SNS email notifications to receive updates when your migration request is scheduled, and when it begins and ends\.

**To schedule a migration**

1. From the Amazon WorkDocs console, choose **Apps**, **Migrations**\.

   1. If this is your first time accessing Amazon WorkDocs Migration Service, you are prompted to subscribe to Amazon SNS email notifications\. Subscribe, confirm in the email message that you receive, then choose **Continue**\.

1. Choose **Create Migration**\.

1. For **Source Type**, choose **Amazon S3**\.

1. Choose **Next**\.

1. For **Data Source & Validation**, under **Sample Policy**, copy the supplied IAM policy\.

1. Use the IAM policy that you copied in the previous step to create a new IAM policy and role, as follows:

   1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

   1. Choose **Policies**, **Create policy**\.

   1. Choose **JSON** and paste in the IAM policy that you copied to your clipboard earlier\.

   1. Choose **Review policy**\. Enter a policy name and description\.

   1. Choose **Create policy**\.

   1. Choose **Roles**, **Create role**\.

   1. Select **Another AWS account**\. For **Account ID**, enter one of the following:
      + For the US East \(N\. Virginia\) Region, enter `899282061130`
      + For the US West \(Oregon\) Region, enter `814301586344`
      + For the Asia Pacific \(Singapore\) Region, enter `900469912330`
      + For the Asia Pacific \(Sydney\) Region, enter `031131923584`
      + For the Asia Pacific \(Tokyo\) Region, enter `178752524102`
      + For the Europe \(Ireland\) Region, enter `191921258524`

   1. Select the new policy that you created and choose **Next: Review**\. If you don't see the new policy, choose the refresh icon\.

   1. Enter a role name and description\. Choose **Create role**\.

   1. On the **Roles** page, under **Role name**, choose the role name that you created\.

   1. On the **Summary** page, change the **Maximum CLI/API session duration** to 12 hours\.

   1. Copy the **Role ARN** to your clipboard to use in the next step\.

1. Return to the **Amazon WorkDocs Migration Service**\. For **Data Source & Validation**, under **Role ARN**, paste the role ARN from the IAM role that you copied in the previous step\.

1. For **Bucket**, select the Amazon S3 bucket to migrate the files from\.

1. Choose **Next**\.

1. For **Select a destination WorkDocs Folder**, select the destination folder in Amazon WorkDocs to migrate the files to\.

1. Choose **Next**\.

1. Under **Review**, for **Title**, enter a name for the migration\.

1. Select the date and time for the migration\.

1. Choose **Send**\.