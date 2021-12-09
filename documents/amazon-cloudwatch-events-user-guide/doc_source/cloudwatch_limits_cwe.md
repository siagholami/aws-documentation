# CloudWatch Events Limits<a name="cloudwatch_limits_cwe"></a>

CloudWatch Events has the following limits:


| Resource | Default Limit | 
| --- | --- | 
|  API requests  |  Up to 50 requests per second for all CloudWatch Events API operations except [PutEvents](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_PutEvents.html)\. PutEvents is limited to 400 requests per second by default\.  | 
|  Default event bus  |  There is no limit on the rate of events that can be received from AWS services or other AWS accounts\. If you send custom events to your event bus using the `PutEvents` API, the `PutEvents` API limits apply\. Any events that are sent on to the targets of the rules in your account count against your invocations limit\.  The policy size of the default event bus is limited to 10240 characters\. This policy size increases each time you grant access to another account\. You can see your current policy and its size by using the `DescribeEventBus` API\. You can [request a limit increase](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudwatch-events)\. For instructions, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\.   | 
|  Event pattern  |  2048 characters maximum\.  | 
|  Invocations  |  An invocation is an event matching a rule and being sent on to the rule’s targets\. The limit is 750 per second \(after 750 invocations, the invocations are throttled; that is, they still happen but they are delayed\)\. If the invocation of a target fails due to a problem with the target service, account throttling, etc\., new attempts are made for up to 24 hours for a specific invocation\. If you are receiving events from another account, each of those events that matches a rule in your account and is sent on to the rule’s targets counts against your account’s limit of 750 invocations per second\. You can [request a limit increase](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudwatch-events)\. For instructions, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\.  | 
|  [ListRuleNamesByTarget](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_ListRuleNamesByTarget.html)  |  Up to 100 results per page for requests\.  | 
|  [ListRules](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_ListRules.html)  |  Up to 100 results per page for requests\.  | 
|  [ListTargetsByRule](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_ListTargetsByRule.html)  |  Up to 100 results per page for requests\.  | 
|  [PutEvents](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_PutEvents.html)  |  10 entries per request and 400 requests per second\. Each request can be up to 256 KB in size\. You can [request a limit increase](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudwatch-events)\. For instructions, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\.  | 
|  [PutTargets](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_PutTargets.html)  |  10 entries per request\.  | 
|  [RemoveTargets](https://docs.aws.amazon.com/AmazonCloudWatchEvents/latest/APIReference/API_RemoveTargets.html)  |  10 entries per request\.  | 
|  Rules  |  100 per region per account\. You can [request a limit increase](https://console.aws.amazon.com/support/home#/case/create?issueType=service-limit-increase&limitType=service-code-cloudwatch-events)\. For instructions, see [AWS Service Limits](https://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html)\. Before requesting a limit increase, examine your rules\. You may have multiple rules each matching to very specific events\. Consider broadening their scope by using fewer identifiers in your [Event Patterns in CloudWatch Events](CloudWatchEventsandEventPatterns.md)\. In addition, a rule can invoke several targets each time it matches an event\. Consider adding more targets to your rules\.  | 
| Systems Manager Run Command target | 1 target key and 1 target value Systems Manager Run Command does not currently support multiple target values\.  | 
|  Targets  |  5 per rule\.  | 