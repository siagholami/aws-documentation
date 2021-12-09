# Global Suppression List<a name="channels-email-manage-suppression-list"></a>

When an Amazon Pinpoint customer sends an email, and that email results in a hard bounce, Amazon Pinpoint adds the destination email address to a suppression list\. This suppression list is *global* because it applies equally to all Amazon Pinpoint accounts in all AWS Regions\.

When you attempt to send a message to an address that's on the suppression list, Amazon Pinpoint accepts the message, but immediately counts it as a hard bounce, and doesn't attempt to send it\.

If an email address is on the global suppression list, but you know that the address is valid, you can complete the procedure in this section to remove the address from the suppression list\.

**Note**  
This capability isn't available in the Amazon Pinpoint console in the Asia Pacific \(Mumbai\) and Europe \(Frankfurt\) AWS Regions\. However, because the same suppression list applies to all Regions, you can access the Amazon Pinpoint console from a different Region, and then use the following steps to remove email addresses from the suppression list\.

**To remove an address from the suppression list**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose a project that uses the email channel\.

1. In the navigation pane, under **Settings**, choose **Email**\.

1. On the **Suppression list** tab, choose **Submit a removal request**\. 

1. For **Email address to remove**, enter the email address that you want to remove from the suppression list\. 

1. Complete the verification test, and then choose **Submit**\. 

When you submit your request, the address is immediately removed from the suppresssion list in all AWS Regions where Amazon Pinpoint is available\. However, the email address can be added to the suppression list again if it produces a hard bounce in the future\.