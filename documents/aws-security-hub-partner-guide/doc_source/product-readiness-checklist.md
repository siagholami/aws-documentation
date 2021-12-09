# Product readiness checklist<a name="product-readiness-checklist"></a>

The AWS Security Hub and APN Partner teams use this checklist to validate that the integration is ready to be launched\.

## ASFF mapping<a name="readiness-asff-mapping"></a>

These questions are related to the mapping of your finding to the AWS Security Finding Format \(ASFF\)\.

**Is all of the partner's finding data mapped into ASFF?**  
Map all your findings to the ASFF in some way\.  
Use curated fields such as modeled resource types, `Network`, `Malware`, or `ThreatIntelIndicators`\.  
Map anything else into `Resource.Details.Other` or `ProductFields` as appropriate\.

**Does the partner use `Resource.Details` fields, such as `AwsEc2instance`, `AwsS3Bucket`, and `Container`? Does the partner use `Resource.Details.Other` to define resource details that are not modeled in the ASFF?**  
Whenever possible, use the provided fields for curated resources such as EC2 instances, S3 buckets, and security groups in your findings\.  
Map other information related to resources to `Resource.Details.Other` only when there is not a direct match\.

**Does the partner map values to `UserDefinedFields`?**  
Do not use `UserDefinedFields`\.  
Consider using another curated field, such as `Resource.Details.Other` or `ProductFields`\.

**Does the partner map information into `ProductFields` that could be mapped into other ASFF fields?**  
Only use `ProductFields` for product\-specific information such as versioning information, product\-specific severity findings, or other information that cannot be mapped into a curated field or `Resources.Details.Other`\.

**Does the partner import their own timestamps for `FirstObservedAt`?**  
The `FirstObservedAt` timestamp is intended to record the time when a finding was observed in the product\. Map this field if at all possible\.

****Does the partner provide unique values generated for each finding identifier, except for findings that they want to update?****  
All findings in Security Hub are indexed on the finding identifier \(`Id` attribute\)\. This value must always be unique to ensure that findings are not updated accidentally\.  
You should also maintain the finding identifier state for the purpose of updating the findings\.

**Does the partner provide a value that maps findings to a generator ID? **  
`GeneratorID` should not have the same value as the finding ID\.  
`GeneratorID` should be able to logically link findings by what generated them\.  
This can be a subcomponent within a product \(Product A \- Vulnerability vs Product A \- EDR\) or something similar\.

**Does the partner use the required finding types namespaces in a way that is relevant to their product? Does the partner use the recommended finding type categories or classifiers in their finding types?**  
The finding type taxonomy should closely map to the findings that the product generates\.  
The first\-level namespaces outlined in the AWS Security Finding Format are required\.  
You can use custom values for the second\- and third\-level namespaces \(Categories or Classifiers\)\.

**Does the partner capture network flow information in the `Network` fields, if they have network data?**  
If your product captures NetFlow information, map it to the `Network` field\.

****Does the partner capture process \(PID\) information in the `Process` fields, if they have process data?****  
If your product captures process information, map it to the `Process` field\.

**Does the partner capture malware information in the `Malware` fields, if they have malware data?**  
If your product captures malware information, map it to the `Malware` field\.

**Does the partner capture threat intelligence information in the `ThreatIntelIndicators` fields, if they have threat intelligence data?**  
If your product captures threat intelligence information, map it to the `ThreatIntelIndicators` field\.

**Does the partner provide a confidence rating for findings? If they do, is a rationale provided?**  
Whenever you use this field, provide a rationale in your documentation and manifest\.

**Does the partner use a canonical ID or ARN for the resource ID in the finding?**  
When identifying AWS resources, the best practice is to use the ARN\. If an ARN is not available, use the canonical resource ID\.

## Integration setup and function<a name="readiness-integration-setup"></a>

These questions are related to the setup and day\-to\-day function of the integration\.

**Does the partner provide an infrastructure\-as\-code \(IaC\) template to deploy the integration with Security Hub, such as Terraform, AWS CloudFormation, or AWS Cloud Development Kit \(AWS CDK\)?**  
For integrations that will send findings from the customer account or use CloudWatch Events to consume findings, some form of IaC template is required\.  
AWS CloudFormation is preferred, but AWS CDK or Terraform can also be used\.

**Does the partner product have a one\-click setup on their console for their integration with Security Hub?**  
Some partner products use a toggle or a similar mechanism in their product to activate the integration\. This may entail automatically provisioning resources and permission\. If you send findings from a product account, one\-click setup is the preferred method\.

**Does the partner only send findings of value?**  
You should generally only send findings that have security value to Security Hub customers\.  
Security Hub is not a general log management tool\. You should not send every possible log to Security Hub\.

**Did the partner provide an estimate on how many findings they will send per day per customer and at what frequency \(average and burst\)?**  
Numbers of unique findings are used to calculate load on Security Hub\. A unique finding is defined as a finding with a different ASFF mapping from another finding\.  
For example, if one finding populated only `ThreatIntelndicators` and another populated only `Resources.Details.AWSEc2Instance`, those are two unique findings\.

**Does the partner have a graceful way of handling 4xx and 5xx errors such that they are not throttled and all findings can be sent at a later time?**  
There is currently a 30–50 TPS burst rate on the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation\. If 4xx or 5xx errors are returned, you must retain the state of those failed findings so that you can retry them in totality later\. You can do this through a dead letter queue or another AWS messaging services such as Amazon SNS or Amazon SQS\.

**Does the partner maintain the state of their findings so that they know to archive findings that are no longer present?**  
If you plan to update findings by overwriting the original finding ID, you must have a mechanism to retain state so that the correct information is updated for the correct finding\.  
If you provide findings, do not use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) operation to update findings\. This operation should only be used by customers\. You only use [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) when you investigate and take action on findings\.

**Does the partner handle retries in a way that does not compromise previously sent successful findings?**  
You should have a mechanism to retain the original finding IDs in the case of errors so that you do not duplicate or overwrite successful findings in error\. 

**Does the partner update findings by calling the `BatchImportFindings` operation with the existing findings' finding ID?**  
To update a finding, you must overwrite the existing finding by submitting the same finding ID\.  
The [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) operation should only be used by customers\.

**Does the partner update findings using the `BatchUpdateFindings` API?**  
If you take action on findings, you can use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) operation to update specific fields\.

**Does the partner provide information on the amount of latency between when a finding is created and when it is sent from their product to Security Hub?**  
You should minimize latency to ensure that customers see findings as soon as possible in Security Hub\.  
This information is required in the manifest\.

**If the partner's architecture is to send findings to Security Hub from a customer account, have they demonstrated this successfully? If the partner's architecture is to send findings to Security Hub from their own account, have they demonstrated this successfully?**  
During testing, findings must be successfully sent from an account that you own that is different from the account provided for the product ARN\.  
Sending a finding from the product ARN owner's account can bypass certain error exceptions from the API operations\.

**Does the partner provide a heartbeat finding to Security Hub?**  
To show that your integration is working correctly, you should send a heartbeat finding\. The heartbeat finding is sent every five minutes and uses the finding type `Heartbeat`\.  
This is important if you send findings from a product account\.

**Did the partner integrate with the Security Hub product team's account during testing?**  
During preproduction validation, you should send finding examples to the Security Hub product team's AWS account\. These examples demonstrate that the findings are sent and mapped correctly\.

## Documentation<a name="readiness-documentation"></a>

These questions are related to the documentation of the integration that you provide\.

**Does the partner host their documentation on a dedicated website?**  
Documentation should be hosted on your website as a static webpage, wiki, Read the Docs, or other dedicated format\.  
Hosting documentation on GitHub does not satisfy the dedicated website requirement\.

**Does the partner documentation provide instructions on how to set up the Security Hub integration?**  
You can set up the integration using either an IaC template or a console\-based "one\-click" integration\.

**Does the partner documentation provide a description of their use case?**  
The use case that you provide in the manifest should also be described in the documentation

**Does the partner documentation provide a rationale for the findings that they send?**  
You should provide the rationale for the types of findings that you send\.  
For example, your product might produce findings for vulnerabilities, malware, and antivirus, but you only send vulnerability and malware findings to Security Hub\. In that case, you must provide a rationale for why you do not send antivirus findings\.

**Does the partner documentation provide a rationale for how the partner maps their findings to ASFF?**  
You should provide the rationale for the mapping of a product's native finding to ASFF\. Customers want to know where to look for specific product information\.

**Does the partner documentation provide guidance on how the partner updates findings, if they update findings?**  
Give customers information about how you retain state, ensure idempotency, and overwrite findings with up\-to\-date information\.

**Does the partner documentation describe finding latency?**  
Minimize latency to ensure that customers see findings as soon as possible in Security Hub\.  
This information is required in the manifest\.

**Does the partner documentation describe how their severity scoring maps to the ASFF severity scoring?**  
Provide information on how you map `Severity.Original` to `Severity.Label`\.  
For example, if your severity value is a letter grade \(A,B,C\), you should provide information on how you map the letter grade to the severity label\.

**Does the partner documentation provide a rationale for confidence ratings?**  
If you provide confidence scores, these scores should be ranked\.  
If you use statically populated confidence scores or mappings that derived from artificial intelligence or machine learning, you should provide additional context\.

**Does the partner documentation note which Regions the partner does and does not support?**  
Note Regions that are or are not supported so that customers know in which Regions to not attempt an integration\.

## Product card information<a name="readiness-product-card"></a>

These questions are related to the card for the product that is displayed on the **Integrations** page of the Security Hub console\.

**Is the provided AWS account ID valid and contain 12 digits?**  
Account identifiers are 12 digits long\. If an account ID contains fewer than 12 digits, then the product ARN will not be valid\.

**Does the product description contain 200 or fewer characters?**  
The product description provided in the JSON within the manifest should be no longer than 200 characters including spaces\.

**Does the configuration link lead to documentation for the integration?**  
The configuration link should lead to your online documentation\. It should not lead to your main website or to marketing pages\.

**Does the purchase link \(if provided\) lead to the AWS Marketplace listing for the product?**  
If you provide a purchase link, it must be for an AWS Marketplace entry\. Security Hub does not accept purchase links that are not hosted by AWS\.

**Do the product categories correctly describe the product?**  
In the manifest, you can provide up to three product categories\. These should match the JSON and cannot be custom\. You cannot provide more than three product categories\.

**Are the company and product names valid and correct?**  
The company name must be 16 or fewer characters\.  
The product name must be 24 or fewer characters\.  
The product name in the product card JSON must match the name in the manifest\.

## Marketing information<a name="readiness-marketing"></a>

These questions are related to marketing for the integration\.

**Is the product description for the Security Hub partners page within 700 characters, including spaces?**  
The Security Hub partners page only accepts up to 700 characters, including spaces\.  
The team will edit down longer descriptions\.

**Is the Security Hub partners page logo no larger than 600 x 300 px?**  
Provide a publicly accessible URL with a company logo in PNG or JPG that is no larger than 600 x 300 pixels\.

**Does the Learn more hyperlink on the Security Hub partners page lead to the partner's dedicated webpage about the integration?**  
The **Learn more** link should not lead to the partner's main website or to the documentation information\.  
This link should always go to a dedicated webpage with marketing information about the integration\.

**Does the partner provide a demo or an instructional video for how to use their integration?**  
A demo or integration walkthrough video is optional but recommended\.

**Is an AWS Partner Network blog post being released with the partner and their partner development manager or partner development representative?**  
AWS Partner Network blog posts should be coordinated ahead of time with the partner development manager or partner development representative\.  
These are separate from any blog post that you create yourself\.  
Allow for 4–6 weeks lead time\. This effort should be started after testing with the private product ARN is complete\.

**Is a partner\-led press release being released?**  
You can work with your partner development manager or partner development representative to get a quote from the VP of External Security Services\. You can use this quotation in your press release\.

**Is a partner\-led blog post being released?**  
You can create your own blog posts to showcase the integration outside of the AWS Partner Network blog\.

**Is a partner\-led webinar being released?**  
You can create your own webinars to showcase the integration\.  
If you require assistance from the Security Hub team, work with the product team after you complete the testing with the private product ARN\.

**Did the partner request social media support from AWS?**  
After your release, you can work with the AWS Security marketing lead to use AWS official social media channels to share details about your webinars\.