# Enabling a member account that is Accepted \(Not enabled\)<a name="graph-master-unblock-account"></a>

After a member account accepts an invitation, Amazon Detective checks whether it can enable the member account\. If Detective cannot enable the member account, then it sets the member account status to **Accepted \(Not enabled\)**\. This can happen for one of the following reasons\.
+ The member account has not been an Amazon GuardDuty customer for at least 48 hours\.
+ The member account data would cause the behavior graph data rate to exceed the quota\.

Member accounts that are **Accepted \(Not enabled\)** do not contribute data to the behavior graph\.

You can try to enable **Accepted \(Not enabled\)** member accounts\. For example, if a member account was not a GuardDuty customer, you can try again 48 hours after the member account enables GuardDuty\.

## Enabling a member account that is Accepted \(Not enabled\) \(Console\)<a name="unblock-account-console"></a>

On the member account list, the **Manage** menu includes an option to enable selected member accounts that are **Accepted \(Not enabled\)\.**

**To enable a member account that is Accepted \(Not enabled\)**

1. Open the [Detective console](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, choose **Account management**\.

1. Under **My member accounts**, select the check box for each member account to enable\.

   You can only enable member accounts that have a status of **Accepted \(Not enabled\)**\.

1. Choose **Manage accounts**, then choose **Enable**\.

Detective determines whether the member account can be enabled\. If the member account can be enabled, the status changes to **Accepted \(Enabled\)**\.

## Enabling a member account that is Accepted \(Not enabled\) \(Detective API, AWS CLI\)<a name="unblock-account-api"></a>

You can use an API call or the AWS Command Line Interface to enable a single member account that is **Accepted \(Not enabled\)**\.

**To enable a member account that is Accepted \(Not enabled\)**
+ Detective API: Use the [https://docs.aws.amazon.com/detective/latest/APIReference/API-StartMonitoringMember.html](https://docs.aws.amazon.com/detective/latest/APIReference/API-StartMonitoringMember.html) API operation\. You must provide the behavior graph ARN\. To identify the member account, use the AWS account identifier\.
+ AWS CLI: At the command line, run the `start-monitoring-member` command:

  ```
  start-monitoring-member --graph-arn <behavior graph ARN> --account-id <AWS account ID>
  ```

  For example:

  ```
  start-monitoring-member --graph-arn arn:aws:detective:us-east-1:111122223333:graph:123412341234 --account-id 444455556666
  ```