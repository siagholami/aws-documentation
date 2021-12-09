# Updating Your Private CA<a name="PCAUpdateCA"></a>

After creating a private CA, you can update its status or its revocation configuration\. 

## Updating CA Status<a name="PcaUpdateStatus"></a>

The status of a CA managed by ACM Private CA results from a user action or, in some cases, from a service action, such as when a CA expires\. The status options available to CA administrators vary depending on the current status of the CA\.

ACM Private CA can report the following status values: 
+ **`CREATING`** – ACM Private CA is creating your private certificate authority\.
+ **`PENDING_CERTIFICATE`** – The CA has been created and now needs a certificate to be operational\. You must use your ACM Private CA\-hosted or on\-premises root or subordinate CA to sign your private CA CSR and then import it into ACM Private CA\. For more information, see [Creating and Installing the Certificate for a Private CA](PCACertInstall.md)\.
+ **`ACTIVE`** – Your private CA is active and can be used to sign and issue certificates\.
+ **`DISABLED`** – A disabled CA cannot issue new certificates\. While disabled, the CA supports revocation for certificates issued previously, and it continues to generate certificate revocation lists \(CRLs\)\.
+ **`EXPIRED`** – If the CA certificate for your private CA expires, ACM Private CA sets the status to `EXPIRED`\.

  Considerations:
  + CA certificates are not automatically renewed by default\. For information about automating renewal through AWS Certificate Manager, see [Assign Certificate Renewal Permissions to ACM](granting-ca-access.md#PcaPermissions)\. 
  + An expired CA no longer generates CRLs\.
  + Audit reports continue to work for an expired CA\.
  + Your account continues to be billed for an expired CA\.
  + You cannot directly change the status of an expired CA\. If you import a new certificate for the CA, its status returns to its state before it expired, either ACTIVE or DISABLED\.
  + If you import a new CA certificate for your private CA, ACM Private CA resets the status to `ACTIVE` unless you set it to `DISABLED` after the CA certificate expired\.
  + If you attempt to issue a new certificate with an expired CA, the `IssueCertificate` API returns `InvalidStateException`\. An expired root CA must self\-sign a new root CA certificate before it can issue new subordinate certificates\.
  + `The ListCertificate Authorities` and `DescribeCertificateAuthority` APIs return a status of `EXPIRED` if the CA certificate is expired, regardless of whether the CA status is set to `ACTIVE` or `DISABLED`\. However, if the expired CA has been set to `DELETED`, the status returned is `DELETED`\.
  + The `UpdateCertificateAuthority` API cannot update the status of an expired CA\.
  + The `RevokeCertificate` API can be used to revoke any expired certificate, including a CA certificate\.
+ **`FAILED`** – The `CreateCertificateAuthority` action failed\. This can occur because of a network outage, back\-end AWS failure, or other errors\. 

  Considerations:
  + A failed CA cannot be recovered\. Delete the CA and create a new one\.
+ **`DELETED` **– Your private CA is within the restoration period\. which can have a length of seven to 30 days\. After this period, it is permanently deleted\.

  Considerations:
  + If you call the `RestoreCertificateAuthority` API on a CA with `DELETED` status and an expired certificate, the CA will be set to `EXPIRED`\.
  + For more information about deleting a CA, see [Deleting Your Private CA](PCADeleteCA.md)\.

**Note**  
For all status values except DELETED and FAILED, you are billed for the CA\.

The following diagram illustrates the CA lifecycle as an interaction of management actions with CA status\.

![\[Interaction of CA management actions and status.\]](http://docs.aws.amazon.com/acm-pca/latest/userguide/images/status.png)

At the top of the diagram, management actions are applied through the ACM Private CA console, CLI, or API\. The actions take the CA through creation, activation, expiration and renewal\. The CA status changes in response \(as shown by the solid lines\) to manual actions or automated updates\. In most cases, a new status leads to a new possible action \(shown by a dotted line\) that the CA administrator can apply\. The lower\-right inset shows the possible status values permitting delete and restore actions\.

**To update CA status using the AWS console**

1. Sign in to your AWS account and open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)\.

1. Choose **Private CAs**\.

1. Choose your private CA from the list\.

1. On the **Actions** menu, choose **Disable** to disable a private CA that's currently active or choose **Enable** to set a CA active\. 

**To update your private CA status using the AWS CLI**  
Use the [update\-certificate\-authority](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/update-certificate-authority.html) command\. You can use a file similar to the following to specify the CRL configuration\. 

```
{
  "CrlConfiguration": 
    {"Enabled": true,
     "ExpirationInDays": 7,
     "CustomCname": "https://www.somename.crl",
     "S3BucketName": "your-crl-bucket-name"}
}
```

The following command uses the preceding file to configure revocation and sets the status of the private CA to `ACTIVE`\. 

```
aws acm-pca update-certificate-authority \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-1232456789012 \
--revocation-configuration file://C:\revoke_config.txt \
--status "ACTIVE"
```

## Updating the CRL Configuration<a name="PcaUpdateCrlConfig"></a>

You can update the Certificate Revocation List \(CRL\) configuration for your private CA to change any of the following values:
+ Whether the private CA generates a certificate revocation list \(CRL\)
+ The number of days before a CRL expires\. Note that ACM Private CA begins trying to regenerate the CRL at ½ the number of days you specify\. 
+ The name of the Amazon S3 bucket where your CRL is saved\.
+ An alias to hide the name of your S3 bucket from public view\.

**Important**  
Changing any of the preceding parameters can have negative consequences\. For example, disabling CRL generation, changing the validity period, or changing the S3 bucket after you have placed your private CA in production could break existing certificates that depend on the CRL and the current CRL configuration\. Changing the alias can be done safely as long as the old alias remains linked to the correct bucket\. 

**To update the CRL configuration using the AWS console**

1. Sign in to your AWS account and open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)\.

1. Choose **Private CAs**\.

1. Choose your private CA from the list\.

1. On the **Actions** menu, choose **Update CA revocation**\.

1. Select **Enable CRL distribution** to generate certificate revocation lists \(CRLs\)\.

1. For **Create a new S3 bucket**, choose **Yes** and type a unique bucket name or choose **No** and choose an existing bucket from the list\. 

1. For **Custom CRL Name**, type an alias to hide your S3 bucket name from public view\.

1. For **Valid for**, type a validity period in days\.

1. Choose **Update**\.

## Add Tags to your Private Certificate Authority<a name="PcaCaTagging"></a>

Tags are words or phrases that act as metadata for identifying and organizing AWS resources\. Each tag consists of a **key** and a **value**\. You can use the ACM Private CA console, AWS Command Line Interface \(AWS CLI\), or the PCA API to add, view, or remove tags for private CAs\. 

You can create custom tags that suit your needs\. For example, you could tag private CAs with the key\-value pairs of `Environment=Prod` or `Environment=Beta` to identify which environment the CA is intended for\. You can add tags to a CA at creation or any time after\. For more information, see [Create a Private CA](PcaCreateCa.md)

Other AWS resources also support tagging\. You can assign the same tag to different resources to indicate whether those resources are related\. For example, you can assign a tag such as `Website=example.com` to your CA, the Elastic Load Balancing load balancer, and other related resources\. For more information on tagging AWS resources, see [Tagging your Amazon EC2 Resources](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html) in the [Amazon EC2 User Guide for Linux Instances](https://docs.aws.amazon.com/ec2/index.html#lang/en_us)\.

The following basic restrictions apply to ACM Private CA tags:
+ The maximum number of tags per private CA is 50\.
+ The maximum length of a tag key is 128 characters\.
+ The maximum length of a tag value is 256 characters\.
+ The tag key and value can contain the following characters: A\-Z, a\-z, and \.:\+=@\_%\-\(hyphen\)\.
+ Tag keys and values are case sensitive\.
+ The `aws:` and `rds:` prefixes are reserved for AWS use; you cannot add, edit, or delete tags whose key begins with `aws:` or `rds:`\. Default tags that begin with `aws:` and `rds:` do not count against your tags\-per\-resource quota\.
+ If you plan to use your tagging schema across multiple services and resources, remember that other services may have different restrictions for allowed characters\. Refer to the documentation for that service\. 
+ ACM Private CA tags are not available for use in the AWS Management Console's [Resource Groups and Tag Editor](https://aws.amazon.com/blogs/aws/resource-groups-and-tagging/)\. 

You can tag a private CA from the [ACM Private CA Console](https://console.aws.amazon.com/acm-pca), the [AWS Command Line Interface \(AWS CLI\)](https://aws.amazon.com/cli/), or the [ACM Private CA API](https://docs.aws.amazon.com/acm-pca/latest/APIReference/)\.

**To tag a private CA \(console\)**

1. Sign in to your AWS account and open the ACM Private CA console at [https://console\.aws\.amazon\.com/acm\-pca/home](https://console.aws.amazon.com/acm-pca/home)\.

1. Choose **Private CAs**\.

1. Choose your private CA from the list\.

1. Choose the **Tags** tab\.

1. Choose **Edit**\.

1. Type a key and value pair\.

1. Choose **Add Tag**\.

**To tag a private CA \(AWS CLI\)**  
Use the [tag\-certificate\-authority](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/tag-certificate-authority.html) command to add tags to your private CA\. 

```
aws acm-pca tag-certificate-authority \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
--tags Key=Admin,Value=Alice
```

Use the [list\-tags](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/list-tags.html) command to list the tags for a private CA\. 

```
aws acm-pca list-tags \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/123455678-1234-1234-1234-123456789012 \
--max-results 10
```

Use the [untag\-certificate\-authority](https://docs.aws.amazon.com/cli/latest/reference/acm-pca/untag-certificate-authority.html) command to remove tags from a private CA\. 

```
aws acm-pca untag-certificate-authority \
--certificate-authority-arn arn:aws:acm-pca:region:account:\
certificate-authority/12345678-1234-1234-1234-123456789012 \
--tags Key=Purpose,Value=Website
```