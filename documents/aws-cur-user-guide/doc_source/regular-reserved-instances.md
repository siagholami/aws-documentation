# Understanding Your Reservation Line Items<a name="regular-reserved-instances"></a>

RIs provide you a significant discount compared to On\-Demand Instance pricing\. RIs aren't physical instances\. They're a billing discount applied to the use of On\-Demand Instances in your account\. These On\-Demand Instances must match certain attributes to benefit from the billing discount\. 

**Topics**
+ [Upfront Fee](#upfront-fee)
+ [Recurring Monthly RI Fee](#recurring-monthly)
+ [RI Discount Benefits](#discount-benefits)

## Upfront Fee<a name="upfront-fee"></a>

The **Fee** line item is added to your bill when you purchase an `All Upfront` or `Partial Upfront` RI\.

The following table shows how this one\-time fee appears in AWS CUR \(some columns were omitted for clarity\)\.
| lineItem/ LineItemType | lineItem/ ProductCode | lineItem/ UsageStartDate | lineItem/ Description | lineItem/ UnblendedCost | reservation/ ReservationARN | 
| --- | --- | --- | --- | --- | --- | 
| Fee | AmazonEC2 | 2016\-01\-01T00:00:00Z | Sign up charge for subscription: 363836886, planId: 1026576 | 68 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 

## Recurring Monthly RI Fee<a name="recurring-monthly"></a>

The **RI Fee** line item describes the recurring monthly charges that are associated RIs applied that month\. The **RI Fee** initially is added to your bill on the day of purchase and on the first day of each billing period thereafter\.

The **RI Fee** is calculated by multiplying your discounted hourly rate and the number of hours in the month\.

The following table shows how the recurring monthly charges appear in the report\.
| lineItem/ LineItemType | lineItem/ ProductCode | lineItem/ UsageStartDate | lineItem/ UsageType | lineItem/ Description | lineItem/ Normalization Factor | lineItem/ UnblendedCost | reservation/ AvailabilityZone | reservation/ ReservationARN | reservation/ TotalReserved Units | reservation/ TotalReserved NormalizedUnits | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
| RI fee | AmazonEC2 | 2016\-01\-01T00:00:00Z | HeavyUsage: m4\.large | USD 0\.0309 hourly fee per Linux/UNIX \(Amazon VPC\), m4\.large instance | 4 | 23 |  | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 744 | 2976 | 

**Note**  
Recurring monthly charges are recorded differently for RIs that have an Availability Zone or Region scope\. For RIs that have an Availability Zone scope, the corresponding Availability Zone is shown in the **reservation/AvailabilityZone** column\. For RIs that have a Region scope, the **reservation/AvailabilityZone** column is empty\. RIs with a Region scope have values for the **lineitem/NormalizationFactor** and **reservation/TotalReservedNormalizedUnits** columns that show the instance size\.

## RI Discount Benefits<a name="discount-benefits"></a>

The **Discounted Usage** line item describes the instance usage that received a matching RI discount benefit, and is added to your bill when you have usage that matches one of your RIs\. AWS calculates RI discount benefits based on matching usage: for example, the use of an instance that matches the instance reservation\. If you have matching usage, the cost associated with the usage line item is always zero because the charges associated with RIs are already accounted for in the two other line items \(the upfront fee and the recurring monthly charges\)\.

The following table shows an example of usage that received an RI discount benefit\.
| lineItem/ LineItemType | lineItem/ ProductCode | lineItem/ UsageStartDate | lineItem/ UsageType | lineItem/ Description | lineItem/ ResourceID | lineItem/ AvailabilityZone | lineItem/ Normalization Factor | lineItem/ NormalizedUsageAmount | lineItem/ UnblendedRate | lineItem/ UnblendedCost | reservation/ ReservationARN | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
| Discounted Usage | AmazonEC2 | 2016\-01\-01T00:00:00Z | BoxUsage:m4\.large | Linux/UNIX \(Amazon VPC\), m4\.large reserved instance applied | i\-1bd250bc | us\-east\-1b | 4 | 4 | 0 | 0 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 

**Note**  
The value for **UsageAmount** in the Amazon EC2 **DiscountedUsage** line is the actual number of hours used\. The value for **NormalizedUsageAmount** is the value for **UsageAmount** multiplied by the value for **NormalizationFactor**\. The value for **NormalizationFactor** is determined by the instance size\. When an RI benefit discount is applied to a matching line item of usage, the Amazon Resource Name \(ARN\) value in the **reservation/ReservationARN** column for the initial upfront fees and recurring monthly charges matches the ARN value in the discounted usage line items\.   
For more information about mapping instance size to normalization factor, see [ Modifying the Instance Size of Your Reservations](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ri-modification-instancemove.html) in the *Amazon EC2 User Guide for Linux Instances*\.