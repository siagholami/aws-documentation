# AWS Cloud Map quotas<a name="cloud-map-limits"></a>

AWS Cloud Map entities are subject to the following quotas\. Each quota listed applies to each AWS Region where you create AWS Cloud Map resources\. For example, each AWS account can create 50 namespaces in each Region\.


| Resource | Default | 
| --- | --- | 
|  Namespaces  |  50 per AWS Region **\*** [Request a higher quota](https://console.aws.amazon.com/support/home?region=us-west-2#/case/create?issueType=service-limit-increase)  | 
|  Service instances  |  1,000 per service 2,000 per namespace [Request a higher quota](https://console.aws.amazon.com/support/home?region=us-west-2#/case/create?issueType=service-limit-increase)  | 
|  Custom attributes  |  30 per service instance  | 

**\*** When you create a namespace, we automatically create an Amazon Route 53 hosted zone\. This hosted zone counts against the quota on the number of hosted zones that you can create with an AWS account\. For more information, see [Quotas on hosted zones](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/DNSLimitations.html#limits-api-entities-hosted-zones) in the *Amazon Route 53 Developer Guide*\.