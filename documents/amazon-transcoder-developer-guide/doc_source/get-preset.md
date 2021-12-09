# Read Preset<a name="get-preset"></a>

**Topics**
+ [Description](#get-preset-description)
+ [Requests](#get-preset-requests)
+ [Responses](#get-preset-responses)
+ [Errors](#get-preset-response-errors)
+ [Examples](#get-preset-examples)

## Description<a name="get-preset-description"></a>

To get detailed information about a preset, send a GET request to the `/2012-09-25/presets/presetId` resource\.

## Requests<a name="get-preset-requests"></a>

### Syntax<a name="get-preset-request-syntax"></a>

```
GET /2012-09-25/presets/[presetId](#get-preset-request-preset-id) HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
```

### Request Parameter<a name="get-preset-request-parameters"></a>

This operation takes the following request parameter\. 

** **presetId****  
The identifier of the preset for which you want to get detailed information\. 

### Request Headers<a name="get-preset-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="get-preset-request-body"></a>

This operation does not have a request body\.

## Responses<a name="get-preset-responses"></a>

### Syntax<a name="get-preset-response-syntax"></a>

```
Status: 200 OK
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature

{
   "Preset":{
      "[Id](#get-preset-response-id)":"preset identifier",
      "[Type](#get-preset-response-type)":"Custom|System",
      "Name":"preset name",
      "Description":"preset description",
      "Container":"flac|flv|fmp4|gif|mp2|mp3|mp4|mpg|mxf|oga|ogg|ts|wav|webm",
      "Audio":{
         "Codec":"AAC|flac|mp2|mp3|pcm|vorbis",
         "CodecOptions":{
            "Profile":"auto|AAC-LC|HE-AAC|HE-AACv2",
            "BitDepth":"8|16|24|32",
            "Signed":"Signed|Unsigned",
            "BitOrder":"LittleEndian"
         },
         "SampleRate":"auto|22050|32000|44100|48000|96000",
         "BitRate":"audio bit rate of output file in kilobits/second",
         "Channels":"auto|0|1|2",
         "AudioPackingMode":"SingleTrack|OneChannelPerTrack|
            OneChannelPerTrackWithMosTo8Tracks"
      },
      "Video":{
         "Codec":"gif|H.264|mpeg2|vp8|vp9",
         "CodecOptions":{
            "Profile":"baseline|main|high|0|1|2|3",
            "Level":"1|1b|1.1|1.2|1.3|2|2.1|2.2|3|3.1|3.2|4|4.1",
            "MaxReferenceFrames":maximum number of reference frames,
            "MaxBitRate":"maximum bit rate",
            "BufferSize":"maximum buffer size",
            "InterlacedMode":"Progressive|TopFirst|BottomFirst|Auto",
            "ColorSpaceConversionMode":"None|Bt709ToBt601|Bt601ToBt709|Auto",
            "ChromaSubsampling":"yuv420p|yuv422p",
            "LoopCount":"Infinite|[0,100]"
         },
         "KeyframesMaxDist":maximum frames between key frames,
         "FixedGOP":"true|false",
         "BitRate":"auto|video bit rate of output file in kilobits/second",
         "FrameRate":"auto|10|15|23.97|24|25|29.97|30|50|60",
         "MaxFrameRate":"10|15|23.97|24|25|29.97|30|50|60",
         "MaxWidth":"auto|[128,4096]",
         "MaxHeight":"auto|[96,3072]",
         "SizingPolicy":"Fit|Fill|Stretch|Keep|ShrinkToFit|ShrinkToFill",
         "PaddingPolicy":"Pad|NoPad",
         "DisplayAspectRatio":"auto|1:1|4:3|3:2|16:9",
         "Resolution":"width in pixelsxheight in pixels" <not recommended>,
         "AspectRatio":"auto|1:1|4:3|3:2|16:9" <not recommended>
         "Watermarks":[
            {
               "Id":"unique identifier up to 40 characters",
               "MaxWidth":"[16,Video:MaxWidth]px|[0,100]%",
               "MaxHeight":"[16,Video:MaxHeight]px|[0,100]%", 
               "SizingPolicy":"Fit|Stretch|ShrinkToFit",
               "HorizontalAlign":"Left|Right|Center",
               "HorizontalOffset":"[0,100]%|[0,Video:MaxWidth]px",
               "VerticalAlign":"Top|Bottom|Center",
               "VerticalOffset":"[0,100]%|[0,Video:MaxHeight]px",
               "Opacity":"[0,100]",
               "Target":"Content|Frame"
            }
         ]
      },   
      "Thumbnails":{
         "Format":"jpg|png",
         "Interval":"number of seconds between thumbnails",
         "MaxWidth":"auto|[32,4096]",
         "MaxHeight":"auto|[32,3072]",
         "SizingPolicy":"Fit|Fill|Stretch|Keep|ShrinkToFit|ShrinkToFill",
         "PaddingPolicy":"Pad|NoPad",
         "Resolution":"width in pixelsxheight in pixels",
         "AspectRatio":"auto|1:1|4:3|3:2|16:9"
      }
   }
}
```

### Response Headers<a name="get-preset-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="get-preset-response-body"></a>

When you get a preset, Elastic Transcoder returns the values that you specified when you created the preset\. For more information, see [Settings that You Specify When You Create an Elastic Transcoder Preset](preset-settings.md)\.

In addition, Elastic Transcoder returns the following values\.

**\(Automatic\) Id**  
Identifier for the preset\. You can use this value to get settings for the preset or to delete it\.

**\(Automatic\) Type**  
Whether the preset is a default preset provided by Elastic Transcoder \(`System`\) or a preset that you have defined \(`Custom`\)\.

## Errors<a name="get-preset-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="get-preset-examples"></a>

The following example request gets the preset that has the preset ID `5555555555555-abcde5`\.

### Sample Request<a name="get-preset-examples-sample-request"></a>

```
GET /2012-09-25/presets/5555555555555-abcde5 HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
```

### Sample Response<a name="get-preset-examples-sample-response"></a>

```
Status: 200 OK
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature

{
   "Preset":{
      "Id":"5555555555555-abcde5",
      "Type":"Custom",
      "Name":"DefaultPreset",
      "Description":"Use for published videos",
      "Container":"mp4",
      "Audio":{
         "Codec":"AAC",
         "CodecOptions":{
            "Profile":"AAC-LC"
         },
         "SampleRate":"44100",
         "BitRate":"96",
         "Channels":"2"
      },
      "Video":{
         "Codec":"H.264",
         "CodecOptions":{
            "Profile":"main",
            "Level":"2.2",
            "MaxReferenceFrames":"3",
            "MaxBitRate":"",
            "BufferSize":"",
            "InterlacedMode":"Progressive",
            "ColorSpaceConversionMode":"None"
         },
         "KeyframesMaxDist":"240",
         "FixedGOP":"false",
         "BitRate":"1600",
         "FrameRate":"auto",
         "MaxFrameRate":"30",
         "MaxWidth":"auto",
         "MaxHeight":"auto",
         "SizingPolicy":"Fit",
         "PaddingPolicy":"Pad",
         "DisplayAspectRatio":"auto",
         "Watermarks":[
            {
               "Id":"company logo",
               "MaxWidth":"20%",
               "MaxHeight":"20%", 
               "SizingPolicy":"ShrinkToFit",
               "HorizontalAlign":"Right",
               "HorizontalOffset":"10px",
               "VerticalAlign":"Bottom",
               "VerticalOffset":"10px",
               "Opacity":"55.5",
               "Target":"Content"
            }
         ]
      }
      "Thumbnails":{
         "Format":"png",
         "Interval":"120",
         "MaxHeight":"auto",
         "MaxWidth":"auto",
         "SizingPolicy":"Fit",
         "PaddingPolicy":"Pad"
      },
   },
   "Warning":""
}
```