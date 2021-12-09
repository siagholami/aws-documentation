# Editing an Endpoint<a name="endpoints-edit"></a>

Edit the packaging preferences on an endpoint to optimize the viewing experience\. You can't change the packager type after you save an endpoint\. To serve content with a different packager, create a different endpoint\.

If you edited the channel to enable Amazon CloudFront distribution creation from the AWS Elemental MediaPackage console, you can also edit the endpoint to add an origin to the distribution \(if you didn't already add one through alternate means\)\. When you save the edited endpoint, MediaPackage automatically works with CloudFront to create the origin\.

You can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API to change an endpoint's settings\. For information about editing an endpoint through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

When you're editing an endpoint, do not put sensitive identifying information like customer account numbers into free\-form fields such as the **Name** field\. This includes when you work with AWS Elemental MediaPackage using the console, REST API, AWS CLI, or AWS SDKs\. Any data that you enter into MediaPackage might get picked up for inclusion in diagnostic logs or Amazon CloudWatch Events\.

**To edit an endpoint \(console\)**

1. Access the channel that the endpoint is associated with, as described in [Viewing Channel Details](channels-view.md)\.

1. On the channel's details page, do one of the following:
   + Choose **Add and edit endpoints** and on the **Edit** page, choose the endpoint to edit\.
   + Choose the name of the endpoint to edit, and then choose **Edit endpoint**\.

1. Edit the endpoint options that you want to change\.

   For information about endpoint attributes, see [Creating an Endpoint](endpoints-create.md)\.

1. Choose **Save all**\.