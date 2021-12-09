# Example container policy: Cross\-account read access over HTTPS<a name="policies-examples-cross-acccount-https"></a>

This example policy allows access to the `GetObject` and `DescribeObject` operations on any object \(as specified by the \* at the end of the resource path\) that is owned by root user user of the specified <other acct number>\. It specifies that this access has the condition of requiring HTTPS for the operations:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "CrossAccountReadOverHttps",
      "Effect": "Allow",
      "Action": ["mediastore:GetObject", "mediastore:DescribeObject"],
      "Principal":{
        "AWS": "arn:aws:iam::<other acct number>:root"},
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
      "Condition": {
        "Bool": {
            "aws:SecureTransport": "true"
        }
      }
    }
  ]
}
```