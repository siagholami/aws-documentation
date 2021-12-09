# ACM Private CA VPC Endpoints \(AWS PrivateLink\)<a name="vpc-endpoints"></a>

You can create a private connection between your VPC and ACM Private CA by configuring an interface VPC endpoint\. Interface endpoints are powered by [AWS PrivateLink](https://docs.aws.amazon.com/whitepapers/latest/aws-vpc-connectivity-options/aws-privatelink.html), a technology for privately accessing ACM Private CA API operations\. AWS PrivateLink routes all network traffic between your VPC and ACM Private CA through the Amazon network, avoiding exposure on the open internet\. Each VPC endpoint is represented by one or more [Elastic Network Interfaces](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-eni.html) \(ENIs\) with private IP addresses in your VPC subnets\. 

The interface VPC endpoint connects your VPC directly to ACM Private CA without an internet gateway, NAT device, VPN connection, or AWS Direct Connect connection\. The instances in your VPC don't need public IP addresses to communicate with the ACM Private CA API\. 

To use ACM Private CA through your VPC, you must connect from an instance that is inside the VPC\. Alternatively, you can connect your private network to your VPC by using an AWS Virtual Private Network \(AWS VPN\) or AWS Direct Connect\. For information about AWS VPN, see [VPN Connections](https://docs.aws.amazon.com/vpc/latest/userguide/vpn-connections.html) in the *Amazon VPC User Guide*\. For information about AWS Direct Connect, see [Creating a Connection](https://docs.aws.amazon.com/directconnect/latest/UserGuide/create-connection.html) in the *AWS Direct Connect User Guide*\.

ACM Private CA does not require the use of AWS PrivateLink, but we recommend it as an additional layer of security\. For more information about AWS PrivateLink and VPC endpoints, see [Accessing Services Through AWS PrivateLink](https://docs.aws.amazon.com/vpc/latest/userguide/what-is-amazon-vpc.html#what-is-privatelink)\.

## Considerations for ACM Private CA VPC Endpoints<a name="vpc-endpoint-considerations"></a>

Before you set up interface VPC endpoints for ACM Private CA, be aware of the following considerations:
+ ACM Private CA may not support VPC endpoints in some Availability Zones\. When you create a VPC endpoint, first check support in the management console\. Unsupported Availability Zones are marked "Service not supported in this Availability Zone\."
+ VPC endpoints do not support cross\-Region requests\. Ensure that you create your endpoint in the same Region where you plan to issue your API calls to ACM Private CA\.
+ VPC endpoints only support Amazon\-provided DNS through Amazon Route 53\. If you want to use your own DNS, you can use conditional DNS forwarding\. For more information, see [DHCP Options Sets](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_DHCP_Options.html) in the *Amazon VPC User Guide*\.
+ The security group attached to the VPC endpoint must allow incoming connections on port 443 from the private subnet of the VPC\.
+ AWS Certificate Manager does not support VPC endpoints\.
+ FIPS endpoints \(and their Regions\) do not support VPC endpoints\.

## Creating the VPC Endpoints for ACM Private CA<a name="ecs-setting-up-vpc-create"></a>

You can create a VPC endpoint for the ACM Private CA service using either the VPC console at [https://console\.aws\.amazon\.com/vpc/](https://console.aws.amazon.com/vpc/) or the AWS Command Line Interface\. For more information, see the [Creating an Interface Endpoint](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html#create-interface-endpoint) procedure in the *Amazon VPC User Guide*\. ACM Private CA supports making calls to all of its API operations inside your VPC\.

If you have enabled private DNS host names for the endpoint, then the default ACM Private CA endpoint now resolves to your VPC endpoint\. For a comprehensive list of default service endpoints, see [Service Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/aws-service-information.html)\.

If you have not enabled private DNS host names, Amazon VPC provides a DNS endpoint name that you can use in the following format:

```
vpc-endpoint-id.acm-pca.region.vpce.amazonaws.com
```

**Note**  
The value *region* represents the Region identifier for an AWS Region supported by ACM Private CA, such as `us-east-2` for the US East \(Ohio\) Region\. For a list of ACM Private CA, see [AWS Certificate Manager Private Certificate Authority Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/acm-pca.html)\.

For more information, see [Interface VPC Endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html) in the *Amazon VPC User Guide*\. 

## Create a VPC Endpoint Policy for ACM Private CA<a name="api-private-link-policy"></a>

You can create a policy for Amazon VPC endpoints for ACM Private CA to specify the following: 
+ The principal that can perform actions\.
+ The actions that can be performed\.
+ The resources on which actions can be performed\.

For more information, see [Controlling Access to Services with VPC Endpoints](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-endpoints-access.html) in the *Amazon VPC User Guide*\. 

**Example – VPC endpoint policy for ACM Private CA actions**  
When attached to an endpoint, the following policy grants access for all principals to the ACM Private CA actions `IssueCertificate`, `DescribeCertificateAuthority`, `GetCertificate`, `GetCertificateAuthorityCertificate`, `ListPermissions`, and `ListTags`\. The resource in each stanza is a private CA\. The first stanza authorizes the creation of end\-entity certificates using the specified private CA and certificate template\. If you don't want to control the template being used, the `Condition` section is not needed\. However, removing this allows all principals to create CA certificates as well as end\-entity certificates\.

```
{
   "Statement":[
      {
         "Principal":"*",
         "Effect":"Allow",
         "Action":[
            "acm-pca:IssueCertificate"
         ],
         "Resource":[
            "arn:aws:acm-pca:us-east-1:555555555555:certificate-authority/12345678-1234567890-1234"
         ],
         "Condition":{
            "StringEquals":{
               "acm-pca:TemplateArn":"arn:aws:acm-pca:::template/EndEntityCertificate/V1"
            }
         }
      },
      {
         "Principal":"*",
         "Effect":"Allow",
         "Action":[
            "acm-pca:DescribeCertificateAuthority",
            "acm-pca:GetCertificate",
            "acm-pca:GetCertificateAuthorityCertificate",
            "acm-pca:ListPermissions",
            "acm-pca:ListTags"
         ],
         "Resource":[
            "arn:aws:acm-pca:us-east-1:555555555555:certificate-authority/12345678-1234567890-1234"
         ]
      }
   ]
}
```