# Using Audit Reports with Your Private CA<a name="PcaAuditReport"></a>

You can create an audit report to list all of the certificates that your private CA has issued or revoked\. The report is saved in a new or existing S3 bucket that you specify on input\. 

For information about adding encryption protection to your audit reports, see [Encrypting Your Audit Reports ](#audit-report-encryption)\.

The audit report file has the following path and file name\. The ARN for an Amazon S3 bucket is the value for `bucket-name`\. `CA_ID` is the unique identifier of an issuing CA\. `UUID` is the unique identifier of an audit report\. 

```
bucket-name/audit-report/CA-ID/UUID.[json|csv]
```

You can generate a new report every 30 minutes and download it from your bucket\. The following example shows a CSV\-separated report\.

```
awsAccountId,requestedByServicePrincipal,certificateArn,serial,subject,notBefore,notAfter,issuedAt,revokedAt,revocationReason,templateArn
123456789012,,arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/fedcba9876543210fedcba9876543210,00:11:22:33:44:55:66:77:88:99:aa:bb:cc:dd:ee:ff,"2.5.4.5=#012345678901,2.5.4.44=#0a1b3c4d,2.5.4.65=#0a1b3c4e5f6a,2.5.4.43=#0a1b3c4d5e,2.5.4.42=#0123456789abcdef0123456789abcdef0123,2.5.4.4=#0123456789abcdef01234567,2.5.4.12=#0a1b3c4d5e,2.5.4.46=#0123456789ab,CN=www.example1.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",2020-03-02T21:43:57+0000,2020-04-07T22:43:57+0000,2020-03-02T22:43:58+0000,,UNSPECIFIED,arn:aws:acm-pca:::template/EndEntityCertificate/V1
123456789012,acm.amazonaws.com,arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/0123456789abcdef0123456789abcdef,ff:ee:dd:cc:bb:aa:99:88:77:66:55:44:33:22:11:00,"2.5.4.5=#012345678901,2.5.4.44=#0a1b3c4d,2.5.4.65=#0a1b3c4d5e6f,2.5.4.43=#0a1b3c4d5e,2.5.4.42=#0123456789abcdef0123456789abcdef0123,2.5.4.4=#0123456789abcdef01234567,2.5.4.12=#0a1b3c4d5e,2.5.4.46=#0123456789ab,CN=www.example1.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",2020-03-02T20:53:39+0000,2020-04-07T21:53:39+0000,2020-03-02T21:53:40+0000,,,arn:aws:acm-pca:::template/EndEntityCertificate/V1
```

The following example shows a JSON\-formatted report\. 

```
[
   {
      "awsAccountId":"123456789012",
      "certificateArn":"arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/fedcba9876543210fedcba9876543210",
      "serial":"00:11:22:33:44:55:66:77:88:99:aa:bb:cc:dd:ee:ff",
      "subject":"2.5.4.5=#012345678901,2.5.4.44=#0a1b3c4d,2.5.4.65=#0a1b3c4d5e6f,2.5.4.43=#0a1b3c4d5e,2.5.4.42=#0123456789abcdef0123456789abcdef0123,2.5.4.4=#0123456789abcdef01234567,2.5.4.12=#0a1b3c4d5e,2.5.4.46=#0123456789ab,CN=www.example1.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",
      "notBefore":"2020-02-26T18:39:57+0000",
      "notAfter":"2021-02-26T19:39:57+0000",
      "issuedAt":"2020-02-26T19:39:58+0000",
      "revokedAt":"2020-02-26T20:00:36+0000",
      "revocationReason":"UNSPECIFIED",
      "templateArn":"arn:aws:acm-pca:::template/EndEntityCertificate/V1"
   },
   {
      "awsAccountId":"123456789012",
      "requestedByServicePrincipal":"acm.amazonaws.com",
      "certificateArn":"arn:aws:acm-pca:region:account:certificate-authority/CA_ID/certificate/0123456789abcdef0123456789abcdef",
      "serial":"ff:ee:dd:cc:bb:aa:99:88:77:66:55:44:33:22:11:00",
      "subject":"2.5.4.5=#012345678901,2.5.4.44=#0a1b3c4d,2.5.4.65=#0a1b3c4d5e6f,2.5.4.43=#0a1b3c4d5e,2.5.4.42=#0123456789abcdef0123456789abcdef0123,2.5.4.4=#0123456789abcdef01234567,2.5.4.12=#0a1b3c4d5e,2.5.4.46=#0123456789ab,CN=www.example1.com,OU=Sales,O=Example Company,L=Seattle,ST=Washington,C=US",
      "notBefore":"2020-01-22T20:10:49+0000",
      "notAfter":"2021-01-17T21:10:49+0000",
      "issuedAt":"2020-01-22T21:10:49+0000",
      "templateArn":"arn:aws:acm-pca:::template/EndEntityCertificate/V1"
   }
]
```

## Preparing an Amazon S3 Bucket for Audit Reports<a name="s3-access"></a>

To store your audit reports, you need to prepare an Amazon S3 bucket\. For more information, see [How Do I Create an S3 bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) 

Your S3 bucket must be secured by an attached permissions policy\. The policy protects the contents of the bucket from being accessed by unauthorized users or service principals\. If you create a new S3 bucket through the ACM Private CA console, a policy \(**Policy 2** below\) is attached to the bucket automatically\. If you use an existing bucket, or if you use the AWS CLI to create the audit report, you must attach a policy manually\. For more information, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)

We offer two example policies for securing Amazon S3 buckets\.
<a name="policy1"></a>
**Policy 1 \(Restrictive\)**  
This policy grants restricted permissions on the S3 bucket to the ACM Private CA service principal\. This example restricts by both AWS account and by the ARN of a private CA, but it could also be configured to restrict just one or the other\. The `Put` permission allows ACM Private CA to place objects in the bucket\. The `Get` permission allows objects in the bucket to be retrieved\. 

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Principal":{
            "Service":"acm-pca.amazonaws.com"
         },
         "Action":[
            "s3:PutObject",
            "s3:PutObjectAcl",
            "s3:GetBucketAcl",
            "s3:GetBucketLocation"
         ],
         "Resource":[
            "arn:aws:s3:::bucket-name/*",
            "arn:aws:s3:::bucket-name"
         ],
         "Condition":{
            "StringEquals":{
               "aws:SourceAccount":"account",
               "aws:SourceArn":"arn:partition:acm-pca:region:account:certificate-authority/11111111-2222-3333-4444-555555555555"
            }
         }
      }
   ]
}
```
<a name="policy2"></a>
**Policy 2 \(Permissive\)**  
This policy grants `Put` and `Get` permissions on the S3 bucket to the ACM Private CA service principal without restricting access by CA or user\. The `Put` permission allows ACM Private CA to place objects in the bucket\. The `Get` permission allows objects in the bucket to be retrieved\. A permissive policy is appropriate if you want the bucket to be available for multiple CAs or multiple users\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Principal":{
            "Service":"acm-pca.amazonaws.com"
         },
         "Action":[
            "s3:PutObject",
            "s3:PutObjectAcl",
            "s3:GetBucketAcl",
            "s3:GetBucketLocation"
         ],
         "Resource":[
            "arn:aws:s3:::bucket-name/*",
            "arn:aws:s3:::bucket-name"
         ]
      }
   ]
}
```

## Creating an Audit Report<a name="create-the-report"></a>

You can create an audit report from either the console or the AWS CLI\.

**To create an audit report \(console\)**

1. Sign in to your AWS account and open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)\.

1. Choose **Private CAs**\.

1. Choose your private CA from the list\.

1. From the **Actions** menu, choose **Generate audit report**\.

1. For **Create a new S3 bucket**, choose **Yes** and type a unique bucket name or choose **No** and choose an existing bucket from the list\. 

   If you choose **Yes**, ACM Private CA creates and attaches the necessary policy to your bucket\. If you choose **No**, you must attach a policy to your bucket before you can generate an audit report\. Use one of the policy patterns described in [Preparing an Amazon S3 Bucket for Audit Reports](#s3-access)\. For information about attaching a policy, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)

1. For **Output format**, choose **JSON** for JavaScript Object Notation or **CSV** for comma\-separated values\. 

1. Choose **Generate audit report**\.

**To create an audit report \(AWS CLI\)**

1. If you do not already have an S3 bucket to use, [create one](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html)\.

1. Attach a policy to your bucket\. Use one of the policy patterns described in [Preparing an Amazon S3 Bucket for Audit Reports](#s3-access)\. For information about attaching a policy, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)

1. Use the `[create\-certificate\-authority\-audit\-report](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/create-certificate-authority-audit-report.html)` command to create the audit report and to place it in the prepared S3 bucket\.

   ```
   $ aws acm-pca create-certificate-authority-audit-report \
   --certificate-authority-arn arn:aws:acm-pca:region:account:\
   certificate-authority/12345678-1234-1234-1234-123456789012 \
   --s3-bucket-name bucket-name \
   --audit-report-response-format JSON
   ```

## Encrypting Your Audit Reports<a name="audit-report-encryption"></a>

You can optionally configure encryption on the Amazon S3 bucket containing your audit reports\. ACM Private CA supports two encryption modes for assets in S3:
+ Automatic server\-side encryption with Amazon S3\-managed AES\-256 keys\.
+ Customer\-managed encryption using AWS Key Management Service and customer master keys \(CMKs\) configured to your specifications\.

**Note**  
ACM Private CA does not support using default CMKs generated automatically by S3\.

The following procedures describe how to set up each of the encryption options\.

**To configure automatic encryption**  
Complete the following steps to enable S3 server\-side encryption\.

1. Open the Amazon S3 console at [https://console\.aws\.amazon\.com/s3/](https://console.aws.amazon.com/s3/)\.

1. In the **Buckets** table, choose the bucket that will hold your ACM Private CA assets\.

1. On the page for your bucket, choose the **Properties** tab\.

1. Choose the **Default encryption** card\.

1. Choose **AES\-256**\.

1. Optionally view the bucket permissions policy, then choose **Save**\.

**To configure custom encryption**  
Complete the following steps to enable encryption using a custom CMK\.

1. \(Optional\) If you do not have an AWS KMS CMK already, create one using the following AWS CLI [create\-key](https://docs.aws.amazon.com/cli/latest/reference/kms/create-key.html) command:

   ```
   aws kms create-key
   ```

   The output contains the key ID and Amazon Resource Name \(ARN\) of the CMK\. The following is example output:

   ```
   {
       "KeyMetadata": {
           "KeyId": "6f815f63-e628-448c-8251-e40cb0d29f59",
           "Description": "",
           "Enabled": true,
           "KeyUsage": "ENCRYPT_DECRYPT",
           "KeyState": "Enabled",
           "CreationDate": 1478910250.94,
           "Arn": "arn:aws:kms:us-west-2:123456789012:key/6f815f63-e628-448c-8251-e40cb0d29f59",
           "AWSAccountId": "123456789012"
       }
   }
   ```

1. Using the following steps, you give the ACM Private CA service principal permission to use the CMK\. By default, all AWS KMS CMKs are private; only the resource owner can use a CMK to encrypt and decrypt data\. However, the resource owner can grant permissions to access the CMK to other users and resources\. The service principal must be in the same region as where the CMK is stored\.

   1. First, save the default policy for your CMK as `policy.json` using the following [get\-key\-policy](https://docs.aws.amazon.com/cli/latest/reference/kms/get-key-policy.html) command:

      ```
      aws kms get-key-policy --key-id key-id --policy-name default --output text > ./policy.json
      ```

   1. Open the `policy.json` file in a text editor and add the following statement:

      ```
      {
         "Sid":"Allow ACM-PCA use of the key",
         "Effect":"Allow",
         "Principal":{
            "Service":"acm-pca.amazonaws.com"
         },
         "Action":[
            "kms:GenerateDataKey",
            "kms:Decrypt"
         ],
         "Resource":"*",
         "Condition":{
            "StringLike":{
               "kms:EncryptionContext:aws:s3:arn":[
                  "arn:aws:s3:::bucket_name/acm-pca-permission-test-key",
                  "arn:aws:s3:::bucket_name/acm-pca-permission-test-key-private",
                  "arn:aws:s3:::bucket_name/audit-report/*",
                  "arn:aws:s3:::bucket_name/crl/*"
               ]
            }
         }
      }
      ```

   1. Finally, add the updated policy using the following [put\-key\-policy](https://docs.aws.amazon.com/cli/latest/reference/kms/put-key-policy.html) command:

      ```
      aws kms put-key-policy --key-id key-id --policy-name default --policy file://policy.json
      ```