# Cost and Usage Report User Guide

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
+ [What Are AWS Cost and Usage Reports?](what-is-cur.md)
+ [Creating Cost and Usage Reports](creating-cur.md)
   + [Setting Up an Amazon S3 Bucket for Cost and Usage Reports](cur-s3.md)
   + [Creating Cost and Usage Reports](cur-create.md)
+ [Managing Your Cost and Usage Reports](managing-cur.md)
   + [Viewing Your Cost and Usage Reports Details](view-cur.md)
   + [Accessing Your Cost and Usage Reports in Amazon S3](access-cur-s3.md)
   + [Editing Your Cost and Usage Reports Configuration](edit-cur.md)
+ [Querying Cost and Usage Reports Using Amazon Athena](cur-query-athena.md)
   + [Setting Up Amazon Athena Integration](cur-ate-setup.md)
      + [Creating a New Amazon S3 Bucket For Your Reports](create-athena-bucket.md)
      + [Creating New Cost and Usage Reports](create-athena-cur.md)
      + [Setting Up Athena Using AWS CloudFormation Templates](use-athena-cf.md)
   + [Manually Setting Up Amazon Athena](cur-ate-manual.md)
      + [Creating an Athena Table](create-manual-table.md)
      + [Creating a Cost and Usage Reports Status Table](create-manual-cur-table.md)
      + [Uploading Your Report Partitions](upload-report-partitions.md)
   + [Running Amazon Athena Queries](cur-ate-run.md)
   + [Loading Report Data to Other Resources](cur-query-other.md)
+ [Data Dictionary](data-dictionary.md)
   + [Identity Details](identity-columns.md)
   + [Billing Details](billing-columns.md)
   + [Line Item Details](Lineitem-columns.md)
   + [Reservation Details](reservation-columns.md)
   + [Pricing Details](pricing-columns.md)
   + [Product Details](product-columns.md)
   + [Resource Tags Details](resource-tags-columns.md)
   + [Savings Plans Details](savingsplans-columns.md)
   + [Cost Categories Details](cost-categories-columns.md)
+ [Use Cases](use-cases.md)
   + [Understanding Savings Plans](cur-sp.md)
   + [Understanding Your Reservations](understanding-ri.md)
      + [Understanding Your Reservation Line Items](regular-reserved-instances.md)
      + [Understanding Your Amortized Reservation Data](amortized-reservation.md)
      + [Monitoring Your Size Flexible Reservations](monitor-flexible-reservation.md)
      + [Monitoring Your On-Demand Capacity Reservations](monitor-ondemand-reservations.md)
+ [Legacy Reports](legacy-reports.md)
   + [Detailed Billing Reports](detailed-billing.md)
      + [Migrating From Detailed Billing Reports to Cost and Usage Reports](detailed-billing-migrate.md)
   + [Monthly Report](monthly-report.md)
   + [Monthly Cost Allocation](monthly-cost-allocation.md)
   + [AWS Usage Report](usage-report.md)
+ [Contacting Customer Support](billing-get-answers.md)
+ [Security in AWS Cost and Usage Reports](security.md)
+ [Quotas and Restrictions](billing-cur-limits.md)
+ [Document History for AWS Cost and Usage Reports User Guide](doc-history.md)
+ [AWS Glossary](glossary.md)