# How AWS Elemental MediaTailor Handles BaseURLs for DASH<a name="baseurls-for-dash"></a>

With server\-side ad insertion, the content segments and ad segments come from different locations\. In your DASH manifests, AWS Elemental MediaTailor manages URL settings based on your content distribution network \(CDN\) configuration and the URLs specified in the manifest\. MediaTailor uses the rules in the following list to manage the `BaseURL` settings in your DASH manifests for your content segments and ad segments\. 

AWS Elemental MediaTailor behavior for content segments:
+ If you specify a **CDN content segment prefix** in your configuration, then MediaTailor makes sure that there is exactly one `BaseURL`, with your specified prefix, defined at the `MPD` level\.
+ If you do not specify a **CDN content segment prefix**, then MediaTailor uses the origin template manifest as follows: 
  + If the origin template manifest contains one or more `BaseURL` settings at the `MPD` level, MediaTailor leaves them unmodified\.
  + If the origin template manifest does not contain any `BaseURL` settings at the `MPD` level, MediaTailor adds one that is based on the origin `MPD` URL\. 

For ad segments, AWS Elemental MediaTailor does the following:
+ If you specify a **CDN ad segment prefix** in your configuration, then MediaTailor ensures that each ad period has exactly one `BaseURL` setting, populated with the configured prefix\. 
+ If you do not specify a **CDN ad segment prefix**, then MediaTailor adds exactly one `BaseURL` setting to each ad period that points to the ad content server that is set up by MediaTailor for serving ad segments\.