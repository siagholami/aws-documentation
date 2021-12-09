# How to Access AWS Explorer<a name="open-aws-explorer"></a>

To display AWS Explorer, click the AWS icon on the toolbar, and select **Show AWS Explorer View**\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-aws-explorer-menu.png)

**Note**  
If the AWS icon is not visible on the toolbar, click the **Window** menu, and then click **Open Perspective \| Other**\. Click **AWS Management** from the list of Eclipse perspectives\.

You can expand each node in AWS Explorer to view resources on AWS that are associated with your account\. For example, if you click the white triangle to the left of the **Amazon EC2** node, it will expand and display Amazon EC2 resources associated with your AWS account\. The AWS Toolkit for Eclipse uses the AWS account that you configured in the [Set up AWS Credentials](setup-credentials.md) to determine which resources to display\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-aws-explorer-expanded.png)

If you select any of the subnodes to Amazon EC2, Eclipse will open a view with detailed information about those resources\. For example, double\-clicking **Instances** opens a view that lists information about each of your Amazon EC2 instances such as its public DNS name, availability zone, and launch time\.