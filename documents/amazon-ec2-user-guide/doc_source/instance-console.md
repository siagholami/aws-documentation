# Troubleshooting an unreachable instance<a name="instance-console"></a>

You can use the following methods to troubleshoot an unreachable instance\.

**Topics**
+ [Instance reboot](#instance-console-rebooting)
+ [Instance console output](#instance-console-console-output)
+ [Capture a screenshot of an unreachable instance](#instance-console-screenshot)
+ [Instance recovery when a host computer fails](#instance-machine-failure)

## Instance reboot<a name="instance-console-rebooting"></a>

The ability to reboot instances that are otherwise unreachable is valuable for both troubleshooting and general instance management\.

 Just as you can reset a computer by pressing the reset button, you can reset EC2 instances using the Amazon EC2 console, CLI, or API\. For more information, see [Reboot your instance](ec2-instance-reboot.md)\. 

**Warning**  
For Windows instances, this operation performs a hard reboot that might result in data corruption\. 

## Instance console output<a name="instance-console-console-output"></a>

Console output is a valuable tool for problem diagnosis\. It is especially useful for troubleshooting kernel problems and service configuration issues that could cause an instance to terminate or become unreachable before its SSH daemon can be started\. 

For Linux/Unix, the instance console output displays the exact console output that would normally be displayed on a physical monitor attached to a computer\. The console output returns buffered information that was posted shortly after an instance transition state \(start, stop, reboot, and terminate\)\. The posted output is not continuously updated; only when it is likely to be of the most value\.

For Windows instances, the instance console output includes the last three system event log errors\.

You can optionally retrieve the latest serial console output at any time during the instance lifecycle\. This option is only supported on [Instances built on the Nitro System](instance-types.md#ec2-nitro-instances)\. It is not supported through the Amazon EC2 console\.

**Note**  
Only the most recent 64 KB of posted output is stored, which is available for at least 1 hour after the last posting\.

Only the instance owner can access the console output\. You can retrieve the console output for your instances using the console or the command line\.

**To get console output using the console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the left navigation pane, choose **Instances**, and select the instance\.

1. Choose **Actions**, **Instance Settings**, **Get System Log**\.

**To get console output using the command line**

You can use one of the following commands\. For more information about these command line interfaces, see [Accessing Amazon EC2](concepts.md#access-ec2)\.
+ [get\-console\-output](https://docs.aws.amazon.com/cli/latest/reference/ec2/get-console-output.html) \(AWS CLI\)
+ [Get\-EC2ConsoleOutput](https://docs.aws.amazon.com/powershell/latest/reference/items/Get-EC2ConsoleOutput.html) \(AWS Tools for Windows PowerShell\)

For more information about common system log errors, see [Troubleshooting system log errors for Linux\-based instances](TroubleshootingInstances.md#system-log-errors-linux)\.

## Capture a screenshot of an unreachable instance<a name="instance-console-screenshot"></a>

If you are unable to reach your instance via SSH or RDP, you can capture a screenshot of your instance and view it as an image\. The image can provide visibility as to the status of the instance, and allows for quicker troubleshooting\. You can generate screenshots while the instance is running or after it has crashed\. There is no data transfer cost for this screenshot\. The image is generated in JPG format and is no larger than 100 kb\. This feature is not supported when the instance is using an NVIDIA GRID driver, is on bare metal instances \(instances of type `*.metal`\), or is powered by Arm\-based Graviton or Graviton 2 processors\. This feature is available in the following Regions: 
+ US East \(N\. Virginia\) Region
+ US East \(Ohio\) Region
+ US West \(Oregon\) Region
+ US West \(N\. California\) Region
+ Europe \(Ireland\) Region
+ Europe \(Frankfurt\) Region
+  Asia Pacific \(Tokyo\) Region
+ Asia Pacific \(Seoul\) Region
+ Asia Pacific \(Singapore\) Region
+ Asia Pacific \(Sydney\) Region\)
+ South America \(São Paulo\) Region\)
+ Asia Pacific \(Mumbai\) Region
+ Canada \(Central\) Region\)
+ Europe \(London\) Region
+ Europe \(Paris\) Region

**To access the instance console**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the left navigation pane, choose **Instances**\.

1. Select the instance to capture\.

1. Choose **Actions**, **Instance Settings**\.

1. Choose **Get Instance Screenshot**\.

Right\-click on the image to download and save it\.

**To capture a screenshot using the command line**

You can use one of the following commands\. The returned content is base64\-encoded\. For more information about these command line interfaces, see [Accessing Amazon EC2](concepts.md#access-ec2)\.
+ [get\-console\-screenshot](https://docs.aws.amazon.com/cli/latest/reference/ec2/get-console-screenshot.html) \(AWS CLI\)
+ [GetConsoleScreenshot](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/ApiReference-query-GetConsoleScreenshot.html) \(Amazon EC2 Query API\)

## Instance recovery when a host computer fails<a name="instance-machine-failure"></a>

If there is an unrecoverable issue with the hardware of an underlying host computer, AWS may schedule an instance stop event\. You are notified of such an event ahead of time by email\.

**To recover an Amazon EBS\-backed instance running on a host computer that failed**

1. Back up any important data on your instance store volumes to Amazon EBS or Amazon S3\.

1. Stop the instance\.

1. Start the instance\.

1. Restore any important data\.

For more information, see [Stop and start your instance](Stop_Start.md)\.

**To recover an instance store\-backed instance running on a host computer that failed**

1. Create an AMI from the instance\.

1. Upload the image to Amazon S3\.

1. Back up important data to Amazon EBS or Amazon S3\.

1. Terminate the instance\.

1. Launch a new instance from the AMI\.

1. Restore any important data to the new instance\.

For more information, see [Creating an instance store\-backed Linux AMI](creating-an-ami-instance-store.md)\.