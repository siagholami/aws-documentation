# Estimating the Cost of Your AWS CloudFormation Template Project in Visual Studio<a name="tkv-cfn-editor-estimate-cost"></a>

With the Toolkit for Visual Studio, you can easily estimate the cost of the AWS CloudFormation stack you are working on before you deploy it\. This way you'll have an idea of the monthly operating costs for the resources include in your template\.

 **To estimate the cost of your CFN stack** 

1. In Solution Explorer, open the context \(right\-click\) menu for the template and choose **Estimate Cost**\.

   Alternatively, to estimate the cost of the template you're currently editing, from the **Template** menu, choose **Estimate Cost**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-template-menu-estimate-cost.png)

1. Provide values for parameters you have defined for your stack, and choose **Finish**\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-cfn-estimate-cost-2.png)

1. The AWS Simple Monthly Calculator  will be displayed\. The values for the form data will be filled in with information pulled from the template you're editing\. You can adjust the values, if needed\.

   The **Estimate of Your Monthly Bill** tab will display an itemized view of the estimated monthly costs of running your stack\.  
![\[Image NOT FOUND\]](http://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/images/vs-editor-simple-monthly-calc.png)

**Note**  
Cost estimates are calculated using the values you provide and the current rates of AWS services, which can vary over time\. For more information, see the [How AWS Pricing Works](https://aws.amazon.com/whitepapers/how-aws-pricing-works/) whitepaper\.