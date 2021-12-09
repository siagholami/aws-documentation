# What Is AWS Data Exchange?<a name="what-is"></a>

AWS Data Exchange is a service that makes it easy for AWS customers to securely exchange file\-based data sets in the AWS Cloud\.

As a subscriber, you can find and subscribe to hundreds of products from qualified data providers\. Then, you can quickly download the data set or copy it to Amazon S3 for use across a variety of AWS analytics and machine learning services\. Anyone with an AWS account can be a AWS Data Exchange subscriber\. For information about becoming a subscriber, see [Subscribing to Data Products on AWS Data Exchange](subscribe-to-data-sets.md)\.

For providers, AWS Data Exchange eliminates the need to build and maintain any data delivery, entitlement, or billing technology\. Providers in AWS Data Exchange have a secure, transparent, and reliable channel to reach AWS customers and grant existing customers their subscriptions more efficiently\. The process for becoming an AWS Data Exchange provider requires a few steps to determine eligibility\. For more information, see [Register to Be a Provider](providing-data-sets.md#provider-registration)\.

## What Is An AWS Data Exchange Product?<a name="data-exchange-products"></a>

A product is the unit of exchange in AWS Data Exchange that is published by a provider and made available for use to subscribers\. When a provider publishes a product, that product is listed on AWS Data Exchange and AWS Marketplace\. A product has the following parts:
+ **Product details** – This information includes name, descriptions \(both short and long\), logo image, and support contact information\. Providers complete the product details\. For more information as a subscriber, see [Product Subscriptions](product-subscriptions.md)\. For more information as a provider, see [Filling Out Product Details](publishing-products.md#fill-out-product-details)\.
+ **Product offers** – To make a product available on AWS Data Exchange, providers must define a public offer\. This offer includes prices and durations, data subscription agreement, refund policy, and the option to create custom offers\. For more information, see [Creating an Offer for AWS Data Exchange Products](prepare-offers.md)\.
+ **Data sets** – A product can contain one or more data sets\. A data set is a dynamic set of file\-based content\. Data sets are dynamic and are versioned through the use of revisions\. Each revision can contain multiple assets\. For more information, see [Working with Data Sets](data-sets.md)\.

## Malware Prevention<a name="ensuring-safe-data"></a>

Security and compliance is a shared responsibility between you and AWS\. To promote a safe, secure, and trustworthy service for everyone, AWS Data Exchange scans all data published by providers before it is made available to subscribers\. If AWS detects malware, the affected asset is removed\.

**Important**  
AWS Data Exchange does not guarantee that the data you consume as a subscriber is free of any potential malware\. We encourage that you conduct your own additional due\-diligence to ensure compliance with your internal security controls\. You can find anti\-malware and security products in AWS Marketplace\.

## Supported Data Sets<a name="supported-data-sets"></a>

AWS Data Exchange takes a responsible approach to facilitating data transactions by promoting transparency through use of the service\. AWS Data Exchange reviews permitted data types, restricting products that are not permitted\. Providers are limited to distributing data sets that meet the legal eligibility requirements set forth in the Terms and Conditions for AWS Marketplace Sellers\.

For more information about permitted data types, see [Publishing Guidelines](publishing-guidelines.md)\.

**Important**  
As an AWS customer, you are encouraged to conduct your own additional due\-diligence to ensure compliance with any applicable data privacy laws\. If you suspect that a product or other resources on AWS Data Exchange are being used for abusive or illegal purposes, report it using the [Report Amazon AWS abuse form](https://support.aws.amazon.com/#/contacts/report-abuse)\.

## Pricing<a name="pricing"></a>

Your AWS Data Exchange subscriptions are displayed in the currency you specified for your AWS account\. You can change your preferred currency for your AWS account in the AWS Billing and Cost Management console\. For instructions, see [Changing which currency you use to pay your bill](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/manage-account-payment.html#manage-account-payment-change-currency) in the *AWS Billing and Cost Management User Guide*\.

**Note**  
 Changing your preferred currency changes your remittance instructions\. To view updated remittance instructions, see your AWS Marketplace invoice or view the **Account Settings** page in the [AWS Billing and Cost Management](https://console.aws.amazon.com/billing/home?#account) console\.

For pricing information, see [http://aws.amazon.com/data-exchange/pricing](http://aws.amazon.com/data-exchange/pricing)\.

## Supported Regions<a name="supported-regions"></a>

AWS Data Exchange has a single, globally available product catalog offered by providers\. Subscribers can see the same catalog regardless of which AWS Region they are using\. The resources underlying the product \(data sets, revisions, assets\) are regional resources that you manage programmatically or through the AWS Data Exchange console in supported AWS Regions\. For information about which regions are supported, see [Global Infrastructure Region Table](http://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/)\.

## Related Services<a name="related-services"></a>

The following services are related to AWS Data Exchange:
+ **Amazon S3** – Currently, the only supported asset type for data sets is Amazon S3 object snapshots\. Subscribers can export data sets to Amazon S3 programatically\. For more information, see [What Is Amazon S3?](https://docs.aws.amazon.com/AmazonS3/latest/dev/Welcome.html) in the *Amazon Simple Storage Service Developer Guide*\.
+ **AWS Marketplace** – AWS Data Exchange allows data sets to be published as products on AWS Marketplace\. AWS Data Exchange providers must be registered as AWS Marketplace sellers, and can use the AWS Marketplace Management Portal or the AWS Marketplace Catalog API\. For information about becoming an AWS Marketplace subscriber, see [What Is AWS Marketplace?](https://docs.aws.amazon.com/marketplace/latest/buyerguide/what-is-marketplace.html) in the *AWS Marketplace Buyer Guide*\. For information about becoming an AWS Marketplace seller, see [What Is AWS Marketplace?](https://docs.aws.amazon.com/marketplace/latest/userguide/what-is-marketplace.html) in the *AWS Marketplace Seller Guide*\.