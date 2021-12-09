# Managing notifications for an IAM user or a role<a name="manage-notifications"></a>

IAM administrators can enable or disable notifications in Amazon WorkDocs through the IAM console\.

**Note**  
Even if there is an explicit allow policy attached to a user or role that grants access to Notification APIs, administrators must use the IAM console to enable notifications for the specified user or role ARN\. Unless notifications are explicitly enabled for the user or role ARN, the applications using the user or role credentials are not able to make calls to `CreateNotificationSubscription` to subscribe and receive notifications\.

**To enable notifications**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

1. On the **Manage Your WorkDocs Sites** page, select the desired directory and choose **Actions** and then **Manage Notifications**\.

1. On the **Manage Notifications** page, choose **Enable Notifications**\.

1. Enter the ARN for the user or role you want to allow to receive notifications from your Amazon WorkDocs site\.

**To disable notifications**

1. Open the Amazon WorkDocs console at [https://console\.aws\.amazon\.com/zocalo/](https://console.aws.amazon.com/zocalo/)\.

1. On the **Manage Your WorkDocs Sites** page, select the desired directory and choose **Actions** and then **Manage Notifications**\.

1. On the **Manage Notifications** page, select the ARN that you wish to disable notifications for and choose **Disable Notifications**\.