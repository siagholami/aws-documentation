# Data Encryption Options<a name="encryption"></a>

You can protect your Elastic Transcoder data by encrypting any input and output files that you want to use for a transcoding job while the files are stored, or at rest, in Amazon S3\. This includes the input file, the output file, and any thumbnails, captions, input watermarks, or input album art\. Playlists and metadata are not encrypted\.

All resources for a job — including the pipeline, Amazon S3 buckets, and AWS Key Management Service key — should be in the same AWS region\.

**Topics**
+ [Encryption Options](#encryption-options)
+ [Using AWS KMS with Elastic Transcoder](#using-kms)
+ [Using Client\-side Encryption with Elastic Transcoder](encrypted-tutorial.md)
+ [HLS Content Protection](content-protection.md)
+ [Digital Rights Management](drm.md)

## Encryption Options<a name="encryption-options"></a>

Elastic Transcoder supports two main encryption options:
+ **Amazon S3 Server\-Side Encryption:** AWS manages the encryption process for you\. For example, Elastic Transcoder calls Amazon S3, and Amazon S3 encrypts your data, saves it on disks in data centers, and decrypts the data when you download it\.

  By default, Amazon S3 buckets accept both encrypted and unencrypted files, but you can set up your Amazon S3 bucket to accept only encrypted files\. You don’t need to make permission changes as long as Elastic Transcoder has access to your Amazon S3 bucket\. 

  For more information about Amazon S3 server\-side encryption, see [Protecting Data Using Server\-Side Encryption](https://docs.aws.amazon.com/AmazonS3/latest/dev/serv-side-encryption.html) in the *Amazon Simple Storage Service Developer Guide*\. For more information about AWS KMS keys, see [What is the AWS Key Management Service?](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html) in the *AWS Key Management Service Developer Guide*\.
**Note**  
There are additional charges for using AWS\-KMS keys\. For more information, see [AWS Key Management Service Pricing](https://aws.amazon.com/kms/pricing)\.
+ **Client\-Side Encryption Using Customer\-Provided Keys:** Elastic Transcoder can also use a client\-provided encryption key to decrypt input files \(which you’ve already encrypted yourself\) or encrypt your output files before storing them in Amazon S3\. In this case, you manage the encryption keys and related tools\. 

  If you want Elastic Transcoder to transcode a file using client\-provided keys, your job request must include the AWS KMS\-encrypted key that you used to encrypt the file, the MD5 of the key that will be used as a checksum, and the initialization vector \(or series of random bits created by a random bit generator\) that you want Elastic Transcoder to use when encrypting your output files\. 

  Elastic Transcoder can only use customer\-provided keys that are encrypted with an AWS KMS master key, and Elastic Transcoder must be given permissions to use the master key\. To encrypt your key, you must call AWS KMS programmatically with an encryption call that contains the following information: 

  ```
  {
      "EncryptionContext": {
          "service" : "elastictranscoder.amazonaws.com"
      },
      "KeyId": "The ARN of the key associated with your pipeline",
      "Plaintext": blob that is your AES key
  }
  ```
**Important**  
Your private encryption keys and your unencrypted data are never stored by AWS; therefore, it is important that you safely manage your encryption keys\. If you lose them, you won't be able to decrypt your data\. 

  To give Elastic Transcoder permission to use your key, see [Using AWS KMS with Elastic Transcoder](#using-kms)\.

  For more information on encrypting data, see the [AWS KMS API Reference](https://docs.aws.amazon.com/kms/latest/APIReference/API_Encrypt.html) and [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html)\. For more information on contexts, see [Encryption Context](https://docs.aws.amazon.com/kms/latest/developerguide/encrypt-context.html) in the *AWS Key Management Service Developer Guide*\.

  For more information about client\-provided keys, see [Protecting Data Using Server\-Side Encryption with Customer\-Provided Encryption Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/ServerSideEncryptionCustomerKeys.html) in the *Amazon Simple Storage Service Developer Guide*\.

For information about the settings required when decrypting and encrypting files using the Elastic Transcoder console, see [\(Optional\) Output Encryption](job-settings.md#job-encryption-settings)\. For information about the settings required when decrypting and encrypting files using the Elastic Transcoder API, see the [Create Job](create-job.md) API action beginning with the **Encryption** element\.

## Using AWS KMS with Elastic Transcoder<a name="using-kms"></a>

You can use the AWS Key Management Service \(AWS KMS\) with Elastic Transcoder to create and manage the encryption keys that are used to encrypt your data\. Before you can set up Elastic Transcoder to use AWS KMS, you must have the following:
+ Elastic Transcoder pipeline
+ IAM role associated with the Elastic Transcoder pipeline
+ AWS KMS key
+ ARN of the AWS KMS key

The following procedures show how to identify your existing resources or create new ones\.

### Getting Ready to Use AWS KMS with Elastic Transcoder<a name="getting-ready-kms"></a>

**To create a pipeline**
+ Follow the steps in [Creating a Pipeline in Elastic Transcoder](creating-pipelines.md)\.

**To identify the IAM role associated with your pipeline**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. In the navigation pane, click **Pipelines**\.

1. Click the magnifying glass icon next to the pipeline name\.

1. Click the **Permissions** section to expand it\.

1. Take note of the IAM role\. If you are using the default role created by Elastic Transcoder, the role is **Elastic\_Transcoder\_Default\_Role**\.

**To create an AWS KMS key**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. Follow the steps in [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html)\.

**To identify the ARN of an AWS KMS key**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, click **Encryption Keys**\.

1. In the region drop\-down list, select the region that your key and pipeline are in\.

1. Click the key you want to use\.

1. Take note of the ARN\.

You can use the console to create an AWS KMS key, but you must use the encryption and decryption APIs to encrypt or decrypt data with an AWS KMS key\. For more information, see [Encrypting and Decrypting Data](https://docs.aws.amazon.com/kms/latest/developerguide/programming-encryption.html)\.

### Connecting Elastic Transcoder and AWS KMS<a name="connecting-ets-and-kms"></a>

Once you have your pipeline, IAM role, and AWS KMS key, you must tell the pipeline which key to use, and tell the key which IAM role can use it\.

**To add the AWS KMS key to your pipeline**

1. Open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. Select the pipeline that you want to use the AWS KMS key with, and click **Edit**\.

1. Click the **Encryption** section to expand it, and in the **AWS KMS Key ARN** section, select **Custom**\.

1. Type in the ARN of your AWS KMS key, and click **Save**\.

**To add an IAM role to your AWS KMS key**

If you did not create your AWS KMS key with the IAM role associated with your pipeline, you can add it by following this procedure:

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, click **Encryption Keys**\.

1. In the region drop\-down list, select the region that your key and pipeline are in\.

1. Click the name of the key that you want to use\.

1. Click the **Key Usage** section to expand it, and then click **Add**\.

1. On the **Attach** page, search for the role associated with your pipeline, select it from the results, and click **Attach**\.

You can now use your AWS KMS key with your Elastic Transcoder pipeline\.