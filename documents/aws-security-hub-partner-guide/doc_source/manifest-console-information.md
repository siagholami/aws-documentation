# AWS Security Hub console information<a name="manifest-console-information"></a>

Provide JSON text to the AWS Security Hub team that contains the following information\. Security Hub uses this information to create your product ARN, display the providers list in the console, and include your proposed managed insights in the Security Hub insight library\.

## Company information<a name="manifest-console-company-info"></a>

The company information provides information about your company\. Here's an example:

```
{
    "id": "example",
    "name": "Example Corp",
    "description": "Example Corp is a network security company that monitors your network for vulnerabilities.",
}
```

The company information contains the following fields:


|  Field  |  Required  |  Description  | 
| --- | --- | --- | 
|  `id`  |  Yes  |  The company's unique identifier\. The company identifier must be unique across companies\. This is likely the same as or similar to `name`\. Type: String Minimum length: 5 characters Maximum length: 24 characters Allowed characters: lowercase letters, numbers, and hyphens Must begin with a lowercase letter\. Must end with a lower case letter or a number\.  | 
|  `name`  |  Yes  |  The name of the provider's company to be displayed on the Security Hub console\. Type: String Maximum length: 16 characters  | 
|  `description`  |  Yes  |  The description of the provider's company to be displayed on the Security Hub console\. Type: String Maximum length: 200 characters  | 

## Product information<a name="manifest-console-product-information"></a>

This section provides information about your product\. Here's an example:

```
{
    "IntegrationTypes": ["SEND_FINDINGS_TO_SECURITY_HUB"],
    "id": "example-corp-network-defender", 
    "regionsNotSupported": "us-west-1",
    "commercialAccountNumber": "111122223333",
    "govcloudAccountNumber": "444455556666",
    "chinaAccountNumber": "777788889999",
    "name": "Example Corp Product",
    "description": "Example Corp Product is a managed threat detection service.",
    "importType": "BATCH_IMPORT_FINDINGS_FROM_CUSTOMER_ACCOUNT",
    "category": "Intrusion Detection Systems (IDS)",
    "marketplaceUrl": "marketplace_url",
    "configurationUrl": "configuration_url"
}
```

The product information contains the following fields\.


|  Field  |  Required  |  Description  | 
| --- | --- | --- | 
|  `IntegrationType`  |  Yes  |  Indicates whether your product sends findings to Security Hub, receives findings from Security Hub, or both sends and receives findings\. If you are a Consulting Partner, leave this field blank\. Type: Array of string Valid values: `SEND_FINDINGS_TO_SECURITY_HUB` \| `RECEIVE_FINDINGS_FROM_SECURITY_HUB`  | 
|  `id`  |  Yes  |  The product's unique identifier\. These must be unique within a company\. They do not need to be unique across companies\. This is likely the same or similar as `name`\. Type: String Minimum length: 5 characters Maximum length: 24 characters Allowed characters: lowercase letters, numbers, and hyphens Must begin with a lowercase letter\. Must end with a lower case letter or a number\.  | 
|  `regionsNotSupported`  |  Yes  |  Which of the following AWS Regions do you not support? In other words, in which Regions should Security Hub not show you as an option in our partners page in the Security Hub console? Type: String Provide the Region code only\. For example, `us-west-1`\. For a list of Regions, see [Regional endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#regional-endpoints) in the *AWS General Reference*\. The Region codes for the AWS GovCloud \(US\) are `us-gov-west-1` \(for AWS GovCloud \(US\-West\)\) and `us-gov-east-1` \(for AWS GovCloud \(US\-East\)\)\. The Region codes for China Regions are `cn-north-1` \(for China \(Beijing\)\) and `cn-northwest-1` \(for China \(Ningxia\)\)\.  | 
|  `commercialAccountNumber`  |  Yes  |  The primary AWS account number for the product for the AWS Regions\. If you send findings to Security Hub, then the account you provide is based on where you send the findings from\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html) Ideally you will use the same account for all of your products across all Regions\. If this is not possible, contact the Security Hub team\. If you only receive findings from Security Hub, this account number is not required\. Type: String  | 
|  `govcloudAccountNumber`  |  No  |  The primary AWS account number for the product for AWS GovCloud \(US\) Regions \(if your product is available in AWS GovCloud \(US\)\)\. If you send findings to Security Hub, then the account you provide is based on where you send the findings from\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html) Ideally you use the same account for all of your products across all AWS GovCloud \(US\) Regions\. If this is not possible, contact the Security Hub team\. If you only receive findings from Security Hub, this account number is not required\.  Type: String  | 
|  `chinaAccountNumber`  |  No  |  The primary AWS account number for the product for China regions \(if your product is available in the China regions\)\. If you send findings to Security Hub, then the account you provide is based on where you send the findings from\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html) Ideally you use the same account for all of your products across all China regions\. If this is not possible, contact the Security Hub team\. If you only receive findings from Security Hub, this can be any account that you own in a China region\. Type: String  | 
|  `name`  |  Yes  |  The name of the provider's product to display on the Security Hub console\. Type: String Maximum length: 24 characters  | 
|  `description`  |  Yes  |  The description of the provider's product to display on the Security Hub console\. Type: String Maximum length: 200 characters  | 
|  `importType`  |  Yes  |  The type of resource policy for the partner\. During the partner onboarding process, you can specify one of the following resource policies, or you can specify `NEITHER`\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html) Type: String Valid values:` BATCH_IMPORT_FINDINGS_FROM_PRODUCT_ACCOUNT` \| `BATCH_IMPORT_FINDINGS_FROM_CUSTOMER_ACCOUNT` \|  `NEITHER`  | 
|  `category`  |  Yes  |  The categories that define your product\. Your selections are displayed on the Security Hub console\. Choose up to three categories\. Custom selections are not allowed\. If you think your category is missing, contact the Security Hub team\. Type: Array Available categories: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html)  | 
|  `marketplaceUrl`  |  No  |  The URL to your product AWS Marketplace destination\. The URL is displayed in the Security Hub console\. Type: String This must be an AWS Marketplace URL\. If you do not have an AWS Marketplace listing, leave this field blank\.  | 
|  `configurationUrl`  |  Yes  |  The URL to your product documentation about the integration with Security Hub\. This content is hosted on your website or on a webpage that you manage, such as a GitHub page\. Type: String Your documentation should include the following information\. [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/securityhub/latest/partnerguide/manifest-console-information.html)  | 