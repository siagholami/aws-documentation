# Step 2: Create a Channel<a name="create-channel"></a>

The channel is the first component in AWS Elemental MediaPackage\. It represents the input to MediaPackage for incoming live content from an encoder such as AWS Elemental MediaLive\. 

MediaPackage does not require that you supply any customer data\. There are no fields in channels where there is an expectation that you will provide customer data\.

**To create a channel**

1. On the MediaPackage **Channels** page, choose **Create channel**\.

1. For **ID**, enter a name that describes the channel, such as **channelHLS1**\. The ID is the primary identifier for the channel, and must be unique for your account in the AWS Region\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. Keep the defaults for the remaining fields, and then choose **Create channel**\.

   MediaPackage displays the new channel's details page\.

1. On the channel's details page, note the values for **Input URL**, **Username**, and **Password**\. If you're using input redundancy, you need this information for both input URLs\. If you're sending only one stream to the channel, you can note the information for either input URL\. 

   MediaPackage securely generates the WebDAV user names and passwords when it creates the channel\. If you need to change these credentials, see [Rotating Credentials on an Input URL](channels-rotate-creds.md)\.

   Provide the information from these fields to the person in charge of the upstream encoder\. In the stream configuration in the encoder, this person must enter the destination as the input URL, and the WebDAV credentials as the channel's user name and password\. The upstream encoder must use digest authentication and push WebDAV over HTTPS to MediaPackage, and include these credentials\. If you're using input redundancy, the input streams to this channel must have identical encoder settings\. For more information about setting up source streams for input redundancy, see [Live Input Redundancy AWS Elemental MediaPackage Processing Flow](what-is-flow-ir.md)\.