# Amazon CodeGuru Reviewer permissions reference<a name="auth-and-access-control-permissions-reference"></a>

You can use AWS\-wide condition keys in your CodeGuru Reviewer policies to express conditions\. For a list, see [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

 You specify the actions in the policy's `Action` field\. To specify an action, use the `codeguru-reviewer:` prefix followed by the API operation name \(for example, `codeguru-reviewer:AssociateRepository` and `codeguru-reviewer:DisassociateRepository`\)\. To specify multiple actions in a single statement, separate them with commas \(for example, `"Action": [ "codeguru-reviewer:AssociateRepository", "codeguru-reviewer:DisassociateRepository" ]`\)\. 

 **Using wildcard characters** 

 You specify an Amazon Resource Name \(ARN\), with or without a wildcard character \(\*\), as the resource value in the policy's `Resource` field\. You can use a wildcard to specify multiple actions or resources\. For example, `codeguru-reviewer:*` specifies all CodeGuru Reviewer actions and `codeguru-reviewer:List*` specifies all CodeGuru Reviewer actions that begin with the word `List`\. The following example refers to all repository associations with a universally unique identifier \(UUID\) that begins with `PullRequest-GITHUB`\. 

```
arn:aws:codeguru-reviewer:us-east-2:123456789012:association:PullRequest-GITHUB*
```

 You can use the following table as a reference when you are setting up [Authenticating with identities in CodeGuru Reviewer](security_iam_authentication.md) and writing permissions policies that you can attach to an IAM identity \(identity\-based policies\)\. 