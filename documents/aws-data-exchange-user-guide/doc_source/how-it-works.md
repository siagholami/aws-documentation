# How AWS Data Exchange Works<a name="how-it-works"></a>

With AWS Data Exchange, providers publish file\-based data products and subscribers subscribe to those products\.

## How to Subscribe to Products<a name="high-level-subscriber"></a>

At a high level, this is how to use AWS Data Exchange as a subscriber\.

1. **Potential subscribers browse the catalog** – Products are published on AWS Data Exchange and are also available on AWS Marketplace\. You can find products and review the associated public or custom offers and product details\. For more information, see [Subscribing to Data Products on AWS Data Exchange](subscribe-to-data-sets.md)\.

1. **\(Optional\) Potential subscribers submit a request for a subscription** – The provider can choose to enable subscription verification\. If they do so, you must request a subscription to the product\. For more information, see [Subscription Verification for Subscribers](subscription-verification-sub.md)\.

1. **Subscriber subscribes to the product** – If you subscribe to a paid product, you are billed on your AWS bill\. You get access to the entitled data set\. For more information, see [Subscribing to Data Products on AWS Data Exchange](subscribe-to-data-sets.md)\.

1. **Subscriber uses the product** – You have access to the product data sets according to the terms of the data subscription agreement\. You can export the associated assets to Amazon S3 or you can use jobs with a signed URL\. For more information, see [Jobs](jobs.md)\.

1. **Request new data products** – If you are not able to find a product in the catalog, you can use the **Request data product page** in the Console to inform AWS of your interest\. AWS will use this information to work with the data provider, and try to get that data added to the catalog\.

## How to Provide Data Products<a name="high-level-provider"></a>

At a high level, this is how to use AWS Data Exchange as a provider\.

1. **Potential provider registers to be a provider** – Registering allows you to list products on AWS Data Exchange and make them available on AWS Marketplace\. For more information, see [Register to Be a Provider](providing-data-sets.md#provider-registration)\.

1. **The data is eligible to be published on AWS Data Exchange** – You're limited to distributing data sets that meet the legal eligibility requirements set forth in the Terms and Conditions for AWS Marketplace Sellers\. For more information about the types of permitted data, see [Publishing Guidelines](publishing-guidelines.md)\.

1. **Provider creates a data set and imports assets** – You can use your files or Amazon S3 objects to create data sets through the AWS Data Exchange console or APIs\. Then, you can create revisions in the data set, and import assets into that revision\. Assets can be imported from either Amazon S3 or through the use of a signed URL using asynchronous workflows called jobs\. For more information, see [Working with Data Sets](data-sets.md)\.

1. **Provider creates a product and its public offer** – To create a product, you must provide product details, include one or more data sets, and provide public offer details\. For more information, see [Publish a Product](providing-data-sets.md#publish-products)\.

1. **AWS Data Exchange copies the data set** – When an owned data set is published in a product, AWS Data Exchange creates a copy of the data set\. Subscribers can access that copy of the data set as an entitled data set\.

1. **\(Optional\) Provider enables subscription verification ** – If you enable subscription verification, subscribers must request a subscription to your product\. This gives you an opportunity to review potential subscribers before they access your data sets\. For more information, see [Subscription Verification for Providers](subscription-verification-pro.md)\.

1. **\(Optional\) Provider creates custom offers for the product** – In addition to the public offer, you can create custom offers, including private and BYOS offers, for select customers\. For more information, see [Creating Custom Offers](create-custom-offers.md)\.

1. **\(Optional\) Provider publishes new revision** – You can update dynamic data sets over time by creating a new revision using the AWS Data Exchange APIs or console\. These revisions can then be published\. For more information, see [Revisions](data-sets.md#revisions) or [Updating Products](updating-products.md)\.

1. **Provider reviews reports through the AWS Marketplace Management Portal** – Reports are available to all registered AWS Marketplace seller and are released on a regular cadence \(daily, weekly, or monthly\)\. For more information, see [Provider Financials on AWS Marketplace](provider-financials.md)\.

1. **Provider receives funds distributed by AWS Marketplace** – For more information, see [Provider Financials on AWS Marketplace](provider-financials.md)\.

## Programmatic Access<a name="control-planes"></a>

If you're using AWS Data Exchange programmatically, there are two different sets of resources with two different APIs\.
+ **AWS Data Exchange APIs** – Use these APIs to create, view, update, and delete data sets and revisions\. You can also use these APIs to import and export assets to and from those revisions\. For more information, see the [AWS Data Exchange API Reference](https://docs.aws.amazon.com/data-exchange/latest/apireference)\.
+ **AWS Marketplace Catalog APIs** – Used by providers to view and update products on AWS Data Exchange and AWS Marketplace\. For more information, see the [AWS Marketplace Catalog API Reference](https://docs.aws.amazon.com/marketplace-catalog/latest/api-reference/catalog-api-user-guide.html)\.