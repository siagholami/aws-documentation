# Creating a DASH Endpoint<a name="endpoints-dash"></a>

Create an endpoint that formats content for devices that support MPEG\-DASH\.

**To create an MPEG\-DASH endpoint \(console\)**

1. Access the channel that the endpoint will be associated with, as described in [Viewing Channel Details](channels-view.md)\.

1. On the details page for the channel, choose either **Add and edit endpoint** or **Add endpoints** if there are no existing endpoints\.

1. Complete the fields as described in the following topics:
   + [New Endpoint Fields](endpoints-dash-new.md)
   + [Packager Settings Fields](endpoints-dash-packager.md)
   +  [Encryption Fields](endpoints-dash-encryption.md)
   + [Access Control Fields](endpoints-dash-access-control.md)
   + [Streams to Include Fields](endpoints-dash-include-streams.md)

1. Choose **Save endpoints**\.

   If you enabled Amazon CloudFront distribution creation from the AWS Elemental MediaPackage console and this is your first endpoint on the channel, MediaPackage adds an origin to the distribution\. You can view the CloudFront CDN URL and endpoint information in the endpoints section of the channel's details page\.

   The endpoint is active and can deliver content as soon as requests are sent to its URL endpoints\. AWS Elemental MediaPackage scales resources up and down to allow the right amount of capacity for your traffic\.

   When you're creating an endpoint, you will receive an error if you exceed the quotas on the account\. An error similar to Too many requests, please try again\. Resource limit exceeded means that either you have exceeded the API request quotas, or you have already reached the maximum number of endpoints allowed on this channel\. If you think you received this error wrongfully, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\. For more information about quotas in AWS Elemental MediaPackage, see [Quotas in AWS Elemental MediaPackage](limits.md)\.