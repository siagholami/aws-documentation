# Create a domain<a name="domain-create"></a>

You can create a domain using the CodeArtifact console or the AWS Command Line Interface \(AWS CLI\)\. When you create a domain, it does not contain any repositories\. For more information, see [Create a repository](create-repo.md)\. 

**Topics**
+ [Create a domain \(console\)](#create-domain-console)
+ [Create a domain \(AWS CLI\)](#create-domain-cli)

## Create a domain \(console\)<a name="create-domain-console"></a>

1. Open the AWS CodeArtifact console at [https://console\.aws\.amazon\.com/codesuite/codeartifact/home](https://console.aws.amazon.com/codesuite/codeartifact/home)\.

1.  In the navigation pane, choose **Domains**, and then choose **Create domain**\. 

1.  In **Name**, enter a name for your domain\. 

1.  Expand **Additional configuration**\. 

1.  You must use a *customer master key* \(CMK\) to encrypt all assets in your domain\. You can use an AWS managed CMK or a CMK that you manage\.
   +  Choose **Default key** if you want to use the default AWS managed CMK\. 
   +  Choose **Customer managed key** if you want to use a CMK that you manage\. If you use a CMK that you manage, in **Customer master key**, choose the CMK\. 

    For more information, see [AWS managed CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) and [Customer managed CMKs](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#customer-cmk) in the *AWS Key Management Service Developer Guide*\. 

1.  Choose **Create domain**\. 

## Create a domain \(AWS CLI\)<a name="create-domain-cli"></a>

Use the `create-domain` command to create a repository in your domain\. You must use a *customer master key* \(CMK\) to encrypt all assets in your domain\. You can use an AWS managed CMK or a CMK that you manage\. If you use an AWS managed CMK, do not use the `--encryption-key` parameter\.

```
aws codeartifact create-domain --domain my-domain
```

 JSON\-formatted data appears in the output with details about your new domain\. 

```
{
    "domain": {
        "name": "my-domain",
        "owner": "123456789012",
        "arn": "arn:aws:codeartifact:us-west-2:123456789012:domain/my-domain",
        "status": "Active",
        "encryptionKey": "arn:aws:kms:us-west-2:123456789012:key/your-kms-key",
        "repositoryCount": 0,
        "assetSizeBytes": 0
    }
}
```

 If you use a CMK that you manage, include its Amazon Resource Name \(ARN\) with the `--encryption-key` parameter\. 

```
aws codeartifact create-domain --domain my-domain --encryption-key arn:aws:kms:us-west-2:123456789012:key/your-kms-key
```

 JSON\-formatted data appears in the output with details about your new domain\. 

```
{
    "domain": {
        "name": "my-domain",
        "owner": "123456789012",
        "arn": "arn:aws:codeartifact:us-west-2:123456789012:domain/my-domain",
        "status": "Active",
        "encryptionKey": "arn:aws:kms:us-west-2:123456789012:key/your-kms-key",
        "repositoryCount": 0,
        "assetSizeBytes": 0
    }
}
```