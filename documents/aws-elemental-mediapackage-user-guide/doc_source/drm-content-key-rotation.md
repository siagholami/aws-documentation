# Key Rotation Expected Behavior<a name="drm-content-key-rotation"></a>

When you enable key rotation on live content from HLS, CMAF, and DASH endpoints, AWS Elemental MediaPackage retrieves content keys before the live content begins\. As the content progresses, MediaPackage retrieves new keys at the interval that you set on the endpoint, as described in [Encryption Fields](endpoints-hls-encryption.md)\.

If MediaPackage is unable to retrieve the content key, it takes the following actions:
+ If MediaPackage successfully retrieved a content key for this endpoint before, it uses the last key that it fetched\. This ensures that endpoints that worked previously continue to work\. 
+ If MediaPackage has *not* successfully retrieved a content key for this endpoint before, MediaPackage responds to the playback request with error 404\. 

In all cases, when MediaPackage can't fetch a content key, it generates a CloudWatch event, as described in [Key Provider Notification Events](cloudwatch-events-example.md#key-provider-state-events)\.