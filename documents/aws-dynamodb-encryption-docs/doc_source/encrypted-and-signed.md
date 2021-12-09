# Which fields are encrypted and signed?<a name="encrypted-and-signed"></a>

In DynamoDB, a [table](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html#HowItWorks.CoreComponents.TablesItemsAttributes) is a collection of items\. Each *item* is a collection of *attributes*\. Each attribute has a name and a value\.

The DynamoDB Encryption Client encrypts the values of attributes\. Then, it calculates a signature over the attributes\. You can specify which attribute values to encrypt and which to include in the signature\. 

Encryption protects the confidentiality of the attribute value\. Signing provides integrity of all signed attributes and their relationship to each other, and provides authentication\. It enables you to detect unauthorized changes to the item as a whole, including adding or deleting attributes, or substituting one encrypted value for another\.

In an encrypted item, some data remains in plaintext, including the table name, all attribute names, the attribute values that you don't encrypt, and the names and values of the primary key \(partition key and sort key\) attributes\. Do not store sensitive data in these fields\.

**Topics**
+ [Encrypting attribute values](#encrypt-attribute-values)
+ [Signing the item](#sign-the-item)
+ [An encrypted and signed item](#encrypted-signed-example)

## Encrypting attribute values<a name="encrypt-attribute-values"></a>

The DynamoDB Encryption Client encrypts the values \(but not the names\) of the attributes that you specify\. To determine which attribute values are encrypted, use [attribute actions](concepts.md#attribute-actions)\. 

For example, this item includes `example` and `test` attributes\.

```
'example': 'data',
'test': 'test-value',
...
```

If you encrypt the `example` attribute, but don't encrypt the `test` attribute, the results look like the following\. The encrypted `example` attribute value is binary data, instead of a string\.

```
'example': Binary(b"'b\x933\x9a+s\xf1\xd6a\xc5\xd5\x1aZ\xed\xd6\xce\xe9X\xf0T\xcb\x9fY\x9f\xf3\xc9C\x83\r\xbb\\"),
'test': 'test-value'
...
```

The primary key attributes—partition key and sort key—of each item must remain in plaintext because DynamoDB uses them to find the item in the table\. They should be signed, but not encrypted\. 

**Warning**  
Do not encrypt the primary key attributes\. They must remain in plaintext so DynamoDB can find the item without running a full table scan\.

The helpers in each programming language identify the primary key attributes for you and ensure that their values are signed, but not encrypted\. And, if you identify your primary key and then try to encrypt it, the client will throw an exception\. If you need to encrypt the primary key for a special use case, use the lower\-level [item encryptor](concepts.md#item-encryptor) directly, but remember that DynamoDB will not be able to find your item without running a full table scan\.

The DynamoDB Encryption Client also does not encrypt or sign the [material description attribute](concepts.md#material-description), which stores information that the DynamoDB Encryption Client needs to verify and decrypt the item\. 

## Signing the item<a name="sign-the-item"></a>

After encrypting the specified attribute values, the DynamoDB Encryption Client calculates a digital signature over the names and values of attributes that you specify in the [attribute actions](concepts.md#attribute-actions) object\. The client saves the signature in an attribute that it adds to the item\.

![\[An encrypted and signed table item\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/encrypted-signed-item.png)

If you provide a table name, it's included in the signature\. This allows you to detect that a signed item was moved to a different table, perhaps maliciously, such as moving an employee record from the `AllEmployees` to `TrustedEmployees` table\. The DynamoDB Encryption Client gets the table name from the [DynamoDB encryption context](concepts.md#encryption-context), where it is an optional field\. 

Be sure to include the primary key in the signature\. It's the default behavior when you use a helper\. The signature captures the relationship between the primary key and other attributes in the item, and the signature validation verifies that the relationship hasn't changed\. 

The [material description attribute](concepts.md#material-description) is not encrypted or signed\.

## An encrypted and signed item<a name="encrypted-signed-example"></a>

When the DynamoDB Encryption Client encrypts and signs a table item, the result is a standard DynamoDB table item with encrypted attribute values\. 

The following figure shows a part of an example encrypted and signed table item\. 

![\[An example encrypted and signed table item\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/encrypted-item-closeup.png)

The figure shows the following characteristics of table items that the DynamoDB Encryption Client encrypts and signs:
+ All attribute names are in plaintext\.
+ The values of the primary key attributes are in plaintext\. In this example, the partition key name is `partition_attribute` and the sort key name is `sort_attribute`\.
+ The values of any attributes that you tell the client not to encrypt remain in plaintext\. In this example, the value of the `test` attribute is in plaintext\.
+ The values of encrypted attributes are binary data\.
+ The client adds a signature attribute \(`*amzn-ddb-map-sig*`\) to the item\. Its value is the item signature\.
+ The client adds a [material description attribute](concepts.md#material-description) \(`*amzn-ddb-map-desc*`\) to the item\. Its value describes how the attribute was encrypted and signed\. The client uses this information to verify and decrypt the item\. The material description attribute is not encrypted or signed\.