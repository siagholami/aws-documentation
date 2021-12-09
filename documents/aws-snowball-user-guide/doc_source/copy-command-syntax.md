--------

This guide is for the Snowball \(50 TB or 80 TB of storage space\)\. If you are looking for documentation for the Snowball Edge, see the [AWS Snowball Edge Developer Guide](https://docs.aws.amazon.com/snowball/latest/developer-guide/whatisedge.html)\.

--------

# Syntax for the snowball cp Command<a name="copy-command-syntax"></a>

Copying data with the Snowball client's `snowball cp` command uses a syntax that is similar to Linux `cp` command syntax\. However, there are some notable differences\. In the following topics, you can find a reference for the syntax used by the `snowball cp` command\. Failure to follow this syntax can lead to unexpected results when copying data to or from a Snowball\.

When copying data, define a source path and a destination path, as in the following example\.

```
snowball cp [source path] [destination path]
```

When copying a directory, if you also want to copy the contents of the source directory, you use the `-r` option to recursively copy the contents\.

**Syntax for Copying a File**
+ **Copying a file to a nonexistent destination with no trailing slash** – Copies the source file to a new file at the destination\.

  ```
  snowball cp /tmp/file1 s3://bucket-name/dir1/file2
  ```

  In the preceding example, the source file file1 is copied to the Snowball with the new file name of file2\.
+ **Copying a file to a nonexistent destination with a trailing slash** – Creates a new directory at the destination, and copies the file into that new directory\.

  ```
  snowball cp /tmp/file3 s3://bucket-name/dir2/
  ```

  In the preceding example, the dir2 directory does not exist until this command is executed\. Because `dir2/` has a trailing slash in this example, dir2 is created as a directory, and the path to file3 on the Snowball is s3://bucket\-name/dir2/file3\.
+ **Copying a file to an existing destination file** – Fails unless you specify the `-f` option to overwrite the existing destination file\.

  ```
  snowball cp -f /tmp/file4 s3://bucket-name/dir3/file5
  ```

  In the preceding example, the destination file file5 already exists before the command was executed\. By executing this command with the `-f` option, file5 is overwritten by the contents of file4, with a destination path of s3://bucket\-name/dir3/file5\.
+ **Copying a file to an existing destination directory** – Copies the file into the existing destination directory\.

  ```
  snowball cp /tmp/file6 s3://bucket-name/dir4/
  ```

  The preceding example copies file6 into s3://bucket\-name/dir4/\.
**Note**  
If file6 already exists in s3://bucket\-name/dir4/ when this command is executed, the command fails\. You can force the destination file6 to be overwritten by the source file6 by using the `snowball cp` command with the `-f` option\.
+ **Copying a file to a bucket on Snowball with or without a trailing slash** – Copies the file into the root level directory on the Snowball that shares the name of an Amazon S3 bucket\.

  ```
  snowball cp /tmp/file7 s3://bucket-name
  ```

  The preceding example copies file7 into s3://bucket\-name/file7\.
**Note**  
If file7 already exists in s3://bucket\-name when this command is executed, the command fails\. You can force the destination file7 to be overwritten by the source file7 by using the `snowball cp` command with the `-f` option\.

**Syntax for Copying a Directory**
+ **Copying a directory to a new destination with or without a trailing slash** – Specify the source path and the destination path\.

  ```
  snowball cp -r /tmp/dir1 s3://bucket-name/dir2/
  ```

  ```
  snowball cp -r /tmp/dir1 s3://bucket-name/dir2
  ```

  The preceding examples both do the same thing\. They both create the new directory dir2 and recursively copy the contents of dir1 to it\.
+ **Copying a directory to a destination directory that already exists** – Only the unique contents from the source directory make it into the destination directory, unless the `snowball cp` command is used with the `-f` option to force the entire destination directory to be overwritten\.

  ```
  snowball cp -r /tmp/dir3 s3://bucket-name/dir4/
  ```

  In the preceding example, only the unique contents from the source directory make it into the destination directory, dir4\.

  ```
  snowball cp -r -f /tmp/dir3 s3://bucket-name/dir4/
  ```

  In the preceding example, the destination directory dir4 is overwritten with the contents in the source dir3 directory\.
+ **Copying a directory to a destination file that already exists** – This operation fails, unless you use the `snowball cp` command with the `-f` option\. In this case, the operation succeeds, because the destination file is overwritten with a copy of the source directory of the same name\.

  ```
  snowball cp -r -f /tmp/dir5 s3://bucket-name/dir6
  ```

  In the preceding example, dir6 on the Snowball is actually a file\. Usually this command fails in this case, because the source dir5 is a directory\. However, because the `-f` is used, the file dir6 is forcibly overwritten as a directory with the contents from the source dir5\.
+ **Copying a directory to a bucket on a Snowball** – Specify the bucket name in the destination path\.

  ```
  snowball cp -r /tmp/dir7 s3://bucket-name/
  ```
**Note**  
If dir7 already exists in s3://bucket\-name when this command is executed, the command copies over the unique content from the source directory into the destination directory\. You can force the destination dir7 to be overwritten by the source dir7 by using the `snowball cp` command with the `-f` option\.