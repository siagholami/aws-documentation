# Preloading Files into Your File System<a name="preload-file-contents-hsm"></a>

Amazon FSx copies data from your Amazon S3 data repository when a file is first accessed\. Because of this approach, the initial read or write to a file incurs a small amount of latency\. If your application is sensitive to this latency and you know which files or directories your application needs to access, you can optionally preload contents of individual files or directories\. You do so using the `hsm_restore` command, as follows\.

You can use the `hsm_action` command to verify that the file's contents have finished loading into the file system\. A return value of `NOOP` indicates that the file has successfully been loaded\. Run the following commands from a compute instance with the file system mounted\.

```
sudo lfs hsm_restore path/to/file
sudo lfs hsm_action path/to/file
```

You can preload your whole file system or an entire directory within your file system by using the following commands\. If you request the preloading of multiple files simultaneously, Amazon FSx loads your files from your Amazon S3 data repository in parallel\.

```
nohup find local/directory -type f -print0 | xargs -0 -n 1 sudo lfs hsm_restore &
```