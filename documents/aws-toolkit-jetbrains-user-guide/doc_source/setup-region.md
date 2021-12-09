# Setting an AWS Region for the AWS Toolkit for JetBrains<a name="setup-region"></a>

When you configure the AWS Toolkit for JetBrains to connect to an AWS account, the toolkit sets the default AWS Region automatically\. This topic describes how to get the current AWS Region or to change it\.

**Topics**
+ [Getting the current AWS Region](#setup-region-current-region)
+ [Switching AWS Regions](#setup-region-switch-region)

## Getting the current AWS Region<a name="setup-region-current-region"></a>

To check which AWS Region the AWS Toolkit for JetBrains is currently using, do one of the following:
+ On the status bar, see the current Region displayed in the **AWS Connection Settings** area\.  
![\[The current AWS Region in the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open, and then choose **Show Options Menu** \(the settings icon\)\. Choose **AWS Connection Settings**\. The current Region is selected\.  
![\[The current AWS Region in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

You can also [switch to a different AWS Region](key-tasks.md#key-tasks-switch-region), if you want\.

## Switching AWS Regions<a name="setup-region-switch-region"></a>

To change the AWS Region Do one of the following\.
+ On the status bar, choose **AWS Connection Settings**, and then choose the AWS Region that you want to switch to\.  
![\[Choosing a different AWS Region in the status bar\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)
+ [Open AWS Explorer](key-tasks.md#key-tasks-open-explorer), if it isn't already open\. Choose **Show Options Menu** \(the settings icon\), and then choose **AWS Connection Settings**\. If the AWS Region that you want to switch to is listed, choose it\. Otherwise, choose **All Regions**, and then choose the Region to switch to\.  
![\[Choosing a different AWS Region in AWS Explorer\]](http://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/)

The AWS Toolkit switches to using the new Region, which is now selected in the **AWS Connection Settings** menu in both the status bar and the **AWS Explorer**\.