# Updating Products<a name="productmgmt-update"></a>

When you need to update a product's AWS CloudFormation template, you create a new version of your product\. A new product version is automatically available to all users who have access to a portfolio that contains the product\. 

Users who are currently running a provisioned product of the previous version of the product can update their provisioned product using the end user console view\. When a new version of a product is available, users can use the **Update provisioned product** command on either the **Provisioned product list** or **Provisioned product details** pages\. 

**Note**  
Before you create a new version of a product, test your product updates in AWS CloudFormation to ensure that they work\.

**To create a new product version**

1. Navigate to the **Products** page\. 

1. Choose the product name\.

1.  On the product details page, expand the **Versions** section, and then choose **Create new version**\. 

1. For **Version details**, enter the following:
   + **Select template** – An AWS CloudFormation template from a local drive or a URL that points to a template stored in Amazon S3\. If you specify an Amazon S3 URL, it must begin with `https://`\. The extension for the template file must be `.template` and can be either JSON– or YAML\-formatted text files\. For more information, see [Template Formats](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/template-formats.html) in the *AWS CloudFormation User Guide*\.
   + **Version title** – the name of the product version \(e\.g\., "v1", "v2beta"\)\. No spaces are allowed\. 
   + **Description** \(optional\) – A description of the product version including how this version differs from the previous version\.
   + **Guidance** – By default, product versions don't have any guidance, so end users can use that version to update and launch provisioned products\. If you set the guidance to deprecated, users can make updates to a provisioned product but can't launch new provisioned products of that version\.

   Choose **Save**\.

 You can also use CodePipeline to create and configure a pipeline to deploy your product template to AWS Service Catalog and deliver changes you have made in your source repository\. For more information, see [Tutorial: Create a Pipeline That Deploys to AWS Service Catalog](https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-S3-servicecatalog.html)\. 