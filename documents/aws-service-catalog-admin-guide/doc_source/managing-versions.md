# Managing Versions<a name="managing-versions"></a>

 You assign product versions when you create a product, and you can update product versions any time\. 

 Versions have an AWS CloudFormation template, a title, a description, a status, and guidance\. 

## Version Status<a name="version-status"></a>

 A version can have one of three statuses: 
+  **Active** \- An active version appears in the version list and allows users to launch it\. 
+  **Inactive** \- An inactive version is hidden from the version list\. Existing provisioned products launched from this version will not be affected\. 
+  **Deleted** \- If a version is deleted, it is removed from the version list\. Deleting a version can't be undone\. 

## Version Guidance<a name="version-guidance"></a>

 You can set version guidance to provide information to end users about the product version\. Version guidance only affects active product versions\. 

 There are two options for version guidance: 
+  **None** \- By default, product versions don't have any guidance, so end users can use that version to update and launch provisioned products\. 
+  **Deprecated** \- With a deprecated version, users can make updates to a provisioned product but can't launch new provisioned products using the deprecated version\. 

## Updating Versions<a name="updating-versions"></a>

 You assign product versions when creating a product, and you can also update a version any time\. For more information about creating a product, see [Creating Products](productmgmt-cloudresource.md)\. 

**To update a product version**

1.  In the AWS Service Catalog console, choose **Products**\. 

1.  From the product list, choose the product you want to update the version of\. 

1.  On the **Product details** page, choose the **Versions** tab, then choose the version you want to update\. 

1.  On the **Version details** page, edit the product version, then choose **Save changes**\. 