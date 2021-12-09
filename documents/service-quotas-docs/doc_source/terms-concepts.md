# Key Terms and Concepts in Service Quotas<a name="terms-concepts"></a>

The following terms and concepts are important for understanding Service Quotas and how it works\. In AWS, the terms *quota* and *limit* can be used interchangeably\. 

## Service Quota<a name="term_servicequota"></a>

In AWS, a service quota is the maximum number of service resources or operations that apply to an account, although some service quotas apply to a Region\. An example of an account\-based quota is the number of AWS IAM roles per account or AWS Elastic Beanstalk applications per account\. An example of a Region\-based quota is the number of AWS AppSync APIs per Region\. Check the service quota description to see if the limit is Region\-specific\.

## Adjustable Value<a name="term_adjustablequota"></a>

An adjustable value is a service quota value that can be increased\. 

## Global Quota<a name="term_globalquota"></a>

A global quota is a quota, or limit, applied at an account level\. Global quotas are available in all Regions\. You can request an increase to a global quota from any Region, and can track the status of the increase from the Region where the increase was requested\. If a quota increase, for a global quota, has been requested, you can't request an increase for the same quota from a different Region until the first request has completed\. Once the initial request has completed, the applied quota value will be visible across all Regions \(if applied quotas are available\)\.

## Default Value<a name="term_defaultvalue"></a>

A default value is the initial service quota value established by AWS\. 

## Applied Value<a name="term_appliedvalue"></a>

 An applied value is the new or latest service quota value, once the default service quota value has been increased\.

## Usage<a name="term_usage"></a>

In Service Quotas, usage is the number of resources or operations in use, for that service quota\. 

## Utilization<a name="term_utilization"></a>

In Service Quotas, utilization is the percentage of the service quota in use\. For example, if the service quota is 200 resources, and 150 resources are in use, the utilization is 75%\.