# AWS IoT Analytics quotas<a name="limits"></a>

The following tables provide the default quotas for AWS IoT Analytics for an AWS account\. Unless specified, each quota is per AWS Region\. For more information, see [AWS IoT Analytics endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-analytics.html) and [AWS service quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *AWS General Reference Guide*\.

To request a service quota increase, submit a support case in the [Support center](https://console.aws.amazon.com/support/cases#/create?issueType=service-limit-increase&limitType=service-code-iot) console\. For more information, see [Requesting a quota increase](https://docs.aws.amazon.com/servicequotas/latest/userguide/request-quota-increase.html) in the *Service Quotas User Guide*\.

[\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/iotanalytics/latest/userguide/limits.html)


| Resource | Quota description | Adjustable? | 
| --- | --- | --- | 
|  Channel  |  50 per account  |  Yes  | 
|  Data store  |  25 per account  |  Yes  | 
|  Pipeline  |  100 per account  |  Yes  | 
|  Activities  |  25 per pipeline  |  No  | 
|  Dataset  |  100 per account  |  Yes  | 
|  Minimum SQL data set refresh interval  |  1 minute  |  No  | 
|  Minimum container data set refresh interval  |  15 minutes  |  Yes  | 
|  Concurrent data set content generation  |  2 data sets simultaneously  |  No  | 
|  Container data sets that can be triggered from a single SQL data set  |  10  |  No  | 
|  Concurrent container data set runs  |  20  |  No  | 