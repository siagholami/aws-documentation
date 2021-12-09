--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Batching Small Files<a name="batching-small-files"></a>

Each copy operation has some overhead because of encryption\. To speed up the process of transferring small files, you can batch them together in a single archive\. When you batch files together, they can be auto\-extracted when they are imported into Amazon S3, if they were batched in one of the supported archive formats\.

Typically, files that are 1 MB or smaller should be included in batches\. There's no hard limit on the number of files you can have in a batch, though we recommend that you limit your batches to about 10,000 files\. Having more than 100,000 files in a batch can affect how quickly those files import into Amazon S3 after you return the device\. We recommend that the total size of each batch be no larger than 100 GB\.

Batching files is a manual process, which you manage\. After you batch your files, transfer them to a Snowball Edge device using the AWS CLI `cp` command with the `--metadata snowball-auto-extract=true` option\. Specifying `snowball-auto-extract=true` automatically extracts the contents of the archived files when the data is imported into Amazon S3, so long as the size of the batched file is no larger than 100 GB\.

**Note**  
Any batches larger than 100 GB will not be extracted when they are imported into Amazon S3\.

**To batch small files**

1. Decide on what format you want to batch your small files in\. The auto\-extract feature supports the `TAR`, `ZIP`, and `tar.gz` formats\.

1. Identify which small files you want to batch together, including their size and the total number of files that you want to batch together\.

1. If you're using Linux, you can batch the files in the same command line used to transfer your files to the device, as in the following example\.

   ```
   tar -cf - /Logs/April | aws s3 cp - s3://mybucket/batch01.tar --metadata snowball-auto-extract=true --endpoint http://192.0.2.0:8080
   ```
**Note**  
Alternatively, you can use the archive utility of your choice to batch the files into one or more large archives\. However, this approach requires extra local storage to save the archives before you transfer them to the Snowball\.

1. Repeat until you've archived all the small files that you want to transfer to Amazon S3 using a Snowball Edge\.

1. Transfer the archived files to the Snowball\. If you want the data to be auto\-extracted, and you used one of the supported archive formats mentioned above in step 1, use the AWS CLI `cp` command with the `- -metadata snowball-auto-extract=true` option\.