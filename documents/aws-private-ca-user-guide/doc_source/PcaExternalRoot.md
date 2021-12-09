# Signing Private CA Certificates with an External CA<a name="PcaExternalRoot"></a>

If your private CA hierarchy's root of trust must be a CA outside of ACM Private CA, you can create and self\-sign your own root CA\. Alternatively, you can obtain a private CA certificate that is signed by an external private CA operated by your organization\. Use this externally obtained CA to sign a private subordinate CA certificate that ACM Private CA manages\. 

**Note**  
Procedures for creating or obtaining an external CA are outside the scope of this guide\.

Using an external parent CA with ACM Private CA also allows you to enforce CA name constraints\. Name constraints are defined in the internet public key infrastructure \(PKI\) standard RFC 5280\. The constraints provide a way for CA administrators to restrict subject names in certificates\. For more information, see the [Name Constraints](https://tools.ietf.org/html/rfc5280#section-4.2.1.10) section of RFC 5280\.

ACM Private CA cannot directly issue CA certificates with name constraints\. However, you can issue CA certificates that include name constraints from an external parent CA\. ACM Private CA will enforce these constraints when issuing subordinate CA and end\-entity certificates\. For more information, see [Enforcing Name Constraints on a Private CA](name_constraints.md)\.

**Topics**
+ [Get a Certificate Signing Request \(CSR\)](PcaGetCsr.md)
+ [Sign Your Private CA Certificate](PcaSignCert.md)
+ [Import Your Private CA Certificate into ACM Private CA](PcaImportCaCert.md)
+ [Retrieve a Private Certificate Created by ACM Private CA](PcaGetCert.md)
+ [Retrieve a Certificate Authority \(CA\) Certificate](PcaGetCACert.md)
+ [Enforcing Name Constraints on a Private CA](name_constraints.md)