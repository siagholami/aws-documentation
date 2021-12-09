# FilterSummary<a name="API_FilterSummary"></a>

A short summary of a filter's attributes\.

## Contents<a name="API_FilterSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-FilterSummary-creationDateTime"></a>
The time at which the filter was created\.  
Type: Timestamp  
Required: No

 **datasetGroupArn**   <a name="personalize-Type-FilterSummary-datasetGroupArn"></a>
The ARN of the dataset group to which the filter belongs\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **failureReason**   <a name="personalize-Type-FilterSummary-failureReason"></a>
If the filter failed, the reason for the failure\.  
Type: String  
Required: No

 **filterArn**   <a name="personalize-Type-FilterSummary-filterArn"></a>
The ARN of the filter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-FilterSummary-lastUpdatedDateTime"></a>
The time at which the filter was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-FilterSummary-name"></a>
The name of the filter\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-FilterSummary-status"></a>
The status of the filter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_FilterSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/FilterSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/FilterSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/FilterSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/FilterSummary) 