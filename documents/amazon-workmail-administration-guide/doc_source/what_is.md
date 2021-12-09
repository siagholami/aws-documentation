# What is Amazon WorkMail?<a name="what_is"></a>

Amazon WorkMail is a secure, managed business email and calendaring service with support for existing desktop and mobile email clients\. Amazon WorkMail users can access their email, contacts, and calendars using Microsoft Outlook, their browser, or their native iOS and Android email applications\. You can integrate Amazon WorkMail with your existing corporate directory and control both the keys that encrypt your data and the location in which your data is stored\.

For a list of supported AWS Regions and endpoints, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#wm_region)\.

**Topics**
+ [Amazon WorkMail system requirements](#accessing_workmail)
+ [Amazon WorkMail concepts](#workmail_concepts)
+ [Related AWS services](#related_services)
+ [Amazon WorkMail pricing](#workmail_pricing)
+ [Amazon WorkMail resources](#RelatedResources)

## Amazon WorkMail system requirements<a name="accessing_workmail"></a>

Amazon WorkMail works with all major mobile devices and operating systems that support the Exchange ActiveSync protocol\. These devices include the iPad, iPhone, Android, and Windows Phone\. Users of macOS can add their Amazon WorkMail account to their Mail, Calendar, and Contacts apps\.

If you have a valid Microsoft Outlook license, you can access Amazon WorkMail using the following versions of Microsoft Outlook:
+ Outlook 2007, Outlook 2010, Outlook 2013, Outlook 2016, and Outlook 2019
+ Outlook 2010 and Outlook 2013 Click\-to\-Run
+ Outlook for Mac 2011, Outlook 2016 for Mac, and Outlook 2019 for Mac

The Amazon WorkMail web application is accessed at `https://alias.awsapps.com/mail`\. Amazon WorkMail can also be used with IMAP clients\. For more information, see [Setting up email clients for Amazon WorkMail](https://docs.aws.amazon.com/workmail/latest/userguide/clients.html) in the *Amazon WorkMail User Guide*\.

## Amazon WorkMail concepts<a name="workmail_concepts"></a>

The terminology and concepts that are central to your understanding and use of Amazon WorkMail are described below\.

**Organization**  
A tenant setup for Amazon WorkMail\.

**Alias**  
A globally unique name to identify your organization\. The alias is used to access the Amazon WorkMail web application \(https://*alias*\.awsapps\.com/mail\)\.

**Domain**  
The web address that comes after the @ symbol in an email address\. You can add a domain that receives mail and delivers it to mailboxes in your organization\.

**Test mail domain**  
A domain is automatically configured during setup that can be used for testing Amazon WorkMail\. The test mail domain is *alias*\.awsapps\.com and is used as the default domain if you do not configure your own domain\. The test mail domain is subject to different limits\. For more information, see [Amazon WorkMail quotas](workmail_limits.md)\.

**Directory**  
An AWS Simple AD, AWS Managed AD, or AD Connector created in AWS Directory Service\. If you create an organization using the Amazon WorkMail Quick setup, we create a WorkMail directory for you\. You cannot view a WorkMail directory in AWS Directory Service\.

**User**  
A user created in the AWS Directory Service\. When a user is enabled for Amazon WorkMail, they receive their own mailbox to access\. When a user is disabled, they cannot access Amazon WorkMail\.

**Group**  
A group used in AWS Directory Service\. A group can be used as a distribution list or a security group in Amazon WorkMail\. Groups do not have their own mailboxes\.

**Resource**  
A resource represents a meeting room or equipment resource that can be booked by Amazon WorkMail users\.

**Mobile device policy**  
Various IT policy rules that control the security features and behavior of a mobile device\.

## Related AWS services<a name="related_services"></a>

The following services are used along with Amazon WorkMail:
+ **AWS Directory Service**—You can integrate Amazon WorkMail with an existing AWS Simple AD, AWS Managed AD, or AD Connector\. Create a directory in the AWS Directory Service and then enable Amazon WorkMail for this directory\. After you've configured this integration, you can choose which users you would like to enable for Amazon WorkMail from a list of users in your existing directory, and users can log in using their existing Active Directory credentials\. For more information, see [AWS Directory Service Administration Guide](https://docs.aws.amazon.com/directoryservice/latest/admin-guide/)\.
+ **Amazon Simple Email Service**—Amazon WorkMail uses Amazon SES to send all outgoing email\. The test mail domain and your domains are available for management in the Amazon SES console\. There is no cost for outgoing email sent from Amazon WorkMail\. For more information, see [Amazon Simple Email Service Developer Guide](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/)\.
+ **AWS Identity and Access Management**—The AWS Management Console requires your user name and password so that any service you use can determine whether you have permission to access its resources\. We recommend that you avoid using AWS account credentials to access AWS because AWS account credentials cannot be revoked or limited in any way\. Instead, we recommend that you create an IAM user and add the user to an IAM group with administrative permissions\. You can then access the console using the IAM user credentials\.

  If you signed up for AWS but have not created an IAM user for yourself, you can create one using the IAM console\. For more information, see [Create individual IAM users](https://docs.aws.amazon.com/IAM/latest/UserGuide/IAMBestPractices.html#create-iam-users) in the *IAM User Guide*\.
+ **AWS Key Management Service**—Amazon WorkMail is integrated with AWS KMS for encryption of customer data\. Key management can be performed from the AWS KMS console\. For more information, see [What is the AWS Key Management Service](https://docs.aws.amazon.com/kms/latest/developerguide/overview.html) in the *AWS Key Management Service Developer Guide*\.

## Amazon WorkMail pricing<a name="workmail_pricing"></a>

With Amazon WorkMail, there are no upfront fees or commitments\. You pay only for active user accounts\. For more specific information about pricing, see [Pricing](http://aws.amazon.com/workmail/pricing)\.

## Amazon WorkMail resources<a name="RelatedResources"></a>

The following related resources can help you as you work with this service\.
+ ** [Classes & Workshops](https://aws.amazon.com/training/course-descriptions/)** – Links to role\-based and specialty courses as well as self\-paced labs to help sharpen your AWS skills and gain practical experience\.
+ ** [AWS Developer Tools](https://aws.amazon.com/tools/)** – Links to developer tools, SDKs, IDE toolkits, and command line tools for developing and managing AWS applications\.
+ ** [AWS Whitepapers](https://aws.amazon.com/whitepapers/)** – Links to a comprehensive list of technical AWS whitepapers, covering topics such as architecture, security, and economics and authored by AWS Solutions Architects or other technical experts\.
+ ** [AWS Support Center](https://console.aws.amazon.com/support/home#/)** – The hub for creating and managing your AWS Support cases\. Also includes links to other helpful resources, such as forums, technical FAQs, service health status, and AWS Trusted Advisor\.
+ ** [AWS Support](https://aws.amazon.com/premiumsupport/)** – The primary web page for information about AWS Support, a one\-on\-one, fast\-response support channel to help you build and run applications in the cloud\.
+ ** [Contact Us](https://aws.amazon.com/contact-us/)** – A central contact point for inquiries concerning AWS billing, account, events, abuse, and other issues\. 
+ ** [AWS Site Terms](https://aws.amazon.com/terms/)** – Detailed information about our copyright and trademark; your account, license, and site access; and other topics\.