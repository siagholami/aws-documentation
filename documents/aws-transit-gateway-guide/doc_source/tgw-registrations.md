# Transit gateway registrations<a name="tgw-registrations"></a>

You can register your existing transit gateways with a global network\. Any transit gateway attachments \(such as VPCs, VPN connections, and AWS Direct Connect gateways\) are automatically included in your global network\.

You cannot create, delete, or modify your transit gateways and their attachments using the Network Manager console or APIs\. To work with transit gateways, use the Amazon VPC console or the Amazon EC2 APIs\.

You can register a transit gateway with one global network only\. You can register transit gateways that are in the same AWS account as the global network\.

**Topics**
+ [Registering a transit gateway](#register-tgw)
+ [Viewing your registered transit gateways](#view-registered-tgws)
+ [Deregistering a transit gateway](#deregister-tgw)

## Registering a transit gateway<a name="register-tgw"></a>

Register a transit gateway with a global network\. You cannot register a transit gateway with more than one global network\.

**To register a transit gateway**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID for your global network\.

1. In the navigation pane, choose **Transit gateways**\. Choose **Register transit gateway**\.

1. Select the transit gateway in the list, and choose **Register transit gateway**\.

**To register a transit gateway using the AWS CLI**  
Use the [register\-transit\-gateway](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/register-transit-gateway.html) command\.

## Viewing your registered transit gateways<a name="view-registered-tgws"></a>

View the registered transit gateways in your global network\.

**To view your registered transit gateways**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID for your global network\.

1. In the navigation pane, choose **Transit gateways**\.

1. The **Transit gateways** page lists your registered transit gateways\. Choose the ID of transit gateway to view its details\.

**To view your registered transit gateways using the AWS CLI**  
Use the [get\-transit\-gateway\-registrations](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/get-transit-gateway-registrations.html) command\.

## Deregistering a transit gateway<a name="deregister-tgw"></a>

Deregister a transit gateway from a global network\.

**To deregister a transit gateway**

1. Open the Network Manager console at [https://console\.aws\.amazon\.com/networkmanager/](https://console.aws.amazon.com/networkmanager/)\. 

1. In the navigation pane, choose **Global networks**\.

1. Choose the ID for your global network\.

1. In the navigation pane, choose **Transit gateways**\. 

1. Select your transit gateway, and choose **Deregister**\.

**To deregister a transit gateway using the AWS CLI**  
Use the [deregister\-transit\-gateway](https://docs.aws.amazon.com/cli/latest/reference/networkmanager/deregister-transit-gateway.html) command\.