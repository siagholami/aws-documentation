# Live Content Ad Behavior<a name="ad-behavior-live"></a>

In live streams, AWS Elemental MediaTailor always performs ad replacement, preserving the total time between the ad markers as closely as possible\. When ad markers include the `DURATION` attribute, MediaTailor uses the value to determine the duration of the ad avail\. Every `CUE-OUT` indicator must have a matching `CUE-IN` indicator in live workflows\. 

MediaTailor performs ad replacement for HLS and DASH live content\. For information on how MediaTailor calculates ad avail placement and timing, see [HLS Supported Ad Markers](hls-ad-markers.md) and [DASH Ad Markers](dash-ad-markers.md)\. 

## Ad Selection and Replacement<a name="ad-behavior-live-ad-selection"></a>

AWS Elemental MediaTailor includes ads from the ADS VAST response as follows: 
+ If a duration is specified, MediaTailor selects a set of ads that fit into the duration and includes them\. 
+ If no duration is specified, MediaTailor plays as many ads as it can until it encounters an ad marker that indicates a return to the main content\.

AWS Elemental MediaTailor adheres to the following guidelines during live ad replacement: 
+ MediaTailor tries to play complete ads, without clipping or truncation\.
+ Whenever MediaTailor encounters an ad marker that indicates an end to the ad avail, it returns to the underlying content\. This can mean shortening an ad that is currently playing\. 
+ At the end of the duration, MediaTailor returns to the underlying content\.
+ If MediaTailor runs out of ads to play for the duration indicated, it plays the slate, if one is configured, or it returns to the underlying content\. This happens most commonly when the ads that are available don't completely fill up the duration\. This can also happen when the ADS response doesn't provide enough ads to fill the ad avail\.

## Examples<a name="ad-behavior-live-examples"></a>
+ If the ad avail has a duration set to 70 seconds and the ADS response contains two 40\-second ads, AWS Elemental MediaTailor plays one of the 40\-second ads\. In the time left over, it switches to the configured slate or underlying content\. At any point during this process, if MediaTailor encounters a cue\-in indicator, it cuts immediately to the underlying content\. 
+ If the ad avail has a duration set to 30 seconds and the shortest ad provided by the ADS response is 40 seconds, MediaTailor plays no ads\. If an ad slate is configured, MediaTailor plays that for 30 seconds or until it encounters a cue\-in indicator\. Otherwise, MediaTailor plays the underlying content\.

## Pre\-Roll Ad Insertion<a name="ad-behavior-preroll"></a>

MediaTailor can insert ads at the beginning of a playback session, before the main content begins\. These are *pre\-roll* ads\. 

To insert pre\-roll ads, complete the **Live pre\-roll ad decision server** and **Live pre\-roll maximum allowed duration** fields in the **Additional** settings on your configuration, as described in [Additional Configuration Fields](configurations-create-addl.md)\. 

1. When MediaTailor receives a playback request, it sends a request to for pre\-roll ads based on the following fields in the MediaTailor playback configuration:
   + **Live pre\-roll ad decision server** is the ad decision server \(ADS\) URL where MediaTailor sends the request for pre\-roll ads\. 
   + **Live pre\-roll maximum allowed duration** is the total maximum length of time for the pre\-roll ads\. MediaTailor takes the following action based on the maximum allowed duration:
     + If the total duration of the ads in the ADS response is *less* than the value you gave in **Live pre\-roll maximum allowed duration**, MediaTailor inserts all of the ads\. When the last ad is complete, MediaTailor immediately returns to the underlying content\.
     + If the total duration of the ads in the ADS response is *more* than the value you gave in **Live pre\-roll maximum allowed duration**, MediaTailor selects a set of ads that fit into the duration without going over\. MediaTailor inserts these ads without clipping or truncation\. MediaTailor returns to the underlying content when the last selected ad completes\.

1. When MediaTailor receives the pre\-roll response from the ADS, it manipulates the manifest to add links to the pre\-roll ads\. MediaTailor calculates the start time of the pre\-roll ad avail as follows:
   + For DASH, the formula is `(publishTime - availabilityStartTime) - max(suggestedPresentationDelay, minBufferTime)`\.
   + For HLS, the formula is `max(2*EXT-X-TARGETDURATION, EXT-X-START:TIMEOFFSET)`\.

1. MediaTailor determines what action to take on any ad avails that aren't pre\-rolls\. If the pre\-roll overlaps another ad avail, MediaTailor doesn't personalize the overlapped portion of the ad avail\. 