# Security group considerations for VPC interfaces<a name="vpc-interface-security-groups"></a>

When you set up a virtual private cloud \(VPC\) in Amazon Virtual Private Cloud, you create security groups that control inbound and outbound traffic\. Then when you create a VPC interface in AWS Elemental MediaConnect, you specify the security groups that you want MediaConnect to use when it sends and receives content from your VPC\.

To ensure that content can flow between your VPC and MediaConnect, adhere to the following guidelines:


****  

| If you have\.\.\. | Make sure that the VPC interface has a security group with\.\.\. | Additional information | 
| --- | --- | --- | 
| A VPC source |  An inbound rule that allows the private IP address of the resource within the VPC that is sending content\.  |  | 
| A VPC output |  An outbound rule that allows all outbound traffic\. By default, all security groups include this rule\. As long as you haven't deleted that rule from the security group, you don't need to create a new one\.  |  On the resource that receives traffic from your flow, you also need to set up a security group with an inbound rule that allows the private IP of the network interface ID that is associated with the VPC interface\. \(In MediaConnect, you can look at the flow details to find the network interface ID\. Then in EC2, you [view details](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html#view_eni_details) about the network interface to obtain the IP address\.\)  | 
| A VPC source and a VPC output from the same VPC interface | An inbound rule and an outbound rule that meet the requirements listed above\.  |  You can use one security group that has both rules or two security groups \(one for each rule\)\.  | 

For more information about security groups, see the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_SecurityGroups.html)\. 