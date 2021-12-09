# Deploying a AWS CloudFormation Template in Visual Studio<a name="tkv-cfn-editor-deploy-template"></a>

 **To deploy an CFN template** 

1. In Solution Explorer, open the context \(right\-click\) menu for the template you want to deploy, and choose **Deploy to AWS CloudFormation**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-solution-explorer-deploy.png)

   Alternatively, to deploy the template you're currently editing, from the **Template** menu, choose **Deploy to AWS CloudFormation** \.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-template-menu-deploy.png)

1. On the **Deploy Template** page, choose the AWS account to use to launch the stack and the region where it will be launched\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-cfn-deploy.png)

1. Choose **Create New Stack** and type a name for your stack\.

1. Choose any \(or none\) of the following options:
   + To receive notifications about the stack's progress, from the **SNS Topic** drop\-down list, choose an SNS topic\. You can also create an SNS topic by choosing **Create New Topic** and typing an email address in the box\.
   + Use **Creation Timeout** to specify how long AWS CloudFormation should allow for the stack to be created before it is declared failed \(and rolled back, unless the **Rollback on failure** option is cleared\)\.
   + Use **Rollback on failure** if you want the stack to roll back \(that is, delete itself\) on failure\. Leave this option cleared if you would like the stack to remain active for debugging purposes, even if it has failed to complete the launch\.

1. Choose **Finish** to launch the stack\.