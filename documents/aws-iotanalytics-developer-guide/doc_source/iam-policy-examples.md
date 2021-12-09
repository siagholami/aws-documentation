# AWS IoT Analytics identity\-based policy examples<a name="iam-policy-examples"></a>

By default, IAM users and roles don't have permission to create or modify AWS IoT Analytics resources\. They also can't perform tasks using the AWS Management Console, AWS CLI, or AWS API\. An IAM administrator must create IAM policies that grant users and roles permission to perform specific API operations on the specified resources they need\. The administrator must then attach those policies to the IAM users or groups that require those permissions\.

To learn how to create an IAM identity\-based policy using these example JSON policy documents, see [Creating policies on the JSON tab](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html#access_policies_create-json-editor) in the *IAM User Guide*

**Topics**
+ [Policy best practices](#iam-policy-best-practices)
+ [Using the AWS IoT Analytics console](#iam-id-based-policy-examples-console)
+ [Allow users to view their own permissions](#iam-view-permissions)
+ [Accessing one AWS IoT Analytics input](#iam-access-one-input)
+ [Viewing AWS IoT Analytics channels based on tags](#iam-view-input-tags)

## Policy best practices<a name="iam-policy-best-practices"></a>

Identity\-based policies are very powerful\. They determine whether someone can create, access, or delete AWS IoT Analytics resources in your account\. These actions can incur costs for your AWS account\. When you create or edit identity\-based policies, follow these guidelines and recommendations:
+ **Get started using AWS managed policies** \- To start using AWS IoT Analytics quickly, use AWS managed policies to give your employees the permissions they need\. These policies are already available in your account and are maintained and update by AWS\. For more information, see [Get started using permissions with AWS managed policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#bp-use-aws-defined-policies) in the *IAM User Guide*\.
+ **Grant least privilege** \- When you create custom policies, grant only the permissions required to perform a task\. Start with a minimum set of permissions and grant additional permissions as necessary\. Doing so is more secure than starting with permissions that are too lenient and then trying to tighten them later\. For more information, see [Grant least privilege](https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#grant-least-privilege) in the *IAM User Guide*\.
+ **Enable MFA for sensitive operations** \- For extra security, require IAM users to use multi\-factor authentication \(MFA\) to access sensitive resources or API operations\. For more information, see [Using multi\-factor authentication \(MFA\) in AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_mfa.html) in the *IAM User Guide*\.
+ **Use policy conditions for extra security** \- To the extent that it's practical, define the conditions under which your identity\-based policies allow access to a resource\. For example, you can write condition to specify a range of allowable IP addresses that a request must come from\. You can also write conditions to allow requests only within a specified date or time range, or to require the use of SSL or MFA\. For more information, see [IAM JSON policy elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.

## Using the AWS IoT Analytics console<a name="iam-id-based-policy-examples-console"></a>

To access the AWS IoT Analytics console, you must have a minimum set of permissions\. These permissions must allow you to list and view details about the AWS IoT Analytics resources in your AWS account\. If you create an identity\-based policy that is more restrictive than the minimum required permissions\. the console won't function as intended for entities \(IAM users or roles\) with that policy\.

To ensure that those entities can still use the AWS IoT Analytics console, also attach the following AWS managed policy to the entities\. For more information, see [Adding permissions to a user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#users_change_permissions-add-console) in the *IAM User Guide*\.

```
{
     "Version": "2012-10-17",
     "Statement": [
         {
             "Effect": "Allow",
             "Action": [
                 "iotanalytics:BatchPutMessage",
                 "iotanalytics:CancelPipelineReprocessing",
                 "iotanalytics:CreateChannel",
                 "iotanalytics:CreateDataset",
                 "iotanalytics:CreateDatasetContent",
                 "iotanalytics:CreateDatastore",
                 "iotanalytics:CreatePipeline",
                 "iotanalytics:DeleteChannel",
                 "iotanalytics:DeleteDataset",
                 "iotanalytics:DeleteDatasetContent",
                 "iotanalytics:DeleteDatastore",
                 "iotanalytics:DeletePipeline",
                 "iotanalytics:DescribeChannel",
                 "iotanalytics:DescribeDataset",
                 "iotanalytics:DescribeDatastore",
                 "iotanalytics:DescribeLoggingOptions",
                 "iotanalytics:DescribePipeline",
                 "iotanalytics:GetDatasetContent",
                 "iotanalytics:ListChannels",
                 "iotanalytics:ListDatasetContents",
                 "iotanalytics:ListDatasets",
                 "iotanalytics:ListDatastores",
                 "iotanalytics:ListPipelines",
                 "iotanalytics:ListTagsForResource",
                 "iotanalytics:PutLoggingOptions",
                 "iotanalytics:RunPipelineActivity",
                 "iotanalytics:SampleChannelData",
                 "iotanalytics:StartPipelineReprocessing",
                 "iotanalytics:TagResource",
                 "iotanalytics:UntagResource",
                 "iotanalytics:UpdateChannel",
                 "iotanalytics:UpdateDataset",
                 "iotanalytics:UpdateDatastore",
                 "iotanalytics:UpdatePipeline"
             ],
             "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:channel/${channelName}",
             "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:dataset/${datasetName}",
             "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:datastore/${datastoreName}",
             "Resource": "arn:${Partition}:iotanalytics:${Region}:${Account}:pipeline/${pipelineName}"
         }
     ]
 }
```

You don't need to allow minimum console permissions for users that are making calls only to the AWS CLI or the AWS API\. Instead, allow access to only the actions that match the API operation that you're trying to perform\.

## Allow users to view their own permissions<a name="iam-view-permissions"></a>

This example shows how you might create a policy that allows IAM users to view the inline and managed policies that are attached to their user identity\. This policy includes permissions to complete this action on the console or programmatically using the AWS CLI or AWS API\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ViewOwnUserInfo",
            "Effect": "Allow",
            "Action": [
                "iam:GetUserPolicy",
                "iam:ListGroupsForUser",
                "iam:ListAttachedUserPolicies",
                "iam:ListUserPolicies",
                "iam:GetUser"
            ],
            "Resource": [
                "arn:aws:iam::*:user/${aws:username}"
            ]
        },
        {
            "Sid": "NavigateInConsole",
            "Effect": "Allow",
            "Action": [
                "iam:GetGroupPolicy",
                "iam:GetPolicyVersion",
                "iam:GetPolicy",
                "iam:ListAttachedGroupPolicies",
                "iam:ListGroupPolicies",
                "iam:ListPolicyVersions",
                "iam:ListPolicies",
                "iam:ListUsers"
            ],
            "Resource": "*"
        }
    ]
}
```

## Accessing one AWS IoT Analytics input<a name="iam-access-one-input"></a>

In this example, you want to grant an IAM user in your AWS account access to one of your AWS IoT Analytics channels, `exampleChannel`\. You also want to allow the use to add, update, and delete channels\.

The policy grants the `iotanalytics:ListChannels, iotanalytics:DescribeChannel, iotanalytics:CreateChannel, iotanalytics:DeleteChannel, and iotanalytics:UpdateChannel` permissions to the user\. For an example walkthrough for the Amazon S3 service that grants permissions to users and tests them using the console, see [An example walkthrough: Using user policies to control access to your bucket](https://docs.aws.amazon.com/AmazonS3/latest/dev/walkthrough1.html)\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"ListChannelsInConsole",
         "Effect":"Allow",
         "Action":[
            "iotanalytics:ListChannels"
         ],
         "Resource":"arn:aws:iotanalytics:::*"
      },
      {
         "Sid":"ViewSpecificChannelInfo",
         "Effect":"Allow",
         "Action":[
            "iotanalytics:DescribeChannel"
         ],
         "Resource":"arn:aws:iotanalytics:::exampleChannel"
      },
      {
         "Sid":"ManageChannels",
         "Effect":"Allow",
         "Action":[
            "iotanalytics:CreateChannel",
            "iotanalytics:DeleteChannel",
            "iotanalytics:DescribeChannel",
            "iotanalytics:ListChannels",
            "iotanalytics:UpdateChannel"
         ],
         "Resource":"arn:aws:iotanalytics:::exampleChannel/*"
      }
   ]
}
```

## Viewing AWS IoT Analytics channels based on tags<a name="iam-view-input-tags"></a>

You can use conditions in your identity\-based policy to control access to AWS IoT Analytics resources based on tags\. This example shows how you might create a policy that allows viewing a `channel`\. However, permissions is granted only if the `channel` tag `Owner` has the value of that user's user name\. This policy also grants the permissions needed to complete this action on the console\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "ListChannelsInConsole",
            "Effect": "Allow",
            "Action": "iotanalytics:ListChannels",
            "Resource": "*"
        },
        {
            "Sid": "ViewChannelsIfOwner",
            "Effect": "Allow",
            "Action": "iotanalytics:ListChannels",
            "Resource": "arn:aws:iotanalytics:*:*:channel/*",
            "Condition": {
                "StringEquals": {"iotanalytics:ResourceTag/Owner": "${aws:username}"}
            }
        }
    ]
}
```

You can attach this policy to the IAM users in your account\. If a user named `richard-roe` attempts to view an AWS IoT Analytics `channel`, the `channel` must be tagged `Owner=richard-roe or owner=richard-roe`\. Otherwise, he is denied access\. The condition tag key `Owner` matches both `Owner` and `owner` because condition key names are not case sensitive\. For more information, see [IAM JSON policy elements: Condition](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition.html) in the *IAM User Guide*\.