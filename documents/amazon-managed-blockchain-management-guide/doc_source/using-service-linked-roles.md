# Using Service\-Linked Roles for Managed Blockchain<a name="using-service-linked-roles"></a>

Amazon Managed Blockchain uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Managed Blockchain\. Service\-linked roles are predefined by Managed Blockchain and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Managed Blockchain easier because you don’t have to manually add the necessary permissions\. Managed Blockchain defines the permissions of its service\-linked roles, and unless defined otherwise, only Managed Blockchain can assume its roles\. The defined permissions include the trust policy and the permissions policy\. The permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting its related resources\. This protects your Managed Blockchain resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-Linked Role Permissions for Managed Blockchain<a name="slr-permissions"></a>

Managed Blockchain uses the service\-linked role named **AWSServiceRoleForAmazonManagedBlockchain\. This role e**nables access to AWS Services and Resources used or managed by Amazon Managed Blockchain\.

The AWSServiceRoleForAmazonManagedBlockchain service\-linked role trusts the following services to assume the role:
+ `managedblockchain.amazonaws.com`

The role permissions policy allows Managed Blockchain to complete actions on the specified resources shown in the following example policy\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "logs:CreateLogGroup"
            ],
            "Effect": "Allow",
            "Resource": "arn:aws:logs:*:*:log-group:/aws/managedblockchain/*"
        },
        {
            "Effect": "Allow",
            "Action": [
                "logs:CreateLogStream",
                "logs:PutLogEvents",
                "logs:DescribeLogStreams"
            ],
            "Resource": [
                "arn:aws:logs:*:*:log-group:/aws/managedblockchain/*:log-stream:*"
            ]
        }
    ]
}
```

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a Service\-Linked Role for Managed Blockchain<a name="create-slr"></a>

You don't need to manually create a service\-linked role\. When you create a network, a member, or a peer node, Managed Blockchain creates the service\-linked role for you\. It doesn't matter if you use the AWS Management Console, the AWS CLI, or the AWS API\. The IAM entity performing the action must have permissions to create the service\-linked role\. After the role is created in your account, Managed Blockchain can use it for all networks and members\. 

If you delete this service\-linked role, and then need to create it again, you can use the same process to recreate the role in your account\. When you create a network, member, or node, Managed Blockchain creates the service\-linked role for you again\.

## Editing a Service\-Linked Role for Managed Blockchain<a name="edit-slr"></a>

Managed Blockchain does not allow you to edit the AWSServiceRoleForAmazonManagedBlockchain service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a Service\-Linked Role for Managed Blockchain<a name="delete-slr"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up the resources for your service\-linked role before you can manually delete it\.

**Note**  
If the Managed Blockchain service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To manually delete the service\-linked role**

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForAmazonManagedBlockchain service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Managed Blockchain Service\-Linked Roles<a name="slr-regions"></a>

Managed Blockchain supports using service\-linked roles in all of the Regions where the service is available\. For more information, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\.