# Slate Management<a name="slate-management"></a>

In AWS Elemental MediaTailor, you can configure a URL to an MP4 slate, to be used to fill gaps in media content\. MediaTailor inserts the slate into unfilled and partially filled ad avails\. MediaTailor downloads the slate from the MP4 URL and transcodes it to the same renditions as your content, for smooth transitions between the two\. The slate may be played in a loop if the duration of the remaining ad avail allows for it\. 

Configuring a slate is optional in all situations except where VPAID is used: 
+ For non\-VPAID situations, if you don't configure a slate, MediaTailor handles unfilled and partially filled ad avails by showing the underlying stream content\. 
+ For VPAID, you must configure a slate\. MediaTailor inserts the slate for the duration of the VPAID ad\. In certain cases, to accommodate user interactivity, this duration might be slightly higher than the duration of the VPAID ad as reported by VAST\. The video player then handles the VPAID ad based on the client\-side reporting metadata that MediaTailor returns\. For information about client\-side reporting, see [Client\-side Reporting](ad-reporting-client-side.md)\. For information about VPAID, see [VPAID Handling](vpaid.md)\. 

The slate that you configure must be a high\-quality MP4 asset that contains both audio and video\. Empty audio slates sometimes cause playback issues on some players\. 

AWS Elemental MediaTailor shows the slate for the following situations: 
+ To fill in time that's not fully used by an ad replacement
+ If the ADS responds with a blank VAST or VMAP response
+ For error conditions, such as ADS timeout
+ If ads are longer than the live ad avail window
+ If an ad isn't available

AWS Elemental MediaTailor always shows the slate near the end of the ad avail\.