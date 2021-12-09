# Controlling Access to Elastic Transcoder<a name="access-control"></a>

Elastic Transcoder lets you use AWS Identity and Access Management \(IAM\) to control what users can do with Elastic Transcoder, and to control Elastic Transcoder's access to other AWS services that Elastic Transcoder requires\. You control access using IAM policies, which are a collection of permissions that can be associated with a user, an IAM group, or a role\. 

**Topics**
+ [Controlling User Access to Elastic Transcoder](#access-control-users)
+ [Service Roles for Elastic Transcoder Pipelines](#access-control-roles)

## Controlling User Access to Elastic Transcoder<a name="access-control-users"></a>

To control what users can do with Elastic Transcoder \(for example, who is allowed to create and manage pipelines and jobs\), you can create policies for users\. For IAM users in your account, you can attach the policy directly to the IAM user or to an IAM group\. If you are granting permissions to an IAM user in another AWS account, known as delegation, or to users signing in from an external identity system, known as federation, you can attach the policy to a role and allow the user to assume that role\. For more information on delegation and federation, see [Roles \(Delegation and Federation\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/WorkingWithRoles.html) in the *IAM User Guide*\.

To control Elastic Transcoder's access to other AWS services, you can create service roles\. These are IAM roles that you assign when you create a pipeline, and that give Elastic Transcoder itself permissions to perform the tasks associated with transcoding\. 

As an example of how user and service roles are both important during the transcoding process, Elastic Transcoder needs a service role in order to get files from an Amazon S3 bucket and store the transcoded files in another Amazon S3 bucket, while a user needs an IAM role that allows them to create a job in Elastic Transcoder\.

For more information about IAM, see the *[IAM User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/)*\. For more information about service roles, see [Creating a Role for an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/create-role-xacct.html)\.

### Example User Policies for Elastic Transcoder<a name="access-control-example-policy"></a>

To allow users to perform Elastic Transcoder administrative functions, such as creating pipelines and running jobs, you must have a policy that you can associate with the user\. This section shows three policies for controlling access to Elastic Transcoder operations and to the operations of related services that Elastic Transcoder relies on\. You can give users of your AWS account access to all Elastic Transcoder operations or to only a subset of them\.

To use these policies with an IAM user, you attach them directly to the IAM user or to an IAM group that the user belongs to\. To use these policies with a delegated or federated user, you attach them to an IAM role that the delegated or federated user will assume\. 

For more information on managing policies, see [Managing IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html) in the *IAM User Guide*\.

#### Give Users Read\-only Access to Elastic Transcoder and Amazon S3<a name="access-control-example-3"></a>

The following policy grants users read\-only access to Elastic Transcoder resources and access to the list operation of Amazon S3\. This policy is useful for users who need permissions to find and watch transcoded files and to see what buckets are available to the IAM account, but who don't need the ability to update, create, or delete resources or files\. This policy also allows a user to list all available pipelines, presets, and jobs for the IAM account\. To restrict access to a particular bucket, see [Restricting Users to Certain Resources](#access-control-resources)\.

```
{
   "Version":"2012-10-17",
   "Statement": [
      {
         "Effect": "Allow",
         "Action": [
            "elastictranscoder:Read*",
            "elastictranscoder:List*",
            "s3:List*"
         ],
         "Resource": "*"
      }
   ]
}
```

#### Give Users Permission to Create Jobs<a name="access-control-example-2"></a>

The following policy grants users the permissions to list and get all Elastic Transcoder resources associated with the account, create or modify jobs and presets, and use the list operations of Amazon S3 and Amazon SNS\. 

This policy is useful for users who need the ability to modify transcoding settings, and the ability to create or delete presets or jobs\. It does not allow the user to create, update, or delete pipelines, Amazon S3 buckets, or Amazon SNS notifications\.

```
{
    "Version":"2012-10-17",
    "Statement": [
       {
           "Effect": "Allow",
           "Action": [
               "elastictranscoder:Read*",
               "elastictranscoder:List*",
               "elastictranscoder:*Job",
               "elastictranscoder:*Preset",
               "s3:List*",
               "sns:List*"
           ],
           "Resource": "*"
       }
    ]
}
```

#### Give Users Broad Access to Elastic Transcoder and Related Services<a name="access-control-example-1"></a>

The following policy lets users perform any Elastic Transcoder or CloudFront action, manage Amazon S3 buckets, create and list IAM roles, and create and list Amazon SNS notifications\.

This policy is useful for users who are administrators for Elastic Transcoder\.

We strongly recommend that for extra security, users who have administrative permissions use multi\-factor authentication \(MFA\)\. For more information, see [Using Multi\-Factor Authentication \(MFA\) Devices with AWS](https://docs.aws.amazon.com/IAM/latest/UserGuide/Using_ManagingMFA.html) in the *IAM User Guide*\.

**Important**  
We recommend that you do not add policies to IAM roles that include permissions for IAM actions\. The policy illustrated here is useful for IAM users in your own account, but should not be assigned to a role that can be assumed by users in another account or by a federated user\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Effect":"Allow",
         "Action": [
            "elastictranscoder:*",
            "cloudfront:*",
            "s3:List*",
            "s3:Put*",
            "s3:Get*",
            "s3:*MultipartUpload*",
            "iam:CreateRole",
            "iam:PutRolePolicy",
            "iam:GetRolePolicy",
            "iam:List*",
            "sns:CreateTopic",
            "sns:List*"
         ],
         "Resource":[
            "*"
         ]
      }
   ]
}
```

#### Elastic Transcoder Operations with Controllable Access<a name="operations-list"></a>

The following is the full list of Elastic Transcoder operations\.

```
    elastictranscoder:CancelJob
    elastictranscoder:CreateJob
    elastictranscoder:CreatePipeline
    elastictranscoder:CreatePreset
    elastictranscoder:DeletePipeline
    elastictranscoder:DeletePreset
    elastictranscoder:ListJobsByPipeline
    elastictranscoder:ListJobsByStatus
    elastictranscoder:ListPipelines
    elastictranscoder:ListPresets
    elastictranscoder:ReadJob
    elastictranscoder:ReadPipeline
    elastictranscoder:ReadPreset
    elastictranscoder:TestRole
    elastictranscoder:UpdatePipeline
    elastictranscoder:UpdatePipelineNotifications
    elastictranscoder:UpdatePipelineStatus
```

### Restricting Users to Certain Resources<a name="access-control-resources"></a>

In addition to restricting access to operations \(actions\), you can further restrict access to specific jobs, pipelines, and presets, which is referred to as granting resource\-level permissions\.

To restrict or grant access to a subset of Elastic Transcoder resources, put the ARN of the resource in the resource element of your policy\. Elastic Transcoder ARNs have the following general format:

```
arn:aws:elastictranscoder:region:account:resource/ID
```

Replace the *region*, *account*, *resource*, and *ID* variables with valid values\. Valid values can be the following:
+ *region*: The name of the region\. A list of regions is available [here](https://docs.aws.amazon.com/general/latest/gr/rande.html#elastictranscoder_region)\. To indicate all regions, use a wildcard \(\*\)\. You must specify a value\.
+ *account*: The ID of the AWS account\. You must specify a value\.
+ *resource*: The type of Elastic Transcoder resource; `preset`, `pipeline`, or `job`\.
+ *ID*: The ID of the specific preset, pipeline, or job, or \* to indicate all resources of the specified type that are associated with the current AWS account\.

For example, the following ARN specifies all preset resources in the `us-east-2` region for the account `111122223333`:

```
arn:aws:elastictranscoder:us-east-2:111122223333:preset/*
```

You can find the ARN of a resource by clicking the magnifying\-glass icon \( ![\[Image NOT FOUND\]](http://docs.aws.amazon.com/elastictranscoder/latest/developerguide/images/magnifying-glass-icon.png) \) next to the resource name in the pipeline, preset, or job console pages\.

For more information, see [Resources](https://docs.aws.amazon.com/IAM/latest/UserGuide/AccessPolicyLanguage_ElementDescriptions.html#Resource) in the *IAM User Guide*\.

#### Example Policy for Restricting Resources for Users<a name="access-control-resources-example"></a>

The following policy grants permissions to the bucket named `example_bucket` in Amazon S3, list and read permissions for everything in Elastic Transcoder, and permission to create jobs in the pipeline named `example_pipeline`\.

This policy is useful for SDK and CLI users who need to be able to see what files and resources are available, and use those resources to create their own transcoding jobs\. It does not allow for updating or deleting resources, creating resources other than jobs, or for working with resources other than the ones specified here, and will not work for console users\.

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"1",
         "Effect":"Allow",
         "Action":[
            "s3:ListAllMyBuckets",
            "s3:GetBucketLocation",
            "s3:ListBucket",
            "s3:GetObject",
            "s3:PutObject"
            ],
         "Resource":[
             "arn:aws:s3:::example_bucket",
             "arn:aws:s3:::example_bucket/*"
         ]
      },
      {
         "Sid":"2",
         "Effect":"Allow",
         "Action":[
            "elastictranscoder:List*",
            "elastictranscoder:Read*",
            "elastictranscoder:CreateJob"
         ],
         "Resource":[
            "arn:aws:elastictranscoder:region:account:pipeline/example_pipeline",
            "arn:aws:elastictranscoder:region:account:job/*"
         ]
      }
   ]
}
```

## Service Roles for Elastic Transcoder Pipelines<a name="access-control-roles"></a>

When you create a pipeline that manages your transcoding jobs, you must specify an IAM service role\. The IAM service role has a policy that specifies the permissions used by that pipeline for transcoding\.

You have two options when you specify a role for a pipeline: 
+ Use the default role, which includes only the permissions that Elastic Transcoder needs for transcoding\. If you use the Elastic Transcoder console to create your pipelines, when you create your first pipeline the console gives you the option to create the default role automatically\. You must have administrative permissions to create IAM service roles, including the default role\.
+ Choose an existing role\. In this case, you must have previously created the role in IAM and attached a policy to the role that gives Elastic Transcoder sufficient permissions to transcode your files\. This is useful if you want to use the role for other AWS services as well\.

### The Default IAM Role for Pipelines<a name="access-control-default-policy"></a>

The default role created by Elastic Transcoder lets Elastic Transcoder perform the following operations:
+ Get a file from an Amazon S3 bucket for transcoding\.
+ List the contents of any Amazon S3 bucket\.
+ Save a transcoded file to an Amazon S3 bucket\.
+ Create an Amazon S3 multipart upload\.
+ Publish notification to any SNS topic\.

The policy prevents Elastic Transcoder from performing any of the following operations:
+ Perform any Amazon SNS delete operations, or add or remove a policy statement in a topic\.
+ Perform any Amazon S3 bucket or item delete operations, or add, remove, or modify a bucket policy\.

The access \(permission\) policy definition for the default role looks like:

```
{
   "Version":"2012-10-17",
   "Statement":[
      {
         "Sid":"1",
         "Effect":"Allow",
         "Action":[
            "s3:Get*",
            "s3:ListBucket",
            "s3:Put*",
            "s3:*MultipartUpload*"
         ],
         "Resource":"*"
      },
      {
         "Sid":"2",
         "Effect":"Allow",
         "Action":"sns:Publish",
         "Resource":"*"
      },
      {
         "Sid":"3",
         "Effect":"Deny",
         "Action":[
            "sns:*Permission*",
            "sns:*Delete*",
            "sns:*Remove*",
            "s3:*Policy*",
            "s3:*Delete*"
         ],
         "Resource":"*"
      }
   ]
}
```

#### Supported Regions for Elastic Transcoder Service\-Linked Roles<a name="slr-regions"></a>

Elastic Transcoder supports using service\-linked roles in the following regions\.


****  

| Region Name | Region Identity | Support in Elastic Transcoder | 
| --- | --- | --- | 
| US East \(N\. Virginia\) | us\-east\-1 | Yes | 
| US East \(Ohio\) | us\-east\-2 | No | 
| US West \(N\. California\) | us\-west\-1 | Yes | 
| US West \(Oregon\) | us\-west\-2 | Yes | 
| Asia Pacific \(Mumbai\) | ap\-south\-1 | Yes | 
| Asia Pacific \(Osaka\-Local\) | ap\-northeast\-3 | No | 
| Asia Pacific \(Seoul\) | ap\-northeast\-2 | No | 
| Asia Pacific \(Singapore\) | ap\-southeast\-1 | Yes | 
| Asia Pacific \(Sydney\) | ap\-southeast\-2 | Yes | 
| Asia Pacific \(Tokyo\) | ap\-northeast\-1 | Yes | 
| Canada \(Central\) | ca\-central\-1 | No | 
| EU \(Frankfurt\) | eu\-central\-1 | No | 
| EU \(Ireland\) | eu\-west\-1 | Yes | 
| EU \(London\) | eu\-west\-2 | No | 
| EU \(Paris\) | eu\-west\-3 | No | 
| South America \(São Paulo\) | sa\-east\-1 | No | 