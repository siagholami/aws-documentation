# Integrating AWS Elemental MediaTailor and a CDN<a name="integrating-cdn-standard"></a>

The following steps show how to integrate AWS Elemental MediaTailor with your content distribution network \(CDN\)\. Depending on the CDN that you use, some terminology might differ from what is used in these steps\.

## Step 1: \(CDN\) Create Routing Behaviors<a name="integrating-cdn-standard-cdn-routing"></a>

In the CDN, create behaviors and rules that route playback requests to MediaTailor\. Use the following rules for all segment requests \(content, normal ad avails, and pre\-roll ad avails\):
+ Create one behavior that routes *content segment* requests to the *origin server*\. Base this on a rule that uses a phrase to differentiate content segment requests from ad segment requests\.

  For example, the CDN could route HLS player requests to `https://CDN_Hostname/subdir/content.ts` to the origin server path `http://origin.com/contentpath/subdir/content.ts` based on the keyword `subdir` in the request\. 

  For example, the CDN could route DASH player requests to `https://CDN_Hostname/subdir/content.mp4` to the origin server path `http://origin.com/contentpath/subdir/content.mp4` based on the keyword `subdir` in the request\. 
+ \(Optional\) Create one behavior that routes *ad segment* requests to the internal Amazon CloudFront distribution where AWS Elemental MediaTailor stores transcoded ads\. Base this on a rule that includes a phrase to differentiate ad segment requests from content segment requests\. This step is optional because AWS Elemental MediaTailor provides a default configuration\.

  AWS Elemental MediaTailor uses the following default Amazon CloudFront distributions for storing ads:  
**Example Ad Segment Routing**  

  Pattern: `https://segments.mediatailor.<region>.amazonaws.com`

  Example: `https://segments.mediatailor.eu-west-1.amazonaws.com`

## Step 2: \(AWS Elemental MediaTailor\) Create a Configuration with CDN Mapping<a name="integrating-cdn-standard-config"></a>

Create an AWS Elemental MediaTailor configuration that maps the domains of the CDN routing behaviors to the origin server and to the ad storage location\. Enter the domain names in the configuration as follows:
+ For **CDN content segment prefix**, enter the CDN domain from the behavior that you created to route content requests to the origin server\. In the manifest, MediaTailor replaces the content segment URL prefix with the CDN domain\.

  For example, consider the following settings\. 
  + **Video content source** in the MediaTailor configuration is `http://origin.com/contentpath/` 
  + **CDN content segment prefix** is `https://CDN_Hostname/`

  For HLS, if the full content file path is `http://origin.com/contentpath/subdir/content.ts`, the content segment in the manifest served by MediaTailor is `https://CDN_Hostname/subdir/content.ts`\.

  For DASH, if the full content file path is `http://origin.com/contentpath/subdir/content.mp4`, the content segment in the manifest served by MediaTailor is `https://CDN_Hostname/subdir/content.mp4`\.
+ For **CDN ad segment prefix**, enter the name of the CDN behavior that you created to route ad requests through your CDN\. In the manifest, MediaTailor replaces the Amazon CloudFront distribution with the behavior name\.

## Step 3: \(CDN\) Set up CDN for Manifest and Reporting Requests<a name="integrating-cdn-standard-cache"></a>

Using a CDN for manifest and reporting requests gives you more functionality in your workflow\.

For manifests, referencing a CDN in front of the manifest specification lets you use CDN features such as geofencing, and also lets you serve everything from your own domain name\. For this path, do not cache the manifests because they are all personalized\. Manifest specifications are `/v1/master` for HLS master manifest requests, `/v1/manifest` for HLS media manifest requests, and `/v1/dash` for DASH manifest requests\.

Make sure that your CDN forwards all query parameters to AWS Elemental MediaTailor\. MediaTailor relies on the query parameters to fulfill your VAST requests for personalized ads\. 

For server\-side reporting, referencing a CDN in front of `/v1/segment` in ad segment requests helps prevent AWS Elemental MediaTailor from sending duplicate ad tracking beacons\. When a player makes a request for a `/v1/segment` ad, MediaTailor issues a 301 redirect to the actual `*.ts` segment\. When MediaTailor sees that `/v1/segment` request, it issues a beacon call to track the view percentage of the ad\. If the same player makes multiple requests for the same `/v1/segment` in one session, and your ad decision server \(ADS\) can't de\-duplicate requests, then MediaTailor issues multiple requests for the same beacon\. Using a CDN to cache these 301 responses ensures that MediaTailor doesn't make duplicate beacon calls for repeated requests\. For this path, you can use a high or default cache because cache\-keys for these segments are unique\.

To take advantage of these benefits, create behaviors in the CDN that route requests to the AWS Elemental MediaTailor configuration endpoint\. Base the behaviors that you create on rules that differentiate requests for master HLS manifests, HLS manifests, DASH manifests, and reporting\. 

Requests follow these formats:
+ HLS master manifest format

  ```
  https://<playback-endpoint>/v1/master/<hashed-account-id>/<origin-id>/<master>.m3u8
  ```

  Example

  ```
  https://a57b77e98569478b83c10881a22b7a24.mediatailor.us-east-1.amazonaws.com/v1/master/a1bc06b59e9a570b3b6b886a763d15814a86f0bb/Demo/assetId.m3u8
  ```
+ HLS manifest format

  ```
  https://<playback-endpoint>/v1/manifest/<hashed-account-id>/<session-id>/<manifestNumber>.m3u8
  ```

  Example

  ```
  https://a57b77e98569478b83c10881a22b7a24.mediatailor.us-east-1.amazonaws.com/v1/manifest/a1bc06b59e9a570b3b6b886a763d15814a86f0bb/c240ea66-9b07-4770-8ef9-7d16d916b407/0.m3u8
  ```
+ DASH manifest format

  ```
  https://<playback-endpoint>/v1/dash/<hashed-account-id>/<origin-id>/<assetName>.mpd
  ```

  Example

  ```
  https://a57b77e98569478b83c10881a22b7a24.mediatailor.us-east-1.amazonaws.com/v1/dash/a1bc06b59e9a570b3b6b886a763d15814a86f0bb/Demo/0.mpd
  ```
+ Format for ad reporting request for server\-side reporting

  ```
  https://<playback-endpoint>/v1/segment/<origin-id>/<session-id>/<manifestNumber>/<HLSSequenceNum>
  ```

  Example

  ```
  https://a57b77e98569478b83c10881a22b7a24.mediatailor.us-east-1.amazonaws.com/v1/segment/Demo/240ea66-9b07-4770-8ef9-7d16d916b407/0/440384
  ```

In the CDN, create a behavior that routes manifest requests to the AWS Elemental MediaTailor configuration endpoint\. Base the behavior on a rule that includes a phrase to differentiate the manifest request from segment requests\.

**Example Routing**  
+ Player requests to `https://CDN_Hostname/some/path/asset.m3u8` are routed to the AWS Elemental MediaTailor path `https://mediatailor.us-west-2.amazonaws.com/v1/session/configuration/endpoint` based on the keyword `*.m3u8` in the request\.
+ Player requests to `https://CDN_Hostname/some/path/asset.mpd` are routed to the AWS Elemental MediaTailor path `https://mediatailor.us-west-2.amazonaws.com/v1/dash/configuration/endpoint` based on the keyword `*.mpd` in the request\.