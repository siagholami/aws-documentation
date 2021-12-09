# AZ IDs for Your Resources<a name="working-with-az-ids"></a>

To ensure that resources are distributed across the Availability Zones for a Region, we independently map Availability Zones to names for each account\. For example, the Availability Zone `us-east-1a` for your AWS account might not have the same location as `us-east-1a` for another AWS account\. For more information, see [Regions and Availability Zones](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html) in the *Amazon EC2 User Guide*\.

To identify the location of your resources relative to your accounts, you must use the *AZ ID*, which is a unique and consistent identifier for an Availability Zone\. For example, `use1-az1` is an AZ ID for the `us-east-1` Region and it is the same location in every AWS account\.

**To view the AZ IDs for the Availability Zones in your account**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. In the navigation pane, choose **Resource Access Manager**\.

1. The AZ IDs for the current Region are under **Your AZ ID**\.

Viewing AZ IDs enables you to determine the location of resources in one account relative to the resources in another account\. For example, if you share a subnet in the Availability Zone with the AZ ID `use-az2` with another account, this subnet is available to that account in the Availability Zone whose AZ ID is also `use-az2`\. The AZ ID for each subnet is displayed in the Amazon VPC console\.

**To view AZ IDs using the AWS CLI**
+ [describe\-availability\-zones](https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-availability-zones.html)
+ [DescribeAvailabilityZones](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeAvailabilityZones.html)