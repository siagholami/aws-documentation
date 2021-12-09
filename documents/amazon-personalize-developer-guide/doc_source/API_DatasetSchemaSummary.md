# DatasetSchemaSummary<a name="API_DatasetSchemaSummary"></a>

Provides a summary of the properties of a dataset schema\. For a complete listing, call the [DescribeSchema](API_DescribeSchema.md) API\.

## Contents<a name="API_DatasetSchemaSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-DatasetSchemaSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the schema was created\.  
Type: Timestamp  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-DatasetSchemaSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the schema was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-DatasetSchemaSummary-name"></a>
The name of the schema\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **schemaArn**   <a name="personalize-Type-DatasetSchemaSummary-schemaArn"></a>
The Amazon Resource Name \(ARN\) of the schema\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

## See Also<a name="API_DatasetSchemaSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DatasetSchemaSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DatasetSchemaSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DatasetSchemaSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DatasetSchemaSummary) 