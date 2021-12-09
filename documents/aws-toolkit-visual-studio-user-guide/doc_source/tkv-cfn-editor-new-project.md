# Creating an AWS CloudFormation Template Project in Visual Studio<a name="tkv-cfn-editor-new-project"></a>

 **To create a template project** 

1. In Visual Studio, choose **File**, choose **New**, and then choose **Project**\.

1. **For Visual Studio 2017**:

   In the **New Project** dialog box, expand **Installed** and select **AWS**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-04-CloudFormation-VS2017.png)

   **For Visual Studio 2019**:

   In the **New Project** dialog box, ensure that the **Language**, **Platform**, and **Project type** drop\-down boxes are set to "All \.\.\." and type **aws** in the **Search** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/CreateNewProject-04-CloudFormation-VS2019.png)

1. Select the **AWS CloudFormation Project** template\.

1. **For Visual Studio 2017**:

   Enter the desired **Name**, **Location**, etc\., for your template project, and then click **OK**\.

   **For Visual Studio 2019**:

   Click **Next**\. In the next dialog, enter the desired **Name**, **Location**, etc\., for your template project, and then click **Create**\.

1. On the **Select Project Source** page, choose the source of the template you will create:
   +  **Create with empty template** generates a new, empty AWS CloudFormation template\.
   +  **Create from existing AWS \|CFN\| stack** generates a template from an existing stack in your AWS account\. \(The stack doesn't need to have a status of `CREATE_COMPLETE`\.\)
   +  **Select sample template** generates a template from one of the AWS CloudFormation sample templates\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-new-template-empty-2.png)

1. To complete the creation of your AWS CloudFormation template project, choose **Finish**\.