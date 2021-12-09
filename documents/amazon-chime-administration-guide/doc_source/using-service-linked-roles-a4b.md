# Using roles with shared Alexa for Business devices<a name="using-service-linked-roles-a4b"></a>

Amazon Chime uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Amazon Chime\. Service\-linked roles are predefined by Amazon Chime and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Amazon Chime more efficient, because you aren't required to manually add the necessary permissions\. Amazon Chime defines the permissions of its service\-linked roles, and unless defined otherwise, only Amazon Chime can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your Amazon Chime resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html)\. Then look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for Amazon Chime<a name="service-linked-role-permissions-a4b"></a>

Amazon Chime uses the service\-linked role named **AWSServiceRoleForAmazonChime** – Allows access to AWS services and resources used or managed by Amazon Chime, such as Alexa for Business shared devices\.

The AWSServiceRoleForAmazonChime service\-linked role trusts the following services to assume the role:
+ `chime.amazonaws.com`

The role permissions policy allows Amazon Chime to complete the following action on the specified resource:
+ Action: `iam:CreateServiceLinkedRole` on `arn:aws:iam::*:role/aws-service-role/chime.amazonaws.com/AWSServiceRoleForAmazonChime`

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-linked role permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for Amazon Chime<a name="create-service-linked-role-a4b"></a>

You don't need to manually create a service\-linked role\. When you turn on Alexa for Business for a shared device in Amazon Chime in the AWS Management Console, the AWS CLI, or the AWS API, Amazon Chime creates the service\-linked role for you\. 

You can also use the IAM console to create a service\-linked role with the **Amazon Chime** use case\. In the AWS CLI or the AWS API, create a service\-linked role with the `chime.amazonaws.com` service name\. For more information, see [Creating a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\. If you delete this service\-linked role, you can use this same process to create the role again\.

## Editing a service\-linked role for Amazon Chime<a name="edit-service-linked-role-a4b"></a>

Amazon Chime does not allow you to edit the AWSServiceRoleForAmazonChime service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for Amazon Chime<a name="delete-service-linked-role-a4b"></a>

If you no longer require a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up your service\-linked role before you can manually delete it\.

### Cleaning up a service\-linked role<a name="service-linked-role-review-before-delete-a4b"></a>

Before you can use IAM to delete a service\-linked role, you must first delete any resources used by the role\.

**Note**  
If Amazon Chime is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete Amazon Chime resources used by the AWSServiceRoleForAmazonChime \(console\)**
+ Turn off Alexa for Business for all shared devices in your Amazon Chime account\.

  1. Open the Amazon Chime console at [https://chime\.aws\.amazon\.com/](https://chime.aws.amazon.com)\.

  1. Choose **Users**, **Shared devices**\.

  1. Select a device\.

  1. Choose **Actions**\.

  1. Choose **Disable Alexa for Business\.**

### Manually delete the service\-linked role<a name="slr-manual-delete-a4b"></a>

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForAmazonChime service\-linked role\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Amazon Chime service\-linked roles<a name="slr-regions-a4b"></a>

Amazon Chime supports using service\-linked roles in all of the regions where the service is available\. For more information, see [Amazon Chime endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/chime.html#chime_region)\.