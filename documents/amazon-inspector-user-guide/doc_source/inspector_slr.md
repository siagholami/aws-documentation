# Using service\-linked roles for Amazon Inspector<a name="inspector_slr"></a>

Amazon Inspector uses AWS Identity and Access Management \(IAM\) service\-linked [roles](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_terms-and-concepts.html#iam-term-service-linked-role)\. A service\-linked role is a unique type of IAM role that is linked directly to Amazon Inspector\. Service\-linked roles are predefined by Amazon Inspector and include all the permissions that the service requires to call other AWS services on your behalf\. 

A service\-linked role makes setting up Amazon Inspector easier because you don’t have to manually add the necessary permissions\. Amazon Inspector defines the permissions of its service\-linked roles, and unless defined otherwise, only Amazon Inspector can assume its roles\. The defined permissions include the trust policy and the permissions policy, and that permissions policy can't be attached to any other IAM entity\.

You can delete a service\-linked role only after first deleting your assessment targets for an AWS account in all the Regions where you have Amazon Inspector running\. 

For information about other services that support service\-linked roles, see [AWS Services That Work with IAM](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html) and look for the services that have **Yes** in the **Service\-Linked Role** column\. Choose a **Yes** with a link to view the service\-linked role documentation for that service\.

## Service\-linked role permissions for Amazon Inspector<a name="slr-permissions"></a>

Amazon Inspector uses the service\-linked role named `AWSServiceRoleForAmazonInspector`\. The `AWSServiceRoleForAmazonInspector` service\-linked role trusts Amazon Inspector to assume the role\.

The permissions policy of the role allows Amazon Inspector to complete the following action on the specified resources:
+ Action: `iam:CreateServiceLinkedRole` on `arn:aws:iam::*:role/aws-service-role/inspector.amazonaws.com/AWSServiceRoleForAmazonInspector`

For the `AWSServiceRoleForAmazonInspector` role to be successfully created, the IAM identity \(user, role, or group\) that you use when you work with Amazon Inspector must have the required permissions\. To grant the required permissions, attach the `AmazonInspectorFullAccess` managed policy to the IAM user, group, or role\. For more information about the managed policy, see [Managed policies for Amazon Inspector](security_iam_service-with-iam.md#security_iam_service-with-iam-id-based-policies-managed)\. 

 For more information about service\-linked roles, see [Service\-Linked Role Permissions](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#service-linked-role-permissions) in the *IAM User Guide*\.

## Creating a service\-linked role for Amazon Inspector<a name="create-slr"></a>

You don't need to manually create the `AWSServiceRoleForAmazonInspector` service\-linked role\. 

The `AWSServiceRoleForAmazonInspector` service\-linked role is created automatically, but you might need to do some minimal setup first\. The following sections describe the details of setting up and using the `AWSServiceRoleForAmazonInspector` service\-linked role\.

### If you are getting started with Amazon Inspector for the first time<a name="CreateRoleFirstRun1"></a>
+ The `AWSServiceRoleForAmazonInspector` service\-linked role is created automatically when you go through the **Get Started with Amazon Inspector** wizard on the console or when you run the [CreateAssessmentTarget](http://docs.aws.amazon.com/inspector/latest/APIReference/API_CreateAssessmentTarget.html) API operation\.
+ The `AWSServiceRoleForAmazonInspector` service\-linked role is created for your AWS account only in the Region that you are currently signed in to\. It grants Amazon Inspector access to the resources in your AWS account only in that Region\. If you then use the same AWS account to go through the **Get Started with Amazon Inspector** console wizard or run the [CreateAssessmentTarget](http://docs.aws.amazon.com/inspector/latest/APIReference/API_CreateAssessmentTarget.html) API operation in other Regions, the same service\-linked role that is already created in your AWS account is applied in these other Regions and grants Amazon Inspector access to the resources in your AWS account in those Regions\. 

### If you already have Amazon Inspector running in your AWS account<a name="CreateRoleExisting1"></a>
+ If you already have Amazon Inspector running in your AWS account, the IAM role that grants Amazon Inspector access to your resources already exists in your AWS account\. In this case, the `AWSServiceRoleForAmazonInspector` service\-linked role is generated when you create an assessment target or an assessment template \(either through the Amazon Inspector console or the API operations\)\. This newly created service\-linked role replaces the previously created IAM role that up until now granted Amazon Inspector access to your resources\.

  You can also create the `AWSServiceRoleForAmazonInspector` service\-linked role manually by choosing the **Manage Amazon Inspector service\-linked role** link in the **Accounts Setting** section on the Amazon Inspector **Dashboard** page\. This newly created service\-linked role replaces the previously created IAM role that up until now granted Amazon Inspector access to your resources\.
**Note**  
This previously created IAM role is not deleted\. It remains intact, but it is no longer used to grant Amazon Inspector access to your resources\. You can use the IAM console to further manage or delete this IAM role\.
+ The `AWSServiceRoleForAmazonInspector` service\-linked role is created for your AWS account only in the Region that you are currently signed in to\. It grants Amazon Inspector access to the resources in your AWS account only in this Region\. Suppose you use the same AWS account to create an assessment target or an assessment template for your Amazon Inspector service running in other Regions\. In that case, the same service\-linked role that is already created in your AWS account is applied\. This role grants Amazon Inspector access to the resources in your AWS account in those Regions\. 

You can also use the IAM console to create an Inspector service\-linked role\. In the IAM CLI or the IAM API, create a service\-linked role with the `Amazon Inspector` service name\. For more information, see [Creating a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#create-service-linked-role) in the *IAM User Guide*\. 

If you delete this service\-linked role, and then need to create it again, you can use the same process to recreate the role in your account\. When you Get started with Amazon Inspector again, the service\-linked role is automatically created for you again\. 

## Editing a service\-linked role for Amazon Inspector<a name="edit-slr"></a>

Amazon Inspector does not allow you to edit the `AWSServiceRoleForAmazonInspector` service\-linked role\. After you create a service\-linked role, you can't change the name of the role because various entities might reference the role\. However, you can edit the description of the role using IAM\. For more information, see [Editing a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#edit-service-linked-role) in the *IAM User Guide*\.

## Deleting a service\-linked role for Amazon Inspector<a name="delete-slr"></a>

If you no longer need to use a feature or service that requires a service\-linked role, we recommend that you delete that role\. That way you don’t have an unused entity that is not actively monitored or maintained\. However, you must clean up the resources for your service\-linked role before you can manually delete it\.

**Note**  
If the Amazon Inspector service is using the role when you try to delete the resources, then the deletion might fail\. If that happens, wait for a few minutes and try the operation again\.

**To delete Amazon Inspector resources used by `AWSServiceRoleForAmazonInspector`**
+ Delete your assessment targets for this AWS account in all the Regions where you have Amazon Inspector running\. For more information, see [Amazon Inspector assessment targets](inspector_applications.md)\.

**To manually delete the service\-linked role using IAM**

Use the IAM console, the IAM CLI, or the IAM API to delete the `AWSServiceRoleForAmazonInspector` service\-linked role\. For more information, see [Deleting a Service\-Linked Role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html#delete-service-linked-role) in the *IAM User Guide*\.