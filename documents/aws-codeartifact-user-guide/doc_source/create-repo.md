# Create a repository<a name="create-repo"></a>

You can create a repository using the CodeArtifact console or the AWS Command Line Interface \(AWS CLI\)\. When you create a repository, it does not contain any packages\. Each repository is associated with the AWS account that you use when you create it\. An AWS account can have up to 10000 repositories, for more information on CodeArtifact service limits, see [Quotas in AWS CodeArtifact](service-limits.md)\. You can delete repositories to make room for more\. 

A repository can have one or more CodeArtifact repositories associated with it as upstream repositories\. This allows a package manager client to access the packages contained in more than one repository using a single URL endpoint\. For more information, see [Working with upstream repositories in CodeArtifact](repos-upstream.md)\. 

**Note**  
After you create a repository, you cannot change its name, associated AWS account, or domain\.

**Topics**
+ [Create a repository \(console\)](#create-repo-console)
+ [Create a repository \(AWS CLI\)](#create-repo-cli)
+ [Create a repository with an upstream repository](#creating-a-repository-with-an-upstream)

## Create a repository \(console\)<a name="create-repo-console"></a>

1. Open the AWS CodeArtifact console at [https://console\.aws\.amazon\.com/codesuite/codeartifact/home](https://console.aws.amazon.com/codesuite/codeartifact/home)\.

1.  On the navigation pane, choose **Repositories**, and then choose **Create repository**\. 

1.  For **Repository name**, enter a name for your repository\.

1.  \(Optional\) In **Repository description**, enter an optional description for your repository\. 

1.  \(Optional\) In **Publish upstream repositories**, add intermediate repositories that connect your repositories to package authorities such as Maven Central or npmjs\.com\. 

1.  Choose **Next**\. 

1.  In **AWS account**, choose **This AWS account** if you are signed in to the account that owns the domain\. Choose **Different AWS account** if another AWS account owns the domain\.

1.  In **Domain**, choose the domain that the repository will be created in\.

    If there are no domains in the account, you must create one\. Enter the name for the new domain in **Domain name**\.

    Expand **Additional configuration**\. 

    You must use a *customer master key* \(CMK\) to encrypt all assets in your domain\. You can use an AWS managed CMK or a CMK that you manage: 
   +  Choose **AWS managed key** if you want to use the default AWS managed CMK\. 
   +  Choose **Customer managed key** if you want to use a CMK that you manage\. If you use a CMK that you manage, in **Customer master key**, choose the CMK\. 

    For more information, see [AWS managed CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) and [Customer managed CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk) in the *AWS Key Management Service Developer Guide*\. 

1.  Choose **Next**\. 

1.  In **Review and create**, review what CodeArtifact is creating for you\. 
   +  **Package flow** shows how your domain and repositories are connected\.
   +  **Step 1: Create repository** shows details about the repository and optional upstream repositories that will be created\. 
   +  **Step 2: Select domain** shows details about `my-domain`\. 

    When you're ready, choose **Create repository**\. 

## Create a repository \(AWS CLI\)<a name="create-repo-cli"></a>

Use the `create-repository` command to create a repository in your domain\.

```
aws codeartifact create-repository --domain my-domain --domain-owner domain-owner-id --repository my-repo --description "My new repository"
```

Example output:

```
{
    "repository": {
        "name": "my-repo",
        "administratorAccount": "123456789012
        "domainName": "my-domain",
        "domainOwner": "123456789012",
        "arn": "arn:aws:codeartifact:region-id:123456789012:repository/my-domain/my-repo",
        "description": "My new repository",
        "upstreams": "[]",
        "externalConnections"" "[]"
    }
}
```

A new repository doesn't contain any packages\. Each repository is associated with the AWS account that you're authenticated to when the repository is created\. An AWS account can have a maximum of 100 repositories\. Repositories that have been deleted with the `delete-repository` command don't count towards this limit\.

## Create a repository with an upstream repository<a name="creating-a-repository-with-an-upstream"></a>

You can specify one or more upstream repositories when you create a repository\. 

```
aws codeartifact create-repository --domain my-domain --domain-owner domain-owner-id --repository my-repo \
  --upstreams repositoryName=my-upstream-repo --repository-description "My new repository"
```

Example output:

```
{
    "repository": {
        "name": "my-repo",
        "administratorAccount": "123456789012
        "domainName": "my-domain",
        "domainOwner": "123456789012",
        "arn": "arn:aws:codeartifact:region-id:123456789012:repository/my-domain/my-repo",
        "description": "My new repository",
        "upstreams": [
            {
                "repositoryName": "my-upstream-repo"
            }
        ],
        "externalConnections"" "[]"
    }
}
```

**Note**  
To create a repository with an upstream, you must have permission for the `AssociateWithDownstreamRepository` action on the upstream repository\.

To add an upstream to a repository after it's been created, see [Add, update, or remove upstream repositories \(console\)](repo-upstream-add-console.md) and [Add, update, or remove upstream repositories \(AWS CLI\)](repo-upstream-add-cli.md)\.