# What is Amazon Detective?<a name="what-is-detective"></a>

Amazon Detective makes it easy to analyze, investigate, and quickly identify the root cause of security findings or suspicious activities\. Detective automatically collects log data from your AWS resources\. It then uses machine learning, statistical analysis, and graph theory to help you visualize and conduct faster and more efficient security investigations\.

The Detective prebuilt data aggregations, summaries, and context help you to quickly analyze and determine the nature and extent of possible security issues\. Detective maintains up to a year of historical event data\. This data is easily available through a set of visualizations that shows changes in the type and volume of activity over a selected time window\. Detective links those changes to GuardDuty findings\.

## How does Detective work?<a name="detective-how-works"></a>

Detective automatically extracts time\-based events such as login attempts, API calls, and network traffic from AWS CloudTrail and Amazon VPC flow logs\. It also ingests findings detected by GuardDuty\.

From those events, Detective uses machine learning and visualization to create a unified, interactive view of your resource behaviors and the interactions between them over time\. You can explore this behavior graph to examine disparate actions such as failed logon attempts or suspicious API calls\. You can also see how these actions affect resources such as AWS accounts and Amazon EC2 instances\. You can adjust the behavior graph's scope and timeline for a variety of tasks:
+ Rapidly investigate any activity that falls outside the norm\.
+ Identify patterns that may indicate a security issue\.
+ Understand all of the resources affected by a finding\.

Detective tailored visualizations provide a baseline for and summarize the account information\. These findings can help answer questions such as "Is this an unusual API call for this role?" Or "Is this spike in traffic from this instance expected?"

With Detective, you don't have to organize any data or develop, configure, or tune your own queries and algorithms\. There are no upfront costs and you pay only for the events analyzed, with no additional software to deploy or other feeds to subscribe to\.

## Who uses Detective?<a name="detective-who-uses"></a>

When an account enables Detective, it becomes the master account for a behavior graph\. A behavior graph is a linked set of extracted and analyzed data from one or more AWS accounts\. Master accounts invite member accounts to contribute their data to the master account's behavior graph\.

For information about how Detective uses source data from behavior graph accounts, see [Source data used in a behavior graph](detective-source-data-about.md)\.

For information on how master accounts manage behavior graphs, see [For master accounts: Managing the accounts in your behavior graph](master-account-graph-management.md)\. For information on how member accounts manage their behavior graph invitations and memberships, see [For member accounts: Managing behavior graph invitations and memberships](member-account-graph-management.md)\.

The master account uses the analytics and visualizations generated from the behavior graph to investigate AWS resources and GuardDuty findings\. The Detective integrations with GuardDuty and AWS Security Hub allow you to pivot from a GuardDuty finding in these services directly into the Detective console\.

A Detective investigation focuses on the activity that is connected to the involved AWS resources\. For an overview of the investigation process in Detective, see [How Amazon Detective is used for investigation](https://docs.aws.amazon.com/detective/latest/userguide/detective-investigation-about.html) in *Detective User Guide*\.