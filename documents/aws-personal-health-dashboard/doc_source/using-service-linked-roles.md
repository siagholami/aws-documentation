# Using service\-linked roles for AWS Health<a name="using-service-linked-roles"></a>

AWS Health uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to AWS Health\. Service\-linked roles are predefined by AWS Health and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up AWS Health easier because you don't have to manually add the necessary permissions\. AWS Health defines the permissions of its service\-linked roles, and unless defined otherwise, only AWS Health can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

## Service\-linked role permissions for AWS Health<a name="service-linked-role-permissions"></a>

AWS Health uses the service\-linked role named `Health_OrganizationsServiceRolePolicy`\.

The service\-linked role trusts the `health.amazonaws.com` service to assume the role\.

The role uses the following permissions policy to allow AWS Health to list accounts in AWS Organizations\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": "organizations:ListAccounts",
            "Resource": "*"
        },
        {
            "Sid": "ListAWSServiceAccessForOrganization0",
            "Effect": "Allow",
            "Action": "organizations:ListAWSServiceAccessForOrganization",
            "Resource": "*"
        }
    ]
}
```

## Creating a service\-linked role for AWS Health<a name="create-service-linked-role"></a>

You don't need to manually create a service\-linked role\. When you call the [EnableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_EnableHealthServiceAccessForOrganization.html) operation, AWS Health creates the service\-linked role in the account for you\. 

## Editing a service\-linked role for AWS Health<a name="edit-service-linked-role"></a>

AWS Health doesn't allow you to edit the service\-linked role\. After you create a service\-linked role, you can't change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for AWS Health<a name="delete-service-linked-role"></a>

If you want to delete this role, you must first call the [DisableHealthServiceAccessForOrganization](https://docs.aws.amazon.com/health/latest/APIReference/API_DisableHealthServiceAccessForOrganization.html) operation\. You can then delete the role through the IAM console, IAM API, or AWS Command Line Interface \(AWS CLI\)\. For more information, see [Using service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.