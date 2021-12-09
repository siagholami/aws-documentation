# Add an accelerator when you create a load balancer<a name="about-accelerators.alb-accelerator"></a>

When you create an Application Load Balancer in the AWS Management Console, you can optionally [ add an accelerator at the same time](https://docs.aws.amazon.com/elasticloadbalancing/latest/application/create-application-load-balancer.html)\. Elastic Load Balancing and Global Accelerator work together to transparently add the accelerator for you\. The accelerator is created in your account, with the load balancer as an endpoint\. Using an accelerator provides static IP addresses and improves the availability and performance of your applications\. 

**Important**  
To create an accelerator, you must have the correct permissions in place\. For more information, see [Permissions required for console access, authentication management, and access control](auth-and-access-control.md#auth_access_required-permissions)\.

## Configure and view your accelerator<a name="about-accelerators.elb-accelerator.config"></a>

You must update your DNS configuration to direct traffic to the static IP addresses or DNS name for the accelerator\. Traffic won't go through the accelerator to your load balancer until your configuration changes are complete\. 

After you create your load balancer by choosing the Global Accelerator add\-on on the Amazon EC2 console, go to the **Integrated services** tab to see the static IP addresses and Domain Name System \(DNS\) name for your accelerator\. You use this information to start routing user traffic to the load balancer over the AWS global network\. For more information about the DNS name assigned to your accelerator, see [Support for DNS addressing in Global Accelerator](about-accelerators.dns-addressing.md)\.

You can view and configure your accelerator by [ navigating to Global Accelerator](https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#GlobalAccelerator:) in the AWS Management Console\. For example, you can see the accelerators that are associated with your account or add additional load balancers to your accelerator\. For more information, see [Viewing your accelerators](about-accelerators.viewing.md) and [ Creating or updating an accelerator](about-accelerators.creating-editing.md)\.

## Pricing<a name="about-accelerators.elb-accelerator.pricing"></a>

With AWS Global Accelerator, you pay only for what you use\. You are charged an hourly rate and data transfer costs for each accelerator in your account\. For more information, see [ AWS Global Accelerator Pricing](https://aws.amazon.com/global-accelerator/pricing)\.

## Stop using the accelerator<a name="about-accelerators.elb-accelerator.deleting"></a>

If you'd like to stop routing traffic through Global Accelerator to your load balancer, do the following:

1. Update your DNS configuration to point your traffic directly to the load balancer\.

1. Delete the load balancer from the accelerator\. For more information, see *To remove an endpoint* in [Adding, editing, or removing an endpoint](about-endpoints-adding-endpoints.md)\.

1. Delete the accelerator\. For more information, see [ Deleting an accelerator](about-accelerators.deleting.md)\.