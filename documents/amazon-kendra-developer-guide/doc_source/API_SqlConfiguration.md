--------

--------

# SqlConfiguration<a name="API_SqlConfiguration"></a>

Provides information that configures Amazon Kendra to use a SQL database\.

## Contents<a name="API_SqlConfiguration_Contents"></a>

 **QueryIdentifiersEnclosingOption**   <a name="Kendra-Type-SqlConfiguration-QueryIdentifiersEnclosingOption"></a>
Determines whether Amazon Kendra encloses SQL identifiers for tables and column names in double quotes \("\) when making a database query\.  
By default, Amazon Kendra passes SQL identifiers the way that they are entered into the data source configuration\. It does not change the case of identifiers or enclose them in quotes\.  
PostgreSQL internally converts uppercase characters to lower case characters in identifiers unless they are quoted\. Choosing this option encloses identifiers in quotes so that PostgreSQL does not convert the character's case\.  
For MySQL databases, you must enable the `ansi_quotes` option when you set this field to `DOUBLE_QUOTES`\.  
Type: String  
Valid Values:` DOUBLE_QUOTES | NONE`   
Required: No

## See Also<a name="API_SqlConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/SqlConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/SqlConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/SqlConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/SqlConfiguration) 