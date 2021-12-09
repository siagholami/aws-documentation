# Example container policy: Post access to an AWS service to a folder<a name="policies-examples-post-access-folder"></a>

This policy allows another AWS service to post objects in AWS Elemental MediaStore\. It allows access to `PutObject` on any object and allows this access to a specific AWS service\. It specifies that this access has the condition of requiring HTTPS for the operation \(this condition must always be included when providing access to `PutObject`\):

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "MediaStorePostToSpecificPath",
      "Effect": "Allow",
      "Action": "mediastore:PutObject",
      "Principal":{
        "AWS": "<aws service principal>"},
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/<specific path>/*",
      "Condition": {
        "Bool": {
            "aws:SecureTransport": "true"
        }
      }
    }
  ]
}
```