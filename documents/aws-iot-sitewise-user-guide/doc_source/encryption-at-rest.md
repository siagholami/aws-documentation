# Encryption at rest<a name="encryption-at-rest"></a>

AWS IoT SiteWise stores your data in the AWS Cloud and on gateways\.

## Data at rest in the AWS Cloud<a name="cloud-encryption-at-rest"></a>

AWS IoT SiteWise stores data in other AWS services that encrypt data at rest by default\.

## Data at rest on gateways<a name="gateway-encryption-at-rest"></a>

AWS IoT SiteWise gateways store the following data on the local file system:
+ OPC\-UA source configuration information
+ The set of OPC\-UA data stream paths from connected OPC\-UA sources
+ Industrial data cached when the gateway loses connection to the internet

AWS IoT SiteWise gateways run on AWS IoT Greengrass\. AWS IoT Greengrass relies on Unix file permissions and full\-disk encryption \(if enabled\) to protect data at rest on the core\. It's your responsiblity to secure the file system and device\.

However, AWS IoT Greengrass does encrypt local copies of your OPC\-UA server secrets retrieved from Secrets Manager\. For more information, see [Secrets encryption](https://docs.aws.amazon.com/greengrass/latest/developerguide/secrets.html#secrets-encryption) in the *AWS IoT Greengrass Developer Guide*\.

For more information about encryption at rest on AWS IoT Greengrass cores, see [Encryption at rest](https://docs.aws.amazon.com/greengrass/latest/developerguide/encryption-at-rest.html) in the *AWS IoT Greengrass Developer Guide*\.