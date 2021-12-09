# Getting started with AWS Global Accelerator<a name="getting-started"></a>

This tutorial provides the steps for getting started with AWS Global Accelerator using the console\. You can also use AWS Global Accelerator API operations to create and customize your accelerator\. At each step in this tutorial, there's a link to the corresponding API operation for completing the task programmatically\. For more information about working with AWS Global Accelerator API operations, see the [AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

**Tip**  
To explore how you can use Global Accelerator to improve performance and availability for web applications, check out the following self\-paced workshop: [AWS Global Accelerator Workshop](https://intro-to-global-accelerator.workshop.aws/en)\.

Global Accelerator is a global service that supports endpoints in multiple AWS Regions, which are listed in the [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)\.

**Tasks**
+ [ Before you begin](#getting-started-before-you-begin)
+ [ Step 1: Create an accelerator](#getting-started-accelerator)
+ [Step 2: Add listeners](#getting-started-create-listeners)
+ [Step 3: Add endpoint groups](#getting-started-add-endpoint-groups)
+ [Step 4: Add endpoints](#getting-started-add-endpoints)
+ [Step 5: Test your accelerator](#getting-started-create-and-test)
+ [Step 6: Delete your accelerator](#getting-started-delete-accelerator)

## Before you begin<a name="getting-started-before-you-begin"></a>

Before you create an accelerator, create at least one resource that you can add as an endpoint to direct traffic to\. For example, create one of the following:
+ Launch at least one Amazon EC2 instance to add as an endpoint\. For more information, see [Create Your EC2 Resources and Launch Your EC2 Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/gs-step-one-create-ec2-resources.html) in the *Amazon EC2 User Guide for Linux Instances*\. 
+ Optionally, create one or more Network Load Balancers or Application Load Balancers that includes EC2 instances\. For more information, see [Create a Network Load Balancer Application Load Balancer](https://docs.aws.amazon.com/elasticloadbalancing/latest/network/create-network-load-balancer.html) in the *User Guide for Network Load Balancers*\.
**Tip**  
You can add an accelerator at the same time that you create an Application Load Balancer, by selecting the option in the Amazon EC2 console when you create the load balancer\. For more information, see [ Create an Application Load Balancer](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/create-application-load-balancer.html)\.

When you create a resource to add to Global Accelerator, be aware of the following:
+ When you add an internal Application Load Balancer or an EC2 instance endpoint in Global Accelerator, you enable internet traffic to flow directly to and from the endpoint in Virtual Private Clouds \(VPCs\) by targeting it in a private subnet\. The VPC that contains the load balancer or EC2 instance must have an [internet gateway](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Internet_Gateway.html) attached to it, to indicate that the VPC accepts internet traffic\. For more information, see [Secure VPC connections in AWS Global Accelerator](secure-vpc-connections.md)\.
+ Global Accelerator requires your router and firewall rules to allow inbound traffic from the IP addresses associated with Route 53 health checkers to complete health checks for EC2 instance or Elastic IP address endpoints\. You can find information about the IP address ranges associated with Amazon Route 53 health checkers in [Health Checks for Your Target Groups](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/route-53-ip-addresses.html) in the *Amazon Route 53 Developer Guide*\.

**Important**  
Global Accelerator is a global service that can front application endpoints in multiple AWS Regions but you must be in the US West \(Oregon\) Region to create or update accelerators by using the AWS Management Console or AWS CLI\.

## Step 1: Create an accelerator<a name="getting-started-accelerator"></a>

To get started creating your accelerator, you enter a name for it\.

**Note**  
To complete this task by using an API operation instead of the console, see [CreateAccelerator](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateAccelerator.html) in the *AWS Global Accelerator API Reference*\.

## To create an accelerator

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. Choose **Create accelerator**\.

1. Provide a name for your accelerator\.

1. Optionally, add one or more tags to help you identify your Global Accelerator resources\.

1. Choose **Next**\.

## Step 2: Add listeners<a name="getting-started-create-listeners"></a>

Create a listener to process inbound connections from your users to Global Accelerator\.

**Note**  
To complete this task by using an API operation instead of the console, see [CreateListener](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateListener.html) in the *AWS Global Accelerator API Reference*\.

## To create a listener

1. On the **Add listener** page, enter the ports or port ranges that you want to associate with the listener\. Listeners support ports 1\-65535\.

1. Choose the protocol for the ports that you entered\.

1. Optionally, choose to enable client affinity\. Client affinity for a listener means that Global Accelerator ensures that connections from a specific source \(client\) IP address are always routed to the same endpoint\. To enable this behavior, in the dropdown list, choose **Source IP**\.

   The default is **None**, which means that client affinity is not enabled and Global Accelerator distributes traffic equally between the endpoints in the endpoint groups for the listener\.

   For more information, see [Client affinity](about-listeners-client-affinity.md)\.

1. Optionally, choose **Add listener** to add an additional listener\.

1. When you're finished adding listeners, choose **Next**\.

## Step 3: Add endpoint groups<a name="getting-started-add-endpoint-groups"></a>

Add one or more endpoint groups, each of which is associated with a specific AWS Region\.

**Note**  
To complete this task by using an API operation instead of the console, see [CreateEndpointGroup](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateEndpointGroup.html) in the *AWS Global Accelerator API Reference*\.

## To add an endpoint group

1. On the **Add endpoint groups** page, in the section for a listener, choose a **Region** from the dropdown list\.

1. Optionally, for **Traffic dial**, enter a number from 0 to 100 to set a percentage of traffic for this endpoint group\. The percentage is applied only to the traffic already directed to this endpoint group, not all listener traffic\. By default, the traffic dial for an endpoint group is set to 100 \(that is, 100%\)\. 

1. Optionally, for custom health check values, choose **Configure health checks**\. When you configure health check settings, Global Accelerator uses the settings for health checks for EC2 instance and Elastic IP address endpoints\. For Network Load Balancer and Application Load Balancer endpoints, Global Accelerator uses the health check settings that you've already configured for the load balancers themselves\. For more information, see [Health check options](about-endpoint-groups-health-check-options.md)\. 

1. Optionally, choose **Add endpoint group** to add additional endpoint groups for this listener or other listeners\.

1. Choose **Next**\.

## Step 4: Add endpoints<a name="getting-started-add-endpoints"></a>

Add one or more endpoints that are associated with specific endpoint groups\. This step isn't required, but no traffic is directed to endpoints in a Region unless the endpoints are included in an endpoint group\.

**Note**  
If you're creating your accelerator programmatically, you add endpoints as part of adding endpoint groups\. For more information, see [CreateEndpointGroup](https://docs.aws.amazon.com/global-accelerator/latest/api/API_CreateEndpointGroup.html) in the *AWS Global Accelerator API Reference*\.

## To add endpoints

1. On the **Create endpoints** page, in the section for an endpoint, choose an endpoint from the dropdown list\.

1. Optionally, for **Weight**, enter a number from 0 to 255 to set a weight for routing traffic to this endpoint\. When you add weights to endpoints, you configure Global Accelerator to route traffic based on proportions that you specify\. By default, all endpoints have a weight of 128\. For more information, see [ Endpoint weights](about-endpoints-endpoint-weights.md)\.

1. Optionally, for an Application Load Balancer endpoint, under **Preserve client IP address**, select **Preserve address**\. For more information, see [Preserve client IP addresses in AWS Global Accelerator](preserve-client-ip-address.md)\.

1. Optionally, choose **Add endpoint** to add more endpoints\.

1. Choose **Next**\.

After you choose **Next**, on the Global Accelerator dashboard you'll see a message that your accelerator is in progress\. When the process is finished, the accelerator status in the dashboard is **Active**\. 

## Step 5: Test your accelerator<a name="getting-started-create-and-test"></a>

Take steps to test your accelerator to make sure that traffic is being directed to your endpoints\. For example, run a curl command such as the following, substituting one of your accelerator's static IP addresses, to show the AWS Regions where requests are processed\. This is especially helpful if you set different weights for endpoints or adjust the traffic dial on endpoint groups\.

Run a curl command like the following, substituting one of your accelerator's static IP addresses, to call the IP address 100 times and then output a count of where each request was processed\.

```
for ((i=0;i<100;i++)); do  curl http://198.51.100.0/ >> output.txt; done; cat output.txt | sort | uniq -c ; rm output.txt;
```

If you've adjusted the traffic dial on any endpoint groups, this command can help you confirm that your accelerator is directing the correct percentages of traffic to different groups\. For more information, see the detailed examples in the following blog post, [ Traffic management with AWS Global Accelerator](https://aws.amazon.com/blogs/networking-and-content-delivery/traffic-management-with-aws-global-accelerator/)\.

## Step 6: Delete your accelerator<a name="getting-started-delete-accelerator"></a>

If you created an accelerator as a test or if you're no longer using an accelerator, you can delete it\. On the console, disable the accelerator, and then you can delete it\. You don't have to remove listeners and endpoint groups from the accelerator\.

To delete an accelerator by using an API operation instead of the console, you must first remove all listeners and endpoint groups that are associated with the accelerator as well as disable it\. For more information, see the [DeleteAccelerator](https://docs.aws.amazon.com/global-accelerator/latest/api/API_DeleteAccelerator.html) operation in the *AWS Global Accelerator API Reference*\.

Be aware of the following when you remove endpoints or endpoint groups, or delete an accelerator:
+ When you create an accelerator, Global Accelerator provides you with a set of two static IP addresses\. The IP addresses are assigned to your accelerator for as long as it exists, even if you disable the accelerator and it no longer accepts or routes traffic\. However, when you *delete* an accelerator, you lose the static IP addresses that are assigned to the accelerator, so you can no longer route traffic by using them\. As a best practice, ensure that you have permissions in place to avoid inadvertently deleting accelerators\. You can use IAM policies with Global Accelerator, for example, tag\-based permissions, to limit the users who have permissions to delete an accelerator\. For more information, see [ Tag\-based policies](auth-and-access-control.md#access-control-manage-access-tag-policies)\.
+ If you terminate an EC2 instance before you remove it from an endpoint group in Global Accelerator, and then you create another instance with the same private IP address, and health checks pass, Global Accelerator will route traffic to the new endpoint\. If you don't want this to happen, remove the EC2 instance from the endpoint group before you terminate the instance\.

## To delete an accelerator

1. Open the Global Accelerator console at [ https://us\-west\-2\.console\.aws\.amazon\.com/ec2/v2/home?region=us\-west\-2\#Global Accelerator:](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:)\. 

1. Choose the accelerator that you want to delete\.

1. Choose **Edit**\.

1. Choose **Disable accelerator**, and then choose **Save**\.

1. Choose the accelerator that you want to delete\.

1. Choose **Delete accelerator**\.

1. In the confirmation dialog box, choose **Delete**\.