# AWS CodeArtifact permissions reference<a name="auth-and-access-control-permissions-reference"></a>

You can use the following table as a reference when you are setting up [Access control](auth-and-access-control-aca.md#access-control) and writing permissions policies that you can attach to an IAM identity \(identity\-based policies\)\. 

You can use AWS\-wide condition keys in your AWS CodeArtifact policies to express conditions\. For a list, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\.

You specify the actions in the policy's `Action` field\. To specify an action, use the `codeartifact:` prefix followed by the API operation name \(for example, `codeartifact:CreateDomain` and `codeartifact:AssociateExternalConnection`\)\. To specify multiple actions in a single statement, separate them with commas \(for example, `"Action": [ "codeartifact:CreateDomain", "codeartifact:AssociateExternalConnection" ]`\)\.

**Using wildcard characters**

You specify an ARN, with or without a wildcard character \(\*\), as the resource value in the policy's `Resource` field\. You can use a wildcard to specify multiple actions or resources\. For example, `codeartifact:*` specifies all CodeArtifact actions and `codeartifact:Describe*` specifies all CodeArtifact actions that begin with the word `Describe`\. The following example refers to all repositories in the `myDomain` domain with names that begin with `my`\.

```
arn:aws:codeartifact:us-east-2:123456789012:repository/mydomain/my*
```