--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Supported AWS CLI Commands<a name="using-adapter-cli"></a>

Following, you can find information about how to specify the Amazon S3 Adapter for Snowball as the endpoint for applicable AWS Command Line Interface \(AWS CLI\) commands\. You can also find the list of AWS CLI commands for Amazon S3 that are supported for transferring data to the AWS Snowball Edge device with the adapter\.

**Note**  
For information on installing and setting up the AWS CLI, including specifying what regions you want to make AWS CLI calls against, see [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\.

## Supported AWS CLI Commands for Amazon S3<a name="using-adapter-cli-commands"></a>

Following, you can find a description of the subset of AWS CLI commands and options for Amazon S3 that the AWS Snowball Edge device supports\. If a command or option isn't listed following, it's not supported\. You can declare some unsupported options, like `--sse` or `--storage-class`, along with a command\. However, these are ignored and have no impact on how data is imported\.
+ [cp](https://docs.aws.amazon.com/cli/latest/reference/s3/cp.html) Copies a file or object to or from the AWS Snowball Edge device\. The following are options for this command:
  + `--dryrun` \(boolean\) The operations that would be performed using the specified command are displayed without being run\.
  + `--quiet` \(boolean\) Operations performed by the specified command are not displayed\.
  + `--include` \(string\) Don't exclude files or objects in the command that match the specified pattern\. For details, see [Use of Exclude and Include Filters](https://docs.aws.amazon.com/cli/latest/reference/s3/index.html#use-of-exclude-and-include-filters) in the *AWS CLI Command Reference*\.
  + `--exclude` \(string\) Exclude all files or objects from the command that matches the specified pattern\.
  + `--follow-symlinks | --no-follow-symlinks` \(boolean\) Symbolic links \(symlinks\) are followed only when uploading to S3 from the local file system\. Amazon S3 doesn't support symbolic links, so the contents of the link target are uploaded under the name of the link\. When neither option is specified, the default is to follow symlinks\.
  + `--only-show-errors` \(boolean\) Only errors and warnings are displayed\. All other output is suppressed\.
  + `--recursive` \(boolean\) The command is performed on all files or objects under the specified directory or prefix\.
  + `--page-size` \(integer\) The number of results to return in each response to a list operation\. The default value is 1000 \(the maximum allowed\)\. Using a lower value might help if an operation times out\.
  + `--metadata` \(map\) A map of metadata to store with the objects in Amazon S3\. This map is applied to every object that is part of this request\. In a sync, this functionality means that files that haven't changed don't receive the new metadata\. When copying between two Amazon S3 locations, the `metadata-directive` argument defaults to `REPLACE` unless otherwise specified\.
+ [ls](https://docs.aws.amazon.com/cli/latest/reference/s3/ls.html) Lists objects on the AWS Snowball Edge device\. The following are options for this command:
  + `--human-readable` \(boolean\) File sizes are displayed in human\-readable format\.
  + `--summarize` \(boolean\) Summary information is displayed\. This information is the number of objects and their total size\.
  + `--recursive` \(boolean\) The command is performed on all files or objects under the specified directory or prefix\.
  + `--page-size` \(integer\) The number of results to return in each response to a list operation\. The default value is 1000 \(the maximum allowed\)\. Using a lower value might help if an operation times out\.
+ [rm](https://docs.aws.amazon.com/cli/latest/reference/s3/rm.html) Deletes an object on the AWS Snowball Edge device\. The following are options for this command:
  + `--dryrun` \(boolean\) The operations that would be performed using the specified command are displayed without being run\.
  + `--include` \(string\) Don't exclude files or objects in the command that match the specified pattern\. For details, see [Use of Exclude and Include Filters](https://docs.aws.amazon.com/cli/latest/reference/s3/index.html#use-of-exclude-and-include-filters) in the *AWS CLI Command Reference*\.
  + `--exclude` \(string\) Exclude all files or objects from the command that matches the specified pattern\.
  + `--recursive` \(boolean\) The command is performed on all files or objects under the specified directory or prefix\.
  + `--page-size` \(integer\) The number of results to return in each response to a list operation\. The default value is 1000 \(the maximum allowed\)\. Using a lower value might help if an operation times out\.
  + `--only-show-errors` \(boolean\) Only errors and warnings are displayed\. All other output is suppressed\.
  + `--quiet` \(boolean\) Operations performed by the specified command are not displayed\.
+ [sync](https://docs.aws.amazon.com/cli/latest/reference/s3/sync.html) Syncs directories and prefixes\. This command copies new and updated files from the source directory to the destination\. This command only creates folders in the destination if they contain one or more files\.
**Important**  
Syncing from one directory to another directory on the same Snowball Edge isn't supported\.   
Syncing from one AWS Snowball device to another AWS Snowball device isn't supported\.   
You can only use this option to sync the contents between your on\-premises data storage and a Snowball Edge\.
  + `--dryrun` \(boolean\) The operations that would be performed using the specified command are displayed without being run\.
  + `--quiet` \(boolean\) Operations performed by the specified command are not displayed\.
  + `--include` \(string\) Don't exclude files or objects in the command that match the specified pattern\. For details, see [Use of Exclude and Include Filters](https://docs.aws.amazon.com/cli/latest/reference/s3/index.html#use-of-exclude-and-include-filters) in the *AWS CLI Command Reference*\.
  + `--exclude` \(string\) Exclude all files or objects from the command that matches the specified pattern\.
  + `--follow-symlinks` or `--no-follow-symlinks` \(boolean\) Symbolic links \(symlinks\) are followed only when uploading to S3 from the local file system\. S3 doesn't support symbolic links, so the contents of the link target are uploaded under the name of the link\. When neither option is specified, the default is to follow symlinks\.
  + `--only-show-errors` \(boolean\) Only errors and warnings are displayed\. All other output is suppressed\.
  + `--no-progress` \(boolean\) File transfer progress is not displayed\. This option is only applied when the `--quiet` and `--only-show-errors` options are not provided\.
  + `--page-size` \(integer\) The number of results to return in each response to a list operation\. The default value is 1000 \(the maximum allowed\)\. Using a lower value might help if an operation times out\.
  + `--metadata` \(map\) A map of metadata to store with the objects in Amazon S3\. This map is applied to every object that is part of this request\. In a sync, this functionality means that files that haven't changed don't receive the new metadata\. When copying between two Amazon S3 locations, the `metadata-directive` argument defaults to `REPLACE` unless otherwise specified\.
**Important**  
Syncing from one directory to another directory on the same Snowball Edge isn't supported\.   
Syncing from one AWS Snowball device to another AWS Snowball device isn't supported\.  
You can only use this option to sync the contents between your on\-premises data storage and a Snowball Edge\.
  + `--size-only` \(boolean\) With this option, the size of each key is the only criterion used to decide whether to sync from source to destination\.
  + `--exact-timestamps` \(boolean\) When syncing from S3 to local storage, same\-sized items are ignored only when the timestamps match exactly\. The default behavior is to ignore same\-sized items unless the local version is newer than the S3 version\.
  + `--delete` \(boolean\) Files that exist in the destination but not in the source are deleted during sync\.

You can work with files or folders with spaces in their names, such as `my photo.jpg` or `My Documents`\. However, make sure that you handle the spaces properly in the AWS CLI commands\. For more information, see [Specifying Parameter Values for the AWS Command Line Interface](https://docs.aws.amazon.com/cli/latest/userguide/cli-using-param.html) in the *AWS Command Line Interface User Guide*\.