# Validating a AWS CloudFormation Template in Eclipse<a name="tke-cfn-editor-validate-stack"></a>

 **To validate an CloudFormation template in Eclipse** 
+ Perform either one of the following actions:
  + Right\-click the template name in the **Package Explorer** view and click **Validate** on the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-validate-template-1.png)
  + Right\-click the template that you are editing in the editor pane and click **Validate** on the context menu\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/images/tke-cfn-editor-validate-template-2.png)

**Important**  
Your template will be validated for *JSON correctness* only; it will not be validated for *CloudFormation correctness*\. A stack template validated in this way can still fail to launch or update\.