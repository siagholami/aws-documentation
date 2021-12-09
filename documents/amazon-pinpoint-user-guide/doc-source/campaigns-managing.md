# Managing Campaigns<a name="campaigns-managing"></a>

In the Amazon Pinpoint console, you update the settings for a campaign, delete a campaign, or copy an existing campaign to a new campaign\.

**To manage a campaign**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose the project for which you want to manage campaigns\.

1. In the navigation pane, choose **Campaigns**\.

1. On the **Campaigns** page, choose the campaign that you want to manage\. Then, on the **Actions** menu, select the action that you want to take, as shown in the following image\.  
![\[The Campaigns table with a single campaign selected and the Actions menu opened. The Actions menu shows the following options: View details, View analytics, Change settings, Duplicate, and Delete.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/images/campaigns_actions_menu.png)![\[The Campaigns table with a single campaign selected and the Actions menu opened. The Actions menu shows the following options: View details, View analytics, Change settings, Duplicate, and Delete.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)![\[The Campaigns table with a single campaign selected and the Actions menu opened. The Actions menu shows the following options: View details, View analytics, Change settings, Duplicate, and Delete.\]](http://docs.aws.amazon.com/pinpoint/latest/userguide/)

   On the **Actions** menu, you can do the following:
   + **View details** – Shows the details page for the selected campaign\. On this page, you can see information about the campaign, such as the campaign type, the status of the campaign, and the number of endpoints targeted by the campaign\.
   + **View analytics** – Shows the analytics page for the selected campaign\. For more information about campaign analytics, see [Campaign Charts](analytics-campaigns.md)\.
   + **Change settings** – Change the settings for the campaign, including the target segment, the message content, and the delivery time\. You can choose this option only for campaigns that haven't been sent yet\.
   + **Duplicate** – Copy the campaign to use its settings as a template for a new campaign, in which you can change or keep any of the original settings\.
   + **Delete** – Remove the campaign from Amazon Pinpoint and stop sending messages through the campaign\.