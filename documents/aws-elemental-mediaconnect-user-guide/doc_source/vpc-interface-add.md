# Adding a VPC interface to a flow<a name="vpc-interface-add"></a>

To avoid streaming your content over the public internet, you can add a VPC interface to your MediaConnect flow\. You can add up to two VPC interfaces to each flow\.

**Important**  
Before you begin this procedure, make sure that the following steps have been completed:  
In Amazon VPC, set up your VPC and associated security groups\. For more information about VPCs, see the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/)\. For information about configuring security groups to work with your VPC interface, see [Security group considerations](vpc-interface-security-groups.md)\.
In IAM, [set up MediaConnect as a trusted service](security-iam-trusted-entity.md)\.

**To add a VPC interface to a flow \(console\)**

1. On the **Flows** page, choose the name of the flow that you want to update\.

1. Choose the **VPC interfaces** tab\.

1. Choose **Add VPC interface**\.

1. For **Name**, specify a name for your VPC interface\. The name of the VPC interface must be unique within the flow\.

1. For **Role ARN**, specify the Amazon Resource Name \(ARN\) of the role that you created when you set up MediaConnect as a trusted service\.

1. For **VPC**, choose the ID of the VPC that you want to use\.

1. For **Subnet**, choose the VPC subnet that you want MediaConnect to use to set up your VPC configuration\. The subnet must reside in the same Availability Zone as the flow\.

1. For **Security groups**, specify the VPC security groups that you want MediaConnect to use to set up your VPC configuration\. You must choose at least one security group\.