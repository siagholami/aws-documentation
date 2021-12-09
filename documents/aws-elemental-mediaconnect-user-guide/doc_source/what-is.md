# What is AWS Elemental MediaConnect?<a name="what-is"></a>

AWS Elemental MediaConnect is a service that makes it easy for broadcasters and other premium video providers to reliably ingest live video into the AWS Cloud and distribute it to multiple destinations inside or outside the AWS Cloud\. MediaConnect provides the reliability, security, and visibility that you are used to with existing distribution methods, combined with the flexibility and cost\-effectiveness that internet\-based transmission provides\.

For ingest, you send content to AWS Elemental MediaConnect from an on\-premises contribution encoder, which encodes your video into a single, high\-quality mezzanine file for contribution into the cloud\. After the video is in the AWS Cloud, MediaConnect sends it to outputs that you specify, such as a cloud encoder, another MediaConnect flow, or an on\-premises destination\.

The following illustration shows the basic workflow of how AWS Elemental MediaConnect ingests live video into the cloud and securely distributes it to multiple destinations\.

![\[This illustration shows the basic workflow of how AWS Elemental MediaConnect ingests live video into the cloud and securely distributes it to multiple destinations.\]](http://docs.aws.amazon.com/mediaconnect/latest/ug/)

In AWS Elemental MediaConnect, you create a *flow* to establish a transport between a source and one or more outputs\. You can also share content with other AWS accounts by creating *entitlements*\. This allows the receiving account to create a flow using your content as the source\.

With AWS Elemental MediaConnect, you can do the following:
+ Ingest live video into the AWS Cloud\.
+ Distribute live video to multiple destinations inside or outside the AWS Cloud\.
+ Subscribe to a live video stream that is supplied by another AWS account\. \(This requires permission from the content originator through an entitlement\.\)
+ Send content from one AWS Region to another\.

**Topics**
+ [AWS Elemental MediaConnect concepts and terminology](what-is-concepts.md)
+ [Related services](what-is-related-services.md)
+ [Accessing AWS Elemental MediaConnect](what-is-accessing.md)
+ [Pricing for AWS Elemental MediaConnect](what-is-pricing.md)
+ [Regions and endpoints for AWS Elemental MediaConnect](what-is-regions.md)