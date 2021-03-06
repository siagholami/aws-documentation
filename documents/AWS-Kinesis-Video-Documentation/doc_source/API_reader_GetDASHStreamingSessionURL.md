# GetDASHStreamingSessionURL<a name="API_reader_GetDASHStreamingSessionURL"></a>

Retrieves an MPEG Dynamic Adaptive Streaming over HTTP \(DASH\) URL for the stream\. You can then open the URL in a media player to view the stream contents\.

Both the `StreamName` and the `StreamARN` parameters are optional, but you must specify either the `StreamName` or the `StreamARN` when invoking this API operation\.

An Amazon Kinesis video stream has the following requirements for providing data through MPEG\-DASH:
+ The media must contain h\.264 or h\.265 encoded video and, optionally, AAC or G\.711 encoded audio\. Specifically, the codec ID of track 1 should be `V_MPEG/ISO/AVC` \(for h\.264\) or V\_MPEGH/ISO/HEVC \(for H\.265\)\. Optionally, the codec ID of track 2 should be `A_AAC` \(for AAC\) or A\_MS/ACM \(for G\.711\)\.
+ Data retention must be greater than 0\.
+ The video track of each fragment must contain codec private data in the Advanced Video Coding \(AVC\) for H\.264 format and HEVC for H\.265 format\. For more information, see [MPEG\-4 specification ISO/IEC 14496\-15](https://www.iso.org/standard/55980.html)\. For information about adapting stream data to a given format, see [NAL Adaptation Flags](http://docs.aws.amazon.com/kinesisvideostreams/latest/dg/producer-reference-nal.html)\.
+ The audio track \(if present\) of each fragment must contain codec private data in the AAC format \([AAC specification ISO/IEC 13818\-7](https://www.iso.org/standard/43345.html)\) or the [MS Wave format](http://www-mmsp.ece.mcgill.ca/Documents/AudioFormats/WAVE/WAVE.html)\.

The following procedure shows how to use MPEG\-DASH with Kinesis Video Streams:

1. Get an endpoint using [GetDataEndpoint](http://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_GetDataEndpoint.html), specifying `GET_DASH_STREAMING_SESSION_URL` for the `APIName` parameter\.

1. Retrieve the MPEG\-DASH URL using `GetDASHStreamingSessionURL`\. Kinesis Video Streams creates an MPEG\-DASH streaming session to be used for accessing content in a stream using the MPEG\-DASH protocol\. `GetDASHStreamingSessionURL` returns an authenticated URL \(that includes an encrypted session token\) for the session's MPEG\-DASH *manifest* \(the root resource needed for streaming with MPEG\-DASH\)\.
**Note**  
Don't share or store this token where an unauthorized entity could access it\. The token provides access to the content of the stream\. Safeguard the token with the same measures that you would use with your AWS credentials\.

   The media that is made available through the manifest consists only of the requested stream, time range, and format\. No other media data \(such as frames outside the requested window or alternate bitrates\) is made available\.

1. Provide the URL \(containing the encrypted session token\) for the MPEG\-DASH manifest to a media player that supports the MPEG\-DASH protocol\. Kinesis Video Streams makes the initialization fragment and media fragments available through the manifest URL\. The initialization fragment contains the codec private data for the stream, and other data needed to set up the video or audio decoder and renderer\. The media fragments contain encoded video frames or encoded audio samples\.

1. The media player receives the authenticated URL and requests stream metadata and media data normally\. When the media player requests data, it calls the following actions:
   +  **GetDASHManifest:** Retrieves an MPEG DASH manifest, which contains the metadata for the media that you want to playback\.
   +  **GetMP4InitFragment:** Retrieves the MP4 initialization fragment\. The media player typically loads the initialization fragment before loading any media fragments\. This fragment contains the "`fytp`" and "`moov`" MP4 atoms, and the child atoms that are needed to initialize the media player decoder\.

     The initialization fragment does not correspond to a fragment in a Kinesis video stream\. It contains only the codec private data for the stream and respective track, which the media player needs to decode the media frames\.
   +  **GetMP4MediaFragment:** Retrieves MP4 media fragments\. These fragments contain the "`moof`" and "`mdat`" MP4 atoms and their child atoms, containing the encoded fragment's media frames and their timestamps\. 
**Note**  
After the first media fragment is made available in a streaming session, any fragments that don't contain the same codec private data cause an error to be returned when those different media fragments are loaded\. Therefore, the codec private data should not change between fragments in a session\. This also means that the session fails if the fragments in a stream change from having only video to having both audio and video\.

     Data retrieved with this action is billable\. See [Pricing](https://aws.amazon.com/kinesis/video-streams/pricing/) for details\.

**Note**  
The following restrictions apply to MPEG\-DASH sessions:  
A streaming session URL should not be shared between players\. The service might throttle a session if multiple media players are sharing it\. For connection limits, see [Kinesis Video Streams Limits](http://docs.aws.amazon.com/kinesisvideostreams/latest/dg/limits.html)\.
A Kinesis video stream can have a maximum of ten active MPEG\-DASH streaming sessions\. If a new session is created when the maximum number of sessions is already active, the oldest \(earliest created\) session is closed\. The number of active `GetMedia` connections on a Kinesis video stream does not count against this limit, and the number of active MPEG\-DASH sessions does not count against the active `GetMedia` connection limit\.  
The maximum limits for active HLS and MPEG\-DASH streaming sessions are independent of each other\. 

You can monitor the amount of data that the media player consumes by monitoring the `GetMP4MediaFragment.OutgoingBytes` Amazon CloudWatch metric\. For information about using CloudWatch to monitor Kinesis Video Streams, see [Monitoring Kinesis Video Streams](http://docs.aws.amazon.com/kinesisvideostreams/latest/dg/monitoring.html)\. For pricing information, see [Amazon Kinesis Video Streams Pricing](https://aws.amazon.com/kinesis/video-streams/pricing/) and [AWS Pricing](https://aws.amazon.com/pricing/)\. Charges for both HLS sessions and outgoing AWS data apply\.

For more information about HLS, see [HTTP Live Streaming](https://developer.apple.com/streaming/) on the [Apple Developer site](https://developer.apple.com)\.

**Important**  
If an error is thrown after invoking a Kinesis Video Streams archived media API, in addition to the HTTP status code and the response body, it includes the following pieces of information:   
 `x-amz-ErrorType` HTTP header ??? contains a more specific error type in addition to what the HTTP status code provides\. 
 `x-amz-RequestId` HTTP header ??? if you want to report an issue to AWS, the support team can better diagnose the problem if given the Request Id\.
Both the HTTP status code and the ErrorType header can be utilized to make programmatic decisions about whether errors are retry\-able and under what conditions, as well as provide information on what actions the client programmer might need to take in order to successfully try again\.  
For more information, see the **Errors** section at the bottom of this topic, as well as [Common Errors](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/CommonErrors.html)\. 

## Request Syntax<a name="API_reader_GetDASHStreamingSessionURL_RequestSyntax"></a>

```
POST /getDASHStreamingSessionURL HTTP/1.1
Content-type: application/json

{
   "[DASHFragmentSelector](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-DASHFragmentSelector)": { 
      "[FragmentSelectorType](API_reader_DASHFragmentSelector.md#KinesisVideo-Type-reader_DASHFragmentSelector-FragmentSelectorType)": "string",
      "[TimestampRange](API_reader_DASHFragmentSelector.md#KinesisVideo-Type-reader_DASHFragmentSelector-TimestampRange)": { 
         "[EndTimestamp](API_reader_DASHTimestampRange.md#KinesisVideo-Type-reader_DASHTimestampRange-EndTimestamp)": number,
         "[StartTimestamp](API_reader_DASHTimestampRange.md#KinesisVideo-Type-reader_DASHTimestampRange-StartTimestamp)": number
      }
   },
   "[DisplayFragmentNumber](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-DisplayFragmentNumber)": "string",
   "[DisplayFragmentTimestamp](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-DisplayFragmentTimestamp)": "string",
   "[Expires](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-Expires)": number,
   "[MaxManifestFragmentResults](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-MaxManifestFragmentResults)": number,
   "[PlaybackMode](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-PlaybackMode)": "string",
   "[StreamARN](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-StreamARN)": "string",
   "[StreamName](#KinesisVideo-reader_GetDASHStreamingSessionURL-request-StreamName)": "string"
}
```

## URI Request Parameters<a name="API_reader_GetDASHStreamingSessionURL_RequestParameters"></a>

The request does not use any URI parameters\.

## Request Body<a name="API_reader_GetDASHStreamingSessionURL_RequestBody"></a>

The request accepts the following data in JSON format\.

 ** [DASHFragmentSelector](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-DASHFragmentSelector"></a>
The time range of the requested fragment and the source of the timestamps\.  
This parameter is required if `PlaybackMode` is `ON_DEMAND` or `LIVE_REPLAY`\. This parameter is optional if PlaybackMode is`` `LIVE`\. If `PlaybackMode` is `LIVE`, the `FragmentSelectorType` can be set, but the `TimestampRange` should not be set\. If `PlaybackMode` is `ON_DEMAND` or `LIVE_REPLAY`, both `FragmentSelectorType` and `TimestampRange` must be set\.  
Type: [DASHFragmentSelector](API_reader_DASHFragmentSelector.md) object  
Required: No

 ** [DisplayFragmentNumber](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-DisplayFragmentNumber"></a>
Fragments are identified in the manifest file based on their sequence number in the session\. If DisplayFragmentNumber is set to `ALWAYS`, the Kinesis Video Streams fragment number is added to each S element in the manifest file with the attribute name ???kvs:fn???\. These fragment numbers can be used for logging or for use with other APIs \(e\.g\. `GetMedia` and `GetMediaForFragmentList`\)\. A custom MPEG\-DASH media player is necessary to leverage these this custom attribute\.  
The default value is `NEVER`\.  
Type: String  
Valid Values:` ALWAYS | NEVER`   
Required: No

 ** [DisplayFragmentTimestamp](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-DisplayFragmentTimestamp"></a>
Per the MPEG\-DASH specification, the wall\-clock time of fragments in the manifest file can be derived using attributes in the manifest itself\. However, typically, MPEG\-DASH compatible media players do not properly handle gaps in the media timeline\. Kinesis Video Streams adjusts the media timeline in the manifest file to enable playback of media with discontinuities\. Therefore, the wall\-clock time derived from the manifest file may be inaccurate\. If DisplayFragmentTimestamp is set to `ALWAYS`, the accurate fragment timestamp is added to each S element in the manifest file with the attribute name ???kvs:ts???\. A custom MPEG\-DASH media player is necessary to leverage this custom attribute\.  
The default value is `NEVER`\. When [DASHFragmentSelector](API_reader_DASHFragmentSelector.md) is `SERVER_TIMESTAMP`, the timestamps will be the server start timestamps\. Similarly, when [DASHFragmentSelector](API_reader_DASHFragmentSelector.md) is `PRODUCER_TIMESTAMP`, the timestamps will be the producer start timestamps\.   
Type: String  
Valid Values:` ALWAYS | NEVER`   
Required: No

 ** [Expires](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-Expires"></a>
The time in seconds until the requested session expires\. This value can be between 300 \(5 minutes\) and 43200 \(12 hours\)\.  
When a session expires, no new calls to `GetDashManifest`, `GetMP4InitFragment`, or `GetMP4MediaFragment` can be made for that session\.  
The default is 300 \(5 minutes\)\.  
Type: Integer  
Valid Range: Minimum value of 300\. Maximum value of 43200\.  
Required: No

 ** [MaxManifestFragmentResults](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-MaxManifestFragmentResults"></a>
The maximum number of fragments that are returned in the MPEG\-DASH manifest\.  
When the `PlaybackMode` is `LIVE`, the most recent fragments are returned up to this value\. When the `PlaybackMode` is `ON_DEMAND`, the oldest fragments are returned, up to this maximum number\.  
When there are a higher number of fragments available in a live MPEG\-DASH manifest, video players often buffer content before starting playback\. Increasing the buffer size increases the playback latency, but it decreases the likelihood that rebuffering will occur during playback\. We recommend that a live MPEG\-DASH manifest have a minimum of 3 fragments and a maximum of 10 fragments\.  
The default is 5 fragments if `PlaybackMode` is `LIVE` or `LIVE_REPLAY`, and 1,000 if `PlaybackMode` is `ON_DEMAND`\.   
The maximum value of 1,000 fragments corresponds to more than 16 minutes of video on streams with 1\-second fragments, and more than 2 1/2 hours of video on streams with 10\-second fragments\.  
Type: Long  
Valid Range: Minimum value of 1\. Maximum value of 1000\.  
Required: No

 ** [PlaybackMode](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-PlaybackMode"></a>
Whether to retrieve live, live replay, or archived, on\-demand data\.  
Features of the three types of sessions include the following:  
+  ** `LIVE` **: For sessions of this type, the MPEG\-DASH manifest is continually updated with the latest fragments as they become available\. We recommend that the media player retrieve a new manifest on a one\-second interval\. When this type of session is played in a media player, the user interface typically displays a "live" notification, with no scrubber control for choosing the position in the playback window to display\.
**Note**  
In `LIVE` mode, the newest available fragments are included in an MPEG\-DASH manifest, even if there is a gap between fragments \(that is, if a fragment is missing\)\. A gap like this might cause a media player to halt or cause a jump in playback\. In this mode, fragments are not added to the MPEG\-DASH manifest if they are older than the newest fragment in the playlist\. If the missing fragment becomes available after a subsequent fragment is added to the manifest, the older fragment is not added, and the gap is not filled\.
+  ** `LIVE_REPLAY` **: For sessions of this type, the MPEG\-DASH manifest is updated similarly to how it is updated for `LIVE` mode except that it starts by including fragments from a given start time\. Instead of fragments being added as they are ingested, fragments are added as the duration of the next fragment elapses\. For example, if the fragments in the session are two seconds long, then a new fragment is added to the manifest every two seconds\. This mode is useful to be able to start playback from when an event is detected and continue live streaming media that has not yet been ingested as of the time of the session creation\. This mode is also useful to stream previously archived media without being limited by the 1,000 fragment limit in the `ON_DEMAND` mode\. 
+  ** `ON_DEMAND` **: For sessions of this type, the MPEG\-DASH manifest contains all the fragments for the session, up to the number that is specified in `MaxMediaPlaylistFragmentResults`\. The manifest must be retrieved only once for each session\. When this type of session is played in a media player, the user interface typically displays a scrubber control for choosing the position in the playback window to display\.
In all playback modes, if `FragmentSelectorType` is `PRODUCER_TIMESTAMP`, and if there are multiple fragments with the same start timestamp, the fragment that has the larger fragment number \(that is, the newer fragment\) is included in the MPEG\-DASH manifest\. The other fragments are not included\. Fragments that have different timestamps but have overlapping durations are still included in the MPEG\-DASH manifest\. This can lead to unexpected behavior in the media player\.  
The default is `LIVE`\.  
Type: String  
Valid Values:` LIVE | LIVE_REPLAY | ON_DEMAND`   
Required: No

 ** [StreamARN](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-StreamARN"></a>
The Amazon Resource Name \(ARN\) of the stream for which to retrieve the MPEG\-DASH manifest URL\.  
You must specify either the `StreamName` or the `StreamARN`\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 1024\.  
Pattern: `arn:aws:kinesisvideo:[a-z0-9-]+:[0-9]+:[a-z]+/[a-zA-Z0-9_.-]+/[0-9]+`   
Required: No

 ** [StreamName](#API_reader_GetDASHStreamingSessionURL_RequestSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-request-StreamName"></a>
The name of the stream for which to retrieve the MPEG\-DASH manifest URL\.  
You must specify either the `StreamName` or the `StreamARN`\.  
Type: String  
Length Constraints: Minimum length of 1\. Maximum length of 256\.  
Pattern: `[a-zA-Z0-9_.-]+`   
Required: No

## Response Syntax<a name="API_reader_GetDASHStreamingSessionURL_ResponseSyntax"></a>

```
HTTP/1.1 200
Content-type: application/json

{
   "[DASHStreamingSessionURL](#KinesisVideo-reader_GetDASHStreamingSessionURL-response-DASHStreamingSessionURL)": "string"
}
```

## Response Elements<a name="API_reader_GetDASHStreamingSessionURL_ResponseElements"></a>

If the action is successful, the service sends back an HTTP 200 response\.

The following data is returned in JSON format by the service\.

 ** [DASHStreamingSessionURL](#API_reader_GetDASHStreamingSessionURL_ResponseSyntax) **   <a name="KinesisVideo-reader_GetDASHStreamingSessionURL-response-DASHStreamingSessionURL"></a>
The URL \(containing the session token\) that a media player can use to retrieve the MPEG\-DASH manifest\.  
Type: String

## Errors<a name="API_reader_GetDASHStreamingSessionURL_Errors"></a>

For information about the errors that are common to all actions, see [Common Errors](CommonErrors.md)\.

 **ClientLimitExceededException**   
Kinesis Video Streams has throttled the request because you have exceeded the limit of allowed client calls\. Try making the call later\.  
HTTP Status Code: 400

 **InvalidArgumentException**   
A specified parameter exceeds its restrictions, is not supported, or can't be used\.  
HTTP Status Code: 400

 **InvalidCodecPrivateDataException**   
The codec private data in at least one of the tracks of the video stream is not valid for this operation\.  
HTTP Status Code: 400

 **MissingCodecPrivateDataException**   
No codec private data was found in at least one of tracks of the video stream\.  
HTTP Status Code: 400

 **NoDataRetentionException**   
A streaming session was requested for a stream that does not retain data \(that is, has a `DataRetentionInHours` of 0\)\.   
HTTP Status Code: 400

 **NotAuthorizedException**   
Status Code: 403, The caller is not authorized to perform an operation on the given stream, or the token has expired\.  
HTTP Status Code: 401

 **ResourceNotFoundException**   
 `GetMedia` throws this error when Kinesis Video Streams can't find the stream that you specified\.  
 `GetHLSStreamingSessionURL` and `GetDASHStreamingSessionURL` throw this error if a session with a `PlaybackMode` of `ON_DEMAND` or `LIVE_REPLAY`is requested for a stream that has no fragments within the requested time range, or if a session with a `PlaybackMode` of `LIVE` is requested for a stream that has no fragments within the last 30 seconds\.  
HTTP Status Code: 404

 **UnsupportedStreamMediaTypeException**   
The type of the media \(for example, h\.264 or h\.265 video or ACC or G\.711 audio\) could not be determined from the codec IDs of the tracks in the first fragment for a playback session\. The codec ID for track 1 should be `V_MPEG/ISO/AVC` and, optionally, the codec ID for track 2 should be `A_AAC`\.  
HTTP Status Code: 400

## See Also<a name="API_reader_GetDASHStreamingSessionURL_SeeAlso"></a>

For more information about using this API in one of the language\-specific AWS SDKs, see the following:
+  [AWS Command Line Interface](https://docs.aws.amazon.com/goto/aws-cli/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for \.NET](https://docs.aws.amazon.com/goto/DotNetSDKV3/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for C\+\+](https://docs.aws.amazon.com/goto/SdkForCpp/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for Go](https://docs.aws.amazon.com/goto/SdkForGoV1/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for Java](https://docs.aws.amazon.com/goto/SdkForJava/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for JavaScript](https://docs.aws.amazon.com/goto/AWSJavaScriptSDK/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for PHP V3](https://docs.aws.amazon.com/goto/SdkForPHPV3/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for Python](https://docs.aws.amazon.com/goto/boto3/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 
+  [AWS SDK for Ruby V3](https://docs.aws.amazon.com/goto/SdkForRubyV3/kinesis-video-reader-data-2017-09-30/GetDASHStreamingSessionURL) 