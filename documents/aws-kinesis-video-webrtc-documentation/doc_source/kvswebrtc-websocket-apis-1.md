# ConnectAsViewer<a name="kvswebrtc-websocket-apis-1"></a>

Connects as a viewer to the signaling channel specified by the endpoint\. Any WebSocket\-compliant library can be used to connect to the endpoint obtained from the `GetSignalingEndpoint` API call\. The Amazon Resource Name \(ARN\) of the signaling channel and the client ID must be provided as query string parameters\. There are separate endpoints for connecting as a master and as a viewer\. If there is an existing connection with the same ClientId as specified the request, the new connection takes precedence\. The connection metadata is overwritten with the new information\.

## Request<a name="kvswebrtc-websocket-apis-1-request"></a>

```
"X-Amz-ChannelARN": "string",
"X-Amz-ClientId": "string"
```
+ **X\-Amz\-ChannelARN** \- ARN of the signaling channel\.
  + Type: string
  + Length constraints: minimum length of 1 and maximum length of 1024
  + Pattern: arn:aws:kinesisvideo:\[a\-z0\-9\-\]\+:\[0\-9\]\+:\[a\-z\]\+/\[a\-zA\-Z0\-9\_\.\-\]\+/\[0\-9\]\+
  + Required: Yes
+ **X\-Amz\-ClientId** \- A unique identifier for the client\.
  + Type: string
  + Length constraints: minimum length of 1\. Maximum length of 256\.
  + Pattern: ^\(\(?\!\(?i\)AWS\_\.\*\)\[a\-zA\-Z0\-9\_\.\-\]
**Note**  
`X-Amz-ClientId` cannot start with an `AWS_ prefix`\.
  + Required: Yes

## Response<a name="kvswebrtc-websocket-apis-1-response"></a>

200 OK HTTP status code with an empty body\.

## Errors<a name="kvswebrtc-websocket-apis-1-errors"></a>
+ InvalidArgumentException

  A specified parameter exceeds its restrictions, is not supported, or cannot be used\. For more information, see the returned message\.

  HTTP Status Code: 400
+ AccessDeniedException

  The caller is not authorized to access the given channel or the token has expired\.

  HTTP Status Code: 403
+ ResourceNotFoundException

  The channel doesn't exist\.

  HTTP Status Code: 404
+ ClientLimitExceededException

  When the API is invoked at a rate that is too high or when there are more than the supported maximum number of viewers connected to the channel\. For more information, see [Amazon Kinesis Video Streams with WebRTC Service Quotas](kvswebrtc-limits.md) and [Error Retries and Exponential Backoff in AWS](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

  HTTP Status Code: 400

## Limits/Throttling<a name="kvswebrtc-websocket-apis-1-limits"></a>

This API is throttled at an account level if the API is invoked at too high a rate or when there are more than the supported maximum number of viewers connected to the channel\. An error returned when throttled with `ClientLimitExceededException`\.

## Idempotent<a name="kvswebrtc-websocket-apis-1-idempotent"></a>

If a connection already exists for the specified ClientId and channel, the connection metadata is updated with the new information\.

## Retry behavior<a name="kvswebrtc-websocket-apis-1-retry"></a>

This is counted as a new API call\.

## Concurrent calls<a name="kvswebrtc-websocket-apis-1-concurrent"></a>

Concurrent calls are allowed, the connection metadata is updated for each call\.