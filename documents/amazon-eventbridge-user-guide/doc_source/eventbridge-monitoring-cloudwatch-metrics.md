# Monitoring Usage with CloudWatch Metrics<a name="eventbridge-monitoring-cloudwatch-metrics"></a>

EventBridge sends metrics to Amazon CloudWatch every minute\.

## EventBridge Metrics<a name="eventbridge-metrics"></a>

The `AWS/Events` namespace includes the following metrics\.

 All of these metrics use Count as the unit, so Sum and SampleCount are the most useful statistics\.


| Metric | Description | 
| --- | --- | 
|  `DeadLetterInvocations`  |  Measures the number of times a rule’s target is not invoked in response to an event\. This includes invocations that would result in triggering the same rule again, causing an infinite loop\. Valid Dimensions: RuleName Units: Count  | 
|  `Invocations`  |  Measures the number of times a target is invoked for a rule in response to an event\. This includes successful and failed invocations, but does not include throttled or retried attempts until they fail permanently\. It does not include DeadLetterInvocations\.  EventBridge only sends this metric to CloudWatch if it has a non\-zero value\.  Valid Dimensions: RuleName Units: Count  | 
|  `FailedInvocations`  |  Measures the number of invocations that failed permanently\. This does not include invocations that are retried, or that succeeded after a retry attempt\. It also does not count failed invocations that are counted in DeadLetterInvocations\. Valid Dimensions: RuleName Units: Count  | 
|  `TriggeredRules`  |  Measures the number of triggered rules that matched with any event\. Valid Dimensions: RuleName Units: Count  | 
|  `MatchedEvents`  |  Measures the number of events that matched with any rule\. Valid Dimensions: None Units: Count  | 
|  `ThrottledRules`  |  Measures the number of triggered rules that are being throttled\. Valid Dimensions: RuleName Units: Count  | 

## Dimensions for EventBridge Metrics<a name="eventbridge-metrics-dimensions"></a>

EventBridge metrics have one dimension, which is listed below\.


|  Dimension  |  Description  | 
| --- | --- | 
|  RuleName  |  Filters the available metrics by rule name\.  | 