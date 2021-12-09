# Example container policy: Public read access over HTTPS<a name="policies-examples-public-https"></a>

This example policy allows users to retrieve an object through an HTTPS request\. It allows read access to anyone over a secured SSL/TLS connection: authenticated users and anonymous users \(users who are not logged in\)\. The statement has the name `PublicReadOverHttps`\. It allows access to the `GetObject` and `DescribeObject` operations on any object \(as specified by the \* at the end of the resource path\)\. It specifies that this access has the condition of requiring HTTPS for the operations:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadOverHttps",
      "Effect": "Allow",
      "Action": ["mediastore:GetObject", "mediastore:DescribeObject"],
      "Principal": "*",
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