# Amazon DynamoDB Encryption Client Developer Guide

This repository contains the open source version of the [Amazon DynamoDB Encryption Client Developer
Guide](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/). We welcome your contributions! Please start by reading the
[Contributions.md](https://github.com/awsdocs/aws-dynamodb-encryption-docs/blob/master/CONTRIBUTING.md) page in this
repo.

## How you can help
We welcome all contributions, including help with conceptual explanations and diagrams. But because 
examples are the heart of every Developer Guide, we want more of them, especially real-world
examples that show common use patterns. We also need your help to build the [troubleshooting
section](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/troubleshooting.html)
into a more comprehensive guide.

## What is the DynamoDB Encryption Client? 

The Amazon DynamoDB Encryption Client is a
[client-side](https://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/client-server-side.html)
software library that helps developers to protect their table data before sending it to [Amazon
DynamoDB](https://aws.amazon.com/dynamodb/). Encrypting sensitive data in transit and at rest helps to ensure that the plaintext application data isn’t available to any third party, including AWS.

## What is the DynamoDB Encryption Client Developer Guide?

The DynamoDB Encryption Client Developer Guide provides a
conceptual overview of the DynamoDB Encryption Client, including an introduction to its
architecture, details about how it protects DynamoDB table data and how it differs from DynamoDB
server-side encryption, guidance on selecting critical components for your application, and examples
in each programming language to help developers get started.

It is not a detailed technical reference and it does not explain how to extend the DynamoDB
Encryption Client or implement it in another language.

## Where is the code?
We are developing the DynamoDB Encryption Client libraries in the following open source projects on GitHub. 

* Java - [aws-dynamodb-encryption-java](https://github.com/aws/aws-dynamodb-encryption-java)
* Python -
[aws-dynamodb-encryption-python](https://github.com/aws/aws-dynamodb-encryption-python)

## Who is the audience?
Any developer who needs to protect sensitive DynamoDB data at its source. The developers who use this library
don't need any cryptographic expertise. The library is designed for general use and includes strong and secure default
implementations. If anyone needs a custom design, the libraries provide extension points for custom implementations.

Developers can use the DynamoDB Encryption Client to protect their data under their AWS Key Management
Service (AWS KMS) customer master key (CMK), but the DynamoDB Encryption Client does not require an AWS account or any AWS service.

If you describe a scenario that requires an AWS service, be sure to explain that it does and link to
the service and how to set any required permissions.


## License Summary

The documentation is made available under the Creative Commons Attribution-ShareAlike 4.0 International License. See the LICENSE file.

The sample code within this documentation is made available under a modified MIT license. See the LICENSE-SAMPLECODE file.
