# Releasing data from your file system<a name="release-files"></a>

If you want to create storage space on your file system, you can release files from your file system\. Releasing a file retains the file listing and metadata, but removes the local copy of that file's contents\. You can release individual files from your file system using the following commands:
+ To release one or more files from your file system if you are the file owner:

  ```
  lfs hsm_release file1 file2 ...
  ```
+ To release one or more files from your file system if you are not the file owner:

  ```
  sudo lfs hsm_release file1 file2 ...
  ```