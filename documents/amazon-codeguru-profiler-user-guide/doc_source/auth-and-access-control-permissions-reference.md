# Amazon CodeGuru Profiler permissions reference<a name="auth-and-access-control-permissions-reference"></a>

You can use AWS\-wide condition keys in your CodeGuru Profiler policies to express conditions\. For a list, see the [IAM JSON Policy Elements Reference](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

 You specify the actions in the policy's `Action` field\. To specify an action, use the `codeguru-profiler:` prefix followed by the API operation name \(for example, `codeguru-profiler:CreateProfilingGroup` and `codeguru-profiler:GetFindingsReport`\)\. To specify multiple actions in a single statement, separate them with commas \(for example, `"Action": [ "codeguru-profiler:CreateProfilingGroup", "codeguru-profiler:GetFindingsReport" ]`\)\. 

 **Using wildcard characters** 

 You specify an ARN, with or without a wildcard character \(\*\), as the resource value in the policy's `Resource` field\. You can use a wildcard to specify multiple actions or resources\. For example, `codeguru-profiler:*` specifies all CodeGuru Profiler actions and `codeguru-profiler:Get*` specifies all CodeGuru Profiler actions that begin with the word `Get`\. The following example refers to all profiling groups with names that begin with `my`\. 

```
arn:aws:codeguru-profiler:us-east-2:123456789012:profilingGroup/my*
```

 You can use the following table as a reference when you are setting up [authenticating with identities in CodeGuru Profiler](https://docs.aws.amazon.com/codeguru/latest/profiler-ug/security_iam_authentication.html) and writing permissions policies that you can attach to an IAM identity \(identity\-based policies\)\. 