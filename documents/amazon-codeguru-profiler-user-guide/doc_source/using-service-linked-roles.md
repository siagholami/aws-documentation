# Using service\-linked roles for CodeGuru Profiler<a name="using-service-linked-roles"></a>

Amazon CodeGuru Profiler uses AWS Identity and Access Management \(IAM\)[ service\-linked roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to CodeGuru Profiler\. Service\-linked roles are predefined by CodeGuru Profiler and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up CodeGuru Profiler easier because you don’t have to manually add the necessary permissions\. CodeGuru Profiler defines the permissions of its service\-linked roles, and unless defined otherwise, only CodeGuru Profiler can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy cannot be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting their related resources\. This protects your CodeGuru Profiler resources because you can't inadvertently remove permission to access the resources\.

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes **in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for CodeGuru Profiler<a name="slr-permissions"></a>

CodeGuru Profiler uses the service\-linked role named **AWSServiceRoleForCodeGuruProfiler**\. This is a managed IAM policy with scoped permissions that CodeGuru Profiler needs to run in your account\.

The AWSServiceRoleForCodeGuruProfiler service\-linked role trusts the following services to assume the role:
+ `codeguru-profiler.amazonaws.com`

The role permissions policy allows CodeGuru Profiler to complete the following actions on the specified resources\.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "AllowSNSPublishToSendNotifications",
      "Effect": "Allow",
      "Action": [ "sns:Publish" ],
      "Resource": "*"
    }
  ]
}
```

You must configure permissions to allow an IAM entity \(such as a user, group, or role\) to create, edit, or delete a service\-linked role\. For more information, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for CodeGuru Profiler<a name="create-slr"></a>

You don't need to manually create a service\-linked role\. When you configure notifications on any profiling group for the first time, you configure an Amazon SNS topic for forwarding notifications from CodeGuru Profiler to the subscribers of the Amazon SNS topic\. When you create the first notification configuration, CodeGuru Profiler automatically creates the IAM service\-linked role, which you can see in the IAM console\. You don't need to manually create or configure this role\.

**Important**  
This service\-linked role can appear in your account if you completed an action in another service that uses the features supported by this role\. Also, if you were using the CodeGuru Profiler service before January 1, 2017, when it began supporting service\-linked roles, then CodeGuru Profiler created the AWSServiceRoleForCodeGuruProfiler role in your account\. To learn more, see [A New Role Appeared in My IAM Account](https://docs.aws.amazon.com/IAM/latest/UserGuide/troubleshoot_roles.html#troubleshoot_roles_new-role-appeared)\.

If you delete this service\-linked role, and then need to create it again, you can use the same process to recreate the role in your account\. When you create the first new notification configuration in CodeGuru Profiler, it creates the service\-linked role for you again\.

In the AWS CLI or the AWS API, create a service\-linked role with the CodeGuru Profiler service name\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\. If you delete this service\-linked role, you can use this same process to create the role again\.

## Editing a service\-linked role for CodeGuru Profiler<a name="edit-slr"></a>

CodeGuru Profiler does not allow you to edit the AWSServiceRoleForCodeGuruProfiler service\-linked role\. After you create a service\-linked role, you cannot change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for CodeGuru Profiler<a name="delete-slr"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up the resources for your service\-linked role before you can manually delete it\.

**Note**  
If the CodeGuru Profiler service is using the role when you try to delete the resources, the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete CodeGuru Profiler resources used by the AWSServiceRoleForCodeGuruProfiler service\-linked role**

1. Sign in to the AWS Management Console, and then open the CodeGuru Profiler console at [https://console\.aws\.amazon\.com/codeguru](https://console.aws.amazon.com/codeguru)\.

1. Choose the profiling group that has notification configuration set up\.

1. Choose **Actions**, and then choose **Edit profiling group**\.

1. Delete all the selected Amazon SNS topics\.

1. Repeat steps 2–4 until notification configuration is removed from all the profiling groups\.

**To manually delete the service\-linked role using IAM**

Use the IAM console, the AWS CLI, or the AWS API to delete the AWSServiceRoleForCodeGuruProfiler service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.

## Supported Regions for CodeGuru Profiler service\-linked roles<a name="slr-regions"></a>

CodeGuru Profiler supports using service\-linked roles in all of the AWS Regions where the service is available\. For more information, see [AWS Regions and Endpoints](https://docs.aws.amazon.com/general/latest/gr/rande.html)\.

CodeGuru Profiler does not support using service\-linked roles in every Region where the service is available\. You can use the AWSServiceRoleForCodeGuruProfiler role in the following Regions\.


****  

| Region name | Region identity | Support in CodeGuru Profiler | 
| --- | --- | --- | 
| US East \(N\. Virginia\) | us\-east\-1 | Yes | 
| US East \(Ohio\) | us\-east\-2 | Yes | 
| US West \(N\. California\) | us\-west\-1 | Yes | 
| US West \(Oregon\) | us\-west\-2 | Yes | 
| Asia Pacific \(Mumbai\) | ap\-south\-1 | Yes | 
| Asia Pacific \(Osaka\-Local\) | ap\-northeast\-3 | Yes | 
| Asia Pacific \(Seoul\) | ap\-northeast\-2 | Yes | 
| Asia Pacific \(Singapore\) | ap\-southeast\-1 | Yes | 
| Asia Pacific \(Sydney\) | ap\-southeast\-2 | Yes | 
| Asia Pacific \(Tokyo\) | ap\-northeast\-1 | Yes | 
| Canada \(Central\) | ca\-central\-1 | Yes | 
| Europe \(Frankfurt\) | eu\-central\-1 | Yes | 
| Europe \(Ireland\) | eu\-west\-1 | Yes | 
| Europe \(London\) | eu\-west\-2 | Yes | 
| Europe \(Paris\) | eu\-west\-3 | Yes | 
| South America \(São Paulo\) | sa\-east\-1 | Yes | 
| AWS GovCloud \(US\) | us\-gov\-west\-1 | No | 