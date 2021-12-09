# Adding VPC outputs to a flow<a name="outputs-add-vpc"></a>

You can add up to 50 outputs for each flow in AWS Elemental MediaConnect\. A VPC output goes to a virtual private cloud \(VPC\) that you created using Amazon Virtual Private Cloud\.

**To add a VPC output to a flow \(console\)**

1. Open the MediaConnect console at [https://console\.aws\.amazon\.com/mediaconnect/](https://console.aws.amazon.com/mediaconnect/)\.

1. On the **Flows** page, choose the name of the flow that you want to add an output to\.

   The details page for that flow appears\. 

1. Choose the **Outputs** tab\.

1. Choose **Add output**\.

1. For **Name**, specify a name for your output\. This value is an identifier that is visible only on the AWS Elemental MediaConnect console and is not visible to the end user\.

1. For **Output type**, choose **VPC output**\.

1. For **Description**, enter a description that will remind you later where this output is going\. This might be the company name or notes about the setup\.

1. Determine which protocol you want to use for the output\.

1. For specific instructions based on the protocol that you want to use, choose one of the following tabs:

------
#### [ RIST ]

   1. For **Protocol**, choose **RIST**\. 

   1. For **IP address**, choose the IP address where you want to send the output\.

   1. For **Port**, choose the port that you want to use when the content is distributed to this output\. For more information about ports, see [Output destinations](destinations.md)\.
**Note**  
The RIST protocol requires one additional port for error correction\. To accommodate this requirement, AWS Elemental MediaConnect reserves the port that is \+1 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000 and 4001\.

   1. For **Smoothing latency**, specify the additional delay that you want to use with output smoothing\. We recommend that you specify a value of 0 ms to disable smoothing\. However, if the receiver can't process the stream properly, specify a value between 100 and 1,000 ms\. This way, AWS Elemental MediaConnect attempts to correct jitter from the flow source\. If you keep this field blank, the service uses the default value of 0 ms\.

   1. For **Output to VPC**, choose the name of the VPC interface that you want to send your output to\.

------
#### [ RTP or RTP\-FEC ]

   1. For **Protocol**, choose **RTP** or **RTP\-FEC**\. 

   1. For **IP address**, choose the IP address where you want to send the output\.

   1. For **Port**, choose the port that you want to use when the content is distributed to this output\. For more information about ports, see [Output destinations](destinations.md)\.
**Note**  
The RTP\-FEC protocol requires two additional ports for error correction\. To accommodate this requirement, AWS Elemental MediaConnect reserves the ports that are \+2 and \+4 from the port that you specify\. For example, if you specify port 4000 for the output, the service assigns ports 4000, 4002, and 4004\. 

   1. For **Smoothing latency**, specify the additional delay that you want to use with output smoothing\. We recommend that you specify a value of 0 ms to disable smoothing\. However, if the receiver can't process the stream properly, specify a value between 100 and 1,000 ms\. This way, AWS Elemental MediaConnect attempts to correct jitter from the flow source\. If you keep this field blank, the service uses the default value of 0 ms\.

   1. For **Output to VPC**, choose the name of the VPC interface that you want to send your output to\.

------
#### [ Zixi pull ]

   1. For **Protocol**, choose **Zixi pull**\. 

   1. For **Stream ID**, enter the stream ID that is set in the Zixi receiver\.
**Important**  
If you keep this field blank, the service uses the output name as the stream ID\. Because the stream ID must match the value that is set in the Zixi receiver, you must specify the stream ID if it is not exactly the same as the output name\.

   1. For **Remote ID**, enter the identifier that is assigned to the receiver\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value between 0 and 60,000 ms\. If you keep this field blank, the service uses the latency that is set in the receiver\.

   1. For **CIDR allow list**, specify a range of IP addresses that are allowed to retrieve content from your source\. Format the IP addresses as a Classless Inter\-Domain Routing \(CIDR\) block, for example, 10\.24\.34\.0/23\. For more information about CIDR notation, see [RFC 4632](https://tools.ietf.org/html/rfc4632)\.
**Tip**  
To specify an additional CIDR block, choose **Add**\. You can specify up to three CIDR blocks\.

   1. For **Output to VPC**, choose the name of the VPC interface that you want to send your output to\.

   1. If you want to encrypt the video as it is sent to this output, do the following:

      1. In the **Encryption** section, choose **Enable**\.

      1. For **Encryption type**, choose **Static key**\.

      1. For **Role ARN**, specify the ARN of the role that you created when you [set up encryption](encryption-static-key-set-up.md#encryption-static-key-set-up-create-iam-role)\.

      1. For **Secret ARN**, specify the ARN that AWS Secrets Manager assigned when you [created the secret to store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key)\.

      1. For **Encryption algorithm**, choose the type of encryption that you want to use to encrypt the source\.

------
#### [ Zixi push ]

   1. For **Protocol**, choose **Zixi push**\. 

   1. For **IP address**, choose the IP address where you want to send the output\.

   1. For **Port**, choose the port that you want to use when the content is distributed to this output\. For more information about ports, see [Output destinations](destinations.md)\.

   1. For **Stream ID**, enter the stream ID that is set in the Zixi receiver\.
**Important**  
If you keep this field blank, the service uses the output name as the stream ID\. Because the stream ID must match the value set in the Zixi receiver, you must specify the stream ID if it is not exactly the same as the output name\.

   1. For **Maximum latency**, specify the size of the buffer \(delay\) that you want the service to maintain\. A higher latency value means a longer delay in transmitting the stream, but more room for error correction\. A lower latency value means a shorter delay, but less room for error correction\. You can choose a value between 0 and 60,000 ms\. If you keep this field blank, the service uses the default value of 6,000 ms\.

   1. For **Output to VPC**, choose the name of the VPC interface that you want to send your output to\.

   1. If you want to encrypt the video as it is sent to this output, do the following:

      1. In the **Encryption** section, choose **Enable**\.

      1. For **Encryption type**, choose **Static key**\.

      1. For **Role ARN**, specify the ARN of the role that you created when you [set up encryption](encryption-static-key-set-up.md#encryption-static-key-set-up-create-iam-role)\.

      1. For **Secret ARN**, specify the ARN that AWS Secrets Manager assigned when you [created the secret to store the encryption key](encryption-static-key-set-up.md#encryption-static-key-set-up-store-key)\.

      1. For **Encryption algorithm**, choose the type of encryption that you want to use to encrypt the source\.

------

1. Choose **Add output**\.