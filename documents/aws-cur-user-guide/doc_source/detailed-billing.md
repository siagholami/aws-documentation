# Detailed Billing Reports<a name="detailed-billing"></a>

**Important**  
The Detailed Billing Report feature is unavailable for new customers as of 07/08/2019\.

Detailed Billing Reports \(DBR\) contain similar information as AWS CUR regarding your charges, but calculates the individual line items differently\. If you've signed up for both the DBR and AWS CUR, the line items will not match\. However, when the reports are finalized at the end of the month, the total cost will align\.

AWS stores the DBR in Amazon S3 as csv files, using the following naming convention:

```
AWS account number-aws-billing-detailed-line-items-yyyy-mm.csv.zip
```

AWS recreates the DBR multiple times a day, overwriting the report\. When AWS overwrites a report, the line items might be in a different order than they were in the previous report\. A final report is created at the end of the month\. For the following month, AWS creates a new report file instead of overwriting the final report from the previous month\. Reports for previous months remain in your S3 bucket until you delete them\.

For information on how to migrate your DBR to AWS CUR, see [Migrating From Detailed Billing Reports to Cost and Usage Reports](detailed-billing-migrate.md)\.

## Understanding Unused Reservation Costs<a name="unused-reservation-costs"></a>

AWS Cost and Usage Reports \(AWS CUR\) can be leveraged to better understand unused RI costs\. Here’s four scenarios showing how\.

### Scenario 1: RI usage is 100%<a name="scenario-1"></a>

RI Fee line item has $0 unused cost and 0 usage hours\.

Using the DBR/DBR\-RT, you can understand your unused RI usage and costs by referring to the fields UsageQuantity and UnblendedCosts for RI Fee line items\. RI Fee line items can be identified by the existence of ‘purchased hours’ information in the ItemDescription field\. Table 1 illustrates the columns and information used to manage unused RI costs in the DBR and DBR\-RT report\.

**Table 1 – Unused RI costs for a 100% RI usage in DBR and DBR\-RT prior to June 17, 2019**


| ProductName | UsageType | Operation | Availability Zone | Reserved Instance | ItemDescription | Usage Quantity | Unblended Rate | Unblended Cost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge \(744 hours purchased, 744 hours used\) | 0 | 0\.1 | 0 | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 0\.1 | 74\.4 | 

Using AWS CUR, you can understand your unused RI usage and costs by referring to the fields ‘reservation/ UnusedQuantity’ and ‘reservation/ UnusedRecurringFee’ for RI Fee line items\. Table 4 below illustrates the current columns and information utilized to manage unused RI costs in AWS CUR\.

**Table 2 – Unused RI costs for a 100% RI usage in AWS CUR**


| lineitem/ Productcode | UsageType | lineitem/ LineItemType | lineitem/ LineItemDescription | lineitem/ UsageAmount | lineitem/ NormalizedUsageAmount | lineitem/ UnblendedRate | lineitem/ UnblendedCost | reservation/ UnusedQuantity | reservation/ UnusedRecurringFee | reservation/ UnusedAmortizedUpfrontFeeForBillingPeriod | reservation/ RecurringFeeForUsage | reservation/ AmortizedUpfrontCostForUsage | reservation/ EffectiveCost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon EC2  | HeavyUsage:c3\.8xlarge | RI Fee | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 47,616 | 0\.1 | 74\.4 | 0 | 0 | 0 |  |  |  | 
|  Amazon EC2  | USW2\-BoxUsage:c3\.8xlarge | DiscountedUsage | USD 0\.00 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 47,616 | 0 | 0 |  |  |  | 74\.4 | 5 | 79\.4 | 

In addition to matching the current functionality supported by DBR/DBR\-RT, AWS CUR has the following advantages:
+ Using AWS CUR, you are able to access information regarding the EffectiveCost for the DiscountedUsage line item, which includes both the recurring and upfront fees\. The DBR only accounts for recurring fees\.
+ In AWS CUR, the UsageType field is not transformed for the DiscountedUsage line items whereas DBR replaces the information with RI Fee line item information\. This is because the user can group line items in AWS CUR by ReservationARN in order to understand what usage was discounted by which RI\.
+ In AWS CUR, the LineItemDescription field is not transformed for the RI Fee line item\. DBR appends the hours purchased and hours used\.

### Scenario 2: Partial RI usage<a name="scenario-2"></a>

RI Fee line item has unused cost and usage\.

Using the DBR/DBR\-RT, you can understand your unused RI usage and costs by referring to fields UsageQuantity and UnblendedCosts for RI Fee line items\. Table 3 illustrates the columns and information used to manage unused RI costs in the DBR and DBR\-RT report\.

**Table 3 – Unused RI costs for a partial RI usage in DBR and DBR\-RT prior to June 17, 2019**


| ProductName | UsageType | Operation | Availability Zone | Reserved Instance | ItemDescription | Usage Quantity | Unblended Rate | Unblended Cost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge \(744 hours purchased, 644 hours used\) | 100 | 0\.1 | 10 | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 644 | 0\.1 | 64\.4 | 

Using AWS CUR, you can understand your unused RI usage and costs by referring to fields ‘reservation/ UnusedQuantity’ and ‘reservation/ UnusedRecurringFee’ for RI Fee line items\. Table 4 illustrates the current columns and information utilized to manage unused RI costs in AWS CUR\.

**Table 4 – Unused RI costs for a partial RI usage in AWS CUR**


| lineitem/ Productcode | UsageType | lineitem/ LineItemType | lineitem/ LineItemDescription | lineitem/ UsageAmount | lineitem/ NormalizedUsageAmount | lineitem/ UnblendedRate | lineitem/ UnblendedCost | reservation/ UnusedQuantity | reservation/ UnusedRecurringFee | reservation/ UnusedAmortizedUpfrontFeeForBillingPeriod | reservation/ RecurringFeeForUsage | reservation/ AmortizedUpfrontCostForUsage | reservation/ EffectiveCost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon EC2  | HeavyUsage:c3\.8xlarge | RI Fee | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 47,616 | 0\.1 | 74\.4 | 100 | 0 | 10 |  |  |  | 
|  Amazon EC2  | USW2\-BoxUsage:c3\.8xlarge | DiscountedUsage | USD 0\.00 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 644 | 47,216 | 0 | 0 |  |  |  | 64\.4 | 5 | 69\.4 | 

In addition to matching the current functionality supported by DBR/DBR\-RT, AWS CUR has the following advantages:
+ AWS CUR has a separate column representing UnusedQuantity for the RI Fee line item vs\. DBR / DBR\-RT which overloads the UsageQuantity column with the unused hours 

### Scenario 3: Capacity Reservation<a name="scenario-3"></a>

DBR/DBR\-RT filters out Capacity Reservations related UnusedBox and UnusedDed usage type line items when covered by an RI because the RI Fee line item already covers the unused amount in the UsageQuantity and UnblendedCost fields\. Table 5 illustrates the columns and information utilized to manage unused RI costs in the DBR and DBR\-RT report\.

**Table 5 – Unused RI costs for Capacity Reservation scenario in DBR and DBR\-RT prior to June 17 2019**


| ProductName | UsageType | Operation | Availability Zone | Reserved Instance | ItemDescription | Usage Quantity | Unblended Rate | Unblended Cost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge \(744 hours purchased, 734 hours used\) | 10 | 0\.1 | 1 | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 734 | 0\.1 | 73\.4 | 

AWS CUR shows these line items as DiscountedUsage\. Table 6 illustrates the current columns and information utilized to manage unused RI costs in AWS CUR\.

**Table 6 – Unused RI costs for the Capacity Reservation scenario in AWS CUR**


| lineitem/ Productcode | UsageType | lineitem/ LineItemType | lineitem/ LineItemDescription | lineitem/ UsageAmount | lineitem/ NormalizedUsageAmount | lineitem/ UnblendedRate | lineitem/ UnblendedCost | reservation/ RecurringFeeForUsage | reservation/ AmortizedUpfrontCostForUsage | reservation/ EffectiveCost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon EC2  | HeavyUsage:c3\.8xlarge | RI Fee | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 47,616 | 0\.1 | 74\.4 |  |  |  | 
|  Amazon EC2  | USW2\-Reservation:c3\.8xlarge | Usage | USD 0\.00 per Reservation Linux/UNIX \(Amazon VPC\), c3:8xlarge Instance Hour | 744 |  | 0 | 0 |  |  |  | 
| Amazon EC2 | USW2\-BoxUsage:c3\.8xlarge | DiscountedUsage | USD 0\.00 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 644 | 47,216 | 0 | 0 | 64\.4 | 5 | 69\.4 | 
| Amazon EC2 | USW2\-UnusedBox:c3\.8xlarge | DiscountedUsage | USD 0\.0058 used Reservation Linux/UNIX \(Amazon VPC\), c3:8xlarge Instance Hour | 100 | 6,500 | 0 | 0 | 10 | 1 | 11 | 

### Scenario 4: Size Flexible Reservations<a name="scenario-4"></a>

Utilizing the DBR/DBR\-RT, you can understand your unused RI usage and costs by referring to fields UsageQuantity and UnblendedCosts for RI Fee line items\. RI Fee line items can be identified by the existence of ‘purchased hours’ information in the ItemDescription field\. Table 9 illustrates the columns and information utilized to manage unused RI costs in the DBR and DBR\-RT report\.

**Table 7 – Unused RI costs for a size flex RI scenario in DBR and DBR\-RT prior to June 17, 2019**


| ProductName | UsageType | Operation | Availability Zone | Reserved Instance | ItemDescription | Usage Quantity | Unblended Rate | Unblended Cost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge \(744 hours purchased, 644 hours used\) | 100 | 0\.1 | 10 | 
|  Amazon Elastic Compute Cloud  | HeavyUsage:c3\.8xlarge | RunInstances | us\-east\-1a | Y | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge; UsageType: BoxUsage:c3\.large | 644 | 0\.1 | 64\.4 | 

Using AWS CUR, you can understand your unused RI usage and costs by referring to fields ‘reservation/ UnusedQuantity’ and ‘reservation/ UnusedRecurringFee’ for RI Fee line items\. Table 8 illustrates the current columns and information utilized to manage unused RI costs in the AWS CUR\.

**Table 10 – Unused RI costs for a size flex RI scenario in AWS CUR**


| lineitem/ Productcode | UsageType | lineitem/ LineItemType | lineitem/ LineItemDescription | lineitem/ UsageAmount | lineitem/ NormalizedUsageAmount | lineitem/ UnblendedRate | lineitem/ UnblendedCost | reservation/ UnusedQuantity | reservation/ UnusedRecurringFee | reservation/ UnusedAmortizedUpfrontFeeForBillingPeriod | reservation/ RecurringFeeForUsage | reservation/ AmortizedUpfrontCostForUsage | reservation/ EffectiveCost | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
|  Amazon EC2  | HeavyUsage:c3\.8xlarge | RI Fee | USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge | 744 | 47,616 | 0\.1 | 74\.4 | 100 | 70\.37 | 5\.5 |  |  |  | 
|  Amazon EC2  | USW2\-BoxUsage:c3\.8xlarge | DiscountedUsage | USD 0\.00 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8large | 644 | 2,576 | 0 | 0 |  |  |  | 4\.03 | 0\.5 | 4\.53 | 

In addition to matching the current functionality supported by DBR/DBR\-RT, AWS CUR has the following advantages:
+ AWS CUR has the NormalizedUsageAmount and quantity\. The DBR / DBR\-RT do not have columns representing this\.
+ AWS CUR UsageType and Operation are not transformed for the DiscountedUsage lineitem\. The DBR / DBR\-RT replaces these values with the RI Fee line item\.
+ AWS CUR LineItemDescription is not transformed for the DiscountedUsage line item\. In DBR / DBR\-RT, which replaces with the RI Fee line item description and appends the DiscountedUsage line item Usage Type to the end of the string i\.e\. “USD 0\.10 hourly fee per Linux/UNIX \(Amazon VPC\), c3:8xlarge; UsageType: BoxUsage:c3\.large”