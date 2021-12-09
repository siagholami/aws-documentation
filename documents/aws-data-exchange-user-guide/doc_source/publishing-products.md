# Publishing Products<a name="publishing-products"></a>

A product is the unit of exchange in AWS Data Exchange that is published by a provider and made available for use to subscribers\. When you publish a product, that product is available on the AWS Data Exchange product catalog as well as the AWS Marketplace\. Each product you publish is uniquely identified by its product ID\.

**Note**  
When a product is initially created and published, all pre\-existing finalized revisions within its data sets are published at the same time\.

You can publish and view your products using the AWS Data Exchange console\. You can also list and view the details of your existing products using the AWS Marketplace Catalog API\. A product has the following parts:
+ **Product details** – This information helps potential subscribers understand what the product is\. This includes a name, descriptions \(both short and long\), a logo image, and contact information\. For more information, see [Filling Out Product Details](#fill-out-product-details)\.
+ **Product offers** – In order to make a product available on AWS Data Exchange, you must define a public offer\. This includes the price, data subscription agreement, refund policy, and more\. Offers define the terms that subscribers are agreeing to when they subscribe to a product\. Each product must have a public offer available to all subscribers\. Providers can also create custom offers to specific subscribers\. For more information, see [Creating an Offer for AWS Data Exchange Products](prepare-offers.md)\.
+ **Data sets** – A product can contain one or more data sets\. A data set is a dynamic set of ﬁle\-based data content\. As a provider, you create owned data sets, and a subscriber can get access to entitled data sets through a product subscription\. Data sets are dynamic and are versioned using revisions\. You can decide which revisions within a data set are published to a product\. For more information, see [Updating Products](updating-products.md)\.

**Note**  
When a subscriber subscribes to your product, they get access to the product’s data sets and all the revisions that have been published to that product for the duration of their subscription\. Subscribers can also access revisions that have been published before their subscription became active\.

## Sensitive Information<a name="sensitive-information"></a>

Sensitive information is biometric or genetic data; health data; racial or ethnic origin; political opinions; religious or philosophical beliefs; sex or sexual orientation; trade union membership; personal payment or financial information \(for example, credit history\); or other similar categories of information\.

If your product contains sensitive information, you must acknowledge that it cannot be used to identify a person\. You make this acknowledgement on **Step 2: Add data** of the product creation wizard\. If the product doesn't contain sensitive information, choose **No**\. If the selection is **Yes**, then you must ensure that the sensitive data in your product is properly anonymized, de\-identified, or aggregated such that the information is no longer identifying for any individuals\.

Additionally, choosing **Yes** will result in the display of a message on this product's page on AWS Data Exchange\. The message informs potential customers that the product contains sensitive information that has been appropriately anonymized, de\-identified, or aggregated\.

**Warning**  
Listing a product with sensitive information that has not been anonymized, de\-identified, or aggregated, or incorrectly acknowledging the state of sensitive data in your product, is a violation of our [Publishing Guidelines](publishing-guidelines.md)\. AWS removes any product that breaches these guidelines and can suspend the provider from future use of the service\.

## Filling Out Product Details<a name="fill-out-product-details"></a>

When you publish a product on the AWS Data Exchange console, you must provide the product's details\. This section covers some best practices to consider when you're preparing product details\.

### Product Name<a name="best-practices-name"></a>

Subscribers will search for the names of products, so make your product name something meaningful\.

### Short Description<a name="best-practices-short-description"></a>

The product short description text appears on the tiles in the product catalog portion of the AWS Data Exchange console\. We recommend that you provide a concise description of your product for this ﬁeld\.

### Long Description<a name="best-practices-long-description"></a>

Subscribers see the product long description in the product detail page after the product is published\. We recommend that you list the product's features, beneﬁts, usage, and other information speciﬁc to the product\.

Product information in the description must accurately represent the data being provided to subscribers\. This includes data coverage \(for example, 30,000 financial instruments or 10,000 location coordinates\) and data set update frequency \(for example, daily updates or weekly updates\)\.

#### Provide Additional Information<a name="best-practices-additional-info"></a>

In order to make your product description compelling to prospective subscribers, we recommend you add the following information to your product description:
+  *Data due diligence questionnaire \(DDQ\)*: Typically includes responses to questions regarding the firm selling a data set\. Examples of the information in a DDQ includes the process that a provider goes through to collect the data, or quality control procedures and questions regarding regulatory compliance\.
+  *Data set schemas*: Provide prospective users with detailed descriptions of the structure and format of your data sets\. Examples of the information in a data set schema include the identification of a primary key, field names, field definitions, expected output types for each field \(for example, string, integer\), and acceptable enumerations for each field \(for example, 0% \- 100%\)\.
+ *Trial Product Listings*: Many prospective subscribers request trials of data sets before paying for a subscription\. Trial products can be published on AWS Data Exchange for subscribers to subscribe to like regular paid products\.
+  *Sample files*: Sample files are typically smaller versions, or older, out\-of\-date versions of full production data sets\. These sample files give prospective users insights into the outputs they can expect before purchasing a subscription\.
+  *Product fact sheets*: These can be documents, web links, or both to provide subscribers with more granular statistics on the coverage of your data sets, typical use\-cases for your data sets, and any other factors that differentiate your data sets\.

For information about adding links in the description, see [Include Links in Your Product Description](#best-practices-links-in-listing)\.

### Product Logo<a name="best-practices-product-logo"></a>

The product logo appears in the AWS Data Exchange product catalog on the console and on AWS Marketplace\. The supported formats for the logo are \.png, \.jpg, and \.jpeg\.

### Support Contact<a name="best-practices-support-info"></a>

As a provider, you must include valid contact information\. This can be a managed email alias or case management system link for customers to use to get help when they have questions about your product\. We strongly recommend that you don't use a personal email address because the address is publicly visible\.

### Product Categories<a name="best-practices-categories"></a>

All products fit into one or more categories\. By specifying up to two categories for your product, you help subscribers filter and find your products in AWS Data Exchange and AWS Marketplace\.

## Include Links in Your Product Description<a name="best-practices-links-in-listing"></a>

The long description for a AWS Data Exchange product supports Markdown, which allows you to include links in your product's details page\. The following procedure shows you how to add links to websites in your AWS Data Exchange product description\. Complete the following steps\.

**To include embedded links in your product listing**

1. Log into the AWS console and navigate to a [Amazon S3 bucket](https://console.aws.amazon.com/s3) that your AWS Data Exchange user account has access to\. The contents of this bucket are publicly readable\.

1. Upload the files \(for example, documents such as PDF files or Microsoft Excel files\) that you want to include in your product listing into the Amazon S3 bucket\. After the upload is complete, make sure you set the file or files to have public read access permissions\.

1.  Choose one of the uploaded files\. In the **Overview** tab, you will see a URL for the file\. Copy the URL to your clipboard\.

1. Open the AWS Data Exchange console at [AWS Data Exchange console](https://console.aws.amazon.com/dataexchange)\.

1. Choose the product you want to update, and then choose **Edit**\.

1. From **Product Description**, use the following Markdown formats to link to relevant files \(using the URL link you copied previously\) or to another URL, like your website\.
   +  To link to a file stored in an Amazon S3 bucket: 

      \*\*\_\[*File name*\]\(*Object URL from Amazon S3*\)\_\*\* 

      *Description of the object*\. 
   +  To link to a trial product listing on AWS Data Exchange: 

      \*\*\_\[*Website Title\]*\(*URL*\)\_\*\* 

      *Description of the website*\. 

1. Choose **Save Changes**\. After a few minutes your AWS Data Exchange product listing page should be updated with the new links\.