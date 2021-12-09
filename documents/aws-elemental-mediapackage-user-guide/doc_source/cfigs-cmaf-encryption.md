# Encryption Fields<a name="cfigs-cmaf-encryption"></a>

Protect your content from unauthorized use through encryption\. Digital rights management \(DRM\) systems provide keys to AWS Elemental MediaPackage for content encryption, and licenses to supported players for decryption\.

**Note**  
To encrypt content, you must have a DRM solution provider, and be set up to use encryption\. For information, see [Content Encryption in AWS Elemental MediaPackage](using-encryption.md)\. 

To serve content with copyright protection, choose **Encryption ** and complete the additional fields as follows:

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

1. For **System IDs**, enter unique identifiers for your streaming protocol and DRM system\. Provide up to two IDs for DASH and exactly one for other streaming protocols\. If you provide more than one system ID, enter one per line and choose **Add**\. For a list of common system IDs, see [DASH\-IF System IDs](https://dashif.org/identifiers/content_protection/)\. If you do not know your IDs, ask your DRM solution provider\.