# SchemaAttribute<a name="API_SchemaAttribute"></a>

An attribute of a schema, which defines a dataset field\. A schema attribute is required for every field in a dataset\. The [Schema](API_Schema.md) object contains an array of `SchemaAttribute` objects\.

## Contents<a name="API_SchemaAttribute_Contents"></a>

 **AttributeName**   <a name="forecast-Type-SchemaAttribute-AttributeName"></a>
The name of the dataset field\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z][a-zA-Z0-9_]*`   
Required: No

 **AttributeType**   <a name="forecast-Type-SchemaAttribute-AttributeType"></a>
The data type of the field\.  
Type: String  
Valid Values:` string | integer | float | timestamp`   
Required: No

## See Also<a name="API_SchemaAttribute_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/SchemaAttribute) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/SchemaAttribute) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/SchemaAttribute) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/SchemaAttribute) 