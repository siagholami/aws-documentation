# Encryption Fields<a name="endpoints-dash-encryption"></a>

Protect your content from unauthorized use through encryption\. Digital rights management \(DRM\) systems provide keys to AWS Elemental MediaPackage for content encryption, and licenses to supported players for decryption\.

**Note**  
To encrypt content, you must have a DRM solution provider and be set up to use encryption\. For information, see [Content Encryption in AWS Elemental MediaPackage](using-encryption.md)\. 

1. To serve content without copyright protection, keep **No encryption** selected\.

1. To serve content with copyright protection, choose **Encrypt content** and complete the additional fields as follows:

   1. For **Resource ID**, enter an identifier for the content\. The service sends this to the key server to identify the current endpoint\. How unique you make this depends on how fine\-grained you want access controls to be\. The service does not allow you to use the same ID for two simultaneous encryption processes\. The resource ID is also known as the content ID\. 

      The following example shows a resource ID\.

      ```
      MovieNight20171126093045
      ```

   1. For **System IDs**, enter unique identifiers for your streaming protocol and DRM system\. Provide up to two IDs for DASH and exactly one for the other streaming protocols\. If you provide more than one system ID, enter them on separate lines, and do not separate them with commas or any other punctuation\. For a list of common system IDs, see [DASH\-IF System IDs](https://dashif.org/identifiers/content_protection/)\. If you do not know your IDs, ask your DRM solution provider\.

   1. For **URL**, enter the URL of the API Gateway proxy that you set up to talk to your key server\. The API Gateway proxy must reside in the same AWS Region as MediaPackage\.

      The following example shows a URL\. 

      ```
      https://1wm2dx1f33.execute-api.us-west-2.amazonaws.com/SpekeSample/copyProtection
      ```

   1. For **Role ARN**, enter the Amazon Resource Name \(ARN\) of the IAM role that provides you access to send your requests through API Gateway\. Get this from your DRM solution provider\.

      The following example shows a role ARN\. 

      ```
      arn:aws:iam::444455556666:role/SpekeAccess
      ```

   1. **Certificate ARN** – \(Optional\) Enter a 2048 RSA certificate ARN to use for content key encryption\. Use this option only if your DRM key provider supports content key encryption\. If you use this and your key provider doesn't support it, the event fails\.

      To enter a certificate ARN here, you must have already imported the corresponding certificate into AWS Certificate Manager\. Then enter the certificate ARN from ACM here\. 

      For information about content key encryption, see [Encrypted Content Keys ](drm-content-key-encryption.md)\.

   1. \(Optional\) For **Key rotation interval**, enter the frequency, in seconds, of key changes for live workflows, in which content is streamed real time\. The service retrieves content keys before the live content begins streaming, and then retrieves them as needed over the lifetime of the workflow\. By default, key rotation is set to 60 seconds, which is equivalent to setting it to `60`\. To disable key rotation, set this interval to `0` \(zero\)\. 

      The following example setting causes the service to rotate keys every thirty minutes\.

      ```
      1800
      ```

      For information about key rotation, see [Key Rotation Expected Behavior](drm-content-key-encryption.md)\.