# Creating a flow that uses a VPC source<a name="flows-create-vpc-source"></a>

A flow consists of one source, a name, and an Availability Zone\. The ability to choose an Availability Zone allows you to create multiple flows within an AWS Region for redundancy\. After you create a flow, you can add up to 50 outputs and up to 50 entitlements\.

When you create a flow that uses a source from your virtual private cloud \(VPC\), your content does not go over the public internet\. This is useful for security reasons as well as reliability\. You set up your VPC and then create a flow that has an interface to that VPC\. Alternatively, you can create a flow based on an entitlement that another AWS account granted to allow you to use their content \([entitled source](flows-create-entitled-source.md)\) or a [standard source](flows-create-standard-source.md)\.

**Important**  
Before you begin this procedure, make sure that the following steps have been completed:  
In Amazon VPC, set up your VPC and associated security groups\. For more information about VPCs, see the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/)\. For information about configuring security groups to work with your VPC interface, see [Security group considerations](vpc-interface-security-groups.md)\.
In IAM, [set up MediaConnect as a trusted service](security-iam-trusted-entity.md)\.
If the source of your flow requires encryption, [set up encryption](encryption-static-key-set-up.md)\.

**To create a flow that uses a VPC source \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose **Create flow**\.

1. In the **Details** section, for **Name**, specify a name for your flow\. This name will become part of the ARN for this flow\.
**Note**  
MediaConnect allows you to create multiple flows with the same name\. However, we encourage you to use unique flow names within an AWS Region to help with organization\. After you create a flow, you can't change the name\.

1. For **Availability Zone**, choose **Any** or choose the Availability Zone where your VPC subnet resides\. We recommend that you leave this as **Any** and let the service ensure that the Availability Zone is set correctly\. 

1. In the **VPC interface** section, choose **Add VPC interface**\.

1. For **Name**, specify a name for your VPC interface\. The name of the VPC interface must be unique within the flow\.

1. For **Role ARN**, specify the Amazon Resource Name \(ARN\) of the role that you created when you set up MediaConnect as a trusted service\.

1. For **VPC**, choose the ID of the VPC that you want to use\.
**Note**  
If you don't see the VPC that you want in the list, verify that the VPC has been set up in Amazon Virtual Private Cloud and that you have IAM permissions to view the VPC\.

1. For **Subnet**, choose the VPC subnet that you want MediaConnect to use to set up your VPC configuration\. You must choose at least one and can choose as many as you want\.

1. For **Security groups**, specify the VPC security groups that you want MediaConnect to use to set up your VPC configuration\. You must choose at least one security group\.

1. In the **Source** section, for **Source type**, choose **VPC source**\.

1. For **Name**, specify a name for your source\. This value is an identifier that is visible only on the MediaConnect console\. 

1. Determine which protocol your source uses\.
**Note**  
If you want to specify redundant sources for failover, create the flow with one of the sources\. After the flow is created, update it to enable failover on the source, and add the second source to the flow\. Because MediaConnect treats both sources as the primary source, it doesn't matter which one you specify when you first create the flow\. 

1. For specific instructions based on your protocol, choose one of the following tabs:

------
#### [ RIST ]

   1. For **Protocol**, choose **RIST**\. 

   1. For **Ingest port**, specify the port that the flow will listen on for incoming content\. 
**Note**  
The RIST protocol requires one additional port for error correction\. To accommodate this requirement, MediaConnect reserves the port that is \+1 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000 and 4001\.

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value from 1\-15,000 ms\. If you keep this field blank, the service uses the default value of 2,000 ms\. 

------
#### [ RTP or RTP\-FEC ]

   1. For **Protocol**, choose **RTP** or **RTP\-FEC**\. 

   1. For **Ingest port**, specify the port that the flow will listen on for incoming content\.
**Note**  
The RTP\-FEC protocol requires two additional ports for error correction\. To accommodate this requirement, MediaConnect reserves the ports that are \+2 and \+4 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000, 4002, and 4004\. 

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

------
#### [ Zixi push ]

   1. For **Protocol**, choose **Zixi push**\. 

      MediaConnect populates the value of the ingest port\.

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Stream ID**, specify the stream ID set in the Zixi feeder\.
**Important**  
If you leave this field blank, the service uses the source name as the stream ID\. Because the stream ID must match the value set in the Zixi feeder, you need to specify the stream ID if it is not exactly the same as the source name\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value between 0 and 60,000 ms\. If you keep this field blank, the service uses the default value of 6,000 ms\. 

   1. If the source is encrypted, choose **Enable** in the **Decryption** section and do the following:

      1. For **Decryption type**, choose **Static key**\.

      1. For **Role ARN**, specify the ARN of the role that you created when you [set up encryption](encryption-static-key-set-up.md#encryption-static-key-set-up-create-iam-role)\.

      1. For **Secret ARN**, specify the ARN that AWS Secrets Manager assigned when you [created the secret to store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key)\.

      1. For **Decryption algorithm**, choose the type of encryption that was used to encrypt the source\.

------

1. At the bottom of the page, choose **Create flow**\.
**Note**  
The flow doesn't start automatically\. You must [start the flow](flows-start.md) manually\.

1. [Add outputs](outputs-add.md) to specify where you want MediaConnect to send the content, or [grant entitlements](entitlements-grant.md) to allow users of other AWS accounts to subscribe to your content\.