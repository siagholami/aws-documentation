# Identity and Access Management in AWS Service Catalog<a name="controlling_access"></a>

Access to AWS Service Catalog requires credentials\. Those credentials must have permission to access AWS resources, such as an AWS Service Catalog portfolio or product\. AWS Service Catalog integrates with AWS Identity and Access Management \(IAM\) to enable you to grant AWS Service Catalog administrators the permissions they need to create and manage products, and to grant AWS Service Catalog end users the permissions they need to launch products and manage provisioned products\. These policies are either created and managed by AWS or individually by administrators and end users\. To control access, you attach these policies to the IAM users, groups, and roles that you use with AWS Service Catalog\.

**Topics**
+ [Audience](#security-iam-audience)
+ [Controlling Access](#access-control)
+ [Predefined AWS Managed Policies](#permissions-managed-policies)
+ [Console Access for End Users](#permissions-end-users-console)
+ [Product Access for End Users](#permissions-end-users-product)
+ [Example Policies for Managing Provisioned Products](permissions-examples.md)

## Audience<a name="security-iam-audience"></a>

The permissions you have via AWS Identity and Access Management \(IAM\) may depend on the role you play in AWS Service Catalog\.

**Administrator** \- As an AWS Service Catalog administrator, you need full access to the administrator console and IAM permissions that allow you to perform tasks such as creating and managing portfolios and products, managing constraints, and granting access to end users\.

**End user** \- Before your end users can use your products, you need to grant them permissions that give them access to the AWS Service Catalog end user console\. They can also have permissions to launch products and manage provisioned products\.

**IAM administrator** \- If you're an IAM administrator, you might want to learn details about how you can write policies to manage access to AWS Service Catalog\. To view example AWS Service Catalog identity\-based policies that you can use in IAM, see [Predefined AWS Managed Policies](#permissions-managed-policies)\.

## Controlling Access<a name="access-control"></a>

 An AWS Service Catalog portfolio gives your administrators a level of access control for your groups of end users\. When you add users to a portfolio, they can browse and launch any of the products in the portfolio\. For more information, see [Managing Portfolios](catalogs_portfolios.md)\. 

### Constraints<a name="constraints-access-control"></a>

Constraints control which rules are applied to your end users when launching a product from a specific portfolio\. You use them to apply limits to products for governance or cost control\. For more information about constraints, see [Using AWS Service Catalog Constraints](constraints.md)\.

 AWS Service Catalog launch constraints give you more control over permissions needed by an end user\. When your administrator creates a launch constraint for a product in a portfolio, the launch constraint associates a role ARN that is used when your end users launch the product from that portfolio\. Using this pattern, you can control access to AWS resource creation\. For more information, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\.

## Predefined AWS Managed Policies<a name="permissions-managed-policies"></a>

The managed policies created by AWS grant the required permissions for common use cases\. You can attach these policies to your IAM users and roles\. For more information, see [AWS Managed Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_managed-vs-inline.html#aws-managed-policies) in the *IAM User Guide*\. 

The following are the AWS managed policies for AWS Service Catalog\.

**Administrators**  
+ **AWSServiceCatalogAdminFullAccess** — Grants full access to the administrator console view and permission to create and manage products and portfolios\.
+ **AWSServiceCatalogAdminReadOnlyAccess** — Grants full access to the administrator console view\. Does not grant access to create or manage products and portfolios\.

**End users**  
+ **AWSServiceCatalogEndUserFullAccess** — Grants full access to the end user console view\. Grants permission to launch products and manage provisioned products\.
+ **AWSServiceCatalogEndUserReadOnlyAccess** — Grants read\-only access to the end user console view\. Does not grant permission to launch products or manage provisioned products\.<a name="attach-managed-policy"></a>

**To attach a policy to an IAM user**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Users**\.

1. Choose the name \(not the check box\) of the IAM user\.

1. On the **Permissions** tab, choose **Add permissions**\.

1. On the **Add permissions** page, choose **Attach existing policies directly**\.

1. Select the check box next to the managed policy for AWS Service Catalog, and then choose **Next: Review**\.

1.  On the **Permissions summary** page, choose **Add permissions**\. 

1. \(Optional\) You must grant administrators additional permissions for Amazon S3 if they need to use a private CloudFormation template\. For more information, see [User Policy Examples](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-policies-s3.html) in the *Amazon Simple Storage Service Developer Guide*

### Deprecated Policies<a name="permissions-deprecated-policies"></a>

The following managed policies are deprecated:
+ **ServiceCatalogAdminFullAccess** — Use **AWSServiceCatalogAdminFullAccess** instead\.
+ **ServiceCatalogAdminReadOnlyAccess** — Use **AWSServiceCatalogAdminReadOnlyAccess** instead\. 
+ **ServiceCatalogEndUserFullAccess** — Use **AWSServiceCatalogEndUserFullAccess** instead\.
+ **ServiceCatalogEndUserAccess** — Use **AWSServiceCatalogEndUserReadOnlyAccess** instead\.

Use the following procedure to ensure that your administrators and end users are granted permissions using the current policies\.<a name="migrate-deprecated"></a>

**To migrate from the deprecated policies to the current policies**

1. Open the IAM console at [https://console\.aws\.amazon\.com/iam/](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Policies**\.

1. In the search field, type **ServiceCatalog** to filter the policy list\. Choose the name \(not the check box\) for **ServiceCatalogAdminFullAccess**\.

1. For each attached entity \(user, group, or role\), do the following:

   1. Open the summary page for the entity\.

   1. Add one of the current policies, as described in the procedure [To attach a policy to an IAM user](#attach-managed-policy)\.

   1. On the **Permissions** tab, next to **ServiceCatalogAdminFullAccess**, choose **Detach Policy**\. When prompted for confirmation, choose **Detach**\.

1. Repeat the process for **ServiceCatalogEndUserFullAccess**\.

## Console Access for End Users<a name="permissions-end-users-console"></a>

The ****AWSServiceCatalogEndUserFullAccess**** and ****AWSServiceCatalogEndUserReadOnlyAccess**** policies grant access to the AWS Service Catalog end user console view\. When a user who has either of these policies chooses AWS Service Catalog in the AWS Management Console, the end user console view displays the products they have permission to launch\.

Before end users can successfully launch a product from AWS Service Catalog to which you give access, you must provide them additional IAM permissions to allow them to use each of the underlying AWS resources in a product's AWS CloudFormation template\. For example, if a product template includes Amazon Relational Database Service \(Amazon RDS\), you must grant the users Amazon RDS permissions to launch the product\.

 To learn about how to enable end users to launch products while enforcing least\-access permissions to AWS resources, see [Using AWS Service Catalog Constraints](constraints.md)\. 

If you apply the **AWSServiceCatalogEndUserReadOnlyAccess** policy, your users have access to the end user console, but they won't have the permissions that they need to launch products and manage provisioned products\. You can grant these permissions directly to an end user using IAM, but if you want to limit the access that end users have to AWS resources, you should attach the policy to a launch role\. You then use AWS Service Catalog to apply the launch role to a launch constraint for the product\. For more information about applying a launch role, launch role limitations, and a sample launch role, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\.

**Note**  
If you grant users IAM permissions intended for AWS Service Catalog administrators, the administrator console view displays instead\. Don't grant end users these permissions unless you want them to have access to the administrator console view\.

## Product Access for End Users<a name="permissions-end-users-product"></a>

Before end users can use a product to which you give access, you must provide them additional IAM permissions to allow them to use each of the underlying AWS resources in a product's AWS CloudFormation template\. For example, if a product template includes Amazon Relational Database Service \(Amazon RDS\), you must grant the users Amazon RDS permissions to launch the product\. 

If you apply the **ServiceCatalogEndUserAccess** policy, your users have access to the end user console view, but they won't have the permissions that they need to launch products and manage provisioned products\. You can grant these permissions directly to an end user in IAM, but if you want to limit the access that end users have to AWS resources, you should attach the policy to a launch role\. You then use AWS Service Catalog to apply the launch role to a launch constraint for the product\. For more information about applying a launch role, launch role limitations, and a sample launch role, see [AWS Service Catalog Launch Constraints](constraints-launch.md)\.