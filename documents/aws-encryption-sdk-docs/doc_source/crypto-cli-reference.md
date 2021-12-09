# AWS Encryption SDK CLI syntax and parameter reference<a name="crypto-cli-reference"></a>

This topic provides syntax diagrams and brief parameter descriptions to help you use the AWS Encryption SDK Command Line Interface \(CLI\)\. For help with master keys and other parameters, see [How to use the AWS Encryption SDK command line interface](crypto-cli-how-to.md)\. For examples, see [Examples of the AWS Encryption SDK command line interface](crypto-cli-examples.md)\. For complete documentation, see [Read the Docs](https://aws-encryption-sdk-cli.readthedocs.io/en/latest/)\.

**Topics**
+ [AWS Encryption CLI syntax](#crypto-cli-syntax)
+ [AWS Encryption CLI command line parameters](#crypto-cli-parameters)
+ [Advanced parameters](#cli-advanced-parameters)

## AWS Encryption CLI syntax<a name="crypto-cli-syntax"></a>

These AWS Encryption CLI syntax diagrams show the syntax for each task that you perform with the AWS Encryption CLI\. 

**Get help**  
To get the full AWS Encryption CLI syntax with parameter descriptions, use `--help` or `-h`\.  

```
aws-encryption-cli (--help | -h)
```

**Get the version**  
To get the version number of your AWS Encryption CLI installation, use `--version`\. Be sure to include the version when you ask questions, report problems, or share tips about using the AWS Encryption CLI\.  

```
aws-encryption-cli --version
```

**Encrypt data**  
The following syntax diagram shows the parameters that an encrypt command uses\.   

```
aws-encryption-cli --encrypt
                   --input <input> [--recursive] [--decode]
                   --output <output> [--interactive] [--no-overwrite] [--suffix [<suffix>]] [--encode]
                   --master-keys  [--master-keys ...]
                       key=<keyID> [provider=<provider-name>] [region=<aws-region>] [profile=<aws-profile>]
                   --metadata-output <location> [--overwrite-metadata] | --suppress-metadata
                   [--encryption-context <encryption_context> [<encryption_context> ...]]
                   [--algorithm <algorithm_suite>]
                   [--caching <attributes>] 
                   [--frame-length <length>]
                   [-v | -vv | -vvv | -vvvv]
                   [--quiet]
```

**Decrypt data**  
The following syntax diagram shows the parameters that a decrypt command uses\.   

```
aws-encryption-cli --decrypt
                   --input <input> [--recursive] [--decode]
                   --output <output> [--interactive] [--no-overwrite]  [--suffix [<suffix>]] [--encode]           
                   --metadata-output <location> [--overwrite-metadata] | --suppress-metadata
                   [--master-keys [--master-keys ...]
                       [key=<keyID>] [provider=<provider-name>] [region=<aws-region>] [profile=<aws-profile>]]
                   [--encryption-context <encryption_context> [<encryption_context> ...]]
                   [--caching <attributes>]
                   [--max-length <length>]
                   [-v | -vv | -vvv | -vvvv]
                   [--quiet]
```

**Use configuration files**  
You can refer to configuration files that contain parameters and their values\. This is equivalent to typing the parameters and values in the command\. For an example, see [How to store parameters in a configuration file](crypto-cli-how-to.md#crypto-cli-config-file)\.  

```
aws-encryption-cli @<configuration_file>

# In a PowerShell console, use a backtick to escape the @.
aws-encryption-cli `@<configuration_file>
```

## AWS Encryption CLI command line parameters<a name="crypto-cli-parameters"></a>

This list provides a basic description of the AWS Encryption CLI command parameters\. For a complete description, see the [aws\-encryption\-sdk\-cli documentation](http://aws-encryption-sdk-cli.readthedocs.io/en/latest/)\.

**\-\-encrypt \(\-e\)**  
Encrypts the input data\. Every command must have an `--encrypt` or `--decrypt` parameter\.

**\-\-decrypt \(\-d\)**  
Decrypts the input data\. Every command must have an `--encrypt` or `--decrypt` parameter\.

**\-\-master\-keys \(\-m\)**  
Specifies the [master keys](concepts.md#master-key) used in encryption and decryption operations\. You can use multiple master keys parameters in each command\.  
The `--master-keys` parameter is required in encrypt commands\. It is required in decrypt commands only when you are using a custom master key provider\.  
**Attributes**: The value of the `--master-keys` parameter consists of the following attributes\. The format is `attribute_name=value`\.     
**key**  
Identifies the master key\. The format is a **key**=ID pair\. The **key** attribute is required in all encrypt commands\.   
When you use an AWS KMS customer master key \(CMK\) in an encrypt command, the value of the **key** attribute can be a key ID, key ARN, an alias name, or an alias ARN\. For details about the   
The **key** attribute is required in decrypt commands when the master key provider is not AWS KMS\. The **key** attribute is not permitted in commands that decrypt data that was encrypted under an AWS KMS CMK\.   
You can specify multiple **key** attributes in each `--master-keys` parameter value\. However, any **provider**, **region**, and **profile** attributes apply to all master keys in the parameter value\. To specify master keys with different attribute values, use multiple `--master-keys` parameters in the command\.   
**provider**  
Identifies the [master key provider](concepts.md#master-key-provider)\. The format is a **provider**=ID pair\. The default value, **aws\-kms**, represents AWS KMS\. This attribute is required only when the master key provider is not AWS KMS\.  
**region**  
Identifies the AWS Region of an AWS KMS CMK\. This attribute is valid only for AWS KMS CMKs\. It is used only when the **key** identifier does not specify a Region; otherwise, it is ignored\. When it is used, it overrides the default Region in the AWS CLI named profile\.   
**profile**  
Identifies an AWS CLI [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-multiple-profiles.html)\. This attribute is valid only for AWS KMS CMKs\. The Region in the profile is used only when the key identifier does not specify a Region and there is no **region** attribute in the command\. 

**\-\-input \(\-i\)**  
Specifies the location of the data to encrypt or decrypt\. This parameter is required\. The value can be a path to a file or directory, or a file name pattern\. If you are piping input to the command \(stdin\), use `-`\.  
If the input does not exist, the command completes successfully without error or warning\.    
**\-\-recursive \(\-r, \-R\)**  
Performs the operation on files in the input directory and its subdirectories\. This parameter is required when the value of `--input` is a directory\.  
**\-\-decode**  
Decodes Base64\-encoded input\.   
If you are decrypting a message that was encrypted and then encoded, you must decode the message before decrypting it\. This parameter does that for you\.   
For example, if you used the `--encode` parameter in an encrypt command, use the `--decode` parameter in the corresponding decrypt command\. You can also use this parameter to decode Base64\-encoded input before you encrypt it\.

**\-\-output \(\-o\)**  
Specifies a destination for the output\. This parameter is required\. The value can be a file name, an existing directory, or `-`, which writes output to the command line \(stdout\)\.   
If the specified output directory does not exist, the command fails\. If the input contains subdirectories, the AWS Encryption CLI reproduces the subdirectories under the output directory that you specify\.   
By default, the AWS Encryption CLI overwrites files with the same name\. To change that behavior, use the `--interactive` or `--no-overwrite` parameters\. To suppress the overwrite warning, use the `--quiet` parameter\.  
If a command that would overwrite an output file fails, the output file is deleted\.  
**\-\-interactive**  
Prompts before overwriting the file\.  
**\-\-no\-overwrite**  
Does not overwrite files\. Instead, if the output file exists, the AWS Encryption CLI skips the corresponding input\.  
**\-\-suffix**  
Specifies a custom file name suffix for files that the AWS Encryption CLI creates\. To indicate no suffix, use the parameter with no value \(`--suffix`\)\.  
By default, when the `--output` parameter does not specify a file name, the output file name has the same name as the input file name plus the suffix\. The suffix for encrypt commands is `.encrypted`\. The suffix for decrypt commands is `.decrypted`\.   
**\-\-encode**  
Applies Base64 \(binary to text\) encoding to the output\. Encoding prevents the shell host program from misinterpreting non\-ASCII characters in output text\.  
Use this parameter when writing encrypted output to stdout \(`--output -`\), especially in a PowerShell console, even when you are piping the output to another command or saving it in a variable\.

**\-\-metadata\-output**  
Specifies a location for metadata about the cryptographic operations\. Enter a path and file name\. If the directory does not exist, the command fails\. To write the metadata to the command line \(stdout\), use `-`\.   
You cannot write command output \(`--output`\) and metadata output \(`--metadata-output`\) to stdout in the same command\. Also, when the value of `--input` or `--output` is a directory \(without file names\), you cannot write the metadata output to the same directory or to any subdirectory of that directory\.  
If you specify an existing file, by default, the AWS Encryption CLI appends new metadata records to any content in the file\. This feature lets you create a single file that contains the metadata for all of your cryptographic operations\. To overwrite the content in an existing file, use the `--overwrite-metadata` parameter\.  
The AWS Encryption CLI returns a JSON\-formatted metadata record for each encryption or decryption operation that the command performs\. Each metadata record includes the full paths to the input and output file, the encryption context, the algorithm suite, and other valuable information that you can use to review the operation and verify that it meets your security standards\.    
**\-\-overwrite\-metadata**  
Overwrites the content in the metadata output file\. By default, the `--metadata-output` parameter appends metadata to any existing content in the file\.

**\-\-suppress\-metadata \(\-S\)**  
Suppresses the metadata about the encryption or decryption operation\. 

**\-\-encryption\-context \(\-c\)**  
Specifies an [encryption context](crypto-cli-how-to.md#crypto-cli-encryption-context) for the operation\. This parameter is not required, but it is recommended\.   
+ In an `--encrypt` command, enter one or more `name=value` pairs\. Use spaces to separate the pairs\.
+ In a decrypt command, enter `name=value` pairs, `name` elements with no values, or both\.
If the `name` or `value` in a `name=value` pair includes spaces or special characters, enclose the entire pair in quotation marks\. For example, `--encryption-context "department=software development"`\.

**\-\-help \(\-h\)**  
Prints usage and syntax at the command line\.

**\-\-version**  
Gets the version of the AWS Encryption CLI\.

**\-v \| \-vv \| \-vvv \| \-vvvv**  
Displays verbose information, warning, and debugging messages\. The detail in the output increases with the number of `v`s in the parameter\. The most detailed setting \(`-vvvv`\) returns debugging\-level data from the AWS Encryption CLI and all of the components that it uses\.

**\-\-quiet \(\-q\)**  
Suppresses warning messages, such as the message that appears when you overwrite an output file\.

## Advanced parameters<a name="cli-advanced-parameters"></a>

\-\-algorithm  
Specifies an alternate [algorithm suite](concepts.md#crypto-algorithm)\. This parameter is optional and valid only in encrypt commands\. By default, the AWS Encryption CLI uses the default algorithm suite for the AWS Encryption SDK, which is AES\-GCM with an [HKDF](https://en.wikipedia.org/wiki/HKDF), an ECDSA signature, and a 256\-bit encryption key\. This algorithm suite is recommended for most encryption operations\. For a list of valid values, see the values for the `algorithm` parameter in [Read the Docs](https://aws-encryption-sdk-cli.readthedocs.io/en/latest/index.html#execution)\.

\-\-frame\-length  
Creates output with specified frame length\. This parameter is optional and valid only in encrypt commands\.   
Enter a value in bytes\. Valid values are 0 and 1 – 2^31 \- 1\. A value of 0 indicates nonframed data\. The default is 4096 \(bytes\)\.   
Whenever possible, use framed data\. The AWS Encryption SDK supports nonframed data only for legacy use\. Some language implementations of the AWS Encryption SDK can still generate nonframed ciphertext\. All supported language implementations can decrypt framed and nonframed ciphertext\.

\-\-max\-length  
Indicates the maximum frame size \(or maximum content length for nonframed messages\) in bytes to read from encrypted messages\. This parameter is optional and valid only in decrypt commands\. It is designed to protect you from decrypting extremely large malicious ciphertext\.   
Enter a value in bytes\. If you omit this parameter, the AWS Encryption SDK does not limit the frame size when decrypting\.

\-\-caching  
Enables the [data key caching](data-key-caching.md) feature, which reuses data keys, instead of generating a new data key for each input file\. This parameter supports an advanced scenario\. Be sure to read the [Data Key Caching](data-key-caching.md) documentation before using this feature\.   
The `--caching` parameter has the following attributes\.    
**capacity \(required\)**  
Determines the maximum number of entries in the cache\.   
The minimum value is 1\. There is no maximum value\.  
**max\_age \(required\)**  
Determine how long cache entries are used, in seconds, beginning when they are added to the cache\.  
Enter a value greater than 0\. There is no maximum value\.  
**max\_messages\_encrypted \(optional\)**  
Determines the maximum number of messages that a cached entry can encrypt\.   
Valid values are 1 – 2^32\. The default value is 2^32 \(messages\)\.  
**max\_bytes\_encrypted \(optional\)**  
Determines the maximum number of bytes that a cached entry can encrypt\.  
Valid values are 0 and 1 – 2^63 \- 1\. The default value is 2^63 \- 1 \(messages\)\. A value of 0 lets you use data key caching only when you are encrypting empty message strings\.