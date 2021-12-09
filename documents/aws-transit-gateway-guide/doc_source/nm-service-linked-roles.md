# Transit Gateway Network Manager service\-linked role<a name="nm-service-linked-roles"></a>

Network Manager uses service\-linked roles for the permissions that it requires to call other AWS services on your behalf\. For more information about service\-linked roles, see [Using Service\-Linked Roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html) in the *IAM User Guide*\.

## Permissions granted by the service\-linked role<a name="service-linked-role-permissions"></a>

Network Manager uses the service\-linked role named **AWSServiceRoleForNetworkManager** to call the actions on your behalf when you work with global networks\. The following IAM policy is attached to the role\.

```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "directconnect:DescribeConnections",
                "directconnect:DescribeDirectConnectGatewayAttachments",
                "directconnect:DescribeLocations",
                "directconnect:DescribeVirtualInterfaces",
                "ec2:DescribeCustomerGateways",
                "ec2:DescribeTransitGatewayAttachments",
                "ec2:DescribeTransitGatewayRouteTables",
                "ec2:DescribeTransitGateways",
                "ec2:DescribeVpnConnections",
                "ec2:GetTransitGatewayRouteTableAssociations",
                "ec2:SearchTransitGatewayRoutes"
            ],
            "Effect": "Allow",
            "Resource": "*"
        }
    ]
}
```

## Create the service\-linked role<a name="create-service-linked-role"></a>

You don't need to manually create the **AWSServiceRoleForNetworkManager** role\. Network Manager creates this role for you when you create your first global network\.

For Network Manager to create a service\-linked role on your behalf, you must have the required permissions\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Edit the service\-linked role<a name="edit-service-linked-role"></a>

You can edit the description of **AWSServiceRoleForNetworkManager** using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Delete the service\-linked role<a name="delete-service-linked-role"></a>

If you no longer need to use Network Manager, we recommend that you delete the **AWSServiceRoleForNetworkManager** role\.

You can delete this service\-linked role only after you delete your global network\.

You can use the IAM console, the IAM CLI, or the IAM API to delete service\-linked roles\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

After you delete **AWSServiceRoleForNetworkManager**, Network Manager will create the role again when you create a new global network\.