# Example code for the DynamoDB Encryption Client for Python<a name="python-examples"></a>

The following examples show you how to use the DynamoDB Encryption Client for Python to protect DynamoDB data in your application\. You can find more examples \(and contribute your own\) in the [examples](https://github.com/aws/aws-dynamodb-encryption-python/tree/master/examples) directory of the [aws\-dynamodb\-encryption\-python](https://github.com/aws/aws-dynamodb-encryption-python/) repository on GitHub\.

**Topics**
+ [Use the EncryptedTable client helper class](#python-example-table)
+ [Use the item encryptor](#python-example-item-encryptor)

## Use the EncryptedTable client helper class<a name="python-example-table"></a>

The following example shows you how to use the [Direct KMS Provider](direct-kms-provider.md) with the `EncryptedTable` [client helper class](python-using.md#python-helpers)\. This example uses the same [cryptographic materials provider](concepts.md#concept-material-provider) as the [Use the item encryptor](#python-example-item-encryptor) example that follows\. However, it uses the `EncryptedTable` class instead of interacting directly with the lower\-level [item encryptor](concepts.md#item-encryptor)\.

By comparing these examples, you can see the work that the client helper class does for you\. This includes creating the [DynamoDB encryption context](concepts.md#encryption-context) and making sure the primary key attributes are always signed, but never encrypted\. To create the encryption context and discover the primary key, the client helper classes call the DynamoDB [DescribeTable](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DescribeTable.html) operation\. To run this code, you must have permission to call this operation\.

**See the complete code sample**: [aws\_kms\_encrypted\_table\.py](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/examples/src/aws_kms_encrypted_table.py)

Step 1: Create the table  
Start by creating an instance of a standard DynamoDB table with the table name\.  

```
table_name='test-table'
table = boto3.resource('dynamodb').Table(table_name)
```

Step 2: Create a cryptographic materials provider  
Create an instance of the [cryptographic materials provider](crypto-materials-providers.md) \(CMP\) that you selected\.  
This example uses the [Direct KMS Provider](direct-kms-provider.md), but you can use any compatible CMP\. To create a Direct KMS Provider, specify a [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMK\)\. This example uses the Amazon Resource Name \(ARN\) of the CMK, but you can use any valid CMK identifier\.  

```
aws_cmk_id='arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab'
aws_kms_cmp = AwsKmsCryptographicMaterialsProvider(key_id=aws_cmk_id)
```

Step 3: Create the attribute actions object  
[Attribute actions](concepts.md#attribute-actions) tell the item encryptor which actions to perform on each attribute of the item\. The `AttributeActions` object in this example encrypts and signs all items except for the `test` attribute, which is ignored\.  
Do not specify attribute actions for the primary key attributes when you use a client helper class\. The `EncryptedTable` class signs, but never encrypts, the primary key attributes\.  

```
actions = AttributeActions(
    default_action=CryptoAction.ENCRYPT_AND_SIGN,
    attribute_actions={'test': CryptoAction.DO_NOTHING}
)
```

Step 4: Create the encrypted table  
Create the encrypted table using the standard table, the Direct KMS Provider, and the attribute actions\. This step completes the configuration\.   

```
encrypted_table = EncryptedTable(
    table=table,
    materials_provider=aws_kms_cmp,
    attribute_actions=actions
)
```

Step 5: Put the plaintext item in the table  
When you call the `put_item` method on the `encrypted_table`, your table items are transparently encrypted, signed, and added to your DynamoDB table\.  
First, define the table item\.  

```
plaintext_item = {
    'partition_attribute': 'value1',
    'sort_attribute': 55
    'example': 'data',
    'numbers': 99,
    'binary': Binary(b'\x00\x01\x02'),
    'test': 'test-value'
}
```
Then, put it in the table\.  

```
encrypted_table.put_item(Item=plaintext_item)
```

To get the item from the DynamoDB table in its encrypted form, call the `get_item` method on the `table` object\. To get the decrypted item, call the `get_item` method on the `encrypted_table` object\.

## Use the item encryptor<a name="python-example-item-encryptor"></a>

This example shows you how to interact directly with the [item encryptor](concepts.md#item-encryptor) in the DynamoDB Encryption Client when encrypting table items, instead of using the [client helper classes](python-using.md#python-helpers) that interact with the item encryptor for you\. 

When you use this technique, you create the DynamoDB encryption context and configuration object \(`CryptoConfig`\) manually\. Also, you encrypt the items in one call and put them in your DynamoDB table in a separate call\. This allows you to customize your `put_item` calls and use the DynamoDB Encryption Client to encrypt and sign structured data that is never sent to DynamoDB\.

This example uses the [Direct KMS Provider](direct-kms-provider.md), but you can use any compatible CMP\.

**See the complete code sample**: [aws\_kms\_encrypted\_item\.py](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/examples/src/aws_kms_encrypted_item.py)

Step 1: Create the table  
Start by creating an instance of a standard DynamoDB table resource with the table name\.  

```
table_name='test-table'
table = boto3.resource('dynamodb').Table(table_name)
```

Step 2: Create a cryptographic materials provider  
Create an instance of the [cryptographic materials provider](crypto-materials-providers.md) \(CMP\) that you selected\.  
This example uses the [Direct KMS Provider](direct-kms-provider.md), but you can use any compatible CMP\. To create a Direct KMS Provider, specify a [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) \(CMK\)\. This example uses the Amazon Resource Name \(ARN\) of the CMK, but you can use any valid CMK identifier\.  

```
aws_cmk_id='arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab'
aws_kms_cmp = AwsKmsCryptographicMaterialsProvider(key_id=aws_cmk_id)
```

Step 3: Use the TableInfo helper class  
To get information about the table from DynamoDB, create an instance of the [TableInfo](python-using.md#python-helpers) helper class\. When you work directly with the item encryptor, you need to create a `TableInfo` instance and call its methods\. The [client helper classes](python-using.md#python-helpers) do this for you\.  
The `refresh_indexed_attributes` method of `TableInfo` uses the [DescribeTable](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_DescribeTable.html) DynamoDB operation to get real\-time, accurate information about the table\. This includes its primary key and its local and global secondary indexes\. The caller needs to have permission to call `DescribeTable`\.  

```
table_info = TableInfo(name=table_name)
table_info.refresh_indexed_attributes(table.meta.client)
```

Step 4: Create the DynamoDB encryption context  
The [DynamoDB encryption context](concepts.md#encryption-context) contains information about the table structure and how it is encrypted and signed\. This example creates a DynamoDB encryption context explicitly, because it interacts with the item encryptor\. The [client helper classes](python-using.md#python-helpers) create the DynamoDB encryption context for you\.   
To get the partition key and sort key, you can use the properties of the [TableInfo](python-using.md#python-helpers) helper class\.   

```
index_key = {
    'partition_attribute': 'value1',
    'sort_attribute': 55
}

encryption_context = EncryptionContext(
    table_name=table_name,
    partition_key_name=table_info.primary_index.partition,
    sort_key_name=table_info.primary_index.sort,
    attributes=dict_to_ddb(index_key)
)
```

Step 5: Create the attribute actions object  
[Attribute actions](concepts.md#attribute-actions) tell the item encryptor which actions to perform on each attribute of the item\. The `AttributeActions` object in this example encrypts and signs all items except for the primary key attributes, which are signed, but not encrypted, and the `test` attribute, which is ignored\.  
When you interact directly with the item encryptor and your default action is `ENCRYPT_AND_SIGN`, you must specify an alternative action for the primary key\. You can use the `set_index_keys` method, which uses `SIGN_ONLY` for the primary key, or it uses `DO_NOTHING` if it's the default action\.  
To specify the primary key, this example uses the index keys in the [TableInfo](python-using.md#python-helpers) object, which is populated by a call to DynamoDB\. This technique is safer than hard\-coding primary key names\.  

```
actions = AttributeActions(
    default_action=CryptoAction.ENCRYPT_AND_SIGN,
    attribute_actions={'test': CryptoAction.DO_NOTHING}
)
actions.set_index_keys(*table_info.protected_index_keys())
```

Step 6: Create the configuration for the item  
To configure the DynamoDB Encryption Client, use the objects that you just created in a [CryptoConfig](https://aws-dynamodb-encryption-python.readthedocs.io/en/latest/lib/encrypted/config.html) configuration for the table item\. The client helper classes create the CryptoConfig for you\.   

```
crypto_config = CryptoConfig(
    materials_provider=aws_kms_cmp,
    encryption_context=encryption_context,
    attribute_actions=actions
)
```

Step 7: Encrypt the item  
This step encrypts and signs the item, but it doesn't put it in the DynamoDB table\.   
When you use a client helper class, your items are transparently encrypted and signed, and then added to your DynamoDB table when you call the `put_item` method of the helper class\. When you use the item encryptor directly, the encrypt and put actions are independent\.  
First, create a plaintext item\.  

```
plaintext_item = {
    'partition_attribute': 'value1',
    'sort_key': 55,
    'example': 'data',
    'numbers': 99,
    'binary': Binary(b'\x00\x01\x02'),
    'test': 'test-value'
}
```
Then, encrypt and sign it\. The `encrypt_python_item` method requires the `CryptoConfig` configuration object\.  

```
encrypted_item = encrypt_python_item(plaintext_item, crypto_config)
```

Step 8: Put the item in the table  
This step puts the encrypted and signed item in the DynamoDB table\.  

```
table.put_item(Item=encrypted_item)
```

To view the encrypted item, call the `get_item` method on the original `table` object, instead of the `encrypted_table` object\. It gets the item from the DynamoDB table without verifying and decrypting it\.

```
encrypted_item = table.get_item(Key=partition_key)['Item']
```

The following image shows part of an example encrypted and signed table item\.

The encrypted attribute values are binary data\. The names and values of the primary key attributes \(`partition_attribute` and `sort_attribute`\) and the `test` attribute remain in plaintext\. The output also shows the attribute that contains the signature \(`*amzn-ddb-map-sig*`\) and the [materials description attribute](concepts.md#material-description) \(`*amzn-ddb-map-desc*`\)\.

![\[An excerpt of an encrypted and signed item\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/encrypted-item-closeup.png)