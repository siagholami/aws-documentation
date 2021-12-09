# Create VPC endpoints for CodeArtifact<a name="create-vpc-endpoints"></a>

 To create virtual private cloud \(VPC\) endpoints for CodeArtifact, use the Amazon EC2 `create-vpc-endpoint` AWS CLI command\. For more information, see [Interface VPC Endpoints \(AWS PrivateLink\)](https://docs.aws.amazon.com/vpc/latest/userguide/vpce-interface.html) in the *Amazon Virtual Private Cloud User Guide*\. 

 Two VPC endpoints are required so that all requests to CodeArtifact are in the AWS network\. The first endpoint is used to call CodeArtifact APIs \(for example, `GetAuthorizationToken` and `CreateRepository`\)\.

```
com.amazonaws.region.codeartifact.api
```

 The second endpoint is used to access CodeArtifact repositories using package managers and build tools \(for example, npm and Gradle\)\.

```
com.amazonaws.region.codeartifact.respositories
```

 The following command creates an endpoint to access CodeArtifact repositories\.

```
aws ec2 create-vpc-endpoint --vpc-id vpcid --vpc-endpoint-type Interface \
  --service-name com.amazonaws.region.codeartifact.api --subnet-ids subnetid \
  --security-group-ids groupid
```

 The following command creates an endpoint to access package managers and build tools\.

```
aws ec2 create-vpc-endpoint --vpc-id vpcid --vpc-endpoint-type Interface \
  --service-name com.amazonaws.region.codeartifact.repositories --subnet-ids subnetid \
  --security-group-ids groupid --private-dns-enabled
```

**Note**  
 When you create a `codeartifact.repositories` endpoint, you must create a private DNS hostname using the `--private-dns-enabled` option\. However, because multiple private DNS hostnames are not currently supported for the `codeartifact.api` and `codeartifact.repositories` endpoints, do not use the `--private-dns-enabled` option for `codeartifact.api`\. 