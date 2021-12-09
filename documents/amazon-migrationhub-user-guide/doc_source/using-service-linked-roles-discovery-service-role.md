# Using Roles to Connect Migration Hub to Application Discovery Service<a name="using-service-linked-roles-discovery-service-role"></a>

Migration Hub uses the service\-linked role named **AWSServiceRoleForMigrationHub**\. The role allows Migration Hub to call the Application Discovery Service on your behalf\. This enables AWS Migration Hub to match migration tracking updates to servers and applications that you've discovered\.

## Service\-Linked Role Permissions for Migration Hub<a name="service-linked-role-permissions-discovery-service-role"></a>

The AWSServiceRoleForMigrationHub service\-linked role trusts the following services to assume the role:
+ `migrationhub.amazonaws.com`

The role permissions policy is as follows:

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "discovery:ListConfigurations",
                "discovery:DescribeConfigurations"
            ],
            "Resource": [
                "*"
            ]
        },
        {
            "Effect": "Allow",
            "Action": "ec2:CreateTags",
            "Resource": [
                "arn:aws:ec2:*:*:instance/*",
                "arn:aws:ec2:*:*:image/*"
            ],
            "Condition": {
                "ForAllValues:StringEquals": {
                    "aws:TagKeys": "aws:migrationhub:source-id"
                }
            }
        },
        {
            "Effect": "Allow",
            "Action": "dms:AddTagsToResource",
            "Resource": [
                "arn:aws:dms:*:*:endpoint:*"
            ],
            "Condition": {
                "ForAllValues:StringEquals": {
                    "aws:TagKeys": "aws:migrationhub:source-id"
                }
            }
        }
    ]
}
```

To allow an IAM entity such as a user, group, or role, to create, edit, or delete a service\-linked role, configure permissions that allow it\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a Service\-Linked Role for Migration Hub<a name="create-service-linked-role-discovery-service-role"></a>

You're not required to manually create a service\-linked role\. When you access the Migration Hub console, Migration Hub creates the service\-linked role for you\. 

**Important**  
This service\-linked role can appear in your account if you completed an action in another service that uses the features supported by this role\. To learn more, see [A New Role Appeared in My IAM Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared)\.

### Creating a Service\-Linked Role in Migration Hub \(Console\)<a name="create-service-linked-role-service-console-discovery-service-role"></a>

Use the Migration Hub console to create this service\-linked role\. Open a web browser and navigate to the Migration Hub console at [console\.aws\.amazon\.com/migrationhub](https://console.aws.amazon.com/migrationhub)\.

You can also use the IAM console to create a service\-linked role for use with the AWS CLI or the AWS API\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\.

If you delete this role and then want to create it again, use the same process\. When you access the Migration Hub console, Migration Hub creates the service\-linked role for you again\. 

## Editing a Service\-Linked Role for Migration Hub<a name="edit-service-linked-role-discovery-service-role"></a>

Migration Hub does not allow you to edit the AWSServiceRoleForMigrationHub service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a Service\-Linked Role for Migration Hub<a name="delete-service-linked-role-discovery-service-role"></a>

### Manually Delete the Service\-Linked Role<a name="slr-manual-delete-discovery-service-role"></a>

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForMigrationHub service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Migration Hub Service\-Linked Roles<a name="slr-regions-discovery-service-role"></a>

Migration Hub supports using service\-linked roles in the US West \(Oregon\) AWS Region, where the service is available\.