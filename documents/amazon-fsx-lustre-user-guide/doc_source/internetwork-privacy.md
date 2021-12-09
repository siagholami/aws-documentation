# Internetwork Traffic Privacy<a name="internetwork-privacy"></a>

This topic describes how Amazon FSx secures connections from the service to other locations\.

## Traffic Between Service and On\-Premises Clients and Amazon FSx<a name="inter-network-traffic-privacy-on-prem"></a>

You have two connectivity options between your private network and AWS:
+ An AWS Site\-to\-Site VPN connection\. For more information, see [What is AWS Site\-to\-Site VPN?](https://docs.aws.amazon.com/vpn/latest/s2svpn/VPC_VPN.html)
+ An AWS Direct Connect connection\. For more information, see [What is AWS Direct Connect?](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html)

Access to Amazon FSx via the network is through AWS published APIs\. Clients must support Transport Layer Security \(TLS\) 1\.0\. We recommend TLS 1\.2 or above\. Clients must also support cipher suites with Perfect Forward Secrecy \(PFS\), such as Ephemeral Diffie\-Hellman \(DHE\) or Elliptic Curve Diffie\-Hellman Ephemeral \(ECDHE\)\. Most modern systems such as Java 7 and later support these modes\. Additionally, make sure that you sign requests using an access key ID and a secret access key that are associated with an IAM principal\. Or you can use the AWS Security Token Service \(STS\) to generate temporary security credentials to sign requests\.