# Filter<a name="API_Filter"></a>

Contains information on a recommendation filter, including its ARN, status, and filter expression\.

## Contents<a name="API_Filter_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-Filter-creationDateTime"></a>
The time at which the filter was created\.  
Type: Timestamp  
Required: No

 **datasetGroupArn**   <a name="personalize-Type-Filter-datasetGroupArn"></a>
The ARN of the dataset group to which the filter belongs\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **failureReason**   <a name="personalize-Type-Filter-failureReason"></a>
If the filter failed, the reason for its failure\.  
Type: String  
Required: No

 **filterArn**   <a name="personalize-Type-Filter-filterArn"></a>
The ARN of the filter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **filterExpression**   <a name="personalize-Type-Filter-filterExpression"></a>
Specifies the type of item interactions to filter out of recommendation results\. The filter expression must follow the following format:  
 `EXCLUDE itemId WHERE INTERACTIONS.event_type in ("EVENT_TYPE")`   
Where "EVENT\_TYPE" is the type of event to filter out\. For more information, see [Using Filters with Amazon Personalize](https://docs.aws.amazon.com/personalize/latest/dg/filters.html)\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 2500\.  
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-Filter-lastUpdatedDateTime"></a>
The time at which the filter was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-Filter-name"></a>
The name of the filter\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-Filter-status"></a>
The status of the filter\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_Filter_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/Filter) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/Filter) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/Filter) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/Filter) 