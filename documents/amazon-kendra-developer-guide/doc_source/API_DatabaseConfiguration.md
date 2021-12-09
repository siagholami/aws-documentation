--------

--------

# DatabaseConfiguration<a name="API_DatabaseConfiguration"></a>

Provides the information necessary to connect a database to an index\. 

## Contents<a name="API_DatabaseConfiguration_Contents"></a>

 **AclConfiguration**   <a name="Kendra-Type-DatabaseConfiguration-AclConfiguration"></a>
Information about the database column that provides information for user context filtering\.  
Type: [AclConfiguration](API_AclConfiguration.md) object  
Required: No

 **ColumnConfiguration**   <a name="Kendra-Type-DatabaseConfiguration-ColumnConfiguration"></a>
Information about where the index should get the document information from the database\.  
Type: [ColumnConfiguration](API_ColumnConfiguration.md) object  
Required: Yes

 **ConnectionConfiguration**   <a name="Kendra-Type-DatabaseConfiguration-ConnectionConfiguration"></a>
The information necessary to connect to a database\.  
Type: [ConnectionConfiguration](API_ConnectionConfiguration.md) object  
Required: Yes

 **DatabaseEngineType**   <a name="Kendra-Type-DatabaseConfiguration-DatabaseEngineType"></a>
The type of database engine that runs the database\.  
Type: String  
Valid Values:` RDS_AURORA_MYSQL | RDS_AURORA_POSTGRESQL | RDS_MYSQL | RDS_POSTGRESQL`   
Required: Yes

 **SqlConfiguration**   <a name="Kendra-Type-DatabaseConfiguration-SqlConfiguration"></a>
Provides information about how Amazon Kendra uses quote marks around SQL identifiers when querying a database data source\.  
Type: [SqlConfiguration](API_SqlConfiguration.md) object  
Required: No

 **VpcConfiguration**   <a name="Kendra-Type-DatabaseConfiguration-VpcConfiguration"></a>
Provides information for connecting to an Amazon VPC\.  
Type: [DataSourceVpcConfiguration](API_DataSourceVpcConfiguration.md) object  
Required: No

## See Also<a name="API_DatabaseConfiguration_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DatabaseConfiguration) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DatabaseConfiguration) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DatabaseConfiguration) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DatabaseConfiguration) 