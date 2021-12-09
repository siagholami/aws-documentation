# Getting started with Transit Gateway Network Manager<a name="network-manager-getting-started"></a>

The following tasks help you become familiar with Transit Gateway Network Manager \(Network Manager\)\.

In this example, you create a global network and register your transit gateway with the global network\. You can also define and associate your on\-premises network resources with the global network\.

**Topics**
+ [Prerequisites](#network-manager-prerequisites)
+ [Step 1: Create a global network](#getting-started-create-global-network)
+ [Step 2: Register your transit gateway](#getting-started-register-tgw)
+ [Step 3: \(Optional\) Define and associate your on\-premises network resources](#getting-started-define-wan)
+ [Step 4: View and monitor your global network](#getting-started-view-global-network)

## Prerequisites<a name="network-manager-prerequisites"></a>

Before you begin, ensure that you have a transit gateway with attachments in your account\. For more information, see [Getting Started with Transit Gateways](https://docs.aws.amazon.com/vpc/latest/tgw/tgw-getting-started.html)\.

The transit gateway must be in the same AWS account as the global network\.

## Step 1: Create a global network<a name="getting-started-create-global-network"></a>

Create a global network as a container for your transit gateway\.

**To create a global network**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose **Create global network**\.

1. Enter a name and description for the global network, and choose **Create global network**\.

## Step 2: Register your transit gateway<a name="getting-started-register-tgw"></a>

Register your transit gateway in your global network\.

**To register the transit gateway**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Transit gateways**\. Choose **Register transit gateway**\.

1. Select the transit gateway in the list, and choose **Register transit gateway**\.

## Step 3: \(Optional\) Define and associate your on\-premises network resources<a name="getting-started-define-wan"></a>

You can define your on\-premises network by creating sites, links, and devices to represent objects in your network\. For more information, see the following procedures:
+ [Creating a site](on-premises-networks.md#creating-a-site)
+ [Creating a link](on-premises-networks.md#creating-a-link)
+ [Creating a device](on-premises-networks.md#creating-a-device)

You associate the device with a specific site, and with one or more links\. For more information, see [Device associations](on-premises-networks.md#device-associations)\.

Finally, create a Site\-to\-Site VPN connection attachment on your transit gateway, and associate the customer gateway with the device\. For more information, see [Customer gateway associations](on-premises-networks.md#cgw-association)\.

You can also work with one of our Partners in the AWS Partner Network \(APN\) to provision and connect your on\-premises network\. For more information, see [Transit Gateway Network Manager](https://aws.amazon.com/transit-gateway/network-manager)\.

## Step 4: View and monitor your global network<a name="getting-started-view-global-network"></a>

The Network Manager console provides a dashboard for you to view and monitor the network objects in your global network\.

**To access the dashboard for your global network**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. The **Overview** page provides an inventory of the objects in your global network\. For more information about the pages in the dashboard, see [Visualizing and monitoring your global network using the Network Manager console](network-manager-monitor-console.md)\.