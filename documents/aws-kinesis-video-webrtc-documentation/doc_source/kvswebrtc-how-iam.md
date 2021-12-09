# Controlling Access to Kinesis Video Streams with WebRTC Resources Using IAM<a name="kvswebrtc-how-iam"></a>

By using AWS Identity and Access Management \(IAM\) with Amazon Kinesis Video Streams with WebRTC, you can control whether users in your organization can perform a task using specific Kinesis Video Streams with WebRTC API operations and whether they can use specific AWS resources\. 

For more information about IAM, see the following:
+ [AWS Identity and Access Management \(IAM\)](https://aws.amazon.com/iam/)
+ [Getting Started](https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started.html)
+ [IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)

**Topics**
+ [Policy Syntax](#policy-syntax)
+ [Actions for Kinesis Video Streams with WebRTC](#kinesis-using-iam-actions)
+ [Amazon Resource Names \(ARNs\) for Kinesis Video Streams](#kinesis-using-iam-arn-format)
+ [Granting Other IAM Accounts Access to a Kinesis Video Stream](#how-iam-crossaccount)
+ [Example Policies for Kinesis Video Streams with WebRTC](#how-iam-policies)

## Policy Syntax<a name="policy-syntax"></a>

An IAM policy is a JSON document that consists of one or more statements\. Each statement is structured as follows:

```
{
  "Statement":[{
    "Effect":"effect",
    "Action":"action",
    "Resource":"arn",
    "Condition":{
      "condition":{
        "key":"value"
        }
      }
    }
  ]
}
```

There are various elements that make up a statement:
+ **Effect:** The *effect* can be `Allow` or `Deny`\. By default, IAM users don't have permission to use resources and API actions, so all requests are denied\. An explicit allow overrides the default\. An explicit deny overrides any allows\.
+ **Action**: The *action* is the specific API action for which you are granting or denying permission\.
+ **Resource**: The resource that's affected by the action\. To specify a resource in the statement, you need to use its Amazon Resource Name \(ARN\)\.
+ **Condition**: Conditions are optional\. They can be used to control when your policy is in effect\.

As you create and manage IAM policies, you might want to use the [IAM Policy Generator](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-generator) and the [IAM Policy Simulator](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_testing-policies.html)\.

## Actions for Kinesis Video Streams with WebRTC<a name="kinesis-using-iam-actions"></a>

In an IAM policy statement, you can specify any API action from any service that supports IAM\. For Kinesis Video Streams with WebRTC, use the following prefix with the name of the API action: `kinesisvideo:`\. For example: `kinesisvideo:CreateSignalingChannel`, `kinesisvideo:ListSignalingChannels`, and `kinesisvideo:DescribeSignalingChannel`\.

To specify multiple actions in a single statement, separate them with commas as follows:

```
"Action": ["kinesisvideo:action1", "kinesisvideo:action2"]
```

You can also specify multiple actions using wildcards\. For example, you can specify all actions whose name begins with the word "Get" as follows:

```
"Action": "kinesisvideo:Get*"
```

To specify all Kinesis Video Streams operations, use the asterisk \(\*\) wildcard as follows:

```
"Action": "kinesisvideo:*"
```

For the complete list of Kinesis Video Streams API actions, see the [https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Reference.html](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_Reference.html)\.

## Amazon Resource Names \(ARNs\) for Kinesis Video Streams<a name="kinesis-using-iam-arn-format"></a>

Each IAM policy statement applies to the resources that you specify using their ARNs\.

Use the following ARN resource format for Kinesis Video Streams:

```
arn:aws:kinesisvideo:region:account-id:channel/channel-name/code
```

For example:

```
"Resource": arn:aws:kinesisvideo::*:111122223333:channel/my-channel/0123456789012
```

You can get the ARN of a channel using [DescribeSignalingChannel](https://docs.aws.amazon.com/kinesisvideostreams/latest/dg/API_DescribeStream.html)\.

## Granting Other IAM Accounts Access to a Kinesis Video Stream<a name="how-iam-crossaccount"></a>

You might need to grant permission to other IAM accounts to perform operations on Kinesis Video Streams with WebRTC signaling channels\. The following overview describes the general steps to grant access to channels across accounts:

1. Get the 12\-digit account ID of the account that you want to grant permissions to perform operations on your channel \(for example, 111111111111\)\.

1. Create a managed policy on the account that owns the channel that allows the level of access that you want to grant\. For example policies for Kinesis Video Streams resources, see [Example Policies](#how-iam-policies) in the next section\.

1. Create a role, specifying the account to which you are granting permissions, and attach the policy that you created in the previous step\.

1. Create a managed policy that allows the `AssumeRole` action on the role you created in the previous step\. For example, the role might look like the following:

   ```
   {
     "Version": "2012-10-17",
     "Statement": {
       "Effect": "Allow",
       "Action": "sts:AssumeRole",
       "Resource": "arn:aws:iam::123456789012:role/CustomRole"
     }
   }
   ```

For step\-by\-step instructions on granting cross\-account access, see [Delegate Access Across AWS Accounts Using IAM Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/tutorial_cross-account-with-roles.html)\.

## Example Policies for Kinesis Video Streams with WebRTC<a name="how-iam-policies"></a>

The following example policies demonstrate how you can control user access to your Kinesis Video Streams with WebRTC channels\.

**Example 1: Allow users to get data from any signaling channel**  
This policy allows a user or group to perform the `DescribeSignalingChannel`, `GetSignalingChannelEndpoint`, `ListSignalingChannels`, and `ListTagsForResource` operations on any signaling channel\.   

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kinesisvideo:Describe*",
                "kinesisvideo:Get*",
                "kinesisvideo:List*"
            ],
            "Resource": "*"
        }
    ]
}
```

**Example 2: Allow a user to create a signaling channel**  
This policy allows a user or group to perform the `CreateSignalingChannel` operation\.  

```
{
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kinesisvideo:CreateSignalingChannel"          
            ],
            "Resource": "*"
        }
    ]
}
```

**Example 3: Allow a user full access to all Kinesis Video Streams and Kinesis Video Streams with WebRTC resources**  
This policy allows a user or group to perform any Kinesis Video Streams operation on any resource\. This policy is appropriate for administrators\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "kinesisvideo:*",
            "Resource": "*"
        }
    ]
}
```

**Example 4: Allow a user to get data from a specific signaling channel**  
This policy allows a user or group to get data from a specific signaling channel\.  

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "kinesisvideo:DescribeSignalingChannel",
            "Resource": "arn:aws:kinesisvideo:us-west-2:123456789012:channel/channel_name/0123456789012"
        }
    ]
}
```