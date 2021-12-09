# How to use the AWS Encryption SDK command line interface<a name="crypto-cli-how-to"></a>

This topic explains how to use the parameters in the AWS Encryption CLI\. For examples, see [Examples of the AWS Encryption SDK command line interface](crypto-cli-examples.md)\. For complete documentation, see [Read the Docs](https://aws-encryption-sdk-cli.readthedocs.io/en/latest/)\. 

**Topics**
+ [How to encrypt and decrypt data](#crypto-cli-e-d-intro)
+ [How to specify a master key](#crypto-cli-master-key)
+ [How to provide input](#crypto-cli-input)
+ [How to specify the output location](#crypto-cli-output)
+ [How to use an encryption context](#crypto-cli-encryption-context)
+ [How to store parameters in a configuration file](#crypto-cli-config-file)

## How to encrypt and decrypt data<a name="crypto-cli-e-d-intro"></a>

The AWS Encryption CLI uses the features of the AWS Encryption SDK to make it easy to encrypt and decrypt data securely\.
+ When you encrypt data in the AWS Encryption CLI, you specify your plaintext data and a [master key](concepts.md#master-key), such as an AWS Key Management Service \(AWS KMS\) customer master key \(CMK\)\. If you are using a custom master key provider, you need to specify the provider\. You also specify output locations for the [encrypted message](concepts.md#message) and for metadata about the encryption operation\. An [encryption context](concepts.md#encryption-context) is optional, but recommended\.

  ```
  aws-encryption-cli --encrypt --input myPlaintextData \
                     --master-keys key=1234abcd-12ab-34cd-56ef-1234567890ab \
                     --output myEncryptedMessage \
                     --metadata-output ~/metadata \
                     --encryption-context purpose=test
  ```

  The AWS Encryption CLI gets a unique data key from the master key and encrypts your data\. It returns an [encrypted message](concepts.md#message) and metadata about the operation\. The encrypted message contains your encrypted data \(*ciphertext*\) and an encrypted copy of the data key\. You don't have to worry about storing, managing, or losing the data key\.

   
+ When you decrypt data, you pass in your encrypted message, the optional encryption context, and location for the plaintext output and the metadata\. If you are using a custom master key provider, you also supply the master key\. If you are using an AWS KMS CMK, AWS KMS derives the master key from the encrypted message\. 

  ```
  aws-encryption-cli --decrypt --input myEncryptedMessage \
                     --output myPlaintextData \
                     --metadata-output ~/metadata \
                     --encryption-context purpose=test
  ```

  The AWS Encryption CLI uses the master key to decrypt the data key in the encrypted message\. Then it uses the data key to decrypt your data\. It returns your plaintext data and metadata about the operation\.

## How to specify a master key<a name="crypto-cli-master-key"></a>

When you encrypt data in the AWS Encryption CLI, you need to specify a [master key](concepts.md#master-key)\. You can use an AWS KMS customer master key \(CMK\) or a master key from a custom [master key provider](concepts.md#master-key-provider)\. The custom master key provider can be any compatible Python master key provider\.

To specify a master key, use the `--master-keys` parameter \(`-m`\)\. Its value is a collection of [attributes](#cli-master-key-attributes) with the `attribute=value` format\. The attributes that you use depend on the master key provider and the command\.
+ **AWS KMS**\. In encrypt commands, you must specify a `--master-keys` parameter with a **key** attribute\. The other attributes are optional\. In decrypt commands, the `--master-keys` parameter is optional and it can only have a **profile** attribute\. 
+ **Custom master key provider**\. You must specify the `--master-keys` parameter in every command\. The parameter value must have **key** and **provider** attributes\.

You can include [multiple `--master-keys` parameters](#cli-many-cmks) in the same command\. 

### Master key parameter attributes<a name="cli-master-key-attributes"></a>

The value of the `--master-keys` parameter consists of the following attributes and their values\. 

If an attribute name or value includes spaces or special characters, enclose both the name and value in quotation marks\. For example, `--master-keys key=12345 "provider=my cool provider".`

**Key: Specify a master key**  
Use the **key** attribute to identify a master key\. The value can be any key identifier that the master key provider recognizes\.   

```
--master-keys key=1234abcd-12ab-34cd-56ef-1234567890ab
```
In an encrypt command, each `--master-keys` parameter value must include at least one **key** attribute and value\. You can use [multiple **key** attributes](#cli-many-cmks) in each `--master-keys` parameter value\.  

```
aws-encryption-cli --encrypt --master-keys key=1234abcd-12ab-34cd-56ef-1234567890ab key=1a2b3c4d-5e6f-1a2b-3c4d-5e6f1a2b3c4d
```
In encrypt commands that use AWS KMS CMKs, the value of **key** can be the key ID, its key ARN, an alias name, or alias ARN\. For example, this encrypt command uses an alias ARN in the value of the **key** attribute\. For details about the key identifiers for a AWS KMS CMK, see [Key Identifiers](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#key-id) in the *AWS Key Management Service Developer Guide*\.  

```
aws-encryption-cli --encrypt --master-keys key=arn:aws:kms:us-west-2:111122223333:alias/ExampleAlias
```
In decrypt commands that use a custom master key provider, **key** and **provider** attributes are required\. The **key** attribute is not permitted in decrypt commands that use an AWS KMS CMK\.  

```
aws-encryption-cli --decrypt --master-keys provider='myProvider' key='100101'
```

**Provider: Specify the master key provider**  
The **provider** attribute identifies the [master key provider](concepts.md#master-key-provider)\. The default value is `aws-kms`, which represents AWS KMS\. If you are using a different master key provider, the **provider** attribute is required\.   

```
--master-keys key=12345 provider=my_custom_provider
```
For more information about using custom \(non\-AWS KMS\) master key providers, see the **Advanced Configuration** topic in the [README](https://github.com/aws/aws-encryption-sdk-cli/blob/master/README.rst) file for the [AWS Encryption SDK CLI](https://github.com/aws/aws-encryption-sdk-cli/) repository\.

**Region: Specify an AWS Region**  
Use the **region** attribute to specify the AWS Region of an AWS KMS CMK\. This attribute is valid only in encrypt commands and only when the master key provider is AWS KMS\.   

```
--encrypt --master-keys key=alias/primary-key region=us-east-2
```
AWS Encryption CLI commands use the AWS Region that is specified in the **key** attribute value if it includes a region, such as an ARN\. if the **key** value specifies a AWS Region, the **region** attribute is ignored\.  
The **region** attribute takes precedence over other region specifications\. If you don't use a region attribute, AWS Encryption CLI commands uses the AWS Region specified in your AWS CLI [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-multiple-profiles.html), if any, or your default profile\.

**Profile: Specify a named profile**  
Use the **profile** attribute to specify an AWS CLI [named profile](https://docs.aws.amazon.com/cli/latest/userguide/cli-multiple-profiles.html)\. Named profiles can include credentials and an AWS Region\. This attribute is valid only when the master key provider is AWS KMS\.   

```
--master-keys key=alias/primary-key profile=admin-1
```
You can use the **profile** attribute to specify alternate credentials in encrypt and decrypt commands\. In an encrypt command, the AWS Encryption CLI uses the AWS Region in the named profile only when the **key** value does not include a region and there is no **region** attribute\. In a decrypt command, the AWS Region in the name profile is ignored\.

### How to specify multiple master keys<a name="cli-many-cmks"></a>

You can specify multiple master keys in each command\. 

If you specify more than one master key, the first master key generates \(and encrypts\) the data key that is used to encrypt your data\. The other master keys only encrypt the data key\. The resulting [encrypted message](concepts.md#message) contains the encrypted data \("ciphertext"\) and a collection of encrypted data keys, one encrypted by each master key\. Any of the master keys can decrypt one data key and then decrypt the data\.

There are two ways to specify multiple master keys: 
+ Include multiple **key** attributes in a `--master-keys` parameter value\.

  ```
  $cmk_oregon=arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab
  $cmk_ohio=arn:aws:kms:us-east-2:111122223333:key/0987ab65-43cd-21ef-09ab-87654321cdef
  
  --master-keys key=$cmk_oregon key=$cmk_ohio
  ```
+ Include multiple `--master-keys` parameters in the same command\. Use this syntax when the attribute values that you specify do not apply to all of the master keys in the command\.

  ```
  --master-keys region=us-east-2 key=alias/primary_CMK \
  --master-keys region=us-west-1 key=alias/primary_CMK
  ```

## How to provide input<a name="crypto-cli-input"></a>

The encrypt operation in the AWS Encryption CLI takes plaintext data as input and returns an [encrypted message](concepts.md#message)\. The decrypt operation takes an encrypted message as input and returns plaintext data\. 

The `--input` parameter \(`-i`\) , which tells the AWS Encryption CLI where to find the input, is required in all AWS Encryption CLI commands\. 

You can provide input in any of the following ways:
+ Use a file\.

  ```
  --input myData.txt
  ```
+ Use a file name pattern\. 

  ```
  --input testdir/*.xml
  ```
+ Use a directory or directory name pattern\. When the input is a directory, the `--recursive` parameter \(`-r`, `-R`\) is required\.

  ```
  --input testdir --recursive
  ```
+ Pipe input to the command \(stdin\)\. Use a value of `-` for the `--input` parameter\. \(The `--input` parameter is always required\.\)

  ```
  echo 'Hello World' | aws-encryption-cli --encrypt --input -
  ```

## How to specify the output location<a name="crypto-cli-output"></a>

The `--output` parameter tells the AWS Encryption CLI where to write the results of the encryption or decryption operation\. It is required in every AWS Encryption CLI command\. The AWS Encryption CLI creates a new output file for every input file in the operation\. 

If an output file already exists, by default, the AWS Encryption CLI prints a warning, then overwrites the file\. To prevent overwriting, use the `--interactive` parameter, which prompts you for confirmation before overwriting, or `--no-overwrite`, which skips the input if the output would cause an overwrite\. To suppress the overwrite warning, use `--quiet`\. To capture errors and warnings from the AWS Encryption CLI, use the `2>&1` redirection operator to write them to the output stream\.

**Note**  
Commands that overwrite output files begin by deleting the output file\. If the command fails, the output file might already be deleted\.

You can the output location in several ways\.
+ Specify a file name\. If you specify a path to the file, all directories in the path must exist before the command runs\. 

  ```
  --output myEncryptedData.txt
  ```
+ Specify a directory\. The output directory must exist before the command runs\. 

  If the input contains subdirectories, the command reproduces the subdirectories under the specified directory\.

  ```
  --output Test
  ```

  When the output location is a directory \(without file names\), the AWS Encryption CLI creates output file names based on the input file names plus a suffix\. Encrypt operations append `.encrypted` to the input file name and the decrypt operations append `.decrypted`\. To change the suffix, use the `--suffix` parameter\.

  For example, if you encrypt `file.txt`, the encrypt command creates `file.txt.encrypted`\. If you decrypt `file.txt.encrypted`, the decrypt command creates `file.txt.encrypted.decrypted`\.

   
+ Write to the command line \(stdout\)\. Enter a value of `-` for the `--output` parameter\. You can use `--output -` to pipe output to another command or program\.

  ```
  --output -
  ```

## How to use an encryption context<a name="crypto-cli-encryption-context"></a>

The AWS Encryption CLI lets you provide an encryption context in encrypt and decrypt commands\. It is not required, but it is a cryptographic best practice that we recommend\.

An *encryption context* is a type of arbitrary, non\-secret *additional authenticated data*\. In the AWS Encryption CLI, the encryption context consists of a collection of `name=value` pairs\. You can use any content in the pairs, including information about the files, data that helps you to find the encryption operation in logs, or data that your grants or policies require\. 

**In an encrypt command**

The encryption context that you specify in an encrypt command, along with any additional pairs that the [CMM](concepts.md#crypt-materials-manager) adds, is cryptographically bound to the encrypted data\. It is also included \(in plaintext\) in the [encrypted message](concepts.md#encryption-context) that the command returns\. If you are using an AWS KMS customer master key \(CMK\), the encryption context also might appear in plaintext in audit records and logs, such as AWS CloudTrail\. 

The following example shows an encryption context with three `name=value` pairs\.

```
--encryption-context purpose=test dept=IT class=confidential 
```

**In a decrypt command**

In a decrypt command, the encryption context helps you to confirm that you are decrypting the right encrypted message\. 

You are not required to provide an encryption context in a decrypt command, even if an encryption context was used on encrypt\. However, if you do, the AWS Encryption CLI verifies that every element in the encryption context of the decrypt command matches an element in the encryption context of the encrypted message\. If any element does not match, the decrypt command fails\. 

For example, the following command decrypts the encrypted message only if its encryption context includes `dept=IT`\.

```
aws-encryption-cli --decrypt --encryption-context dept=IT ...
```

An encryption context is an important part of your security strategy\. However, when choosing an encryption context, remember that its values are not secret\. Do not include any confidential data in the encryption context\.

**To specify an encryption context**
+ In an **encrypt** command, use the `--encryption-context` parameter with one or more `name=value` pairs\. Use a space to separate each pair\. 

  ```
  --encryption-context name=value [name=value] ...
  ```
+ In a **decrypt** command, the `--encryption-context` parameter value can include `name=value` pairs, `name` elements \(with no values\), or a combination of both\.

  ```
  --encryption-context name[=value] [name] [name=value] ...
  ```

If the `name` or `value` in a `name=value` pair includes spaces or special characters, enclose the entire pair in quotation marks\.

```
--encryption-context "department=software engineering" "AWS Region=us-west-2"
```

For example, this encrypt command includes an encryption context with two pairs, `purpose=test` and `dept=23`\.

```
aws-encryption-cli --encrypt --encryption-context purpose=test dept=23 ...
```

These decrypt command would succeed\. The encryption context in each commands is a subset of the original encryption context\.

```
\\ Any one or both of the encryption context pairs
aws-encryption-cli --decrypt --encryption-context dept=23 ...

\\ Any one or both of the encryption context names
aws-encryption-cli --decrypt --encryption-context purpose ...

\\ Any combination of names and pairs
aws-encryption-cli --decrypt --encryption-context dept purpose=test ...
```

However, these decrypt commands would fail\. The encryption context in the encrypted message does not contain the specified elements\.

```
aws-encryption-cli --decrypt --encryption-context dept=Finance ...
aws-encryption-cli --decrypt --encryption-context scope ...
```

## How to store parameters in a configuration file<a name="crypto-cli-config-file"></a>

You can save time and avoid typing errors by saving frequently used AWS Encryption CLI parameters and values in configuration files\. 

A *configuration file* is a text file that contains parameters and values for an AWS Encryption CLI command\. When you refer to a configuration file in a AWS Encryption CLI command, the reference is replaced by the parameters and values in the configuration file\. The effect is the same is if you typed the file content at the command line\. A configuration file can have any name and it can be located in any directory that the current user can access\. 

The following example configuration file, `cmk.conf`, specifies two AWS KMS CMKs in different regions\.

```
--master-keys key=arn:aws:kms:us-west-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab
--master-keys key=arn:aws:kms:us-east-2:111122223333:key/0987ab65-43cd-21ef-09ab-87654321cdef
```

To use the configuration file in a command, prefix the file name with an at sign \(`@`\)\. In a PowerShell console, use a backtick character to escape the at sign \(``@`\)\.

This example command uses the `cmk.conf` file in an encrypt command\.

------
#### [ Bash ]

```
$ aws-encryption-cli -e @cmk.conf -i hello.txt -o testdir  
```

------
#### [ PowerShell ]

```
PS C:\> aws-encryption-cli -e `@cmk.conf -i .\Hello.txt -o .\TestDir
```

------

**Configuration file rules**

The rules for using configuration files are as follows:
+ You can include multiple parameters in each configuration file and list them in any order\. List each parameter with its values \(if any\) on a separate line\. 
+ Use `#` to add a comment to all or part of a line\.
+ You can include references to other configuration files\. Do not use a backtick to escape the `@` sign, even in PowerShell\.
+ If you use quotes in a configuration file, the quoted text cannot span multiple lines\.

For example, this is the contents of an example `encrypt.conf` file\.

```
# Archive Files
--encrypt
--output /archive/logs
--recursive
--interactive
--encryption-context class=unclassified dept=IT
--suffix  # No suffix
--metadata-output ~/metadata
@caching.conf  # Use limited caching
```

You can also include multiple configuration files in a command\. This example command uses both the `encrypt.conf` and `master-keys.conf` configurations files\.

------
#### [ Bash ]

```
$  aws-encryption-cli -i /usr/logs @encrypt.conf @master-keys.conf
```

------
#### [ PowerShell ]

```
PS C:\> aws-encryption-cli -i $home\Test\*.log `@encrypt.conf `@master-keys.conf
```

------

**Next: **[Try the AWS Encryption CLI examples](crypto-cli-examples.md)