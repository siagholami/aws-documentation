# Clean Up<a name="launch-config-cleanup"></a>

When you no longer need the DLAMI, you can stop it or terminate it to avoid incurring continuing charges\. Stopping an instance will keep it around so you can resume it later\. Your configurations, files, and other non\-volatile information is being stored in a volume on Amazon S3\. You will be charged the small S3 fee to retain the volume while the instance is stopped, but you will no longer be charged for the compute resources while it is in the stopped state\. When your start the instance again, it will mount that volume and your data will be there\. If you terminate an instance, it is gone, and you cannot start it again\. Your data actually still resides on S3, so to prevent any further charges you need to delete the volume as well\. For more instructions, see [Terminate Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/terminating-instances.html) in the *Amazon EC2 User Guide for Linux Instances*\.