# Data protection in AWS ParallelCluster<a name="data-protection"></a>

AWS ParallelCluster conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use SSL/TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields such as a **Name** field\. This includes when you work with AWS ParallelCluster or other AWS services using the console, API, or AWS SDKs\. Any data that you enter into AWS ParallelCluster or other services might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS shared responsibility model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

## Data encryption<a name="security-data-encryption"></a>

A key feature of any secure service is that information is encrypted when it is not being actively used\.

### Encryption at rest<a name="security-data-encryption-at-rest"></a>

AWS ParallelCluster does not itself store any customer data other than the credentials it needs to interact with the AWS services on the user's behalf\.

For data on the nodes in the cluster, data can be encrypted at rest\. For Amazon EBS volumes, encryption is configured using the [`encrypted`](ebs-section.md#encrypted) and [`ebs_kms_key_id`](ebs-section.md#ebs-kms-key-id) settings in the [`[ebs]` section](ebs-section.md)\. For more information, see [Amazon EBS encryption](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSEncryption.html) in the Amazon EC2 User Guide for Linux Instances\. For Amazon EFS volumes, encryption is configured using the [`encrypted`](efs-section.md#efs-encrypted) and [`efs_kms_key_id`](efs-section.md#efs-efs-kms-key-id) settings in the [`[efs]` section](efs-section.md)\. For more information, see [How encryption at rest works](https://docs.aws.amazon.com/efs/latest/ug/encryption-at-rest.html#howencrypt) in the *Amazon Elastic File System User Guide\. *For Amazon FSx for Lustre file systems, encryption of data at rest is automatically enabled when creating an Amazon FSx file system\. For more information, see [Encrypting data at rest](https://docs.aws.amazon.com/fsx/latest/LustreGuide/encryption-at-rest.html) in the *Amazon FSx for Lustre User Guide*\.

For instance types with NVMe volumes, the data on NVMe instance store volumes is encrypted using an XTS\-AES\-256 cipher implemented on a hardware module on the instance\. The encryption keys are generated using the hardware module and are unique to each NVMe instance storage device\. All encryption keys are destroyed when the instance is stopped or terminated and cannot be recovered\. You cannot disable this encryption and you cannot provide your own encryption key\. For more information, see [Encryption at rest](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/data-protection.html#encryption-rest) in the *Amazon EC2 User Guide for Linux Instances*\.

If you use AWS ParallelCluster to invoke an AWS service that transmits customer data to your local computer for storage, then refer to the Security & Compliance chapter in that service's User Guide for information on how that data is stored, protected, and encrypted\.

### Encryption in transit<a name="security-data-encryption-in-transit"></a>

By default, all data transmitted from the client computer running AWS ParallelCluster and AWS service endpoints is encrypted by sending everything through a HTTPS/TLS connection\. Traffic between the nodes in the cluster can be automatically encrypted, depending on the instance types selected\. For more information, see [Encryption in transit](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/data-protection.html#encryption-transit) in the *Amazon EC2 User Guide for Linux Instances*\.

## See also<a name="security-data-protection-seealso"></a>
+ [Data protection in Amazon EC2](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/data-protection.html)
+ [Data protection in Amazon S3](https://docs.aws.amazon.com/AmazonS3/latest/dev/DataDurability.html)
+ [Data protection in Amazon FSx for Lustre](https://docs.aws.amazon.com/fsx/latest/LustreGuide/data-protection.html)