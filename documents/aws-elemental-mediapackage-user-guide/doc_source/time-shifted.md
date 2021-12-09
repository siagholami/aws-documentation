# Time\-shifted Viewing Reference in AWS Elemental MediaPackage<a name="time-shifted"></a>

Time\-shifted viewing is available with live workflows in AWS Elemental MediaPackage\.

*Time\-shifted viewing* means that viewers can start watching a live stream at a time earlier than "now," allowing them to join from the beginning a show that's already in progress or to watch a show that's already completed\. MediaPackage supports time\-shifted viewing for content that's up to 336 hours \(14 days\) old\. You can enable time\-shifted viewing for some or all of this content by defining the **startover window** on the endpoint\. Content that falls within that window is available for playback when playback requests include valid start and end parameters\. Requests for content outside the window configured on the endpoint result in an HTTP error 404\. 

Alternatively, you can harvest a clip of a live stream and make it available as a video on demand \(VOD\) asset\. For information about harvesting VOD assets, see [Creating Live\-to\-VOD Assets with AWS Elemental MediaPackage](ltov.md)\.

In the following steps, "now" is the current time according to the program date time \(PDT\), when it's present in the source content from the encoder\. If the source content doesn't include PDT information, "now" refers to the MediaPackage ingest time of the most recent segment\.

**To enable time\-shifted viewing**

1. Enable time\-shifted viewing by typing a value for **Startover window** on the AWS Elemental MediaPackage endpoint object\. You can do this through either the MediaPackage console or the REST API\. 

   When requests with start and end parameters that are within the startover window are sent to this endpoint, AWS Elemental MediaPackage generates a manifest for the requested timeframe\. If the start or end parameters are outside of the startover window, the playback request fails\. If no start and end parameters are used, the service generates a standard manifest\.
**Note**  
You might notice that the manifest lags behind real time when you initially create a startover window on an endpoint\. This is because AWS Elemental MediaPackage starts filling the manifest from the start of the window, and works up to "now\." So if you have a 24\-hour startover window, MediaPackage fills the manifest starting 24 hours ago and working up to "now\."

1. Ensure that content requests contain start and end parameters as needed\. AWS Elemental MediaPackage accepts requests for up to 9 or 18 hours of content, depending on the endpoint type\. For information about time\-shifted manifest length quotas by endpoint type, see [Live Hard Quotas](limits-live.md#hard-limits)\.

   For packager\-specific rules about how you can notate the parameters, see [Rules for Start and End Parameters](#start-and-end-parameters-rules)\.

   The start and end parameters determine the time boundaries of the manifest\. These are the expected behaviors based on request start and end parameters:
**Note**  
In all cases, the maximum manifest length is 9 or 18 hours, depending on the endpoint type\.
   + If both start and end parameters are used in the URL, the resulting manifest has a fixed start and end time that correspond to the specified start and end parameters\.

     If the end time is in the future, the tags in the manifest are consistent with a live manifest\. Otherwise, if the end time is in the past, the tags in the manifest are consistent with a video on demand \(VOD\) manifest\. For information about the manifest differences, see [Live and VOD Manifest Reference](what-is-manifest.md)\.
   + If a start parameter is specified but not an end, the resulting manifest has a fixed start time that corresponds to the specified start parameter, and the end of the manifest grows as the live content progresses\. You can use a start time that’s up to 9 or 18 hours in the past, depending on the endpoint type\.
**Note**  
For HLS output, many playback devices start playback at the current time \("now"\)\. To view the content from the actual start time of the playback window, viewers can seek back on the playback progress bar\.
   + If no parameters are specified, a standard manifest is generated starting "now" with no end time\.
   + If an end parameter is specified but no start, the manifest is generated in the same way as when no parameters are specified\. The manifest starts "now" and has no end time\.

## Rules for Start and End Parameters<a name="start-and-end-parameters-rules"></a>

Start and end parameters denote the beginning and end of a time\-shifted manifest\. The playback device can append parameters to the end of a manifest request or include the parameters within the request\. 

In all cases, the date and time must be notated in one of the following formats:
+ ISO 8601 dates, such as 2017\-08\-18T21:18:54\+00:00
+ POSIX \(or Epoch\) time, such as 1503091134

The following topics describe the location rules by packager type\.

### DASH Parameter Rules<a name="parameter-rules-dash"></a>

Start and end parameters in the URL request for DASH content can use standard parameter notation, or can be included as path elements in the URL\. 
+ Query parameter notation – start and end parameters are included at the end of the request URL  
**Example**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/997cbb27697d4863bb65488133bff26f/sports.mpd?start=1513717228&end=1513720828
  ```
+ Path elements – start and end parameters are included in the path of the request URL  
**Example**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/997cbb27697d4863bb65488133bff26f/start/2017-12-19T13:00:28-08:00/end/2017-12-19T14:00:28-08:00/sports.mpd
  ```

### HLS and CMAF Parameter Rules<a name="allowed-parameter-location-hls"></a>

Start and end parameters in the URL request for HLS content can use standard parameter notation, or can be included as path elements in the URL\. The rules for HLS and CMAF are the same, except that when you're inserting path elements in the CMAF endpoint, the elements have to be after the manifest ID in the URL\.
+ Query parameter notation – start and end parameters are included at the end of the request URL  
**Example HLS**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/064134724fd74667ba294657a674ae72/comedy.m3u8?start=2017-12-19T13:00:28-08:00&end=2017-12-19T14:00:28-08:00
  ```  
**Example CMAF**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/064134724fd74667ba294657a674ae72/manifest_id/news.m3u8?start=2018-04-04T01:14:00-08:00&2018-04-04T02:15:00-08:00
  ```
+ Path elements – start and end parameters are included in the path of the request URL  
**Example HLS**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/064134724fd74667ba294657a674ae72/start/1513717228/end/1513720828/comedy.m3u8
  ```  
**Example CMAF**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/064134724fd74667ba294657a674ae72/manifest_id/start/1522807213/end/1522800013/news.m3u8
  ```

### Microsoft Smooth Parameter Rules<a name="allowed-parameter-location-mss"></a>

Start and end parameters in the URL request for Microsoft Smooth Streaming content can be included as path elements in the URL\. 
+ Path elements – start and end parameters are included in the path of the request URL  
**Example**  

  ```
  https://cf98fa7b2ee4450e.mediapackage.us-east-1.amazonaws.com/out/v1/1f76b3b4f94c44a485c0e4e560afe50e/start/1513717228/end/1513720828/drama.ism/Manifest
  ```