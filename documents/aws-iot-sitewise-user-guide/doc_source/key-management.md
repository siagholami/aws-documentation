# Key management<a name="key-management"></a>

AWS IoT SiteWise doesn't support customer\-managed encryption keys for data encrypted in the AWS Cloud\.

AWS IoT SiteWise gateways run on AWS IoT Greengrass, and AWS IoT Greengrass core devices use public and private keys to authenticate with the AWS Cloud and encrypt local secrets, such as OPC\-UA authentication secrets\. For more information, see [Key management](https://docs.aws.amazon.com/greengrass/latest/developerguide/key-management.html) in the *AWS IoT Greengrass Developer Guide*\.