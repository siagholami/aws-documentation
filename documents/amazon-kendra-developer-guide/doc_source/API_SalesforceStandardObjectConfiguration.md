--------

--------

# SalesforceStandardObjectConfiguration<a name="API_SalesforceStandardObjectConfiguration"></a>

Specifies confguration information for indexing a single standard object\.

## Contents<a name="API_SalesforceStandardObjectConfiguration_Contents"></a>

 **DocumentDataFieldName**   <a name="Kendra-Type-SalesforceStandardObjectConfiguration-DocumentDataFieldName"></a>
The name of the field in the standard object table that contains the document contents\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DocumentTitleFieldName**   <a name="Kendra-Type-SalesforceStandardObjectConfiguration-DocumentTitleFieldName"></a>
The name of the field in the standard object table that contains the document titleB\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **FieldMappings**   <a name="Kendra-Type-SalesforceStandardObjectConfiguration-FieldMappings"></a>
One or more objects that map fields in the standard object to Amazon Kendra index fields\. The index field must exist before you can map a Salesforce field to it\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **Name**   <a name="Kendra-Type-SalesforceStandardObjectConfiguration-Name"></a>
The name of the standard object\.  
Type: String  
Valid Values:` ACCOUNT | CAMPAIGN | CASE | CONTACT | CONTRACT | DOCUMENT | GROUP | IDEA | LEAD | OPPORTUNITY | PARTNER | PRICEBOOK | PRODUCT | PROFILE | SOLUTION | TASK | USER`   
Required: Yes

## See Also<a name="API_SalesforceStandardObjectConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceStandardObjectConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceStandardObjectConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceStandardObjectConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceStandardObjectConfiguration) 