# Using service\-linked roles for AWS IoT SiteWise<a name="using-service-linked-roles"></a>

AWS IoT SiteWise uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to AWS IoT SiteWise\. Service\-linked roles are predefined by AWS IoT SiteWise and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up AWS IoT SiteWise easier because you don't have to manually add the necessary permissions\. AWS IoT SiteWise defines the permissions of its service\-linked roles, and unless defined otherwise, only AWS IoT SiteWise can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy can't be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your AWS IoT SiteWise resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for AWS IoT SiteWise<a name="service-linked-role-permissions"></a>

AWS IoT SiteWise uses the service\-linked role named **AWSServiceRoleForIoTSiteWise** – AWS IoT SiteWise uses this service\-linked role to deploy gateways \(which run on AWS IoT Greengrass\) and perform logging\.

The AWSServiceRoleForIoTSiteWise service\-linked role trusts the following services to assume the role:
+ `iotsitewise.amazonaws.com`

The role uses the following permissions policy to allow AWS IoT SiteWise to complete actions on other services' resources in your account:

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": [
        "greengrass:GetAssociatedRole",
        "greengrass:GetCoreDefinition",
        "greengrass:GetCoreDefinitionVersion",
        "greengrass:GetGroup",
        "greengrass:GetGroupVersion"
      ],
      "Resource": "*",
      "Effect": "Allow"
    },
    {
      "Action": [
        "logs:CreateLogGroup",
        "logs:DescribeLogGroups"
      ],
      "Resource": "arn:aws:logs:*:*:log-group:/aws/iotsitewise*",
      "Effect": "Allow"
    },
    {
      "Action": [
        "logs:CreateLogStream",
        "logs:DescribeLogStreams",
        "logs:PutLogEvents"
      ],
      "Resource": "arn:aws:logs:*:*:log-group:/aws/iotsitewise*:log-stream:*",
      "Effect": "Allow"
    }
  ]
}
```

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-linked role permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for AWS IoT SiteWise<a name="create-service-linked-role"></a>

You don't need to manually create a service\-linked role\. When you perform any operation in the AWS IoT SiteWise console, AWS IoT SiteWise creates the service\-linked role for you\. 

If you delete this service\-linked role, and then need to create it again, you can use the same process to recreate the role in your account\. When you perform any operation in the AWS IoT SiteWise console, AWS IoT SiteWise creates the service\-linked role for you again\. 

You can also use the IAM console or API to create a service\-linked role for AWS IoT SiteWise\.
+ To do so in the IAM console, create a role with the **AWSServiceRoleForIoTSiteWise** policy and a trust relationship with `iotsitewise.amazonaws.com`\.
+ To do so using the AWS CLI or IAM API, create a role with the `arn:aws:iam::aws:policy/aws-service-role/AWSServiceRoleForIoTSiteWise` policy and a trust relationship with `iotsitewise.amazonaws.com`\.

For more information, see [Creating a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\.

If you delete this service\-linked role, you can use this same process to create the role again\.

## Editing a service\-linked role for AWS IoT SiteWise<a name="edit-service-linked-role"></a>

AWS IoT SiteWise doesn't allow you to edit the AWSServiceRoleForIoTSiteWise service\-linked role\. After you create a service\-linked role, you can't change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for AWS IoT SiteWise<a name="delete-service-linked-role"></a>

If you no longer need a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don't have an unused entity that isn't actively monitored or maintained\. However, you must clean up the resources for your service\-linked role before you can manually delete it\.

**Note**  
If the AWS IoT SiteWise service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try again\.

**To delete AWS IoT SiteWise resources used by the AWSServiceRoleForIoTSiteWise**

1. Disable logging for AWS IoT SiteWise\. For more information, see [Changing your logging level \(console\)](monitor-cloudwatch-logs.md#change-logging-level-console) or [Changing your logging level \(CLI\)](monitor-cloudwatch-logs.md#change-logging-level-cli)\.

1. Delete any active gateways\.

**To manually delete the service\-linked role using IAM**

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForIoTSiteWise service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for AWS IoT SiteWise service\-linked roles<a name="slr-regions"></a>

AWS IoT SiteWise supports using service\-linked roles in all of the Regions where the service is available\. For more information, see [AWS IoT SiteWise Endpoints and Quotas](https://docs.aws.amazon.com/general/latest/gr/iot-sitewise.html)\.