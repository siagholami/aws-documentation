# Getting Started with AWS Elemental MediaTailor<a name="getting-started"></a>

This Getting Started tutorial shows you how to integrate AWS Elemental MediaTailor into your workflow, including how to create a MediaTailor configuration that holds information about the origin server and ad decision server \(ADS\)\.

**Topics**
+ [Prerequisites](#prerequisites)
+ [Step 1: Access AWS Elemental MediaTailor](#access-emt)
+ [Step 2: Prepare a Stream](#getting-started-prep-stream)
+ [Step 3: Configure ADS Request URL and Query Parameters](#getting-started-configure-request)
+ [Step 4: Create a Configuration](#getting-started-add-mapping)
+ [Step 5: Test the Configuration](#getting-started-test-config)
+ [Step 6: Send the Playback Request to AWS Elemental MediaTailor](#send-request-to-mediatailor)
+ [\(Optional\) Step 7: Monitor AWS Elemental MediaTailor Activity](#monitor-step)
+ [Step 8: Clean Up](#clean-up)

## Prerequisites<a name="prerequisites"></a>

To use AWS Elemental MediaTailor, you need an AWS account and permissions to access, view, and edit MediaTailor configurations\. For information on how to do this, see [Setting Up AWS Elemental MediaTailor](setting-up.md)\.

## Step 1: Access AWS Elemental MediaTailor<a name="access-emt"></a>

Using your IAM credentials, sign in to the MediaTailor console at **https://console\.aws\.amazon\.com/mediatailor/home**\.

## Step 2: Prepare a Stream<a name="getting-started-prep-stream"></a>

Configure your origin server to produce manifests for HLS or DASH that are compatible with AWS Elemental MediaTailor\. 

### Prepare an HLS Stream<a name="getting-started-prep-stream-hls"></a>

HLS manifests must satisfy the following requirements:
+ Manifests must be accessible on the public internet\.
+ Manifests must be live or video\-on\-demand \(VOD\)\.
+ Manifests must have an `EXT-X-VERSION` of `3` or higher\.
+ For live content, manifests must contain markers to delineate ad avails\. This is optional for VOD content, which can use VMAP timeoffsets instead\. 

  The manifest file must have ad slots marked with one of the following:
  + **\#EXT\-X\-CUE\-OUT / \#EXT\-X\-CUE\-IN** \(more common\) with durations as shown in the following example\.

    ```
    #EXT-X-CUE-OUT:60.00
    #EXT-X-CUE-IN
    ```
  + **\#EXT\-X\-DATERANGE** \(less common\) with durations as shown in the following example\.

    ```
    #EXT-X-DATERANGE:ID="",START-DATE="",DURATION=30.000,SCTE35-OUT=0xF
    #EXT-X-DATERANGE:ID="",START-DATE="",DURATION=30.000,SCTE35-OUT=0xF
    ```

    All fields shown for `#EXT-X-DATERANGE` are required\.

  The way that you configure the ad markers in the manifest influences whether ads are inserted in a stream or replace other fragments in the stream\. For more information, see [Ad Behavior in AWS Elemental MediaTailor](ad-behavior.md)\.
+ HLS master manifests must follow the HLS specification documented at [HTTP Live Streaming: Master Playlist Tags](https://tools.ietf.org/html/draft-pantos-http-live-streaming-21#section-4.3.4)\. In particular, `#EXT-X-STREAM-INF` must include the fields `RESOLUTION`, `BANDWIDTH`, and `CODEC`\.

After you have configured the stream, note the content origin URL prefix for the master manifest\. You need it to create the configuration in AWS Elemental MediaTailor, later in this tutorial\.

### Prepare a DASH Stream<a name="getting-started-prep-stream-dash"></a>

DASH manifests must satisfy the following requirements:
+ Manifests must be accessible on the public internet\.
+ Manifests must be live or video on demand \(VOD\)\.
+ Manifests must mark events as ad avails using either splice insert markers or time signal markers\. You can provide the ad markers in clear XML or in base64\-encoded binary\. For splice insert, the out\-of\-network indicator must be enabled\. For time signal markers, the segmentation type ID, located inside the segmentation UPID, must be a cue\-out value recognized by AWS Elemental MediaTailor\. The ad avail starts at the event start and lasts for the event duration, if one is specified, or until the next event starts\. 

  The following example shows an event designated as an ad avail using splice insert markers\. The duration for this ad avail is the event's duration\. 

  ```
    <Period start="PT444806.040S" id="123586" duration="PT15.000S">
      <EventStream timescale="90000" schemeIdUri="urn:scte:scte35:2013:xml">
        <Event duration="1350000">
          <scte35:SpliceInfoSection protocolVersion="0" ptsAdjustment="180832" tier="4095">
            <scte35:SpliceInsert spliceEventId="4026531855" spliceEventCancelIndicator="false" outOfNetworkIndicator="true" spliceImmediateFlag="false" uniqueProgramId="1" availNum="1" availsExpected="1">
              <scte35:Program><scte35:SpliceTime ptsTime="5672624400"/></scte35:Program>
              <scte35:BreakDuration autoReturn="true" duration="1350000"/>
            </scte35:SpliceInsert>
          </scte35:SpliceInfoSection>
        </Event>
      </EventStream>
      <AdaptationSet mimeType="video/mp4" 
          ...
      </AdaptationSet>
    </Period>
  ```
+ Ad avails must have the same `AdaptationSet` and `Representation` settings as content streams\. AWS Elemental MediaTailor uses these settings to transcode the ads to match the content stream, for smooth switching between the two\.

After you configure the stream, note the content origin URL prefix for the DASH manifest\. You need it to create the configuration in AWS Elemental MediaTailor, later in this tutorial\.

## Step 3: Configure ADS Request URL and Query Parameters<a name="getting-started-configure-request"></a>

To determine the query parameters that the ADS requires, generate an ad tag URL from the ADS\. This URL acts as a template for requests to the ADS, and consists of the following:
+ Static values
+ Values generated by AWS Elemental MediaTailor \(denoted by `session` or `avail` query parameters\)
+ Values generated by players, obtained from the client application \(denoted by `player_params.` query parameters\)

**Example Ad tag URL from an ADS**  

```
https://my.ads.com/ad?output=vast&content_id=12345678&playerSession=[session.id]&cust_params=[player_params.cust_params]
```
Where:  
+ **output** and **content\_id** are static values
+ **playerSession=\[session\.id\]** is a dynamic value provided by AWS Elemental MediaTailor\. The value of **\[session\.id\]** changes for each player session and results in a different URL for the VAST request for each session\. 
+ **cust\_params** are player\-supplied dynamic values

The master manifest request from the player must provide key\-value pairs that correspond to the `player_params.` query parameters in the ADS request URL\. For more information about configuring key\-value pairs in the request to AWS Elemental MediaTailor, see [Dynamic Ad Variables in AWS Elemental MediaTailor](variables.md)\.

Enter the configured "template" URL when you create the origin server/ADS mapping in MediaTailor, in [Step 4: Create a Configuration](#getting-started-add-mapping)\.

**Testing**  
You can use a static VAST response from your ADS for testing purposes\. Ideally, the VAST response returns a mezzanine quality MP4 rendition that AWS Elemental MediaTailor can transcode\. If the response from the ADS contains multiple playback renditions, MediaTailor picks the highest quality and resolution MP4 rendition and sends it to the transcoder\.

## Step 4: Create a Configuration<a name="getting-started-add-mapping"></a>

The AWS Elemental MediaTailor configuration holds mapping information for the origin server and ADS\.

**To create a configuration \(console\)**

1. Open the MediaTailor console at [https://console\.aws\.amazon\.com/mediatailor/](https://console.aws.amazon.com/mediatailor/)\.

1. On the **Configurations** page, choose **Create configuration**\.

1. In the **Configuration** section at the bottom of the page, for **Configuration name**, enter a unique name that describes the configuration\. The name is the primary identifier for the configuration\. The maximum length allowed is 512 characters\.

1.  For **Video content source**, enter the URL prefix for the HLS master manifest or DASH manifest for this stream, minus the asset ID\. For example, if the master manifest URL is `http://origin-server.com/a/master.m3u8`, you would enter `http://origin-server.com/a/`\. Alternatively, you can enter a shorter prefix such as `http://origin-server.com`, but then you must include the `/a/` in the asset ID in the player request for content\. The maximum length is 512 characters\.
**Note**  
If your content origin uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) Otherwise, AWS Elemental MediaTailor fails to connect to the content origin and can't serve manifests in response to player requests\.

1. For **Ad decision server**, enter the URL for your ADS\. This is either the URL with variables as described in [Step 3: Configure ADS Request URL and Query Parameters](#getting-started-configure-request), or the static VAST URL that you are using for testing purposes\. The maximum length is 25,000 characters\.
**Note**  
If your ADS uses HTTPS, its certificate must be from a well\-known certificate authority\. \(It can't be a self\-signed certificate\.\) The same is true for mezzanine ad URLs returned by the ADS\. Otherwise, MediaTailor fails to retrieve and stitch ads into the manifests from the content origin\.

1. \(Optional as needed for DASH\) For **Location**, choose **DISABLED** if you have CDN routing rules set up for accessing MediaTailor manifests and you are either using client\-side reporting or your players support sticky HTTP redirects\. 

   For more information about the **Location** feature, see [DASH Location Feature](dash-location-feature.md)\.

1. \(Optional\) If your origin server produces single\-period DASH manifests, choose **DASH mpd manifest origin type**, and then choose **SINGLE\_PERIOD**\. By default, MediaTailor handles DASH manifests as multi\-period manifests\. For more information, see [DASH \.mpd Manifests](manifest-dash.md)\.

1. Choose **Create configuration**\.

   AWS Elemental MediaTailor displays the new configuration on the **Configurations** page\.

## Step 5: Test the Configuration<a name="getting-started-test-config"></a>

After you save the configuration, test the stream using a URL in the appropriate format for your streaming protocol:
+ Example: HLS

  ```
  playback-endpoint/v1/master/hashed-account-id/origin-id/master.m3u8
  ```
+ Example: DASH

  ```
  playback-endpoint/v1/dash/hashed-account-id/origin-id/manifest.mpd
  ```

Where:
+ `playback-endpoint` is the unique playback endpoint that AWS Elemental MediaTailor generated when the configuration was created\. 

  Example

  ```
  https://bdaaeb4bd9114c088964e4063f849065.mediatailor.us-east-1.amazonaws.com
  ```
+ `hashed-account-id` is your AWS account ID\. 

  Example

  ```
  AKIAIOSFODNN7EXAMPLE
  ```
+ `origin-id` is the name that you gave when creating the configuration\. 

  Example

  ```
  myOrigin
  ```
+ `master.m3u8` or `manifest.mpd` is the name of the manifest from the test stream plus its file extension\. Define this so that you get a fully identified manifest when you append this to the video content source that you configured in [Step 4: Create a Configuration](#getting-started-add-mapping)\. 

Using the values from the preceding examples, the full URLs are the following\.
+ Example: HLS

  ```
  https://bdaaeb4bd9114c088964e4063f849065.mediatailor.us-east-1.amazonaws.com/v1/master/AKIAIOSFODNN7EXAMPLE/myOrigin/master.m3u8
  ```
+ Example: DASH

  ```
  https://bdaaeb4bd9114c088964e4063f849065.mediatailor.us-east-1.amazonaws.com/v1/dash/AKIAIOSFODNN7EXAMPLE/myOrigin/manifest.mpd
  ```

You can test the stream using one of the following methods\.
+ As shown in the preceding example, enter the URL in a standalone player\.
+ Test the stream in your own player environment\.

## Step 6: Send the Playback Request to AWS Elemental MediaTailor<a name="send-request-to-mediatailor"></a>

Configure the downstream player or CDN to send playback requests to the configuration's playback endpoint provided from AWS Elemental MediaTailor\. Any player\-defined dynamic variables that you used in the ADS request URL in [Step 3: Configure ADS Request URL and Query Parameters](#getting-started-configure-request) must be defined in the manifest request from the player\.

**Example**  
Assume your template ADS URL is the following\.  

```
https://my.ads.com/ad?output=vast&content_id=12345678&playerSession=[session.id]&cust_params=[player_params.cust_params]
```
Then define `[player_params.cust_params]` in the player request by prefacing the key\-value pair with `ads.`\. AWS Elemental MediaTailor passes parameters that aren't preceded with `ads.` to the origin server instead of the ADS\.  
The player request URL is some variation of the following HLS and DASH examples\.   

```
https://bdaaeb4bd9114c088964e4063f849065.mediatailor.us-east-1.amazonaws.com/v1/master/AKIAIOSFODNN7EXAMPLE/myOrigin/master.m3u8?ads.cust_params=viewerinfo
```

```
https://bdaaeb4bd9114c088964e4063f849065.mediatailor.us-east-1.amazonaws.com/v1/dash/AKIAIOSFODNN7EXAMPLE/myOrigin/manifest.mpd?ads.cust_params=viewerinfo
```
When AWS Elemental MediaTailor receives the player request, it defines the player variables based on the information in the request\. The resulting ADS request URL is some variation of this\.   

```
https://my.ads.com/ad?output=vast&content_id=12345678&playerSession=<filled_in_session_id>&cust_params=viewerinfo
```

For more information about configuring key\-value pairs to pass to the ADS, see [Dynamic Ad Variables in AWS Elemental MediaTailor](variables.md)\.

## \(Optional\) Step 7: Monitor AWS Elemental MediaTailor Activity<a name="monitor-step"></a>

Use Amazon CloudWatch and Amazon CloudWatch Logs to track AWS Elemental MediaTailor activity, such as the counts of requests, errors, and ad avails filled\. 

If this is your first time using CloudWatch with AWS Elemental MediaTailor, create an AWS Identity and Access Management \(IAM\) role to allow communication between the services\.

**To allow AWS Elemental MediaTailor access to CloudWatch \(console\)**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane of the IAM console, choose **Roles**, and then choose **Create role**\.

1. Choose the **Another AWS account** role type\.

1. For **Account ID**, enter your AWS account ID\.

1. Select **Require external ID** and enter **midas**\. This option automatically adds a condition to the trust policy that allows the service to assume the role only if the request includes the correct `sts:ExternalID`\.

1. Choose **Next: Permissions**\.

1. Add a permissions policy that specifies what actions this role can complete\. Select from one of the following options, and then choose **Next: Review**:
   + **CloudWatchLogsFullAccess** to provide full access to Amazon CloudWatch Logs
   + **CloudWatchFullAccess** to provide full access to Amazon CloudWatch

1. For **Role name**, enter **MediaTailorLogger**, and then choose **Create role**\.

1. On the **Roles** page, select the role that you just created\. 

1. Edit the trust relationship to update the principal:

   1. On the role's **Summary** page, choose the **Trust relationship** tab\.

   1. Choose **Edit trust relationship**\.

   1. In the policy document, change the principal to the AWS Elemental MediaTailor service\. It should look like this\.

      ```
      "Principal": {
         "Service": "mediatailor.amazonaws.com"
      },
      ```

      The entire policy should read as follows\.

      ```
      {
        "Version": "2012-10-17",
        "Statement": [
          {
            "Effect": "Allow",
            "Principal": {
              "Service": "mediatailor.amazonaws.com"
            },
            "Action": "sts:AssumeRole",
            "Condition": {
              "StringEquals": {
                "sts:ExternalId": "Midas"
              }
            }
          }
        ]
      }
      ```

   1. Choose **Update Trust Policy**\.

## Step 8: Clean Up<a name="clean-up"></a>

To avoid extraneous charges, delete all unnecessary configurations\.

**To delete a configuration \(console\)**

1. On the AWS Elemental MediaTailor **Configurations** page, do one of the following:
   + Choose the **Configuration name** for the configuration that you want to delete\.
   + In the **Configuration name** column, choose the radio button, and then choose **Delete**\.

1. In the **Delete configuration** confirmation box, enter **Delete**, and then choose **Delete** again\.

   AWS Elemental MediaTailor removes the configuration\.