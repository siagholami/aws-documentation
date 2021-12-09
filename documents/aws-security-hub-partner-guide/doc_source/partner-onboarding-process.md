# Partner onboarding process<a name="partner-onboarding-process"></a>

As a partner, you can expect to complete several high\-level steps as part of your onboarding process\. You must complete these steps before you can send security findings to AWS Security Hub\.

1. You initiate an engagement with the APN Partner team or the Security Hub team and express interest in becoming a partner with Security Hub\. You identify the email addresses to add to Security Hub communication channels\.

1. AWS gives you the Security Hub partner onboarding materials\.

1. You are invited to the Security Hub partner Slack channel, where you can ask questions related to your integration\.

1. You provide APN Partner contacts with a draft product integration manifest for review\.

   The product integration manifest contains information that is used to create the partner product Amazon Resource Name \(ARN\) for the integration with AWS Security Hub\.

   It provides the Security Hub team with information that appears on the partner provider page in the Security Hub console\. It is also used to propose new managed insights related to the integration to add to the Security Hub insight library\.

   This initial version of the product integration manifest does not have to have the complete details\. But it should at least contain the use case and dataset information\.

   For details about the manifest and the required information, see [Product integration manifest](integration-manifest.md)\.

1. The Security Hub team gives you a product ARN for your product\. You use the ARN to send findings to Security Hub\.

1. You build your integration to send findings to or receive findings from Security Hub\.  
**Mapping findings to ASFF**  
To send findings to Security Hub, you must map your findings to the AWS Security Finding Format \(ASFF\)\.  
The ASFF provides a consistent description of findings that can be shared among AWS security services, partners, and customer security systems\. This reduces integration efforts, encourages a common language, and provides a blueprint for implementers\.  
ASFF is the required wire protocol format to use to send findings to AWS Security Hub\. Findings are represented as JSON documents that adhere to the ASFF JSON Schema and RFC\-7493 The I\-JSON Message Format\. For details on the ASFF schema, see [AWS Security Finding Format \(ASFF\)](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html) in the *AWS Security Hub User Guide*\.  
See [Guidelines for mapping findings into the AWS Security Finding Format \(ASFF\)](guidelines-asff-mapping.md)\.  
**Building and testing the integration**  
You can complete all of the testing for your integration using an AWS account that you own\. Doing so gives you full visibility into how the findings appear in Security Hub\. It also helps you understand the customer's experience with your security findings\.  
You use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation to send new and updated findings to Security Hub\.  
Throughout the build of a Security Hub integration, AWS encourages you to keep your APN Partner contacts informed about the progress of your integration\. You can also ask your APN Partner contacts for help with integration questions\.  
See [Guidelines for using the `BatchImportFindings` API](guidelines-batchimportfindings.md)\.

1. You demonstrate the integration to the Security Hub product team\. This integration must be demonstrated using an account that the Security Hub team owns\.

   If they are comfortable with the integration, the Security Hub team gives approval to move forward to list you as a provider\.

1. You provide AWS with a final manifest for review\.

1. The Security Hub team creates the provider integration in the Security Hub console\. Customers can then discover and enable the integration\.

1. \(Optional\) You engage in additional marketing efforts to promote your Security Hub integration\. See [Go\-to\-market activities](go-to-market-activities.md)\.

   At a minimum, Security Hub recommends that you provide the following assets\.
   + A demonstration video \(3 minutes at most\) of the working integration\. The video is used for marketing purposes and is posted to the AWS YouTube channel\.
   + A one\-slide architecture diagram to add to the Security Hub first call slide deck\.