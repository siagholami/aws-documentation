--------

--------

# ColumnConfiguration<a name="API_ColumnConfiguration"></a>

Provides information about how Amazon Kendra should use the columns of a database in an index\.

## Contents<a name="API_ColumnConfiguration_Contents"></a>

 **ChangeDetectingColumns**   <a name="Kendra-Type-ColumnConfiguration-ChangeDetectingColumns"></a>
One to five columns that indicate when a document in the database has changed\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 5 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

 **DocumentDataColumnName**   <a name="Kendra-Type-ColumnConfiguration-DocumentDataColumnName"></a>
The column that contains the contents of the document\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

 **DocumentIdColumnName**   <a name="Kendra-Type-ColumnConfiguration-DocumentIdColumnName"></a>
The column that provides the document's unique identifier\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: Yes

 **DocumentTitleColumnName**   <a name="Kendra-Type-ColumnConfiguration-DocumentTitleColumnName"></a>
The column that contains the title of the document\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*$`   
Required: No

 **FieldMappings**   <a name="Kendra-Type-ColumnConfiguration-FieldMappings"></a>
An array of objects that map database column names to the corresponding fields in an index\. You must first create the fields in the index using the [UpdateIndex](API_UpdateIndex.md) operation\.  
Type: Array of [DataSourceToIndexFieldMapping](API_DataSourceToIndexFieldMapping.md) objects  
Array Members: Minimum number of 1 item\. Maximum number of 100 items\.  
Required: No

## See Also<a name="API_ColumnConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/ColumnConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/ColumnConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/ColumnConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/ColumnConfiguration) 