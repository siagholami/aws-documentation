--------

--------

# IAM access roles for Amazon Kendra<a name="iam-roles"></a>

When you create an index, data source, or an FAQ, Amazon Kendra needs access to the AWS resources required to create the Amazon Kendra resource\. You must create a AWS Identity and Access Management \(IAM\) policy before you create the Amazon Kendra resource\. When you call the operation, you provide the Amazon Resource Name \(ARN\) of the role with the policy attached\. For example, if you are calling the [BatchPutDocument](API_BatchPutDocument.md) operation to add documents from an Amazon S3 bucket, you provide Amazon Kendra with a role with a policy that has access to the bucket\.

The Amazon Kendra console enables you to create a new IAM role or to choose an IAM existing role to use\. The console displays roles that have the string "kendra" or "Kendra" in the role name\. 

The following topics provide details for the required policies\. If you create IAM roles using the Amazon Kendra console these policies are created for you\.

**Topics**
+ [IAM roles for indexes](#iam-roles-index)
+ [IAM Roles for the BatchPutDocument operation](#iam-roles-batch)
+ [IAM roles for data sources](#iam-roles-ds)
+ [IAM roles for frequently asked questions](#iam-roles-ds-faq)

## IAM roles for indexes<a name="iam-roles-index"></a>

When you create an index, you must provide an IAM role with permission to write to an Amazon CloudWatch Logs\. You must also provide a trust policy that allows Amazon Kendra to assume the role\. The following are the policies that must be provided\.

A role policy to enable Amazon Kendra to access a CloudWatch log\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "cloudwatch:PutMetricData",
            "Resource": "*",
            "Condition": {
                "StringEquals": {
                    "cloudwatch:namespace": "Kendra"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": "logs:DescribeLogGroups",
            "Resource": "*"
        },
        {
            "Effect": "Allow",
            "Action": "logs:CreateLogGroup",
            "Resource": "arn:aws:logs:region:account ID:log-group:/aws/kendra/*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "logs:DescribeLogStreams",
                "logs:CreateLogStream",
                "logs:PutLogEvents"
            ],
            "Resource": "arn:aws:logs:region:account ID:log-group:/aws/kendra/*:log-stream:*"
        }
    ]
}
```

A trust policy to enable Amazon Kendra to assume a role\.

```
{
    "Version": "2012-10-17",
    "Statement": {
        "Effect": "Allow",
        "Principal": {
            "Service": "kendra.amazonaws.com"
        },
        "Action": "sts:AssumeRole"
    }
}
```

## IAM Roles for the BatchPutDocument operation<a name="iam-roles-batch"></a>

When you use the [BatchPutDocument](API_BatchPutDocument.md) operation to index documents in an Amazon S3 bucket, you must provide Amazon Kendra with an IAM role with access to the bucket\. You must also provide a trust policy that enables Amazon Kendra to assume the role\. If the documents in the bucket are encrypted, you must provide permission to use the AWS KMS customer master key \(CMK\) to decrypt the documents\.

A required role policy to enable Amazon Kendra to access an Amazon S3 bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name/*"
            ]
        }
    ]
}
```

A required trust policy to enable Amazon Kendra to assume a role\.

```
{
    "Version": "2012-10-17",
    "Statement": {
        "Sid": "AllowKendraToAssumeAttachedRole",
        "Effect": "Allow",
        "Principal": {
            "Service": "kendra.amazonaws.com"
        },
        "Action": "sts:AssumeRole"
    }
}
```

An optional role policy to enable Amazon Kendra to use an AWS KMS customer master key \(CMK\) to decrypt documents in an Amazon S3 bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        }
    ]
}
```

## IAM roles for data sources<a name="iam-roles-ds"></a>

When you use the [CreateDataSource](API_CreateDataSource.md) operation, you must give Amazon Kendra an IAM role that has permission to access the database resources\. The specific permissions required depend on the data source\.

**Topics**
+ [IAM roles for Amazon S3 data sources](#iam-roles-ds-s3)
+ [IAM roles for database data sources](#iam-roles-ds-jdbc)
+ [IAM roles for Microsoft OneDrive data sources](#iam-roles-ds-on)
+ [IAM role for Salesforce data sources](#iam-roles-ds-sf)
+ [IAM role for ServiceNow data sources](#iam-roles-ds-sn)
+ [IAM roles for Microsoft SharePoint Online data sources](#iam-roles-ds-spo)

### IAM roles for Amazon S3 data sources<a name="iam-roles-ds-s3"></a>

When you use an Amazon S3 bucket as a data source, you supply a role that has permission to access the bucket, and to use the `BatchPutDocument` and `BatchDeleteDocument` operations\. If the documents in the Amazon S3 bucket are encrypted, you must provide permission to use the AWS KMS customer master key \(CMK\) to decrypt the documents\.

A required role policy to enable Amazon Kendra to use an Amazon S3 bucket as a data source\.

```
{
    "Version": "2012-10-17",
    "Statement": [
         {
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name/*"
            ],
            "Effect": "Allow"
        },
        {
            "Action": [
                "s3:ListBucket"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name"
            ],
            "Effect": "Allow"
        },
        {
            "Effect": "Allow",
            "Action": [
                "kendra:BatchPutDocument",
                "kendra:BatchDeleteDocument"
            ],
            "Resource": [
                "arn:aws:kendra:region:account ID:index/index ID"
            ]
        }
    ]
}
```

An optional role policy to enable Amazon Kendra to use an AWS KMS customer master key \(CMK\) to decrypt documents in an Amazon S3 bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        }
    ]
}
```

### IAM roles for database data sources<a name="iam-roles-ds-jdbc"></a>

When you use a database as a data source, you provide Amazon Kendra with a role that has the permissions necessary for connecting to the database\. These include:
+ Permission to access the AWS Secrets Manager secret that contains the user name and password for the database site\. For more information about the contents of the secret, see [Using a database data source](data-source-database.md)\.
+ Permission to use the AWS KMS customer master key \(CMK\) to decrypt the user name and password secret stored by Secrets Manager\.
+ Permission to use the `BatchPutDocument` and `BatchDeleteDocument` operations to update the index\.
+ Permission to access the Amazon S3 bucket that contains the SSL certificate used to communicate with the database site\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "secretsmanager:GetSecretValue"
            ],
            "Resource": [
                "arn:aws:secretsmanager:region:account ID:secret:secret ID"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "kendra:BatchPutDocument",
                "kendra:BatchDeleteDocument"
            ],
            "Resource": [
                "arn:aws:kendra:region:account ID:index/index ID"
            "Condition": {
                "StringLike": {
                    "kms:ViaService": [
                        "kendra.amazonaws.com"
                    ]
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name/*"
            ]
        }
    ]
}
```

There are two optional policies that you might use with a database data source\.

If you have encrypted the Amazon S3 bucket that contains the SSL certificate used to communicate with the database, provide a policy to give Amazon Kendra access to the key\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        }
    ]
}
```

If you are using a VPC, provide a policy that gives Amazon Kendra access to the required resources\.

```
{
    "Version": "2012-10-17",
    "Statement": [
  {
    "Effect": "Allow",
    "Action":[
      "ec2:CreateNetworkInterface",
      "ec2:DescribeNetworkInterfaces",
      "ec2:DeleteNetworkInterface"
    ],
    "Resource": "*"        
  },
  {
    "Effect": "Allow",
    "Action": [
      "ec2:CreateNetworkInterfacePermission"
    ],
    "Resource": "*",
    "Condition": {
      "StringEquals": {
        "ec2:AuthorizedService": "kendra.amazonaws.com"
      },
      "ArnEquals": {
        "ec2:Subnet": [
          "arn:aws:ec2:region:account ID:subnet/subnet IDs"
        ]
      }
    }
  },
  {
    "Effect": "Allow",
    "Action": [
      "ec2:DescribeSubnets"
    ],
    "Resource": "*"
  }    ]
}
```

### IAM roles for Microsoft OneDrive data sources<a name="iam-roles-ds-on"></a>

When you use a Microsoft OneDrive data source, you provide Amazon Kendra with a role that has the permissions necessary for connecting to the site\. These include: 
+ Permission to get and decrypt the AWS Secrets Manager secret that contains the application ID and secret key necessary to connect to the OneDrive site\. For more information about the contents of the secret, see [Using a Microsoft OneDrive data source](data-source-onedrive.md)\.
+ Permission to use the [BatchPutDocument](API_BatchPutDocument.md) and [BatchDeleteDocument](API_BatchDeleteDocument.md) operations\.

The following IAM policy provides the necessary permissions:

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "secretsmanager:GetSecretValue"
    ],
    "Resource": [
      "arn:aws:secretsmanager:region:account ID:secret:secret ID"
    ]
  },
  {
    "Effect": "Allow",
    "Action": [
      "kms:Decrypt"
    ],
    "Resource": [
      "arn:aws:kms:region:account ID:key/key ID"
    ],
    "Condition": {
      "StringLike": {
        "kms:ViaService": [
          "secretsmanager.*.amazonaws.com"
        ]
      }
    }
  },
  {
    "Effect": "Allow",
    "Action": [
      "kendra:BatchPutDocument",
      "kendra:BatchDeleteDocument"
    ],
    "Resource": "arn:aws:kendra:region:account ID:index/index ID"
  }]
}
```

If you are storing the list of users to index in an S3 bucket, you must also provide permission to use the S3 `GetObject` operation\. The following IAM policy provides the necessary permissions:

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "secretsmanager:GetSecretValue"
    ],
    "Resource": [
      "arn:aws:secretsmanager:region:account ID:secret:secret ID"
    ]
  },
  {
    "Action": [
      "s3:GetObject"
    ],
    "Resource": [
      "arn:aws:s3:::input_bucket_name/*"
    ],
    "Effect": "Allow"
  },
  {
    "Effect": "Allow",
    "Action": [
      "kms:Decrypt"
    ],
    "Resource": [
      "arn:aws:kms:region:account ID:key/[[key IDs]]"
    ],
    "Condition": {
      "StringLike": {
        "kms:ViaService": [
          "secretsmanager.*.amazonaws.com",
          "s3.*.amazonaws.com"
        ]
      }
    }
  },
  {
    "Effect": "Allow",
    "Action": [
      "kendra:BatchPutDocument",
      "kendra:BatchDeleteDocument"
    ],
    "Resource": "arn:aws:kendra:region:account ID:index/index ID"
  }]
}
```

### IAM role for Salesforce data sources<a name="iam-roles-ds-sf"></a>

When you use a Salesforce as a data source, you provide a role with the following policies:
+ Permission to access the AWS Secrets Manager secret that contains the user name and password for the Salesforce site\. For more information about the contents of the secret, see [Using a Salesforce data source](data-source-salesforce.md)\.
+ Permission to use the AWS KMS customer master key \(CMK\) to decrypt the user name and password secret stored by Secrets Manager\.
+ Permission to use the `BatchPutDocument` and `BatchDeleteDocument` operations to update the index\.

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "secretsmanager:GetSecretValue"
    ],
    "Resource": [
      "arn:aws:secretsmanager:region:account ID:secret:secret ID"
    ]
  },
  {
    "Effect": "Allow",
    "Action": [
      "kms:Decrypt"
    ],
    "Resource": [
      "arn:aws:kms:region:account ID:key/key ID"
    ],
    "Condition": {
      "StringLike": {
        "kms:ViaService": [
          "secretsmanager.*.amazonaws.com"
        ]
      }
    }
  },
  {
    "Effect": "Allow",
    "Action": [
      "kendra:BatchPutDocument",
      "kendra:BatchDeleteDocument"
    ],
    "Resource": "arn:aws:kendra:region:account ID:index/index ID"
  }]
}
```

### IAM role for ServiceNow data sources<a name="iam-roles-ds-sn"></a>

When you use a ServiceNow as a data source, you provide a role with the following policies:
+ Permission to access the AWS Secrets Manager secret that contains the user name and password for the ServiceNow site\. For more information about the contents of the secret, see [Using a ServiceNow data source](data-source-servicenow.md)\.
+ Permission to use the AWS KMS customer master key \(CMK\) to decrypt the user name and password secret stored by Secrets Manager\.
+ Permission to use the `BatchPutDocument` and `BatchDeleteDocument` operations to update the index\.

```
{
  "Version": "2012-10-17",
  "Statement": [
  {
    "Effect": "Allow",
    "Action": [
      "secretsmanager:GetSecretValue"
    ],
    "Resource": [
      "arn:aws:secretsmanager:region:account ID:secret:secret ID"
    ]
  },
  {
    "Effect": "Allow",
    "Action": [
      "kms:Decrypt"
    ],
    "Resource": [
      "arn:aws:kms:region:account ID:key/key ID"
    ],
    "Condition": {
      "StringLike": {
        "kms:ViaService": [
          "secretsmanager.*.amazonaws.com"
        ]
      }
    }
  },
  {
    "Effect": "Allow",
    "Action": [
      "kendra:BatchPutDocument",
      "kendra:BatchDeleteDocument"
    ],
    "Resource": "arn:aws:kendra:region:account ID:index/index ID"
  }]
}
```

### IAM roles for Microsoft SharePoint Online data sources<a name="iam-roles-ds-spo"></a>

For a Microsoft SharePoint Online data source, you provide a role with the following policies\.
+ Permission to access the AWS Secrets Manager secret that contains the user name and password for the SharePoint site\. For more information about the contents of the secret, see [Using a Microsoft SharePoint data source](data-source-sharepoint.md)\.
+ Permission to use the AWS KMS customer master key \(CMK\) to decrypt the user name and password secret stored by Secrets Manager\.
+ Permission to use the `BatchPutDocument` and `BatchDeleteDocument` operations to update the index\.
+ Permission to access the Amazon S3 bucket that contains the SSL certificate used to communicate with the SharePoint site\.

You must also attach a trust policy that enables Amazon Kendra to assume the role\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "secretsmanager:GetSecretValue"
            ],
            "Resource": [
                "arn:aws:secretsmanager:region:account ID:secret:secret ID"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        },
        {
            "Effect": "Allow",
            "Action": [
                "kendra:BatchPutDocument",
                "kendra:BatchDeleteDocument"
            ],
            "Resource": [
                "arn:aws:kendra:region:account ID:index/index ID"
            ],
            "Condition": {
                "StringLike": {
                    "kms:ViaService": [
                        "kendra.amazonaws.com"
                    ]
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name/*"
            ]
        }
    ]
}
```

You must apply the following trust policy to the role\.

```
{
    "Version": "2012-10-17",
    "Statement": {
        "Effect": "Allow",
        "Principal": {
            "Service": "kendra.amazonaws.com"
        },
        "Action": "sts:AssumeRole"
    }
}
```

If you have encrypted the Amazon S3 bucket that contains the SSL certificate used to communicate with the Sharepoint site, provide a policy to give Amazon Kendra access to the key\. 

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ]
        }
    ]
}
```

## IAM roles for frequently asked questions<a name="iam-roles-ds-faq"></a>

When you use the [CreateFaq](API_CreateFaq.md) operation to load questions and answers into an index, you must provide Amazon Kendra with an IAM role with access to the Amazon S3 bucket that contains the source files\. If the source files are encrypted, you must provide permission to use the AWS KMS customer master key \(CMK\) to decrypt the files\.

A required role policy to enable Amazon Kendra to access an Amazon S3 bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket name/*"
            ]
        }
    ]
}
```

A required trust policy to enable Amazon Kendra to assume a role\.

```
{
    "Version": "2012-10-17",
    "Statement": {
        "Sid": "AllowKendraToAssumeAttachedRole",
        "Effect": "Allow",
        "Principal": {
            "Service": "kendra.amazonaws.com"
        },
        "Action": "sts:AssumeRole"
    }
}
```

An optional role policy to enable Amazon Kendra to use an AWS KMS customer master key \(CMK\) to decrypt files in an Amazon S3 bucket\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "kms:Decrypt"
            ],
            "Resource": [
                "arn:aws:kms:region:account ID:key/key ID"
            ],
            "Condition": {
                "StringLike": {
                    "kms:ViaService": [
                        "kendra.amazonaws.com"
                    ]
                }
            }
        }
    ]
}
```