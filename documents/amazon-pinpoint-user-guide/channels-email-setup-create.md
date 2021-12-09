# Creating an Amazon Pinpoint Project with Email Support<a name="channels-email-setup-create"></a>

To send email with Amazon Pinpoint, you create an Amazon Pinpoint project, enable the email channel for that project, and then specify and verify the email address that you want to use when you send email from the project\. 

There are two ways to create an Amazon Pinpoint project\. You can use the Amazon Pinpoint console or the Amazon Pinpoint API\. This section shows you how to create a project by using the console\. To learn how to create a project by using the Amazon Pinpoint API, see the [Amazon Pinpoint Developer Guide](https://docs.aws.amazon.com/pinpoint/latest/developerguide/)\.

After you create a new project, you enable the email channel for the project, and then specify and verify the email identity that you want to use\. In Amazon Pinpoint, an *identity* is an email address or domain that you use to send email\. Before you can send email using Amazon Pinpoint, you must verify each identity that you plan to use as a "From", "Source", "Sender", or "Return\-Path" address to prove that you own the identity\. If your account is still in the Amazon Pinpoint sandbox, you also need to verify the identities that you plan to send email to\.

**To create a new Amazon Pinpoint project and verify an email address**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose **Create a project**\.

1. For **Project name**, enter a name, and then choose **Create**\.
**Note**  
The project name can contain up to 64 alphanumeric characters\. It can also include the following characters: comma \(,\), period \(\.\), at sign \(@\), underscore \(\_\), equals sign \(=\), and plus sign \(\+\)\.

1. Under **Email**, choose **Configure**\.

1. For **Email address**, enter the email address that you want to use when you send email from the project, and then choose **Verify**\. Amazon Pinpoint sends an email to the address that you entered\. Open the email, and then click the link in the message to verify the email address\.