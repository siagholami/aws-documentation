# Unlimited mode for burstable performance instances<a name="burstable-performance-instances-unlimited-mode"></a>

A burstable performance instance configured as `unlimited` can sustain high CPU utilization for any period of time whenever required\. The hourly instance price automatically covers all CPU usage spikes if the average CPU utilization of the instance is at or below the baseline over a rolling 24\-hour period or the instance lifetime, whichever is shorter\.

For the vast majority of general\-purpose workloads, instances configured as `unlimited` provide ample performance without any additional charges\. If the instance runs at higher CPU utilization for a prolonged period, it can do so for a flat additional rate per vCPU\-hour\. For information about instance pricing, see [Amazon EC2 Pricing](https://aws.amazon.com/ec2/pricing/) and the section for Unlimited Mode Pricing on the [Amazon EC2 On\-Demand Pricing page](https://aws.amazon.com/ec2/pricing/on-demand/#T2.2FT3_Unlimited_Mode_Pricing)\.

If you use a `t2.micro` or `t3.micro` instance under the [AWS Free Tier](https://aws.amazon.com/free/) offer and use it in `unlimited` mode, charges might apply if your average utilization over a rolling 24\-hour period exceeds the [baseline utilization](burstable-credits-baseline-concepts.md#baseline_performance) of the instance\.

T3 and T4g instances launch as `unlimited` by default\. If the average CPU usage over a 24\-hour period exceeds the baseline, you incur charges for surplus credits\. If you launch Spot Instances as `unlimited` and plan to use them immediately and for a short duration, with no idle time for accruing CPU credits, you incur charges for surplus credits\. We recommend that you launch your Spot Instances in [standard](burstable-performance-instances-standard-mode.md) mode to avoid paying higher costs\. For more information, see [Surplus credits can incur charges](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-surplus-credits) and [Burstable performance instances](using-spot-limits.md#t3-spot-instances)\.

**Contents**
+ [Unlimited mode concepts](burstable-performance-instances-unlimited-mode-concepts.md)
  + [How Unlimited burstable performance instances work](burstable-performance-instances-unlimited-mode-concepts.md#how-burstable-performance-instances-unlimited-works)
  + [When to use unlimited mode versus fixed CPU](burstable-performance-instances-unlimited-mode-concepts.md#when-to-use-unlimited-mode)
  + [Surplus credits can incur charges](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-surplus-credits)
  + [No launch credits for T2 Unlimited instances](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-no-launch-credits)
  + [Enabling unlimited mode](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-enabling)
  + [What happens to credits when switching between Unlimited and Standard](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-switching-and-credits)
  + [Monitoring credit usage](burstable-performance-instances-unlimited-mode-concepts.md#unlimited-mode-monitoring-credit-usage)
+ [Unlimited mode examples](unlimited-mode-examples.md)
  + [Example 1: Explaining credit use with T3 Unlimited](unlimited-mode-examples.md#t3_unlimited_example)
  + [Example 2: Explaining credit use with T2 Unlimited](unlimited-mode-examples.md#t2_unlimited_example)