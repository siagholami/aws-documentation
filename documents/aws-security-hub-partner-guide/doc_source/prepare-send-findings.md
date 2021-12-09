# Preparing to send findings to AWS Security Hub<a name="prepare-send-findings"></a>

As an APN Partner, you cannot send information to Security Hub for your customers until the Security Hub team enables you as a finding provider\. To be enabled as a finding provider, you must complete the following onboarding steps\. Doing so ensures a positive experience Security Hub for you and your customers\.

1. Map your security findings to the AWS Security Finding Format \(ASFF\)\.

1. Build your integration architecture to push findings to the correct Regional Security Hub endpoint\. To do this, you define whether you will send findings from your own AWS account or from within your customer's accounts\.

1. Have your customers subscribe the product to their account\. To do this, they can use the console or the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html) API operation\. See [Managing product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-integrations-managing.html) in the *AWS Security Hub User Guide*\.

   You can also subscribe the product for them\. To do this, you use a cross\-account role to access the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html) API operation on behalf of the customer\.

   This step establishes the resource policies that are needed to accept findings from that product for that account\.

The following blog posts discuss some of the existing partner integrations with Security Hub\.
+ [Announcing Cloud Custodian Integration with AWS Security Hub](http://aws.amazon.com/blogs/opensource/announcing-cloud-custodian-integration-aws-security-hub/)
+ [Use AWS Fargate and Prowler to send security configuration findings about AWS services to Security Hub](http://aws.amazon.com/blogs/security/use-aws-fargate-prowler-send-security-configuration-findings-about-aws-services-security-hub/)
+ [How to import AWS Config rules evaluations as findings in Security Hub](http://aws.amazon.com/blogs/security/how-to-import-aws-config-rules-evaluations-findings-security-hub/)