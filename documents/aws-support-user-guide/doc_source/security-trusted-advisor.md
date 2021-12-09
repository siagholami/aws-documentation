# Manage access for AWS Trusted Advisor<a name="security-trusted-advisor"></a>

You can access AWS Trusted Advisor from the AWS Management Console\. All AWS accounts have access to a select core [Trusted Advisor checks](http://aws.amazon.com/premiumsupport/faqs/#TaFree)\. If you have a Business or Enterprise support plan, you can access all [Trusted Advisor checks](http://aws.amazon.com/premiumsupport/technology/trusted-advisor/best-practice-checklist/)\.

You can use AWS Identity and Access Management \(IAM\) to control access to Trusted Advisor\. 

**Topics**
+ [Permissions for the Trusted Advisor console](#using-the-trusted-advisor-console)
+ [Trusted Advisor actions](#trusted-advisor-operations)
+ [IAM policy examples](#iam-policy-examples-trusted-advisor)
+ [See also](#see-also-security-trusted-advisor)

## Permissions for the Trusted Advisor console<a name="using-the-trusted-advisor-console"></a>

You must have a minimum set of permissions to access the Trusted Advisor console\. These permissions must allow you to list and view details about the Trusted Advisor resources in your AWS account\.

You can use the following options to control access to Trusted Advisor:
+ Use the tag filter feature of the Trusted Advisor console\. The user or role must have permissions associated with the tags\. 

  You can use AWS managed policies or custom policies to assign permissions by tags\. For more information, see [Obtaining Permissions for Tagging](https://docs.aws.amazon.com/awsconsolehelpdocs/latest/gsg/obtaining-permissions-for-tagging.html)\.
+ Create an IAM policy with the `trustedadvisor` namespace, so that you can specify permissions to actions and resources\. 

When you create a policy, you can specify the namespace of the service to allow or deny an action\. The namespace for Trusted Advisor is `trustedadvisor.`

**Important**  
You can't use the `trustedadvisor` namespace to allow or deny Trusted Advisor API operations in the AWS Support API\. The namespace for AWS Support is `support`\. 

## Trusted Advisor actions<a name="trusted-advisor-operations"></a>

You can perform the following Trusted Advisor actions in the console\. You can also specify these Trusted Advisor actions in an IAM policy to allow or deny specific actions\. 


| Action | Description | 
| --- | --- | 
|  `DescribeAccount`  |  Grants permission to view the AWS Support plan and various Trusted Advisor preferences\.  | 
|  `DescribeAccountAccess`  |  Grants permission to view if the AWS account has enabled or disabled Trusted Advisor\.  | 
|  `DescribeCheckItems`  |  Grants permission to view details for the check items\.  | 
|  `DescribeCheckRefreshStatuses`  |  Grants permission to view the refresh statuses for Trusted Advisor checks\.  | 
|  `DescribeCheckSummaries`  |  Grants permission to view Trusted Advisor check summaries\.  | 
|  `DescribeChecks`  |  Grants permission to view details for Trusted Advisor checks\.  | 
|   `DescribeNotificationPreferences`   |  Grants permission to view the notification preferences for the AWS account\.  | 
|   `ExcludeCheckItems`   |  Grants permission to exclude recommendations for Trusted Advisor checks\.  | 
|   `IncludeCheckItems`   |  Grants permission to include recommendations for Trusted Advisor checks\.  | 
|  `RefreshCheck`  |  Grants permission to refresh a Trusted Advisor check\.  | 
|  `SetAccountAccess`  |  Grants permission to enable or disable Trusted Advisor for the account\.  | 
|   `UpdateNotificationPreferences`   |  Grants permission to update notification preferences for Trusted Advisor\.  | 

The following Trusted Advisor actions are for the organizational view feature\. For more information, see [Organizational view for AWS Trusted Advisor](organizational-view.md)\.


| Action | Description | 
| --- | --- | 
|  `DescribeOrganization`  |  Grants permission to view if the AWS account meets the requirements to enable the organizational view feature\.  | 
|  `DescribeOrganizationAccounts`  |  Grants permission to view the linked AWS accounts that are in the organization\.  | 
|  `DescribeReports`  |  Grants permission to view details for organizational view reports, such as the report name, runtime, date created, status, and format\.  | 
|  `DescribeServiceMetadata`  |  Grants permission to view information about organizational view reports, such as the AWS Regions, check categories, check names, and resource statuses\.  | 
|  `GenerateReport`  |  Grants permission to create a report for Trusted Advisor checks in your organization\.  | 
|  `SetOrganizationAccess`  |  Grants permission to enable the organizational view feature for Trusted Advisor\.  | 

## IAM policy examples<a name="iam-policy-examples-trusted-advisor"></a>

The following policies show you how to allow and deny access to Trusted Advisor\.

**Topics**
+ [Full access to Trusted Advisor](#full-access-trusted-advisor)
+ [Read\-only access to Trusted Advisor](#read-only-access-trusted-advisor)
+ [Deny access to Trusted Advisor](#no-access-trusted-advisor)
+ [Allow and deny specific actions](#allow-specific-actions-trusted-advisor)
+ [Control access to the AWS Support API operations for Trusted Advisor](#control-access-to-trusted-advisor-deny-support)

### Full access to Trusted Advisor<a name="full-access-trusted-advisor"></a>

The following policy allows users to view and take all actions on all Trusted Advisor checks\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "trustedadvisor:*",
            "Resource": "*"
        }
    ]
}
```

### Read\-only access to Trusted Advisor<a name="read-only-access-trusted-advisor"></a>

The following policy allows users read\-only access to Trusted Advisor\. Users can't make changes, such as refresh checks or change notification preferences\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "trustedadvisor:Describe*",
            "Resource": "*"
        }
    ]
}
```

### Deny access to Trusted Advisor<a name="no-access-trusted-advisor"></a>

The following policy doesn't allow users to view or take actions for Trusted Advisor checks\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Action": "trustedadvisor:*",
            "Resource": "*"
        }
    ]
}
```

### Allow and deny specific actions<a name="allow-specific-actions-trusted-advisor"></a>

The following policy allows users to view all Trusted Advisor checks, but doesn't allow them to refresh any checks\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "trustedadvisor:*",
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": "trustedadvisor:RefreshCheck",
            "Resource": "*"
        }
    ]
}
```

### Control access to the AWS Support API operations for Trusted Advisor<a name="control-access-to-trusted-advisor-deny-support"></a>

In the AWS Management Console, a separate `trustedadvisor` IAM namespace controls access to Trusted Advisor\. You can't use the `trustedadvisor` namespace to allow or deny Trusted Advisor API operations in the AWS Support API\. Instead, you use the `support` IAM namespace\. You must have permissions to the AWS Support API to call Trusted Advisor programmatically\.

 For example, if you want to call the [RefreshTrustedAdvisorCheck](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_RefreshTrustedAdvisorCheck.html) operation, you must have permissions to this action in the policy\.

The following policy allows users only access to the AWS Support API operations for Trusted Advisor, but not the rest of the AWS Support API operations\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "support:DescribeTrustedAdvisorCheckRefreshStatuses",
                "support:DescribeTrustedAdvisorCheckResult",
                "support:DescribeTrustedAdvisorChecks",
                "support:DescribeTrustedAdvisorCheckSummaries",
                "support:RefreshTrustedAdvisorCheck"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "support:AddAttachmentsToSet",
                "support:AddCommunicationToCase",
                "support:CreateCase",
                "support:DescribeAttachment",
                "support:DescribeCases",
                "support:DescribeCommunications",
                "support:DescribeServices",
                "support:DescribeSeverityLevels",
                "support:ResolveCase"
            ],
            "Resource": "*"
        }
    ]
}
```

For more information about how IAM works with AWS Support and Trusted Advisor, see [Actions](security_iam_service-with-iam.md#security_iam_service-with-iam-id-based-policies-actions)\.

## See also<a name="see-also-security-trusted-advisor"></a>

For more information about Trusted Advisor permissions, see the following resources: 
+ [Actions defined by AWS Trusted Advisor](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awstrustedadvisor.html#awstrustedadvisor-actions-as-permissions) in the *IAM User Guide*\.
+ [Controlling Access to the Trusted Advisor Console](http://aws.amazon.com/premiumsupport/ta-iam/)