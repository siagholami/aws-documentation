# Create an AMI from an Amazon EC2 Instance<a name="tkv-create-ami-from-instance"></a>

From the **Amazon EC2 Instances** view, you can create Amazon Machine Images \(AMIs\) from either running or stopped instances\.

 *To create an AMI from an instance* 

1. Right\-click the instance you want to use as the basis for your AMI, and choose **Create Image** from the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-create-ami-menu2.png)

    **Create Image** context menu

1. In the **Create Image** dialog box, type a unique name and description, and then choose **Create Image**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-create-ami-dlg2.png)

    **Create Image** dialog box

It may take a few minutes for the AMI to be created\. After it is created, it will appear in the **AMIs** view in AWS Explorer\. To display this view, double\-click the **Amazon EC2 \| AMIs** node in AWS Explorer\. To see your AMIs, from the **Viewing** drop\-down list, choose **Owned By Me**\. You may need to choose **Refresh** to see your AMI\. When the AMI first appears, it may be in a pending state, but after a few moments, it transitions to an available state\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ec2-created-amis-list2.png)

List of created AMIs