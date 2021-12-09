# Allowing Amazon CloudFront to access your AWS Elemental MediaStore container<a name="cdns-allowing-cloudfront-to-access-mediastore"></a>

You can use Amazon CloudFront to serve the content that you store in a container in AWS Elemental MediaStore\. To get started, you attach a policy to your container that grants read access or greater to CloudFront\. 

**To allow CloudFront to access your container \(console\)**

1. Open the MediaStore console at [https://console\.aws\.amazon\.com/mediastore/](https://console.aws.amazon.com/mediastore/)\.

1. On the **Containers** page, choose the container name\.

   The container details page appears\.

1. In the **Container policy** section, attach a policy that grants read access or greater to Amazon CloudFront\.
**Note**  
The example policy for [Public Read Access over HTTPS](policies-examples-public-https.md) matches these requirements because it allows `GetObject` and `DescribeObject` commands from anyone who submits requests to your domain through HTTPS\.

1. In the **Container CORS policy** section, assign a policy that allows the appropriate access level\. 
**Note**  
A [CORS policy](cors-policy.md) is necessary only if you want to provide access to a browser\-based player\.

1. Make note of the following details:
   + The data endpoint that is assigned to your container\. You can find this information in the **Info** section of the **Containers** page\. In CloudFront, the data endpoint is referred to as the *origin domain name*\.
   + The folder structure in the container where the objects are stored\. In CloudFront, this is referred to as the *origin path*\. Note that this setting is optional\. For more information about origin paths, see the [Amazon CloudFront Developer Guide](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/distribution-web-values-specify.html#DownloadDistValuesOriginPath)\.

1. In CloudFront, create a distribution that is [configured to serve content from AWS Elemental MediaStore](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/live-streaming.html#video-streaming-mediastore)\. You will need the information that you collected in the preceding step\.