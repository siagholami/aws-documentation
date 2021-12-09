# Quotas for your Classic Load Balancer<a name="elb-limits"></a>

Your AWS account has default quotas, formerly referred to as limits, for each AWS service\. Unless otherwise noted, each quota is Region\-specific\. You can request increases for some quotas, and other quotas cannot be increased\.

To view the quotas for your Classic Load Balancers, open the [Service Quotas console](https://console.aws.amazon.com/servicequotas/home)\. In the navigation pane, choose **AWS services** and select **Elastic Load Balancing**\. You can also use the [describe\-account\-limits](https://docs.aws.amazon.com/cli/latest/reference/elb/describe-account-limits.html) \(AWS CLI\) command for Elastic Load Balancing\.

To request a quota increase, see [Requesting a quota increase](https://docs.aws.amazon.com/servicequotas/latest/userguide/request-quota-increase.html) in the *Service Quotas User Guide*\. If the quota is not yet available in Service Quotas, use the [Elastic Load Balancing limit increase form](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-elastic-load-balancers)\.

Your AWS account has the following quotas related to Classic Load Balancers\.
+ Load balancers per Region: 20
+ Listeners per load balancer: 100 **†**
+ Security groups per load balancer: 5
+ Registered instances per load balancer: 1,000
+ Subnets per Availability Zone per load balancer: 1 **†**

**†** These quotas cannot be increased\.