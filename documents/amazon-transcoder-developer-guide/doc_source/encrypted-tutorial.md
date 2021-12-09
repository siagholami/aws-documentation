# Using Client\-side Encryption with Elastic Transcoder<a name="encrypted-tutorial"></a>

With Elastic Transcoder, you can transcode files that you encrypted and uploaded to Amazon S3\. In this tutorial, we show you how to encrypt your file, set up Elastic Transcoder to transcode an encrypted file, and create a job to transcode the file\. This tutorial assumes that you are using Linux\. 

Elastic Transcoder supports three encryption algorithms\. This tutorial uses AES\-CBC\-PKCS7 \(AES CBC 128\-bit with padding\) because it's natively supported by OpenSSL\. OpenSSL 1\.0\.1 and later also support AES\-CTR\.

**Note**  
You can't use Elastic Transcoder with the AWS Encryption SDK \(or CLI\) because the SDK does not show the initialization vector\. Elastic Transcoder needs the initialization vector to transcode an encrypted file\.

**Topics**
+ [Prerequisites](#client-side-encryption-prerequisites)
+ [Step 1: Convert Your Plaintext Key and Initialization Vector](#step-1)
+ [Step 2: Encrypt Your Input File](#step-2)
+ [Step 3: Encrypt Your Plaintext Key With KMS](#step-3)
+ [Step 4: Generate the Ciphertext MD5 Hash](#step-4)
+ [Step 5: Upload Your Encrypted File](#step-5)
+ [Step 6: Configure Your Elastic Transcoder Pipeline](#step-6)
+ [Step 7: Create Your Elastic Transcoder Job](#step-7)

## Prerequisites<a name="client-side-encryption-prerequisites"></a>

To encrypt and transcode a file, you need the following:
+ A video or audio file that you want to encrypt and transcode\. 

  For this tutorial, we use an input video called `input.mp4`\.
+ A KMS master key ARN\.

  For this tutorial, we refer to this as `YourKmsKeyArnHere`\. 
+ A plaintext key\. This is a string of characters\. It can be 16, 24, or 32 characters long\. 

  For this tutorial, we use the 16\-byte string `keykeykeykeykeyk`\.
+ An initialization vector\. This is a string of 16 characters\.

  For this tutorial, we use the initialization vector `1234567890123456`\. 

## Step 1: Convert Your Plaintext Key and Initialization Vector<a name="step-1"></a>

To encrypt a file and transcode the encrypted file, you need the base64 and hexadecimal versions of your plaintext key and initialization vector\. Start by converting your plaintext key and initialization vector into base64 and hexadecimal\. To do that, run the following commands on the command line:

```
echo -n "keykeykeykeykeyk" | base64
echo -n "1234567890123456" | base64
echo -n "keykeykeykeykeyk" | xxd -p
echo -n "1234567890123456" | xxd -p
```

**Note**  
Make sure to include the *\-n* option when running the echo commands\. This tells Linux to encode only the given string, and to not include a newline character at the end of the string\. If you forget the *\-n*, the encoded results include extra characters\.

Record the results\. For this example, the results are the following: 

```
a2V5a2V5a2V5a2V5a2V5aw==
MTIzNDU2Nzg5MDEyMzQ1Ng==
6b65796b65796b65796b65796b65796b
31323334353637383930313233343536
```

## Step 2: Encrypt Your Input File<a name="step-2"></a>

Now that you encoded the input key and initialization vector, encrypt your input file with the hexadecimal input key and initialization vector\. To encrypt your file, run the following command: 

```
openssl enc -nosalt -aes-128-cbc -in "input.mp4" -out "encrypted.mp4" -K "6b65796b65796b65796b65796b65796b" -iv "31323334353637383930313233343536"
```

## Step 3: Encrypt Your Plaintext Key With KMS<a name="step-3"></a>

Now that you have an encrypted file, encrypt your KMS key\. KMS supports only the Galois/Counter Mode \(GCM\) encryption algorithm, so your key is encrypted with GCM no matter which encryption algorithm you used for your input file\. 

Make sure that you call the same region for KMS that your KMS key is actually in\. The region is visible in your master key ARN, and looks like `us-east-1`\. You can use `--region` in your CLI call to specify the correct region\. Also, make sure that you include the parameter `--encryption-context "service=elastictranscoder.amazonaws.com"`\. If you don't include it, the call to KMS succeeds, but Elastic Transcoder won't be able to decrypt your file\. Each time you call the encryption operation it returns a different result, even if you use the same plaintext key\.

Run the following command to encrypt your KMS key:

```
aws kms encrypt --key-id "YourKmsKeyArnHere" --encryption-context "service=elastictranscoder.amazonaws.com" --plaintext "a2V5a2V5a2V5a2V5a2V5aw==" | jq -r ".CiphertextBlob"
```

Your result is a blob of ciphertext that looks like this: 

```
CiCCgQY/OrQ5/gdcoup5mIrqT/WTIjxM6ZSge+uRZ7tiAhKXAQEBAgB4goEGPzq0Of4HXKLqeZiK6k/1kyI8TOmUoHvrkWe7YgIAAABuMGwGCSqGSIb3DQEHBqBfMF0CAQAwWAYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAxIEi6/cfLGY+6ia0UCARCAK5wHYxg+3oHCzX4B4RqUY9N+YmVRooWmncNN4NKduc6jA/m+A+cKAFSvuF0=
```

## Step 4: Generate the Ciphertext MD5 Hash<a name="step-4"></a>

Now that you have an encrypted file and an encrypted KMS key, use the encrypted KMS key to generate a ciphertext hash:

```
echo -n "CiCCgQY/OrQ5/gdcoup5mIrqT/WTIjxM6ZSge+uRZ7tiAhKXAQEBAgB4goEGPzq0Of4HXKLqeZiK6k/1kyI8TOmUoHvrkWe7YgIAAABuMGwGCSqGSIb3DQEHBqBfMF0CAQAwWAYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAxIEi6/cfLGY+6ia0UCARCAK5wHYxg+3oHCzX4B4RqUY9N+YmVRooWmncNN4NKduc6jA/m+A+cKAFSvuF0=" | base64 -d | md5sum -b | cut -f 1 -d " " | xxd -r -p | base64
```

Your result looks like this:

```
zG9MId7htnmIZEWCXXG5yg==
```

Save this MD5 hash for [Step 7: Create Your Elastic Transcoder Job](#step-7)\.

## Step 5: Upload Your Encrypted File<a name="step-5"></a>

Upload `encrypted.mp4` to the S3 bucket that you want to use as your input bucket\. <a name="upload-encrypted-file"></a>

**To upload your encrypted file to Amazon S3**

1. Sign in to the AWS Management Console and open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. In the list of buckets, choose the name of your input bucket\. 

1. Choose **Upload**\.

1. In the **Upload** dialog box, choose **Add Files**, and choose the file that you want to upload\.

1. Choose **Upload**\.

## Step 6: Configure Your Elastic Transcoder Pipeline<a name="step-6"></a>

Now that you have an encrypted KMS master key and an encrypted file, configure your pipeline to use your KMS master key\. 

Check that your pipeline has the correct **AWS KMS Key ARN** configured\. If it doesn't, you can update your pipeline to add or edit that field\. <a name="configure-pipeline-kms-key"></a>

**To configure your pipeline with your KMS key**

1. Sign in to the AWS Management Console and open the Elastic Transcoder console at [https://console\.aws\.amazon\.com/elastictranscoder/](https://console.aws.amazon.com/elastictranscoder/)\.

1. Either choose **Create New Pipeline** or select your pipeline and choose **Edit**\.

1. Scroll down to the **Encryption \(Optional\)** section, and expand it if necessary\.

1. For **AWS KMS Key ARN**, choose **Custom**\. In the text area, paste the ARN of your KMS master key\. In this tutorial, the KMS master key ARN is `YourKmsKeyArnHere`\.

1. If you're editing an existing pipeline, choose **Save**\. If you're creating a pipeline, choose **Create Pipeline**\.

## Step 7: Create Your Elastic Transcoder Job<a name="step-7"></a>

Now that you have your encrypted file, your encrypted KMS master key, and an Elastic Transcoder pipeline, you can transcode your encrypted file by creating a job\. For this example, use the following command to create a job with the Elastic Transcoder API:

```
aws elastictranscoder create-job --pipeline-id "YourPipelineIdHere" --inputs '[{"Key":"encrypted.mp4","Encryption":{"Mode":"aes-cbc-pkcs7","Key":"CiCCgQY/OrQ5/gdcoup5mIrqT/WTIjxM6ZSge+uRZ7tiAhKXAQEBAgB4goEGPzq0Of4HXKLqeZiK6k/1kyI8TOmUoHvrkWe7YgIAAABuMGwGCSqGSIb3DQEHBqBfMF0CAQAwWAYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAxIEi6/cfLGY+6ia0UCARCAK5wHYxg+3oHCzX4B4RqUY9N+YmVRooWmncNN4NKduc6jA/m+A+cKAFSvuF0=","KeyMd5":"zG9MId7htnmIZEWCXXG5yg==","InitializationVector":"MTIzNDU2Nzg5MDEyMzQ1Ng=="}}]' --outputs '[{"Key":"output.mp4","PresetId":"YourPresetIdHere"}]'
```

**Note**  
The transcoded output file that is generated from this example isn't encrypted\. If you want to create a job that generates an encrypted output, specify encryption parameters for the output instead of for \(or in addition to\) the input\.

You now have a pipeline set up to transcode the files that you encrypt with your KMS key\.