# AWS Service Catalog Stack Set Constraints<a name="constraints-stackset"></a>

**Note**  
 This feature is currently in beta mode\. AutoTags are not currently supported with AWS CloudFormation StackSets\. 

A stack set constraint allows you to configure product deployment options using AWS CloudFormation StackSets\. You can specify multiple accounts and regions for the product launch\.

**To apply a stack set constraint to a product**

1. Open the AWS Service Catalog console at [https://console\.aws\.amazon\.com/servicecatalog/](https://console.aws.amazon.com/servicecatalog/)\.

1. Choose the portfolio that contains the product\.

1. Expand **Constraints** and choose **Add constraints**\.

1. Choose the product from **Product** and set **Constraint type** to **Stack Set**\. Choose **Continue**\.

1. On the **Stack Set constraint page**, enter a description\.

1. Choose the account\(s\) in which you want to create products\.

1. Choose the region\(s\) in which you want to deploy products\. Products are deployed in these regions in the order that you specify\.

1. Choose an IAM StackSet Administrator Role that will be used to manage your target accounts\. If you don't choose a role, StackSets will use the default ARN\. [Learn more about setting up stack set permissions\.](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/stacksets-prereqs.html)

1. Choose **Submit**\.