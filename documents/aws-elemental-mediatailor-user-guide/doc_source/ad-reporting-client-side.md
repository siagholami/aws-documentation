# Client\-side Reporting<a name="ad-reporting-client-side"></a>

With client\-side reporting, AWS Elemental MediaTailor proxies the ad tracking URL to the client player\. The player then performs all ad\-tracking activities\. 

Client\-side reporting enables functionality like the following: 
+ Scrubbing behavior, where a viewer can scrub through the video by moving the cursor on the playback bar\.
**Note**  
MediaTailor does not support *trick play* for DASH live or VOD content\. This means that viewers won't see visual feedback during fast forward and rewind\.
+ Advanced playback behaviors that require player development, like no skip\-forward and countdown timers on ad avails\.

Use client\-side reporting for VPAID functionality\. For more information, see [VPAID Handling](vpaid.md)\. The client\-side reporting response includes additional metadata about the VPAID creative\.

**To perform client\-side ad reporting**

1. On the player, construct a JSON message body for the session initialization request to AWS Elemental MediaTailor: 
   + Provide parameters that MediaTailor should pass to the ADS inside an `adsParams` object\. These parameters correspond to `[player_params.param]` settings in the ADS template URL of the MediaTailor configuration\. 
   + Provide parameters that you want MediaTailor to send to the origin server as top\-level objects\. 

   Example: HLS

   ```
   POST master.m3u8
       {
           "adsParams": {
              "deviceType": "ipad"
          }
          "auth_token": "kjhdsaf7gh"
       }
   ```

   Example: DASH

   ```
   POST manifest.mpd
       {
           "adsParams": {
              "deviceType": "ipad"
          }
          "auth_token": "kjhdsaf7gh"
       }
   ```

   For more information about providing dynamic ad variables, see [Dynamic Ad Variables in AWS Elemental MediaTailor](variables.md)\. 

1. From the player, use your constructed JSON to initialize a new MediaTailor playback session\. Format your request like the following\. 

   ```
   POST <mediatailorURL>/v1/session/<hashed-account-id>/<origin-id>/<asset-id>
       {
          "adsParams": {
              "param1": "value1",
              "param2": "value2",
              "param3": "value3"
          }
          "originServerParam1": "originValue1",
          "originServerParam2": "originValue2"
       }
   ```

   AWS Elemental MediaTailor responds to the request with two relative URLs, one for the manifest and one for the tracking endpoint: 
   + Manifest – used to retrieve content manifests and ad segments

     Example: HLS

     ```
     /v1/master/<hashed-account-id>/<origin-id>/<asset-id>?aws.sessionId=<session>
     ```

     Example: DASH

     ```
     /v1/dash/<hashed-account-id>/<origin-id>/<asset-id>?aws.sessionId=<session>
     ```
   + Tracking – used to poll for upcoming ad avails

     Example 

     ```
     /v1/tracking/<hashed-account-id>/<origin-id>/<asset-id>/<session>
     ```

1. Construct the full manifest and tracking URLs by prefixing the relative URLs from MediaTailor with *<mediatailorURL>*\. 

1. Program the player to poll the tracking URL periodically and manage ad avails accordingly\. Poll frequently enough to satisfy your reporting requirements\. If you don't have set requirements, poll at least once per manifest duration\. For example, if the manifest is a 10\-minute rolling window, poll the tracking URL every 5 minutes\. MediaTailor keeps mid\-roll tracking data until all corresponding segments are outside the manifest window\.

   When an ad is coming, the response from AWS Elemental MediaTailor to the player's polling request contains a JSON object that specifies the time offsets for the ad avails\. The offsets are relative to when the player initiated the session\. You can use them when programming specific behaviors in the player, such as preventing the viewer from skipping past the ads\. The response also includes duration, timing, and identification information\. 

   The response from MediaTailor can include the following values:
   + `adId`: For HLS, the sequence number associated with the beginning of the ad\. For DASH, the period ID of the ad\.
   + `adParameters`: String of ad parameters from VAST VPAID, which AWS Elemental MediaTailor passes to the player\.
   + `adSystem`: The name for the system that serves the ad\.
   + `adTitle`: The title for the ad\.
   + `apiFramework`: Set this to `VPAID` to tell the player that this is a VPAID ad\.
   + `availId`: For HLS, the sequence number associated with the start of the ad avail\. For DASH, the period ID of the ad avail, which is usually the period ID of the content that is to be replaced with an ad\.
   + `beaconUrls`: Where to send each ad beacon\.
   + `bitrate`: Bitrate of the video asset\. This is not typically included for an executable asset\.
   + `companionAds`: One or more companion ad content specifications, each of which specifies a resource file to use\. Companion ads accompany the ad avail, and are used to provide content like a frame around the ad or a banner to display near the video\. 
   + `creativeId`: The `Id` attribute of the `Creative` tag for the ad\.
   + `delivery`: This indicates the protocol used, and can be set to either `progressive` or `streaming`\.
   + `duration`: Length in ISO 8601 seconds format\. The response includes durations for the entire ad avail and for each ad and beacon \(though beacon durations are always zero\)\. For [VPAID Handling](vpaid.md), the duration conveyed is the MP4 slate duration\. This duration typically is slightly larger than the XML duration conveyed in VAST due to transcoder and segment duration configurations\. You can interpret this as the maximum amount of time that you have available to fill with a VPAID ad without incurring drift\.
   + `durationInSeconds`: Length in seconds format\. The response includes durations for the entire ad avail and for each ad and beacon \(though beacon durations are always zero\)\.
   + `eventId`: For HLS, the sequence number that is associated with the beacon\. For DASH, the `ptsTime` of the start of the ad\.
   + `eventType`: Type of beacon\.
   + `height`: Height of the video asset\.
   + `maintainAspectRatio`: Indicates whether to maintain the aspect ratio while scaling\.
   + `mediaFilesList`: Specifies video and other assets that the player needs for the ad avail\.
   + `mediaFileUri`: URI that points to either an executable asset or video asset\. Example\. `https://myad.com/ad/ad134/vpaid.js`\. 
   + `mediaType`: Typically either `JavaScript` or `Flash` for executable assets\. 
   + `mezzanine`: The mezzanine MP4 asset, specified if the VPAID ad includes one\. Example\. `https://gcdn.2mdn.net/videoplayback/id/itag/ck2/file/file.mp4`\.
   + `scalable`: Indicates whether to scale the video to other dimensions\.
   + `startTime`: Time position in ISO 8601 seconds format, relative to the beginning of the playback session\. The response includes start times for the entire ad avail and for each ad and beacon\.
   + `startTimeInSeconds`: Time position in seconds format, relative to the beginning of the playback session\. The response includes start times for the entire ad avail and for each ad and beacon\.
   + `vastAdId`: The `Id` attribute of the `Ad` tag\.
   + `width`: Width of the video asset\.

   The following example responses indicate that an ad is coming\.

   ```
   {
     "avails": [
       {
         "ads": [
           {
             "adId": "8104385",
             "duration": "PT15.100000078S",
             "durationInSeconds": 15.1,
             "startTime": "PT17.817798612S",
             "startTimeInSeconds": 17.817,
             "trackingEvents": [
   		  {
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=impression"
                 ],
                 "duration": "PT15.100000078S",
                 "durationInSeconds": 15.1,
                 "eventId": "8104385",
                 "eventType": "impression",
                 "startTime": "PT17.817798612S",
                 "startTimeInSeconds": 17.817
               },
               {
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=start"
                 ],
                 "duration": "PT0S",
                 "durationInSeconds": 0.0,
                 "eventId": "8104385",
                 "eventType": "start",
                 "startTime": "PT17.817798612S",
                 "startTimeInSeconds": 17.817
               },
   			{
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=firstQuartile"
                 ],
                 "duration": "PT0S",
                 "durationInSeconds": 0.0,
                 "eventId": "8104386",
                 "eventType": "firstQuartile",
                 "startTime": "PT21.592798631S",
                 "startTimeInSeconds": 21.592
               },
   			 {
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=midpoint"
                 ],
                 "duration": "PT0S",
                 "durationInSeconds": 0.0,
                 "eventId": "8104387",
                 "eventType": "midpoint",
                 "startTime": "PT25.367798651S",
                 "startTimeInSeconds": 25.367
               },
               {
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=thirdQuartile"
                 ],
                 "duration": "PT0S",
                 "durationInSeconds": 0.0,
                 "eventId": "8104388",
                 "eventType": "thirdQuartile",
                 "startTime": "PT29.14279867S",
                 "startTimeInSeconds": 29.142
               },
               {
                 "beaconUrls": [
                   "http://exampleadserver.com/tracking?event=complete"
                 ],
                 "duration": "PT0S",
                 "durationInSeconds": 0.0,
                 "eventId": "8104390",
                 "eventType": "complete",
                 "startTime": "PT32.91779869S",
                 "startTimeInSeconds": 32.917
               }
             ]
           }
         ],
         "availId": "8104385",
         "duration": "PT15.100000078S",
         "durationInSeconds": 15.1,
         "meta": null,
         "startTime": "PT17.817798612S",
         "startTimeInSeconds": 17.817
       }
     ]
   }
   ```

   ```
   {
     "avails": [
       {
         "ads": [
           {
             "adId": "6744037",
             "mediaFiles": {
               "mezzanine": "https://gcdn.2mdn.net/videoplayback/id/itag/ck2/file/file.mp4",
               "mediaFilesList": [
                 {
                   "mediaFileUri": "https://myad.com/ad/ad134/vpaid.js",
                   "delivery": "progressive",
                   "width": 176,
                   "height": 144,
                   "mediaType": "application/javascript",
                   "scalable": false,
                   "maintainAspectRatio": false,
                   "apiFramework": "VPAID"
                 },
                 {
                   "mediaFileUri": "https://myad.com/ad/ad134/file.mp4",
                   "delivery": "progressive",
                   "width": 640,
                   "height": 360,
                   "mediaType": "video/mp4",
                   "scalable": false,
                   "maintainAspectRatio": false
                 },
                 ...
               ],
               "adParameters": "[{'ads':[{"url":"https://myads/html5/media/LinearVPAIDCreative.mp4","mimetype":"video/mp4"]}]",
               "duration": "PT15.066667079S",
               "durationInSeconds": 15.066,
               "startTime": "PT39.700000165S",
               "startTimeInSeconds": 39.7,
               "trackingEvents": [
                 {
                   "beaconUrls": [
                     "https://beaconURL.com"
                   ],
                   "duration": "PT15.066667079S",
                   "durationInSeconds": 15.066,
                   "eventId": "6744037",
                   "eventType": "impression",
                   "startTime": "PT39.700000165S",
                   "startTimeInSeconds": 39.7
                 },
                 ...
               ]
             }
           },
           ...
         ],
         "availId": "6744037",
         "duration": "PT45.166667157S",
         "durationInSeconds": 45.166,
         "meta": null,
         "startTime": "PT39.700000165S",
         "startTimeInSeconds": 39.7
       }
     ]
   }
   ```

   ```
   {
       "avails": [
         {
           "ads": [
             {
               "adId": "3348173",
               "adParameters": null,
               "duration": "PT12.700001178S",
               "durationInSeconds": 12.7,
               "mediaFiles": null,
               "startTime": "PT1M56.060003037S",
               "startTimeInSeconds": 116.06,
               "trackingEvents": [],
               "companionAds": [
                 {
                     "sequence": "",
                     "attributes": {
                       "width": "REQUIRED",
                       "height": "REQUIRED",
                       "id": "",
                       "assetWidth": "",
                       "assetHeight": "",
                       "expandedWidth": "",
                       "expandedHeight": "",
                       "apiFramework": "",
                       "adSlotId": "",
                       "pxratio": "",
                       "renderingMode": ""
                     },
                     "staticResource": "",
                     "iFrameResource": "",
                     "htmlResource": "<![CDATA[<!doctype html><html><head><meta name=\"viewport\" content=\"width=1, initial-scale=1.0, minimum-scale=1.     0, . . . ]]>",
                     "adParameters": "",
                     "altText": "",
                     "companionClickThrough": "",
                     "companionClickTracking": "",
                     "trackingEvents": [
                       {
                         "tracking": {}
                       }
                     ]
                 }
               ]
             }
           ],
           "availId": "3348173",
           "duration": "PT12.700001178S",
           "durationInSeconds": 12.7,
           "meta": null,
           "startTime": "PT1M56.060003037S",
           "startTimeInSeconds": 116.06
         }
       ]
     }
   ```