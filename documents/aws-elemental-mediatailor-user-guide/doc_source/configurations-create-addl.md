# Additional Configuration Fields<a name="configurations-create-addl"></a>

Choose **Additional configuration** to complete optional fields, described here\.

**Slate ad**  
Enter the URL for a high\-quality MP4 asset to transcode and use to fill in time that's not used by ads\. AWS Elemental MediaTailor shows the slate to fill in gaps in media content\. Configuring the slate is optional for non\-VPAID configurations\. For VPAID, you must configure a slate, which MediaTailor provides in the slots designated for dynamic ad content\. The slate must be a high\-quality MP4 asset that contains both audio and video\. For more information, see [Slate Management](slate-management.md)\.  
If the server that hosts your slate uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) Otherwise, AWS Elemental MediaTailor can't retrieve and stitch the slate into the manifests from the content origin\.

**Transcode Profile Name**  
The name that associates this configuration with a custom transcode profile\. This name overrides the dynamic transcoding defaults of MediaTailor\. Complete this field only if you have already set\-up custom profiles with the help of AWS Support\.

**Live pre\-roll ad decision server**  
To insert ads at the start of a live stream before the main content starts playback, enter the URL for the ad pre\-roll from the ad decision server \(ADS\)\. This is either the URL with variables as described in [Step 3: Configure ADS Request URL and Query Parameters](getting-started.md#getting-started-configure-request), or the static VAST URL that you are using for testing purposes\. The maximum length is 25,000 characters\.  
If your ADS uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) The same also applies to mezzanine ad URLs returned by the ADS\. Otherwise, AWS Elemental MediaTailor can't retrieve and stitch ads into the manifests from the content origin\.
For information about how pre\-roll works, see [Pre\-Roll Ad Insertion](ad-behavior-live.md#ad-behavior-preroll)\.

**Live pre\-roll maximum allowed duration**  
When you're inserting ads at the start of a live stream, enter the maximum allowed duration for the pre\-roll ad avail\. MediaTailor won't go over this duration when inserting ads\. If the response from the ADS contains more ads than will fit in this duration, MediaTailor fills the avail with as many ads as possible, without going over the duration\. For more details about how MediaTailor fills avails, see [Live Content Ad Behavior](ad-behavior-live.md)\.

**CDN content segment prefix**  
Enables AWS Elemental MediaTailor to create manifests with URLs to your CDN path for content segments\. Before you do this step, set up a rule in your CDN to pull segments from your origin server\. For **CDN content segment prefix**, enter the CDN prefix path\.  
For more information about integrating MediaTailor with a CDN, see [CDN Integration with AWS Elemental MediaTailor](integrating-cdn.md)\.

**CDN ad segment prefix**  
Enables AWS Elemental MediaTailor to create manifests with URLs to your own CDN path for ad segments\. By default, MediaTailor serves ad segments from an internal Amazon CloudFront distribution with default cache settings\. Before you can complete the **CDN ad segment prefix** field, you must set up a rule in your CDN to pull ad segments from the following origin, like in the following example\.  

```
https://segments.mediatailor.<region>.amazonaws.com
```
For **CDN ad segment prefix**, enter the name of your CDN prefix in the configuration\.  
For more information about integrating MediaTailor with a CDN, see [CDN Integration with AWS Elemental MediaTailor](integrating-cdn.md)\.

**DASH mpd location**  
\(Optional as needed for DASH\) Choose **DISABLED** if you have CDN routing rules set up for accessing MediaTailor manifests and you are either using client\-side reporting or your players support sticky HTTP redirects\.   
For more information about the **Location** feature, see [DASH Location Feature](dash-location-feature.md)\.

**DASH origin manifest type**  
If your origin server produces single\-period DASH manifests, open the dropdown list and choose **SINGLE\_PERIOD**\. By default, MediaTailor handles DASH manifests as multi\-period manifests\. For more information, see [DASH \.mpd Manifests](manifest-dash.md)\.