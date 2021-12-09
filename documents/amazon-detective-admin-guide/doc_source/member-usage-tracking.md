# Monitoring usage and cost across behavior graphs \(member account\)<a name="member-usage-tracking"></a>

Amazon Detective bills each account for the data used in each behavior graph that the account belongs to\. Detective charges a tiered flat rate per GB for all data regardless of the source\.

For member accounts, the **Usage** page shows the volume of data and projected 30\-day cost for that account only\.

**To view Detective usage information**

1. Sign in to the AWS Management Console\. Then open the Detective console at [https://console\.aws\.amazon\.com/detective/](https://console.aws.amazon.com/detective/)\.

1. In the Detective navigation pane, under **Settings**, choose **Usage**\.

## Ingested volume for each behavior graph<a name="volume-per-behavior-graph"></a>

**This account's ingested volume** lists the behavior graphs that the member account contributes to\. It does not include memberships that you resigned, or memberships that the master account removed\.

For each behavior graph, the list includes the following information\.
+ The account number of the master account
+ The volume of ingested data from the member account over the previous 30 days\. The total includes all source types\.
+ The date when the member account was enabled for the behavior graph\.

## Projected cost across behavior graphs<a name="member-projected-cost"></a>

**This account's projected cost** shows a projected cost for 30 days of data for the member account across all of the behavior graphs that it contributes to\. The projected cost is based on the daily average volume for the member account\.

**Important**  
This amount is a projected cost only\. It projects the total cost for the master account data for a typical 30\-day time period\. It is based on the usage from the previous 30 days\. See [How Amazon Detective calculates projected cost](usage-projected-cost-calculation.md)\.