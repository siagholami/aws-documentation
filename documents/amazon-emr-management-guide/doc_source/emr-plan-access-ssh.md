# Use an Amazon EC2 Key Pair for SSH Credentials<a name="emr-plan-access-ssh"></a>

Amazon EMR cluster nodes run on Amazon EC2 instances\. You can connect to cluster nodes in the same way that you can connect to Amazon EC2 instances\. You can use Amazon EC2 to create a key pair, or you can import a key pair\. When you create a cluster, you can specify the Amazon EC2 key pair that will be used for SSH connections to all cluster instances\. You can also create a cluster without a key pair\. This is usually done with transient clusters that start, run steps, and then terminate automatically\.

The SSH client that you use to connect to the cluster needs to use the private key file associated with this key pair\. This is a \.pem file for SSH clients using Linux, Unix and macOS\. You must set permissions so that only the key owner has permission to access the file\. This is a \.ppk file for SSH clients using Windows, and the \.ppk file is usually created from the \.pem file\.
+ For more information about creating an Amazon EC2 key pair, see [Amazon EC2 Key Pairs](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-key-pairs.html) in the *Amazon EC2 User Guide for Linux Instances*\.
+ For instructions about using PuTTYgen to create a \.ppk file from a \.pem file, see [Converting Your Private Key Using PuTTYgen](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/putty.html#putty-private-key) in the *Amazon EC2 User Guide for Linux Instances*\.
+ For more information about setting \.pem file permissions and how to connect to an EMR cluster's master node using different methods—including `ssh` from Linux or macOS, PuTTY from Windows, or the AWS CLI from any supported operating system, see [Connect to the Master Node Using SSH](emr-connect-master-node-ssh.md)\.