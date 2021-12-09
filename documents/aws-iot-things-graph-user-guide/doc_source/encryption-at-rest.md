--------

--------

# Encryption at Rest<a name="encryption-at-rest"></a>

In cloud deployments, AWS IoT Things Graph protects data at rest through server\-side encryption\. For more information, see [Data Encryption in AWS IoT in the *AWS IoT Developer Guide*\.](https://docs.aws.amazon.com/iot/latest/developerguide/data-encryption.html)

In AWS IoT Greengrass deployments, AWS IoT Things Graph uses the encryption features of AWS IoT Greengrass\. AWS IoT Greengrass stores data in the following locations:
+ The AWS Cloud – This includes information such as your group definitions\. This data is encrypted in the same way as other AWS IoT data in the cloud\. 
+ The AWS IoT Greengrass core device – This data isn't encrypted\. AWS IoT Greengrass relies on Unix file permissions and full\-disk encryption \(if enabled\) to protect data at rest on the core\. It's your responsibility to secure the file system and device\.

Additionally, when AWS IoT Things Graph installs a flow to your AWS IoT Greengrass core, it first uploads a file that contains all of the flow's dependencies to an Amazon S3 bucket\. AWS IoT Things Graph uploads this file by using the HTTPS protocol, so that it's secure in transit by default\. It's your responsibility to secure the Amazon S3 bucket\.