# Player Data<a name="variables-player"></a>

To configure AWS Elemental MediaTailor to send data received from the player to the ADS, in the template ADS URL, specify `player_params.<query_parameter_name>` variables\. For example, if the player sends a query parameter named `user_id` in its request to MediaTailor, to pass that data in the ADS request, include `[player_params.user_id]` in the ADS URL configuration\. 

This allows you to control the query parameters that are included in the ADS request\. Typically, you add a special query parameter that the ADS recognizes to the ADS request URL and provide key\-value pairs as the value of the parameter\. 

The examples used in the following procedure use the following key\-value pairs:
+ *param1* with a value of *value1:*
+ *param2* with a value of *value2:*

**To add query parameters as key\-value pairs** 

1. In AWS Elemental MediaTailor, configure the ADS request template URL to reference the parameters\. The following URL shows the inclusion of the example parameters: 

   ```
   https://my.ads.com/path?param1=[player_params.param1]&param2=[player_params.param2]
   ```

1. \(Optional\) For server\-side ad\-tracking reporting, URL\-encode the key\-value pairs on the player\. When MediaTailor receives the session initialization request, it URL\-decodes the values once before substituting them into the ADS request URL\. 
**Note**  
If your ADS requires a URL\-encoded value, URL\-encode the value twice on the player\. This way, the decoding done by MediaTailor results in a once\-encoded value for the ADS\. 

   For example, if the decoded representation of the values sent to the ADS is `param1=value1:&param2=value2:`, then the URL\-encoded representation is `param1=value1%3A&param2=value2%3A`\.

1. In the session initialization call from the player, pass the key\-value pairs to MediaTailor as the value of a single query parameter\. The following example calls provide the example key\-value pairs for server\- and client\-side ad tracking reporting\.
   + Example requests for server\-side ad\-tracking reporting \- using URL\-encoded pairs

     HLS:

     ```
     <master>.m3u8?ads.param1=value1%3A&ads.param2=value2%3A
     ```

     DASH:

     ```
     <manifest>.mpd?ads.param1=value1%3A&ads.param2=value2%3A
     ```
   + Example request for client\-side ad\-tracking reporting \- with no URL\-encoding

     HLS:

     ```
     POST <master>.m3u8
         {
             "adsParams": {
                "param1": "value1:",
                "param2": "value2:"
            }
         }
     ```

     DASH:

     ```
     POST <manifest>.mpd
         {
             "adsParams": {
                "param1": "value1:",
                "param2": "value2:"
            }
         }
     ```

For server\-side reporting, MediaTailor decodes the parameters when the player request is received\. For client\-side reporting, it doesn't alter the parameters received in the JSON payload\. MediaTailor sends the following request to the ADS:

```
https://my.ads.com/<path>?param1=value1:&param2=value2:
```

In this way, the `param1` and `param2` key\-value pairs are included as first\-class query parameters in the ADS request\.