# Accelerators in AWS Global Accelerator<a name="about-accelerators"></a>

An *accelerator* in AWS Global Accelerator directs traffic to optimal endpoints over the AWS global network to improve the availability and performance of your internet applications that have a global audience\. Each accelerator includes one or more listeners\. A listener processes inbound connections from clients to Global Accelerator, based on the protocol and port \(or port range\) that you configure\. 

When you create an accelerator, by default, Global Accelerator provides you with a set of two static IP addresses\. If you bring your own IP address range to AWS \(BYOIP\), you can instead assign static IP addresses from your own pool to use with your accelerator\. For more information, see [Bring your own IP addresses \(BYOIP\) in AWS Global Accelerator](using-byoip.md)\.

**Important**  
The IP addresses are assigned to your accelerator for as long as it exists, even if you disable the accelerator and it no longer accepts or routes traffic\. However, when you *delete* an accelerator, you lose the Global Accelerator static IP addresses that are assigned to the accelerator, so you can no longer route traffic by using them\. As a best practice, ensure that you have permissions in place to avoid inadvertently deleting accelerators\. You can use IAM policies with Global Accelerator, for example, tag\-based permissions, to limit the users who have permissions to delete an accelerator\. For more information, see [ Tag\-based policies](auth-and-access-control.md#access-control-manage-access-tag-policies)\.

This section includes steps to create, edit, or delete an accelerator on the Global Accelerator console\. If you want to use API operations with Global Accelerator, see the [ AWS Global Accelerator API Reference](https://docs.aws.amazon.com/global-accelerator/latest/api/Welcome.html)\.

**Topics**
+ [Creating or updating an accelerator](about-accelerators.creating-editing.md)
+ [Deleting an accelerator](about-accelerators.deleting.md)
+ [Viewing your accelerators](about-accelerators.viewing.md)
+ [Add an accelerator when you create a load balancer](about-accelerators.alb-accelerator.md)
+ [Bring your own IP addresses \(BYOIP\) in AWS Global Accelerator](using-byoip.md)
+ [Support for DNS addressing in Global Accelerator](about-accelerators.dns-addressing.md)
+ [Route custom domain traffic to your accelerator](about-accelerators.mapping-your-custom-domain.md)