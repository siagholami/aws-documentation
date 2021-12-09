# Setting Launch Permissions on an Amazon Machine Image<a name="tkv-set-ami-launch-perms"></a>

You can set launch permissions on your Amazon Machine Images \(AMIs\) from the **AMIs** view in AWS Explorer\. You can use the **Set AMI Permissions** dialog box to copy permissions from AMIs\.

 *To set permissions on an AMI* 

1. In the **AMIs** view in AWS Explorer, open the context \(right\-click\) menu on an AMI, and then choose **Edit Permission**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ami-edit-permissions-menu.png)

1. There are three options available in the **Set AMI Permissions** dialog box:
   + To give launch permission, choose **Add**, and type the account number for the AWS user to whom you are giving launch permission\.
   + To remove launch permission, choose the account number for the AWS user from whom you are removing launch permission, and choose **Remove**\.
   + To copy permissions from one AMI to another, choose an AMI from the list, and choose **Copy from**\. The users who have launch permissions on the AMI you chose will be given launch permissions on the current AMI\. You can repeat this process with other AMIs in the **Copy\-from** list to copy permissions from multiple AMIs into the target AMI\.

     The **Copy\-from** list contains only those AMIs owned by the account that was active when the **AMIs** view was displayed from AWS Explorer\. As a result, the **Copy\-from** list might not display any AMIs if no other AMIs are owned by the active account\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/tkv-ami-copy-permissions-dlg.png)

    **Copy AMI permissions** dialog box