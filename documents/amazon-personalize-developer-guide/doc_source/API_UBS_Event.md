# Event<a name="API_UBS_Event"></a>

Represents user interaction event information sent using the `PutEvents` API\.

## Contents<a name="API_UBS_Event_Contents"></a>

 **eventId**   <a name="personalize-Type-UBS_Event-eventId"></a>
An ID associated with the event\. If an event ID is not provided, Amazon Personalize generates a unique ID for the event\. An event ID is not used as an input to the model\. Amazon Personalize uses the event ID to distinquish unique events\. Any subsequent events after the first with the same event ID are not used in model training\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Required: No

 **eventType**   <a name="personalize-Type-UBS_Event-eventType"></a>
The type of event, such as click or download\. This property corresponds to the `EVENT_TYPE` field of your Interactions schema and depends on the types of events you are tracking\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Required: Yes

 **eventValue**   <a name="personalize-Type-UBS_Event-eventValue"></a>
The event value that corresponds to the `EVENT_VALUE` field of the Interactions schema\.  
Type: Float  
Required: No

 **impression**   <a name="personalize-Type-UBS_Event-impression"></a>
A list of item IDs that represents the sequence of items you have shown the user\. For example, `["itemId1", "itemId2", "itemId3"]`\.  
Type: Array of strings  
Array Members: Minimum number of 1 item\. Maximum number of 25 items\.  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Required: No

 **itemId**   <a name="personalize-Type-UBS_Event-itemId"></a>
The item ID key that corresponds to the `ITEM_ID` field of the Interactions schema\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Required: No

 **properties**   <a name="personalize-Type-UBS_Event-properties"></a>
A string map of event\-specific data that you might choose to record\. For example, if a user rates a movie on your site, other than movie ID \(`itemId`\) and rating \(`eventValue`\) , you might also send the number of movie ratings made by the user\.  
Each item in the map consists of a key\-value pair\. For example,  
 `{"numberOfRatings": "12"}`   
The keys use camel case names that match the fields in the Interactions schema\. In the above example, the `numberOfRatings` would match the 'NUMBER\_OF\_RATINGS' field defined in the Interactions schema\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Required: No

 **recommendationId**   <a name="personalize-Type-UBS_Event-recommendationId"></a>
The ID of the recommendation\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 40\.  
Required: No

 **sentAt**   <a name="personalize-Type-UBS_Event-sentAt"></a>
The timestamp \(in Unix time\) on the client side when the event occurred\.  
Type: Timestamp  
Required: Yes

## See Also<a name="API_UBS_Event_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-events-2018-03-22/Event) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-events-2018-03-22/Event) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-events-2018-03-22/Event) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-events-2018-03-22/Event) 