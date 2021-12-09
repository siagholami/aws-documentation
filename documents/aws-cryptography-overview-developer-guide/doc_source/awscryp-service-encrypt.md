# AWS Encryption SDK<a name="awscryp-service-encrypt"></a>

The [AWS Encryption SDK](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/) is a client\-side encryption library to help you implement best\-practice encryption and decryption in any application even if you're not a cryptography expert\.

The AWS Encryption SDK works on all types of data\. Every successful call to encrypt returns a single portable, formatted encrypted message that contains metadata and the message ciphertext\.

The AWS Encryption SDK offers advanced data protection features, including envelope encryption and additional authenticated data \(AAD\)\. It also offers secure, authenticated, symmetric key algorithm suites, such as 256\-bit AES\-GCM with key derivation and signing\.

The AWS Encryption SDK is developed as an open source project\. It is available in [multiple programming languages](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/programming-languages.html), including a [command line interface](https://github.com/aws//aws-encryption-sdk-cli) that is supported on Linux, macOS, and Windows\. All implementations are interoperable\. For example, you can encrypt your data with the Java library and decrypt it with the Python library\. Or you can encrypt data with the C library and decrypt it with the CLI\.

For informations about the AWS Encryption SDK, see the [AWS Encryption SDK Developer Guide](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/)\.