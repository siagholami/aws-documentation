# Step 2: Install and Configure the Lustre Client on Your Instance Before Mounting Your File System<a name="getting-started-step2"></a>

To mount your Amazon FSx for Lustre file system from your Amazon EC2 instance, first install the Lustre client\.

**To download the Lustre client onto your Amazon EC2 instance**

1. Open a terminal on your client\.

1. Determine which kernel is currently running on your compute instance by running the following command\.

   ```
   uname -r
   ```

1. Do one of the following:
   + If the command returns `4.14.104-95.84.amzn2.x86_64` for x86\-based EC2 instances, or `4.14.181-142.260.amzn2.aarch64` or higher for Graviton2\-based EC2 instances, download and install the Lustre client with the following command\.

     ```
     sudo amazon-linux-extras install -y lustre2.10
     ```
   +  If the command returns a result less than `4.14.104-95.84.amzn2.x86_64` for x86\-based EC2 instances, or less than `4.14.181-142.260.amzn2.aarch64` for Graviton2\-based EC2 instances, update the kernel and reboot your Amazon EC2 instance by running the following command\. 

     ```
     sudo yum -y update kernel && sudo reboot
     ```

     Confirm that the kernel has been updated using the uname \-r command\. Then download and install the Lustre client as described above\.

   For information about installing the Lustre client on other Linux distributions, see [Installing the Lustre Client](install-lustre-client.md)\.

**To mount your file system**

1. Make a directory for the mount point with the following command\.

   ```
   $ sudo mkdir -p /mnt/fsx
   ```

1. Mount the Amazon FSx for Lustre file system to the directory that you created\. Use the following command and replace the following items:
   + Replace `file_system_dns_name` with the actual file system's Domain Name System \(DNS\) name\.
   + Replace `mountname` with the file system's mount name, which you can get by running the describe\-file\-systems AWS CLI command or the [DescribeFileSystems](https://docs.aws.amazon.com/fsx/latest/APIReference/API_DescribeFileSystems.html) API operation\.

   ```
   sudo mount -t lustre -o noatime,flock file_system_dns_name@tcp:/mountname /mnt/fsx
   ```

    This command mounts your file system with two options, `-o noatime` and `flock`: 
   +  `noatime` – Turns off updates to inode access times\. To update inode access times, use the `mount` command without `noatime`\. 
   +  `flock` – Enables file locking for your file system\. If you don't want file locking enabled, use the `mount` command without `flock`\. 

1. Verify that the mount command was successful by listing the contents of the directory to which you mounted the file system `/mnt/fsx`, by using the following command\.

   ```
   $ ls /mnt/fsx
   import-path  lustre
   $
   ```

   You can also use the `df` command, following\.

   ```
   $ df
   Filesystem                      1K-blocks    Used  Available Use% Mounted on
   devtmpf                          1001808       0    1001808   0% /dev
   tmpfs                            1019760       0    1019760   0% /dev/shm
   tmpfs                            1019760     392    1019368   1% /run
   tmpfs                            1019760       0    1019760   0% /sys/fs/cgroup
   /dev/xvda1                       8376300 1263180    7113120  16% /
   123.456.789.0@tcp:/mountname  3547698816   13824 3547678848   1% /mnt/fsx
   tmpfs                             203956       0     203956   0% /run/user/1000
   ```

   The results show the Amazon FSx file system mounted on /mnt/fsx\.