# Resource\-based policies in CodeGuru Profiler<a name="resource-based-policies"></a>

 You control access to profiling groups in Amazon CodeGuru Profiler using profiling group resource\-based policies\. 

 AWS defines a *profiling group* as a *resource* in CodeGuru Profiler\. You, as the account administrator, control access to a resource in an AWS service\. For profiling groups, resource\-based policies support the agent\-related actions `ConfigureAgent` and `PostAgentProfile`\. 

In CodeGuru Profiler, permissions policies are *resource\-based policies* that are attached directly to profiling groups\. You can use resource\-based policies to manage the roles or IAM users that have permission to submit profiling data and configure the agent\. After you grant permissions for a role or user, you don't need to attach IAM permissions\. For more information, see [Identity\-based policies and resource\-based policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html) in the *AWS Identity and Access Management User Guide*\. 

 You can use the console, the SDK, or the AWS CLI to specify resource\-based permissions on a profiling group 

**Topics**
+ [Add a resource\-based policy to a profiling group \(console\)](#add-resource-based-policy-console)
+ [Add a resource\-based policy to a profiling group \(AWS CLI\)](#add-resource-based-policy-cli)
+ [Add a resource\-based policy to a profiling group \(AWS SDKs\)](#add-resource-based-policy-sdk)

## Add a resource\-based policy to a profiling group \(console\)<a name="add-resource-based-policy-console"></a>

1. Open the Amazon CodeGuru Profiler console at [https://console\.aws\.amazon\.com/codeguru/profiler](https://console.aws.amazon.com/codeguru/profiler)\.

1.  In the navigation pane, choose **Profiling groups**\. 

1. Choose the profiling group to add a resource\-based policy to\. 

1. Choose **Actions**, and then choose **Manage permissions**\.

1.  From **Application permissions**, select the users and roles you want to grant access to the profiling group\. 

1.  Choose **Save**\. 

 For more information, see [Set permissions](https://docs.aws.amazon.com/codeguru/latest/profiler-ug/setting-up.html#setting-up-step-3)\. 

## Add a resource\-based policy to a profiling group \(AWS CLI\)<a name="add-resource-based-policy-cli"></a>

Run the following AWS CLI command to add a resource\-based policy to a profiling group\. Use your profiling group name and the Amazon Resource Names \(ARNs\) of the roles and users you want to grant access to the profiling group\. 

The only valid value for the `action-group` argument is the `agentPermissions` action group\. `agentPermissions` grants the `ConfigureAgent` and `PostAgentProfile` permissions on a profiling group to the roles and users listed in the `principals` argument\.

```
aws codeguruprofiler put-permission --action-group agentPermissions \ 
            --profiling-group-name "my-profiling-group-name" \
            --principals "arn:aws:iam::123456789012:user/my-user-name"
```

 The following is an example output that grants access to a profiling group named `my-profiling-group` to an AWS user specified using its ARN, `arn:aws:iam::123456789012:user/my-user-name`\. 

```
{
    "policy": "{\n  \"Version\" : \"2012-10-17\",\n  \"Statement\" : [ {\n    \"Sid\" : \"agentPermissions-statement\",\n    \"Effect\" : \"Allow\",\n    \"Principal\" : {\n      \"AWS\" : \"arn:aws:iam::123456789012:user/my-user-name\"\n    },\n    \"Action\" : [ \"codeguru-profiler:ConfigureAgent\", \"codeguru-profiler:PostAgentProfile\" ],\n    \"Resource\" : \"arn:aws:codeguru-profiler:us-west-2:123456789012:profilingGroup/my-profiling-group-name\"\n  } ]\n}",
    "revisionId": "125820ee-98c7-4df9-8739-442ffad7b3a0"
}
```

## Add a resource\-based policy to a profiling group \(AWS SDKs\)<a name="add-resource-based-policy-sdk"></a>

 To add a resource\-based policy using an AWS SDK, use the `PutPermission` method\. For more information, see [PutPermission](https://docs.aws.amazon.com/codeguru/latest/profiler-api/API_PutPermission.html) in the *Amazon CodeGuru Profiler API Reference*\. 