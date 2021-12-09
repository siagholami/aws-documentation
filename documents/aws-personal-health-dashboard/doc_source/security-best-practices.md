# Security best practices for AWS Health<a name="security-best-practices"></a>

See the following best practices for working with AWS Health\.

## Grant AWS Health users minimum possible permissions<a name="minimum-permissions"></a>

Follow the principle of least privilege by using the minimum set of access policy permissions for your users and groups\. For example, you might allow an AWS Identity and Access Management \(IAM\) user access to the Personal Health Dashboard\. However, you might not allow that same user to enable or disable access to AWS Organizations\.

For more information, see [AWS Health identity\-based policy examples](security_iam_id-based-policy-examples.md)\.

## View the Personal Health Dashboard<a name="view-health-events"></a>

Check your Personal Health Dashboard often to identify events that might affect your account or applications\. For example, you might receive an event notification about your resources, such as an Amazon Elastic Compute Cloud \(Amazon EC2\) instance that needs to be updated\. 

For more information, see [Getting started with the AWS Personal Health Dashboard](getting-started-phd.md)\.

## Integrate AWS Health with Amazon Chime or Slack<a name="slack-chime-integration"></a>

You can integrate AWS Health with your chat tools\. This integration lets you and your team get notified about AWS Health events in real time\. For more information, see the [AWS Health Tools](https://github.com/aws/aws-health-tools) in GitHub\.

## Monitor for AWS Health events<a name="set-up-monitoring"></a>

You can integrate AWS Health with Amazon CloudWatch Events, so that you can create rules for specific events\. When CloudWatch Events detects an event that matches your rule, you are notified and can then take action\. CloudWatch Events events are Region\-specific, so you must configure this service in the Region in which your application or infrastructure resides\.

In some cases, the Region for the AWS Health event can't be determined\. If that situation occurs, the event appears in the US East \(N\. Virginia\) Region by default\. You can set up CloudWatch Events in this Region to ensure that you monitor these events\. 

For more information, see [Monitor for AWS Health events with Amazon CloudWatch Events](cloudwatch-events-health.md)\.