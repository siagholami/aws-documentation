# Monitoring Your Size Flexible Reservations<a name="monitor-flexible-reservation"></a>

Amazon EC2 RIs that apply to a Region provide Availability Zone flexibility and instance size flexibility\. RIs that provide Availability Zone flexibility provide a discount on usage in any Availability Zone in the Region\. RIs that provide instance size flexibility provide a discount on usage, regardless of instance size in that family\. To understand how instance size flexibility provided by your RI is applied to your usage, refer to the **lineItem/NormalizationFactor** and **lineItem/NormalizedUsageAmount** columns\.

**Note**  
Instance size flexibility is supported only by Linux or Unix RIs with default tenancy that are assigned to a Region\.

## Example 1<a name="ri-effective-costs-ex1"></a>

You purchase one `m4.xlarge` RI in a given Region\. This `m4.xlarge` RI can be applied automatically to all `m4` instance usage in the same Region\. In the following table, AWS applied the `m4.xlarge` to two separate `m4.large` instances\.
| lineItem/ LineItemType | lineItem/ ProductCode | lineItem/ UsageStartDate | lineItem/ UsageType | lineItem/ Description | lineItem/ ResourceID | lineItem/ UsageAmount | lineItem/ Normalization Factor | lineItem/ NormalizedUsageAmount | lineItem/ UnblendedRate | lineItem/ UnblendedCost | reservation/ ReservationARN | reservation/ TotalReservedUnits | reservation/ TotalReservedNormalizedUnits | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
| RIFee | AmazonEC2 | 2016\-01\-01T00:00:00Z | HeavyUsage:m4\.large | USD 0\.0618 hourly fee per Linux/UNIX \(Amazon VPC\), m4\.xlarge instance |  |  | 0 |  |  | 46 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 744 | 5952 | 
| Discounted Usage | AmazonEC2 | 2016\-01\-01T00:00:00Z | BoxUsage:m4\.large | Linux/UNIX \(Amazon VPC\), m4\.large reserved instance applied | i\-1bd250bc | 1 | 4 | 4 | 0 | 0 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea |  |  | 
| Discounted Usage | AmazonEC2 | 2016\-01\-01T00:00:00Z | BoxUsage:m4\.large | Linux/UNIX \(Amazon VPC\), m4\.large reserved instance applied | i\-1df340ed | 1 | 4 | 4 | 0 | 0 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea |  |  | 

The two `m4.large` usage line items have different **ResourceID**s, and both received a discount benefit from the single `m4.xlarge` RI\. This is shown by matching the **reservationARN** value across the usage and recurring monthly charge line items\.

## Example 2<a name="ri-effective-costs-ex2"></a>

The following table shows an account that has subscriptions for two `m4.large` RIs, with one RI in each subscription\. In this example, the account uses a single instance of `m4.xlarge` for an hour and receives a separate discount benefit from each of the two `m4.large` RIs\.
| lineItem/ LineItemType | lineItem/ ProductCode | lineItem/ UsageStartDate | lineItem/ UsageType | lineItem/ Description | lineItem/ ResourceID | lineItem/ UsageAmount | lineItem/ Normalization Factor | lineItem/ NormalizedUsageAmount | lineItem/ UnblendedRate | lineItem/ UnblendedCost | reservation/ ReservationARN | reservation/ TotalReservedUnits | reservation/ TotalReservedNormalizedUnits | 
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | 
| RIFee | AmazonEC2 | 2016\-01\-01T00:00:00Z | HeavyUsage:m4\.large | USD 0\.0309 hourly fee per Linux/UNIX \(Amazon VPC\), m4\.large instance |  |  | 4 |  |  | 23 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 744 | 2976 | 
| RIFee | AmazonEC2 | 2016\-01\-01T00:00:00Z | HeavyUsage:m4\.large | USD 0\.0309 hourly fee per Linux/UNIX \(Amazon VPC\), m4\.large instance |  |  | 4 |  |  | 23 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea | 744 | 2976 | 
| Discounted Usage | AmazonEC2 | 2016\-01\-01T00:00:00Z | BoxUsage:m4\.xlarge | Linux/UNIX \(Amazon VPC\), m4\.large reserved instance applied | i\-1bd250bc | 0\.5 | 8 | 4 | 0 | 0 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea |  |  | 
| Discounted Usage | AmazonEC2 | 2016\-01\-01T00:00:00Z | BoxUsage:m4\.xlarge | Linux/UNIX \(Amazon VPC\), m4\.xlarge reserved instance applied | i\-1bd250bc | 0\.5 | 8 | 4 | 0 | 0 | arn:aws:ec2:us\-east\-1:572481847476:reserved\-instances/f8c204c1\-dd48\-43f1\-adb8\-f88aa61e0dea |  |  | 

The single hour of `m4.xlarge` usage is split into two lines of 0\.5 hours \(both usage lines still retain the same **ResourceID**\) because different RI subscriptions were applied to each portion of that single hour\. The **reservationARN** for each 0\.5 hour matches the corresponding RI subscription\.

For more information about RI purchase options, see [ Billing Benefits and Payment Options](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts-reserved-instances-application.html#reserved-instances-payment-options) in the *Amazon EC2 User Guide for Linux Instances*\.