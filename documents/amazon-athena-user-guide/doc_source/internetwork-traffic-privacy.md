# Internetwork Traffic Privacy<a name="internetwork-traffic-privacy"></a>

Traffic is protected both between Athena and on\-premises applications and between Athena and Amazon S3\. Traffic between Athena and other services, such as AWS Glue and AWS Key Management Service, uses HTTPS by default\.
+ **For traffic between Athena and on\-premises clients and applications**, query results that stream to JDBC or ODBC clients are encrypted using Transport Layer Security \(TLS\)\.

  You can use one of the connectivity options between your private network and AWS: 
  + A Site\-to\-Site VPN AWS VPN connection\. For more information, see [What is Site\-to\-Site VPN AWS VPN](https://docs.aws.amazon.com/vpn/latest/s2svpn/VPC_VPN.html) in the *AWS Site\-to\-Site VPN User Guide*\.
  + An AWS Direct Connect connection\. For more information, see [What is AWS Direct Connect](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html) in the *AWS Direct Connect User Guide*\.
+ **For traffic between Athena and Amazon S3 buckets**, Transport Layer Security \(TLS\) encrypts objects in\-transit between Athena and Amazon S3, and between Athena and customer applications accessing it, you should allow only encrypted connections over HTTPS \(TLS\) using the [https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html#Conditions_Boolean](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html#Conditions_Boolean) on Amazon S3 bucket IAM policies\.