# ConnectAsMaster<a name="kvswebrtc-websocket-apis-2"></a>

Connects as a master to the signaling channel specified by the endpoint\. Any WebSocket\-complaint library can be used to connect to the endpoint obtained from a `GetSignalingEndpoint` API call\. The Amazon Resource Name \(ARN\) of the signaling channel must be provided as a query string parameter\. There are separate endpoints for connecting as a master and as a viewer\. If more than one client connects as master to a specific channel, then most recent request takes precedence\. Existing connection metadata is overwritten by the new one\.

## Request<a name="kvswebrtc-websocket-apis-2-request"></a>

```
"X-Amz-ChannelARN": "string"
```
+ **X\-Amz\-ChannelARN** \- ARN of the signaling channel\.
  + Type: string
  + Length constraints: Minimum length of 1\. Maximum length of 1024\.
  + Pattern: arn:aws:kinesisvideo:\[a\-z0\-9\-\]\+:\[0\-9\]\+:\[a\-z\]\+/\[a\-zA\-Z0\-9\_\.\-\]\+/\[0\-9\]\+
  + Required: Yes

## Response<a name="kvswebrtc-websocket-apis-2-response"></a>

200 OK HTTP status code with an empty body\.

## Errors<a name="kvswebrtc-websocket-apis-2-errors"></a>
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

  When the API is invoked at a rate that is too high\. For more information, see [Amazon Kinesis Video Streams with WebRTC Service Quotas](kvswebrtc-limits.md) and [Error Retries and Exponential Backoff in AWS](https://docs.aws.amazon.com/general/latest/gr/api-retries.html)\.

  HTTP Status Code: 400

## Limits/Throttling<a name="kvswebrtc-websocket-apis-2-limits"></a>

This API is throttled at an account level if the API is invoked at too high a rate\. An error returned when throttled with `ClientLimitExceededException`\.

## Idempotent<a name="kvswebrtc-websocket-apis-2-idempotent"></a>

If a connection already exists for the specified clientId and channel, the connection metadata is updated with the new information\.

## Retry behavior<a name="kvswebrtc-websocket-apis-2-retry"></a>

This is counted as a new API call\.

## Concurrent calls<a name="kvswebrtc-websocket-apis-2-concurrent"></a>

Concurrent calls are allowed, the connection metadata is updated for each call\.