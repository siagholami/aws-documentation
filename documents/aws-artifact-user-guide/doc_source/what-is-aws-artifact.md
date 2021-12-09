# What Is AWS Artifact?<a name="what-is-aws-artifact"></a>

AWS Artifact provides on\-demand downloads of AWS security and compliance documents, such as AWS ISO certifications, Payment Card Industry \(PCI\), and Service Organization Control \(SOC\) reports\. You can submit the security and compliance documents \(also known as *audit artifacts*\) to your auditors or regulators to demonstrate the security and compliance of the AWS infrastructure and services that you use\. You can also use these documents as guidelines to evaluate your own cloud architecture and assess the effectiveness of your company's internal controls\. AWS Artifact provides documents about AWS only\. AWS customers are responsible for developing or obtaining documents that demonstrate the security and compliance of their companies\. For more information, see [Shared Responsibility Model](https://aws.amazon.com/compliance/shared-responsibility-model/)\.

You can also use AWS Artifact to review, accept, and track the status of AWS agreements such as the Business Associate Addendum \(BAA\)\. A BAA typically is required for companies that are subject to the Health Insurance Portability and Accountability Act \(HIPAA\) to ensure that protected health information \(PHI\) is appropriately safeguarded\. With AWS Artifact, you can accept agreements with AWS and designate AWS accounts that can legally process restricted information\. You can accept an agreement on behalf of multiple accounts\. To accept agreements for multiple accounts, use AWS Organizations to create an organization\. For more information, see [Managing Your Agreements in AWS Artifact](managingagreements.md)\.

**Topics**
+ [Are You a First\-Time User of AWS Artifact?](#first-time-user)
+ [Accessing AWS Artifact](#accessing-artifact)
+ [Securing Your Documents](#artifact-best-practices)
+ [AWS Artifact Regions](#regions-artifact)
+ [Pricing for AWS Artifact](#pricing-for-artifact)

## Are You a First\-Time User of AWS Artifact?<a name="first-time-user"></a>

If you're a first\-time user of AWS Artifact, we recommend that you begin by reading the following sections:
+ [Securing Your Documents](#artifact-best-practices)
+ [Setting Up AWS Artifact](setting-up.md)
+ [Getting Started with AWS Artifact](getting-started.md)
+ [Downloading Reports in AWS Artifact](downloading-documents.md)

## Accessing AWS Artifact<a name="accessing-artifact"></a>

AWS Artifact provides a web\-based user interface, the AWS Artifact console\. If you have signed up for an AWS account, you can access the AWS Artifact console by signing in to [https://console\.aws\.amazon\.com/artifact/](https://console.aws.amazon.com/artifact/) and choosing **Artifact** from the console home page\. If you don't have an AWS account yet, see [Sign Up for AWS](setting-up.md#setting-up-aws-sign-up)\. 

For information about creating permissions that control access to the console for you and other users, see [Create an IAM Admin Group and User](setting-up.md#setting-up-create-iam-user)\. 

## Securing Your Documents<a name="artifact-best-practices"></a>

AWS Artifact documents are confidential and should be kept secure at all times\. AWS Artifact uses the [AWS shared compliance responsibility model](https://aws.amazon.com/compliance/shared-responsibility-model/) for its documents\. This means that AWS is responsible for keeping documents secure while they are in the AWS Cloud, but you are responsible for keeping them secure after you download them\. AWS Artifact might require you to sign a nondisclosure agreement \(NDA\) before you can download documents\. Each document download has a unique, traceable watermark\.

You are only permitted to share documents marked as confidential within your company, with your regulators, or with your auditors\. You aren't permitted to share these documents with your customers or on your website\. We strongly recommend that you use a secure document sharing service, such as Amazon WorkDocs, to share documents with others\. Don't send the documents through email or upload them to an unsecure site\.

## AWS Artifact Regions<a name="regions-artifact"></a>

AWS Artifact is available in all public regions\.

## Pricing for AWS Artifact<a name="pricing-for-artifact"></a>

AWS provides AWS Artifact documents and agreements to you free of cost\.