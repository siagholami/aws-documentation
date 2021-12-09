# Spot Instance considerations<a name="using-spot-limits"></a>

Spot Instance requests are subject to the following limits:

**Topics**
+ [Spot Instance request limits](#spot-limits-general)
+ [Spot Fleet limits](#spot-fleet-limitations)
+ [Burstable performance instances](#t3-spot-instances)

## Spot Instance request limits<a name="spot-limits-general"></a>

Limits on Spot Instance requests are dynamic\. When your account is new, there is an initial default limit on Spot Instance requests per Region\. This limit can increase over time\. If you submit a Spot Instance request and you receive the error `Max spot instance count exceeded`, you can request a limit increase for Spot Instance requests\. For more information about viewing your current limits and requesting limit increases, see [Amazon EC2 service quotas](ec2-resource-limits.md)\.

If you terminate Spot Instances but do not cancel the Spot Instance requests, the requests count against your dynamic Spot Instance request limit until Amazon EC2 detects the Spot Instance terminations and closes the requests\.

## Spot Fleet limits<a name="spot-fleet-limitations"></a>

The usual Amazon EC2 limits apply to instances launched by a Spot Fleet or an EC2 Fleet, such as Spot request price limits, instance limits, and volume limits\. In addition, the following limits apply:
+ The number of active Spot Fleets and EC2 Fleets per Region: 1,000\*
+ The number of Spot Instance pools \(unique combination of instance type and subnet\): 300\*
+ The size of the user data in a launch specification: 16 KB\*
+ The target capacity per Spot Fleet or EC2 Fleet: 10,000
+ The target capacity across all Spot Fleets and EC2 Fleets in a Region: 100,000
+ A Spot Fleet request or an EC2 Fleet request can't span Regions\.
+ A Spot Fleet request or an EC2 Fleet request can't span different subnets from the same Availability Zone\.

If you need more than the default limits for target capacity, complete the AWS Support Center [Create case](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-ec2-fleet) form to request a limit increase\. For **Limit type**, choose **EC2 Fleet**, choose a Region, and then choose **Target Fleet Capacity per Fleet \(in units\)** or **Target Fleet Capacity per Region \(in units\)**, or both\.

\* These are hard limits\. You cannot request a limit increase for these limits\.

## Burstable performance instances<a name="t3-spot-instances"></a>

If you plan to use your Spot Instances immediately and for a short duration, with no idle time for accruing CPU credits, we recommend that you launch your Spot Instances in [Standard mode](burstable-performance-instances-standard-mode.md) to avoid paying higher costs\.

If you launch your Spot Instances in [Unlimited mode](burstable-performance-instances-unlimited-mode.md) and burst CPU immediately, you'll spend surplus credits for bursting\. If you use the instance for a short duration, your instance doesn't have time to accrue CPU credits to pay down the surplus credits, and you are charged for the surplus credits when you terminate your instance\.

Unlimited mode is suitable for Spot Instances only if the instance runs long enough to accrue CPU credits for bursting\. Otherwise, paying for surplus credits makes burstable performance Spot Instances more expensive than using other instances\. For more information, see [When to use unlimited mode versus fixed CPU](burstable-performance-instances-unlimited-mode-concepts.md#when-to-use-unlimited-mode)\.

Launch credits are meant to provide a productive initial launch experience for T2 instances by providing sufficient compute resources to configure the instance\. Repeated launches of T2 instances to access new launch credits is not permitted\. If you require sustained CPU, you can earn credits \(by idling over some period\), use [Unlimited mode](burstable-performance-instances-unlimited-mode.md) for T2 Spot Instances, or use an instance type with dedicated CPU\.