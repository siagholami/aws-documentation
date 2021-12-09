# How the DynamoDB Encryption Client works<a name="how-it-works"></a>

The DynamoDB Encryption Client is designed specifically to protect the data that you store in DynamoDB\. The libraries include secure implementations that you can extend or use unchanged\. And, most elements are represented by abstract elements so you can create and use compatible custom components\.

**Encrypting and signing table items**

At the core of the DynamoDB Encryption Client is an *item encryptor* that encrypts, signs, verifies, and decrypts table items\. It takes in information about your table items and instructions about which items to encrypt and sign\. It gets the encryption materials, and instructions on how to use them, from a [cryptographic material provider](concepts.md#concept-material-provider) that you select and configure\. 

The following diagram shows a high\-level view of this process\.

![\[Encrypting and signing items in the DynamoDB Encryption Client\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/arch-encrypt.png)

To encrypt and sign a table item, the DynamoDB Encryption Client needs:
+ **Information about the table\. ** It gets information about the table from a [DynamoDB encryption context](concepts.md#encryption-context) that you supply\. Some helpers get the required information from DynamoDB and create the DynamoDB encryption context for you\. 
**Note**  
The *DynamoDB encryption context* in the DynamoDB Encryption Client is not related to the *encryption context* in AWS Key Management Service \(AWS KMS\) and the AWS Encryption SDK\.
+ **Which attributes to encrypt and sign\.** It gets this information from the [attribute actions](concepts.md#attribute-actions) that you supply\.
+ **Encryption materials, including encryption and signing keys\.** It gets these from a [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) that you select and configure\. 
+ **Instructions for encrypting and signing the item**\. The CMP adds instructions for using the encryption materials, including encryption and signing algorithms, to the [actual material description](concepts.md#material-description)\.

The [item encryptor](concepts.md#item-encryptor) uses all of these elements to encrypt and sign the item\. The item encryptor also adds two attributes to the item: a [material description attribute](concepts.md#material-description) that contains the encryption and signing instructions \(the actual material description\), and an attribute that contains the signature\. You can interact with the item encryptor directly, or use helper features that interact with the item encryptor for you to implement secure default behavior\.

The result is a DynamoDB item containing encrypted and signed data\.

**Verifying and decrypting table items**

These components also work together to verify and decrypt your item, as shown in the following diagram\.

![\[Verifying and decrypting items in the DynamoDB Encryption Client\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/arch-decrypt.png)

To verify and decrypt an item, the DynamoDB Encryption Client needs the same components, components with the same configuration, or components especially designed for decrypting the items, as follows:
+ **Information about the table** from the [DynamoDB encryption context](concepts.md#encryption-context)\.
+ **Which attributes to encrypt and sign\.** It gets these from the [attribute actions](concepts.md#attribute-actions)\.
+ **Decryption materials, including verification and decryption keys**, from the [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) that you select and configure\.

  The encrypted item doesn't include any record of the CMP that was used to encrypt it\. You must supply the same CMP, a CMP with the same configuration, or a CMP that is designed to decrypt items\.
+ **Information about how the item was encrypted and signed**, including the encryption and signing algorithms\. The client gets these from the [material description attribute](concepts.md#material-description) in the item\.

The [item encryptor](concepts.md#item-encryptor) uses all of these elements to verify and decrypt the item\. It also removes the material description and signature attributes\. The result is a plaintext DynamoDB item\.