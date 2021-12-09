# Amazon Pinpoint Metrics That Are Exported to CloudWatch<a name="monitoring-metrics"></a>

The following topics describe the metrics that Amazon Pinpoint exports to CloudWatch\.

**Topics**
+ [Metrics Related to Message Delivery](#monitoring-metrics-delivery)
+ [Metrics Related to Endpoints](#monitoring-metrics-endpoints)
+ [Metrics Related to Import Jobs](#monitoring-metrics-import-jobs)
+ [Metrics Related to Events](#monitoring-metrics-events)

## Metrics Related to Message Delivery<a name="monitoring-metrics-delivery"></a>


****  

| Metric | Description | 
| --- | --- | 
|  `DirectSendMessagePermanentFailure`  |  The number of direct messages that weren't sent because of a permanent issue\.  This type of issue usually occurs when an endpoint token is expired or invalid\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `DirectSendMessageTemporaryFailure`  |  The number of direct messages that failed to send because of a temporary issue\. This type of issue usually indicates that an internal issue with the Amazon Pinpoint service prevented the message from being sent\. When this type of issue occurs, Amazon Pinpoint doesn't attempt to redeliver the message\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `CampaignSendMessagePermanentFailure`  |  The number of campaign messages that weren't sent because of a permanent issue\.  This type of issue usually occurs when an endpoint token is expired or invalid\.  Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `CampaignSendMessageTemporaryFailure`  |  The number of campaign messages that weren't sent because of a temporary issue\. This type of issue usually indicates that an internal issue with the Amazon Pinpoint service prevented the message from being sent\. When this type of issue occurs, Amazon Pinpoint doesn't attempt to redeliver the message\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `DirectSendMessageThrottled`  |  The number of direct messages that weren't sent because your account's ability to send messages was throttled\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `CampaignSendMessageThrottled`  |  The number of campaign messages that weren't sent because your account's ability to send messages was throttled\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 
|  `CampaignSendMessageLatency`  |  The amount of time, in seconds, that passed between the time when the campaign started running and the time when it finished running\. Units: *Count* Dimensions: ApplicationId, ChannelType  | 

## Metrics Related to Endpoints<a name="monitoring-metrics-endpoints"></a>


****  

| Metric | Description | 
| --- | --- | 
|  `EndpointRegistrationFailure`  |  The number of endpoint registrations submitted through an AWS SDK or the Amazon Pinpoint API that couldn't be imported\.  This type of issue usually occurs when an incoming endpoint record is invalid\. Units: *Count* Dimensions: ApplicationId  | 

## Metrics Related to Import Jobs<a name="monitoring-metrics-import-jobs"></a>


****  

| Metric | Description | 
| --- | --- | 
|  `ImportedEndpointFailure`  |  The number of endpoints in an import job that couldn't be imported because they were invalid\. Units: *Count* Dimensions: ApplicationId  | 
|  `ImportJobFailure`  |  The number of import jobs that couldn't be completed for any reason\. Units: *Count* Dimensions: ApplicationId  | 
|  `ImportJobDuration`  |  The amount of time, in seconds, that elapsed between the beginning and the end of each import job\. Units: *Count* Dimensions: ApplicationId  | 

## Metrics Related to Events<a name="monitoring-metrics-events"></a>


****  

| Metric | Description | 
| --- | --- | 
|  `TotalEvents`  |  The total number of events that Amazon Pinpoint recorded\. This metric includes events that were recorded by AWS SDKs or by the Amazon Pinpoint API\. Units: *Count* Dimensions: ApplicationId  | 
|  `ExportedEvents`  |  The total number of events that were successfully written to the event stream for exporting\. Units: *Count* Dimensions: ApplicationId  | 
|  `ExportEventErrors`  |  The total number of errors that occurred after writing to the event stream\. These errors can include issues that aren't related to Amazon Pinpoint\.  For example, this error could occur when the volume of events that you stream to Kinesis Data Firehose exceeds your provisioned throughput\. Units: *Count* Dimensions: ApplicationId, ErrorCode  | 