# EventTrackerSummary<a name="API_EventTrackerSummary"></a>

Provides a summary of the properties of an event tracker\. For a complete listing, call the [DescribeEventTracker](API_DescribeEventTracker.md) API\.

## Contents<a name="API_EventTrackerSummary_Contents"></a>

 **creationDateTime**   <a name="personalize-Type-EventTrackerSummary-creationDateTime"></a>
The date and time \(in Unix time\) that the event tracker was created\.  
Type: Timestamp  
Required: No

 **eventTrackerArn**   <a name="personalize-Type-EventTrackerSummary-eventTrackerArn"></a>
The Amazon Resource Name \(ARN\) of the event tracker\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-EventTrackerSummary-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the event tracker was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-EventTrackerSummary-name"></a>
The name of the event tracker\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-EventTrackerSummary-status"></a>
The status of the event tracker\.  
An event tracker can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_EventTrackerSummary_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/EventTrackerSummary) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/EventTrackerSummary) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/EventTrackerSummary) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/EventTrackerSummary) 