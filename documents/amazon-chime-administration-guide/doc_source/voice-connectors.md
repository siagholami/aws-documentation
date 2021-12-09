# Managing Amazon Chime Voice Connectors<a name="voice-connectors"></a>

**What is an Amazon Chime Voice Connector?**  
An Amazon Chime Voice Connector provides SIP trunking service for your existing phone system\. You can manage your Amazon Chime Voice Connector from the Amazon Chime console, and access it over your internet connection or with AWS Direct Connect\. For more information, see [What is AWS Direct Connect?](https://docs.aws.amazon.com/directconnect/latest/UserGuide/Welcome.html) in the *AWS Direct Connect User Guide*\.

**Amazon Chime Voice Connector outbound and inbound calling**  
After you create an Amazon Chime Voice Connector, edit the termination and origination settings to allow outbound or inbound calls, or both\. Then, assign phone numbers to the Amazon Chime Voice Connector\. You can port in existing phone numbers or provision new phone numbers in the Amazon Chime console\. For more information, see [Porting existing phone numbers](porting.md), [Provisioning phone numbers](provision-phone.md), and [Assigning and unassigning Amazon Chime Voice Connector phone numbers](assign-voicecon.md)\.

**Amazon Chime Voice Connector groups**  
You can also create an Amazon Chime Voice Connector group and add Amazon Chime Voice Connectors to it that are created in different AWS Regions\. This creates a fault\-tolerant mechanism for fallback if availability events occur\. For more information, see [Managing Amazon Chime Voice Connector groups](voice-connector-groups.md)\.

**Logging and monitoring Amazon Chime Voice Connector data**  
Optionally, you can send logs from your Amazon Chime Voice Connector to CloudWatch Logs, and turn on media streaming from your Amazon Chime Voice Connector to Amazon Kinesis\. For more information, see [CloudWatch logs for Amazon Chime](monitoring-cloudwatch.md#cw-logs) and [Streaming Amazon Chime Voice Connector media to Kinesis](start-kinesis-vc.md)\.

**Topics**
+ [Before you begin](#vc-prereq)
+ [Creating an Amazon Chime Voice Connector](create-voicecon.md)
+ [Editing Amazon Chime Voice Connector settings](edit-voicecon.md)
+ [Assigning and unassigning Amazon Chime Voice Connector phone numbers](assign-voicecon.md)
+ [Deleting an Amazon Chime Voice Connector](delete-voicecon.md)
+ [Managing Amazon Chime Voice Connector groups](voice-connector-groups.md)
+ [Streaming Amazon Chime Voice Connector media to Kinesis](start-kinesis-vc.md)

## Before you begin<a name="vc-prereq"></a>

To use an Amazon Chime Voice Connector, you must have an IP Private Branch Exchange \(PBX\), Session Border Controller \(SBC\), or other voice infrastructure with internet access that supports Session Initiation Protocol \(SIP\)\. Make sure to confirm that you have sufficient bandwidth to support peak call volume\. For information about bandwidth requirements, see [Bandwidth requirements](network-config.md#bandwidth)\.

To ensure security for calls sent from AWS to your on\-premises phone system, we recommend configuring an SBC between AWS and your phone system\. Allowlist SIP traffic to the SBC from the Amazon Chime Voice Connector signaling and media IP addresses\. For more information, see the recommended ports and protocols for [Amazon Chime Voice Connector](network-config.md#cvc)\.

Amazon Chime Voice Connectors expect phone numbers to be in E\.164 format\.