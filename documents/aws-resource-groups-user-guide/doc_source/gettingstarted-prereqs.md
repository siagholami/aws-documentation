# Prerequisites for working with AWS Resource Groups<a name="gettingstarted-prereqs"></a>

Before you get started working with resource groups, be sure you have an active AWS account with existing resources and appropriate rights to tag resources and create groups\.

## Sign up for AWS<a name="gettingstarted-prereqs-signup"></a>

If you do not have an AWS account, complete the following steps to create one\.

**To sign up for an AWS account**

1. Open [https://portal\.aws\.amazon\.com/billing/signup](https://portal.aws.amazon.com/billing/signup)\.

1. Follow the online instructions\.

   Part of the sign\-up procedure involves receiving a phone call and entering a verification code on the phone keypad\.

## Create resources<a name="gettingstarted-prereqs-create"></a>

You can create an empty resource group, but won't be able to perform any tasks on resource group members until there are resources in the group\. For more information about the supported resource types, see [Resources you can use with AWS Resource Groups](supported-resources.md)\.

## Set up permissions<a name="gettingstarted-prereqs-permissions"></a>

To make full use of Resource Groups and Tag Editor, you might need additional permissions to tag resources or to see a resource's tag keys and values\. These permissions fall into the following categories: 
+ Permissions for individual services so that you can tag resources from those services and include them in resource groups\.
+ Permissions that are are required to use the Tag Editor console
+ Permissions that are required to use the AWS Resource Groups console and API\. 

If you are an administrator, you can provide permissions for your users by creating policies through the AWS Identity and Access Management \(IAM\) service\. You first create IAM users or groups, and then apply the policies with the permissions that they need\. For information about creating and attaching IAM policies, see [Working with policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/ManagingPolicies.html)\.

### Permissions for individual services<a name="rg-perms-individual-services"></a>

**Important**  
This section describes permissions that are required if you want to tag resources from other service consoles and APIs, and add those resources to resource groups\.

As described in [What are resource groups?](welcome.md#resource-groups-intro), each resource group represents a collection of resources of specified types that share one or more tag keys or values\. To add tags to a resource, you need the permissions required for the service to which the resource belongs\. For example, to tag Amazon EC2 instances, your must have permissions to the tagging actions in that service's API, such as those listed in the [Amazon EC2 User Guide](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/Using_Tags.html#Using_Tags_CLI)\.

To make full use of the Resource Groups feature, you need other permissions that allow you to access a service's console and interact with the resources there\. For examples of such policies for Amazon EC2, see [Example policies for working in the Amazon EC2 console](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/iam-policies-ec2-console.html) in the *Amazon EC2 User Guide for Linux Instances*\.

### Required permissions for Resource Groups and Tag Editor<a name="gettingstarted-prereqs-permissions-te"></a>

To use Resource Groups and Tag Editor, the following permissions must be added to a user's policy statement in IAM\. The next section describes how to add the required permissions\.
+ `resource-groups:*` \(This permission allows all Resource Groups actions, but to restrict actions that are available to a user, you can replace the asterisk with a [specific Resource Groups action](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsresourcegroups.html), and add more permissions as required to allow additional, specific actions\.\)
+ `cloudformation:DescribeStacks`
+ `cloudformation:ListStackResources`
+ `tag:GetResources`
+ `tag:TagResources`
+ `tag:UntagResources`
+ `tag:getTagKeys`
+ `tag:getTagValues`
+ `resource-explorer:*`

To use Resource Groups and Tag Editor in the console, you also need permission to run the `resource-groups:ListGroupResources` action\. This permission is necessary for listing available resource types in the current Region\. Using policy conditions with `resource-groups:ListGroupResources` is not currently supported\.

### Granting permissions for using AWS Resource Groups and Tag Editor<a name="gettingstarted-prereqs-permissions-howto"></a>

To add a policy for using AWS Resource Groups and Tag Editor to a user, do the following\.

1. Open the [IAM console]()\.

1. In the navigation pane, choose **Users**\.

1. Find the user to whom you want to grant AWS Resource Groups and Tag Editor permissions\. Choose the user's name to open the user properties page\.

1. Choose **Add permissions**\.

1. Choose **Attach existing policies directly**\.  
![\[IAM attach policies.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-iam-addperms.png)

1. Choose **Create policy**\.

1. On the **JSON** tab, paste the following policy statement\.

   ```
   {
     "Version": "2012-10-17",
     "Statement": [
       {
         "Effect": "Allow",
         "Action": [
           "resource-groups:*",
           "cloudformation:DescribeStacks",
           "cloudformation:ListStackResources",
           "tag:GetResources",
           "tag:TagResources",
           "tag:UntagResources",
           "tag:getTagKeys",
           "tag:getTagValues",
           "resource-explorer:*"
         ],
         "Resource": "*"
       }
     ]
   }
   ```
**Note**  
This policy statement grants permissions only for AWS Resource Groups and Tag Editor actions\. It does not allow access to AWS Systems Manager tasks in the AWS Resource Groups console\. For example, this policy does not grant permissions for you to use Systems Manager Automation commands\. To perform Systems Manager tasks on resource groups, you must have Systems Manager permissions attached to your policy \(such as `ssm:*`\)\. For more information about granting access to Systems Manager, see [Configuring access to Systems Manager](https://docs.aws.amazon.com/systems-manager/latest/userguidesystems-manager-access.html) in the *AWS Systems Manager User Guide*\.

1. Choose **Review policy**\.

1. Give the new policy a name and description\. \(for example, `AWSResourceGroupsQueryAPIAccess`\)\.  
![\[IAM review policy name and description.\]](http://docs.aws.amazon.com/ARG/latest/userguide/images/rg-iam-policyname.png)

1. Choose **Create policy**\.

1. Now that the policy is saved in IAM, you can attach it to other users\. For more information about how to add a policy to a user, see [Adding permissions by attaching policies directly to the user](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_users_change-permissions.html#by-direct-attach-policy) in the *IAM User Guide*\.

### Learn more about AWS Resource Groups authorization and access control<a name="rg-perms-iam"></a>

Resource Groups supports the following\.
+ **Action\-based policies\.** For example, you can create a policy that allows users to perform [https://docs.aws.amazon.com/ARG/latest/APIReference/API_ListGroups.html](https://docs.aws.amazon.com/ARG/latest/APIReference/API_ListGroups.html) operations, but no others\.
+ **Resource\-level permissions\.** Resource Groups supports using [ARNs](https://docs.aws.amazon.com/general/latest/gr/aws-arns-and-namespaces.html) to specify individual resources in the policy\.
+ **Authorization based on tags\.** Resource Groups supports using [resource tags](tag-editor.md) in the condition of a policy\. For example, you can create a policy that allows Resource Groups users full access to a group that you have tagged\.
+ **Temporary credentials\.** Users can assume a role with a policy that allows AWS Resource Groups operations\.

Resource Groups doesn't support resource\-based policies\.

Resource Groups doesn't use any service\-linked roles\.

For more information about how Resource Groups and Tag Editor integrate with AWS Identity and Access Management \(IAM\), see the following topics in the *AWS Identity and Access Management User Guide*\.
+ [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html#management_svcs)
+ [Actions, resources, and condition keys for AWS Resource Groups](https://docs.aws.amazon.com/IAM/latest/UserGuide/list_awsresourcegroups.html)
+ [Controlling access using policies](https://docs.aws.amazon.com/IAM/latest/UserGuide/access_controlling.html)