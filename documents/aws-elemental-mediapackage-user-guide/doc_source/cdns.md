# Working with Content Delivery Networks \(CDNs\)<a name="cdns"></a>

You can use a content delivery network \(CDN\) such as [Amazon CloudFront](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/) to serve the content that you store in AWS Elemental MediaPackage\. A CDN is a globally distributed set of servers that caches content such as videos\. When a user requests your content, the CDN routes the request to the edge location that provides the lowest latency\. If your content is already cached in that edge location, the CDN delivers it immediately\. If your content is not currently in that edge location, the CDN retrieves it from your origin \(in this case, the MediaPackage endpoint\) and distributes it to the user\. The following illustration shows this process\.

![\[This illustration shows how content that is stored in AWS Elemental MediaPackage is distributed using a CDN.\]](http://docs.aws.amazon.com/mediapackage/latest/ug/images/cf_flow.png)

**Topics**
+ [Using AWS Elemental MediaPackage with Amazon CloudFront](cdns-cf.md)
+ [Using Content Delivery Network \(CDN\) Authorization](working-cdn-auth.md)