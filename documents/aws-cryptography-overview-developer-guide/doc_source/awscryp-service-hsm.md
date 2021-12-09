# AWS CloudHSM<a name="awscryp-service-hsm"></a>

AWS CloudHSM is a cryptographic service for creating and maintaining hardware security modules \(HSMs\) in your AWS environment\. HSMs are computing devices that process cryptographic operations and provide secure storage for cryptographic keys\. You can use AWS CloudHSM to offload SSL/TLS processing for web servers, protect private keys linked to an issuing certificate authority \(CA\), or enable Transparent Data Encryption \(TDE\) for Oracle databases\.

When you use an HSM from AWS CloudHSM, you can perform a variety of cryptographic tasks:
+ Generate, store, import, export, and manage cryptographic keys, including symmetric keys and asymmetric key pairs\.
+ Use symmetric and asymmetric algorithms to encrypt and decrypt data\.
+ Use cryptographic hash functions to compute message digests and hash\-based message authentication codes \(HMACs\)\.
+ Cryptographically sign data \(including code signing\) and verify signatures\.
+ Generate cryptographically secure random data\.

AWS CloudHSM organizes HSMs in [https://docs.aws.amazon.com/cloudhsm/latest/userguide/clusters.html](https://docs.aws.amazon.com/cloudhsm/latest/userguide/clusters.html), which are automatically synchronized collections of HSMs within a given Availability Zone \(AZ\)\. By adding more HSMs to a cluster and distributing clusters across AZs, you can load balance the cryptographic operations being performed within your cloud environment and provide redundancy and high availability in case of AZ failure\. Additionally, AWS CloudHSM periodically generates and stores [https://docs.aws.amazon.com/cloudhsm/latest/userguide/backups.html](https://docs.aws.amazon.com/cloudhsm/latest/userguide/backups.html) of your clusters, making CloudHSM data recovery secure and simple\.

The keys that you generate in AWS KMS are protected by [FIPS 140\-2 validated cryptographic modules](https://csrc.nist.gov/projects/cryptographic-module-validation-program/Certificate/3139)\. If you want a managed service for creating and controlling encryption keys, but do not want or need to operate your own HSM, consider using [AWS Key Management Service](awscryp-service-kms.md)\.

To learn more about what you can do with AWS CloudHSM, see the [AWS CloudHSM User Guide](https://docs.aws.amazon.com/cloudhsm/latest/userguide/introduction.html)\.