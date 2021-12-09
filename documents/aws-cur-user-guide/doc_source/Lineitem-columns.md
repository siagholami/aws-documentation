# Line Item Details<a name="Lineitem-columns"></a>

Columns under the **lineItem** header are static fields that appear in every Cost and Usage Reports\. They cover all of the cost and usage information for your usage\. This includes the following columns:

[A](#l-A) \| [B](#l-B) \| [C](#l-C) \| D \| E \| F \| G \| H \| I \| J \| K \| [L](#l-L) \| M \| [N](#l-N) \| [O](#l-O) \| [P](billing-columns.md#b-P) \| Q \| [R](#l-R) \| S \| T \| [U](#l-U) \| VWXYZ 

## A<a name="Lineitem-details-A"></a>

### lineItem/AvailabilityZone<a name="Lineitem-details-A-AvailabilityZone"></a>

The Availability Zone that hosts this line item\. For example, `us-east-1a` or `us-east-1b`\.

## B<a name="Lineitem-details-B"></a>

### lineItem/BlendedCost<a name="Lineitem-details-B-BlendedCost"></a>

The `BlendedRate` multiplied by the `UsageAmount`\.

**Note**  
**BlendedCost** is blank for line items that have a **LineItemType** of **Discount**\. Discounts are calculated using only the unblended cost of a linked account, aggregated by linked account and SKU\. As a result, **BlendedCost** is not available for discounts\.

### lineItem/BlendedRate<a name="Lineitem-details-B-BlendedRate"></a>

The `BlendedRate` is the average cost incurred for each SKU across an organization\.

For example, the Amazon S3 blended rates are the total cost of storage divided by the amount of data stored per month\. For accounts with RIs, the blended rates are calculated as the average costs of the RIs and the On\-Demand Instances\.

Blended rates are calculated at the Master \(Payer\) Account level, and used to allocate costs to each member account\. For more information, see [Blended Rates and Costs](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/con-bill-blended-rates.html#Blended_CB) in the *AWS Billing and Cost Management User Guide*\.

## C<a name="Lineitem-details-C"></a>

### lineItem/CurrencyCode<a name="Lineitem-details-C-currencyCode"></a>

The currency that this line item is shown in\.

## L<a name="Lineitem-details-L"></a>

### lineItem/LegalEntity<a name="Lineitem-details-L-LegalEntity"></a>

The provider of your AWS services\. Possible values are the following:
+ **Amazon Web Services** – The entity that sells AWS services\.
+ **Amazon Internet Services Pvt\. Ltd** – The local Indian entity that acts as a reseller for AWS services in India\.

### lineItem/LineItemDescription<a name="Lineitem-details-L-LineItemDescription"></a>

The description of the line item type\. For example, the description of a usage line item summarizes what type of usage you incurred during a specific time period\.

For size\-flexible RIs, the description corresponds to the RI the benefit was applied to\. For example, if a line item corresponds to a `t2.micro` and a `t2.small` RI was applied to the usage, the line **item/description** displays `t2.small`\.

The description for a usage line item with an RI discount contains the pricing plan covered by the line item\.

### lineItem/LineItemType<a name="Lineitem-details-L-LineItemType"></a>

The type of charge covered by this line item\. Possible types are the following:
+ **Credit** – Any credits that AWS applied to your bill\. See the **Description** column for details\. AWS might update reports after they have been finalized if AWS applies a credit to your account for the month after finalizing your bill\.
+ **DiscountedUsage** – The rate for any instances for which you had Reserved Instance \(RI\) benefits\.
+ **Fee** – Any upfront annual fee that you paid for subscriptions\. For example, the upfront fee that you paid for an **All Upfront RI** or a **Partial Upfront RI**\.
+ **Refund** – The negative charges that AWS refunded money for\. Check the **Description** column for details\. AWS might update reports after they have been finalized if AWS applies a refund to your account for the month after finalizing your bill\.
+ **RIFee** – The monthly recurring fee for subscriptions\. For example, the recurring fee for **Partial Upfront RI**s, **No Upfront RI**s, and **All Upfront**s that you pay every month\.
+ **Tax** – Any taxes that AWS applied to your bill\. For example, VAT or US sales tax\.
+ **Usage** – Any usage that is charged at On\-Demand Instance rates\.
+ **SavingsPlanUpfrontFee** – Any upfront fee you paid for your Savings Plans\. For example, the upfront fee that you paid for an **All Upfront Savings Plan** or a **Partial Upfront Savings Plan**\.
+ **SavingsPlanRecurringFee** – The monthly recurring fee for your Savings Plans related subscriptions\. For example, the recurring monthly fee for a **Partial Upfront Savings Plan** or **No Upfront Savings Plan**\.
+ **SavingsPlanCoveredUsage** – The instances that received benefits from a Savings Plan subscription\.
+ **SavingsPlanNegation** – The Savings Plans discount applied\. The line item contains negative costs \(discounts\)\. This enables you to find the net cost after Savings Plans discounts, using the total sum of the **Unblended Cost**\.

## N<a name="Lineitem-details-N"></a>

### lineItem/NormalizationFactor<a name="Lineitem-details-N-NormalizationFactor"></a>

As long as the instance has shared tenancy\. AWS can apply all regional Linux or Unix Amazon EC2 and Amazon RDS RI discounts to all instance sizes in an instance family and AWS Region\. This also applies to RI discounts for member accounts in an organization\. All new and existing Amazon EC2 and Amazon RDS size\-flexible RIs are sized according to a normalization factor, based on the instance size\. The following table shows the normalization factor that AWS applies to each instance size\.


**Normalization Factors for Amazon EC2 Size\-Flexible RIs**  

|  Instance Size  |  Normalization Factor  | 
| --- | --- | 
|  `nano`  |  0\.25  | 
|  `micro`  |  0\.5  | 
|  `small`  |  1  | 
|  `medium`  |  2  | 
|  `large`  |  4  | 
|  `xlarge`  |  8  | 
|  `2xlarge`  |  16  | 
|  `4xlarge`  |  32  | 
|  `8xlarge`  |  64  | 
|  `10xlarge`  |  80  | 
|  `16xlarge`  |  128  | 
|  `32xlarge`  |  256  | 

### lineItem/NormalizedUsageAmount<a name="Lineitem-details-N-NormalizedUsageAmount"></a>

The amount of usage that you incurred, in normalized units, for size\-flexible RIs\. The **NormalizedUsageAmount** is equal to **UsageAmount** multiplied by **NormalizationFactor**\.

## O<a name="Lineitem-details-O"></a>

### lineItem/Operation<a name="Lineitem-details-O-Operation"></a>

The specific AWS operation covered by this line item\. This describes the specific usage of the line item\. For example, a value of `RunInstances` indicates the operation of an Amazon EC2 instance\.

## P<a name="Lineitem-details-P"></a>

### lineItem/ProductCode<a name="Lineitem-details-P-ProductCode"></a>

The code of the product measured\. For example, Amazon EC2 is the product code for Amazon Elastic Compute Cloud\.

## R<a name="Lineitem-details-R"></a>

### lineItem/ResourceId<a name="Lineitem-details-R-ResourceId"></a>

\(Optional\) If you chose to include individual resource IDs in your report, this column contains the ID of the resource that you provisioned\. For example, an Amazon S3 storage bucket, an Amazon EC2 Compute Instance, or an Amazon RDS database can each have a resource ID\. This field is blank for usage types that aren't associated with an instantiated host, such as data transfers and API requests, and line item types such as discounts, credits, and taxes\. The following table shows a list of resource identifiers for common AWS services\.


**AWS Resource Identifiers**  

|  AWS Service  |  Resource Identifier  | 
| --- | --- | 
|  Amazon CloudFront  |  Distribution ID  | 
|  Amazon CloudSearch  |  Search domain  | 
|  Amazon DynamoDB  |  DynamoDB table  | 
|  Amazon Elastic Compute Cloud \- Amazon EBS  |  Amazon EBS volume  | 
|  Amazon Elastic Compute Cloud  |  Instance ID  | 
|  Amazon Elastic Compute Cloud \- CloudWatch  |  CloudWatch charges for an instance ID  | 
|  Amazon EMR  |  MapReduce cluster  | 
|  Amazon ElastiCache  |  Cache cluster  | 
|  Amazon Elasticsearch Service  |  Search domain  | 
|  Amazon S3 Glacier  |  Vault  | 
|  Amazon Relational Database Service  |  Database  | 
|  Amazon Redshift  |  Amazon Redshift cluster  | 
|  Amazon Simple Storage Service  |  Amazon S3 bucket  | 
|  Amazon Virtual Private Cloud  |  VPN ID  | 
|  AWS Lambda  |  Lambda function name  | 

## T<a name="Lineitem-details-T"></a>

### lineItem/TaxType<a name="Lineitem-details-T-TaxType"></a>

The type of tax that AWS applied to this line item\.

## U<a name="Lineitem-details-U"></a>

### lineItem/UnblendedCost<a name="Lineitem-details-U-UnblendedCost"></a>

The `UnblendedCost` is the `UnblendedRate` multiplied by the `UsageAmount`\.

### lineItem/UnblendedRate<a name="Lineitem-details-U-UnblendedRate"></a>

The uncombined rate for specific usage\. For line items that have an RI discount applied to them, the `UnblendedRate` is zero\. Line items with an RI discount have a `UsageType` of `Discounted Usage`\.

### lineItem/UsageAccountId<a name="Lineitem-details-U-UsageAccountId"></a>

The ID of the account that used this line item\. For organizations, this can be either the master account or a member account\. You can use this field to track costs or usage by account\. 

### lineItem/UsageAmount<a name="Lineitem-details-U-UsageAmount"></a>

The amount of usage that you incurred during the specified time period\. For size\-flexible reserved instances, use the **reservation/TotalReservedUnits** column instead\.

### lineItem/UsageEndDate<a name="Lineitem-details-U-UsageEndDate"></a>

The end date and time for the corresponding line item in UTC, exclusive\. The format is `YYYY-MM-DDTHH:mm:ssZ`\.

### lineItem/UsageStartDate<a name="Lineitem-details-U-UsageStartDate"></a>

The start date and time for the line item in UTC, inclusive\. The format is `YYYY-MM-DDTHH:mm:ssZ`\. 

### lineItem/UsageType<a name="Lineitem-details-U-UsageType"></a>

The usage details of the line item\. For example, `USW2-BoxUsage:m2.2xlarge` describes an M2 High Memory Double Extra Large instance in the US West \(Oregon\) Region\.