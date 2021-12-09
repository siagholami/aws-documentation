# Updating a AWS CloudFormation Template in Eclipse<a name="tke-cfn-editor-update-stack"></a>

 **To update an CloudFormation template from Eclipse** 

1. With your AWS CloudFormation`.template` file open in the AWS CloudFormation template editor \(see [Adding and Accessing AWS CloudFormation Templates in Eclipse](tke-cfn-editor-adding-template.md) for more information\), right\-click on the open template and select **Run on AWS**, then **Update Stack** on the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-update-stack.png)

1. In the **Update CloudFormation Stack** dialog, select your stack name in the **Stack Name** field if it has not been automatically selected for you\. Your template file should also be automatically chosen in the **Template File** field\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-update-stack-dlg.png)

1. Choose any \(or none\) of the following options:

    **SNS Topic**– choose an existing SNS topic from the list to receive notifications about the stack’s progress, or create a new one by typing an email address in the box and clicking **Create New Topic**\.

    **Creation Timeout**– choose how long AWS CloudFormation should allow for the stack to be created before it is declared failed \(and rolled back, unless the **Rollback on failure** option is unchecked\.

    **Rollback on failure**– if you want the stack to rollback \(delete itself\) on failure, check this option\. Leave it unchecked if you would like the stack to remain active, for debugging purposes, even if it has failed to complete launching\.

1. Click **Next** to continue with entering parameter values\.

1. If your stack has parameters, you will enter values for them next\. For parameters with a predefined list of possible responses, you can choose a value from the list provided\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-update-stack-dlg-params.png)

1. Click **Finish** to begin updating your stack\.

While your stack is being updated, you can view its status by double\-clicking the stack name beneath the **CloudFormation** node in the **AWS Explorer** view, or by right\-clicking the stack name and selecting **Open in Stack Editor** on the context menu\.

![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-stack-events.png)