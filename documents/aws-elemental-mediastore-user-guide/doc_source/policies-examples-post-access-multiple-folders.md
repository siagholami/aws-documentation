# Example container policy: Post access to an AWS service to multiple folders<a name="policies-examples-post-access-multiple-folders"></a>

This policy is a variation on `MediaStorePostToSpecificPath` that shows how to set up access to two different paths:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "MediaStorePostToSeveralPaths",
      "Effect": "Allow",
      "Action": "mediastore:PutObject",
      "Principal":{
        "AWS": "<aws service principal>"},
      "Resource": [
        "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/<specific path 1>/*",
        "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/<specific path 2>/*",
      ],
      "Condition": {
        "Bool": {
            "aws:SecureTransport": "true"
        }
      }
    }
  ]
}
```