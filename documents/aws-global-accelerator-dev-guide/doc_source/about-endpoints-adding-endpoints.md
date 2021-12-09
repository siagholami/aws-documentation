# Adding, editing, or removing an endpoint<a name="about-endpoints-adding-endpoints"></a>

You add endpoints to endpoint groups so that traffic can be directed to your resources\. You can edit an endpoint to change the weight for the endpoint\. Or you can remove an endpoint from your accelerator by removing it from an endpoint group\. Removing an endpoint doesn't affect the endpoint itself, but Global Accelerator can no longer direct traffic to that resource\.

You can add or remove endpoints from endpoint groups based on usage\. For example, if demand on your application increases, you can add more endpoints to one or more endpoint groups to handle the increased traffic\. Global Accelerator starts routing requests to an endpoint as soon as you add it and the endpoint passes the initial health checks\. You can manage traffic to endpoints by adjusting the weights on an endpoint, to send proportionally more or less traffic to the endpoint\.

If you're adding an endpoint with client IP address preservation, first review the information in [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md) and [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)\.

You can remove endpoints from your endpoint groups, for example, if you need to service your endpoints\. Removing an endpoint takes it out of the endpoint group, but does not affect the endpoint otherwise\. Global Accelerator stops directing traffic to an endpoint as soon as you remove it from an endpoint group\. The endpoint goes into a state where it waits for all current requests to be completed so there's no interruption for client traffic that is in progress\. You can add the endpoint back to the endpoint group when you’re ready for it to resume receiving requests\.

This section explains how to work with endpoints on the AWS Global Accelerator console\. If you want to use API operations with AWS Global Accelerator, see the [ AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

# To add an endpoint

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, for **Listener ID**, choose the ID of a listener\.

1. In the **Endpoint groups** section, for **Endpoint group ID**, choose the ID of the endpoint group that you want to add an endpoint to\.

1. In the **Endpoints** section, choose **Add endpoint**\.

1. On the **Add endpoints** page, choose an endpoint from the dropdown list\.

1. Optionally, for **Weight**, enter a number from 0 to 255 to set a weight for routing traffic to this endpoint\. When you add weights to endpoints, you configure Global Accelerator to route traffic based on proportions that you specify\. By default, all endpoints have a weight of 128\. For more information, see [ Endpoint weights](about-endpoints-endpoint-weights.md)\.

1. Optionally, enable client IP address preservation for an internet\-facing Application Load Balancer endpoint\. Under **Preserve client IP address**, select **Preserve address**\. 

   This option is always selected for internal Application Load Balancer and EC2 instance endpoints, and never selected for Network Load Balancer and Elastic IP address endpoints\. For more information, see [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)\.
**Note**  
Before you add and begin to route traffic to endpoints that preserve the client IP address, make sure that all your required security configurations, for example, security groups, are updated to include the user client IP address on allow lists\.

1. Choose **Add endpoint**\.

# To edit an endpoint

You can edit an endpoint configuration to change the weight\. For more information, see [ Endpoint weights](about-endpoints-endpoint-weights.md)\.

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, for **Listener ID**, choose the ID of a listener\.

1. In the **Endpoint groups** section, for **Endpoint group ID**, choose the ID of the endpoint group\.

1. Choose **Edit endpoint**\.

1. On the **Edit endpoint** page, make updates, and then choose **Save**\.

# To remove an endpoint

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, for **Listener ID**, choose the ID of a listener\.

1. In the **Endpoint groups** section, for **Endpoint group ID**, choose the ID of the endpoint group\.

1. Choose **Remove endpoint**\.

1. In the confirmation dialog box, choose **Remove**\.