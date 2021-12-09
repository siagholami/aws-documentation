# Create a Private Subnet<a name="create-subnets"></a>

Create a private subnet \(a subnet with no internet gateway attached\) for each Availability Zone where you want to create an HSM\. Private subnets are available across all AWS Availability Zones\. Even if AWS CloudHSM is not supported in a certain Availability Zone, the HSM cluster still performs as expected if support is added later\. Creating a private subnet in each Availability Zone provides the most robust configuration for high availability\. Visit [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#cloudhsm_region) in the *AWS General Reference* or the [AWS Region Table](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/) to see the regional and zone availability for AWS CloudHSM\.

**To create the private subnets in your VPC**

1. Open the Amazon VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/)\.

1. In the navigation pane, choose **Subnets**\. Then choose **Create Subnet**\.

1. In the **Create Subnet** dialog box, do the following:

   1. For **Name tag**, type an identifiable name such as **CloudHSM private subnet**\.

   1. For **VPC**, choose the VPC that you created previously\.

   1. For **Availability Zone**, choose the first Availability Zone in the list\.

   1. For **CIDR block**, type the CIDR block to use for the subnet\. If you used the default values for the VPC in the previous procedure, then type **10\.0\.1\.0/28**\.

   Choose **Yes, Create**\.

1. Repeat steps 2 and 3 to create subnets for each remaining Availability Zone in the region\. For the subnet CIDR blocks, you can use 10\.0\.2\.0/28, 10\.0\.3\.0/28, and so on\.