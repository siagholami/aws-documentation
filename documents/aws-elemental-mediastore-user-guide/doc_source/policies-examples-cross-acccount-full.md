# Example container policy: Cross\-account full access to a role<a name="policies-examples-cross-acccount-full"></a>

This example policy allows cross\-account access to update any object in the account, as long as the user is logged in over HTTP\. It also allows cross\-account access to delete, download, and describe objects over HTTP or HTTPS to an account that has assumed the specified role:
+ The first statement is `CrossAccountRolePostOverHttps`\. It allows access to the `PutObject` operation on any object and allows this access to any user of the specified account if that account has assumed the role that is specified in <role name>\. It specifies that this access has the condition of requiring HTTPS for the operation \(this condition must always be included when providing access to `PutObject`\)\.

  In other words, any principal that has cross\-account access can access `PutObject`, but only over HTTPS\.
+ The second statement is `CrossAccountFullAccessExceptPost`\. It allows access to all operations except `PutObject` on any object\. It allows this access to any user of the specified account if that account has assumed the role that is specified in <role name>\. This access does not have the condition of requiring HTTPS for the operations\. 

  In other words, any account that has cross\-account access can access `DeleteObject`, `GetObject`, and so on \(but not `PutObject`\), and can do this over HTTP or HTTPS\.

  If you don’t exclude `PutObject` from the second statement, the statement won’t be valid \(because if you include `PutObject` you must explicitly set HTTPS as a condition\)\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "CrossAccountRolePostOverHttps",
      "Effect": "Allow",
      "Action": "mediastore:PutObject",
      "Principal":{
        "AWS": "arn:aws:iam::<other acct number>:role/<role name>"},
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*",
      "Condition": {
        "Bool": {
            "aws:SecureTransport": "true"
        }
      }
    },
    {
      "Sid": "CrossAccountFullAccessExceptPost",
      "Effect": "Allow",
      "NotAction": "mediastore:PutObject",
      "Principal":{
        "AWS": "arn:aws:iam::<other acct number>:role/<role name>"},
      "Resource": "arn:aws:mediastore:<region>:<owner acct number>:container/<container name>/*"
    }
  ]
}
```