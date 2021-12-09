# Server\-side Reporting<a name="ad-reporting-server-side"></a>

AWS Elemental MediaTailor defaults to server\-side reporting\. With server\-side reporting, when the player requests an ad URL from the manifest, the service reports ad consumption directly to the ad tracking URL\. After the player initializes a playback session with MediaTailor, no further input is required from you or the player to perform server\-side reporting\. As each ad is played back, MediaTailor sends beacons to the ad server to report how much of the ad has been viewed\. MediaTailor sends beacons for the start of the ad and for the ad progression in quartiles: the first quartile, midpoint, third quartile, and ad completion\.

**To perform server\-side ad reporting**
+ From the player, initialize a new MediaTailor playback session using a request in one of the following formats, according to your protocol:
  + Example: HLS format

    ```
    GET <mediatailorURL>/v1/master/<hashed-account-id>/<origin-id>/<asset-id>?ads.<key-value-pairs-for-ads>&<key-value-pairs-for-origin-server>
    ```
  + Example: DASH format

    ```
    GET <mediatailorURL>/v1/dash/<hashed-account-id>/<origin-id>/<asset-id>?ads.<key-value-pairs-for-ads>&<key-value-pairs-for-origin-server>
    ```

  The key\-value pairs are the dynamic targeting parameters for ad tracking\. For information about adding parameters to the request, see [Dynamic Ad Variables in AWS Elemental MediaTailor](variables.md)\.

AWS Elemental MediaTailor responds to the request with the manifest URL\. The manifest contains URLs for the media manifests\. The media manifests contain embedded links for ad segment requests\.

When the player requests playback from an ad segment URL \(`/v1/segment` path\), AWS Elemental MediaTailor sends the appropriate beacon to the ad server through the ad tracking URLs\. At the same time, the service issues a redirect to the actual `*.ts` ad segment\. The ad segment is either in the Amazon CloudFront distribution where MediaTailor stores transcoded ads, or in the content distribution network \(CDN\) where you have cached the ad\. 