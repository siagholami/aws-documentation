# Managing the Private CA Lifecycle<a name="ca-lifecycle"></a>

CA certificates have a fixed lifetime, or validity period\. When a CA certificate expires, all of the certificates issued directly or indirectly by subordinate CAs below it in the CA hierarchy become invalid\. You can avoid CA certificate expiration by planning in advance\. 

## Choosing Validity Periods<a name="ca-validity-period"></a>

The validity period of an X\.509 certificate is a required basic certificate field\. It determines the time\-range during which the issuing CA certifies that the certificate can be trusted, barring revocation\. \(A root certificate, being self\-signed, certifies its own validity period\.\) 

ACM Private CA and AWS Certificate Manager assist with the configuration of certificate validity periods subject to the following constraints:
+ A certificate managed by ACM Private CA must have a validity period shorter than or equal to the validity period of the CA that issued it\. In other words, child CAs and end\-entity certificates cannot outlive their parent certificates\. Attempting to use the `IssueCertificate` API to issue a CA certificate with a validity period greater than or equal to the parent's CA fails\.
+ Certificates issued and managed by AWS Certificate Manager \(those for which ACM generates the private key\) have a validity period of 13 months \(395 days\)\. ACM manages the renewal process for these certificates\. If you use ACM Private CA to issue certificates directly, you can choose any validity period\.

The following diagram shows a typical configuration of nested validity periods\. The root certificate is the most long\-lived; end\-entity certificates are relatively short\-lived; and subordinate CAs range between these extremes\. 

![\[Subordinate and validity periods must fall within the validity periods of their parents.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/validity.png)

When you plan your CA hierarchy, determine the optimal lifetime for your CA certificates\. Work backwards from the desired lifetime of the end\-entity certificates that you want to issue\. 

**End\-entity certificates**  
End\-entity certificates should have a validity period appropriate to the use case\. A short lifetime minimizes the exposure of a certificate in the event that its private key is lost or stolen\. However, short lifetimes mean frequent renewals\. Failure to renew an expiring certificate can result in downtime\.

The distributed use of end\-entity certificates can also present logistical problems if there is a security breach\. Your planning should account for renewal and distribution certificates, revocation of compromised certificates, and how quickly revocations propagate to clients that rely on the certificates\. 

The default validity period for an end\-entity certificate issued through ACM is 13 months \(395 days\)\. In ACM Private CA, you can use the `IssueCertificate` API to apply any validity period so long as it is less than that of the issuing CA\.

**Subordinate CA Certificates**  
Subordinate CA certificates should have significantly longer validity periods than the certificates they issue\. A good range for a CA certificate's validity is two to five times the period of any child CA certificate or end\-entity certificate it issues\. For example, assume you have a two\-level CA hierarchy \(root CA and one subordinate CA\)\. If you want to issue end\-entity certificates with a one\-year lifetime, you could configure the subordinate issuing CA lifetime to be three years\. This is the default validity period for a subordinate CA certificate in ACM Private CA\. Subordinate CA certificates can be changed without replacing the root CA certificate\.

**Root Certificates**  
Changes to a root CA certificate affect the entire PKI \(public key infrastructure\) and require you to update all the dependent client operating system and browser trust stores\. To minimize operational impact, you should choose a long validity period for the root certificate\. The ACM Private CA default for root certificates is ten years\.

## Managing CA Succession<a name="ca-succession"></a>

You have two ways to manage CA succession: Replace the old CA, or reissue the CA with a new validity period\.

### Replacing an Old CA<a name="replace-ca-cert"></a>

To replace an old CA, you create a new CA and chain it to the same parent CA\. Afterward, you issue certificates from the new CA\. 

Certificates issued from the new CA have a new CA chain\. Once the new CA is established, you can disable the old CA to prevent it from issuing new certificates\. While disabled, the old CA supports revocation for old certificates issued from the CA, and it continues to generate certificate revocation lists \(CRLs\)\. When the last certificate issued from the old CA expires, you can delete the old CA\. You can generate an audit report for all of the certificates issued from the CA to confirm that all of the certificates issued have expired\. If the old CA has subordinate CAs, you must also replace them, because subordinate CAs expire at the same time or before their parent CA\. Start by replacing the highest CA in the hierarchy that needs to be replaced\. Then create new replacement subordinate CAs at each subsequent lower level\. 

AWS recommends that you include a CA generation identifier in the names of CAs as needed\. For example, assume that you name the first generation CA “Corporate Root CA\." When you create the second generation CA, name it “Corporate Root CA G2\." This simple naming convention can help avoid confusion when both CAs are unexpired\.

This method of CA succession is preferred because it rotates the private key of the CA\. Rotating the private key is a best practice for CA keys\. The frequency of rotation should be proportional to the frequency of key use: CAs that issue more certificates should be rotated more frequently\.

**Note**  
Private certificates issued through ACM cannot be renewed if you replace the CA\. If you use ACM for issuance and renewal, you must re\-issue the CA certificate to extend the lifetime of the CA\. 

## Revoking a CA<a name="ca-revoke"></a>

When you revoke a CA certificate, you effectively revoke all of the certificates issued by the CA\. Revocation information is distributed to clients via the CRL\. Clients will stop trusting certificates issued by the CA as soon as they receive the updated CRL\. You should revoke a CA certificate only if you want to effectively revoke all of the end\-entity and CA certificates\.