--------

--------

# SalesforceCustomKnowledgeArticleTypeConfiguration<a name="API_SalesforceCustomKnowledgeArticleTypeConfiguration"></a>

Provides configuration information for indexing Salesforce custom articles\.

## Contents<a name="API_SalesforceCustomKnowledgeArticleTypeConfiguration_Contents"></a>

 **DocumentDataFieldName**   <a name="Kendra-Type-SalesforceCustomKnowledgeArticleTypeConfiguration-DocumentDataFieldName"></a>
The name of the field in the custom knowledge article that contains the document data to index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DocumentTitleFieldName**   <a name="Kendra-Type-SalesforceCustomKnowledgeArticleTypeConfiguration-DocumentTitleFieldName"></a>
The name of the field in the custom knowledge article that contains the document title\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **FieldMappings**   <a name="Kendra-Type-SalesforceCustomKnowledgeArticleTypeConfiguration-FieldMappings"></a>
One or more objects that map fields in the custom knowledge article to fields in the Amazon Kendra index\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **Name**   <a name="Kendra-Type-SalesforceCustomKnowledgeArticleTypeConfiguration-Name"></a>
The name of the configuration\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

## See Also<a name="API_SalesforceCustomKnowledgeArticleTypeConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceCustomKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceCustomKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceCustomKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceCustomKnowledgeArticleTypeConfiguration) 