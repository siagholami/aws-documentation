--------

--------

# SalesforceChatterFeedConfiguration<a name="API_SalesforceChatterFeedConfiguration"></a>

Defines configuration for syncing a Salesforce chatter feed\. The contents of the object comes from the Salesforce FeedItem table\.

## Contents<a name="API_SalesforceChatterFeedConfiguration_Contents"></a>

 **DocumentDataFieldName**   <a name="Kendra-Type-SalesforceChatterFeedConfiguration-DocumentDataFieldName"></a>
The name of the column in the Salesforce FeedItem table that contains the content to index\. Typically this is the `Body` column\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DocumentTitleFieldName**   <a name="Kendra-Type-SalesforceChatterFeedConfiguration-DocumentTitleFieldName"></a>
The name of the column in the Salesforce FeedItem table that contains the title of the document\. This is typically the `Title` collumn\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **FieldMappings**   <a name="Kendra-Type-SalesforceChatterFeedConfiguration-FieldMappings"></a>
Maps fields from a Salesforce chatter feed into Amazon Kendra index fields\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **IncludeFilterTypes**   <a name="Kendra-Type-SalesforceChatterFeedConfiguration-IncludeFilterTypes"></a>
Filters the documents in the feed based on status of the user\. When you specify `ACTIVE_USERS` only documents from users who have an active account are indexed\. When you specify `STANDARD_USER` only documents for Salesforce standard users are documented\. You can specify both\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 2 items\.  
Valid Values:` ACTIVE_USER | STANDARD_USER`   
Required: No

## See Also<a name="API_SalesforceChatterFeedConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SalesforceChatterFeedConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SalesforceChatterFeedConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SalesforceChatterFeedConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SalesforceChatterFeedConfiguration) 