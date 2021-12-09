# Using IAM with DynamoDB Backup and Restore<a name="backuprestore_IAM"></a>

You can use AWS Identity and Access Management \(IAM\) to restrict Amazon DynamoDB backup and restore actions for some resources\. The `CreateBackup` and `RestoreTableFromBackup` APIs operate on a per\-table basis\.

 For more information about using IAM policies in DynamoDB, see [Using Identity\-Based Policies \(IAM Policies\) for Amazon DynamoDB](using-identity-based-policies.md)\. 

The following are examples of IAM policies that you can use to configure specific backup and restore functionality in DynamoDB\.

## Example 1: Allow the CreateBackup and RestoreTableFromBackup Actions<a name="access-policy-example1"></a>

The following IAM policy grants permissions to allow the `CreateBackup` and `RestoreTableFromBackup` DynamoDB actions on all tables:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "dynamodb:CreateBackup",
                "dynamodb:RestoreTableFromBackup",
                "dynamodb:PutItem",
                "dynamodb:UpdateItem",
                "dynamodb:DeleteItem",
                "dynamodb:GetItem",
                "dynamodb:Query",
                "dynamodb:Scan",
                "dynamodb:BatchWriteItem"   
            ],
            "Resource": "*"
        }
    ]
}
```

**Important**  
 DynamoDB write permissions are necessary for restore functionality\. 

## Example 2: Allow CreateBackup and Deny RestoreTableFromBackup<a name="access-policy-example2"></a>

The following IAM policy grants permissions for the `CreateBackup` action and denies the `RestoreTableFromBackup` action:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": ["dynamodb:CreateBackup"],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": ["dynamodb:RestoreTableFromBackup"],
            "Resource": "*"
        }
        
    ]
}
```

## Example 3: Allow ListBackups and Deny CreateBackup and RestoreTableFromBackup<a name="access-policy-example3"></a>

The following IAM policy grants permissions for the `ListBackups` action and denies the `CreateBackup` and `RestoreTableFromBackup` actions:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": ["dynamodb:ListBackups"],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "dynamodb:CreateBackup",
                "dynamodb:RestoreTableFromBackup"
            ],
            "Resource": "*"
        }
        
    ]
}
```

## Example 4: Allow ListBackups and Deny DeleteBackup<a name="access-policy-example4"></a>

The following IAM policy grants permissions for the `ListBackups` action and denies the `DeleteBackup` action:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": ["dynamodb:ListBackups"],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": ["dynamodb:DeleteBackup"],
            "Resource": "*"
        }
        
    ]
}
```

## Example 5: Allow RestoreTableFromBackup and DescribeBackup for All Resources and Deny DeleteBackup for a Specific Backup<a name="access-policy-example5"></a>

The following IAM policy grants permissions for the `RestoreTableFromBackup` and `DescribeBackup` actions and denies the `DeleteBackup` action for a specific backup resource:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "dynamodb:DescribeBackup",
                "dynamodb:RestoreTableFromBackup",
                "dynamodb:PutItem",
                "dynamodb:UpdateItem",
                "dynamodb:DeleteItem",
                "dynamodb:GetItem",
                "dynamodb:Query",
                "dynamodb:Scan",
                "dynamodb:BatchWriteItem"
            ],
            "Resource": "*"
        },
        {
            "Effect": "Deny",
            "Action": [
                "dynamodb:DeleteBackup"
            ],
            "Resource": "arn:aws:dynamodb:us-east-1:123456789012:table/Music/backup/01489173575360-b308cd7d"
        }
    ]
}
```

**Important**  
 DynamoDB write permissions are necessary for restore functionality\. 

## Example 6: Allow CreateBackup for a Specific Table<a name="access-policy-example6"></a>

The following IAM policy grants permissions for the `CreateBackup` action on the `Movies` table only:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": ["dynamodb:CreateBackup"],
            "Resource": [
                "arn:aws:dynamodb:us-east-1:123456789012:table/Movies"
            ]
        }
    ]
}
```

## Example 7: Allow ListBackups<a name="access-policy-example7"></a>

The following IAM policy grants permissions for the `ListBackups` action:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": ["dynamodb:ListBackups"],
            "Resource": "*"
        }
    ]
}
```

**Important**  
 You cannot grant permissions for the `ListBackups` action on a specific table\. 