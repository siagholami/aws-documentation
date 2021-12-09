--------

--------

# DataSourceToIndexFieldMapping<a name="API_DataSourceToIndexFieldMapping"></a>

Maps a column or attribute in the data source to an index field\. You must first create the fields in the index using the [UpdateIndex](API_UpdateIndex.md) operation\.

## Contents<a name="API_DataSourceToIndexFieldMapping_Contents"></a>

 **DataSourceFieldName**   <a name="Kendra-Type-DataSourceToIndexFieldMapping-DataSourceFieldName"></a>
The name of the column or attribute in the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_.]*$`   
Required: Yes

 **DateFieldFormat**   <a name="Kendra-Type-DataSourceToIndexFieldMapping-DateFieldFormat"></a>
The type of data stored in the column or attribute\.  
Type: String  
Length Constraints: Minimum length of 4\. Maximum length of 40\.  
Pattern: `^(?!\s).*(?<!\s)$`   
Required: No

 **IndexFieldName**   <a name="Kendra-Type-DataSourceToIndexFieldMapping-IndexFieldName"></a>
The name of the field in the index\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 30\.  
Pattern: `^\P{C}*$`   
Required: Yes

## See Also<a name="API_DataSourceToIndexFieldMapping_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DataSourceToIndexFieldMapping) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DataSourceToIndexFieldMapping) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DataSourceToIndexFieldMapping) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DataSourceToIndexFieldMapping) 