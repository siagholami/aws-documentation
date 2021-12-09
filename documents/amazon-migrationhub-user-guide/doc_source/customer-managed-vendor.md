# Custom Policies for Migration Tools<a name="customer-managed-vendor"></a>

This is an example role for use by a integrated partner or developer when using the AWS Migration Hub API or CLI\.

## Integrated Partner Role Policy<a name="customer-managed-vendor-role"></a>

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "mgh:CreateProgressUpdateStream"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:mgh:us-west-2:account_num:progressUpdateStream/vendor_name"
        },
        {
            "Action": [
                "mgh:AssociateCreatedArtifact",
                "mgh:DescribeMigrationTask",
                "mgh:DisassociateCreatedArtifact",
                "mgh:ImportMigrationTask",
                "mgh:ListCreatedArtifacts",
                "mgh:NotifyMigrationTaskState",
                "mgh:PutResourceAttributes",
                "mgh:NotifyApplicationState",
                "mgh:DescribeApplicationState",
                "mgh:AssociateDiscoveredResource",
                "mgh:DisassociateDiscoveredResource",
                "mgh:ListDiscoveredResources"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:mgh:us-west-2:account_num:progressUpdateStream/vendor_name/*"
        },
        {
            "Action": [
                "mgh:ListMigrationTasks",
                "mgh:GetHomeRegion"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

## Integrated Partner Policy Trust Policy<a name="customer-managed-vendor-trust"></a>

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "AWS": "arn:aws:iam::vendor_account_num:root"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```