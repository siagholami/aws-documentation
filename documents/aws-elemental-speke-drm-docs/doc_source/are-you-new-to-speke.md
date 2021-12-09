# Are You New to SPEKE?<a name="are-you-new-to-speke"></a>

This section lists some basic terminology related to Secure Packager and Encoder Key Exchange \(SPEKE\) and provides links to related documentation\.

## Related Services and Specifications<a name="related-services-and-specifications"></a>
+ [API Gateway Permissions](https://docs.aws.amazon.com/apigateway/latest/developerguide/permissions.html) – How to control access to an API with AWS Identity and Access Management \(AWS IAM\) permissions\.
+ [AWS AssumeRole](https://docs.aws.amazon.com/STS/latest/APIReference/API_AssumeRole.html) – How to use AWS Security Token Service \(AWS STS\) to assume role functionality\.
+ [AWS Sigv4](https://docs.aws.amazon.com/general/latest/gr/sigv4_signing.html) – How to sign an HTTP request using Signature Version 4\. 
+ [DASH\-IF CPIX specification](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf) – The DASH\-IF Content Protection Information Exchange Format \(CPIX\) specification, which this SPEKE specification is based on\. 
+ [DASH\-IF System IDs](https://dashif.org/identifiers/content_protection/) – The list of registered identifiers for DRM systems\.
+ [https://github.com/awslabs/speke-reference-server](https://github.com/awslabs/speke-reference-server) – Example reference key provider to use with your AWS account, to help you get started with a SPEKE implementation in AWS\.

## Terminology<a name="terminology"></a>

The following list defines the terminology used in this specification\. Where possible, this specification follows the terminology used in the [DASH\-IF CPIX specification](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf)\.
+ **ARN** – Amazon Resource Name\. Uniquely identifies an AWS resource\. 
+ **Content key** – A cryptographic key used for encrypting part of the content\.
+ **Content provider** – A publisher who provides the rights and rules for delivering protected media\. The content provider might also provide source media \(mezzanine format, for transcoding\), asset identifiers, key identifiers \(KIDs\), key values, encoding instructions, and content description metadata\.
+ **DRM** – Digital rights management\. Used to protect copyrighted digital content from unapproved access\. 
+ **DRM platform** – A system that provides DRM functionality and support to content encryptors and viewers, including providing DRM keys and licensing for content encryption and decryption\. 
+ **DRM provider** – See DRM platform\.
+ **DRM system** – A standard for DRM implementations\. Common DRM systems include Apple FairPlay, Google Widevine, and Microsoft PlayReady\. DRM systems are used by content providers to secure digital content for delivery to viewers and for access by viewers\. For a list of DRM systems that are registered with DASH\-IF, see [DASH\-IF System IDs](https://dashif.org/identifiers/content_protection/)\. The [DASH\-IF CPIX specification](https://dashif.org/docs/DASH-IF-CPIX-v2-0.pdf) uses the term "DRM system" as defined here and, in some places, it uses "DRM system" to mean what this specification refers to as a DRM platform\. 
+ **DRM solution** – See DRM platform\.
+ **DRM technology** – See DRM system\.
+ **Encryptor** – A media processing component that encrypts media content using keys obtained from the key provider\. Encryptors typically also add DRM encryption signaling and metadata to the media\.\. Encryptors are usually encoders, packagers, and transcoders\. 
+ **Key provider** – The component of a DRM platform that exposes a SPEKE REST API to handle key requests\. The key provider might be the key server itself, or it might be another component of the platform\.
+ **Key server** – The component of a DRM platform that maintains keys for content encryption and decryption\.
+ **Operator** – A person in charge of operating the overall system, including the encryptor and the key provider\.
+ **Player** – A media player operating on behalf of a viewer\. Gets its information from different sources, including the media manifest files, media files, and DRM licenses\. Requests licenses from the DRM platform on behalf of the viewers\.