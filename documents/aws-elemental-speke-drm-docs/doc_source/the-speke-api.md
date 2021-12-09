# SPEKE API<a name="the-speke-api"></a>

To be SPEKE\-compliant, your DRM key provider must expose the REST API described in this specification\. The encryptor makes API calls to your key provider\.

**Note**  
The code examples in this specification are for illustration purposes only\. You can’t run the examples because they aren’t part of a complete SPEKE implementation\. 

Secure Packager and Encoder Key Exchange uses the DASH Industry Forum Content Protection Information Exchange Format \(DASH\-IF\-CPIX\) data structure definition for key exchange, with some restrictions\. DASH\-IF\-CPIX defines a schema to provide an extensible, multi\-DRM exchange from the DRM platform to the encryptor\. This enables content encryption for all adaptive bitrate packaging formats at the time of content compression and packaging\. Adaptive bitrate packaging formats include HLS, DASH, and MSS\. 

For detailed information about the exchange format, see the DASH Industry Forum CPIX specification at [https://dashif\.org/docs/DASH\-IF\-CPIX\-v2\-0\.pdf](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf)\. 

**Topics**
+ [Customizations and Constraints to the DASH\-IF Specification](speke-constraints.md)
+ [Standard Payload Components](standard-payload-components.md)
+ [Live Workflow Method Call Examples](live-workflow-methods.md)
+ [VOD Workflow Method Call Examples](vod-workflow-methods.md)
+ [Content Key Encryption](content-key-encryption.md)
+ [Heartbeat](heartbeat.md)
+ [Overriding the Key Identifier \(KID\)](kid-override.md)