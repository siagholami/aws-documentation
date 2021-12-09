# Create a VPC endpoint policy for CodeArtifact<a name="create-vpc-endoint-policy"></a>

 To create a VPC endpoint policy for CodeArtifact, specify the following: 
+  The principal that can perform actions\. 
+  The actions that can be performed\. 
+  The resources that can have actions performed on them\. 

 The following example policy specifies that principals in the account 123456789012 can call the `GetAuthorizationToken` API and fetch packages from an CodeArtifact repository\. 

```
{
  "Statement": [
    {
      "Action": [
        "codeartifact:GetAuthorizationToken",
        "codeartifact:GetRepositoryEndpoint",
        "codeartifact:ReadFromRepository",
        "sts:GetServiceBearerToken"
      ],
      "Effect": "Allow",
      "Resource": "*",
      "Principal": {
         "AWS": "arn:aws:iam::123456789012:root"
       }
    }
  ]
}
```