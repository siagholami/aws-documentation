# For master accounts: Managing the accounts in your behavior graph<a name="master-account-graph-management"></a>

A master account can invite 1,000 other accounts to be member accounts in the behavior graph\. See [Inviting member accounts to a behavior graph](graph-master-add-member-accounts.md)\. When a member account accepts the invitation and is enabled, Amazon Detective begins to ingest and extract the member account's data into that behavior graph\.

The master account can also remove member accounts from their behavior graph\. See [Removing member accounts from a behavior graph](graph-master-remove-member-accounts.md)\.

An account can be a member account of multiple behavior graphs in the same Region\. An account can only be the master account of one behavior graph per Region\. An account can be a master account in different Regions\.

Detective charges each account for the data that it contributes to each behavior graph\. For information on tracking the volume of data for each account in the behavior graph, see [Monitoring usage and cost for a behavior graph \(master account\)](usage-tracking-master.md)\.

**Topics**
+ [Viewing the list of accounts in a behavior graph](graph-master-view-accounts.md)
+ [Inviting member accounts to a behavior graph](graph-master-add-member-accounts.md)
+ [Enabling a member account that is Accepted \(Not enabled\)](graph-master-unblock-account.md)
+ [Removing member accounts from a behavior graph](graph-master-remove-member-accounts.md)