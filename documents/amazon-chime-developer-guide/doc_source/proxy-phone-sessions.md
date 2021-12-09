# Proxy phone sessions<a name="proxy-phone-sessions"></a>

Developers can use the AWS Command Line Interface \(AWS CLI\), Amazon Chime API, or AWS SDK to create proxy phone sessions for use with Amazon Chime Voice Connectors\. Proxy phone sessions allow participants to call or send text messages to each other without revealing private phone numbers\.

Creating proxy phone sessions requires the following:
+ The ability to program\.
+ An AWS account\.
+ An AWS Identity and Access Management \(IAM\) role that grants permission to access the Amazon Chime API actions used to create proxy phone sessions, such as the following:
  + `chime:CreateProxySession`
  + `chime:DeleteProxySession`
  + `chime:DeleteVoiceConnectorProxy`
  + `chime:GetProxySession`
  + `chime:GetVoiceConnectorProxy`
  + `chime:ListProxySessions`
  + `chime:PutVoiceConnectorProxy`
  + `chime:UpdateProxySession`

  For more information, see [Amazon Chime identity\-based policies](https://docs.aws.amazon.com/chime/latest/ag/security_iam_service-with-iam.html#security_iam_service-with-iam-id-based-policies) in the *Amazon Chime Administrator Guide*\.
+ An Amazon Chime Voice Connector created by an Amazon Chime account administrator\. For more information, see [Managing Amazon Chime Voice Connectors](https://docs.aws.amazon.com/chime/latest/ag/voice-connectors.html) in the *Amazon Chime Administrator Guide*\.

The following procedure demonstrates how to create a proxy phone session\.

**To create a proxy phone session**

1. Use the [PutVoiceConnectorProxy](https://docs.aws.amazon.com/chime/latest/APIReference/API_PutVoiceConnectorProxy.html) action in the *Amazon Chime API Reference* to configure the Amazon Chime Voice Connector for the proxy phone session\.

1. Use the [CreateProxySession](https://docs.aws.amazon.com/chime/latest/APIReference/API_CreateProxySession.html) action in the *Amazon Chime API Reference* to create the proxy phone session\.

For more information about the available Amazon Chime API actions for proxy phone sessions, see the [https://docs.aws.amazon.com/chime/latest/APIReference/Welcome.html](https://docs.aws.amazon.com/chime/latest/APIReference/Welcome.html)\.