# Compliance validation for Amazon Chime<a name="compliance"></a>

Third\-party auditors assess the security and compliance of Amazon Chime as part of multiple AWS compliance programs\. These include ISO and HIPAA\.

If you have an executed HIPAA Business Associate Addendum \(BAA\) with AWS, you can use Amazon Chime for meetings, collaboration, and business calling\. For information about getting a BAA with AWS, or about how to run HIPAA\-regulated workloads on AWS, see [HIPAA](http://aws.amazon.com/compliance/hipaa-compliance/)\.

Amazon Chime's internal communication channels are encrypted during transit and support TLS 1\.2\. This doesn't include traffic that flows to and from the public telephone network \(PSTN\) to Amazon Chime's carrier partners\. Because the public telephone network \(PSTN\) is an unencrypted network, there is no end\-to\-end encryption mechanism for it\.

Amazon Chime supports the option for an unencrypted session initiation protocol \(SIP\) endpoint for video conferencing and PSTN services\. This option is for users with equipment that does not support SIP over TLS\. For a list of Amazon Chime's public endpoints, see [Network configuration and bandwidth requirements](network-config.md)\. 

For a list of AWS services that are in scope for specific compliance programs, see [AWS Services in Scope by Compliance Program](http://aws.amazon.com/compliance/services-in-scope/)\. For general information, see [AWS Compliance Programs](http://aws.amazon.com/compliance/programs/)\.

You can download third\-party audit reports using AWS Artifact\. For more information, see [Downloading reports in AWS Artifact](https://docs.aws.amazon.com/artifact/latest/ug/downloading-documents.html)\.

Your compliance responsibility when using Amazon Chime is determined by the sensitivity of your data, your company's compliance objectives, and applicable laws and regulations\. AWS provides the following resources to help with compliance:
+ [Security and Compliance Quick Start Guides](http://aws.amazon.com/quickstart/?awsf.quickstart-homepage-filter=categories%23security-identity-compliance) – These deployment guides discuss architectural considerations and provide steps for deploying security\- and compliance\-focused baseline environments on AWS\.
+ [Architecting for HIPAA Security and Compliance Whitepaper ](https://d0.awsstatic.com/whitepapers/compliance/AWS_HIPAA_Compliance_Whitepaper.pdf) – This whitepaper describes how companies can use AWS to create HIPAA\-compliant applications\.
+ [AWS Compliance Resources](http://aws.amazon.com/compliance/resources/) – This collection of workbooks and guides might apply to your industry and location\.
+ [Evaluating resources with rules](https://docs.aws.amazon.com/config/latest/developerguide/evaluate-config.html) in the *AWS Config Developer Guide* – The AWS Config service assesses the compliance of your resource configurations with internal practices, industry guidelines, and regulations\.
+ [AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/what-is-securityhub.html) – This AWS service provides a comprehensive view of your security state within AWS\. This helps you check your compliance with security industry standards and best practices\.