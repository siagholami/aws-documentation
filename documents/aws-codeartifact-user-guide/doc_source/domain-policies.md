# Domain policies<a name="domain-policies"></a>

CodeArtifact supports using resource\-based permissions to control access\. Resource\-based permissions let you specify who has access to a resource and which actions they can perform on it\. By default, only the AWS account that owns the domain can create and access repositories in the domain\. You can apply a policy document to a domain to allow other IAM principals to access it\.

For more information, see [Policies and Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) and [Identity\-Based Policies and Resource\-Based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html)\.

**Topics**
+ [Enable cross\-account access to a domain](#enabling-cross-acount-access-to-a-domain)
+ [Domain policy example](#domain-policy-example)
+ [Domain policy example with AWS Organizations](#domain-policy-example-with-aws-organizations)
+ [Set a domain policy](#set-domain-policy)
+ [Read a domain policy](#reading-a-domain-policy)
+ [Delete a domain policy](#deleting-a-domain-policy)

## Enable cross\-account access to a domain<a name="enabling-cross-acount-access-to-a-domain"></a>

A resource policy is a text file in JSON format\. The file must specify a principal \(actor\), one or more actions, and an effect \(`Allow` or `Deny`\)\. To create a repository in a domain owned by another account, the principal must be granted the `CreateRepository` permission on the *domain* resource\.

For example, the following resource policy grants the account 123456789012 permission to create a repository in the domain\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:CreateRepository"
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

Because the policy is evaluated only for operations against the domain it's attached to, you do not need to specify a resource\. Because the resource is implied, the `Resource` can be set to `*`\.

To access packages in a domain owned by another account, a principal must be granted the `GetAuthorizationToken` permission on the *domain resource*\. This allows the domain owner to exercise control over which accounts can read the contents of repositories in the domain\.

For example, the following resource policy grants the account 123456789012 permission to retrieve an auth token for any repository in the domain\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:GetAuthorizationToken"
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

**Note**  
A principal who wants to fetch packages from a repository endpoint must be granted the `ReadFromRepository` permission on the repository resource in addition to the `GetAuthorizationToken` permission on the domain\. Similarly, a principal who wants to publish packages to a repository endpoint must be granted the `PublishPackageVersion` permission in addition to `GetAuthorizationToken`\.   
For more information about the `ReadFromRepository` and `PublishPackageVersion` permissions, see [Repository Policies](repo-policies.md)\.

## Domain policy example<a name="domain-policy-example"></a>

When multiple accounts are using a domain, the accounts should be granted a basic set of permissions to allow full use of the domain\. The following resource policy lists a set of permissions that allow full use of the domain\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "BasicDomainPolicy",
            "Action": [
                "codeartifact:GetDomainPermissionsPolicy",
                "codeartifact:ListRepositoriesInDomain",
                "codeartifact:GetAuthorizationToken",
                "codeartifact:DescribeDomain",
                "codeartifact:CreateRepository"
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

**Note**  
You don't need to create a domain policy if a domain and all its repositories are owned by a single account and only need to be used from that account\.

## Domain policy example with AWS Organizations<a name="domain-policy-example-with-aws-organizations"></a>

You can use the `aws:PrincipalOrgID` condition key to grant access to an CodeArtifact domain from all accounts in your organization, as follows\.

```
{
    "Version": "2012-10-17",
    "Statement": {
        "Sid": "DomainPolicyForOrganization",
        "Effect": "Allow",
        "Principal": "*",
        "Action": [
             "codeartifact:GetDomainPermissionsPolicy",
             "codeartifact:ListRepositoriesInDomain",
             "codeartifact:GetAuthorizationToken",
             "codeartifact:DescribeDomain",
             "codeartifact:CreateRepository"
        ],
        "Resource": "*",
        "Condition": {
            "StringEquals": { "aws:PrincipalOrgID":["o-xxxxxxxxxxx"]}
        }
    }
}
```

For more information about using the `aws:PrincipalOrgID` condition key, see [AWS Global Condition Context Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_condition-keys.html) in the *IAM User Guide*\.

## Set a domain policy<a name="set-domain-policy"></a>

You can use the `put-domain-permissions-policy` command to attach a policy to a domain\.

```
aws codeartifact put-domain-permissions-policy --domain my-domain --domain-owner domain-owner-id \
 --policy-document file://</PATH/TO/policy.json>
```

When you call `put-domains-permissions-policy`, the resource policy on the domain is ignored when evaluting permissions\. This ensures that the owner of a domain cannot lock themselves out of the domain, which would prevent them from being able to update the resource policy\.

**Note**  
 You cannot grant permissions to another AWS account to update the resource policy on a domain using a resource policy, since the resource policy is ignored when calling put\-domain\-permissions\-policy\. 

Sample output:

```
{
    "policy": {
        "resourceArn": "arn:aws:codeartifact:region-id:123456789012:domain/my-domain",
        "document": "{ ...policy document content...}",
        "revision": "MQlyyTQRASRU3HB58gBtSDHXG7Q3hvxxxxxxx="
    }
}
```

The output of the command contains the Amazon Resource Name \(ARN\) of the domain resource, the full contents of the policy document, and a revision identifier\. The revision identifier can be passed to `put-domain-permissions-policy` using the `--policy-revision` option\. This ensures that a known revision of the document is being overwritten, and not a newer version set by another writer\.

## Read a domain policy<a name="reading-a-domain-policy"></a>

To read an existing version of a policy document, use the `get-domain-permissions-policy` command\. To format the output for readability, use the `--output` and `--query policy.document` together with the Python `json.tool` module, as follows\.

```
aws codeartifact get-domain-permissions-policy --domain my-domain --domain-owner domain-owner-id \
   --output text --query policy.document | python -m json.tool
```

Sample output:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "BasicDomainPolicy",
            "Action": [
                "codeartifact:GetDomainPermissionsPolicy",
                "codeartifact:ListRepositoriesInDomain",
                "codeartifact:GetAuthorizationToken",
                "codeartifact:CreateRepository"
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

## Delete a domain policy<a name="deleting-a-domain-policy"></a>

Use the `delete-domain-permissions-policy` command to delete a policy from a domain\.

```
aws codeartifact delete-domain-permissions-policy --domain my-domain --domain-owner domain-owner-id
```

The format of the output is the same as that of the `get-domain-permissions-policy` and `delete-domain-permissions-policy` commands\.