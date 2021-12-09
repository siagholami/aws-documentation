# Repository policies<a name="repo-policies"></a>

CodeArtifact uses resource\-based permissions to control access\. Resource\-based permissions let you specify who has access to a repository and what actions they can perform on it\. By default, only the repository owner has access to a repository\. You can apply a policy document that allows other IAM principals to access your repository\.

For more information, see [Resource\-Based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_resource-based) and [Identity\-Based Policies and Resource\-Based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html)\.

## Create a resource policy to grant read access<a name="creating-a-resource-policy-to-grant-read-access"></a>

A resource policy is a text file in JSON format\. The file must specify a principal \(actor\), one or more actions, and an effect \(`Allow` or `Deny`\)\. For example, the following resource policy grants the account `1234567890` permission to download packages from the repository\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:ReadFromRepository"
            ],
            "Effect": "Allow",
            "Principal": {
                 "AWS": "arn:aws:iam::123456789012:root"
            },
            "Resource": "*"
        }
    ]
}
```

Because the policy is evaluated only for operations against the repository that it's attached to, you don't need to specify a resource\. Because the resource is implied, you can set the `Resource` to `*`\.

**Note**  
The `codeartifact:ReadFromRepository` action can only be used on a repository resource\. You cannot put a package's Amazon Resource Name \(ARN\) as a resource with `codeartifact:ReadFromRepository` as the action to allow read access to a subset of packages in a repository\. A given principal can either read all the packages in a repository or none of them\.

Because the only action specified in the repository is `ReadFromRepository`, users and roles from account `1234567890` can download packages from the repository\. However, they can't perform other actions on them \(for example, listing package names and versions\)\. Typically, you grant permissions in the following policy in addition to `ReadFromRepository` because a user who downloads packages from a repository needs to interact with it in other ways, too\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:DescribePackageVersion",
                "codeartifact:DescribeRepository",
                "codeartifact:GetPackageVersionReadme",
                "codeartifact:GetRepositoryEndpoint",
                "codeartifact:ListPackages",
                "codeartifact:ListPackageVersions",
                "codeartifact:ListPackageVersionAssets",
                "codeartifact:ListPackageVersionDependencies",
                "codeartifact:ReadFromRepository"
            ],
            "Effect": "Allow",
            "Principal": {
                 "AWS": "arn:aws:iam::123456789012:root"
            },
            "Resource": "*"
        }
    ]
}
```

## Set a policy<a name="setting-a-policy"></a>

After you create a policy document, use the `put-repository-permissions-policy` command to attach it to a repository:

```
aws codeartifact put-repository-permissions-policy --domain my-domain --domain-owner domain-owner-id \
          --repository my-repo --policy-document file:///PATH/TO/policy.json
```

When you call `put-repository-permissions-policy`, the resource policy on the repository is ignored when evaluting permissions\. This ensures that the owner of a domain cannot lock themselves out of the repository, which would prevent them from being able to update the resource policy\.

**Note**  
 You cannot grant permissions to another AWS account to update the resource policy on a repository using a resource policy, since the resource policy is ignored when calling put\-repository\-permissions\-policy\. 

Sample output:

```
{
    "policy": {
        "resourceArn": "arn:aws:codeartifact:region-id:123456789012:repository/my-domain/my-repo",
        "document": "{ ...policy document content...}",
        "revision": "MQlyyTQRASRU3HB58gBtSDHXG7Q3hvxxxxxxx="
    }
}
```

The output of the command contains the Amazon Resource Name \(ARN\) of the repository resource, the full contents of the policy document, and a revision identifier\. You can pass the revision identifier to `put-repository-permissions-policy` using the `--policy-revision` option\. This ensures that a known revision of the document is being overwritten, and not a newer version set by another writer\.

## Read a policy<a name="reading-a-policy"></a>

Use the `get-repository-permissions-policy` command to read an existing version of a policy document\. To format the output for readability, use the `--output` and `--query policy.document` together with the Python `json.tool` module\.

```
aws codeartifact get-repository-permissions-policy --domain my-domain --domain-owner domain-owner-id \
          --repository my-repo
```

Sample output:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Principal": {
                "AWS": "arn:aws:iam::123456789012:root"
            },
            "Action": [
                "codeartifact:DescribePackageVersion",
                "codeartifact:DescribeRepository",
                "codeartifact:GetPackageVersionReadme",
                "codeartifact:GetRepositoryEndpoint",
                "codeartifact:ListPackages",
                "codeartifact:ListPackageVersions",
                "codeartifact:ListPackageVersionAssets",
                "codeartifact:ListPackageVersionDependencies",
                "codeartifact:ReadFromRepository"
            ],
            "Resource": "*"
        }
    ]
}
```

## Delete a policy<a name="deleting-a-policy"></a>

Use the `delete-repository-permissions-policy` command to delete a policy from a repository\.

```
aws codeartifact delete-repository-permissions-policy --domain my-domain --domain-owner domain-owner-id \
          --repository my-repo
```

The format of the output is the same as that of `get-repository-permissions-policy` and `delete-repository-permissions-policy` commands\.

## Grant read access to principals<a name="granting-read-access-to-specific-principals"></a>

 When you specify the root user of an account as the principal in a policy document, you grant access to all of the users and roles in that account\. To limit access to selected users or roles, use their ARN in the `Principal` section of the policy\. For example, use the following to grant read access to the IAM user `bob` in account 123456789012\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:ReadFromRepository"
            ],
            "Effect": "Allow",
            "Principal": {
                 "AWS": "arn:aws:iam::123456789012:user/bob"
            },
            "Resource": "*"
        }
    ]
}
```

## Grant write access to packages<a name="granting-write-access-to-specific-packages"></a>

 The `codeartifact:PublishPackageVersion` action is used to control permission to publish new versions of a package\. The resource used with this action must be a package\. The format of CodeArtifact package ARNs is as follows\.

```
arn:aws:codeartifact:region-id:123456789012:package/my-domain/my-repo/package-format/package-namespace/package-name
```

The following example shows the ARN for an npm package with scope `@parity` and name `ui` in the `example-repo` repository in domain `example-domain`\.: 

```
arn:aws:codeartifact:region-id:123456789012:package/example-domain/example-repo/npm/parity/ui
```

The ARN for an npm package without a scope has the empty string for the namespace field\. For example, the following is the ARN for a package without a scope and with name `react` in the `example-repo` repository in domain `example-domain`\.

```
arn:aws:codeartifact:region-id:123456789012:package/example-domain/example-repo/npm//react
```

The following policy grants account 123456789012 permission to publish versions of `@parity/ui` in the `example-repo` repository\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:PublishPackageVersion"
            ],
            "Effect": "Allow",
            "Principal": {
                "AWS": "arn:aws:iam::123456789012:root"
            },
            "Resource": "arn:aws:codeartifact:region-id:123456789012:package/example-domain/example-repo/npm/parity/ui"
        }
    ]
}
```

**Important**  
 To grant permission to publish Maven package versions, add the **codeartifact:PutPackageMetadata** permission\. 

 Because this policy specifies a domain and repository as part of the resource, it allows publishing only when attached to that repository\. 

## Grant write access to a repository<a name="granting-write-access-to-a-repository"></a>

 You can use wildcards to grant write permission for all packages in a repository\. For example, use the following policy to grant an account permission to write to all packages in the `example-repo` repository\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:PublishPackageVersion"
            ],
            "Effect": "Allow",
            "Principal": {
                "AWS": "arn:aws:iam::123456789012:root"
            },
            "Resource": "*"
        }
    ]
}
```