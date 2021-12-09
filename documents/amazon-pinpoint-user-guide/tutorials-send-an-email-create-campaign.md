# Step 4: Create a Campaign<a name="tutorials-send-an-email-create-campaign"></a>

After you create a segment, you can create a *campaign* and schedule Amazon Pinpoint to send it to your segment\.

In Amazon Pinpoint, a campaign refers to a single message that you send to a segment\. If you've used other digital user engagement tools in the past, you might have used phrases like "tactics" or "campaign elements" to refer to the same concept\.

**To create a new campaign**

1. In the navigation pane, choose **Campaigns**, and then choose **Create a campaign**\.

1. For **Campaign name**, enter a name for the campaign\. 

1. Under **Campaign type**, choose **Standard campaign**, and then choose **Next**\.

1. On the **Choose a segment** page, choose **Use an existing segment**\. Then, for **Segment**, choose the segment that you created in the previous section\. Choose **Next step**\.

1. On the **Create your message** page, do the following:

   1. Under **Choose a channel for this campaign**, choose **Email**\.

   1. Under **Email details**, for **Message content**, choose **Create a new message**\.

   1. For **Subject**, enter the subject line of the email\. 

   1. For **Message**, enter the body of the email\.
**Tip**  
You can enter the email body by using either HTML or Design view\. In the HTML view, you can manually enter HTML content for the email body, including formatting, links, and other features that you want to include in the message\. In the Design view, you can use a rich text editor to enter the content, and you can use the formatting toolbar to apply formatting and add links and other features to the content\. To switch views, choose **HTML** or **Design** from the view selector above the message editor\.  
You can also include personalized content in your message\. You do this by adding the name of an attribute from the spreadsheet that you imported into Amazon Pinpoint\. When you specify an attribute in this way, surround the attribute name with two sets of curly braces\. For example, you could include the recipient's first name in the body of the message by typing `{{User.UserAttributes.FirstName}}` in the body of the message\.

   1. When you finish, choose **Next**\.

1. On the **Schedule your campaign** page, for **How often should this campaign be sent?**, choose **Immediately**, and then choose **Next**\.
**Note**  
You can also choose to schedule the delivery of your message for a specific date and time\. To schedule the delivery of your message, choose **Once**, and then specify the date and time when you want Amazon Pinpoint to send the email\.   
If you want to send the message on a recurring basis, choose one of the other schedule options, such as **Daily** or **Weekly**, and then specify the start and end times\.

1. On the **Review and launch** page, confirm that the campaign is set up correctly, and then choose **Launch campaign**\.

**Next:** [Next Steps »](tutorials-send-an-email-next-steps.md)