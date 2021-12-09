# Security best practices for Amazon Detective<a name="security-best-practices"></a>

Detective provides a number of security features to consider as you develop and implement your own security policies\. The following best practices are general guidelines and don’t represent a complete security solution\. Because these best practices might not be appropriate or sufficient for your environment, treat them as helpful considerations rather than prescriptions\.

For Detective, the security best practices are associated with managing the accounts in a behavior graph\.

## Best practices for master accounts<a name="security-best-practices-master-accounts"></a>

When inviting member accounts to your behavior graph, only invite accounts that you oversee\.

Limit access to the behavior graph\. When a user has access to a behavior graph, they can see all of the findings for the member accounts\. Such findings might expose sensitive security information\.

## Best practices for member accounts<a name="security-best-practices-member-accounts"></a>

When you receive an invitation to a behavior graph, make sure to validate the source of the invitation\.

Check the AWS account identifier of the master account that sent the invitation\. Verify that you know who the account belongs to, and that the inviting account has a legitimate reason to monitor your security data\.