# Use CodeArtifact from a VPC<a name="use-codeartifact-from-vpc"></a>

Because the `com.amazonaws.region.codeartifact.api` endpoint uses a hostname different from the default hostname used by CodeArtifact, you must override the hostname when you use the CodeArtifact AWS CLI or SDK\.

 Run the following command to find a VPC endpoint to use to override the hostname\.

```
$ aws ec2 describe-vpc-endpoints --filters Name=service-name,Values=com.amazonaws.region.codeartifact.api \
  --query 'VpcEndpoints[*].DnsEntries[*].DnsName'
```

 The output looks like the following\.

```
[
  [
    "vpce-0743fe535b883ffff-76ddffff.api.codeartifact.us-west-2.vpce.amazonaws.com",
    "vpce-0743fe535b883ffff-76edffff-us-west-2a.api.codeartifact.us-west-2.vpce.amazonaws.com",
  ]
]
```

 In this example, you can use either hostname to override the `com.amazonaws.region.codeartifact.api` endpoint\.

If you use the CodeArtifact AWS CLI, pass the hostname to the `--endpoint-url` parameter, as in the following example\.

```
aws codeartifact login --tool npm --domain mydomain --domain-owner domain-owner-id --repository myrepo --endpoint-url VPC_endpoint
```

If you use the SDK, consult your SDK documentation to learn how to override a hostname\. How to do this varies by the language that you use\.