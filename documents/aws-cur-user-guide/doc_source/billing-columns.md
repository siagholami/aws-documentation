# Billing Details<a name="billing-columns"></a>

Columns under the **bill** header are static fields that appear in every Cost and Usage Reports\. You can use the billing line items in the AWS CUR to find details about the specific bill covered by the report, such as the charge type and the beginning and end of the billing period\. This includes the following columns: 

A \| [B](#b-B) \| C \| D \| E \| F \| G \| H \| [I](#b-I) \| J \| K \| L \| M \| N \| O \| [P](#b-P) \| Q \| R \| S \| T \| U \| VWXYZ 

## B<a name="billing-details-B"></a>

### bill/BillingEntity<a name="billing-details-B-BillingEntity"></a>

The AWS seller that your account is with\. Possible values are the following: 
+ **AWS** – Amazon Web Services The entity that sells AWS services\.
+ **AISPL** – Amazon Internet Services Pvt\. Ltd\. The local Indian entity that acts as a reseller for AWS services in India\.
+ **AWS Marketplace** – The entity that supports the sale of solutions built on top of the AWS platform by third\-party software providers\.

### bill/BillingPeriodEndDate<a name="billing-details-B-BillingPeriodEndDate"></a>

The end date of the billing period that is covered by this report, in UTC\. The format is `YYYY-MM-DDTHH:mm:ssZ`\.

### bill/BillingPeriodStartDate<a name="billing-details-B-BillingPeriodStartDate"></a>

The start date of the billing period that is covered by this report, in UTC\. The format is `YYYY-MM-DDTHH:mm:ssZ`\. 

### bill/BillType<a name="billing-details-B-BillType"></a>

The type of bill that this report covers\. There are three bill types:
+ **Anniversary** – Line items for services that you used during the month
+ **Purchase** – Line items for upfront service fees
+ **Refund** – Line items for refunds

## I<a name="billing-details-I"></a>

### bill/InvoiceId<a name="billing-details-I-InvoiceId"></a>

The ID associated with a specific line item\. Until the report is final, the **InvoiceId** is blank\.

## P<a name="billing-details-P"></a>

### bill/PayerAccountId<a name="billing-details-P-PayerAccountId"></a>

The account ID of the paying account\. For an organization in AWS Organizations, this is the account ID of the master account\.