# Read Job<a name="get-job"></a>

**Topics**
+ [Description](#get-job-description)
+ [Requests](#get-job-requests)
+ [Responses](#get-job-responses)
+ [Errors](#get-job-response-errors)
+ [Examples](#get-job-examples)

## Description<a name="get-job-description"></a>

To get detailed information about a job, send a GET request to the `/2012-09-25/jobs/jobId` resource\.

## Requests<a name="get-job-requests"></a>

### Syntax<a name="get-job-request-syntax"></a>

```
GET /2012-09-25/jobs/[jobId](#get-job-request-job-id) HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Request Parameter<a name="get-job-request-parameters"></a>

This operation takes the following request parameter\. 

**jobId**  
The identifier of the job for which you want to get detailed information\. 

### Request Headers<a name="get-job-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="get-job-request-body"></a>

This operation does not have a request body\.

## Responses<a name="get-job-responses"></a>

### Syntax<a name="get-job-response-syntax"></a>

```
Status: 200 OK
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Job":{
      "[Id](list-jobs-by-status.md#list-jobs-by-status-response-job-id)":"Id that Elastic Transcoder assigned to the job",
      "Inputs":[{
         "Key":"name of the file to transcode",
         "Encryption":{
            "Mode":"aes-cbc-pkcs7|aes-ctr|aes-gcm",
            "Key":"encrypted and base64-encoded decryption key",
            "KeyMd5":"base64-encoded key digest",
            "InitializationVector":"base64-encoded initialization vector"
         },
         "TimeSpan":{
            "StartTime":"starting place of the clip, in
               HH:mm:ss.SSS or sssss.SSS",
            "Duration":"duration of the clip, in HH:mm:ss.SSS
               or sssss.SSS"
         },
         "FrameRate":"auto|10|15|23.97|24|25|29.97|30|50|60",
         "Resolution":"auto|width in pixelsxheight in pixels",
         "AspectRatio":"auto|1:1|4:3|3:2|16:9",
         "Interlaced":"auto|true|false",
         "Container":"auto|aac|asf|avi|divx|flv|m4a|mkv|mov|mp2|mp3|
            mp4|mpeg|mpeg-ps|mpeg-ts|mxf|ogg|vob|wav|webm",
         "[DetectedProperties](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-properties)":{
            "[Width](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-width)":"video width in pixels",
            "[Height](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-height)":"video height in pixels",
            "[FrameRate](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-frame-rate)":"video frame rate in fps",
            "[FileSize](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-file-size)":"file size in bytes",
            "[DurationMillis](list-jobs-by-status.md#list-jobs-by-status-response-inputs-detected-duration)":"file duration in milliseconds"
         },
         "InputCaptions":{
            "MergePolicy":"MergeOverride|MergeRetain|Override",
            "CaptionSources":[
               {
                  "Key":"name of the input caption file",
                  "Language":"language of the input caption file",
                  "TimeOffset":"starting place of the captions, in
                     either [-+]SS.sss or [-+]HH:mm:SS.ss",
                  "Label":"label for the caption"
                  "Encryption":{
                     "Mode":"aes-cbc-pkcs7|aes-ctr|aes-gcm",
                     "Key":"encrypted and base64-encoded decryption key",
                     "KeyMd5":"base64-encoded key digest",
                     "InitializationVector":"base64-encoded initialization 
                        vector"
                  },
               },
               {...}
            ]
         }
      },
   {...}],
   "OutputKeyPrefix":"prefix for file names in Amazon S3 bucket",
   "Outputs":[{
         "[Id](list-jobs-by-status.md#list-jobs-by-status-response-output-id)":"sequential counter",
         "Key":"name of the transcoded file",
         "Encryption":{
            "Mode":"s3||aes-cbc-pkcs7|aes-ctr|
               aes-gcm",
            "Key":"encrypted and base64-encoded encryption key",
            "KeyMd5":"base64-encoded key digest",
            "InitializationVector":"base64-encoded initialization vector"           
         },
         "ThumbnailPattern":""|"pattern",
         "Rotate":"auto|0|90|180|270",
         "PresetId":"preset to use for the job",
         "SegmentDuration":"[1,60]",
         "Watermarks":[
            {
               "InputKey":"name of the .png or .jpg file",
               "Encryption":{
                  "Mode":"s3||aes-cbc-pkcs7|
                     aes-ctr|aes-gcm",
                  "Key":"encrypted and base64-encoded encryption key",
                  "KeyMd5":"base64-encoded key digest",
                  "InitializationVector":"base64-encoded initialization 
                     vector"
               },
               "PresetWatermarkId":"value of Video:Watermarks:Id in 
                  preset"
            },
            {...}
         ],
         "AlbumArt":[
            {
               "AlbumArtMerge":"Replace|Prepend|Append|Fallback",
               "AlbumArtArtwork":"can be empty, but not null":[
                  {
                     "AlbumArtInputKey":"name of the file to use as album 
                        art",
                     "Encryption":{
                        "Mode":"s3||aes-cbc-pkcs7|
                           aes-ctr|aes-gcm",
                        "Key":"encrypted and base64-encoded encryption key",
                        "KeyMd5":"base64-encoded key digest",
                        "InitializationVector":"base64-encoded
                           initialization vector"
                     },
                     "AlbumArtMaxWidth":"maximum width of output album art
                        in pixels",
                     "AlbumArtMaxHeight":"maximum height of output album
                        art in pixels",
                     "AlbumArtSizingPolicy":"Fit|Fill|Stretch|Keep|
                        ShrinkToFit|ShrinkToFill",
                     "AlbumArtPaddingPolicy":"Pad|NoPad",
                     "AlbumArtFormat":"jpg|png"
                  },
                  {...}
               ]
            },
         {...}], 
         "[Duration](list-jobs-by-status.md#list-jobs-by-status-response-output-duration)":"duration in seconds",
         "[DurationMillis](list-jobs-by-status.md#list-jobs-by-status-response-output-duration-millis)":"duration in milliseconds",
         "[Height](list-jobs-by-status.md#list-jobs-by-status-response-output-height)":"height in pixels",
         "[Width](list-jobs-by-status.md#list-jobs-by-status-response-output-width)":"width in pixels",
         "[FrameRate](list-jobs-by-status.md#list-jobs-by-status-response-output-frame-rate)":"frame rate in fps",
         "[FileSize](list-jobs-by-status.md#list-jobs-by-status-response-output-file-size)":"file size in bytes",
         "[Status](list-jobs-by-status.md#list-jobs-by-status-response-output-status)":"Submitted|In Progress|Complete|Error",
         "[StatusDetail](list-jobs-by-status.md#list-jobs-by-status-response-output-status-detail)":"detail associated with Status",
         "Captions":{
            "CaptionFormats":[
               {
                  "Format":"cea-708|dfxp|mov-text|scc|srt|webvtt",
                  "Pattern":"myCaption/file-language",
                  "Encryption":{
                     "Mode":"s3||aes-cbc-pkcs7|
                        aes-ctr|aes-gcm",
                     "Key":"encrypted and base64-encoded encryption key",
                     "KeyMd5":"base64-encoded key digest",
                     "InitializationVector":"base64-encoded 
                       initialization vector"
                  }
               },
               {...}
            ]
         },
         "[AppliedColorSpaceConversion](list-jobs-by-status.md#list-jobs-by-status-response-output-color-space)":"None|Bt601ToBt709|
            Bt709ToBt601"
      },
      {...}
   ],
   "Playlists":[
      {
         "Format":"HLSv3|HLSv4|MPEG-DASH|Smooth",
         "Name":"name",
         "OutputKeys":[
            "Outputs:Key to include in this playlist",
            {...}
         ],
         "HlsContentProtection":{
             "Method":"aes-128",
             "Key":"encrypted and base64-encoded protection key",
             "KeyMd5":"base64-encoded key digest",
             "InitializationVector":"base64-encoded
                initialization vector",
             "LicenseAcquisitionUrl":"license acquisition url",
             "KeyStoragePolicy":"NoStore|WithVariantPlaylists"
         },
         "PlayReadyDrm":{
             "Format":"microsoft|discretix-3.0",
             "Key":"encrypted and base64-encoded DRM key",
             "KeyId":"id of the DRM key",
             "KeyMd5":"base64-encoded key digest",
             "InitializationVector":"base64-encoded
                initialization vector",
             "LicenseAcquisitionUrl":"license acquisition url"
            }
         },
         {...}
      ],
      "UserMetadata":
         {
            "Key":"Value",
            "Second user metadata key":"Second user metadata value"
         },
      "PipelineId":"PipelineId for the job",
      "[Status](list-jobs-by-status.md#list-jobs-by-status-response-job-status)":"Submitted|Progressing|Complete|Canceled|Error",
      "[Timing](list-jobs-by-status.md#list-jobs-by-status-response-job-timing)":{
         "[SubmitTimeMillis](list-jobs-by-status.md#list-jobs-by-status-response-job-timing-submit)":"job submitted time in epoch milliseconds",
         "[StartTimeMillis](list-jobs-by-status.md#list-jobs-by-status-response-job-timing-start)":"job start time in epoch milliseconds",
         "[FinishTimeMillis](list-jobs-by-status.md#list-jobs-by-status-response-job-timing-finish)":"job finish time in epoch milliseconds"
      }
   }
}
```

### Response Headers<a name="get-job-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="get-job-response-body"></a>

For each job that satisfies the search criteria, the response body contains the values that you specified when you created the job\. For more information about the job values, see [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

In addition, Elastic Transcoder returns the following values\.

**\(Automatic\) Id**  
The identifier that Elastic Transcoder assigned to the job\. You use this value to get settings for the job or to delete the job\.

**\(Automatic\) Inputs:DetectedProperties**  
The detected properties of the input file\. Elastic Transcoder identifies these values from the input file\.

**\(Automatic\) Inputs:Width**  
The detected width of the input file, in pixels\.

**\(Automatic\) Inputs:Height**  
The detected height of the input file, in pixels\.

**\(Automatic\) Inputs:FrameRate**  
The detected frame rate of the input file, in frames per second\.

**\(Automatic\) Inputs:FileSize**  
The detected file size of the input file, in bytes\.

**\(Automatic\) Inputs:DurationMillis**  
The detected duration of the input file, in milliseconds\.

**\(Automatic\) Outputs:Id**  
A sequential counter, starting with 1, that identifies an output among the outputs from the current job\. In the `Output` syntax, this value is always `1`\.

**\(Automatic\) Outputs:Duration**  
Duration of the output file in seconds, rounded up\.

**\(Automatic\) Outputs:DurationMillis**  
Duration of the output file, in milliseconds\.

**\(Automatic\) Outputs:Width**  
Width of the output file, in pixels\.

**\(Automatic\) Outputs:Height**  
Height of the output file, in pixels\.

**\(Automatic\) Outputs:FrameRate**  
Frame rate of the output file, in frames per second\.

**\(Automatic\) Outputs:FileSize**  
File size of the output file, in bytes\.

**\(Automatic\) Outputs:Status**  
The status of one output in a job\. If you specified only one output for the job, `Outputs:Status` is always the same as `Job:Status`\. If you specified more than one output:  
+ `Job:Status` and `Outputs:Status` for all of the outputs is `Submitted` until Elastic Transcoder starts to process the first output\.
+ When Elastic Transcoder starts to process the first output, `Outputs:Status` for that output and `Job:Status` both change to `Progressing`\. For each output, the value of `Outputs:Status` remains `Submitted` until Elastic Transcoder starts to process the output\.
+ `Job:Status` remains `Progressing` until all of the outputs reach a terminal status, either `Complete` or `Error`\.
+ When all of the outputs reach a terminal status, `Job:Status` changes to `Complete` only if `Outputs:Status` for all of the outputs is `Complete`\. If `Outputs:Status` for one or more outputs is `Error`, the terminal status for `Job:Status` is also `Error`\.
The value of `Status` is one of the following: `Submitted`, `Progressing`, `Complete`, `Canceled`, or `Error`\.

**\(Automatic\) Outputs:StatusDetail**  
Information that further explains `Outputs:Status`\.

**\(Automatic\) Outputs:AppliedColorSpaceConversion**  
If Elastic Transcoder used a preset with a `ColorSpaceConversionMode` to transcode the output file, the `AppliedColorSpaceConversion` parameter shows the conversion used\. If no `ColorSpaceConversionMode` was defined in the preset, this parameter will not be included in the job response\.

**\(Automatic\) Status**  
If you specified more than one output for the job, the status of the entire job\. When Elastic Transcoder starts processing a job, the value of `Job:Status` changes to `Progressing` and doesn't change until Elastic Transcoder has finished processing all outputs\. When processing is complete, `Job:Status` changes either to `Complete` or, if any of the outputs failed, to `Error`\.  
If you specified only one output for the job, `Job:Status` is the same as `Outputs:Status`\.   
The value of `Job:Status` is one of the following: `Submitted`, `Progressing`, `Complete`, `Canceled`, or `Error`\.

**\(Automatic\) Timing**  
The details about the timing of a job\.

**\(Automatic\) Timing:SubmitTimeMillis**  
The time the job was submitted to Elastic Transcoder, in epoch milliseconds\.

**\(Automatic\) Timing:StartTimeMillis**  
The time the job began transcoding, in epoch milliseconds\.

**\(Automatic\) Timing:FinishTimeMillis**  
The time the job finished transcoding, in epoch milliseconds\.  
To learn more about epoch time, go to the [ Epoch Computing](https://en.wikipedia.org/wiki/Epoch_%28reference_date%29#Computing) page on Wikipedia\.

## Errors<a name="get-job-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

## Examples<a name="get-job-examples"></a>

### Sample Request<a name="get-job-examples-sample-request-1"></a>

The following example request gets the job that has the job ID 3333333333333\-abcde3\.

```
GET /2012-09-25/jobs/3333333333333-abcde3 HTTP/1.1
Content-Type: charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
```

### Sample Response<a name="get-job-examples-sample-response-1"></a>

```
Status: 200 OK
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Job":{
      "Id":"3333333333333-abcde3",
      "Inputs":[{
         "Key":"cooking/lasagna.mp4",
         "FrameRate":"auto",
         "Resolution":"auto",
         "AspectRatio":"auto",
         "Interlaced":"auto",
         "Container":"mp4",
         "InputCaptions":{
            "MergePolicy":"MergeOverride",
            "CaptionSources":[
               {
                  "Key":"scc/lasagna-kindlefirehd.scc",
                  "Language":"en",
                  "Label":"English"
               },
               {
                  "Key":"srt/lasagna-kindlefirehd.srt",
                  "Language":"fr",
                  "TimeOffset":"1:00:00",
                  "Label":"French"
               }
            ],
         }
         "DetectedProperties":{
            "Width":"1280",
            "Height":"720",
            "FrameRate":"30.00",
            "FileSize":"5872000",
            "DurationMillis":"1003000"
         }
      }],
      "OutputKeyPrefix":"",
      "Outputs":[
         {
            "Id":"1",
            "Key":"mp4/lasagna-kindlefirehd.mp4",
            "ThumbnailPattern":"mp4/thumbnails/lasagna-{count}",
            "Rotate":"0",
            "PresetId":"1351620000000-100080",
            "Watermarks":[
               {
                  "InputKey":"logo/128x64.png",
                  "PresetWatermarkId":"company logo 128x64",
               }
            ],
            "Duration":"1003",
            "DurationMillis":"1003000",
            "Width":"1280",
            "Height":"720",
            "FrameRate":"30.00",
            "FileSize":"5872000",
            "Status":"Progressing",
            "StatusDetail":"",
            "Captions":{
               "CaptionFormats":[
                  {
                     "Format":"scc",
                     "Pattern":"scc/lasagna-{language}",
                  },
                  {
                     "Format":"srt",
                     "Pattern":"srt/lasagna-{language}",
                  },
                  {
                     "Format":"mov-text"
                  }
               ]
            }
         },
         {
            "Id":"2",
            "Key":"iphone/lasagna-1024k",
            "ThumbnailPattern":"iphone/th1024k/lasagna-{count}",
            "Rotate":"0",
            "PresetId":"1351620000000-987654",
            "SegmentDuration":"5",
            "Duration":"1003",
            "DurationMillis":"1003000",
            "Width":"1136",
            "Height":"640",
            "FrameRate":"30.00",
            "FileSize":"4718600",
            "Status":"Progressing",
            "StatusDetail":"",
            "AppliedColorSpaceConversion":"None"
         },
         {
            "Id":"3",
            "Key":"iphone/lasagna-512k",
            "ThumbnailPattern":"iphone/th512k/lasagna-{count}",
            "Rotate":"0",
            "PresetId":"1351620000000-456789",
            "SegmentDuration":"5",
            "Duration":"1003",
            "DurationMillis":"1003000",
            "Width":"1136",
            "Height":"640",
            "FrameRate":"30.00",
            "FileSize":"3508900",
            "Status":"Complete",
            "StatusDetail":""
         }
      ],
      "Playlists":[
         {
            "Format":"HLSv3",
            "Name":"playlist-iPhone-lasagna.m3u8",
            "OutputKeys":[
               "iphone/lasagna-1024k",
               "iphone/lasagna-512k"
            ]
         }
      ],
      "UserMetadata":
         {
            "Food type":"Italian",
            "Cook book":"recipe notebook"
         },
      "PipelineId":"1111111111111-abcde1",
      "Status":"Progressing",
      "Timing":{
         "SubmitTime":"1427212800000",
         "StartTime":"1427212856000",
         "FinishTime":"1427212875000"
      }
   }
}
```