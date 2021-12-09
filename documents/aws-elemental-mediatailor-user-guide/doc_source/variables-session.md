# Session Data<a name="variables-session"></a>

To configure AWS Elemental MediaTailor to send session data to the ADS, in the template ADS URL, specify one or more of the variables listed in this section\. You can use individual variables, and you can concatenate multiple variables to create a single value\. MediaTailor generates some values and obtains the rest from sources like the manifest and the player's session initialization request\. 

You can use the following session data variables in your template ADS request URL configuration: 
+ **\[avail\.random\]** – a random number between 0 and 10,000,000,000 that MediaTailor generates for each request to the ADS\. Some ad servers use this parameter to enable features such as separating ads from competing companies\.
+ **\[scte\.avail\_num\]** – the value parsed by MediaTailor from the SCTE\-35 field `avail_num`\. MediaTailor can use this value to designate linear ad avail numbers\.
+ **\[scte\.event\_id\]** – the value parsed by MediaTailor from the SCTE\-35 field `splice_event_id`, as a long number\. MediaTailor uses this value to designate linear ad avail numbers or to populate ad server query strings, like ad pod positions\.
+ **\[scte\.unique\_program\_id\]** – the value parsed by MediaTailor from the SCTE\-35 `splice_insert` field `unique_program_id`\. The ADS uses the unique program ID \(UPID\) to provide program\-level ad targeting for live linear streams\. If the SCTE\-35 command is not splice insert, MediaTailor sets this to an empty value\.
+ **\[session\.avail\_duration\_ms\]** – the duration in milliseconds of the ad availability slot\. The default value is 300,000 ms\. AWS Elemental MediaTailor obtains the duration value from the input manifest as follows: 
  + For HLS, MediaTailor obtains the duration from the `#EXT-X-CUE-OUT: DURATION` or from values in the `#EXT-X-DATERANGE` tag\. If the input manifest has a null, invalid, or 0 duration for the ad avail in those tags, MediaTailor uses the default\. 
  + For DASH, MediaTailor obtains the duration value from the event duration, if one is specified\. Otherwise, it uses the default value\. 
+ **\[session\.avail\_duration\_secs\]** – the duration in seconds of the ad availability slot, or ad avail\. MediaTailor determines this value the same way it determines `[session.avail_duration_ms]`\.
+ **\[session\.client\_ip\]** – the remote IP address that the MediaTailor request came from\. If the `X-forwarded-for` header is set, then that value is what MediaTailor uses for the `client_ip`\.
+ **\[session\.id\]** – a unique numeric identifier for the current playback session\. All requests that a player makes for a session have the same id, so it can be used for ADS fields that are intended to correlate requests for a single viewing\.
+ **\[session\.referer\]** – usually, the URL of the page that is hosting the video player\. MediaTailor sets this variable to the value of the `Referer` header that the player used in its request to MediaTailor\. If the player doesn't provide this header, MediaTailor leaves the **\[session\.referer\]** empty\. If you use a CDN or proxy in front of the manifest endpoint and you want this variable to appear, proxy the correct header from the player here\.
+ **\[session\.user\_agent\]** – the `User-Agent` header that MediaTailor received from the player’s session initialization request\. If you're using a CDN or proxy in front of the manifest endpoint, you must proxy the correct header from the player here\.
+ **\[session\.uuid\]** – alternative to **\[session\.id\]**\. This is a unique identifier for the current playback session, such as the following: 

  ```
  e039fd39-09f0-46b2-aca9-9871cc116cde
  ```

**Example Examples**  
If the ADS requires a query parameter named `deviceSession` to be passed with the unique session identifier, the template ADS URL in AWS Elemental MediaTailor could look like the following:  

```
https://my.ads.server.com/path?deviceSession=[session.id]
```
AWS Elemental MediaTailor automatically generates a unique identifier for each stream, and enters the identifier in place of `session.id`\. If the identifier is `1234567`, the final request that MediaTailor makes to the ADS would look something like this:  

```
https://my.ads.server.com/path?deviceSession=1234567
```