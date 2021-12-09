# Transit gateway service\-linked role<a name="tgw-service-linked-roles"></a>

Amazon VPC uses service\-linked roles for the permissions that it requires to call other AWS services on your behalf\. For more information, see [Using service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.

## Permissions granted by the service\-linked role<a name="service-linked-role-permissions"></a>

Amazon VPC uses the service\-linked role named **AWSServiceRoleForVPCTransitGateway** to call the following actions on your behalf when you work with a transit gateway:
+ `ec2:CreateNetworkInterface`
+ `ec2:DescribeNetworkInterface`
+ `ec2:ModifyNetworkInterfaceAttribute`
+ `ec2:DeleteNetworkInterface`
+ `ec2:CreateNetworkInterfacePermission`

**AWSServiceRoleForVPCTransitGateway** trusts the `transitgateway.amazonaws.com` service to assume the role\.

## Create the service\-linked role<a name="create-service-linked-role"></a>

You don't need to manually create the **AWSServiceRoleForVPCTransitGateway** role\. Amazon VPC creates this role for you when you attach a VPC in your account to a transit gateway\.

For Amazon VPC to create a service\-linked role on your behalf, you must have the required permissions\. For more information, see [Service\-linked role permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Edit the service\-linked role<a name="edit-service-linked-role"></a>

You can edit the description of **AWSServiceRoleForVPCTransitGateway** using IAM\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Delete the service\-linked role<a name="delete-service-linked-role"></a>

If you no longer need to use transit gateways, we recommend that you delete **AWSServiceRoleForVPCTransitGateway**\.

You can delete this service\-linked role only after you delete all transit gateway VPC attachments in your AWS account\. This ensures that you can't inadvertently remove permission to access your VPC attachments\.

You can use the IAM console, the IAM CLI, or the IAM API to delete service\-linked roles\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

After you delete **AWSServiceRoleForVPCTransitGateway**, Amazon VPC creates the role again if you attach a VPC in your account to a transit gateway\.