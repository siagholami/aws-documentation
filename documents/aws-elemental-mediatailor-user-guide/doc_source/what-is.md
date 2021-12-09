# What Is AWS Elemental MediaTailor?<a name="what-is"></a>

AWS Elemental MediaTailor is a scalable ad insertion service that runs in the AWS Cloud\. With MediaTailor, you can serve targeted ads to viewers while maintaining broadcast quality in over\-the\-top \(OTT\) video applications\.

AWS Elemental MediaTailor offers important advances over traditional ad\-tracking systems: ads are better monetized, more consistent in video quality and resolution, and easier to manage across multi\-platform environments\. MediaTailor simplifies your ad workflow by allowing all IP\-connected devices to render ads in the same way as they render other content\. The service also offers advanced tracking of ad views, which further increases the monetization of content\.

MediaTailor supports Apple HTTP Live Streaming \(HLS\) and MPEG Dynamic Adaptive Streaming over HTTP \(DASH\) for video on demand \(VOD\) and live workflows\.

## Related Services<a name="related-services"></a>
+ **Amazon CloudFront** is a global content delivery network \(CDN\) service that securely delivers data and videos to your viewers\. Use CloudFront to deliver content with the best possible performance\. For more information about CloudFront, see the [Amazon CloudFront website](https://aws.amazon.com/cloudfront/)\.
+ **AWS Elemental MediaPackage** is a just\-in\-time packaging and origination service that customizes live video assets for distribution in a format that is compatible with the device that makes the request\. Use AWS Elemental MediaPackage as an origin server to prepare content and add ad markers before sending streams to MediaTailor\. For more information about how MediaTailor works with origin servers, see [How MediaTailor Works](what-is-flow.md)\.
+ **AWS Identity and Access Management \(IAM\)** is a web service that helps you securely control access to AWS resources for your users\. Use IAM to control who can use your AWS resources \(authentication\) and what resources they can use in which ways \(authorization\)\. For more information, see [Setting Up AWS Elemental MediaTailor](setting-up.md)\.

## Accessing MediaTailor<a name="accessing-emt"></a>

You can access MediaTailor using the service's console\.

Access your AWS account by providing credentials that verify that you have permissions to use the services\. 

To log in to the MediaTailor console, use the following link: **https://console\.aws\.amazon\.com/mediatailor/home**\.

## Pricing for MediaTailor<a name="pricing"></a>

As with other AWS products, there are no contracts or minimum commitments for using MediaTailor\. You are charged based on your use of the service\. For more information, see [MediaTailor Pricing](https://aws.amazon.com/mediatailor/pricing/)\.

## Regions for MediaTailor<a name="regions-endpoints"></a>

To reduce data latency in your applications, MediaTailor offers regional endpoints to make your requests\. To view the list of Regions in which MediaTailor is available, see [https://docs.aws.amazon.com/general/latest/gr/rande.html#mediatailor_region](https://docs.aws.amazon.com/general/latest/gr/rande.html#mediatailor_region)\.

## Stream Requirements<a name="stream-reqmts"></a>

A video stream must meet the following requirements to work with MediaTailor:
+ Use Apple HLS \(HTTP Live Streaming\) or MPEG DASH \(Dynamic Adaptive Streaming over HTTP\)
+ Use live streaming or video on demand \(VOD\)
+ Be accessible on the public internet and have a public IP address
+ Contain ad markers in one of the formats described in [Step 2: Prepare a Stream](getting-started.md#getting-started-prep-stream)

## Transcoded Ad Management<a name="transcoded-ad-management"></a>

MediaTailor manages transcoded ads on your behalf with no additional charge\. When you play an ad in a video stream, it might get copied to another AWS Region\.

If you need to delete your transcoded ad assets for any reason, file a case with AWS Support\. On the navigation bar of the console, choose **Support**, and then choose **Support Center**\. In the Support Center, create a case\.