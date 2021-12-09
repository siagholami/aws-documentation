# Providing Data Products on AWS Data Exchange<a name="providing-data-sets"></a>

Before you become a data product provider on AWS Data Exchange, review the following topics:
+ [How to Provide Data Products](how-it-works.md#high-level-provider)
+ [Setting Up AWS Data Exchange](setting-up.md)

After you review these topics, you're ready to get started\.

## Getting Started as a Provider<a name="provider-getting-started"></a>

These topics describe the end\-to\-end process of becoming a data product provider on AWS Data Exchange using the AWS Data Exchange console\. The process has the following steps:

**Topics**
+ [Confirm Your Eligibility](#provider-prereqs)
+ [Register to Be a Provider](#provider-registration)
+ [Confirm Eligibility of Your Data](#confirm-data-eligibility)
+ [Create a Data Set](#create-products)
+ [Publish a Product](#publish-products)
+ [Unpublish a Product](#unpublish-product)
+ [View Reports](#view-reports)
+ [Related Topics](#provider-related-topics)

### Confirm Your Eligibility<a name="provider-prereqs"></a>

Before you can register, you must meet the following requirements to confirm your eligibility\.

#### Seller requirements for publishing data products<a name="seller-requirements-for-publishing-free-products"></a>

 Whether you charge for your AWS Data Exchange data product or not you're selling that product on AWS Marketplace\. To create and offer data products you must: 
+ Have a defined customer support process and support organization\. 
+ Provide a means to keep data regularly updated and free of vulnerabilities\.
+ Follow best practices and guidelines when marketing your product\.
+ Be an AWS customer in good standing and meet the requirements in the terms and conditions for AWS Marketplace sellers and for AWS Data Exchange providers\.
+ You must be a permanent resident or citizen in an [eligible jurisdiction](#eligible-jurisdictions), or a business entity organized or incorporated in one of those areas\.
+  You must provide tax and bank account information\. For US\-based entities, a W\-9 form and a banking account from a US\-based bank are required\.
+ Non\-US sellers are required to provide a \(i\) W\-8 form, value\-added tax \(VAT\) or goods and services tax \(GST\) registration number, and \(ii\) US bank information\. If you don't have a US bank account, you can register for a virtual US bank account from [Hyperwallet](https://wssellers.hyperwallet.com/)\. 
+ To provide data products, you must also request on\-boarding through the [Create case](https://console.aws.amazon.com/support/cases?#/create?issueType=customer-service) wizard for AWS Support\. The AWS Data Exchange team will contact you to complete the qualification and registration process\.

##### Eligible jurisdictions for AWS Data Exchange products<a name="eligible-jurisdictions"></a>

To provide data products on AWS Data Exchange, you must be a permanent resident or citizen in one of the following countries, or a business entity organized or incorporated therein: 
+ Australia¹
+ Bahrain¹²
+ European Union \(EU\) member state¹
+ New Zealand¹
+ Norway¹²
+ Switzerland¹²
+ United Arab Emirates \(UAE\)¹²
+ United Kingdom \(UK\)¹
+ United States \(US\)

¹ Sellers of paid products in these countries must provide VAT information\. For more information, see [Tax Help \- AWS Marketplace Sellers](http://aws.amazon.com/tax-help/marketplace/)\.

² In these countries, sellers may need to provide an invoice to buyers\. For more informations, see [Tax Help \- AWS Marketplace Sellers](http://aws.amazon.com/tax-help/marketplace/)\. 

### Register to Be a Provider<a name="provider-registration"></a>

To use AWS Data Exchange as a provider, you must be a registered seller on AWS Marketplace and be qualified by the AWS Data Exchange team\. When you register an account as an AWS Marketplace seller, the account is the seller of record for your products and is used for reporting and disbursement\. All products and their public offers are discoverable on AWS Data Exchange and AWS Marketplace\.

**Important**  
You cannot change the AWS account you use to list a product on AWS Marketplace\. Only data sets owned by that account can be included in products published by that account\. Only AWS accounts that are registered to provide data products on AWS Marketplace and AWS Data Exchange can publish products\.

**To register as a provider for AWS Data Exchange and AWS Marketplace**

1. From your web browser, open the [AWS Marketplace Management Portal](http://aws.amazon.com/marketplace/management/tour/)\.

1. Choose **Sign Up as an AWS Marketplace Seller** to open the registration wizard\.

1. Confirm your company or full name, and review the Terms and Conditions\. If you agree to them, choose **I have read and agree to these terms**\.

1. On the **Account Settings** page, from the **Provide tax and banking information** tab, choose **Start** to complete the tax and banking wizard\. This submits your tax and banking information in the AWS Marketplace Management Portal\. 
**Note**  
We strongly recommend that you sign and submit the tax form electronically\. Otherwise, you must print, complete the signature section, and mail a hard copy of the tax form to the address provided in the tax information interview\. This delays the registration process\.

1. On the **Account Settings** page, choose **Add** to add a public profile\. Your registration for the AWS Marketplace is now complete\.
**Note**  
While your tax and banking registration is pending, you cannot submit a public profile\. 

1. In addition to being a registered AWS Marketplace seller, you must submit an AWS Data Exchange qualification request\. Access the [AWS Support Dashboard](https://console.aws.amazon.com/support/cases#/create?issueType=customer-service) and create a case in the AWS Management Console\. The AWS Data Exchange team will contact you to complete the qualification and registration process\.

### Confirm Eligibility of Your Data<a name="confirm-data-eligibility"></a>

You're limited to distributing data sets that meet the legal eligibility requirements set forth in the Terms and Conditions for AWS Marketplace Sellers\. If a provider breach these terms in any way, the prohibited product is removed from AWS Data Exchange and the provider might be suspended from the service\. For more information, see [Publishing Guidelines](publishing-guidelines.md)\.

If you have questions about the eligibility of your data set, access the [AWS Support Dashboard](https://console.aws.amazon.com/support/cases#/create?issueType=customer-service) and create a case in the AWS Management Console\. After you've reviewed the publishing guidelines for data products on AWS Data Exchange, and you've confirmed that your data set can be listed, you create your product\.

### Create a Data Set<a name="create-products"></a>

In the following procedure, you configure a data set, create a revision, add data assets, and prepare it for publishing in the AWS Data Exchange console\. Data sets are dynamic and are versioned using revisions, with each revision containing at least one asset\. For more information, see [Working with Data Sets](data-sets.md)\.

It's assumed you have already created files for your data sets and stored them as objects in Amazon S3 or on your local computer\. AWS Data Exchange supports all file types\.

**To create a data set**

1. Open your web browser and go to the [AWS Data Exchange console](https://console.aws.amazon.com/dataexchange)\.

1.  In the left side navigation pane, from **Publish data**, choose **Data sets**\.

1. In **Data sets**, choose **Create data set** to open the wizard\.

1. Enter a name and description for your data set, and then choose **Create**\. You can also add tags to your data sets\. For more information, see [Data Set Best Practices](data-sets.md#data-set-best-practices)\. 

1. Edit or deleted information about your data set, and then choose **Create revision**\.

1. Provide an optional comment for your revision that describes the purpose of the revision, and then choose **Create**\. You can also add tags for your revision\.

1. Again, you can review, edit, or delete your changes from the previous step\. After that, expand **Import assets**, and choose either **from Amazon S3** or **from your computer**, depending on where the data assets for the data set are currently stored\.

1. This starts a job to import your asset into your data set\. After the job is finished, the **State** field in the **Jobs** section is updated to **Completed\.**

1. If you have more data to add, choose **Import assets** to add assets to this revision\.

1. Review your revision and its assets\. If it's complete, choose **Finalize** to stage it for publishing\.

You have successfully finalized a revision for a data set\. It's now ready to be published as a part of a product\.

### Publish a Product<a name="publish-products"></a>

After you've created at least one data set and finalized a revision with assets, you're ready to publish that data set as a part of a product\. For more information, see [Publishing Products](publishing-products.md)\. Make sure that you have all required details about your product and offer\.

**To publish a product**

1. Open your web browser and go to the [AWS Data Exchange console](https://console.aws.amazon.com/dataexchange)\.

1. From the left navigation pane, expand **Publish data**, and choose **Products dashboard**\.

1. From **Products**, choose **Publish new product** to open the wizard\.

1. Enter information about your product, including name, logo, support contact, web address, categories, and descriptions\. For more information, see [Filling Out Product Details](publishing-products.md#fill-out-product-details)\.

1. Review your information, and then choose **Next**\.

1. Select the check box next to the data sets you want to add\.
**Note**  
The data sets you choose must have a finalized revision\. Data sets without finalized revisions won't be added\.

1. Choose **Add selected**, and then scroll to **Selected data sets**\.

1. Review your data sets, and then choose **Next**\.

1. Configure your public offer\. All AWS Data Exchange products require a public offer\. Choose your price and subscription durations, U\.S\. sales tax settings, data subscription agreement, and refund policy\. For more information, see [Creating an Offer for AWS Data Exchange Products](prepare-offers.md)\.

1. \(Optional\) Set **Subscription verification**, which enables you to control who can subscribe to this product\. For more information, see [Subscription Verification for Providers](subscription-verification-pro.md)\.

1. Review your product information before you publish\.

1. If you are sure you want sure to make the product and public offer visible and available to everyone, choose **Publish**\.

1. You've now completed the manual portion of publishing a data product with a public offer\. AWS Data Exchange prepares and publishes your product\. On the **Product overview** page, the status of your product is **Publishing**\.

### Unpublish a Product<a name="unpublish-product"></a>

After your product is published, it's available for all to find and subscribe to\. Use the following procedure if you created a product for this getting started exercise or if you'd like to clean up your resources\. You should also follow the steps in this procedure to remove a product from the publicly listed products on AWS Data Exchange\.

Keep the following in mind when you unpublish a product:
+ You can unpublish a product whenever you want\.
+ If you unpublish a product, it is no longer visible in the AWS Data Exchange catalog or on AWS Marketplace\.
+ Subscribers with an active subscription maintain access to the data product until the term of their subscription expires\.
+ Active subscriptions that expire after you have unpublished your product are not renewed, even if the subscriber has enabled auto\-renewal\.
+ Existing subscribers can still view the product details until their subscription expires\.

**To unpublish a product**

1. Open your web browser and go to the [AWS Data Exchange console](https://console.aws.amazon.com/dataexchange)\.

1. From the left navigation pane, expand **Publish data**, and then choose **Products dashboard**\.

1. From **Products**, choose the product you want to remove\. Make sure its status is **Published**\.

1. From **Product overview**, choose **Unpublish**, and then follow the instructions to unpublish the product\.
**Important**  
This action can't be undone\.

After you complete these steps, your product's status is **Unpublished**\. An unpublished product can't be published again, but you can create a new product \(with a new product ID\) that has the same data sets, product details, and offer details\.

### View Reports<a name="view-reports"></a>

AWS Data Exchange is integrated with AWS Marketplace, so you benefit from AWS Marketplace features, such as seller reports and the AWS Marketplace Commerce Analytics Service\. For more information, see [Provider Financials on AWS Marketplace](provider-financials.md)\.

### Related Topics<a name="provider-related-topics"></a>
+ [Publishing Guidelines](publishing-guidelines.md)
+ [Publishing Products](publishing-products.md)
+ [Creating an Offer for AWS Data Exchange Products](prepare-offers.md)
+ [Working with Data Sets](data-sets.md)