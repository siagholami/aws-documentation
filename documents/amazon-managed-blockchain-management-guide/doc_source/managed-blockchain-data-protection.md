# Data Protection for Amazon Managed Blockchain<a name="managed-blockchain-data-protection"></a>

Data encryption helps prevent unauthorized users from reading data from a blockchain network and the associated data storage systems\. This includes data saved to persistent media, known as *data at rest*, and data that may be intercepted as it travels the network, known as *data in transit*\.

## Encryption at Rest<a name="managed-blockchain-encryption-at-rest"></a>

Amazon Managed Blockchain offers fully managed encryption at rest\. Managed Blockchain encryption at rest provides enhanced security by encrypting all data at rest on peer nodes using Managed Blockchain owned encryption keys in AWS Key Management Service \(AWS KMS\)\. This functionality helps reduce the operational burden and complexity involved in protecting sensitive data\. With encryption at rest, you can build security\-sensitive blockchain applications that meet strict encryption compliance and regulatory requirements\.

Encryption at rest integrates with AWS KMS for managing the encryption key that is used to encrypt your tables\. A Managed Blockchain owned key is used to encrypt data at rest by default at no additional cost\. No configuration is required\. Using an AWS managed encryption key is not supported\. For more information, see [AWS owned CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-owned-cmk) in the *AWS Key Management Service Developer Guide*\.

## Encryption in Transit<a name="managed-blockchain-encryption-in-transit"></a>

The Hyperledger Fabric certificate authority \(CA\) in each membership provides a TLS certificate authority to secure Hyperledger Fabric communication channels in the network\. For more information, see the [Fabric CA's User Guide](https://hyperledger-fabric-ca.readthedocs.io/en/release-1.2/users-guide.html) in Hyperledger Fabric documentation\.