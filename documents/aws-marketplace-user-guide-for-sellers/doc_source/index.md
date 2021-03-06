# AWS Marketplace Seller Guide

-----
*****Copyright &copy; 2020 Amazon Web Services, Inc. and/or its affiliates. All rights reserved.*****

-----
Amazon's trademarks and trade dress may not be used in 
     connection with any product or service that is not Amazon's, 
     in any manner that is likely to cause confusion among customers, 
     or in any manner that disparages or discredits Amazon. All other 
     trademarks not owned by Amazon are the property of their respective
     owners, who may or may not be affiliated with, connected to, or 
     sponsored by Amazon.

-----
## Contents
+ [What Is AWS Marketplace?](what-is-marketplace.md)
+ [Getting started as a seller](user-guide-for-sellers.md)
   + [Seller registration process](seller-registration-process.md)
   + [Seller toolkit](additional-seller-tools.md)
      + [AWS Marketplace Commerce Analytics Service](commerce-analytics-service.md)
      + [AWS Marketplace Enhanced Data Sharing Program](enhanced-data-sharing-program.md)
      + [AWS Marketplace Field Demonstration Program](field-demonstration-program.md)
      + [Product Support Connection](product-support-connection.md)
+ [Preparing your product](product-preparation.md)
   + [Product pricing](pricing.md)
      + [Refunds](refunds.md)
   + [Private offers](private-offers-overview.md)
      + [Flexible payment scheduler](flexible-payment-scheduler.md)
      + [Consulting partner private offers](consulting-partner-offers.md)
         + [ISV setup](consulting-partner-isv-info.md)
         + [Consulting partner setup](consulting-partner-info.md)
      + [Private offer upgrades and renewals](private-offers-upgrades-and-renewals.md)
   + [Standardized license terms](standardized-license-terms.md)
   + [Categories and metadata](categories-and-metadata.md)
   + [Search engine optimization](search-engine-optimization.md)
+ [AWS Marketplace for Desktop Applications (AMDA)](amda.md)
+ [AMI-based products](ami-products.md)
   + [Best practices for building AMIs](best-practices-for-building-your-amis.md)
   + [Metering service](metering-service.md)
   + [AMI-based delivery using AWS CloudFormation](cloudformation.md)
      + [Adding serverless application components](cloudformation-serverless-application.md)
   + [Private images](private-images.md)
   + [AMI product checklist](aws-marketplace-listing-checklist.md)
+ [Container-based products](container-based-products.md)
   + [Getting started with container products](container-product-getting-started.md)
   + [Pricing container products](pricing-container-products.md)
   + [AWS Marketplace Metering Service integration](entitlement-and-metering-for-paid-products.md)
      + [Custom metering](container-metering-meterusage.md)
         + [Integrating your container product with the AWS Marketplace Metering Service using the AWS SDK for Java](java-integration-example-meterusage.md)
      + [Hourly metering](container-metering-registerusage.md)
         + [Integrating your container product with the AWS Marketplace Metering Service using the AWS SDK for Java](java-integration-example-registerusage.md)
+ [Machine learning products](machine-learning-products.md)
   + [Putting your algorithms and model packages on the AWS Marketplace](listing-algorithms-and-model-packages-in-aws-marketplace-for-machine-learning.md)
   + [Best practices for sample input data and sample notebooks](best-practices-sample-ml.md)
+ [Software as a service (SaaS)???based products](saas-products.md)
   + [Getting started](saas-getting-started.md)
      + [SaaS subscriptions](saas-subscription-overview.md)
      + [SaaS contracts](saas-contract-overview.md)
      + [SaaS contracts with consumption](saas-contract-consumption-overview.md)
   + [Plan your SaaS product](saas-prepare.md)
   + [SaaS product guidelines](saas-guidelines.md)
   + [Pricing SaaS products](saas-pricing-models.md)
      + [Pricing for SaaS subscriptions](saas-subscriptions.md)
      + [Pricing for SaaS contracts](saas-contracts.md)
   + [SaaS customer onboarding](saas-product-customer-setup.md)
   + [Amazon SNS notifications for SaaS products](saas-notification.md)
   + [Accessing the AWS Marketplace Metering and Entitlement Service APIs](saas-integration-metering-and-entitlement-apis.md)
      + [Metering for usage](metering-for-usage.md)
      + [Checking entitlements](checking-entitlements.md)
      + [SaaS product integration checklist](aws-marketplace-integration-checklist.md)
   + [Reporting](saas-reporting.md)
   + [Code examples](saas-code-examples.md)
   + [Using AWS PrivateLink with AWS Marketplace](privatelink.md)
+ [Data products](data-products.md)
+ [Submitting your product for publication](product-submission.md)
+ [Marketing your product](product-marketing.md)
+ [Seller reports and data feeds](reports-and-data-feed.md)
   + [Seller reports](Reporting.md)
      + [Daily business report](daily-business-report.md)
      + [Daily customer subscriber report](daily-customer-subscriber-report.md)
      + [Disbursement report](monthly-disbursement-report.md)
      + [Monthly billed revenue report](monthly-billed-revenue-report.md)
      + [Sales compensation report](sales-compensation-report.md)
      + [US sales and use tax report](u.s.-sales-and-use-tax-report.md)
      + [Daily ref tag](daily-ref-tag.md)
      + [Weekly ref tag](weekly-ref-tag-1.md)
   + [Data feeds](data-feed.md)
      + [Account data feed](data-feed-account.md)
      + [Address data feed](data-feed-address.md)
      + [Billing event data feed](data-feed-billing-event.md)
      + [Legacy mapping data feed](data-feed-legacy-mapping.md)
      + [Offer data feed](data-feed-offer.md)
      + [Offer product data feed](data-feed-offer-product.md)
      + [Offer target data feed](data-feed-offer-target.md)
      + [Product data feed](data-feed-product.md)
      + [Tax item data feed](data-feed-tax-item.md)
+ [AWS Marketplace security](security.md)
   + [Controlling access to AWS Marketplace Management Portal](marketplace-management-portal-user-access.md)
   + [Policies and permissions for AWS Marketplace sellers](detailed-management-portal-permissions.md)
   + [AWS Marketplace Commerce Analytics Service account permissions](set-aws-iam-cas-permissions.md)
   + [AWS Marketplace Product Support Connection account permissions](set-aws-iam-psc-permissions.md)
   + [Amazon SQS permissions](set-aws-iam-sqs-permissions.md)
   + [AWS Marketplace metering and entitlement API permissions](iam-user-policy-for-aws-marketplace-actions.md)
   + [AMI security policies](product-and-ami-policies.md)
   + [Logging AWS Marketplace API calls with AWS CloudTrail](logging-aws-marketplace-api-calls-with-aws-cloudtrail.md)
+ [Document history](document-history.md)
+ [AWS glossary](glossary.md)