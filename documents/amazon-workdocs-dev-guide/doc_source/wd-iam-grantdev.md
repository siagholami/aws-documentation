# Grant permission to a developer to assume an IAM role given by a Amazon WorkDocs customer<a name="wd-iam-grantdev"></a>

If you are a developer with an administrative AWS account, you can grant a user permission to switch to a role by creating a new policy and attaching it to the user\.

A policy that grants a user permission to assume a role must include a statement with the `Allow` effect on the `sts:AssumeRole` action and the Amazon Resource Name \(ARN\) of the role in a `Resource` element, as shown in the following example\. Users that get the policy \(either through group membership or directly attached\) are allowed to switch to the specified role\.

```
{
  "Version": "2012-10-17",
  "Statement": {
    "Effect": "Allow",
    "Action": "sts:AssumeRole",
    "Resource": "arn:aws:iam::<aws_account_id>:role/ workdocs_app_role"
  }
}
```