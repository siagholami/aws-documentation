# Monitoring usage and cost for a behavior graph \(master account\)<a name="usage-tracking-master"></a>

Amazon Detective bills each account for the data used in each behavior graph that the account belongs to\. Detective charges a tiered flat rate per GB for all data regardless of the source\.

For master accounts, the **Usage** page of the Detective console shows the volume of data ingested into their behavior graph over the previous 30 days\. Master accounts also see a projected cost for a typical 30\-day period for their account and for the entire behavior graph\.

**To view Detective usage information**

1. Sign in to the AWS Management Console\. Then open the Detective console at [https://console\.aws\.amazon\.com/detective/](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, under **Settings**, choose **Usage**\.

## Volume of data ingested for each account<a name="usage-data-volume-by-account"></a>

**Ingested volume by member account** lists the active accounts in the behavior graph\. It does not list member accounts that were removed\.

For each account, the ingested volume list provides the following information\.
+ The AWS account identifier and root user email address\.
+ The date when the account began to contribute data to the behavior graph\.

  For the master account, this is the date when the account enabled Detective\.

  For member accounts, this is the date when an account was enabled as a member account after accepting the invitation\.
+ The volume of ingested data from the account over the previous 30 days\. The total includes all source types\.
+ Whether the account is currently in the free trial period\. For accounts that are currently in their free trial period, the list displays the number of days remaining\.

  If none of the accounts are in the free trial period, then the free trial status column is not displayed\.

## Projected cost for the master account<a name="usage-cost-this-account"></a>

**This account's projected cost** shows a projected cost for 30 days of data for the master account\. The projected cost is based on the daily average volume for the master account\.

**Important**  
This amount is a projected cost only\. It projects the total cost for the master account data for a typical 30\-day time period\. It is based on the usage from the previous 30 days\. See [How Amazon Detective calculates projected cost](usage-projected-cost-calculation.md)\.

## Projected cost for the behavior graph<a name="usage-cost-all-accounts"></a>

**All accounts' projected cost** shows a total projected cost for 30 days of data for the entire behavior graph\. The projected cost is based on the daily average volume for each account\.

Important

**Important**  
This amount is a projected cost only\. It projects the total cost for the behavior graph data for a typical 30\-day time period\. It is based on the usage from the previous 30 days\. The projected cost does not include member accounts that were removed from the behavior graph\. See [How Amazon Detective calculates projected cost](usage-projected-cost-calculation.md)\.