# Using service\-linked roles for Amazon WorkMail<a name="using-service-linked-roles"></a>

Amazon WorkMail uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Amazon WorkMail\. Service\-linked roles are predefined by Amazon WorkMail and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Amazon WorkMail easier because you don’t have to manually add the necessary permissions\. Amazon WorkMail defines the permissions of its service\-linked roles, and unless defined otherwise, only Amazon WorkMail can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting the related resources\. This protects your Amazon WorkMail resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS services that work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-linked role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for Amazon WorkMail<a name="slr-permissions"></a>

Amazon WorkMail uses the service\-linked role named **AmazonWorkMailEvents** – Amazon WorkMail uses this service\-linked role to enable access to AWS services and resources used or managed by Amazon WorkMail events, such as monitoring email events logged by CloudWatch\. For more information about enabling email event logging for Amazon WorkMail, see [Tracking messages](tracking.md)\.

The AmazonWorkMailEvents service\-linked role trusts the following services to assume the role:
+ `events.workmail.amazonaws.com`

The role permissions policy allows Amazon WorkMail to complete the following actions on the specified resources:
+ Action: `logs:CreateLogGroup` on `all AWS resources`
+ Action: `logs:CreateLogStream` on `all AWS resources`
+ Action: `logs:PutLogEvents` on `all AWS resources`

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-linked role permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for Amazon WorkMail<a name="create-slr"></a>

You don't need to manually create a service\-linked role\. When you turn on Amazon WorkMail event logging and use the default settings in the Amazon WorkMail console, Amazon WorkMail creates the service\-linked role for you\. 

If you delete this service\-linked role, and then need to create it again, you can use the same process to recreate the role in your account\. When you turn on Amazon WorkMail event logging and use the default settings, Amazon WorkMail creates the service\-linked role for you again\. 

## Editing a service\-linked role for Amazon WorkMail<a name="edit-slr"></a>

Amazon WorkMail does not allow you to edit the AmazonWorkMailEvents service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for Amazon WorkMail<a name="delete-slr"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up the resources for your service\-linked role before you can manually delete it\.

**Note**  
If the Amazon WorkMail service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete Amazon WorkMail resources used by AmazonWorkMailEvents**

1. Turn off Amazon WorkMail event logging\.

   1. Open the Amazon WorkMail console at [https://console\.aws\.amazon\.com/workmail/](https://console.aws.amazon.com/workmail/)\.

   1. Choose the organization alias for which to delete the AmazonWorkMailEvents role\.

   1. Choose **Organization settings**, **Monitoring**\.

   1. For **Log settings**, choose **Edit**\.

   1. Clear the check box for **Enable mail events**\.

   1. Choose **Save**\.

1. Delete the Amazon CloudWatch log group\.

   1. Open the CloudWatch console at [https://console\.aws\.amazon\.com/cloudwatch/](https://console.aws.amazon.com/cloudwatch/)\.

   1. Choose **Logs**\.

   1. For **Log Groups**, select the log group to delete\.

   1. For **Actions**, choose **Delete log group**\.

   1. Choose **Yes, Delete**\.

**To manually delete the service\-linked role using IAM**

Use the IAM console, the AWS CLI, or the AWS API to delete the AmazonWorkMailEvents service\-linked role\. For more information, see [Deleting a service\-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for Amazon WorkMail service\-linked roles<a name="slr-regions"></a>

Amazon WorkMail supports using service\-linked roles in all of the Regions where the service is available\. For more information, see [Amazon WorkMail Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html#wm_region)\.