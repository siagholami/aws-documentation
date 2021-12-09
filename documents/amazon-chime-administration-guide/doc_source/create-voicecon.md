# Creating an Amazon Chime Voice Connector<a name="create-voicecon"></a>

Create an Amazon Chime Voice Connector from the Amazon Chime console\.

**To create an Amazon Chime Voice Connector**

1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

1. For **Calling**, choose **Voice connectors**\.

1. Choose **Create new voice connector**\.

1. For **Voice connector name**, enter a name for the Amazon Chime Voice Connector\.

1. \(Optional\) For **AWS Region**, choose an AWS Region for your Amazon Chime Voice Connector\. The default Region is US East \(N\. Virginia\) \(**us\-east\-1**\)\. Regions cannot be changed after your Amazon Chime Voice Connector is created\.

1. For **Encryption**, select **Enabled** or **Disabled**\.

1. Choose **Create**\.

**Note**  
Enabling encryption configures your Amazon Chime Voice Connector to use TLS transport for SIP signaling and Secure RTP \(SRTP\) for media\. Inbound calls use TLS transport, and unencrypted outbound calls are blocked\.