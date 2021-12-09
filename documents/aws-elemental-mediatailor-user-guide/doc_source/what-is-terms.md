# Concepts and Terminology<a name="what-is-terms"></a>

Ad decision server \(ADS\)  
A server that provides advertising spot specifications based on criteria including current advertising campaigns and viewer preferences\. 

Configuration  
An object in MediaTailor that you interact with\. The configuration holds location information about the origin server and the ad decision server \(ADS\)\. The configuration also holds endpoints that provide access points in and out of MediaTailor\.

Dynamic transcoding  
A process that matches the ad quality and format to the primary video content when content is requested\. Dynamic transcoding reduces storage requirements and ensures that playback seamlessly transitions between the ad and video content\.

Manifest manipulation  
The process of rewriting manifests from the origin server so that the manifests reference the appropriate ad and content fragments\. Ads are determined by the VAST response from the ad decision server \(ADS\)\. As playback progresses, MediaTailor performs ad insertion or ad replacement into the content stream\.

VAST and VMAP  
Video Ad Serving Template \(VAST\) and Video Multiple Ad Playlist \(VMAP\) are XML responses that the ad decision server \(ADS\) sends to ad requests from MediaTailor\. The responses dictate what ads MediaTailor inserts in the manifest\. VMAP also includes timing for ad avails\. For more information about the logic behind MediaTailor ad insertion, see [Ad Behavior in AWS Elemental MediaTailor](ad-behavior.md)\. For more information about how MediaTailor works with VAST, see [VAST in AWS Elemental MediaTailor](vast.md)\.