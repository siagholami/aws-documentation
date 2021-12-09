--------

--------

# SalesforceConfiguration<a name="API_SalesforceConfiguration"></a>

Provides configuration information for connecting to a Salesforce data source\.

## Contents<a name="API_SalesforceConfiguration_Contents"></a>

 **ChatterFeedConfiguration**   <a name="Kendra-Type-SalesforceConfiguration-ChatterFeedConfiguration"></a>
Specifies configuration information for Salesforce chatter feeds\.  
Type: [SalesforceChatterFeedConfiguration](API_SalesforceChatterFeedConfiguration.md) object  
Required: No

 **CrawlAttachments**   <a name="Kendra-Type-SalesforceConfiguration-CrawlAttachments"></a>
Indicates whether Amazon Kendra should index attachments to Salesforce objects\.  
Type: Boolean  
Required: No

 **ExcludeAttachmentFilePatterns**   <a name="Kendra-Type-SalesforceConfiguration-ExcludeAttachmentFilePatterns"></a>
A list of regular expression patterns\. Documents that match the patterns are excluded from the index\. Documents that don't match the patterns are included in the index\. If a document matches both an exclusion pattern and an inclusion pattern, the document is not included in the index\.  
The regex is applied to the name of the attached file\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **IncludeAttachmentFilePatterns**   <a name="Kendra-Type-SalesforceConfiguration-IncludeAttachmentFilePatterns"></a>
A list of regular expression patterns\. Documents that match the patterns are included in the index\. Documents that don't match the patterns are excluded from the index\. If a document matches both an inclusion pattern and an exclusion pattern, the document is not included in the index\.  
The regex is applied to the name of the attached file\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **KnowledgeArticleConfiguration**   <a name="Kendra-Type-SalesforceConfiguration-KnowledgeArticleConfiguration"></a>
Specifies configuration information for the knowlege article types that Amazon Kendra indexes\. Amazon Kendra indexes standard knowledge articles and the standard fields of knowledge articles, or the custom fields of custom knowledge articles, but not both\.  
Type: [SalesforceKnowledgeArticleConfiguration](API_SalesforceKnowledgeArticleConfiguration.md) object  
Required: No

 **SecretArn**   <a name="Kendra-Type-SalesforceConfiguration-SecretArn"></a>
The Amazon Resource Name \(ARN\) of an AWS Secrets Manager secret that contains the key/value pairs required to connect to your Salesforce instance\. The secret must contain a JSON structure with the following keys:  
+ authenticationUrl \- The OAUTH endpoint that Amazon Kendra connects to get an OAUTH token\. 
+ consumerKey \- The application public key generated when you created your Salesforce application\.
+ consumerSecret \- The application private key generated when you created your Salesforce application\.
+ password \- The password associated with the user logging in to the Salesforce instance\.
+ securityToken \- The token associated with the user account logging in to the Salesforce instance\.
+ username \- The user name of the user logging in to the Salesforce instance\.
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 **ServerUrl**   <a name="Kendra-Type-SalesforceConfiguration-ServerUrl"></a>
The instance URL for the Salesforce site that you want to index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^(https?|ftp|file):\/\/([^\s]*)`   
Required: Yes

 **StandardObjectAttachmentConfiguration**   <a name="Kendra-Type-SalesforceConfiguration-StandardObjectAttachmentConfiguration"></a>
Provides configuration information for processing attachments to Salesforce standard objects\.   
Type: [SalesforceStandardObjectAttachmentConfiguration](API_SalesforceStandardObjectAttachmentConfiguration.md) object  
Required: No

 **StandardObjectConfigurations**   <a name="Kendra-Type-SalesforceConfiguration-StandardObjectConfigurations"></a>
Specifies the Salesforce standard objects that Amazon Kendra indexes\.  
Type: Array of [SalesforceStandardObjectConfiguration](API_SalesforceStandardObjectConfiguration.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 17 items\.  
Required: No

## See Also<a name="API_SalesforceConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceConfiguration) 