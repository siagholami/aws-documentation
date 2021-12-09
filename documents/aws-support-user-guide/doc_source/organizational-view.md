# Organizational view for AWS Trusted Advisor<a name="organizational-view"></a>

Organizational view lets you view Trusted Advisor checks for all accounts in your [AWS Organizations](http://aws.amazon.com/organizations/)\. After you enable this feature, you can create reports to aggregate the check results for all linked accounts in your organization\. The report includes a summary of check results and information about affected resources for each account\. For example, you can use the reports to identify which accounts in your organization are using AWS Identity and Access Management \(IAM\) with the IAM Use check or whether you have recommended actions for Amazon Simple Storage Service \(Amazon S3\) buckets with the Amazon S3 Bucket Permissions check\.

**Topics**
+ [Prerequisites](#prerequisites-organizational-view)
+ [Enable organizational view](#enable-organizational-view)
+ [Refresh Trusted Advisor checks](#refresh-trusted-advisor-checks)
+ [Create organizational view reports](#create-organizational-view-reports)
+ [View the report summary](#view-organizational-reports)
+ [Download an organizational view report](#download-organizational-view-reports)
+ [Disable organizational view](#disable-organizational-view)
+ [Using IAM policies to allow access to organizational view](organizational-view-iam-policies.md)
+ [Using other AWS services to view Trusted Advisor reports](use-other-aws-services-with-trusted-advisor-reports.md)

## Prerequisites<a name="prerequisites-organizational-view"></a>

You must meet the following requirements to enable organizational view:
+ Your accounts must be members of an [AWS Organization](http://aws.amazon.com/organizations/)\.
+ Your organization must have [all features](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_org_support-all-features.html) enabled\.
+ The master account in your organization must have a Business or Enterprise support plan\. See [Compare AWS Support plans](http://aws.amazon.com/premiumsupport/plans/)\.
+ You must sign in as a user in the [master account](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_accounts.html) \(or [assumed equivalent role](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_use_switch-role-console.html)\)\. Whether you sign in as an IAM user or an IAM role, you must have a policy with the required permissions\. See [Using IAM policies to allow access to organizational view](organizational-view-iam-policies.md)\.

## Enable organizational view<a name="enable-organizational-view"></a>

After you meet the prerequisites, follow these steps to enable organizational view\. After you enable this feature, the following happens:
+ Trusted Advisor is enabled as a *trusted service* in your organization\. For more information, see [Enabling trusted access with other AWS services](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_integrate_services.html) in the *AWS Organizations User Guide*\.
+ The `AWSServiceRoleForTrustedAdvisorReporting` service\-linked\-role is created for you in the master account in your organization\. This role includes the permissions that Trusted Advisor needs to call Organizations on your behalf\. This service\-linked role is locked, and you can't delete it manually\. For more information, see [Using service\-linked roles for Trusted Advisor](using-service-linked-roles-ta.md)\.

You enable organizational view from the Trusted Advisor console\.

**To enable organizational view**

1. Sign in as an administrator in the organization's master account and open the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. In the navigation pane, choose **Organizational View**\.

1. Under **Get Started**, choose **Enable organizational view**\.  
![\[Screenshot of how to enable organizational view in the Trusted Advisor console.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/enable-organizational-view.png)

## Refresh Trusted Advisor checks<a name="refresh-trusted-advisor-checks"></a>

Before you create a report for your organization, we recommend that you refresh the statuses of your Trusted Advisor checks\. You can download a report without refreshing your Trusted Advisor checks, but your report might not have the latest information\.

If you have a Business or Enterprise account, Trusted Advisor automatically refreshes the checks in your account on a weekly basis\.

**Note**  
If you have accounts in your organization that have a Developer or Basic support plan, a user for those accounts must sign in to the Trusted Advisor console to refresh the checks\. You can't refresh checks for all accounts from the organization's master account\.

**To refresh Trusted Advisor checks**

1. Navigate to the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. On the **Dashboard** page, choose the refresh icon\. This refreshes all checks in your account\.

You can also refresh specific checks in the following ways:
+ Use the [RefreshTrustedAdvisorCheck](https://docs.aws.amazon.com/awssupport/latest/APIReference/API_RefreshTrustedAdvisorCheck.html) API operation\.
+ Choose the refresh icon for individual check categories or checks\.

## Create organizational view reports<a name="create-organizational-view-reports"></a>

After you enable organizational view, you can create reports so that you can view Trusted Advisor check results for your organization\.

You can create up to 50 reports\. If you create reports beyond this quota, Trusted Advisor deletes the earliest report\. You can't recover deleted reports\.

**To create organizational view reports**

1. Sign in to the organization's master account and open the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. In the navigation pane, choose **Organizational View**\.

1. Choose **Create**\.

1. By default, the report includes all AWS Regions, accounts in your organization, check categories, checks, and resource statuses\. On the **Create report** page, you can use the filter options to customize your report\. For example, you can clear the **All** option for **Account**, and then use the list to specify the individual account IDs to include in the report\.

   1. Enter a **Name** for the report\.

   1. For **Format**, choose **JSON** or **CSV**\.

   1. For **Region**, specify the AWS Regions or choose **All**\.

   1. For **Account**, specify the account IDs or choose **All**\.

   1. For **Check category**, specify the check category or choose **All**\.

   1. For **Checks**, choose the specific checks for that category or choose **All**\.

   1. For **Resource Status**, choose the status to filter, such as **warning**, or choose **All**\.

1. Choose **Create**\.

   The amount of time it takes to run the report depends on the number of accounts in the organization and the number of resources in each account\. On the **Organizational View** page, you can use the **Runtime** and the timestamp for **Date created** to estimate how long it will take to run future reports\.

**Example : Create report filter options**  
The following example creates a report for the following:  
+ Three AWS Regions
+ All accounts
+ All **Security** checks
+ The **Idle Load Balancers** and **High Utilization Amazon EC2 Instances** checks

![\[Screenshot of how to create an organizational view report in Trusted Advisor.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-create-report-filters.png)

**Notes**  
Currently, filtering by organizational units \(OUs\) is not supported\. For more information about OUs, see[ Managing organizational units](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_ous.html) in the *AWS Organizations User Guide*\.
You can't create more than one report at a time unless the current report has been running for more than 6 hours\.
Refresh the page if you don't see the report appear on the page\.

## View the report summary<a name="view-organizational-reports"></a>

After the report is ready, you can view the report summary from the Trusted Advisor console\. This lets you quickly view the summary of your check results across your organization\.

**To view the report summary**

1. Sign in to the organization's master account and open the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. In the left navigation pane, choose **Organizational View**\.

1. Choose the report name\.

   On the **Summary** page, view the check statuses for each category\. You can choose the **Filters Applied** list to see the filters specified for your report\.

**Example : Report summary for an organization**  

![\[Screenshot of an example report summary for Trusted Advisor.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-summary-report-console-2.png)

## Download an organizational view report<a name="download-organizational-view-reports"></a>

After your report is ready, download it from the Trusted Advisor console\. The report is a \.zip file that contains three files: 
+ `summary.json` – Contains a summary of the check results for each check category\.
+ `schema.json` – Contains the schema for the specified checks in the report\.
+ A resources file \(\.json or \.csv\) – Contains detailed information about the check statuses for resources in your organization\.

**To download an organizational view report**

1. Sign in to the organization's master account and open the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. In the navigation pane, choose **Organizational View**\.

   The **Organizational View** page displays the available reports to download\.

1. Select the check box for the report\.  
![\[Screenshot of example reports to download for Trusted Advisor.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-summary-reports-2.png)

1. Choose **Download** and save the file\.

1. Unzip the file\.

1. Use a text editor to open the `.json` file or a spreadsheet application to open the `.csv` file\.
**Note**  
You might receive multiple files if your report is 5 MB or larger\.

**Example : summary\.json file**  
The `summary.json` file shows the number of accounts in the organization and the statuses of the checks in each category\.   

Trusted Advisor uses the following color code for check results:
+ `Green` – Trusted Advisor doesn't detect an issue for the check\.
+ `Yellow` – Trusted Advisor detects a possible issue for the check\.
+ `Red` – Trusted Advisor detects an error and recommends an action for the check\.
+ `Blue` – Trusted Advisor can't determine the status of the check\.
In the following example, two checks are `Red`, two are `Yellow`, and two are `Green`\.  

```
{
    "numAccounts": 4,
    "filtersApplied": {
        "accountIds": "All",
        "checkIds": [
            "Qch7DwouX1",
            "zXCkfM1nI3",
            "Yw2K9puPzl",
            "hjLMh88uM8"
        ],
        "categories": [
            "security",
            "fault_tolerance"
        ],
        "statuses": "All",
        "regions": [
            "us-west-2",
            "us-west-1",
            "us-east-2"
        ]
    },
    "categoryStatusMap": {
        "security": {
            "statusMap": {
                "ERROR": {
                    "name": "Red",
                    "count": 1
                },
                "OK": {
                    "name": "Green",
                    "count": 2
                },
                "WARN": {
                    "name": "Yellow",
                    "count": 1
                }
            },
            "name": "Security"
        },
        "fault_tolerance": {
            "statusMap": {
                "ERROR": {
                    "name": "Red",
                    "count": 1
                },
                "WARN": {
                    "name": "Yellow",
                    "count": 1
                }
            },
            "name": "Fault Tolerance"
        }
    },
    "accountStatusMap": {
        "123456789012": {
            "security": {
                "statusMap": {
                    "ERROR": {
                        "name": "Red",
                        "count": 1
                    },
                    "OK": {
                        "name": "Green",
                        "count": 2
                    },
                    "WARN": {
                        "name": "Yellow",
                        "count": 1
                    }
                },
                "name": "Security"
            },
            "fault_tolerance": {
                "statusMap": {
                    "ERROR": {
                        "name": "Red",
                        "count": 1
                    },
                    "WARN": {
                        "name": "Yellow",
                        "count": 1
                    }
                },
                "name": "Fault Tolerance"
            }
        }
    }
}
```

**Example : schema\.json file**  
The `schema.json` file includes the schema for the checks in the report\. The following example includes the IDs and properties for the IAM Password Policy \(Yw2K9puPzl\) and IAM Key Rotation \(DqdJqYeRm5\) checks\.  

```
{
    "Yw2K9puPzl": [
        "Password Policy",
        "Uppercase",
        "Lowercase",
        "Number",
        "Non-alphanumeric",
        "Status",
        "Reason"
    ],
    "DqdJqYeRm5": [
        "Status",
        "IAM User",
        "Access Key",
        "Key Last Rotated",
        "Reason"
    ],
    ...
}
```

**Example : resources\.csv file**  
The `resources.csv` file includes information about resources in the organization\. This example shows some of the data columns that appear in the report, such as the following:  
+ Account ID of the affected account
+ The Trusted Advisor check ID
+ The resource ID
+ Timestamp of the report
+ The full name of the Trusted Advisor check
+ The Trusted Advisor check category

![\[Screenshot of an example CSV resources report for Trusted Advisor.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/organizational-view-summary-report-csv.png)

The resources file only contains entries if a check result exists at the resource level\. You might not see checks in the report for the following reasons:
+ Some checks, such as **MFA on Root Account**, don't have resources and won't appear in the report\. Checks without resources appear in the `summary.json` file instead\.
+ Some checks only show resources if they are `Red` or `Yellow`\. If all resources are `Green`, they might not appear in your report\.
+ If an account isn't enabled for a service that requires the check, the check might not appear in the report\. For example, if you're not using Amazon Elastic Compute Cloud Reserved Instances in your organization, the Amazon EC2 Reserved Instance Lease Expiration check won't appear in your report\.
+ The account hasn't refreshed check results\. This might happen when users with a Basic or Developer support plan sign in to the Trusted Advisor console for the first time\. If you have a Business or Enterprise support plan, it can take up to one week from account sign up for users to see check results\. For more information, see [Refresh Trusted Advisor checks](#refresh-trusted-advisor-checks)\.
+ If only the organization's master account enabled recommendations for checks, the report won't include resources for other accounts in the organization\.

For the resources file, you can use common software such as Microsoft Excel to open the \.csv file format\. You can use the \.csv file for one\-time analysis of all checks across all accounts in your organization\. If you want to use your report with an application, you can download the report as a \.json file instead\. 

The \.json file format provides more flexibility than the \.csv file format for advanced use cases such as aggregation and advanced analytics with multiple datasets\. For example, you can use a SQL interface with an AWS service such as Amazon Athena to run queries on your reports\. You can also use Amazon QuickSight to create dashboards and visualize your data\. For more information, see [Using other AWS services to view Trusted Advisor reports](use-other-aws-services-with-trusted-advisor-reports.md)\.

## Disable organizational view<a name="disable-organizational-view"></a>

Follow this procedure to disable organizational view\. You must sign in to the organization's master account or assume a role with the required permissions to disable this feature\. You can't disable this feature from another account in the organization\. 

After you disable this feature, the following happens:
+ Trusted Advisor is removed as a trusted service in Organizations\.
+ The `AWSServiceRoleForTrustedAdvisorReporting` service\-linked role is unlocked in the organization's master account\. This means you can delete it manually, if needed\.
+ You can't create, view, or download reports for your organization\. To access previously created reports, you must reenable organizational view from the Trusted Advisor console\. See [Enable organizational view](#enable-organizational-view)\.

**To disable organizational view for Trusted Advisor**

1. Sign in to the organization's master account and open the AWS Trusted Advisor console at [https://console\.aws\.amazon\.com/trustedadvisor](https://console.aws.amazon.com/trustedadvisor/)\.

1. In the left navigation, choose **Preferences**\.

1. Under **Organizational View**, choose **Disable organizational view**\.  
![\[Screenshot of how to disable Trusted Advisor organizational view.\]](http://docs.aws.amazon.com/awssupport/latest/user/images/disable-organizational-view.png)

After you disable organizational view, Trusted Advisor no longer aggregates checks from other AWS accounts in your organization\. However, the `AWSServiceRoleForTrustedAdvisorReporting` service\-linked role remains on the organization's master account until you delete it through the IAM console, IAM API, or AWS Command Line Interface \(AWS CLI\)\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.