# AWS Security Hub partner FAQ<a name="integration-faq"></a>

The following are common questions about setting up and maintaining an integration with AWS Security Hub\.

1. **What are the benefits of Security Hub integration?**
   + **Customer satisfaction** – The number one reason to integrate with Security Hub is because you have customer requests to do so\.

     Security Hub is the security and compliance center for AWS customers\. It is designed as the first stop where AWS security and compliance professionals go each day to understand their security and compliance state\.

     Listen to your customers\. They will tell you if they want to see your findings in Security Hub\.
   + **Discovery opportunities** – We promote partners with certified integrations inside the Security Hub console, including links to their AWS Marketplace listings\. This is a great way for customers to discover new security products\. 
   + **Marketing opportunities** – Vendors with approved integrations can participate in webinars, issue press releases, create slick sheets, and demonstrate their integrations to AWS customers\. 

1. **What types of partners are there?**
   + Partners that send findings to Security Hub
   + Partner that receive findings from Security Hub
   + Partners that both send and receive findings
   + Consulting partners that help customers to set up, customize, and use Security Hub in their environment

1. **How does a partner integration with Security Hub work at a high level?**

   You gather findings from within a customer account or from your own AWS account and transform the format of the findings to the AWS Security Finding Format \(ASFF\)\. You then push those findings to the appropriate Security Hub regional endpoint\.

   You can also use CloudWatch Events to receive findings from Security Hub\.

1. **What are the basic steps for completing an integration with Security Hub?**

   1. Submit your partner manifest information\.

   1. Receive product ARNs to use with Security Hub, if you will be sending findings to Security Hub\.

   1. Map your findings to ASFF\.

   1. Define your architecture for sending findings to and receiving findings from Security Hub\.

   1. Create a deployment framework for customers\. For example, AWS CloudFormation scripts can serve this purpose\.

   1. Document your setup and provide configuration instructions for customers\.

   1. Define any custom insights \(correlation rules\) that customers can use with your product\.

   1. Demonstrate your integration to the Security Hub team\.

   1. Submit marketing information for approval \(website language, press release, architecture slide, video, slick sheet\)\.

1. **What is the process for submitting the partner manifest? And for AWS services to send findings to Security Hub?**

   To submit the manifest information to the Security Hub team, use securityhub\-partners@amazon\.com\.

   You are issued product ARNs within seven calendar days\.

1. **What types of findings should I send to Security Hub?**

   Security Hub pricing is partly based on the number of findings ingested\. Because of this, you should refrain from sending findings that do not provide value to customers\.

   For example, some vulnerability management vendors only send findings with a Common Vulnerability Scoring System \(CVSS\) score of 3 or above out of a possible 10\. 

1. **What are the different approaches for me to send findings to Security Hub?**

   These are the primary approaches:
   + You send findings from their own designated AWS account using the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) operation\.
   + You send findings from within the customer account using the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) operation\. You could use assume\-role approaches, but these approaches are not required\. 

1. **How do I gather my findings and push them to a Security Hub Regional endpoint? **

   Partners have used different approaches for this, as it is highly dependent on the architecture of your solution\.

   For example, some partners build a Python app that can be deployed as an AWS CloudFormation script\. The script gathers the partner's findings from the customer environment, transforms them into ASFF, and sends them to the Security Hub Regional endpoint\.

   Other partners build a full wizard that gives the customer a single\-click experience to push findings to Security Hub\.

1. **How do I know when to start sending findings to Security Hub?**

   Security Hub supports partial batch authorization for the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) API operation, so that you can send all of your findings to Security Hub for all of your customers\.

   If some of your customers have not yet subscribed to Security Hub, Security Hub does not ingest those findings\. It only ingests authorized findings that are in the batch\.

1. **What steps do I need to complete to send findings to a customer's Security Hub instance?**

   1. Ensure the correct IAM policies are in place\.

   1. Enable a product subscription \(resource policies\) for the accounts\. Use either the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html) API operation or the **Integrations** page\. The customer can do this, or you can use cross\-account roles to act on behalf of the customer\.

   1. Ensure that the `ProductArn` of the finding is your product's public ARN\.

   1. Ensure that the `AwsAccountId` of the finding is the customer’s account ID\. 

   1. Ensure that your findings do not have any malformed data according to the AWS Security Finding Format \(ASFF\)\. For example, required fields are populated, and there are no invalid values\. 

   1. Send findings in batches to the correct Regional endpoint\.

1. **What IAM permissions must be in place for me to send findings? **

   IAM policies must be configured for the IAM user or role that calls [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) or other API calls\.

   The easiest test is to do this from an admin account\. You can constrain these to `action: ‘securityhub:BatchImportFindings’` and `resource: <productArn and/or productSubscriptionArn>`\.

   Resources in the same account can be configured with IAM policies without requiring resource policies\. 

   To rule out IAM policy issues from the caller of [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html), set the IAM policy for the caller as follows:

   ```
   {
       Action: 'securityhub:*',
       Effect: 'Allow',
       Resource: '*'
   }
   ```

   Be sure to check that there are no `Deny` policies for the caller\. After you get it to work with that, you can restrict the policy to the following:

   ```
   {
       Action: 'securityhub:BatchImportFindings',
       Effect: 'Allow',
       Resource: 'arn:aws:securityhub:<region>:<account>:product/mycompany/myproduct'
   },
   {
       Action: 'securityhub:BatchImportFindings',
       Effect: 'Allow',
       Resource: 'arn:aws:securityhub:<region>:*:product-subscription/mycompany/myproduct'
   }
   ```

1. **What is a product subscription?**

   To receive findings from a specific partner product, the customer \(or the partner with cross\-account roles working on behalf of the customer\) must establish a product subscription\. To do this from the console, they use the **Integrations** page\. To do this from the API, they use the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_EnableImportFindingsForProduct.html) API operation\.

   The product subscription creates a resource policy that authorizes the findings from the partner to be received or sent by the customer\. For details, see [Integration use cases and required permissions](integration-use-cases.md)\.

   Security Hub has the following types of resource policies for partners:
   + `BATCH_IMPORT_FINDINGS_FROM_PRODUCT_ACCOUNT`
   + `BATCH_IMPORT_FINDINGS_FROM_CUSTOMER_ACCOUNT`

   During the partner onboarding process, you can request either one or both types of policies\.

   With `BATCH_IMPORT_FINDINGS_FROM_PRODUCT_ACCOUNT`, you can only send findings to Security Hub from the account listed in your product ARN\.

   With `BATCH_IMPORT_FINDINGS_FROM_CUSTOMER_ACCOUNT`, you can only send findings from the customer account that subscribed to you\. 

1. **Assume a customer created a master account and added a few member accounts\. Does the customer need to subscribe each member account to me? Or does the customer only subscribe from master account, and I can then send findings against resources in all member accounts?**

   This question asks whether the permissions are created for all member accounts based on the master account registration\.

   The customer must put a product subscription in place for each account\. They can do this programmatically through the API\.

1. **What is my product ARN?**

   Your product ARN is your unique identifier that Security Hub generates for you and that you use to submit findings\. You receive a product ARN for each product that you integrate with Security Hub\. The correct product ARN must be part of every finding that you send to Security Hub\. Findings without the product ARN are dropped\. The product ARN uses the following format:

   `arn:aws:securityhub:[region code]:[account ID]:product/[company name]/[product name]`

   Here is an example:

   `arn:aws:securityhub:us-west-2:222222222222:product/generico/secure-pro`

   You are given a product ARN for each Region where Security Hub is deployed\. The account ID, company, and product names are dictated by your partner manifest submissions\. You never change any of the information that is associated with your product ARN, except for the Region code\. The Region code must match the Region that you submit findings for\.

   A common mistake is to change the account ID to match the account where you are currently working from\. The account ID does not change\. You submit a "home" account ID as part of the manifest submission\. This account ID is locked into your product ARN\.

   When Security Hub launches in new Regions, it automatically uses the standard Region codes to generate your product ARNs for those Regions\.

   Every account is also automatically provisioned with a private product ARN\. You can use this ARN to test importing findings within your own development account before you receive your official public product ARN\.

1. **What format should be used to send findings to Security Hub? **

   Findings must be provided in the AWS Security Finding Format \(ASFF\)\. For details, see [AWS Security Finding Format \(ASFF\)](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-format.html) in the *AWS Security Hub User Guide*\.

   The expectation is that all of the information in your native findings is fully reflected in the ASFF\. Custom fields such as `ProductFields` and `Resource.Details.Other` allow you to map data that does not fit neatly into the predefined fields\.

1. **What is the correct Regional endpoint to use?**

   You must send findings to the Security Hub Regional endpoint that is associated with the customer account\.

1. **Where can I find the list of regional endpoints? **

   See the [Security Hub endpoints list](https://docs.aws.amazon.com/general/latest/gr/sechub.html)\.

1. **Can I submit cross\-Region findings?**

   Security Hub does not yet support cross\-Region submission of findings for the native AWS services, such as Amazon GuardDuty, Amazon Macie, and Amazon Inspector\. If your customer allows it, Security Hub does not prevent you from submitting findings from different Regions\.

   In this sense, you can call a Regional endpoint from anywhere, and the resource information of the ASFF does not have to match the Region of the endpoint\. However, `ProductArn` must match the Region of the endpoint\.

1. **What are the rules and guidelines for sending batches of findings?**

   You can batch up to 100 findings or 240 KB in a single call of [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html)\. Queue up and batch as many findings as possible up to this limit\.

   You can batch a set of findings from different accounts\. However, if any of the accounts in the batch are not subscribed to Security Hub, the entire batch fails\. This is a limitation of the API Gateway baseline authorization model\.

1. **Can I send updates to findings that I created?**

   Yes, if you submit a finding with the same product ARN and same finding ID, it overwrites the previous data for that finding\. Note that all of the data is overwritten, so you should submit a complete finding\.

   Customers are metered and billed for both new findings and finding updates\.

1. **Can I send updates to findings that someone else created?**

   Yes, if the customer grants you access to the [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchUpdateFindings.html) API operation, you can update certain fields using that operation\. This operation is designed to be used by customers, SIEMs, ticketing systems, and Security Orchestration, Automation, and Response \(SOAR\) platforms\. 

1. **How are findings aged off?**

   Security Hub ages out findings 90 days after the last update date\. After this time, the aged\-out findings are purged from the Security Hub Elasticsearch cluster\.

   If you update a finding with the same finding ID, and it has been aged off, a new finding is created in Security Hub\.

   Customers can use CloudWatch Events to move findings out of Security Hub\. Doing so enables all findings to be sent to targets of the customer's choice\.

   In general, Security Hub recommends that you create new findings every 90 days and do not update findings forever\.

1. **What throttles does Security Hub put in place?**

   Security Hub throttles `GetFindings` API calls, as the recommended approach to access findings is using CloudWatch Events\.

   Security Hub does not implement any other throttling on internal services, partners, or customers beyond that enforced by API Gateway and Lambda invocations\.

1. **What is the timeliness or latency SLAs or expectations for findings that are sent to Security Hub from source services?**

   The aim is to be as near\-real time as possible for both initial findings and updates to findings\. You should send findings to Security Hub within five minutes after they are created\.

1. **How can I receive findings from Security Hub?**

   To receive findings, use one of the following methods\.
   + All findings are automatically sent to CloudWatch Events\. A customer can create specific CloudWatch Events rules to send findings to specific targets, such as a SIEM or an S3 bucket\. This capability replaced the legacy `GetFindings` API operation\.
   + Use CloudWatch Events for custom actions\. Security Hub allows customers to select specific findings or groups of findings from within the console and take action on them\. For example, they can send findings to a SIEM, ticketing system, chat platform, or remediation workflow\. This would be part of an alert triage workflow that a customer performs within Security Hub\. These are called custom actions\.

     When a user selects a custom action, a CloudWatch event is created for those specific findings\. You could leverage this capability and build out CloudWatch Events rules and targets for a customer to use as part of a custom action\. Note that this capability is not used to automatically send all findings of a particular type or class to CloudWatch Events\. It is for a user to take action on specific findings\.

     You can use the custom action API operations, such as `CreateActionTarget`, to automatically create available actions for your product \(such as using AWS CloudFormation templates\)\. You would also use CloudWatch Events rule API operations to create corresponding CloudWatch Events rules that are associated with the custom action\. Using AWS CloudFormation templates, you can also create CloudWatch Events rules to automatically ingest from Security Hub all findings or all findings with certain characteristics\.

1. **What are the requirements for a managed security service provider \(MSSP\) to become a Security Hub partner?**

   You must demonstrate how Security Hub is used as part of your service delivery to customers\. 

   You should have user documentation that explains your use of Security Hub\.

   If the MSSP is a finding provider, they must demonstrate sending findings to Security Hub\.

   If the MSSP only receives findings from Security Hub, they must at a minimum have an AWS CloudFormation template to set up the appropriate CloudWatch Events rules\.

1. **What are the requirements for a non\-MSSP APN Consulting Partner to become a Security Hub partner?**

   If you are am APN Consulting Partner, you can become a Security Hub partner\. You should submit two private case studies on how you helped a specific customer do the following\.
   + Set up Security Hub with IAM permissions that the customer needs\.
   + Help to connect already integrated independent software vendor \(ISV\) solutions to Security Hub using the configuration instructions on the partner page in the console\.
   + Help customers with custom product integrations\.
   + Build custom insights relevant to the customer needs and datasets\.
   + Build custom actions\.
   + Build remediation playbooks\.
   + Build Quickstarts that align to the Security Hub compliance standards\. These must be validated by the Security Hub team\.

   Case studies do not need to be publicly shareable\.

1. **What are the requirements around how I deploy my integration with Security Hub with my customers?**

   Integration architectures between Security Hub and partner products vary from partner to partner in terms of how that partner's solution is operated\. You should ensure that the setup process for the integration takes no longer than 15 minutes\.

   If you are deploying integration software into the customer's AWS environment, you should leverage AWS CloudFormation templates to simplify the integration\. Some partners have created a one\-click integration, which is highly encouraged\. 

1. **What are my documentation requirements?**

   You must provide a link to documentation that describes the integration and setup process between your product and Security Hub, including your use of AWS CloudFormation templates\.

   That documentation should also include information on your usage of ASFF\. Specifically, this should list the ASFF finding types that you are using for your different findings\. If you have any default insight definitions, we recommend that you also include them here\.

   Consider including other potential information:
   + Your use case for integration with Security Hub
   + Average volume of findings sent
   + Your integration architecture
   + The Regions that you do and do not support
   + Latency between when findings are created and when they are sent to Security Hub
   + Whether you update findings

1. **What are custom insights?**

   You are encouraged to define custom insights for your findings\. Insights are lightweight correlation rules that help a customer prioritize which findings and resources most require attention and action\.

   Security Hub has a `CreateInsight` API operation\. You can create custom insights inside a customer account as part of your AWS CloudFormation template\. These insights appear on the customer’s console\.

1. **Can I submit dashboard widgets?**

   No, not at this time\. You can only create managed insights\.

1. **What is your pricing model?**

   See the [Security Hub pricing information](http://aws.amazon.com/security-hub/pricing/)\.

1. **How do I submit findings to the Security Hub demo account as part of the final approval process for my integration?**

   Send findings to the Security Hub demo account using your provided product ARN, using `us-west-2` as the Region\. The findings should include the demo account number in the `AwsAccountId` field of ASFF\. To obtain the demo account number, contact the Security Hub team\.

   Do not send us any sensitive data or personally identifiable information\. This data is used for public demos\. When you send us this data, you authorize us to use it in demos\.

1. **What error or success messages does `BatchImportFindings` provide?**

   Security Hub provides a response for authorization and a response for [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html)\. More crisp success, failure, and error messages are in development\. 

1. **What error handling is the source service responsible for?**

   Source services are responsible for all error handling\. They must handle error messages, retries, throttling, and alarming\. They also must handle feedback or error messages sent through the Security Hub feedback mechanism\.

1. **What are some resolutions to common problems?**

   An `AuthorizerConfigurationException` is caused by either a malformed `AwsAccountId` or `ProductArn`\.

   When troubleshooting, note the following:
   + `AwsAccountId` must be 12 digits exactly\.
   + `ProductArn` must be in the following format: arn:aws:securityhub:*<us\-west\-2 or us\-east\-1>*:*<accountId>*:product/*<company\-id>*/*<product\-id>*

     The account ID does not change from the one that the Security Hub team included in the product ARNs that they provided to you\.

   `AccessDeniedException` is caused when a finding is sent to or from the wrong account, or when the account does not have a `ProductSubscription`\. The error message will contain an ARN with a resource type of `product` or `product-subscription`\. This error only occurs during cross\-account calls\. If you call [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html) with your own account for the same account in `AwsAccountId` and `ProductArn`, the operation uses IAM policies and has nothing to do with `ProductSubscriptions`\. 

   Be sure the customer account and product account that you use are the actual registered accounts\. Some partners have used an account number for the product from the product ARN, but try to use an entirely different account to call [https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html](https://docs.aws.amazon.com/securityhub/1.0/APIReference/API_BatchImportFindings.html)\. In other cases, they created `ProductSubscriptions` for other customer accounts, or even for their own product account\. They did not create `ProductSubscriptions` for the customer account that they attempted to import findings into\.

1. **Where do I send questions, comments, and bugs?**

   securityhub\-partners@amazon\.com

1. **Which Region do I send findings to for items related to global AWS services? For example, where do I send IAM related findings?**

   Send findings to the same Region where the finding was detected\. For a service such as IAM, your solution will likely find the same IAM issue in multiple Regions\. In this case, the finding is sent to every Region where the issue was detected\.

   If the customer runs Security Hub in three Regions, and the same IAM issue is detected in all three Regions, then send the finding to all three Regions\.

   When an issue is resolved, send the update to the finding to all of the Regions where you sent the original finding\.