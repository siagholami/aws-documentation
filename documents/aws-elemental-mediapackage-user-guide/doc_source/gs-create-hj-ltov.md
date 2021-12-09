# Step 3: Extract a VOD Asset<a name="gs-create-hj-ltov"></a>

To extract a live\-to\-VOD asset from a live content stream, create a harvest job\. The harvest job identifies what endpoint the asset is being harvested from, the start and end of the asset, and where MediaPackage saves the asset after it's been harvested\. 

**To create a harvest job**

1. On the MediaPackage **Harvest jobs** page, choose **Create job**\.

1. For **ID**, enter a name that describes the harvest job, such as **gamehighlights**\. The ID is the primary identifier for the job\. You can reuse the ID after the harvest job expires from your account\. Supported characters are letters, numbers, underscore \(\_\), and dash \(\-\)\. You can't use spaces in the ID\.

1. For **Origin endpoint**, select the endpoint for the live content stream that you're extracting a VOD asset from\. The endpoint must serve clear \(unencrypted\) HLS content\. If you want to extract from encrypted live content, see [Creating Live\-to\-VOD Assets with AWS Elemental MediaPackage](ltov.md)\.

1. For **Date and time format**, keep the default\.

1. For **Start date and time** and **End date and time**, enter the start and end dates and times for the extracted VOD asset\. The start time must be after the live stream has started and before the current time \("now"\)\. The end time must be in the past\.
**Note**  
"Now" is the current time according to the program date time \(PDT\), when it's present in the source content from the encoder\.

1. For **IAM role**, enter the IAM role that allows MediaPackage to write to Amazon S3\. For help with the role, see [Allowing AWS Elemental MediaPackage to Access Other AWS Services](setting-up-create-trust-rel.md)\.

1. For **S3 bucket name**, select the bucket where you want MediaPackage to store the live\-to\-VOD asset\.

1. For **Manifest key**, enter the path within the Amazon S3 bucket and file name for the master manifest of the live\-to\-VOD asset\. MediaPackage creates a directory based on the path that you enter\.
**Important**  
The manifest key must be unique\. When you use the same manifest key for multiple harvest jobs, the newest playlist for the asset overwrites existing playlists\. The only time you should reuse a manifest key is when you are harvesting the same content, such as if there was a problem with a previous harvest of the content\.

1. Choose **Create job**\.

When MediaPackage processes the harvest job, it sends a CloudWatch event when the job fails or succeeds\. The event includes the details of the harvest job\. If the job fails, the event includes information about why\. This information is available only in the CloudWatch event\. For example events, see [Harvest Job Notification Events](cloudwatch-events-example.md#hj-status-events)\.