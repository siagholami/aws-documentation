# Example container policy: Public read access over HTTP or HTTPS<a name="policies-examples-public-httphttps"></a>

This example policy allows access to the `GetObject` and `DescribeObject` operations on any object \(as specified by the \* at the end of the resource path\)\. It allows read access to anyone, including all authenticated users and anonymous users \(users who are not logged in\):

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadOverHttpOrHttps",
      "Effect": "Allow",
      "Action": ["mediastore:GetObject", "mediastore:DescribeObject"],
      "Principal": "*",
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
      "Condition": {
        "Bool": { "aws:SecureTransport": ["true", "false"] }
      }
    }
  ]
}
```