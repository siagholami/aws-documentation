# Using Amazon FSx with Your On\-Premises Data Repository<a name="fsx-on-premises"></a>

You can use Amazon FSx to process data stored in your on\-premises data repository with in\-cloud compute instances\. Amazon FSx supports access over AWS Direct Connect and VPN, enabling you to mount your file systems from on\-premises clients\.

**To use Amazon FSx with your on\-premises data**

1. Create a file system\. For more information, see [Step 1: Create Your Amazon FSx for Lustre File System](getting-started-step1.md) in the getting started exercise\.

1. Mount the file system from on\-premises clients\. For more information, see [Mounting Amazon FSx File Systems from On\-Premises or a Peered Amazon VPC](mounting-on-premises.md)\.

1. Copy the data that you want to process into your Amazon FSx file system\.

1. Run your compute\-intensive workload on in\-cloud Amazon EC2 instances mounting your file system\. If you want to, you can periodically copy intermediate results to your data repository\.

1. When you're finished, copy the final results from your file system back to your on\-premises data repository, and delete your Amazon FSx file system\.