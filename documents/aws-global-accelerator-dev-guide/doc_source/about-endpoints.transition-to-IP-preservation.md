# Transitioning endpoints to use client IP address preservation<a name="about-endpoints.transition-to-IP-preservation"></a>

Follow the guidance in this section to transition one or more endpoints in your accelerator to endpoints that preserve the user’s client IP address\. You can optionally choose to transition an Application Load Balancer endpoint or an Elastic IP address endpoint to a corresponding endpoint—an Application Load Balancer or an EC2 instance—that has client IP address preservation\. For more information, see [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)\.

We recommend that you transition to using client IP address preservation slowly\. First, add new Application Load Balancer or EC2 instance endpoints that you enable to preserve the client IP address\. Then slowly move traffic from existing endpoints to the new endpoints by configuring weights on the endpoints\. 

**Important**  
Before you begin to route traffic to endpoints that preserve the client IP address, make sure that all the configurations in which you’ve included Global Accelerator client IP addresses on allow lists are updated to include the user client IP address instead\.

Client IP address preservation is available only in specific AWS Regions\. For more information, see [Supported AWS Regions for client IP address preservation](preserve-client-ip-address.regions.md)\. 

This section explains how to work with endpoint groups on the AWS Global Accelerator console\. If you want to use API operations with Global Accelerator, see the [ AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

After you move a small amount of traffic to the new endpoint with client IP address preservation, test to make sure that your configuration is working as you expect it to\. Then gradually increase the proportion of traffic to the new endpoint by adjusting the weights on the corresponding endpoints\.

To transition to endpoints that preserve client IP addresses, start by following the steps here to add a new endpoint and, for internet\-facing Application Load Balancer endpoints, enable client IP address preservation\. \(The client IP address preservation option is always selected for internal Application Load Balancers and EC2 instances\.\)

# To add an endpoint with client IP address preservation

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. On the **accelerators** page, choose an accelerator\.

1. In the **Listeners** section, choose a listener\.

1. In the **Endpoint group** section, choose an endpoint group\.

1. In the **Endpoints** section, choose **Add endpoint**\.

1. On the **Add endpoints** page, in the **Endpoints** dropdown list, choose an Application Load Balancer endpoint or an EC2 instance endpoint\.

1. In the **Weight** field, choose a low number compared to the weights that are set for your existing endpoints\. For example, if the weight for a corresponding Application Load Balancer is 255, you could enter a weight of 5 for the new Application Load Balancer, to start with\. For more information, see [ Endpoint weights](about-endpoints-endpoint-weights.md)\.

1. For a new external\-facing Application Load Balancer endpoint, under **Preserve client IP address**, select **Preserve address**\. \(This option is always selected for internal Application Load Balancers and EC2 instances\.\)

1. Choose **Save changes**\.

Next, follow the steps here to edit the corresponding existing endpoints \(that you're replacing with the new endpoints with client IP address preservation\) to reduce the weights for existing endpoints so that less traffic goes to them\.

# To reduce traffic for the existing endpoints

1. On the **Endpoint group** page, choose an existing endpoint that doesn't have client IP address preservation\.

1. Choose **Edit**\.

1. On the **Edit endpoint** page, in the **Weight** field, enter a lower number than the current number\. For example, if the weight for an existing endpoint is 255, you could enter a weight of 220 for the new endpoint \(with client IP address preservation\)\.

1. Choose **Save changes**\.

After you’ve tested with a small portion of the original traffic by setting the weight for the new endpoint to a low number, you can slowly transition all the traffic by continuing to adjust the weights for the original and new endpoints\.

For example, say you start with an existing Application Load Balancer with a weight set to 200, and you add a new Application Load Balancer endpoint with client IP address preservation enabled with a weight set to 5\. Gradually shift traffic from the original Application Load Balancer to the new Application Load Balancer by increasing the weight for the new Application Load Balancer and decreasing the weight for the original Application Load Balancer\. For example: 
+ Original weight 190/new weight 10
+ Original weight 180/new weight 20
+ Original weight 170/new weight 30, and so on\.

When you have decreased the weight to 0 for the original endpoint, all traffic \(in this example scenario\) goes to the new Application Load Balancer endpoint, which includes client IP address preservation\. 

If you have additional endpoints—Application Load Balancers or EC2 instances—that you want to transition to use client IP address preservation, repeat the steps in this section to transition them\.

If you need to revert your configuration for an endpoint so that traffic to the endpoint doesn't preserve the client IP address, you can do that at any time: increase the weight for the endpoint that does *not* have client IP address preservation to the original value, and decrease the weight for the endpoint *with* client IP address preservation to 0\.