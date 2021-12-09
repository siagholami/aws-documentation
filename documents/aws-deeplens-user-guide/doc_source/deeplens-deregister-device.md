# Deregistering Your AWS DeepLens Device<a name="deeplens-deregister-device"></a>

Deregistering your AWS DeepLens disassociates your AWS account and credentials from the device\. Before you deregister your device, delete the photos or videos that are stored on it\.

**To deregister your AWS DeepLens**

1. Open the AWS DeepLens console at [https://console\.aws\.amazon\.com/deeplens/home?region=us\-east\-1\#firstrun/](https://console.aws.amazon.com/deeplens/home?region=us-east-1#firstrun)\.

1. From the primary navigation pane, choose **Devices**, then choose the device that you want to deregister\.

1. Next to the **Current project** on the selected device page, choose **Remove current project from device**\.
**Important**  
Delete the  photos or videos that are stored on the device, using SSH and the SSH password that you set when you registered the device to log on to the device\. Navigate to the folder where the photos or videos are stored and delete them\. 

1. When prompted, choose **Yes** to confirm\.

1. Next to **Device Settings**, choose **Deregister**\.

1. When prompted, choose **Deregister** to confirm\.

Your AWS DeepLens is now deregistered\. To use it again, repeat each of these steps:
+ [Register Your AWS DeepLens Device](deeplens-getting-started-register.md)
+ [Connect to Your AWS DeepLens Device's Wi\-Fi Network](deeplens-getting-started-connect.md)
+ [Set Up Your AWS DeepLens Device](deeplens-getting-started-set-up.md)
+ [Verify Your AWS DeepLens Device Registration Status](deeplens-getting-started-verify-connection.md)