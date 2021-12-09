# Mounting from an Amazon EC2 Instance<a name="mounting-ec2-instance"></a>

You can mount your file system from an Amazon EC2 instance\.

**To mount your file system from Amazon EC2**

1. Connect to your Amazon EC2 instance\.

1. Make a directory on your Amazon FSx for Lustre file system for the mount point with the following command\.

   ```
   $ sudo mkdir -p /fsx
   ```

1. Mount the Amazon FSx for Lustre file system to the directory that you created\. Use the following command and replace the following items:
   + Replace `file_system_dns_name` with the actual file system's DNS name\.
   + Replace `mountname` with the file system's mount name\. This mount name is returned in the `CreateFileSystem` API operation response\. It's also returned in the response of the describe\-file\-systems AWS CLI command, the describe\-file\-systems CLI command, and the [DescribeFileSystems](https://docs.aws.amazon.com/APIReference/API_DescribeFileSystems.html) API operation\.

   ```
   sudo mount -t lustre -o noatime,flock file_system_dns_name@tcp:/mountname /fsx
   ```

    This command mounts your file system with two options, `-o noatime` and `flock`: 
   +  `noatime` – Turns off updates to inode access times\. To update inode access times, use the `mount` command without `noatime`\. 
   +  `flock` – Enables file locking for your file system\. If you don't want file locking enabled, use the `mount` command without `flock`\. 

1. Verify that the mount command was successful by listing the contents of the directory to which you mounted the file system, /mnt/fsx by using the following command\.

   ```
   $ ls /fsx
   import-path  lustre
   $
   ```

   You can also use the `df` command, following\.

   ```
   $ df
   Filesystem                    1K-blocks    Used  Available Use% Mounted on
   devtmpfs                        1001808       0    1001808   0% /dev
   tmpfs                           1019760       0    1019760   0% /dev/shm
   tmpfs                           1019760     392    1019368   1% /run
   tmpfs                           1019760       0    1019760   0% /sys/fs/cgroup
   /dev/xvda1                      8376300 1263180    7113120  16% /
   123.456.789.0@tcp:/mountname 3547698816   13824 3547678848   1% /fsx
   tmpfs                            203956       0     203956   0% /run/user/1000
   ```

   The results show the Amazon FSx file system mounted on /fsx\.