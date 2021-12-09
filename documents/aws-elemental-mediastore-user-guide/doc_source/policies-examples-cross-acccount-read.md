# Example container policy: Cross\-account read access to a role<a name="policies-examples-cross-acccount-read"></a>

The example policy allows access to the `GetObject` and `DescribeObject` operations on any object \(as specified by the \* at the end of the resource path\) that is owned by the <owner acct number>\. It allows this access to any user of the <other acct number> if that account has assumed the role that is specified in <role name>:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "CrossAccountRoleRead",
      "Effect": "Allow",
      "Action": ["mediastore:GetObject", "mediastore:DescribeObject"],
      "Principal":{
        "AWS": "arn:aws:iam::<other acct number>:role/<role name>"},
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
    }
  ]
}
```