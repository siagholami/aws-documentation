# Security<a name="sc-introduction"></a>

You can secure the management of your models and the `DetectCustomLabels` API that your customers use to detect custom labels\. 

For more information about securing Amazon Rekognition, see [Amazon Rekognition Security](https://docs.aws.amazon.com/rekognition/latest/dg/security.html)\.

## Securing Amazon Rekognition Custom Labels Projects<a name="sc-resources"></a>

You can secure your Amazon Rekognition Custom Labels projects by specifying the resource\-level permissions that are specified in identity\-based policies\. For more information, see [Identity\-Based Policies and Resource\-Based Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_identity-vs-resource.html)\. 

The Amazon Rekognition Custom Labels resources that you can secure are:


| Resource | Amazon Resource Name Format | 
| --- | --- | 
|  Project  |  arn:aws:rekognition:\*:\*:project/*project\_name*/datetime  | 
|  Model  |  arn:aws:rekognition:\*:\*:project/*project\_name*/version/*name*/datetime  | 

The following example policy shows how to give an identity permission to:
+ Describe all projects\.
+ Create, start, stop, and use a specific model for inference\.
+ Create a project\. Create and describe a specific model\.
+ Deny the creation of a specific project\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AllResources",
            "Effect": "Allow",
            "Action": "rekognition:DescribeProjects",
            "Resource": "*"
        },
        {
            "Sid": "SpecificProjectVersion",
            "Effect": "Allow",
            "Action": [
                "rekognition:StopProjectVersion",
                "rekognition:StartProjectVersion",
                "rekognition:DetectCustomLabels",
                "rekognition:CreateProjectVersion"
            ],
            "Resource": "arn:aws:rekognition:*:*:project/MyProject/version/MyVersion/*"
       },
        {
            "Sid": "SpecificProject",
            "Effect": "Allow",
            "Action": [
                "rekognition:CreateProject",
                "rekognition:DescribeProjectVersions",
                "rekognition:CreateProjectVersion"
            ],
            "Resource": "arn:aws:rekognition:*:*:project/MyProject/*"
        },
        {
            "Sid": "ExplicitDenyCreateProject",
            "Effect": "Deny",
            "Action": [
                "rekognition:CreateProject"
            ],
            "Resource": ["arn:aws:rekognition:*:*:project/SampleProject/*"]
        }
    ]
}
```

## Securing DetectCustomLabels<a name="sc-detect-custom-labels"></a>

The identity used to detect custom labels might be different from the identity that manages Amazon Rekognition Custom Labels models\.

You can secure access an identity’s access to `DetectCustomLabels` by applying a policy to the identity\. The following example restricts access to `DetectCustomLabels` only and to a specific model\. The identity doesn’t have access to any of the other Amazon Rekognition operations\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "rekognition:DetectCustomLabels"


            ],
            "Resource": "arn:aws:rekognition:*:*:project/MyProject/version/MyVersion/*"
        }
    ]
}
```