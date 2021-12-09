# Required IAM policy for a member account<a name="member-account-iam-policy"></a>

Before a member account can view and manage invitations, the required IAM policy must be attached to their principal\. The principal can be an existing user or role, or you can create a new user or role to use for Detective\.

Ideally, the master account has their IAM administrator attach the required policy\.

The member account IAM policy grants access to member account actions in Amazon Detective\. The email invitation to contribute to a behavior graph includes the text of that IAM policy\.

To use this policy, replace `<behavior graph ARN>` with the graph ARN\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "detective:AcceptInvitation",
        "detective:DisassociateMembership",
        "detective:RejectInvitation"
      ],
      "Resource": "<behavior graph ARN>"
    },
   {
    "Effect":"Allow",
    "Action":["detective:ListInvitations"],
    "Resource":"*"
   }
 ]
}
```