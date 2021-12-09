# Sharing Your Resources<a name="getting-started-sharing"></a>

To start sharing a resource that you own using AWS RAM, do the following:
+ [Enable Sharing with AWS Organizations](#getting-started-sharing-orgs)
+ [Create a Resource Share](#getting-started-sharing-create)

**Note**  
Some resources have special considerations and prerequisites for sharing\. For more information, see [Shareable Resources](shareable.md)\.

## Enable Sharing with AWS Organizations<a name="getting-started-sharing-orgs"></a>

If you would like to share resources with your organization or organizational units, then you must use the AWS RAM console or CLI command to enable sharing with AWS Organizations\.

When you share resources within your organization, AWS RAM does not send invitations to principals\. Principals in your organization get access to shared resources without exchanging invitations\.

**Requirements**
+ Only the master account can enable sharing with AWS Organizations\.
+ The organization must be enabled for all features\. For more information, see [ Enabling All Features in Your Organization](https://docs.aws.amazon.com/organizations/latest/userguide/orgs_manage_org_support-all-features.html) in the *AWS Organizations User Guide*\.

**Important**  
If you do not enable sharing with AWS Organizations, you cannot share resources with your organization or organizational units within your organization\. However, you can still share resources with individual AWS accounts in your organization\. In this case, the accounts are treated as external principals\. They receive an invitation to join the resource share, and they must accept the invitation to get access to the shared resources\.
You must enable sharing with AWS Organizations using the AWS RAM console or the [enable\-sharing\-with\-aws\-organization](https://docs.aws.amazon.com/cli/latest/reference/ram/enable-sharing-with-aws-organization.html) AWS CLI command\. This ensures that the `AWSResourceAccessManagerServiceRolePolicy` service\-linked role is created\. If you enable trusted access with AWS Organizations using the AWS Organizations console or the [ enable\-aws\-service\-access](https://docs.aws.amazon.com/cli/latest/reference/organizations/enable-aws-service-access.html) AWS CLI command, the `AWSResourceAccessManagerServiceRolePolicy` service\-linked role is not created, and you will not be able to share resources within your organization\.

**To enable sharing with AWS Organizations \(Console\)**

1. Open the **Settings** page of AWS RAM console at [https://console\.aws\.amazon\.com/ram/home\#Settings](https://console.aws.amazon.com/ram/home#Settings)\.

1. Choose **Enable sharing with AWS Organizations**\.

**To enable sharing with AWS Organizations \(AWS CLI\)**  
Use the [enable\-sharing\-with\-aws\-organization](https://docs.aws.amazon.com/cli/latest/reference/ram/enable-sharing-with-aws-organization.html) command\.

This command can be used in any region, and it enables sharing with AWS Organizations in all regions in which AWS RAM is supported\.

## Create a Resource Share<a name="getting-started-sharing-create"></a>

To share resources that you own, create a resource share, add the resources to share, and specify the principals with whom they are to be shared\.

**Considerations**
+ You can share a resource only if you own it\. You can't share a resource that is shared with you\.
+ If you are part of an organization in AWS Organizations and sharing within your organization is enabled, principals in your organization are automatically granted access to the shared resources\. Otherwise, principals receive an invitation to join the resource share and are granted access to the shared resources after accepting the invitation\.
+ After you add an organization to a resource share, changes to the OU or organization affect the resource share\. For example, if you add a new account to the organization, it has access to the shared resources\.
+ You can't add the following to a resource share as principals: IAM users, IAM roles, or OUs or organizations outside your organization in AWS Organizations\.

**To create a resource share \(Console\)**

1. Open the AWS RAM console at [https://console\.aws\.amazon\.com/ram](https://console.aws.amazon.com/ram/)\.

1. If you are new to AWS RAM, choose **Create a resource share** from the home page\. Otherwise, choose **Create resource share** from the **Resource shares** page\.

1. Under **Description**, for **Name**, type a descriptive name for the resource share\.

1. \(Optional\) Under **Resources**, select resources to add to the resource share as follows:

   1. For **Select resource type**, select the type of resource\. This filters the list of shareable resources to resources of the selected type\.

   1. Select the check boxes next to the resources\. The selected resources are moved under **Selected resources**\.

      If you are sharing zonal resources, using the Availability Zone ID \(AZ ID\) helps you determine the relative location of these resources across accounts\. For more information, see [AZ IDs for Your Resources](working-with-az-ids.md)\.

1. \(Optional\) Under **Principals**, do the following:

   1. By default, you can share resources with any AWS account\. To restrict resource sharing to your organization in AWS Organizations, clear **Allow external accounts**\.

   1. For each principal, specify its ID and choose **Add**:
      + To add an AWS account, type the 12\-digit account ID\. For example, `123456789012`\.
      + To add an OU, type the ID of the OU\. For example, `ou-abcd1234-mnop5678qrst9098uv76`\.
      + To add your entire organization, type the ID of the organization\. For example, `o-abcd1234efgh5678`\.

1. \(Optional\) Under **Tags**, type a tag key and tag value\. To add another tag, choose **Add tag** and type a tag key and tag value pair\. These tags are not applied to the resources included in the resource share\.

1. Choose **Create resource share**\.

   It can take a few minutes for the resource and principal associations to complete\. Allow this process to complete before attempting to use the resource share\.

1. You can add and remove resources and principals or apply custom tags to your resource share at any time\. You can delete your resource share when you no longer want to share the resources\. For more information, see [Sharing Resources Owned by You](working-with-sharing.md)\.

**To create a resource share \(AWS CLI\)**  
Use the [create\-resource\-share](https://docs.aws.amazon.com/cli/latest/reference/ram/create-resource-share.html) command\.