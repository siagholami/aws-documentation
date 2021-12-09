# Dynamic Ad Variables in AWS Elemental MediaTailor<a name="variables"></a>

The AWS Elemental MediaTailor request to the ad decision server \(ADS\) includes information about the current viewing session, which helps the ADS choose the best ads to provide in its response\. When you configure your ADS request, you specify the query parameters to use to convey the information\. 

The query parameters take the following forms:
+ **Static values** – values that don't change from one session to the next\. For example, the response type that MediaTailor expects from the ADS\.
+ **Session data** – dynamic values that are provided by MediaTailor for each session, for example, the session ID\. For details, see [Session Data](variables-session.md)\. 
+ **Player data** – dynamic values that are provided by the player for each session\. These describe the content viewer and help the ADS to determine which ads MediaTailor should stitch into the stream\. For details, see [Player Data](variables-player.md)\.

## Passing Parameters to the ADS<a name="passing-paramters-to-the-ads"></a>

**To pass session and player information to the ADS**

1. Work with the ADS to determine the information that it needs so that it can respond to an ad query from AWS Elemental MediaTailor\.

1. Create a configuration in MediaTailor that uses a template ADS request URL that satisfies the ADS requirements\. In the URL, include static parameters and include placeholders for dynamic parameters\. Enter your template URL in the configuration's **Ad decision server** field\. 

   In the following example template URL, `correlation` provides session data, and `deviceType` provides player data:

   ```
   https://my.ads.server.com/path?correlation=[session.id]&deviceType=[player_params.deviceType]
   ```

1. On the player, configure the session initiation request for AWS Elemental MediaTailor to provide parameters for the player data\. Include your parameters in the session initiation request, and omit them from subsequent requests for the session\. 

   The type of call that the player makes to initialize the session determines whether the player \(client\) or MediaTailor \(server\) provides ad\-tracking reporting for the session\. For information about these two options, see [Ad Tracking Reporting in AWS Elemental MediaTailor](ad-reporting.md)\. 

   Make one of the following types of calls, depending on whether you want server\- or client\-side ad\-tracking reporting\. In both of the example calls, `userID` is intended for the ADS and `auth_token` is intended for the origin:
   + \(Option\) Call for server\-side ad\-tracking reporting – Prefix the parameters that you want MediaTailor to send to the ADS with `ads`\. Leave the prefix off for parameters that you want MediaTailor to send to the origin server: 

     The following examples show incoming requests for HLS and DASH to AWS Elemental MediaTailor\. MediaTailor uses the `deviceType` in its request to the ADS and the `auth_token` in its request to the origin server\. 

     HLS example:

     ```
     GET master.m3u8?ads.deviceType=ipad&auth_token=kjhdsaf7gh
     ```

     DASH example:

     ```
     GET manifest.mpd?ads.deviceType=ipad&auth_token=kjhdsaf7gh
     ```
   + \(Option\) Call for client\-side ad\-tracking reporting – Provide parameters for the ADS inside an `adsParams` object\. Provide parameters that you want MediaTailor to send to the origin server as top\-level objects\. 

     HLS example:

     ```
     POST master.m3u8
         {
             "adsParams": {
                "deviceType": "ipad"
            }
            "auth_token": "kjhdsaf7gh"
         }
     ```

     DASH example:

     ```
     POST manifest.mpd
         {
             "adsParams": {
                "deviceType": "ipad"
            }
            "auth_token": "kjhdsaf7gh"
         }
     ```

When the player initiates a session, AWS Elemental MediaTailor replaces the variables in the template ADS request URL with the session data and the player's `ads` parameters\. It passes the remaining parameters from the player to the origin server\.

The following examples show the calls to the ADS and origin server from AWS Elemental MediaTailor that correspond to the preceding player's session initialization call examples: 
+ MediaTailor calls the ADS with session data and the player's device type: 

  ```
  https://my.ads.server.com/path?correlation=896976764&deviceType=ipad
  ```
+ MediaTailor calls the origin server with the player's authorization token\.
  + HLS example:

    ```
    https://my.origin.server.com/master.m3u8?auth_token=kjhdsaf7gh
    ```
  + DASH example:

    ```
    https://my.origin.server.com/manifest.mpd?auth_token=kjhdsaf7gh
    ```

The following sections provide details for configuring session and player data\.