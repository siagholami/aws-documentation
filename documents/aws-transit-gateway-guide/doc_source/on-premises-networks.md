# On\-premises network<a name="on-premises-networks"></a>

You can represent your on\-premises network in your global network through sites, devices, and links\. For more information, see [Defining and associating your on\-premises network](how-network-manager-works.md#nm-how-it-works-on-premises)\. You then associate a device with a site and one or more links\.

To add your on\-premises network to your global network, you associate a customer gateway with your device\. For more information about viewing the topology of your on\-premises network in Network Manager, see [Topology](network-manager-monitor-console.md#network-manager-topology)\.

All sites, devices, and links are created for a specific global network and cannot be shared with other global networks\.

**Topics**
+ [Working with sites](#working-with-sites)
+ [Working with links](#working-with-links)
+ [Working with devices](#working-with-devices)
+ [Device associations](#device-associations)
+ [Customer gateway associations](#cgw-association)

## Working with sites<a name="working-with-sites"></a>

The following procedures show you how to create, update, and delete sites\.

**Topics**
+ [Creating a site](#creating-a-site)
+ [Updating a site](#updating-a-site)
+ [Deleting a site](#deleting-a-site)

### Creating a site<a name="creating-a-site"></a>

Create a site to represent the physical location of your network\. The location information is used for visualization in the Network Manager console\.

**To create a site**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Sites**\. Choose **Create site**\.

1. For **Name** and **Description**, enter a name and description for the site\.

1. For **Address**, enter the physical address of the site, for example, `New York, NY 10004`\.

1. For **Latitude**, enter the latitude coordinates for the site, for example, `40.7128`\.

1. For **Longitude**, enter the longitude coordinates for the site, for example, `-74.0060`\.

1. Choose **Create site**\.

**Creating and viewing a site using the AWS CLI**  
Use the following commands:
+ To create a site: [create\-site](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/create-site.html)
+ To view your sites: [get\-sites](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-sites.html)

### Updating a site<a name="updating-a-site"></a>

You can update the details of your site, including the description, address, latitude, and longitude\.

**To update your site**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID for your global network\.

1. In the navigation pane, choose **Sites**, and select your site\.

1. Choose **Edit**\.

1. Update the description, address, latitude, longitude, and tags as needed\.

1. Choose **Edit site**\.

**Updating a site using the AWS CLI**  
Use the [update\-site](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/update-site.html) command\.

### Deleting a site<a name="deleting-a-site"></a>

If you no longer need a site, you can delete it\. You must first disassociate the site from any devices and delete any links for the site\.

**To delete a site**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Sites**\.

1. Select the site and choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.

**Deleting a site using the AWS CLI**  
Use the [delete\-site](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/delete-site.html) command\.

## Working with links<a name="working-with-links"></a>

The following procedures show you how to create, update, and delete links\.

**Topics**
+ [Creating a link](#creating-a-link)
+ [Updating a link](#updating-a-link)
+ [Deleting a link](#deleting-a-link)

### Creating a link<a name="creating-a-link"></a>

Create a link to represent an internet connection from a device\. A link is created for a specific site, therefore you must create a site before you create a link\.

**To create a link**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Sites**\. Choose the ID of the site for which to create the link, and the choose **Links**\.

1. Choose **Create link**\.

1. For **Name** and **Description**, enter a name and description for the link\.

1. For **Upload speed**, enter the upload speed in Mbps\.

1. For **Download speed**, enter the download speed in Mbps\.

1. For **Provider**, enter the name of the service provider\.

1. For **Type**, enter the type of link, for example, `broadband`\.

1. Choose **Create link**\.

**Creating and viewing a link using the AWS CLI**  
Use the following commands:
+ To create a link: [create\-link](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/create-link.html)
+ To view your links: [get\-links](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-links.html)

### Updating a link<a name="updating-a-link"></a>

You can update the details of your link, including the bandwidth information, description, provider, and type\.

**To update a link**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Sites** and choose the ID for the site\. Choose **Links**\.

1. Select the link and choose **Edit**\.

1. Update the link details as needed, then choose **Edit link**\.

**Updating a link using the AWS CLI**  
Use the [update\-link](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/update-link.html) command\.

### Deleting a link<a name="deleting-a-link"></a>

If you no longer need a link, you can delete it\. You must first disassociate the link from any devices and customer gateways\.

**To delete a link**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Sites** and choose the ID for the site\. Choose **Links**\.

1. Select the link and choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.

**Deleting a link using the AWS CLI**  
Use the [delete\-link](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/delete-link.html) command\.

## Working with devices<a name="working-with-devices"></a>

The following procedures show you how to create, update, and delete devices\.

**Topics**
+ [Creating a device](#creating-a-device)
+ [Updating a device](#updating-a-device)
+ [Deleting a device](#deleting-a-device)

### Creating a device<a name="creating-a-device"></a>

Create a device to represent a physical or virtual appliance\.

**To create a device**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**\. Choose **Create device**\.

1. For **Name** and **Description**, enter a name and description for the device\.

1. For **Model**, enter the device model number\.

1. For **Serial number**, enter the serial number for the device\.

1. For **Type**, enter the device type\.

1. For **Vendor**, enter the name of the vendor, for example, `Cisco`\.

1. For **Address**, enter the physical address of the site, for example, `New York, NY 10004`\.

1. For **Latitude**, enter the latitude coordinates for the site, for example, `40.7128`\.

1. For **Longitude**, enter the longitude coordinates for the site, for example, `-74.0060`\.

1. Choose **Create device**\.

**Creating and viewing a device using the AWS CLI**  
Use the following commands:
+ To create a device: [create\-device](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/create-device.html)
+ To view your devices: [get\-devices](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-devices.html)

### Updating a device<a name="updating-a-device"></a>

You can update the details of your device, including the description, model, serial number, type, vendor, and location information\.

**To update a device**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices** and select the device\.

1. Choose **Edit**\.

1. Update the device details as needed, then choose **Edit device**\.

**Updating a device using the AWS CLI**  
Use the [update\-device](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/update-device.html) command\.

### Deleting a device<a name="deleting-a-device"></a>

If you no longer need a device, you can delete it\. You must first disassociate the device from any sites, links, and customer gateways\.

**To delete a device**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**\.

1. Select the site and choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.

**Deleting a device using the AWS CLI**  
Use the [delete\-device](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/delete-device.html) command\.

## Device associations<a name="device-associations"></a>

You can associate a device with a site, and a device with one or more links\.

**Topics**
+ [Device and site associations](#device-site-association)
+ [Device and link associations](#device-link-association)

### Device and site associations<a name="device-site-association"></a>

 A site can have multiple devices associated with it, but a device can only be associated with a single site\.

**To associate a device and site**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and choose the ID of your device\.

1. Choose **Associate site**\.

1. For **Site**, choose the name of your site from the list\.

1. Choose **Edit site association**\.

You can remove the association between a device and a site\.

**To disassociate a device and site**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and choose the ID of your device\.

1. Choose **Disassociate site**\.

**Working with device and site associations using the AWS CLI**  
When you create a new device using the [create\-device](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/create-device.html) AWS CLI command, you can specify the site to associate with the device\. For an existing device, you can use the [update\-device](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/update-device.html) AWS CLI command to associate or disassociate a site\.

### Device and link associations<a name="device-link-association"></a>

A link can be associated with more than one device\. The device must be associated with a site\.

**To associate a link and a device**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and choose the ID of your device\.

1. Choose **Links**\.

1. Choose **Associate link**\.

1. Choose the link to associate, then choose **Associate link**\.

You can remove the association between a link and a device\.

**To disassociate a link and a device**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and choose the ID of your device\.

1. Choose **Links**\.

1. Select the link and choose **Disassociate**\.

**Working with device and link associations using the AWS CLI**  
You can work with device associations using the following commands\.
+ To associate a link with a device: [associate\-link](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/associate-link.html)
+ To view your link associations: [get\-link\-associations](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-link-associations.html)
+ To disassociate a link from a device: [disassociate\-link](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/disassociate-link.html)

## Customer gateway associations<a name="cgw-association"></a>

You can associate a customer gateway with your on\-premises network by associating it with a device, and optionally, a link\. The customer gateway must already be in your global network as part of a VPN attachment in your transit gateway\. If you specify a link, it must already be associated with the specified device\.

For more information about creating a customer gateway, see [Create a Customer Gateway](https://docs.aws.amazon.com/vpn/latest/s2svpn/SetUpVPNConnections.html#vpn-create-cgw) in the *AWS Site\-to\-Site VPN User Guide*\. For more information about creating a VPN attachment to a transit gateway, see [Transit Gateway VPN Attachments](https://docs.aws.amazon.com/vpc/latest/tgw/tgw-vpn-attachments.html) in *Amazon VPC Transit Gateways*\.

You can associate a customer gateway with a device and link in one of the following ways:
+ On the **Transit gateways** page
+ On the **Devices** page

------
#### [ Transit gateways page ]

**To associate a customer gateway using the Transit gateways page**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Transit gateways**, and then choose the ID of your transit gateway\.

1. Choose **On\-premises associations**\.

1. Select your customer gateway and choose **Associate**\.

1. For **Device**, select the ID of the device to associate\. For **Link**, select the ID of the link to associate\.

1. Choose **Edit on\-premises association**\.

------
#### [ Devices page ]

**To associate a customer gateway using the Devices page**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and then choose the ID of your device\.

1. Choose **On\-premises associations**\.

1. Choose **Associate**\.

1. For **Customer gateway**, select the ID of the customer gateway to associate\. For **Link**, select the ID of the link to associate\.

1. Choose **Create on\-premises association**\.

------

You can disassociate a customer gateway from a device or link in one of the following ways:
+ On the **Transit gateways** page
+ On the **Devices** page

------
#### [ Transit gateways page ]

**To disassociate a customer gateway using the Transit gateways page**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Transit gateways**, and then choose **On\-premises associations**\.

1. Select your customer gateway and choose **Disassociate**\.

------
#### [ Devices page ]

**To disassociate a customer gateway using the Devices page**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID of your global network\.

1. In the navigation pane, choose **Devices**, and then choose the ID of your device\.

1. Choose **On\-premises associations**\.

1. Select your customer gateway and choose **Disassociate**\.

------

**Working with customer gateway associations using the AWS CLI**  
You can work with customer gateway associations using the following commands\.
+ To associate a customer gateway with a device and link: [associate\-customer\-gateway](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/associate-customer-gateway.html)
+ To view your customer gateway associations: [get\-customer\-gateway\-associations](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-customer-gateway-associations.html)
+ To disassociate a customer gateway from a device and link: [disassociate\-customer\-gateway](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/disassociate-customer-gateway.html)