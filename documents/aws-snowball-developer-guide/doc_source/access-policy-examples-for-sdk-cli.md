--------

This guide is for the Snowball Edge\. If you are looking for documentation for the Snowball, see the [AWS Snowball User Guide](https://docs.aws.amazon.com/snowball/latest/ug/whatissnowball.html)\.

--------

# Customer Managed Policy Examples<a name="access-policy-examples-for-sdk-cli"></a>

In this section, you can find example user policies that grant permissions for various AWS Snowball job management actions\. These policies work when you are using AWS SDKs or the AWS CLI\. When you are using the console, you need to grant additional permissions specific to the console, which is discussed in [Permissions Required to Use the AWS Snowball Console](access-control-managing-permissions.md#additional-console-required-permissions)\.

**Note**  
All examples use the us\-west\-2 region and contain fictitious account IDs\.

**Topics**
+ [Example 1: Role Policy That Allows a User to Create a Job with the API](#access-policy-example-create-api)
+ [Example 2: Role Policy for Creating Import Jobs](#role-policy-example-import)
+ [Example 3: Role Policy for Creating Export Jobs](#role-policy-example-export)
+ [AWS Snowball API Permissions: Actions, Resources, and Conditions Reference](#snowball-api-permissions-ref)

## Example 1: Role Policy That Allows a User to Create a Job with the API<a name="access-policy-example-create-api"></a>

The following permissions policy is a necessary component of any policy that is used to grant job or cluster creation permission using the job management API\. The user also needs some or all of the permissions specified in [Permissions Required to Use the AWS Snowball Console](access-control-managing-permissions.md#additional-console-required-permissions), depending on the type of job created\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "",
      "Effect": "Allow",
      "Principal": {
        "Service": "importexport.amazonaws.com"
      },
      "Action": "sts:AssumeRole",
      "Condition": {
        "StringEquals": {
          "sts:ExternalId": "AWSIE"
        }
      }
    }
  ]
}
```

## Example 2: Role Policy for Creating Import Jobs<a name="role-policy-example-import"></a>

You use the following role trust policy for creating import jobs for Snowball Edge that use AWS Lambda powered by AWS Greengrass functions\.

```
                    {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketLocation",
                "s3:ListBucketMultipartUploads"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketPolicy",
                "s3:PutObject",
                "s3:AbortMultipartUpload",
                "s3:ListMultipartUploadParts",
                "s3:PutObjectAcl"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "snowball:*"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "iot:AttachPrincipalPolicy",
                "iot:AttachThingPrincipal",
                "iot:CreateKeysAndCertificate",
                "iot:CreatePolicy",
                "iot:CreateThing",
                "iot:DescribeEndpoint",
                "iot:GetPolicy"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "lambda:GetFunction"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "greengrass:CreateCoreDefinition",
                "greengrass:CreateDeployment",
                "greengrass:CreateDeviceDefinition",
                "greengrass:CreateFunctionDefinition",
                "greengrass:CreateGroup",
                "greengrass:CreateGroupVersion",
                "greengrass:CreateLoggerDefinition",
                "greengrass:CreateSubscriptionDefinition",
                "greengrass:GetDeploymentStatus",
                "greengrass:UpdateGroupCertificateConfiguration",
                "greengrass:CreateGroupCertificateAuthority",
                "greengrass:GetGroupCertificateAuthority",
                "greengrass:ListGroupCertificateAuthorities",
                "greengrass:ListDeployments", 
                "greengrass:GetGroup", 
                "greengrass:GetGroupVersion", 
                "greengrass:GetCoreDefinitionVersion"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

## Example 3: Role Policy for Creating Export Jobs<a name="role-policy-example-export"></a>

You use the following role trust policy for creating export jobs for Snowball Edge that use AWS Lambda powered by AWS Greengrass functions\.

```
                    {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetBucketLocation",
                "s3:GetObject",
                "s3:ListBucket"
            ],
            "Resource": "arn:aws:s3:::*"
        },
        {
           "Effect": "Allow",
           "Action": [
                "snowball:*"
           ],
           "Resource": [
                "*"
           ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "iot:AttachPrincipalPolicy",
                "iot:AttachThingPrincipal",
                "iot:CreateKeysAndCertificate",
                "iot:CreatePolicy",
                "iot:CreateThing",
                "iot:DescribeEndpoint",
                "iot:GetPolicy"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "lambda:GetFunction"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "greengrass:CreateCoreDefinition",
                "greengrass:CreateDeployment",
                "greengrass:CreateDeviceDefinition",
                "greengrass:CreateFunctionDefinition",
                "greengrass:CreateGroup",
                "greengrass:CreateGroupVersion",
                "greengrass:CreateLoggerDefinition",
                "greengrass:CreateSubscriptionDefinition",
                "greengrass:GetDeploymentStatus",
                "greengrass:UpdateGroupCertificateConfiguration",
                "greengrass:CreateGroupCertificateAuthority",
                "greengrass:GetGroupCertificateAuthority",
                "greengrass:ListGroupCertificateAuthorities",
                "greengrass:ListDeployments", 
                "greengrass:GetGroup", 
                "greengrass:GetGroupVersion", 
                "greengrass:GetCoreDefinitionVersion"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```

## AWS Snowball API Permissions: Actions, Resources, and Conditions Reference<a name="snowball-api-permissions-ref"></a>

When you are setting up [Access Control in the AWS Cloud](access-control.md) and writing a permissions policy that you can attach to an IAM identity \(identity\-based policies\), you can use the following table as a reference\. The table following each AWS Snowball job management API operation and the corresponding actions for which you can grant permissions to perform the action\. It also includes for each API operation the AWS resource for which you can grant the permissions\. You specify the actions in the policy's `Action` field, and you specify the resource value in the policy's `Resource` field\. 

You can use AWS\-wide condition keys in your AWS Snowball policies to express conditions\. For a complete list of AWS\-wide keys, see [Available Keys](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements.html#AvailableKeys) in the *IAM User Guide*\. 

**Note**  
To specify an action, use the `snowball:` prefix followed by the API operation name \(for example, `snowball:CreateJob`\)\.

Use the scroll bars to see the rest of the table\.


**AWS Snowball Job Management API and Required Permissions for Actions**  

| Job Management API Actions | Required Permissions | 
| --- | --- | 
|   [CancelCluster](https://docs.aws.amazon.com/snowball/latest/api-reference/API_CancelCluster.html)   | snowball:CancelCluster | 
|   [CancelJob](https://docs.aws.amazon.com/snowball/latest/api-reference/API_CancelJob.html)  |  `snowball:CancelJob`  | 
|   [CreateAddress](https://docs.aws.amazon.com/snowball/latest/api-reference/API_CreateAddress.html)  | snowball:CreateAddress | 
|   [CreateCluster](https://docs.aws.amazon.com/snowball/latest/api-reference/API_CreateCluster.html)  | This action requires the following permissions: [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/developer-guide/access-policy-examples-for-sdk-cli.html) | 
|   [CreateJob](https://docs.aws.amazon.com/snowball/latest/api-reference/API_CreateJob.html)  |  [\[See the AWS documentation website for more details\]](http://docs.aws.amazon.com/snowball/latest/developer-guide/access-policy-examples-for-sdk-cli.html) | 
|   [DescribeAddress](https://docs.aws.amazon.com/snowball/latest/api-reference/API_DescribeAddress.html)  | snowball:DescribeAddress | 
|   [DescribeAddresses](https://docs.aws.amazon.com/snowball/latest/api-reference/API_DescribeAddresses.html)  | snowball:DescribeAddresses | 
|   [DescribeCluster](https://docs.aws.amazon.com/snowball/latest/api-reference/API_DescribeCluster.html)  | snowball:DescribeCluster | 
|   [DescribeJob](https://docs.aws.amazon.com/snowball/latest/api-reference/API_DescribeJob.html)  | snowball:DescribeJob | 
|   [GetJobManifest](https://docs.aws.amazon.com/snowball/latest/api-reference/API_GetJobManifest.html)  | snowball:GetJobManifest | 
|   [GetJobUnlockCode](https://docs.aws.amazon.com/snowball/latest/api-reference/API_GetJobUnlockCode.html)  | snowball:GetJobUnlockCode | 
|   [GetSnowballUsage](https://docs.aws.amazon.com/snowball/latest/api-reference/API_GetSnowballUsage.html)  | snowball:GetSnowballUsage | 
|   [ListClusterJobs](https://docs.aws.amazon.com/snowball/latest/api-reference/API_ListClusterJobs.html)  | snowball:ListClusterJobs | 
|   [ListClusters](https://docs.aws.amazon.com/snowball/latest/api-reference/API_ListClusters.html)  | snowball:ListClusters | 
|   [ListJobs](https://docs.aws.amazon.com/snowball/latest/api-reference/API_ListJobs.html)  | snowball:ListJobs | 
|   [UpdateCluster](https://docs.aws.amazon.com/snowball/latest/api-reference/API_UpdateCluster.html)  | snowball:UpdateCluster | 
|   [UpdateJob](https://docs.aws.amazon.com/snowball/latest/api-reference/API_UpdateJob.html)  | snowball:UpdateJob | 