# VPAID Handling<a name="vpaid"></a>

AWS Elemental MediaTailor supports VPAID for HLS\. VPAID is not currently supported for DASH\. 

VPAID allows publishers to serve highly interactive video ads and to provide viewability metrics on their monetized streams\. For information about VPAID, see the specification at [https://www\.iab\.com/guidelines/digital\-video\-player\-ad\-interface\-definition\-vpaid\-2\-0/](https://www.iab.com/guidelines/digital-video-player-ad-interface-definition-vpaid-2-0/)\. AWS Elemental MediaTailor supports VPAID for HLS\. 

AWS Elemental MediaTailor supports a mix of server\-side\-stitched VAST MP4 linear ads and client\-side\-inserted VPAID interactive creatives in the same ad avail\. It preserves the order in which they appear in the VAST response\. MediaTailor follows VPAID redirects through a maximum of three levels of wrappers\. The client\-side reporting response includes the unwrapped VPAID metadata\.

To use VPAID, follow these guidelines:
+ Configure an MP4 slate for your VPAID creatives\. AWS Elemental MediaTailor fills the VPAID ad slots with your configured slate, and provides VPAID ad metadata for the client player to use to run the interactive ads\. If you don't have a slate configured, when a VPAID ad appears, MediaTailor provides the ad metadata through client\-side reporting as usual\. It also logs an error in CloudWatch about the missing slate\. For more information, see [Slate Management](slate-management.md) and [Creating a Configuration](configurations-create.md)\. 
+ Use client\-side reporting\. AWS Elemental MediaTailor supports VPAID through our client\-side reporting API\. For more information, see [Client\-side Reporting](ad-reporting-client-side.md)\. 

  It is theoretically possible to use the default server\-side reporting mode with VPAID\. However, if you use server\-side reporting, you lose any information about the presence of the VPAID ad and the metadata surrounding it, because that is available only through the client\-side API\. 
+ In live scenarios, make sure that your ad avails, denoted by `EXT-X-CUE-OUT: Duration`, are large enough to accommodate any user interactivity on VPAID\. For example, if the VAST XML specifies a VPAID ad that is 30 seconds long, implement your ad avail to be more than 30 seconds, to accommodate the ad\. If you don't do this, you lose the VPAID metadata, because the remaining duration in the ad avail is not long enough to accommodate the VPAID ad\.