# How to choose a PKI service<a name="awspki-choose-toplevel"></a>

AWS offers two primary PKI services, [ACM](awspki-service-acm.md) and [ACM PCA](awspki-service-pca.md)\. Use the guidance here to help you decide which service to use for a given scenario\.

## When to use ACM<a name="awspki-choose-acm"></a>

A public [SSL/TLS](pki-concepts.md#concept-ssl) certificate is required to authenticate the identity of your web server and establish a secure connection with any trustworthy host it might interact with\. With ACM, you can easily create and manage public and private SSL/TLS certificates or import an external [public certificate](pki-concepts.md#concept-pub-cert) into your AWS environment\.

 **When Do I Use It?**

Use ACM when you need to create a new public certificate, renew a public certificate created with ACM, or import an existing public certificate into your AWS environment\.

Use ACM to generate a private certificate and manage it within the same environment as your public certificates\. You must first use ACM PCA to establish a private CA from which private certificates can be validated\. Private certificates created in ACM are bound by the following restrictions:
+ They must use [RSA\-2048 keys](https://en.wikipedia.org/wiki/RSA_(cryptosystem)) and [SHA\-256 hashing](https://en.wikipedia.org/wiki/SHA-2)\.
+ They must be renewed after 13 months\.
+ Their subject must be a [DNS](pki-concepts.md#concept-dns) name\.

## When to use ACM PCA<a name="awspki-choose-pca"></a>

Private certificates are issued by a [private CA](pki-concepts.md#concept-ca) and are exclusively used for authentication between entities within your organization\. As a result, private certificates cannot be publically trusted\. ACM PCA lets you establish a private CA and use it to create and manage private certificates under its authority\. Private certificates can be managed by ACM PCA as a standalone service or in conjunction with ACM\.
+ Use ACM PCA if you need to create an internal CA for further authentication operations\.
+ Use ACM PCA if you need to generate a private certificate for internal entity authentication\.
**Note**  
ACM can also generate private certificates once a private CA has been established\. But ACM PCA gives you more control over the management and encryption protocols of those private certificates\.