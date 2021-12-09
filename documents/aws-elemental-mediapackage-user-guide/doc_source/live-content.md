# Delivering Live Content from AWS Elemental MediaPackage<a name="live-content"></a>

AWS Elemental MediaPackage uses the following resources for live content:
+ *Channels* are the entry point for your live streams from upstream encoders\.

  For supported live inputs and codecs, see [Live Supported Codecs and Input Types](supported-inputs-live.md)\.
+ *Endpoints* tell AWS Elemental MediaPackage how to package outbound content\. Endpoints are associated with channels and hold encryption, stream, and packaging settings\.

The following sections describe how to use these resources to manage live content in AWS Elemental MediaPackage\.

**Topics**
+ [Working with Channels in AWS Elemental MediaPackage](channels.md)
+ [Working with Endpoints in AWS Elemental MediaPackage](endpoints.md)