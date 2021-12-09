# Step 3: Configure Security Group Inbound Rules Using the AWS Management Console<a name="DAX.create-cluster.console.configure-inbound-rules"></a>

Your Amazon DynamoDB Accelerator \(DAX\) cluster uses TCP port 8111 for communication, so you must authorize inbound traffic on that port\. This allows Amazon EC2 instances in your Amazon VPC to access your DAX cluster\.

**Note**  
If you launched your DAX cluster with a different security group \(other than `default`\), you must perform this procedure for that group instead\.

**To configure security group inbound rules**

1. Open the Amazon EC2 console at [https://console\.aws\.amazon\.com/ec2/](https://console.aws.amazon.com/ec2/)\.

1. In the navigation pane, choose **Security Groups**\.

1. Choose the **default** security group\. On the **Actions** menu, choose **Edit inbound rules**\.

1. Choose **Add Rule**, and enter the following information:
   + **Port Range**—Enter **8111**\.

     **Source**—Enter **default**, and then choose the identifier for your default security group\.

   When the settings are as you want them, choose **Save**\.