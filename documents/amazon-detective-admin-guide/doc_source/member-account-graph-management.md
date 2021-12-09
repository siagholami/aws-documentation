# For member accounts: Managing behavior graph invitations and memberships<a name="member-account-graph-management"></a>

A member account receives an invitation from the master account for a behavior graph\. The invitation indicates that the master account wants to use the member account's data in the behavior graph\. A member account can be invited to contribute to multiple behavior graphs\. For more information, see [Viewing your list of behavior graph invitations](member-view-graph-invitations.md)\.

Amazon Detective charges each member account for the ingested data for each behavior graph that it contributes to\.

Before Detective can ingest and extract the member account's data, the member account must accept the invitation\. If the member account declines the invitation, then the behavior graph does not use the member account's data\. See [Responding to a behavior graph invitation](member-invitation-response.md)\.

A member account can remove their account from a behavior graph at any time\. When they remove their account, Detective stops ingesting and extracting the account data into that behavior graph\. See [Removing your account from a behavior graph](member-remove-self-from-graph.md)\.

**Topics**
+ [Required IAM policy for a member account](member-account-iam-policy.md)
+ [Viewing your list of behavior graph invitations](member-view-graph-invitations.md)
+ [Responding to a behavior graph invitation](member-invitation-response.md)
+ [Removing your account from a behavior graph](member-remove-self-from-graph.md)