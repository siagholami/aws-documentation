# DescribeEventTracker<a name="API_DescribeEventTracker"></a>

Describes an event tracker\. The response includes the `trackingId` and `status` of the event tracker\. For more information on event trackers, see [CreateEventTracker](API_CreateEventTracker.md)\.

## Request Syntax<a name="API_DescribeEventTracker_RequestSyntax"></a>

```
{
   "eventTrackerArn": "string"
}
```

## Request Parameters<a name="API_DescribeEventTracker_RequestParameters"></a>

The request accepts the following data in JSON format\.

 ** [eventTrackerArn](#API_DescribeEventTracker_RequestSyntax) **   <a name="personalize-DescribeEventTracker-request-eventTrackerArn"></a>
The Amazon Resource Name \(ARN\) of the event tracker to describe\.  
Type: String  
Length Constraints: Maximum length of 256\.  
Pattern: `arn:([a-z\d-]+):personalize:.*:.*:.+`   
Required: Yes

## Response Syntax<a name="API_DescribeEventTracker_ResponseSyntax"></a>

```
{
   "eventTracker": { 
      "accountId": "string",
      "creationDateTime": number,
      "datasetGroupArn": "string",
      "eventTrackerArn": "string",
      "lastUpdatedDateTime": number,
      "name": "string",
      "status": "string",
      "trackingId": "string"
   }
}
```

## Response Elements<a name="API_DescribeEventTracker_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [eventTracker](#API_DescribeEventTracker_ResponseSyntax) **   <a name="personalize-DescribeEventTracker-response-eventTracker"></a>
An object that describes the event tracker\.  
Type: [EventTracker](API_EventTracker.md) object

## Errors<a name="API_DescribeEventTracker_Errors"></a>

 **InvalidInputException**   
Provide a valid value for the field or parameter\.  
HTTP Status Code: 400

 **ResourceNotFoundException**   
Could not find the specified resource\.  
HTTP Status Code: 400

## See Also<a name="API_DescribeEventTracker_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/personalize-2018-05-22/DescribeEventTracker) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/personalize-2018-05-22/DescribeEventTracker) 