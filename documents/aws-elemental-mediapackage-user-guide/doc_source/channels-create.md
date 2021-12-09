# Creating a Channel<a name="channels-create"></a>

Create a channel to start receiving content streams\. Later, you add an endpoint to the channel\. This endpoint is the access point for content playback requests\.

You can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API to create a channel\. For information about creating a channel through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

When you're creating a channel, do not put sensitive identifying information like customer account numbers into free\-form fields such as the **Name** field\. This includes when you work with AWS Elemental MediaPackage using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To create a channel \(console\)**

1. Open the MediaPackage console at [https://console\.aws\.amazon\.com/mediapackage/](https://console.aws.amazon.com/mediapackage/)\.

1. On the **Channels** page, choose **Create channel**\.

1. For **ID**, type a name that describes the channel\. The ID is the primary identifier for the channel, and must be unique for your account in the region\.

1. \(Optional\) For **Description**, type any descriptive text that helps you to identify the channel\.

1. For **Input type**, choose **Apple HLS**\.

1. Choose **Create channel**\.

   AWS Elemental MediaPackage displays the new channel's details page\.

   The channel is active and can start receiving content as soon as it's created\. AWS Elemental MediaPackage scales resources up and down to allow the right amount of capacity for your traffic\. If you're using input redundancy and one of the inputs stops sending content, then MediaPackage automatically switches to the other input for the source content\. For more information about how input redundancy works, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.

   When you're creating a channel, you will receive an error if you exceed the quotas on the account\. An error similar to Too many requests, please try again\. Resource limit exceeded means that either you have exceeded the API request quotas, or you have already reached the maximum number of channels allowed on your account\. If this is your first channel, or if you think you received this error wrongfully, use the Service Quotas console to [request quota increases](https://console.aws.amazon.com/servicequotas/home?region=us-east-1#!/services/mediapackage/quotas)\. For more information about quotas in AWS Elemental MediaPackage, see [Quotas in AWS Elemental MediaPackage](limits.md)\.