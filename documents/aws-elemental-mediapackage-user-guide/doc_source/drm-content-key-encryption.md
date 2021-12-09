# Encrypted Content Keys<a name="drm-content-key-encryption"></a>

AWS Elemental MediaPackage uses a Content Protection Information Exchange \(CPIX\) document to communicate with SPEKE about content keys that are used to encrypt your content\. For the most secure DRM encryption solution, use encrypted content keys in the CPIX document\. 

To use encrypted content keys, the following requirements must be met:
+ The encrypted content must be live\. Video on demand \(VOD\) and live\-to\-VOD workflows don't support encrypted content keys in the CPIX document\.
+ Your DRM key provider must support encrypted content keys\. If you enable this feature for a key provider that doesn't handle content key encryption, playback fails\.
+ You must import a suitable certificate into AWS Certificate Manager in the same Region that you run MediaPackage\. For information about ACM, see the [AWS Certificate Manager User Guide](https://docs.aws.amazon.com/acm/latest/userguide/)\. 

  The following procedures describe how to prepare and manage the certificate\.

**To prepare a certificate for DRM content key encryption**

1. Obtain a 2048 RSA, SHA\-512\-signed certificate\. 

1. Open the ACM console at [https://console\.aws\.amazon\.com/acm/](https://console.aws.amazon.com/acm/)\.

1. Import the certificate into ACM according to the instructions at [Importing Certificates into AWS Certificate Manager](https://docs.aws.amazon.com/acm/latest/userguide/import-certificate.html)\. Note the resulting certificate ARN because you will need it later\.

   For use in DRM encryption, your certificate must have a status of **Issued** in ACM\.

**To use a certificate in AWS Elemental MediaPackage**

When you use DRM encryption in your endpoint configuration, provide your certificate ARN in the encryption parameters\. This enables content key encryption\. You can use the same certificate ARN for multiple events\. For information, see the encryption settings information in [Working with Endpoints in AWS Elemental MediaPackage](endpoints.md)\. 

**To renew a certificate**

To renew a certificate that you are using in AWS Elemental MediaPackage, reimport it in AWS Certificate Manager\. The certificate renews without any disruption of its use in MediaPackage\. 

**To delete a certificate**

To delete a certificate from AWS Certificate Manager, it must not be associated with any other service\. Delete the certificate ARN from endpoint configurations where you have used it, then delete it from ACM\. 

**Note**  
If you delete a certificate ARN from an active endpoint, the endpoint keeps running, but stops using content key encryption\. 