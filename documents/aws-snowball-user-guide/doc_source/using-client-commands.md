--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Commands for the Snowball Client<a name="using-client-commands"></a>

Following, you can find information on Snowball client commands that help you manage your data transfer into Amazon Simple Storage Service \(Amazon S3\)\. You can have multiple instances of the Snowball client in different terminal windows connected to a single Snowball\.

**Topics**
+ [Copy Command for the Snowball Client](#snowball-cp-command)
+ [List Command for the Snowball Client](#snowball-ls-command)
+ [Make Directory Command for the Snowball Client](#snowball-mkdir-command)
+ [Retry Command for the Snowball Client](#snowball-retry-command)
+ [Remove Command for the Snowball Client](#snowball-rm-command)
+ [Start Command for the Snowball Client](#snowball-start-command)
+ [Status Command for the Snowball Client](#snowball-status-command)
+ [Stop Command for the Snowball Client](#snowball-stop-command)
+ [Test Command for the Snowball Client](#snowball-test-command)
+ [Validate Command for the Snowball Client](#snowball-validate-command)
+ [Version Command for the Snowball Client](#snowball-version-command)
+ [Using the Verbose Option](#clientverbose)

During data transfer, at least one folder appears at the root level of the Snowball\. This folder and any others at this level have the same names as the Amazon S3 buckets that you chose when this job was created\. You can't write data to the root level of the Snowball\. All data must be written into one of the bucket folders or into their subfolders\.

You can work with files or folders with spaces in their names, like `my photo.jpg` or `My Documents`\. However, make sure that you handle the spaces properly in the client commands\. For more information, see the following examples:
+ **Linux and Mac version of the client** – `snowball ls s3://mybucket/My\ Folder/my\ photo.jpg`
+ **Windows version of the client** – `snowball ls "s3://mybucket/My Documents/my photo.jpg"`

**Note**  
Before transferring data into Amazon S3 using Snowball, you should make sure that the files and folders that you're going to transfer are named according to the [Object Key Naming Guidelines](https://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html#object-key-guidelines) for Amazon S3\. 

If you're having trouble using the Snowball client, see [Troubleshooting for a Standard Snowball](troubleshooting.md)\.

## Copy Command for the Snowball Client<a name="snowball-cp-command"></a>

The `snowball cp` command copies files and folders between the Snowball and your data source\. For details on options for the Snowball copy command \(`snowball cp`\), see [Options for the snowball cp Command](copy-command-reference.md)\. In addition to supporting command options, transferring data with the Snowball client supports schemas to define what type of data is being transferred\. For more information on schemas, see [Schemas for Snowball Client](using-client.md#using-client-schema)\.

**Usage**

```
snowball cp [OPTION...] SRC... s3://DEST
```

**Import examples**

```
snowball cp --recursive /Logs/April s3://MyBucket/Logs
```

```
snowball cp -r /Logs/April s3://MyBucket/Logs
```

**Export examples**

```
snowball cp --recursive s3://MyBucket/Logs/ /Logs/April
```

```
snowball cp -r s3://MyBucket/Logs/ /Logs/April
```

For details on options for the Snowball copy command \(`snowball cp`\), see [Options for the snowball cp Command](copy-command-reference.md)\.

## List Command for the Snowball Client<a name="snowball-ls-command"></a>

The `snowball ls` command lists the Snowball contents in the specified path\. You can't use this command to list the contents on your workstation, your data source, or other network locations outside of the Snowball\.

**Usage**

```
snowball ls [OPTION...] s3://DEST
```

**Example**

```
snowball ls s3://MyBucket/Logs/April
```

## Make Directory Command for the Snowball Client<a name="snowball-mkdir-command"></a>

The `snowball mkdir` command creates a new subfolder on the Snowball\. You can't create a new folder at the root level\. The root level is reserved for bucket folders\.

**Usage**

```
snowball mkdir [OPTION...] s3://DEST
```

**Example**

```
snowball mkdir s3://MyBucket/Logs/April/ExpenseReports
```

## Retry Command for the Snowball Client<a name="snowball-retry-command"></a>

The `snowball retry` command retries the `snowball cp` command for all the files that didn't copy the last time `snowball cp` was executed\. The list of files that weren't copied is saved in a plaintext log in your workstation's temporary directory\. The exact path to that log is printed to the terminal if the `snowball cp` command fails to copy a file\.

**Example Usage**

```
snowball retry
```

## Remove Command for the Snowball Client<a name="snowball-rm-command"></a>

The `snowball rm` command deletes files and folders on the Snowball\. This operation can take some time to complete if it removes a large number of files or directories, such as with `snowball rm -r`, which deletes everything on the device\. If you run the `snowball ls` command afterwards, it shows you the state of the device when the deletion is completed\.

However, the amount of storage reported by the `snowball status` command may show you the amount of storage remaining before the `snowball rm` command was issued\. If this happens, try the `snowball status` command in an hour or so to see the new remaining storage value\.

**Usage**

```
snowball rm [OPTION...] s3://DEST
```

**Examples**

```
snowball rm --recursive s3://MyBucket/Logs/April
```

```
snowball rm -r s3://MyBucket/Logs/April
```

## Start Command for the Snowball Client<a name="snowball-start-command"></a>

The `snowball start` command authenticates your access to the Snowball with the Snowball's IP address and your credentials\. After you run a `snowball start` command, you can execute any number of `snowball cp` commands\.

**Usage**

```
snowball start -i IP Address -m Path/to/manifest/file -u 29 character unlock code
```

**Example**

```
snowball start -i 192.0.2.0 -m /user/tmp/manifest -u 01234-abcde-01234-ABCDE-01234
```

## Status Command for the Snowball Client<a name="snowball-status-command"></a>

The `snowball status` command returns the status of the Snowball\.

**Example Usage**

```
snowball status
```

**Example Output**

```
Snowball Status: SUCCESS
S3 Endpoint running at: http://192.0.2.0:8080
Total Size: 72 TB
Free Space: 64 TB
```

## Stop Command for the Snowball Client<a name="snowball-stop-command"></a>

The `snowball stop` command stops communication from the current instance of the Snowball client to the Snowball\. 

You can use this command to make sure that all other commands are stopped between the data source server and the Snowball\. If you have multiple instances of the client connected to a single Snowball, you use this command for each instance when you’re ready to stop transferring data\. You can run this command to stop one instance of the client while still copying data with another instance\.

**Example Usage**

```
snowball stop
```

## Test Command for the Snowball Client<a name="snowball-test-command"></a>

The `snowball test` command tests your data transfer before it begins\. For more information, see [Testing Your Data Transfer with the Snowball Client](using-client.md#testing-client)\.

**Example Usage**

```
snowball test
```

## Validate Command for the Snowball Client<a name="snowball-validate-command"></a>

Unless you specify a path, the `snowball validate` command validates all the metadata and transfer statuses for the objects on the Snowball\. If you specify a path, then this command validates the content pointed to by that path and its subdirectories\. This command lists files that are currently in the process of being transferred as incomplete for their transfer status\.

Doing this for import jobs helps ensure that your content can be imported into AWS without issue\.

This command might take some time to complete, and might appear to be stuck from time to time\. This effect is common when there are lots of files, and even more so when files are nested within many subfolders\. We recommend that you run this command with the `verbose` option\.

**Example Usage**

```
snowball -v validate
```

## Version Command for the Snowball Client<a name="snowball-version-command"></a>

The `snowball version` command displays the Snowball client version on the terminal\.

**Example Usage**

```
snowball version
```

## Using the Verbose Option<a name="clientverbose"></a>

Whenever you execute a Snowball client command, you can use the `verbose` option for additional information\. This additional information is printed to the terminal while the command is running\. 

Using the `verbose` option helps you to better understand what each command is doing\. It also helps you troubleshoot issues you might encounter with the Snowball client\. 

The verbose option is off by default\. You can turn it on by specifying the option while running a command, as in the following examples\.

```
snowball -v cp /Logs/April/logs1.csv s3://MyBucket/Logs/April/logs1.csv
```

```
snowball --verbose ls s3://MyBucket/Logs/April/
```