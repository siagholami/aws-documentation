# Importing files from your S3 bucket<a name="importing-files"></a>

 When you create a new ﬁle system linked to a data repository, Amazon FSx automatically imports the ﬁle metadata \(name, ownership, timestamp, and permissions\) of the objects in your repository, such as an Amazon S3 bucket\. Amazon FSx makes them visible as new ﬁles and directories in the Amazon FSx for Lustre ﬁle system\. If the object does not include metadata, then Amazon FSx uses the default permissions of root root 755\.

You can also configure your file system to automatically import file metadata for new or changed objects from your S3 bucket after creation\. For more information, see [Automatically import updates from your S3 bucket](autoimport-data-repo.md)\.

Amazon FSx transparently copies the content of a file from your repository and loads it into the ﬁle system when your application first accesses the file in FSx\. You can also preload your whole ﬁle system or an entire directory within your ﬁle system, for more information, see [Preloading Files into Your File System](preload-file-contents-hsm.md)\. If you request the preloading of multiple ﬁles simultaneously, Amazon FSx loads your ﬁles from your Amazon S3 data repository in parallel\.

If you have a large number of files to import, this will impact the amount of time it takes for Amazon FSx to create your file system\.

 Amazon FSx *only* imports S3 objects that have POSIX\-compliant object keys, such as these:

```
test/mydir/ 
test/
```

Amazon FSx does *not* import S3 object keys that are not POSIX\-compliant, such as these:

```
.
.. 
test/. 
test/..
```

Amazon FSx automatically copies file data for a given file from the linked durable data repository into your file system the first time you open that file\. This data movement is managed by Amazon FSx and occurs transparently to your applications\. Subsequent reads of these files are served directly out of the Amazon FSx file system with consistent sub millisecond latencies\.