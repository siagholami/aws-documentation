--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Receive the AWS Snowball device<a name="receive-export"></a>

When you receive the Snowball appliance, you'll notice that it doesn't come in a box\. The Snowball is its own physically rugged shipping container\. When the Snowball first arrives, inspect it for damage or obvious tampering\. If you notice anything that looks suspicious about the Snowball, don't connect it to your internal network\. Instead, contact [AWS Support](https://aws.amazon.com/premiumsupport/) and inform us of the issue so that a new Snowball can be shipped to you\.

**Important**  
The Snowball is the property of AWS\. Tampering with a Snowball is a violation of the AWS Acceptable Use Policy\. For more information, see [http://aws\.amazon\.com/aup/](http://aws.amazon.com/aup/)\.

Before you connect the Snowball to your network and begin transferring data, it's important to cover a few basic components of Snowball data transfer\.
+ **The Snowball** – The following is what the Snowball will look like\.  
![\[This is what a Snowball looks like.\]](http://docs.aws.amazon.com/snowball/latest/ug/images/Snowball-closed-600w.png)
+ **Data destination** – This on\-premises device will hold the data that you want to transfer from the Snowball\. It can be a single device, such as a hard drive or USB stick, or it can be separate destinations of data within your data center\. The data destination must be mounted onto your workstation in order to transfer data to it\.
+ **Workstation** – This computer hosts your mounted data destination\. You'll use this workstation to receive data from the Snowball\. We highly recommend that your workstation be a powerful computer, able to meet high demands in terms of processing, memory, and networking\. For more information, see [Workstation Specifications](specifications.md#workstationspecs)\.

**Next:** [Connect the AWS Snowball device to Your Local Network](export-connect.md) 