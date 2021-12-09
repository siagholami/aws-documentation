# Using IAM policies to allow access to organizational view<a name="organizational-view-iam-policies"></a>

You can use the following AWS Identity and Access Management \(IAM\) policies to allow users or roles in your account access to organizational view in AWS Trusted Advisor\.

**Example : **Full access to organizational view****  
The following policy allows full access to the organizational view feature\. A user with these permissions can do the following:  
+ Enable organizational view\.
+ Create, view, and download reports\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ReadStatement",
            "Effect": "Allow",
            "Action": [
                "organizations:ListAccountsForParent",
                "organizations:ListAccounts",
                "organizations:DescribeOrganization",
                "organizations:ListOrganizationalUnitsForParent",
                "organizations:ListAWSServiceAccessForOrganization",
                "trustedadvisor:DescribeAccount",
                "trustedadvisor:DescribeChecks",
                "trustedadvisor:DescribeAccountAccess",
                "trustedadvisor:DescribeOrganization",
                "trustedadvisor:DescribeReports",
                "trustedadvisor:DescribeServiceMetadata",
                "trustedadvisor:DescribeOrganizationAccounts"
            ],
            "Resource": "*"
        },
        {
            "Sid": "MutatingStatement",
            "Effect": "Allow",
            "Action": [
                "trustedadvisor:GenerateReport"
            ],
            "Resource": "*"
        },
        {
            "Sid": "OnboardingStatement1",
            "Effect": "Allow",
            "Action": [
                "organizations:EnableAWSServiceAccess",
                "trustedadvisor:SetOrganizationAccess"
            ],
            "Resource": "*"
        },
        {
            "Sid": "OnboardingStatement2",
            "Effect": "Allow",
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "arn:aws:iam::*:role/aws-service-role/reporting.trustedadvisor.amazonaws.com/AWSServiceRoleForTrustedAdvisorReporting"
        }
    ]
}
```

**Example : Read access to organizational view**  
The following policy allows read\-only access to organizational view for Trusted Advisor\. A user with these permissions can only view and download existing reports\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ReadStatement",
            "Effect": "Allow",
            "Action": [
                "organizations:ListAccountsForParent",
                "organizations:ListAccounts",
                "organizations:DescribeOrganization",
                "organizations:ListOrganizationalUnitsForParent",
                "organizations:ListAWSServiceAccessForOrganization",
                "trustedadvisor:DescribeAccount",
                "trustedadvisor:DescribeChecks",
                "trustedadvisor:DescribeAccountAccess",
                "trustedadvisor:DescribeOrganization",
                "trustedadvisor:DescribeReports"
            ],
            "Resource": "*"
        }
    ]
}
```
You can also create your own IAM policy\. For more information, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.htmlorgs_integrate_services.html) in the *IAM User Guide*\.

**Note**  
If you enabled AWS CloudTrail in your account, the following roles can appear in your log entries:  
`AWSServiceRoleForTrustedAdvisorReporting` – The service\-linked role \(SLR\) that Trusted Advisor uses to access accounts in your organization\.
`AWSServiceRoleForTrustedAdvisor` – The service\-linked role that Trusted Advisor uses to access services in your organization\.
For more information about SLRs, see [Using service\-linked roles for Trusted Advisor](using-service-linked-roles-ta.md)\.