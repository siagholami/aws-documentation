# Example container policy: Cross\-account read access—HTTP enabled<a name="policies-examples-cross-acccount-http"></a>

This example policy allows users to retrieve an object through an HTTP request\. It allows this access to authenticated users with cross\-account access\. The object is not required to be hosted on a server with an SSL/TLS certificate:

```
{
  "Version" : "2012-10-17",
  "Statement" : [ {
    "Sid" : "CrossAccountReadOverHttpOrHttps",
    "Effect" : "Allow",
    "Principal" : {
      "AWS" : "arn:aws:iam::<other acct number>:root"
    },
    "Action" : [ "mediastore:GetObject", "mediastore:DescribeObject" ],
    "Resource" : "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
    "Condition" : {
      "Bool" : {
        "aws:SecureTransport" : [ "true", "false" ]
      }
    }
  } ]
}
```