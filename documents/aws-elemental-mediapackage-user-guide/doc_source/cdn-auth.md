# Content Delivery Network \(CDN\) Authorization in AWS Elemental MediaPackage<a name="cdn-auth"></a>

CDN authorization is available for live workflows\. It is not supported for video on demand \(VOD\)\.

CDN authorization helps to protect your content from unauthorized use\. When you enable this feature on an endpoint, you must also configure a static header in content requests from your CDN\. The value of this header is a code that you create\. MediaPackage checks all requests to the endpoint to verify that they have the correct header and value\. If either is missing or incorrect, MediaPackage doesn't fulfill the content request and playback fails\. This means that unauthorized devices can't gain access to your content\.

**How it works**  
To use CDN authorization, perform the appropriate setup as described in [Using Content Delivery Network \(CDN\) Authorization](working-cdn-auth.md)\. When the setup is complete, this is how CDN authorization works in MediaPackage:

1. Your CDN includes the `X-MediaPackage-CDNIdentifier` header and configured authorization code in content requests to the endpoint in MediaPackage\.

1. MediaPackage receives the request and uses the IAM role to access AWS Secrets Manager\. This is the **Secrets role ARN** that you identified in the endpoint settings\. 

1. In Secrets Manager, MediaPackage verifies that the authorization code in the CDN request matches the secret you stored\. This is the **CDN identifier secret** that you identified in the endpoint settings\.

1. If the authorization code matches between the CDN request and the Secrets Manager secret, MediaPackage authorizes the request and responds with a manifest\.

   If the code is wrong or missing in the request, MediaPackage responds with an error\. 