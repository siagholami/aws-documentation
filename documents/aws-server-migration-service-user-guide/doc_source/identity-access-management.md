# Identity and access management for AWS Server Migration Service<a name="identity-access-management"></a>

AWS Identity and Access Management \(IAM\) is an AWS service that helps an administrator securely control access to AWS resources\. IAM administrators control who can be authenticated \(signed in\) and authorized \(have permissions\) to use AWS resources\. IAM enables you to create users and groups under your AWS account\. You control the permissions that users have to perform tasks using AWS resources\. You can use IAM for no additional charge\.

By default, IAM users don't have permissions for AWS Server Migration Service \(AWS SMS\) resources and operations\. To allow IAM users to manage AWS SMS resources, you must create an IAM policy that explicitly grants them permissions, and attach the policy to the IAM users or groups that require those permissions\.

When you attach a policy to a user or group of users, it allows or denies the users permission to perform the specified tasks on the specified resources\. For more information, see [Policies and Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html) in the *IAM User Guide* guide\.

## Policy structure<a name="iam-policy-structure"></a>

An IAM policy is a JSON document that consists of one or more statements\. Each statement is structured as follows\.

```
{
  "Statement": [
    {
      "Effect": "effect",
      "Action": "action",
      "Resource": "arn",
      "Condition": {
        "condition": {
          "key":"value"
        }
      }
    }
  ]
}
```

There are various elements that make up a statement:
+ **Effect:** The effect can be `Allow` or `Deny`\. By default, IAM users don't have permission to use resources and API actions, so all requests are denied\. An explicit allow overrides the default\. An explicit deny overrides any allows\.
+ **Action**: The action is the specific AWS SMS API action for which you are granting or denying permission\.
+ **Resource**: The resource that's affected by the action\. For AWS SMS, you must specify "\*" as the resource\.
+ **Condition**: Conditions are optional\. They can be used to control when your policy is in effect\.

## Example policies<a name="iam-policy-examples"></a>

In an IAM policy statement, you can specify any API action from any service that supports IAM\. For AWS SMS, use the following prefix with the name of the API action: `sms:` as follows\.

```
"Action": "sms:UpdateReplicationJob"
```

To specify multiple actions in a single statement, separate them with commas as follows\.

```
{
  "Statement":[
    {
      "Effect": "Allow",
      "Action": ["sms:action1", "sms:action2"],
      "Resource": "*"
    }
  ]
}
```

You can also specify multiple actions using wildcards\. For example, you can specify all AWS SMS API actions whose name begins with the word "Get" as follows\.

```
{
  "Statement":[
    {
      "Effect": "Allow",
      "Action": "sms:Get*",
      "Resource": "*"
    }
  ]
}
```

To specify all AWS SMS API actions, use the \* wildcard as follows\.

```
{
  "Statement":[
    {
      "Effect": "Allow",
      "Action": "sms:*",
      "Resource": "*"
    }
  ]
}
```

The following statement restricts users from launching an application by enabling automatic launch after replication\.

```
{
  "Statement":[
    {
      "Effect": "Deny",
      "Action": "sms:LaunchApp",
      "Resource": "*"
    }
  ]
}
```

## Predefined AWS managed policies<a name="elb-predefined-policies"></a>

The managed policies created by AWS grant the required permissions for common use cases\. You can attach these policies to your IAM users, based on the access to AWS that they require\.

To grant an IAM user full access to AWS SMS features, attach the following policy: **ServerMigrationServiceConsoleFullAccess**\.