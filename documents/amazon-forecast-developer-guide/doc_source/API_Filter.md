# Filter<a name="API_Filter"></a>

Describes a filter for choosing a subset of objects\. Each filter consists of a condition and a match statement\. The condition is either `IS` or `IS_NOT`, which specifies whether to include or exclude the objects that match the statement, respectively\. The match statement consists of a key and a value\.

## Contents<a name="API_Filter_Contents"></a>

 **Condition**   <a name="forecast-Type-Filter-Condition"></a>
The condition to apply\. To include the objects that match the statement, specify `IS`\. To exclude matching objects, specify `IS_NOT`\.  
Type: String  
Valid Values:` IS | IS_NOT`   
Required: Yes

 **Key**   <a name="forecast-Type-Filter-Key"></a>
The name of the parameter to filter on\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\_]+$`   
Required: Yes

 **Value**   <a name="forecast-Type-Filter-Value"></a>
The value to match\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `^[a-zA-Z0-9\-\_\.\/\:]+$`   
Required: Yes

## See Also<a name="API_Filter_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/forecast-2018-06-26/Filter) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/forecast-2018-06-26/Filter) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/forecast-2018-06-26/Filter) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/forecast-2018-06-26/Filter) 