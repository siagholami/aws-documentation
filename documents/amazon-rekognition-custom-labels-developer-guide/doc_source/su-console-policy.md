# Step 5: Set Up Amazon Rekognition Custom Labels Console Permissions<a name="su-console-policy"></a>

## Console Access<a name="su-console-access"></a>

The Identity and Access Management \(IAM\) user or group that uses the Amazon Rekognition Custom Labels consoles needs the following IAM policy that covers Amazon S3, Amazon SageMaker Ground Truth, and Amazon Rekognition Custom Labels\. For information about adding IAM policies, see [Creating IAM Policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies_create.html)\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:HeadBucket",
                "s3:ListAllMyBuckets"
            ],
            "Resource": "*"
        },
        {
            "Sid": "s3Policies",
            "Effect": "Allow",
            "Action": [
                "s3:ListBucket",
                "s3:CreateBucket",
                "s3:GetBucketAcl",
                "s3:GetBucketLocation",
                "s3:GetObject",
                "s3:GetObjectAcl",
                "s3:GetObjectVersion",
                "s3:GetObjectTagging",
                "s3:GetBucketVersioning",
                "s3:GetObjectVersionTagging",
                "s3:PutBucketCORS",
                "s3:PutLifecycleConfiguration",
                "s3:PutBucketPolicy",
                "s3:PutObject",
                "s3:PutObjectTagging",
                "s3:PutBucketVersioning",
                "s3:PutObjectVersionTagging"
            ],
            "Resource": [
                "arn:aws:s3:::custom-labels-console-*",
                "arn:aws:s3:::rekognition-video-console-*"
            ]
        },
        {
            "Sid": "rekognitionPolicies",
            "Effect": "Allow",
            "Action": [
                "rekognition:*"
            ],
            "Resource": "*"
        },
        {
            "Sid": "groundTruthPolicies",
            "Effect": "Allow",
            "Action": [
                "groundtruthlabeling:*"
            ],
            "Resource": "*"
        }
    ]
}
```

## External Amazon S3 Buckets<a name="su-external-buckets"></a>

Additionally, if you intend to use your own Amazon S3 bucket to upload the images or manifest file to the console, you must add the following policy block to the preceding policy\. Replace `my-bucket` with the name of the bucket\.

```
{
    "Sid": "s3ExternalBucketPolicies",
    "Effect": "Allow",
    "Action": [
        "s3:GetBucketAcl",
        "s3:GetBucketLocation",
        "s3:GetObject",
        "s3:GetObjectAcl",
        "s3:GetObjectVersion",
        "s3:GetObjectTagging",
        "s3:ListBucket",
        "s3:PutObject"
    ],
    "Resource": [
        "arn:aws:s3:::my-bucket*"
    ]
}
```