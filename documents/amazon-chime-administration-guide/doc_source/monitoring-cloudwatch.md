# Monitoring Amazon Chime with Amazon CloudWatch<a name="monitoring-cloudwatch"></a>

You can monitor Amazon Chime using CloudWatch, which collects raw data and processes it into readable, near real\-time metrics\. These statistics are kept for 15 months, so that you can access historical information and gain a better perspective about how your web application or service is performing\. You can also set alarms that watch for certain thresholds, and send notifications or take actions when those thresholds are met\. For more information, see the [Amazon CloudWatch User Guide](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/)\.

## CloudWatch metrics for Amazon Chime<a name="cw-metrics"></a>

Amazon Chime sends the following metrics to CloudWatch\.

The `AWS/ChimeVoiceConnector` namespace includes the following metrics for phone numbers assigned to your AWS account and to Amazon Chime Voice Connectors\.


| Metric | Description | 
| --- | --- | 
|  `InboundCallAttempts`  |  The number of inbound calls attempted\. Units: Count  | 
|  `InboundCallFailures`  |  The number of inbound call failures\. Units: Count  | 
|  `InboundCallsAnswered`  |  The number of inbound calls that are answered\. Units: Count  | 
|  `InboundCallsActive`  |  The number of inbound calls that are currently active\. Units: Count  | 
|  `OutboundCallAttempts`  |  The number of outbound calls attempted\. Units: Count  | 
|  `OutboundCallFailures`  |  The number of outbound call failures\. Units: Count  | 
|  `OutboundCallsAnswered`  |  The number of outbound calls that are answered\. Units: Count  | 
|  `OutboundCallsActive`  |  The number of outbound calls that are currently active\. Units: Count  | 
|  `Throttles`  |  The number of times your account is throttled when attempting to make a call\. Units: Count  | 
|  `Sip1xxCodes`  |  The number of SIP messages with 1xx\-level status codes\. Units: Count  | 
|  `Sip2xxCodes`  |  The number of SIP messages with 2xx\-level status codes\. Units: Count  | 
|  `Sip3xxCodes`  |  The number of SIP messages with 3xx\-level status codes\. Units: Count  | 
|  `Sip4xxCodes`  |  The number of SIP messages with 4xx\-level status codes\. Units: Count  | 
|  `Sip5xxCodes`  |  The number of SIP messages with 5xx\-level status codes\. Units: Count  | 
|  `Sip6xxCodes`  |  The number of SIP messages with 6xx\-level status codes\. Units: Count  | 
|  `CustomerToVcRtpPackets`  |  The number of RTP packets sent from the customer to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `CustomerToVcRtpBytes`  |  The number of bytes sent from the customer to the Amazon Chime Voice Connector infrastructure in RTP packets\. Units: Count  | 
|  `CustomerToVcRtcpPackets`  |  The number of RTCP packets sent from the customer to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `CustomerToVcRtcpBytes`  |  The number of bytes sent from the customer to the Amazon Chime Voice Connector infrastructure in RTCP packets\. Units: Count  | 
|  `CustomerToVcPacketsLost`  |  The number of packets lost in transit from the customer to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `CustomerToVcJitter`  |  The average jitter for packets sent from the customer to the Amazon Chime Voice Connector infrastructure\. Units: Microseconds  | 
|  `VcToCustomerRtpPackets`  |  The number of RTP packets sent from the Amazon Chime Voice Connector infrastructure to the customer\. Units: Count  | 
|  `VcToCustomerRtpBytes`  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the customer in RTP packets\. Units: Count  | 
|  `VcToCustomerRtcpPackets`  |  The number of RTCP packets sent from the Amazon Chime Voice Connector infrastructure to the customer\. Units: Count  | 
|  `VcToCustomerRtcpBytes`  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the customer in RTCP packets\. Units: Count  | 
|  `VcToCustomerPacketsLost`  |  The number of packets lost in transit from the Amazon Chime Voice Connector infrastructure to the customer\. Units: Count  | 
|  `VcToCustomerJitter`  |  The average jitter for packets sent from the Amazon Chime Voice Connector infrastructure to the customer\. Units: Microseconds  | 
|  `RTTBetweenVcAndCustomer`  |  The average round\-trip time between the customer and the Amazon Chime Voice Connector infrastructure\. Units: Microseconds  | 
|  `MOSBetweenVcAndCustomer`  |  The estimated Mean opinion score \(MOS\) associated with voice streams between the customer and the Amazon Chime Voice Connector infrastructure\. Units: Score between 1\.0\-4\.4\. A higher score indicates better perceived audio quality\.  | 
|  `RemoteToVcRtpPackets`  |  The number of RTP packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `RemoteToVcRtpBytes`  |  The number of bytes sent from the remote end to the Amazon Chime Voice Connector infrastructure in RTP packets\. Units: Count  | 
|  `RemoteToVcRtcpPackets`  |  The number of RTCP packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `RemoteToVcRtcpBytes`  |  The number of bytes sent from the remote end to the Amazon Chime Voice Connector infrastructure in RTCP packets\. Units: Count  | 
|  `RemoteToVcPacketsLost`  |  The number of packets lost in transit from the remote end to the Amazon Chime Voice Connector infrastructure\. Units: Count  | 
|  `RemoteToVcJitter`  |  The average jitter for packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\. Units: Microseconds  | 
|  `VcToRemoteRtpPackets`  |  The number of RTP packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\. Units: Count  | 
|  `VcToRemoteRtpBytes`  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the remote end in RTP packets\. Units: Count  | 
|  `VcToRemoteRtcpPackets`  |  The number of RTCP packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\. Units: Count  | 
|  `VcToRemoteRtcpBytes`  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the remote end in RTCP packets\. Units: Count  | 
|  `VcToRemotePacketsLost`  |  The number of packets lost in transit from the Amazon Chime Voice Connector infrastructure to the remote end\. Units: Count  | 
|  `VcToRemoteJitter`  |  The average jitter for packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\. Units: Microseconds  | 
|  `RTTBetweenVcAndRemote`  |  The average round\-trip time between the remote end and the Amazon Chime Voice Connector infrastructure\. Units: Microseconds  | 
|  `MOSBetweenVcAndRemote`  |  The estimated Mean opinion score \(MOS\) associated with voice streams between the remote end and the Amazon Chime Voice Connector infrastructure\. Units: Units: Score between 1\.0\-4\.4\. A higher score indicates better perceived audio quality\.  | 

## CloudWatch dimensions for Amazon Chime<a name="cw-dimensions"></a>

The CloudWatch dimensions that you can use with Amazon Chime are listed as follows\.


| Dimension | Description | 
| --- | --- | 
|  `VoiceConnectorId`  |  The identifier of the Amazon Chime Voice Connector to display metrics for\.  | 
|  `Region`  |  The AWS Region associated with the event\.  | 

## CloudWatch logs for Amazon Chime<a name="cw-logs"></a>

You can send Amazon Chime Voice Connector metrics to CloudWatch Logs\. For more information, see [Editing Amazon Chime Voice Connector settings](edit-voicecon.md)\.

**Media quality metric logs**  
You can opt to receive media quality metric logs for your Amazon Chime Voice Connector\. When you do, Amazon Chime sends detailed, per\-minute metrics for all of your Amazon Chime Voice Connector calls to a CloudWatch Logs log group that is created for you\. The log group name is `/aws/ChimeVoiceConnectorLogs/${VoiceConnectorID}`\. The following fields are included in the logs, in JSON format\.


| Field | Description | 
| --- | --- | 
|  voice\_connector\_id  |  The Amazon Chime Voice Connector ID carrying the call\.  | 
|  event\_timestamp  |  The time when the metrics are emitted, in number of milliseconds since the UNIX epoch \(midnight on January 1, 1970\) in UTC\.  | 
|  call\_id  |  The call ID\.  | 
|  from\_sip\_user  |  The initiating user for the call\.  | 
|  from\_country  |  The initiating country for the call\.  | 
|  to\_sip\_user  |  The receiving user for the call\.  | 
|  to\_country  |  The receiving country for the call\.  | 
|  endpoint\_id  |  An opaque identifier indicating the other endpoint of the call\. Use with CloudWatch Logs Insights\. For more information, see [Analyzing log data with CloudWatch Logs Insights](https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/AnalyzingLogData.html) in the *Amazon CloudWatch Logs User Guide*\.  | 
|  aws\_region  |  The AWS Region for the call\.  | 
|  cust2vc\_rtp\_packets  |  The number of RTP packets sent from the customer to the Amazon Chime Voice Connector infrastructure\.  | 
|  cust2vc\_rtp\_bytes  |  The number of bytes sent from the customer to the Amazon Chime Voice Connector infrastructure in RTP packets\.  | 
|  cust2vc\_rtcp\_packets  |  The number of RTCP packets sent from the customer to the Amazon Chime Voice Connector infrastructure\.  | 
|  cust2vc\_rtcp\_bytes  |  The number of bytes sent from the customer to the Amazon Chime Voice Connector infrastructure in RTCP packets\.  | 
|  cust2vc\_packets\_lost  |  The number of packets lost in transit from the customer to the Amazon Chime Voice Connector infrastructure\.  | 
|  cust2vc\_jitter  |  The average jitter for packets sent from the customer to the Amazon Chime Voice Connector infrastructure\.  | 
|  vc2cust\_rtp\_packets  |  The number of RTP packets sent from the Amazon Chime Voice Connector infrastructure to the customer\.  | 
|  vc2cust\_rtp\_bytes  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the customer in RTP packets\.  | 
|  vc2cust\_rtcp\_packets  |  The number of RTCP packets sent from the Amazon Chime Voice Connector infrastructure to the customer\.  | 
|  vc2cust\_rtcp\_bytes  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the customer in RTCP packets\.  | 
|  vc2cust\_packets\_lost  |  The number of packets lost in transit from the Amazon Chime Voice Connector infrastructure to the customer\.  | 
|  vc2cust\_jitter  |  The average jitter for packets sent from the Amazon Chime Voice Connector infrastructure to the customer\.  | 
|  rtt\_btwn\_vc\_and\_cust  |  The average round\-trip time between the customer and the Amazon Chime Voice Connector infrastructure\.  | 
|  mos\_btwn\_vc\_and\_cust  |  The estimated Mean opinion score \(MOS\) associated with voice streams between the customer and the Amazon Chime Voice Connector infrastructure\.  | 
|  rem2vc\_rtp\_packets  |  The number of RTP packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\.  | 
|  rem2vc\_rtp\_bytes  |  The number of bytes sent from the remote end to the Amazon Chime Voice Connector infrastructure in RTP packets\.  | 
|  rem2vc\_rtcp\_packets  |  The number of RTCP packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\.  | 
|  rem2vc\_rtcp\_bytes  |  The number of bytes sent from the remote end to the Amazon Chime Voice Connector infrastructure in RTCP packets\.  | 
|  rem2vc\_packets\_lost  |  The number of packets lost in transit from the remote end to the Amazon Chime Voice Connector infrastructure\.  | 
|  rem2vc\_jitter  |  The average jitter for packets sent from the remote end to the Amazon Chime Voice Connector infrastructure\.  | 
|  vc2rem\_rtp\_packets  |  The number of RTP packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\.  | 
|  vc2rem\_rtp\_bytes  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the remote end in RTP packets\.  | 
|  vc2rem\_rtcp\_packets  |  The number of RTCP packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\.  | 
|  vc2rem\_rtcp\_bytes  |  The number of bytes sent from the Amazon Chime Voice Connector infrastructure to the remote end in RTCP packets\.  | 
|  vc2rem\_packets\_lost  |  The number of packets lost in transit from the Amazon Chime Voice Connector infrastructure to the remote end\.  | 
|  vc2rem\_jitter  |  The average jitter for packets sent from the Amazon Chime Voice Connector infrastructure to the remote end\.  | 
|  rtt\_btwn\_vc\_and\_rem  |  The average round\-trip time between the remote end and the Amazon Chime Voice Connector infrastructure\.  | 
|  mos\_btwn\_vc\_and\_rem  |  The estimated Mean opinion score \(MOS\) associated with voice streams between the remote end and the Amazon Chime Voice Connector infrastructure\.  | 

**SIP message logs**  
You can opt to receive SIP message logs for your Amazon Chime Voice Connector\. When you do, Amazon Chime captures inbound and outbound SIP messages and sends them to a CloudWatch Logs log group that is created for you\. The log group name is `/aws/ChimeVoiceConnectorSipMessages/${VoiceConnectorID}`\. The following fields are included in the logs, in JSON format\.


| Field | Description | 
| --- | --- | 
|  voice\_connector\_id  |  The Amazon Chime Voice Connector ID\.  | 
|  aws\_region  |  The AWS Region associated with the event\.  | 
|  event\_timestamp  |  The time when the message is captured, in number of milliseconds since the UNIX epoch \(midnight on January 1, 1970\) in UTC\.  | 
|  call\_id  |  The Amazon Chime Voice Connector call ID\.  | 
|  sip\_message  |  The full SIP message that is captured\.  | 