# DASH Location Feature<a name="dash-location-feature"></a>

This section provides information about the location feature for DASH, which is enabled by default in AWS Elemental MediaTailor\. Read this section if you create content delivery network \(CDN\) routing rules for accessing MediaTailor manifests\. Also read this section if you use server\-side reporting with players that don't support sticky HTTP redirects\.

**What is the location feature?**  
The location feature allows players that don't support sticky HTTP redirects to provide sticky behavior in their manifest update requests\. 

AWS Elemental MediaTailor uses sessionless initialization, and it requires sticky HTTP redirect behavior from its players\. With server\-side reporting, when the player makes a request for a manifest update to MediaTailor, the service issues a 302 temporary redirect, to direct the player to an endpoint for the personalized manifest\. MediaTailor includes a session ID in the response, as a query parameter\. The intent is for the player to follow the URL for the entirety of the session, but players that don't support sticky HTTP redirects drop the redirect and return to the original URL\. When a player returns to the original URL, for each new request MediaTailor creates a new session rather than staying with the original session\. This can cause the manifest to become corrupt\. 

The DASH specification provides a solution to this problem in the location feature, which is enabled by default in AWS Elemental MediaTailor configurations\. When this feature is enabled, MediaTailor puts the absolute URL in the manifest `<Location>` tag\. Players that don't support sticky HTTP redirects can use the URL provided in `<Location>` to request updates to the manifest\. 

**Do I need to disable the location feature in my configuration?**  
The location feature overrides any CDN routing rules that you set up for accessing AWS Elemental MediaTailor manifests, so you might need to disable it\. The location feature doesn't affect CDN caching of content or ad segments\. 

Find your situation in the following list to determine whether you need to disable the location feature for your configuration and how to handle it:
+ If you don't have CDN routing rules set up for accessing AWS Elemental MediaTailor manifests, leave the location setting enabled\. 
+ Otherwise, use the following rules:
  + If you either don't use server\-side reporting or your players all support sticky HTTP redirects, disable the location feature\. For information about how to do this on the console, see [Creating a Configuration](configurations-create.md)\.
  + Otherwise, contact [AWS Support](https://aws.amazon.com/premiumsupport/)\.

**Do I need to use the location feature?**  
You need to use the location feature for players that don't support sticky HTTP redirects, for example, Shaka\. Use the URL provided in the `<Location>` tag for all of your manifest update requests\. 

**Example**  
Example URLs and example `<Location>` tag\.
+   
**Example Example: Initial request URL**  

  ```
  https://b00f3e55c5cb4c1ea6dee499964bea92.mediatailor.us-east-1.amazonaws.com/v1/dash/5ca4c1892b1f213a1247fad47b3e34c454a7d490/testLocationTag/index.mpd
  ```
+   
**Example Example: Redirected 302 response**  

  ```
  /v1/dash/5ca4c1892b1f213a1247fad47b3e34c454a7d490/testLocationTag/index.mpd?aws.sessionId=0e5d9b45-ae97-49eb-901b-893d043e0aa6
  ```
+   
**Example Example: Location tag in a manifest**  

  ```
  <Location>https://b00f3e55c5cb4c1ea6dee499964bea92.mediatailor.us-east-1.amazonaws.com/v1/dash/5ca4c1892b1f213a1247fad47b3e34c454a7d490/testLocationTag/index.mpd?aws.sessionId=0e5d9b45-ae97-49eb-901b-893d043e0aa6</Location>
  ```