# What Is AWS Elemental MediaPackage?<a name="what-is"></a>

MediaPackage is a just\-in\-time video packaging and origination service that runs in the AWS Cloud\. With MediaPackage, you can deliver highly secure, scalable, and reliable video streams to a wide variety of playback devices and content delivery networks \(CDNs\)\. 

MediaPackage offers a broadcast\-grade viewing experience for viewers, while allowing you the flexibility to control and protect your content\. Additionally, the built\-in resiliency and scalability of MediaPackage means that you have the right amount of resources at the right time, with no manual intervention required\.

**Topics**
+ [Are You a First\-Time User of MediaPackage?](#first-time-user)
+ [Concepts and Terminology](what-is-terms.md)
+ [Supported Inputs and Outputs](supported-inputs.md)
+ [How AWS Elemental MediaPackage Works](what-is-flow.md)
+ [Features of AWS Elemental MediaPackage](what-is-features.md)
+ [Related Services](#related-services)
+ [Accessing MediaPackage](#accessing-emp)
+ [Pricing for MediaPackage](#pricing-for-emp)
+ [Regions for MediaPackage](#regions-and-endpoints)

## Are You a First\-Time User of MediaPackage?<a name="first-time-user"></a>

If you are a first\-time user of MediaPackage, we recommend that you begin by reading the following sections:
+ [How AWS Elemental MediaPackage Works](what-is-flow.md)
+ [Concepts and Terminology](what-is-terms.md)
+ [Features of AWS Elemental MediaPackage](what-is-features.md)
+ [Getting Started with AWS Elemental MediaPackage](getting-started.md)

## Related Services<a name="related-services"></a>
+ **Amazon CloudFront** is a global content delivery network \(CDN\) service that securely delivers data and videos to your viewers\. Use CloudFront to deliver content with the best possible performance\. For more information, see [Amazon CloudFront](https://aws.amazon.com/cloudfront/)\.
+ **Amazon CloudWatch** is a monitoring service for AWS Cloud resources and the applications that you run on AWS\. Use CloudWatch to track metrics such as content input and output request counts\. For more information, see [Amazon CloudWatch](https://aws.amazon.com/cloudwatch/)\.
+ **AWS Elemental MediaLive** is a live video processing service that encodes high\-quality live video streams for broadcast television and multi\-screen devices\. Use MediaLive to encode content streams and send them to MediaPackage for packaging\. For more information about how encoders \(such as MediaLive\) work with MediaPackage, see [How AWS Elemental MediaPackage Works](what-is-flow.md)\.
+ **AWS Identity and Access Management \(IAM\)** is a web service that helps you securely control access to AWS resources for your users\. Use IAM to control who can use your AWS resources \(authentication\) and what resources users can use in which ways \(authorization\)\. For more information, see [Setting Up AWS Elemental MediaPackage](setting-up.md)\.
+ **AWS Elemental MediaTailor** is a scalable ad insertion service that runs in the AWS Cloud\. Use MediaTailor to serve targeted ads to viewers\. For more information, see [AWS Elemental MediaTailor](https://aws.amazon.com/mediatailor/)\.
+ **Amazon Simple Storage Service** \(Amazon S3\) is a storage service\. Pull video on demand \(VOD\) assets from Amazon S3, or store live\-to\-VOD assets in the bucket of your choice\. For more information, see [Getting Started with VOD Content Delivery in AWS Elemental MediaPackage](getting-started-vod.md) and [Getting Started with Live\-to\-VOD Content Delivery in AWS Elemental MediaPackage](getting-started-ltov.md)\.

## Accessing MediaPackage<a name="accessing-emp"></a>

You can access MediaPackage through the console, AWS Command Line Interface \(AWS CLI\), or MediaPackage REST API\. 
+ Console access: 

  ```
  https://<region>.console.aws.amazon.com/mediapackage/home
  ```
+ AWS CLI endpoint: 

  ```
  aws mediapackage
  ```
+ MediaPackage REST API endpoint: 

  ```
  https://config.mediapackage.<region>.amazonaws.com 
  ```

## Pricing for MediaPackage<a name="pricing-for-emp"></a>

As with other AWS products, there are no contracts or minimum commitments for using MediaPackage\. You are charged only for AWS resources that your account uses\. Pricing is pay\-as\-you\-go and consists of the following:
+ A per GB charge for received content
+ A per GB charge for content that is streamed out of MediaPackage

  Content that is cached and served from a content delivery network \(CDN\) does not incur this per GB charge\.

For detailed pricing information, see [MediaPackage Pricing](https://aws.amazon.com/mediapackage/pricing/)\.

## Regions for MediaPackage<a name="regions-and-endpoints"></a>

To reduce latency in your applications, MediaPackage offers a regional endpoint for your requests\. To view the list of AWS Regions where MediaPackage is available, see [MediaPackage Regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#mediapackage_region)\.