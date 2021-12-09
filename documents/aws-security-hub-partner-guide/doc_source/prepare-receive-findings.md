# Preparing to receive findings from AWS Security Hub<a name="prepare-receive-findings"></a>

To receive findings from AWS Security Hub, use one of the following options:
+ Have your customers automatically send all findings to CloudWatch Events\. A customer can create specific CloudWatch event rules to send findings to specific targets, such as a SIEM or an S3 bucket\. 
+ Have your customers select specific findings or groups of findings from within the Security Hub console and then take action on them\.

For example, your customers can send findings to an SIEM, a ticketing system, a chat platform, or a remediation workflow\. This would be part of an alert triage workflow that a customer performs within Security Hub\.

These are called custom actions\. When a user takes a custom action, a CloudWatch event is created for those specific findings\. As a partner, you can leverage this capability and build CloudWatch event rules or targets for a customer to use as part of a custom action\. Note that this capability does not automatically send all findings of a particular type or class to CloudWatch Events\. This feature is for a user to take action on specific findings\.

The following blog posts outline solutions that use the integration with Security Hub and CloudWatch Events for custom actions\.
+ [How to Integrate AWS Security Hub Custom Actions with PagerDuty](http://aws.amazon.com/blogs/apn/how-to-integrate-aws-security-hub-custom-actions-with-pagerduty/)
+ [How to Enable Custom Actions in AWS Security Hub](http://aws.amazon.com/blogs/apn/how-to-enable-custom-actions-in-aws-security-hub/)
+ [How to import AWS Config rules evaluations as findings in Security Hub](http://aws.amazon.com/blogs/security/how-to-import-aws-config-rules-evaluations-findings-security-hub/)