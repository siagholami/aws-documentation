# Step 5: Clean Up Resources<a name="getting-started-step4"></a>

After you have finished this exercise, you should follow these steps to clean up your resources and protect your AWS account\.

**To clean up resources**

1. If you want to do a final export, run the following command\.

   ```
   nohup find /mnt/fsx -type f -print0 | xargs -0 -n 1 sudo lfs hsm_archive &
   ```

1. On the Amazon EC2 console, terminate your instance\. For more information, see [Terminate Your Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/terminating-instances.html) in the *Amazon EC2 User Guide for Linux Instances\.*

1. On the Amazon FSx for Lustre console, delete your file system with the following procedure:

   1. In the navigation pane, choose **File systems**\.

   1. Choose the file system that you want to delete from list of file systems on the dashboard\.

   1. For **Actions**, choose **Delete file system**\.

   1. In the dialog box that appears, confirm that you want to delete your file system, and choose **Delete file system**\.

1. If you created an Amazon S3 bucket for this exercise, and if you don't want to preserve the data you exported, you can now delete it\. For more information, see [How Do I Delete an S3 Bucket?](https://docs.aws.amazon.com/AmazonS3/latest/user-guide/delete-bucket.html) in the *Amazon Simple Storage Service Console User Guide\.*