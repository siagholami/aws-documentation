# Using the DynamoDB Encryption Client for Java<a name="java-using"></a>

This topic explains some of the features of the DynamoDB Encryption Client in Java that might not be found in other programming language implementations\. 

For details about programming with the DynamoDB Encryption Client, see the [Java examples](java-examples.md), the [examples](https://github.com/aws/aws-dynamodb-encryption-java/tree/master/examples) in the `aws-dynamodb-encryption-java repository` on GitHub, and the [Javadoc](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/) for the DynamoDB Encryption Client\.

**Topics**
+ [Item encryptors](#attribute-encryptor)
+ [Configuring save behavior](#save-behavior)
+ [Attribute actions in Java](#attribute-actions-java)
+ [Overriding table names](#override-table-name)

## Item encryptors: AttributeEncryptor and DynamoDBEncryptor<a name="attribute-encryptor"></a>

The DynamoDB Encryption Client in Java has two [item encryptors](concepts.md#item-encryptor): the lower\-level [DynamoDBEncryptor](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html) and the [AttributeEncryptor](#attribute-encryptor)\. 

The `AttributeEncryptor` is a helper class that helps you use the [DynamoDBMapper](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.Methods.html) in the AWS SDK for Java with the `DynamoDB Encryptor` in the DynamoDB Encryption Client\. When you use the `AttributeEncryptor` with the `DynamoDBMapper`, it transparently encrypts and signs your items when you save them\. It also transparently verifies and decrypts your items when you load them\.

## Configuring save behavior<a name="save-behavior"></a>

You can use the `AttributeEncryptor` and `DynamoDBMapper` to add or edit table items with attributes that are signed only or encrypted and signed\. For these tasks, we recommend that you configure it to use the `PUT` save behavior, as shown in the following example\. Otherwise, you might not be able to decrypt your data\. 

```
DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder().withSaveBehavior(SaveBehavior.PUT).build();
DynamoDBMapper mapper = new DynamoDBMapper(ddb, mapperConfig, new AttributeEncryptor(encryptor));
```

If you use the default save behavior, which updates the attributes in the table item, only attributes that have changed are included in the signature\. That signature might not match the signature of the entire item that is calculated on decrypt\.

You can also use the `CLOBBER` save behavior\. This behavior is identical to the `PUT` save behavior except that it disables optimistic locking and overwrites the item in the table\.

To see this code used in an example, see [Using the DynamoDBMapper](java-examples.md#java-example-dynamodb-mapper) and the [AwsKmsEncryptedObject\.java](https://github.com/aws/aws-dynamodb-encryption-java/blob/master/examples/com/amazonaws/examples/AwsKmsEncryptedObject.java) example in the `aws-dynamodb-encryption-java` repository in GitHub\.

## Attribute actions in Java<a name="attribute-actions-java"></a>

[Attribute actions](concepts.md#attribute-actions) determine which attribute values are encrypted and signed, which are only signed, and which are ignored\. The method you use to specify attribute actions depends on whether you use the `DynamoDBMapper` and `AttributeEncryptor`, or the lower\-level [DynamoDBEncryptor](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html)\.

### Attribute actions for the DynamoDBMapper<a name="attribute-action-java-mapper"></a>

When you use the `DynamoDBMapper` and `AttributeEncryptor` helper classes, you use annotations to specify the attribute actions\. The DynamoDB Encryption Client uses the [standard DynamoDB attribute annotations](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.Annotations.html) that define the attribute type to determine how to protect an attribute\. By default, all attributes are encrypted and signed except for primary keys, which are signed but not encrypted\.

**Note**  
Do not encrypt the value of attributes with the [@DynamoDBVersionAttribute annotation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.OptimisticLocking.html), although you can \(and should\) sign them\. Otherwise, conditions that use its value will have unintended effects\.

```
// Attributes are encrypted and signed
@DynamoDBAttribute(attributeName="Description")

// Partition keys are signed but not encrypted
@DynamoDBHashKey(attributeName="Title")

// Sort keys are signed but not encrypted
@DynamoDBRangeKey(attributeName="Author")
```

To specify exceptions, use the encryption annotations defined in the DynamoDB Encryption Client for Java\. If you specify them at the class level, they become the default value for the class\.

```
// Sign only
@DoNotEncrypt

// Do nothing; not encrypted or signed
@DoNotTouch
```

For example, these annotations sign but do not encrypt the `PublicationYear` attribute, and do not encrypt or sign the `ISBN` attribute value\.

```
// Sign only (override the default)
@DoNotEncrypt
@DynamoDBAttribute(attributeName="PublicationYear")

// Do nothing (override the default)
@DoNotTouch
@DynamoDBAttribute(attributeName="ISBN")
```

### Attribute actions for the DynamoDBEncryptor<a name="attribute-action-default"></a>

To specify attribute actions when you use the [DynamoDBEncryptor](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html) directly, create a `HashMap` object in which the name\-value pairs represent attribute names and the specified actions\. 

The valid values are for the attribute actions are defined in the `EncryptionFlags` enumerated type\. You can use `ENCRYPT` and `SIGN` together, use `SIGN` alone, or omit both\. However, if you use `ENCRYPT` alone, the DynamoDB Encryption Client throws an error\. You cannot encrypt an attribute that you don't sign\.

```
ENCRYPT
SIGN
```

**Warning**  
Do not encrypt the primary key attributes\. They must remain in plaintext so DynamoDB can find the item without running a full table scan\.

If you specify a primary key in the encryption context and then specify `ENCRYPT` in the attribute action for either primary key attribute, the DynamoDB Encryption Client throws an exception\.

For example, the following Java code creates an `actions` HashMap that encrypts and signs all attributes in the `record` item\. The exceptions are the partition key and sort key attributes, which are signed but not encrypted, and the `test` attribute, which is not signed or encrypted\.

```
final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
final EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);
final Map<String, Set<EncryptionFlags>> actions = new HashMap<>();

for (final String attributeName : record.keySet()) {
  switch (attributeName) {
    case partitionKeyName: // no break; falls through to next case
    case sortKeyName:
      // Partition and sort keys must not be encrypted, but should be signed
      actions.put(attributeName, signOnly);
      break;
    case "test":
      // Don't encrypt or sign
      break;
    default:
      // Encrypt and sign everything else
      actions.put(attributeName, encryptAndSign);
      break;
  }
}
```

Then, when you call the [encryptRecord](https://aws.github.io/aws-dynamodb-encryption-java/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/encryption/DynamoDBEncryptor.html#encryptRecord-java.util.Map-java.util.Map-com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext-) method of the `DynamoDBEncryptor`, specify the map as the value of the `attributeFlags` parameter\. For example, this call to `encryptRecord` uses the `actions` map\.

```
// Encrypt the plaintext record
final Map<String, AttributeValue> encrypted_record = encryptor.encryptRecord(record, actions, encryptionContext);
```

## Overriding table names<a name="override-table-name"></a>

In the DynamoDB Encryption Client, the name of the DynamoDB table is an element of the [DynamoDB encryption context](concepts.md#encryption-context) that is passed to the encryption and decryption methods\. When you encrypt or sign table items, the DynamoDB encryption context, including the table name, is cryptographically bound to the ciphertext\. If the DynamoDB encryption context that is passed to the decrypt method doesn't match the DynamoDB encryption context that was passed to the encrypt method, the decrypt operation fails\.

Occasionally, the name of a table changes, such as when you back up a table or perform a [point\-in\-time recovery](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/PointInTimeRecovery.html)\. When you decrypt or verify the signature of these items, you must pass in the same DynamoDB encryption context that was used to encrypt and sign the items, including the original table name\. The current table name is not needed\. 

When you use the `DynamoDBEncryptor`, you assemble the DynamoDB encryption context manually\. However, if you are using the `DynamoDBMapper`, the `AttributeEncryptor` creates the DynamoDB encryption context for you, including the current table name\. To tell the `AttributeEncryptor` to create an encryption context with a different table name, use the `EncryptionContextOverrideOperator`\. 

For example, the following code creates instances of the cryptographic materials provider \(CMP\) and the `DynamoDBEncryptor`\. Then it calls the `setEncryptionContextOverrideOperator` method of the `DynamoDBEncryptor`\. It uses the `overrideEncryptionContextTableName` operator, which overrides one table name\. When it is configured this way, the `AttributeEncryptor` creates a DynamoDB encryption context that includes `newTableName` in place of `oldTableName`\. For a complete example, see [EncryptionContextOverridesWithDynamoDBMapper\.java](https://github.com/aws/aws-dynamodb-encryption-java/blob/master/examples/com/amazonaws/examples/EncryptionContextOverridesWithDynamoDBMapper.java)\.

```
final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(kms, cmkArn);
final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);

encryptor.setEncryptionContextOverrideOperator(EncryptionContextOperators.overrideEncryptionContextTableName(
                oldTableName, newTableName));
```

When you call the load method of the `DynamoDBMapper`, which decrypts and verifies the item, you specify the original table name\.

```
mapper.load(itemClass, DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(oldTableName))
                .build());
```

You can also use the `overrideEncryptionContextTableNameUsingMap` operator, which overrides multiple table names\. 

The table name override operators are typically used when decrypting data and verifying signatures\. However, you can use them to set the table name in the DynamoDB encryption context to a different value when encrypting and signing\.

Do not use the table name override operators if you are using the `DynamoDBEncryptor`\. Instead, create an encryption context with the original table name and submit it to the decryption method\.