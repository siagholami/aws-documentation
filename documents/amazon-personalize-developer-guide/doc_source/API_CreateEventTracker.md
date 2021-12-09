# CreateEventTracker<a name="API_CreateEventTracker"></a>

Creates an event tracker that you use when sending event data to the specified dataset group using the [PutEvents](https://docs.aws.amazon.com/personalize/latest/dg/API_UBS_PutEvents.html) API\.

When Amazon Personalize creates an event tracker, it also creates an *event\-interactions* dataset in the dataset group associated with the event tracker\. The event\-interactions dataset stores the event data from the `PutEvents` call\. The contents of this dataset are not available to the user\.

**Note**  
Only one event tracker can be associated with a dataset group\. You will get an error if you call `CreateEventTracker` using the same dataset group as an existing event tracker\.

When you send event data you include your tracking ID\. The tracking ID identifies the customer and authorizes the customer to send the data\.

The event tracker can be in one of the following states:
+ CREATE PENDING > CREATE IN\_PROGRESS > ACTIVE \-or\- CREATE FAILED
+ DELETE PENDING > DELETE IN\_PROGRESS

To get the status of the event tracker, call [DescribeEventTracker](API_DescribeEventTracker.md)\.

**Note**  
The event tracker must be in the ACTIVE state before using the tracking ID\.

**Related APIs**
+  [ListEventTrackers](API_ListEventTrackers.md) 
+  [DescribeEventTracker](API_DescribeEventTracker.md) 
+  [DeleteEventTracker](API_DeleteEventTracker.md) 

## Request Syntax<a name="API_CreateEventTracker_RequestSyntax"></a>

```
{
   "datasetGroupArn": "string",
   "name": "string"
}
```

## Request Parameters<a name="API_CreateEventTracker_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [datasetGroupArn](#API_CreateEventTracker_RequestSyntax) **   <a name="personalize-CreateEventTracker-request-datasetGroupArn"></a>
The Amazon Resource Name \(ARN\) of the dataset group that receives the event data\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

 ** [name](#API_CreateEventTracker_RequestSyntax) **   <a name="personalize-CreateEventTracker-request-name"></a>
The name for the event tracker\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 63\.  
Pattern: `^[a-zA-Z0-9][a-zA-Z0-9\-_]*`   
Required: Yes

## Response Syntax<a name="API_CreateEventTracker_ResponseSyntax"></a>

```
{
   "eventTrackerArn": "string",
   "trackingId": "string"
}
```

## Response Elements<a name="API_CreateEventTracker_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [eventTrackerArn](#API_CreateEventTracker_ResponseSyntax) **   <a name="personalize-CreateEventTracker-response-eventTrackerArn"></a>
The ARN of the event tracker\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+` 

 ** [trackingId](#API_CreateEventTracker_ResponseSyntax) **   <a name="personalize-CreateEventTracker-response-trackingId"></a>
The ID of the event tracker\. Include this ID in requests to the [PutEvents](https://docs.aws.amazon.com/personalize/latest/dg/API_UBS_PutEvents.html) API\.  
Type: String  
Length Constraints: Maximum length of 256\.

## Errors<a name="API_CreateEventTracker_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **LimitExceededException**   
The limit on the number of requests per second has been exceeded\.  
HTTP Status Code: 400

 **ResourceAlreadyExistsException**   
The specified resource already exists\.  
HTTP Status Code: 400

 **ResourceInUseException**   
The specified resource is in use\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_CreateEventTracker_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/CreateEventTracker) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/CreateEventTracker) 