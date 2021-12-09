# Content Encryption in AWS Elemental MediaPackage<a name="using-encryption"></a>

Protect your content from unauthorized use through encryption\. Digital rights management \(DRM\) systems provide keys to AWS Elemental MediaPackage for content encryption, and licenses to supported players for decryption\.

MediaPackage supports live and VOD content encryption\. Live\-to\-VOD assets, though, must be harvested from unencrypted live content\. The live\-to\-VOD asset is also not encrypted\. For more information about this kind of asset, see [Creating Live\-to\-VOD Assets with AWS Elemental MediaPackage](ltov.md)\.

**Note**  
To encrypt content, you must have a DRM solution provider\.   
For an overview, see [https://docs\.aws\.amazon\.com/speke/latest/documentation/what\-is\-speke\.html\#services\-architecture](https://docs.aws.amazon.com/speke/latest/documentation/what-is-speke.html#services-architecture)\.
To get set up, see [https://docs\.aws\.amazon\.com/speke/latest/documentation/customer\-onboarding\.html](https://docs.aws.amazon.com/speke/latest/documentation/customer-onboarding.html)\.

Your DRM solution provider can help you get set up to use DRM encryption in AWS Elemental MediaPackage\. 

The following sections provide additional information about content protection in MediaPackage\.

**Topics**
+ [Encrypted Content Keys](drm-content-key-encryption.md)
+ [Key Rotation Expected Behavior](drm-content-key-rotation.md)