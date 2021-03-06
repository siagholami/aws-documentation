# Data Protection in Amazon AppStream 2\.0<a name="data-protection"></a>

Amazon AppStream 2\.0 conforms to the AWS [shared responsibility model](http://aws.amazon.com/compliance/shared-responsibility-model/), which includes regulations and guidelines for data protection\. AWS is responsible for protecting the global infrastructure that runs all the AWS services\. AWS maintains control over data hosted on this infrastructure, including the security configuration controls for handling customer content and personal data\. AWS customers and APN partners, acting either as data controllers or data processors, are responsible for any personal data that they put in the AWS Cloud\. 

For data protection purposes, we recommend that you protect AWS account credentials and set up individual user accounts with AWS Identity and Access Management \(IAM\), so that each user is given only the permissions necessary to fulfill their job duties\. We also recommend that you secure your data in the following ways:
+ Use multi\-factor authentication \(MFA\) with each account\.
+ Use TLS to communicate with AWS resources\.
+ Set up API and user activity logging with AWS CloudTrail\.
+ Use AWS encryption solutions, along with all default security controls within AWS services\.
+ Use advanced managed security services such as Amazon Macie, which assists in discovering and securing personal data that is stored in Amazon S3\.

We strongly recommend that you never put sensitive identifying information, such as your customers' account numbers, into free\-form fields or metadata, such as function names and tags\. Any data that you enter into metadata might get picked up for inclusion in diagnostic logs\. When you provide a URL to an external server, don't include credentials information in the URL to validate your request to that server\.

For more information about data protection, see the [AWS Shared Responsibility Model and GDPR](http://aws.amazon.com/blogs/security/the-aws-shared-responsibility-model-and-gdpr/) blog post on the *AWS Security Blog*\.

## Encryption at Rest<a name="encryption-rest"></a>

AppStream 2\.0 fleet instances are ephemeral in nature\. After a user's streaming session is finished, the underlying instance and its associated Amazon Elastic Block Store \(Amazon EBS\) volume are terminated\. In addition, AppStream 2\.0 periodically recycles unused instances for freshness\.

When you enable [application settings persistence](how-it-works-app-settings-persistence.md) or [home folders](home-folders.md#home-folders-admin) for your users, the data that is generated by your users and stored in Amazon Simple Storage Service buckets is encrypted at rest\. AWS Key Management Service is a service that combines secure, highly available hardware and software to provide a key management system scaled for the cloud\. Amazon S3 uses [AWS Managed CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) to encrypt your Amazon S3 object data\.

## Encryption in Transit<a name="encryption-transit"></a>

The following table provides information about how data is encrypted in transit\. Where applicable, other data protection methods for AppStream 2\.0 are also listed\.


| Data | Network path | How protected | 
| --- | --- | --- | 
|  Web assets This traffic includes assets such as images and JavaScript files\.  |  Between AppStream 2\.0 users and AppStream 2\.0  | Encrypted using TLS 1\.2 | 
| Pixel and related streaming traffic | Between AppStream 2\.0 users and AppStream 2\.0 |  Encrypted using 256\-bit Advanced Encryption Standard \(AES\-256\) Transported using TLS 1\.2  | 
| API traffic | Between AppStream 2\.0 users and AppStream 2\.0 |  Encrypted using TLS 1\.2 Requests to create a connection are signed using SigV4  | 
| Application settings and home folder data generated by users Applicable when application settings persistence and home folders are enabled\.  | Between AppStream 2\.0 users and Amazon S3 | Encrypted using Amazon S3 SSL endpoints | 
| AppStream 2\.0\-managed traffic |  Between AppStream 2\.0 streaming instances and: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/appstream2/latest/developerguide/data-protection.html)  | Encrypted using TLS 1\.2 Requests to create a connection are signed using SigV4 where applicable | 

## Administrator Controls<a name="administrator-controls"></a>

AppStream 2\.0 provides administrative controls that you can use to limit the ways in which users can transfer data between their local computer and an AppStream 2\.0 fleet instance\. You can limit or disable the following when you [create or update an AppStream 2\.0 stack](set-up-stacks-fleets.md#set-up-stacks-fleets-install):
+ Clipboard/copy and paste actions
+ File upload and download, including folder and drive redirection
+ Printing

When you create an AppStream 2\.0 image, you can specify which USB devices are available to redirect to AppStream 2\.0 fleet instances from the AppStream 2\.0 client for Windows\. The USB devices that you specify will be available for use during users??? AppStream 2\.0 streaming sessions\. For more information, see [Qualify USB Devices for Use with Streaming Applications](qualify-usb-devices.md)\.

## Application Access<a name="application-access"></a>

By default, AppStream 2\.0 enables the applications that you specify in your image to launch other applications and executable files on the image builder and fleet instance\. This ensures that applications with dependencies on other applications \(for example, an application that launches the browser to navigate to a product website\) function as expected\. Make sure that you configure your administrative controls, security groups, and other security software to grant users the minimum permissions required to access resources and transfer data between their local computers and fleet instances\.

You can use application control software, such as [Microsoft AppLocker](https://docs.microsoft.com/en-us/windows/security/threat-protection/windows-defender-application-control/applocker/applocker-overview), and policies to control which applications and files your users can run\. Application control software and policies help you control the executable files, scripts, Windows installer files, dynamic\-link libraries, and application packages that your users can run on AppStream 2\.0 image builders and fleet instances\.

**Note**  
The AppStream 2\.0 agent software relies on the Windows command prompt and Windows Powershell to provision streaming instances\. If you choose to prevent users from launching the Windows command prompt or Windows Powershell, the policies must not apply to the Windows NT AUTHORITY\\SYSTEM or users in the Administrators group\.


| Rule type | Action | Windows user or group | Name/Path | Condition | Description | 
| --- | --- | --- | --- | --- | --- | 
| Executable | Allow | NT AUTHORITY\\System | \* | Path | Required for the AppStream 2\.0 agent software | 
| Executable | Allow | BUILTIN\\Administrators | \* | Path | Required for the AppStream 2\.0 agent software | 
| Executable | Allow | Everyone | %PROGRAMFILES%\\nodejs\\\* | Path | Required for the AppStream 2\.0 agent software | 
| Executable | Allow | Everyone | %PROGRAMFILES%\\NICE\\\* | Path | Required for the AppStream 2\.0 agent software | 
| Executable | Allow | Everyone | %PROGRAMFILES%\\Amazon\\\* | Path | Required for the AppStream 2\.0 agent software | 
| Executable | Allow | Everyone | %PROGRAMFILES%\\<default\-browser>\\\* | Path | Required for the AppStream 2\.0 agent software when persistent storage solutions, such as Google Drive or Microsoft OneDrive for Business, are used\. This exception is not required when AppStream 2\.0 home folders are used\. | 