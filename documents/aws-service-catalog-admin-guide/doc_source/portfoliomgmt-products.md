# Adding Products<a name="portfoliomgmt-products"></a>

To add products to a portfolio, you either create a new product or add an existing product from your catalog to the portfolio\.

**Note**  
The AWS CloudFormation template that you upload when you create an AWS Service Catalog product is stored in an Amazon Simple Storage Service \(Amazon S3\) bucket that starts with `cf-templates-` in your AWS account\. Do not delete these files unless you are sure that they are no longer in use\.

## Adding a New Product<a name="portfoliomgmt-products-new"></a>

You add new products directly from the portfolio details page\. When you create a product from this page, AWS Service Catalog adds it to the currently selected portfolio\. You can also add a product to other portfolios\. 

**To add a new product**

1.  Navigate to the **Portfolios** page, and then choose the name of the portfolio to which you want to add the product\.

1. On the portfolio details page, expand the **Products** section, and then choose **Upload new product**\. 

1. For **Enter product details**, enter the following:
   + **Product name** – The name of the product\.
   + **Short description** – The short description\. This description appears in search results to help the user choose the correct product\.
   + **Description** – The full description\. This description is shown in the product listing to help the user choose the correct product\.
   + **Provided by** – The name or email address of your IT department or administrator\.
   + **Vendor** \(optional\) – The name of the application's publisher\. This field allows users to sort their products list to makes it easier to find the products that they need\.

   Choose **Next**\.

1. For **Enter support details**, enter the following:
   + **Email contact** \(optional\) – The email address for reporting issues with the product\.
   + **Support link** \(optional\) – A URL to a site where users can find support information or file tickets\. The URL must begin with `http://` or `https://`\.
   + **Support description** \(optional\) – A description of how users should use the **Email contact** and **Support link**\.

   Choose **Next**\.

1. On the **Version details** page, enter the following:
   + **Select template** – An AWS CloudFormation template from a local drive or a URL that points to a template stored in Amazon S3\. If you specify an Amazon S3 URL, it must begin with `https://`\. The extension for the template file must be `.template`\.
   + **Version title** – the name of the product version \(e\.g\., "v1", "v2beta"\)\. No spaces are allowed\. 
   + **Description** \(optional\) – A description of the product version including how this version differs from the previous version\.

   Choose **Next**\.

1. On the **Review** page, verify that the information is correct, and then choose **Confirm and upload**\. After a few seconds, the product appears in your portfolio\. You might need to refresh your browser to see the product\.

## Adding an Existing Product<a name="portfoliomgmt-products-existing"></a>

You can add existing products to a portfolio from three places: the **Portfolios** list, the portfolio details page, or the **Products** page\.

**To add an existing product to a portfolio**

1. Navigate to the **Portfolios** page\. 

1. Choose a portfolio, and then choose **Add product**\. 

1.  Choose a product, and then choose **Add product to portfolio**\. 

## Removing a Product from a Portfolio<a name="portfoliomgmt-products-remove"></a>

When you no longer want users to use a product, remove it from a portfolio\. The product is still available in your catalog from the **Products** page, and you can still add it to other portfolios\. You can remove multiple products from a portfolio at one time\.

**To remove a product from a portfolio**

1. Navigate to the **Portfolios** page, and then choose the portfolio that contains the product\. The portfolio details page opens\. 

1. Expand the **Products** section\. 

1. Choose one or more products, and then choose **Remove product**\. 

1. Choose **Continue**\. 