--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# AWS Key Management Service in AWS Snowball Edge<a name="kms"></a>

AWS Key Management Service \(AWS KMS\) is a managed service that makes it easy for you to create and control the encryption keys used to encrypt your data\. AWS KMS uses hardware security modules \(HSMs\) to protect the security of your keys\. Specifically, the Amazon Resource Name \(ARN\) for the AWS KMS key that you choose for a job in AWS Snowball Edge is associated with a KMS key\. That KMS key is used to encrypt the unlock code for your job\. The unlock code is used to decrypt the top layer of encryption on your manifest file\. The encryption keys stored within the manifest file are used to encrypt and de\-encrypt the data on the device\.

In AWS Snowball Edge, AWS KMS protects the encryption keys used to protect data on each AWS Snowball Edge device\. When you create your job, you also choose an existing KMS key\. Specifying the ARN for an AWS KMS key tells AWS Snowball which AWS KMS master key to use to encrypt the unique keys on the AWS Snowball Edge device\. For more information on AWS Snowball Edge supported Amazon S3 server\-side\-encryption options , see [Server\-Side Encryption in AWS Snowball Edge](encryption.md#sse)\.

## Using the AWS\-Managed Customer Master Key for Snowball Edge<a name="defaultenvelopekey"></a>

>If you'd like to use the AWS\-managed customer master key \(CMK\) for Snowball Edge created for your account, use the following procedure\.

**To select the AWS KMS CMK for your job**

1. On the AWS Snowball Management Console, choose **Create job**\.

1. Choose your job type, and then choose **Next**\.

1. Provide your shipping details, and then choose **Next**\.

1. Fill in your job's details, and then choose **Next**\.

1. Set your security options\. Under **Encryption**, for **KMS key** either choose the AWS\-managed CMK or a custom CMK that was previously created in AWS KMS, or choose **Enter a key ARN** if you need to enter a key that is owned by a separate account\.
**Note**  
The AWS KMS key ARN is a globally unique identifier for AWS KMS CMKs\.

1. Choose **Next** to finish selecting your AWS KMS CMK\.

## Creating a Custom KMS Envelope Encryption Key<a name="customenvelopekey"></a>

You have the option of using your own custom AWS KMS envelope encryption key with AWS Snowball Edge\. If you choose to create your own key, that key must be created in the same region that your job was created in\.

To create your own AWS KMS key for a job, see [Creating Keys](https://docs.aws.amazon.com/kms/latest/developerguide/create-keys.html) in the *AWS Key Management Service Developer Guide*\.