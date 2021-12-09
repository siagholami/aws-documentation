--------

--------

# ServiceNowServiceCatalogConfiguration<a name="API_ServiceNowServiceCatalogConfiguration"></a>

Provides configuration information for crawling service catalog items in the ServiceNow site

## Contents<a name="API_ServiceNowServiceCatalogConfiguration_Contents"></a>

 **CrawlAttachments**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-CrawlAttachments"></a>
Indicates whether Amazon Kendra should crawl attachments to the service catalog items\.   
Type: Boolean  
Required: No

 **DocumentDataFieldName**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-DocumentDataFieldName"></a>
The name of the ServiceNow field that is mapped to the index document contents field in the Amazon Kendra index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DocumentTitleFieldName**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-DocumentTitleFieldName"></a>
The name of the ServiceNow field that is mapped to the index document title field\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **ExcludeAttachmentFilePatterns**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-ExcludeAttachmentFilePatterns"></a>
Determines the types of file attachments that are excluded from the index\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **FieldMappings**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-FieldMappings"></a>
Mapping between ServiceNow fields and Amazon Kendra index fields\. You must create the index field before you map the field\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **IncludeAttachmentFilePatterns**   <a name="Kendra-Type-ServiceNowServiceCatalogConfiguration-IncludeAttachmentFilePatterns"></a>
Determines the types of file attachments that are included in the index\.   
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

## See Also<a name="API_ServiceNowServiceCatalogConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ServiceNowServiceCatalogConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ServiceNowServiceCatalogConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ServiceNowServiceCatalogConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ServiceNowServiceCatalogConfiguration) 