# Managing Budgets<a name="catalogs_budgets"></a>

You can use AWS Budgets to track your service costs and usage within AWS Service Catalog\. You can associate budgets with AWS Service Catalog products and portfolios\.

AWS Budgets gives you the ability to set custom budgets that alert you when your costs or usage exceed \(or are forecasted to exceed\) your budgeted amount\. Information about AWS Budgets is available at [https://aws.amazon.com/aws-cost-management/aws-budgets](https://aws.amazon.com/aws-cost-management/aws-budgets)\.

**Topics**
+ [Prerequisites](#budgets-setup)
+ [Creating a Budget](#budgets-create)
+ [Associating a Budget](#budgets-associate)
+ [Viewing a Budget](#budgets-view)
+ [Disassociating a Budget](#budgets-disassociate)

## Prerequisites<a name="budgets-setup"></a>

Before using AWS Budgets, you need to activate cost allocation tags in the AWS Billing and Cost Management console\. For more information, see [Activating User\-Defined Cost Allocation Tags](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/activating-tags.html) in the *AWS Billing and Cost Management User Guide*\. 

**Note**  
Tags take up to 24 hours to activate\.

You also need to enable user access to the AWS Billing and Cost Management console for any users or groups who will be using the Budgets feature\. You can do this by creating a new policy for your users\.

To allow IAM users to create budgets, you must also allow users to view billing information\. If you want to use Amazon SNS notifications, you can give users the ability to create Amazon SNS notifications, as shown in the policy example below\.

**To create the budgets policy**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**\. 

1. In the content pane, choose **Create policy**\. 

1. Choose the **JSON** tab and copy the text from the following JSON policy document\. Paste this text into the **JSON** text box\. 

   ```
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Sid": "Stmt1435216493000",
               "Effect": "Allow",
               "Action": [
                   "aws-portal:ViewBilling",
                   "aws-portal:ModifyBilling",
                   "budgets:ViewBudget",
                   "budgets:ModifyBudget"
               ],
               "Resource": [
                   "*"
               ]
           },
           {
               "Sid": "Stmt1435216552000",
               "Effect": "Allow",
               "Action": [
                   "sns:*"
               ],
               "Resource": [
                   "arn:aws:sns:us-east-1"
               ]
           }
       ]
   }
   ```

1. When you are finished, choose **Review policy**\. The Policy Validator reports any syntax errors\.

1. On the **Review** page, give your policy a name\. Review the policy **Summary** to see the permissions granted by your policy, and then choose **Create policy** to save your work\. 

   The new policy appears in the list of managed policies and is ready to attach to your users and groups\. For more information, see [Create and Attach Customer Managed Policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/tutorial_managed-policies.html#step2-attach-policy) in the *AWS Identity and Access Management User Guide*\.

## Creating a Budget<a name="budgets-create"></a>

In the AWS Service Catalog administrator console, the **Products** and **Portfolios** pages list information about existing products and portfolios and allow you to take actions on them\. To create a budget, first decide which product or portfolio you want to associate the budget to\.

**To create a budget**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose either **Products** or **Portfolios**\.

1. Select the product or portfolio you want to add a budget to\.

1. Open the **Actions** menu, then choose **Create budget**\.

1. On the **Budget creation** page, associate one tag type to your budget\.

   There are two types of tags: AutoTags and TagOptions\. AutoTags are tags that identify the portfolio, product, and user that launched a product, and are automatically applied by AWS Service Catalog to provisioned resources\. A TagOption is an administrator\-defined key\-value pair managed in AWS Service Catalog\.

   In order for spending that occurs on a portfolio or product to reflect on the associated budget, they must have the same tag\. Note that a tag key being used for the first time can take 24 hours to activate\. For more information, see [Prerequisites](#budgets-setup)\.

1. Choose **Continue**\.

1. You will be taken to the **Set up your budget** page\. Continue your budget setup by following the steps on [Creating a Budget](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/budgets-create.html)\.

After you create a budget, you need to associate it to the product or portfolio\.

## Associating a Budget<a name="budgets-associate"></a>

Each portfolio or product can have one budget associated to it, but each budget can be associated to multiple products and portfolios\.

When you associate a budget to a product or portfolio, you will be able to view information about the budget from that product or portfolio's detail page\. In order for spending that occurs on the product or portfolio to be reflected on the budget, you must associate the same tags on both the budget and the product or portfolio\.

**Note**  
If you delete a budget from within AWS Budgets, existing associations with AWS Service Catalog products and portfolios will still exist but AWS Service Catalog will be unable to display any information about the deleted budget\.

**To associate a budget**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose either **Products** or **Portfolios**\.

1. Select the product or portfolio you want to associate a budget to\.

1. Open the **Actions** menu, then choose **Associate budget**\.

1. On the **Budget association** page, select an existing budget\. Then choose **Continue**\.

1. The **Portfolios** or **Products** table will now include data for the budget you just added\.

## Viewing a Budget<a name="budgets-view"></a>

If a budget is associated to a product, you can view information about the budget on the **Products** and **Product details** page\. If a budget is associated to a portfolio, you can view information about the budget on the **Portfolios** and **Portfolio details** page\.

Both the **Portfolios** and **Products** pages display budget information for existing resources\. You can see columns displaying **Current vs\. budget** and **Forecast vs\. budget**\.

When you click on a product or portfolio, you are taken to a detail page\. These **Portfolio detail** and **Product detail** pages have a section with detailed information about the associated budget\. You can see the budgeted amount, current spend, and forecasted spend\. You also have the option to view budget details and edit the budget\.

## Disassociating a Budget<a name="budgets-disassociate"></a>

You can disassociate a budget from a portfolio or product\.

**Note**  
If you delete a budget from within AWS Budgets, existing associations with AWS Service Catalog products and portfolios will still exist but AWS Service Catalog will be unable to display any information about the deleted budget\.

**To disassociate a budget**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **Products** or **Portfolios**\.

1. Select the product or portfolio you want to disassociate a budget from\.

1. Open the **Actions** menu, then choose **Disassociate budget**\.

1. An alert will appear asking you to confirm that you want to disassociate the budget\. Choose **Confirm**\.