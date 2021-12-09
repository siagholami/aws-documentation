# Key management for static key encryption<a name="encryption-static-key-key-management"></a>

In AWS Elemental MediaConnect, you can use static key encryption to secure content in sources, outputs, and entitlements\. To use this method, you store an encryption key as a *secret* in AWS Secrets Manager, and you give AWS Elemental MediaConnect permission to access the secret\. Secrets Manager keeps your encryption key secure, allowing it be accessed only by entities that you specify in an AWS Identity and Access Management \(IAM\) policy\.

With static key encryption, all participants \(the owner of the source, the flow, and any outputs or entitlements\) need the encryption key\. If the content is shared using an entitlement, both AWS account owners must store the encryption key in AWS Secrets Manager\.

For more information, see [Setting up static key encryption](encryption-static-key-set-up.md)\.