--------

--------

# SharePointConfiguration<a name="API_SharePointConfiguration"></a>

Provides configuration information for connecting to a Microsoft SharePoint data source\.

## Contents<a name="API_SharePointConfiguration_Contents"></a>

 **CrawlAttachments**   <a name="Kendra-Type-SharePointConfiguration-CrawlAttachments"></a>
 `TRUE` to include attachments to documents stored in your Microsoft SharePoint site in the index; otherwise, `FALSE`\.  
Type: Boolean  
Required: No

 **DocumentTitleFieldName**   <a name="Kendra-Type-SharePointConfiguration-DocumentTitleFieldName"></a>
The Microsoft SharePoint attribute field that contains the title of the document\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: No

 **ExclusionPatterns**   <a name="Kendra-Type-SharePointConfiguration-ExclusionPatterns"></a>
A list of regular expression patterns\. Documents that match the patterns are excluded from the index\. Documents that don't match the patterns are included in the index\. If a document matches both an exclusion pattern and an inclusion pattern, the document is not included in the index\.  
The regex is applied to the display URL of the SharePoint document\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **FieldMappings**   <a name="Kendra-Type-SharePointConfiguration-FieldMappings"></a>
A list of `DataSourceToIndexFieldMapping` objects that map Microsoft SharePoint attributes to custom fields in the Amazon Kendra index\. You must first create the index fields using the [UpdateIndex](API_UpdateIndex.md) operation before you map SharePoint attributes\. For more information, see [Mapping Data Source Fields](https://docs.aws.amazon.com/kendra/latest/dg/field-mapping.html)\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

 **InclusionPatterns**   <a name="Kendra-Type-SharePointConfiguration-InclusionPatterns"></a>
A list of regular expression patterns\. Documents that match the patterns are included in the index\. Documents that don't match the patterns are excluded from the index\. If a document matches both an inclusion pattern and an exclusion pattern, the document is not included in the index\.  
The regex is applied to the display URL of the SharePoint document\.  
Type: Array of strings  
Array Members: Minimum number of 0 items\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 50\.  
Required: No

 **SecretArn**   <a name="Kendra-Type-SharePointConfiguration-SecretArn"></a>
The Amazon Resource Name \(ARN\) of credentials stored in AWS Secrets Manager\. The credentials should be a user/password pair\. For more information, see [Using a Microsoft SharePoint Data Source](https://docs.aws.amazon.com/kendra/latest/dg/data-source-sharepoint.html)\. For more information about AWS Secrets Manager, see [ What Is AWS Secrets Manager ](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html) in the *AWS Secrets Manager* user guide\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1284\.  
Pattern: `arn:[a-z0-9-\.]{1,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[a-z0-9-\.]{0,63}:[^/].{0,1023}`   
Required: Yes

 **SharePointVersion**   <a name="Kendra-Type-SharePointConfiguration-SharePointVersion"></a>
The version of Microsoft SharePoint that you are using as a data source\.  
Type: String  
Valid Values:` SHAREPOINT_ONLINE`   
Required: Yes

 **Urls**   <a name="Kendra-Type-SharePointConfiguration-Urls"></a>
The URLs of the Microsoft SharePoint site that contains the documents that should be indexed\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 2048\.  
Pattern: `^(https?|ftp|file):\/\/([^\s]*)`   
Required: Yes

 **UseChangeLog**   <a name="Kendra-Type-SharePointConfiguration-UseChangeLog"></a>
Set to `TRUE` to use the Microsoft SharePoint change log to determine the documents that need to be updated in the index\. Depending on the size of the SharePoint change log, it may take longer for Amazon Kendra to use the change log than it takes it to determine the changed documents using the Amazon Kendra document crawler\.  
Type: Boolean  
Required: No

 **VpcConfiguration**   <a name="Kendra-Type-SharePointConfiguration-VpcConfiguration"></a>
Provides information for connecting to an Amazon VPC\.  
Type: [DataSourceVpcConfiguration](API_DataSourceVpcConfiguration.md) object  
Required: No

## See Also<a name="API_SharePointConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SharePointConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SharePointConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SharePointConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SharePointConfiguration) 