# Step 3: Run Your Analysis<a name="getting-started-step3"></a>

Now that your file system has been created and mounted to a compute instance, you can use it to run your high\-performance compute workload\.

If you linked your file system to an Amazon S3 data repository, you can export data that you've written to your file system back to your Amazon S3 bucket at any time\. From a terminal on one of your compute instances, run the following command to export a file to your Amazon S3 bucket\.

```
sudo lfs hsm_archive file_name
```

For more information on how to run this command on a folder or large collection of files quickly, see [Using data repositories with Amazon FSx for Lustre](fsx-data-repositories.md)\.