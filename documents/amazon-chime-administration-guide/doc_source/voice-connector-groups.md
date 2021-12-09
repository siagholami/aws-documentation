# Managing Amazon Chime Voice Connector groups<a name="voice-connector-groups"></a>

**How an Amazon Chime Voice Connector group works**  
You can create an Amazon Chime Voice Connector group and add Amazon Chime Voice Connectors to it that are created in different AWS Regions\. This allows incoming calls to fail over across Regions, which creates a fault\-tolerant mechanism for fallback in case of availability events\.

For example, an Amazon Chime Voice Connector group is created with two Amazon Chime Voice Connectors assigned to it\. One Amazon Chime Voice Connector is in the US East \(N\. Virginia\) Region, and the other Amazon Chime Voice Connector is in the US West \(Oregon\) Region\.

An incoming call is placed to a phone number associated with the Amazon Chime Voice Connector in the US East \(N\. Virginia\) Region\. However, there is a connectivity issue in that Region, so the call is then routed through the US West \(Oregon\) Region\.

**Get started with an Amazon Chime Voice Connector group**  
To get started, first create Amazon Chime Voice Connectors in different AWS Regions\. Then, create an Amazon Chime Voice Connector group and assign the Amazon Chime Voice Connectors to it\. You can also provision phone numbers for your Amazon Chime Voice Connector group from your Amazon Chime **Phone number management** inventory\. For more information, see [Provisioning phone numbers](provision-phone.md)\. For more information about creating Amazon Chime Voice Connectors in different AWS Regions, see [Managing Amazon Chime Voice Connectors](voice-connectors.md)\.

**Topics**
+ [Creating an Amazon Chime Voice Connector group](#create-voicecon-group)
+ [Editing an Amazon Chime Voice Connector group](#edit-voicecon-group)
+ [Assigning and unassigning phone numbers for an Amazon Chime Voice Connector group](#assign-voicecon-group)
+ [Deleting an Amazon Chime Voice Connector group](#delete-voicecon-group)

## Creating an Amazon Chime Voice Connector group<a name="create-voicecon-group"></a>

You can create up to three Amazon Chime Voice Connector groups for your account\.

**To create an Amazon Chime Voice Connector group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose **Create group**\.

1. For **Voice connector group name**, enter a name for the group\.

1. Choose **Create**\.

## Editing an Amazon Chime Voice Connector group<a name="edit-voicecon-group"></a>

After you create an Amazon Chime Voice Connector group, you can add or remove Amazon Chime Voice Connectors for it\. You can also edit the priority for the Amazon Chime Voice Connectors in the group\.

**To add Amazon Chime Voice Connectors to a group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to edit\.

1. For **Actions**, choose **Add**\.

1. For **Choose voice connectors**, select the Amazon Chime Voice Connectors to add to the group\.

1. Choose **Add**\.

**To edit Amazon Chime Voice Connector priority in a group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to edit\.

1. For **Actions**, choose **Edit priority**\.

1. For **Edit voice connector priority ranking**, enter a different priority ranking for each Amazon Chime Voice Connector\. 1 is the highest priority\. Higher priority Amazon Chime Voice Connectors are attempted first\.

1. Choose **Save**\.

**To remove Amazon Chime Voice Connectors from a group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to edit\.

1. For **Actions**, choose **Remove**\.

1. For **Choose voice connectors**, select the Amazon Chime Voice Connectors to remove\.

1. Choose **Remove**\.

## Assigning and unassigning phone numbers for an Amazon Chime Voice Connector group<a name="assign-voicecon-group"></a>

You can assign and unassign phone numbers for an Amazon Chime Voice Connector group in the Amazon Chime console\.

**To assign phone numbers to an Amazon Chime Voice Connector group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to edit\.

1. Choose **Phone numbers**\.

1. Choose **Assign from inventory**\.

1. Select one or more phone numbers to assign to the Amazon Chime Voice Connector group\.

1. Choose **Assign from inventory**\.

You can also choose **Reassign** to reassign phone numbers with the **Voice Connector** product type\. This lets you reassign these numbers from one Amazon Chime Voice Connector or Amazon Chime Voice Connector group to another\.

**To unassign phone numbers from an Amazon Chime Voice Connector group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to edit\.

1. Choose **Phone numbers**\.

1. Select the phone numbers that you want from the Amazon Chime Voice Connector group, and choose **Unassign**\.

1. Choose **Unassign**\.

## Deleting an Amazon Chime Voice Connector group<a name="delete-voicecon-group"></a>

Before you can delete an Amazon Chime Voice Connector group, you must unassign all Amazon Chime Voice Connectors and phone numbers from it\. For more information, see the previous section\.

**To delete an Amazon Chime Voice Connector group**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connector groups**\.

1. Choose the name of the Amazon Chime Voice Connector group to delete\.

1. Choose **Delete group**\.

1. Select the check box, and choose **Delete**\.