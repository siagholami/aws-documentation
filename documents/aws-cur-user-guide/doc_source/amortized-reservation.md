# Understanding Your Amortized Reservation Data<a name="amortized-reservation"></a>

Amortizing is when you distribute one\-time reservation costs across the billing period that is affected by that cost\. Amortizing enables you to see your costs in accrual\-based accounting as opposed to cash\-based accounting\. For example, if you pay $365 for an All Upfront RI for one year and you have a matching instance that uses that RI, that instance costs you $1 a day, amortized\.

You can see the data that Billing and Cost Management uses to calculate your amortized costs in the following Cost and Usage Reports columns\. 

**Topics**
+ [Reserved Instance Inventory](#ri-inventory)
+ [Amortization Data for the Billing Period](#amortization-billing-period)
+ [Reserved Instance Effective Costs](#ri-effective-costs)

## Reserved Instance Inventory<a name="ri-inventory"></a>

You can use the following columns to track your RI inventory\. The values for these columns appear only for RI subscription line items \(also known as `RI Fee` line items\) and not for the actual instances using the RIs\.

For more information about column descriptions and sample values, see [Reservation Details](reservation-columns.md)\.
+ reservation/UpfrontValue
+ reservation/startTime
+ reservation/endTime
+ reservation/modificationStatus

## Amortization Data for the Billing Period<a name="amortization-billing-period"></a>

You can use the following columns to understand the amortized costs of your RIs for the billing period\. The values for these columns appear only for RI subscription line items \(also known as `RI Fee` line items\) and not for the actual instances using the RIs\.

For more information about column descriptions and sample values, see [Reservation Details](reservation-columns.md)\.
+ reservation/amortizedUpfrontFeeForBillingPeriod
+ reservation/unusedQuantity
+ reservation/unusedNormalizedUnitQuantity
+ reservation/unusedRecurringFee
+ reservation/unusedAmortizedUpfrontFeeForBillingPeriod

## Reserved Instance Effective Costs<a name="ri-effective-costs"></a>

You can use the following columns to understand your effective cost at the instance level\. The values for these columns appear only for instance usage line items \(also known as `Discounted Usage boxUsage` line items\)\.

For more information about column descriptions and sample values, see [Reservation Details](reservation-columns.md)\.
+ reservation/amortizedUpfrontCostForUsage
+ reservation/recurringFeeForUsage
+ reservation/effectiveCost