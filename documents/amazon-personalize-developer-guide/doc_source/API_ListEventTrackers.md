# ListEventTrackers<a name="API_ListEventTrackers"></a>

Returns the list of event trackers associated with the account\. The response provides the properties for each event tracker, including the Amazon Resource Name \(ARN\) and tracking ID\. For more information on event trackers, see [CreateEventTracker](API_CreateEventTracker.md)\.

## Request Syntax<a name="API_ListEventTrackers_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "maxResults": number,
   "nextToken": "string"
}
```

## Request Parameters<a name="API_ListEventTrackers_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_ListEventTrackers_RequestSyntax) **   <a name="personalize-ListEventTrackers-request-datasetGroupArn"></a>
The ARN of a dataset group used to filter the response\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: No

 ** [maxResults](#API_ListEventTrackers_RequestSyntax) **   <a name="personalize-ListEventTrackers-request-maxResults"></a>
The maximum number of event trackers to return\.  
Type: Integer  
Valid Range: Minimum value of 1\. Maximum value of 100\.  
Required: No

 ** [nextToken](#API_ListEventTrackers_RequestSyntax) **   <a name="personalize-ListEventTrackers-request-nextToken"></a>
A token returned from the previous call to `ListEventTrackers` for getting the next set of event trackers \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.  
Required: No

## Response Syntax<a name="API_ListEventTrackers_ResponseSyntax"></a>

```
{
   "eventTrackers": [ 
      { 
         "creationDateTime": number,
         "eventTrackerArn": "string",
         "lastUpdatedDateTime": number,
         "name": "string",
         "status": "string"
      }
   ],
   "nextToken": "string"
}
```

## Response Elements<a name="API_ListEventTrackers_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [eventTrackers](#API_ListEventTrackers_ResponseSyntax) **   <a name="personalize-ListEventTrackers-response-eventTrackers"></a>
A list of event trackers\.  
Type: Array of [EventTrackerSummary](API_EventTrackerSummary.md) objects  
Array Members: Maximum number of 100 items\.

 ** [nextToken](#API_ListEventTrackers_ResponseSyntax) **   <a name="personalize-ListEventTrackers-response-nextToken"></a>
A token for getting the next set of event trackers \(if they exist\)\.  
Type: String  
Length Constraints: Maximum length of 1300\.

## Errors<a name="API_ListEventTrackers_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **InvalidNextTokenException**   
The token is not valid\.  
HTTP Status Code: 400

## See Also<a name="API_ListEventTrackers_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/ListEventTrackers) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/ListEventTrackers) 