# Importing key material in AWS Key Management Service \(AWS KMS\)<a name="importing-keys"></a>

You can create a [customer master key](concepts.md#master_keys) \(CMK\) with key material that you supply\. 

A CMK is a logical representation of a master key\. It contains *key material* used to encrypt and decrypt data, in addition to its [key identifiers](concepts.md#key-id) and other metadata\. When you [create a CMK](create-keys.md), by default, AWS KMS generates the key material for that CMK\. But you can create a CMK without key material and then import your own key material into that CMK, a feature often known as "bring your own key" \(BYOK\)\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/kms/latest/developerguide/images/import-key.png)

**Note**  
Ciphertexts produced by using imported key material are not portable\. You cannot decrypt a ciphertext encrypted under a CMK by using the raw key material outside of AWS KMS\.

Imported key material is supported only for symmetric CMKs in AWS KMS key stores\. It is not supported on [asymmetric CMKs](symm-asymm-concepts.md#asymmetric-cmks) or CMKs in [custom key stores](custom-key-store-overview.md)\.

When you use imported key material, you remain responsible for the key material while allowing AWS KMS to use a copy of it\. You might choose to do this for one or more of the following reasons:
+ To prove that you generated the key material using a source of entropy that meets your requirements\.
+ To use key material from your own infrastructure with AWS services, and to use AWS KMS to manage the lifecycle of that key material within AWS\.
+ To set an expiration time for the key material in AWS and to [manually delete it](importing-keys-delete-key-material.md), but to also make it available again in the future\. In contrast, [scheduling key deletion](deleting-keys.md#deleting-keys-how-it-works) requires a waiting period of 7 to 30 days, after which you cannot recover the deleted CMK\.
+ To own the original copy of the key material, and to keep it outside of AWS for additional durability and disaster recovery during the complete lifecycle of the key material\.

For information about important differences between CMKs with imported key material and those with key material generated by AWS KMS, see [About imported key material](#importing-keys-considerations)\.

The key material you import must be a 256\-bit symmetric encryption key\.

**Topics**
+ [About imported key material](#importing-keys-considerations)
+ [Permissions for importing key material](#importing-keys-permissions)
+ [How to import key material](#importing-keys-overview)
+ [How to reimport key material](#reimport-key-material)
+ [How to identify CMKs with imported key material](#identify-imported-keys)

## About imported key material<a name="importing-keys-considerations"></a>

Before you decide to import key material into AWS KMS, you should understand the following characteristics of imported key material\.

**You generate the key material**  
You are responsible for generating 256 bits of key material using a source of randomness that meets your security requirements\.

**Can't change the key material**  
When you import key material into a CMK, the CMK is permanently associated with that key material\. You can [reimport the same key material](#reimport-key-material), but you cannot import different key material into that CMK\. Also, you cannot [enable automatic key rotation](rotate-keys.md) for a CMK with imported key material\. However, you can [manually rotate a CMK](rotate-keys.md#rotate-keys-manually) with imported key material\. 

**Can't decrypt with any other CMK**  
When you encrypt data under a KMS CMK, the ciphertext cannot be decrypted with any other CMK\. This is true even when you import the same key material into a different CMK\.

**No portability or escrow features**  
The ciphertexts that AWS KMS produces are not portable\. They include metadata and other artifacts that bind each ciphertext to the CMK that was used to encrypt it\. You cannot decrypt an AWS KMS ciphertext outside of AWS KMS even if you have the key material\. You cannot use any AWS tools, such as the [AWS Encryption SDK](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/) or [Amazon S3 client\-side encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingClientSideEncryption.html), to decrypt AWS KMS ciphertexts\.

As a result, you cannot use keys with imported key material to support key escrow arrangements where an authorized third party with conditional access to key material can decrypt certain ciphertexts outside of AWS KMS\. To support key escrow, use the [AWS Encryption SDK](https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/java-example-code.html#java-example-multiple-providers) to encrypt your message under a key that is independent of AWS KMS\.

**You're responsible for availability and durability**  
You are responsible for the key material's overall availability and durability\. AWS KMS is designed to keep imported key material highly available\. But the service does not maintain the durability of imported key material at the same level as key material generated on your behalf\. This difference is meaningful in the following cases:
+ When you set an expiration time for your imported key material, AWS KMS deletes the key material after it expires\. AWS KMS does not delete the CMK or its metadata\. You cannot set an expiration time for key material generated by AWS KMS\.
+ When you [manually delete imported key material](importing-keys-delete-key-material.md), AWS KMS deletes the key material but does not delete the CMK or its metadata\. In contrast, [scheduling key deletion](deleting-keys.md#deleting-keys-how-it-works) requires a waiting period of 7 to 30 days, after which AWS KMS deletes the key material and all of the CMK's metadata\.
+ In the unlikely event of certain regionwide failures that affect the service \(such as a total loss of power\), AWS KMS cannot automatically restore your imported key material\. However, AWS KMS can restore the CMK and its metadata\.

To restore the key material after events like these, you must retain a copy of the key material in a system that you control\. Then, you can reimport it into the CMK\.

## Permissions for importing key material<a name="importing-keys-permissions"></a>

To create and manage CMKs with imported key material, the user needs permission for the operations in this process\. You can provide the `kms:GetParameterForImport`, `kms:ImportKeyMaterial`, and `kms:DeleteImportedKeyMaterial` permissions in the key policy when you create the CMK\. The `kms:ImportKeyMaterial` permission is not included in the default permissions for key administrators, so you need to add it manually\.

To create CMKs with imported key material, the principal needs the following permissions\.
+ [kms:CreateKey](iam-policies.md#iam-policy-example-create-key) \(IAM policy\)
  + To limit this permission to CMKs with imported key material, use the [kms:KeyOrigin](policy-conditions.md#conditions-kms-key-origin) policy condition with a value of `EXTERNAL`\.

    ```
    {
      "Version": "2012-10-17",
      "Statement": {
        "Sid": "IAM policy to create CMKs with no key material" 
        "Effect": "Allow",
        "Resource": "*",
        "Principal": {
          "AWS": "arn:aws:iam::111122223333:role/KMSAdminRole"
        },
        "Action": "kms:CreateKey",
        "Condition": {
          "StringEquals": {
            "kms:KeyOrigin": "EXTERNAL"
        }
      }
    }
    ```
+ [kms:GetParametersForImport](https://docs.aws.amazon.com/kms/latest/APIReference/API_GetParametersForImport.html) \(Key policy or IAM policy\)
  + To limit this permission to requests that use a particular wrapping algorithm and wrapping key spec, use the [kms:WrappingAlgorithm](policy-conditions.md#conditions-kms-wrapping-algorithm) and [kms:WrappingKeySpec](policy-conditions.md#conditions-kms-wrapping-key-spec) policy conditions\. 
+ [kms:ImportKeyMaterial](https://docs.aws.amazon.com/kms/latest/APIReference/API_ImportKeyMaterial.html) \(Key policy or IAM policy\)
  + To allow or prohibit key material that expires and control the expiration date, use the [kms:ExpirationModel](policy-conditions.md#conditions-kms-expiration-model) and [kms:ValidTo](policy-conditions.md#conditions-kms-valid-to) policy conditions\.

To reimport imported key material, the principal needs the [kms:GetParametersForImport](https://docs.aws.amazon.com/kms/latest/APIReference/API_GetParametersForImport.html) and [kms:ImportKeyMaterial](https://docs.aws.amazon.com/kms/latest/APIReference/API_ImportKeyMaterial.html) permissions\.

To delete imported key material, the principal needs [kms:DeleteImportedKeyMaterial](https://docs.aws.amazon.com/kms/latest/APIReference/API_DeleteImportedKeyMaterial.html) permission\.

## How to import key material<a name="importing-keys-overview"></a>

The following overview explains how to import your key material into AWS KMS\. For more details about each step in the process, see the corresponding topic\.

1. [Create a symmetric CMK with no key material](importing-keys-create-cmk.md) – To get started with importing key material, first create a symmetric CMK whose *origin* is `EXTERNAL`\. This indicates that the key material was generated outside of AWS KMS and prevents AWS KMS from generating key material for the CMK\. In a later step you will import your own key material into this CMK\.

1. [Download the public key and import token](importing-keys-get-public-key-and-token.md) – After completing step 1, download a public key and an import token\. These items protect the import of your key material to AWS KMS\.

1. [Encrypt the key material](importing-keys-encrypt-key-material.md) – Use the public key that you downloaded in step 2 to encrypt the key material that you created on your own system\.

1. [Import the key material](importing-keys-import-key-material.md) – Upload the encrypted key material that you created in step 3 and the import token that you downloaded in step 2\.

AWS KMS records an entry in your AWS CloudTrail log when you [create the CMK](ct-createkey.md), [download the public key and import token](ct-getparametersforimport.md), and [import the key material](ct-importkeymaterial.md)\. AWS KMS also records an entry when you delete imported key material or when AWS KMS [deletes expired key material](ct-deleteexpiredkeymaterial.md)\. 

## How to reimport key material<a name="reimport-key-material"></a>

If you manage a CMK with imported key material, you might need to reimport the key material, either because the key material expired, or because the key material was accidentally deleted or lost\. 

You must reimport the same key material that was originally imported into the CMK\. You cannot import different key material into a CMK\. Also, AWS KMS cannot create key material for a CMK that is created without key material\.

To reimport key material, use the same procedure that you used to [import the key material](#importing-keys-overview) the first time, with the following exceptions\.
+ Use an existing CMK, instead of creating a new CMK\. You can skip [Step 1](importing-keys-create-cmk.md) of the import procedure\.
+ If the CMK contains key material, you must [delete the existing key material](importing-keys-delete-key-material.md) before you reimport the key material\. 

Each time you import key material to a CMK, you need to [download and use a new wrapping key and import token](importing-keys-get-public-key-and-token.md) for the CMK\. The wrapping procedure does not affect the content of the key material, so you can use different wrapping keys \(and different import tokens\) to import the same key material\.

## How to identify CMKs with imported key material<a name="identify-imported-keys"></a>

When you create a CMK with no key material, the value of the `Origin` property of the CMK is `EXTERNAL`, and it cannot be changed\. You cannot convert a key that is designed to use imported key material to one that uses the key material that AWS KMS provides\.

You can identify CMKs that require imported key material in the AWS KMS console or by using the AWS KMS API\.

### To identify the value of the `Origin` property of CMKs \(console\)<a name="identify-imported-keys-console"></a>

1. Open the AWS KMS console at [https://console\.aws\.amazon\.com/kms](https://console.aws.amazon.com/kms)\.

1. To change the AWS Region, use the Region selector in the upper\-right corner of the page\.

1. Use either of the following techniques to view the `Origin` property of your CMKs\.
   + To add an **Origin** column to your CMK table, in the upper right corner, choose the **Settings** icon\. Choose **Origin** and choose **Confirm**\. The **Origin** column makes it easy to identify CMKs with an `EXTERNAL` origin property value\.
   + To find the value of the `Origin` property of a particular CMK, choose the key ID or alias of the CMK\. The `Origin` property value appears in the **General configuration** section\.

### To identify the value of the `Origin` property of CMKs \(AWS KMS API\)<a name="identify-imported-keys-api"></a>

Use the [DescribeKey](https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html) operation\. The response includes the `Origin` property of the CMK, as shown in the following example\.

```
$  aws kms describe-key --key-id 1234abcd-12ab-34cd-56ef-1234567890ab
{
    "KeyMetadata": {
        "KeyId": "1234abcd-12ab-34cd-56ef-1234567890ab",
        "Origin": "EXTERNAL",
        "ExpirationModel": "KEY_MATERIAL_EXPIRES"
        "ValidTo": 1568894400.0,
        "Arn": "arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab",
        "AWSAccountId": "111122223333",
        "CreationDate": 1568289600.0,
        "Enabled": false,
        "Description": "",
        "KeyUsage": "ENCRYPT_DECRYPT",
        "KeyState": "PendingImport",
        "KeyManager": "CUSTOMER",
        "CustomerMasterKeySpec": "SYMMETRIC_DEFAULT",
        "EncryptionAlgorithms": [
            "SYMMETRIC_DEFAULT"
        ]
    }
}
```