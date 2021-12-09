# Configuring Permissions<a name="sample-applications-permissions"></a>

When you launch a sample program in the AWS RoboMaker console, you can provide an IAM role to use\. The permissions vary by sample program\. This section describes what you need to launch each sample\. 

For more information about AWS Identity and Access Management roles, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html)\.

## Minimum permissions<a name="sample-applications-permissions-many"></a>

To launch a sample application, you need a role that has:
+ A trust relationship with `robomaker.amazonaws.com`\.
+ A trust relationship with `lambda.amazonaws.com`\.
+ Sample application permissions\.

Use the following permissions to launch `Hello world`, `Robot monitoring`, `Self-driving`, and the `Object-following` samples\. Other samples use these permissions and a set of additional permissions\. 

Replace `account#` with your account number\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "s3:ListBucket",
                "s3:GetObject",
                "s3:PutObject"
            ],
            "Resource": [
                "*"
            ],
            "Effect": "Allow"
        },
        {
            "Action": [
                "iam:PassRole"
            ],
            "Resource": "arn:aws:iam::account#:role/*",
            "Effect": "Allow"
        },
        {
            "Action": [
                "robomaker:*"
            ],
            "Resource": "*",
            "Effect": "Allow"
        },
        {
            "Action": [
                "ec2:AssociateRouteTable",
                "ec2:AttachInternetGateway",
                "ec2:CreateInternetGateway",
                "ec2:CreateSubnet",
                "ec2:CreateVpc",
                "ec2:CreateTags",
                "ec2:CreateRoute",
                "ec2:CreateRouteTable",
                "ec2:CreateSecurityGroup",
                "ec2:DeleteSubnet",
                "ec2:DescribeSecurityGroups",
                "ec2:DescribeSubnets",
                "ec2:DescribeVpcs"
            ],
            "Resource": "*",
            "Effect": "Allow"
        },
        {
            "Action": [
                "logs:CreateLogGroup",
                "logs:CreateLogStream",
                "logs:PutLogEvents"
            ],
            "Resource": [
                "arn:aws:logs:us-west-2:account#:log-group:/aws/lambda/*:*"
            ],
            "Effect": "Allow"
        },
        {
            "Condition": {
                "StringEquals": {
                    "iam:AWSServiceName": [
                        "robomaker.amazonaws.com"
                    ]
                }
            },
            "Action": "iam:CreateServiceLinkedRole",
            "Resource": "*",
            "Effect": "Allow"
        },
        {
            "Action": [
                "cloudformation:DescribeStacks"
            ],
            "Resource": "arn:aws:cloudformation:*:account#:stack/*",
            "Effect": "Allow"
        }
    ]
}
```

## Navigation<a name="sample-applications-permissions-nav"></a>

With the [minimum permissions](#sample-applications-permissions-many), the navigation sample program requires the permissions listed here\.

Replace `account#` with your account number\. 

```
{
    "Action": [
        "iam:PassRole"
    ],
    "Resource": "arn:aws:iam::account#:role/*",
    "Effect": "Allow"
},
{
    "Action": [
        "cloudformation:DescribeStacks"
    ],
    "Resource": "arn:aws:cloudformation:*:account#:stack/*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesis:DeleteStream",
        "kinesis:DescribeStream",
        "kinesis:CreateStream"
    ],
    "Resource": "arn:aws:kinesis:*:account#:stream/AmazonRekognitionPersonDetectionStream*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesisvideo:CreateStream"
    ],
    "Resource": "*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesisvideo:DescribeStream",
        "kinesisvideo:DeleteStream"
    ],
    "Resource": "arn:aws:kinesisvideo:*:account#:stream/RoboMakerPersonDetectionVideoStream*",
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:CreateCollection",
        "rekognition:DeleteCollection",
        "rekognition:IndexFaces"
    ],
    "Resource": "arn:aws:rekognition:*:account#:collection/roboMakerSampleAppPersonDetectionCollection*",
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:CreateStreamProcessor"
    ],
    "Resource": [
        "arn:aws:rekognition:*:account#:streamprocessor/personDetectionStreamProcessor*",
        "arn:aws:rekognition:*:account#:collection/roboMakerSampleAppPersonDetectionCollection*"
    ],
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:DeleteStreamProcessor",
        "rekognition:StartStreamProcessor",
        "rekognition:StopStreamProcessor"
    ],
    "Resource": "arn:aws:rekognition:*:account#:streamprocessor/personDetectionStreamProcessor*",
    "Effect": "Allow"
},
{
    "Action": [
        "s3:PutBucketNotification"
    ],
    "Resource": "*",
    "Effect": "Allow"
}
```

## Person detection<a name="sample-applications-permissions-detect"></a>

With the [minimum permissions](#sample-applications-permissions-many), the person detection sample requires a trust relationship with `rekognition.amazonaws.com`\. Attach the policy `arn:aws:iam::aws:policy/service-role/AmazonRekognitionServiceRole` to the role\. 

This also requires the permissions listed here\. Replace `account#` with your account number\. 

```
{
    "Action": [
        "iam:PassRole"
    ],
    "Resource": "arn:aws:iam::account#:role/*",
    "Effect": "Allow"
},
{
    "Action": [
        "cloudformation:DescribeStacks"
    ],
    "Resource": "arn:aws:cloudformation:*:account#:stack/*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesis:DeleteStream",
        "kinesis:DescribeStream",
        "kinesis:CreateStream"
    ],
    "Resource": "arn:aws:kinesis:*:account#:stream/AmazonRekognitionPersonDetectionStream*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesisvideo:CreateStream"
    ],
    "Resource": "*",
    "Effect": "Allow"
},
{
    "Action": [
        "kinesisvideo:DescribeStream",
        "kinesisvideo:DeleteStream"
    ],
    "Resource": "arn:aws:kinesisvideo:*:account#:stream/RoboMakerPersonDetectionVideoStream*",
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:CreateCollection",
        "rekognition:DeleteCollection",
        "rekognition:IndexFaces"
    ],
    "Resource": "arn:aws:rekognition:*:account#:collection/roboMakerSampleAppPersonDetectionCollection*",
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:CreateStreamProcessor"
    ],
    "Resource": [
        "arn:aws:rekognition:*:account#:streamprocessor/personDetectionStreamProcessor*",
        "arn:aws:rekognition:*:account#:collection/roboMakerSampleAppPersonDetectionCollection*"
    ],
    "Effect": "Allow"
},
{
    "Action": [
        "rekognition:DeleteStreamProcessor",
        "rekognition:StartStreamProcessor",
        "rekognition:StopStreamProcessor"
    ],
    "Resource": "arn:aws:rekognition:*:account#:streamprocessor/personDetectionStreamProcessor*",
    "Effect": "Allow"
},
{
    "Action": [
        "s3:PutBucketNotification"
    ],
    "Resource": "*",
    "Effect": "Allow"
}
```

## Voice commands<a name="sample-applications-permissions-voice"></a>

With the [minimum permissions](#sample-applications-permissions-many), the voice command sample requires the permissions listed below\.

Replace `account#` with your account number\. 

```
{
    "Action": [
        "lex:CreateBotVersion",
        "lex:GetBot",
        "lex:GetBotAlias",
        "lex:GetIntent",
        "lex:GetSlotType",
        "lex:PutBot",
        "lex:PutBotAlias",
        "lex:PutIntent",
        "lex:PutSlotType"
    ],
    "Resource": [
        "arn:aws:lex:*:account#:*"
    ],
    "Effect": "Allow"
},
{
    "Action": [
        "lex:GetImport",
        "lex:StartImport"
    ],
    "Resource": "*",
    "Effect": "Allow"
}
```