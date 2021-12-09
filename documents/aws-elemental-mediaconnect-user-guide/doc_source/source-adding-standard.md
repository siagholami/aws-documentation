# Adding a standard source to an existing flow<a name="source-adding-standard"></a>

You can add a second source to an existing flow for failover\. Both sources on the flow must use the same protocol\. \(However, you can have one source that uses RTP and the other that uses RTP\-FEC\.\) For more information about source failover, see [Source failover](source-failover.md)\.

**To add a standard source to an existing flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to update\.

1. Choose the **Source** tab\.

1. In the **Source failover configuration** section, choose **Edit**\.

1. In the **Edit source failover configuration** window, make sure that **Failover** is set to **Enabled**\.
**Note**  
If you enable failover on a flow that is running, you might encounter a brief interruption in the flow output\. 

1. For **Recovery window**, specify the size of the buffer \(delay\) that you want the service to maintain\. A larger buffer means a longer delay in transmitting the stream, but more room for error correction\. A smaller buffer means a shorter delay, but less room for error correction\. You can choose a value from 100–15000 ms\. If you keep this field blank, MediaConnect uses the default value of 200 ms\.

1. Choose **Update**\.

1. In the **Sources** section, choose **Add**\.

1. For **Name**, specify a name for your source\. This value is an identifier that is visible only on the MediaConnect console\. 

1. For **Source type**, choose **Standard source**\.

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

   1. For **Whitelist CIDR**, specify a range of IP addresses that are allowed to contribute content to your source\. Format the IP addresses as a Classless Inter\-Domain Routing \(CIDR\) block, for example, 10\.24\.34\.0/23\. For more information about CIDR notation, see [RFC 4632](https://tools.ietf.org/html/rfc4632)\.
**Important**  
Specify a CIDR block that is as precise as possible\. Include only the IP addresses that you want to contribute content to your flow\. If you specify a CIDR block that is too wide, it allows for the possibility of outside parties sending content to your flow\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value from 1–15,000 ms\. If you keep this field blank, MediaConnect uses the default value of 2,000 ms\. 

------
#### [  RTP or RTP\-FEC ]

   1. For **Protocol**, choose **RTP** or **RTP\-FEC**\. 

   1. For **Ingest port**, specify the port that the flow listens on for incoming content\.
**Note**  
The RTP\-FEC protocol requires two additional ports for error correction\. To accommodate this requirement, MediaConnect reserves the ports that are \+2 and \+4 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000, 4002, and 4004\. 

   1. For **Whitelist CIDR**, specify a range of IP addresses that are allowed to contribute content to your source\. Format the IP addresses as a Classless Inter\-Domain Routing \(CIDR\) block, for example, 10\.24\.34\.0/23\. For more information about CIDR notation, see [RFC 4632](https://tools.ietf.org/html/rfc4632)\.
**Important**  
Specify a CIDR block that is as precise as possible\. Include only the IP addresses that you want to contribute content to your flow\. If you specify a CIDR block that is too wide, it allows for the possibility of outside parties sending content to your flow\.

   1. For **Maximum bitrate**, specify the maximum expected bitrate \(in bits per second\) for the flow\. We recommend that you specify a value that is twice the actual bitrate\.

------
#### [ Zixi push ]

   1. For **Protocol**, choose **Zixi push**\. 

      AWS Elemental MediaConnect populates the value of the ingest port\.

   1. For **Whitelist CIDR**, specify a range of IP addresses that are allowed to contribute content to your source\. Format the IP addresses as a Classless Inter\-Domain Routing \(CIDR\) block, for example, 10\.24\.34\.0/23\. For more information about CIDR notation, see [RFC 4632](https://tools.ietf.org/html/rfc4632)\.
**Important**  
Specify a CIDR block that is as precise as possible\. Include only the IP addresses that you want to contribute content to your flow\. If you specify a CIDR block that is too wide, it allows for the possibility of outside parties sending content to your flow\.

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