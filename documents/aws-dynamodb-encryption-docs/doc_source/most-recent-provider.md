# Most Recent Provider<a name="most-recent-provider"></a>

The *Most Recent Provider* is a [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) that is designed to work with a [provider store](concepts.md#provider-store)\. It gets CMPs from the provider store, and gets the cryptographic materials that it returns from the CMPs\. It typically uses each CMP to satisfy multiple requests for cryptographic materials\. But you can use the features of its provider store to control the extent to which materials are reused, determine how often its CMP is rotated, and even change the type of CMP that it uses without changing the Most Recent Provider\.

The Most Recent Provider is a good choice for applications that need to minimize calls to the provider store and its cryptographic source, and applications that can reuse some cryptographic materials without violating their security requirements\. For example, It allows you to protect your cryptographic materials under an [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys) without calling AWS KMS every time you encrypt or decrypt an item\.

The provider store that you choose determines the type of CMPs that the Most Recent Provider uses and how often it gets a new CMP\. You can use any compatible provider store with the Most Recent Provider, including custom provider stores that you design\. 

The DynamoDB Encryption Client includes a *MetaStore* that creates and returns [Wrapped Materials Providers](wrapped-provider.md) \(Wrapped CMPs\)\. The MetaStore saves multiple versions of the Wrapped CMPs that it generates in an internal DynamoDB table and protects them with client\-side encryption by an internal instance of the DynamoDB Encryption Client\. 

You can configure the MetaStore to use any type of internal CMP to protect the materials in the table, including a [Direct KMS Provider](direct-kms-provider.md) that generates cryptographic materials protected by your AWS KMS customer master key, a Wrapped CMP that uses wrapping and signing keys that you supply, or a compatible custom CMP that you design\.

**For example code, see:**
+ Java: [MostRecentEncryptedItem](https://github.com/aws/aws-dynamodb-encryption-java/blob/master/examples/com/amazonaws/examples/MostRecentEncryptedItem.java)
+ Python: [most\_recent\_provider\_encrypted\_table](https://github.com/aws/aws-dynamodb-encryption-python/blob/master/examples/src/most_recent_provider_encrypted_table.py)

**Topics**
+ [How to use it](#mrp-how-to-use-it)
+ [How it works](#mrp-how-it-works)

## How to use it<a name="mrp-how-to-use-it"></a>

To create a Most Recent Provider, you need to create and configure a provider store, and then create a Most Recent Provider that uses the provider store\. 

These examples show how to create a Most Recent Provider that uses a MetaStore and protects the versions in its internal DynamoDB table with cryptographic materials from a [Direct KMS Provider](direct-kms-provider.md)\.

Each Most Recent Provider has a name that identifies its CMPs in the MetaStore table, and a time\-to\-live value that determines how often it asks the provider store for the version number of the most recent version\.

------
#### [ Java ]

```
final String keyTableName = 'metaStoreTable' //for MetaStore's internal table
final String region = 'us-west-2'
final String cmkArn = 'arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab'
final long ttlInMillis = 60000 //check for a new version every 60 seconds

// A name for the Most Recent Provider; used to
// identify its CMPs in provider store storage
final String materialName = 'testMRP'

// Create an internal DynamoDB client for the MetaStore
final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(region).build();

// Create an internal Direct KMS Provider for the MetaStore
final AWSKMS kms = AWSKMSClientBuilder.standard().withRegion(region).build();
final DirectKmsMaterialProvider kmsProv = new DirectKmsMaterialProvider(kms, cmkArn);

// Create an item encryptor for the MetaStore,
// including the Direct KMS Provider
final DynamoDBEncryptor keyEncryptor = DynamoDBEncryptor.getInstance(kmsProv);

// Create the MetaStore
final MetaStore metaStore = new MetaStore(ddb, keyTableName, keyEncryptor);

//Create the Most Recent Provider
final MostRecentProvider cmp = new MostRecentProvider(metaStore, materialName, ttlInMillis);
```

------
#### [ Python ]

```
aws_cmk_id = 'arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab'
meta_table_name = 'metaStoreTable'

# A name for the Most Recent Provider; used to
# identify its CMPs in provider store storage
material_name = 'testMRP'

# Create an internal DynamoDB table resource for the MetaStore
meta_table = boto3.resource('dynamodb').Table(meta_table_name)

# Create an internal Direct KMS Provider for the MetaStore
aws_kms_cmp = AwsKmsCryptographicMaterialsProvider(key_id=aws_cmk_id)
    
# Create the MetaStore with the Direct KMS Provider
meta_store = MetaStore(
    table=meta_table,
    materials_provider=aws_kms_cmp
)

# Create a Most Recent Provider using the MetaStore
most_recent_cmp = MostRecentProvider(
    provider_store=meta_store,
    material_name=material_name,
    version_ttl=60.0  # Check for a new version every 60 seconds
)
```

------

## How it works<a name="mrp-how-it-works"></a>

The Most Recent Provider gets CMPs from a provider store\. Then, it uses the CMP to generate the cryptographic materials that it returns to the item encryptor\.

### About the Most Recent Provider<a name="about-mrp"></a>

The Most Recent Provider gets a [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\) from a [provider store](concepts.md#provider-store)\. Then, it uses the CMP to generate the cryptographic materials it returns\. Each Most Recent Provider is associated with one provider store, but a provider store can supply CMPs to multiple providers across multiple hosts\.

The Most Recent Provider can work with any compatible CMP from any provider store\. It just calls the operation to get encryption materials or get decryption materials, and returns the output to the item encryptor\. It does not perform any cryptographic operations\.

To request a CMP from its provider store, the Most Recent Provider supplies its material name and the version of an existing CMP it wants to use\. For encryption materials, the Most Recent Provider always requests the maximum \("most recent"\) version\. For decryption materials, it requests the version of the CMP that was used to create the encryption materials, as shown in the following diagram\.

![\[A Most Recent Provider\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/most-recent-provider-1.png)

The Most Recent Provider saves versions of the CMPs that the provider store returns in a local Least Recently Used \(LRU\) cache in memory\. The cache enables the Most Recent Provider to get the CMPs that it needs without calling the provider store for every item\. You can clear the cache on demand\.

To determine the version number that the Most Recent Provider uses in its request for CMPs, the Most Recent Provider periodically sends a query for the maximum version to the provider store\. The query frequency is determined by a time\-to\-live value that you configure when you create the Most Recent Provider\. The time\-to\-live does not determine how often a new CMP version is created—only how often the Most Recent Provider asks the provider store for the maximum version number\. 

Between queries to its provider store, the Most Recent Provider repeatedly uses the most recent version of the CMP that the provider store returned\. Also, if the provider store replies to the query with the same version number, the Most Recent Provider continues to use that version of the CMP\. It requests a new version of the CMP only when the provider store replies to the query with a new version number\.

### About the MetaStore<a name="about-metastore"></a>

You can use a Most Recent Provider with any provider store, including a compatible custom provider store\. The DynamoDB Encryption Client includes a MetaStore, a secure implementation that you can configure and customize\.

A *MetaStore* is a [provider store](concepts.md#provider-store) that creates and returns [Wrapped CMPs](wrapped-provider.md) that are configured with the wrapping key, unwrapping key, and signing key that Wrapped CMPs require\. A MetaStore is a secure option for a Most Recent Provider, because Wrapped CMPs always generate unique item encryption keys for every item\. Only the wrapping key that protects the item encryption key and the signing keys are reused\.

The following diagram shows the components of the MetaStore and how it interacts with the Most Recent Provider\.

![\[A MetaStore\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/most-recent-provider-2.png)

The MetaStore generates the Wrapped CMPs, and then stores them \(in encrypted form\) in an internal DynamoDB table where the provider's material name is the partition key and the version number is the sort key\. The materials in the table are protected by an internal DynamoDB Encryption Client, including an item encryptor and internal [cryptographic materials provider](concepts.md#concept-material-provider) \(CMP\)\.

You can use any type of internal CMP in your MetaStore, including the a [Direct KMS Provider](wrapped-provider.md), a Wrapped CMP with cryptographic materials that you provide, or a compatible custom CMP\. If the internal CMP in your MetaStore is a Direct KMS Provider, your reusable wrapping and signing keys are protected under your [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\) [customer master key](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#master_keys)\. The MetaStore calls AWS KMS every time it adds a new CMP version to its internal table or gets a CMP version from its internal table\.

### Rotating cryptographic materials<a name="most-recent-provider-rotate"></a>

When a Most Recent Provider requests a CMP from a provider store, it always asks the provider store for an existing version of its CMPs by using its material name and the maximum version number that it knows\. To discover the maximum version number, it queries the provider store on a schedule determined by a time\-to\-live value that you configure when you create a Most Recent Provider\. When the time\-to\-live value elapses, the Most Recent Provider asks the provider store for the maximum version of its existing CMPs\.

Between queries, the Most Recent Provider uses the same CMP to satisfy requests for encryption materials\. And, when the timer elapses, if the version number that the provider store returns is the same as the current version number, the Most Recent Provider continues to use the same CMP\. It can use a CMP of that version from its cache or get a new CMP with the same version \(and the same cryptographic materials\) from the provider store\.

To tell the provider store to create a new version of a CMP for a Most Recent Provider, call the provider store's Create New Provider operation with the material name of the Most Recent Provider\. The provider store creates a new CMP and saves an encrypted copy in its internal storage with a greater version number\. \(It also returns a CMP, but you can discard it\.\) As a result, the next time the Most Recent Provider queries the provider store for the maximum version number of its CMPs, it gets the new greater version number, and uses it in subsequent requests\.

You can schedule your Create New Provider calls based on time, the number of items or attributes processed, or any other metric that makes sense for your application\.

### Get encryption materials<a name="most-recent-provider-encrypt"></a>

The Most Recent Provider uses the following process, shown in this diagram, to get the encryption materials that it returns to the item encryptor\. The output depends on the type of CMP that the provider store returns\. The Most Recent Provider can use any compatible provider store, including the MetaStore that is included in the DynamoDB Encryption Client\.

![\[Input, processing, and output of the Most Recent Provider in the DynamoDB Encryption Client\]](http://docs.aws.amazon.com/dynamodb-encryption-client/latest/devguide/images/most-recent-provider-provider-store.png)

When you create a Most Recent Provider, you specify a provider store, a name for the Most Recent Provider, and a time\-to\-live value that determines how often the Most Recent Provider asks its provider store for the version number of its most recent version of cryptographic materials\. 

**Note**  
When the time\-to\-live value expires, the Most Recent Provider asks the provider store for the maximum version number of its existing CMPs\. This action does not increment the version or cause the provider store to create new encryption materials\. For more information, see [Rotating cryptographic materials](#most-recent-provider-rotate)\.

When the item encryptor asks the Most Recent Provider for encryption materials, the Most Recent Provider begins by searching its cache for the latest version of its CMP\.
+ If it finds the latest version CMP in its cache, the Most Recent Provider uses the CMP to generate encryption materials\. Then, it returns the encryption materials to the item encryptor\. This operation does not require a call to the provider store\.
+ If the latest version of the CMP is not in its cache, the Most Recent Provider requests a CMP from its provider store\. The request includes the Most Recent Provider material name and the maximum version number that it knows\.

  1. The provider store returns a CMP from its persistent storage\. If the provider store is a MetaStore, it gets an encrypted Wrapped CMP from its internal DynamoDB table by using the Most Recent Provider material name as the partition key and the version number as the sort key\. The MetaStore uses its internal item encryptor and internal CMP to decrypt the Wrapped CMP\. Then, it returns the plaintext CMP to the Most Recent Provider \. If the internal CMP is a [Direct KMS Provider](direct-kms-provider.md), this step includes a call to the [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\)\.

  1. The CMP adds the `amzn-ddb-meta-id` field to the [actual material description](concepts.md#material-description)\. Its value is the material name and version of the CMP in its internal table\. The provider store returns the CMP to the Most Recent Provider\.

  1. The Most Recent Provider caches the CMP in memory\.

  1. The Most Recent Provider uses the CMP to generate encryption materials\. Then, it returns the encryption materials to the item encryptor\.

### Get decryption materials<a name="most-recent-provider-decrypt"></a>

When the item encryptor asks the Most Recent Provider for decryption materials, the Most Recent Provider uses the following process to get and return them\.

1. The Most Recent Provider asks the provider store for the version number of the cryptographic materials that were used to encrypt the item\. It passes in the actual material description from the [material description attribute](concepts.md#material-description) of the item\.

1. The provider store gets the encrypting CMP version number from the `amzn-ddb-meta-id` field in the actual material description and returns it to the Most Recent Provider\.

1. The Most Recent Provider searches its cache for the version of CMP that was used to encrypt and sign the item\.
+ If it finds the matching version of the CMP is in its cache, the Most Recent Provider uses the CMP to generate decryption materials\. Then, it returns the decryption materials to the item encryptor\. This operation does not require a call to the provider store or any other CMP\.
+ If the matching version of the CMP is not in its cache, the Most Recent Provider requests a CMP from its provider store\. It sends its material name and the encrypting CMP version number in the request\.

  1. The provider store searches its persistent storage for the CMP by using the Most Recent Provider name as the partition key and the version number as the sort key\.
     + If the name and version number are not in its persistent storage, the provider store throws an exception\. If the provider store was used to generate the CMP, the CMP should be stored in its persistent storage, unless it was intentionally deleted\.
     + If the CMP with the matching name and version number are in the provider store's persistent storage, the provider store returns the specified CMP to the Most Recent Provider\. 

       If the provider store is a MetaStore, it gets the encrypted CMP from its DynamoDB table\. Then, it uses cryptographic materials from its internal CMP to decrypt the encrypted CMP before it returns the CMP to Most Recent Provider\. If the internal CMP is a [Direct KMS Provider](direct-kms-provider.md), this step includes a call to the [AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/) \(AWS KMS\)\.

  1. The Most Recent Provider caches the CMP in memory\.

  1. The Most Recent Provider uses the CMP to generate decryption materials\. Then, it returns the decryption materials to the item encryptor\.