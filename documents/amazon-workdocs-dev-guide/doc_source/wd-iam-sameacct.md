# Grant permission to the Amazon WorkDocs API for a developer on the AWS account<a name="wd-iam-sameacct"></a>

If you are an IAM administrator, you can grant Amazon WorkDocs API access to an IAM user from the same AWS account\. To do this, create a Amazon WorkDocs API permission policy and attach it to the IAM user\. The following is a sample Amazon WorkDocs API policy that grants permission to read\-only APIs \(List and Describe APIs\)\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "WorkDocsAPIReadOnly",
            "Effect": "Allow",
            "Action": [
                "workdocs:Get*",
		    "workdocs:Describe*"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```