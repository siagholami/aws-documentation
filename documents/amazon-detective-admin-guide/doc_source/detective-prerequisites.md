# Amazon Detective prerequisites and recommendations<a name="detective-prerequisites"></a>

Before you can enable Amazon Detective, you must have an AWS account\. If you don't have an account, use this procedure to create one\.

**To sign up for AWS**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

You also need to be aware of the following requirements and recommendations\.

**Topics**
+ [Supported AWS Command Line Interface version](#aws-cli-version)
+ [Account must have Amazon GuardDuty enabled](#prereq-guardduty-enabled)
+ [Account data volume must be within the Detective quota](#prereq-data-volume-quota)
+ [Recommended alignment with GuardDuty and AWS Security Hub](#recommended-service-alignment)
+ [Required IAM policy for Detective](#detective-setup-add-iam-policy)
+ [Enabling the display of account names](#detective-enable-account-name-display)
+ [Recommended update to the GuardDuty CloudWatch notification frequency](#recommended-guardduty-config)

## Supported AWS Command Line Interface version<a name="aws-cli-version"></a>

To use the AWS CLI to perform Detective tasks, the minimum required version is 1\.16\.303\.

## Account must have Amazon GuardDuty enabled<a name="prereq-guardduty-enabled"></a>

When you try to enable Detective, Detective checks whether GuardDuty has been enabled for your account for at least 48 hours\.

If you are not a GuardDuty customer, or have been a GuardDuty customer for less than 48 hours, you cannot enable Detective\. You must either enable GuardDuty or wait for 48 hours\. This allows GuardDuty to assess the data volume that your account produces\.

## Account data volume must be within the Detective quota<a name="prereq-data-volume-quota"></a>

The volume of data flowing into a behavior graph must be less than the maximum allowed by Detective\.

When you try to enable Detective, if the data volume for your account is too large, you cannot enable Detective\. The Detective console displays a notification to indicate that data volume is too large\.

## Recommended alignment with GuardDuty and AWS Security Hub<a name="recommended-service-alignment"></a>

If you are enrolled in GuardDuty and AWS Security Hub, we recommend that your account be a master account for those services\. If the master accounts are the same for all three services, then the following integration points work seamlessly\.
+ In GuardDuty or Security Hub, when viewing details for a GuardDuty finding, you can pivot from the finding details to the Detective finding profile\.
+ In Detective, when investigating a GuardDuty finding, you can choose the option to archive that finding\.

If you have different master accounts for GuardDuty and Security Hub, we recommend that you align the master accounts based on the service you use more frequently\.
+ If you use GuardDuty more frequently, then enable Detective using the GuardDuty master account\.
+ If you use Security Hub more frequently, then enable Detective using the Security Hub master account\.

If you cannot use the same master accounts across all of the services, then after you enable Detective, you can optionally create a cross\-account role\. This role grants the Detective master account access to other accounts\.

For information on how IAM supports this type of role, see [Providing access to an IAM user in another AWS account that you own](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_common-scenarios_aws-accounts.html) in the *IAM User Guide*\.

## Required IAM policy for Detective<a name="detective-setup-add-iam-policy"></a>

Before you can enable Detective, if you are not an administrator, then you must attach the following permissions policy to your IAM principal\. The principal can be an existing user or role that you are already using, or you can create a new user or role to use for Detective\.

This policy allows you to perform all master account actions in Detective\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "detective:Get*",
        "detective:CreateGraph",
        "detective:CreateMembers",
        "detective:DeleteGraph",
        "detective:DeleteMembers",
        "detective:ListGraphs",
        "detective:ListMembers",
        "detective:SearchGraph",
        "detective:StartMonitoringMember",
        "guardduty:ArchiveFindings",
        "guardduty:ListDetectors"
      ],
      "Resource": "*"
    }
  ]
}
```

## Enabling the display of account names<a name="detective-enable-account-name-display"></a>

By default, the Detective console displays AWS account IDs\.

If your account belongs to an organization in AWS Organizations, then Detective can also display account names\. Detective retrieves the account names from Organizations\.

To have Detective display account names, your account must belong to the organization\.

You also must have the following permissions:
+ `organizations:ListAccounts`
+ `organizations:DescribeOrganization`

## Recommended update to the GuardDuty CloudWatch notification frequency<a name="recommended-guardduty-config"></a>

In GuardDuty, detectors are configured with an Amazon CloudWatch notification frequency for reporting subsequent occurrences of a finding\. This includes sending notifications to Detective\.

By default, the frequency is six hours\. This means that even if a finding recurs many times, the new occurrences are not reflected in Detective until up to six hours later\.

To reduce the amount of time it takes for Detective to receive these updates, we recommend that the GuardDuty master account changes the setting on their detectors to 15 minutes\. Note that changing the configuration has no effect on the cost of using GuardDuty\.

For information on setting the notification frequency, see [Monitoring GuardDuty Findings with Amazon CloudWatch Events](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_findings_cloudwatch.html) in the Amazon GuardDuty User Guide\.