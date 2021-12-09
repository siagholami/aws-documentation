# CDN Best Practices with AWS Elemental MediaTailor<a name="cdn-bp"></a>

We highly recommend that you use a content distribution network \(CDN\) to cache content and ad segments, but personalized manifest responses must *not* be cached or shared between viewers\. Use the following settings for manifest traffic in your CDN to make the most of the service:
+ Set all **time to live \(TTL\)** settings to **0**\. This includes the maximum, minimum, and default TTL\.
+ **Forward all query strings** to MediaTailor\. This way, all ad variables can be passed to the ad decision server \(ADS\) to determine the ads to be used in this playback session\.
+ **Forward the `User-Agent` header** to MediaTailor\. The ADS often needs to know what user agent is requesting the content\. If you don't forward the `User-Agent` header, the value that MediaTailor receives is the user agent of your CDN\.