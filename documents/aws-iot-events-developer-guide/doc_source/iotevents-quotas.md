# AWS IoT Events quotas<a name="iotevents-quotas"></a>

The following tables provide the default quotas for AWS IoT Events for an AWS account\. Unless specified, each quota is per AWS Region\. For more information, see [AWS IoT Events endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/iot-events.html) and [AWS Service Quotas](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html) in the *AWS General Reference Guide*\.

To request a service quota increase, submit a support case in the [Support center](https://console.aws.amazon.com/support/cases#/create?issueType=service-limit-increase&             limitType=service-code-iot) console\. For more information, see [Requesting a quota increase](https://docs.aws.amazon.com/servicequotas/latest/userguide/request-quota-increase.html) in the *Service Quotas User Guide*\.


****  

| Resource | Description | Limit | Adjustable? | 
| --- | --- | --- | --- | 
| Detector model definition size | The maximum size, in kilobytes, of a detector model definition\. | 512 | No | 
| Detector model versions | The maximum number of versions of a single detector model for this account\. | 500 | Yes | 
| Detector models | The maximum number of detector models for this account\. | 50 | Yes | 
| Detector models per input | The maximum number of detector models that can be associated with a single input\. | 10 | No | 
| Detectors per detector model | The maximum number of detectors that a detector model can create\. | 100,000 | Yes | 
| Inputs | The maximum number of inputs for this account\. | 50 | Yes | 
| Message size | The maximum size of a message, in kilobytes\. | 1 | Yes | 
| Messages per detector per second | The maximum number of messages that can be sent to a detector in a second\. | 10 | No | 
| State variables per detector model definition | The maximum number of state variables in a detector model definition\. | 50 | Yes | 
| Timers scheduled per detector | The maximum number of timers that a detector can schedule\. | 5 | Yes | 
| Total messages evaluated per second | The maximum number of messages evaluated per second for all detectors in this account\. | 1000 | Yes | 
| Trigger expressions | The maximum number of trigger expressions per state\. | 20 | Yes | 


| API | Quota description | Adjustable? | 
| --- | --- | --- | 
| BatchPutMessage | 1000 transactions per second | Yes | 

**Note**  
All names for detector models and inputs must be unique within an account\.
You can't change names for detector models and inputs after they're created\.