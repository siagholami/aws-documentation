# Step 6: Clean Up<a name="gs-cleanup-ltov"></a>

To avoid incurring extra charges, delete the resources that you're no longer using\.

**Note**  
Harvest jobs automatically expire off your account and can't be manually deleted\.

## Delete Live Resources<a name="gs-cleanup-ltov-l"></a>

When you're done ingesting, serving, and harvesting from live content, delete the channel and endpoint\. You must delete all endpoints on a channel before you can delete the channel\. 

**To delete an endpoint**

1. On the **Channels page**, choose the channel that the endpoint is associated with\.

1. On the channel details page, choose the name of the endpoint that you want to delete\.

1. On the endpoint details page, choose **Delete endpoint**\.

1. On the **Delete Endpoints** page, choose **Save all**\.

**To delete a channel**

1. On the **Channels** page, choose the channel using one the following methods: 
   + Choose the channel name
   + Select the check box next to the channel name

1. Choose **Delete selected** or **Delete channel**\.

1. In the confirmation dialog box, choose **Delete**\.

   AWS Elemental MediaPackage removes the channel and all associated endpoints\.

## Delete VOD Resources<a name="gs-cleanup-ltov-v"></a>

When you're done ingesting and serving VOD content, delete the extra resources\. If you want to make a specific output unavailable, delete the packaging configuration from the packaging group\. If you want to make an asset no longer available for playback from any outputs, delete the asset\. 

**To delete an asset**

1. On the AWS Elemental MediaPackage console, go to the **Assets** page, and then choose the **ID** of the asset\.

1. On the asset's details page, choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.

**To delete a packaging configuration**

1. On the AWS Elemental MediaPackage console, go to the **Packaging groups** page\.

1. Choose the **ID** of the group that has the configuration that you want to delete\.

1. On the packaging group's details page, in the **Packaging configurations** section, locate the configuration and choose its **ID**\.

1. On the packaging configuration's details page, choose **Delete**\.

1. In the confirmation dialog box, choose **Delete**\.