--------

--------

# SalesforceStandardKnowledgeArticleTypeConfiguration<a name="API_SalesforceStandardKnowledgeArticleTypeConfiguration"></a>

Provides configuration information for standard Salesforce knowledge articles\.

## Contents<a name="API_SalesforceStandardKnowledgeArticleTypeConfiguration_Contents"></a>

 **DocumentDataFieldName**   <a name="Kendra-Type-SalesforceStandardKnowledgeArticleTypeConfiguration-DocumentDataFieldName"></a>
The name of the field that contains the document data to index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DocumentTitleFieldName**   <a name="Kendra-Type-SalesforceStandardKnowledgeArticleTypeConfiguration-DocumentTitleFieldName"></a>
The name of the field that contains the document title\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **FieldMappings**   <a name="Kendra-Type-SalesforceStandardKnowledgeArticleTypeConfiguration-FieldMappings"></a>
One or more objects that map fields in the knowledge article to Amazon Kendra index fields\. The index field must exist before you can map a Salesforce field to it\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

## See Also<a name="API_SalesforceStandardKnowledgeArticleTypeConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceStandardKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceStandardKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceStandardKnowledgeArticleTypeConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceStandardKnowledgeArticleTypeConfiguration) 