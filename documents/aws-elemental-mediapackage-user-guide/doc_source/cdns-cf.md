# Using AWS Elemental MediaPackage with Amazon CloudFront<a name="cdns-cf"></a>

The following sections provide procedures for working with distributions from Amazon CloudFront\.

**Topics**
+ [Creating a Distribution](#cdns-create)
+ [Viewing a Distribution](#cdns-view)
+ [Editing a Distribution](#cdns-edit)
+ [Deleting a Distribution](#cdns-delete)

## Creating a Distribution<a name="cdns-create"></a>

A distribution in Amazon CloudFront holds all information about content delivery, including where content is coming from and how it's tracked and managed\. The distribution holds origins \(where content is originating from\) and behaviors \(where content requests are routed based on specified patterns in the request\)\. You can create a distribution automatically from the AWS Elemental MediaPackage live console, or manually from the CloudFront console\. The following sections describe each approach\.

**Topics**
+ [Creating a Distribution from AWS Elemental MediaPackage](#cdns-create-mp)
+ [Creating a Distribution from Amazon CloudFront](#cdns-create-cf)

### Creating a Distribution from AWS Elemental MediaPackage<a name="cdns-create-mp"></a>

You can create a CloudFront distribution from the AWS Elemental MediaPackage console when you're working with live content only\.

AWS Elemental MediaPackage communicates with Amazon CloudFront on your behalf to create a distribution for a channel and its endpoints\. When you enable the feature, MediaPackage creates a distribution in CloudFront when you save the channel, and then adds an origin and updates cache behaviors when you save an endpoint\. Because the creation process is automated and initiated from your actions in MediaPackage, there is no additional action required from you\. 

**Important**  
You need additional permissions to create distributions in CloudFront\. Have an admin user add the correct level of permissions through AWS Identity and Access Management \(IAM\) using the steps described in [Step 1: \(Optional\) Create a Policy for Amazon CloudFront](setting-up-create-non-admin-iam-cf.md)\.

**To create a distribution from the AWS Elemental MediaPackage console**

1. Start a new channel as described in [Creating a Channel](channels-create.md), and then choose **Create a CloudFront distribution**\. 

   You can also edit an existing channel to add a distribution\. For instructions on editing a channel, see [Editing a Channel](channels-edit.md)\.

1. When you've completed the channel, choose **Save**\. AWS Elemental MediaPackage communicates with CloudFront to create a distribution\. CloudFront uses placeholder values for settings that require information from the endpoint in MediaPackage, such as the origin domain name and caching behaviors\. 

   If you receive an error message that CloudFront couldn't create the distribution, choose **Edit** on the channel and save it again to restart the creation process\.

   Note that when the distribution is first created, it isn't fully functional until it has an origin, which AWS Elemental MediaPackage creates in the next step \(when you create an endpoint in MediaPackage\)\.

1. Create an endpoint on the channel, as described in [Creating an Endpoint](endpoints-create.md)\. AWS Elemental MediaPackage updates the origin and cache behaviors with information from the endpoint, and configures the distribution with settings that optimize live video streaming, as described in [Serving Live Video Formatted with AWS Elemental MediaPackage](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/live-streaming.html#live-streaming-with-mediapackage) of the *Amazon CloudFront Developer Guide*\.

   If you're adding a distribution to an existing channel with endpoints, AWS Elemental MediaPackage automatically adds the origin for you\.

   AWS Elemental MediaPackage communicates with CloudFront to add an origin to the distribution, and to update the settings on the distribution\. 

   When the distribution status on the channel's details page says **Deployed**, you can start using the distribution\. From the details page, note the CloudFront CDN URL and provide it for downstream devices to send playback requests\.
**Note**  
AWS Elemental MediaPackage adds only one origin to the distribution\. All endpoints on the channel are served by the same origin on the distribution\.

### Creating a Distribution from Amazon CloudFront<a name="cdns-create-cf"></a>

After you create a channel and its endpoints in AWS Elemental MediaPackage, note the URLs for each of the endpoints\. These URLs are what you use for the origin domain names for your CloudFront distribution\. You need one origin for each endpoint on the channel in MediaPackage\. 

For detailed steps about creating a distribution in Amazon CloudFront with AWS Elemental MediaPackage endpoints as the origins, see [Delivering Live Streaming Video](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/live-streaming.html) in the *Amazon CloudFront Developer Guide*\.

## Viewing a Distribution<a name="cdns-view"></a>

As described in [Viewing Channel Details](channels-view.md), you can view basic information about a distribution that was created in MediaPackage, such as the distribution ID and description\. Note that the ID links to the CloudFront management console\.

Access more detailed information about the distribution from the Amazon CloudFront console\. For help accessing this information, see [Viewing and Updating Distribution](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/HowToUpdateDistribution.html) in the *Amazon CloudFront Developer Guide*\.

## Editing a Distribution<a name="cdns-edit"></a>

Edit an Amazon CloudFront distribution from the CloudFront console\. The only edit that AWS Elemental MediaPackage can make to an origin is to create an origin when you add an endpoint to a channel in MediaPackage\. You can't edit a distribution from the MediaPackage console\.

To access the distribution in CloudFront, choose the distribution's ID on the channel's details page\. For more information about editing a distribution in CloudFront, see [Viewing and Updating Distribution](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/HowToUpdateDistribution.html) in the *Amazon CloudFront Developer Guide*\.

**Important**  
When you're editing a distribution, do not change the default on the **Tagging** page\. CloudFront uses the AWS Elemental MediaPackage channel ID in this tag to link the distribution and the channel together\. If the tag is modified, then you will no longer be able to view or manage the distribution from MediaPackage\.

## Deleting a Distribution<a name="cdns-delete"></a>

Delete an Amazon CloudFront distribution from the CloudFront console\. You can't delete a distribution from the AWS Elemental MediaPackage console\.

To access the distribution in CloudFront, choose the distribution's ID on the channel's details page\. For more information about deleting a distribution in CloudFront, see [Deleting a Distribution](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/HowToDeleteDistribution.html) in the *Amazon CloudFront Developer Guide*\.