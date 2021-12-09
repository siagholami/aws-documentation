# Creating Products<a name="productmgmt-cloudresource"></a>

 You create products from the **Products** page in the AWS Service Catalog administrator console\. 

**To create a new AWS Service Catalog product**

1. Navigate to the **Products** page\. 

1. Choose **Upload new product**\. 

1. For **Enter product details**, enter the following:
   + **Product name** – The name of the product\.
   + **Short description** – The short description\. This description appears in search results to help the user choose the correct product\.
   + **Description** – The full description\. This description is shown in the product listing to help the user choose the correct product\. 
   + **Provided by** – The name of your IT department or administrator\. 
   + **Vendor** \(optional\) – The name of the application's publisher\. This field allows users to sort their products list to makes it easier to find the products that they need\. 

   Choose **Next**\.

1. For **Enter support details**, enter the following:
   + **Email contact** \(optional\) – The email address for reporting issues with the product\. 
   + **Support link** \(optional\) – A URL to a site where users can find support information or file tickets\. The URL must begin with `http://` or `https://`\.
   + **Support description** \(optional\) – A description of how users should use the **Email contact** and **Support link**\.

   Choose **Next**\.

1. For **Version details**, enter the following:
   + **Select template** – An AWS CloudFormation template from a local drive or a URL that points to a template stored in Amazon S3\. If you specify an Amazon S3 URL, it must begin with `https://`\. The extension for the template file must be `.template`\.
   + **Version title** – the name of the product version \(e\.g\., "v1", "v2beta"\)\. No spaces are allowed\. 
   + **Description** \(optional\) – A description of the product version including how this version differs from the previous version\. 
   + **Guidance** – By default, product versions don't have any guidance, so end users can use that version to update and launch provisioned products\. If you set the guidance to deprecated, users can make updates to a provisioned product but can't launch new provisioned products of that version\.

1.  Choose **Next**\.

1. On the **Review** page, verify that the information is correct, and then choose **Confirm and upload**\. After a few seconds, the product appears on the **Products** page\. You might need to refresh your browser to see the product\.

 You can also use CodePipeline to create and configure a pipeline to deploy your product template to AWS Service Catalog and deliver changes you have made in your source repository\. For more information, see [Tutorial: Create a Pipeline That Deploys to AWS Service Catalog](https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-S3-servicecatalog.html)\. 