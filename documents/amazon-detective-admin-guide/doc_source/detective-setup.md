# Setting up Amazon Detective<a name="detective-setup"></a>

When you enable Amazon Detective, Detective creates a Region\-specific behavior graph that has your account as its master account\. This is initially the only account in the behavior graph\. The master account can then invite other AWS accounts to contribute their data to the behavior graph\. See [For master accounts: Managing the accounts in your behavior graph](master-account-graph-management.md)\.

Enabling Detective in a Region for the first time also begins a 30\-day free trial for the behavior graph\. If the account disables Detective and then enables it again, no free trial is available\. See [About the free trial for behavior graphs](free-trial-overview.md)\.

After the free trial, each account in the behavior graph is billed for the data they contribute to it\. The master account can track the usage and see the total projected cost for a typical 30\-day period for their entire behavior graph\. See [Monitoring usage and cost for a behavior graph \(master account\)](usage-tracking-master.md)\. Member accounts can track the usage and projected cost for the behavior graphs that they belong to\. See [Monitoring usage and cost across behavior graphs \(member account\)](member-usage-tracking.md)\.

**Topics**
+ [Amazon Detective prerequisites and recommendations](detective-prerequisites.md)
+ [Enabling Amazon Detective](detective-enabling.md)