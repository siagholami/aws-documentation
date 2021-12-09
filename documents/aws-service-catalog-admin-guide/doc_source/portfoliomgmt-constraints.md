# Adding Constraints<a name="portfoliomgmt-constraints"></a>

To control how users are able to use products, add constraints\. For more information about the types of constraints that AWS Service Catalog supports, see [Using AWS Service Catalog Constraints](constraints.md)\. 

 You add constraints to products after they have been placed in a portfolio\.

**To add a constraint to a product**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose **Portfolios** and select a portfolio\. 

1. In the portfolio details page, expand the **Constraints** section and choose **Add constraints**\. 

1. For **Product**, select the product to which to apply the constraint\.

1. For **Constraint type**, choose one of the following options:
   + **Launch** – The IAM role that AWS Service Catalog uses to launch and manage the product\. For more information, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\.
   + **Notification** – The Amazon SNS topic specified to receive notifications\. For more information, see [AWS Service Catalog Notification Constraints](constraints-notification.md)\.
   + **Template** – A JSON–formatted text file that contains one or more rules\. Rules are added to the AWS CloudFormation template used by the product\. For more information, see [Template Constraint Rules](reference-template_constraint_rules.md)\.
   + **Stack Set** – Uses AWS CloudFormation StackSets to specify multiple accounts and regions for the AWS Service Catalog product launch\. For more information, see [AWS Service Catalog Stack Set Constraints](constraints-stackset.md)\.
   + **Tag Update** – Allows you to update tags after the product has been provisioned\. For more information, see [AWS Service Catalog Tag Update Constraints](constraints-resourceupdate.md)\.

1.  Choose **Continue**\.

**To edit a constraint**

1. Sign in to the AWS Management Console and open the AWS Service Catalog administrator console at [https://console\.aws\.amazon\.com/catalog/](https://console.aws.amazon.com/catalog/)\.

1. Choose **Portfolios** and select a portfolio\. 

1. In the portfolio details page, expand the **Constraints** section and select the constraint to edit\.

1. Choose **Edit constraints**\.

1. Edit the constraint as needed, and choose **Submit**\.