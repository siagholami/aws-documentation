# RFC Compliance<a name="RFC-compliance"></a>

ACM Private CA does not enforce certain constraints defined in [RFC 5280](https://tools.ietf.org/html/rfc5280)\. The reverse situation is also true: Certain additional constraints appropriate to a private CA are enforced\.

**Enforced**
+ [Not After date](https://tools.ietf.org/html/rfc5280#section-4.1.2.5)\. In conformity with [RFC 5280](https://tools.ietf.org/html/rfc5280), ACM Private CA prevents the issuance of certificates bearing a `Not After` date later than the `Not After` date of the issuing CA's certificate\.
+ [Basic constraints](https://tools.ietf.org/html/rfc5280#section-4.2.1.9)\. ACM Private CA enforces basic constraints and path length in imported CA certificates\. 

  Basic constraints indicate whether or not the resource identified by the certificate is a CA and can issue certificates\. CA certificates imported to ACM Private CA must include the basic constraints extension, and the extension must be marked `critical`\. In addition to the `critical` flag, `CA=true` must be set\. ACM Private CA enforces basic constraints by failing with a validation exception for the following reasons:
  + The extension is not included in the CA certificate\.
  + The extension is not marked `critical`\.

  Path length determines the maximum depth of valid certification paths below the imported CA certificate in the validation chain\. ACM Private CA enforces path length by failing with a validation exception for the following reasons:
  + Importing a CA certificate would violate the path length constraint in the CA certificate or in any CA certificate in the chain\.
  + Issuing a certificate would violate a path length constraint\.
+ [Name constraints](https://tools.ietf.org/html/rfc5280#section-4.2.1.10)\. These constraints on a CA govern what subject names are valid for downstream certificates\. For more information, see [Enforcing Name Constraints on a Private CA](name_constraints.md)\.

**Not enforced**
+ [Policy constraints](https://tools.ietf.org/html/rfc5280#section-4.2.1.11)\. These constraints limit a CA's capacity to issue subordinate CA certificates\.
+ [Subject Key Identifier \(SKI\)](https://tools.ietf.org/html/rfc5280#section-4.2.1.2) and [Authority Key Identifier \(AKI\)](https://tools.ietf.org/html/rfc5280#section-4.2.1.1)\. The RFC requires a CA certificate to contain the SKI extension\. Certificates issued by the CA must contain an AKI extension matching the CA certificate's SKI\. AWS does not enforce these requirements\. If your CA Certificate does not contain an SKI, the issued end\-entity or subordinate CA certificate AKI will be the SHA\-1 hash of the issuer public key instead\.
+ [SubjectPublicKeyInfo](https://tools.ietf.org/html/rfc5280#section-4.1) and [Subject Alternative Name \(SAN\)](https://tools.ietf.org/html/rfc5280#section-4.2.1.6)\. When issuing a certificate, ACM Private CA copies the SubjectPublicKeyInfo and SAN extensions from the provided CSR without performing validation\.