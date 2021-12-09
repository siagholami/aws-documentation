# EventTracker<a name="API_EventTracker"></a>

Provides information about an event tracker\.

## Contents<a name="API_EventTracker_Contents"></a>

 **accountId**   <a name="personalize-Type-EventTracker-accountId"></a>
The Amazon AWS account that owns the event tracker\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **creationDateTime**   <a name="personalize-Type-EventTracker-creationDateTime"></a>
The date and time \(in Unix format\) that the event tracker was created\.  
Type: Timestamp  
Required: No

 **datasetGroupArn**   <a name="personalize-Type-EventTracker-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that receives the event data\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **eventTrackerArn**   <a name="personalize-Type-EventTracker-eventTrackerArn"></a>
The ARN of the event tracker\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 **lastUpdatedDateTime**   <a name="personalize-Type-EventTracker-lastUpdatedDateTime"></a>
The date and time \(in Unix time\) that the event tracker was last updated\.  
Type: Timestamp  
Required: No

 **name**   <a name="personalize-Type-EventTracker-name"></a>
The name of the event tracker\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: No

 **status**   <a name="personalize-Type-EventTracker-status"></a>
The status of the event tracker\.  
An event tracker can be in one of the following states:  
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

 **trackingId**   <a name="personalize-Type-EventTracker-trackingId"></a>
The ID of the event tracker\. Include this ID in requests to the [PutEvents](https://docs.aws.amazon.com/personalize/latest/dg/API_UBS_PutEvents.html) API\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Required: No

## See Also<a name="API_EventTracker_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/EventTracker) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/EventTracker) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/EventTracker) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/EventTracker) 