# Setting mailbox retention policies<a name="mailbox-retention-policy"></a>

Set mailbox retention policies for your Amazon WorkMail organization that automatically delete email messages from user mailboxes after a time period that you choose\. You can choose which mailbox folders to apply retention policies to, and choose whether to set different retention policies for different folders\. Mailbox retention policies apply to the selected folders in all of the user mailboxes in your organization\. Users cannot override the retention policies\.

**To set a mailbox retention policy**

1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

1. For **Organizations**, choose the name of your organization\.

1. Choose **Retention policy**\.

1. For **Folder actions**, next to each mailbox folder that you want to include in the policy, select **Delete** or **Permanently delete**\.

1. Enter the number of days to keep the email messages in each mailbox folder before deleting them\.

1. Choose **Save**\.

It can take up to 48 hours to apply the retention policies for your organization\. If you choose the **Delete** folder action, users can recover deleted email messages from the Amazon WorkMail web application and supported clients\. If you choose the **Permanently delete** folder action, email messages cannot be recovered after they are deleted\.

The number of days in a retention policy are counted starting with the day that an email message is placed in the selected folder\. For example, if a user moves an email message to their **Deleted Items** folder, the retention policy deletes the email message after the number of days you set for the **Deleted Items** folder\. When a user sends an email message and it appears in their **Sent Items** folder, the retention policy deletes the email messge after the number of days you set for the **Sent Items** folder\. Anytime a user moves an email message from one folder to another, the retention policy deletes the email message after the number of days you set for the destination folder\.