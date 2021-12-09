# Migrating From Detailed Billing Reports to Cost and Usage Reports<a name="detailed-billing-migrate"></a>

The Detailed Billing Report \(DBR\) and AWS Cost and Usage Reports \(CUR\) both provide information about your charges\. If you are using a legacy DBR, we strongly recommend you transfer your report to Cost and Usage Reports\.

**Topics**
+ [Comparing Benefits of the Cost and Usage Reports \(AWS CUR\)](#migrate-benefit-cur)
+ [Key Differences Between the Detailed Billing Report and the Cost and Usage Reports](#migrate-key)
+ [Reporting on Advanced Charge Types](#reporting-advanced-chargetype)

## Comparing Benefits of the Cost and Usage Reports \(AWS CUR\)<a name="migrate-benefit-cur"></a>

AWS CUR provides the most comprehensive source of information\. It allows you to understand individual costs in depth, and to analyze them in greater detail, which is especially useful at an enterprise scale\. AWS CUR is best suited for customers with complex cost management needs, for example, those with dedicated query or analytic\-based systems\. AWS CUR is also your best source for Reserved Instance \(RI\) information, especially if you want to view amortized costs\.

### Comprehensive Reservation Information<a name="migrate-reservation"></a>

Reserved Instances \(RI\), or reservations, offer a discounted hourly rate compared to On\-Demand usage in exchange for committing to a one\- or three\-year term of service\. This can result in significant savings\. AWS CUR helps you monitor and manage your reservation portfolio by providing comprehensive information like reservation Amazon Resource Numbers \(ARNs\), numbers of reservations, and total RIs\. You can track your reservation\-related discounts to specific resources, which help you better understand your savings\. 

DBR provides a subset of this metadata, but work is required to transform the required columns\.

AWS CUR provides additional columns not available in DBR, such as information regarding your amortized reservation costs\. For more information, see [Understanding Your Amortized Reservation Data](amortized-reservation.md)\.

### On\-Demand Pricing Availability<a name="migrate-ondemand"></a>

AWS CUR provides information regarding the On\-Demand rates for each individual line item of usage\. This information enables you to quantify your savings by subtracting the amount you paid from the On\-Demand rate, enabling you to compute your savings as compared to On\-Demand prices\. This also gives you the flexibility of choosing to allocate your costs using public On\-Demand rates\.

DBR doesn’t contain information for On\-Demand rates, but only the billed amount\. This makes it difficult to calculate your overall savings or to allocate costs using On\-Demand rates\.

### Granular Breakdown of Discounts<a name="migrate-granular"></a>

AWS CUR can access a granular view of the usage\-based discounts\. If discounts were applied, you can use AWS CUR to view the following:
+ Cost prior to being discounted
+ Discounted amount
+ Total cost after the discount was applied at the line item level

DBR does not contain a granular breakdown of your discounts\.awsMasterSchedDocs

### Automated Data Ingestion at Scale<a name="migrate-autodata"></a>

When you use AWS CUR, you can easily configure an event to trigger an automated data ingestion process, streamlining the process of refreshing the billing data in your in\-house systems\. AWS CUR data can automatically be refreshed when charges related to previous months are detected\.

Additionally, AWS CUR is generated as multiple files, providing the added benefit of segmenting the data into smaller pieces\. This makes it easier to ingest the data according to the processes used by multiple workers\. It also allows you to retry data downloads in smaller pieces\.

AWS CUR is formatted in a way that enables you to locate and extract data quickly\. This report is modeled from a manifest file that contains information for the overall structure of the data, including a list of every column that is contained in the report\. This enables you to extend the report and include new information regarding your usage when it becomes available\.

### Cross\-Product Integration<a name="migrate-crossproduct"></a>

AWS CUR supports integration with Amazon Redshift, Amazon QuickSight, and Amazon Athena, making it easy to quickly build out an AWS based cost management solution\. AWS CUR also provides data in Parquet format, broadening your options when it comes to building out your own cost and usage reporting system\. For more information, see [AWS Cost and Usage Report Manifest Files](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-reports-costusage-files.html#manifests) in the *AWS Billing and Cost Management User Guide*\.

## Key Differences Between the Detailed Billing Report and the Cost and Usage Reports<a name="migrate-key"></a>

There are a few differences between DBR and AWS CUR that you should be aware of after you migrate to using AWS CUR\. You may need to adjust how you ingest the data into your systems accordingly\.

### File Structure<a name="key-file"></a>

DBR is delivered as a single file, while AWS CUR provides as a consolidated set of files\. In AWS CUR, you can view the following files in your Amazon S3 bucket:
+ Set of data files containing all of your usage line items
+ Separate data file containing all of your discounts \(if applicable\)
+ Manifest file that lists all of the data files that belong to a single report

### Column Structure<a name="key-column"></a>

DBR has a fixed list of columns, limiting its flexibility\. AWS CUR does not have a fixed column structure, and instead allows you to freely add or remove columns as needed\. When you begin using a new AWS service, AWS CUR can dynamically start to include new data in the report that may be useful in your case\. The manifest file provides a map of all columns present in the report\.


**Equivalent Column Names for DBR and AWS CUR**  

| DBR Column Name | AWS CUR Column Name | 
| --- | --- | 
| InvoiceId | bill/InvoiceId | 
| PayerAccountId | bill/PayerAccountId | 
| LinkedAccountId | lineItem/UsageAccountId | 
| ProductName | product/ProductName | 
| SubscriptionId | reservation/subscriptionid | 
| UsageType | lineItem/UsageType | 
| Operation | lineItem/Operation | 
| AvailabilityZone | lineItem/AvailabilityZone | 
| ReservedInstance | Not Supported | 
| ItemDescription | lineItem/LineItemDescription | 
| UsageStartDate | lineItem/UsageStartDate | 
| UsageEndDate | lineItem/UsageEndDate | 
| UsageQuantity | lineItem/UsageAmount | 
| BlendedRate | lineItem/BlendedRate | 
| BlendedCost | lineItem/BlendedCost | 
| UnBlendedRate | lineItem/UnblendedRate | 
| UnBlendedCost | lineItem/UnblendedCost | 
| ResourceId | lineItem/ResourceId | 
| RecordType | Not Supported | 
| Pricingplanid | Not Supported | 
| RateID | pricing/RateId | 

**Note**  
There is no equivalent for RecordId in AWS CUR, but you can gather this information by combining identity/LineItemId, identity/TimeInterval, and bill/BillType\.

 


**Retrieving DBR RecordType Values Through AWS CUR**  

| RecordType values in DBR | Syntax to Retrieve RecordType Through AWS CUR | Use Case | 
| --- | --- | --- | 
| LineItem | SELECT SUM\(line\_item\_unblended\_cost\) FROM \[CUR\] WHERE line\_item\_line\_item\_type = 'Usage' | Usage line item partitions out usage costs from one\-time charges\. For example: upfront RI payment  | 
| InvoiceTotal | SELECT \(bill\_invoice\_id\), sum\(line\_item\_unblended\_cost\) FROM \[CUR\] GROUP BY bill\_invoice\_id | Invoice total helps you reconcile your costs between Invoices and the Cost and Usage Report\. | 
| AccountTotal | SELECT line\_item\_usage\_account\_id, sum\(line\_item\_unblended\_cost\) FROM \[CUR\] GROUP BY line\_item\_usage\_account\_id  | Account total helps you isolate costs related to your linked accounts for charge back purposes\. | 
| StatementTotal | SELECT SUM\(line\_item\_unblended\_cost\) FROM \[CUR\] | Statement total helps you understand your costs for the billing period\. | 
| Discount | SELECT SUM\(line\_item\_unblended\_cost\) FROM \[CUR\] WHERE line\_item\_line\_item\_type = 'Discount'  | Discount line items helps you identify all of your discount\-related line items\. | 
| Rounding | Not yet supported | Not yet supported | 

## Reporting on Advanced Charge Types<a name="reporting-advanced-chargetype"></a>

### Refunds<a name="reporting-advanced-refunds"></a>

AWS CUR: Refunds are identified by filtering for the `lineitem/lineitemtype = ‘Refund’` string\.

DBR: Credits can be identified by parsing the ItemDescription column for the `‘Credit’` substring\. 

### Credits<a name="reporting-advanced-credits"></a>

AWS CUR: Refunds are identified by filtering for the `lineitem/lineitemtype = ‘Credit’` string\.

DBR: Refunds are identified through parsing the ItemDescription column for the `‘Refund’` substring\. 

### Taxes<a name="reporting-advanced-taxes"></a>

AWS CUR: Taxes are identified by filtering the `lineitem/lineitemtype = ‘Tax’` string\.

DBR: Taxes are identified by parsing the ItemDescription column for the `‘Tax’` substring\. 

### Identifying Reservation\-Related Upfront Costs<a name="reporting-advanced-upfront"></a>

AWS CUR: Reservation\-related upfront fees can be identified by filtering `"lineitem/lineitemtype" = 'Fee'`\.

DBR: Reservation\-related upfront costs can be identified by examining the Usagetype column for the `'HeavyUsage'` substring, and whether the `'SubscriptionId'` is null\.

### Identifying Reservation\-Related Monthly Fee<a name="reporting-advanced-monthly"></a>

AWS CUR: Reservation\-related monthly fees can be identified by filtering `"lineitem/lineitemtype" = 'RIfee'`\.

DBR: Reservation\-related monthly fees can be identified by examining the Usagetype column for the `'HeavyUsage'` substring\. 

### Identifying Instances That Received Reserved Instance Benefits<a name="identify-benefit-instance"></a>

AWS CUR: Reservation\-related upfront fees can be identified by filtering `"lineitem/lineitemtype" = 'DiscountedUsage'`\.

DBR: Reservation\-related upfront fees can be identified by filtering`'ReservedInstance' = 'Y'`\. 