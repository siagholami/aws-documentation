# Create Job<a name="create-job"></a>

**Topics**
+ [Description](#create-job-description)
+ [Requests](#create-job-requests)
+ [Responses](#create-job-responses)
+ [Errors](#create-job-response-errors)
+ [Examples](#create-job-examples)

## Description<a name="create-job-description"></a>

To create a job, send a POST request to the `/2012-09-25/jobs` resource\. Jobs start as soon as you create them\.

**Note**  
You can configure Elastic Transcoder to notify you when the status of a job changes, including when Elastic Transcoder starts and finishes processing a job, and when Elastic Transcoder encounters a warning or error condition\. For more information, see [Create Pipeline](create-pipeline.md)\.

## Requests<a name="create-job-requests"></a>

### Syntax<a name="create-job-request-syntax"></a>

```
POST /2012-09-25/jobs HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
{
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
      "Resolution":"auto",
      "AspectRatio":"auto|1:1|4:3|3:2|16:9",
      "Interlaced":"auto|true|false",
      "Container":"auto|aac|asf|avi|divx|flv|m4a|mkv|mov|mp2|mp3|
         mp4|mpeg|mpeg-ps|mpeg-ts|mxf|ogg|vob|wav|webm",
      "InputCaptions":{
	        "MergePolicy":"MergeOverride|MergeRetain|Override",
            "CaptionSources":[
               {
                  "Key":"name of the input caption file",
                  "Encryption":{
                     "Mode":"aes-cbc-pkcs7|aes-ctr|aes-gcm",
                     "Key":"encrypted and base64-encoded encryption key",
                     "KeyMd5":"base64-encoded key digest",
                     "InitializationVector":"base64-encoded 
                        initialization vector"
                  },
                  "Language":"language of the input caption file",
                  "TimeOffset":"starting place of the captions, in
                     either [-+]SS.sss or [-+]HH:mm:SS.ss",
                  "Label":"label for the caption"
               },
               {...}
            ]
         }
      },
      {...}
   ]
   "OutputKeyPrefix":"prefix for file names in Amazon S3 bucket",
   "Outputs":[{
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
            "PresetWatermarkId":"value of Video:Watermarks:Id in preset"
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
         {...}
      ],
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
      }
   },
   {...}],
   "Playlists":[{
      "Format":"HLSv3|HLSv4|MPEG-DASH|Smooth",
      "Name":"name", 
      "OutputKeys":[
         "Outputs:Key to include in this playlist",
         ...
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
   {...}],
   "UserMetadata": {
      "Key":"Value",
      "Second user metadata key":"Second user metadata value"
   },
   "PipelineId":"pipeline to use for transcoding"
}
```

### Request Parameters<a name="create-job-request-parameters"></a>

This operation does not use request parameters\.

### Request Headers<a name="create-job-request-headers"></a>

This operation uses only request headers that are common to all operations\. For information about common request headers, see [HTTP Header Contents](making-http-requests.md#http-request-header)\.

### Request Body<a name="create-job-request-body"></a>

The JSON string in the request body contains the input objects for the `CreateJob` operation\. For more information about the input objects, see [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

## Responses<a name="create-job-responses"></a>

### Syntax<a name="create-job-response-syntax"></a>

```
Status: 201 Created
				
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Job":{
      "[Id](#create-job-response-job-id)":"Id that Elastic Transcoder assigns to the job",
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
            "[Id](#create-job-response-output-id)":"sequential counter",
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
               {...}
            ], 
         "[Duration](#create-job-response-output-duration)":"duration in seconds",
         "[Width](#create-job-response-output-width)":"width in pixels",
         "[Height](#create-job-response-output-height)":"height in pixels",
         "[Status](#create-job-response-output-status)":"Submitted|Progressing|Complete|Canceled|Error",
         "[StatusDetail](#create-job-response-output-status-detail)":"additional information about job status",
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
         "[AppliedColorSpaceConversion](#create-job-response-output-color-space)":"None|Bt601ToBt709|
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
               ...
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
      "UserMetadata":{
         "key1":"First user metadata value",
         "key2":"Second user metadata value"
      },
      "PipelineId":"pipeline to add the job to",
      "[Status](#create-job-response-job-status)":"Submitted|Progressing|Complete|Canceled|Error"
   }
}
```

### Response Headers<a name="create-job-response-headers"></a>

This operation uses only response headers that are common to most responses\. For information about common response headers, see [HTTP Responses](making-http-requests.md#http-response-header)\.

### Response Body<a name="create-job-response-body"></a>

When you create a job, Elastic Transcoder returns the values that you specified in the request\. For more information, see [Settings that You Specify When You Create an Elastic Transcoder Job](job-settings.md)\.

In addition, Elastic Transcoder returns the following values\.

**\(Automatic\) Id**  
The identifier that Elastic Transcoder assigned to the job\. You use this value to get settings for the job or to delete the job\.

**\(Automatic\) Outputs:Id**  
A sequential counter, starting with 1, that identifies an output among the outputs from the current job\. In the `Output` syntax, this value is always `1`\.

**\(Automatic\) Outputs:Duration**  
Duration of the output file in seconds, rounded up\.

**\(Automatic\) Outputs:Width**  
Width of the output file, in pixels\.

**\(Automatic\) Outputs:Height**  
Height of the output file, in pixels\.

**\(Automatic\) Outputs:Status**  
The status of one output in a job\. If you specified only one output for the job, `Outputs:Status` is always the same as `Job:Status`\. If you specified more than one output:  
+ `Job:Status` and `Outputs:Status` for all of the outputs is `Submitted` until Elastic Transcoder starts to process the first output\.
+ When Elastic Transcoder starts to process the first output, `Outputs:Status` for that output and `Job:Status` both change to `Progressing`\. For each output, the value of `Outputs:Status` remains `Submitted` until Elastic Transcoder starts to process the output\.
+ `Job:Status` remains `Progressing` until all of the outputs reach a terminal status, either `Complete` or `Error`\.
+ When all of the outputs reach a terminal status, `Job:Status` changes to `Complete` only if `Outputs:Status` for all of the outputs is `Complete`\. If `Outputs:Status` for one or more outputs is `Error`, the terminal status for `Job:Status` is also `Error`\.
The value of `Status` is one of the following: `Submitted`, `Progressing`, `Complete`, `Canceled`, or `Error`\.

**\(Automatic\) Outputs:StatusDetail**  
Information that further explains `Outputs:Status`\.

** \(Automatic\) Outputs:AppliedColorSpaceConversion**  
If Elastic Transcoder used a preset with a `ColorSpaceConversionMode` to transcode the output file, the `AppliedColorSpaceConversion` parameter shows the conversion used\. If no `ColorSpaceConversionMode` was defined in the preset, this parameter will not be included in the job response\.

**\(Automatic\) Status**  
If you specified more than one output for the job, the status of the entire job\. When Elastic Transcoder starts processing a job, the value of `Job:Status` changes to `Progressing` and doesn't change until Elastic Transcoder has finished processing all outputs\. When processing is complete, `Job:Status` changes either to `Complete` or, if any of the outputs failed, to `Error`\.  
If you specified only one output for the job, `Job:Status` is the same as `Outputs:Status`\.   
The value of `Job:Status` is one of the following: `Submitted`, `Progressing`, `Complete`, `Canceled`, or `Error`\.

## Errors<a name="create-job-response-errors"></a>

For information about Elastic Transcoder exceptions and error messages, see [Handling Errors in Elastic Transcoder](error-handling.md)\.

**Note**  
If a job fails with an `Access Denied` error, we recommend that you run the `Test Role` API action to determine what is causing the error\. For more information, see [Test Role](test-pipeline-role.md)\.

## Examples<a name="create-job-examples"></a>

The following example request creates a job that has two outputs\.

### Sample Request<a name="create-job-examples-sample-request"></a>

```
POST /2012-09-25/jobs HTTP/1.1
Content-Type: application/json; charset=UTF-8
Accept: */*
Host: elastictranscoder.Elastic Transcoder endpoint.amazonaws.com:443
x-amz-date: 20130114T174952Z
Authorization: AWS4-HMAC-SHA256 
               Credential=AccessKeyID/request-date/Elastic Transcoder endpoint/elastictranscoder/aws4_request,
               SignedHeaders=host;x-amz-date;x-amz-target,
               Signature=calculated-signature
Content-Length: number of characters in the JSON string
{
   "Inputs":[{
      "Key":"recipes/lasagna.mp4",
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
         ]
      }
   }]
   "OutputKeyPrefix":"recipes/",
   "Outputs":[
      {
         "Key":"mp4/lasagna-kindlefirehd.mp4",
         "ThumbnailPattern":"mp4/thumbnails/lasagna-{count}",
         "Rotate":"0",
         "PresetId":"1351620000000-100080",
         "Watermarks":[
            {
               "InputKey":"logo/128x64.png",
               "PresetWatermarkId":"company logo 128x64"
            }
         ],
         "Captions":{
            "CaptionFormats":[
               {
                  "Format":"scc",
                  "Pattern":"scc/lasagna-{language}"
               },
               {
                  "Format":"srt",
                  "Pattern":"srt/lasagna-{language}",
               }
            ]
         }
      },
      {
         "Key":"iphone/lasagna-1024k",
         "ThumbnailPattern":"iphone/th1024k/lasagna-{count}",
         "Rotate":"0",
         "PresetId":"1351620000000-987654",
         "SegmentDuration":"5"
      },
      {
         "Key":"iphone/lasagna-512k",
         "ThumbnailPattern":"iphone/th512k/lasagna-{count}",
         "Rotate":"0",
         "PresetId":"1351620000000-456789",
         "SegmentDuration":"5"
      },
   ],
   "Playlists": [
      {
         "Format": "HLSv3",
         "Name": "playlist-iPhone-lasagna.m3u8",
         "OutputKeys": [
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
   "PipelineId":"1111111111111-abcde1"
}
```

### Sample Response<a name="create-job-examples-sample-response"></a>

```
Status: 201 Created
x-amzn-RequestId: c321ec43-378e-11e2-8e4c-4d5b971203e9
Content-Type: application/json
Content-Length: number of characters in the response
Date: Mon, 14 Jan 2013 06:01:47 GMT

{
   "Job":{
      "Id":"3333333333333-abcde3",
      "Inputs":[{
         "Key":"recipes/lasagna.mp4",
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
            ]
         }
      }],
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
            "Width":"1280",
            "Height":"720",
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
            "Width":"1136",
            "Height":"640",
            "Status":"Progressing",
            "StatusDetail":""
         },
         {
            "Id":"3",
            "Key":"iphone/lasagna-512k",
            "ThumbnailPattern":"iphone/th512k/lasagna-{count}",
            "Rotate":"0",
            "PresetId":"1351620000000-456789",
            "SegmentDuration":"5",
            "Duration":"1003",
            "Width":"1136",
            "Height":"640",
            "Status":"Complete",
            "StatusDetail":"",
            "AppliedColorSpaceConversion":"None"
         }
      ],
      "Playlists":[
         {
            "Format":"HLSv3",
            "Name":"playlist-iPhone-lasagna.m3u8",
            "OutputKeys": [
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
      "Status":"Progressing"
   }
}
```