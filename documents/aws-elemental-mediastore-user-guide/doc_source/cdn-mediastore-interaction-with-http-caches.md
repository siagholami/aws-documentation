# AWS Elemental MediaStore's interaction with HTTP caches<a name="cdn-mediastore-interaction-with-http-caches"></a>

AWS Elemental MediaStore stores objects so that they can be cached correctly and efficiently by content delivery networks \(CDNs\) like Amazon CloudFront\. When an end user or CDN retrieves an object from MediaStore, the service returns HTTP headers that affect the caching behavior of the object\. \(The standards for HTTP 1\.1 caching behavior are found in [RFC2616 section 13](https://www.w3.org/Protocols/rfc2616/rfc2616-sec13.html)\.\) These headers are:
+ **`ETag` \(not customizable\)** – The entity tag header is a unique identifier for the response that MediaStore sends\. Standards\-compliant CDNs and web browsers use this tag as a key to cache the object with\. MediaStore automatically generates an `ETag` for each object when it is uploaded\. You can [view an object's details](objects-view-details.md) to determine its ETag value\.
+ **`Last-Modified` \(not customizable\)** – The value of this header indicates the date and time that the object was modified\. MediaStore automatically generates this value when the object is uploaded\.
+ **`Cache-Control` \(customizable\)** – The value of this header controls how long an object should be cached before the CDN checks to see if it has been modified\. You can set this header to any value when you upload an object to a MediaStore container using the [CLI](objects-upload.md) or [API](https://docs.aws.amazon.com/mediastore/latest/apireference/API_objstore_PutObject.html)\. The complete set of valid values is described in [HTTP/1\.1 documentation](https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.9)\. If you don't set this value when you upload an object, MediaStore won't return this header when the object is retrieved\.

  A common use case for the Cache\-Control header is to specify a duration to cache the object\. For example, suppose that you have a video manifest file that is being frequently overwritten by an encoder\. You could set the `max-age` to 10 to indicate that the object should be cached for only 10 seconds\. Or suppose that you have a stored video segment that will never be overwritten\. You could set the `max-age` for this object to 31536000 to cache for approximately 1 year\. 

## Conditional requests<a name="cdn-mediastore-interaction-with-http-caches-conditional-requests"></a>

### Conditional requests to MediaStore<a name="cdn-mediastore-interaction-with-http-caches-conditional-requests-to-mediastore"></a>

MediaStore responds identically to conditional requests \(using request headers such as `If-Modified-Since` and `If-None-Match`, as described in [RFC7232](https://tools.ietf.org/html/rfc7232)\) and unconditional requests\. This means that when MediaStore receives a valid `GetObject` request, the service always returns the object even if the client already has the object\.

### Conditional requests to CDNs<a name="cdn-mediastore-interaction-with-http-caches-conditional-requests-to-cdns"></a>

CDNs that serve content on behalf of MediaStore can process conditional requests by returning `304 Not Modified`, as described in [RFC7232 section 4\.1](https://tools.ietf.org/html/rfc7232#section-4.1)\. This indicates that there is no need to transfer the complete object contents, because the requester already has an object that matches the conditional request\. 

CDNs \(and other caches that are compliant with HTTP/1\.1\) base these decisions on the `ETag` and `Cache-Control` headers that are forwarded by the origin servers\. To control how often CDNs query MediaStore origin servers for updates to repeatedly retrieved objects, set the `Cache-Control` headers for those objects when you upload them to MediaStore\.