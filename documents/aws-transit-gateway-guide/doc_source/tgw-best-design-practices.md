# Transit gateway design best practices<a name="tgw-best-design-practices"></a>

The following are best practices for your transit gateway design:
+ Use a separate subnet for each transit gateway VPC attachment\. For each subnet, use a small CIDR, for example /28, so that you have more addresses for EC2 resources\. When you use a separate subnet, you can configure the following:
  + Keep the inbound and outbound NACL associated with the transit gateway subnets open\. 
  + Depending on your traffic flow, you can apply NACLs to your workload subnets\.
+ Create one network ACL and associate it with all of the subnets that are associated with the transit gateway\. Keep the network ACL open in both the inbound and outbound directions\.
+ Associate the same VPC route table with all of the subnets that are associated with the transit gateway, unless your network design requires multiple VPC route tables \(for example, a middle\-box VPC that routes traffic through multiple NAT gateways\)\. 
+ Use Border Gateway Protocol \(BGP\) Site\-to\-Site VPN connections\. If your customer gateway device or firewall for the connection supports multipath, enable the feature\. 
+ Enable route propagation for AWS Direct Connect gateway attachments and BGP Site\-to\-Site VPN attachments\.
+ You do not need additional transit gateways for high availability, because transit gateways are highly available by design\.
+ Limit the number of transit gateway route tables unless your design requires multiple transit gateway route tables\.
+ For multiple Region deployments, we recommend that you use a unique Autonomous System Number \(Amazon\-side ASN\) for each of your transit gateways\. 