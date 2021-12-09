--------

--------

# SalesforceKnowledgeArticleConfiguration<a name="API_SalesforceKnowledgeArticleConfiguration"></a>

Specifies configuration information for the knowlege article types that Amazon Kendra indexes\. Amazon Kendra indexes standard knowledge articles and the standard fields of knowledge articles, or the custom fields of custom knowledge articles, but not both 

## Contents<a name="API_SalesforceKnowledgeArticleConfiguration_Contents"></a>

 **CustomKnowledgeArticleTypeConfigurations**   <a name="Kendra-Type-SalesforceKnowledgeArticleConfiguration-CustomKnowledgeArticleTypeConfigurations"></a>
Provides configuration information for custom Salesforce knowledge articles\.  
Type: Array of [SalesforceCustomKnowledgeArticleTypeConfiguration](API_SalesforceCustomKnowledgeArticleTypeConfiguration.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 10 items\.  
Required: No

 **IncludedStates**   <a name="Kendra-Type-SalesforceKnowledgeArticleConfiguration-IncludedStates"></a>
Specifies the document states that should be included when Amazon Kendra indexes knowledge articles\. You must specify at least one state\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 3 items\.  
Valid Values:` DRAFT | PUBLISHED | ARCHIVED`   
Required: Yes

 **StandardKnowledgeArticleTypeConfiguration**   <a name="Kendra-Type-SalesforceKnowledgeArticleConfiguration-StandardKnowledgeArticleTypeConfiguration"></a>
Provides configuration information for standard Salesforce knowledge articles\.  
Type: [SalesforceStandardKnowledgeArticleTypeConfiguration](API_SalesforceStandardKnowledgeArticleTypeConfiguration.md) object  
Required: No

## See Also<a name="API_SalesforceKnowledgeArticleConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceKnowledgeArticleConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceKnowledgeArticleConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceKnowledgeArticleConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceKnowledgeArticleConfiguration) 