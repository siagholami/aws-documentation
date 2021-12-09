# Troubleshooting File Systems Joined to an AWS Managed Microsoft Active Directory<a name="unable-to-create-aws-mad"></a>

Use the following sections to help troubleshoot problems you experience while creating an Amazon FSx file system that is joined to your self\-managed Active Directory\.

**Potential Cause**  
VPC security groups and network ACLs aren't using the recommended security group configuration for AWS Managed Microsoft AD\.

**Resolution**  
Make sure that the VPC security groups and network ACLs are configured using the recommended security group configuration\. For more information, see [Creating FSx Security Groups, Step 6](limit-access-security-groups.md#vpc-sg-step6)\.