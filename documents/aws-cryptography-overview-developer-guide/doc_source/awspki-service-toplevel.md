# AWS public key infrastructure \(PKI\) services and tools<a name="awspki-service-toplevel"></a>

AWS offers multiple PKI services that can help you easily and securely manage your certificate infrastructure\. The primary AWS offerings for PKI are tightly linked:
+ **[AWS Certificate Manager \(ACM\)](awspki-service-acm.md)** is used to generate, issue, and manage [public and private SSL/TLS certificates](pki-concepts.md#concept-pub-cert) for use with your AWS based websites and applications\.
+ **[AWS Certificate Manager Private Certificate Authority \(ACM PCA\)](awspki-service-pca.md)** is a managed private certificate authority \(CA\) service with which you can manage your CA infrastructure and your [private certificates](pki-concepts.md#concept-priv-cert)\.

Many AWS services rely on these PKI services to authenticate the actors involved in a data transfer process\. For a list of such services and an overview of how they use PKI practices, see [Other AWS Services That Use SSL/TLS Certificates](awspki-service-other.md)\.

AWS PKI services comply with a wide range of security standards, making it easy for you to protect your data without worrying about governmental or professional regulations\. For a full list of AWS data security standard compliances, see [AWS Compliance Programs](https://aws.amazon.com/compliance/programs/)\.