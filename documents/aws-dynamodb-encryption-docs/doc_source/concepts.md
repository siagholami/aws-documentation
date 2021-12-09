# Amazon DynamoDB Encryption Client concepts<a name="concepts"></a>

This topic explains the concepts and terminology used in the Amazon DynamoDB Encryption Client\. 

To learn how the components of the DynamoDB Encryption Client interact, see [How the DynamoDB Encryption Client works](how-it-works.md)\.

**Topics**
+ [Cryptographic materials provider \(CMP\)](#concept-material-provider)
+ [Item encryptors](#item-encryptor)
+ [Attribute actions](#attribute-actions)
+ [Material description](#material-description)
+ [DynamoDB encryption context](#encryption-context)
+ [Provider store](#provider-store)

## Cryptographic materials provider \(CMP\)<a name="concept-material-provider"></a>

When implementing the DynamoDB Encryption Client, one of your first tasks is to [select a cryptographic materials provider](crypto-materials-providers.md) \(CMP\) \(also known as an *encryption materials provider*\)\. Your choice determines much of the rest of the implementation\. 

A *cryptographic materials provider* \(CMP\) collects, assembles, and returns the cryptographic materials that the [item encryptor](#item-encryptor) uses to encrypt and sign your table items\. The CMP determines the encryption algorithms to use and how to generate and protect encryption and signing keys\.

The CMP interacts with the item encryptor\. The item encryptor requests encryption or decryption materials from the CMP, and the CMP returns them to the item encryptor\. Then, the item encryptor uses the cryptographic materials to encrypt and sign, or verify and decrypt, the item\.

You specify the CMP when you configure the client\. You can create a compatible custom CMP, or use one of the many CMPs in the library\. Most CMPs are available for multiple programming languages\. 

## Item encryptors<a name="item-encryptor"></a>

The *item encryptor* is a lower\-level component that performs cryptographic operations for the DynamoDB Encryption Client\. It requests cryptographic materials from a [cryptographic materials provider](#concept-material-provider) \(CMP\), then uses the materials that the CMP returns to encrypt and sign, or verify and decrypt, your table item\.

You can interact with the item encryptor directly or use the helpers that your library provides\. For example, the DynamoDB Encryption Client for Java includes an `AttributeEncryptor` helper class that you can use with the `DynamoDBMapper`, instead of interacting directly with the `DynamoDBEncryptor` item encryptor\. The Python library includes `EncryptedTable`, `EncryptedClient`, and `EncryptedResource` helper classes that interact with the item encryptor for you\.

## Attribute actions<a name="attribute-actions"></a>

*Attribute actions* tell the item encryptor which actions to perform on each attribute of the item\. 

The attribute action values can be one of the following:
+ **Encrypt and sign** – Encrypt the attribute value\. Include the attribute \(name and value\) in the item signature\.
+ **Sign only** – Include the attribute in the item signature\.
+ **Do nothing** – Do not encrypt or sign the attribute\.

Use **Encrypt and sign** for all attributes that can store sensitive data\. For primary key attributes \(partition key and sort key\), use **Sign only**\. The [material description attribute](#material-description) and the signature attribute are not signed or encrypted\. You don't need to specify attribute actions for these attributes\.

**Warning**  
Do not encrypt the primary key attributes\. They must remain in plaintext so DynamoDB can find the item without running a full table scan\.

If the [DynamoDB encryption context](#encryption-context) identifies your primary key attributes, the client will throw an error if you try to encrypt them\.

The technique that you use to specify the attribute actions is different for each programming language\. It might also be specific to helper classes that you use\.

For details, see the documentation for your programming language\.
+ [Python](python-using.md#python-attribute-actions)
+ [Java](java-using.md#attribute-actions-java)

## Material description<a name="material-description"></a>

The *material description* for an encrypted table item consists of information, such as encryption algorithms, about how the table item is encrypted and signed\. The [cryptographic materials provider](#concept-material-provider) \(CMP\) records the material description as it assembles the cryptographic materials for encryption and signing\. Later, when it needs to assemble cryptographic materials to verify and decrypt the item, it uses the material description as its guide\. 

In the DynamoDB Encryption Client, the material description refers to three related elements:

**Requested material description**  
Some [cryptographic materials providers](#concept-material-provider) \(CMPs\) let you specify advanced options, such as an encryption algorithm\. To indicate your choices, you add name\-value pairs to the material description property of the [DynamoDB encryption context](#encryption-context) in your request to encrypt a table item\. This element is known as the *requested material description*\. The valid values in the requested material description are defined by the CMP that you choose\.   
Because the material description can override secure default values, we recommend that you omit the requested material description unless you have a compelling reason to use it\.

**Actual material description**  
The material description that the [cryptographic materials providers](#concept-material-provider) \(CMPs\) return is known as the *actual material description*\. It describes the actual values that the CMP used when it assembled the cryptographic materials\. It usually consists of the requested material description, if any, with additions and changes\.

**Material description attribute**  
The client saves the actual material description in the *material description attribute* of the encrypted item\. The material description attribute name is `amzn-ddb-map-desc` and its value is the actual material description\. The client uses the values in the material description attribute to verify and decrypt the item\.

## DynamoDB encryption context<a name="encryption-context"></a>

The *DynamoDB encryption context* supplies information about the table and item to the [cryptographic materials provider](#concept-material-provider) \(CMP\)\. In advanced implementations, the DynamoDB encryption context can include a [requested material description](#material-description)\.

When you encrypt table items, the DynamoDB encryption context is cryptographically bound to the encrypted attribute values\. When you decrypt, if the DynamoDB encryption context is not an exact, case\-sensitive match for the DynamoDB encryption context that was used to encrypt, the decrypt operation fails\. If you interact with the [item encryptor](#item-encryptor) directly, you must provide a DynamoDB encryption context when you call an encrypt or decrypt method\. Most helpers create the DynamoDB encryption context for you\.

**Note**  
The *DynamoDB encryption context* in the DynamoDB Encryption Client is not related to the *encryption context* in AWS Key Management Service \(AWS KMS\) and the AWS Encryption SDK\.

The DynamoDB encryption context can include the following fields\. All fields and values are optional\.
+ Table name
+ Partition key name
+ Sort key name
+ Attribute name\-value pairs
+ [Requested material description](#material-description)

## Provider store<a name="provider-store"></a>

A *provider store* is a component that returns [cryptographic materials providers](#concept-material-provider) \(CMPs\)\. The provider store can create the CMPs or get them from another source, such as another provider store\. The provider store saves versions of the CMPs that it creates in persistent storage in which each stored CMP is identified by the material name of the requester and version number\. 

The [Most Recent Provider](most-recent-provider.md) in the DynamoDB Encryption Client gets its CMPs from a provider store, but you can use the provider store to supply CMPs to any component\. Each Most Recent Provider is associated with one provider store, but a provider store can supply CMPs to many requesters across multiple hosts\.

The provider store creates new versions of CMPs on demand, and returns new and existing versions\. It also returns the latest version number for a given material name\. This lets the requester know when the provider store has a new version of its CMP that it can request\.

The DynamoDB Encryption Client includes a[ MetaStore](most-recent-provider.md#about-metastore), which is a provider store that creates Wrapped CMPs with keys that are stored in DynamoDB and encrypted by using an internal DynamoDB Encryption Client\. 

**Learn more:**
+ Provider store: [Java](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/providers/store/ProviderStore.html), [Python](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/src/dynamodb_encryption_sdk/material_providers/store/__init__.py)
+ MetaStore: [Java](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/providers/store/MetaStore.html), [Python](https://aws-dynamodb-encryption-python.readthedocs.io/en/latest/lib/materials_providers/metastore.html#module-dynamodb_encryption_sdk.material_providers.store.meta)