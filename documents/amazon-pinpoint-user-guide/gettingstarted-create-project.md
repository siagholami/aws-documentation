# Step 1: Create and Configure a Project<a name="gettingstarted-create-project"></a>

In Amazon Pinpoint, a *project* is a collection of settings, customer information, segments, and campaigns\. If you're new to Amazon Pinpoint, the first step you should take is to create a project\.

**Note**  
If you've used the Amazon Pinpoint API, you may have seen references to "applications\." In Amazon Pinpoint, a *project* is the same as an *application*\.

This section shows you how to create a project\. As part of this procedure, you also verify an email address\. You use this address to send email when you create your email campaign later in this tutorial\.

If you've never created a project in your Amazon Pinpoint account, complete the steps in [Option 1: Create and Configure a Project \(New Amazon Pinpoint Users\)](#gettingstarted-create-project-new-user)\. If your Amazon Pinpoint account already contains one or more projects, complete the steps in [Option 1: Create and Configure a Project \(Existing Amazon Pinpoint Users\)](#gettingstarted-create-project-existing-user) instead\.

## Option 1: Create and Configure a Project \(New Amazon Pinpoint Users\)<a name="gettingstarted-create-project-new-user"></a>

The procedures in this section show you how to create a project and verify an email address\. If you've never created a project in Amazon Pinpoint, complete the procedures in this section\.

If your Amazon Pinpoint account includes one or more existing projects, you should complete the steps in [Option 2: Create and Configure a Project \(Existing Amazon Pinpoint Users\)](#gettingstarted-create-project-existing-user) instead\.

**To create a project and verify an email address**

1. Sign in to the AWS Management Console and open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. If this is your first time using Amazon Pinpoint, you see a page that introduces you to the features of the service\.

   In the **Get started** section, enter a name for your project, and then choose **Create a project**\.
**Note**  
The project name can contain up to 64 characters\.

1. On the **Configure features** page, next to **Email**, choose **Configure**\.

1. For **Email address**, type an email address that you want to use to send email\. For example, you can use your personal email address, or your work email address\. Choose **Verify**\.

1. Wait for 1–2 minutes, and then check the inbox for the email address that you specified in step 4\. You should see an email from *Amazon Web Services \(no\-reply\-aws@amazon\.com\)* with the subject line "Amazon Web Services – Email Address Verification Request in region *RegionName*", where *RegionName* is the name of the AWS Region that you're configuring Amazon Pinpoint in\.

1. Open the email, and then click the link in the body of the email\.

1. Return to the Amazon Pinpoint console in your browser\. On the **Set up email** page, choose **Save**\.

## Option 2: Create and Configure a Project \(Existing Amazon Pinpoint Users\)<a name="gettingstarted-create-project-existing-user"></a>

The procedures in this section show you how to create a project and verify an email address\. If your Amazon Pinpoint account includes one or more existing projects, complete the procedures in this section\.

If you've never created a project in Amazon Pinpoint, you should complete the steps in [Option 1: Create and Configure a Project \(New Amazon Pinpoint Users\)](#gettingstarted-create-project-new-user) instead\.

**To create a project and verify an email address**

1. Open the Amazon Pinpoint console at [https://console\.aws\.amazon\.com/pinpoint/](https://console.aws.amazon.com/pinpoint/)\.

1. On the **All projects** page, choose **Create a project**\.

1. On the **Create a project** window, for **Project name**, enter a name for your project, and then choose **Create**\.
**Note**  
The project name can contain up to 64 characters\.

1. On the **Configure features** page, next to **Email**, choose **Configure**\.

1. For **Email address**, type an email address that you want to use to send email\. For example, you can use your personal email address, or your work email address\. Choose **Verify**\.

1. Wait for 1–2 minutes, and then check the inbox for the email address that you specified in step 4\. You should see an email from *Amazon Web Services \(no\-reply\-aws@amazon\.com\)* with the subject line "Amazon Web Services – Email Address Verification Request in region *RegionName*", where *RegionName* is the name of the AWS Region that you're configuring Amazon Pinpoint in\.

1. Open the email, and then click the link in the body of the email\.

1. Return to the Amazon Pinpoint console in your browser\. On the **Set up email** page, choose **Save**\.

Your account is now ready to send email from the email address that you verified\. You can add additional email addresses later\.

You can also verify entire domains\. When you verify a domain, you can send email from any address on that domain\. For more information, see [Verifying a Domain](channels-email-manage-verify.md#channels-email-manage-verify-domain)\.

**Next:** [Import Customer Data and Create a Segment](gettingstarted-import-customer-data.md)