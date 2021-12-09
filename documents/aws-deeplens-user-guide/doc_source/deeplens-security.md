# AWS DeepLens Security<a name="deeplens-security"></a>

**Topics**
+ [Data Protection](#deeplens-security-data-protection)
+ [Authentication and Access Control](#deeplens-security-access-control)
+ [Incident Response](#deeplens-security-incident-response)
+ [Update Management](#deeplens-security-update-management)

## Data Protection<a name="deeplens-security-data-protection"></a>

 AWS DeepLens does not collect data from the device\. Video frames from the camera and inference results are confined to the device locally\. As a user, you control how and where to publish inference results to other AWS services in the project's Lambda function\. Your account remains the sole ownership of the affected data regardless which service it is published to\. 

 The AWS DeepLens supports hardware\-level full\-disk encryption for the data storage on device\. The data encryption does not require any user intervention or configuration\. 

 For the purpose of device registration and maintenance, communications between your AWS DeepLens device and you computer requires HTTPS connection, except for connecting to the device softAP endpoint in the device setup mode that requires authentication with password\. The default password is printed at the bottom of the AWS DeepLens device\. 

 For on\-device disk encryption, keys are stored in a hardware component known as Trusted Platform Module \(TPM\)\. When the disk is removed from the device, data becomes inaccessible\. 

## Authentication and Access Control<a name="deeplens-security-access-control"></a>

See [Set Up Required Permissions ](deeplens-required-iam-roles.md)\.

## Incident Response<a name="deeplens-security-incident-response"></a>

 To detect device software issues, check the [logs on the device](deeplens-logging.md#deeplens-logging-fs) or the [CloudWatch Logs for AWS DeepLens](deeplens-logging.md#deeplens-logging-cwl)\.

## Update Management<a name="deeplens-security-update-management"></a>

 AWS DeepLens makes available device software updates\. As a user, you decide whether or not to install the updates to the device\. You can do so in the AWS DeepLens console\. For a security patch, you'll be forced to install the patch\. 

 AWS DeepLens provides device software updates, periodically, as software patches or new features\. You can choose to re\-flash the image\. 