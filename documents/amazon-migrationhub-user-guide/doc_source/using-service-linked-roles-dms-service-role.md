# Using Roles to Connect Migration Hub to AWS DMS<a name="using-service-linked-roles-dms-service-role"></a>

Migration Hub uses the service\-linked role named **AWSServiceRoleForMigrationHubDMSAccess** – Allows AWS Database Migration Service \(AWS DMS\) to send migration tracking information from any supported AWS Region to Migration Hub in US West \(Oregon\)\.

## Service\-Linked Role Permissions for Migration Hub<a name="service-linked-role-permissions-dms-service-role"></a>

The AWSServiceRoleForMigrationHubDMSAccess service\-linked role trusts the following services to assume the role:
+ `dms.amazonaws.com`

The role permissions policy is as follows:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "mgh:CreateProgressUpdateStream",
            "Resource": "arn:aws:mgh:*:*:progressUpdateStream/DMS"
        },
        {
            "Effect": "Allow",
            "Action": [
                "mgh:DescribeMigrationTask",
                "mgh:AssociateDiscoveredResource",
                "mgh:ListDiscoveredResources",
                "mgh:ImportMigrationTask",
                "mgh:ListCreatedArtifacts",
                "mgh:DisassociateDiscoveredResource",
                "mgh:AssociateCreatedArtifact",
                "mgh:NotifyMigrationTaskState",
                "mgh:DisassociateCreatedArtifact",
                "mgh:PutResourceAttributes"
            ],
            "Resource": "arn:aws:mgh:*:*:progressUpdateStream/DMS/migrationTask/*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "mgh:ListMigrationTasks",
                "mgh:NotifyApplicationState",
                "mgh:DescribeApplicationState"
            ],
            "Resource": "*"
        }
    ]
}
```

To allow an IAM entity such as a user, group, or role to create, edit, or delete a service\-linked role, configure permissions to allow this\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a Service\-Linked Role for Migration Hub<a name="create-service-linked-role-dms-service-role"></a>

You're not required to manually create a service\-linked role\. When you connect to AWS DMS in the Migration Hub console, Migration Hub creates the service\-linked role for you\. 

**Important**  
 This service\-linked role can appear in your account if you completed an action in another service that uses the features supported by this role\. To learn more, see [A New Role Appeared in My IAM Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared)\.

### Creating a Service\-Linked Role in Migration Hub \(Console\)<a name="create-service-linked-role-service-console-dms-service-role"></a>

Use the Migration Hub console to create a service\-linked role\.

**To create a service\-linked role \(console\)**

1. Open a web browser and navigate to the Migration Hub console at [console\.aws\.amazon\.com/migrationhub](https://console.aws.amazon.com/migrationhub)\.

1. From the left navigation, under **Migrate** choose **Tools******

1. Scroll down to **Database migration tools**\.

1. In the **Database Migration Service** box, choose **Connect**\.

You can also use the IAM console to create a service\-linked role for use with the AWS CLI or the AWS API\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\.

If you delete this service\-linked role, and want need to create it again, use the same process\. When you connect to AWS DMS in the Migration Hub console, Migration Hub creates the service\-linked role for you again\. 

## Editing a Service\-Linked Role for Migration Hub<a name="edit-service-linked-role-dms-service-role"></a>

Migration Hub does not allow you to edit the AWSServiceRoleForMigrationHubDMSAccess service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a Service\-Linked Role for Migration Hub<a name="delete-service-linked-role-dms-service-role"></a>

### Manually Delete the Service\-Linked Role<a name="slr-manual-delete-dms-service-role"></a>

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForMigrationHubDMSAccess service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Migration Hub Service\-Linked Roles<a name="slr-regions-dms-service-role"></a>

Migration Hub supports using service\-linked roles in the US West \(Oregon\) AWS Region, where the service is available\.