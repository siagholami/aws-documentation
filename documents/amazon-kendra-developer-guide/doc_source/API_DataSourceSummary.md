--------

--------

# DataSourceSummary<a name="API_DataSourceSummary"></a>

Summary information for a Amazon Kendra data source\. Returned in a call to [DescribeDataSource](API_DescribeDataSource.md)\.

## Contents<a name="API_DataSourceSummary_Contents"></a>

 **CreatedAt**   <a name="Kendra-Type-DataSourceSummary-CreatedAt"></a>
The UNIX datetime that the data source was created\.  
Type: Timestamp  
Required: No

 **Id**   <a name="Kendra-Type-DataSourceSummary-Id"></a>
The unique identifier for the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 100\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: No

 **Name**   <a name="Kendra-Type-DataSourceSummary-Name"></a>
The name of the data source\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1000\.  
Pattern: `[a-zA-Z0-9][a-zA-Z0-9_-]*`   
Required: No

 **Status**   <a name="Kendra-Type-DataSourceSummary-Status"></a>
The status of the data source\. When the status is `ATIVE` the data source is ready to use\.  
Type: String  
Valid Values:` CREATING | DELETING | FAILED | UPDATING | ACTIVE`   
Required: No

 **Type**   <a name="Kendra-Type-DataSourceSummary-Type"></a>
The type of the data source\.  
Type: String  
Valid Values:` S3 | SHAREPOINT | DATABASE | SALESFORCE | ONEDRIVE | SERVICENOW`   
Required: No

 **UpdatedAt**   <a name="Kendra-Type-DataSourceSummary-UpdatedAt"></a>
The UNIX datetime that the data source was lasted updated\.   
Type: Timestamp  
Required: No

## See Also<a name="API_DataSourceSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kendra-2019-02-03/DataSourceSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kendra-2019-02-03/DataSourceSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kendra-2019-02-03/DataSourceSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kendra-2019-02-03/DataSourceSummary) 