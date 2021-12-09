# Global networks<a name="global-networks"></a>

A global network is a container for your network objects\. When you create a global network, it's empty\. After you create it, you can register your transit gateways and define your on\-premises networks in the global network\.

**Topics**
+ [Creating a global network](#global-networks-creating)
+ [Viewing a global network](#global-networks-viewing)
+ [Updating a global network](#global-networks-updating)
+ [Deleting a global network](#global-networks-deleting)

## Creating a global network<a name="global-networks-creating"></a>

Create a global network\.

**To create a global network**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose **Create global network**\.

1. Enter a name and description for the global network\.

1. \(Optional\) Expand **Additional settings**\. To add a tag, enter a **Key** and **Value** and choose **Add tag**\.

1. Choose **Create global network**\.

**To create a global network using the AWS CLI**  
Use the [create\-global\-network](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/create-global-network.html) command\.

## Viewing a global network<a name="global-networks-viewing"></a>

You can view the details of your global network and information about the network objects in your global network\.

**To view your global network information**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. The **Overview** page contains information about the network objects in your global network\. To view details about the global network resource \(such as its ARN\), choose **Details**\. For more information about the other pages on the dashboard, see [Visualizing and monitoring your global network using the Network Manager console](network-manager-monitor-console.md)\.

**To view global network details using the AWS CLI**  
Use the [describe\-global\-networks](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/describe-global-networks.html) command\.

## Updating a global network<a name="global-networks-updating"></a>

You can modify the description or tags for a global network\.

**To update your global network**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose your global network and choose **Edit**\.

1. For **Description**, enter a new description for the global network\.

1. For **Tags**, choose **Remove tag** to remove an existing tag, or choose **Add tag** to add a new tag\.

1. Choose **Edit global network**\.

**To update a global network using the AWS CLI**  
Use the [update\-global\-network](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/update-global-network.html) command to update the description\. Use the [tag\-resource](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/tag-resource.html) and [untag\-resource](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/untag-resource.html) commands to update the tags\.

## Deleting a global network<a name="global-networks-deleting"></a>

You cannot delete a global network if there are any network objects in the global network, including transit gateways, links, devices, and sites\. You must first deregister or delete the network objects\.

**To delete your global network**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose your global network and choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.

**To delete a global network using the AWS CLI**  
Use the [delete\-global\-network](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/delete-global-network.html) command\.