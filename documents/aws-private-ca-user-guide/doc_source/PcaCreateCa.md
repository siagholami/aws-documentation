# Creating a Private CA and CRL<a name="PcaCreateCa"></a>

This section describes how you create a private certificate authority \(CA\) with an optional certificate revocation list \(CRL\) using ACM Private CA\. You can use these procedures to create both root CAs and subordinate CAs, resulting in an auditable hierarchy of trust relationships that matches your organizational needs\.

For information about using a CA to sign end\-entity certificates for your users, devices, and applications, see [Issuing a Private End\-Entity Certificate](PcaIssueCert.md)\.

**Note**  
Your account is charged a monthly price for each private CA starting from the time that you create it\.

**Topics**
+ [Access Policies for CRLs in Amazon S3](#s3-policies)
+ [CRL Structure](#crl-structure)
+ [Procedures for Creating a CA](#CA-procedures)

## Access Policies for CRLs in Amazon S3<a name="s3-policies"></a>

If you plan to create a CRL, you need to prepare an Amazon S3 bucket to store it in\. ACM Private CA automatically deposits the CRL in the Amazon S3 bucket you designate and updates it periodically\. For more information, see [How Do I Create an S3 bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/create-bucket.html) 

Your S3 bucket must be secured by an attached permissions policy\. The policy protects the contents of the bucket from being accessed by unauthorized users or service principals\. During the console procedure for creating a CA, you can let ACM Private CA create a new bucket and apply a policy automatically, or you can use a bucket that you have previously set up yourself\. In that case, or when you create a CA using the AWS CLI, you must attach a policy manually\. For more information, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)

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

## CRL Structure<a name="crl-structure"></a>

Each CRL is a DER encoded file\. To download the file and use OpenSSL to view it, use a command like to the following:

```
openssl crl -inform DER -in path-to-crl-file -text -noout
```

CRLs have the following format:

```
Certificate Revocation List (CRL):
	        Version 2 (0x1)
	    Signature Algorithm: sha256WithRSAEncryption
	        Issuer: /C=US/ST=WA/L=Seattle/O=Example Company CA/OU=Corporate/CN=www.example.com
	        Last Update: Feb 26 19:28:25 2018 GMT
	        Next Update: Feb 26 20:28:25 2019 GMT
	        CRL extensions:
	            X509v3 Authority Key Identifier:
	                keyid:AA:6E:C1:8A:EC:2F:8F:21:BC:BE:80:3D:C5:65:93:79:99:E7:71:65
	
	            X509v3 CRL Number:
	                1519676905984
	Revoked Certificates:
	    Serial Number: E8CBD2BEDB122329F97706BCFEC990F8
	        Revocation Date: Feb 26 20:00:36 2018 GMT
	        CRL entry extensions:
	            X509v3 CRL Reason Code:
	                Key Compromise
	    Serial Number: F7D7A3FD88B82C6776483467BBF0B38C
	        Revocation Date: Jan 30 21:21:31 2018 GMT
	        CRL entry extensions:
	            X509v3 CRL Reason Code:
	                Key Compromise
	    Signature Algorithm: sha256WithRSAEncryption
	         82:9a:40:76:86:a5:f5:4e:1e:43:e2:ea:83:ac:89:07:49:bf:
	         c2:fd:45:7d:15:d0:76:fe:64:ce:7b:3d:bb:4c:a0:6c:4b:4f:
	         9e:1d:27:f8:69:5e:d1:93:5b:95:da:78:50:6d:a8:59:bb:6f:
	         49:9b:04:fa:38:f2:fc:4c:0d:97:ac:02:51:26:7d:3e:fe:a6:
	         c6:83:34:b4:84:0b:5d:b1:c4:25:2f:66:0a:2e:30:f6:52:88:
	         e8:d2:05:78:84:09:01:e8:9d:c2:9e:b5:83:bd:8a:3a:e4:94:
	         62:ed:92:e0:be:ea:d2:59:5b:c7:c3:61:35:dc:a9:98:9d:80:
	         1c:2a:f7:23:9b:fe:ad:6f:16:7e:22:09:9a:79:8f:44:69:89:
	         2a:78:ae:92:a4:32:46:8d:76:ee:68:25:63:5c:bd:41:a5:5a:
	         57:18:d7:71:35:85:5c:cd:20:28:c6:d5:59:88:47:c9:36:44:
	         53:55:28:4d:6b:f8:6a:00:eb:b4:62:de:15:56:c8:9c:45:d7:
	         83:83:07:21:84:b4:eb:0b:23:f2:61:dd:95:03:02:df:0d:0f:
	         97:32:e0:9d:38:de:7c:15:e4:36:66:7a:18:da:ce:a3:34:94:
	         58:a6:5d:5c:04:90:35:f1:8b:55:a9:3c:dd:72:a2:d7:5f:73:
	         5a:2c:88:85
```

**Note**  
The CRL will only be deposited in Amazon S3 once a certificate has been issued that refers to it\. Prior to that, there will only be an `acm-pca-permission-test-key` file visible in the Amazon S3 bucket\.

## Procedures for Creating a CA<a name="CA-procedures"></a>

You can create a CA using the AWS console, the ACM Private CA portion of the AWS CLI, or AWS CloudFormation\.

**To create a private CA using the AWS console**

1. Sign in to your AWS account and open the ACM Private CA console at **[https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)**\. The introductory page will appear if your console opens to a region in which you do not have a CA\. Choose **Get started** beneath **Private certificate authority**\. Choose **Get started** again\. If the console opens to a region in which you already have one or more CAs, the introductory page will not be shown\. Choose **Private CAs** and then choose **Create CA**\. 

1. <a name="PcaCreateCaType"></a>On the **Select the certificate authority \(CA\) type** page, select the type of the private certificate authority that you want to create\. 
   + Choosing **Root CA** establishes a new CA hierarchy\. This CA is backed by a self\-signed certificate\. It serves as the ultimate signing authority for other CAs and end\-entity certificates in the hierarchy\.
   + Choosing **Subordinate CA** creates a CA that must be signed by a parent CA above it in the hierarchy\. Subordinate CAs are typically be used to create other subordinate CAs or to issue end\-entity certificates to users, computers, and applications\. 

   After selecting a CA type, choose **Next**\.

1. <a name="PcaCreateCaName"></a>On the **Configure the certificate authority \(CA\) subject name**, configure the subject name of your private CA\. You must enter at least one of the following values:
   + **Organization \(O\)**
   + **Organization Unit \(OU\)**
   + **Country name \(C\)**
   + **State or province name**
   + **Locality name**
   + **Common Name \(CN\)**

   Because the backing certificate is self\-signed, the subject information you provide for a private CA is probably sparser than what a public CA would contain\. For more information about each of the values that make up a subject distinguished name, see [X\.500 Distinguished Name](PcaTerms.md#terms-x500dn)\.

    When done, choose **Next**\.

1. <a name="PcaCreateKeyAlg"></a>On the **Configure the certificate authority \(CA\) key type** page, select the key algorithm and the bit\-size of the key\. The default value is an RSA algorithm with a 2048\-bit key length\. If you expand the **Advanced** options, you can select from the following algorithms: 
   + RSA 2048
   + RSA 4096
   + ECDSA P256
   + ECDSA P384

   Make a selection and then choose **Next**\. 

1. <a name="PcaCreateCRL"></a>On the **Configure certificate revocation** page, you have the option of creating a certificate revocation list \(CRL\) managed by ACM Private CA\. Clients such as web browsers query CRLs to determine whether an end\-entity or subordinate CA certificate can be trusted\. For more information, see [Revoking a Private Certificate](PcaRevokeCert.md)\. 

   When you have associated a CRL with a CA, ACM Private CA includes the CRL Distribution Points extension in certificates issued by the CA\. This extension provides the URL to the CRL so that client devices can check certificate revocation status\.

   To create a CRL, complete the following steps: 

   1. Choose **Enable CRL distribution**\.

   1. To create a new Amazon S3 bucket for your CRL entries, choose **Yes** for the **Create a new S3 bucket** option and type a unique bucket name\. \(You do not need to include the path to the bucket\.\) Otherwise, choose **No** and select an existing bucket from the list\. 

      If you choose **Yes**, ACM Private CA creates and attaches the necessary policy to your bucket\. If you choose **No**, you must attach a policy to your bucket before you can begin generating CRLs\. Use one of the policy patterns described in [Access Policies for CRLs in Amazon S3 ](#s3-policies)\. For information about attaching a policy, see [How Do I Add an S3 Bucket Policy?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/add-bucket-policy.html)
**Note**  
Your private CA may fail to create a CRL bucket if Amazon S3 **block public access** settings are enforced on your account\. Check your Amazon S3 settings if this occurs\. For more information, see [Using Amazon S3 Block Public Access](Amazon Simple Storage Service Developer Guideaccess-control-block-public-access.html)\.

   1. Expand **Advanced** for additional configuration options\.
      + Add a **Custom CRL Name** to create an alias for your Amazon S3 bucket\. This name is contained in certificates issued by the CA in the “CRL Distribution Points" extension that is defined by RFC 5280\.
      + Type the number of days your CRL will remain valid\. The default value is 7 days\. For online CRLs, a validity period of two to seven days is common\. ACM Private CA tries to regenerate the CRL at the midpoint of the specified period\. 

   Choose **Next**\.

1. On the **Add tags** page, you can optionally tag your CA\. Tags are key/value pairs that serve as metadata for identifying and organizing AWS resources\. For a list of ACM Private CA tag parameters and for instructions on how to add tags to CAs after creation, see [Add Tags to your Private Certificate Authority](PCAUpdateCA.md#PcaCaTagging)\.

   Choose **Next**\.

1. <a name="configure-acm-renewal"></a>**Configure CA permissions**

   Optionally delegate automatic renewal permissions to the ACM service principal\. ACM can only automatically renew private end\-entity certificates generated by this CA if this permission is granted\. You can assign renewal permissions at any time with the ACM Private CA [CreatePermission](https://docs.aws.amazon.com/acm-pca/latest/APIReference/API_CreatePermission.html) API or [create\-permission](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/create-permission.html) CLI command\.

   The default is to enable these permissions\.

   Choose **Next**\.

1. On the **Review and create** page, confirm that your configuration is correct, check the box to acknowledge pricing information, and choose **Confirm and create**\. 

   If you want to continue on to creating and installing a CA certificate, choose **Get started** in the **Success** dialog box and follow the instructions at [Creating and Installing the Certificate for a Private CA](PCACertInstall.md)\. Otherwise choose **You can also finish this later**, which takes you to a list of your **Private CAs**\. 

**To create a private CA using the AWS CLI**  
Use the [create\-certificate\-authority](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/create-certificate-authority.html) command to create a private CA\. You must specify the CA configuration, the revocation configuration if you plan to use a CRL, and the CA type\. This information is contained in two files that you supply as arguments to the command\. Optionally, you can also supply tags and an idempotency token\.

If you are configuring a CRL, you must have a secured Amazon S3 bucket in place *before* you issue the create\-certificate\-authority command\. For more information, see [Access Policies for CRLs in Amazon S3 ](#s3-policies)\.

The CA configuration file specifies the following information:
+ The name of the algorithm
+ The key size to be used to create the CA private key
+ The type of signing algorithm that the CA uses to sign
+ X\.500 subject information

The CRL configuration file specifies the following information:
+ The CRL expiration period in days \(the validity period of the CRL\)
+ The Amazon S3 bucket that will contain the CRL 
+ A CNAME alias for the S3 bucket that is included in certificates issued by the CA

Modify as needed the see example files to use with the command\.

**File: C:\\ca\_config\.txt**

```
{
   "KeyAlgorithm":"RSA_2048",
   "SigningAlgorithm":"SHA256WITHRSA",
   "Subject":{
      "Country":"US",
      "Organization":"Example Corp",
      "OrganizationalUnit":"Sales",
      "State":"WA",
      "Locality":"Seattle",
      "CommonName":"www.example.com"
   }
}
```

**File: C:\\revoke\_config\.txt**

```
{
   "CrlConfiguration":{
      "Enabled":true,
      "ExpirationInDays":7,
      "CustomCname":"some_name.crl",
      "S3BucketName":"your-bucket-name"
   }
}
```

**Command:**

```
aws acm-pca create-certificate-authority \
	--certificate-authority-configuration file://C:\ca_config.txt \
	--revocation-configuration file://C:\revoke_config.txt \
	--certificate-authority-type "ROOT" \
	--idempotency-token 98256344 \
	--tags  Key=Name,Value=MyPCA
```

If successful, this command outputs the ARN \(Amazon Resource Name\) of the CA\.

```
{
	"CertificateAuthorityArn":"arn:aws:acm-pca:region:account:
       certificate-authority/12345678-1234-1234-123456789012"
}
```

**To create a private CA using AWS CloudFormation**  
For information about creating a private CA using AWS CloudFormation, see [ACM PCA Resource Type Reference](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/AWS_ACMPCA.html) in the *AWS CloudFormation User Guide*\.

### Encrypting Your CRLs<a name="crl-encryption"></a>

You can optionally configure encryption on the Amazon S3 bucket containing your CRLs\. ACM Private CA supports two encryption modes for assets in S3:
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