--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Using the Adapter with Amazon S3 Commands for the AWS CLI<a name="using-adapter-cli"></a>

In the following, you can find how to specify the Amazon S3 Adapter for Snowball as the endpoint for applicable AWS CLI commands\. You can also find what Amazon S3 AWS CLI commands are supported for transferring data to the Snowball with the adapter\.

**Note**  
For information on installing and setting up the AWS CLI, including specifying what regions you want to make AWS CLI calls against, see the [AWS Command Line Interface User Guide](https://docs.aws.amazon.com/cli/latest/userguide/)\.

## Specifying the Adapter as the AWS CLI Endpoint<a name="using-adapter-cli-endpoint"></a>

When you use the AWS CLI to issue a command to the Snowball, specify that the endpoint is the Amazon S3 Adapter for Snowball, as shown following\.

```
aws s3 ls --endpoint http://<IP address for the S3 Adapter>:8080
```

By default, the adapter runs on port 8080\. You can specify a different port by changing the contents in the snowball\-adapter\.config file described in [Downloading and Installing the Amazon S3 Adapter for Snowball](snowball-transfer-adapter.md#adapter-install)\.

## Supported AWS CLI Amazon S3 Commands<a name="using-adapter-cli-commands"></a>

Following, you can find a description of the subset of AWS CLI commands and options for Amazon S3 that the AWS Snowball Edge device supports\. If a command or option isn't listed following, it's not supported\. You can declare some unsupported options, like `--sse` or `--storage-class`, along with a command\. However, these are ignored and have no impact on how data is imported\.
+ [cp](https://docs.aws.amazon.com/cli/latest/reference/s3/cp.html) Copies a file or object to or from the Snowball\.
  + `--dryrun` \(boolean\) The operations that would be performed using the specified command are displayed without being run\.
  + `--quiet` \(boolean\) Operations performed by the specified command are not displayed\.
  + `--include` \(string\) Don't exclude files or objects in the command that match the specified pattern\. See [Use of Exclude and Include Filters](https://docs.aws.amazon.com/cli/latest/reference/s3/index.html#use-of-exclude-and-include-filters) in the *AWS CLI Command Reference* for details\.
  + `--exclude` \(string\) Exclude all files or objects from the command that matches the specified pattern\.
  + `--follow-symlinks | --no-follow-symlinks` \(boolean\) Symbolic links \(symlinks\) are followed only when uploading to S3 from the local file system\. Amazon S3 doesn't support symbolic links, so the contents of the link target are uploaded under the name of the link\. When neither option is specified, the default is to follow symlinks\.
  + `--only-show-errors` \(boolean\) Only errors and warnings are displayed\. All other output is suppressed\.
  + `--recursive` \(boolean\) The command is performed on all files or objects under the specified directory or prefix\. Currently, this option is only supported for uploading data to a Snowball\.
  + `--metadata` \(map\) A map of metadata to store with the objects in Amazon S3\. This map is applied to every object that is part of this request\. In a sync, this functionality means that files that aren't changed don't receive the new metadata\. When copying between two Amazon S3 locations, the metadata\-directive argument defaults to `REPLACE` unless otherwise specified\.
**Important**  
Syncing from one directory on a Snowball to another directory on the same Snowball is not supported\. Syncing from one Snowball to another Snowball is not supported\.
+ [ls](https://docs.aws.amazon.com/cli/latest/reference/s3/ls.html) Lists objects on the Snowball\.
  + `--human-readable` \(boolean\) File sizes are displayed in human\-readable format\.
  + `--summarize` \(boolean\) Summary information is displayed \(number of objects, total size\)\.
+ [rm](https://docs.aws.amazon.com/cli/latest/reference/s3/rm.html) Deletes an object on the Snowball\.
  + `--dryrun` \(boolean\) The operations that would be performed using the specified command are displayed without being run\.
  + `--include` \(string\) Don't exclude files or objects in the command that match the specified pattern\. For details, see [Use of Exclude and Include Filters](https://docs.aws.amazon.com/cli/latest/reference/s3/index.html#use-of-exclude-and-include-filters) in the *AWS CLI Command Reference*\.
  + `--exclude` \(string\) Exclude all files or objects from the command that matches the specified pattern\.
  + `--only-show-errors` \(boolean\) Only errors and warnings are displayed\. All other output is suppressed\.
  + `--quiet` \(boolean\) Operations performed by the specified command are not displayed\.