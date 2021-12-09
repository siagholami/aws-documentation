# Deploying a AWS CloudFormation Template in Eclipse<a name="tke-cfn-editor-create-stack"></a>

**Note**  
Only files that end in `.template` can be launched from the Eclipse IDE\. If your file ends with another extension, such as `.json`, you will need to rename it first with a `.template` extension to use this feature\.

 **To deploy an CloudFormation template from Eclipse** 

1. With your AWS CloudFormation`.template` file open in the AWS CloudFormation template editor \(see [Adding and Accessing AWS CloudFormation Templates in Eclipse](tke-cfn-editor-adding-template.md) for more information\), right\-click on the open template and select **Run on AWS**, then **Create Stack** on the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-create-stack.png)

1. In the **Create New CloudFormation Stack** dialog, enter your stack name in the **Stack Name** field\. Your template file should be automatically chosen in the **Template File** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-create-stack-dlg.png)

1. Choose any \(or none\) of the following options:

    **SNS Topic**– choose an existing SNS topic from the list to receive notifications about the stack’s progress, or create a new one by typing an email address in the box and clicking **Create New Topic**\.

    **Creation Timeout**– choose how long AWS CloudFormation should allow for the stack to be created before it is declared failed \(and rolled back, unless the **Rollback on failure** option is unchecked\.

    **Rollback on failure**– if you want the stack to rollback \(delete itself\) on failure, check this option\. Leave it unchecked if you would like the stack to remain active, for debugging purposes, even if it has failed to complete launching\.

1. Click **Next** to continue with entering parameter values\.

1. If your stack has parameters, you will enter values for them next\. For parameters with a predefined list of possible responses, you can choose a value from the list provided\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-create-stack-dlg-params.png)

1. Click **Finish** to begin launching your stack\.

While your stack is being launched, you can view its status by double\-clicking the stack name beneath the **CloudFormation** node in the **AWS Explorer** view, or by right\-clicking the stack name and selecting **Open in Stack Editor** on the context menu\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-stack-events.png)

**Note**  
If you cannot see the stack you launched in **AWS Explorer**, you may need to manually refresh the view by clicking the **Refresh AWS Explorer** icon at the top of the **AWS Explorer** view\.  

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-refresh-view.png)