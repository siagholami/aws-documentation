# Deleting an Endpoint<a name="endpoints-delete"></a>

Endpoints can serve content until they are deleted\. Delete the endpoint if it should no longer respond to playback requests\. You must delete all endpoints from a channel before you can delete the channel\.

**Warning**  
If you delete an endpoint, the playback URL stops working\.

You can use the AWS Elemental MediaPackage console, the AWS CLI, or the MediaPackage API to delete an endpoint\. For information about deleting an endpoint through the AWS CLI or MediaPackage API, see the [AWS Elemental MediaPackage API Reference](https://docs.aws.amazon.com/mediapackage/latest/apireference/)\.

**To delete an endpoint \(console\)**

1. Access the channel that the endpoint is associated with, as described in [Viewing Channel Details](channels-view.md)\.

1. On the channel details page, choose the endpoint name\.

1. On the endpoint details page, choose **Delete endpoint**\.

1. On the **Delete Endpoints** page, choose **Save all**\.