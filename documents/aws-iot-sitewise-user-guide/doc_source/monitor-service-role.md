# Using service roles for AWS IoT SiteWise Monitor<a name="monitor-service-role"></a>

  A service role is an IAM role that a service assumes to perform actions in your account on your behalf\. When you set up some AWS service environments, you must define a role for the service to assume\. This service role must include all the permissions that are required for the service to access the AWS resources that it needs\. Service roles vary from service to service, but many allow you to choose your permissions as long as you meet the documented requirements for that service\. Service roles provide access only within your account and cannot be used to grant access to services in other accounts\. You can create, modify, and delete a service role from within IAM\. For example, you can create a role that allows Amazon Redshift to access an Amazon S3 bucket on your behalf and then load data from that bucket into an Amazon Redshift cluster\. For more information, see [Creating a Role to Delegate Permissions to an AWS Service](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-service.html) in the *IAM User Guide*\. 

To allow federated SiteWise Monitor portal users to access your AWS IoT SiteWise and AWS Single Sign\-On resources, you must attach a service role to each portal that you create\. The service role must specify SiteWise Monitor as a trusted entity and include the [AWSIoTSiteWiseMonitorPortalAccess](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/service-role/AWSIoTSiteWiseMonitorPortalAccess) managed policy or define [equivalent permissions](#monitor-service-role-permissions)\. This policy is maintained by AWS and defines the set of permissions that SiteWise Monitor uses to access your AWS IoT SiteWise and AWS SSO resources\.

When you create a SiteWise Monitor portal, you must choose a role that allows users of that portal to access your AWS IoT SiteWise and AWS SSO resources\. The AWS IoT SiteWise console can create and configure the role for you\. You can edit the role in IAM later\. Your portal users will have issues using their SiteWise Monitor portals if you remove the required permissions from the role or delete the role\.

**Note**  
Portals created before April 29, 2020 didn't require service roles\. If you created portals before this date, you must attach service roles to continue using them\. To do so, navigate to the **Portals** page in the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/), and then choose **Migrate all portals to use IAM roles**\.

The following sections describe how to create and manage the SiteWise Monitor service role in the AWS Management Console or the AWS Command Line Interface\.

**Contents**
+ [Service role permissions for SiteWise Monitor](#monitor-service-role-permissions)
+ [Managing the SiteWise Monitor service role \(console\)](#manage-portal-role-console)
  + [Finding a portal's service role \(console\)](#find-portal-role-console)
  + [Creating a SiteWise Monitor service role \(AWS IoT SiteWise console\)](#create-portal-role-sitewise-console)
  + [Creating a SiteWise Monitor service role \(IAM console\)](#create-portal-role-iam-console)
  + [Changing a portal's service role \(console\)](#change-portal-role-console)
+ [Managing the SiteWise Monitor service role \(CLI\)](#manage-portal-role-cli)
  + [Finding a portal's service role \(CLI\)](#find-portal-role-cli)
  + [Creating the SiteWise Monitor service role \(CLI\)](#create-portal-role-cli)

## Service role permissions for SiteWise Monitor<a name="monitor-service-role-permissions"></a>

When you create a portal, AWS IoT SiteWise lets you create a role whose name starts with **AWSIoTSiteWiseMonitorServiceRole**\. This role allows federated SiteWise Monitor users to access your portal configuration, assets, asset data, and AWS SSO configuration\.

The role trusts the following service to assume the role:
+ `monitor.iotsitewise.amazonaws.com`

The role uses the following permissions policy, whose name starts with **AWSIoTSiteWiseMonitorServicePortalPolicy**, to allow SiteWise Monitor users to complete actions on resources in your account\. The [AWSIoTSiteWiseMonitorPortalAccess](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/service-role/AWSIoTSiteWiseMonitorPortalAccess) managed policy defines equivalent permissions\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "iotsitewise:CreateProject",
        "iotsitewise:DescribeProject",
        "iotsitewise:UpdateProject",
        "iotsitewise:DeleteProject",
        "iotsitewise:ListProjects",
        "iotsitewise:BatchAssociateProjectAssets",
        "iotsitewise:BatchDisassociateProjectAssets",
        "iotsitewise:ListProjectAssets",
        "iotsitewise:CreateDashboard",
        "iotsitewise:DescribeDashboard",
        "iotsitewise:UpdateDashboard",
        "iotsitewise:DeleteDashboard",
        "iotsitewise:ListDashboards",
        "iotsitewise:CreateAccessPolicy",
        "iotsitewise:DescribeAccessPolicy",
        "iotsitewise:UpdateAccessPolicy",
        "iotsitewise:DeleteAccessPolicy",
        "iotsitewise:ListAccessPolicies",
        "iotsitewise:DescribeAsset",
        "iotsitewise:ListAssets",
        "iotsitewise:ListAssociatedAssets",
        "iotsitewise:DescribeAssetProperty",
        "iotsitewise:GetAssetPropertyValue",
        "iotsitewise:GetAssetPropertyValueHistory",
        "iotsitewise:GetAssetPropertyAggregates",
        "sso-directory:DescribeUsers"
      ],
      "Resource": "*"
    }
  ]
}
```

When a portal user signs in, SiteWise Monitor creates a [session policy](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html#policies_session) based on the intersection of the service role and that user's access policies\. Access policies define AWS SSO identities' level of access to your portals and projects\. For more information about portal permissions and access policies, see [Administering your SiteWise Monitor portals](administer-portals.md) and [CreateAccessPolicy](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreateAccessPolicy.html)\.

## Managing the SiteWise Monitor service role \(console\)<a name="manage-portal-role-console"></a>

You can use the AWS IoT SiteWise console to easily manage the SiteWise Monitor service role for your portals\. When you create a portal, the console checks if you have any existing roles that can be attached to that portal\. If not, the console can create and configure a service role for you\. For more information, see [Creating a portal](monitor-getting-started.md#monitor-create-portal)\.

**Topics**
+ [Finding a portal's service role \(console\)](#find-portal-role-console)
+ [Creating a SiteWise Monitor service role \(AWS IoT SiteWise console\)](#create-portal-role-sitewise-console)
+ [Creating a SiteWise Monitor service role \(IAM console\)](#create-portal-role-iam-console)
+ [Changing a portal's service role \(console\)](#change-portal-role-console)

### Finding a portal's service role \(console\)<a name="find-portal-role-console"></a>

Use the following steps to find the service role attached to a SiteWise Monitor portal\.

**To find a portal's service role**

1. Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. In the left navigation pane, choose **Portals**\.

1. Choose the portal for which you want to find the service role\.

   The role attached to the portal appears under **Permissions**, **Service role**\.

### Creating a SiteWise Monitor service role \(AWS IoT SiteWise console\)<a name="create-portal-role-sitewise-console"></a>

When you create a SiteWise Monitor portal, you can create a service role for your portal\. For more information, see [Creating a portal](monitor-getting-started.md#monitor-create-portal)\.

You can also create a service role for an existing portal in the AWS IoT SiteWise console\. This replaces the portal's existing service role\.

**To create a service role for an existing portal**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-portals"></a>In the navigation pane, choose **Portals**\.

1. Choose the portal for which you want to create a new service role\.

1. <a name="sitewise-edit-portal-details"></a>Under **Portal details**, choose **Edit**\.

1. Under **Permissions**, choose **Create and use a new service role** from the list\.

1. Enter a name for your new role\.

1. Choose **Save**\.

### Creating a SiteWise Monitor service role \(IAM console\)<a name="create-portal-role-iam-console"></a>

You can create a service role from the service role template in the IAM console\. This role template includes the [AWSIoTSiteWiseMonitorPortalAccess](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/service-role/AWSIoTSiteWiseMonitorPortalAccess) managed policy and specifies SiteWise Monitor as a trusted entity\.

**To create a service role from the portal service role template**

1. Navigate to the [IAM console](https://console.aws.amazon.com/iam/)\.

1. In the navigation pane, choose **Roles**\.

1. Choose **Create role**\.

1. In **Choose a use case**, choose **IoT SiteWise**\.

1. In **Select your use case**, choose **IoT SiteWise Monitor \- Portal**\.

1. Choose **Next: Permissions**\.

1. Choose **Next: Tags**\.

1. Choose **Next: Review**\.

1. Enter a **Role name** for the new service role\.

1. Choose **Create role**\.

### Changing a portal's service role \(console\)<a name="change-portal-role-console"></a>

Use the following procedure to choose a different SiteWise Monitor service role for a portal\.

**To change a portal's service role**

1. <a name="sitewise-open-console"></a>Navigate to the [AWS IoT SiteWise console](https://console.aws.amazon.com/iotsitewise/)\.

1. <a name="sitewise-choose-portals"></a>In the navigation pane, choose **Portals**\.

1. Choose the portal for which you want to change the service role\.

1. <a name="sitewise-edit-portal-details"></a>Under **Portal details**, choose **Edit**\.

1. Under **Permissions**, choose **Use an existing role**\.

1. Choose an existing role to attach to this portal\.

1. Choose **Save**\.

## Managing the SiteWise Monitor service role \(CLI\)<a name="manage-portal-role-cli"></a>

You can use the AWS CLI for the following portal service role management tasks:

**Topics**
+ [Finding a portal's service role \(CLI\)](#find-portal-role-cli)
+ [Creating the SiteWise Monitor service role \(CLI\)](#create-portal-role-cli)

### Finding a portal's service role \(CLI\)<a name="find-portal-role-cli"></a>

To find the service role attached to a SiteWise Monitor portal, run the following command to list all of your portals in the current Region\.

```
aws iotsitewise list-portals
```

The operation returns a response that contains your portal summaries in the following format\.

```
{
  "portalSummaries": [
    {
      "id": "a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE",
      "name": "WindFarmPortal",
      "description": "A portal that contains wind farm projects for Example Corp.",
      "roleArn": "arn:aws:iam::123456789012:role/service-role/role-name",
      "startUrl": "https://a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE.app.iotsitewise.aws",
      "creationDate": "2020-02-04T23:01:52.90248068Z",
      "lastUpdateDate": "2020-02-04T23:01:52.90248078Z"
    }
  ]
}
```

You can also use the [DescribePortal](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_DescribePortal.html) operation to find your portal's role if you know the ID of your portal\.

### Creating the SiteWise Monitor service role \(CLI\)<a name="create-portal-role-cli"></a>

Use the following steps to create a new SiteWise Monitor service role\.

**To create a SiteWise Monitor service role**

1. Create a role with a trust policy that allows SiteWise Monitor to assume the role\. This example creates a role named **MySiteWiseMonitorPortalRole** from a trust policy stored in a JSON string\.

------
#### [ Linux, macOS, or Unix ]

   ```
   aws iam create-role --role-name MySiteWiseMonitorPortalRole --assume-role-policy-document '{
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Principal": {
           "Service": "monitor.iotsitewise.amazonaws.com"
         },
         "Action": "sts:AssumeRole"
       }
     ]
   }'
   ```

------
#### [ Windows command prompt ]

   ```
   aws iam create-role --role-name MySiteWiseMonitorPortalRole --assume-role-policy-document "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"Service\":\"monitor.iotsitewise.amazonaws.com\"},\"Action\":\"sts:AssumeRole\"}]}"
   ```

------

1. Copy the role ARN from the role metadata in the output\. When you create a portal, you use this ARN to associate the role with your portal\. For more information about creating a portal, see [CreatePortal](https://docs.aws.amazon.com/iot-sitewise/latest/APIReference/API_CreatePortal.html) in the *AWS IoT SiteWise API Reference*\.

1. Attach the `AWSIoTSiteWiseMonitorPortalAccess` policy to the role, or attach a policy that defines equivalent permissions\.

   ```
   aws iam attach-role-policy --role-name MySiteWiseMonitorPortalRole --policy-arn arn:aws:iam::aws:policy/service-role/AWSIoTSiteWiseMonitorPortalAccess
   ```

**To attach a service role to an existing portal**

1. To retrieve the portal's existing details, run the following command\. Replace *portal\-id* with the ID of the portal\.

   ```
   aws iotsitewise describe-portal --portal-id portal-id
   ```

   The operation returns a response that contains the portal's details in the following format\.

   ```
   {
       "portalId": "a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE",
       "portalArn": "arn:aws:iotsitewise:region:account-id:portal/a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE",
       "portalName": "WindFarmPortal",
       "portalDescription": "A portal that contains wind farm projects for Example Corp.",
       "portalClientId": "E-1a2b3c4d5e6f_sn6tbqHVzLWVEXAMPLE",
       "portalStartUrl": "https://a1b2c3d4-5678-90ab-cdef-aaaaaEXAMPLE.app.iotsitewise.aws",
       "portalContactEmail": "support@example.com",
       "portalStatus": {
           "state": "ACTIVE"
       },
       "portalCreationDate": "2020-04-29T23:01:52.90248068Z",
       "portalLastUpdateDate": "2020-04-29T00:28:26.103548287Z",
       "roleArn": "arn:aws:iam::123456789012:role/service-role/AWSIoTSiteWiseMonitorServiceRole_1aEXAMPLE"
   }
   ```

1. To attach a service role to a portal, run the following command\. Replace *role\-arn* with the service role ARN, and replace the remaining parameters with the portal's existing values\.

   ```
   aws iotsitewise update-portal \
     --portal-id portal-id \
     --role-arn role-arn \
     --portal-name portal-name \
     --portal-description portal-description \
     --portal-contact-email portal-contact-email
   ```