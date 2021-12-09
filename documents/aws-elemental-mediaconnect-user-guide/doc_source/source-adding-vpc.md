# Adding a VPC source to an existing flow<a name="source-adding-vpc"></a>

You can add a second source to an existing flow for failover\. Both sources on the flow must be binary identical \(come from the same encoder\) and they must use the same protocol\. \(However, you can have one source that uses RTP and the other that uses RTP\-FEC\.\) For more information about source failover, see [Source failover](source-failover.md)\.

**Important**  
Before you begin this procedure, make sure that the following steps have been completed:  
In Amazon VPC, set up your VPC and associated security groups\. For more information about VPCs, see the [Amazon VPC User Guide](https://docs.aws.amazon.com/vpc/latest/userguide/)\. For information about configuring security groups to work with your VPC interface, see [Security group considerations](vpc-interface-security-groups.md)\.
In IAM, [set up MediaConnect as a trusted service](security-iam-trusted-entity.md)\.
If the source of your flow requires encryption, [set up encryption](encryption-static-key-set-up.md)\.

**To add a VPC source to an existing flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to update\.

1. Choose the **Source** tab\.

1. In the **Source failover configuration** section, choose **Edit**\.

1. In the **Edit source failover configuration** window, make sure that **Failover** is set to **Enabled**\.
**Note**  
If you enable failover on a flow that is running, you might encounter a brief interruption in the flow output\. 

1. For **Recovery window**, specify the size of the buffer \(delay\) that you want the service to maintain\. A larger buffer means a longer delay in transmitting the stream, but more room for error correction\. A smaller buffer means a shorter delay, but less room for error correction\. You can choose a value from 100–15000 ms\. If you keep this field blank, MediaConnect uses the default value of 200 ms\.

1. Choose **Update**\.

1. In the **Sources** section, choose **Add source**\.

1. For **Name**, specify a name for your source\. This value is an identifier that is visible only on the MediaConnect console\. 

1. Determine which protocol your source uses\.
**Note**  
All sources on a flow must use the same protocol\. However, you can have one source that uses RTP and the other that uses RTP\-FEC\.

1. For specific instructions based on your protocol, choose one of the following tabs:

------
#### [ RIST ]

   1. For **Protocol**, choose **RIST**\. 

   1. For **Ingest port**, specify the port that the flow listens on for incoming content\. 
**Note**  
The RIST protocol requires one additional port for error correction\. To accommodate this requirement, MediaConnect reserves the port that is \+1 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000 and 4001\.

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value from 1–15,000 ms\. If you keep this field blank, MediaConnect uses the default value of 2,000 ms\. 

------
#### [  RTP or RTP\-FEC ]

   1. In the **Source** section, for **Source type**, choose **Standard source**\.

   1. For **Protocol**, choose **RTP** or **RTP\-FEC**\. 

   1. For **Ingest port**, specify the port that the flow listens on for incoming content\.
**Note**  
The RTP\-FEC protocol requires two additional ports for error correction\. To accommodate this requirement, MediaConnect reserves the ports that are \+2 and \+4 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000, 4002, and 4004\. 

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

------
#### [ Zixi push ]

   1. In the **Source** section, for **Source type**, choose **Standard source**\.

   1. For **Protocol**, choose **Zixi push**\. 

      AWS Elemental MediaConnect populates the value of the ingest port\.

   1. For **VPC interface name**, choose the name of the VPC interface that you want to use as the source\.

   1. For **Stream ID**, specify the stream ID set in the Zixi feeder\.
**Important**  
The stream ID must match the value set in the Zixi feeder\. If you leave this field blank, MediaConnect uses the source name as the stream ID\. If the stream ID is not exactly the same as the source name, you must manually enter the stream ID\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value from 0–60,000 ms\. If you keep this field blank, the service uses the default value of 6,000 ms\. 

   1. If the source is encrypted, choose **Enable** in the **Decryption** section and do the following:

      1. For **Decryption type**, choose **Static key**\.

      1. For **Role ARN**, specify the ARN of the role that you created when you [set up encryption](encryption-static-key-set-up.md#encryption-static-key-set-up-create-iam-role)\.

      1. For **Secret ARN**, specify the ARN that AWS Secrets Manager assigned when you [created the secret to store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key)\.

      1. For **Decryption algorithm**, choose the type of encryption that was used to encrypt the source\.

------

1. Choose **Save**\.