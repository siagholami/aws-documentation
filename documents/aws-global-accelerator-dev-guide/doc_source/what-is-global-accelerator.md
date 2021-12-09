# What is AWS Global Accelerator?<a name="what-is-global-accelerator"></a>

AWS Global Accelerator is a service in which you create *accelerators* to improve availability and performance of your applications for local and global users\. Global Accelerator directs traffic to optimal endpoints over the AWS global network\. This improves the availability and performance of your internet applications that are used by a global audience\. Global Accelerator is a global service that supports endpoints in multiple AWS Regions, which are listed in the [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)\.

By default, Global Accelerator provides you with two static IP addresses that you associate with your accelerator\. \(Or, instead of using the IP addresses that Global Accelerator provides, you can configure these entry points to be IPv4 addresses from your own IP address ranges that you bring to Global Accelerator\.\) The static IP addresses are anycast from the AWS edge network and distribute incoming application traffic across multiple endpoint resources in multiple AWS Regions, which increases the availability of your applications\. Endpoints can be Network Load Balancers, Application Load Balancers, Amazon EC2 instances, or Elastic IP addresses that are located in one AWS Region or multiple Regions\.

**Important**  
The static IP addresses remain assigned to your accelerator for as long as it exists, even if you disable the accelerator and it no longer accepts or routes traffic\. However, when you *delete* an accelerator, you lose the static IP addresses that are assigned to it, so you can no longer route traffic by using them\. You can use IAM policies with Global Accelerator, for example, tag\-based permissions, to limit the users who have permissions to delete an accelerator\. For more information, see [ Tag\-based policies](auth-and-access-control.md#access-control-manage-access-tag-policies)\.

Global Accelerator uses the AWS global network to route traffic to the optimal regional endpoint based on health, client location, and policies that you configure\. The service reacts instantly to changes in health or configuration to ensure that internet traffic from clients is always directed to healthy endpoints\.

For a list of the AWS Regions where Global Accelerator and other services are currently supported, see the [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)\.

**Topics**
+ [AWS Global Accelerator components](introduction-components.md)
+ [How AWS Global Accelerator works](introduction-how-it-works.md)
+ [Location and IP address ranges of Global Accelerator edge servers](introduction-ip-ranges.md)
+ [AWS Global Accelerator use cases](introduction-benefits-of-migrating.md)
+ [AWS Global Accelerator Speed Comparison Tool](introduction-speed-comparison-tool.md)
+ [How to get started with AWS Global Accelerator](introduction-get-started.md)
+ [Tagging in AWS Global Accelerator](tagging-in-global-accelerator.md)
+ [Pricing for AWS Global Accelerator](introduction-pricing.md)